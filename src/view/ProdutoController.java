/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class ProdutoController extends AbstractTableModel {
    //criasse esses metodos pq é o minimo para se criar uma tabela, ter o numero de linhas, colunas e conteudo
    
    List lista; // cria o atributo lista 
    
    public void setList(List lista){ //cria o metodo setList que joga os dados da lista do listAll para a a variavel lista do UsuariosControle
        this.lista = lista; //coloca o this pq é o mesmo nome do atributo e do parametro --> assim coloca o this para dizer que o lusta é o atributo criado anteriomente
        this.fireTableDataChanged(); //para atualizar a lista 
    }
    
    public ClbProduto getBean(int row){ //pega o bena para saber a posição de acordo com a linha da lista e do jTable 
        return (ClbProduto) lista.get(row); //converte o get que retorna object em PRODUTO
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pegar os valores -> conteúdo
            ClbProduto clbProduto = (ClbProduto) lista.get(rowIndex); //cria o ben e passa a lista para ele poder retornar os bean em cada coluna
        if(columnIndex == 0){ //compara a posição da coluna para atribuir o valor
       return clbProduto.getClbIdproduto(); //retorna o id 
   }
        if(columnIndex == 1){
       return clbProduto.getClbNomeProduto(); //retorna o nome
   }
        if(columnIndex == 2){
       return clbProduto.getClbAutor(); //retorna o autor do livro
   }
        if(columnIndex == 3){
       return clbProduto.getClbPreco(); //retorna o preço do produto
   }
        return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
    @Override
    public String getColumnName(int column){ //o parametro é pra definir a coluna que vai passar
        if(column == 0){ //compara qual é a coluna que será passado o nome. começando na posição 0 
       return "Id Produto";
   }
       if(column == 1){
       return "Nome do Produto";
   }
       if(column == 2){
       return "Autor";
   }
       if(column == 3){
       return "Preco";
   }
       return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
}
