package com.example.vender.Exception;

public class RegraNegocioException
        extends RuntimeException {

    public RegraNegocioException(String mensagem) {
        super(mensagem);
    }
}