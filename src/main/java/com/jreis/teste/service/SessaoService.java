package com.jreis.teste.service;

import com.jreis.teste.domain.Sessao;
import com.jreis.teste.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;

    public List<Sessao> findAll() {
        return sessaoRepository.findAll();
    }

    public Sessao findById(final Long id) {
        return sessaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " não existe!"));
    }

    public void save(final Sessao sessao) {
        sessaoRepository.save(sessao);
    }

    public void update(Long id, Sessao sessao) {
        Sessao sessaoOld = findById(id);
        sessao.setId(sessaoOld.getId());

        sessaoRepository.save(sessao);
    }

    public void delete(Long id) {
        if (!sessaoRepository.findById(id).isPresent())
            sessaoRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Sessão não encontrada para o id: " + id);
    }
}