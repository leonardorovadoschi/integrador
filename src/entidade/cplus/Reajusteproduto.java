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
@Table(name = "REAJUSTEPRODUTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reajusteproduto.findAll", query = "SELECT r FROM Reajusteproduto r")
    , @NamedQuery(name = "Reajusteproduto.findByCodreajusteproduto", query = "SELECT r FROM Reajusteproduto r WHERE r.codreajusteproduto = :codreajusteproduto")
    , @NamedQuery(name = "Reajusteproduto.findByPrecocusto", query = "SELECT r FROM Reajusteproduto r WHERE r.precocusto = :precocusto")
    , @NamedQuery(name = "Reajusteproduto.findByPercoutroscustos", query = "SELECT r FROM Reajusteproduto r WHERE r.percoutroscustos = :percoutroscustos")
    , @NamedQuery(name = "Reajusteproduto.findByValoutroscustos", query = "SELECT r FROM Reajusteproduto r WHERE r.valoutroscustos = :valoutroscustos")
    , @NamedQuery(name = "Reajusteproduto.findByOutros", query = "SELECT r FROM Reajusteproduto r WHERE r.outros = :outros")
    , @NamedQuery(name = "Reajusteproduto.findByCustoreal", query = "SELECT r FROM Reajusteproduto r WHERE r.custoreal = :custoreal")
    , @NamedQuery(name = "Reajusteproduto.findByCodigo", query = "SELECT r FROM Reajusteproduto r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Reajusteproduto.findByNomeprod", query = "SELECT r FROM Reajusteproduto r WHERE r.nomeprod = :nomeprod")
    , @NamedQuery(name = "Reajusteproduto.findByNomeentidadeorigem", query = "SELECT r FROM Reajusteproduto r WHERE r.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Reajusteproduto.findByIdentidadeorigem", query = "SELECT r FROM Reajusteproduto r WHERE r.identidadeorigem = :identidadeorigem")})
public class Reajusteproduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREAJUSTEPRODUTO")
    private Integer codreajusteproduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECOCUSTO")
    private BigDecimal precocusto;
    @Column(name = "PERCOUTROSCUSTOS")
    private BigDecimal percoutroscustos;
    @Column(name = "VALOUTROSCUSTOS")
    private BigDecimal valoutroscustos;
    @Column(name = "OUTROS")
    private BigDecimal outros;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPROD")
    private String nomeprod;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODREAJUSTE", referencedColumnName = "CODREAJUSTE")
    @ManyToOne
    private Reajuste codreajuste;
    @OneToMany(mappedBy = "codreajusteproduto")
    private Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection;

    public Reajusteproduto() {
    }

    public Reajusteproduto(Integer codreajusteproduto) {
        this.codreajusteproduto = codreajusteproduto;
    }

    public Integer getCodreajusteproduto() {
        return codreajusteproduto;
    }

    public void setCodreajusteproduto(Integer codreajusteproduto) {
        this.codreajusteproduto = codreajusteproduto;
    }

    public BigDecimal getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(BigDecimal precocusto) {
        this.precocusto = precocusto;
    }

    public BigDecimal getPercoutroscustos() {
        return percoutroscustos;
    }

    public void setPercoutroscustos(BigDecimal percoutroscustos) {
        this.percoutroscustos = percoutroscustos;
    }

    public BigDecimal getValoutroscustos() {
        return valoutroscustos;
    }

    public void setValoutroscustos(BigDecimal valoutroscustos) {
        this.valoutroscustos = valoutroscustos;
    }

    public BigDecimal getOutros() {
        return outros;
    }

    public void setOutros(BigDecimal outros) {
        this.outros = outros;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Reajuste getCodreajuste() {
        return codreajuste;
    }

    public void setCodreajuste(Reajuste codreajuste) {
        this.codreajuste = codreajuste;
    }

    @XmlTransient
    public Collection<Reajusteprodutopreco> getReajusteprodutoprecoCollection() {
        return reajusteprodutoprecoCollection;
    }

    public void setReajusteprodutoprecoCollection(Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection) {
        this.reajusteprodutoprecoCollection = reajusteprodutoprecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codreajusteproduto != null ? codreajusteproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reajusteproduto)) {
            return false;
        }
        Reajusteproduto other = (Reajusteproduto) object;
        if ((this.codreajusteproduto == null && other.codreajusteproduto != null) || (this.codreajusteproduto != null && !this.codreajusteproduto.equals(other.codreajusteproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Reajusteproduto[ codreajusteproduto=" + codreajusteproduto + " ]";
    }
    
}
