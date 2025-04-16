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
public class PsAnproducttabsContentLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_anproducttabs_content")
    private int idAnproducttabsContent;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsAnproducttabsContentLangPK() {
    }

    public PsAnproducttabsContentLangPK(int idAnproducttabsContent, int idLang) {
        this.idAnproducttabsContent = idAnproducttabsContent;
        this.idLang = idLang;
    }

    public int getIdAnproducttabsContent() {
        return idAnproducttabsContent;
    }

    public void setIdAnproducttabsContent(int idAnproducttabsContent) {
        this.idAnproducttabsContent = idAnproducttabsContent;
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
        hash += (int) idAnproducttabsContent;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsContentLangPK)) {
            return false;
        }
        PsAnproducttabsContentLangPK other = (PsAnproducttabsContentLangPK) object;
        if (this.idAnproducttabsContent != other.idAnproducttabsContent) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsContentLangPK[ idAnproducttabsContent=" + idAnproducttabsContent + ", idLang=" + idLang + " ]";
    }
    
}
