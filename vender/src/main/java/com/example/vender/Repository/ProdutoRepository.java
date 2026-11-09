
package com.example.vender.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vender.Model.Produto;

@Repository
public interface ProdutoRepository
        extends JpaRepository<Produto, Long> {

    boolean existsByNome(String nome);

}

