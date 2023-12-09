/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.ClbVendas;
import bean.ClbVendasProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DELL
 */
public class VendasProdutoController extends AbstractTableModel{
    //criasse esses metodos pq é o minimo para se criar uma tabela, ter o numero de linhas, colunas e conteudo
    
    List lista; // cria o atributo lista 
    
    public void setList(List lista){ //cria o metodo setList que joga os dados da lista do listAll para a a variavel lista do UsuariosControle
        this.lista = lista; //coloca o this pq é o mesmo nome do atributo e do parametro --> assim coloca o this para dizer que o lusta é o atributo criado anteriomente
        this.fireTableDataChanged(); //para atualizar a lista 
    }
    
    public ClbVendasProduto getBean(int row){ //pega o bena para saber a posição de acordo com a linha da lista e do jTable 
        return (ClbVendasProduto) lista.get(row); //converte o get que retorna object em VENDAS 
    }
    
    public void addBean(ClbVendasProduto clbVendasProduto){ //adiciona o bean no banco de dados
        lista.add(clbVendasProduto);
        this.fireTableDataChanged(); //atualiza o0 conteudo da tabela 
    }
    
    public void removeBean(int index){ //remove a linha selecionada na tabela 
        lista.remove(index);
        this.fireTableDataChanged();
    }
    
    public void updateBean(int index, ClbVendasProduto clbVendasProduto){ //utilizamos a linha selecionada e o bean para podermos definir a alteração
        lista.set(index, clbVendasProduto); //
        this.fireTableDataChanged();//atualiza a tabela 
    }

    @Override
    public int getRowCount() { //pegar quantidade de linhas
        return lista.size(); // numero de linhas
    }

    @Override
    public int getColumnCount() {//pegar quantidade de colunas
        return 4; //retorna o numero de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pegar os valores -> conteúdo
        ClbVendasProduto clbVendasProduto = (ClbVendasProduto) lista.get(rowIndex); //cria o bean e passa a lista para ele poder retornar os bean em cada coluna
        if(columnIndex == 0){
       return clbVendasProduto.getClbProduto();
   }
        if(columnIndex == 1){
       return clbVendasProduto.getClbQuantidade(); //retorna O FK PRODUTO
   }
        if(columnIndex == 2){
       return clbVendasProduto.getClbValorUnitario(); //retorna a quantidade
   }
        if(columnIndex == 3){ //para mostrar o "total" fazemos a mesma formula apresentada nos metodos da teçla IA 
            //devemos multiplicar a quantidade de produtos X o valor unitario, assim mostrando na tela o resultado
       return clbVendasProduto.getClbValorUnitario() * clbVendasProduto.getClbQuantidade(); //retorna o valor unitario 
   }
        return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
    @Override
    public String getColumnName(int column){ //o parametro é pra definir a coluna que vai passar
        if(column == 0){ //compara qual é a coluna que será passado o nome. começando na posição 0 
       return "Produto: ";
   }
       if(column == 1){
       return "Quantidade: ";
   }
       if(column == 2){
       return "Valor Unitário: ";
   }
       if(column == 3){
       return "Valor Total: ";
   }
       return ""; //o metodo precisa de um retorno, se não entrar em nenhum if, ele retorna nada. 
    }
    
}
