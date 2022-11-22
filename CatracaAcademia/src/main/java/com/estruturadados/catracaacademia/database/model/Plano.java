/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.catracaacademia.database.model;

/**
 *
 * @author User
 */
public class Plano {

    private int codigo;
    private String descricao;
    private Graduacao graduacao;
    private Double valorMensal;

    public Plano() {
    }

    public Plano(int codigo, String descricao, Graduacao graduacao, Double valorMensal) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.graduacao = graduacao;
        this.valorMensal = valorMensal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
