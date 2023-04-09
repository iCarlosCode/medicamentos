package br.edu.ufrb.aluno.fetch.entities;

public class Medicamento {
    //Declaração das atributos privados
    private String codigo;
    private int quantidade;
    private int pesoEmGramas;
    
    private boolean statusGenerico;
    private boolean statusTarjaPreta;

    private String nome;
    private String fabricante;
    private String outrasInformacoes;
    
    

    //Construtor.
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
    
    

    @Override // Sobrescrevendo o método equals.
    public boolean equals(Object obj) {
        if (obj == null) return false;
        Medicamento remedio = (Medicamento) obj;
        //Cmparando com base no peso,status,nome, fabricante e outras informações.
        return  
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

    /* @Override
    public String toString() {
        String info = "Nome: " + this.nome +
               "\nCódigo: " + this.codigo +
               "\nPeso(gramas): " + this.pesoEmGramas +
               "\nFabricante: " + this.fabricante +
               "\nQuantidade: " + this.quantidade;

                if(this.statusGenerico){
                    info += "\nMedicamento genérico";
                } else {
                    info += "\nMedicamento não genérico";
                }

                if(this.statusTarjaPreta){
                    info += "\nMedicamento tarja preta";
                } else {
                    info += "\nMedicamento sem tarja preta";
                }

                info += "\nOutras informações: " + this.outrasInformacoes;
        return info;
    } */
}
