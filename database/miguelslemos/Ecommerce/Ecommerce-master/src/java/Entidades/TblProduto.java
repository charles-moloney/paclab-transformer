package Entidades;
// Generated 31/03/2015 20:14:15 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TblProduto generated by hbm2java
 */
public class TblProduto  implements java.io.Serializable {


     private Integer produtoCodigo;
     private TblRefTipoProduto tblRefTipoProduto;
     private String produtoNome;
     private String produtoDescricao;
     private BigDecimal produtoPreco;
     private int produtoQuantidade;
     private String produtoTamanho;
     private Set tblItensPedidos = new HashSet(0);

    public TblProduto() {
    }

	
    public TblProduto(TblRefTipoProduto tblRefTipoProduto, String produtoNome, String produtoDescricao, int produtoQuantidade) {
        this.tblRefTipoProduto = tblRefTipoProduto;
        this.produtoNome = produtoNome;
        this.produtoDescricao = produtoDescricao;
        this.produtoQuantidade = produtoQuantidade;
    }
    public TblProduto(TblRefTipoProduto tblRefTipoProduto, String produtoNome, String produtoDescricao, BigDecimal produtoPreco, int produtoQuantidade, String produtoTamanho, Set tblItensPedidos) {
       this.tblRefTipoProduto = tblRefTipoProduto;
       this.produtoNome = produtoNome;
       this.produtoDescricao = produtoDescricao;
       this.produtoPreco = produtoPreco;
       this.produtoQuantidade = produtoQuantidade;
       this.produtoTamanho = produtoTamanho;
       this.tblItensPedidos = tblItensPedidos;
    }
   
    public Integer getProdutoCodigo() {
        return this.produtoCodigo;
    }
    
    public void setProdutoCodigo(Integer produtoCodigo) {
        this.produtoCodigo = produtoCodigo;
    }
    public TblRefTipoProduto getTblRefTipoProduto() {
        return this.tblRefTipoProduto;
    }
    
    public void setTblRefTipoProduto(TblRefTipoProduto tblRefTipoProduto) {
        this.tblRefTipoProduto = tblRefTipoProduto;
    }
    public String getProdutoNome() {
        return this.produtoNome;
    }
    
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }
    public String getProdutoDescricao() {
        return this.produtoDescricao;
    }
    
    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }
    public BigDecimal getProdutoPreco() {
        return this.produtoPreco;
    }
    
    public void setProdutoPreco(BigDecimal produtoPreco) {
        this.produtoPreco = produtoPreco;
    }
    public int getProdutoQuantidade() {
        return this.produtoQuantidade;
    }
    
    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }
    public String getProdutoTamanho() {
        return this.produtoTamanho;
    }
    
    public void setProdutoTamanho(String produtoTamanho) {
        this.produtoTamanho = produtoTamanho;
    }
    public Set getTblItensPedidos() {
        return this.tblItensPedidos;
    }
    
    public void setTblItensPedidos(Set tblItensPedidos) {
        this.tblItensPedidos = tblItensPedidos;
    }




}

