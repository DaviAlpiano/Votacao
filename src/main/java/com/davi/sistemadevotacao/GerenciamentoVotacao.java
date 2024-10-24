package com.davi.sistemadevotacao;

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
    List<String> cpfs = cpfsComputados
        .stream().filter(e -> e.equals(cpfPessoaEleitora)).toList();
    if (!cpfs.isEmpty()) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoa : pessoasCandidatas) {
        if (pessoa.getNumero() == numeroPessoaCandidata) {
          pessoa.receberVoto();
        }
      }
      cpfsComputados.add(cpfPessoaEleitora);
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (PessoaCandidata candidato : pessoasCandidatas) {
        String nome = candidato.getNome();
        int votos = candidato.getVotos();
        double divisor = cpfsComputados.size();
        long media = Math.round((votos * 100) / divisor);
        System.out.println("Nome: " + nome + " - " + votos + " votos ( " + media + "% )");
      }
      System.out.println("Total de votos: " + cpfsComputados.size());
    }
  }
}
