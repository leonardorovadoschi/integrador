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
@Table(name = "LAYOUTPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Layoutproduto.findAll", query = "SELECT l FROM Layoutproduto l")
    , @NamedQuery(name = "Layoutproduto.findByCodlayoutproduto", query = "SELECT l FROM Layoutproduto l WHERE l.codlayoutproduto = :codlayoutproduto")
    , @NamedQuery(name = "Layoutproduto.findByCodigolayoutproduto", query = "SELECT l FROM Layoutproduto l WHERE l.codigolayoutproduto = :codigolayoutproduto")
    , @NamedQuery(name = "Layoutproduto.findByNomelayoutproduto", query = "SELECT l FROM Layoutproduto l WHERE l.nomelayoutproduto = :nomelayoutproduto")})
public class Layoutproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLAYOUTPRODUTO")
    private String codlayoutproduto;
    @Basic(optional = false)
    @Column(name = "CODIGOLAYOUTPRODUTO")
    private String codigolayoutproduto;
    @Basic(optional = false)
    @Column(name = "NOMELAYOUTPRODUTO")
    private String nomelayoutproduto;
    @OneToMany(mappedBy = "codlayoutproduto")
    private Collection<Layoutprodutoitem> layoutprodutoitemCollection;

    public Layoutproduto() {
    }

    public Layoutproduto(String codlayoutproduto) {
        this.codlayoutproduto = codlayoutproduto;
    }

    public Layoutproduto(String codlayoutproduto, String codigolayoutproduto, String nomelayoutproduto) {
        this.codlayoutproduto = codlayoutproduto;
        this.codigolayoutproduto = codigolayoutproduto;
        this.nomelayoutproduto = nomelayoutproduto;
    }

    public String getCodlayoutproduto() {
        return codlayoutproduto;
    }

    public void setCodlayoutproduto(String codlayoutproduto) {
        this.codlayoutproduto = codlayoutproduto;
    }

    public String getCodigolayoutproduto() {
        return codigolayoutproduto;
    }

    public void setCodigolayoutproduto(String codigolayoutproduto) {
        this.codigolayoutproduto = codigolayoutproduto;
    }

    public String getNomelayoutproduto() {
        return nomelayoutproduto;
    }

    public void setNomelayoutproduto(String nomelayoutproduto) {
        this.nomelayoutproduto = nomelayoutproduto;
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
        hash += (codlayoutproduto != null ? codlayoutproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Layoutproduto)) {
            return false;
        }
        Layoutproduto other = (Layoutproduto) object;
        if ((this.codlayoutproduto == null && other.codlayoutproduto != null) || (this.codlayoutproduto != null && !this.codlayoutproduto.equals(other.codlayoutproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Layoutproduto[ codlayoutproduto=" + codlayoutproduto + " ]";
    }
    
}
