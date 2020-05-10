package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Sessao extends BaseEntity {

    private Time voteTime;
    private Date sessionDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Pauta pauta;

    @JsonIgnore
    @OneToMany(mappedBy = "sessao", cascade = CascadeType.ALL)
    private Set<Voto> votos;
}