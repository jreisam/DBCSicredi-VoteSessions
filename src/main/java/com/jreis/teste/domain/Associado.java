package com.jreis.teste.domain;

import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Associado extends BaseEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    private boolean ableToVote;


}