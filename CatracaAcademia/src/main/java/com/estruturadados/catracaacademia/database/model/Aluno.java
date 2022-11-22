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
public class Aluno {
    private int codigo;
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String contato;
    private Cidade cidade;

    public Aluno() {
    }

    public Aluno(int codigo, String nome, String cpf, Date data_nascimento, String contato, Cidade cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.contato = contato;
        this.cidade = cidade;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    

}
