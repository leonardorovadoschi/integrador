/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VENDEDORCOMISSAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedorcomissao.findAll", query = "SELECT v FROM Vendedorcomissao v")
    , @NamedQuery(name = "Vendedorcomissao.findByCodvendedorcomissao", query = "SELECT v FROM Vendedorcomissao v WHERE v.codvendedorcomissao = :codvendedorcomissao")
    , @NamedQuery(name = "Vendedorcomissao.findByCodvended", query = "SELECT v FROM Vendedorcomissao v WHERE v.codvended = :codvended")
    , @NamedQuery(name = "Vendedorcomissao.findByCoduser", query = "SELECT v FROM Vendedorcomissao v WHERE v.coduser = :coduser")
    , @NamedQuery(name = "Vendedorcomissao.findByData", query = "SELECT v FROM Vendedorcomissao v WHERE v.data = :data")
    , @NamedQuery(name = "Vendedorcomissao.findByValorbasecalculo", query = "SELECT v FROM Vendedorcomissao v WHERE v.valorbasecalculo = :valorbasecalculo")
    , @NamedQuery(name = "Vendedorcomissao.findByValorcomissao", query = "SELECT v FROM Vendedorcomissao v WHERE v.valorcomissao = :valorcomissao")
    , @NamedQuery(name = "Vendedorcomissao.findByTipocomissao", query = "SELECT v FROM Vendedorcomissao v WHERE v.tipocomissao = :tipocomissao")
    , @NamedQuery(name = "Vendedorcomissao.findByLotecomissao", query = "SELECT v FROM Vendedorcomissao v WHERE v.lotecomissao = :lotecomissao")})
public class Vendedorcomissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDEDORCOMISSAO")
    private String codvendedorcomissao;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORBASECALCULO")
    private BigDecimal valorbasecalculo;
    @Column(name = "VALORCOMISSAO")
    private BigDecimal valorcomissao;
    @Column(name = "TIPOCOMISSAO")
    private String tipocomissao;
    @Column(name = "LOTECOMISSAO")
    private Integer lotecomissao;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne
    private Movenda codmovenda;
    @JoinColumn(name = "CODMOVPROD", referencedColumnName = "CODMOVPROD")
    @ManyToOne
    private Movendaprod codmovprod;
    @OneToMany(mappedBy = "codvendedorcomissao")
    private Collection<Vendedordesconto> vendedordescontoCollection;

    public Vendedorcomissao() {
    }

    public Vendedorcomissao(String codvendedorcomissao) {
        this.codvendedorcomissao = codvendedorcomissao;
    }

    public String getCodvendedorcomissao() {
        return codvendedorcomissao;
    }

    public void setCodvendedorcomissao(String codvendedorcomissao) {
        this.codvendedorcomissao = codvendedorcomissao;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
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

    public BigDecimal getValorbasecalculo() {
        return valorbasecalculo;
    }

    public void setValorbasecalculo(BigDecimal valorbasecalculo) {
        this.valorbasecalculo = valorbasecalculo;
    }

    public BigDecimal getValorcomissao() {
        return valorcomissao;
    }

    public void setValorcomissao(BigDecimal valorcomissao) {
        this.valorcomissao = valorcomissao;
    }

    public String getTipocomissao() {
        return tipocomissao;
    }

    public void setTipocomissao(String tipocomissao) {
        this.tipocomissao = tipocomissao;
    }

    public Integer getLotecomissao() {
        return lotecomissao;
    }

    public void setLotecomissao(Integer lotecomissao) {
        this.lotecomissao = lotecomissao;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Movendaprod getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(Movendaprod codmovprod) {
        this.codmovprod = codmovprod;
    }

    @XmlTransient
    public Collection<Vendedordesconto> getVendedordescontoCollection() {
        return vendedordescontoCollection;
    }

    public void setVendedordescontoCollection(Collection<Vendedordesconto> vendedordescontoCollection) {
        this.vendedordescontoCollection = vendedordescontoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedorcomissao != null ? codvendedorcomissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedorcomissao)) {
            return false;
        }
        Vendedorcomissao other = (Vendedorcomissao) object;
        if ((this.codvendedorcomissao == null && other.codvendedorcomissao != null) || (this.codvendedorcomissao != null && !this.codvendedorcomissao.equals(other.codvendedorcomissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedorcomissao[ codvendedorcomissao=" + codvendedorcomissao + " ]";
    }
    
}
