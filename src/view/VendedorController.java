/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class VendedorController extends AbstractTableModel{
    //criasse esses metodos pq é o minimo para se criar uma tabela, ter o numero de linhas, colunas e conteudo
    
    List lista; // cria o atributo lista 
    
    public void setList(List lista){ //cria o metodo setList que joga os dados da lista do listAll para a a variavel lista do UsuariosControle
        this.lista = lista; //coloca o this pq é o mesmo nome do atributo e do parametro --> assim coloca o this para dizer que o lusta é o atributo criado anteriomente
        this.fireTableDataChanged(); //para atualizar a lista 
    }
    
    public ClbVendedor getBean(int row){ //pega o bena para saber a posição de acordo com a linha da lista e do jTable 
        return (ClbVendedor) lista.get(row); //converte o get que retorna object em vendedor
    }

    @Override
    public int getRowCount() {//pegar quantidade de linhas
        return lista.size(); // numero de linhas
    }

    @Override
    public int getColumnCount() {//pegar quantidade de colunas
        return 4; //retorna o numero de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//pegar os valores -> conteúdo
        ClbVendedor clbVendedor = (ClbVendedor) lista.get(rowIndex); //cria o ben e passa a lista para ele poder retornar os bean em cada coluna
        if(columnIndex == 0){ //compara a posição da coluna para atribuir o valor
       return clbVendedor.getClbIdvendedor(); //retorna o id 
   }
        if(columnIndex == 1){
       return clbVendedor.getClbNomeVendedor(); //retorna o nome
   }
        if(columnIndex == 2){
       return clbVendedor.getClbTelefone(); //retorna o telefone do vendedor
   }
        if(columnIndex == 3){
       return clbVendedor.getClbCpf(); //retorna o cpf
   }
        return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
    @Override
    public String getColumnName(int column){
        //o parametro é pra definir a coluna que vai passar
       if(column == 0){ //compara qual é a coluna que será passado o nome. começando na posição 0 
       return "Id Vendedor";
   }
       if(column == 1){
       return "Nome Vendedor";
   }
       if(column == 2){
       return "Telefone";
   }
       if(column == 3){
       return "CPF";
   }
        return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
}
