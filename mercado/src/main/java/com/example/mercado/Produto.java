package com.example.mercado;

public class Produto {
    public Long id_produto;
    public String nome_produto;
    public double preco_produto;
    public double quantidade_medida;
    public String medida;
    public int quantidade_estoque;
    
    public Long getId_produto() {
        return id_produto;
    }
    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome_produto() {
        return nome_produto;
    }
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }
    public double getPreco_produto() {
        return preco_produto;
    }
    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }
    public double getQuantidade_medida() {
        return quantidade_medida;
    }
    public void setQuantidade_medida(double quantidade_medida) {
        this.quantidade_medida = quantidade_medida;
    }
    public String getMedida() {
        return medida;
    }
    public void setMedida(String medida) {
        this.medida = medida;
    }
    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }
    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    

    
    
}
