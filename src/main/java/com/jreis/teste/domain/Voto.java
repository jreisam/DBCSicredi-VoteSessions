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
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Voto extends BaseEntity {

    private boolean Voto;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Associado.class)
    private Associado associado;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Sessao.class)
    private Sessao sessao;

}
