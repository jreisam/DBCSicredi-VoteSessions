package com.jreis.teste.service;

import com.jreis.teste.repository.VotoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@RunWith(PowerMockRunner.class)
public class VotoServiceTest {

    @InjectMocks
    private VotoService service;

    @Mock
    private VotoRepository repository;

    @Test(expected = ResourceNotFoundException.class)
    public void deveLancarErrorSeVotoNaoEncontrada() {
        service.findById(1L);
    }
}
