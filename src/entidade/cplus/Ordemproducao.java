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
import javax.persistence.Lob;
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
@Table(name = "ORDEMPRODUCAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordemproducao.findAll", query = "SELECT o FROM Ordemproducao o")
    , @NamedQuery(name = "Ordemproducao.findByCodordemproducao", query = "SELECT o FROM Ordemproducao o WHERE o.codordemproducao = :codordemproducao")
    , @NamedQuery(name = "Ordemproducao.findByCoduser", query = "SELECT o FROM Ordemproducao o WHERE o.coduser = :coduser")
    , @NamedQuery(name = "Ordemproducao.findByCodempresa", query = "SELECT o FROM Ordemproducao o WHERE o.codempresa = :codempresa")
    , @NamedQuery(name = "Ordemproducao.findByCodcli", query = "SELECT o FROM Ordemproducao o WHERE o.codcli = :codcli")
    , @NamedQuery(name = "Ordemproducao.findByDatacadastro", query = "SELECT o FROM Ordemproducao o WHERE o.datacadastro = :datacadastro")
    , @NamedQuery(name = "Ordemproducao.findByDataconclusao", query = "SELECT o FROM Ordemproducao o WHERE o.dataconclusao = :dataconclusao")
    , @NamedQuery(name = "Ordemproducao.findByDataprazoproducao", query = "SELECT o FROM Ordemproducao o WHERE o.dataprazoproducao = :dataprazoproducao")
    , @NamedQuery(name = "Ordemproducao.findByCodigo", query = "SELECT o FROM Ordemproducao o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "Ordemproducao.findByFlagconcluido", query = "SELECT o FROM Ordemproducao o WHERE o.flagconcluido = :flagconcluido")
    , @NamedQuery(name = "Ordemproducao.findByDescricao", query = "SELECT o FROM Ordemproducao o WHERE o.descricao = :descricao")
    , @NamedQuery(name = "Ordemproducao.findByCodsetorestoquesaida", query = "SELECT o FROM Ordemproducao o WHERE o.codsetorestoquesaida = :codsetorestoquesaida")
    , @NamedQuery(name = "Ordemproducao.findByNumproducao", query = "SELECT o FROM Ordemproducao o WHERE o.numproducao = :numproducao")
    , @NamedQuery(name = "Ordemproducao.findByFlagstatus", query = "SELECT o FROM Ordemproducao o WHERE o.flagstatus = :flagstatus")})
public class Ordemproducao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORDEMPRODUCAO")
    private String codordemproducao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODEMPRESA")
    private String codempresa;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    @Column(name = "DATACONCLUSAO")
    @Temporal(TemporalType.DATE)
    private Date dataconclusao;
    @Column(name = "DATAPRAZOPRODUCAO")
    @Temporal(TemporalType.DATE)
    private Date dataprazoproducao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FLAGCONCLUIDO")
    private Character flagconcluido;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "CODSETORESTOQUESAIDA")
    private String codsetorestoquesaida;
    @Column(name = "NUMPRODUCAO")
    private Integer numproducao;
    @Column(name = "FLAGSTATUS")
    private Integer flagstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codordemproducao")
    private Collection<Producaohistorico> producaohistoricoCollection;
    @JoinColumn(name = "CODSETORESTOQUEENTRADA", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoqueentrada;
    @OneToMany(mappedBy = "codordemproducao")
    private Collection<Ordemproducaoproduto> ordemproducaoprodutoCollection;

    public Ordemproducao() {
    }

    public Ordemproducao(String codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    public String getCodordemproducao() {
        return codordemproducao;
    }

    public void setCodordemproducao(String codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(String codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Date getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public Date getDataprazoproducao() {
        return dataprazoproducao;
    }

    public void setDataprazoproducao(Date dataprazoproducao) {
        this.dataprazoproducao = dataprazoproducao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Character getFlagconcluido() {
        return flagconcluido;
    }

    public void setFlagconcluido(Character flagconcluido) {
        this.flagconcluido = flagconcluido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodsetorestoquesaida() {
        return codsetorestoquesaida;
    }

    public void setCodsetorestoquesaida(String codsetorestoquesaida) {
        this.codsetorestoquesaida = codsetorestoquesaida;
    }

    public Integer getNumproducao() {
        return numproducao;
    }

    public void setNumproducao(Integer numproducao) {
        this.numproducao = numproducao;
    }

    public Integer getFlagstatus() {
        return flagstatus;
    }

    public void setFlagstatus(Integer flagstatus) {
        this.flagstatus = flagstatus;
    }

    @XmlTransient
    public Collection<Producaohistorico> getProducaohistoricoCollection() {
        return producaohistoricoCollection;
    }

    public void setProducaohistoricoCollection(Collection<Producaohistorico> producaohistoricoCollection) {
        this.producaohistoricoCollection = producaohistoricoCollection;
    }

    public Setorestoque getCodsetorestoqueentrada() {
        return codsetorestoqueentrada;
    }

    public void setCodsetorestoqueentrada(Setorestoque codsetorestoqueentrada) {
        this.codsetorestoqueentrada = codsetorestoqueentrada;
    }

    @XmlTransient
    public Collection<Ordemproducaoproduto> getOrdemproducaoprodutoCollection() {
        return ordemproducaoprodutoCollection;
    }

    public void setOrdemproducaoprodutoCollection(Collection<Ordemproducaoproduto> ordemproducaoprodutoCollection) {
        this.ordemproducaoprodutoCollection = ordemproducaoprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codordemproducao != null ? codordemproducao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordemproducao)) {
            return false;
        }
        Ordemproducao other = (Ordemproducao) object;
        if ((this.codordemproducao == null && other.codordemproducao != null) || (this.codordemproducao != null && !this.codordemproducao.equals(other.codordemproducao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ordemproducao[ codordemproducao=" + codordemproducao + " ]";
    }
    
}
