package com.example.mercado;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class Controller {

    private final ProdutoService service;
    private final EstoqueService estoqueService;
    

    public Controller(ProdutoService service,EstoqueService estoqueService) {
        this.service = service;
        this.estoqueService=estoqueService;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return service.listarTodos();
    }

    @GetMapping("/{id_produto}")
    public Produto buscarProduto(@PathVariable Long id_produto) {
        return service.buscarPorId(id_produto);
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return service.cadastrar(produto);
    }

    @DeleteMapping("/{id_produto}")
    public void deletarProduto(@PathVariable Long id_produto) {
        service.deletar(id_produto);
    }

    @PutMapping("/{id_produto}")
    public Produto atualizarEstoque(
            @PathVariable Long id_produto,
            @RequestParam int quantidade) {

        return estoqueService.atualizarEstoque(id_produto, quantidade);
    }
}
