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
public class RelatoriocampoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMETABELA")
    private String nometabela;
    @Basic(optional = false)
    @Column(name = "NOMECAMPO")
    private String nomecampo;

    public RelatoriocampoPK() {
    }

    public RelatoriocampoPK(String nometabela, String nomecampo) {
        this.nometabela = nometabela;
        this.nomecampo = nomecampo;
    }

    public String getNometabela() {
        return nometabela;
    }

    public void setNometabela(String nometabela) {
        this.nometabela = nometabela;
    }

    public String getNomecampo() {
        return nomecampo;
    }

    public void setNomecampo(String nomecampo) {
        this.nomecampo = nomecampo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nometabela != null ? nometabela.hashCode() : 0);
        hash += (nomecampo != null ? nomecampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatoriocampoPK)) {
            return false;
        }
        RelatoriocampoPK other = (RelatoriocampoPK) object;
        if ((this.nometabela == null && other.nometabela != null) || (this.nometabela != null && !this.nometabela.equals(other.nometabela))) {
            return false;
        }
        if ((this.nomecampo == null && other.nomecampo != null) || (this.nomecampo != null && !this.nomecampo.equals(other.nomecampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.RelatoriocampoPK[ nometabela=" + nometabela + ", nomecampo=" + nomecampo + " ]";
    }
    
}
