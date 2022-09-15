package br.com.poo.pessoas;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class Funcionario extends Pessoa {
    double salario;
    String senha;
    String tipoPessoa;
    
    public static Map<String, Funcionario> mapaFuncionario = new HashMap<String, Funcionario>();
    public static TreeMap<String, Funcionario> ordenaFuncionario = new TreeMap<String, Funcionario>();
    
	public Funcionario() {
		super();
	}
	
	public Funcionario(String tipoPessoa, double salario, String senha, String nome, String genero,
			String estadoCivil, String cpf, String telefone, String email, String dataNascimento) {
		super(nome, genero, estadoCivil, cpf, telefone, email, dataNascimento);
		
		this.tipoPessoa = tipoPessoa;
		this.salario = salario;
		this.senha = senha;
	}
	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
	public String relatorioFuncionario() {
		return "Nome: " + this.nome + "\nCPF: " + this.cpf + "\nCargo: " + this.tipoPessoa;
	}
}
