package br.com.poo.sistemainterno;

public class App {

    final int STRAM = 45;

    public void limparTela() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void linhaMenu() {
        for (int i = 0; i < STRAM; i++) {
            System.out.print("*");
        }
    }
}