package br.edu.ufrb.aluno.fetch.entities;

public class Medicamento {
    private int codigo;
    private int quantidade;
    private int pesoEmGramas;
    
    private boolean statusGenerico;
    private boolean statusTarjaPreta;

    private String nome;
    private String fabricante;
    private String outrasInformacoes;
    
    



    public Medicamento(int codigo, 
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
    
    /*
    @Override
    public boolean equals(Medicamento placebo) {
        if(this.codigo == placebo.getCodigo() && this.nome.toLowerCase() == placebo.getNome().toLowerCase()){
            return true;
        }
        return false;
    }
     */
/*
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
 */
    //Getters e Setters do Medicamento
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
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
