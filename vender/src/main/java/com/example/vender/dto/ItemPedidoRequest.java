package com.example.vender.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemPedidoRequest(

    @NotNull(message = "Informe o produto")
    @Positive(message = "ID do produto inválido")
    Long produtoId,

    @NotNull(message = "Informe a quantidade")
    @Positive(message = "A quantidade deve ser maior que zero")
    Integer quantidade

) {}