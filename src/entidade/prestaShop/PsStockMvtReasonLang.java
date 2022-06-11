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
 * @author leo
 */
@Entity
@Table(name = "ps_stock_mvt_reason_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStockMvtReasonLang.findAll", query = "SELECT p FROM PsStockMvtReasonLang p")
    , @NamedQuery(name = "PsStockMvtReasonLang.findByIdStockMvtReason", query = "SELECT p FROM PsStockMvtReasonLang p WHERE p.psStockMvtReasonLangPK.idStockMvtReason = :idStockMvtReason")
    , @NamedQuery(name = "PsStockMvtReasonLang.findByIdLang", query = "SELECT p FROM PsStockMvtReasonLang p WHERE p.psStockMvtReasonLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsStockMvtReasonLang.findByName", query = "SELECT p FROM PsStockMvtReasonLang p WHERE p.name = :name")})
public class PsStockMvtReasonLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsStockMvtReasonLangPK psStockMvtReasonLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsStockMvtReasonLang() {
    }

    public PsStockMvtReasonLang(PsStockMvtReasonLangPK psStockMvtReasonLangPK) {
        this.psStockMvtReasonLangPK = psStockMvtReasonLangPK;
    }

    public PsStockMvtReasonLang(PsStockMvtReasonLangPK psStockMvtReasonLangPK, String name) {
        this.psStockMvtReasonLangPK = psStockMvtReasonLangPK;
        this.name = name;
    }

    public PsStockMvtReasonLang(int idStockMvtReason, int idLang) {
        this.psStockMvtReasonLangPK = new PsStockMvtReasonLangPK(idStockMvtReason, idLang);
    }

    public PsStockMvtReasonLangPK getPsStockMvtReasonLangPK() {
        return psStockMvtReasonLangPK;
    }

    public void setPsStockMvtReasonLangPK(PsStockMvtReasonLangPK psStockMvtReasonLangPK) {
        this.psStockMvtReasonLangPK = psStockMvtReasonLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psStockMvtReasonLangPK != null ? psStockMvtReasonLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStockMvtReasonLang)) {
            return false;
        }
        PsStockMvtReasonLang other = (PsStockMvtReasonLang) object;
        if ((this.psStockMvtReasonLangPK == null && other.psStockMvtReasonLangPK != null) || (this.psStockMvtReasonLangPK != null && !this.psStockMvtReasonLangPK.equals(other.psStockMvtReasonLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStockMvtReasonLang[ psStockMvtReasonLangPK=" + psStockMvtReasonLangPK + " ]";
    }
    
}
