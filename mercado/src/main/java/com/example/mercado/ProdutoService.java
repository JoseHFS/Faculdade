package com.example.mercado;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final MercadoRepository repository;

    public ProdutoService(MercadoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.listarTodos();
    }

    public Produto buscarPorId(Long id_produto) {
        return repository.buscarPorId(id_produto);
    }

    public Produto cadastrar(Produto produto) {
        if(produto.getPreco_produto() <= 0){
            throw new IllegalArgumentException("Preço não pode ser nulo, igual ou menor que zero");

        }

        if(produto.getNome_produto() ==null){
            throw new IllegalArgumentException("Preço deve ter nome");

        }
        if((produto.getQuantidade_medida()==0 && produto.getMedida()==null)||(produto.getQuantidade_medida()>0 && produto.getMedida()==null)){
            throw new IllegalArgumentException("Se o produto tiver medida terá que ter a quantidade da mesma e vice-versa");

        }
        if(produto.getQuantidade_medida()<0){
            throw new IllegalArgumentException("A quantidade não pode ser negativa");
        }
        return repository.salvar(produto);
    }

    


    public void deletar(Long id_produto) {
        
        repository.deletar(id_produto);
    }
}