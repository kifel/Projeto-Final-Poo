package br.com.poo.enums;

public enum PessoasEnum {
	GERENTE("gerente", 1),
	DIRETOR("diretor", 2),
	PRESIDENTE("presidente", 3),
	CLIENTE("cliente", 4),
	OPERADOR_CAIXA("operador caixa", 5);

	private final Integer idTipoPessoa;
	private final String tipoPessoa;

	PessoasEnum(String tipoPessoa, int idTipoPessoa) {
		this.tipoPessoa = tipoPessoa;
		this.idTipoPessoa = idTipoPessoa;
	}

	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

}
