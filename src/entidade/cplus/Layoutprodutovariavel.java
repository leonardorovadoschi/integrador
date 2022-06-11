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
@Table(name = "LAYOUTPRODUTOVARIAVEL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Layoutprodutovariavel.findAll", query = "SELECT l FROM Layoutprodutovariavel l")
    , @NamedQuery(name = "Layoutprodutovariavel.findByCodlayoutprodutovariavel", query = "SELECT l FROM Layoutprodutovariavel l WHERE l.codlayoutprodutovariavel = :codlayoutprodutovariavel")
    , @NamedQuery(name = "Layoutprodutovariavel.findByNomevariavel", query = "SELECT l FROM Layoutprodutovariavel l WHERE l.nomevariavel = :nomevariavel")
    , @NamedQuery(name = "Layoutprodutovariavel.findByAliasvariavel", query = "SELECT l FROM Layoutprodutovariavel l WHERE l.aliasvariavel = :aliasvariavel")})
public class Layoutprodutovariavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLAYOUTPRODUTOVARIAVEL")
    private String codlayoutprodutovariavel;
    @Basic(optional = false)
    @Column(name = "NOMEVARIAVEL")
    private String nomevariavel;
    @Basic(optional = false)
    @Column(name = "ALIASVARIAVEL")
    private String aliasvariavel;
    @OneToMany(mappedBy = "codlayoutprodutovariavel")
    private Collection<Layoutprodutoitem> layoutprodutoitemCollection;

    public Layoutprodutovariavel() {
    }

    public Layoutprodutovariavel(String codlayoutprodutovariavel) {
        this.codlayoutprodutovariavel = codlayoutprodutovariavel;
    }

    public Layoutprodutovariavel(String codlayoutprodutovariavel, String nomevariavel, String aliasvariavel) {
        this.codlayoutprodutovariavel = codlayoutprodutovariavel;
        this.nomevariavel = nomevariavel;
        this.aliasvariavel = aliasvariavel;
    }

    public String getCodlayoutprodutovariavel() {
        return codlayoutprodutovariavel;
    }

    public void setCodlayoutprodutovariavel(String codlayoutprodutovariavel) {
        this.codlayoutprodutovariavel = codlayoutprodutovariavel;
    }

    public String getNomevariavel() {
        return nomevariavel;
    }

    public void setNomevariavel(String nomevariavel) {
        this.nomevariavel = nomevariavel;
    }

    public String getAliasvariavel() {
        return aliasvariavel;
    }

    public void setAliasvariavel(String aliasvariavel) {
        this.aliasvariavel = aliasvariavel;
    }

    @XmlTransient
    public Collection<Layoutprodutoitem> getLayoutprodutoitemCollection() {
        return layoutprodutoitemCollection;
    }

    public void setLayoutprodutoitemCollection(Collection<Layoutprodutoitem> layoutprodutoitemCollection) {
        this.layoutprodutoitemCollection = layoutprodutoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlayoutprodutovariavel != null ? codlayoutprodutovariavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Layoutprodutovariavel)) {
            return false;
        }
        Layoutprodutovariavel other = (Layoutprodutovariavel) object;
        if ((this.codlayoutprodutovariavel == null && other.codlayoutprodutovariavel != null) || (this.codlayoutprodutovariavel != null && !this.codlayoutprodutovariavel.equals(other.codlayoutprodutovariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Layoutprodutovariavel[ codlayoutprodutovariavel=" + codlayoutprodutovariavel + " ]";
    }
    
}
