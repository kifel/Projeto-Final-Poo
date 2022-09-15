package br.com.poo.pessoas;

public class OperadorCaixa extends Funcionario {
	//Atributos herdados
	
	
	public OperadorCaixa() {
		super();
	}

	public OperadorCaixa(String tipoPessoa, double salario, String senha, String nome, String genero,
			String estadoCivil, String cpf, String telefone, String email, String dataNascimento) {
		super(tipoPessoa, salario, senha, nome, genero, estadoCivil, cpf, telefone, email, dataNascimento);

	}
}
