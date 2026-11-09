
package com.example.vender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vender.Model.Pedido_Produto;

@Repository
public interface PedidoProdutoRepository
        extends JpaRepository<Pedido_Produto, Long> {

    boolean existsByProdutoId(Long produtoId);

}
