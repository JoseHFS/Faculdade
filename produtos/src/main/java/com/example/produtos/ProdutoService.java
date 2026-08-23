package com.example.produtos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.listarTodos();
    }

    public Produto buscarPorId(String id_produto) {
        return repository.buscarPorId(id_produto);
    }

    public Produto cadastrar(Produto produto) {
        return repository.salvar(produto);
    }

    public void deletar(String id_produto) {
        repository.deletar(id_produto);
    }
}
