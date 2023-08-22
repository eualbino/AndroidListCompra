package com.example.atividade_22_08;

import java.io.Serializable;

public class Compra implements Serializable {
    private String nome;
    private String marca;
    private String quantidade;
    private String comprado;

    public Compra(String nome, String marca, String quantidade, String comprado) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.comprado = comprado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getComprado() {
        return comprado;
    }

    public void setComprado(String comprado) {
        this.comprado = comprado;
    }
}
