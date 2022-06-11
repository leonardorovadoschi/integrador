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
@Table(name = "TIPODOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")
    , @NamedQuery(name = "Tipodocumento.findByCodtipodocumento", query = "SELECT t FROM Tipodocumento t WHERE t.codtipodocumento = :codtipodocumento")
    , @NamedQuery(name = "Tipodocumento.findByCodigo", query = "SELECT t FROM Tipodocumento t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipodocumento.findByNometipodocumento", query = "SELECT t FROM Tipodocumento t WHERE t.nometipodocumento = :nometipodocumento")})
public class Tipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPODOCUMENTO")
    private String codtipodocumento;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPODOCUMENTO")
    private String nometipodocumento;
    @OneToMany(mappedBy = "codtipodocumento")
    private Collection<Empresatipodocumento> empresatipodocumentoCollection;

    public Tipodocumento() {
    }

    public Tipodocumento(String codtipodocumento) {
        this.codtipodocumento = codtipodocumento;
    }

    public String getCodtipodocumento() {
        return codtipodocumento;
    }

    public void setCodtipodocumento(String codtipodocumento) {
        this.codtipodocumento = codtipodocumento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipodocumento() {
        return nometipodocumento;
    }

    public void setNometipodocumento(String nometipodocumento) {
        this.nometipodocumento = nometipodocumento;
    }

    @XmlTransient
    public Collection<Empresatipodocumento> getEmpresatipodocumentoCollection() {
        return empresatipodocumentoCollection;
    }

    public void setEmpresatipodocumentoCollection(Collection<Empresatipodocumento> empresatipodocumentoCollection) {
        this.empresatipodocumentoCollection = empresatipodocumentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipodocumento != null ? codtipodocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.codtipodocumento == null && other.codtipodocumento != null) || (this.codtipodocumento != null && !this.codtipodocumento.equals(other.codtipodocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipodocumento[ codtipodocumento=" + codtipodocumento + " ]";
    }
    
}
