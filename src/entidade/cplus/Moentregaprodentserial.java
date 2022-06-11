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
@Table(name = "MOENTREGAPRODENTSERIAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentregaprodentserial.findAll", query = "SELECT m FROM Moentregaprodentserial m")
    , @NamedQuery(name = "Moentregaprodentserial.findById", query = "SELECT m FROM Moentregaprodentserial m WHERE m.id = :id")
    , @NamedQuery(name = "Moentregaprodentserial.findByIdmoentregaprodent", query = "SELECT m FROM Moentregaprodentserial m WHERE m.idmoentregaprodent = :idmoentregaprodent")
    , @NamedQuery(name = "Moentregaprodentserial.findByCodmovendaprodserial", query = "SELECT m FROM Moentregaprodentserial m WHERE m.codmovendaprodserial = :codmovendaprodserial")})
public class Moentregaprodentserial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "IDMOENTREGAPRODENT")
    private Integer idmoentregaprodent;
    @Column(name = "CODMOVENDAPRODSERIAL")
    private String codmovendaprodserial;

    public Moentregaprodentserial() {
    }

    public Moentregaprodentserial(Integer id) {
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

    public String getCodmovendaprodserial() {
        return codmovendaprodserial;
    }

    public void setCodmovendaprodserial(String codmovendaprodserial) {
        this.codmovendaprodserial = codmovendaprodserial;
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
        if (!(object instanceof Moentregaprodentserial)) {
            return false;
        }
        Moentregaprodentserial other = (Moentregaprodentserial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentregaprodentserial[ id=" + id + " ]";
    }
    
}
