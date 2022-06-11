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
 * @author leo
 */
@Entity
@Table(name = "ps_homeslider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHomeslider.findAll", query = "SELECT p FROM PsHomeslider p")
    , @NamedQuery(name = "PsHomeslider.findByIdHomesliderSlides", query = "SELECT p FROM PsHomeslider p WHERE p.psHomesliderPK.idHomesliderSlides = :idHomesliderSlides")
    , @NamedQuery(name = "PsHomeslider.findByIdShop", query = "SELECT p FROM PsHomeslider p WHERE p.psHomesliderPK.idShop = :idShop")})
public class PsHomeslider implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsHomesliderPK psHomesliderPK;

    public PsHomeslider() {
    }

    public PsHomeslider(PsHomesliderPK psHomesliderPK) {
        this.psHomesliderPK = psHomesliderPK;
    }

    public PsHomeslider(int idHomesliderSlides, int idShop) {
        this.psHomesliderPK = new PsHomesliderPK(idHomesliderSlides, idShop);
    }

    public PsHomesliderPK getPsHomesliderPK() {
        return psHomesliderPK;
    }

    public void setPsHomesliderPK(PsHomesliderPK psHomesliderPK) {
        this.psHomesliderPK = psHomesliderPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psHomesliderPK != null ? psHomesliderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHomeslider)) {
            return false;
        }
        PsHomeslider other = (PsHomeslider) object;
        if ((this.psHomesliderPK == null && other.psHomesliderPK != null) || (this.psHomesliderPK != null && !this.psHomesliderPK.equals(other.psHomesliderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHomeslider[ psHomesliderPK=" + psHomesliderPK + " ]";
    }
    
}
