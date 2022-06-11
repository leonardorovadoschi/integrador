/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PRODUTOESTOQUELOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoestoquelote.findAll", query = "SELECT p FROM Produtoestoquelote p")
    , @NamedQuery(name = "Produtoestoquelote.findByCodprodutoestoquelote", query = "SELECT p FROM Produtoestoquelote p WHERE p.codprodutoestoquelote = :codprodutoestoquelote")
    , @NamedQuery(name = "Produtoestoquelote.findByQtdeentrada", query = "SELECT p FROM Produtoestoquelote p WHERE p.qtdeentrada = :qtdeentrada")
    , @NamedQuery(name = "Produtoestoquelote.findByQtdesaida", query = "SELECT p FROM Produtoestoquelote p WHERE p.qtdesaida = :qtdesaida")
    , @NamedQuery(name = "Produtoestoquelote.findByQtdeestoque", query = "SELECT p FROM Produtoestoquelote p WHERE p.qtdeestoque = :qtdeestoque")})
public class Produtoestoquelote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOESTOQUELOTE")
    private String codprodutoestoquelote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QTDEENTRADA")
    private BigDecimal qtdeentrada;
    @Column(name = "QTDESAIDA")
    private BigDecimal qtdesaida;
    @Column(name = "QTDEESTOQUE")
    private BigDecimal qtdeestoque;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODPRODUTOLOTE", referencedColumnName = "CODPRODUTOLOTE")
    @ManyToOne
    private Produtolote codprodutolote;

    public Produtoestoquelote() {
    }

    public Produtoestoquelote(String codprodutoestoquelote) {
        this.codprodutoestoquelote = codprodutoestoquelote;
    }

    public String getCodprodutoestoquelote() {
        return codprodutoestoquelote;
    }

    public void setCodprodutoestoquelote(String codprodutoestoquelote) {
        this.codprodutoestoquelote = codprodutoestoquelote;
    }

    public BigDecimal getQtdeentrada() {
        return qtdeentrada;
    }

    public void setQtdeentrada(BigDecimal qtdeentrada) {
        this.qtdeentrada = qtdeentrada;
    }

    public BigDecimal getQtdesaida() {
        return qtdesaida;
    }

    public void setQtdesaida(BigDecimal qtdesaida) {
        this.qtdesaida = qtdesaida;
    }

    public BigDecimal getQtdeestoque() {
        return qtdeestoque;
    }

    public void setQtdeestoque(BigDecimal qtdeestoque) {
        this.qtdeestoque = qtdeestoque;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Produtolote getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(Produtolote codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutoestoquelote != null ? codprodutoestoquelote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoestoquelote)) {
            return false;
        }
        Produtoestoquelote other = (Produtoestoquelote) object;
        if ((this.codprodutoestoquelote == null && other.codprodutoestoquelote != null) || (this.codprodutoestoquelote != null && !this.codprodutoestoquelote.equals(other.codprodutoestoquelote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoestoquelote[ codprodutoestoquelote=" + codprodutoestoquelote + " ]";
    }
    
}
