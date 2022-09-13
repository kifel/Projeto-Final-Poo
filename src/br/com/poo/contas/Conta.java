package br.com.poo.contas;

public abstract class Conta {

    private String senhaConta;
    private String numeroAgencia;
    private String numeroConta;
    protected Double saldo;
    private String dataAbertura;
    private Boolean status;
    private String cpf;

    public Conta() {

    }

    public Conta(String senhaConta, String numeroAgencia, String numeroConta, Double saldo, String dataAbertura,
            Boolean status, String cpf) {
        super();
        this.senhaConta = senhaConta;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.cpf = cpf;
    }

    public String getSenha() {
        return senhaConta;
    }

    public void setSenha(String senhaConta) {
        this.senhaConta = senhaConta;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double saldo(double saldo) {
        return this.getSaldo();
    }

    @Override
    public String toString() {
        return "\nnumeroAgencia="
                + numeroAgencia + "\n numeroConta=" + numeroConta + "\nsaldo=" + getSaldo() + "\ndataAbertura="
                + dataAbertura
                + "\nstatus=" + status + "]";
    }

}