package com.projetofeh.projetofeh.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Usadas juntas para tratar exceções e retornar repostas personalizadas.
@RestControllerAdvice
public class ProductExceptionHandler {
 @ExceptionHandler(EntityNotFoundException.class)
 public ResponseEntity<ExceptionDTO> threat404(){
  ExceptionDTO response = new ExceptionDTO("Data not found", 404);
  return ResponseEntity.badRequest().body(response);
 }
}