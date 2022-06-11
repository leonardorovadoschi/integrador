/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SINTEGRA_60A", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintegra60a.findAll", query = "SELECT s FROM Sintegra60a s")
    , @NamedQuery(name = "Sintegra60a.findByCodsintegra60a", query = "SELECT s FROM Sintegra60a s WHERE s.codsintegra60a = :codsintegra60a")
    , @NamedQuery(name = "Sintegra60a.findByCodempresa", query = "SELECT s FROM Sintegra60a s WHERE s.codempresa = :codempresa")
    , @NamedQuery(name = "Sintegra60a.findByDataemissao", query = "SELECT s FROM Sintegra60a s WHERE s.dataemissao = :dataemissao")
    , @NamedQuery(name = "Sintegra60a.findByNumeroserie", query = "SELECT s FROM Sintegra60a s WHERE s.numeroserie = :numeroserie")
    , @NamedQuery(name = "Sintegra60a.findByNumerocaixa", query = "SELECT s FROM Sintegra60a s WHERE s.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Sintegra60a.findByStAliquota", query = "SELECT s FROM Sintegra60a s WHERE s.stAliquota = :stAliquota")
    , @NamedQuery(name = "Sintegra60a.findByValortotal", query = "SELECT s FROM Sintegra60a s WHERE s.valortotal = :valortotal")
    , @NamedQuery(name = "Sintegra60a.findByFlagaltpaf", query = "SELECT s FROM Sintegra60a s WHERE s.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Sintegra60a.findByCodigototalizador", query = "SELECT s FROM Sintegra60a s WHERE s.codigototalizador = :codigototalizador")
    , @NamedQuery(name = "Sintegra60a.findByNumerototalizador", query = "SELECT s FROM Sintegra60a s WHERE s.numerototalizador = :numerototalizador")
    , @NamedQuery(name = "Sintegra60a.findByAliquota", query = "SELECT s FROM Sintegra60a s WHERE s.aliquota = :aliquota")
    , @NamedQuery(name = "Sintegra60a.findByGuid", query = "SELECT s FROM Sintegra60a s WHERE s.guid = :guid")
    , @NamedQuery(name = "Sintegra60a.findByDatamovimento", query = "SELECT s FROM Sintegra60a s WHERE s.datamovimento = :datamovimento")
    , @NamedQuery(name = "Sintegra60a.findByHoraemissao", query = "SELECT s FROM Sintegra60a s WHERE s.horaemissao = :horaemissao")
    , @NamedQuery(name = "Sintegra60a.findByCooz", query = "SELECT s FROM Sintegra60a s WHERE s.cooz = :cooz")
    , @NamedQuery(name = "Sintegra60a.findByModeloecf", query = "SELECT s FROM Sintegra60a s WHERE s.modeloecf = :modeloecf")
    , @NamedQuery(name = "Sintegra60a.findByNumerousuario", query = "SELECT s FROM Sintegra60a s WHERE s.numerousuario = :numerousuario")
    , @NamedQuery(name = "Sintegra60a.findByNumerosequencial", query = "SELECT s FROM Sintegra60a s WHERE s.numerosequencial = :numerosequencial")
    , @NamedQuery(name = "Sintegra60a.findByFlagservico", query = "SELECT s FROM Sintegra60a s WHERE s.flagservico = :flagservico")})
public class Sintegra60a implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSINTEGRA_60A")
    private String codsintegra60a;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "ST_ALIQUOTA")
    private String stAliquota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "CODIGOTOTALIZADOR")
    private String codigototalizador;
    @Column(name = "NUMEROTOTALIZADOR")
    private String numerototalizador;
    @Column(name = "ALIQUOTA")
    private BigDecimal aliquota;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "DATAMOVIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datamovimento;
    @Column(name = "HORAEMISSAO")
    @Temporal(TemporalType.TIME)
    private Date horaemissao;
    @Column(name = "COOZ")
    private Integer cooz;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "NUMEROSEQUENCIAL")
    private Integer numerosequencial;
    @Column(name = "FLAGSERVICO")
    private Character flagservico;

    public Sintegra60a() {
    }

    public Sintegra60a(String codsintegra60a) {
        this.codsintegra60a = codsintegra60a;
    }

    public String getCodsintegra60a() {
        return codsintegra60a;
    }

    public void setCodsintegra60a(String codsintegra60a) {
        this.codsintegra60a = codsintegra60a;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Integer getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Integer numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public String getStAliquota() {
        return stAliquota;
    }

    public void setStAliquota(String stAliquota) {
        this.stAliquota = stAliquota;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getCodigototalizador() {
        return codigototalizador;
    }

    public void setCodigototalizador(String codigototalizador) {
        this.codigototalizador = codigototalizador;
    }

    public String getNumerototalizador() {
        return numerototalizador;
    }

    public void setNumerototalizador(String numerototalizador) {
        this.numerototalizador = numerototalizador;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getDatamovimento() {
        return datamovimento;
    }

    public void setDatamovimento(Date datamovimento) {
        this.datamovimento = datamovimento;
    }

    public Date getHoraemissao() {
        return horaemissao;
    }

    public void setHoraemissao(Date horaemissao) {
        this.horaemissao = horaemissao;
    }

    public Integer getCooz() {
        return cooz;
    }

    public void setCooz(Integer cooz) {
        this.cooz = cooz;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public Integer getNumerosequencial() {
        return numerosequencial;
    }

    public void setNumerosequencial(Integer numerosequencial) {
        this.numerosequencial = numerosequencial;
    }

    public Character getFlagservico() {
        return flagservico;
    }

    public void setFlagservico(Character flagservico) {
        this.flagservico = flagservico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsintegra60a != null ? codsintegra60a.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintegra60a)) {
            return false;
        }
        Sintegra60a other = (Sintegra60a) object;
        if ((this.codsintegra60a == null && other.codsintegra60a != null) || (this.codsintegra60a != null && !this.codsintegra60a.equals(other.codsintegra60a))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sintegra60a[ codsintegra60a=" + codsintegra60a + " ]";
    }
    
}
