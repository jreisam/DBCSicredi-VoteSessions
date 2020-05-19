package com.jreis.teste.service;

import com.jreis.teste.repository.SessaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@RunWith(PowerMockRunner.class)
public class SessaoServiceTest {

    @InjectMocks
    private SessaoService service;

    @Mock
    private SessaoRepository repository;

    @Test(expected = ResourceNotFoundException.class)
    public void deveLancarErrorSeSessaoNaoEncontrada() {
        service.findById(1L);
    }
}
