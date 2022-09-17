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
                        app.limparTela();
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        Double inputValorSaque = menu.myObj.nextDouble();
                        if (conta.sacar(inputValorSaque)) {
                            LeituraArquivo.escritorSaque(conta, inputValorSaque, "corrente");
                            menuCliente(pessoa, conta);
                        } else {
                            menuCliente(pessoa, conta);
                        }
                        break;
                    case 2:
                        app.limparTela();
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
                        app.limparTela();
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
                        app.limparTela();
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuCliente(pessoa, conta);
                        break;
                    case 5:
                        app.limparTela();
                        menu.logoInicio();
                        break;
                    default:
                        app.limparTela();
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
                        app.limparTela();
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
                        app.limparTela();
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
                        app.limparTela();
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
                        app.limparTela();
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuCliente(pessoa, conta);
                        break;
                    case 5:
                        app.limparTela();
                        ContaPoupanca contaP = (ContaPoupanca) Conta.mapaContas.get(pessoa.getCpf());
                        contaP.rendimentoPoupanca();
                        menuCliente(pessoa, conta);
                        break;
                    case 6:
                        app.limparTela();
                        menu.logoInicio();
                        break;
                    default:
                        app.limparTela();
                        menuCliente(pessoa, conta);
                }
            } else {
                app.limparTela();
                System.out.println("Erro 404");
                menuCliente(pessoa, conta);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuFuncionarioOp(Pessoa pessoa, Conta conta, Funcionario funcionario) throws IOException {

        int opcaoOperacao;

        try {
            MenuOpecaoFuncionario menuF = new MenuOpecaoFuncionario();
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
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja sacar: ");
                            Double inputValorSaque = menu.myObj.nextDouble();
                            if (conta.sacar(inputValorSaque)) {
                                LeituraArquivo.escritorSaque(conta, inputValorSaque, "corrente");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            } else {
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 2:
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja depositar: ");
                            Double inputValorDeposito = menu.myObj.nextDouble();
                            if (conta.depositar(inputValorDeposito)) {
                                LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "corrente");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            } else {
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 3:
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nInforme o cpf da conta destino: ");
                            String cpfDestino = menu.myObj.next();
                            Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                            if (contaDestino != null) {
                                System.out.print("Digite o valor que deseja transferir: ");
                                Double valor = menu.myObj.nextDouble();
                                if (conta.transferir(valor, contaDestino)) {
                                    System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                    System.out.print("Consulte seu saldo");
                                    conta.getSaldo();
                                    LeituraArquivo.escritorTransferencia(conta, valor, "corrente");
                                    menuFuncionarioOp(pessoa, conta, funcionario);
                                }
                            } else {
                                System.out.println("conta não existe");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 4:
                            app.limparTela();
                            System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                            menuFuncionarioOp(pessoa, conta, funcionario);
                            break;
                        case 5:
                            app.limparTela();
                            menuF.menuFuncionario(pessoa, conta, funcionario);
                            break;
                        case 6:
                            app.limparTela();
                            menu.logoInicio();
                            break;
                        default:
                            app.limparTela();
                            menuFuncionarioOp(pessoa, conta, funcionario);
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
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja sacar: ");
                            Double inputValorSaque = menu.myObj.nextDouble();
                            if (conta.sacar(inputValorSaque)) {
                                LeituraArquivo.escritorSaque(conta, inputValorSaque, "poupanca");
                                System.out.println("\nOperação realizada com sucesso!\n");
                                System.out.printf("\nValor sacado: R$%.2f", inputValorSaque, "\n");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            } else {
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 2:
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nDigite o valor que deseja depositar: ");
                            Double inputValorDeposito = menu.myObj.nextDouble();
                            if (conta.depositar(inputValorDeposito)) {
                                app.limparTela();
                                LeituraArquivo.escritorDeposito(conta, inputValorDeposito, "poupanca");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            } else {
                                app.limparTela();
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 3:
                            app.limparTela();
                            app.linhaMenu();
                            System.out.print("\nInforme o cpf da conta destino: ");
                            String cpfDestino = menu.myObj.next();
                            Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                            if (contaDestino != null) {
                                app.limparTela();
                                System.out.print("Digite o valor que deseja transferir: ");
                                Double valor = menu.myObj.nextDouble();
                                if (conta.transferir(valor, contaDestino)) {
                                    app.limparTela();
                                    System.out.println("Operação realizada com sucesso!");
                                    System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                    System.out.print("Consulte seu saldo");
                                    conta.getSaldo();
                                    LeituraArquivo.escritorTransferencia(conta, valor, "poupanca");
                                    menuFuncionarioOp(pessoa, conta, funcionario);
                                }
                            } else {
                                app.limparTela();
                                System.out.println("conta não existe");
                                menuFuncionarioOp(pessoa, conta, funcionario);
                            }
                            break;
                        case 4:
                            app.limparTela();
                            System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                            menuFuncionarioOp(pessoa, conta, funcionario);
                            break;
                        case 5:
                            app.limparTela();
                            ContaPoupanca contaP = (ContaPoupanca) Conta.mapaContas.get(pessoa.getCpf());
                            contaP.rendimentoPoupanca();
                            menuFuncionarioOp(pessoa, conta, funcionario);
                            break;
                        case 6:
                            app.limparTela();
                            menuF.menuFuncionario(pessoa, conta, funcionario);
                            break;
                        case 7:
                            app.limparTela();
                            menu.logoInicio();
                            break;
                        default:
                            app.limparTela();
                            menuFuncionarioOp(pessoa, conta, funcionario);
                    }
                } else {
                    app.limparTela();
                    System.out.println("Erro 404");
                    menuFuncionarioOp(pessoa, conta, funcionario);
                }
            } else {
                app.limparTela();
                menuF.menuFuncionario(pessoa, conta, funcionario);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
