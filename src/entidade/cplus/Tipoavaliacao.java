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
@Table(name = "TIPOAVALIACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoavaliacao.findAll", query = "SELECT t FROM Tipoavaliacao t")
    , @NamedQuery(name = "Tipoavaliacao.findByCodtipoavaliacao", query = "SELECT t FROM Tipoavaliacao t WHERE t.codtipoavaliacao = :codtipoavaliacao")
    , @NamedQuery(name = "Tipoavaliacao.findByCodigo", query = "SELECT t FROM Tipoavaliacao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoavaliacao.findByNometipoavaliacao", query = "SELECT t FROM Tipoavaliacao t WHERE t.nometipoavaliacao = :nometipoavaliacao")
    , @NamedQuery(name = "Tipoavaliacao.findByFlagativo", query = "SELECT t FROM Tipoavaliacao t WHERE t.flagativo = :flagativo")})
public class Tipoavaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOAVALIACAO")
    private String codtipoavaliacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOAVALIACAO")
    private String nometipoavaliacao;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @OneToMany(mappedBy = "codtipoavaliacao")
    private Collection<Avaliacao> avaliacaoCollection;

    public Tipoavaliacao() {
    }

    public Tipoavaliacao(String codtipoavaliacao) {
        this.codtipoavaliacao = codtipoavaliacao;
    }

    public String getCodtipoavaliacao() {
        return codtipoavaliacao;
    }

    public void setCodtipoavaliacao(String codtipoavaliacao) {
        this.codtipoavaliacao = codtipoavaliacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipoavaliacao() {
        return nometipoavaliacao;
    }

    public void setNometipoavaliacao(String nometipoavaliacao) {
        this.nometipoavaliacao = nometipoavaliacao;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoavaliacao != null ? codtipoavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoavaliacao)) {
            return false;
        }
        Tipoavaliacao other = (Tipoavaliacao) object;
        if ((this.codtipoavaliacao == null && other.codtipoavaliacao != null) || (this.codtipoavaliacao != null && !this.codtipoavaliacao.equals(other.codtipoavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipoavaliacao[ codtipoavaliacao=" + codtipoavaliacao + " ]";
    }
    
}
