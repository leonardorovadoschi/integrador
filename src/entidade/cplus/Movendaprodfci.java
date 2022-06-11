/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENDAPRODFCI", catalog = "", schema = "")

public class Movendaprodfci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDAPRODFCI")
    private String codmovendaprodfci;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "QUANTIDADEDEVOLVIDA")
    private BigDecimal quantidadedevolvida;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODPRODUTOFCI", referencedColumnName = "CODPRODUTOFCI")
    @ManyToOne(optional = false)
    private Produtofci codprodutofci;

    public Movendaprodfci() {
    }

    public Movendaprodfci(String codmovendaprodfci) {
        this.codmovendaprodfci = codmovendaprodfci;
    }

    public String getCodmovendaprodfci() {
        return codmovendaprodfci;
    }

    public void setCodmovendaprodfci(String codmovendaprodfci) {
        this.codmovendaprodfci = codmovendaprodfci;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public BigDecimal getQuantidadedevolvida() {
        return quantidadedevolvida;
    }

    public void setQuantidadedevolvida(BigDecimal quantidadedevolvida) {
        this.quantidadedevolvida = quantidadedevolvida;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Produtofci getCodprodutofci() {
        return codprodutofci;
    }

    public void setCodprodutofci(Produtofci codprodutofci) {
        this.codprodutofci = codprodutofci;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovendaprodfci != null ? codmovendaprodfci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprodfci)) {
            return false;
        }
        Movendaprodfci other = (Movendaprodfci) object;
        if ((this.codmovendaprodfci == null && other.codmovendaprodfci != null) || (this.codmovendaprodfci != null && !this.codmovendaprodfci.equals(other.codmovendaprodfci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprodfci[ codmovendaprodfci=" + codmovendaprodfci + " ]";
    }
    
}
