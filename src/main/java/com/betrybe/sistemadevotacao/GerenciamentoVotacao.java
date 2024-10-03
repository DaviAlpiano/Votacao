package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gerenciamento votacao.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  /**
   * The Pessoas candidatas.
   */
  ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  /**
   * The Pessoas eleitoras.
   */
  ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  /**
   * The Cpfs computados.
   */
  ArrayList<String> cpfsComputados = new ArrayList<String>();

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    GerenciamentoVotacao cadastrar = new GerenciamentoVotacao();
    System.out.println(cadastrar.pessoasCandidatas);
    cadastrar.cadastrarPessoaCandidata("davi", 222);
    cadastrar.cadastrarPessoaCandidata("davi", 222);
    cadastrar.cadastrarPessoaEleitora("lucas", "70900525844");
    System.out.println(cadastrar.pessoasCandidatas.toString());
    System.out.println(cadastrar.pessoasEleitoras.toString());
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    List<PessoaEleitora> eleitora = pessoasEleitoras
        .stream().filter(e -> cpf.equals(e.getCpf())).toList();
    if (!eleitora.isEmpty()) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(pessoaEleitora);
    }
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    List<PessoaCandidata> candidata = pessoasCandidatas
        .stream().filter(candidato -> numero == candidato.getNumero()).toList();
    if (!candidata.isEmpty()) {
      System.out.println("Número da pessoa candidata já utilizado!");
    } else {
      PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(pessoaCandidata);
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
