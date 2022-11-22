/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.brasil.catracaacademia.graphic;

import com.brasil.catracaacademia.controller.ControllerMain;
import com.estruturadados.catracaacademia.database.model.Aluno;
import com.estruturadados.catracaacademia.database.model.Assiduidade;
import com.estruturadados.catracaacademia.database.model.Fatura;
import com.estruturadados.catracaacademia.database.model.MatriculaPlano;
import com.estruturadadosdois.catracaacademia.database.ConnectionFactory;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private Connection connection = null;
    private ControllerMain controllerMain;
    private Aluno aluno;
    private List<MatriculaPlano> listaMatriculaPlanos;
    private List<Fatura> listaFaturas;
    private List<Assiduidade> listaAssiduidades;
    private DefaultTableModel table;

    public Main() {
        initComponents();

        jTextFieldCodigoAluno.requestFocus();
        listaMatriculaPlanos = new ArrayList<>();
        listaFaturas = new ArrayList<>();
        listaAssiduidades = new ArrayList<>();
        jLabelSituacaoAluno.setText("Situação");
        try {
            connection = ConnectionFactory.getConnection("localhost", "5432", "catraca_academia", "postgres", "mananger");
            controllerMain = new ControllerMain(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println(connection);
    }

    public void preencherTabelaModalidades() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        table = (DefaultTableModel) jTableInformacoesPlano.getModel();
        table.setRowCount(0);
        for (MatriculaPlano mp : listaMatriculaPlanos) {
            if (mp.getMatricula().getDataEncerramento() != null) {
                Object[] dados = {mp.getPlano().getGraduacao().getModalidade().getNome(), mp.getPlano().getGraduacao().getNome(), mp.getPlano().getDescricao(), sdf.format(mp.getDataInicio()), sdf.format(mp.getMatricula().getDataEncerramento())};
                table.addRow(dados);
            } else {
                Object[] dados = {mp.getPlano().getGraduacao().getModalidade().getNome(), mp.getPlano().getGraduacao().getNome(), mp.getPlano().getDescricao(), sdf.format(mp.getDataInicio())};
                table.addRow(dados);
            }
        }
    }

    public void preencherTabelaFaturas() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        table = (DefaultTableModel) jTableDadosFatura.getModel();
        table.setRowCount(0);

        Date hoje = new Date();

        for (int i = 0; i < listaFaturas.size(); i++) {
            if (listaFaturas.get(i).getPagamento() == null && listaFaturas.get(i).getMatricula().getDataEncerramento() == null) {
                Object[] dados = {sdf.format(listaFaturas.get(i).getVencimento()), listaFaturas.get(i).getValor()};
                table.addRow(dados);
            } else if (listaFaturas.get(i).getMatricula().getDataEncerramento() == null) {
                Object[] dados = {sdf.format(listaFaturas.get(i).getVencimento()), listaFaturas.get(i).getValor(), sdf.format(listaFaturas.get(i).getPagamento())};
                table.addRow(dados);
            } else {
                Object[] dados = {sdf.format(listaFaturas.get(i).getVencimento()), listaFaturas.get(i).getValor(), sdf.format(listaFaturas.get(i).getPagamento()), sdf.format(listaFaturas.get(i).getMatricula().getDataEncerramento())};
                table.addRow(dados);
            }
        }

    }

    public void preencherAssiduidade() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        table = (DefaultTableModel) jTableAssiduidades.getModel();
        table.setRowCount(0);
        for (Assiduidade a : listaAssiduidades) {
            Object[] dados = {sdf.format(a.getData())};
            table.addRow(dados);
        }
    }

    public void preencherSituacao() {
        for (Fatura f : listaFaturas) {
            if (new Date().compareTo(f.getVencimento()) > 0 && f.getPagamento() == null) {
                jLabelSituacaoAluno.setText("Pendências em aberto");
                jPanelSituacaoAluno.setBackground(Color.red);
                return;
            }
            jLabelSituacaoAluno.setText("Sem pendências");
            jPanelSituacaoAluno.setBackground(Color.GREEN);
            return;

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPaneMain = new javax.swing.JDesktopPane();
        jPanelFotoAluno = new javax.swing.JPanel();
        jTextFieldCodigoAluno = new javax.swing.JTextField();
        jTextFieldNomeAluno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInformacoesPlano = new javax.swing.JTable();
        jPanelSituacaoAluno = new javax.swing.JPanel();
        jLabelSituacaoAluno = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAssiduidades = new javax.swing.JTable();
        jButtonAcessarDadosAluno = new javax.swing.JButton();
        jButtonAcessarDadosMatricula = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDadosFatura = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jDesktopPaneMain.setBackground(new java.awt.Color(153, 153, 153));
        jDesktopPaneMain.setForeground(new java.awt.Color(153, 153, 153));

        jPanelFotoAluno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelFotoAlunoLayout = new javax.swing.GroupLayout(jPanelFotoAluno);
        jPanelFotoAluno.setLayout(jPanelFotoAlunoLayout);
        jPanelFotoAlunoLayout.setHorizontalGroup(
            jPanelFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );
        jPanelFotoAlunoLayout.setVerticalGroup(
            jPanelFotoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextFieldCodigoAluno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldCodigoAlunoFocusLost(evt);
            }
        });
        jTextFieldCodigoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoAlunoActionPerformed(evt);
            }
        });

        jTextFieldNomeAluno.setEditable(false);

        jTableInformacoesPlano.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modalidade", "Graduação", "Plano", "Data Ínicio", "Data Fim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableInformacoesPlano);
        if (jTableInformacoesPlano.getColumnModel().getColumnCount() > 0) {
            jTableInformacoesPlano.getColumnModel().getColumn(0).setMinWidth(100);
            jTableInformacoesPlano.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanelSituacaoAluno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelSituacaoAluno.setForeground(new java.awt.Color(51, 255, 0));

        jLabelSituacaoAluno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSituacaoAluno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSituacaoAluno.setText("Situação");

        javax.swing.GroupLayout jPanelSituacaoAlunoLayout = new javax.swing.GroupLayout(jPanelSituacaoAluno);
        jPanelSituacaoAluno.setLayout(jPanelSituacaoAlunoLayout);
        jPanelSituacaoAlunoLayout.setHorizontalGroup(
            jPanelSituacaoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSituacaoAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelSituacaoAlunoLayout.setVerticalGroup(
            jPanelSituacaoAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSituacaoAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jTableAssiduidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assiduidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableAssiduidades);
        if (jTableAssiduidades.getColumnModel().getColumnCount() > 0) {
            jTableAssiduidades.getColumnModel().getColumn(0).setResizable(false);
        }

        jButtonAcessarDadosAluno.setText("Acessar dados do aluno");
        jButtonAcessarDadosAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarDadosAlunoActionPerformed(evt);
            }
        });

        jButtonAcessarDadosMatricula.setText("Acessar dados da Matrícula");
        jButtonAcessarDadosMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarDadosMatriculaActionPerformed(evt);
            }
        });

        jTableDadosFatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vencimento", "Valor", "Pagamento", "Cancelamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDadosFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDadosFaturaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDadosFatura);
        if (jTableDadosFatura.getColumnModel().getColumnCount() > 0) {
            jTableDadosFatura.getColumnModel().getColumn(0).setResizable(false);
            jTableDadosFatura.getColumnModel().getColumn(1).setResizable(false);
            jTableDadosFatura.getColumnModel().getColumn(2).setResizable(false);
            jTableDadosFatura.getColumnModel().getColumn(3).setResizable(false);
        }

        jDesktopPaneMain.setLayer(jPanelFotoAluno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jTextFieldCodigoAluno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jTextFieldNomeAluno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jPanelSituacaoAluno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jButtonAcessarDadosAluno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jButtonAcessarDadosMatricula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneMain.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneMainLayout = new javax.swing.GroupLayout(jDesktopPaneMain);
        jDesktopPaneMain.setLayout(jDesktopPaneMainLayout);
        jDesktopPaneMainLayout.setHorizontalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                        .addComponent(jPanelFotoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                                .addComponent(jTextFieldCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeAluno))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                            .addComponent(jPanelSituacaoAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                                .addComponent(jButtonAcessarDadosAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAcessarDadosMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jDesktopPaneMainLayout.setVerticalGroup(
            jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPaneMainLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelSituacaoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelFotoAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcessarDadosAluno)
                    .addComponent(jButtonAcessarDadosMatricula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPaneMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPaneMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodigoAlunoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCodigoAlunoFocusLost
        jTextFieldCodigoAluno.requestFocus();
    }//GEN-LAST:event_jTextFieldCodigoAlunoFocusLost

    private void jTextFieldCodigoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoAlunoActionPerformed
        if (!jTextFieldCodigoAluno.getText().isBlank()) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            aluno = new Aluno();
            aluno.setCodigo(Integer.parseInt(jTextFieldCodigoAluno.getText()));

            controllerMain.buscarAluno(aluno);
            jTextFieldNomeAluno.setText(aluno.getNome());
            
            //pra não duplicar os dados
            if (listaMatriculaPlanos != null) {
                listaMatriculaPlanos.clear();
            }
            controllerMain.buscarModalidadesAluno(aluno.getCodigo(), listaMatriculaPlanos);

            if (listaMatriculaPlanos != null) {
                preencherTabelaModalidades();

            }
            if (listaFaturas != null) {
                listaFaturas.clear();
            }
            controllerMain.buscarFaturasAluno(listaFaturas, aluno.getCodigo());
            preencherTabelaFaturas();

            if (listaAssiduidades != null) {
                listaAssiduidades.clear();
            }
            controllerMain.buscarAssiduidade(listaMatriculaPlanos.get(0).getMatricula().getCodigo(), listaAssiduidades);
            preencherAssiduidade();
            preencherSituacao();
        }
    }//GEN-LAST:event_jTextFieldCodigoAlunoActionPerformed

    private void jButtonAcessarDadosAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarDadosAlunoActionPerformed
        // TODO add your handling code here:
        if (jTextFieldCodigoAluno.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor informe o código do aluno.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DadosAlunoView tela = new DadosAlunoView(aluno);
        jDesktopPaneMain.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonAcessarDadosAlunoActionPerformed

    private void jButtonAcessarDadosMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarDadosMatriculaActionPerformed
        // TODO add your handling code here:
        DadosMatriculaModalidadeView tela = new DadosMatriculaModalidadeView(listaMatriculaPlanos);
        jDesktopPaneMain.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonAcessarDadosMatriculaActionPerformed

    private void jTableDadosFaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDadosFaturaMouseClicked
        // TODO add your handling code here:
        table = (DefaultTableModel) jTableDadosFatura.getModel();
        if(table.getValueAt(jTableDadosFatura.getSelectedRow(), 2) != null){
            JOptionPane.showMessageDialog(null, "Fatura já possuí data de pagamento.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            int mensagem = JOptionPane.showConfirmDialog(null, "Deseja pagar a fatura?", "Fatura", JOptionPane.YES_NO_OPTION);
            if(mensagem == JOptionPane.YES_OPTION){
                //faz o update com a data de hoje na fatura
            }
        
        }
    }//GEN-LAST:event_jTableDadosFaturaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessarDadosAluno;
    private javax.swing.JButton jButtonAcessarDadosMatricula;
    private javax.swing.JDesktopPane jDesktopPaneMain;
    private javax.swing.JLabel jLabelSituacaoAluno;
    private javax.swing.JPanel jPanelFotoAluno;
    private javax.swing.JPanel jPanelSituacaoAluno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAssiduidades;
    private javax.swing.JTable jTableDadosFatura;
    private javax.swing.JTable jTableInformacoesPlano;
    private javax.swing.JTextField jTextFieldCodigoAluno;
    private javax.swing.JTextField jTextFieldNomeAluno;
    // End of variables declaration//GEN-END:variables
}
