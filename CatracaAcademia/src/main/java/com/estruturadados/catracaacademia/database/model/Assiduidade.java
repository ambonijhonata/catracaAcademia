/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.catracaacademia.database.model;

import java.util.Date;

/**
 *
 * @author User
 */
public class Assiduidade {
    private int codigo;
    private Date data;
    private Matricula matricula;

    public Assiduidade() {
    }        
    
    public Assiduidade(int codigo, Date data, Matricula matricula) {
        this.codigo = codigo;
        this.data = data;
        this.matricula = matricula;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Assiduidade{" + "data=" + data + '}';
    }
        
}
