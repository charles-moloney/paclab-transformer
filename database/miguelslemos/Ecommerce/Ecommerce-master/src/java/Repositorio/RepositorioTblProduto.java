/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.TblProduto;
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
public class RepositorioTblProduto {
    
    SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public void savePrduto(TblProduto p){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.save(p);
        
        trans.commit();
        session.close();
    }
    
    public void updateProduto(TblProduto p){
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.update(p);
        
        trans.commit();
        session.close();
        
    }
    
    public void deleteProduto(TblProduto p){
        Session session = factory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        trans.begin();
        
        session.delete(p);
        trans.commit();
        session.close();
        
    }
    
    public List searchProdutoPorNome(TblProduto p){
        List produtos = null;
        Session session = factory.getCurrentSession();
        SQLQuery query =session.createSQLQuery("SELECT{tbl_produto.*}"+
                "FROM tbl_produto {produto} WHERE produto_nome= '"
                + p.getProdutoNome()+ "'");
        
        query.addEntity("produto",TblProduto.class);
        produtos = query.list();
        
        for(Object o: produtos){
            RepositorioTblProduto.initializa((TblProduto) o);
           
        }
        session.close();
        return produtos;
        
    }
    
    public List searchProdutoPorDescricao(TblProduto p){
      List produtos = null;
        Session session = factory.getCurrentSession();
        SQLQuery query =session.createSQLQuery("SELECT{tbl_produto.*}"+
                "FROM tbl_produto {produto} WHERE produto_descricao = '"
                + p.getProdutoDescricao()+ "'");
        
        query.addEntity("produto",TblProduto.class);
        produtos = query.list();
        
        for(Object o: produtos){
            RepositorioTblProduto.initializa((TblProduto) o);
           
        }
        session.close();
        return produtos;
        
    }
    
    public static void initializa(TblProduto p){
        Hibernate.initialize(p);
        Hibernate.initialize(p.getTblItensPedidos());
    }
    
}
