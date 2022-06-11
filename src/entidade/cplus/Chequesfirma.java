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
@Table(name = "CHEQUESFIRMA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chequesfirma.findAll", query = "SELECT c FROM Chequesfirma c")
    , @NamedQuery(name = "Chequesfirma.findByCodchequefirma", query = "SELECT c FROM Chequesfirma c WHERE c.codchequefirma = :codchequefirma")
    , @NamedQuery(name = "Chequesfirma.findByCodcp", query = "SELECT c FROM Chequesfirma c WHERE c.codcp = :codcp")
    , @NamedQuery(name = "Chequesfirma.findByEntrada", query = "SELECT c FROM Chequesfirma c WHERE c.entrada = :entrada")
    , @NamedQuery(name = "Chequesfirma.findByEmitente", query = "SELECT c FROM Chequesfirma c WHERE c.emitente = :emitente")
    , @NamedQuery(name = "Chequesfirma.findByValor", query = "SELECT c FROM Chequesfirma c WHERE c.valor = :valor")
    , @NamedQuery(name = "Chequesfirma.findByNumcheque", query = "SELECT c FROM Chequesfirma c WHERE c.numcheque = :numcheque")
    , @NamedQuery(name = "Chequesfirma.findByBanco", query = "SELECT c FROM Chequesfirma c WHERE c.banco = :banco")
    , @NamedQuery(name = "Chequesfirma.findByAgencia", query = "SELECT c FROM Chequesfirma c WHERE c.agencia = :agencia")
    , @NamedQuery(name = "Chequesfirma.findByDepositar", query = "SELECT c FROM Chequesfirma c WHERE c.depositar = :depositar")
    , @NamedQuery(name = "Chequesfirma.findByQuantret", query = "SELECT c FROM Chequesfirma c WHERE c.quantret = :quantret")
    , @NamedQuery(name = "Chequesfirma.findByFlagforn", query = "SELECT c FROM Chequesfirma c WHERE c.flagforn = :flagforn")
    , @NamedQuery(name = "Chequesfirma.findByFlagdepos", query = "SELECT c FROM Chequesfirma c WHERE c.flagdepos = :flagdepos")
    , @NamedQuery(name = "Chequesfirma.findByDeposito", query = "SELECT c FROM Chequesfirma c WHERE c.deposito = :deposito")
    , @NamedQuery(name = "Chequesfirma.findByRetornou", query = "SELECT c FROM Chequesfirma c WHERE c.retornou = :retornou")
    , @NamedQuery(name = "Chequesfirma.findByDestinatario", query = "SELECT c FROM Chequesfirma c WHERE c.destinatario = :destinatario")
    , @NamedQuery(name = "Chequesfirma.findByHistorico", query = "SELECT c FROM Chequesfirma c WHERE c.historico = :historico")
    , @NamedQuery(name = "Chequesfirma.findByCodsituacaoadministrativa", query = "SELECT c FROM Chequesfirma c WHERE c.codsituacaoadministrativa = :codsituacaoadministrativa")
    , @NamedQuery(name = "Chequesfirma.findByLotechequefirma", query = "SELECT c FROM Chequesfirma c WHERE c.lotechequefirma = :lotechequefirma")
    , @NamedQuery(name = "Chequesfirma.findByLotecheques", query = "SELECT c FROM Chequesfirma c WHERE c.lotecheques = :lotecheques")
    , @NamedQuery(name = "Chequesfirma.findByNumeroconta", query = "SELECT c FROM Chequesfirma c WHERE c.numeroconta = :numeroconta")})
public class Chequesfirma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCHEQUEFIRMA")
    private String codchequefirma;
    @Column(name = "CODCP")
    private String codcp;
    @Column(name = "ENTRADA")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Column(name = "EMITENTE")
    private String emitente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "NUMCHEQUE")
    private String numcheque;
    @Column(name = "BANCO")
    private String banco;
    @Column(name = "AGENCIA")
    private String agencia;
    @Column(name = "DEPOSITAR")
    @Temporal(TemporalType.DATE)
    private Date depositar;
    @Basic(optional = false)
    @Column(name = "QUANTRET")
    private short quantret;
    @Column(name = "FLAGFORN")
    private Character flagforn;
    @Basic(optional = false)
    @Column(name = "FLAGDEPOS")
    private Character flagdepos;
    @Column(name = "DEPOSITO")
    @Temporal(TemporalType.DATE)
    private Date deposito;
    @Column(name = "RETORNOU")
    private Character retornou;
    @Column(name = "DESTINATARIO")
    private String destinatario;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "HISTORICO")
    private String historico;
    @Column(name = "CODSITUACAOADMINISTRATIVA")
    private String codsituacaoadministrativa;
    @Column(name = "LOTECHEQUEFIRMA")
    private String lotechequefirma;
    @Column(name = "LOTECHEQUES")
    private String lotecheques;
    @Column(name = "NUMEROCONTA")
    private String numeroconta;
    @JoinColumn(name = "CODCAIXA", referencedColumnName = "CODCAIXA")
    @ManyToOne
    private Caixa codcaixa;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCENTROCUSTO", referencedColumnName = "CODCENTROCUSTO")
    @ManyToOne
    private Centrocusto codcentrocusto;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(mappedBy = "codchequefirma")
    private Collection<Contapagarpag> contapagarpagCollection;

    public Chequesfirma() {
    }

    public Chequesfirma(String codchequefirma) {
        this.codchequefirma = codchequefirma;
    }

    public Chequesfirma(String codchequefirma, String numcheque, short quantret, Character flagdepos) {
        this.codchequefirma = codchequefirma;
        this.numcheque = numcheque;
        this.quantret = quantret;
        this.flagdepos = flagdepos;
    }

    public String getCodchequefirma() {
        return codchequefirma;
    }

    public void setCodchequefirma(String codchequefirma) {
        this.codchequefirma = codchequefirma;
    }

    public String getCodcp() {
        return codcp;
    }

    public void setCodcp(String codcp) {
        this.codcp = codcp;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public String getEmitente() {
        return emitente;
    }

    public void setEmitente(String emitente) {
        this.emitente = emitente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNumcheque() {
        return numcheque;
    }

    public void setNumcheque(String numcheque) {
        this.numcheque = numcheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDepositar() {
        return depositar;
    }

    public void setDepositar(Date depositar) {
        this.depositar = depositar;
    }

    public short getQuantret() {
        return quantret;
    }

    public void setQuantret(short quantret) {
        this.quantret = quantret;
    }

    public Character getFlagforn() {
        return flagforn;
    }

    public void setFlagforn(Character flagforn) {
        this.flagforn = flagforn;
    }

    public Character getFlagdepos() {
        return flagdepos;
    }

    public void setFlagdepos(Character flagdepos) {
        this.flagdepos = flagdepos;
    }

    public Date getDeposito() {
        return deposito;
    }

    public void setDeposito(Date deposito) {
        this.deposito = deposito;
    }

    public Character getRetornou() {
        return retornou;
    }

    public void setRetornou(Character retornou) {
        this.retornou = retornou;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public String getLotechequefirma() {
        return lotechequefirma;
    }

    public void setLotechequefirma(String lotechequefirma) {
        this.lotechequefirma = lotechequefirma;
    }

    public String getLotecheques() {
        return lotecheques;
    }

    public void setLotecheques(String lotecheques) {
        this.lotecheques = lotecheques;
    }

    public String getNumeroconta() {
        return numeroconta;
    }

    public void setNumeroconta(String numeroconta) {
        this.numeroconta = numeroconta;
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

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codchequefirma != null ? codchequefirma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chequesfirma)) {
            return false;
        }
        Chequesfirma other = (Chequesfirma) object;
        if ((this.codchequefirma == null && other.codchequefirma != null) || (this.codchequefirma != null && !this.codchequefirma.equals(other.codchequefirma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Chequesfirma[ codchequefirma=" + codchequefirma + " ]";
    }
    
}
