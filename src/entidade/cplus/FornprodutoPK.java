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
public class FornprodutoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODFORN")
    private String codforn;
    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;

    public FornprodutoPK() {
    }

    public FornprodutoPK(String codforn, String codprod) {
        this.codforn = codforn;
        this.codprod = codprod;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codforn != null ? codforn.hashCode() : 0);
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FornprodutoPK)) {
            return false;
        }
        FornprodutoPK other = (FornprodutoPK) object;
        if ((this.codforn == null && other.codforn != null) || (this.codforn != null && !this.codforn.equals(other.codforn))) {
            return false;
        }
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.FornprodutoPK[ codforn=" + codforn + ", codprod=" + codprod + " ]";
    }
    
}
