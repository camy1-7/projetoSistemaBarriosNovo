/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import bean.ClbProduto;
import dao.ProdutoDAO;
import java.util.List;
import tools.Util;

/**
 *
 * @author DELL
 */
public class JDlgProduto extends javax.swing.JDialog {

    /**
     * Creates new form JDlgProdutoNovo
     */
    ProdutoDAO produtoDAO;
    ClbProduto clbProduto;
    ProdutoController produtoController;
    JDlgProdutoIA jDlgProdutoIA;
    
    public JDlgProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Tabela de Produtos");
        setLocationRelativeTo(null);
        
        jDlgProdutoIA = new JDlgProdutoIA(null, true);
        produtoController = new ProdutoController();
        produtoDAO = new ProdutoDAO();
        List lista = produtoDAO.listAll();
        produtoController.setList(lista);
        jTable1.setModel(produtoController);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtnClb_Incluir = new javax.swing.JButton();
        jBtnClb_Alterar = new javax.swing.JButton();
        jBtnClb_Excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnClb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnClb_Incluir.setText("Incluir");
        jBtnClb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_IncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnClb_Incluir);

        jBtnClb_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnClb_Alterar.setText("Alterar");
        jBtnClb_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_AlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnClb_Alterar);

        jBtnClb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnClb_Excluir.setText("Excluir");
        jBtnClb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnClb_Excluir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnClb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_IncluirActionPerformed
        // TODO add your handling code here:
        //criando a tela de ProdutoIA
        jDlgProdutoIA.setTitle("Inclusão");
        jDlgProdutoIA.setVisible(true);
        //atualizar a lista no jtable
        List lista = produtoDAO.listAll();
        produtoController.setList(lista);
    }//GEN-LAST:event_jBtnClb_IncluirActionPerformed

    private void jBtnClb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_AlterarActionPerformed
        // TODO add your handling code here:
        //criando a tela de ProdutoIA
        jDlgProdutoIA.setTitle("Alteração");
        jDlgProdutoIA.setVisible(true);
    }//GEN-LAST:event_jBtnClb_AlterarActionPerformed

    private void jBtnClb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ExcluirActionPerformed
        // TODO add your handling code here:
        //trás o método perguntar do UTIL para o botão excluir. 
        if (Util.perguntar("Deseja excluir o registro?") == true) {
            int sel = jTable1.getSelectedRow();
            clbProduto = produtoController.getBean(sel);
            produtoDAO.delete(clbProduto);
            //atualizar a lista no jtable
            List lista = produtoDAO.listAll();
            produtoController.setList(lista);
        } else {
            Util.mensagem("Exclusão cancelada.");
        }
    }//GEN-LAST:event_jBtnClb_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProduto dialog = new JDlgProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnClb_Alterar;
    private javax.swing.JButton jBtnClb_Excluir;
    private javax.swing.JButton jBtnClb_Incluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
