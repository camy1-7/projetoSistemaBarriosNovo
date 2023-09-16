/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbUsuario;
import dao.UsuarioDAO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u07870835188
 */
public class JDlgUsuario extends javax.swing.JDialog {
    
    private boolean incluindo; //variavel tipo booleana, nome -> incluindo --- para poder usar em todos os lugares, declaramos ela como global
    MaskFormatter mascaraCpf; // declarei um objeto -- mascara do cpf ja adicionei a importação
    MaskFormatter mascaraDataNascimento;
    
    /**
     * Creates new form JDialogUsuario
     */
    public JDlgUsuario(java.awt.Frame parent, boolean modal) {
        //colocando titulo e deixando a pagina no meio
        super(parent, modal);
        initComponents();
        //desabilitar
        Util.habilitar(false, jTxtClb_Codigo, jTxtClb_Nome, jTxtClb_Apelido, jFmtClb_Cpf, jFmtClb_Nascimento, jPwfClb_Senha, jChbClb_Ativo, jCboClb_Nivel, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        setTitle("Cadastro de Usuários");
        setLocationRelativeTo(null);
        try {
            mascaraCpf  = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento  = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtClb_Cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf)); //instancia a mascara e passou a mascara pro campo
        jFmtClb_Nascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
    }
    
   /* //tira o metodo e manda para o Util
    public void habilitar(boolean valor, JComponent ... vetComponentes){
        for (int i = 0; i < vetComponentes.length; i++) { //cria um for para verificar o valor que contem no vetor, se vai ser true ou false
            vetComponentes[i].setEnabled(valor); //puxa o metodo setEnabled (que esta implementado na arvore de derivação (jComponent)) para poder atribuir o valor - que vai variar entre true e false dependendo do metodo onde for utilizado
            //utiliza o polimorfismo estático -> pq vc sabe da onde esta herdando de um lugar que vc sabe onde está
        }
    }*/
    
    /*public void habilitar(){
        // true para os campos e botoes que vao ter que aparecer e ser utilizados
        jTxtCodigo.setEnabled(true);
        jTxtNome.setEnabled(true);
        jTxtApelido.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jFmtNascimento.setEnabled(true);
        jPwfSenha.setEnabled(true);
        jCboNivel.setEnabled(true);
        jChbAtivo.setEnabled(true);
        
        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        
        // false para desabilitar os botoes que não precisam ser utilizados
        jBtnAlterar.setEnabled(false);
        jBtnIncluir.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnPesquisar.setEnabled(false);
    
    }
    
    public void desabilitar(){
        //desabilita os campos e botoes que não tem a necessidade de aparecer 
        jTxtCodigo.setEnabled(false);
        jTxtNome.setEnabled(false);
        jTxtApelido.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jFmtNascimento.setEnabled(false);
        jPwfSenha.setEnabled(false);
        jCboNivel.setEnabled(false);
        jChbAtivo.setEnabled(false);
        
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        
        //habilita os botoes que precisam aparecer para fazer uma funçao
        jBtnAlterar.setEnabled(true);
        jBtnIncluir.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
        
    }*/
    
    /*public void limparCampos(){
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jTxtApelido.setText("");
        jFmtCpf.setText("");
        jFmtNascimento.setText("");
        jPwfSenha.setText("");
        jCboNivel.setSelectedIndex(-1);
        jChbAtivo.setSelected(false);
    }*/
    
    public ClbUsuario viewBean(){
        ClbUsuario clbUsuario = new ClbUsuario(); //cria o bean 
        
        //pega oq esta na tela e joga para o bean
        int id = Integer.valueOf(jTxtClb_Codigo.getText());
        clbUsuario.setClbIdusuario(id);
        clbUsuario.setClbNomeUsuario(jTxtClb_Nome.getText());
        clbUsuario.setClbApelidoUsuario(jTxtClb_Apelido.getText());
        //string para data 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // cria o objeto que vai transformar a string para data
        try {
            clbUsuario.setClbDataNascimento(formato.parse(jFmtClb_Nascimento.getText())); //utiliza o metodo parse -> que faz a transformação
        } catch (ParseException ex) {
            //Logger.getLogger(JDlgUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!"+ex.getMessage());
        }
        clbUsuario.setClbCpf(jFmtClb_Cpf.getText());
        clbUsuario.setClbSenha(jPwfClb_Senha.getText());
        clbUsuario.setClbNivel(jCboClb_Nivel.getSelectedIndex());
        if(jChbClb_Ativo.isSelected() == true){ //pergunta se o campo ativo esta selecionado
            clbUsuario.setClbAtivo("S");
        }else{
            clbUsuario.setClbAtivo("N");
        }
        return clbUsuario; //
    }
    
    public void beanView(ClbUsuario clbUsuario){//pega do bean e joga na tela -- o parametro é o bean
        //mostrar na tela os dados
        String valor = String.valueOf(clbUsuario.getClbIdusuario()); //converter inteiro para string por causa do Text -- a string valor recebe o valor do inteiro
        jTxtClb_Codigo.setText(valor); 
        jTxtClb_Nome.setText(clbUsuario.getClbNomeUsuario());
        jTxtClb_Apelido.setText(clbUsuario.getClbApelidoUsuario());
        jFmtClb_Cpf.setText(clbUsuario.getClbCpf());
        //data para string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //cria o método e utiliza ele no campo do bean que vai ser retornado na tela
        jFmtClb_Nascimento.setText(formato.format(clbUsuario.getClbDataNascimento())); //cria o metodo format que faz a conversão 
        jPwfClb_Senha.setText(clbUsuario.getClbSenha());
        jCboClb_Nivel.setSelectedIndex(clbUsuario.getClbNivel());
        if(clbUsuario.getClbAtivo().equals("S") == true){ //se esta "S" significa que o ativo esta marcado
            jChbClb_Ativo.setSelected(true);
        }else{
            jChbClb_Ativo.setSelected(false);
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

        jLabel1 = new javax.swing.JLabel();
        jTxtClb_Codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtClb_Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtClb_Apelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnClb_Incluir = new javax.swing.JButton();
        jBtnClb_Alterar = new javax.swing.JButton();
        jBtnClb_Excluir = new javax.swing.JButton();
        jBtnClb_Confirmar = new javax.swing.JButton();
        jBtnClb_Cancelar = new javax.swing.JButton();
        jBtnClb_Pesquisar = new javax.swing.JButton();
        jCboClb_Nivel = new javax.swing.JComboBox<>();
        jPwfClb_Senha = new javax.swing.JPasswordField();
        jChbClb_Ativo = new javax.swing.JCheckBox();
        jFmtClb_Cpf = new javax.swing.JFormattedTextField();
        jFmtClb_Nascimento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código:");

        jTxtClb_Codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_CodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_CodigoFocusLost(evt);
            }
        });
        jTxtClb_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_CodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

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

        jLabel3.setText("Apelido:");

        jTxtClb_Apelido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_ApelidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_ApelidoFocusLost(evt);
            }
        });

        jLabel4.setText("CPF:");

        jLabel5.setText("Data de nascimento:");

        jLabel6.setText("Senha:");

        jLabel7.setText("Nível:");

        jBtnClb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnClb_Incluir.setText("Incluir");
        jBtnClb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_IncluirActionPerformed(evt);
            }
        });

        jBtnClb_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnClb_Alterar.setText("Alterar");
        jBtnClb_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_AlterarActionPerformed(evt);
            }
        });

        jBtnClb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnClb_Excluir.setText("Excluir");
        jBtnClb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ExcluirActionPerformed(evt);
            }
        });

        jBtnClb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnClb_Confirmar.setText("Confirmar");
        jBtnClb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ConfirmarActionPerformed(evt);
            }
        });

        jBtnClb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnClb_Cancelar.setText("Cancelar");
        jBtnClb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_CancelarActionPerformed(evt);
            }
        });

        jBtnClb_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnClb_Pesquisar.setText("Pesquisar");
        jBtnClb_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_PesquisarActionPerformed(evt);
            }
        });

        jCboClb_Nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Convidado", "Financeiro" }));
        jCboClb_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClb_NivelActionPerformed(evt);
            }
        });

        jPwfClb_Senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPwfClb_SenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPwfClb_SenhaFocusLost(evt);
            }
        });

        jChbClb_Ativo.setText("Ativo");
        jChbClb_Ativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbClb_AtivoActionPerformed(evt);
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
        jFmtClb_Cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtClb_CpfActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnClb_Incluir)
                                        .addGap(8, 8, 8)
                                        .addComponent(jBtnClb_Alterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnClb_Excluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnClb_Confirmar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnClb_Cancelar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(335, 335, 335)
                                        .addComponent(jCboClb_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jChbClb_Ativo)
                                    .addComponent(jBtnClb_Pesquisar))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtClb_Apelido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jFmtClb_Cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                    .addComponent(jPwfClb_Senha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addGap(142, 142, 142))
                                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTxtClb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtClb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtClb_Apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtClb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboClb_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPwfClb_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbClb_Ativo))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClb_Incluir)
                    .addComponent(jBtnClb_Alterar)
                    .addComponent(jBtnClb_Excluir)
                    .addComponent(jBtnClb_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnClb_Cancelar)
                    .addComponent(jBtnClb_Pesquisar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtClb_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_CodigoActionPerformed

    private void jTxtClb_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_NomeActionPerformed

    private void jBtnClb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_IncluirActionPerformed
        // TODO add your handling code here:
        //chamamos o habilitar para que os campos fiquem clicaveis quando selecionar incluir
        //habilitar();
        Util.habilitar(true, jTxtClb_Codigo, jTxtClb_Nome, jTxtClb_Apelido, jFmtClb_Cpf, jFmtClb_Nascimento, jPwfClb_Senha, jChbClb_Ativo, jCboClb_Nivel, jBtnClb_Confirmar, jBtnClb_Cancelar); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar); //desabilita os campos
        Util.limparCampos();
        incluindo = true; // quando clicar aqui o incluindo = true. 
    }//GEN-LAST:event_jBtnClb_IncluirActionPerformed

    private void jBtnClb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ConfirmarActionPerformed
        // TODO add your handling code here:
        //declarou um objeto do tipo Bean -> e o objeto recebe viewBean -> Bean recebe Bean
        /*ClbUsuario clbUsuario = viewBean();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        if(incluindo == true){
            usuarioDAO.insert(clbUsuario);
        }else{
            usuarioDAO.update(clbUsuario);
        }*/
        
        //desabilitar();
        Util.habilitar(false, jTxtClb_Codigo, jTxtClb_Nome, jTxtClb_Apelido, jFmtClb_Cpf, jFmtClb_Nascimento, jPwfClb_Senha, jChbClb_Ativo, jCboClb_Nivel, jBtnClb_Confirmar, jBtnClb_Cancelar); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar); //desabilita os campos
        Util.limparCampos();
        
    }//GEN-LAST:event_jBtnClb_ConfirmarActionPerformed

    private void jBtnClb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_CancelarActionPerformed
        // TODO add your handling code here:
        //desabilitar();
        Util.habilitar(false, jTxtClb_Codigo, jTxtClb_Nome, jTxtClb_Apelido, jFmtClb_Cpf, jFmtClb_Nascimento, jPwfClb_Senha, jChbClb_Ativo, jCboClb_Nivel, jBtnClb_Confirmar, jBtnClb_Cancelar); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar); //desabilita os campos
        Util.limparCampos();
    }//GEN-LAST:event_jBtnClb_CancelarActionPerformed

    private void jChbClb_AtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbClb_AtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChbClb_AtivoActionPerformed

    private void jFmtClb_CpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_CpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_CpfActionPerformed

    private void jFmtClb_NascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_NascimentoActionPerformed

    private void jBtnClb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_AlterarActionPerformed
        // TODO add your handling code here:
        //habilitar();
        Util.habilitar(true, jTxtClb_Codigo, jTxtClb_Nome, jTxtClb_Apelido, jFmtClb_Cpf, jFmtClb_Nascimento, jPwfClb_Senha, jChbClb_Ativo, jCboClb_Nivel, jBtnClb_Confirmar, jBtnClb_Cancelar); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar); //desabilita os campos
        incluindo = false; // quando clicar aqui o incluindo = true. 
    }//GEN-LAST:event_jBtnClb_AlterarActionPerformed

    private void jTxtClb_CodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_CodigoFocusGained
        // TODO add your handling code here:
        jTxtClb_Codigo.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_CodigoFocusGained

    private void jTxtClb_CodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_CodigoFocusLost
        // TODO add your handling code here:
        jTxtClb_Codigo.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_CodigoFocusLost

    private void jTxtClb_NomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusGained
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_NomeFocusGained

    private void jTxtClb_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusLost
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_NomeFocusLost

    private void jTxtClb_ApelidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_ApelidoFocusGained
        // TODO add your handling code here:
        jTxtClb_Apelido.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_ApelidoFocusGained

    private void jTxtClb_ApelidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_ApelidoFocusLost
        // TODO add your handling code here:
        jTxtClb_Apelido.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_ApelidoFocusLost

    private void jFmtClb_CpfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CpfFocusGained
        // TODO add your handling code here:
        jFmtClb_Cpf.setBackground(Color.lightGray);
    }//GEN-LAST:event_jFmtClb_CpfFocusGained

    private void jFmtClb_CpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CpfFocusLost
        // TODO add your handling code here:
        jFmtClb_Cpf.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_CpfFocusLost

    private void jFmtClb_NascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusGained
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.lightGray);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusGained

    private void jFmtClb_NascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusLost
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusLost

    private void jPwfClb_SenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwfClb_SenhaFocusGained
        // TODO add your handling code here:
        jPwfClb_Senha.setBackground(Color.lightGray);
    }//GEN-LAST:event_jPwfClb_SenhaFocusGained

    private void jPwfClb_SenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPwfClb_SenhaFocusLost
        // TODO add your handling code here:
        jPwfClb_Senha.setBackground(Color.WHITE);
    }//GEN-LAST:event_jPwfClb_SenhaFocusLost

    private void jCboClb_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClb_NivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClb_NivelActionPerformed

    private void jBtnClb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ExcluirActionPerformed
        // TODO add your handling code here:
        //sobrecarga 
        //mudar imagem e nome da tela -> MUDEI
        //resp = resposta
        //JOptionPane.YES_OPTION (0) -> se a opção for verdadeira
        /*
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION, 0); //yes.no.option -> pq queremos somente os botoes de sim e não
        if (resp == JOptionPane.YES_OPTION){
        //pega da tela, joga para o bean, manda para o DAO e assim aciona o método DELETE
        ClbUsuario usuarios = viewBean(); //declarou um objeto do tipo Bean -> e o objeto recebe viewBean -> Bean recebe Bean
        UsuarioDAO usuarios_DAO = new UsuarioDAO(); //declarou o DAO
        usuarios_DAO.delete(usuarios); //pressiona o ctrl emcima do insert e ele abre onde esta o arquivo
        }else{
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Alerta", 2); //em ordem os parametros são: centraliza em relação a tela, menssagem, titulo e numero da imagem
        } */
        if(Util.perguntar("Deseja excluir o usuário?") == true){
            //fazer alguma coisa
        }
        Util.limparCampos();
    }//GEN-LAST:event_jBtnClb_ExcluirActionPerformed

    private void jBtnClb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_PesquisarActionPerformed
        // TODO add your handling code here:
        String resp = JOptionPane.showInputDialog(null, "Entre com o id ou código (PK)", "Tela de Pesquisa", 2);//retorna uma string
    }//GEN-LAST:event_jBtnClb_PesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuario dialog = new JDlgUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnClb_Cancelar;
    private javax.swing.JButton jBtnClb_Confirmar;
    private javax.swing.JButton jBtnClb_Excluir;
    private javax.swing.JButton jBtnClb_Incluir;
    private javax.swing.JButton jBtnClb_Pesquisar;
    private javax.swing.JComboBox<String> jCboClb_Nivel;
    private javax.swing.JCheckBox jChbClb_Ativo;
    private javax.swing.JFormattedTextField jFmtClb_Cpf;
    private javax.swing.JFormattedTextField jFmtClb_Nascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPwfClb_Senha;
    private javax.swing.JTextField jTxtClb_Apelido;
    private javax.swing.JTextField jTxtClb_Codigo;
    private javax.swing.JTextField jTxtClb_Nome;
    // End of variables declaration//GEN-END:variables
}
