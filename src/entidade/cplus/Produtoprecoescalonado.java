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
@Table(name = "PRODUTOPRECOESCALONADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoprecoescalonado.findAll", query = "SELECT p FROM Produtoprecoescalonado p")
    , @NamedQuery(name = "Produtoprecoescalonado.findByCodprodutoprecoescalonado", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.codprodutoprecoescalonado = :codprodutoprecoescalonado")
    , @NamedQuery(name = "Produtoprecoescalonado.findByQuantidade", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Produtoprecoescalonado.findByAliqdesconto", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "Produtoprecoescalonado.findByFlagtipodesconto", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.flagtipodesconto = :flagtipodesconto")
    , @NamedQuery(name = "Produtoprecoescalonado.findByValordesconto", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.valordesconto = :valordesconto")
    , @NamedQuery(name = "Produtoprecoescalonado.findByGuid", query = "SELECT p FROM Produtoprecoescalonado p WHERE p.guid = :guid")})
public class Produtoprecoescalonado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOPRECOESCALONADO")
    private String codprodutoprecoescalonado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public Produtoprecoescalonado() {
    }

    public Produtoprecoescalonado(String codprodutoprecoescalonado) {
        this.codprodutoprecoescalonado = codprodutoprecoescalonado;
    }

    public String getCodprodutoprecoescalonado() {
        return codprodutoprecoescalonado;
    }

    public void setCodprodutoprecoescalonado(String codprodutoprecoescalonado) {
        this.codprodutoprecoescalonado = codprodutoprecoescalonado;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public Character getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(Character flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
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
        hash += (codprodutoprecoescalonado != null ? codprodutoprecoescalonado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoprecoescalonado)) {
            return false;
        }
        Produtoprecoescalonado other = (Produtoprecoescalonado) object;
        if ((this.codprodutoprecoescalonado == null && other.codprodutoprecoescalonado != null) || (this.codprodutoprecoescalonado != null && !this.codprodutoprecoescalonado.equals(other.codprodutoprecoescalonado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoprecoescalonado[ codprodutoprecoescalonado=" + codprodutoprecoescalonado + " ]";
    }
    
}
