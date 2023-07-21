/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
        Integer oldCodmoventradaprodcomp = this.codmoventradaprodcomp;
        this.codmoventradaprodcomp = codmoventradaprodcomp;
        changeSupport.firePropertyChange("codmoventradaprodcomp", oldCodmoventradaprodcomp, codmoventradaprodcomp);
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        BigDecimal oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        BigDecimal oldCustoreal = this.custoreal;
        this.custoreal = custoreal;
        changeSupport.firePropertyChange("custoreal", oldCustoreal, custoreal);
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        BigDecimal oldCustomedio = this.customedio;
        this.customedio = customedio;
        changeSupport.firePropertyChange("customedio", oldCustomedio, customedio);
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        Date oldLastChange = this.lastChange;
        this.lastChange = lastChange;
        changeSupport.firePropertyChange("lastChange", oldLastChange, lastChange);
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        Moventradaprod oldCodmoveprod = this.codmoveprod;
        this.codmoveprod = codmoveprod;
        changeSupport.firePropertyChange("codmoveprod", oldCodmoveprod, codmoveprod);
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        Produto oldCodprod = this.codprod;
        this.codprod = codprod;
        changeSupport.firePropertyChange("codprod", oldCodprod, codprod);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
