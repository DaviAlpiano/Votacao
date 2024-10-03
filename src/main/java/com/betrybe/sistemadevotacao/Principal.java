package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {
  private final GerenciamentoVotacao gerenciamentoVotacao;

  /**
   * Instantiates a new Principal.
   */
  public Principal() {
    this.gerenciamentoVotacao = new GerenciamentoVotacao();
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Principal principal = new Principal();
    principal.run();
  }

  /**
   * Run.
   */
  public void run() {
    Scanner scanner = new Scanner(System.in);

    cadastrarCandidato(scanner);
    cadastrarEleitore(scanner);
    realizarVotacao(scanner);

    scanner.close();
  }

  private void cadastrarCandidato(Scanner scanner) {
    char option = '0';
    while (option != '2') {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      option = scanner.next().charAt(0);

      if (option == '1') {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String nome = scanner.next();
        System.out.print("Entre com o número da pessoa candidata: ");
        int numero = scanner.nextInt();
        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    }
  }

  private void cadastrarEleitore(Scanner scanner) {
    char option = '0';
    while (option != '2') {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      option = scanner.next().charAt(0);

      if (option == '1') {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nomeEleitor = scanner.next();
        System.out.print("Entre com o CPF da pessoa eleitora: ");
        String cpfEleitor = scanner.next();
        gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    }
  }

  private void realizarVotacao(Scanner scanner) {
    char option = '0';
    while (option != '3')  {
      menuVotacao();
      option = scanner.next().charAt(0);

      if (option == '1') {
        processarVoto(scanner);
      } else if (option == '2') {
        gerenciamentoVotacao.mostrarResultado();
      } else if (option == '3') {
        gerenciamentoVotacao.mostrarResultado();
      }
    }
  }

  private void menuVotacao() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Votar");
    System.out.println("2 - Resultado Parcial");
    System.out.println("3 - Finalizar Votação");
    System.out.print("Opção: ");
  }

  private void processarVoto(Scanner scanner) {
    System.out.print("Entre com o CPF da pessoa eleitora: ");
    String cpfEleitor = scanner.next();
    System.out.print("Entre com o número da pessoa candidata: ");
    int numeroCandidato = scanner.nextInt();
    gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
  }

}
