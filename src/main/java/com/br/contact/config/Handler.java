package com.br.contact.config;

import com.br.contact.service.ContactNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestController
@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ContactNaoEncontradoException.class)
    public ResponseEntity<DefaultError> contactNaoEncontradoException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultError
                        .builder()
                        .msg("contact não encontrado")
                        .build());
    }
}
