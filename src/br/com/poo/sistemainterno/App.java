package br.com.poo.sistemainterno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {

    final int STRAM = 45;

    public void limparTela() {
        for (int i = 0; i < STRAM; i++) {
            System.out.println();
        }
    }

    public void linhaMenu() {
        for (int i = 0; i < STRAM; i++) {
            System.out.print("*");
        }
    }

    public String data() {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy 'as' hh:mm:ss a");
        String dataFormatada = data.format(formatada);
        return dataFormatada;
    }

    public void logoBanco() {
        int pos = 8;
        int ini;
        int tronco = 0;
        int alturaTronco = 3;
        int quantidade = 1;

        ini = pos;

        System.out.print("\n");

        // It's printing the tree.
        for (int i = 0; i <= pos; i++) {
            // It's printing the spaces before the stars.
            for (int j = 1; j <= ini; j++) {
                System.out.print(" ");
            }
            ini -= 1;
            // It's printing the stars.
            for (int j = 1; j <= quantidade; j++) {
                if (j == 1) {
                    System.out.print("/");
                    if (quantidade == 1) {
                        System.out.print("\\");
                    }
                } else if (j == quantidade) {
                    System.out.print("*");
                    System.out.print("\\");
                } else {
                    System.out.print("*");
                }
            }
            quantidade += 2;
            System.out.print("\n");
        }

        tronco = 2;
        pos -= 1;

        // It's printing the trunk of the tree.
        for (int i = 0; i < alturaTronco; i++) {
            // It's printing the spaces before the stars.
            for (int j = 1; j <= pos; j++) {
                System.out.print(" ");
            }
            // It's printing the trunk of the tree.
            for (int j = 0; j < tronco; j++) {
                if (j == 0) {
                    System.out.print("|");
                    System.out.print("*");

                } else {
                    System.out.print("*");
                }

                if (j == tronco - 1) {
                    System.out.print("|");
                    if (i == 1 && j == 1) {
                        System.out.print("            Tree Bank, aonde o seu dinheiro cresce");

                    }
                }
            }
            System.out.print("\n");
        }

    }

}