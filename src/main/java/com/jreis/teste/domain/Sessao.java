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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Sessao extends BaseEntity {

    private int voteMinutes;
    private boolean sessionRunning;

    @Column(nullable = false)
    private LocalDateTime voteStart = getTimeNow();

    @Column(nullable = false)
    private LocalDateTime voteEnd;


    @OneToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Pauta pauta;

    private static LocalDateTime getTimeNow() {
        final java.time.LocalDateTime localDateTime = LocalDateTime.now();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        final String formatted = localDateTime.format(dateTimeFormatter);
        return LocalDateTime.parse(formatted, dateTimeFormatter);
    }
}