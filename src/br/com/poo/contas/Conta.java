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

    public boolean sacar(double valor) {
        if (this.saldo < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    public boolean depositar(double valor) {
        if (valor < 0) {
            return false;
        } else {
            this.saldo += valor;
            return true;
        }
    }

    public boolean transferir(double valor, Conta nomeConta) {
        boolean transfere = sacar(valor);
        if (transfere == false) {
            System.out.println("Saldo insuficiente");
            return false;
        } else {
            nomeConta.depositar(valor);
            System.out.println("Transferido com sucesso");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Conta [titular=" + titular + ", numero=" + numeroConta + ", agencia=" + numeroAgencia + ", tipo="
                + tipoConta
                + ", cpfTitular=" + cpf + ", saldo=" + saldo + "]";

    }

}