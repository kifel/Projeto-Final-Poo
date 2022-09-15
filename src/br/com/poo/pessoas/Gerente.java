package br.com.poo.pessoas;

public class Gerente extends Funcionario {
	int idAgencia;

	
	public Gerente() {
		super();
		
	}

	public Gerente(int idAgencia, String tipoPessoa, double salario, String senha, String nome, String genero,
			String estadoCivil, String cpf, String telefone, String email, String dataNascimento) {
		super(tipoPessoa, salario, senha, nome, genero, estadoCivil, cpf, telefone, email, dataNascimento);
		
		this.idAgencia = idAgencia;
	}	
}
