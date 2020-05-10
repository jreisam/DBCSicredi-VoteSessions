package com.jreis.teste.controller;

import com.jreis.teste.domain.Associado;
import com.jreis.teste.domain.Pauta;
import com.jreis.teste.repository.PautaRepository;
import com.jreis.teste.service.AssociadoService;
import com.jreis.teste.service.PautaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/pauta"})
@Slf4j
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @GetMapping
    public ResponseEntity<List<Pauta>> findAll() {
        List<Pauta> response = pautaService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Pauta pauta) {
        pautaService.save(pauta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Pauta pauta) {
        pautaService.update(id, pauta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        pautaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}