/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class TmpFaturamentoorcamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODORC")
    private String codorc;
    @Basic(optional = false)
    @Column(name = "CODORCPROD")
    private String codorcprod;

    public TmpFaturamentoorcamentoPK() {
    }

    public TmpFaturamentoorcamentoPK(String codorc, String codorcprod) {
        this.codorc = codorc;
        this.codorcprod = codorcprod;
    }

    public String getCodorc() {
        return codorc;
    }

    public void setCodorc(String codorc) {
        this.codorc = codorc;
    }

    public String getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorc != null ? codorc.hashCode() : 0);
        hash += (codorcprod != null ? codorcprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpFaturamentoorcamentoPK)) {
            return false;
        }
        TmpFaturamentoorcamentoPK other = (TmpFaturamentoorcamentoPK) object;
        if ((this.codorc == null && other.codorc != null) || (this.codorc != null && !this.codorc.equals(other.codorc))) {
            return false;
        }
        if ((this.codorcprod == null && other.codorcprod != null) || (this.codorcprod != null && !this.codorcprod.equals(other.codorcprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpFaturamentoorcamentoPK[ codorc=" + codorc + ", codorcprod=" + codorcprod + " ]";
    }
    
}
