package com.jreis.teste.service;

import com.jreis.teste.repository.PautaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@RunWith(PowerMockRunner.class)
public class PautaServiceTest {

    @InjectMocks
    private PautaService service;

    @Mock
    private PautaRepository repository;

    @Test(expected = ResourceNotFoundException.class)
    public void deveLancarErrorSePautaNaoEncontrada() {
        service.findById(1L);
    }

}
