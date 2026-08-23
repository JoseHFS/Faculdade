package com.example.produtos;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> listarTodos() {
        return produtos;
    }

    public Produto salvar(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public Produto buscarPorId(String id_produto) {
        return produtos.stream()
                .filter(produto -> produto.getId_produto().equals(id_produto))
                .findFirst()
                .orElse(null);
    }

    public void deletar(String id_produto) {
        produtos.removeIf(produto -> produto.getId_produto().equals(id_produto));
    }
}
