/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author u07870835188
 */
public class Util { //ao vc atribuir o comando "STATIC" ao metodo, ele não precisa mais instanciar - no caso cria um object para poder chamar os metodos que est]ao na classe.
    public static void habilitar(boolean valor, JComponent ... vetComponentes){
        for (int i = 0; i < vetComponentes.length; i++) { //cria um for para verificar o valor que contem no vetor, se vai ser true ou false
            vetComponentes[i].setEnabled(valor); //puxa o metodo setEnabled (que esta implementado na arvore de derivação (jComponent)) para poder atribuir o valor - que vai variar entre true e false dependendo do metodo onde for utilizado
            //utiliza o polimorfismo estático -> pq vc sabe da onde esta herdando de um lugar que vc sabe onde está
        }
    }
    
    //trazer o de limparCampos

    public static void limparCampos(JComponent... vetComponentes) {
        for (JComponent componente : vetComponentes) {
            if(componente instanceof JTextField){
                ((JTextField) componente).setText("");
            }
            if(componente instanceof JComboBox){
                ((JComboBox) componente).setSelectedIndex(-1);
            }
            if(componente instanceof JCheckBox){
                ((JCheckBox) componente).setSelected(false);
            }  
            /*if(componente instanceof JPasswordField){
                ((JPasswordField) componente).setText("");
            }*/
        }
    }
    
    public static void mensagem(String cadeia){ //funciona para retornar uma mensagem de pergunta
        JOptionPane.showMessageDialog(null, cadeia); //cadeia é um parametro que represneta as mensagens que serão mostradas 
    }
    
    public static boolean perguntar(String cadeia){ //cadeia por causa de cadeia de caracteres -> pode ser qualquer nome 
       // JOptionPane.showMessageDialog(null, cadeia);
       //fazer se um if se clicar yes -> retorna true e se clicar no -> retorna false
       
        JOptionPane.showConfirmDialog(null, cadeia, "Perguntar", JOptionPane.YES_NO_OPTION); //yes.no.option -> pq queremos somente os botoes de sim e não
        int resp = 0;
        if (resp == JOptionPane.YES_OPTION){
            return true;
        } else{
            return false;
        }
        
    }
    
    public static int strInt(String cad){
        return Integer.valueOf(cad);
    }
    
    public static String intStr(int num){
        return "";
    }
    
    public static double strDouble(double card){
        return 0;
    }
    
    public static String doubleStr(double card){
        return "";
    }
    
    public static Date strDate(double card){
      return null; 
    }
    
    public static String dateStr(Date num){
        return "";
    }
    
}
