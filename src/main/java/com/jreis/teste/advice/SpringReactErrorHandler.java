package com.jreis.teste.advice;

import com.jreis.teste.exception.SpringReactError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class SpringReactErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public SpringReactError notFound(final ResourceNotFoundException ex) {
        log.debug("Error: ResourceNotFound - {}", ex.getLocalizedMessage());
        final String mse = "Recurso não encontrado";
        log.error("{} - {}", mse, ex.getLocalizedMessage());
        return SpringReactError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(mse)
                .details(ex.getLocalizedMessage()).build();
    }
}

