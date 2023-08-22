package com.example.atividade_22_08;

import java.io.Serializable;

public class Compra implements Serializable {
    private String nome;
    private String marca;
    private String quantidade;

    public Compra (String nome, String marca, String quantidade){
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return nome;
    }
    public String getMarca(){
        return marca;
    }
    public String getQuantidade(){
        return quantidade;
    }

}
