/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anmegamenu_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnmegamenuGroups.findAll", query = "SELECT p FROM PsAnmegamenuGroups p")})
public class PsAnmegamenuGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnmegamenuGroupsPK psAnmegamenuGroupsPK;

    public PsAnmegamenuGroups() {
    }

    public PsAnmegamenuGroups(PsAnmegamenuGroupsPK psAnmegamenuGroupsPK) {
        this.psAnmegamenuGroupsPK = psAnmegamenuGroupsPK;
    }

    public PsAnmegamenuGroups(int idGroup, int idAnmenu) {
        this.psAnmegamenuGroupsPK = new PsAnmegamenuGroupsPK(idGroup, idAnmenu);
    }

    public PsAnmegamenuGroupsPK getPsAnmegamenuGroupsPK() {
        return psAnmegamenuGroupsPK;
    }

    public void setPsAnmegamenuGroupsPK(PsAnmegamenuGroupsPK psAnmegamenuGroupsPK) {
        this.psAnmegamenuGroupsPK = psAnmegamenuGroupsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnmegamenuGroupsPK != null ? psAnmegamenuGroupsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnmegamenuGroups)) {
            return false;
        }
        PsAnmegamenuGroups other = (PsAnmegamenuGroups) object;
        if ((this.psAnmegamenuGroupsPK == null && other.psAnmegamenuGroupsPK != null) || (this.psAnmegamenuGroupsPK != null && !this.psAnmegamenuGroupsPK.equals(other.psAnmegamenuGroupsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnmegamenuGroups[ psAnmegamenuGroupsPK=" + psAnmegamenuGroupsPK + " ]";
    }
    
}
