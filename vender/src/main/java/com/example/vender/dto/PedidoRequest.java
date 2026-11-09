package com.example.vender.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequest(

    @NotNull(message = "Informe o cliente")
    @Positive(message = "ID do cliente inválido")
    Long clienteId,

    @NotEmpty(message = "O pedido deve possuir pelo menos um produto")
    List<@Valid ItemPedidoRequest> produtos

) {}