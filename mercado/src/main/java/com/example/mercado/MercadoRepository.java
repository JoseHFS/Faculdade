package com.example.mercado;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository 
public class MercadoRepository {
    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto salvar(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public Produto buscarPorId(Long id_produto) {
        return produtos.stream()
                .filter(produto -> produto.getId_produto().equals(id_produto))
                .findFirst()
                .orElse(null);
    }

    public void deletar(Long id_produto) {
        produtos.removeIf(produto -> produto.getId_produto().equals(id_produto));
    }

}
