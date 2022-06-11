/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_tag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsTag.findAll", query = "SELECT p FROM PsTag p")
    , @NamedQuery(name = "PsTag.findByIdTag", query = "SELECT p FROM PsTag p WHERE p.idTag = :idTag")
    , @NamedQuery(name = "PsTag.findByIdLang", query = "SELECT p FROM PsTag p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsTag.findByName", query = "SELECT p FROM PsTag p WHERE p.name = :name")})
public class PsTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tag")
    private Integer idTag;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public PsTag() {
    }

    public PsTag(Integer idTag) {
        this.idTag = idTag;
    }

    public PsTag(Integer idTag, int idLang, String name) {
        this.idTag = idTag;
        this.idLang = idLang;
        this.name = name;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTag != null ? idTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsTag)) {
            return false;
        }
        PsTag other = (PsTag) object;
        if ((this.idTag == null && other.idTag != null) || (this.idTag != null && !this.idTag.equals(other.idTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsTag[ idTag=" + idTag + " ]";
    }
    
}
