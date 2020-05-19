package com.jreis.teste.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MessageSessionInfo {

    private String pauta;
    private int numVotos;

    public String getMsg() {
        return "Pauta: " + pauta + ". Número de Votos: " + numVotos + ".";
    }

}