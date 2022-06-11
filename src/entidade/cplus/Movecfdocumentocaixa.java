/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVECFDOCUMENTOCAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfdocumentocaixa.findAll", query = "SELECT m FROM Movecfdocumentocaixa m")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCodmovecfdocumentocaixa", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.codmovecfdocumentocaixa = :codmovecfdocumentocaixa")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByNumeroserie", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.numeroserie = :numeroserie")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByNumerousuario", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.numerousuario = :numerousuario")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCoo", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.coo = :coo")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCnf", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.cnf = :cnf")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByGrg", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.grg = :grg")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCdc", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.cdc = :cdc")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCrz", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.crz = :crz")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByDenominacao", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.denominacao = :denominacao")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByDataemissao", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.dataemissao = :dataemissao")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByHoraemissao", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.horaemissao = :horaemissao")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByGuid", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCodmovecfdocumentocaixacanc", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.codmovecfdocumentocaixacanc = :codmovecfdocumentocaixacanc")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCoocanc", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.coocanc = :coocanc")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByGuidorigem", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.guidorigem = :guidorigem")
    , @NamedQuery(name = "Movecfdocumentocaixa.findByCodusercancelamento", query = "SELECT m FROM Movecfdocumentocaixa m WHERE m.codusercancelamento = :codusercancelamento")})
public class Movecfdocumentocaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFDOCUMENTOCAIXA")
    private String codmovecfdocumentocaixa;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "CNF")
    private Integer cnf;
    @Column(name = "GRG")
    private Integer grg;
    @Column(name = "CDC")
    private Integer cdc;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "DENOMINACAO")
    private String denominacao;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "HORAEMISSAO")
    @Temporal(TemporalType.TIME)
    private Date horaemissao;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CODMOVECFDOCUMENTOCAIXACANC")
    private String codmovecfdocumentocaixacanc;
    @Column(name = "COOCANC")
    private Integer coocanc;
    @Column(name = "GUIDORIGEM")
    private String guidorigem;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @JoinColumn(name = "CODECF", referencedColumnName = "CODECF")
    @ManyToOne
    private Ecf codecf;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;

    public Movecfdocumentocaixa() {
    }

    public Movecfdocumentocaixa(String codmovecfdocumentocaixa) {
        this.codmovecfdocumentocaixa = codmovecfdocumentocaixa;
    }

    public String getCodmovecfdocumentocaixa() {
        return codmovecfdocumentocaixa;
    }

    public void setCodmovecfdocumentocaixa(String codmovecfdocumentocaixa) {
        this.codmovecfdocumentocaixa = codmovecfdocumentocaixa;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getCnf() {
        return cnf;
    }

    public void setCnf(Integer cnf) {
        this.cnf = cnf;
    }

    public Integer getGrg() {
        return grg;
    }

    public void setGrg(Integer grg) {
        this.grg = grg;
    }

    public Integer getCdc() {
        return cdc;
    }

    public void setCdc(Integer cdc) {
        this.cdc = cdc;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getHoraemissao() {
        return horaemissao;
    }

    public void setHoraemissao(Date horaemissao) {
        this.horaemissao = horaemissao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCodmovecfdocumentocaixacanc() {
        return codmovecfdocumentocaixacanc;
    }

    public void setCodmovecfdocumentocaixacanc(String codmovecfdocumentocaixacanc) {
        this.codmovecfdocumentocaixacanc = codmovecfdocumentocaixacanc;
    }

    public Integer getCoocanc() {
        return coocanc;
    }

    public void setCoocanc(Integer coocanc) {
        this.coocanc = coocanc;
    }

    public String getGuidorigem() {
        return guidorigem;
    }

    public void setGuidorigem(String guidorigem) {
        this.guidorigem = guidorigem;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public Ecf getCodecf() {
        return codecf;
    }

    public void setCodecf(Ecf codecf) {
        this.codecf = codecf;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfdocumentocaixa != null ? codmovecfdocumentocaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfdocumentocaixa)) {
            return false;
        }
        Movecfdocumentocaixa other = (Movecfdocumentocaixa) object;
        if ((this.codmovecfdocumentocaixa == null && other.codmovecfdocumentocaixa != null) || (this.codmovecfdocumentocaixa != null && !this.codmovecfdocumentocaixa.equals(other.codmovecfdocumentocaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfdocumentocaixa[ codmovecfdocumentocaixa=" + codmovecfdocumentocaixa + " ]";
    }
    
}
