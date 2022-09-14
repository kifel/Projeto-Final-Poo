package br.com.poo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeituraArquivo {
  static final String PATH_BASIC = "./temp/";
  static final String EXTENSION = ".txt";

  public static void leitor(String path) throws IOException {
    BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASIC + path + EXTENSION));
    String linha = "";

    while(true) {
      linha = buffRead.readLine();  
    
      if (linha != null) {
        System.out.println(linha);
      } else {
        break;
      }
    }

    buffRead.close();
  }


  public static void escritor () throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escreva o nome do arquivo do relatório: ");
    String path = sc.next();


    BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASIC + path + EXTENSION, true));
    

    String linha = sc.next();
    buffWrite.append(linha);
    buffWrite.newLine();
    buffWrite.close();
    sc.close();

    
  }
}
