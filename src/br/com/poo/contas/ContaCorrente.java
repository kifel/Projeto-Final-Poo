package br.com.poo.contas;

import br.com.poo.tributos.Tributo;

public class ContaCorrente extends Conta implements Tributo {

	private double taxas;
	private Integer totalSaques = 0;
	private Integer totalDepositos = 0;
	private Integer totalTransferencia = 0;

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

	public Integer getTotalDepositos() {
		return totalDepositos;
	}

	public Integer getTotalTransferencia() {
		return totalTransferencia;
	}

	@Override
	public double tributarSaque(double valor) {
		return valor + Tributo.SAQUE;
	}

	@Override
	public double tributarDeposito(double valor) {
		return valor - Tributo.DEPOSITO;
	}

	@Override
	public double tributarTransferencia(double valor) {
		return valor + Tributo.TRANSFERENCIA;
	}

	@Override
	public boolean sacar(double valor) {
		double valorTributado = tributarSaque(valor);
		if (valor <= 0) {
			System.out.println("O valor digitado para saque é inválido!");
			return false;
		} else if (this.saldo - valorTributado >= 0) {
			this.saldo -= valorTributado;
			this.taxas += Tributo.SAQUE;
			totalSaques++;
			return true;
		} else {
			System.out.println("Saldo insuficiente!!!");
			return false;
		}
	}

	@Override
	public boolean depositar(double valor) {
		double valorTributado = tributarDeposito(valor);
		if (valor <= 0) {
			System.out.println("Erro ao depositar, valor invalido!!!");
			return false;
		} else {
			this.saldo += valorTributado;
			this.taxas += Tributo.DEPOSITO;
			System.out.println("\nOperação realizada com sucesso!\n");
			System.out.printf("\nValor depositado: R$%.2f", valor, "\n");
			totalDepositos++;
			return true;
		}
	}

	@Override
	public boolean transferir(double valor, Conta nomeConta) {

		double valorTributado = tributarTransferencia(valor);
		if (valor > 0) {
			if (this.saldo >= valorTributado) {
				nomeConta.saldo = nomeConta.saldo + valor;
				this.saldo -= valorTributado;
				this.taxas += Tributo.TRANSFERENCIA;
				System.out.println(taxas);
				System.out.println("\nOperação realizada com sucesso!\n");
				totalTransferencia++;
				return true;
			} else {
				System.out.println("Não há saldo suficiente para transferir esse valor!!!");
				return false;

			}
		}else {
			System.out.println("Valor Invalido !!!!");
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
