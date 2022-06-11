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
public class RelatoriopastaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMEPASTA")
    private String nomepasta;
    @Basic(optional = false)
    @Column(name = "CODRELATORIOPASTAPAI")
    private int codrelatoriopastapai;

    public RelatoriopastaPK() {
    }

    public RelatoriopastaPK(String nomepasta, int codrelatoriopastapai) {
        this.nomepasta = nomepasta;
        this.codrelatoriopastapai = codrelatoriopastapai;
    }

    public String getNomepasta() {
        return nomepasta;
    }

    public void setNomepasta(String nomepasta) {
        this.nomepasta = nomepasta;
    }

    public int getCodrelatoriopastapai() {
        return codrelatoriopastapai;
    }

    public void setCodrelatoriopastapai(int codrelatoriopastapai) {
        this.codrelatoriopastapai = codrelatoriopastapai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomepasta != null ? nomepasta.hashCode() : 0);
        hash += (int) codrelatoriopastapai;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatoriopastaPK)) {
            return false;
        }
        RelatoriopastaPK other = (RelatoriopastaPK) object;
        if ((this.nomepasta == null && other.nomepasta != null) || (this.nomepasta != null && !this.nomepasta.equals(other.nomepasta))) {
            return false;
        }
        if (this.codrelatoriopastapai != other.codrelatoriopastapai) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.RelatoriopastaPK[ nomepasta=" + nomepasta + ", codrelatoriopastapai=" + codrelatoriopastapai + " ]";
    }
    
}
