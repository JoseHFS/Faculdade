package com.example.gestao.Service;



import org.springframework.stereotype.Service;
import com.example.gestao.Model.Cliente;
import com.example.gestao.Repository.ClienteRepository;



@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository=repository;
    }

    public Cliente buscarCliente(long id){
        Cliente cliente = repository.findById(id).orElseThrow();
        return cliente;
    }

    public void excluir(long id){
        Cliente cliente = buscarCliente(id);
        if(cliente!= null){
            repository.deleteById(id);
        }
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return repository.save(cliente);
    }

    

    //buscar todos, buscar por id, buscar por parte do nome, ignorar maiusculas e minusculas, deletar, mudar campo especifico

}
