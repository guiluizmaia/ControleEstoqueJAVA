package com.br.unifafibe.controleestoque.model;

public class Produto {
    private String nome, tipo, fornecedor;
    private int cod, quant;
    private boolean visivel = false;
    
    public Produto(int cod, String nome, String tipo, String fornecedor,  int quant){
        this.nome = nome;
        this.tipo = tipo;
        this.fornecedor = fornecedor;
        this.cod = cod;
        this.quant = quant;       
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public int getCod() {
        return cod;
    }

    public int getQuant() {
        return quant;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    
    
    
    @Override
    public String toString() {
        return String.format("-----------------\n"
                + "Cod: %d\n"
                + "Nome: %s\n"
                + "Tipo: %s\n"
                + "Fornecedor: %s\n"
                + "Quant: %d\n-----------------\n", cod, nome, tipo, fornecedor, quant); 
    }

}
