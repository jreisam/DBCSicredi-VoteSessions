package com.jreis.teste.service;

import com.jreis.teste.domain.Associado;
import com.jreis.teste.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;

    public List<Associado> findAll() {
        return associadoRepository.findAll();
    }

    public Associado findById(final Long id) {
        return associadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " não existe!"));
    }

    public void save(final Associado associado) {
        associadoRepository.save(associado);
    }

    public void update(Long id, Associado associado) {
        Associado associadoOld = findById(id);
        associado.setId(associadoOld.getId());

        associadoRepository.save(associado);
    }

    public void delete(Long id) {
//        if (!associadoRepository.findById(id).isPresent())
            associadoRepository.deleteById(id);
    }
}