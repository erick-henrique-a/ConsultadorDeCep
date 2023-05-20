package com.ConsultadorDeCep.principal;

import com.ConsultadorDeCep.metodos.ConexaoApi;
import com.ConsultadorDeCep.modelo.Cep;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConexaoApi programa = new ConexaoApi();
        Scanner le = new Scanner(System.in);
        System.out.println("Você gostaria de pesquisar o CEP de uma rua (1)?");
        System.out.println("Ou consultar um CEP que você já possui (2)?");
        int resposta = le.nextInt();
        switch (resposta){
            case 1:
                String resultados = programa.buscaCep();
                programa.salvar(resultados);
                break;
            case 2:
                Cep cep = programa.buscaEndereco();
                programa.salvar(cep);
                break;
        }
    }
}