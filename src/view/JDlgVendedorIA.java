/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbProduto;
import bean.ClbVendedor;
import dao.ProdutoDAO;
import dao.VendedorDAO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author DELL
 */
public class JDlgVendedorIA extends javax.swing.JDialog {

    public boolean incluindo;
    public JDlgVendedor jDlgVendedor;
    
    VendedorDAO vendedorDAO;
    ClbVendedor clbVendedor;
    VendedorController vendedorController;
    
    MaskFormatter mascaraCpf; // declarei um objeto -- mascara do cpf ja adicionei a importação
    MaskFormatter mascaraDataNascimento;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraRg;
    /**
     * Creates new form JDlgVendedorNovoIA
     */
    public JDlgVendedorIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Incluisão ou Alteração");//o titulo muda de acordo com o botão que seja escolhido na tela de UsuariosNovo
        setLocationRelativeTo(null);
        
        vendedorDAO = new VendedorDAO();
        vendedorController = new VendedorController();
        
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            mascaraRg = new MaskFormatter("#.###.###");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
       jFmtClb_Cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf)); //instancia a mascara e passou a mascara pro campo
       jFmtClb_Nascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
       jFmtClb_Telefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
       jFmtClb_Rg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
    }
    
    public void setTelaAnterior(JDlgVendedor jDlgVendedor){
        this.jDlgVendedor = jDlgVendedor;
    }
    
    public ClbVendedor viewBean(){
        clbVendedor = new ClbVendedor(); //cria o bean 
        
        //pega oq esta na tela e joga para o bean
        int id = Integer.valueOf(jTxtClb_IdVendedor.getText());
        clbVendedor.setClbIdvendedor(id);
        clbVendedor.setClbNomeVendedor(jTxtClb_Nome.getText());
        clbVendedor.setClbEmail(jTxtClb_Email.getText());
        clbVendedor.setClbCpf(jFmtClb_Cpf.getText());
        clbVendedor.setClbRg(jFmtClb_Rg.getText());
        //string para data 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // cria o objeto que vai transformar a string para data
        try {
            clbVendedor.setClbDataNascimento(formato.parse(jFmtClb_Nascimento.getText())); //utiliza o metodo parse -> que faz a transformação
        } catch (ParseException ex) {
            //Logger.getLogger(JDlgVendedor.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!"+ex.getMessage());
        }
        clbVendedor.setClbSalario(Double.parseDouble( jTxtClb_Salario.getText()));
        clbVendedor.setClbSexo(jCboClb_Sexo.getSelectedIndex());
        clbVendedor.setClbTelefone(jFmtClb_Telefone.getText());
     
        
        return clbVendedor; 
    }
    
    public void beanView(ClbVendedor clbVendedor){//pega do bean e joga na tela -- o parametro é o bean
        //mostrar na tela os dados
        String valor = String.valueOf(clbVendedor.getClbIdvendedor()); //converter inteiro para string por causa do Text -- a string valor recebe o valor do inteiro
        jTxtClb_IdVendedor.setText(valor); 
        jTxtClb_Nome.setText(clbVendedor.getClbNomeVendedor());
        jFmtClb_Telefone.setText(clbVendedor.getClbTelefone());
        jFmtClb_Cpf.setText(clbVendedor.getClbCpf());
        jFmtClb_Rg.setText(clbVendedor.getClbRg());
        jTxtClb_Email.setText(clbVendedor.getClbEmail());
        jCboClb_Sexo.setSelectedIndex(clbVendedor.getClbSexo());
        
        //data para string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //cria o método e utiliza ele no campo do bean que vai ser retornado na tela
        jFmtClb_Nascimento.setText(formato.format(clbVendedor.getClbDataNascimento())); //cria o metodo format que faz a conversão
        jTxtClb_Salario.setText(String.valueOf(clbVendedor.getClbSalario()));
        
        //quando o for pegar os beans e jogar na tela, ele chama o listProduto e manda para a tabela todos os dados tambem
        vendedorDAO = new VendedorDAO();
        List listaProd = (List) vendedorDAO.listAll();
        vendedorController.setList(listaProd);
        
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFmtClb_Telefone = new javax.swing.JFormattedTextField();
        jCboClb_Sexo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTxtClb_IdVendedor = new javax.swing.JTextField();
        jTxtClb_Nome = new javax.swing.JTextField();
        jFmtClb_Nascimento = new javax.swing.JFormattedTextField();
        jFmtClb_Cpf = new javax.swing.JFormattedTextField();
        jFmtClb_Rg = new javax.swing.JFormattedTextField();
        jTxtClb_Email = new javax.swing.JTextField();
        jTxtClb_Salario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jBtnClb_Confirmar = new javax.swing.JButton();
        jBtnClb_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jFmtClb_Telefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_TelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_TelefoneFocusLost(evt);
            }
        });

        jCboClb_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));

        jLabel1.setText("Dados Pessoais: ");

        jLabel2.setText("Id_Vendedor:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Sexo:");

        jLabel5.setText("Telefone");

        jLabel6.setText("Email:");

        jLabel7.setText("Data de Nascimento:");

        jLabel8.setText("Salário:");

        jLabel9.setText("CPF:");

        jLabel10.setText("RG:");

        jTxtClb_IdVendedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_IdVendedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_IdVendedorFocusLost(evt);
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

        jFmtClb_Nascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_NascimentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_NascimentoFocusLost(evt);
            }
        });
        jFmtClb_Nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtClb_NascimentoActionPerformed(evt);
            }
        });

        jFmtClb_Cpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_CpfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_CpfFocusLost(evt);
            }
        });

        jFmtClb_Rg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_RgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_RgFocusLost(evt);
            }
        });

        jTxtClb_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_EmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_EmailFocusLost(evt);
            }
        });

        jTxtClb_Salario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_SalarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_SalarioFocusLost(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtClb_IdVendedor)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jFmtClb_Cpf)
                                    .addComponent(jLabel8)
                                    .addComponent(jTxtClb_Salario)
                                    .addComponent(jFmtClb_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtClb_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCboClb_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTxtClb_Email, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addGap(222, 222, 222)
                                                        .addComponent(jLabel4))
                                                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(170, 170, 170))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel3))))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_IdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtClb_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtClb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtClb_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtClb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtClb_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jCboClb_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFmtClb_TelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_TelefoneFocusGained
        // TODO add your handling code here:
        jFmtClb_Telefone.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_TelefoneFocusGained

    private void jFmtClb_TelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_TelefoneFocusLost
        // TODO add your handling code here:
        jFmtClb_Telefone.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_TelefoneFocusLost

    private void jTxtClb_IdVendedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdVendedorFocusGained
        // TODO add your handling code here:
        jTxtClb_IdVendedor.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_IdVendedorFocusGained

    private void jTxtClb_IdVendedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdVendedorFocusLost
        // TODO add your handling code here:
        jTxtClb_IdVendedor.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_IdVendedorFocusLost

    private void jTxtClb_NomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusGained
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_NomeFocusGained

    private void jTxtClb_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusLost
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_NomeFocusLost

    private void jTxtClb_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_NomeActionPerformed

    private void jFmtClb_NascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusGained
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusGained

    private void jFmtClb_NascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusLost
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusLost

    private void jFmtClb_NascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_NascimentoActionPerformed

    private void jFmtClb_CpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CpfFocusGained
        // TODO add your handling code here:
        jFmtClb_Cpf.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_CpfFocusGained

    private void jFmtClb_CpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CpfFocusLost
        // TODO add your handling code here:
        jFmtClb_Cpf.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_CpfFocusLost

    private void jFmtClb_RgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_RgFocusGained
        // TODO add your handling code here:
        jFmtClb_Rg.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_RgFocusGained

    private void jFmtClb_RgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_RgFocusLost
        // TODO add your handling code here:
        jFmtClb_Rg.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_RgFocusLost

    private void jTxtClb_EmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EmailFocusGained
        // TODO add your handling code here:
        jTxtClb_Email.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_EmailFocusGained

    private void jTxtClb_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EmailFocusLost
        // TODO add your handling code here:
        jTxtClb_Email.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_EmailFocusLost

    private void jTxtClb_SalarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_SalarioFocusGained
        // TODO add your handling code here:
        jTxtClb_Salario.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_SalarioFocusGained

    private void jTxtClb_SalarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_SalarioFocusLost
        // TODO add your handling code here:
        jTxtClb_Salario.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_SalarioFocusLost

    private void jBtnClb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ConfirmarActionPerformed
        // TODO add your handling code here:
        clbVendedor = new ClbVendedor();
        clbVendedor.setClbIdvendedor(Util.strInt(jTxtClb_IdVendedor.getText()));
        clbVendedor.setClbNomeVendedor(jTxtClb_Nome.getText());
        clbVendedor.setClbTelefone(jFmtClb_Telefone.getText());
        clbVendedor.setClbDataNascimento(Util.strDate(jFmtClb_Nascimento.getText()));
        clbVendedor.setClbCpf(jFmtClb_Cpf.getText());
        clbVendedor.setClbRg(jFmtClb_Rg.getText());
        clbVendedor.setClbSexo(jCboClb_Sexo.getSelectedIndex());
        clbVendedor.setClbSalario(Double.parseDouble(jTxtClb_Salario.getText()));
        clbVendedor.setClbEmail(jTxtClb_Email.getText());
        
        //Nesse if ele fara a verifcação do tipo de operação que a teça deve fazer sendo INCLUSÃO ou ALTERAÇÃO
        if(incluindo == true){
            //utitiliza os metodos de adicionar que criamos na tela Controller
            jDlgVendedor.vendedorController.addBean(clbVendedor);
            vendedorDAO.insert(clbVendedor); //salva a no0va inclusão no bd
            //atualizar a lista no jtable
            List lista = vendedorDAO.listAll();
            vendedorController.setList(lista);
            //Util.limparCampos(jTxtClb_IdVendedor, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Nascimento, jFmtClb_Cpf, jFmtClb_Rg, jTxtClb_Salario,jTxtClb_Email);
        }else{
            //utiliza o metodo alterar que criamos na tela controller, 
            //para isso pega a linha selecionada na tabela e substitui o bean
            vendedorDAO.delete(clbVendedor); //exclui tudo para poder fazer a alteração
            jDlgVendedor.vendedorController.updateBean(jDlgVendedor.getSelectedRowProd(), clbVendedor);
            vendedorDAO.insert(clbVendedor); //envia as novas alterações e salva no bd
            //atualizar a lista no jtable
            List lista = vendedorDAO.listAll();
            vendedorController.setList(lista);
            //Util.limparCampos(jTxtClb_IdVendedor, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Nascimento, jFmtClb_Cpf, jFmtClb_Rg, jTxtClb_Salario,jTxtClb_Email);
        }
        
        setVisible(false); //fecha a tela 
    }//GEN-LAST:event_jBtnClb_ConfirmarActionPerformed

    private void jBtnClb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_CancelarActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnClb_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVendedorIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendedorIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendedorIA dialog = new JDlgVendedorIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCboClb_Sexo;
    private javax.swing.JFormattedTextField jFmtClb_Cpf;
    private javax.swing.JFormattedTextField jFmtClb_Nascimento;
    private javax.swing.JFormattedTextField jFmtClb_Rg;
    private javax.swing.JFormattedTextField jFmtClb_Telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtClb_Email;
    private javax.swing.JTextField jTxtClb_IdVendedor;
    private javax.swing.JTextField jTxtClb_Nome;
    private javax.swing.JTextField jTxtClb_Salario;
    // End of variables declaration//GEN-END:variables
}
