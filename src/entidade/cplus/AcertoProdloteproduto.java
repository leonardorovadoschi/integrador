/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ACERTO_PRODLOTEPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcertoProdloteproduto.findAll", query = "SELECT a FROM AcertoProdloteproduto a")
    , @NamedQuery(name = "AcertoProdloteproduto.findById", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.id = :id")
    , @NamedQuery(name = "AcertoProdloteproduto.findByCodacertoProdlote", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.codacertoProdlote = :codacertoProdlote")
    , @NamedQuery(name = "AcertoProdloteproduto.findByLote", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.lote = :lote")
    , @NamedQuery(name = "AcertoProdloteproduto.findByQuantidade", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.quantidade = :quantidade")
    , @NamedQuery(name = "AcertoProdloteproduto.findByCoduser", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.coduser = :coduser")
    , @NamedQuery(name = "AcertoProdloteproduto.findByData", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.data = :data")
    , @NamedQuery(name = "AcertoProdloteproduto.findByDatavalidade", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.datavalidade = :datavalidade")
    , @NamedQuery(name = "AcertoProdloteproduto.findByDatafabricacao", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.datafabricacao = :datafabricacao")
    , @NamedQuery(name = "AcertoProdloteproduto.findByCodprodutolote", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.codprodutolote = :codprodutolote")
    , @NamedQuery(name = "AcertoProdloteproduto.findByFlagloteperecivel", query = "SELECT a FROM AcertoProdloteproduto a WHERE a.flagloteperecivel = :flagloteperecivel")})
public class AcertoProdloteproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "CODACERTO_PRODLOTE")
    private String codacertoProdlote;
    @Column(name = "LOTE")
    private String lote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "DATAFABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date datafabricacao;
    @Column(name = "CODPRODUTOLOTE")
    private String codprodutolote;
    @Column(name = "FLAGLOTEPERECIVEL")
    private Character flagloteperecivel;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;

    public AcertoProdloteproduto() {
    }

    public AcertoProdloteproduto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodacertoProdlote() {
        return codacertoProdlote;
    }

    public void setCodacertoProdlote(String codacertoProdlote) {
        this.codacertoProdlote = codacertoProdlote;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public Date getDatafabricacao() {
        return datafabricacao;
    }

    public void setDatafabricacao(Date datafabricacao) {
        this.datafabricacao = datafabricacao;
    }

    public String getCodprodutolote() {
        return codprodutolote;
    }

    public void setCodprodutolote(String codprodutolote) {
        this.codprodutolote = codprodutolote;
    }

    public Character getFlagloteperecivel() {
        return flagloteperecivel;
    }

    public void setFlagloteperecivel(Character flagloteperecivel) {
        this.flagloteperecivel = flagloteperecivel;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcertoProdloteproduto)) {
            return false;
        }
        AcertoProdloteproduto other = (AcertoProdloteproduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.AcertoProdloteproduto[ id=" + id + " ]";
    }
    
}
