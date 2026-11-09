
package com.example.vender.Model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CheckConstraint;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id_produto;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nome_produto;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "estoque", nullable = false)
    private int estoque;

    @OneToMany(mappedBy = "produto")
    private List<Pedido_Produto> pedidos = new ArrayList<>();

    public Long getId() {
        return id_produto;
    }

    public void setId(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome_produto;
    }

    public void setNome(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public List<Pedido_Produto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido_Produto> pedidos) {
        this.pedidos = pedidos;
    }
}
