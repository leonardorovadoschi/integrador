/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOPRECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtopreco.findAll", query = "SELECT p FROM Produtopreco p")
    , @NamedQuery(name = "Produtopreco.findByCodprodutopreco", query = "SELECT p FROM Produtopreco p WHERE p.codprodutopreco = :codprodutopreco")
    , @NamedQuery(name = "Produtopreco.findByMargem", query = "SELECT p FROM Produtopreco p WHERE p.margem = :margem")
    , @NamedQuery(name = "Produtopreco.findByPreco", query = "SELECT p FROM Produtopreco p WHERE p.preco = :preco")
    , @NamedQuery(name = "Produtopreco.findByDatareajuste", query = "SELECT p FROM Produtopreco p WHERE p.datareajuste = :datareajuste")
    , @NamedQuery(name = "Produtopreco.findByQuantidademinima", query = "SELECT p FROM Produtopreco p WHERE p.quantidademinima = :quantidademinima")
    , @NamedQuery(name = "Produtopreco.findByGuid", query = "SELECT p FROM Produtopreco p WHERE p.guid = :guid")
    , @NamedQuery(name = "Produtopreco.findByFlagaltpaf", query = "SELECT p FROM Produtopreco p WHERE p.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Produtopreco.findByFlagprodutoprecoexpafv", query = "SELECT p FROM Produtopreco p WHERE p.flagprodutoprecoexpafv = :flagprodutoprecoexpafv")})
public class Produtopreco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOPRECO")
    private String codprodutopreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MARGEM")
    private BigDecimal margem;
    @Column(name = "PRECO")
    private BigDecimal preco;
    @Column(name = "DATAREAJUSTE")
    @Temporal(TemporalType.DATE)
    private Date datareajuste;
    @Column(name = "QUANTIDADEMINIMA")
    private BigDecimal quantidademinima;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "FLAGPRODUTOPRECOEXPAFV")
    private Character flagprodutoprecoexpafv;
    @JoinColumn(name = "CODMOEDA", referencedColumnName = "CODMOEDA")
    @ManyToOne
    private Moeda codmoeda;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne(optional = false)
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtopreco() {
    }

    public Produtopreco(String codprodutopreco) {
        this.codprodutopreco = codprodutopreco;
    }

    public String getCodprodutopreco() {
        return codprodutopreco;
    }

    public void setCodprodutopreco(String codprodutopreco) {
        this.codprodutopreco = codprodutopreco;
    }

    public BigDecimal getMargem() {
        return margem;
    }

    public void setMargem(BigDecimal margem) {
        this.margem = margem;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDatareajuste() {
        return datareajuste;
    }

    public void setDatareajuste(Date datareajuste) {
        this.datareajuste = datareajuste;
    }

    public BigDecimal getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(BigDecimal quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Character getFlagprodutoprecoexpafv() {
        return flagprodutoprecoexpafv;
    }

    public void setFlagprodutoprecoexpafv(Character flagprodutoprecoexpafv) {
        this.flagprodutoprecoexpafv = flagprodutoprecoexpafv;
    }

    public Moeda getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(Moeda codmoeda) {
        this.codmoeda = codmoeda;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutopreco != null ? codprodutopreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtopreco)) {
            return false;
        }
        Produtopreco other = (Produtopreco) object;
        if ((this.codprodutopreco == null && other.codprodutopreco != null) || (this.codprodutopreco != null && !this.codprodutopreco.equals(other.codprodutopreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtopreco[ codprodutopreco=" + codprodutopreco + " ]";
    }
    
}
