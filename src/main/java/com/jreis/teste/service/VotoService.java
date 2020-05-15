package com.jreis.teste.service;

import com.jreis.teste.domain.Pauta;
import com.jreis.teste.domain.Voto;
import com.jreis.teste.repository.PautaRepository;
import com.jreis.teste.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public List<Voto> findAll() {
        return votoRepository.findAll();
    }

    public Voto findById(final Long id) {
        return votoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " não existe!"));
    }

    public void save(final Voto voto) {
        votoRepository.save(voto);
    }

    public void update(Long id, Voto voto) {
        Voto votoOld = findById(id);
        voto.setId(votoOld.getId());

        votoRepository.save(voto);
    }

    public void delete(Long id) {
        if (!votoRepository.findById(id).isPresent())
            votoRepository.deleteById(id);
    }
}