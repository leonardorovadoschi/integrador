/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "REGRACFOP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regracfop.findAll", query = "SELECT r FROM Regracfop r")
    , @NamedQuery(name = "Regracfop.findByCodregracfop", query = "SELECT r FROM Regracfop r WHERE r.codregracfop = :codregracfop")
    , @NamedQuery(name = "Regracfop.findByCodigo", query = "SELECT r FROM Regracfop r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Regracfop.findByNomeregracfop", query = "SELECT r FROM Regracfop r WHERE r.nomeregracfop = :nomeregracfop")})
public class Regracfop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGRACFOP")
    private String codregracfop;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMEREGRACFOP")
    private String nomeregracfop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codregracfop")
    private Collection<Regracfopitem> regracfopitemCollection;
    @OneToMany(mappedBy = "codregracfop")
    private Collection<Produto> produtoCollection;

    public Regracfop() {
    }

    public Regracfop(String codregracfop) {
        this.codregracfop = codregracfop;
    }

    public Regracfop(String codregracfop, String codigo, String nomeregracfop) {
        this.codregracfop = codregracfop;
        this.codigo = codigo;
        this.nomeregracfop = nomeregracfop;
    }

    public String getCodregracfop() {
        return codregracfop;
    }

    public void setCodregracfop(String codregracfop) {
        this.codregracfop = codregracfop;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeregracfop() {
        return nomeregracfop;
    }

    public void setNomeregracfop(String nomeregracfop) {
        this.nomeregracfop = nomeregracfop;
    }

    @XmlTransient
    public Collection<Regracfopitem> getRegracfopitemCollection() {
        return regracfopitemCollection;
    }

    public void setRegracfopitemCollection(Collection<Regracfopitem> regracfopitemCollection) {
        this.regracfopitemCollection = regracfopitemCollection;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codregracfop != null ? codregracfop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regracfop)) {
            return false;
        }
        Regracfop other = (Regracfop) object;
        if ((this.codregracfop == null && other.codregracfop != null) || (this.codregracfop != null && !this.codregracfop.equals(other.codregracfop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Regracfop[ codregracfop=" + codregracfop + " ]";
    }
    
}
