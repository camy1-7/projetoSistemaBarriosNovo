/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author u07870835188
 */
public abstract class DAO_Abstract {
    
    Session session;
    
    public DAO_Abstract(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public abstract void insert(Object object);  //metodo abstrato só é criado quando utilizamos o abstract
    public abstract void update(Object object); // ctrl + shift + seta pra baixo = copia a linha 
    public abstract void delete(Object object); //utiliza o object pq é generico e pode ser usado para varios tipos - string, int, double e etc
    public abstract Object list(int id);
    public abstract List listAll();
    
    public void mensagem(String texto){
        System.out.println(texto); //digitando sout + TAB = ele completa com a frase System.out.println()
        System.out.println("");
    }
}
