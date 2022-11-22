/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadadosdois.catracaacademia.database.dao;

import com.estruturadados.catracaacademia.database.model.Aluno;
import com.estruturadados.catracaacademia.database.model.Graduacao;
import com.estruturadados.catracaacademia.database.model.Matricula;
import com.estruturadados.catracaacademia.database.model.MatriculaPlano;
import com.estruturadados.catracaacademia.database.model.Modalidade;
import com.estruturadados.catracaacademia.database.model.Plano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class MatriculaPlanoDAO {

    private Connection connection;
    private String selectInformacoesModalidadesPraticadasAndPlano = "SELECT alunos.nome AS nomeAluno, matriculas.codigo AS codMatricula, matriculas.data_matricula AS dataMatricula, modalidades.nome AS modalidade, graduacoes.nome AS graduacao,"
            + " planos.descricao AS plano, planos.valor_mensal AS valorMensalPlano,"
            + " matriculas_planos.data_inicio as dataInicio,"
            + " matriculas.data_encerramento"
            + " FROM matriculas_planos"
            + " INNER JOIN matriculas ON matriculas_planos.codigo_matricula = matriculas.codigo"
            + " INNER JOIN alunos ON matriculas.id_aluno = alunos.codigo"
            + " INNER JOIN planos ON matriculas_planos.codigo_plano = planos.codigo"
            + " INNER JOIN graduacoes ON planos.id_graduacao = graduacoes.codigo"
            + " INNER JOIN modalidades ON graduacoes.id_modalidade = modalidades.codigo"            
            + " WHERE matriculas.id_aluno = ?"
            + " ORDER BY matriculas_planos.data_inicio ASC";

    private PreparedStatement pstSelect;

    public MatriculaPlanoDAO(Connection connection) {
        if (connection != null) {
            try {
                this.connection = connection;
                pstSelect = this.connection.prepareStatement(selectInformacoesModalidadesPraticadasAndPlano);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Conexão inválida");
        }
    }

    public List<MatriculaPlano> buscaInformacoesModalidadesPraticadas(int codAluno) {
        List<MatriculaPlano> list = new ArrayList<>();

        try {
            pstSelect.setInt(1, codAluno);
            ResultSet resultado = pstSelect.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (resultado.next()) {
                
                Aluno aluno = new Aluno();                
                aluno.setNome(resultado.getString("nomeAluno"));
                
                Matricula matricula = new Matricula();
                matricula.setCodigo(resultado.getInt("codMatricula"));
                matricula.setAluno(aluno);
                matricula.setDataMatricula(resultado.getDate("dataMatricula"));
                matricula.setDataEncerramento(resultado.getDate("data_encerramento"));
                Modalidade modalidade = new Modalidade();
                modalidade.setNome(resultado.getString("modalidade"));

                Graduacao graduacao = new Graduacao();
                graduacao.setNome(resultado.getString("graduacao"));
                graduacao.setModalidade(modalidade);

                Plano plano = new Plano();
                plano.setDescricao(resultado.getString("plano"));
                plano.setGraduacao(graduacao);
                MatriculaPlano matriculaPlano = new MatriculaPlano();
                matriculaPlano.setMatricula(matricula);
                matriculaPlano.setPlano(plano);
                matriculaPlano.setDataInicio(resultado.getDate("dataInicio"));
                
                list.add(matriculaPlano);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
