package br.com.poo.Menus;

import java.util.Scanner;
import br.com.poo.sistemainterno.App;

public class MenuPrincipal {

    App app = new App();
    String choice;

    public static Scanner myObj = new Scanner(System.in);

    public void menuInicio() {
        app.linhaMenu();
        System.out.println("\n*              [1] - Logar                  *");
        System.out.println("*             [2] - Cadastro                *");
        System.out.println("*              [3] - Sair                   *");
        app.linhaMenu();
        System.out.print("\n\n=> ");
        choice = myObj.nextLine();

        switch (choice) {
            case "1":
                //menuLogar();
            break;
            case "2":
                //menuCadastro();
            break;
            case "3":
                app.limparTela();
                System.out.println("Saindo do sistema, tenha um bom dia");
            break;
            default:
                app.limparTela();
                System.out.println("Opção invalida, tente novamente");
                menuInicio();
        }
    }
    
}
