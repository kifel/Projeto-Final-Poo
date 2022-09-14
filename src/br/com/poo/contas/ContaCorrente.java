package br.com.poo.contas;

import br.com.poo.tributos.Tributo;

public class ContaCorrente extends Conta implements Tributo{

	protected double taxas;

	public ContaCorrente() {

	}

	public ContaCorrente(String titular, String numeroAgencia, String numeroConta, int tipoConta, Double saldo,
			String dataAbertura, String cpf) {
		super(titular, numeroAgencia, numeroConta, tipoConta, saldo, dataAbertura, cpf);
	}

	@Override
	public double tributarSaque(double valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double tributarDeposito(double valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double tributarTransferencia(double valor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean sacar(double valor) {
		if (this.saldo < (valor + 0.10)) {
			System.out.println("Saldo insuficiente!!!");
			return false;

		} else {
			this.saldo = this.saldo - (valor + 0.10);
			this.taxas = this.taxas + 0.10;
			return true;

		}
	}

	@Override
	public boolean depositar(double valor) {
		if (valor < 0) {
			return false;
		} else {
			this.saldo += (valor - 0.10);
			this.taxas = this.taxas + 0.10;
			return true;
		}
	}

	@Override
	public boolean transferir(double valor, Conta nomeConta) {
		if (this.saldo >= (valor + 0.20)) {
			nomeConta.saldo = nomeConta.saldo + valor;
			this.saldo = this.saldo - (valor + 0.20);
			this.taxas = this.taxas + 0.20;
			return true;

		} else {
			System.out.println("Não há saldo suficiente para transferir esse valor!!!");
			return false;

		}
	}

	public double consultaTotalTaxas() {
		return this.taxas;

	}


}
