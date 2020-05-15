package com.jreis.teste.service;

import com.jreis.teste.domain.Associado;
import com.jreis.teste.domain.Pauta;
import com.jreis.teste.repository.AssociadoRepository;
import com.jreis.teste.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;

    public List<Pauta> findAll() {
        return pautaRepository.findAll();
    }

    public Pauta findById(final Long id) {
        return pautaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " não existe!"));
    }

    public void save(final Pauta pauta) {
        pautaRepository.save(pauta);
    }

    public void update(Long id, Pauta pauta) {
        Pauta pautaOld = findById(id);
        pauta.setId(pautaOld.getId());

        pautaRepository.save(pauta);
    }

    public void delete(Long id) {
        if (!pautaRepository.findById(id).isPresent())
            pautaRepository.deleteById(id);
    }
}