package br.com.poo.pessoas;

public class Presidente extends Funcionario {
	//Atributos herdados


	public Presidente() {
		super();
	}

	public Presidente(String senha, String tipoPessoa, double salario, String nome, String genero,
			String estadoCivil, String cpf, String telefone, String email, String dataNascimento) {
		super(tipoPessoa, salario, senha, nome, genero, estadoCivil, cpf, telefone, 
				email, dataNascimento);
		
	}
	
	
	
	
}
