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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ps_stock_mvt_reason")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStockMvtReason.findAll", query = "SELECT p FROM PsStockMvtReason p")
    , @NamedQuery(name = "PsStockMvtReason.findByIdStockMvtReason", query = "SELECT p FROM PsStockMvtReason p WHERE p.idStockMvtReason = :idStockMvtReason")
    , @NamedQuery(name = "PsStockMvtReason.findBySign", query = "SELECT p FROM PsStockMvtReason p WHERE p.sign = :sign")
    , @NamedQuery(name = "PsStockMvtReason.findByDateAdd", query = "SELECT p FROM PsStockMvtReason p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsStockMvtReason.findByDateUpd", query = "SELECT p FROM PsStockMvtReason p WHERE p.dateUpd = :dateUpd")
    , @NamedQuery(name = "PsStockMvtReason.findByDeleted", query = "SELECT p FROM PsStockMvtReason p WHERE p.deleted = :deleted")})
public class PsStockMvtReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_stock_mvt_reason")
    private Integer idStockMvtReason;
    @Basic(optional = false)
    @Column(name = "sign")
    private boolean sign;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;

    public PsStockMvtReason() {
    }

    public PsStockMvtReason(Integer idStockMvtReason) {
        this.idStockMvtReason = idStockMvtReason;
    }

    public PsStockMvtReason(Integer idStockMvtReason, boolean sign, Date dateAdd, Date dateUpd, boolean deleted) {
        this.idStockMvtReason = idStockMvtReason;
        this.sign = sign;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.deleted = deleted;
    }

    public Integer getIdStockMvtReason() {
        return idStockMvtReason;
    }

    public void setIdStockMvtReason(Integer idStockMvtReason) {
        this.idStockMvtReason = idStockMvtReason;
    }

    public boolean getSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStockMvtReason != null ? idStockMvtReason.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStockMvtReason)) {
            return false;
        }
        PsStockMvtReason other = (PsStockMvtReason) object;
        if ((this.idStockMvtReason == null && other.idStockMvtReason != null) || (this.idStockMvtReason != null && !this.idStockMvtReason.equals(other.idStockMvtReason))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStockMvtReason[ idStockMvtReason=" + idStockMvtReason + " ]";
    }
    
}
