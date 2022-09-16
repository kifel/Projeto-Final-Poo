package br.com.poo.menu;

import java.io.IOException;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.io.LeituraArquivo;
import br.com.poo.pessoas.Funcionario;
import br.com.poo.pessoas.Pessoa;
import br.com.poo.sistemainterno.App;

public class MenuOpcao {

    App app = new App();
    MenuLogin menu = new MenuLogin();

    public void menuCliente(Pessoa pessoa, Conta conta) throws IOException {

        int opcaoOperacao;

        try {

            if (conta.getTipoConta().equals("CORRENTE")) {
                System.out.println();
                app.linhaMenu();
                System.out.println("\n*           \t[1]-Saque                   *");
                System.out.println("*           \t[2]-Deposito                *");
                System.out.println("*           \t[3]-Transferência           *");
                System.out.println("*           \t[4]-Saldo                   *");
                System.out.println("*           \t[5]-Sair                    *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        Double inputValorSaque = menu.myObj.nextDouble();
                        if (conta.sacar(inputValorSaque)) {
                            LeituraArquivo.escritorSaque(conta, inputValorSaque, "corrente");

                            // LeituraArquivo.atualizadata(conta);
                            menuCliente(pessoa, conta);
                        } else {
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 2:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja depositar: ");
                        Double inputValorDeposito = menu.myObj.nextDouble();
                        if (conta.depositar(inputValorDeposito)) {
                            LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "corrente");
                            menuCliente(pessoa, conta);
                        } else {
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 3:
                        app.linhaMenu();
                        System.out.print("\nInforme o cpf da conta destino: ");
                        String cpfDestino = menu.myObj.next();
                        Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            Double valor = menu.myObj.nextDouble();
                            if (conta.transferir(valor, contaDestino)) {
                                System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                conta.getSaldo();
                                LeituraArquivo.escritorTransferencia(conta, valor, "corrente");
                                menuCliente(pessoa, conta);

                            }
                        } else {
                            System.out.println("conta não existe");
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 4:
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuCliente(pessoa, conta);
                        // LeituraArquivo.comprovanteSaldo(conta);
                        break;
                    case 5:
                        menu.menuInicio();
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                        menuCliente(pessoa, conta);
                }
            } else if (conta.getTipoConta().equals("POUPANCA")) {
                System.out.println();
                app.linhaMenu();
                System.out.println("\n*           \t[1]-Saque                   *");
                System.out.println("*           \t[2]-Deposito                *");
                System.out.println("*           \t[3]-Transferência           *");
                System.out.println("*           \t[4]-Saldo                   *");
                System.out.println("*           \t[5]-Rendimento              *");
                System.out.println("*           \t[6]-Sair                    *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        Double inputValorSaque = menu.myObj.nextDouble();
                        if (conta.sacar(inputValorSaque)) {
                            LeituraArquivo.escritorSaque(conta, inputValorSaque, "poupanca");
                            menuCliente(pessoa, conta);
                        } else {
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 2:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja depositar: ");
                        Double inputValorDeposito = menu.myObj.nextDouble();
                        if (conta.depositar(inputValorDeposito)) {
                            LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "poupanca");
                            menuCliente(pessoa, conta);
                        } else {
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 3:
                        app.linhaMenu();
                        System.out.print("\nInforme o cpf da conta destino: ");
                        String cpfDestino = menu.myObj.next();
                        Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            Double valor = menu.myObj.nextDouble();
                            if (conta.transferir(valor, contaDestino)) {
                                System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                conta.getSaldo();
                                LeituraArquivo.escritorTransferencia(conta, valor, "poupanca");
                                menuCliente(pessoa, conta);
                            }
                        } else {
                            System.out.println("conta não existe");
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 4:
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuCliente(pessoa, conta);
                        // LeituraArquivo.comprovanteSaldo(conta);
                        break;
                    case 5:
                        ContaPoupanca contaP = (ContaPoupanca) Conta.mapaContas.get(pessoa.getCpf());
                        contaP.rendimentoPoupanca();
                        menuCliente(pessoa, conta);
                        break;
                    case 6:
                        menu.menuInicio();
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("Erro 404");
                menuCliente(pessoa, conta);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuFuncionarioOp(Pessoa pessoa, Conta conta, Funcionario funcionario) throws IOException {

        int opcaoOperacao;
        MenuOpecaoFuncionario menuF = new MenuOpecaoFuncionario();

        try {
            if (conta != null) {
                if (conta.getTipoConta().equals("CORRENTE")) {
                    System.out.println();
                    app.linhaMenu();
                    System.out.println("\n*           \t[1]-Saque                   *");
                    System.out.println("*           \t[2]-Deposito                *");
                    System.out.println("*           \t[3]-Transferência           *");
                    System.out.println("*           \t[4]-Saldo                   *");
                    System.out.println("*           \t[5]-Menu Funcionario        *");
                    System.out.println("*           \t[6]-Sair                    *");
                    app.linhaMenu();
                    System.out.print("\nDigite a opção desejada: ");
                    opcaoOperacao = menu.myObj.nextInt();
                    switch (opcaoOperacao) {
                        case 1:
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja sacar: ");
                            Double inputValorSaque = menu.myObj.nextDouble();
                            if (conta.sacar(inputValorSaque)) {
                                LeituraArquivo.escritorSaque(conta, inputValorSaque, "corrente");

                                // LeituraArquivo.atualizadata(conta);
                                menuCliente(pessoa, conta);
                            } else {
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 2:
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja depositar: ");
                            Double inputValorDeposito = menu.myObj.nextDouble();
                            if (conta.depositar(inputValorDeposito)) {
                                LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "corrente");
                                menuCliente(pessoa, conta);
                            } else {
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 3:
                            app.linhaMenu();
                            System.out.print("\nInforme o cpf da conta destino: ");
                            String cpfDestino = menu.myObj.next();
                            Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                            if (contaDestino != null) {
                                System.out.print("Digite o valor que deseja transferir: ");
                                Double valor = menu.myObj.nextDouble();
                                if (conta.transferir(valor, contaDestino)) {
                                    System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                    System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                    conta.getSaldo();
                                    LeituraArquivo.escritorTransferencia(conta, valor, "corrente");
                                    menuCliente(pessoa, conta);
                                }
                            } else {
                                System.out.println("conta não existe");
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 4:
                            System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                            menuCliente(pessoa, conta);
                            // LeituraArquivo.comprovanteSaldo(conta);
                            break;
                        case 5:
                            menuF.menuFuncionario(pessoa, conta, funcionario);
                            break;
                        case 6:
                            menu.menuInicio();
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                            menuCliente(pessoa, conta);
                    }
                } else if (conta.getTipoConta().equals("POUPANCA")) {
                    System.out.println();
                    app.linhaMenu();
                    System.out.println("\n*           \t[1]-Saque                   *");
                    System.out.println("*           \t[2]-Deposito                *");
                    System.out.println("*           \t[3]-Transferência           *");
                    System.out.println("*           \t[4]-Saldo                   *");
                    System.out.println("*           \t[5]-Rendimento              *");
                    System.out.println("*           \t[6]-Menu Funcionario        *");
                    System.out.println("*           \t[7]-Sair                    *");
                    app.linhaMenu();
                    System.out.print("\nDigite a opção desejada: ");
                    opcaoOperacao = menu.myObj.nextInt();
                    switch (opcaoOperacao) {
                        case 1:
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja sacar: ");
                            Double inputValorSaque = menu.myObj.nextDouble();
                            if (conta.sacar(inputValorSaque)) {
                                LeituraArquivo.escritorSaque(conta, inputValorSaque, "poupanca");
                                menuCliente(pessoa, conta);
                            } else {
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 2:
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja depositar: ");
                            Double inputValorDeposito = menu.myObj.nextDouble();
                            if (conta.depositar(inputValorDeposito)) {
                                LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "poupanca");
                                menuCliente(pessoa, conta);
                            } else {
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 3:
                            app.linhaMenu();
                            System.out.print("\nInforme o cpf da conta destino: ");
                            String cpfDestino = menu.myObj.next();
                            Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                            if (contaDestino != null) {
                                System.out.print("Digite o valor que deseja transferir: ");
                                Double valor = menu.myObj.nextDouble();
                                if (conta.transferir(valor, contaDestino)) {
                                    System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                    System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                    conta.getSaldo();
                                    LeituraArquivo.escritorTransferencia(conta, valor, "poupanca");
                                    menuCliente(pessoa, conta);
                                }
                            } else {
                                System.out.println("conta não existe");
                                menuCliente(pessoa, conta);
                            }
                            break;
                        case 4:
                            System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                            menuCliente(pessoa, conta);
                            // LeituraArquivo.comprovanteSaldo(conta);
                            break;
                        case 5:
                            ContaPoupanca contaP = (ContaPoupanca) Conta.mapaContas.get(pessoa.getCpf());
                            contaP.rendimentoPoupanca();
                            menuCliente(pessoa, conta);
                            break;
                        case 6:
                            menuF.menuFuncionario(pessoa, conta, funcionario);
                            break;
                        case 7:
                            menu.menuInicio();
                            break;
                        default:
                            System.out.println("\nOpção inválida!");
                    }
                } else {
                    System.out.println("Erro 404");
                    menuCliente(pessoa, conta);
                }
            } else {
                menuF.menuFuncionario(pessoa, conta, funcionario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
