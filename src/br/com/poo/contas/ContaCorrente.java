package br.com.poo.contas;

public class ContaCorrente extends Conta {

    private Double chequeEspecial;
    private Double taxa;

    private Integer numeroTotalSaques = 0, numeroTotalDepositos = 0, numeroTotalTransferencias = 0;
    private Double numeroTotalTributado = 0.0;

    public ContaCorrente() {

    }

    public ContaCorrente(String senhaConta, String numeroAgencia, String numeroConta, Double saldo, String dataAbertura,
            Boolean status, String cpf, Double chequeEspecial, Double taxa, Integer numeroTotalSaques,
            Integer numeroTotalDepositos,
            Integer numeroTotalTransferencias, Double numeroTotalTributado) {
        super(senhaConta, numeroAgencia, numeroConta, saldo, dataAbertura, status, cpf);
        this.chequeEspecial = chequeEspecial;
        this.taxa = taxa;
        this.numeroTotalSaques = numeroTotalSaques;
        this.numeroTotalDepositos = numeroTotalDepositos;
        this.numeroTotalTransferencias = numeroTotalTransferencias;
        this.numeroTotalTributado = numeroTotalTributado;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Integer getTotalSaques() {
        return numeroTotalSaques;
    }

    public void setTotalSaques(Integer numeroTotalSaques) {
        this.numeroTotalSaques = numeroTotalSaques;
    }

    public Integer getTotalDepositos() {
        return numeroTotalDepositos;
    }

    public void setTotalDepositos(Integer numeroTotalDepositos) {
        this.numeroTotalDepositos = numeroTotalDepositos;
    }

    public Integer getTotalTransferencias() {
        return numeroTotalTransferencias;
    }

    public void setTotalTransferencias(Integer numeroTotalTransferencias) {
        this.numeroTotalTransferencias = numeroTotalTransferencias;
    }

    public Double getTotalTributado() {
        return numeroTotalTributado;
    }

    public void setTotalTributado(Double numeroTotalTributado) {
        this.numeroTotalTributado = numeroTotalTributado;
    }

    public String toString() {

        return "ContaCorrente \nchequeEspecial: " + chequeEspecial + "taxa: " + taxa +
                "\\nnumeroAgencia: " + getNumeroAgencia() + "\nnumeroConta: " + getNumeroConta() +
                "\nsaldo: " + getSaldo() + "\ndataAbertura: " + getDataAbertura();
    }

}
