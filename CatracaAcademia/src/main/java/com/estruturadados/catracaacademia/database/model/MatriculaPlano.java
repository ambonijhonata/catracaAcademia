/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadados.catracaacademia.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class MatriculaPlano {

    private Matricula matricula;
    private Plano plano;
    private Date dataInicio;
    
    public MatriculaPlano() {
    }

    public MatriculaPlano(Matricula matricula, Plano plano, Date dataInicio, Date dataCancelamento) {
        this.matricula = matricula;
        this.plano = plano;
        this.dataInicio = dataInicio;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

}
