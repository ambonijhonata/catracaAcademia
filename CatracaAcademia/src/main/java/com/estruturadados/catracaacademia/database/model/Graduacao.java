/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.catracaacademia.database.model;

/**
 *
 * @author User
 */
public class Graduacao {
    private int codigo;
    private String nome;
    private Modalidade modalidade;

    public Graduacao() {
    }

    public Graduacao(int codigo, String nome, Modalidade modalidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.modalidade = modalidade;
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

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }
        
}
