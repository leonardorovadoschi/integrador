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
@Table(name = "SINTEGRA_60M", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintegra60m.findAll", query = "SELECT s FROM Sintegra60m s")
    , @NamedQuery(name = "Sintegra60m.findByCodsintegra60m", query = "SELECT s FROM Sintegra60m s WHERE s.codsintegra60m = :codsintegra60m")
    , @NamedQuery(name = "Sintegra60m.findByCodempresa", query = "SELECT s FROM Sintegra60m s WHERE s.codempresa = :codempresa")
    , @NamedQuery(name = "Sintegra60m.findByDataemissao", query = "SELECT s FROM Sintegra60m s WHERE s.dataemissao = :dataemissao")
    , @NamedQuery(name = "Sintegra60m.findByNumeroserie", query = "SELECT s FROM Sintegra60m s WHERE s.numeroserie = :numeroserie")
    , @NamedQuery(name = "Sintegra60m.findByNumerocaixa", query = "SELECT s FROM Sintegra60m s WHERE s.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Sintegra60m.findByCooinicial", query = "SELECT s FROM Sintegra60m s WHERE s.cooinicial = :cooinicial")
    , @NamedQuery(name = "Sintegra60m.findByCoofinal", query = "SELECT s FROM Sintegra60m s WHERE s.coofinal = :coofinal")
    , @NamedQuery(name = "Sintegra60m.findByCrz", query = "SELECT s FROM Sintegra60m s WHERE s.crz = :crz")
    , @NamedQuery(name = "Sintegra60m.findByCro", query = "SELECT s FROM Sintegra60m s WHERE s.cro = :cro")
    , @NamedQuery(name = "Sintegra60m.findByVendabruta", query = "SELECT s FROM Sintegra60m s WHERE s.vendabruta = :vendabruta")
    , @NamedQuery(name = "Sintegra60m.findByGtfinal", query = "SELECT s FROM Sintegra60m s WHERE s.gtfinal = :gtfinal")
    , @NamedQuery(name = "Sintegra60m.findByFlagaltpaf", query = "SELECT s FROM Sintegra60m s WHERE s.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Sintegra60m.findByGuid", query = "SELECT s FROM Sintegra60m s WHERE s.guid = :guid")
    , @NamedQuery(name = "Sintegra60m.findByDatamovimento", query = "SELECT s FROM Sintegra60m s WHERE s.datamovimento = :datamovimento")
    , @NamedQuery(name = "Sintegra60m.findByHoraemissao", query = "SELECT s FROM Sintegra60m s WHERE s.horaemissao = :horaemissao")
    , @NamedQuery(name = "Sintegra60m.findByDatainstalacaosb", query = "SELECT s FROM Sintegra60m s WHERE s.datainstalacaosb = :datainstalacaosb")
    , @NamedQuery(name = "Sintegra60m.findByVersaosb", query = "SELECT s FROM Sintegra60m s WHERE s.versaosb = :versaosb")
    , @NamedQuery(name = "Sintegra60m.findByHorainstalacaosb", query = "SELECT s FROM Sintegra60m s WHERE s.horainstalacaosb = :horainstalacaosb")
    , @NamedQuery(name = "Sintegra60m.findByCooz", query = "SELECT s FROM Sintegra60m s WHERE s.cooz = :cooz")
    , @NamedQuery(name = "Sintegra60m.findByNumerousuario", query = "SELECT s FROM Sintegra60m s WHERE s.numerousuario = :numerousuario")
    , @NamedQuery(name = "Sintegra60m.findByMarcaecf", query = "SELECT s FROM Sintegra60m s WHERE s.marcaecf = :marcaecf")
    , @NamedQuery(name = "Sintegra60m.findByModeloecf", query = "SELECT s FROM Sintegra60m s WHERE s.modeloecf = :modeloecf")})
public class Sintegra60m implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSINTEGRA_60M")
    private String codsintegra60m;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "COOINICIAL")
    private Integer cooinicial;
    @Column(name = "COOFINAL")
    private Integer coofinal;
    @Column(name = "CRZ")
    private Integer crz;
    @Column(name = "CRO")
    private Integer cro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VENDABRUTA")
    private BigDecimal vendabruta;
    @Column(name = "GTFINAL")
    private BigDecimal gtfinal;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "DATAMOVIMENTO")
    @Temporal(TemporalType.DATE)
    private Date datamovimento;
    @Column(name = "HORAEMISSAO")
    @Temporal(TemporalType.TIME)
    private Date horaemissao;
    @Column(name = "DATAINSTALACAOSB")
    @Temporal(TemporalType.DATE)
    private Date datainstalacaosb;
    @Column(name = "VERSAOSB")
    private String versaosb;
    @Column(name = "HORAINSTALACAOSB")
    @Temporal(TemporalType.TIME)
    private Date horainstalacaosb;
    @Column(name = "COOZ")
    private Integer cooz;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;

    public Sintegra60m() {
    }

    public Sintegra60m(String codsintegra60m) {
        this.codsintegra60m = codsintegra60m;
    }

    public String getCodsintegra60m() {
        return codsintegra60m;
    }

    public void setCodsintegra60m(String codsintegra60m) {
        this.codsintegra60m = codsintegra60m;
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

    public Integer getCooinicial() {
        return cooinicial;
    }

    public void setCooinicial(Integer cooinicial) {
        this.cooinicial = cooinicial;
    }

    public Integer getCoofinal() {
        return coofinal;
    }

    public void setCoofinal(Integer coofinal) {
        this.coofinal = coofinal;
    }

    public Integer getCrz() {
        return crz;
    }

    public void setCrz(Integer crz) {
        this.crz = crz;
    }

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
        this.cro = cro;
    }

    public BigDecimal getVendabruta() {
        return vendabruta;
    }

    public void setVendabruta(BigDecimal vendabruta) {
        this.vendabruta = vendabruta;
    }

    public BigDecimal getGtfinal() {
        return gtfinal;
    }

    public void setGtfinal(BigDecimal gtfinal) {
        this.gtfinal = gtfinal;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
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

    public Date getDatainstalacaosb() {
        return datainstalacaosb;
    }

    public void setDatainstalacaosb(Date datainstalacaosb) {
        this.datainstalacaosb = datainstalacaosb;
    }

    public String getVersaosb() {
        return versaosb;
    }

    public void setVersaosb(String versaosb) {
        this.versaosb = versaosb;
    }

    public Date getHorainstalacaosb() {
        return horainstalacaosb;
    }

    public void setHorainstalacaosb(Date horainstalacaosb) {
        this.horainstalacaosb = horainstalacaosb;
    }

    public Integer getCooz() {
        return cooz;
    }

    public void setCooz(Integer cooz) {
        this.cooz = cooz;
    }

    public Integer getNumerousuario() {
        return numerousuario;
    }

    public void setNumerousuario(Integer numerousuario) {
        this.numerousuario = numerousuario;
    }

    public String getMarcaecf() {
        return marcaecf;
    }

    public void setMarcaecf(String marcaecf) {
        this.marcaecf = marcaecf;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsintegra60m != null ? codsintegra60m.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintegra60m)) {
            return false;
        }
        Sintegra60m other = (Sintegra60m) object;
        if ((this.codsintegra60m == null && other.codsintegra60m != null) || (this.codsintegra60m != null && !this.codsintegra60m.equals(other.codsintegra60m))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sintegra60m[ codsintegra60m=" + codsintegra60m + " ]";
    }
    
}
