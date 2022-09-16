package br.com.poo.pessoas;

public class Gerente extends Funcionario {
	protected Integer idAgencia;

	public Gerente() {
		super();

	}

	public Gerente(String nome, String genero, String estadoCivil, String cpf, String telefone, String email,
			String dataNascimento, String senha, double salario, String tipoPessoa, Integer idAgencia) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento, senha, salario, tipoPessoa);
		this.idAgencia = idAgencia;
	}

}
