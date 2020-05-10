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
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Associado extends BaseEntity {

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "associado", cascade = CascadeType.ALL)
    private Set<Voto> votos;

    public Associado(){};

    public Associado(String joão_reis) {
        super();
    }
}