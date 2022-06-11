/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_message_readed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMessageReaded.findAll", query = "SELECT p FROM PsMessageReaded p")
    , @NamedQuery(name = "PsMessageReaded.findByIdMessage", query = "SELECT p FROM PsMessageReaded p WHERE p.psMessageReadedPK.idMessage = :idMessage")
    , @NamedQuery(name = "PsMessageReaded.findByIdEmployee", query = "SELECT p FROM PsMessageReaded p WHERE p.psMessageReadedPK.idEmployee = :idEmployee")
    , @NamedQuery(name = "PsMessageReaded.findByDateAdd", query = "SELECT p FROM PsMessageReaded p WHERE p.dateAdd = :dateAdd")})
public class PsMessageReaded implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsMessageReadedPK psMessageReadedPK;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsMessageReaded() {
    }

    public PsMessageReaded(PsMessageReadedPK psMessageReadedPK) {
        this.psMessageReadedPK = psMessageReadedPK;
    }

    public PsMessageReaded(PsMessageReadedPK psMessageReadedPK, Date dateAdd) {
        this.psMessageReadedPK = psMessageReadedPK;
        this.dateAdd = dateAdd;
    }

    public PsMessageReaded(int idMessage, int idEmployee) {
        this.psMessageReadedPK = new PsMessageReadedPK(idMessage, idEmployee);
    }

    public PsMessageReadedPK getPsMessageReadedPK() {
        return psMessageReadedPK;
    }

    public void setPsMessageReadedPK(PsMessageReadedPK psMessageReadedPK) {
        this.psMessageReadedPK = psMessageReadedPK;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psMessageReadedPK != null ? psMessageReadedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMessageReaded)) {
            return false;
        }
        PsMessageReaded other = (PsMessageReaded) object;
        if ((this.psMessageReadedPK == null && other.psMessageReadedPK != null) || (this.psMessageReadedPK != null && !this.psMessageReadedPK.equals(other.psMessageReadedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMessageReaded[ psMessageReadedPK=" + psMessageReadedPK + " ]";
    }
    
}
