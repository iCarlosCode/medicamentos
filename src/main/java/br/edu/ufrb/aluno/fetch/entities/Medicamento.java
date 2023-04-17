package br.edu.ufrb.aluno.fetch.entities;

import java.util.ArrayList;

public class Medicamento {
    //Declara as variaveis privadas
    private String codigo;
    private int quantidade;
    private int pesoEmGramas;
    
    private boolean statusGenerico;
    private boolean statusTarjaPreta;

    private String nome;
    private String fabricante;
    private String outrasInformacoes;
    
    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Medicamento(String codigo, 
    int quantidade, 
    int pesoEmGramas,
    boolean statusGenerico, 
    boolean statusTarjaPreta,
    String nome, 
    String fabricante, 
    String outrasInformacoes) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.pesoEmGramas = pesoEmGramas;
        this.statusGenerico = statusGenerico;
        this.statusTarjaPreta = statusTarjaPreta;
        this.nome = nome;
        this.fabricante = fabricante;
        this.outrasInformacoes = outrasInformacoes;
        
    }
    
    @Override //Sobre escreve os valores
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Medicamento remedio = (Medicamento) obj;
        return  this.codigo.equals(remedio.getCodigo()) &&
                this.pesoEmGramas == remedio.pesoEmGramas &&
                this.statusGenerico == remedio.statusGenerico &&
                this.statusTarjaPreta == remedio.statusTarjaPreta &&
                this.nome.toLowerCase().equals(remedio.nome.toLowerCase()) &&
                this.fabricante.toLowerCase().equals(remedio.fabricante.toLowerCase()) &&
                this.outrasInformacoes.toLowerCase().equals(remedio.outrasInformacoes.toLowerCase());
    }
    
   
    //Getters e Setters do Medicamento
    
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public int getPesoEmGramas() {
        return pesoEmGramas;
    }
    public void setPesoEmGramas(int pesoEmGramas) {
        this.pesoEmGramas = pesoEmGramas;
    }
    
     
    public boolean isStatusGenerico() {
        return statusGenerico;
    }
    public void setStatusGenerico(boolean statusGenerico) {
        this.statusGenerico = statusGenerico;
    }
    public boolean isStatusTarjaPreta() {
        return statusTarjaPreta;
    }
    public void setStatusTarjaPreta(boolean statusTarjaPreta) {
        this.statusTarjaPreta = statusTarjaPreta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }
    public void setOutrasInformacoes(String outrasInformacoes) {
        this.outrasInformacoes = outrasInformacoes;
    }

    
}
