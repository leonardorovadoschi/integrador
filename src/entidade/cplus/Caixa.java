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
@Table(name = "CAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findByCodcaixa", query = "SELECT c FROM Caixa c WHERE c.codcaixa = :codcaixa")
    , @NamedQuery(name = "Caixa.findByOperacao", query = "SELECT c FROM Caixa c WHERE c.operacao = :operacao")
    , @NamedQuery(name = "Caixa.findByCoduser", query = "SELECT c FROM Caixa c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Caixa.findByCodmovenda", query = "SELECT c FROM Caixa c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Caixa.findByCodforn", query = "SELECT c FROM Caixa c WHERE c.codforn = :codforn")
    , @NamedQuery(name = "Caixa.findByIdrec", query = "SELECT c FROM Caixa c WHERE c.idrec = :idrec")
    , @NamedQuery(name = "Caixa.findByData", query = "SELECT c FROM Caixa c WHERE c.data = :data")
    , @NamedQuery(name = "Caixa.findByHistorico", query = "SELECT c FROM Caixa c WHERE c.historico = :historico")
    , @NamedQuery(name = "Caixa.findByNumdoc", query = "SELECT c FROM Caixa c WHERE c.numdoc = :numdoc")
    , @NamedQuery(name = "Caixa.findByValor", query = "SELECT c FROM Caixa c WHERE c.valor = :valor")
    , @NamedQuery(name = "Caixa.findByDatlan", query = "SELECT c FROM Caixa c WHERE c.datlan = :datlan")
    , @NamedQuery(name = "Caixa.findByVisto", query = "SELECT c FROM Caixa c WHERE c.visto = :visto")
    , @NamedQuery(name = "Caixa.findByFlagforncli", query = "SELECT c FROM Caixa c WHERE c.flagforncli = :flagforncli")
    , @NamedQuery(name = "Caixa.findByGuid", query = "SELECT c FROM Caixa c WHERE c.guid = :guid")
    , @NamedQuery(name = "Caixa.findByCodcentrocusto", query = "SELECT c FROM Caixa c WHERE c.codcentrocusto = :codcentrocusto")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAIXA")
    private String codcaixa;
    @Column(name = "OPERACAO")
    private Character operacao;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "IDREC")
    private String idrec;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HISTORICO")
    private String historico;
    @Column(name = "NUMDOC")
    private String numdoc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DATLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datlan;
    @Column(name = "VISTO")
    private Character visto;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "FLAGFORNCLI")
    private Character flagforncli;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CODCENTROCUSTO")
    private String codcentrocusto;
    @OneToMany(mappedBy = "codcaixa")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(mappedBy = "codcaixa")
    private Collection<Contapagarpag> contapagarpagCollection;
    @OneToMany(mappedBy = "codcaixa")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codcaixa")
    private Collection<Contareceberrec> contareceberrecCollection;
    @OneToMany(mappedBy = "codcaixa")
    private Collection<Cheques> chequesCollection;

    public Caixa() {
    }

    public Caixa(String codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Caixa(String codcaixa, BigDecimal valor) {
        this.codcaixa = codcaixa;
        this.valor = valor;
    }

    public String getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(String codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getIdrec() {
        return idrec;
    }

    public void setIdrec(String idrec) {
        this.idrec = idrec;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatlan() {
        return datlan;
    }

    public void setDatlan(Date datlan) {
        this.datlan = datlan;
    }

    public Character getVisto() {
        return visto;
    }

    public void setVisto(Character visto) {
        this.visto = visto;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Character getFlagforncli() {
        return flagforncli;
    }

    public void setFlagforncli(Character flagforncli) {
        this.flagforncli = flagforncli;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(String codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    @XmlTransient
    public Collection<Contapagarpag> getContapagarpagCollection() {
        return contapagarpagCollection;
    }

    public void setContapagarpagCollection(Collection<Contapagarpag> contapagarpagCollection) {
        this.contapagarpagCollection = contapagarpagCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Contareceberrec> getContareceberrecCollection() {
        return contareceberrecCollection;
    }

    public void setContareceberrecCollection(Collection<Contareceberrec> contareceberrecCollection) {
        this.contareceberrecCollection = contareceberrecCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcaixa != null ? codcaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.codcaixa == null && other.codcaixa != null) || (this.codcaixa != null && !this.codcaixa.equals(other.codcaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Caixa[ codcaixa=" + codcaixa + " ]";
    }
    
}
