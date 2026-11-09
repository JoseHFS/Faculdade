
package com.example.vender.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vender.Model.Pedido_Produto;
import com.example.vender.Model.Produto;

import com.example.vender.Repository.PedidoProdutoRepository;
import com.example.vender.Repository.ProdutoRepository;

import com.example.vender.Exception.RecursoNaoEncontradoException;
import com.example.vender.Exception.RegraNegocioException;

@Service
public class PedidoProdutoService {

    private final PedidoProdutoRepository pedidoProdutoRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoProdutoService(
            PedidoProdutoRepository pedidoProdutoRepository,
            ProdutoRepository produtoRepository) {

        this.pedidoProdutoRepository = pedidoProdutoRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Pedido_Produto> listar() {
        return pedidoProdutoRepository.findAll();
    }

    public Pedido_Produto buscarPorId(Long id) {
        return pedidoProdutoRepository.findById(id)
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Item do pedido não encontrado"
                    ));
    }

    @Transactional
    public void excluir(Long id) {

        Pedido_Produto item = buscarPorId(id);

        if (item.getQuantidade() <= 0) {
            throw new RegraNegocioException(
                "Quantidade inválida no item do pedido"
            );
        }

        Produto produto = item.getProduto();

        produto.setEstoque(
            produto.getEstoque() + item.getQuantidade()
        );

        produtoRepository.save(produto);

        pedidoProdutoRepository.delete(item);
    }
}
