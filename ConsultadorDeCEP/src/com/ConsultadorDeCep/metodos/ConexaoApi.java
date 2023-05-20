package com.ConsultadorDeCep.metodos;

import com.ConsultadorDeCep.modelo.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConexaoApi {

    private String estado;
    private String cidade;
    private String logradouro;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Scanner leitura = new Scanner(System.in);

    public Cep buscaEndereco() throws IOException, InterruptedException {
        System.out.println("Digite seu CEP: ");
        int cepInput = Integer.parseInt(leitura.nextLine());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cepInput + "/json/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Cep cepObjeto = gson.fromJson(response.body(), Cep.class);

       return cepObjeto;
    }

    public String buscaCep() throws IOException, InterruptedException {


        System.out.println("Digite o Estado: ");
        estado = leitura.nextLine().toUpperCase();
        System.out.println("Digite a Cidade: ");
        cidade = leitura.nextLine().replace(" ", "%20");
        System.out.println("Digite o Logradouro: ");
        logradouro = leitura.nextLine().replace(" ", "%20");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ estado + "/" + cidade + "/" + logradouro + "/json/"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().create();
        return response.body();

    }

    public static void salvar(Cep cepObjeto) throws IOException {
        FileWriter escrita = new FileWriter("cep.json");
        Gson gson = new GsonBuilder().create();
        escrita.write(gson.toJson(cepObjeto));
        escrita.close();

        System.out.println(cepObjeto.toString());
    }

    public static void salvar(String resultado) throws IOException {
        FileWriter escrita = new FileWriter("enderecos.json");
        Gson gson = new GsonBuilder().create();
        escrita.write(resultado);
        escrita.close();

        System.out.println(resultado);
    }
}
