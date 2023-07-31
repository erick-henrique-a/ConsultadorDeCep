package com.ConsultadorDeCep.modelo;

import com.google.gson.annotations.SerializedName;


public class Cep {
    private String cep;
    private String logradouro;
    private String bairro;
    @SerializedName("localidade")
    private String cidade;
    @SerializedName("uf")
    private String estado;

    public Cep(String cep, String logradouro, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cep(){}

    @Override
    public String toString() {
        return "Cep: " + cep +
                ", Logradouro='" + logradouro + '\'' +
                ", Bairro='" + bairro + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Estado='" + estado + '\''
                ;
    }
}
