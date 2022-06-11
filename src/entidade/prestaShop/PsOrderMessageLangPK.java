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
public class PsOrderMessageLangPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_order_message")
    private int idOrderMessage;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;

    public PsOrderMessageLangPK() {
    }

    public PsOrderMessageLangPK(int idOrderMessage, int idLang) {
        this.idOrderMessage = idOrderMessage;
        this.idLang = idLang;
    }

    public int getIdOrderMessage() {
        return idOrderMessage;
    }

    public void setIdOrderMessage(int idOrderMessage) {
        this.idOrderMessage = idOrderMessage;
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
        hash += (int) idOrderMessage;
        hash += (int) idLang;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderMessageLangPK)) {
            return false;
        }
        PsOrderMessageLangPK other = (PsOrderMessageLangPK) object;
        if (this.idOrderMessage != other.idOrderMessage) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderMessageLangPK[ idOrderMessage=" + idOrderMessage + ", idLang=" + idLang + " ]";
    }
    
}
