package br.com.poo.contas;

import java.util.Scanner;

import br.com.poo.tributos.Tributo;

public class ContaPoupanca extends Conta implements Tributo{

    protected final double TAXARENDIMENTO = 0.01575;

    ContaPoupanca() {

    }

    public ContaPoupanca(String titular, String numeroAgencia, String numeroConta, int tipoConta, Double saldo,
            String dataAbertura, String cpf) {
        super(titular, numeroAgencia, numeroConta, tipoConta, saldo, dataAbertura, cpf);
    }
    
    @Override
    public boolean sacar(double valor) {
        if (this.saldo < valor) {
            return false;
        } else {
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
            System.out.println("Transferido com sucesso");
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
}
