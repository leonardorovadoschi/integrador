/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOLOCALIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtolocalizacao.findAll", query = "SELECT p FROM Produtolocalizacao p")
    , @NamedQuery(name = "Produtolocalizacao.findByCodprodutolocalizacao", query = "SELECT p FROM Produtolocalizacao p WHERE p.codprodutolocalizacao = :codprodutolocalizacao")})
public class Produtolocalizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOLOCALIZACAO")
    private String codprodutolocalizacao;
    @JoinColumn(name = "CODLOC", referencedColumnName = "CODLOC")
    @ManyToOne(optional = false)
    private Localizacao codloc;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtolocalizacao() {
    }

    public Produtolocalizacao(String codprodutolocalizacao) {
        this.codprodutolocalizacao = codprodutolocalizacao;
    }

    public String getCodprodutolocalizacao() {
        return codprodutolocalizacao;
    }

    public void setCodprodutolocalizacao(String codprodutolocalizacao) {
        this.codprodutolocalizacao = codprodutolocalizacao;
    }

    public Localizacao getCodloc() {
        return codloc;
    }

    public void setCodloc(Localizacao codloc) {
        this.codloc = codloc;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutolocalizacao != null ? codprodutolocalizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtolocalizacao)) {
            return false;
        }
        Produtolocalizacao other = (Produtolocalizacao) object;
        if ((this.codprodutolocalizacao == null && other.codprodutolocalizacao != null) || (this.codprodutolocalizacao != null && !this.codprodutolocalizacao.equals(other.codprodutolocalizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtolocalizacao[ codprodutolocalizacao=" + codprodutolocalizacao + " ]";
    }
    
}
