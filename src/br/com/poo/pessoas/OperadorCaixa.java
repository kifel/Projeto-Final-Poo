package br.com.poo.pessoas;

public class OperadorCaixa extends Funcionario {
	// Atributos herdados

	public OperadorCaixa() {
		super();
	}

	public OperadorCaixa(String nome, String genero, String estadoCivil, String cpf, String telefone, String email,
			String dataNascimento, String senha, double salario, String tipoPessoa) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento, senha, salario, tipoPessoa);
	}

}
