package com.example.gestao.Controller;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestao.Model.Cliente;
import com.example.gestao.Repository.ClienteRepository;
import com.example.gestao.Service.ClienteService;

import java.util.List;

@RestController 
@RequestMapping ("/clientes")
public class ClienteController {
    private final ClienteRepository repository;
    private final ClienteService service;

    

    public ClienteController(ClienteRepository repository,ClienteService service) {
        this.repository = repository;
        this.service=service;
    }

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable  Long id){
        return service.buscarCliente(id);
    }

    @DeleteMapping("/clientes/{id}")
        public String excluirCliente(@PathVariable Long id){
            service.excluir(id);
            return "CLiente excluido";
        }
        
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        return service.cadastrarCliente(cliente);
    }
    

}
