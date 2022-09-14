package br.com.poo.Menus;

import java.util.Scanner;
import br.com.poo.sistemainterno.App;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                // menuLogar();
                break;
            case "2":
                menuCadastro();
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

    public void menuCadastro() {
        String choice;
        String data;
        int tipoConta;

        app.linhaMenu();
        System.out.println("\n|         Escolha o tipo de conta           |");
        System.out.println("|              [1]- Corrente                |");
        System.out.println("|              [2]- Poupança                |");
        app.linhaMenu();
        System.out.print("\n\n=> ");
        choice = myObj.nextLine();

        switch (choice) {
            case "1":
                data = data();
                tipoConta = Integer.parseInt(choice);
                System.out.print("Digite o nome do titular da conta: ");
                String titular = myObj.nextLine();
                System.out.printf("\nDigite o número da agencia: ");
                String numeroAgencia = myObj.nextLine();
                System.out.print("\nDigite o número da conta: ");
                String numeroConta = myObj.nextLine();
                System.out.println("\nDigite o cpf: ");
                String cpf = myObj.nextLine();
                ContaCorrente cs = new ContaCorrente(titular, numeroAgencia, numeroConta, tipoConta, 0.0, data, cpf,
                        0.0);
                app.limparTela();
                System.out.println("Conta Criada com o saldo de " + cs.getSaldo());
                System.out.println("Data de criação de conta " + cs.getDataAbertura());
                menuInicio();
                break;
            case "2":
                data = data();
                tipoConta = Integer.parseInt(choice);
                System.out.print("Digite o nome do titular da conta: ");
                String titularcp = myObj.nextLine();
                System.out.printf("\nDigite o número da agencia: ");
                String numeroAgenciacp = myObj.nextLine();
                System.out.print("\nDigite o número da conta: ");
                String numeroContacp = myObj.nextLine();
                System.out.println("\nDigite o cpf: ");
                String cpfcp = myObj.nextLine();
                ContaPoupanca cp = new ContaPoupanca(titularcp, numeroAgenciacp, numeroContacp, tipoConta, 0.0, data,
                        cpfcp);
                app.limparTela();
                System.out.println("Conta Criada com o saldo de " + cp.getSaldo());
                System.out.println("Data de criação de conta " + cp.getDataAbertura());
                menuInicio();
                break;
            default:
                System.out.println("Opção invalida, tente novamente");
                menuCadastro();
        }
    }

    public String data() {
        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy 'as' hh:mm:ss a");
        String dataFormatada = data.format(formatada);
        return dataFormatada;
    }

}
