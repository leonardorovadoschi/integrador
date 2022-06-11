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
@Table(name = "COR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cor.findAll", query = "SELECT c FROM Cor c")
    , @NamedQuery(name = "Cor.findByCodcor", query = "SELECT c FROM Cor c WHERE c.codcor = :codcor")
    , @NamedQuery(name = "Cor.findByDescricao", query = "SELECT c FROM Cor c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Cor.findByCodigo", query = "SELECT c FROM Cor c WHERE c.codigo = :codigo")})
public class Cor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOR")
    private String codcor;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "codcor")
    private Collection<Pedidoitem> pedidoitemCollection;

    public Cor() {
    }

    public Cor(String codcor) {
        this.codcor = codcor;
    }

    public Cor(String codcor, String descricao) {
        this.codcor = codcor;
        this.descricao = descricao;
    }

    public String getCodcor() {
        return codcor;
    }

    public void setCodcor(String codcor) {
        this.codcor = codcor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Pedidoitem> getPedidoitemCollection() {
        return pedidoitemCollection;
    }

    public void setPedidoitemCollection(Collection<Pedidoitem> pedidoitemCollection) {
        this.pedidoitemCollection = pedidoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcor != null ? codcor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cor)) {
            return false;
        }
        Cor other = (Cor) object;
        if ((this.codcor == null && other.codcor != null) || (this.codcor != null && !this.codcor.equals(other.codcor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cor[ codcor=" + codcor + " ]";
    }
    
}
