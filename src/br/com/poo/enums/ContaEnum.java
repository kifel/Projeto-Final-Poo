package br.com.poo.enums;

public enum ContaEnum {
	CORRENTE("corrente", 1),
	POUPANCA("poupanca", 2);


	private final String tipoConta;
	private final Integer idTipoConta;

	ContaEnum(String tipoConta, Integer idTipoConta) {
		this.tipoConta = tipoConta;
		this.idTipoConta = idTipoConta;
	}
	public String getTipoConta() {
		return tipoConta;
	}

	public Integer getIdTipoConta() {
		return idTipoConta;
	}

}