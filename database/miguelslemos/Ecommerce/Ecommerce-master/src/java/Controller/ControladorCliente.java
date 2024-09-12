/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entidades.TblCliente;
import java.util.List;
import Repositorio.RepositorioTblCliente;

/**
 *
 * @author MiguelLemos
 */
public class ControladorCliente {
    
    private RepositorioTblCliente repCliente;
    
    public ControladorCliente(){
        this.repCliente = new RepositorioTblCliente();
        
    }
    
    public void saveCliente(TblCliente c) throws Exception{
       //falta verificar se email ja é existente
        if(c.getClienteEmail()!="" && c.getClienteLogin()!="" && c.getClienteSenha()!=""){
         
            
            
        }
       
    }
    
}
