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
public class ControlelockPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;
    @Basic(optional = false)
    @Column(name = "IDENTIDADE")
    private String identidade;

    public ControlelockPK() {
    }

    public ControlelockPK(String nomeentidade, String identidade) {
        this.nomeentidade = nomeentidade;
        this.identidade = identidade;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeentidade != null ? nomeentidade.hashCode() : 0);
        hash += (identidade != null ? identidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlelockPK)) {
            return false;
        }
        ControlelockPK other = (ControlelockPK) object;
        if ((this.nomeentidade == null && other.nomeentidade != null) || (this.nomeentidade != null && !this.nomeentidade.equals(other.nomeentidade))) {
            return false;
        }
        if ((this.identidade == null && other.identidade != null) || (this.identidade != null && !this.identidade.equals(other.identidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.ControlelockPK[ nomeentidade=" + nomeentidade + ", identidade=" + identidade + " ]";
    }
    
}
