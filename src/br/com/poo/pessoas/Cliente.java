package br.com.poo.pessoas;

public class Cliente extends Pessoa {
    String senha;
    int agencia;
    
    
	public Cliente() {
		super();
	}
	
	public Cliente(String senha, int agencia, String nome, String genero, String estadoCivil,
			String cpf, String telefone, String email, String dataNascimento) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento);
		
		this.senha = senha;
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
