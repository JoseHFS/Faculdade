
package com.example.vender.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vender.Model.Cliente;
import com.example.vender.Repository.ClienteRepository;

import com.example.vender.Exception.RecursoNaoEncontradoException;
import com.example.vender.Exception.RegraNegocioException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Cliente não encontrado"
                    ));
    }

    public Cliente cadastrar(Cliente cliente) {

        if (cliente.getNome() == null ||
            cliente.getNome().isBlank()) {

            throw new RegraNegocioException(
                "O nome do cliente é obrigatório"
            );
        }

        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente) {

        Cliente existente = buscarPorId(id);

        if (cliente.getNome() == null ||
            cliente.getNome().isBlank()) {

            throw new RegraNegocioException(
                "O nome do cliente é obrigatório"
            );
        }

        existente.setNome(cliente.getNome());
        existente.setTelefone(cliente.getTelefone());

        return clienteRepository.save(existente);
    }

    public void excluir(Long id) {

        Cliente cliente = buscarPorId(id);

        clienteRepository.delete(cliente);
    }
}
