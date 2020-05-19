package com.jreis.teste.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jreis.teste.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Sessao extends BaseEntity {

    private int voteMinutes;
    private boolean sessionRunning;

    @Column(nullable = false)

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm")
    private LocalDateTime voteStart = LocalDateTime.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm")
    @Column(nullable = false)
    private LocalDateTime voteEnd;


    @OneToOne(optional = false)
    private Pauta pauta;
}