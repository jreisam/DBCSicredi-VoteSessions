package com.jreis.teste.service;

import com.jreis.teste.repository.AssociadoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@RunWith(PowerMockRunner.class)
public class AssociadoServiceTest {

    @InjectMocks
    private AssociadoService service;

    @Mock
    private AssociadoRepository repository;

    @Test(expected = ResourceNotFoundException.class)
    public void deveLancarErrorSeAssociadoNaoEncontrado() {
        service.findById(1L);
    }
}
