package com.jreis.teste.controller;

import com.jreis.teste.domain.Pauta;
import com.jreis.teste.domain.Voto;
import com.jreis.teste.service.PautaService;
import com.jreis.teste.service.VotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/voto"})
@Slf4j
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping
    public ResponseEntity<List<Voto>> findAll() {
        List<Voto> response = votoService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Voto voto) {
        votoService.save(voto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Voto voto) {
        votoService.update(id, voto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        votoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}