package com.jreis.teste.controller;

import com.google.gson.Gson;
import com.jreis.teste.domain.Associado;
import com.jreis.teste.service.AssociadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/associado"})
@Slf4j
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public ResponseEntity<List<Associado>> findAll() {
        List<Associado> response = associadoService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Associado associado) {
        String response = getAbleToVote(associado.getCpf());
        if(response.equals("ABLE_TO_VOTE"))
            associado.setAbleToVote(true);
        else
            associado.setAbleToVote(false);

            associadoService.save(associado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Associado associado) {
        associadoService.update(id, associado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        associadoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private String getAbleToVote(String userCPF) {

        final String uri = "https://user-info.herokuapp.com/users/" + userCPF;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        Map jsonJavaRootObject = new Gson().fromJson(result, Map.class);

        System.out.println(jsonJavaRootObject.get("status").toString());
        return jsonJavaRootObject.get("status").toString();
    }



}