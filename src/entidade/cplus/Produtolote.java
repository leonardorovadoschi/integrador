/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOLOTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtolote.findAll", query = "SELECT p FROM Produtolote p")
    , @NamedQuery(name = "Produtolote.findByCodprodutolote", query = "SELECT p FROM Produtolote p WHERE p.codprodutolote = :codprodutolote")
    , @NamedQuery(name = "Produtolote.findByLote", query = "SELECT p FROM Produtolote p WHERE p.lote = :lote")
    , @NamedQuery(name = "Produtolote.findByDatafabricacao", query = "SELECT p FROM Produtolote p WHERE p.datafabricacao = :datafabricacao")
    , @NamedQuery(name = "Produtolote.findByFlagloteperecivel", query = "SELECT p FROM Produtolote p WHERE p.flagloteperecivel = :flagloteperecivel")
    , @NamedQuery(name = "Produtolote.findByCampopersonalizado", query = "SELECT p FROM Produtolote p WHERE p.campopersonalizado = :campopersonalizado")
    , @NamedQuery(name = "Produtolote.findByDatavalidade", query = "SELECT p FROM Produtolote p WHERE p.datavalidade = :datavalidade")})
public class Produtolote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOLOTE")
    private String codprodutolote;
    @Column(name = "LOTE")
    private String lote;
    @Column(name = "DATAFABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date datafabricacao;
    @Column(name = "FLAGLOTEPERECIVEL")
    private Character flagloteperecivel;
    @Column(name = "CAMPOPERSONALIZADO")
    private String campopersonalizado;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutolote")
    private Collection<Orcamentoprodlote> orcamentoprodloteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutolote")
    private Collection<Moventradaprodlote> moventradaprodloteCollection;
    @OneToMany(mappedBy = "codprodutolote")
    private Collection<Consignacaobaixa> consignacaobaixaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutolote")
    private Collection<OsProdservlote> osProdservloteCollection;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprodutolote")
    private Collection<Movendaprodlote> movendaprodloteCollection;
    @OneToMany(mappedBy = "codprodutolote")
    private Collection<Produtoestoquelote> produtoestoqueloteCollection;

    public Produtolote() {
    }

    public Produtolote(String codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    public String getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(String codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public Character getFlagloteperecivel() {
        return flagloteperecivel;
    }

    public void setFlagloteperecivel(Character flagloteperecivel) {
        this.flagloteperecivel = flagloteperecivel;
    }

    public String getCampopersonalizado() {
        return campopersonalizado;
    }

    public void setCampopersonalizado(String campopersonalizado) {
        this.campopersonalizado = campopersonalizado;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    @XmlTransient
    public Collection<Orcamentoprodlote> getOrcamentoprodloteCollection() {
        return orcamentoprodloteCollection;
    }

    public void setOrcamentoprodloteCollection(Collection<Orcamentoprodlote> orcamentoprodloteCollection) {
        this.orcamentoprodloteCollection = orcamentoprodloteCollection;
    }

    @XmlTransient
    public Collection<Moventradaprodlote> getMoventradaprodloteCollection() {
        return moventradaprodloteCollection;
    }

    public void setMoventradaprodloteCollection(Collection<Moventradaprodlote> moventradaprodloteCollection) {
        this.moventradaprodloteCollection = moventradaprodloteCollection;
    }

    @XmlTransient
    public Collection<Consignacaobaixa> getConsignacaobaixaCollection() {
        return consignacaobaixaCollection;
    }

    public void setConsignacaobaixaCollection(Collection<Consignacaobaixa> consignacaobaixaCollection) {
        this.consignacaobaixaCollection = consignacaobaixaCollection;
    }

    @XmlTransient
    public Collection<OsProdservlote> getOsProdservloteCollection() {
        return osProdservloteCollection;
    }

    public void setOsProdservloteCollection(Collection<OsProdservlote> osProdservloteCollection) {
        this.osProdservloteCollection = osProdservloteCollection;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @XmlTransient
    public Collection<Movendaprodlote> getMovendaprodloteCollection() {
        return movendaprodloteCollection;
    }

    public void setMovendaprodloteCollection(Collection<Movendaprodlote> movendaprodloteCollection) {
        this.movendaprodloteCollection = movendaprodloteCollection;
    }

    @XmlTransient
    public Collection<Produtoestoquelote> getProdutoestoqueloteCollection() {
        return produtoestoqueloteCollection;
    }

    public void setProdutoestoqueloteCollection(Collection<Produtoestoquelote> produtoestoqueloteCollection) {
        this.produtoestoqueloteCollection = produtoestoqueloteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutolote != null ? codprodutolote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtolote)) {
            return false;
        }
        Produtolote other = (Produtolote) object;
        if ((this.codprodutolote == null && other.codprodutolote != null) || (this.codprodutolote != null && !this.codprodutolote.equals(other.codprodutolote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtolote[ codprodutolote=" + codprodutolote + " ]";
    }
    
}
