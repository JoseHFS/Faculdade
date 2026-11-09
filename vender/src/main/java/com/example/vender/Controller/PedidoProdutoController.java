
package com.example.vender.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vender.Model.Pedido_Produto;
import com.example.vender.Service.PedidoProdutoService;

@RestController
@RequestMapping("/pedidos-produtos")
public class PedidoProdutoController {

    private final PedidoProdutoService pedidoProdutoService;

    public PedidoProdutoController(
            PedidoProdutoService pedidoProdutoService) {

        this.pedidoProdutoService = pedidoProdutoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido_Produto>> listar() {
        return ResponseEntity.ok(pedidoProdutoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido_Produto> buscarPorId(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(
            pedidoProdutoService.buscarPorId(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable("id") Long id) {

        pedidoProdutoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
