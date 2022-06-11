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
@Table(name = "PROMOCAOPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocaoproduto.findAll", query = "SELECT p FROM Promocaoproduto p")
    , @NamedQuery(name = "Promocaoproduto.findByCodpromocaoproduto", query = "SELECT p FROM Promocaoproduto p WHERE p.codpromocaoproduto = :codpromocaoproduto")
    , @NamedQuery(name = "Promocaoproduto.findByQuantidademinima", query = "SELECT p FROM Promocaoproduto p WHERE p.quantidademinima = :quantidademinima")
    , @NamedQuery(name = "Promocaoproduto.findByPreco", query = "SELECT p FROM Promocaoproduto p WHERE p.preco = :preco")})
public class Promocaoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPROMOCAOPRODUTO")
    private String codpromocaoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEMINIMA")
    private BigDecimal quantidademinima;
    @Column(name = "PRECO")
    private BigDecimal preco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODPROMOCAO", referencedColumnName = "CODPROMOCAO")
    @ManyToOne
    private Promocao codpromocao;

    public Promocaoproduto() {
    }

    public Promocaoproduto(String codpromocaoproduto) {
        this.codpromocaoproduto = codpromocaoproduto;
    }

    public String getCodpromocaoproduto() {
        return codpromocaoproduto;
    }

    public void setCodpromocaoproduto(String codpromocaoproduto) {
        this.codpromocaoproduto = codpromocaoproduto;
    }

    public BigDecimal getQuantidademinima() {
        return quantidademinima;
    }

    public void setQuantidademinima(BigDecimal quantidademinima) {
        this.quantidademinima = quantidademinima;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Promocao getCodpromocao() {
        return codpromocao;
    }

    public void setCodpromocao(Promocao codpromocao) {
        this.codpromocao = codpromocao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpromocaoproduto != null ? codpromocaoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocaoproduto)) {
            return false;
        }
        Promocaoproduto other = (Promocaoproduto) object;
        if ((this.codpromocaoproduto == null && other.codpromocaoproduto != null) || (this.codpromocaoproduto != null && !this.codpromocaoproduto.equals(other.codpromocaoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Promocaoproduto[ codpromocaoproduto=" + codpromocaoproduto + " ]";
    }
    
}
