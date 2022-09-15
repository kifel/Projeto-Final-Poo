package br.com.poo.io;

// Importing the necessary libraries to use the methods.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.enums.*;
import br.com.poo.pessoas.*;

public class LeituraArquivo {
  static final String PATH_BASIC = "./temp/";
  static final String EXTENSION = ".txt";

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
        }else if(data[0].equals(ContaEnum.CORRENTE.getTipoConta())){
          ContaCorrente contaC = new ContaCorrente(data[0], data[1],data[4], data[3], Double.parseDouble(data[4]),data[5],data[6] );
          Conta.mapaContas.put(data[6], contaC);
        }else if(data[0].equals(PessoasEnum.GERENTE.getTipoPessoa())) {
          Gerente gerente = new Gerente(Integer.parseInt(data[0]),data[1],Double.parseDouble(data[2]), data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]);
          Funcionario.mapaFuncionario.put(data[7], gerente);
          Funcionario.ordenaFuncionario.put(data[3], gerente);
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


  public static void escritor () throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escreva o nome do arquivo do relatório: ");
    String path = sc.next();

try {
    BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASIC + path + EXTENSION, true));
    

    String linha = sc.next();
    buffWrite.append(linha);
    buffWrite.newLine();
    buffWrite.close();
    sc.close();
} catch (IOException e) {
  e.printStackTrace();
} catch(Exception e) {
  e.printStackTrace();
}
    
  }
}
