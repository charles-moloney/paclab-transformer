package Entidades;
// Generated 31/03/2015 20:14:15 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * TblPedidoItemStatus generated by hbm2java
 */
public class TblPedidoItemStatus  implements java.io.Serializable {


     private Integer pedidoItemStatusCodigo;
     private String pedidoItemDescricao;
     private Set tblItensPedidos = new HashSet(0);

    public TblPedidoItemStatus() {
    }

	
    public TblPedidoItemStatus(String pedidoItemDescricao) {
        this.pedidoItemDescricao = pedidoItemDescricao;
    }
    public TblPedidoItemStatus(String pedidoItemDescricao, Set tblItensPedidos) {
       this.pedidoItemDescricao = pedidoItemDescricao;
       this.tblItensPedidos = tblItensPedidos;
    }
   
    public Integer getPedidoItemStatusCodigo() {
        return this.pedidoItemStatusCodigo;
    }
    
    public void setPedidoItemStatusCodigo(Integer pedidoItemStatusCodigo) {
        this.pedidoItemStatusCodigo = pedidoItemStatusCodigo;
    }
    public String getPedidoItemDescricao() {
        return this.pedidoItemDescricao;
    }
    
    public void setPedidoItemDescricao(String pedidoItemDescricao) {
        this.pedidoItemDescricao = pedidoItemDescricao;
    }
    public Set getTblItensPedidos() {
        return this.tblItensPedidos;
    }
    
    public void setTblItensPedidos(Set tblItensPedidos) {
        this.tblItensPedidos = tblItensPedidos;
    }




}

