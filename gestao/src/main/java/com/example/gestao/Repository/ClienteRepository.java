package com.example.gestao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestao.Model.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
