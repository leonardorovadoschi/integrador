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
@Table(name = "ps_order_message_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderMessageLang.findAll", query = "SELECT p FROM PsOrderMessageLang p")
    , @NamedQuery(name = "PsOrderMessageLang.findByIdOrderMessage", query = "SELECT p FROM PsOrderMessageLang p WHERE p.psOrderMessageLangPK.idOrderMessage = :idOrderMessage")
    , @NamedQuery(name = "PsOrderMessageLang.findByIdLang", query = "SELECT p FROM PsOrderMessageLang p WHERE p.psOrderMessageLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsOrderMessageLang.findByName", query = "SELECT p FROM PsOrderMessageLang p WHERE p.name = :name")})
public class PsOrderMessageLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsOrderMessageLangPK psOrderMessageLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;

    public PsOrderMessageLang() {
    }

    public PsOrderMessageLang(PsOrderMessageLangPK psOrderMessageLangPK) {
        this.psOrderMessageLangPK = psOrderMessageLangPK;
    }

    public PsOrderMessageLang(PsOrderMessageLangPK psOrderMessageLangPK, String name, String message) {
        this.psOrderMessageLangPK = psOrderMessageLangPK;
        this.name = name;
        this.message = message;
    }

    public PsOrderMessageLang(int idOrderMessage, int idLang) {
        this.psOrderMessageLangPK = new PsOrderMessageLangPK(idOrderMessage, idLang);
    }

    public PsOrderMessageLangPK getPsOrderMessageLangPK() {
        return psOrderMessageLangPK;
    }

    public void setPsOrderMessageLangPK(PsOrderMessageLangPK psOrderMessageLangPK) {
        this.psOrderMessageLangPK = psOrderMessageLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psOrderMessageLangPK != null ? psOrderMessageLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderMessageLang)) {
            return false;
        }
        PsOrderMessageLang other = (PsOrderMessageLang) object;
        if ((this.psOrderMessageLangPK == null && other.psOrderMessageLangPK != null) || (this.psOrderMessageLangPK != null && !this.psOrderMessageLangPK.equals(other.psOrderMessageLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderMessageLang[ psOrderMessageLangPK=" + psOrderMessageLangPK + " ]";
    }
    
}
