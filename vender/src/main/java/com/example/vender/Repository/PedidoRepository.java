
package com.example.vender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vender.Model.Pedido;

@Repository
public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

}




