package com.davi.sistemadevotacao;

/**
 * The type Pessoa eleitora.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  /**
   * Instantiates a new Pessoa eleitora.
   *
   * @param nome the nome
   * @param cpf  the cpf
   */
  public PessoaEleitora(String nome, String cpf) {
    super.setNome(nome);
    this.cpf = cpf;
  }

  /**
   * Gets cpf.
   *
   * @return the cpf
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Sets cpf.
   *
   * @param cpf the cpf
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
