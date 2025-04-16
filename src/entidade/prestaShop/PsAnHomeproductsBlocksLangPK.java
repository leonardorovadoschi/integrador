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
public class PsAnHomeproductsBlocksLangPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_block")
    private int idBlock;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private String idLang;

    public PsAnHomeproductsBlocksLangPK() {
    }

    public PsAnHomeproductsBlocksLangPK(int idBlock, String idLang) {
        this.idBlock = idBlock;
        this.idLang = idLang;
    }

    public int getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(int idBlock) {
        this.idBlock = idBlock;
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
        hash += (int) idBlock;
        hash += (idLang != null ? idLang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksLangPK)) {
            return false;
        }
        PsAnHomeproductsBlocksLangPK other = (PsAnHomeproductsBlocksLangPK) object;
        if (this.idBlock != other.idBlock) {
            return false;
        }
        if ((this.idLang == null && other.idLang != null) || (this.idLang != null && !this.idLang.equals(other.idLang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksLangPK[ idBlock=" + idBlock + ", idLang=" + idLang + " ]";
    }
    
}
