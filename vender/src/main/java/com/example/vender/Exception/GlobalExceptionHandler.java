
package com.example.vender.Exception;

import java.util.Map;
import java.util.HashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Registro não encontrado: 404
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarNaoEncontrado(
            RecursoNaoEncontradoException ex) {

        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // Regra de negócio violada: 409
    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Map<String, String>> tratarRegraNegocio(
            RegraNegocioException ex) {

        Map<String, String> erro = new HashMap<>();
        erro.put("erro", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    // Erros de validação: 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(erro ->
            erros.put(erro.getField(), erro.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(erros);
    }

    // JSON inválido: 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> tratarJsonInvalido(
            HttpMessageNotReadableException ex) {

        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "JSON inválido ou dados em formato incorreto");

        return ResponseEntity.badRequest().body(erro);
    }

    // Violação de integridade do banco: 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> tratarIntegridade(
            DataIntegrityViolationException ex) {

        Map<String, String> erro = new HashMap<>();
        erro.put("erro",
            "Não foi possível realizar a operação devido a uma restrição do banco de dados");

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    // Erros inesperados: 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> tratarErroInterno(
            Exception ex) {

        Map<String, String> erro = new HashMap<>();
        erro.put("erro", "Ocorreu um erro interno no servidor");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(erro);
    }
}
