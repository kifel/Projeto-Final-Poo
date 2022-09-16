package br.com.poo.pessoas;

import java.util.HashMap;
import java.util.Map;

public class Gerente extends Funcionario {
	protected Integer idAgencia;
	public static Map<String, Gerente> mapaGerente = new HashMap<>();

	public Gerente() {
		super();

	}

	public Gerente(String nome, String genero, String estadoCivil, String cpf, String telefone, String email,
			String dataNascimento, String senha, double salario, String tipoPessoa, Integer idAgencia) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento, senha, salario, tipoPessoa);
		this.idAgencia = idAgencia;
	}

	public Integer getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Integer idAgencia) {
		this.idAgencia = idAgencia;
	}

}
