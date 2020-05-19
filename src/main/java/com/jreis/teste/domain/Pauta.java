package com.jreis.teste.domain;

import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pauta extends BaseEntity {

    @Column(nullable = false)
    private String nome;

    private int totalVotos;

}