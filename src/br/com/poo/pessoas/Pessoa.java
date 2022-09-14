package br.com.poo.pessoas;

public abstract class Pessoa {

	private String nome;
	private String genero;
	private String estadoCivil;
	private String cpf;
	private String telefone;
	private String email;
	private String dataNascimento;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String genero, String estadoCivil, String cpf, String telefone,
			String email, String dataNascimento) {
		this.nome = nome;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String listagem() {
		return "Pessoa [nome=" + nome + ", genero=" + genero + ", estadoCivil="
				+ estadoCivil + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
