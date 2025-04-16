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
public class PsAnSizeGuideWidgetsLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_widget")
    private int idWidget;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnSizeGuideWidgetsLangPK() {
    }

    public PsAnSizeGuideWidgetsLangPK(int idWidget, String idLang) {
        this.idWidget = idWidget;
        this.idLang = idLang;
    }

    public int getIdWidget() {
        return idWidget;
    }

    public void setIdWidget(int idWidget) {
        this.idWidget = idWidget;
    }

    public String getIdLang() {
        return idLang;
    }

    public void setIdLang(String idLang) {
        this.idLang = idLang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idWidget;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnSizeGuideWidgetsLangPK)) {
            return false;
        }
        PsAnSizeGuideWidgetsLangPK other = (PsAnSizeGuideWidgetsLangPK) object;
        if (this.idWidget != other.idWidget) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgetsLangPK[ idWidget=" + idWidget + ", idLang=" + idLang + " ]";
    }
    
}
