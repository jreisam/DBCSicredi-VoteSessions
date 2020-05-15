package com.jreis.teste.repository;

import com.jreis.teste.domain.Associado;
import com.jreis.teste.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

    List<Pauta> findByNome(String nomeDaPauta);

}

