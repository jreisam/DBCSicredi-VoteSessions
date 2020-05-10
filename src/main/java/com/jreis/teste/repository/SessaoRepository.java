package com.jreis.teste.repository;

import com.jreis.teste.domain.Sessao;
import com.jreis.teste.domain.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}

