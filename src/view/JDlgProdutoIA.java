/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbProduto;
import dao.ProdutoDAO;
import java.awt.Color;
import tools.Util;

/**
 *
 * @author DELL
 */
public class JDlgProdutoIA extends javax.swing.JDialog {

    ProdutoDAO produtoDAO;
    ClbProduto clbProduto;
    
    
    /**
     * Creates new form JDlgProdutoNovoIA
     */
    public JDlgProdutoIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Incluisão ou Alteração");//o titulo muda de acordo com o botão que seja escolhido na tela de UsuariosNovo
        setLocationRelativeTo(null);
        produtoDAO = new ProdutoDAO();
    }
    
    public ClbProduto viewBean(){
        clbProduto = new ClbProduto(); //cria o bean 
        
        //pega oq esta na tela e joga para o bean
        int id = Integer.valueOf(jTxtClb_IdProduto.getText());
        clbProduto.setClbIdproduto(id);
        clbProduto.setClbNomeProduto(jTxtClb_Nome.getText());
        clbProduto.setClbAutor(jTxtClb_Autor.getText());
        clbProduto.setClbEditora(jTxtClb_Editora.getText());
        clbProduto.setClbPreco(Double.parseDouble( jTxtClb_Preco.getText())); 
        clbProduto.setClbAssunto(jTxtClb_Assunto.getText());
        
        
        return clbProduto; 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtClb_Autor = new javax.swing.JTextField();
        jTxtClb_Editora = new javax.swing.JTextField();
        jTxtClb_Preco = new javax.swing.JTextField();
        jTxtClb_Assunto = new javax.swing.JTextField();
        jTxtClb_Nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtClb_IdProduto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBtnClb_Confirmar = new javax.swing.JButton();
        jBtnClb_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTxtClb_Autor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_AutorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_AutorFocusLost(evt);
            }
        });

        jTxtClb_Editora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_EditoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_EditoraFocusLost(evt);
            }
        });
        jTxtClb_Editora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_EditoraActionPerformed(evt);
            }
        });

        jTxtClb_Preco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_PrecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_PrecoFocusLost(evt);
            }
        });

        jTxtClb_Assunto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_AssuntoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_AssuntoFocusLost(evt);
            }
        });

        jTxtClb_Nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_NomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_NomeFocusLost(evt);
            }
        });
        jTxtClb_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_NomeActionPerformed(evt);
            }
        });

        jLabel1.setText("Dados do Produto:");

        jLabel2.setText("Id_Produto:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Editora:");

        jLabel5.setText("Preço:");

        jLabel6.setText("Autor:");

        jLabel7.setText("Assunto/Gênero:");

        jTxtClb_IdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_IdProdutoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_IdProdutoFocusLost(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtnClb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnClb_Confirmar.setText("Confirmar");
        jBtnClb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnClb_Confirmar);

        jBtnClb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnClb_Cancelar.setText("Cancelar");
        jBtnClb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnClb_Cancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTxtClb_IdProduto)
                                        .addComponent(jTxtClb_Autor)
                                        .addComponent(jTxtClb_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(77, 77, 77)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(77, 77, 77)
                                            .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(78, 78, 78)
                                            .addComponent(jTxtClb_Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(295, 295, 295)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jTxtClb_Editora, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)))))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_IdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_Autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtClb_AutorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_AutorFocusGained
        // TODO add your handling code here:
        jTxtClb_Autor.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_AutorFocusGained

    private void jTxtClb_AutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_AutorFocusLost
        // TODO add your handling code here:
        jTxtClb_Autor.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_AutorFocusLost

    private void jTxtClb_EditoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EditoraFocusGained
        // TODO add your handling code here:
        jTxtClb_Editora.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_EditoraFocusGained

    private void jTxtClb_EditoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EditoraFocusLost
        // TODO add your handling code here:
        jTxtClb_Editora.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_EditoraFocusLost

    private void jTxtClb_EditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_EditoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_EditoraActionPerformed

    private void jTxtClb_PrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_PrecoFocusGained
        // TODO add your handling code here:
        jTxtClb_Preco.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_PrecoFocusGained

    private void jTxtClb_PrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_PrecoFocusLost
        // TODO add your handling code here:
        jTxtClb_Preco.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_PrecoFocusLost

    private void jTxtClb_AssuntoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_AssuntoFocusGained
        // TODO add your handling code here:
        jTxtClb_Assunto.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_AssuntoFocusGained

    private void jTxtClb_AssuntoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_AssuntoFocusLost
        // TODO add your handling code here:
        jTxtClb_Assunto.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_AssuntoFocusLost

    private void jTxtClb_NomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusGained
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_NomeFocusGained

    private void jTxtClb_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusLost
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_NomeFocusLost

    private void jTxtClb_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_NomeActionPerformed

    private void jTxtClb_IdProdutoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdProdutoFocusGained
        // TODO add your handling code here:
        jTxtClb_IdProduto.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_IdProdutoFocusGained

    private void jTxtClb_IdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdProdutoFocusLost
        // TODO add your handling code here:
        jTxtClb_IdProduto.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_IdProdutoFocusLost

    private void jBtnClb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_CancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnClb_CancelarActionPerformed

    private void jBtnClb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ConfirmarActionPerformed
        // TODO add your handling code here:
        clbProduto = viewBean();
        produtoDAO.insert(clbProduto);
        setVisible(false);
    }//GEN-LAST:event_jBtnClb_ConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProdutoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProdutoIA dialog = new JDlgProdutoIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnClb_Cancelar;
    private javax.swing.JButton jBtnClb_Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtClb_Assunto;
    private javax.swing.JTextField jTxtClb_Autor;
    private javax.swing.JTextField jTxtClb_Editora;
    private javax.swing.JTextField jTxtClb_IdProduto;
    private javax.swing.JTextField jTxtClb_Nome;
    private javax.swing.JTextField jTxtClb_Preco;
    // End of variables declaration//GEN-END:variables
}
