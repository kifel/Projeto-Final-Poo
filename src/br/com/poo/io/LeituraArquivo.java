package br.com.poo.io;

// Importing the necessary libraries to use the methods.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.enums.*;
import br.com.poo.pessoas.*;

import br.com.poo.sistemainterno.App;

public class LeituraArquivo {
  static final String PATH_BASIC = "./temp/";
  static final String EXTENSION = ".txt";
  static App app = new App();

  static Cliente cliente = new Cliente();

  public static void leitor(String path) throws IOException {
    try {
      BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASIC + path + EXTENSION));
      String line = "";

      while (true) {
        line = buffRead.readLine();
        if (line != null) {
          String[] data = line.split(";");
          if (data[0].equalsIgnoreCase(PessoasEnum.CLIENTE.getTipoPessoa())) {
            Cliente cliente = new Cliente(data[2], data[10], data[12], data[7], data[11], data[8], data[13], data[9],
                Integer.parseInt(data[3]));
            Cliente.mapaPessoas.put(data[7], cliente);
            if (data[1].equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {
              ContaPoupanca contaP = new ContaPoupanca(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]),
                  data[6], data[7]);
              Conta.mapaContas.put(data[7], contaP);
            } else if (data[1].equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
              ContaCorrente contaC = new ContaCorrente(data[1], data[2], data[3], data[4], Double.parseDouble(data[5]),
                  data[6], data[7]);
              Conta.mapaContas.put(data[7], contaC);
            }
          } else if (data[0].equalsIgnoreCase(PessoasEnum.GERENTE.getTipoPessoa())) {
            Gerente gerente = new Gerente(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8],
                Double.parseDouble(data[9]), data[0], Integer.parseInt(data[10]));
            Funcionario.mapaFuncionario.put(data[4], gerente);
            Funcionario.ordenaFuncionario.put(data[1], gerente);
          } else if (data[0].equalsIgnoreCase(PessoasEnum.DIRETOR.getTipoPessoa())) {
            Diretor diretor = new Diretor(data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8],
                Double.parseDouble(data[9]), data[0]);
            Funcionario.mapaFuncionario.put(data[4], diretor);
            Funcionario.ordenaFuncionario.put(data[1], diretor);
          } else if (data[0].equalsIgnoreCase(PessoasEnum.PRESIDENTE.getTipoPessoa())) {
            Presidente presidente = new Presidente(data[1], data[2], data[3], data[4], data[5], data[6], data[7],
                data[8], Double.parseDouble(data[9]), data[0]);
            Funcionario.mapaFuncionario.put(data[4], presidente);
            Funcionario.ordenaFuncionario.put(data[1], presidente);
          } else if (data[0].equalsIgnoreCase(PessoasEnum.OPERADOR_CAIXA.getTipoPessoa())) {
            OperadorCaixa operadorCaixa = new OperadorCaixa(data[1], data[2], data[3], data[4], data[5], data[6],
                data[7], data[8], Double.parseDouble(data[9]), data[0]);
            Funcionario.mapaFuncionario.put(data[4], operadorCaixa);
            Funcionario.ordenaFuncionario.put(data[1], operadorCaixa);
          }
        } else {
          break;
        }

      }

      buffRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void atualizadata(Conta conta) throws IOException {
    BufferedWriter buffWrite;
    BufferedReader buffRead;
    String arq = "./temp/data.txt";
    String arqtmp = "./temp/data-tmp";

    try {
      buffWrite = new BufferedWriter(new FileWriter(arqtmp));
      buffRead = new BufferedReader(new FileReader(arq));
      String line;

      while ((line = buffRead.readLine()) != null) {
        String[] data = line.split(";");

        if (data[7].equalsIgnoreCase(conta.getCpf())) {
          line = line.replace(data[5], String.valueOf(conta.getSaldo()));
        }
        buffWrite.write(line + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    new File(arq).delete();
    new File(arqtmp).renameTo(new File(arq));
  }

  public static void escritorSaque(Conta conta, double Valor, String tipoConta) throws IOException {

    String arq = conta.getTitular() + "_Comprovante_Saque";
    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASIC + arq + EXTENSION, true));) {

      String linha = "============ saque ============";
      buffWrite.append(linha + "\n");

      linha = "Nome: " + conta.getTitular();
      buffWrite.append(linha + "\n");

      linha = "Agencia: " + conta.getNumeroAgencia();
      buffWrite.append(linha + "\n");
      if (tipoConta.equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
        linha = "Conta: corrente";
        buffWrite.append(linha + "\n");
      } else if (tipoConta.equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {
        linha = "Conta: poupança";
        buffWrite.append(linha + "\n");
      }

      linha = "Numero da Conta: " + conta.getNumeroConta();
      buffWrite.append(linha + "\n");

      linha = "Valor: R$ " + Valor;
      buffWrite.append(linha + "\n");

      linha = app.data();
      buffWrite.append(linha + "\n");

      linha = "============= fim do saque =============";
      buffWrite.append(linha + "\n");

      buffWrite.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void escritorTransferencia(Conta conta, double Valor, String tipoConta) throws IOException {
    String arq = conta.getTitular() + "_Comprovante_Transferencia";

    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASIC + arq + EXTENSION))) {

      String linha = "============ transferencia ============";
      buffWrite.append(linha + "\n");

      linha = "Nome: " + conta.getTitular();
      buffWrite.append(linha + "\n");

      linha = "Agencia: " + conta.getNumeroAgencia();
      buffWrite.append(linha + "\n");
      if (tipoConta.equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())) {
        linha = "Conta: corrente";
        buffWrite.append(linha + "\n");
      } else if (tipoConta.equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {
        linha = "Conta: poupança";
        buffWrite.append(linha + "\n");
      }

      linha = "Numero da Conta: " + conta.getNumeroConta();
      buffWrite.append(linha + "\n");

      linha = "Valor: R$ " + Valor;
      buffWrite.append(linha + "\n");

      linha = app.data();
      buffWrite.append(linha + "\n");

      linha = "============= fim da transferencia =============";
      buffWrite.append(linha + "\n");

      buffWrite.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
