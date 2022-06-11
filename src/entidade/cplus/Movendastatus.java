/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENDASTATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendastatus.findAll", query = "SELECT m FROM Movendastatus m")
    , @NamedQuery(name = "Movendastatus.findByCodmovendastatus", query = "SELECT m FROM Movendastatus m WHERE m.codmovendastatus = :codmovendastatus")
    , @NamedQuery(name = "Movendastatus.findByCodigo", query = "SELECT m FROM Movendastatus m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Movendastatus.findByNomemovendastatus", query = "SELECT m FROM Movendastatus m WHERE m.nomemovendastatus = :nomemovendastatus")})
public class Movendastatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDASTATUS")
    private String codmovendastatus;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEMOVENDASTATUS")
    private String nomemovendastatus;
    @OneToMany(mappedBy = "codmovendastatus")
    private Collection<Movenda> movendaCollection;

    public Movendastatus() {
    }

    public Movendastatus(String codmovendastatus) {
        this.codmovendastatus = codmovendastatus;
    }

    public String getCodmovendastatus() {
        return codmovendastatus;
    }

    public void setCodmovendastatus(String codmovendastatus) {
        this.codmovendastatus = codmovendastatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomemovendastatus() {
        return nomemovendastatus;
    }

    public void setNomemovendastatus(String nomemovendastatus) {
        this.nomemovendastatus = nomemovendastatus;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovendastatus != null ? codmovendastatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendastatus)) {
            return false;
        }
        Movendastatus other = (Movendastatus) object;
        if ((this.codmovendastatus == null && other.codmovendastatus != null) || (this.codmovendastatus != null && !this.codmovendastatus.equals(other.codmovendastatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendastatus[ codmovendastatus=" + codmovendastatus + " ]";
    }
    
}
