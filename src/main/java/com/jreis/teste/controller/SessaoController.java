package com.jreis.teste.controller;

import com.jreis.teste.domain.Message;
import com.jreis.teste.domain.MessageSessionInfo;
import com.jreis.teste.domain.Sessao;
import com.jreis.teste.domain.Voto;
import com.jreis.teste.service.SessaoService;
import com.jreis.teste.service.VotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/sessao"})
@Slf4j
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    public ResponseEntity<List<Sessao>> findAll() {
        List<Sessao> response = sessaoService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Sessao sessao) {

        sessaoService.save(sessao);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable("Id") Long id, @Valid @RequestBody Sessao sessao) {
        sessaoService.update(id, sessao);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        sessaoService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @MessageMapping("/msg")
    @SendTo("/msg")
    public Message sendMsg(MessageSessionInfo messageSessionInfo) throws Exception {
        Thread.sleep(1000); // simulated delay
        System.out.println(messageSessionInfo.getMsg());
        return new Message(messageSessionInfo.getMsg());
    }

}