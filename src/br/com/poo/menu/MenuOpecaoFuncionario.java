package br.com.poo.menu;

import java.io.IOException;


import br.com.poo.pessoas.Funcionario;
import br.com.poo.sistemainterno.App;

public class MenuOpecaoFuncionario {

    App app = new App();
    MenuLogin menu = new MenuLogin();

    public void menuFuncionario(Funcionario funcionario) throws IOException {

        int opcaoOperacao;

        try {

            if (funcionario.getTipoPessoa().equals("GERENTE")) {
                app.linhaMenu();
       
            
                System.out.println("*           \t[1]- Relatório Gerente         *");
                System.out.println("*           \t[2]- Sair                    *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                case 1:
               
                case 2:
                    menu.menuInicio();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    menuFuncionario(funcionario);
                	
                }
            } else if (funcionario.getTipoPessoa().equals("DIRETOR")) {
                app.linhaMenu();
       
            
                System.out.println("*           \t[1]- Relatório Gerente         *");
                System.out.println("*           \t[2]- Relatório  Diretor         *");
                System.out.println("*           \t[3]- Sair                    *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                case 1:
                case 2:
                case 3:
                    menu.menuInicio();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    menuFuncionario(funcionario);
                    }
            }else if  ( funcionario.getTipoPessoa().equals("PRESIDENTE")) {
                app.linhaMenu();
                
                System.out.println("*           \t[1]- Relatório Gerente         *");
                System.out.println("*           \t[2]- Relatório  Diretor         *");
                System.out.println("*           \t[3]- Relatório Presidente                 *");
                System.out.println("*           \t[4]- Sair                    *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                case 1:
                case 2:
                case 3:
                case 4:
                    menu.menuInicio();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    menuFuncionario(funcionario);
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}               