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
 * @author leo
 */
@Entity
@Table(name = "ps_advice_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAdviceLang.findAll", query = "SELECT p FROM PsAdviceLang p")
    , @NamedQuery(name = "PsAdviceLang.findByIdAdvice", query = "SELECT p FROM PsAdviceLang p WHERE p.psAdviceLangPK.idAdvice = :idAdvice")
    , @NamedQuery(name = "PsAdviceLang.findByIdLang", query = "SELECT p FROM PsAdviceLang p WHERE p.psAdviceLangPK.idLang = :idLang")})
public class PsAdviceLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAdviceLangPK psAdviceLangPK;
    @Lob
    @Column(name = "html")
    private String html;

    public PsAdviceLang() {
    }

    public PsAdviceLang(PsAdviceLangPK psAdviceLangPK) {
        this.psAdviceLangPK = psAdviceLangPK;
    }

    public PsAdviceLang(int idAdvice, int idLang) {
        this.psAdviceLangPK = new PsAdviceLangPK(idAdvice, idLang);
    }

    public PsAdviceLangPK getPsAdviceLangPK() {
        return psAdviceLangPK;
    }

    public void setPsAdviceLangPK(PsAdviceLangPK psAdviceLangPK) {
        this.psAdviceLangPK = psAdviceLangPK;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAdviceLangPK != null ? psAdviceLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAdviceLang)) {
            return false;
        }
        PsAdviceLang other = (PsAdviceLang) object;
        if ((this.psAdviceLangPK == null && other.psAdviceLangPK != null) || (this.psAdviceLangPK != null && !this.psAdviceLangPK.equals(other.psAdviceLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAdviceLang[ psAdviceLangPK=" + psAdviceLangPK + " ]";
    }
    
}
