/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.catracaacademia.database.model;

/**
 *
 * @author User
 */
public class Estado {

    private int codigo;
    private String nome;
    private String uf;
    private Pais pais;

    public Estado() {
    }

    public Estado(int codigo, String nome, String uf, Pais pais) {
        this.codigo = codigo;
        this.nome = nome;
        this.uf = uf;
        this.pais = pais;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nome;
    }

}
