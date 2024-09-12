/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.TblCliente;
import Entidades.TblMetodosPagamentoCliente;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Util.HibernateUtil;
import org.hibernate.Hibernate;

/**
 *
 * @author MiguelLemos
 */
public class RepositorioTblMetodosPagamentoCliente {
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public void saveMetodoPagamentoCliente(TblMetodosPagamentoCliente c){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.save(c);
        
        trans.commit();
        session.close();
    }
    public void updateMetodoPagamentoCliente(TblMetodosPagamentoCliente c){
        Session session = factory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.update(c);
        trans.commit();
        session.close();
    }
    public void deleteMetodoPagamentoCliente(TblMetodosPagamentoCliente c){
        Session session = factory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
       session.delete(c);
       
       
       trans.commit();
       session.close();
         
    }
}
