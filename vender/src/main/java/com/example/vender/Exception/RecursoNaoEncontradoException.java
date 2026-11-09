package com.example.vender.Exception;

public class RecursoNaoEncontradoException
        extends RuntimeException {

    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}