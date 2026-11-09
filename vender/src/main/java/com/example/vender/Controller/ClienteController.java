
package com.example.vender.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vender.Model.Cliente;
import com.example.vender.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(
            @PathVariable("id") Long id) {

        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(
            @Valid @RequestBody Cliente cliente) {

        Cliente novoCliente = clienteService.cadastrar(cliente);

        return ResponseEntity.status(201).body(novoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable("id") Long id,
            @Valid @RequestBody Cliente cliente) {

        return ResponseEntity.ok(
            clienteService.atualizar(id, cliente)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable("id") Long id) {

        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
