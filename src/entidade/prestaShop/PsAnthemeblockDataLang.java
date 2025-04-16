/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anthemeblock_data_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnthemeblockDataLang.findAll", query = "SELECT p FROM PsAnthemeblockDataLang p")})
public class PsAnthemeblockDataLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnthemeblockDataLangPK psAnthemeblockDataLangPK;
    @Lob
    @Column(name = "data")
    private String data;

    public PsAnthemeblockDataLang() {
    }

    public PsAnthemeblockDataLang(PsAnthemeblockDataLangPK psAnthemeblockDataLangPK) {
        this.psAnthemeblockDataLangPK = psAnthemeblockDataLangPK;
    }

    public PsAnthemeblockDataLang(int idAnthemeblockData, int idLang) {
        this.psAnthemeblockDataLangPK = new PsAnthemeblockDataLangPK(idAnthemeblockData, idLang);
    }

    public PsAnthemeblockDataLangPK getPsAnthemeblockDataLangPK() {
        return psAnthemeblockDataLangPK;
    }

    public void setPsAnthemeblockDataLangPK(PsAnthemeblockDataLangPK psAnthemeblockDataLangPK) {
        this.psAnthemeblockDataLangPK = psAnthemeblockDataLangPK;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnthemeblockDataLangPK != null ? psAnthemeblockDataLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblockDataLang)) {
            return false;
        }
        PsAnthemeblockDataLang other = (PsAnthemeblockDataLang) object;
        if ((this.psAnthemeblockDataLangPK == null && other.psAnthemeblockDataLangPK != null) || (this.psAnthemeblockDataLangPK != null && !this.psAnthemeblockDataLangPK.equals(other.psAnthemeblockDataLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblockDataLang[ psAnthemeblockDataLangPK=" + psAnthemeblockDataLangPK + " ]";
    }
    
}
