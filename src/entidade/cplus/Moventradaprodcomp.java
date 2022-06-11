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
@Table(name = "MOVENTRADAPRODCOMP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradaprodcomp.findAll", query = "SELECT m FROM Moventradaprodcomp m")
    , @NamedQuery(name = "Moventradaprodcomp.findByCodmoventradaprodcomp", query = "SELECT m FROM Moventradaprodcomp m WHERE m.codmoventradaprodcomp = :codmoventradaprodcomp")
    , @NamedQuery(name = "Moventradaprodcomp.findByQuantidade", query = "SELECT m FROM Moventradaprodcomp m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Moventradaprodcomp.findByCustoreal", query = "SELECT m FROM Moventradaprodcomp m WHERE m.custoreal = :custoreal")
    , @NamedQuery(name = "Moventradaprodcomp.findByCustomedio", query = "SELECT m FROM Moventradaprodcomp m WHERE m.customedio = :customedio")
    , @NamedQuery(name = "Moventradaprodcomp.findByLastChange", query = "SELECT m FROM Moventradaprodcomp m WHERE m.lastChange = :lastChange")})
public class Moventradaprodcomp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENTRADAPRODCOMP")
    private Integer codmoventradaprodcomp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "CUSTOMEDIO")
    private BigDecimal customedio;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne(optional = false)
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Moventradaprodcomp() {
    }

    public Moventradaprodcomp(Integer codmoventradaprodcomp) {
        this.codmoventradaprodcomp = codmoventradaprodcomp;
    }

    public Moventradaprodcomp(Integer codmoventradaprodcomp, BigDecimal quantidade) {
        this.codmoventradaprodcomp = codmoventradaprodcomp;
        this.quantidade = quantidade;
    }

    public Integer getCodmoventradaprodcomp() {
        return codmoventradaprodcomp;
    }

    public void setCodmoventradaprodcomp(Integer codmoventradaprodcomp) {
        this.codmoventradaprodcomp = codmoventradaprodcomp;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        this.customedio = customedio;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
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
        hash += (codmoventradaprodcomp != null ? codmoventradaprodcomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradaprodcomp)) {
            return false;
        }
        Moventradaprodcomp other = (Moventradaprodcomp) object;
        if ((this.codmoventradaprodcomp == null && other.codmoventradaprodcomp != null) || (this.codmoventradaprodcomp != null && !this.codmoventradaprodcomp.equals(other.codmoventradaprodcomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradaprodcomp[ codmoventradaprodcomp=" + codmoventradaprodcomp + " ]";
    }
    
}
