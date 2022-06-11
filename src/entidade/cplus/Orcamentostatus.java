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
@Table(name = "ORCAMENTOSTATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentostatus.findAll", query = "SELECT o FROM Orcamentostatus o")
    , @NamedQuery(name = "Orcamentostatus.findByCodorcamentostatus", query = "SELECT o FROM Orcamentostatus o WHERE o.codorcamentostatus = :codorcamentostatus")
    , @NamedQuery(name = "Orcamentostatus.findByCodigo", query = "SELECT o FROM Orcamentostatus o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Orcamentostatus.findByNomeorcamentostatus", query = "SELECT o FROM Orcamentostatus o WHERE o.nomeorcamentostatus = :nomeorcamentostatus")})
public class Orcamentostatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCAMENTOSTATUS")
    private String codorcamentostatus;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEORCAMENTOSTATUS")
    private String nomeorcamentostatus;
    @OneToMany(mappedBy = "codorcamentostatus")
    private Collection<Orcamento> orcamentoCollection;

    public Orcamentostatus() {
    }

    public Orcamentostatus(String codorcamentostatus) {
        this.codorcamentostatus = codorcamentostatus;
    }

    public String getCodorcamentostatus() {
        return codorcamentostatus;
    }

    public void setCodorcamentostatus(String codorcamentostatus) {
        this.codorcamentostatus = codorcamentostatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeorcamentostatus() {
        return nomeorcamentostatus;
    }

    public void setNomeorcamentostatus(String nomeorcamentostatus) {
        this.nomeorcamentostatus = nomeorcamentostatus;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcamentostatus != null ? codorcamentostatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentostatus)) {
            return false;
        }
        Orcamentostatus other = (Orcamentostatus) object;
        if ((this.codorcamentostatus == null && other.codorcamentostatus != null) || (this.codorcamentostatus != null && !this.codorcamentostatus.equals(other.codorcamentostatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentostatus[ codorcamentostatus=" + codorcamentostatus + " ]";
    }
    
}
