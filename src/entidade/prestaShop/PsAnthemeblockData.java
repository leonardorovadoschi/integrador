/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anthemeblock_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnthemeblockData.findAll", query = "SELECT p FROM PsAnthemeblockData p")})
public class PsAnthemeblockData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anthemeblock_data")
    private Integer idAnthemeblockData;
    @Basic(optional = false)
    @Column(name = "id_anthemeblock")
    private int idAnthemeblock;

    public PsAnthemeblockData() {
    }

    public PsAnthemeblockData(Integer idAnthemeblockData) {
        this.idAnthemeblockData = idAnthemeblockData;
    }

    public PsAnthemeblockData(Integer idAnthemeblockData, int idAnthemeblock) {
        this.idAnthemeblockData = idAnthemeblockData;
        this.idAnthemeblock = idAnthemeblock;
    }

    public Integer getIdAnthemeblockData() {
        return idAnthemeblockData;
    }

    public void setIdAnthemeblockData(Integer idAnthemeblockData) {
        this.idAnthemeblockData = idAnthemeblockData;
    }

    public int getIdAnthemeblock() {
        return idAnthemeblock;
    }

    public void setIdAnthemeblock(int idAnthemeblock) {
        this.idAnthemeblock = idAnthemeblock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnthemeblockData != null ? idAnthemeblockData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockData)) {
            return false;
        }
        PsAnthemeblockData other = (PsAnthemeblockData) object;
        if ((this.idAnthemeblockData == null && other.idAnthemeblockData != null) || (this.idAnthemeblockData != null && !this.idAnthemeblockData.equals(other.idAnthemeblockData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockData[ idAnthemeblockData=" + idAnthemeblockData + " ]";
    }
    
}
