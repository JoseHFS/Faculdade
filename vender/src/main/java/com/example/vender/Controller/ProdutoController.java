
package com.example.vender.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vender.Model.Produto;
import com.example.vender.Service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(produtoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(
            @Valid @RequestBody Produto produto) {

        Produto novoProduto = produtoService.cadastrar(produto);

        return ResponseEntity.status(201).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable("id") Long id,
            @Valid @RequestBody Produto produto) {

        return ResponseEntity.ok(
            produtoService.atualizar(id, produto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable("id") Long id) {

        produtoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
