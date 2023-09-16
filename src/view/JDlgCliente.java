/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbCliente;
import dao.ClienteDAO; //Mudar
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author u07870835188
 */
public class JDlgCliente extends javax.swing.JDialog {

    private boolean incluindo;
    MaskFormatter mascaraCpf; // declarei um objeto -- mascara do cpf ja adicionei a importação
    MaskFormatter mascaraDataNascimento;
    MaskFormatter mascaraTelefone;
    MaskFormatter mascaraCep;
    MaskFormatter mascaraRg;
    
    /**
     * Creates new form JDlgCliente
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Cadastro de Cliente");
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdCliente, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Cpf, jFmtClb_Rg,jCboClb_Sexo, jFmtClb_Nascimento, jTxtClb_Email,jFmtClb_Cep,jTxtClb_Endereco,jTxtClb_Bairro,jTxtClb_Cidade, jCboClb_EstadoCivil, jCboClb_ComposicaoFamiliar, jTxtClb_Renda, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraRg = new MaskFormatter("#.###.###");
            
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       jFmtClb_Cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf)); //instancia a mascara e passou a mascara pro campo
       jFmtClb_Nascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
       jFmtClb_Telefone.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefone));
       jFmtClb_Cep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
       jFmtClb_Rg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
    }
    
     /*public void habilitar(){
        // true para os campos e botoes que vao ter que aparecer e ser utilizados
        jTxtIdCliente.setEnabled(true);
        jTxtNome.setEnabled(true);
        jFmtTelefone.setEnabled(true);
        jCboSexo.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jFmtRg.setEnabled(true);
        jFmtNascimento.setEnabled(true);
        jFmtCep.setEnabled(true);
        jTxtEndereco.setEnabled(true);
        jTxtBairro.setEnabled(true);
        jTxtCidade.setEnabled(true);
        jCboEstadoCivil.setEnabled(true);
        jCboComposicaoFamiliar.setEnabled(true);
        jTxtRenda.setEnabled(true);
        
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
        jTxtIdCliente.setEnabled(false);
        jTxtNome.setEnabled(false);
        jFmtTelefone.setEnabled(false);
        jCboSexo.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jFmtRg.setEnabled(false);
        jFmtNascimento.setEnabled(false);
        jFmtCep.setEnabled(false);
        jTxtEndereco.setEnabled(false);
        jTxtBairro.setEnabled(false);
        jTxtCidade.setEnabled(false);
        jCboEstadoCivil.setEnabled(false);
        jCboComposicaoFamiliar.setEnabled(false);
        jTxtRenda.setEnabled(false);
        
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        
        //habilita os botoes que precisam aparecer para fazer uma funçao
        jBtnAlterar.setEnabled(true);
        jBtnIncluir.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
        
    }*/
    
     public void limparCampos(){
        jTxtClb_IdCliente.setText("");
        jTxtClb_Nome.setText("");
        jFmtClb_Telefone.setText("");
        jCboClb_Sexo.setSelectedIndex(-1);
        jTxtClb_Email.setText("");
        jFmtClb_Cpf.setText("");
        jFmtClb_Rg.setText("");
        jFmtClb_Nascimento.setText("");
        jFmtClb_Cep.setText("");
        jTxtClb_Endereco.setText("");
        jTxtClb_Bairro.setText("");
        jTxtClb_Cidade.setText("");
        jCboClb_EstadoCivil.setSelectedIndex(-1);
        jCboClb_ComposicaoFamiliar.setSelectedIndex(-1);
        jTxtClb_Renda.setText("");
    }
     
    public ClbCliente viewBean(){
        ClbCliente clbCliente = new ClbCliente(); //cria o bean 
        
        //pega oq esta na tela e joga para o bean
        int id = Integer.valueOf(jTxtClb_IdCliente.getText());
        clbCliente.setClbIdcliente(id);
        clbCliente.setClbNome(jTxtClb_Nome.getText());
        clbCliente.setClbTelefone(jFmtClb_Telefone.getText());
        clbCliente.setClbSexo(jCboClb_Sexo.getSelectedIndex());
        clbCliente.setClbCpf(jFmtClb_Cpf.getText());
        clbCliente.setClbRg(jFmtClb_Rg.getText());
        //string para data 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // cria o objeto que vai transformar a string para data
        try {
            clbCliente.setClbDataNascimento(formato.parse(jFmtClb_Nascimento.getText())); //utiliza o metodo parse -> que faz a transformação
        } catch (ParseException ex) {
            //Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!"+ex.getMessage());
        }
        clbCliente.setClbEmail(jTxtClb_Email.getText());
        clbCliente.setClbCep(jFmtClb_Cep.getText());
        clbCliente.setClbEndereco(jTxtClb_Endereco.getText());
        clbCliente.setClbBairro(jTxtClb_Bairro.getText());
        clbCliente.setClbCidade(jTxtClb_Cidade.getText());
        clbCliente.setClbEstadoCivil(jCboClb_EstadoCivil.getSelectedIndex()); 
        clbCliente.setClbComposicaoFamiliar(jCboClb_ComposicaoFamiliar.getSelectedIndex());
        clbCliente.setClbRenda(Double.parseDouble( jTxtClb_Renda.getText())); //-> double / decimal
        
        
        return clbCliente; 
    }
    
    public void beanView(ClbCliente clbCliente){
        //pega do bean e joga na tela -- o parametro é o bean
        //mostrar na tela os dados
        String valor = String.valueOf(clbCliente.getClbIdcliente()); //converter inteiro para string por causa do Text -- a string valor recebe o valor do inteiro
        jTxtClb_IdCliente.setText(valor); 
        jTxtClb_Nome.setText(clbCliente.getClbNome());
        jFmtClb_Telefone.setText(clbCliente.getClbTelefone());
        jFmtClb_Cpf.setText(clbCliente.getClbCpf());
        jFmtClb_Rg.setText(clbCliente.getClbRg());
        jCboClb_Sexo.setSelectedIndex(clbCliente.getClbSexo());
        //data para string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //cria o método e utiliza ele no campo do bean que vai ser retornado na tela
        jFmtClb_Nascimento.setText(formato.format(clbCliente.getClbDataNascimento())); //cria o metodo format que faz a conversão 
        jFmtClb_Cep.setText(clbCliente.getClbCep());
        jTxtClb_Email.setText(clbCliente.getClbEmail());
        jTxtClb_Endereco.setText(clbCliente.getClbEndereco());
        jTxtClb_Bairro.setText(clbCliente.getClbBairro());
        jTxtClb_Cidade.setText(clbCliente.getClbCidade());
        jCboClb_EstadoCivil.setSelectedIndex(clbCliente.getClbEstadoCivil());
        jCboClb_ComposicaoFamiliar.setSelectedIndex(clbCliente.getClbComposicaoFamiliar());
        jTxtClb_Renda.setText(String.valueOf(clbCliente.getClbRenda()));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTxtClb_IdCliente = new javax.swing.JTextField();
        jTxtClb_Nome = new javax.swing.JTextField();
        jFmtClb_Cpf = new javax.swing.JFormattedTextField();
        jFmtClb_Rg = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jFmtClb_Nascimento = new javax.swing.JFormattedTextField();
        jTxtClb_Email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTxtClb_Endereco = new javax.swing.JTextField();
        jTxtClb_Bairro = new javax.swing.JTextField();
        jTxtClb_Cidade = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTxtClb_Renda = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jBtnClb_Incluir = new javax.swing.JButton();
        jBtnClb_Alterar = new javax.swing.JButton();
        jBtnClb_Excluir = new javax.swing.JButton();
        jBtnClb_Cancelar = new javax.swing.JButton();
        jBtnClb_Confirmar = new javax.swing.JButton();
        jBtnClb_Pesquisar = new javax.swing.JButton();
        jFmtClb_Cep = new javax.swing.JFormattedTextField();
        jCboClb_Sexo = new javax.swing.JComboBox<>();
        jCboClb_EstadoCivil = new javax.swing.JComboBox<>();
        jCboClb_ComposicaoFamiliar = new javax.swing.JComboBox<>();
        jFmtClb_Telefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id_Cliente:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("CPF: ");

        jLabel5.setText("RG: ");

        jLabel6.setText("Dados Pessoais:");

        jTxtClb_IdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_IdClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_IdClienteFocusLost(evt);
            }
        });
        jTxtClb_IdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_IdClienteActionPerformed(evt);
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

        jFmtClb_Rg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_RgFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_RgFocusLost(evt);
            }
        });
        jFmtClb_Rg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtClb_RgActionPerformed(evt);
            }
        });

        jLabel7.setText("Sexo:");

        jLabel8.setText("Data de Nascimento:");

        jLabel9.setText("Email:");

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

        jTxtClb_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_EmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_EmailFocusLost(evt);
            }
        });
        jTxtClb_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_EmailActionPerformed(evt);
            }
        });

        jLabel10.setText("Endereço:");

        jLabel11.setText("CEP:");

        jLabel12.setText("Endereço:");

        jLabel13.setText("Bairro:");

        jLabel14.setText("Cidade:");

        jTxtClb_Endereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_EnderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_EnderecoFocusLost(evt);
            }
        });
        jTxtClb_Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_EnderecoActionPerformed(evt);
            }
        });

        jTxtClb_Bairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_BairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_BairroFocusLost(evt);
            }
        });

        jTxtClb_Cidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_CidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_CidadeFocusLost(evt);
            }
        });
        jTxtClb_Cidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_CidadeActionPerformed(evt);
            }
        });

        jLabel15.setText("Dados Adicionais:");

        jLabel16.setText("Estado Cívil:");

        jLabel17.setText("Composição Familiar:");

        jLabel18.setText("Renda:");

        jTxtClb_Renda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_RendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_RendaFocusLost(evt);
            }
        });
        jTxtClb_Renda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_RendaActionPerformed(evt);
            }
        });

        jLabel19.setText("Nome:");

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

        jBtnClb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir_1.png"))); // NOI18N
        jBtnClb_Excluir.setText("Excluir");
        jBtnClb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ExcluirActionPerformed(evt);
            }
        });

        jBtnClb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar_1.png"))); // NOI18N
        jBtnClb_Cancelar.setText("Cancelar");
        jBtnClb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_CancelarActionPerformed(evt);
            }
        });

        jBtnClb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnClb_Confirmar.setText("Confirmar");
        jBtnClb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ConfirmarActionPerformed(evt);
            }
        });

        jBtnClb_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar_1.png"))); // NOI18N
        jBtnClb_Pesquisar.setText("Pesquisar");
        jBtnClb_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_PesquisarActionPerformed(evt);
            }
        });

        jFmtClb_Cep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_CepFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_CepFocusLost(evt);
            }
        });

        jCboClb_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        jCboClb_Sexo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCboClb_SexoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboClb_SexoFocusLost(evt);
            }
        });
        jCboClb_Sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClb_SexoActionPerformed(evt);
            }
        });

        jCboClb_EstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Separado(a)", "Divorciado(a)", "Víuvo(a)", " " }));
        jCboClb_EstadoCivil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCboClb_EstadoCivilFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCboClb_EstadoCivilFocusLost(evt);
            }
        });

        jCboClb_ComposicaoFamiliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jTxtClb_IdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jTxtClb_Bairro)
                            .addComponent(jFmtClb_Cep)
                            .addComponent(jCboClb_Sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16)
                            .addComponent(jCboClb_EstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFmtClb_Telefone))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel19)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jTxtClb_Cidade)
                            .addComponent(jTxtClb_Endereco)
                            .addComponent(jTxtClb_Nome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtClb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jFmtClb_Rg, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTxtClb_Email)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jCboClb_ComposicaoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jTxtClb_Renda, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnClb_Incluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_Alterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_Excluir)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnClb_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnClb_Pesquisar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_IdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtClb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtClb_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtClb_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtClb_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClb_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtClb_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtClb_Renda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClb_EstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClb_ComposicaoFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClb_Incluir)
                    .addComponent(jBtnClb_Alterar)
                    .addComponent(jBtnClb_Excluir)
                    .addComponent(jBtnClb_Cancelar)
                    .addComponent(jBtnClb_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnClb_Pesquisar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtClb_IdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_IdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_IdClienteActionPerformed

    private void jTxtClb_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_NomeActionPerformed

    private void jFmtClb_NascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_NascimentoActionPerformed

    private void jTxtClb_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_EmailActionPerformed

    private void jFmtClb_CpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_CpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_CpfActionPerformed

    private void jFmtClb_RgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtClb_RgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtClb_RgActionPerformed

    private void jTxtClb_EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_EnderecoActionPerformed

    private void jTxtClb_RendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_RendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_RendaActionPerformed

    private void jBtnClb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_IncluirActionPerformed
        // TODO add your handling code here:
        //habilitar();
        Util.habilitar(true, jTxtClb_IdCliente, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Cpf, jFmtClb_Rg,jCboClb_Sexo, jFmtClb_Nascimento, jTxtClb_Email,jFmtClb_Cep,jTxtClb_Endereco,jTxtClb_Bairro,jTxtClb_Cidade, jCboClb_EstadoCivil, jCboClb_ComposicaoFamiliar, jTxtClb_Renda, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos();
        incluindo = true;
    }//GEN-LAST:event_jBtnClb_IncluirActionPerformed

    private void jBtnClb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_CancelarActionPerformed
        // TODO add your handling code here:
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdCliente, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Cpf, jFmtClb_Rg,jCboClb_Sexo, jFmtClb_Nascimento, jTxtClb_Email,jFmtClb_Cep,jTxtClb_Endereco,jTxtClb_Bairro,jTxtClb_Cidade, jCboClb_EstadoCivil, jCboClb_ComposicaoFamiliar, jTxtClb_Renda, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos();
    }//GEN-LAST:event_jBtnClb_CancelarActionPerformed

    private void jBtnClb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_PesquisarActionPerformed
        // TODO add your handling code here:
          //resp = resposta
        String resp = JOptionPane.showInputDialog(null, "Entre com o id ou código (PK)", "Tela de Pesquisa", 2);//retorna uma string
        
    }//GEN-LAST:event_jBtnClb_PesquisarActionPerformed

    private void jBtnClb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_AlterarActionPerformed
        // TODO add your handling code here:
        //habilitar();
        Util.habilitar(true, jTxtClb_IdCliente, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Cpf, jFmtClb_Rg,jCboClb_Sexo, jFmtClb_Nascimento, jTxtClb_Email,jFmtClb_Cep,jTxtClb_Endereco,jTxtClb_Bairro,jTxtClb_Cidade, jCboClb_EstadoCivil, jCboClb_ComposicaoFamiliar, jTxtClb_Renda, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        incluindo = false;
    }//GEN-LAST:event_jBtnClb_AlterarActionPerformed

    private void jBtnClb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ConfirmarActionPerformed
        // TODO add your handling code here:
        //declarou um objeto do tipo Bean -> e o objeto recebe viewBean -> Bean recebe Bean
        /*ClbCliente clbCliente = viewBean();
        ClienteDAO clienteDAO = new ClienteDAO();
        
        if(incluindo == true){
            clienteDAO.insert(clbCliente);
        }else{
            clienteDAO.update(clbCliente);
        }*/
        
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdCliente, jTxtClb_Nome, jFmtClb_Telefone, jFmtClb_Cpf, jFmtClb_Rg,jCboClb_Sexo, jFmtClb_Nascimento, jTxtClb_Email,jFmtClb_Cep,jTxtClb_Endereco,jTxtClb_Bairro,jTxtClb_Cidade, jCboClb_EstadoCivil, jCboClb_ComposicaoFamiliar, jTxtClb_Renda, jBtnClb_Confirmar, jBtnClb_Cancelar ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos();
    }//GEN-LAST:event_jBtnClb_ConfirmarActionPerformed

    private void jTxtClb_IdClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdClienteFocusGained
        // TODO add your handling code here:
        jTxtClb_IdCliente.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_IdClienteFocusGained

    private void jTxtClb_IdClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdClienteFocusLost
        // TODO add your handling code here:
        jTxtClb_IdCliente.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_IdClienteFocusLost

    private void jTxtClb_NomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusGained
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_NomeFocusGained

    private void jTxtClb_NomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_NomeFocusLost
        // TODO add your handling code here:
        jTxtClb_Nome.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_NomeFocusLost

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

    private void jFmtClb_NascimentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusGained
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusGained

    private void jFmtClb_NascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_NascimentoFocusLost
        // TODO add your handling code here:
        jFmtClb_Nascimento.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_NascimentoFocusLost

    private void jTxtClb_EmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EmailFocusGained
        // TODO add your handling code here:
        jTxtClb_Email.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_EmailFocusGained

    private void jTxtClb_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EmailFocusLost
        // TODO add your handling code here:
        jTxtClb_Email.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_EmailFocusLost

    private void jTxtClb_EnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EnderecoFocusGained
        // TODO add your handling code here:
        jTxtClb_Endereco.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_EnderecoFocusGained

    private void jTxtClb_EnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_EnderecoFocusLost
        // TODO add your handling code here:
        jTxtClb_Endereco.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_EnderecoFocusLost

    private void jTxtClb_BairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_BairroFocusGained
        // TODO add your handling code here:
        jTxtClb_Bairro.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_BairroFocusGained

    private void jTxtClb_BairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_BairroFocusLost
        // TODO add your handling code here:
        jTxtClb_Bairro.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_BairroFocusLost

    private void jTxtClb_CidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_CidadeFocusGained
        // TODO add your handling code here:
        jTxtClb_Cidade.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_CidadeFocusGained

    private void jTxtClb_CidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_CidadeFocusLost
        // TODO add your handling code here:
        jTxtClb_Cidade.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_CidadeFocusLost

    private void jTxtClb_RendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_RendaFocusGained
        // TODO add your handling code here:
        jTxtClb_Renda.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jTxtClb_RendaFocusGained

    private void jTxtClb_RendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_RendaFocusLost
        // TODO add your handling code here:
        jTxtClb_Renda.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_RendaFocusLost

    private void jFmtClb_CepFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CepFocusGained
        // TODO add your handling code here:
        jFmtClb_Cep.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jFmtClb_CepFocusGained

    private void jFmtClb_CepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_CepFocusLost
        // TODO add your handling code here:
        jFmtClb_Cep.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_CepFocusLost

    private void jCboClb_SexoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboClb_SexoFocusGained
        // TODO add your handling code here:
        jCboClb_Sexo.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jCboClb_SexoFocusGained

    private void jCboClb_SexoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboClb_SexoFocusLost
        // TODO add your handling code here:
        jCboClb_Sexo.setBackground(Color.WHITE);
    }//GEN-LAST:event_jCboClb_SexoFocusLost

    private void jCboClb_EstadoCivilFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboClb_EstadoCivilFocusGained
        // TODO add your handling code here:
        jCboClb_EstadoCivil.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jCboClb_EstadoCivilFocusGained

    private void jCboClb_EstadoCivilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCboClb_EstadoCivilFocusLost
        // TODO add your handling code here:
        jCboClb_EstadoCivil.setBackground(Color.WHITE);
    }//GEN-LAST:event_jCboClb_EstadoCivilFocusLost

    private void jBtnClb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ExcluirActionPerformed
        // TODO add your handling code here:
        /*int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmar", JOptionPane.YES_NO_OPTION, 0); //yes.no.option -> pq queremos somente os botoes de sim e não
        if (resp == JOptionPane.YES_OPTION){
        //pega da tela, joga para o bean, manda para o DAO e assim aciona o método DELETE
            ClbCliente clientes = viewBean();//declarou um objeto do tipo Bean -> e o objeto recebe viewBean -> Bean recebe Bean
            ClienteDAO clientes_DAO = new ClienteDAO(); //declarou o DAO
            clientes_DAO.delete(clientes);
        }else{
            JOptionPane.showMessageDialog(null, "Exclusão cancelada.", "Alerta", 2); //em ordem os parametros são: centraliza em relação a tela, menssagem, titulo e numero da imagem
        }
        limparCampos();*/
        
        if(Util.perguntar("Deseja excluir o usuário?") == true){
            //fazer alguma coisa
        }
        Util.limparCampos();
    }//GEN-LAST:event_jBtnClb_ExcluirActionPerformed

    private void jCboClb_SexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClb_SexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClb_SexoActionPerformed

    private void jTxtClb_CidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_CidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_CidadeActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCboClb_ComposicaoFamiliar;
    private javax.swing.JComboBox<String> jCboClb_EstadoCivil;
    private javax.swing.JComboBox<String> jCboClb_Sexo;
    private javax.swing.JFormattedTextField jFmtClb_Cep;
    private javax.swing.JFormattedTextField jFmtClb_Cpf;
    private javax.swing.JFormattedTextField jFmtClb_Nascimento;
    private javax.swing.JFormattedTextField jFmtClb_Rg;
    private javax.swing.JFormattedTextField jFmtClb_Telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtClb_Bairro;
    private javax.swing.JTextField jTxtClb_Cidade;
    private javax.swing.JTextField jTxtClb_Email;
    private javax.swing.JTextField jTxtClb_Endereco;
    private javax.swing.JTextField jTxtClb_IdCliente;
    private javax.swing.JTextField jTxtClb_Nome;
    private javax.swing.JTextField jTxtClb_Renda;
    // End of variables declaration//GEN-END:variables
}
