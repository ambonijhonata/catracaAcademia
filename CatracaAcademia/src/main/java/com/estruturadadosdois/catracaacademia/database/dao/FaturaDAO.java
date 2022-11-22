/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadadosdois.catracaacademia.database.dao;

import com.estruturadados.catracaacademia.database.model.Fatura;
import com.estruturadados.catracaacademia.database.model.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class FaturaDAO {

    private Connection connection;

    private String selectFatura = "SELECT faturas.codigo AS codFatura, id_matricula, data_vencimento, data_pagamento, valor, "
            + "matriculas.data_encerramento "
            + "FROM public.faturas "
            + "INNER JOIN matriculas ON id_matricula = matriculas.codigo "
            + "WHERE id_matricula = (SELECT matriculas.codigo FROM matriculas WHERE id_aluno = ?) "
            + "ORDER BY data_vencimento ASC";
    private String updatePagarFatura = "UPDATE faturas SET data_pagamento = ? WHERE id_matricula = ? AND data_vencimento = ? ";
    private PreparedStatement pstSelectFatura;
    private PreparedStatement pstUpdatePagarFatura;
    
    public FaturaDAO(Connection connection) {
        try {
            if (connection != null) {
                this.connection = connection;
                pstSelectFatura = this.connection.prepareStatement(selectFatura);
                pstUpdatePagarFatura = this.connection.prepareStatement(updatePagarFatura);
            } else {
                System.out.println("conexão inválida");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void buscarFaturas(List<Fatura> list, int idAluno) {
        try {
            pstSelectFatura.setInt(1, idAluno);
            ResultSet resultado = pstSelectFatura.executeQuery();
            
            while (resultado.next()) {
                Fatura fatura = new Fatura();
                fatura.setCodigo(resultado.getInt("codFatura"));
                fatura.setVencimento(resultado.getDate("data_vencimento"));
                fatura.setPagamento(resultado.getDate("data_pagamento"));
                fatura.setValor(resultado.getDouble("valor"));

                Matricula matricula = new Matricula();
                matricula.setCodigo(resultado.getInt("id_matricula"));
                matricula.setDataEncerramento(resultado.getDate("data_encerramento"));

                fatura.setMatricula(matricula);
                list.add(fatura);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
