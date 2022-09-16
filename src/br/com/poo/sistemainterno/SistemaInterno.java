package br.com.poo.sistemainterno;

import br.com.poo.Menus.MenuPrincipal;
import java.io.IOException;

import br.com.poo.io.LeituraArquivo;;

public class SistemaInterno {
    public static void main(String[] args) throws IOException {

        LeituraArquivo.leitor("data");

        MenuPrincipal menu = new MenuPrincipal();
        menu.menuInicio();
    }
}
