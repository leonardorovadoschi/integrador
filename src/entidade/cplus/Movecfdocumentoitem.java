/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVECFDOCUMENTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movecfdocumentoitem.findAll", query = "SELECT m FROM Movecfdocumentoitem m")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodmovecfdocumentoitem", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codmovecfdocumentoitem = :codmovecfdocumentoitem")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodmovprod", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codmovprod = :codmovprod")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodecf", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codecf = :codecf")
    , @NamedQuery(name = "Movecfdocumentoitem.findByNumeroserieecf", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Movecfdocumentoitem.findByNumerousuario", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.numerousuario = :numerousuario")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCoo", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.coo = :coo")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCcf", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.ccf = :ccf")
    , @NamedQuery(name = "Movecfdocumentoitem.findByNumeroitem", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.numeroitem = :numeroitem")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodigo", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Movecfdocumentoitem.findByNomeprod", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.nomeprod = :nomeprod")
    , @NamedQuery(name = "Movecfdocumentoitem.findByQuantidade", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Movecfdocumentoitem.findByUnidade", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.unidade = :unidade")
    , @NamedQuery(name = "Movecfdocumentoitem.findByValorunitario", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.valorunitario = :valorunitario")
    , @NamedQuery(name = "Movecfdocumentoitem.findByValordesconto", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.valordesconto = :valordesconto")
    , @NamedQuery(name = "Movecfdocumentoitem.findByValoracrescimo", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.valoracrescimo = :valoracrescimo")
    , @NamedQuery(name = "Movecfdocumentoitem.findByValortotalliquido", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.valortotalliquido = :valortotalliquido")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodigototalizadorparcial", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codigototalizadorparcial = :codigototalizadorparcial")
    , @NamedQuery(name = "Movecfdocumentoitem.findByStAliquota", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.stAliquota = :stAliquota")
    , @NamedQuery(name = "Movecfdocumentoitem.findByFlagcancelado", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.flagcancelado = :flagcancelado")
    , @NamedQuery(name = "Movecfdocumentoitem.findByQuantidadecancelada", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.quantidadecancelada = :quantidadecancelada")
    , @NamedQuery(name = "Movecfdocumentoitem.findByValorcancelado", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.valorcancelado = :valorcancelado")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCancelamentoacrescimoitem", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.cancelamentoacrescimoitem = :cancelamentoacrescimoitem")
    , @NamedQuery(name = "Movecfdocumentoitem.findByIat", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.iat = :iat")
    , @NamedQuery(name = "Movecfdocumentoitem.findByIppt", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.ippt = :ippt")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCasasdecimaisquantidade", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.casasdecimaisquantidade = :casasdecimaisquantidade")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCasasdecimaisvalorunitario", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.casasdecimaisvalorunitario = :casasdecimaisvalorunitario")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCodempresa", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.codempresa = :codempresa")
    , @NamedQuery(name = "Movecfdocumentoitem.findByGuid", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movecfdocumentoitem.findByModeloecf", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.modeloecf = :modeloecf")
    , @NamedQuery(name = "Movecfdocumentoitem.findByFlagitemcancelado", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.flagitemcancelado = :flagitemcancelado")
    , @NamedQuery(name = "Movecfdocumentoitem.findByGtin", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.gtin = :gtin")
    , @NamedQuery(name = "Movecfdocumentoitem.findByCest", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.cest = :cest")
    , @NamedQuery(name = "Movecfdocumentoitem.findByNcm", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.ncm = :ncm")
    , @NamedQuery(name = "Movecfdocumentoitem.findByFlagaltpaf", query = "SELECT m FROM Movecfdocumentoitem m WHERE m.flagaltpaf = :flagaltpaf")})
public class Movecfdocumentoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVECFDOCUMENTOITEM")
    private String codmovecfdocumentoitem;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "NUMEROUSUARIO")
    private Integer numerousuario;
    @Column(name = "COO")
    private Integer coo;
    @Column(name = "CCF")
    private Integer ccf;
    @Column(name = "NUMEROITEM")
    private Integer numeroitem;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPROD")
    private String nomeprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "VALORTOTALLIQUIDO")
    private BigDecimal valortotalliquido;
    @Column(name = "CODIGOTOTALIZADORPARCIAL")
    private String codigototalizadorparcial;
    @Column(name = "ST_ALIQUOTA")
    private String stAliquota;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "QUANTIDADECANCELADA")
    private BigDecimal quantidadecancelada;
    @Column(name = "VALORCANCELADO")
    private BigDecimal valorcancelado;
    @Column(name = "CANCELAMENTOACRESCIMOITEM")
    private BigDecimal cancelamentoacrescimoitem;
    @Column(name = "IAT")
    private Character iat;
    @Column(name = "IPPT")
    private Character ippt;
    @Column(name = "CASASDECIMAISQUANTIDADE")
    private Integer casasdecimaisquantidade;
    @Column(name = "CASASDECIMAISVALORUNITARIO")
    private Integer casasdecimaisvalorunitario;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "FLAGITEMCANCELADO")
    private Character flagitemcancelado;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "CEST")
    private String cest;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @JoinColumn(name = "CODMOVECFDOCUMENTO", referencedColumnName = "CODMOVECFDOCUMENTO")
    @ManyToOne
    private Movecfdocumento codmovecfdocumento;

    public Movecfdocumentoitem() {
    }

    public Movecfdocumentoitem(String codmovecfdocumentoitem) {
        this.codmovecfdocumentoitem = codmovecfdocumentoitem;
    }

    public String getCodmovecfdocumentoitem() {
        return codmovecfdocumentoitem;
    }

    public void setCodmovecfdocumentoitem(String codmovecfdocumentoitem) {
        this.codmovecfdocumentoitem = codmovecfdocumentoitem;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
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

    public Integer getCcf() {
        return ccf;
    }

    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    public Integer getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(Integer numeroitem) {
        this.numeroitem = numeroitem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
    }

    public BigDecimal getValoracrescimo() {
        return valoracrescimo;
    }

    public void setValoracrescimo(BigDecimal valoracrescimo) {
        this.valoracrescimo = valoracrescimo;
    }

    public BigDecimal getValortotalliquido() {
        return valortotalliquido;
    }

    public void setValortotalliquido(BigDecimal valortotalliquido) {
        this.valortotalliquido = valortotalliquido;
    }

    public String getCodigototalizadorparcial() {
        return codigototalizadorparcial;
    }

    public void setCodigototalizadorparcial(String codigototalizadorparcial) {
        this.codigototalizadorparcial = codigototalizadorparcial;
    }

    public String getStAliquota() {
        return stAliquota;
    }

    public void setStAliquota(String stAliquota) {
        this.stAliquota = stAliquota;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public BigDecimal getQuantidadecancelada() {
        return quantidadecancelada;
    }

    public void setQuantidadecancelada(BigDecimal quantidadecancelada) {
        this.quantidadecancelada = quantidadecancelada;
    }

    public BigDecimal getValorcancelado() {
        return valorcancelado;
    }

    public void setValorcancelado(BigDecimal valorcancelado) {
        this.valorcancelado = valorcancelado;
    }

    public BigDecimal getCancelamentoacrescimoitem() {
        return cancelamentoacrescimoitem;
    }

    public void setCancelamentoacrescimoitem(BigDecimal cancelamentoacrescimoitem) {
        this.cancelamentoacrescimoitem = cancelamentoacrescimoitem;
    }

    public Character getIat() {
        return iat;
    }

    public void setIat(Character iat) {
        this.iat = iat;
    }

    public Character getIppt() {
        return ippt;
    }

    public void setIppt(Character ippt) {
        this.ippt = ippt;
    }

    public Integer getCasasdecimaisquantidade() {
        return casasdecimaisquantidade;
    }

    public void setCasasdecimaisquantidade(Integer casasdecimaisquantidade) {
        this.casasdecimaisquantidade = casasdecimaisquantidade;
    }

    public Integer getCasasdecimaisvalorunitario() {
        return casasdecimaisvalorunitario;
    }

    public void setCasasdecimaisvalorunitario(Integer casasdecimaisvalorunitario) {
        this.casasdecimaisvalorunitario = casasdecimaisvalorunitario;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public Character getFlagitemcancelado() {
        return flagitemcancelado;
    }

    public void setFlagitemcancelado(Character flagitemcancelado) {
        this.flagitemcancelado = flagitemcancelado;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public Movecfdocumento getCodmovecfdocumento() {
        return codmovecfdocumento;
    }

    public void setCodmovecfdocumento(Movecfdocumento codmovecfdocumento) {
        this.codmovecfdocumento = codmovecfdocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovecfdocumentoitem != null ? codmovecfdocumentoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movecfdocumentoitem)) {
            return false;
        }
        Movecfdocumentoitem other = (Movecfdocumentoitem) object;
        if ((this.codmovecfdocumentoitem == null && other.codmovecfdocumentoitem != null) || (this.codmovecfdocumentoitem != null && !this.codmovecfdocumentoitem.equals(other.codmovecfdocumentoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movecfdocumentoitem[ codmovecfdocumentoitem=" + codmovecfdocumentoitem + " ]";
    }
    
}
