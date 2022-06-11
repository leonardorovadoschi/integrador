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
public class CesticmsclassificacaofiscalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODCESTICMS")
    private String codcesticms;
    @Basic(optional = false)
    @Column(name = "CODIGOCLASSIFICACAOFISCAL")
    private String codigoclassificacaofiscal;

    public CesticmsclassificacaofiscalPK() {
    }

    public CesticmsclassificacaofiscalPK(String codcesticms, String codigoclassificacaofiscal) {
        this.codcesticms = codcesticms;
        this.codigoclassificacaofiscal = codigoclassificacaofiscal;
    }

    public String getCodcesticms() {
        return codcesticms;
    }

    public void setCodcesticms(String codcesticms) {
        this.codcesticms = codcesticms;
    }

    public String getCodigoclassificacaofiscal() {
        return codigoclassificacaofiscal;
    }

    public void setCodigoclassificacaofiscal(String codigoclassificacaofiscal) {
        this.codigoclassificacaofiscal = codigoclassificacaofiscal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcesticms != null ? codcesticms.hashCode() : 0);
        hash += (codigoclassificacaofiscal != null ? codigoclassificacaofiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CesticmsclassificacaofiscalPK)) {
            return false;
        }
        CesticmsclassificacaofiscalPK other = (CesticmsclassificacaofiscalPK) object;
        if ((this.codcesticms == null && other.codcesticms != null) || (this.codcesticms != null && !this.codcesticms.equals(other.codcesticms))) {
            return false;
        }
        if ((this.codigoclassificacaofiscal == null && other.codigoclassificacaofiscal != null) || (this.codigoclassificacaofiscal != null && !this.codigoclassificacaofiscal.equals(other.codigoclassificacaofiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.CesticmsclassificacaofiscalPK[ codcesticms=" + codcesticms + ", codigoclassificacaofiscal=" + codigoclassificacaofiscal + " ]";
    }
    
}
