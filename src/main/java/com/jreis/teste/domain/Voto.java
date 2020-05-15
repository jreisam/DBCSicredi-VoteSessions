package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Voto extends BaseEntity {

    @Column(nullable = false)
    private boolean voto;

    @Column(nullable = false)
    private int status = 0;

    private String errorMsg;

    @ManyToOne(optional = false, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinColumn(nullable = false)
    private Associado associado;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Sessao sessao;

}
