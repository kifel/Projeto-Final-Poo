package br.com.poo.menu;

import java.io.IOException;

import br.com.poo.contas.Conta;
import br.com.poo.io.LeituraArquivo;
import br.com.poo.pessoas.Funcionario;
import br.com.poo.pessoas.Gerente;
import br.com.poo.pessoas.Pessoa;
import br.com.poo.sistemainterno.App;

public class MenuOpecaoFuncionario {

    App app = new App();
    MenuLogin menu = new MenuLogin();
    MenuOpcao menuOp = new MenuOpcao();
    Gerente gerente = new Gerente();

    public void menuFuncionario(Pessoa pessoa, Conta conta, Funcionario funcionario) throws IOException {

        int opcaoOperacao;

        try {
            if (funcionario.getTipoPessoa().equals("GERENTE")) {
                app.linhaMenu();
                System.out.println("\n*           \t[1]- Relatório Gerente      *");
                System.out.println("*           \t[2]- Sair                   *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        String cpf = funcionario.getCpf();
                        Gerente gerente = (Gerente) Gerente.mapaGerente.get(cpf);
                        app.limparTela();
                        app.linhaMenu();
                        System.out.println("\n O total de contas na agência " + gerente.getIdAgencia()
                                + " são: " + LeituraArquivo.escritorContaAgencia("data", gerente.getIdAgencia()));
                        menuFuncionario(pessoa, conta, funcionario);
                        break;
                    case 2:
                        if (conta == null) {
                            menu.menuInicio();
                        } else {
                            menuOp.menuFuncionarioOp(pessoa, conta, funcionario);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(pessoa, conta, funcionario);

                }
            } else if (funcionario.getTipoPessoa().equals("DIRETOR")) {
                app.linhaMenu();
                System.out.println("\n*           \t[1]- Relatório Gerente      *");
                System.out.println("*           \t[2]- Relatório  Diretor     *");
                System.out.println("*           \t[3]- Sair                   *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        System.out.println(LeituraArquivo.escritorContaAgencia("data", gerente.getIdAgencia()));
                        break;
                    case 2:
                        break;
                    case 3:
                        if (conta == null) {
                            menu.menuInicio();
                        } else {
                            menuOp.menuFuncionarioOp(pessoa, conta, funcionario);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(pessoa, conta, funcionario);
                }
            } else if (funcionario.getTipoPessoa().equals("PRESIDENTE")) {
                app.linhaMenu();
                System.out.println("\n*           \t[1]- Relatório Gerente      *");
                System.out.println("*           \t[2]- Relatório  Diretor     *");
                System.out.println("*           \t[3]- Relatório Presidente   *");
                System.out.println("*           \t[4]- Sair                   *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        System.out.println(LeituraArquivo.escritorContaAgencia("data", gerente.getIdAgencia()));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        if (conta == null) {
                            menu.menuInicio();
                        } else {
                            menuOp.menuFuncionarioOp(pessoa, conta, funcionario);
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuFuncionario(pessoa, conta, funcionario);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}