package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pauta extends BaseEntity {

    private String nome;
    private int totalVotos;

    @JsonIgnore
    @OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL)
    private Set<Sessao> sessoes;
}