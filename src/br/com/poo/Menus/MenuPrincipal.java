package br.com.poo.menus;

import java.io.IOException;
import java.util.Scanner;
import br.com.poo.sistemainterno.App;
import br.com.poo.contas.Conta;
import br.com.poo.pessoas.Funcionario;
import br.com.poo.pessoas.Pessoa;

public class MenuPrincipal {

    App app = new App();
    MenuOpcao menu = new MenuOpcao();
    String choice;
    Scanner myObj = new Scanner(System.in);

    public void menuInicio() {

        app.linhaMenu();
        System.out.println("\n*              [1] - Logar                  *");
        System.out.println("*           [2] - Funcionários              *");
        System.out.println("*              [3] - Sair                   *");
        app.linhaMenu();
        System.out.print("\n\n=> ");
        choice = myObj.nextLine();

        switch (choice) {
            case "1":
                menuLogarCliente();
                break;
            case "2":
                menuFuncionario();
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

    public void menuFuncionario() {
        String cpf;
        String senha;

        try {

            System.out.print("Digite o seu CPF :");
            cpf = myObj.nextLine();
            System.out.print("Digite a sua senha :");
            senha = myObj.nextLine();

            Funcionario funcionario = (Funcionario) Funcionario.mapaFuncionario.get(cpf);

            if (funcionario == null || !(funcionario.getSenha().equals(senha))) {
                app.limparTela();
                System.out.println("Informações incorretas");
                menuFuncionario();
            } else {
                System.out.println("LOGADO COM SUCESSO");
                menuFunc(funcionario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        myObj.close();
    }

    public void menuLogarCliente() {
        String cpf;
        String senha;

        try {

            System.out.print("Digite o seu CPF :");
            cpf = myObj.nextLine();
            System.out.print("Digite a sua senha :");
            senha = myObj.nextLine();

            Pessoa pessoa = (Pessoa) Pessoa.mapaPessoas.get(cpf);
            Conta conta = (Conta) Conta.mapaContas.get(cpf);

            if (pessoa == null || !(pessoa.getSenha().equals(senha))) {
                app.limparTela();
                System.out.println("Informações incorretas");
                menuLogarCliente();
            } else {
                System.out.println("LOGADO COM SUCESSO");
                menuCliente(pessoa, conta);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuCliente(Pessoa pessoa, Conta conta) throws IOException {
        try {
            app.limparTela();
            System.out.println("Bem-vindo(a) ao seu Banco, " + pessoa.getNome() + "!\n");
            System.out.println("Escolha uma opção");
            menu.menuPrincipal(pessoa, conta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuFunc(Funcionario funcionario) throws IOException {
        try {
            app.limparTela();
            System.out.println("Bem-vindo(a) ao seu trabalho, " + funcionario.getNome() + "!\n");
            System.out.println("Você tem a função de " + funcionario.getTipoPessoa() + "!\n");
            System.out.println("RELATÓRIOS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
