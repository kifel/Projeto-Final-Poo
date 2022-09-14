package br.com.poo.enums;

public enum ContaEnum {
    CORRENTE("corrente"), POUPANCA("poupanca");

	private final String tipoConta;

	ContaEnum(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getContaEnum() {
		return this.tipoConta;
	}
}
