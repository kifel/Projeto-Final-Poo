package br.com.poo.pessoas;

import java.util.HashMap;
import java.util.Map;

public class Cliente extends Pessoa {
	private int agencia;
	public static Map<String, Cliente> mapaCliente = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(String nome, String genero, String estadoCivil, String cpf, String telefone, String email,
			String dataNascimento, String senha, int agencia) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento, senha);
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
}
