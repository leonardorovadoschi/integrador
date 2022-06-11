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
@Table(name = "CONSULTASPCTIPODOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaspctipodocumento.findAll", query = "SELECT c FROM Consultaspctipodocumento c")
    , @NamedQuery(name = "Consultaspctipodocumento.findByCodconsultpdoc", query = "SELECT c FROM Consultaspctipodocumento c WHERE c.codconsultpdoc = :codconsultpdoc")
    , @NamedQuery(name = "Consultaspctipodocumento.findByCodigo", query = "SELECT c FROM Consultaspctipodocumento c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Consultaspctipodocumento.findByDescricao", query = "SELECT c FROM Consultaspctipodocumento c WHERE c.descricao = :descricao")})
public class Consultaspctipodocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONSULTPDOC")
    private String codconsultpdoc;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "codconsultpdoc")
    private Collection<Consultaspc> consultaspcCollection;

    public Consultaspctipodocumento() {
    }

    public Consultaspctipodocumento(String codconsultpdoc) {
        this.codconsultpdoc = codconsultpdoc;
    }

    public String getCodconsultpdoc() {
        return codconsultpdoc;
    }

    public void setCodconsultpdoc(String codconsultpdoc) {
        this.codconsultpdoc = codconsultpdoc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Consultaspc> getConsultaspcCollection() {
        return consultaspcCollection;
    }

    public void setConsultaspcCollection(Collection<Consultaspc> consultaspcCollection) {
        this.consultaspcCollection = consultaspcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconsultpdoc != null ? codconsultpdoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaspctipodocumento)) {
            return false;
        }
        Consultaspctipodocumento other = (Consultaspctipodocumento) object;
        if ((this.codconsultpdoc == null && other.codconsultpdoc != null) || (this.codconsultpdoc != null && !this.codconsultpdoc.equals(other.codconsultpdoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Consultaspctipodocumento[ codconsultpdoc=" + codconsultpdoc + " ]";
    }
    
}
