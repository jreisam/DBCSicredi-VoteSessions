package com.jreis.teste.domain;

public class MessageSessionInfo {

    private String pauta;
    private int numVotos;

    public MessageSessionInfo() {
    }

    public MessageSessionInfo(String pauta, int numVotos) {
        this.pauta = pauta;
        this.numVotos = numVotos;
    }

    public String getMsg() {
        return "Pauta: " + pauta + ". Número de Votos: " + numVotos + ".";
    }

}