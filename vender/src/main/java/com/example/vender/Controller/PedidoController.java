
package com.example.vender.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vender.Model.Pedido;
import com.example.vender.Service.PedidoService;
import com.example.vender.dto.PedidoRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(
            @Valid @RequestBody PedidoRequest pedido) {

        Pedido novoPedido = pedidoService.cadastrar(pedido);

        return ResponseEntity.status(201).body(novoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable("id") Long id) {

        pedidoService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
