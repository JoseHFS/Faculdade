package com.example.produtos;

public class Produto {
    private String id_produto;
    private String nome;
    private double preco;
    private int quantidade;
    private double valor_medida;
    private String medidade;
    
    public String getId_produto() {
        return id_produto;
    }
    public void setId_produto(String id_produto) {
        this.id_produto = id_produto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValor_medida() {
        return valor_medida;
    }
    public void setValor_medida(double valor_medida) {
        this.valor_medida = valor_medida;
    }
    public String getMedidade() {
        return medidade;
    }
    public void setMedidade(String medidade) {
        this.medidade = medidade;
    }

    
    
}
