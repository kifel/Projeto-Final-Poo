package br.com.poo.tributos;

public interface Tributo {
    final double SAQUE = 0.1;
    final double DEPOSITO = 0.1;
    final double TRANSFERENCIA = 0.2;


    double tributarSaque (double valor);

    double tributarDeposito (double valor);

    double tributarTransferencia (double valor);
}
