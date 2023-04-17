package br.edu.ufrb.aluno.fetch.entities;
public class Fornecedor {
  private String cnpj;
  private String nome;
  private String endereço;
  private String telefone;
  private String email;

  public Fornecedor(String nome, String cnpj) {
    this.nome = nome;
    this.cnpj = cnpj;
  }

  public Fornecedor() {
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereço() {
    return this.endereço;
  }

  public void setEndereço(String endereço) {
    this.endereço = endereço;
  }
  
  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

