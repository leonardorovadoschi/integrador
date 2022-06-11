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
@Table(name = "ps_hook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHook.findAll", query = "SELECT p FROM PsHook p")
    , @NamedQuery(name = "PsHook.findByIdHook", query = "SELECT p FROM PsHook p WHERE p.idHook = :idHook")
    , @NamedQuery(name = "PsHook.findByName", query = "SELECT p FROM PsHook p WHERE p.name = :name")
    , @NamedQuery(name = "PsHook.findByTitle", query = "SELECT p FROM PsHook p WHERE p.title = :title")
    , @NamedQuery(name = "PsHook.findByPosition", query = "SELECT p FROM PsHook p WHERE p.position = :position")})
public class PsHook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hook")
    private Integer idHook;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "position")
    private boolean position;

    public PsHook() {
    }

    public PsHook(Integer idHook) {
        this.idHook = idHook;
    }

    public PsHook(Integer idHook, String name, String title, boolean position) {
        this.idHook = idHook;
        this.name = name;
        this.title = title;
        this.position = position;
    }

    public Integer getIdHook() {
        return idHook;
    }

    public void setIdHook(Integer idHook) {
        this.idHook = idHook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHook != null ? idHook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHook)) {
            return false;
        }
        PsHook other = (PsHook) object;
        if ((this.idHook == null && other.idHook != null) || (this.idHook != null && !this.idHook.equals(other.idHook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHook[ idHook=" + idHook + " ]";
    }
    
}
