
package com.example.vender.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vender.Model.Produto;
import com.example.vender.Repository.ProdutoRepository;
import com.example.vender.Exception.RecursoNaoEncontradoException;
import com.example.vender.Exception.RegraNegocioException;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Produto não encontrado"
                    ));
    }

    public Produto cadastrar(Produto produto) {

        if (produto.getPreco() == null ||
            produto.getPreco().compareTo(BigDecimal.ZERO) < 0) {

            throw new RegraNegocioException(
                "Preço inválido"
            );
        }

        if (produto.getEstoque() < 0) {
            throw new RegraNegocioException(
                "Estoque inválido"
            );
        }

        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {

        Produto existente = buscarPorId(id);

        if (produto.getPreco() == null ||
            produto.getPreco().compareTo(BigDecimal.ZERO) < 0) {

            throw new RegraNegocioException(
                "Preço inválido"
            );
        }

        if (produto.getEstoque() < 0) {
            throw new RegraNegocioException(
                "Estoque inválido"
            );
        }

        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setEstoque(produto.getEstoque());

        return produtoRepository.save(existente);
    }

    public void excluir(Long id) {

        Produto produto = buscarPorId(id);

        if (produtoRepository.existsById(id)) {
            // A exclusão pode ser impedida pela chave estrangeira
            // caso existam itens de pedidos associados.
        }

        produtoRepository.delete(produto);
    }
}
