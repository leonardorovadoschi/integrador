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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_client_service_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnClientServiceLang.findAll", query = "SELECT p FROM PsAnClientServiceLang p")})
public class PsAnClientServiceLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnClientServiceLangPK psAnClientServiceLangPK;
    @Basic(optional = false)
    @Column(name = "client_service_title")
    private String clientServiceTitle;
    @Lob
    @Column(name = "client_service_text")
    private String clientServiceText;

    public PsAnClientServiceLang() {
    }

    public PsAnClientServiceLang(PsAnClientServiceLangPK psAnClientServiceLangPK) {
        this.psAnClientServiceLangPK = psAnClientServiceLangPK;
    }

    public PsAnClientServiceLang(PsAnClientServiceLangPK psAnClientServiceLangPK, String clientServiceTitle) {
        this.psAnClientServiceLangPK = psAnClientServiceLangPK;
        this.clientServiceTitle = clientServiceTitle;
    }

    public PsAnClientServiceLang(int idClientService, String idLang) {
        this.psAnClientServiceLangPK = new PsAnClientServiceLangPK(idClientService, idLang);
    }

    public PsAnClientServiceLangPK getPsAnClientServiceLangPK() {
        return psAnClientServiceLangPK;
    }

    public void setPsAnClientServiceLangPK(PsAnClientServiceLangPK psAnClientServiceLangPK) {
        this.psAnClientServiceLangPK = psAnClientServiceLangPK;
    }

    public String getClientServiceTitle() {
        return clientServiceTitle;
    }

    public void setClientServiceTitle(String clientServiceTitle) {
        this.clientServiceTitle = clientServiceTitle;
    }

    public String getClientServiceText() {
        return clientServiceText;
    }

    public void setClientServiceText(String clientServiceText) {
        this.clientServiceText = clientServiceText;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnClientServiceLangPK != null ? psAnClientServiceLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnClientServiceLang)) {
            return false;
        }
        PsAnClientServiceLang other = (PsAnClientServiceLang) object;
        if ((this.psAnClientServiceLangPK == null && other.psAnClientServiceLangPK != null) || (this.psAnClientServiceLangPK != null && !this.psAnClientServiceLangPK.equals(other.psAnClientServiceLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnClientServiceLang[ psAnClientServiceLangPK=" + psAnClientServiceLangPK + " ]";
    }
    
}
