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
@Table(name = "ps_store_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStoreLang.findAll", query = "SELECT p FROM PsStoreLang p")
    , @NamedQuery(name = "PsStoreLang.findByIdStore", query = "SELECT p FROM PsStoreLang p WHERE p.psStoreLangPK.idStore = :idStore")
    , @NamedQuery(name = "PsStoreLang.findByIdLang", query = "SELECT p FROM PsStoreLang p WHERE p.psStoreLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsStoreLang.findByName", query = "SELECT p FROM PsStoreLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsStoreLang.findByAddress1", query = "SELECT p FROM PsStoreLang p WHERE p.address1 = :address1")
    , @NamedQuery(name = "PsStoreLang.findByAddress2", query = "SELECT p FROM PsStoreLang p WHERE p.address2 = :address2")})
public class PsStoreLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsStoreLangPK psStoreLangPK;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Lob
    @Column(name = "hours")
    private String hours;
    @Lob
    @Column(name = "note")
    private String note;

    public PsStoreLang() {
    }

    public PsStoreLang(PsStoreLangPK psStoreLangPK) {
        this.psStoreLangPK = psStoreLangPK;
    }

    public PsStoreLang(PsStoreLangPK psStoreLangPK, String name, String address1) {
        this.psStoreLangPK = psStoreLangPK;
        this.name = name;
        this.address1 = address1;
    }

    public PsStoreLang(int idStore, int idLang) {
        this.psStoreLangPK = new PsStoreLangPK(idStore, idLang);
    }

    public PsStoreLangPK getPsStoreLangPK() {
        return psStoreLangPK;
    }

    public void setPsStoreLangPK(PsStoreLangPK psStoreLangPK) {
        this.psStoreLangPK = psStoreLangPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psStoreLangPK != null ? psStoreLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStoreLang)) {
            return false;
        }
        PsStoreLang other = (PsStoreLang) object;
        if ((this.psStoreLangPK == null && other.psStoreLangPK != null) || (this.psStoreLangPK != null && !this.psStoreLangPK.equals(other.psStoreLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStoreLang[ psStoreLangPK=" + psStoreLangPK + " ]";
    }
    
}
