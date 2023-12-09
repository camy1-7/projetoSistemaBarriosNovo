/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbCliente;
import bean.ClbVendas;
import bean.ClbVendasProduto;
import bean.ClbVendedor;
import dao.ClienteDAO;
import dao.VendasDAO;
import dao.VendasProdutoDAO;
import dao.VendedorDAO;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author DELL
 */
public class JDlgVendas extends javax.swing.JDialog {
     public boolean incluindo; //variavel tipo booleana, nome -> incluindo --- para poder usar em todos os lugares, declaramos ela como global
     MaskFormatter mascaraDataVenda;
     ClienteDAO clienteDAO;
     VendedorDAO vendedorDAO;
     VendasDAO vendasDAO;
     ClbVendas clbVendas;
     ClbVendasProduto clbVendasProduto;
     ClbCliente clbCliente;
     ClbVendedor clbVendedor;
     VendasProdutoController vendasProdutoController;
     VendasController vendasController;
     VendasProdutoDAO vendasProdutoDAO;
     JDlgIncluirAlterarProduto jDlgIncluirAlterarProduto;
     JDlgVendasPesquisa jDlgVendasPesquisa;
    
     
     
    /**
     * Creates new form JDlgVendas
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal, jBtnClb_Confirmar, jBtnClb_Cancelar, jBtnClb_AlterarProd, jBtnClb_ExcluirProd, jBtnClb_IncluirProd ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        setTitle("Cadastro de Vendas");
        setLocationRelativeTo(null);
        
        jDlgIncluirAlterarProduto = new JDlgIncluirAlterarProduto(null, true);
        
        /*vendasProdutoController = new VendasProdutoController(); //criei o vendasProduto controle 
        vendasProdutoDAO = new VendasProdutoDAO();
        //jDlgvendasProdutosPesquisa.setList(lista);
        jTable2.setModel(vendasProdutoController); //agora o usuariosControle que controla a tabela*/
        
        //Anteriormente o pesquisar não funcionava por nada, então fui buscar em telas anteiores como chamava o controller 
        //assim cheguei neste codigo que com algumas mudanças, deioxu eu abrir a tela (oq estava dando ero antes) 
        //ele inclui e altera na tabela, mas o id esta incorreto
        vendasProdutoController = new VendasProdutoController(); //criei o vendasControle 
        vendasProdutoDAO = new VendasProdutoDAO(); //criou o objeto vendas_DAO
        List lista = vendasProdutoDAO.listProdutos(clbVendas); //Criou uma lista e ta passando o metodo ListAll do Vendas_DAO
        vendasProdutoController.setList(lista); //passando o a lista para o vendasControle -> se retorna a lista para que as informações sejam mostradas e a lista vem do Vendas_DAO
        jTable2.setModel(vendasProdutoController); 

        try {
            mascaraDataVenda  = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtClb_DataVenda.setFormatterFactory(new DefaultFormatterFactory(mascaraDataVenda)); //instancia a mascara e passou a mascara pro campo
    
        clienteDAO = new ClienteDAO();
        List listaClientes = clienteDAO.listAll();
        for (int i = 0; i < listaClientes.size(); i++){
            jCboClb_FkCliente.addItem(((ClbCliente) listaClientes.get(i))); //conver~soa de object
        }
        
        vendedorDAO = new VendedorDAO();
        List listaVendedor = vendedorDAO.listAll();
        for (int i = 0; i < listaVendedor.size(); i++){
            jCboClb_FkVendedor.addItem(((ClbVendedor) listaVendedor.get(i)));
        }
    }
    
     public ClbVendas viewBean(){
        clbVendas = new ClbVendas(); //cria o bean 
        
        //pega oq esta na tela e joga para o bean
        int id = Integer.valueOf(jTxtClb_IdVendas.getText());
        clbVendas.setClbIdvendas(id);
        
        /*ClbCliente clientes1 = (ClbCliente) jCboClb_FkCliente.getSelectedItem(); //cria o bean
        clbVendas.setClbCliente(clientes1.getClbIdcliente());*/
        
        ClbCliente clientes1 = ((ClbCliente) jCboClb_FkCliente.getSelectedItem()); //cria o bean
        clbVendas.setClbCliente(clientes1);
        
        /*ClbVendedor vendedor1 = (ClbVendedor) jCboClb_FkVendedor.getSelectedItem();
        clbVendas.setClbVendedor((vendedor1.getClbIdvendedor()));*/
        
        ClbVendedor vendedor1 = ((ClbVendedor) jCboClb_FkVendedor.getSelectedItem());
        clbVendas.setClbVendedor(vendedor1);
        
        //string para data 
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // cria o objeto que vai transformar a string para data
        try {
            clbVendas.setClbDataVenda(formato.parse(jFmtClb_DataVenda.getText())); //utiliza o metodo parse -> que faz a transformação
        } catch (ParseException ex) {
            //Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro!"+ex.getMessage());
        }
        
        clbVendas.setClbValorTotal(Double.parseDouble( jTxtClb_ValorTotal.getText())); //-> double / decimal
      
        return clbVendas; //
    }
    
    public void beanView(ClbVendas clbVendas){//pega do bean e joga na tela -- o parametro é o bean
        //mostrar na tela os dados
        String valor = String.valueOf(clbVendas.getClbIdvendas()); //converter inteiro para string por causa do Text -- a string valor recebe o valor do inteiro
        jTxtClb_IdVendas.setText(valor); 
        jCboClb_FkCliente.setSelectedItem(clbVendas.getClbCliente());
        jCboClb_FkVendedor.setSelectedItem(clbVendas.getClbVendedor());
        
        /*int idClientes = ClbVendas.getClbCliente();
        clienteDAO = new ClienteDAO();
        jCboClb_FkCliente.setSelectedItem(clienteDAO.list(idClientes));*/
        
        /*int idVendedor = ClbVendas.getClbVendedor();
        vendedorDAO = new VendedorDAO();
        jCboClb_FkVendedor.setSelectedItem(vendedorDAO.list(idVendedor));*/
        
        //data para string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //cria o método e utiliza ele no campo do bean que vai ser retornado na tela
        jFmtClb_DataVenda.setText(formato.format(clbVendas.getClbDataVenda())); //cria o metodo format que faz a conversão
        jTxtClb_ValorTotal.setText(String.valueOf(clbVendas.getClbValorTotal()));
        
        //quando o for pegar os beans e jogar na tela, ele chama o listProduto e manda para a tabela todos os dados tambem
        vendasProdutoDAO = new VendasProdutoDAO();
        List listaProd = (List) vendasProdutoDAO.listProdutos(clbVendas);
        vendasProdutoController.setList(listaProd);
        
        }
    
        public int getSelectedRowProd(){
            return jTable2.getSelectedRow();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFmtClb_DataVenda = new javax.swing.JFormattedTextField();
        jTxtClb_IdVendas = new javax.swing.JTextField();
        jTxtClb_ValorTotal = new javax.swing.JTextField();
        jCboClb_FkVendedor = new javax.swing.JComboBox<ClbVendedor>();
        jCboClb_FkCliente = new javax.swing.JComboBox<ClbCliente>();
        jBtnClb_Incluir = new javax.swing.JButton();
        jBtnClb_Alterar = new javax.swing.JButton();
        jBtnClb_Excluir = new javax.swing.JButton();
        jBtnClb_Confirmar = new javax.swing.JButton();
        jBtnClb_Cancelar = new javax.swing.JButton();
        jBtnClb_Pesquisar = new javax.swing.JButton();
        jBtnClb_IncluirProd = new javax.swing.JButton();
        jBtnClb_AlterarProd = new javax.swing.JButton();
        jBtnClb_ExcluirProd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id_Vendas:");

        jLabel2.setText("Cliente:");

        jLabel3.setText("Vendedor:");

        jLabel4.setText("Data da Venda:");

        jLabel5.setText("Valor Total: ");

        jFmtClb_DataVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFmtClb_DataVendaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFmtClb_DataVendaFocusLost(evt);
            }
        });

        jTxtClb_IdVendas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_IdVendasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_IdVendasFocusLost(evt);
            }
        });
        jTxtClb_IdVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_IdVendasActionPerformed(evt);
            }
        });

        jTxtClb_ValorTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtClb_ValorTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtClb_ValorTotalFocusLost(evt);
            }
        });
        jTxtClb_ValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtClb_ValorTotalActionPerformed(evt);
            }
        });
        jTxtClb_ValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtClb_ValorTotalKeyReleased(evt);
            }
        });

        jCboClb_FkCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboClb_FkClienteActionPerformed(evt);
            }
        });

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

        jBtnClb_IncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnClb_IncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_IncluirProdActionPerformed(evt);
            }
        });

        jBtnClb_AlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnClb_AlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_AlterarProdActionPerformed(evt);
            }
        });

        jBtnClb_ExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnClb_ExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnClb_ExcluirProdActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto:", "Quantidade:", "Valor Unitário:", "Valor Total:"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnClb_Incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnClb_Alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnClb_Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnClb_Confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnClb_Cancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_Pesquisar)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTxtClb_IdVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jCboClb_FkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jCboClb_FkVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jFmtClb_DataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(56, 56, 56)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTxtClb_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(531, 531, 531)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jBtnClb_IncluirProd)
                                    .addComponent(jBtnClb_AlterarProd)
                                    .addComponent(jBtnClb_ExcluirProd)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtClb_DataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_IdVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtClb_ValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClb_FkVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboClb_FkCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBtnClb_IncluirProd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_AlterarProd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnClb_ExcluirProd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnClb_Incluir)
                    .addComponent(jBtnClb_Alterar)
                    .addComponent(jBtnClb_Excluir)
                    .addComponent(jBtnClb_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnClb_Cancelar)
                    .addComponent(jBtnClb_Pesquisar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnClb_IncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_IncluirProdActionPerformed
        // TODO add your handling code here:
        //set chama a tela de pesquisa do clientes
        
        jDlgIncluirAlterarProduto = new JDlgIncluirAlterarProduto(null, true);
        jDlgIncluirAlterarProduto.setTitle("Inclusão de Produtos");
        jDlgIncluirAlterarProduto.setTelaAnterior(this); //importante ter  -> o this é a tela jDlgUsuarios (o this se refre a si mesmo)
        jDlgIncluirAlterarProduto.setVisible(true);
        
    }//GEN-LAST:event_jBtnClb_IncluirProdActionPerformed

    private void jBtnClb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_IncluirActionPerformed
        // TODO add your handling code here:
        //habilitar();
        Util.habilitar(true, jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal, jBtnClb_Confirmar, jBtnClb_Cancelar, jBtnClb_AlterarProd, jBtnClb_ExcluirProd, jBtnClb_IncluirProd ); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos(jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal);
        incluindo = true; // quando clicar aqui o incluindo = true. 
    }//GEN-LAST:event_jBtnClb_IncluirActionPerformed

    private void jTxtClb_IdVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_IdVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_IdVendasActionPerformed

    private void jTxtClb_ValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtClb_ValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtClb_ValorTotalActionPerformed

    private void jTxtClb_IdVendasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdVendasFocusGained
        // TODO add your handling code here:
        jTxtClb_IdVendas.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_IdVendasFocusGained

    private void jTxtClb_IdVendasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_IdVendasFocusLost
        // TODO add your handling code here:
        jTxtClb_IdVendas.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_IdVendasFocusLost

    private void jFmtClb_DataVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_DataVendaFocusGained
        // TODO add your handling code here:
        jFmtClb_DataVenda.setBackground(Color.lightGray);
    }//GEN-LAST:event_jFmtClb_DataVendaFocusGained

    private void jFmtClb_DataVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFmtClb_DataVendaFocusLost
        // TODO add your handling code here:
        jFmtClb_DataVenda.setBackground(Color.WHITE);
    }//GEN-LAST:event_jFmtClb_DataVendaFocusLost

    private void jTxtClb_ValorTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_ValorTotalFocusGained
        // TODO add your handling code here:
        jTxtClb_ValorTotal.setBackground(Color.lightGray);
    }//GEN-LAST:event_jTxtClb_ValorTotalFocusGained

    private void jTxtClb_ValorTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtClb_ValorTotalFocusLost
        // TODO add your handling code here:
        jTxtClb_ValorTotal.setBackground(Color.WHITE);
    }//GEN-LAST:event_jTxtClb_ValorTotalFocusLost

    private void jBtnClb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_AlterarActionPerformed
        // TODO add your handling code here:
        //habilitar();
        Util.habilitar(true, jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal, jBtnClb_Confirmar, jBtnClb_Cancelar, jBtnClb_AlterarProd, jBtnClb_ExcluirProd, jBtnClb_IncluirProd ); //habilita os campos
        Util.habilitar(false, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        incluindo = false; // quando clicar aqui o incluindo = true. 
    }//GEN-LAST:event_jBtnClb_AlterarActionPerformed

    private void jBtnClb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ConfirmarActionPerformed
        // TODO add your handling code here:
        clbVendas = viewBean();
        vendasDAO = new VendasDAO();
        
        if(incluindo == true){ //se incluindo for == true é uma inclusão
            vendasDAO.insert(clbVendas); //então ele vai inserir os beans 
            vendasProdutoDAO = new VendasProdutoDAO();
            for(int linha = 0; linha < jTable2.getRowCount(); linha ++){ //faz um for que passa por cada linha da tabela
                clbVendasProduto = vendasProdutoController.getBean(linha); //
                //Como na tela de IA não é inserido o clbVendas - chave estrangeira
                //durante o insert da vendas, temos que mandar ele para o bean
                clbVendasProduto.setClbVendas(clbVendas); //
                vendasProdutoDAO.insert(clbVendasProduto);//insere os dados da tela no bean -> para poder mandar para o bd
            }
        }else{
            vendasDAO.update(clbVendas);
            //remover todos os pedidos do pedido escolhido 
            //faço o for para poder pegar todas as linhas da tabela
            for(int linha = 0; linha < jTable2.getRowCount(); linha ++){  
                clbVendasProduto = vendasProdutoController.getBean(linha); //pega linha a linha com os dados da tela
                //Como na tela de IA não é inserido o clbVendas - chave estrangeira
                //durante o insert da vendas, temos que mandar ele para o bean
                clbVendasProduto.setClbVendas(clbVendas);
                vendasProdutoDAO.delete(clbVendasProduto); //escolho a operação de exclusão, pois quero remover do bd, para depois incluir de novo
                //devido a isso, devemos adicionar todos os novos dados 
            }
            //e incluri todos os pedidosproduto que estao no jtable
            vendasProdutoDAO = new VendasProdutoDAO();
            //depois de remover tudo do banco de dados 
            //ele pega todos os dados da tabela e joga no bean 
            for(int linha = 0; linha < jTable2.getRowCount(); linha ++){  //para por todas as linhas da tabela 
                clbVendasProduto = vendasProdutoController.getBean(linha); //pega linha a linha os dados da tela
                //Como na tela de IA não é inserido o clbVendas - chave estrangeira
                //durante o insert da vendas, temos que mandar ele para o bean
                clbVendasProduto.setClbVendas(clbVendas);
                vendasProdutoDAO.insert(clbVendasProduto); //adicionamos em vez de update, pq iniclamnete excluimos tudo
                //devido a isso, devemos adicionar todos os novos dados 
            }
        }
        
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal, jBtnClb_Confirmar, jBtnClb_Cancelar, jBtnClb_AlterarProd, jBtnClb_ExcluirProd, jBtnClb_IncluirProd ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos(jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal);
        
        //limpa a lista 
        vendasProdutoController.setList(new ArrayList()); //lista vazia para limpar a lista
        
        clbVendas = null; //se a venda for nula, nao ter nada 
    }//GEN-LAST:event_jBtnClb_ConfirmarActionPerformed

    private void jBtnClb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_CancelarActionPerformed
        // TODO add your handling code here:
        //desabilitar();
        Util.habilitar(false, jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal, jBtnClb_Confirmar, jBtnClb_Cancelar, jBtnClb_AlterarProd, jBtnClb_ExcluirProd, jBtnClb_IncluirProd ); //habilita os campos
        Util.habilitar(true, jBtnClb_Alterar, jBtnClb_Excluir, jBtnClb_Incluir, jBtnClb_Pesquisar);//desabilita os campos
        Util.limparCampos(jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal);
        
        //entender??
        vendasProdutoController.setList(new ArrayList()); //lista vazia para limpar a lista
        
        clbVendas = null; //se a venda for nula, nao ter nada 
    }//GEN-LAST:event_jBtnClb_CancelarActionPerformed

    private void jBtnClb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ExcluirActionPerformed
        // TODO add your handling code here:
        //sobrecarga 
        if(clbVendas != null){ //VERIFICA SE O BEAN É DIFERENTE DE NULO -> se tem valores
            if(Util.perguntar("Deseja excluir a venda?") == true){ //se sim, pergunta se deseja excluir a venda
                //vendasProdutoDAO = new VendasProdutoDAO(); 
                for(int linha = 0; linha < jTable2.getRowCount(); linha ++){ //for passa pelas linhas do jTable
                clbVendasProduto = vendasProdutoController.getBean(linha); //pega a linha selecionada que corresponde a venda pesquisada
                vendasProdutoDAO.delete(clbVendasProduto);//exclui o vendasProduto referente
                }
                vendasDAO.delete(clbVendas); //e termina excluindo a venda
                vendasProdutoController.setList(new ArrayList());  //lista vazia para limpar a lista
                Util.limparCampos(jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal);
            }else{
                Util.mensagem("Exclusão Cancelada!"); //caso a resposta seja não, retorna a mensagem
            }
        }
        
        Util.limparCampos(jTxtClb_IdVendas, jCboClb_FkCliente, jCboClb_FkVendedor, jFmtClb_DataVenda, jTxtClb_ValorTotal);
        clbVendas = null; //o bean é igual a nulo, não tem nada 
        
        /* if (pedidos != null) {
            if (Util.perguntar("Deseja excluir o pedido ?") == true) {
                PedidosProdutosDAO pedidosProdutosDAO = new PedidosProdutosDAO();
                PedidosProdutos pedidosProdutos;
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    pedidosProdutos = pedidosProdutosControle.getBean(linha);
                    pedidosProdutosDAO.delete(pedidosProdutos);
                }
                pedidosDAO.delete(pedidos);
            }
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        Util.limparCampos(jTxtNumPedido, jFmtData, jCboCliente, jCboVendedor, jTxtTotal);
        pedidos = null;*/
    }//GEN-LAST:event_jBtnClb_ExcluirActionPerformed

    private void jBtnClb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_PesquisarActionPerformed
        // TODO add your handling code here:
        //set chama a tela de pesquisa do vendas
        jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true);
        jDlgVendasPesquisa.setTelaAnterior(this); //importante ter  -> o this é a tela jDlgUsuarios (o this se refre a si mesmo) 
        jDlgVendasPesquisa.setVisible(true);
        
        /*String resp = JOptionPane.showInputDialog(null, "Entre com o id ou código (PK)", "Tela de Pesquisa", 2);//retorna uma string
        Vendas_DAO vendas_DAO = new Vendas_DAO();
        int id = Integer.valueOf(resp); //converteu string para int
        Vendas vendas = (Vendas) vendas_DAO.list(id); //list espera a chave primario -- inteiro
        //nesta linha esta acontecendo o polimorfismo, como no list retorna OBJECT
        //esta transformando a classe bean que vem do LIST em OBJECT 
        //mesma ideia de transformar object 
        //object é a maior classe, todo mundo herda dela 
        
        beanView(vendas);*/
    }//GEN-LAST:event_jBtnClb_PesquisarActionPerformed

    private void jBtnClb_AlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_AlterarProdActionPerformed
        // TODO add your handling code here:

        jDlgIncluirAlterarProduto = new JDlgIncluirAlterarProduto(null, true);
        jDlgIncluirAlterarProduto.setTitle("Alteração de Produtos");
        jDlgIncluirAlterarProduto.setTelaAnterior(this); //importante ter  -> o this é a tela jDlgUsuarios (o this se refre a si mesmo)
        int rowSel = jTable2.getSelectedRow(); // cria uma variavel para receber os beans da Linha selecionada
        clbVendasProduto = (ClbVendasProduto) vendasProdutoController.getBean(rowSel); //Pega os beans e manda para o controller -> para poder fazer o update
        jDlgIncluirAlterarProduto.beanView(clbVendasProduto); //retorna os beans da tela, para serem mostradas 
        jDlgIncluirAlterarProduto.setVisible(true);
          
    }//GEN-LAST:event_jBtnClb_AlterarProdActionPerformed

    private void jBtnClb_ExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnClb_ExcluirProdActionPerformed
        // TODO add your handling code here:
        if(getSelectedRowProd() == -1){ //verifica se a linha não esta selecionada
            Util.mensagem("Nenhuma linha Selecionada!");
        }else{
            if( Util.perguntar("Confirma a exclusão do produto?") == true){ //confirma a exclusão, se sim chama o metodo delete do controller
                vendasProdutoController.removeBean(getSelectedRowProd()); //pega a linha selecionada e exclui 
            }
        }
        
    }//GEN-LAST:event_jBtnClb_ExcluirProdActionPerformed

    private void jCboClb_FkClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboClb_FkClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboClb_FkClienteActionPerformed

    private void jTxtClb_ValorTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtClb_ValorTotalKeyReleased
        // TODO add your handling code here:
        //FAZER COM Q A QUANTIDADE X O VALOR TOTAL, FELITA O VALOR TOTAL NA VENDAS TAMBEM 
    }//GEN-LAST:event_jTxtClb_ValorTotalKeyReleased

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
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnClb_AlterarProd;
    private javax.swing.JButton jBtnClb_Cancelar;
    private javax.swing.JButton jBtnClb_Confirmar;
    private javax.swing.JButton jBtnClb_Excluir;
    private javax.swing.JButton jBtnClb_ExcluirProd;
    private javax.swing.JButton jBtnClb_Incluir;
    private javax.swing.JButton jBtnClb_IncluirProd;
    private javax.swing.JButton jBtnClb_Pesquisar;
    private javax.swing.JComboBox<ClbCliente> jCboClb_FkCliente;
    private javax.swing.JComboBox<ClbVendedor> jCboClb_FkVendedor;
    private javax.swing.JFormattedTextField jFmtClb_DataVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtClb_IdVendas;
    private javax.swing.JTextField jTxtClb_ValorTotal;
    // End of variables declaration//GEN-END:variables
}
