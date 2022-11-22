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
public class Matricula {

    private int codigo;
    private Aluno aluno;
    private Date dataMatricula;
    private Date dataEncerramento;
    
    public Matricula() {
    }

    public Matricula(int codigo, Aluno aluno, Date dataMatricula, Date dataEncerramento) {
        this.codigo = codigo;
        this.aluno = aluno;
        this.dataMatricula = dataMatricula;
        this.dataEncerramento = dataEncerramento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }        

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
}
