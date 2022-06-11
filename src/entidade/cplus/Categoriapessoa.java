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
@Table(name = "CATEGORIAPESSOA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriapessoa.findAll", query = "SELECT c FROM Categoriapessoa c")
    , @NamedQuery(name = "Categoriapessoa.findByCodcategoriapessoa", query = "SELECT c FROM Categoriapessoa c WHERE c.codcategoriapessoa = :codcategoriapessoa")
    , @NamedQuery(name = "Categoriapessoa.findByCodigo", query = "SELECT c FROM Categoriapessoa c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Categoriapessoa.findByNomecategoriapessoa", query = "SELECT c FROM Categoriapessoa c WHERE c.nomecategoriapessoa = :nomecategoriapessoa")})
public class Categoriapessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCATEGORIAPESSOA")
    private String codcategoriapessoa;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECATEGORIAPESSOA")
    private String nomecategoriapessoa;
    @OneToMany(mappedBy = "codcategoriapessoa")
    private Collection<Pessoacategoria> pessoacategoriaCollection;

    public Categoriapessoa() {
    }

    public Categoriapessoa(String codcategoriapessoa) {
        this.codcategoriapessoa = codcategoriapessoa;
    }

    public String getCodcategoriapessoa() {
        return codcategoriapessoa;
    }

    public void setCodcategoriapessoa(String codcategoriapessoa) {
        this.codcategoriapessoa = codcategoriapessoa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecategoriapessoa() {
        return nomecategoriapessoa;
    }

    public void setNomecategoriapessoa(String nomecategoriapessoa) {
        this.nomecategoriapessoa = nomecategoriapessoa;
    }

    @XmlTransient
    public Collection<Pessoacategoria> getPessoacategoriaCollection() {
        return pessoacategoriaCollection;
    }

    public void setPessoacategoriaCollection(Collection<Pessoacategoria> pessoacategoriaCollection) {
        this.pessoacategoriaCollection = pessoacategoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcategoriapessoa != null ? codcategoriapessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriapessoa)) {
            return false;
        }
        Categoriapessoa other = (Categoriapessoa) object;
        if ((this.codcategoriapessoa == null && other.codcategoriapessoa != null) || (this.codcategoriapessoa != null && !this.codcategoriapessoa.equals(other.codcategoriapessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Categoriapessoa[ codcategoriapessoa=" + codcategoriapessoa + " ]";
    }
    
}
