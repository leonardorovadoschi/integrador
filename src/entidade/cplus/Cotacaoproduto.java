/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "COTACAOPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotacaoproduto.findAll", query = "SELECT c FROM Cotacaoproduto c")
    , @NamedQuery(name = "Cotacaoproduto.findByCodcotacaoproduto", query = "SELECT c FROM Cotacaoproduto c WHERE c.codcotacaoproduto = :codcotacaoproduto")
    , @NamedQuery(name = "Cotacaoproduto.findByQuantidadedesejada", query = "SELECT c FROM Cotacaoproduto c WHERE c.quantidadedesejada = :quantidadedesejada")
    , @NamedQuery(name = "Cotacaoproduto.findByFlagbaixado", query = "SELECT c FROM Cotacaoproduto c WHERE c.flagbaixado = :flagbaixado")})
public class Cotacaoproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOTACAOPRODUTO")
    private String codcotacaoproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADEDESEJADA")
    private BigDecimal quantidadedesejada;
    @Column(name = "FLAGBAIXADO")
    private Character flagbaixado;
    @JoinColumn(name = "CODCOTACAO", referencedColumnName = "CODCOTACAO")
    @ManyToOne
    private Cotacao codcotacao;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @OneToMany(mappedBy = "codcotacaoproduto")
    private Collection<Cotacaofornecedorpreco> cotacaofornecedorprecoCollection;

    public Cotacaoproduto() {
    }

    public Cotacaoproduto(String codcotacaoproduto) {
        this.codcotacaoproduto = codcotacaoproduto;
    }

    public String getCodcotacaoproduto() {
        return codcotacaoproduto;
    }

    public void setCodcotacaoproduto(String codcotacaoproduto) {
        this.codcotacaoproduto = codcotacaoproduto;
    }

    public BigDecimal getQuantidadedesejada() {
        return quantidadedesejada;
    }

    public void setQuantidadedesejada(BigDecimal quantidadedesejada) {
        this.quantidadedesejada = quantidadedesejada;
    }

    public Character getFlagbaixado() {
        return flagbaixado;
    }

    public void setFlagbaixado(Character flagbaixado) {
        this.flagbaixado = flagbaixado;
    }

    public Cotacao getCodcotacao() {
        return codcotacao;
    }

    public void setCodcotacao(Cotacao codcotacao) {
        this.codcotacao = codcotacao;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @XmlTransient
    public Collection<Cotacaofornecedorpreco> getCotacaofornecedorprecoCollection() {
        return cotacaofornecedorprecoCollection;
    }

    public void setCotacaofornecedorprecoCollection(Collection<Cotacaofornecedorpreco> cotacaofornecedorprecoCollection) {
        this.cotacaofornecedorprecoCollection = cotacaofornecedorprecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcotacaoproduto != null ? codcotacaoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacaoproduto)) {
            return false;
        }
        Cotacaoproduto other = (Cotacaoproduto) object;
        if ((this.codcotacaoproduto == null && other.codcotacaoproduto != null) || (this.codcotacaoproduto != null && !this.codcotacaoproduto.equals(other.codcotacaoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cotacaoproduto[ codcotacaoproduto=" + codcotacaoproduto + " ]";
    }
    
}
