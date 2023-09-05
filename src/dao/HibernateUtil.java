/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.cfg.AnnotationConfiguration;//pode dar erro se não fizer o mapeamento
import org.hibernate.SessionFactory;//some o erro quando adiciona a biblioteca hibernate 4.3.x (mas se faz o mapeamento não precisa)

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author u07870835188
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {//cria uma vez a conexão e ir usando como uma fabrica -> é estático pq não precisa instanciar 
        return sessionFactory;
    }
}
