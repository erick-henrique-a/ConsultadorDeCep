package com.ConsultadorDeCep.principal;

import com.ConsultadorDeCep.metodos.ConexaoApi;
import com.ConsultadorDeCep.modelo.Cep;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConexaoApi programa = new ConexaoApi();
        Scanner le = new Scanner(System.in);
        int resposta;

        //Exibe uma pergunta para o usuário e continua solicitando a entrada até que uma resposta válida seja fornecida
        System.out.println("Você gostaria de pesquisar o CEP de uma rua (1)?\nOu consultar um CEP que você já possui (2)?");
        do{

            try{
                resposta = Integer.parseInt(le.nextLine()); // Lê a entrada do usuário e converte para um número inteiro
            }
            catch (NumberFormatException e){
                resposta = -1; // Se a entrada não for um número válido, atribui -1 à resposta
            }
            //Se a resposta for um número válido, se executa a pesquisa
            if(resposta == 1 || resposta == 2){
                switch (resposta){
                    case 1:
                        String resultados = programa.buscaCep();
                        programa.salvar(resultados);
                        break;
                    case 2:
                        Cep cep = programa.buscaEndereco();
                        programa.salvar(cep);
                        break;
                    default: break;
                }
            }else{ // Exibe uma mensagem de erro se a resposta não for 1 ou 2 e solicita novamente a entrada do usuário
                System.out.println("Entrada inválida, digite 1 ou 2" +
                        "\nVocê gostaria de pesquisar o CEP de uma rua (1)?\n" +
                        "Ou consultar um CEP que você já possui (2)?");
            }

        } while (resposta != 1 && resposta != 2);
    }
}