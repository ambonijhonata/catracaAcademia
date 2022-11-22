/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.brasil.catracaacademia.controller;

import com.estruturadados.catracaacademia.database.model.Aluno;
import com.estruturadados.catracaacademia.database.model.Assiduidade;
import com.estruturadados.catracaacademia.database.model.Fatura;
import com.estruturadados.catracaacademia.database.model.MatriculaPlano;
import com.estruturadadosdois.catracaacademia.database.dao.AlunoDAO;
import com.estruturadadosdois.catracaacademia.database.dao.AssiduidadeDAO;
import com.estruturadadosdois.catracaacademia.database.dao.FaturaDAO;
import com.estruturadadosdois.catracaacademia.database.dao.MatriculaPlanoDAO;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerMain {

    private Connection connection;

    public ControllerMain(Connection connection) {
        this.connection = connection;
    }

    public void buscarAluno(Aluno aluno) {
        if (connection != null) {
            AlunoDAO alunoDAO = new AlunoDAO(connection);
            alunoDAO.buscarAluno(aluno);
        }
    }

    public void buscarModalidadesAluno(int codigoAluno, List<MatriculaPlano> listaMatriculaPlanos) {
        MatriculaPlanoDAO mpDAO = new MatriculaPlanoDAO(connection);
        List<MatriculaPlano> list = mpDAO.buscaInformacoesModalidadesPraticadas(codigoAluno);

        if (list != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (MatriculaPlano mp : list) {
                listaMatriculaPlanos.add(mp);
            }
        }
    }

    public void buscarFaturasAluno(List<Fatura> list, int codigoAluno) {
        FaturaDAO faturaDAO = new FaturaDAO(connection);
        faturaDAO.buscarFaturas(list, codigoAluno);
    }
    
    public void buscarAssiduidade(int idAluno, List<Assiduidade> list){
        AssiduidadeDAO assiduidadeDAO = new AssiduidadeDAO(connection);
        assiduidadeDAO.buscarAssiduidades(idAluno, list);
    }
}
