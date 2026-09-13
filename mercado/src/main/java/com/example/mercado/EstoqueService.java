package com.example.mercado;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    private final MercadoRepository repository;

    public EstoqueService(MercadoRepository repository){
        this.repository=repository;
    }

    public Produto atualizarEstoque(Long id_produto, int quantidade) {

        Produto produto = repository.buscarPorId(id_produto);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        int novoEstoque = produto.getQuantidade_estoque() + quantidade;

        if (novoEstoque < 0) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        produto.setQuantidade_estoque(novoEstoque);

        return produto;
    }

}
