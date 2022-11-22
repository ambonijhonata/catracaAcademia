/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estruturadadosdois.catracaacademia.database.dao;

import com.estruturadados.catracaacademia.database.model.Assiduidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author User
 */
public class AssiduidadeDAO {

    private Connection connection;

    private String select = "SELECT data FROM assiduidade "
            + "WHERE id_matricula = ? "
            + "ORDER BY data DESC";
    private PreparedStatement pstSelect;

    public AssiduidadeDAO(Connection connection) {
        this.connection = connection;
        try {
            pstSelect = this.connection.prepareStatement(select);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void buscarAssiduidades(int idMatricula, List<Assiduidade> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            pstSelect.setInt(1, idMatricula);
            ResultSet resultado = pstSelect.executeQuery();
            while (resultado.next()) {
                Assiduidade a = new Assiduidade();
                a.setData(resultado.getDate("data"));
                list.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
