/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadadosdois.catracaacademia.database.dao;

import com.estruturadados.catracaacademia.database.model.Aluno;
import com.estruturadados.catracaacademia.database.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class AlunoDAO {

    private Connection connection;
    private String selectCondicaoCodigoAluno = "SELECT alunos.codigo AS codAluno, alunos.nome AS nomeALuno, alunos.cpf AS cpf," +
                                                " alunos.data_nascimento AS dataNascimento, alunos.contato AS contato, cidades.codigo AS codCidade," +
                                                " cidades.nome AS cidade FROM alunos" +
                                                " INNER JOIN cidades ON alunos.id_cidade = cidades.codigo" +
                                                " WHERE alunos.codigo = ?" +
                                                " ORDER BY alunos.codigo ASC;";
    private PreparedStatement pstSelectCondicaoCodigoAluno;

    public AlunoDAO(Connection connection) {
        try {
            if (connection != null) {
                this.connection = connection;
                pstSelectCondicaoCodigoAluno = this.connection.prepareStatement(selectCondicaoCodigoAluno);
            } else {
                System.out.println("Conexão inválida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Aluno buscarAluno(Aluno aluno) {
        
        try {
            pstSelectCondicaoCodigoAluno.setInt(1, aluno.getCodigo());
            ResultSet resultado = pstSelectCondicaoCodigoAluno.executeQuery();

            if (resultado.next()) {
                aluno.setCodigo(resultado.getInt("codAluno"));
                aluno.setNome(resultado.getString("nomeALuno"));
                aluno.setCpf(resultado.getString("cpf"));
                aluno.setData_nascimento(resultado.getDate("dataNascimento"));
                aluno.setContato(resultado.getString("contato"));
                
                Cidade cidade = new Cidade();
                cidade.setCodigo(resultado.getInt("codCidade"));
                cidade.setNome(resultado.getString("cidade"));
                aluno.setCidade(cidade);                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return aluno;
    }
}
