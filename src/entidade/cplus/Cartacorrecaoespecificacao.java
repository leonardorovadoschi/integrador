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
@Table(name = "CARTACORRECAOESPECIFICACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartacorrecaoespecificacao.findAll", query = "SELECT c FROM Cartacorrecaoespecificacao c")
    , @NamedQuery(name = "Cartacorrecaoespecificacao.findByCodcartacorrecaoespecificacao", query = "SELECT c FROM Cartacorrecaoespecificacao c WHERE c.codcartacorrecaoespecificacao = :codcartacorrecaoespecificacao")
    , @NamedQuery(name = "Cartacorrecaoespecificacao.findByCodigo", query = "SELECT c FROM Cartacorrecaoespecificacao c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cartacorrecaoespecificacao.findByNomecartacorrecaoespecificacao", query = "SELECT c FROM Cartacorrecaoespecificacao c WHERE c.nomecartacorrecaoespecificacao = :nomecartacorrecaoespecificacao")})
public class Cartacorrecaoespecificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARTACORRECAOESPECIFICACAO")
    private String codcartacorrecaoespecificacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECARTACORRECAOESPECIFICACAO")
    private String nomecartacorrecaoespecificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartacorrecaoespecificacao")
    private Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollection;

    public Cartacorrecaoespecificacao() {
    }

    public Cartacorrecaoespecificacao(String codcartacorrecaoespecificacao) {
        this.codcartacorrecaoespecificacao = codcartacorrecaoespecificacao;
    }

    public String getCodcartacorrecaoespecificacao() {
        return codcartacorrecaoespecificacao;
    }

    public void setCodcartacorrecaoespecificacao(String codcartacorrecaoespecificacao) {
        this.codcartacorrecaoespecificacao = codcartacorrecaoespecificacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecartacorrecaoespecificacao() {
        return nomecartacorrecaoespecificacao;
    }

    public void setNomecartacorrecaoespecificacao(String nomecartacorrecaoespecificacao) {
        this.nomecartacorrecaoespecificacao = nomecartacorrecaoespecificacao;
    }

    @XmlTransient
    public Collection<Cartacorrecaoretificacao> getCartacorrecaoretificacaoCollection() {
        return cartacorrecaoretificacaoCollection;
    }

    public void setCartacorrecaoretificacaoCollection(Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollection) {
        this.cartacorrecaoretificacaoCollection = cartacorrecaoretificacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcartacorrecaoespecificacao != null ? codcartacorrecaoespecificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartacorrecaoespecificacao)) {
            return false;
        }
        Cartacorrecaoespecificacao other = (Cartacorrecaoespecificacao) object;
        if ((this.codcartacorrecaoespecificacao == null && other.codcartacorrecaoespecificacao != null) || (this.codcartacorrecaoespecificacao != null && !this.codcartacorrecaoespecificacao.equals(other.codcartacorrecaoespecificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cartacorrecaoespecificacao[ codcartacorrecaoespecificacao=" + codcartacorrecaoespecificacao + " ]";
    }
    
}
