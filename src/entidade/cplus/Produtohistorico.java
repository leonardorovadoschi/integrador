/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOHISTORICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtohistorico.findAll", query = "SELECT p FROM Produtohistorico p")
    , @NamedQuery(name = "Produtohistorico.findByCodigoantigo", query = "SELECT p FROM Produtohistorico p WHERE p.codigoantigo = :codigoantigo")
    , @NamedQuery(name = "Produtohistorico.findByCodigonovo", query = "SELECT p FROM Produtohistorico p WHERE p.codigonovo = :codigonovo")
    , @NamedQuery(name = "Produtohistorico.findByDataatualizacao", query = "SELECT p FROM Produtohistorico p WHERE p.dataatualizacao = :dataatualizacao")
    , @NamedQuery(name = "Produtohistorico.findByCodprodutohistorico", query = "SELECT p FROM Produtohistorico p WHERE p.codprodutohistorico = :codprodutohistorico")
    , @NamedQuery(name = "Produtohistorico.findByNomeprodantigo", query = "SELECT p FROM Produtohistorico p WHERE p.nomeprodantigo = :nomeprodantigo")
    , @NamedQuery(name = "Produtohistorico.findByNomeprodnovo", query = "SELECT p FROM Produtohistorico p WHERE p.nomeprodnovo = :nomeprodnovo")
    , @NamedQuery(name = "Produtohistorico.findByFlagorigemproduto", query = "SELECT p FROM Produtohistorico p WHERE p.flagorigemproduto = :flagorigemproduto")
    , @NamedQuery(name = "Produtohistorico.findByCodclassificacaofiscal", query = "SELECT p FROM Produtohistorico p WHERE p.codclassificacaofiscal = :codclassificacaofiscal")
    , @NamedQuery(name = "Produtohistorico.findByTipo", query = "SELECT p FROM Produtohistorico p WHERE p.tipo = :tipo")})
public class Produtohistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODIGOANTIGO")
    private String codigoantigo;
    @Column(name = "CODIGONOVO")
    private String codigonovo;
    @Column(name = "DATAATUALIZACAO")
    @Temporal(TemporalType.DATE)
    private Date dataatualizacao;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOHISTORICO")
    private String codprodutohistorico;
    @Column(name = "NOMEPRODANTIGO")
    private String nomeprodantigo;
    @Column(name = "NOMEPRODNOVO")
    private String nomeprodnovo;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "TIPO")
    private Character tipo;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Produtohistorico() {
    }

    public Produtohistorico(String codprodutohistorico) {
        this.codprodutohistorico = codprodutohistorico;
    }

    public String getCodigoantigo() {
        return codigoantigo;
    }

    public void setCodigoantigo(String codigoantigo) {
        this.codigoantigo = codigoantigo;
    }

    public String getCodigonovo() {
        return codigonovo;
    }

    public void setCodigonovo(String codigonovo) {
        this.codigonovo = codigonovo;
    }

    public Date getDataatualizacao() {
        return dataatualizacao;
    }

    public void setDataatualizacao(Date dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }

    public String getCodprodutohistorico() {
        return codprodutohistorico;
    }

    public void setCodprodutohistorico(String codprodutohistorico) {
        this.codprodutohistorico = codprodutohistorico;
    }

    public String getNomeprodantigo() {
        return nomeprodantigo;
    }

    public void setNomeprodantigo(String nomeprodantigo) {
        this.nomeprodantigo = nomeprodantigo;
    }

    public String getNomeprodnovo() {
        return nomeprodnovo;
    }

    public void setNomeprodnovo(String nomeprodnovo) {
        this.nomeprodnovo = nomeprodnovo;
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        this.flagorigemproduto = flagorigemproduto;
    }

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
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
        hash += (codprodutohistorico != null ? codprodutohistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtohistorico)) {
            return false;
        }
        Produtohistorico other = (Produtohistorico) object;
        if ((this.codprodutohistorico == null && other.codprodutohistorico != null) || (this.codprodutohistorico != null && !this.codprodutohistorico.equals(other.codprodutohistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtohistorico[ codprodutohistorico=" + codprodutohistorico + " ]";
    }
    
}
