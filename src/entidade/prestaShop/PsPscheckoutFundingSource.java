/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "ps_pscheckout_funding_source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutFundingSource.findAll", query = "SELECT p FROM PsPscheckoutFundingSource p")})
public class PsPscheckoutFundingSource implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsPscheckoutFundingSourcePK psPscheckoutFundingSourcePK;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private short position;

    public PsPscheckoutFundingSource() {
    }

    public PsPscheckoutFundingSource(PsPscheckoutFundingSourcePK psPscheckoutFundingSourcePK) {
        this.psPscheckoutFundingSourcePK = psPscheckoutFundingSourcePK;
    }

    public PsPscheckoutFundingSource(PsPscheckoutFundingSourcePK psPscheckoutFundingSourcePK, short active, short position) {
        this.psPscheckoutFundingSourcePK = psPscheckoutFundingSourcePK;
        this.active = active;
        this.position = position;
    }

    public PsPscheckoutFundingSource(String name, int idShop) {
        this.psPscheckoutFundingSourcePK = new PsPscheckoutFundingSourcePK(name, idShop);
    }

    public PsPscheckoutFundingSourcePK getPsPscheckoutFundingSourcePK() {
        return psPscheckoutFundingSourcePK;
    }

    public void setPsPscheckoutFundingSourcePK(PsPscheckoutFundingSourcePK psPscheckoutFundingSourcePK) {
        this.psPscheckoutFundingSourcePK = psPscheckoutFundingSourcePK;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psPscheckoutFundingSourcePK != null ? psPscheckoutFundingSourcePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutFundingSource)) {
            return false;
        }
        PsPscheckoutFundingSource other = (PsPscheckoutFundingSource) object;
        if ((this.psPscheckoutFundingSourcePK == null && other.psPscheckoutFundingSourcePK != null) || (this.psPscheckoutFundingSourcePK != null && !this.psPscheckoutFundingSourcePK.equals(other.psPscheckoutFundingSourcePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutFundingSource[ psPscheckoutFundingSourcePK=" + psPscheckoutFundingSourcePK + " ]";
    }
    
}
