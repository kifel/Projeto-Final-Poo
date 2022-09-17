package br.com.poo.contas;

import br.com.poo.tributos.Tributo;

public class ContaCorrente extends Conta implements Tributo {

	private double taxas;
	private Integer totalSaques = 0;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String tipoConta, String titular, String numeroAgencia, String numeroConta, Double saldo,
			String dataAbertura, String cpf) {
		super(tipoConta, titular, numeroAgencia, numeroConta, saldo, dataAbertura, cpf);
	}

	public double getTaxas() {
		return taxas;
	}

	public Integer getTotalSaques() {
		return totalSaques;
	}

	@Override
	public double tributarSaque(double valor) {
		return valor + Tributo.SAQUE;
	}

	@Override
	public double tributarDeposito(double valor) {
		return 0;
	}

	@Override
	public double tributarTransferencia(double valor) {
		return 0;
	}

	@Override
	public boolean sacar(double valor) {
		double valorTributado = tributarSaque(valor);
		if (valor < 0) {
			System.out.println("O valor digitado para saque é inválido!");
			return false;
		} else if (this.saldo - valorTributado >= 0) {
			this.saldo -= valorTributado;
			this.taxas += Tributo.SAQUE;
			++totalSaques;
			return true;
		} else {
			System.out.println("Saldo insuficiente!!!");
			return false;
		}
	}

	@Override
	public boolean depositar(double valor) {
		double valorTributado = tributarDeposito(valor);
		if (valor < 0) {
			return false;
		} else {
			this.saldo += (valor - valorTributado);
			this.taxas += valorTributado;
			System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("\nValor depositado: R$%.2f", valor, "\n");
			return true;
		}
	}

	@Override
	public boolean transferir(double valor, Conta nomeConta) {
		double valorTributado = tributarTransferencia(valor);
		if (this.saldo >= valorTributado) {
			nomeConta.saldo = nomeConta.saldo + valor;
			sacar(valor + valorTributado);
			this.taxas += valorTributado;
			System.out.println("\nOperação realizada com sucesso!\n");
			return true;

		} else {
			System.out.println("Não há saldo suficiente para transferir esse valor!!!");
			return false;

		}
	}

	public double consultaTotalTaxas() {
		return this.taxas;

	}

	@Override
	public String toString() {
		return "Conta Corrente\tNúmero da Agência = " + this.numeroAgencia + "\tNúmero da Conta = "
				+ this.numeroConta + "\tSaldo = " + this.saldo + "\tCPF = " + this.cpf + "\n";
	}

}
