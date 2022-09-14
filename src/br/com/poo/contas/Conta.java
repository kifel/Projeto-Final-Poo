package br.com.poo.contas;

public abstract class Conta {

    private String titular;
    private String numeroAgencia;
    private String numeroConta;
    protected int tipoConta;
    protected Double saldo;
    private String dataAbertura;
    private String cpf;

    public Conta() {

    }

    public Conta(String titular, String numeroAgencia, String numeroConta, int tipoConta, Double saldo,
    String dataAbertura, String cpf) {
        this.titular = titular;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
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

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
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