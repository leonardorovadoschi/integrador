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
@Table(name = "MOVENTRADAPRODFCI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradaprodfci.findAll", query = "SELECT m FROM Moventradaprodfci m")
    , @NamedQuery(name = "Moventradaprodfci.findByCodmoventradaprodfci", query = "SELECT m FROM Moventradaprodfci m WHERE m.codmoventradaprodfci = :codmoventradaprodfci")
    , @NamedQuery(name = "Moventradaprodfci.findByQuantidade", query = "SELECT m FROM Moventradaprodfci m WHERE m.quantidade = :quantidade")})
public class Moventradaprodfci implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTRADAPRODFCI")
    private String codmoventradaprodfci;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne(optional = false)
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPRODUTOFCI", referencedColumnName = "CODPRODUTOFCI")
    @ManyToOne(optional = false)
    private Produtofci codprodutofci;

    public Moventradaprodfci() {
    }

    public Moventradaprodfci(String codmoventradaprodfci) {
        this.codmoventradaprodfci = codmoventradaprodfci;
    }

    public String getCodmoventradaprodfci() {
        return codmoventradaprodfci;
    }

    public void setCodmoventradaprodfci(String codmoventradaprodfci) {
        this.codmoventradaprodfci = codmoventradaprodfci;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
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
        hash += (codmoventradaprodfci != null ? codmoventradaprodfci.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradaprodfci)) {
            return false;
        }
        Moventradaprodfci other = (Moventradaprodfci) object;
        if ((this.codmoventradaprodfci == null && other.codmoventradaprodfci != null) || (this.codmoventradaprodfci != null && !this.codmoventradaprodfci.equals(other.codmoventradaprodfci))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradaprodfci[ codmoventradaprodfci=" + codmoventradaprodfci + " ]";
    }
    
}
