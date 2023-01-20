package main;

import java.util.ArrayList;
import java.util.Scanner;
import programa.*;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("1 - Criar Conta ");
        System.out.println("2 - Depositar ");
        System.out.println("3 - Sacar ");
        System.out.println("4 - Transferir ");
        System.out.println("5 - Listar ");
        System.out.println("6 - Sair ");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;

            case 2:
                depositar();
                break;

            case 3:
                sacar();
                break;

            case 4:
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                System.out.println("Saindo...");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida! ");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF");
        String CPF = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa cliente = new Pessoa(nome, CPF, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");

        operacoes();
    }

    private static Conta encotrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for (Conta conta1 : contasBancarias) {
                if (conta1.getNumeroConta() == numeroConta) {
                    conta = conta1;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroDaConta = input.nextInt();
        Conta conta = encotrarConta(numeroDaConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encotrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso! ");
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encotrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encotrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor de transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);
            } else {
                System.out.println("A conta para depósito não foi encontrada! ");
            }
        } else {
            System.out.println("Conta para trandferência não encontrada! ");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não existe conta cadastradas");
        }
        operacoes();
    }
}
