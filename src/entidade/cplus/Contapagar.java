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
@Table(name = "CONTAPAGAR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contapagar.findAll", query = "SELECT c FROM Contapagar c")
    , @NamedQuery(name = "Contapagar.findByCodcp", query = "SELECT c FROM Contapagar c WHERE c.codcp = :codcp")
    , @NamedQuery(name = "Contapagar.findByCodcpfixa", query = "SELECT c FROM Contapagar c WHERE c.codcpfixa = :codcpfixa")
    , @NamedQuery(name = "Contapagar.findByNumdoc", query = "SELECT c FROM Contapagar c WHERE c.numdoc = :numdoc")
    , @NamedQuery(name = "Contapagar.findByCredor", query = "SELECT c FROM Contapagar c WHERE c.credor = :credor")
    , @NamedQuery(name = "Contapagar.findByFlagforn", query = "SELECT c FROM Contapagar c WHERE c.flagforn = :flagforn")
    , @NamedQuery(name = "Contapagar.findByValor", query = "SELECT c FROM Contapagar c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contapagar.findByDatentr", query = "SELECT c FROM Contapagar c WHERE c.datentr = :datentr")
    , @NamedQuery(name = "Contapagar.findByDatvenc", query = "SELECT c FROM Contapagar c WHERE c.datvenc = :datvenc")
    , @NamedQuery(name = "Contapagar.findByOrigem", query = "SELECT c FROM Contapagar c WHERE c.origem = :origem")
    , @NamedQuery(name = "Contapagar.findByLocal", query = "SELECT c FROM Contapagar c WHERE c.local = :local")
    , @NamedQuery(name = "Contapagar.findByParcela", query = "SELECT c FROM Contapagar c WHERE c.parcela = :parcela")
    , @NamedQuery(name = "Contapagar.findByFlagpago", query = "SELECT c FROM Contapagar c WHERE c.flagpago = :flagpago")
    , @NamedQuery(name = "Contapagar.findByDatpag", query = "SELECT c FROM Contapagar c WHERE c.datpag = :datpag")
    , @NamedQuery(name = "Contapagar.findByValorpg", query = "SELECT c FROM Contapagar c WHERE c.valorpg = :valorpg")
    , @NamedQuery(name = "Contapagar.findByDatvencfixa", query = "SELECT c FROM Contapagar c WHERE c.datvencfixa = :datvencfixa")
    , @NamedQuery(name = "Contapagar.findByLocalfixa", query = "SELECT c FROM Contapagar c WHERE c.localfixa = :localfixa")
    , @NamedQuery(name = "Contapagar.findByValorfixa", query = "SELECT c FROM Contapagar c WHERE c.valorfixa = :valorfixa")
    , @NamedQuery(name = "Contapagar.findByCodigobarra", query = "SELECT c FROM Contapagar c WHERE c.codigobarra = :codigobarra")
    , @NamedQuery(name = "Contapagar.findByNumerotitulobanco", query = "SELECT c FROM Contapagar c WHERE c.numerotitulobanco = :numerotitulobanco")
    , @NamedQuery(name = "Contapagar.findByNumerocontabancaria", query = "SELECT c FROM Contapagar c WHERE c.numerocontabancaria = :numerocontabancaria")
    , @NamedQuery(name = "Contapagar.findByAgencia", query = "SELECT c FROM Contapagar c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Contapagar.findByCodmovenda", query = "SELECT c FROM Contapagar c WHERE c.codmovenda = :codmovenda")
    , @NamedQuery(name = "Contapagar.findByFlagtipoboleto", query = "SELECT c FROM Contapagar c WHERE c.flagtipoboleto = :flagtipoboleto")
    , @NamedQuery(name = "Contapagar.findByRefercontafixa", query = "SELECT c FROM Contapagar c WHERE c.refercontafixa = :refercontafixa")
    , @NamedQuery(name = "Contapagar.findByCoduser", query = "SELECT c FROM Contapagar c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Contapagar.findByLastChange", query = "SELECT c FROM Contapagar c WHERE c.lastChange = :lastChange")
    , @NamedQuery(name = "Contapagar.findByComplemento", query = "SELECT c FROM Contapagar c WHERE c.complemento = :complemento")
    , @NamedQuery(name = "Contapagar.findByDatprevisaopg", query = "SELECT c FROM Contapagar c WHERE c.datprevisaopg = :datprevisaopg")})
public class Contapagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCP")
    private String codcp;
    @Column(name = "CODCPFIXA")
    private String codcpfixa;
    @Column(name = "NUMDOC")
    private String numdoc;
    @Column(name = "CREDOR")
    private String credor;
    @Basic(optional = false)
    @Column(name = "FLAGFORN")
    private Character flagforn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "DATENTR")
    @Temporal(TemporalType.DATE)
    private Date datentr;
    @Column(name = "DATVENC")
    @Temporal(TemporalType.DATE)
    private Date datvenc;
    @Column(name = "ORIGEM")
    private String origem;
    @Column(name = "LOCAL")
    private String local;
    @Column(name = "PARCELA")
    private String parcela;
    @Lob
    @Column(name = "OBS")
    private byte[] obs;
    @Basic(optional = false)
    @Column(name = "FLAGPAGO")
    private Character flagpago;
    @Column(name = "DATPAG")
    @Temporal(TemporalType.DATE)
    private Date datpag;
    @Column(name = "VALORPG")
    private BigDecimal valorpg;
    @Column(name = "DATVENCFIXA")
    @Temporal(TemporalType.DATE)
    private Date datvencfixa;
    @Column(name = "LOCALFIXA")
    private String localfixa;
    @Column(name = "VALORFIXA")
    private BigDecimal valorfixa;
    @Column(name = "CODIGOBARRA")
    private String codigobarra;
    @Column(name = "NUMEROTITULOBANCO")
    private String numerotitulobanco;
    @Column(name = "NUMEROCONTABANCARIA")
    private String numerocontabancaria;
    @Column(name = "AGENCIA")
    private String agencia;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "FLAGTIPOBOLETO")
    private Character flagtipoboleto;
    @Column(name = "REFERCONTAFIXA")
    private String refercontafixa;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "DATPREVISAOPG")
    @Temporal(TemporalType.DATE)
    private Date datprevisaopg;
    @OneToMany(mappedBy = "codcp")
    private Collection<Contapagarpag> contapagarpagCollection;
    @JoinColumn(name = "CODBANCO", referencedColumnName = "CODBANCO")
    @ManyToOne
    private Banco codbanco;
    @JoinColumn(name = "CODCAIXA", referencedColumnName = "CODCAIXA")
    @ManyToOne
    private Caixa codcaixa;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCLIREVENDA", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclirevenda;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODMOVENTR", referencedColumnName = "CODMOVENTR")
    @ManyToOne
    private Moventrada codmoventr;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @JoinColumn(name = "CODSITUACAOADMINISTRATIVA", referencedColumnName = "CODSITUACAOADMINISTRATIVA")
    @ManyToOne
    private Situacaoadministrativa codsituacaoadministrativa;

    public Contapagar() {
    }

    public Contapagar(String codcp) {
        this.codcp = codcp;
    }

    public Contapagar(String codcp, Character flagforn, BigDecimal valor, Character flagpago) {
        this.codcp = codcp;
        this.flagforn = flagforn;
        this.valor = valor;
        this.flagpago = flagpago;
    }

    public String getCodcp() {
        return codcp;
    }

    public void setCodcp(String codcp) {
        this.codcp = codcp;
    }

    public String getCodcpfixa() {
        return codcpfixa;
    }

    public void setCodcpfixa(String codcpfixa) {
        this.codcpfixa = codcpfixa;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public Character getFlagforn() {
        return flagforn;
    }

    public void setFlagforn(Character flagforn) {
        this.flagforn = flagforn;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDatentr() {
        return datentr;
    }

    public void setDatentr(Date datentr) {
        this.datentr = datentr;
    }

    public Date getDatvenc() {
        return datvenc;
    }

    public void setDatvenc(Date datvenc) {
        this.datvenc = datvenc;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public byte[] getObs() {
        return obs;
    }

    public void setObs(byte[] obs) {
        this.obs = obs;
    }

    public Character getFlagpago() {
        return flagpago;
    }

    public void setFlagpago(Character flagpago) {
        this.flagpago = flagpago;
    }

    public Date getDatpag() {
        return datpag;
    }

    public void setDatpag(Date datpag) {
        this.datpag = datpag;
    }

    public BigDecimal getValorpg() {
        return valorpg;
    }

    public void setValorpg(BigDecimal valorpg) {
        this.valorpg = valorpg;
    }

    public Date getDatvencfixa() {
        return datvencfixa;
    }

    public void setDatvencfixa(Date datvencfixa) {
        this.datvencfixa = datvencfixa;
    }

    public String getLocalfixa() {
        return localfixa;
    }

    public void setLocalfixa(String localfixa) {
        this.localfixa = localfixa;
    }

    public BigDecimal getValorfixa() {
        return valorfixa;
    }

    public void setValorfixa(BigDecimal valorfixa) {
        this.valorfixa = valorfixa;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getNumerotitulobanco() {
        return numerotitulobanco;
    }

    public void setNumerotitulobanco(String numerotitulobanco) {
        this.numerotitulobanco = numerotitulobanco;
    }

    public String getNumerocontabancaria() {
        return numerocontabancaria;
    }

    public void setNumerocontabancaria(String numerocontabancaria) {
        this.numerocontabancaria = numerocontabancaria;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Character getFlagtipoboleto() {
        return flagtipoboleto;
    }

    public void setFlagtipoboleto(Character flagtipoboleto) {
        this.flagtipoboleto = flagtipoboleto;
    }

    public String getRefercontafixa() {
        return refercontafixa;
    }

    public void setRefercontafixa(String refercontafixa) {
        this.refercontafixa = refercontafixa;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Date getDatprevisaopg() {
        return datprevisaopg;
    }

    public void setDatprevisaopg(Date datprevisaopg) {
        this.datprevisaopg = datprevisaopg;
    }

    @XmlTransient
    public Collection<Contapagarpag> getContapagarpagCollection() {
        return contapagarpagCollection;
    }

    public void setContapagarpagCollection(Collection<Contapagarpag> contapagarpagCollection) {
        this.contapagarpagCollection = contapagarpagCollection;
    }

    public Banco getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(Banco codbanco) {
        this.codbanco = codbanco;
    }

    public Caixa getCodcaixa() {
        return codcaixa;
    }

    public void setCodcaixa(Caixa codcaixa) {
        this.codcaixa = codcaixa;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Centrocusto getCodcentrocusto() {
        return codcentrocusto;
    }

    public void setCodcentrocusto(Centrocusto codcentrocusto) {
        this.codcentrocusto = codcentrocusto;
    }

    public Cliente getCodclirevenda() {
        return codclirevenda;
    }

    public void setCodclirevenda(Cliente codclirevenda) {
        this.codclirevenda = codclirevenda;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    public Moventrada getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(Moventrada codmoventr) {
        this.codmoventr = codmoventr;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    public Situacaoadministrativa getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(Situacaoadministrativa codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcp != null ? codcp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contapagar)) {
            return false;
        }
        Contapagar other = (Contapagar) object;
        if ((this.codcp == null && other.codcp != null) || (this.codcp != null && !this.codcp.equals(other.codcp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contapagar[ codcp=" + codcp + " ]";
    }
    
}
