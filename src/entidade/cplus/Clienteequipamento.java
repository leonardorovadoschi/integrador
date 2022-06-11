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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "CLIENTEEQUIPAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteequipamento.findAll", query = "SELECT c FROM Clienteequipamento c")
    , @NamedQuery(name = "Clienteequipamento.findByCodclienteequipamento", query = "SELECT c FROM Clienteequipamento c WHERE c.codclienteequipamento = :codclienteequipamento")
    , @NamedQuery(name = "Clienteequipamento.findByCodigo", query = "SELECT c FROM Clienteequipamento c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Clienteequipamento.findByDescricao", query = "SELECT c FROM Clienteequipamento c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Clienteequipamento.findByTipo", query = "SELECT c FROM Clienteequipamento c WHERE c.tipo = :tipo")
    , @NamedQuery(name = "Clienteequipamento.findByMarcamodelo", query = "SELECT c FROM Clienteequipamento c WHERE c.marcamodelo = :marcamodelo")
    , @NamedQuery(name = "Clienteequipamento.findByIdentificador", query = "SELECT c FROM Clienteequipamento c WHERE c.identificador = :identificador")
    , @NamedQuery(name = "Clienteequipamento.findByValorvisita", query = "SELECT c FROM Clienteequipamento c WHERE c.valorvisita = :valorvisita")
    , @NamedQuery(name = "Clienteequipamento.findByValorhoraadicional", query = "SELECT c FROM Clienteequipamento c WHERE c.valorhoraadicional = :valorhoraadicional")
    , @NamedQuery(name = "Clienteequipamento.findByNumhorasvisita", query = "SELECT c FROM Clienteequipamento c WHERE c.numhorasvisita = :numhorasvisita")
    , @NamedQuery(name = "Clienteequipamento.findByFlaginativo", query = "SELECT c FROM Clienteequipamento c WHERE c.flaginativo = :flaginativo")})
public class Clienteequipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCLIENTEEQUIPAMENTO")
    private String codclienteequipamento;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TIPO")
    private String tipo;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "MARCAMODELO")
    private String marcamodelo;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORVISITA")
    private BigDecimal valorvisita;
    @Column(name = "VALORHORAADICIONAL")
    private BigDecimal valorhoraadicional;
    @Column(name = "NUMHORASVISITA")
    private BigDecimal numhorasvisita;
    @Column(name = "FLAGINATIVO")
    private Character flaginativo;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne(optional = false)
    private Cliente codcli;
    @JoinColumn(name = "CODMOD", referencedColumnName = "CODMOD")
    @ManyToOne
    private OsModalidade codmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codclienteequipamento")
    private Collection<ClienteequipCampousuario> clienteequipCampousuarioCollection;
    @OneToMany(mappedBy = "codclienteequipamento")
    private Collection<OsOrdemservico> osOrdemservicoCollection;

    public Clienteequipamento() {
    }

    public Clienteequipamento(String codclienteequipamento) {
        this.codclienteequipamento = codclienteequipamento;
    }

    public Clienteequipamento(String codclienteequipamento, String codigo) {
        this.codclienteequipamento = codclienteequipamento;
        this.codigo = codigo;
    }

    public String getCodclienteequipamento() {
        return codclienteequipamento;
    }

    public void setCodclienteequipamento(String codclienteequipamento) {
        this.codclienteequipamento = codclienteequipamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public BigDecimal getValorvisita() {
        return valorvisita;
    }

    public void setValorvisita(BigDecimal valorvisita) {
        this.valorvisita = valorvisita;
    }

    public BigDecimal getValorhoraadicional() {
        return valorhoraadicional;
    }

    public void setValorhoraadicional(BigDecimal valorhoraadicional) {
        this.valorhoraadicional = valorhoraadicional;
    }

    public BigDecimal getNumhorasvisita() {
        return numhorasvisita;
    }

    public void setNumhorasvisita(BigDecimal numhorasvisita) {
        this.numhorasvisita = numhorasvisita;
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        this.flaginativo = flaginativo;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public OsModalidade getCodmod() {
        return codmod;
    }

    public void setCodmod(OsModalidade codmod) {
        this.codmod = codmod;
    }

    @XmlTransient
    public Collection<ClienteequipCampousuario> getClienteequipCampousuarioCollection() {
        return clienteequipCampousuarioCollection;
    }

    public void setClienteequipCampousuarioCollection(Collection<ClienteequipCampousuario> clienteequipCampousuarioCollection) {
        this.clienteequipCampousuarioCollection = clienteequipCampousuarioCollection;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codclienteequipamento != null ? codclienteequipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteequipamento)) {
            return false;
        }
        Clienteequipamento other = (Clienteequipamento) object;
        if ((this.codclienteequipamento == null && other.codclienteequipamento != null) || (this.codclienteequipamento != null && !this.codclienteequipamento.equals(other.codclienteequipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Clienteequipamento[ codclienteequipamento=" + codclienteequipamento + " ]";
    }
    
}
