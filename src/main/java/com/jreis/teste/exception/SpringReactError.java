package com.jreis.teste.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpringReactError {

    private String message;

    private HttpStatus status;

    private String details;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
