package br.com.poo.contas;

import java.util.Scanner;

public class ContaPoupanca extends Conta {

    protected final double TAXARENDIMENTO = 0.01575;

    ContaPoupanca() {

    }

    public ContaPoupanca(String tipoConta, String titular, String numeroAgencia, String numeroConta, Double saldo,
            String dataAbertura, String cpf) {
        super(tipoConta, titular, numeroAgencia, numeroConta, saldo, dataAbertura, cpf);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor digitado para saque é inválido!");
            return false;
        } else if (this.saldo < valor) {
            System.out.println("Valor digitado excede o saldo disponível!");
            return false;
        } else {
            System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("Valor sacado: R$%.2f", valor, "\n");
			System.out.printf("Saldo atual: R$%.2f", this.saldo, "\n");
            this.saldo -= valor;
            return true;
        }
    }

    @Override
    public boolean depositar(double valor) {
        if (valor < 0) {
            return false;
        } else {
            this.saldo += valor;
            System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("Valor depositado: R$%.2f", valor, "\n");
			System.out.printf("Saldo atual: R$%.2f", this.saldo, "\n");
            return true;
        }
    }

    @Override
    public boolean transferir(double valor, Conta nomeConta) {
        boolean transfere = sacar(valor);
        if (transfere == false) {
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            nomeConta.depositar(valor);
            System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("Valor Transferido de : R$%.2f", valor, "\n");
			System.out.printf("Saldo atual: R$%.2f", this.saldo, "\n");
            return true;
        }
    }

    public void rendimentoPoupanca() {
        double rendimentoPoupanca;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Informe o número de dias: ");
        int dias = myObj.nextInt();
        System.out.println("Digite o valor: ");
        double valor = myObj.nextDouble();

        rendimentoPoupanca = (this.TAXARENDIMENTO / 365 * dias) * valor;
        System.out.println();
        System.out.printf("Valor investido: R$ %.2f%n", valor);
        System.out.printf("Valor do rendimento: R$ %.2f%n", rendimentoPoupanca);
        System.out.print("Valor total ao fim dos " + dias + " dias:");
        System.out.printf(" R$ %.2f", (valor + rendimentoPoupanca));
        System.out.println();

        myObj.close();
    }

    @Override
	public String toString() {
		return "Conta Poupança\tNúmero da Agência = " + this.numeroAgencia + "\tNúmero da Conta = "
				+ this.numeroConta + "\tSaldo = " + this.saldo + "\tCPF = " + this.cpf + "\n";
	}
}
