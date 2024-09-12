/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.TblCliente;
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
public class RepositorioTblCliente {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public void saveCliente(TblCliente c){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.save(c);
        
        trans.commit();
        session.close();
    }
    public void updateCliente(TblCliente c){
        Session session = factory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.update(c);
        trans.commit();
        session.close();
    }
    public void deleteCliente(TblCliente c){
        Session session = factory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
       session.delete(c);
       
       trans.commit();
       session.close();
         
    }
    
    public List searchClientePorNome(TblCliente c){
        List clientes = null;
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT {tbl_cliente.*}"+
                "FROM tbl_cliente {tbl_cliente} WHERE cliente_ultimonome= '"
                + c.getClientePrimeironome() 
                + " WHERE cliente_segundonome = '"
                +c.getClienteUltimonome()+ "'");
   query.addEntity("tbl_cliente",TblCliente.class);
        clientes = query.list();
        for(Object o: clientes){
            RepositorioTblCliente.initialize((TblCliente) o);
        }
        session.close();
        return clientes;
    }
    
    public List searchClientePorEmail(TblCliente c){
        List clientes = null;
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT {tbl_cliente.*}"+
                "FROM tbl_cliente {tbl_cliente} WHERE cliente_login= '"
                + c.getClienteEmail()+ "'");
        query.addEntity("tbl_cliente",TblCliente.class);
        clientes = query.list();
        
        for(Object o:clientes){
            RepositorioTblCliente.initialize((TblCliente) o);
            
        }
        session.close();
            return clientes;
    }
    
    
    public static void initialize(TblCliente c){
        Hibernate.initialize(c);
        Hibernate.initialize(c.getTblMetodosPagamentoClientes());
        Hibernate.initialize(c.getTblPedidos());
       
    }
    
    
}
