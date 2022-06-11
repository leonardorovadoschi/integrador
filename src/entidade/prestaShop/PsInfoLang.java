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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_info_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsInfoLang.findAll", query = "SELECT p FROM PsInfoLang p")
    , @NamedQuery(name = "PsInfoLang.findByIdInfo", query = "SELECT p FROM PsInfoLang p WHERE p.psInfoLangPK.idInfo = :idInfo")
    , @NamedQuery(name = "PsInfoLang.findByIdShop", query = "SELECT p FROM PsInfoLang p WHERE p.psInfoLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsInfoLang.findByIdLang", query = "SELECT p FROM PsInfoLang p WHERE p.psInfoLangPK.idLang = :idLang")})
public class PsInfoLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsInfoLangPK psInfoLangPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "text")
    private String text;

    public PsInfoLang() {
    }

    public PsInfoLang(PsInfoLangPK psInfoLangPK) {
        this.psInfoLangPK = psInfoLangPK;
    }

    public PsInfoLang(PsInfoLangPK psInfoLangPK, String text) {
        this.psInfoLangPK = psInfoLangPK;
        this.text = text;
    }

    public PsInfoLang(int idInfo, int idShop, int idLang) {
        this.psInfoLangPK = new PsInfoLangPK(idInfo, idShop, idLang);
    }

    public PsInfoLangPK getPsInfoLangPK() {
        return psInfoLangPK;
    }

    public void setPsInfoLangPK(PsInfoLangPK psInfoLangPK) {
        this.psInfoLangPK = psInfoLangPK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psInfoLangPK != null ? psInfoLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsInfoLang)) {
            return false;
        }
        PsInfoLang other = (PsInfoLang) object;
        if ((this.psInfoLangPK == null && other.psInfoLangPK != null) || (this.psInfoLangPK != null && !this.psInfoLangPK.equals(other.psInfoLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsInfoLang[ psInfoLangPK=" + psInfoLangPK + " ]";
    }
    
}
