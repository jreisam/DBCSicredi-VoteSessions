package com.jreis.teste.repository;

import com.jreis.teste.domain.Pauta;
import com.jreis.teste.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

}

