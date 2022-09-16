package br.com.poo.menu;

import java.io.IOException;

import br.com.poo.io.LeituraArquivo;
import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.pessoas.Pessoa;
import br.com.poo.sistemainterno.App;

public class MenuOpcao {

    public void menuPrincipal(Pessoa pessoa, Conta conta) throws IOException {

        App app = new App();
        MenuPrincipal menu = new MenuPrincipal();
        int opcaoOperacao;

        try {
            if (conta.getTipoConta().equals("CORRENTE")) {
                app.linhaMenu();
                System.out.println("\n*            [1]\tSaque                *");
                System.out.println("*            [2]\tDeposito             *");
                System.out.println("*            [3]\tTransferência        *");
                System.out.println("*            [4]\tSaldo                *");
                System.out.println("*            [5]\tSair                 *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        Double inputValorSaque = menu.myObj.nextDouble();
                        if (conta.sacar(inputValorSaque)) {
                            LeituraArquivo.escritorSaque(conta, inputValorSaque);
                            LeituraArquivo.atualizadata(conta);
                            menuPrincipal(pessoa, conta);
                        } else {
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 2:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja depositar: ");
                        Double inputValorDeposito = menu.myObj.nextDouble();
                        if (conta.depositar(inputValorDeposito)) {
                            menuPrincipal(pessoa, conta);
                            // LeituraArquivo.escritorDeposito(conta, inputValorSaque);
                        } else {
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 3:
                        app.linhaMenu();
                        System.out.print("Informe o cpf da conta destino: ");
                        String cpfDestino = menu.myObj.next();
                        Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            Double valor = menu.myObj.nextDouble();
                            if (conta.transferir(valor, contaDestino)) {
                                System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                conta.getSaldo();
                                menuPrincipal(pessoa, conta);
                            }
                        } else {
                            System.out.println("conta não existe");
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 4:
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuPrincipal(pessoa, conta);
                        // LeituraArquivo.comprovanteSaldo(conta);
                        break;
                    case 5:
                        menu.menuInicio();
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else if (conta.getTipoConta().equals("POUPANCA")) {
                app.linhaMenu();
                System.out.println("\n*            [1]\tSaque                *");
                System.out.println("*            [2]\tDeposito             *");
                System.out.println("*            [3]\tTransferência        *");
                System.out.println("*            [4]\tSaldo                *");
                System.out.println("*            [5]\tRendimento           *");
                System.out.println("*            [6]\tSair                 *");
                app.linhaMenu();
                System.out.print("\nDigite a opção desejada: ");
                opcaoOperacao = menu.myObj.nextInt();
                switch (opcaoOperacao) {
                    case 1:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja sacar: ");
                        Double inputValorSaque = menu.myObj.nextDouble();
                        if (conta.sacar(inputValorSaque)) {
                            LeituraArquivo.escritorSaque(conta, inputValorSaque);
                            menuPrincipal(pessoa, conta);
                        } else {
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 2:
                        app.linhaMenu();
                        System.out.print("\nDigite o valor que deseja depositar: ");
                        Double inputValorDeposito = menu.myObj.nextDouble();
                        if (conta.depositar(inputValorDeposito)) {
                            // LeituraArquivo.escritorDeposito(conta, inputValorSaque);
                            menuPrincipal(pessoa, conta);
                        } else {
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 3:
                        app.linhaMenu();
                        System.out.print("Informe o cpf da conta destino: ");
                        String cpfDestino = menu.myObj.next();
                        Conta contaDestino = Conta.mapaContas.get(cpfDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor que deseja transferir: ");
                            Double valor = menu.myObj.nextDouble();
                            if (conta.transferir(valor, contaDestino)) {
                                System.out.printf("\nValor transferido foi de: R$ %.2f%n", valor);
                                System.out.print("\nSaldo atual de " + conta.getTitular() + " ");
                                conta.getSaldo();
                                menuPrincipal(pessoa, conta);
                            }
                        } else {
                            System.out.println("conta não existe");
                            menuPrincipal(pessoa, conta);
                        }
                        break;
                    case 4:
                        System.out.printf("\nSeu saldo é: R$%.2f", conta.getSaldo());
                        menuPrincipal(pessoa, conta);
                        // LeituraArquivo.comprovanteSaldo(conta);
                        break;
                    case 5:
                        ContaPoupanca contaP = (ContaPoupanca) Conta.mapaContas.get(pessoa.getCpf());
                        contaP.rendimentoPoupanca();
                        menuPrincipal(pessoa, conta);
                        break;
                    case 6:
                        menu.menuInicio();
                        break;
                    default:
                        System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("Erro 404");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
