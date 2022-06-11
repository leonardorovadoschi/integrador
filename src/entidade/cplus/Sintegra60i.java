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
@Table(name = "SINTEGRA_60I", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sintegra60i.findAll", query = "SELECT s FROM Sintegra60i s")
    , @NamedQuery(name = "Sintegra60i.findByCodsintegra60i", query = "SELECT s FROM Sintegra60i s WHERE s.codsintegra60i = :codsintegra60i")
    , @NamedQuery(name = "Sintegra60i.findByCodempresa", query = "SELECT s FROM Sintegra60i s WHERE s.codempresa = :codempresa")
    , @NamedQuery(name = "Sintegra60i.findByDataemissao", query = "SELECT s FROM Sintegra60i s WHERE s.dataemissao = :dataemissao")
    , @NamedQuery(name = "Sintegra60i.findByNumeroserie", query = "SELECT s FROM Sintegra60i s WHERE s.numeroserie = :numeroserie")
    , @NamedQuery(name = "Sintegra60i.findByNumerocaixa", query = "SELECT s FROM Sintegra60i s WHERE s.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "Sintegra60i.findByCoo", query = "SELECT s FROM Sintegra60i s WHERE s.coo = :coo")
    , @NamedQuery(name = "Sintegra60i.findByNumeroitem", query = "SELECT s FROM Sintegra60i s WHERE s.numeroitem = :numeroitem")
    , @NamedQuery(name = "Sintegra60i.findByCodprod", query = "SELECT s FROM Sintegra60i s WHERE s.codprod = :codprod")
    , @NamedQuery(name = "Sintegra60i.findByCodigoproduto", query = "SELECT s FROM Sintegra60i s WHERE s.codigoproduto = :codigoproduto")
    , @NamedQuery(name = "Sintegra60i.findByNomeprod", query = "SELECT s FROM Sintegra60i s WHERE s.nomeprod = :nomeprod")
    , @NamedQuery(name = "Sintegra60i.findByQuantidade", query = "SELECT s FROM Sintegra60i s WHERE s.quantidade = :quantidade")
    , @NamedQuery(name = "Sintegra60i.findByFlagcancelado", query = "SELECT s FROM Sintegra60i s WHERE s.flagcancelado = :flagcancelado")
    , @NamedQuery(name = "Sintegra60i.findByValorliquido", query = "SELECT s FROM Sintegra60i s WHERE s.valorliquido = :valorliquido")
    , @NamedQuery(name = "Sintegra60i.findByBaseicms", query = "SELECT s FROM Sintegra60i s WHERE s.baseicms = :baseicms")
    , @NamedQuery(name = "Sintegra60i.findByStAliquota", query = "SELECT s FROM Sintegra60i s WHERE s.stAliquota = :stAliquota")
    , @NamedQuery(name = "Sintegra60i.findByValoricms", query = "SELECT s FROM Sintegra60i s WHERE s.valoricms = :valoricms")
    , @NamedQuery(name = "Sintegra60i.findByValorbruto", query = "SELECT s FROM Sintegra60i s WHERE s.valorbruto = :valorbruto")
    , @NamedQuery(name = "Sintegra60i.findByValordescontoitem", query = "SELECT s FROM Sintegra60i s WHERE s.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "Sintegra60i.findByAliqdescontoitem", query = "SELECT s FROM Sintegra60i s WHERE s.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "Sintegra60i.findByFlagtipodescontoitem", query = "SELECT s FROM Sintegra60i s WHERE s.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "Sintegra60i.findByValoracrescimoitem", query = "SELECT s FROM Sintegra60i s WHERE s.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "Sintegra60i.findByAliqacrescimoitem", query = "SELECT s FROM Sintegra60i s WHERE s.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "Sintegra60i.findByAliqacrescimo", query = "SELECT s FROM Sintegra60i s WHERE s.aliqacrescimo = :aliqacrescimo")
    , @NamedQuery(name = "Sintegra60i.findByFlagtipoacrescimoitem", query = "SELECT s FROM Sintegra60i s WHERE s.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "Sintegra60i.findByFlagtipodesconto", query = "SELECT s FROM Sintegra60i s WHERE s.flagtipodesconto = :flagtipodesconto")
    , @NamedQuery(name = "Sintegra60i.findByValordesconto", query = "SELECT s FROM Sintegra60i s WHERE s.valordesconto = :valordesconto")
    , @NamedQuery(name = "Sintegra60i.findByAliqdesconto", query = "SELECT s FROM Sintegra60i s WHERE s.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "Sintegra60i.findByCodmovenda", query = "SELECT s FROM Sintegra60i s WHERE s.codmovenda = :codmovenda")
    , @NamedQuery(name = "Sintegra60i.findByCodmovprod", query = "SELECT s FROM Sintegra60i s WHERE s.codmovprod = :codmovprod")
    , @NamedQuery(name = "Sintegra60i.findByFlagaltpaf", query = "SELECT s FROM Sintegra60i s WHERE s.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Sintegra60i.findByValordescontorateado", query = "SELECT s FROM Sintegra60i s WHERE s.valordescontorateado = :valordescontorateado")
    , @NamedQuery(name = "Sintegra60i.findByValoracrescimorateado", query = "SELECT s FROM Sintegra60i s WHERE s.valoracrescimorateado = :valoracrescimorateado")
    , @NamedQuery(name = "Sintegra60i.findByCcf", query = "SELECT s FROM Sintegra60i s WHERE s.ccf = :ccf")
    , @NamedQuery(name = "Sintegra60i.findByUnidade", query = "SELECT s FROM Sintegra60i s WHERE s.unidade = :unidade")
    , @NamedQuery(name = "Sintegra60i.findByNumerousuario", query = "SELECT s FROM Sintegra60i s WHERE s.numerousuario = :numerousuario")
    , @NamedQuery(name = "Sintegra60i.findByMarcaecf", query = "SELECT s FROM Sintegra60i s WHERE s.marcaecf = :marcaecf")
    , @NamedQuery(name = "Sintegra60i.findByModeloecf", query = "SELECT s FROM Sintegra60i s WHERE s.modeloecf = :modeloecf")
    , @NamedQuery(name = "Sintegra60i.findByTipoecf", query = "SELECT s FROM Sintegra60i s WHERE s.tipoecf = :tipoecf")
    , @NamedQuery(name = "Sintegra60i.findByCst", query = "SELECT s FROM Sintegra60i s WHERE s.cst = :cst")
    , @NamedQuery(name = "Sintegra60i.findByCodcfop", query = "SELECT s FROM Sintegra60i s WHERE s.codcfop = :codcfop")
    , @NamedQuery(name = "Sintegra60i.findByAliqicms", query = "SELECT s FROM Sintegra60i s WHERE s.aliqicms = :aliqicms")
    , @NamedQuery(name = "Sintegra60i.findByValorcofins", query = "SELECT s FROM Sintegra60i s WHERE s.valorcofins = :valorcofins")
    , @NamedQuery(name = "Sintegra60i.findByValorpis", query = "SELECT s FROM Sintegra60i s WHERE s.valorpis = :valorpis")})
public class Sintegra60i implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSINTEGRA_60I")
    private String codsintegra60i;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "NUMEROITEM")
    private Integer numeroitem;
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "NOMEPROD")
    private String nomeprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "VALORLIQUIDO")
    private BigDecimal valorliquido;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "ST_ALIQUOTA")
    private String stAliquota;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "VALORBRUTO")
    private BigDecimal valorbruto;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Column(name = "ALIQDESCONTOITEM")
    private BigDecimal aliqdescontoitem;
    @Column(name = "FLAGTIPODESCONTOITEM")
    private Character flagtipodescontoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "ALIQACRESCIMOITEM")
    private BigDecimal aliqacrescimoitem;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "FLAGTIPOACRESCIMOITEM")
    private Character flagtipoacrescimoitem;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "VALORDESCONTORATEADO")
    private BigDecimal valordescontorateado;
    @Column(name = "VALORACRESCIMORATEADO")
    private BigDecimal valoracrescimorateado;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "CST")
    private String cst;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "VALORCOFINS")
    private BigDecimal valorcofins;
    @Column(name = "VALORPIS")
    private BigDecimal valorpis;

    public Sintegra60i() {
    }

    public Sintegra60i(String codsintegra60i) {
        this.codsintegra60i = codsintegra60i;
    }

    public String getCodsintegra60i() {
        return codsintegra60i;
    }

    public void setCodsintegra60i(String codsintegra60i) {
        this.codsintegra60i = codsintegra60i;
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

    public Integer getCoo() {
        return coo;
    }

    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    public Integer getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(Integer numeroitem) {
        this.numeroitem = numeroitem;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public BigDecimal getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(BigDecimal valorliquido) {
        this.valorliquido = valorliquido;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public String getStAliquota() {
        return stAliquota;
    }

    public void setStAliquota(String stAliquota) {
        this.stAliquota = stAliquota;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public BigDecimal getValorbruto() {
        return valorbruto;
    }

    public void setValorbruto(BigDecimal valorbruto) {
        this.valorbruto = valorbruto;
    }

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        this.valordescontoitem = valordescontoitem;
    }

    public BigDecimal getAliqdescontoitem() {
        return aliqdescontoitem;
    }

    public void setAliqdescontoitem(BigDecimal aliqdescontoitem) {
        this.aliqdescontoitem = aliqdescontoitem;
    }

    public Character getFlagtipodescontoitem() {
        return flagtipodescontoitem;
    }

    public void setFlagtipodescontoitem(Character flagtipodescontoitem) {
        this.flagtipodescontoitem = flagtipodescontoitem;
    }

    public BigDecimal getValoracrescimoitem() {
        return valoracrescimoitem;
    }

    public void setValoracrescimoitem(BigDecimal valoracrescimoitem) {
        this.valoracrescimoitem = valoracrescimoitem;
    }

    public BigDecimal getAliqacrescimoitem() {
        return aliqacrescimoitem;
    }

    public void setAliqacrescimoitem(BigDecimal aliqacrescimoitem) {
        this.aliqacrescimoitem = aliqacrescimoitem;
    }

    public BigDecimal getAliqacrescimo() {
        return aliqacrescimo;
    }

    public void setAliqacrescimo(BigDecimal aliqacrescimo) {
        this.aliqacrescimo = aliqacrescimo;
    }

    public Character getFlagtipoacrescimoitem() {
        return flagtipoacrescimoitem;
    }

    public void setFlagtipoacrescimoitem(Character flagtipoacrescimoitem) {
        this.flagtipoacrescimoitem = flagtipoacrescimoitem;
    }

    public Character getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(Character flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public BigDecimal getValordescontorateado() {
        return valordescontorateado;
    }

    public void setValordescontorateado(BigDecimal valordescontorateado) {
        this.valordescontorateado = valordescontorateado;
    }

    public BigDecimal getValoracrescimorateado() {
        return valoracrescimorateado;
    }

    public void setValoracrescimorateado(BigDecimal valoracrescimorateado) {
        this.valoracrescimorateado = valoracrescimorateado;
    }

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
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

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(BigDecimal valorcofins) {
        this.valorcofins = valorcofins;
    }

    public BigDecimal getValorpis() {
        return valorpis;
    }

    public void setValorpis(BigDecimal valorpis) {
        this.valorpis = valorpis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsintegra60i != null ? codsintegra60i.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sintegra60i)) {
            return false;
        }
        Sintegra60i other = (Sintegra60i) object;
        if ((this.codsintegra60i == null && other.codsintegra60i != null) || (this.codsintegra60i != null && !this.codsintegra60i.equals(other.codsintegra60i))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sintegra60i[ codsintegra60i=" + codsintegra60i + " ]";
    }
    
}
