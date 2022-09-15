package br.com.poo.io;

// Importing the necessary libraries to use the methods.
import java.io.BufferedReader;
import java.io.BufferedWriter;
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

  public static void leitor(String path) throws IOException {
    try {
    BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASIC + path + EXTENSION));
    String line = "";

    while(true) {
      line = buffRead.readLine();  
    
      if (line != null) {
        String[] data = line.split(";");
          
        if(data[0].equalsIgnoreCase(ContaEnum.POUPANCA.getTipoConta())) {
          ContaPoupanca contaP = new ContaPoupanca(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]), data[5], data[6]);
          Conta.mapaContas.put(data[6], contaP);
        }else if(data[0].equalsIgnoreCase(ContaEnum.CORRENTE.getTipoConta())){
          ContaCorrente contaC = new ContaCorrente(data[0], data[1],data[4], data[3], Double.parseDouble(data[4]),data[5],data[6] );
          Conta.mapaContas.put(data[6], contaC);
        }else if(data[0].equalsIgnoreCase(PessoasEnum.GERENTE.getTipoPessoa())) {
          Gerente gerente = new Gerente(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]), data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]);
          Funcionario.mapaFuncionario.put(data[7], gerente);
          Funcionario.ordenaFuncionario.put(data[3], gerente);
        }else if(data[0].equalsIgnoreCase(PessoasEnum.DIRETOR.getTipoPessoa())) {
          Diretor diretor = new Diretor(data[0], Double.parseDouble(data[1]), data[2],data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
          Funcionario.mapaFuncionario.put(data[6], diretor);
          Funcionario.ordenaFuncionario.put(data[3], diretor);
        } else if(data[0].equalsIgnoreCase(PessoasEnum.PRESIDENTE.getTipoPessoa())) {
          Presidente presidente = new Presidente(data[0], data[1], Double.parseDouble(data[2]),data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
          Funcionario.mapaFuncionario.put(data[6], presidente);
          Funcionario.ordenaFuncionario.put(data[3], presidente);
        }else if(data[0].equalsIgnoreCase(PessoasEnum.OPERADOR_CAIXA.getTipoPessoa())) {
          OperadorCaixa operadorCaixa = new OperadorCaixa(data[0], Double.parseDouble(data[1]), data[2],data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
          Funcionario.mapaFuncionario.put(data[6], operadorCaixa);
          Funcionario.ordenaFuncionario.put(data[3], operadorCaixa);
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


  public static void escritorSaque(Conta conta, double Valor) throws IOException {


    String arq = conta.getTitular() + "_Comprovante_Saque";
    try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASIC + arq + EXTENSION, true));) {
    
    String linha = "============ saque ============";
    buffWrite.append(linha + "\n");

    linha = "Agência: " + conta.getNumeroAgencia();
    buffWrite.append(linha + "\n");

    linha = "Conta: " + conta.getNumeroConta();
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
} catch(Exception e) {
  e.printStackTrace();
}
    
  }
}
