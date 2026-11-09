
package com.example.vender.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vender.Model.Cliente;
import com.example.vender.Model.Pedido;
import com.example.vender.Model.Produto;
import com.example.vender.Model.Pedido_Produto;

import com.example.vender.Repository.ClienteRepository;
import com.example.vender.Repository.PedidoRepository;
import com.example.vender.Repository.PedidoProdutoRepository;
import com.example.vender.Repository.ProdutoRepository;

import com.example.vender.dto.PedidoRequest;
import com.example.vender.dto.ItemPedidoRequest;

import com.example.vender.Exception.RecursoNaoEncontradoException;
import com.example.vender.Exception.RegraNegocioException;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final PedidoProdutoRepository pedidoProdutoRepository;

    public PedidoService(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository,
            PedidoProdutoRepository pedidoProdutoRepository) {

        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoProdutoRepository = pedidoProdutoRepository;
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Pedido não encontrado"
                    ));
    }

    @Transactional
    public Pedido cadastrar(PedidoRequest request) {

        if (request.produtos() == null ||
            request.produtos().isEmpty()) {

            throw new RegraNegocioException(
                "O pedido deve possuir pelo menos um produto"
            );
        }

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() ->
                    new RecursoNaoEncontradoException(
                        "Cliente não encontrado"
                    ));

        Pedido pedido = new Pedido();
        pedido.setData_pedido(LocalDateTime.now());
        pedido.setCliente(cliente);

        for (ItemPedidoRequest item : request.produtos()) {

            if (item.quantidade() == null ||
                item.quantidade() <= 0) {

                throw new RegraNegocioException(
                    "A quantidade deve ser maior que zero"
                );
            }

            Produto produto = produtoRepository.findById(item.produtoId())
                    .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                            "Produto não encontrado"
                        ));

            if (produto.getEstoque() < item.quantidade()) {

                throw new RegraNegocioException(
                    "Estoque insuficiente para: " +
                    produto.getNome()
                );
            }

            Pedido_Produto pedidoProduto = new Pedido_Produto();

            pedidoProduto.setPedido(pedido);
            pedidoProduto.setProduto(produto);
            pedidoProduto.setQuantidade(item.quantidade());
            pedidoProduto.setPreco_unitario(produto.getPreco());

            pedido.getProdutos().add(pedidoProduto);

            produto.setEstoque(
                produto.getEstoque() - item.quantidade()
            );

            produtoRepository.save(produto);
        }

        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void excluir(Long id) {

        Pedido pedido = buscarPorId(id);

        for (Pedido_Produto item : pedido.getProdutos()) {

            Produto produto = item.getProduto();

            produto.setEstoque(
                produto.getEstoque() + item.getQuantidade()
            );

            produtoRepository.save(produto);
        }

        pedidoRepository.delete(pedido);
    }
}
