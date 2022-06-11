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
@Table(name = "PRECO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preco.findAll", query = "SELECT p FROM Preco p")
    , @NamedQuery(name = "Preco.findByCodpreco", query = "SELECT p FROM Preco p WHERE p.codpreco = :codpreco")
    , @NamedQuery(name = "Preco.findByNomepreco", query = "SELECT p FROM Preco p WHERE p.nomepreco = :nomepreco")
    , @NamedQuery(name = "Preco.findByCodigo", query = "SELECT p FROM Preco p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Preco.findByFlagvisualizarconsulta", query = "SELECT p FROM Preco p WHERE p.flagvisualizarconsulta = :flagvisualizarconsulta")
    , @NamedQuery(name = "Preco.findByMargempadrao", query = "SELECT p FROM Preco p WHERE p.margempadrao = :margempadrao")
    , @NamedQuery(name = "Preco.findByAliqcomissao", query = "SELECT p FROM Preco p WHERE p.aliqcomissao = :aliqcomissao")
    , @NamedQuery(name = "Preco.findByDescontomaximo", query = "SELECT p FROM Preco p WHERE p.descontomaximo = :descontomaximo")
    , @NamedQuery(name = "Preco.findByFormula", query = "SELECT p FROM Preco p WHERE p.formula = :formula")
    , @NamedQuery(name = "Preco.findByFlagusaformula", query = "SELECT p FROM Preco p WHERE p.flagusaformula = :flagusaformula")
    , @NamedQuery(name = "Preco.findByFlagexportaafv", query = "SELECT p FROM Preco p WHERE p.flagexportaafv = :flagexportaafv")
    , @NamedQuery(name = "Preco.findByGuid", query = "SELECT p FROM Preco p WHERE p.guid = :guid")
    , @NamedQuery(name = "Preco.findByFlaginativa", query = "SELECT p FROM Preco p WHERE p.flaginativa = :flaginativa")
    , @NamedQuery(name = "Preco.findByFlagexportapdv", query = "SELECT p FROM Preco p WHERE p.flagexportapdv = :flagexportapdv")
    , @NamedQuery(name = "Preco.findByMensagem", query = "SELECT p FROM Preco p WHERE p.mensagem = :mensagem")
    , @NamedQuery(name = "Preco.findByListaformapag", query = "SELECT p FROM Preco p WHERE p.listaformapag = :listaformapag")
    , @NamedQuery(name = "Preco.findByEstado", query = "SELECT p FROM Preco p WHERE p.estado = :estado")})
public class Preco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRECO")
    private String codpreco;
    @Column(name = "NOMEPRECO")
    private String nomepreco;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FLAGVISUALIZARCONSULTA")
    private Character flagvisualizarconsulta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MARGEMPADRAO")
    private BigDecimal margempadrao;
    @Column(name = "ALIQCOMISSAO")
    private BigDecimal aliqcomissao;
    @Column(name = "DESCONTOMAXIMO")
    private BigDecimal descontomaximo;
    @Column(name = "FORMULA")
    private String formula;
    @Column(name = "FLAGUSAFORMULA")
    private Character flagusaformula;
    @Column(name = "FLAGEXPORTAAFV")
    private Character flagexportaafv;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGINATIVA")
    private Character flaginativa;
    @Column(name = "FLAGEXPORTAPDV")
    private Character flagexportapdv;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "LISTAFORMAPAG")
    private String listaformapag;
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(mappedBy = "codprecodistribuidor")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpreco")
    private Collection<Produtopreco> produtoprecoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<OsProdserv> osProdservCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<OsOrdemservico> osOrdemservicoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Usuariopreco> usuarioprecoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Produtoprecoescalonado> produtoprecoescalonadoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Orcamentoprod> orcamentoprodCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Clienteproduto> clienteprodutoCollection;
    @OneToMany(mappedBy = "codpreco")
    private Collection<Cliente> clienteCollection;

    public Preco() {
    }

    public Preco(String codpreco) {
        this.codpreco = codpreco;
    }

    public Preco(String codpreco, String codigo) {
        this.codpreco = codpreco;
        this.codigo = codigo;
    }

    public String getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(String codpreco) {
        this.codpreco = codpreco;
    }

    public String getNomepreco() {
        return nomepreco;
    }

    public void setNomepreco(String nomepreco) {
        this.nomepreco = nomepreco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Character getFlagvisualizarconsulta() {
        return flagvisualizarconsulta;
    }

    public void setFlagvisualizarconsulta(Character flagvisualizarconsulta) {
        this.flagvisualizarconsulta = flagvisualizarconsulta;
    }

    public BigDecimal getMargempadrao() {
        return margempadrao;
    }

    public void setMargempadrao(BigDecimal margempadrao) {
        this.margempadrao = margempadrao;
    }

    public BigDecimal getAliqcomissao() {
        return aliqcomissao;
    }

    public void setAliqcomissao(BigDecimal aliqcomissao) {
        this.aliqcomissao = aliqcomissao;
    }

    public BigDecimal getDescontomaximo() {
        return descontomaximo;
    }

    public void setDescontomaximo(BigDecimal descontomaximo) {
        this.descontomaximo = descontomaximo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Character getFlagusaformula() {
        return flagusaformula;
    }

    public void setFlagusaformula(Character flagusaformula) {
        this.flagusaformula = flagusaformula;
    }

    public Character getFlagexportaafv() {
        return flagexportaafv;
    }

    public void setFlagexportaafv(Character flagexportaafv) {
        this.flagexportaafv = flagexportaafv;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlaginativa() {
        return flaginativa;
    }

    public void setFlaginativa(Character flaginativa) {
        this.flaginativa = flaginativa;
    }

    public Character getFlagexportapdv() {
        return flagexportapdv;
    }

    public void setFlagexportapdv(Character flagexportapdv) {
        this.flagexportapdv = flagexportapdv;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getListaformapag() {
        return listaformapag;
    }

    public void setListaformapag(String listaformapag) {
        this.listaformapag = listaformapag;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection1() {
        return calculoicmsestadoCollection1;
    }

    public void setCalculoicmsestadoCollection1(Collection<Calculoicmsestado> calculoicmsestadoCollection1) {
        this.calculoicmsestadoCollection1 = calculoicmsestadoCollection1;
    }

    @XmlTransient
    public Collection<Produtopreco> getProdutoprecoCollection() {
        return produtoprecoCollection;
    }

    public void setProdutoprecoCollection(Collection<Produtopreco> produtoprecoCollection) {
        this.produtoprecoCollection = produtoprecoCollection;
    }

    @XmlTransient
    public Collection<OsProdserv> getOsProdservCollection() {
        return osProdservCollection;
    }

    public void setOsProdservCollection(Collection<OsProdserv> osProdservCollection) {
        this.osProdservCollection = osProdservCollection;
    }

    @XmlTransient
    public Collection<Reajusteprodutopreco> getReajusteprodutoprecoCollection() {
        return reajusteprodutoprecoCollection;
    }

    public void setReajusteprodutoprecoCollection(Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection) {
        this.reajusteprodutoprecoCollection = reajusteprodutoprecoCollection;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @XmlTransient
    public Collection<Usuariopreco> getUsuarioprecoCollection() {
        return usuarioprecoCollection;
    }

    public void setUsuarioprecoCollection(Collection<Usuariopreco> usuarioprecoCollection) {
        this.usuarioprecoCollection = usuarioprecoCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Produtoprecoescalonado> getProdutoprecoescalonadoCollection() {
        return produtoprecoescalonadoCollection;
    }

    public void setProdutoprecoescalonadoCollection(Collection<Produtoprecoescalonado> produtoprecoescalonadoCollection) {
        this.produtoprecoescalonadoCollection = produtoprecoescalonadoCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @XmlTransient
    public Collection<Clienteproduto> getClienteprodutoCollection() {
        return clienteprodutoCollection;
    }

    public void setClienteprodutoCollection(Collection<Clienteproduto> clienteprodutoCollection) {
        this.clienteprodutoCollection = clienteprodutoCollection;
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
        hash += (codpreco != null ? codpreco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preco)) {
            return false;
        }
        Preco other = (Preco) object;
        if ((this.codpreco == null && other.codpreco != null) || (this.codpreco != null && !this.codpreco.equals(other.codpreco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Preco[ codpreco=" + codpreco + " ]";
    }
    
}
