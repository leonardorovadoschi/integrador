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
public class EmpresafilialPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODEMPRESAMATRIZ")
    private int codempresamatriz;
    @Basic(optional = false)
    @Column(name = "CODEMPRESAFILIAL")
    private int codempresafilial;

    public EmpresafilialPK() {
    }

    public EmpresafilialPK(int codempresamatriz, int codempresafilial) {
        this.codempresamatriz = codempresamatriz;
        this.codempresafilial = codempresafilial;
    }

    public int getCodempresamatriz() {
        return codempresamatriz;
    }

    public void setCodempresamatriz(int codempresamatriz) {
        this.codempresamatriz = codempresamatriz;
    }

    public int getCodempresafilial() {
        return codempresafilial;
    }

    public void setCodempresafilial(int codempresafilial) {
        this.codempresafilial = codempresafilial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresamatriz;
        hash += (int) codempresafilial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresafilialPK)) {
            return false;
        }
        EmpresafilialPK other = (EmpresafilialPK) object;
        if (this.codempresamatriz != other.codempresamatriz) {
            return false;
        }
        if (this.codempresafilial != other.codempresafilial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.EmpresafilialPK[ codempresamatriz=" + codempresamatriz + ", codempresafilial=" + codempresafilial + " ]";
    }
    
}
