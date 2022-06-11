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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_tag_count")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTagCount.findAll", query = "SELECT p FROM PsTagCount p")
    , @NamedQuery(name = "PsTagCount.findByIdGroup", query = "SELECT p FROM PsTagCount p WHERE p.psTagCountPK.idGroup = :idGroup")
    , @NamedQuery(name = "PsTagCount.findByIdTag", query = "SELECT p FROM PsTagCount p WHERE p.psTagCountPK.idTag = :idTag")
    , @NamedQuery(name = "PsTagCount.findByIdLang", query = "SELECT p FROM PsTagCount p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsTagCount.findByIdShop", query = "SELECT p FROM PsTagCount p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsTagCount.findByCounter", query = "SELECT p FROM PsTagCount p WHERE p.counter = :counter")})
public class PsTagCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsTagCountPK psTagCountPK;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "counter")
    private int counter;

    public PsTagCount() {
    }

    public PsTagCount(PsTagCountPK psTagCountPK) {
        this.psTagCountPK = psTagCountPK;
    }

    public PsTagCount(PsTagCountPK psTagCountPK, int idLang, int idShop, int counter) {
        this.psTagCountPK = psTagCountPK;
        this.idLang = idLang;
        this.idShop = idShop;
        this.counter = counter;
    }

    public PsTagCount(int idGroup, int idTag) {
        this.psTagCountPK = new PsTagCountPK(idGroup, idTag);
    }

    public PsTagCountPK getPsTagCountPK() {
        return psTagCountPK;
    }

    public void setPsTagCountPK(PsTagCountPK psTagCountPK) {
        this.psTagCountPK = psTagCountPK;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psTagCountPK != null ? psTagCountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTagCount)) {
            return false;
        }
        PsTagCount other = (PsTagCount) object;
        if ((this.psTagCountPK == null && other.psTagCountPK != null) || (this.psTagCountPK != null && !this.psTagCountPK.equals(other.psTagCountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTagCount[ psTagCountPK=" + psTagCountPK + " ]";
    }
    
}
