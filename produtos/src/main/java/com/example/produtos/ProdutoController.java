package com.example.produtos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return service.listarTodos();
    }

    @GetMapping("/{id_produto}")
    public Produto buscarProduto(@PathVariable String id_produto) {
        return service.buscarPorId(id_produto);
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return service.cadastrar(produto);
    }

    @DeleteMapping("/{id_produto}")
    public void deletarProduto(@PathVariable String id_produto) {
        service.deletar(id_produto);
    }
}
