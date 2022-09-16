package br.com.poo.pessoas;

public class Diretor extends Funcionario {
	// Atributos herdados

	public Diretor() {
		super();
	}

	public Diretor(String nome, String genero, String estadoCivil, String cpf, String telefone, String email,
			String dataNascimento, String senha, double salario, String tipoPessoa) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento, senha, salario, tipoPessoa);
	}

}
