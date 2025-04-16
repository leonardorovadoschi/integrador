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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_productextratabs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabs.findAll", query = "SELECT p FROM PsAnProductextratabs p")})
public class PsAnProductextratabs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtab")
    private Integer idtab;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "combinations")
    private short combinations;
    @Basic(optional = false)
    @Column(name = "contactform")
    private short contactform;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "relation")
    private int relation;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "tab_type")
    private int tabType;

    public PsAnProductextratabs() {
    }

    public PsAnProductextratabs(Integer idtab) {
        this.idtab = idtab;
    }

    public PsAnProductextratabs(Integer idtab, short active, short combinations, short contactform, String note, int relation, int position, int tabType) {
        this.idtab = idtab;
        this.active = active;
        this.combinations = combinations;
        this.contactform = contactform;
        this.note = note;
        this.relation = relation;
        this.position = position;
        this.tabType = tabType;
    }

    public Integer getIdtab() {
        return idtab;
    }

    public void setIdtab(Integer idtab) {
        this.idtab = idtab;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getCombinations() {
        return combinations;
    }

    public void setCombinations(short combinations) {
        this.combinations = combinations;
    }

    public short getContactform() {
        return contactform;
    }

    public void setContactform(short contactform) {
        this.contactform = contactform;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTabType() {
        return tabType;
    }

    public void setTabType(int tabType) {
        this.tabType = tabType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtab != null ? idtab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabs)) {
            return false;
        }
        PsAnProductextratabs other = (PsAnProductextratabs) object;
        if ((this.idtab == null && other.idtab != null) || (this.idtab != null && !this.idtab.equals(other.idtab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabs[ idtab=" + idtab + " ]";
    }
    
}
