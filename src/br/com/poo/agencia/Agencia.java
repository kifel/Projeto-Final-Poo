package br.com.poo.agencia;

public class Agencia {
	private Integer Diretor;
	private String Endereco;
	private String numeroAgencia;
	
	
	public Agencia( Integer Diretor, String Endereco, String numeroAgencia) {
		super();
		
		this.Diretor = Diretor;
		this.Endereco = Endereco;
		this.numeroAgencia = numeroAgencia;
	}

	public Agencia() {
		super();
		
	}

	public Integer getDiretor() {
		return Diretor;
	}

	public void setDiretor(Integer idDiretor) {
		this.Diretor = idDiretor;
	}

	public String getEndereco() {
		return Endereco;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}


	public String toString() {
		return "\n Numero Agencia: " + numeroAgencia+ "\n no endereco: " + Endereco;
	}
	
	
    
}
