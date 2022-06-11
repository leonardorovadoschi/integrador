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
@Table(name = "TIPOCARTAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocartao.findAll", query = "SELECT t FROM Tipocartao t")
    , @NamedQuery(name = "Tipocartao.findByCodcar", query = "SELECT t FROM Tipocartao t WHERE t.codcar = :codcar")
    , @NamedQuery(name = "Tipocartao.findByCodigo", query = "SELECT t FROM Tipocartao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipocartao.findByCartao", query = "SELECT t FROM Tipocartao t WHERE t.cartao = :cartao")
    , @NamedQuery(name = "Tipocartao.findByDias", query = "SELECT t FROM Tipocartao t WHERE t.dias = :dias")
    , @NamedQuery(name = "Tipocartao.findByComissao", query = "SELECT t FROM Tipocartao t WHERE t.comissao = :comissao")
    , @NamedQuery(name = "Tipocartao.findByTaxaavista", query = "SELECT t FROM Tipocartao t WHERE t.taxaavista = :taxaavista")
    , @NamedQuery(name = "Tipocartao.findByTaxaparcemissor", query = "SELECT t FROM Tipocartao t WHERE t.taxaparcemissor = :taxaparcemissor")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja2x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja2x = :taxaloja2x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja3x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja3x = :taxaloja3x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja4x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja4x = :taxaloja4x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja5x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja5x = :taxaloja5x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja6x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja6x = :taxaloja6x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja7x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja7x = :taxaloja7x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja8x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja8x = :taxaloja8x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja9x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja9x = :taxaloja9x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja10x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja10x = :taxaloja10x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja11x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja11x = :taxaloja11x")
    , @NamedQuery(name = "Tipocartao.findByTaxaloja12x", query = "SELECT t FROM Tipocartao t WHERE t.taxaloja12x = :taxaloja12x")})
public class Tipocartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAR")
    private String codcar;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CARTAO")
    private String cartao;
    @Column(name = "DIAS")
    private Short dias;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "TAXAAVISTA")
    private BigDecimal taxaavista;
    @Column(name = "TAXAPARCEMISSOR")
    private BigDecimal taxaparcemissor;
    @Column(name = "TAXALOJA2X")
    private BigDecimal taxaloja2x;
    @Column(name = "TAXALOJA3X")
    private BigDecimal taxaloja3x;
    @Column(name = "TAXALOJA4X")
    private BigDecimal taxaloja4x;
    @Column(name = "TAXALOJA5X")
    private BigDecimal taxaloja5x;
    @Column(name = "TAXALOJA6X")
    private BigDecimal taxaloja6x;
    @Column(name = "TAXALOJA7X")
    private BigDecimal taxaloja7x;
    @Column(name = "TAXALOJA8X")
    private BigDecimal taxaloja8x;
    @Column(name = "TAXALOJA9X")
    private BigDecimal taxaloja9x;
    @Column(name = "TAXALOJA10X")
    private BigDecimal taxaloja10x;
    @Column(name = "TAXALOJA11X")
    private BigDecimal taxaloja11x;
    @Column(name = "TAXALOJA12X")
    private BigDecimal taxaloja12x;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcar")
    private Collection<Lancacartao> lancacartaoCollection;
    @OneToMany(mappedBy = "codcar")
    private Collection<Cliente> clienteCollection;

    public Tipocartao() {
    }

    public Tipocartao(String codcar) {
        this.codcar = codcar;
    }

    public Tipocartao(String codcar, String codigo) {
        this.codcar = codcar;
        this.codigo = codigo;
    }

    public String getCodcar() {
        return codcar;
    }

    public void setCodcar(String codcar) {
        this.codcar = codcar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Short getDias() {
        return dias;
    }

    public void setDias(Short dias) {
        this.dias = dias;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public BigDecimal getTaxaavista() {
        return taxaavista;
    }

    public void setTaxaavista(BigDecimal taxaavista) {
        this.taxaavista = taxaavista;
    }

    public BigDecimal getTaxaparcemissor() {
        return taxaparcemissor;
    }

    public void setTaxaparcemissor(BigDecimal taxaparcemissor) {
        this.taxaparcemissor = taxaparcemissor;
    }

    public BigDecimal getTaxaloja2x() {
        return taxaloja2x;
    }

    public void setTaxaloja2x(BigDecimal taxaloja2x) {
        this.taxaloja2x = taxaloja2x;
    }

    public BigDecimal getTaxaloja3x() {
        return taxaloja3x;
    }

    public void setTaxaloja3x(BigDecimal taxaloja3x) {
        this.taxaloja3x = taxaloja3x;
    }

    public BigDecimal getTaxaloja4x() {
        return taxaloja4x;
    }

    public void setTaxaloja4x(BigDecimal taxaloja4x) {
        this.taxaloja4x = taxaloja4x;
    }

    public BigDecimal getTaxaloja5x() {
        return taxaloja5x;
    }

    public void setTaxaloja5x(BigDecimal taxaloja5x) {
        this.taxaloja5x = taxaloja5x;
    }

    public BigDecimal getTaxaloja6x() {
        return taxaloja6x;
    }

    public void setTaxaloja6x(BigDecimal taxaloja6x) {
        this.taxaloja6x = taxaloja6x;
    }

    public BigDecimal getTaxaloja7x() {
        return taxaloja7x;
    }

    public void setTaxaloja7x(BigDecimal taxaloja7x) {
        this.taxaloja7x = taxaloja7x;
    }

    public BigDecimal getTaxaloja8x() {
        return taxaloja8x;
    }

    public void setTaxaloja8x(BigDecimal taxaloja8x) {
        this.taxaloja8x = taxaloja8x;
    }

    public BigDecimal getTaxaloja9x() {
        return taxaloja9x;
    }

    public void setTaxaloja9x(BigDecimal taxaloja9x) {
        this.taxaloja9x = taxaloja9x;
    }

    public BigDecimal getTaxaloja10x() {
        return taxaloja10x;
    }

    public void setTaxaloja10x(BigDecimal taxaloja10x) {
        this.taxaloja10x = taxaloja10x;
    }

    public BigDecimal getTaxaloja11x() {
        return taxaloja11x;
    }

    public void setTaxaloja11x(BigDecimal taxaloja11x) {
        this.taxaloja11x = taxaloja11x;
    }

    public BigDecimal getTaxaloja12x() {
        return taxaloja12x;
    }

    public void setTaxaloja12x(BigDecimal taxaloja12x) {
        this.taxaloja12x = taxaloja12x;
    }

    @XmlTransient
    public Collection<Lancacartao> getLancacartaoCollection() {
        return lancacartaoCollection;
    }

    public void setLancacartaoCollection(Collection<Lancacartao> lancacartaoCollection) {
        this.lancacartaoCollection = lancacartaoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcar != null ? codcar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocartao)) {
            return false;
        }
        Tipocartao other = (Tipocartao) object;
        if ((this.codcar == null && other.codcar != null) || (this.codcar != null && !this.codcar.equals(other.codcar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipocartao[ codcar=" + codcar + " ]";
    }
    
}
