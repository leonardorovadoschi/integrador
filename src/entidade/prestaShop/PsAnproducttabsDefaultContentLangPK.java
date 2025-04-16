/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo-note
 */
@Embeddable
public class PsAnproducttabsDefaultContentLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anproducttabs_default_content")
    private int idAnproducttabsDefaultContent;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnproducttabsDefaultContentLangPK() {
    }

    public PsAnproducttabsDefaultContentLangPK(int idAnproducttabsDefaultContent, int idLang) {
        this.idAnproducttabsDefaultContent = idAnproducttabsDefaultContent;
        this.idLang = idLang;
    }

    public int getIdAnproducttabsDefaultContent() {
        return idAnproducttabsDefaultContent;
    }

    public void setIdAnproducttabsDefaultContent(int idAnproducttabsDefaultContent) {
        this.idAnproducttabsDefaultContent = idAnproducttabsDefaultContent;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAnproducttabsDefaultContent;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsDefaultContentLangPK)) {
            return false;
        }
        PsAnproducttabsDefaultContentLangPK other = (PsAnproducttabsDefaultContentLangPK) object;
        if (this.idAnproducttabsDefaultContent != other.idAnproducttabsDefaultContent) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsDefaultContentLangPK[ idAnproducttabsDefaultContent=" + idAnproducttabsDefaultContent + ", idLang=" + idLang + " ]";
    }
    
}
