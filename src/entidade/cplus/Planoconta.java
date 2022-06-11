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
@Table(name = "PLANOCONTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planoconta.findAll", query = "SELECT p FROM Planoconta p")
    , @NamedQuery(name = "Planoconta.findByCodpc", query = "SELECT p FROM Planoconta p WHERE p.codpc = :codpc")
    , @NamedQuery(name = "Planoconta.findByCodigo", query = "SELECT p FROM Planoconta p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Planoconta.findByDescricao", query = "SELECT p FROM Planoconta p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Planoconta.findByOperacao", query = "SELECT p FROM Planoconta p WHERE p.operacao = :operacao")
    , @NamedQuery(name = "Planoconta.findByClassificacao", query = "SELECT p FROM Planoconta p WHERE p.classificacao = :classificacao")
    , @NamedQuery(name = "Planoconta.findByTipo", query = "SELECT p FROM Planoconta p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Planoconta.findByLastChange", query = "SELECT p FROM Planoconta p WHERE p.lastChange = :lastChange")
    , @NamedQuery(name = "Planoconta.findByCodigocontarfb", query = "SELECT p FROM Planoconta p WHERE p.codigocontarfb = :codigocontarfb")})
public class Planoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPC")
    private String codpc;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "OPERACAO")
    private Character operacao;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.DATE)
    private Date lastChange;
    @Column(name = "CODIGOCONTARFB")
    private String codigocontarfb;
    @OneToMany(mappedBy = "codpc")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Caixa> caixaCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Cheques> chequesCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Contareceberfixa> contareceberfixaCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Recebimento> recebimentoCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Terminal> terminalCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Contapagarfixa> contapagarfixaCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Contabancaria> contabancariaCollection;
    @OneToMany(mappedBy = "codpc")
    private Collection<Cliente> clienteCollection;

    public Planoconta() {
    }

    public Planoconta(String codpc) {
        this.codpc = codpc;
    }

    public Planoconta(String codpc, String codigo, String descricao, Character operacao) {
        this.codpc = codpc;
        this.codigo = codigo;
        this.descricao = descricao;
        this.operacao = operacao;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
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

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getCodigocontarfb() {
        return codigocontarfb;
    }

    public void setCodigocontarfb(String codigocontarfb) {
        this.codigocontarfb = codigocontarfb;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Contareceberfixa> getContareceberfixaCollection() {
        return contareceberfixaCollection;
    }

    public void setContareceberfixaCollection(Collection<Contareceberfixa> contareceberfixaCollection) {
        this.contareceberfixaCollection = contareceberfixaCollection;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
    }

    @XmlTransient
    public Collection<Contapagarfixa> getContapagarfixaCollection() {
        return contapagarfixaCollection;
    }

    public void setContapagarfixaCollection(Collection<Contapagarfixa> contapagarfixaCollection) {
        this.contapagarfixaCollection = contapagarfixaCollection;
    }

    @XmlTransient
    public Collection<Contabancaria> getContabancariaCollection() {
        return contabancariaCollection;
    }

    public void setContabancariaCollection(Collection<Contabancaria> contabancariaCollection) {
        this.contabancariaCollection = contabancariaCollection;
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
        hash += (codpc != null ? codpc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planoconta)) {
            return false;
        }
        Planoconta other = (Planoconta) object;
        if ((this.codpc == null && other.codpc != null) || (this.codpc != null && !this.codpc.equals(other.codpc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Planoconta[ codpc=" + codpc + " ]";
    }
    
}
