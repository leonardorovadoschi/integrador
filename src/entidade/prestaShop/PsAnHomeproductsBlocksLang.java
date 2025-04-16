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
@Table(name = "ps_an_homeproducts_blocks_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBlocksLang.findAll", query = "SELECT p FROM PsAnHomeproductsBlocksLang p")})
public class PsAnHomeproductsBlocksLang implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnHomeproductsBlocksLangPK psAnHomeproductsBlocksLangPK;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @Column(name = "link")
    private String link;

    public PsAnHomeproductsBlocksLang() {
    }

    public PsAnHomeproductsBlocksLang(PsAnHomeproductsBlocksLangPK psAnHomeproductsBlocksLangPK) {
        this.psAnHomeproductsBlocksLangPK = psAnHomeproductsBlocksLangPK;
    }

    public PsAnHomeproductsBlocksLang(PsAnHomeproductsBlocksLangPK psAnHomeproductsBlocksLangPK, String title, String link) {
        this.psAnHomeproductsBlocksLangPK = psAnHomeproductsBlocksLangPK;
        this.title = title;
        this.link = link;
    }

    public PsAnHomeproductsBlocksLang(int idBlock, String idLang) {
        this.psAnHomeproductsBlocksLangPK = new PsAnHomeproductsBlocksLangPK(idBlock, idLang);
    }

    public PsAnHomeproductsBlocksLangPK getPsAnHomeproductsBlocksLangPK() {
        return psAnHomeproductsBlocksLangPK;
    }

    public void setPsAnHomeproductsBlocksLangPK(PsAnHomeproductsBlocksLangPK psAnHomeproductsBlocksLangPK) {
        this.psAnHomeproductsBlocksLangPK = psAnHomeproductsBlocksLangPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnHomeproductsBlocksLangPK != null ? psAnHomeproductsBlocksLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocksLang)) {
            return false;
        }
        PsAnHomeproductsBlocksLang other = (PsAnHomeproductsBlocksLang) object;
        if ((this.psAnHomeproductsBlocksLangPK == null && other.psAnHomeproductsBlocksLangPK != null) || (this.psAnHomeproductsBlocksLangPK != null && !this.psAnHomeproductsBlocksLangPK.equals(other.psAnHomeproductsBlocksLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocksLang[ psAnHomeproductsBlocksLangPK=" + psAnHomeproductsBlocksLangPK + " ]";
    }
    
}
