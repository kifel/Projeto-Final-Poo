package br.com.poo.menu;

import java.io.IOException;
import java.util.Scanner;
import br.com.poo.sistemainterno.App;
import br.com.poo.contas.Conta;
import br.com.poo.pessoas.Funcionario;
import br.com.poo.pessoas.Pessoa;

public class MenuLogin {

    App app = new App();
    MenuPrincipal menu = new MenuPrincipal();
    String choice;
    Scanner myObj = new Scanner(System.in);

    public void logoInicio() {
        try {
            menuInicio();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuInicio() {

        try {
            app.logoBanco();
            System.out.println("\n");
            app.linhaMenu();
            System.out.println("\n*              [1] - Logar                  *");
            System.out.println("*              [2] - Sair                   *");
            app.linhaMenu();
            System.out.print("\n\n=> ");
            choice = myObj.nextLine();

            switch (choice) {
                case "1":
                    menuLogar();
                    break;
                case "2":
                    app.limparTela();
                    app.logoBanco();
                    System.out.println("\n");
                    System.out.println("Saindo do Tree Bank, tenha um bom dia");
                    break;
                default:
                    app.limparTela();
                    menuInicio();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuLogar() {
        String cpf;
        String senha;

        try {

            System.out.print("Digite o seu CPF :");
            cpf = myObj.nextLine();
            System.out.print("Digite a sua senha :");
            senha = myObj.nextLine();

            Funcionario funcionario = (Funcionario) Funcionario.mapaFuncionario.get(cpf);
            Pessoa pessoa = (Pessoa) Pessoa.mapaPessoas.get(cpf);
            Conta conta = (Conta) Conta.mapaContas.get(cpf);

            if (funcionario == null) {
                if (pessoa == null || !(pessoa.getSenha().equals(senha))) {
                    app.limparTela();
                    System.out.println("Informa????es incorretas");
                    menuLogar();
                } else {
                    subMenu(pessoa, conta, funcionario);
                }
            } else if (funcionario == null || !(funcionario.getSenha().equals(senha))) {
                app.limparTela();
                System.out.println("Informa????es incorretas");
                menuLogar();
            } else {
                System.out.println("LOGADO COM SUCESSO");
                subMenu(pessoa, conta, funcionario);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void subMenu(Pessoa pessoa, Conta conta, Funcionario funcionario) throws IOException {
        try {
            if (funcionario != null) {
                app.limparTela();
                System.out.println("Bem-vindo(a) ao seu Banco, " + funcionario.getNome() + "!\n");
                System.out.println("Voc?? tem a fun????o de " + funcionario.getTipoPessoa() + "!\n");
                System.out.println("Escolha uma op????o");
            } else {
                app.limparTela();
                System.out.println("Bem-vindo(a) ao seu Banco, " + pessoa.getNome() + "!\n");
                System.out.println("Escolha uma op????o");
            }
            menu.menuPrincipal(pessoa, conta, funcionario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
