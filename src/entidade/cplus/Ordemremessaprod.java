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
@Table(name = "ORDEMREMESSAPROD", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemremessaprod.findAll", query = "SELECT o FROM Ordemremessaprod o")
    , @NamedQuery(name = "Ordemremessaprod.findByCodordremessaprod", query = "SELECT o FROM Ordemremessaprod o WHERE o.codordremessaprod = :codordremessaprod")
    , @NamedQuery(name = "Ordemremessaprod.findByCodprod", query = "SELECT o FROM Ordemremessaprod o WHERE o.codprod = :codprod")
    , @NamedQuery(name = "Ordemremessaprod.findByQuantidade", query = "SELECT o FROM Ordemremessaprod o WHERE o.quantidade = :quantidade")
    , @NamedQuery(name = "Ordemremessaprod.findByNumped", query = "SELECT o FROM Ordemremessaprod o WHERE o.numped = :numped")
    , @NamedQuery(name = "Ordemremessaprod.findByGuid", query = "SELECT o FROM Ordemremessaprod o WHERE o.guid = :guid")})
public class Ordemremessaprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDREMESSAPROD")
    private String codordremessaprod;
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "NUMPED")
    private Integer numped;
    @Basic(optional = false)
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODORDREMESSA", referencedColumnName = "CODORDREMESSA")
    @ManyToOne(optional = false)
    private Ordemremessa codordremessa;

    public Ordemremessaprod() {
    }

    public Ordemremessaprod(String codordremessaprod) {
        this.codordremessaprod = codordremessaprod;
    }

    public Ordemremessaprod(String codordremessaprod, String codprod, String guid) {
        this.codordremessaprod = codordremessaprod;
        this.codprod = codprod;
        this.guid = guid;
    }

    public String getCodordremessaprod() {
        return codordremessaprod;
    }

    public void setCodordremessaprod(String codordremessaprod) {
        this.codordremessaprod = codordremessaprod;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getNumped() {
        return numped;
    }

    public void setNumped(Integer numped) {
        this.numped = numped;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Ordemremessa getCodordremessa() {
        return codordremessa;
    }

    public void setCodordremessa(Ordemremessa codordremessa) {
        this.codordremessa = codordremessa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordremessaprod != null ? codordremessaprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemremessaprod)) {
            return false;
        }
        Ordemremessaprod other = (Ordemremessaprod) object;
        if ((this.codordremessaprod == null && other.codordremessaprod != null) || (this.codordremessaprod != null && !this.codordremessaprod.equals(other.codordremessaprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemremessaprod[ codordremessaprod=" + codordremessaprod + " ]";
    }
    
}
