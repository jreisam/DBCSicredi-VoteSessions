package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Sessao extends BaseEntity {

    private int voteMinutes;
    private boolean sessionRunning;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sessionStarted;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Pauta pauta;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Voto> votos;
}