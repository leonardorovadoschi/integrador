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
public class TmpContratocobrancaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCA")
    private String codcontratocobranca;
    @Basic(optional = false)
    @Column(name = "CODCONTRATOCOBRANCAPRODUTO")
    private String codcontratocobrancaproduto;

    public TmpContratocobrancaPK() {
    }

    public TmpContratocobrancaPK(String codcontratocobranca, String codcontratocobrancaproduto) {
        this.codcontratocobranca = codcontratocobranca;
        this.codcontratocobrancaproduto = codcontratocobrancaproduto;
    }

    public String getCodcontratocobranca() {
        return codcontratocobranca;
    }

    public void setCodcontratocobranca(String codcontratocobranca) {
        this.codcontratocobranca = codcontratocobranca;
    }

    public String getCodcontratocobrancaproduto() {
        return codcontratocobrancaproduto;
    }

    public void setCodcontratocobrancaproduto(String codcontratocobrancaproduto) {
        this.codcontratocobrancaproduto = codcontratocobrancaproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontratocobranca != null ? codcontratocobranca.hashCode() : 0);
        hash += (codcontratocobrancaproduto != null ? codcontratocobrancaproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpContratocobrancaPK)) {
            return false;
        }
        TmpContratocobrancaPK other = (TmpContratocobrancaPK) object;
        if ((this.codcontratocobranca == null && other.codcontratocobranca != null) || (this.codcontratocobranca != null && !this.codcontratocobranca.equals(other.codcontratocobranca))) {
            return false;
        }
        if ((this.codcontratocobrancaproduto == null && other.codcontratocobrancaproduto != null) || (this.codcontratocobrancaproduto != null && !this.codcontratocobrancaproduto.equals(other.codcontratocobrancaproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpContratocobrancaPK[ codcontratocobranca=" + codcontratocobranca + ", codcontratocobrancaproduto=" + codcontratocobrancaproduto + " ]";
    }
    
}
