/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "MOENTREGAPRODENTLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentregaprodentlote.findAll", query = "SELECT m FROM Moentregaprodentlote m")
    , @NamedQuery(name = "Moentregaprodentlote.findById", query = "SELECT m FROM Moentregaprodentlote m WHERE m.id = :id")
    , @NamedQuery(name = "Moentregaprodentlote.findByIdmoentregaprodent", query = "SELECT m FROM Moentregaprodentlote m WHERE m.idmoentregaprodent = :idmoentregaprodent")
    , @NamedQuery(name = "Moentregaprodentlote.findByCodmovendaprodlote", query = "SELECT m FROM Moentregaprodentlote m WHERE m.codmovendaprodlote = :codmovendaprodlote")})
public class Moentregaprodentlote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDMOENTREGAPRODENT")
    private Integer idmoentregaprodent;
    @Column(name = "CODMOVENDAPRODLOTE")
    private String codmovendaprodlote;

    public Moentregaprodentlote() {
    }

    public Moentregaprodentlote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmoentregaprodent() {
        return idmoentregaprodent;
    }

    public void setIdmoentregaprodent(Integer idmoentregaprodent) {
        this.idmoentregaprodent = idmoentregaprodent;
    }

    public String getCodmovendaprodlote() {
        return codmovendaprodlote;
    }

    public void setCodmovendaprodlote(String codmovendaprodlote) {
        this.codmovendaprodlote = codmovendaprodlote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moentregaprodentlote)) {
            return false;
        }
        Moentregaprodentlote other = (Moentregaprodentlote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentregaprodentlote[ id=" + id + " ]";
    }
    
}
