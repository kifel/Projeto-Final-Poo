package br.com.poo.contas;

import java.util.HashMap;
import java.util.Map;

public abstract class Conta {

    protected String tipoConta;
    protected String titular;
    protected String numeroAgencia;
    protected String numeroConta;
    protected Double saldo;
    protected String dataAbertura;
    protected String cpf;

    public static Map<String, Conta> mapaContas = new HashMap<>();

    public Conta() {

    }

    public Conta(String tipoConta, String titular, String numeroAgencia, String numeroConta, Double saldo,
            String dataAbertura, String cpf) {
        this.tipoConta = tipoConta;
        this.titular = titular;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.cpf = cpf;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public abstract boolean sacar(double valor);

    public abstract boolean depositar(double valor);

    public abstract boolean transferir(double valor, Conta nomeConta);

    @Override
    public String toString() {
        return "Conta [titular=" + titular + ", numero=" + numeroConta + ", agencia=" + numeroAgencia + ", tipo="
                + tipoConta
                + ", cpfTitular=" + cpf + ", saldo=" + saldo + "]";

    }

}