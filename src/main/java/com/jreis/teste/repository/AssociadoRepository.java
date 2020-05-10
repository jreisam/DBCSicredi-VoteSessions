package com.jreis.teste.repository;

import com.jreis.teste.domain.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    List<Associado> findByNome(String nomeDoAssociado);

}

