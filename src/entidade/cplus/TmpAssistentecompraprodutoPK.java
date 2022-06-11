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
public class TmpAssistentecompraprodutoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODPROD")
    private String codprod;
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;

    public TmpAssistentecompraprodutoPK() {
    }

    public TmpAssistentecompraprodutoPK(String codprod, int codempresa) {
        this.codprod = codprod;
        this.codempresa = codempresa;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        hash += (int) codempresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpAssistentecompraprodutoPK)) {
            return false;
        }
        TmpAssistentecompraprodutoPK other = (TmpAssistentecompraprodutoPK) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        if (this.codempresa != other.codempresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpAssistentecompraprodutoPK[ codprod=" + codprod + ", codempresa=" + codempresa + " ]";
    }
    
}
