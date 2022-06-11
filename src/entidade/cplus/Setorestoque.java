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
@Table(name = "SETORESTOQUE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Setorestoque.findAll", query = "SELECT s FROM Setorestoque s")
    , @NamedQuery(name = "Setorestoque.findByCodsetorestoque", query = "SELECT s FROM Setorestoque s WHERE s.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "Setorestoque.findByNomesetorestoque", query = "SELECT s FROM Setorestoque s WHERE s.nomesetorestoque = :nomesetorestoque")
    , @NamedQuery(name = "Setorestoque.findByFlagativo", query = "SELECT s FROM Setorestoque s WHERE s.flagativo = :flagativo")
    , @NamedQuery(name = "Setorestoque.findByCodigo", query = "SELECT s FROM Setorestoque s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Setorestoque.findByFlagrma", query = "SELECT s FROM Setorestoque s WHERE s.flagrma = :flagrma")
    , @NamedQuery(name = "Setorestoque.findBySomatotalestatu", query = "SELECT s FROM Setorestoque s WHERE s.somatotalestatu = :somatotalestatu")})
public class Setorestoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "NOMESETORESTOQUE")
    private String nomesetorestoque;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FLAGRMA")
    private Character flagrma;
    @Column(name = "SOMATOTALESTATU")
    private Character somatotalestatu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsetorestoque")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Moventradaprod> moventradaprodCollection;
    @OneToMany(mappedBy = "codsetorestoqueentrada")
    private Collection<Ordemproducao> ordemproducaoCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "setorestoque")
    private Collection<Produtoestoque> produtoestoqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsetorestoque")
    private Collection<Acerto> acertoCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "codsetorestoque")
    private Collection<Orcamentoprod> orcamentoprodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsetorestoque")
    private Collection<AcertoProdlote> acertoProdloteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codsetorestoque")
    private Collection<AcertoProdfci> acertoProdfciCollection;

    public Setorestoque() {
    }

    public Setorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Setorestoque(String codsetorestoque, String codigo) {
        this.codsetorestoque = codsetorestoque;
        this.codigo = codigo;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public String getNomesetorestoque() {
        return nomesetorestoque;
    }

    public void setNomesetorestoque(String nomesetorestoque) {
        this.nomesetorestoque = nomesetorestoque;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Character getFlagrma() {
        return flagrma;
    }

    public void setFlagrma(Character flagrma) {
        this.flagrma = flagrma;
    }

    public Character getSomatotalestatu() {
        return somatotalestatu;
    }

    public void setSomatotalestatu(Character somatotalestatu) {
        this.somatotalestatu = somatotalestatu;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Moventradaprod> getMoventradaprodCollection() {
        return moventradaprodCollection;
    }

    public void setMoventradaprodCollection(Collection<Moventradaprod> moventradaprodCollection) {
        this.moventradaprodCollection = moventradaprodCollection;
    }

    @XmlTransient
    public Collection<Ordemproducao> getOrdemproducaoCollection() {
        return ordemproducaoCollection;
    }

    public void setOrdemproducaoCollection(Collection<Ordemproducao> ordemproducaoCollection) {
        this.ordemproducaoCollection = ordemproducaoCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Produtoestoque> getProdutoestoqueCollection() {
        return produtoestoqueCollection;
    }

    public void setProdutoestoqueCollection(Collection<Produtoestoque> produtoestoqueCollection) {
        this.produtoestoqueCollection = produtoestoqueCollection;
    }

    @XmlTransient
    public Collection<Acerto> getAcertoCollection() {
        return acertoCollection;
    }

    public void setAcertoCollection(Collection<Acerto> acertoCollection) {
        this.acertoCollection = acertoCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @XmlTransient
    public Collection<AcertoProdlote> getAcertoProdloteCollection() {
        return acertoProdloteCollection;
    }

    public void setAcertoProdloteCollection(Collection<AcertoProdlote> acertoProdloteCollection) {
        this.acertoProdloteCollection = acertoProdloteCollection;
    }

    @XmlTransient
    public Collection<AcertoProdfci> getAcertoProdfciCollection() {
        return acertoProdfciCollection;
    }

    public void setAcertoProdfciCollection(Collection<AcertoProdfci> acertoProdfciCollection) {
        this.acertoProdfciCollection = acertoProdfciCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsetorestoque != null ? codsetorestoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setorestoque)) {
            return false;
        }
        Setorestoque other = (Setorestoque) object;
        if ((this.codsetorestoque == null && other.codsetorestoque != null) || (this.codsetorestoque != null && !this.codsetorestoque.equals(other.codsetorestoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Setorestoque[ codsetorestoque=" + codsetorestoque + " ]";
    }
    
}
