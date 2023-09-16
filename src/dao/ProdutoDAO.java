/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ClbProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DELL
 */
public class ProdutoDAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {//todas as operações ocm bd são feitas com transações(ações)
        session.beginTransaction(); //começou a transação
        session.save(object); //salvar o objeto é o insert
        session.getTransaction().commit(); //todas as operações terminam com "commit" (gravar) ou "rollback" (apagar)
        //não coloca flush() e clear() pq no insert manda uma nova informação e no uodate e no delete vc pega uma que ja existe
    }

    @Override
    public void update(Object object) {
        session.beginTransaction(); //começou a transação
        session.flush(); //pq vai limpar o cash do hibernate pra nao gravar coisas erradas 
        session.clear();
        session.update(object); //update pq é para mudar/atualizar o objeto
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction(); //começou a transação
        session.flush();
        session.clear();
        session.delete(object); //delete pq é para apagar o objeto
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction(); //sempre faz uma transação, independente se manda ou pega registros
        //antes o comando sql que fazia o listA era o "SELECT * from tabela WHERE id" que agora substitui pela criação de um objeto
        Criteria criteria = session.createCriteria(ClbProduto.class); //importa o bean e a classe Criteria
        //o eq é o equals pq o parametro tem que ser igual ao campo do bean 
        criteria.add(Restrictions.eq("clbIdproduto", id)); //adiciona uma Restriction que seria uma restrição, que substitui a clausala WHERE - é uma classe statica que não instancia
        List lista = criteria.list(); //cria uma lista com os registros do banco de dados 
        session.getTransaction().commit();
        return lista.get(0); //retorna a lista com os beans
    }

    @Override
    public List listAll() {
        session.beginTransaction(); //sempre faz uma transação, independente se manda ou pega registros
        //antes o comando sql que fazia o listAll era o "SELECT * from tabela" que agora substitui pela criação de um objeto
        Criteria criteria = session.createCriteria(ClbProduto.class); //importa o bean e a classe Criteria
        List lista = criteria.list(); //cria uma lista com os registros do banco de dados 
        session.getTransaction().commit();
        return lista; //retorna a lista com os beans
    }
    
}
