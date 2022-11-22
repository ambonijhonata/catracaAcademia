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
public class Fatura {

    private int codigo;
    private Matricula matricula;
    private Date vencimento;
    private Date pagamento;
    private Double valor;

    public Fatura() {
    }

    public Fatura(int codigo, Matricula matricula, Date vencimento, Date pagamento, Double valor) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.vencimento = vencimento;
        this.pagamento = pagamento;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getPagamento() {
        return pagamento;
    }

    public void setPagamento(Date pagamento) {
        this.pagamento = pagamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
        
}
