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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TMP_INVENTARIO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpInventario.findAll", query = "SELECT t FROM TmpInventario t")
    , @NamedQuery(name = "TmpInventario.findByCodprod", query = "SELECT t FROM TmpInventario t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "TmpInventario.findByValor", query = "SELECT t FROM TmpInventario t WHERE t.valor = :valor")})
public class TmpInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;

    public TmpInventario() {
    }

    public TmpInventario(String codprod) {
        this.codprod = codprod;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpInventario)) {
            return false;
        }
        TmpInventario other = (TmpInventario) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpInventario[ codprod=" + codprod + " ]";
    }
    
}
