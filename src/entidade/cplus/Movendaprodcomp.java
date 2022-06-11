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
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENDAPRODCOMP", catalog = "", schema = "")

public class Movendaprodcomp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDAPRODCOMP")
    private String codmovendaprodcomp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "CUSTOMEDIO")
    private BigDecimal customedio;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne(optional = false)
    private Movendaprod codmovprod;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Movendaprodcomp() {
    }

    public Movendaprodcomp(String codmovendaprodcomp) {
        this.codmovendaprodcomp = codmovendaprodcomp;
    }

    public Movendaprodcomp(String codmovendaprodcomp, BigDecimal quantidade) {
        this.codmovendaprodcomp = codmovendaprodcomp;
        this.quantidade = quantidade;
    }

    public String getCodmovendaprodcomp() {
        return codmovendaprodcomp;
    }

    public void setCodmovendaprodcomp(String codmovendaprodcomp) {
        this.codmovendaprodcomp = codmovendaprodcomp;
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

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
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
        hash += (codmovendaprodcomp != null ? codmovendaprodcomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprodcomp)) {
            return false;
        }
        Movendaprodcomp other = (Movendaprodcomp) object;
        if ((this.codmovendaprodcomp == null && other.codmovendaprodcomp != null) || (this.codmovendaprodcomp != null && !this.codmovendaprodcomp.equals(other.codmovendaprodcomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprodcomp[ codmovendaprodcomp=" + codmovendaprodcomp + " ]";
    }
    
}
