package br.com.poo.sistemainterno;

import java.io.IOException;

import br.com.poo.io.LeituraArquivo;
import br.com.poo.menu.MenuPrincipal;;

public class SistemaInterno {
    public static void main(String[] args) throws IOException {

        LeituraArquivo.leitor("data");

        MenuPrincipal menu = new MenuPrincipal();
        menu.menuInicio();
    }
}
