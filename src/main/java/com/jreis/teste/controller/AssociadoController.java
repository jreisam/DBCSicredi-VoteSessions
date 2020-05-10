package com.jreis.teste.controller;

import com.jreis.teste.domain.Associado;
import com.jreis.teste.service.AssociadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/associado"})
@Slf4j
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @GetMapping
    public ResponseEntity<List<Associado>> findAll() {
//        log.info("findAll BcMsg");
        List<Associado> response = associadoService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Associado associado) {
        associadoService.save(associado);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Associado associado) {
//        associadoService.update(id, associado);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        associadoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}