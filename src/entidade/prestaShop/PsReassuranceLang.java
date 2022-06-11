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
@Table(name = "ps_reassurance_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsReassuranceLang.findAll", query = "SELECT p FROM PsReassuranceLang p")
    , @NamedQuery(name = "PsReassuranceLang.findByIdReassurance", query = "SELECT p FROM PsReassuranceLang p WHERE p.psReassuranceLangPK.idReassurance = :idReassurance")
    , @NamedQuery(name = "PsReassuranceLang.findByIdLang", query = "SELECT p FROM PsReassuranceLang p WHERE p.psReassuranceLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsReassuranceLang.findByText", query = "SELECT p FROM PsReassuranceLang p WHERE p.text = :text")})
public class PsReassuranceLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsReassuranceLangPK psReassuranceLangPK;
    @Basic(optional = false)
    @Column(name = "text")
    private String text;

    public PsReassuranceLang() {
    }

    public PsReassuranceLang(PsReassuranceLangPK psReassuranceLangPK) {
        this.psReassuranceLangPK = psReassuranceLangPK;
    }

    public PsReassuranceLang(PsReassuranceLangPK psReassuranceLangPK, String text) {
        this.psReassuranceLangPK = psReassuranceLangPK;
        this.text = text;
    }

    public PsReassuranceLang(int idReassurance, int idLang) {
        this.psReassuranceLangPK = new PsReassuranceLangPK(idReassurance, idLang);
    }

    public PsReassuranceLangPK getPsReassuranceLangPK() {
        return psReassuranceLangPK;
    }

    public void setPsReassuranceLangPK(PsReassuranceLangPK psReassuranceLangPK) {
        this.psReassuranceLangPK = psReassuranceLangPK;
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
        hash += (psReassuranceLangPK != null ? psReassuranceLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReassuranceLang)) {
            return false;
        }
        PsReassuranceLang other = (PsReassuranceLang) object;
        if ((this.psReassuranceLangPK == null && other.psReassuranceLangPK != null) || (this.psReassuranceLangPK != null && !this.psReassuranceLangPK.equals(other.psReassuranceLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReassuranceLang[ psReassuranceLangPK=" + psReassuranceLangPK + " ]";
    }
    
}
