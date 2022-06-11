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
@Table(name = "COTACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotacao.findAll", query = "SELECT c FROM Cotacao c")
    , @NamedQuery(name = "Cotacao.findByCodcotacao", query = "SELECT c FROM Cotacao c WHERE c.codcotacao = :codcotacao")
    , @NamedQuery(name = "Cotacao.findByCodigo", query = "SELECT c FROM Cotacao c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cotacao.findByNomecotacao", query = "SELECT c FROM Cotacao c WHERE c.nomecotacao = :nomecotacao")
    , @NamedQuery(name = "Cotacao.findByData", query = "SELECT c FROM Cotacao c WHERE c.data = :data")
    , @NamedQuery(name = "Cotacao.findByCoduser", query = "SELECT c FROM Cotacao c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Cotacao.findByFlagstatus", query = "SELECT c FROM Cotacao c WHERE c.flagstatus = :flagstatus")
    , @NamedQuery(name = "Cotacao.findByGuid", query = "SELECT c FROM Cotacao c WHERE c.guid = :guid")
    , @NamedQuery(name = "Cotacao.findByLastChange", query = "SELECT c FROM Cotacao c WHERE c.lastChange = :lastChange")
    , @NamedQuery(name = "Cotacao.findByDataencerramento", query = "SELECT c FROM Cotacao c WHERE c.dataencerramento = :dataencerramento")
    , @NamedQuery(name = "Cotacao.findByDatarecebimento", query = "SELECT c FROM Cotacao c WHERE c.datarecebimento = :datarecebimento")})
public class Cotacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOTACAO")
    private String codcotacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECOTACAO")
    private String nomecotacao;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "FLAGSTATUS")
    private Character flagstatus;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "DATAENCERRAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataencerramento;
    @Column(name = "DATARECEBIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datarecebimento;
    @OneToMany(mappedBy = "codcotacao")
    private Collection<Cotacaoproduto> cotacaoprodutoCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @OneToMany(mappedBy = "codcotacao")
    private Collection<Cotacaofornecedor> cotacaofornecedorCollection;

    public Cotacao() {
    }

    public Cotacao(String codcotacao) {
        this.codcotacao = codcotacao;
    }

    public String getCodcotacao() {
        return codcotacao;
    }

    public void setCodcotacao(String codcotacao) {
        this.codcotacao = codcotacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecotacao() {
        return nomecotacao;
    }

    public void setNomecotacao(String nomecotacao) {
        this.nomecotacao = nomecotacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Character getFlagstatus() {
        return flagstatus;
    }

    public void setFlagstatus(Character flagstatus) {
        this.flagstatus = flagstatus;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Date getDataencerramento() {
        return dataencerramento;
    }

    public void setDataencerramento(Date dataencerramento) {
        this.dataencerramento = dataencerramento;
    }

    public Date getDatarecebimento() {
        return datarecebimento;
    }

    public void setDatarecebimento(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }

    @XmlTransient
    public Collection<Cotacaoproduto> getCotacaoprodutoCollection() {
        return cotacaoprodutoCollection;
    }

    public void setCotacaoprodutoCollection(Collection<Cotacaoproduto> cotacaoprodutoCollection) {
        this.cotacaoprodutoCollection = cotacaoprodutoCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @XmlTransient
    public Collection<Cotacaofornecedor> getCotacaofornecedorCollection() {
        return cotacaofornecedorCollection;
    }

    public void setCotacaofornecedorCollection(Collection<Cotacaofornecedor> cotacaofornecedorCollection) {
        this.cotacaofornecedorCollection = cotacaofornecedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcotacao != null ? codcotacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacao)) {
            return false;
        }
        Cotacao other = (Cotacao) object;
        if ((this.codcotacao == null && other.codcotacao != null) || (this.codcotacao != null && !this.codcotacao.equals(other.codcotacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cotacao[ codcotacao=" + codcotacao + " ]";
    }
    
}
