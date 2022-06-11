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
 * @author leo
 */
@Embeddable
public class PsLinkBlockLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_link_block")
    private int idLinkBlock;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsLinkBlockLangPK() {
    }

    public PsLinkBlockLangPK(int idLinkBlock, int idLang) {
        this.idLinkBlock = idLinkBlock;
        this.idLang = idLang;
    }

    public int getIdLinkBlock() {
        return idLinkBlock;
    }

    public void setIdLinkBlock(int idLinkBlock) {
        this.idLinkBlock = idLinkBlock;
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
        hash += (int) idLinkBlock;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinkBlockLangPK)) {
            return false;
        }
        PsLinkBlockLangPK other = (PsLinkBlockLangPK) object;
        if (this.idLinkBlock != other.idLinkBlock) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinkBlockLangPK[ idLinkBlock=" + idLinkBlock + ", idLang=" + idLang + " ]";
    }
    
}
