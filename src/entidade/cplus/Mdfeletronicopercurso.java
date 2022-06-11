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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MDFELETRONICOPERCURSO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicopercurso.findAll", query = "SELECT m FROM Mdfeletronicopercurso m")
    , @NamedQuery(name = "Mdfeletronicopercurso.findByCodmdfeletronicopercurso", query = "SELECT m FROM Mdfeletronicopercurso m WHERE m.codmdfeletronicopercurso = :codmdfeletronicopercurso")})
public class Mdfeletronicopercurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOPERCURSO")
    private String codmdfeletronicopercurso;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne(optional = false)
    private Uf coduf;

    public Mdfeletronicopercurso() {
    }

    public Mdfeletronicopercurso(String codmdfeletronicopercurso) {
        this.codmdfeletronicopercurso = codmdfeletronicopercurso;
    }

    public String getCodmdfeletronicopercurso() {
        return codmdfeletronicopercurso;
    }

    public void setCodmdfeletronicopercurso(String codmdfeletronicopercurso) {
        this.codmdfeletronicopercurso = codmdfeletronicopercurso;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicopercurso != null ? codmdfeletronicopercurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicopercurso)) {
            return false;
        }
        Mdfeletronicopercurso other = (Mdfeletronicopercurso) object;
        if ((this.codmdfeletronicopercurso == null && other.codmdfeletronicopercurso != null) || (this.codmdfeletronicopercurso != null && !this.codmdfeletronicopercurso.equals(other.codmdfeletronicopercurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicopercurso[ codmdfeletronicopercurso=" + codmdfeletronicopercurso + " ]";
    }
    
}
