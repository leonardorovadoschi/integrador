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
import javax.persistence.Lob;
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
@Table(name = "DOCUMENTOCAIXA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentocaixa.findAll", query = "SELECT d FROM Documentocaixa d")
    , @NamedQuery(name = "Documentocaixa.findByCoddocumentocaixa", query = "SELECT d FROM Documentocaixa d WHERE d.coddocumentocaixa = :coddocumentocaixa")
    , @NamedQuery(name = "Documentocaixa.findByCoddocumentocaixaabertura", query = "SELECT d FROM Documentocaixa d WHERE d.coddocumentocaixaabertura = :coddocumentocaixaabertura")
    , @NamedQuery(name = "Documentocaixa.findByNumerodocumentocaixa", query = "SELECT d FROM Documentocaixa d WHERE d.numerodocumentocaixa = :numerodocumentocaixa")
    , @NamedQuery(name = "Documentocaixa.findByData", query = "SELECT d FROM Documentocaixa d WHERE d.data = :data")
    , @NamedQuery(name = "Documentocaixa.findByHora", query = "SELECT d FROM Documentocaixa d WHERE d.hora = :hora")
    , @NamedQuery(name = "Documentocaixa.findByCoduser", query = "SELECT d FROM Documentocaixa d WHERE d.coduser = :coduser")
    , @NamedQuery(name = "Documentocaixa.findByCodsistema", query = "SELECT d FROM Documentocaixa d WHERE d.codsistema = :codsistema")
    , @NamedQuery(name = "Documentocaixa.findByCodterminal", query = "SELECT d FROM Documentocaixa d WHERE d.codterminal = :codterminal")
    , @NamedQuery(name = "Documentocaixa.findByNomeentidadeorigem", query = "SELECT d FROM Documentocaixa d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documentocaixa.findByIdentidadeorigem", query = "SELECT d FROM Documentocaixa d WHERE d.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Documentocaixa.findByFlagcancelado", query = "SELECT d FROM Documentocaixa d WHERE d.flagcancelado = :flagcancelado")
    , @NamedQuery(name = "Documentocaixa.findByCodempresa", query = "SELECT d FROM Documentocaixa d WHERE d.codempresa = :codempresa")
    , @NamedQuery(name = "Documentocaixa.findByTipo", query = "SELECT d FROM Documentocaixa d WHERE d.tipo = :tipo")
    , @NamedQuery(name = "Documentocaixa.findByCodusercancelamento", query = "SELECT d FROM Documentocaixa d WHERE d.codusercancelamento = :codusercancelamento")
    , @NamedQuery(name = "Documentocaixa.findByCodecf", query = "SELECT d FROM Documentocaixa d WHERE d.codecf = :codecf")
    , @NamedQuery(name = "Documentocaixa.findByNumeroserieecf", query = "SELECT d FROM Documentocaixa d WHERE d.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Documentocaixa.findByTipodocumento", query = "SELECT d FROM Documentocaixa d WHERE d.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Documentocaixa.findByGuid", query = "SELECT d FROM Documentocaixa d WHERE d.guid = :guid")
    , @NamedQuery(name = "Documentocaixa.findByNumerodocumentocaixacanc", query = "SELECT d FROM Documentocaixa d WHERE d.numerodocumentocaixacanc = :numerodocumentocaixacanc")
    , @NamedQuery(name = "Documentocaixa.findByCoddocumentocaixacanc", query = "SELECT d FROM Documentocaixa d WHERE d.coddocumentocaixacanc = :coddocumentocaixacanc")
    , @NamedQuery(name = "Documentocaixa.findByNumeroccf", query = "SELECT d FROM Documentocaixa d WHERE d.numeroccf = :numeroccf")
    , @NamedQuery(name = "Documentocaixa.findByModeloecf", query = "SELECT d FROM Documentocaixa d WHERE d.modeloecf = :modeloecf")
    , @NamedQuery(name = "Documentocaixa.findByNumerognf", query = "SELECT d FROM Documentocaixa d WHERE d.numerognf = :numerognf")
    , @NamedQuery(name = "Documentocaixa.findByNumerogrg", query = "SELECT d FROM Documentocaixa d WHERE d.numerogrg = :numerogrg")
    , @NamedQuery(name = "Documentocaixa.findByNumerocdc", query = "SELECT d FROM Documentocaixa d WHERE d.numerocdc = :numerocdc")
    , @NamedQuery(name = "Documentocaixa.findByNumerousuario", query = "SELECT d FROM Documentocaixa d WHERE d.numerousuario = :numerousuario")
    , @NamedQuery(name = "Documentocaixa.findByGuidcancelamento", query = "SELECT d FROM Documentocaixa d WHERE d.guidcancelamento = :guidcancelamento")
    , @NamedQuery(name = "Documentocaixa.findByGuidabertura", query = "SELECT d FROM Documentocaixa d WHERE d.guidabertura = :guidabertura")
    , @NamedQuery(name = "Documentocaixa.findByTipoecf", query = "SELECT d FROM Documentocaixa d WHERE d.tipoecf = :tipoecf")
    , @NamedQuery(name = "Documentocaixa.findByMarcaecf", query = "SELECT d FROM Documentocaixa d WHERE d.marcaecf = :marcaecf")
    , @NamedQuery(name = "Documentocaixa.findByFlagaltpaf", query = "SELECT d FROM Documentocaixa d WHERE d.flagaltpaf = :flagaltpaf")})
public class Documentocaixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOCAIXA")
    private String coddocumentocaixa;
    @Column(name = "CODDOCUMENTOCAIXAABERTURA")
    private String coddocumentocaixaabertura;
    @Column(name = "NUMERODOCUMENTOCAIXA")
    private Integer numerodocumentocaixa;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODSISTEMA")
    private String codsistema;
    @Column(name = "CODTERMINAL")
    private String codterminal;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "TIPO")
    private Integer tipo;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "TIPODOCUMENTO")
    private String tipodocumento;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "NUMERODOCUMENTOCAIXACANC")
    private Integer numerodocumentocaixacanc;
    @Column(name = "CODDOCUMENTOCAIXACANC")
    private String coddocumentocaixacanc;
    @Column(name = "NUMEROCCF")
    private Integer numeroccf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "NUMEROGNF")
    private Integer numerognf;
    @Column(name = "NUMEROGRG")
    private Integer numerogrg;
    @Column(name = "NUMEROCDC")
    private Integer numerocdc;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "GUIDCANCELAMENTO")
    private String guidcancelamento;
    @Column(name = "GUIDABERTURA")
    private String guidabertura;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(mappedBy = "coddocumentocaixa")
    private Collection<Contareceberrec> contareceberrecCollection;
    @OneToMany(mappedBy = "coddocumentocaixa")
    private Collection<Vale> valeCollection;
    @OneToMany(mappedBy = "coddocumentocaixabaixa")
    private Collection<Vale> valeCollection1;
    @OneToMany(mappedBy = "coddocumentocaixa")
    private Collection<Movimentocaixa> movimentocaixaCollection;

    public Documentocaixa() {
    }

    public Documentocaixa(String coddocumentocaixa) {
        this.coddocumentocaixa = coddocumentocaixa;
    }

    public String getCoddocumentocaixa() {
        return coddocumentocaixa;
    }

    public void setCoddocumentocaixa(String coddocumentocaixa) {
        this.coddocumentocaixa = coddocumentocaixa;
    }

    public String getCoddocumentocaixaabertura() {
        return coddocumentocaixaabertura;
    }

    public void setCoddocumentocaixaabertura(String coddocumentocaixaabertura) {
        this.coddocumentocaixaabertura = coddocumentocaixaabertura;
    }

    public Integer getNumerodocumentocaixa() {
        return numerodocumentocaixa;
    }

    public void setNumerodocumentocaixa(Integer numerodocumentocaixa) {
        this.numerodocumentocaixa = numerodocumentocaixa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodsistema() {
        return codsistema;
    }

    public void setCodsistema(String codsistema) {
        this.codsistema = codsistema;
    }

    public String getCodterminal() {
        return codterminal;
    }

    public void setCodterminal(String codterminal) {
        this.codterminal = codterminal;
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

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getNumerodocumentocaixacanc() {
        return numerodocumentocaixacanc;
    }

    public void setNumerodocumentocaixacanc(Integer numerodocumentocaixacanc) {
        this.numerodocumentocaixacanc = numerodocumentocaixacanc;
    }

    public String getCoddocumentocaixacanc() {
        return coddocumentocaixacanc;
    }

    public void setCoddocumentocaixacanc(String coddocumentocaixacanc) {
        this.coddocumentocaixacanc = coddocumentocaixacanc;
    }

    public Integer getNumeroccf() {
        return numeroccf;
    }

    public void setNumeroccf(Integer numeroccf) {
        this.numeroccf = numeroccf;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public Integer getNumerognf() {
        return numerognf;
    }

    public void setNumerognf(Integer numerognf) {
        this.numerognf = numerognf;
    }

    public Integer getNumerogrg() {
        return numerogrg;
    }

    public void setNumerogrg(Integer numerogrg) {
        this.numerogrg = numerogrg;
    }

    public Integer getNumerocdc() {
        return numerocdc;
    }

    public void setNumerocdc(Integer numerocdc) {
        this.numerocdc = numerocdc;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public String getGuidcancelamento() {
        return guidcancelamento;
    }

    public void setGuidcancelamento(String guidcancelamento) {
        this.guidcancelamento = guidcancelamento;
    }

    public String getGuidabertura() {
        return guidabertura;
    }

    public void setGuidabertura(String guidabertura) {
        this.guidabertura = guidabertura;
    }

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
    }

    public String getMarcaecf() {
        return marcaecf;
    }

    public void setMarcaecf(String marcaecf) {
        this.marcaecf = marcaecf;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    @XmlTransient
    public Collection<Contareceberrec> getContareceberrecCollection() {
        return contareceberrecCollection;
    }

    public void setContareceberrecCollection(Collection<Contareceberrec> contareceberrecCollection) {
        this.contareceberrecCollection = contareceberrecCollection;
    }

    @XmlTransient
    public Collection<Vale> getValeCollection() {
        return valeCollection;
    }

    public void setValeCollection(Collection<Vale> valeCollection) {
        this.valeCollection = valeCollection;
    }

    @XmlTransient
    public Collection<Vale> getValeCollection1() {
        return valeCollection1;
    }

    public void setValeCollection1(Collection<Vale> valeCollection1) {
        this.valeCollection1 = valeCollection1;
    }

    @XmlTransient
    public Collection<Movimentocaixa> getMovimentocaixaCollection() {
        return movimentocaixaCollection;
    }

    public void setMovimentocaixaCollection(Collection<Movimentocaixa> movimentocaixaCollection) {
        this.movimentocaixaCollection = movimentocaixaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentocaixa != null ? coddocumentocaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentocaixa)) {
            return false;
        }
        Documentocaixa other = (Documentocaixa) object;
        if ((this.coddocumentocaixa == null && other.coddocumentocaixa != null) || (this.coddocumentocaixa != null && !this.coddocumentocaixa.equals(other.coddocumentocaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentocaixa[ coddocumentocaixa=" + coddocumentocaixa + " ]";
    }
    
}
