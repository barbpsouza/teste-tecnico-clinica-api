package com.example.teste.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    // esse metodo captura qualquer runtimeException que lançou no service
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeError(RuntimeException ex) {
        // retorna o erro 400 (bad request)
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}