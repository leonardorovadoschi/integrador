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
@Table(name = "ps_import_match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsImportMatch.findAll", query = "SELECT p FROM PsImportMatch p")
    , @NamedQuery(name = "PsImportMatch.findByIdImportMatch", query = "SELECT p FROM PsImportMatch p WHERE p.idImportMatch = :idImportMatch")
    , @NamedQuery(name = "PsImportMatch.findByName", query = "SELECT p FROM PsImportMatch p WHERE p.name = :name")
    , @NamedQuery(name = "PsImportMatch.findBySkip", query = "SELECT p FROM PsImportMatch p WHERE p.skip = :skip")})
public class PsImportMatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_import_match")
    private Integer idImportMatch;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "match")
    private String match;
    @Basic(optional = false)
    @Column(name = "skip")
    private int skip;

    public PsImportMatch() {
    }

    public PsImportMatch(Integer idImportMatch) {
        this.idImportMatch = idImportMatch;
    }

    public PsImportMatch(Integer idImportMatch, String name, String match, int skip) {
        this.idImportMatch = idImportMatch;
        this.name = name;
        this.match = match;
        this.skip = skip;
    }

    public Integer getIdImportMatch() {
        return idImportMatch;
    }

    public void setIdImportMatch(Integer idImportMatch) {
        this.idImportMatch = idImportMatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImportMatch != null ? idImportMatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImportMatch)) {
            return false;
        }
        PsImportMatch other = (PsImportMatch) object;
        if ((this.idImportMatch == null && other.idImportMatch != null) || (this.idImportMatch != null && !this.idImportMatch.equals(other.idImportMatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsImportMatch[ idImportMatch=" + idImportMatch + " ]";
    }
    
}
