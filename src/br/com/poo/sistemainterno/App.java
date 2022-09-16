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
}