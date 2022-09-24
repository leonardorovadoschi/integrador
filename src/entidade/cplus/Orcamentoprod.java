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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ORCAMENTOPROD", catalog = "", schema = "")

public class Orcamentoprod implements Serializable {
    @Column(name = "ALIQDIFERIMENTO")
    private BigDecimal aliqdiferimento;
    @Column(name = "VALORICMSDIFERIMENTO")
    private BigDecimal valoricmsdiferimento;
    @Column(name = "VALORFCPDIFERIMENTO")
    private BigDecimal valorfcpdiferimento;
    @Column(name = "VALORFCPEFETIVO")
    private BigDecimal valorfcpefetivo;
    @Column(name = "ALIQFCPDIFERIMENTO")
    private BigDecimal aliqfcpdiferimento;
    @Column(name = "VALORICMSSTDESONERADO")
    private BigDecimal valoricmsstdesonerado;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORCPROD")
    private String codorcprod;
    @Column(name = "CODCOR")
    private String codcor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "FLAGTIPODESCONTOITEM")
    private Character flagtipodescontoitem;
    @Column(name = "ALIQDESCONTOITEM")
    private BigDecimal aliqdescontoitem;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Column(name = "FLAGTIPOACRESCIMOITEM")
    private Character flagtipoacrescimoitem;
    @Column(name = "ALIQACRESCIMOITEM")
    private BigDecimal aliqacrescimoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Basic(optional = false)
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASEIPI")
    private BigDecimal baseipi;
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "VALORIPI")
    private BigDecimal valoripi;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORFRETERATEADO")
    private BigDecimal valorfreterateado;
    @Column(name = "VALORSEGURORATEADO")
    private BigDecimal valorsegurorateado;
    @Column(name = "VALOROUTRASDESPRATEADO")
    private BigDecimal valoroutrasdesprateado;
    @Column(name = "VALORACRESCIMORATEADO")
    private BigDecimal valoracrescimorateado;
    @Column(name = "VALORDESCONTORATEADO")
    private BigDecimal valordescontorateado;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "PRECOTABELA")
    private BigDecimal precotabela;
    @Column(name = "FLAG1")
    private Character flag1;
    @Column(name = "FLAG2")
    private Character flag2;
    @Column(name = "FLAG3")
    private Character flag3;
    @Column(name = "QUANTIDADETOTALFATURADA")
    private BigDecimal quantidadetotalfaturada;
    @Column(name = "DATAINCLUSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "ALIQCOMISSAO")
    private BigDecimal aliqcomissao;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBUTARIA")
    private BigDecimal aliqreducaobasesubsttributaria;
    @Column(name = "CODSITUACAOTRIBUTARIAIPI")
    private String codsituacaotributariaipi;
    @Column(name = "VALORPISFRETERATEADO")
    private BigDecimal valorpisfreterateado;
    @Column(name = "VALORCOFINSFRETERATEADO")
    private BigDecimal valorcofinsfreterateado;
    @Column(name = "BASEIRRF")
    private BigDecimal baseirrf;
    @Column(name = "ALIQIRRF")
    private BigDecimal aliqirrf;
    @Column(name = "VALORIRRF")
    private BigDecimal valorirrf;
    @Column(name = "BASECSLL")
    private BigDecimal basecsll;
    @Column(name = "ALIQCSLL")
    private BigDecimal aliqcsll;
    @Column(name = "VALORCSLL")
    private BigDecimal valorcsll;
    @Column(name = "BASEII")
    private BigDecimal baseii;
    @Column(name = "ALIQII")
    private BigDecimal aliqii;
    @Column(name = "VALORII")
    private BigDecimal valorii;
    @Column(name = "BASECOFINS")
    private BigDecimal basecofins;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "VALORCOFINS")
    private BigDecimal valorcofins;
    @Column(name = "BASEPIS")
    private BigDecimal basepis;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "VALORPIS")
    private BigDecimal valorpis;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "QUANTIDADEMARCADA")
    private BigDecimal quantidademarcada;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "ALIQCREDITOSIMPLESNACIONAL")
    private BigDecimal aliqcreditosimplesnacional;
    @Column(name = "VALORCREDITOSIMPLESNACIONAL")
    private BigDecimal valorcreditosimplesnacional;
    @Column(name = "ALIQICMS_ST_UF_DESTINO")
    private BigDecimal aliqicmsStUfDestino;
    @Column(name = "FLAGITEMCANCELADO")
    private Character flagitemcancelado;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "QUANTIDADEIPI")
    private BigDecimal quantidadeipi;
    @Column(name = "VALORUNIDADEIPI")
    private BigDecimal valorunidadeipi;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "GUIDORCAMENTO")
    private String guidorcamento;
    @Column(name = "NUMEROITEM")
    private Short numeroitem;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "TIPOTRIBUTACAO")
    private Character tipotributacao;
    @Column(name = "ALIQTRIBUTACAO")
    private BigDecimal aliqtributacao;
    @Column(name = "NUMEROORCAMENTO")
    private String numeroorcamento;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "ALIQFCP_ST_UF_DESTINO")
    private BigDecimal aliqfcpStUfDestino;
    @Column(name = "ALIQMVA")
    private BigDecimal aliqmva;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "GTINTRIB")
    private String gtintrib;
    @Column(name = "UNIDADETRIB")
    private String unidadetrib;
    @Column(name = "QUANTIDADEEMBALAGEM")
    private BigDecimal quantidadeembalagem;
    @Column(name = "ALIQREDUCAOBASEICMSEFETIVO")
    private BigDecimal aliqreducaobaseicmsefetivo;
    @Column(name = "BASEICMSEFETIVO")
    private BigDecimal baseicmsefetivo;
    @Column(name = "ALIQICMSEFETIVO")
    private BigDecimal aliqicmsefetivo;
    @Column(name = "VALORICMSEFETIVO")
    private BigDecimal valoricmsefetivo;
    @Column(name = "VALORICMSOPERACAO")
    private BigDecimal valoricmsoperacao;
    @Column(name = "CODIGOMOTIVODESO")
    private String codigomotivodeso;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "NUMEROPEDIDOFORN")
    private String numeropedidoforn;
    @Column(name = "NUMEROITEMPEDIDOFORN")
    private Integer numeroitempedidoforn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codorcprod")
    private Collection<Orcamentoprodlote> orcamentoprodloteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codorcprod")
    private Collection<Orcamentoprodpharma> orcamentoprodpharmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codorcprod")
    private Collection<Orcamentovenda> orcamentovendaCollection;
    @OneToMany(mappedBy = "codorcprod")
    private Collection<Orcamentoprodserial> orcamentoprodserialCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODEMPRESAESTOQUE", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresaestoque;
    @JoinColumn(name = "CODORC", referencedColumnName = "CODORC")
    @ManyToOne(optional = false)
    private Orcamento codorc;
    @JoinColumn(name = "CODTEC", referencedColumnName = "CODTEC")
    @ManyToOne
    private OsTecnico codtec;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;

    public Orcamentoprod() {
    }

    public Orcamentoprod(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    public Orcamentoprod(String codorcprod, BigDecimal quantidade, BigDecimal aliqicms) {
        this.codorcprod = codorcprod;
        this.quantidade = quantidade;
        this.aliqicms = aliqicms;
    }

    public String getCodorcprod() {
        return codorcprod;
    }

    public void setCodorcprod(String codorcprod) {
        this.codorcprod = codorcprod;
    }

    public String getCodcor() {
        return codcor;
    }

    public void setCodcor(String codcor) {
        this.codcor = codcor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Character getFlagtipodescontoitem() {
        return flagtipodescontoitem;
    }

    public void setFlagtipodescontoitem(Character flagtipodescontoitem) {
        this.flagtipodescontoitem = flagtipodescontoitem;
    }

    public BigDecimal getAliqdescontoitem() {
        return aliqdescontoitem;
    }

    public void setAliqdescontoitem(BigDecimal aliqdescontoitem) {
        this.aliqdescontoitem = aliqdescontoitem;
    }

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        this.valordescontoitem = valordescontoitem;
    }

    public Character getFlagtipoacrescimoitem() {
        return flagtipoacrescimoitem;
    }

    public void setFlagtipoacrescimoitem(Character flagtipoacrescimoitem) {
        this.flagtipoacrescimoitem = flagtipoacrescimoitem;
    }

    public BigDecimal getAliqacrescimoitem() {
        return aliqacrescimoitem;
    }

    public void setAliqacrescimoitem(BigDecimal aliqacrescimoitem) {
        this.aliqacrescimoitem = aliqacrescimoitem;
    }

    public BigDecimal getValoracrescimoitem() {
        return valoracrescimoitem;
    }

    public void setValoracrescimoitem(BigDecimal valoracrescimoitem) {
        this.valoracrescimoitem = valoracrescimoitem;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public BigDecimal getBaseipi() {
        return baseipi;
    }

    public void setBaseipi(BigDecimal baseipi) {
        this.baseipi = baseipi;
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        this.aliqipi = aliqipi;
    }

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        this.valoripi = valoripi;
    }

    public Character getFlagtipoipi() {
        return flagtipoipi;
    }

    public void setFlagtipoipi(Character flagtipoipi) {
        this.flagtipoipi = flagtipoipi;
    }

    public BigDecimal getAliqiss() {
        return aliqiss;
    }

    public void setAliqiss(BigDecimal aliqiss) {
        this.aliqiss = aliqiss;
    }

    public BigDecimal getValoriss() {
        return valoriss;
    }

    public void setValoriss(BigDecimal valoriss) {
        this.valoriss = valoriss;
    }

    public Character getFlagtipoiss() {
        return flagtipoiss;
    }

    public void setFlagtipoiss(Character flagtipoiss) {
        this.flagtipoiss = flagtipoiss;
    }

    public BigDecimal getBasesubsttributaria() {
        return basesubsttributaria;
    }

    public void setBasesubsttributaria(BigDecimal basesubsttributaria) {
        this.basesubsttributaria = basesubsttributaria;
    }

    public BigDecimal getValorsubsttributaria() {
        return valorsubsttributaria;
    }

    public void setValorsubsttributaria(BigDecimal valorsubsttributaria) {
        this.valorsubsttributaria = valorsubsttributaria;
    }

    public BigDecimal getValorfreterateado() {
        return valorfreterateado;
    }

    public void setValorfreterateado(BigDecimal valorfreterateado) {
        this.valorfreterateado = valorfreterateado;
    }

    public BigDecimal getValorsegurorateado() {
        return valorsegurorateado;
    }

    public void setValorsegurorateado(BigDecimal valorsegurorateado) {
        this.valorsegurorateado = valorsegurorateado;
    }

    public BigDecimal getValoroutrasdesprateado() {
        return valoroutrasdesprateado;
    }

    public void setValoroutrasdesprateado(BigDecimal valoroutrasdesprateado) {
        this.valoroutrasdesprateado = valoroutrasdesprateado;
    }

    public BigDecimal getValoracrescimorateado() {
        return valoracrescimorateado;
    }

    public void setValoracrescimorateado(BigDecimal valoracrescimorateado) {
        this.valoracrescimorateado = valoracrescimorateado;
    }

    public BigDecimal getValordescontorateado() {
        return valordescontorateado;
    }

    public void setValordescontorateado(BigDecimal valordescontorateado) {
        this.valordescontorateado = valordescontorateado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public BigDecimal getPrecotabela() {
        return precotabela;
    }

    public void setPrecotabela(BigDecimal precotabela) {
        this.precotabela = precotabela;
    }

    public Character getFlag1() {
        return flag1;
    }

    public void setFlag1(Character flag1) {
        this.flag1 = flag1;
    }

    public Character getFlag2() {
        return flag2;
    }

    public void setFlag2(Character flag2) {
        this.flag2 = flag2;
    }

    public Character getFlag3() {
        return flag3;
    }

    public void setFlag3(Character flag3) {
        this.flag3 = flag3;
    }

    public BigDecimal getQuantidadetotalfaturada() {
        return quantidadetotalfaturada;
    }

    public void setQuantidadetotalfaturada(BigDecimal quantidadetotalfaturada) {
        this.quantidadetotalfaturada = quantidadetotalfaturada;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getAliqcomissao() {
        return aliqcomissao;
    }

    public void setAliqcomissao(BigDecimal aliqcomissao) {
        this.aliqcomissao = aliqcomissao;
    }

    public BigDecimal getAliqreducaobasesubsttributaria() {
        return aliqreducaobasesubsttributaria;
    }

    public void setAliqreducaobasesubsttributaria(BigDecimal aliqreducaobasesubsttributaria) {
        this.aliqreducaobasesubsttributaria = aliqreducaobasesubsttributaria;
    }

    public String getCodsituacaotributariaipi() {
        return codsituacaotributariaipi;
    }

    public void setCodsituacaotributariaipi(String codsituacaotributariaipi) {
        this.codsituacaotributariaipi = codsituacaotributariaipi;
    }

    public BigDecimal getValorpisfreterateado() {
        return valorpisfreterateado;
    }

    public void setValorpisfreterateado(BigDecimal valorpisfreterateado) {
        this.valorpisfreterateado = valorpisfreterateado;
    }

    public BigDecimal getValorcofinsfreterateado() {
        return valorcofinsfreterateado;
    }

    public void setValorcofinsfreterateado(BigDecimal valorcofinsfreterateado) {
        this.valorcofinsfreterateado = valorcofinsfreterateado;
    }

    public BigDecimal getBaseirrf() {
        return baseirrf;
    }

    public void setBaseirrf(BigDecimal baseirrf) {
        this.baseirrf = baseirrf;
    }

    public BigDecimal getAliqirrf() {
        return aliqirrf;
    }

    public void setAliqirrf(BigDecimal aliqirrf) {
        this.aliqirrf = aliqirrf;
    }

    public BigDecimal getValorirrf() {
        return valorirrf;
    }

    public void setValorirrf(BigDecimal valorirrf) {
        this.valorirrf = valorirrf;
    }

    public BigDecimal getBasecsll() {
        return basecsll;
    }

    public void setBasecsll(BigDecimal basecsll) {
        this.basecsll = basecsll;
    }

    public BigDecimal getAliqcsll() {
        return aliqcsll;
    }

    public void setAliqcsll(BigDecimal aliqcsll) {
        this.aliqcsll = aliqcsll;
    }

    public BigDecimal getValorcsll() {
        return valorcsll;
    }

    public void setValorcsll(BigDecimal valorcsll) {
        this.valorcsll = valorcsll;
    }

    public BigDecimal getBaseii() {
        return baseii;
    }

    public void setBaseii(BigDecimal baseii) {
        this.baseii = baseii;
    }

    public BigDecimal getAliqii() {
        return aliqii;
    }

    public void setAliqii(BigDecimal aliqii) {
        this.aliqii = aliqii;
    }

    public BigDecimal getValorii() {
        return valorii;
    }

    public void setValorii(BigDecimal valorii) {
        this.valorii = valorii;
    }

    public BigDecimal getBasecofins() {
        return basecofins;
    }

    public void setBasecofins(BigDecimal basecofins) {
        this.basecofins = basecofins;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public BigDecimal getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(BigDecimal valorcofins) {
        this.valorcofins = valorcofins;
    }

    public BigDecimal getBasepis() {
        return basepis;
    }

    public void setBasepis(BigDecimal basepis) {
        this.basepis = basepis;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public BigDecimal getValorpis() {
        return valorpis;
    }

    public void setValorpis(BigDecimal valorpis) {
        this.valorpis = valorpis;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public BigDecimal getQuantidademarcada() {
        return quantidademarcada;
    }

    public void setQuantidademarcada(BigDecimal quantidademarcada) {
        this.quantidademarcada = quantidademarcada;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public BigDecimal getAliqcreditosimplesnacional() {
        return aliqcreditosimplesnacional;
    }

    public void setAliqcreditosimplesnacional(BigDecimal aliqcreditosimplesnacional) {
        this.aliqcreditosimplesnacional = aliqcreditosimplesnacional;
    }

    public BigDecimal getValorcreditosimplesnacional() {
        return valorcreditosimplesnacional;
    }

    public void setValorcreditosimplesnacional(BigDecimal valorcreditosimplesnacional) {
        this.valorcreditosimplesnacional = valorcreditosimplesnacional;
    }

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
    }

    public Character getFlagitemcancelado() {
        return flagitemcancelado;
    }

    public void setFlagitemcancelado(Character flagitemcancelado) {
        this.flagitemcancelado = flagitemcancelado;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public BigDecimal getQuantidadeipi() {
        return quantidadeipi;
    }

    public void setQuantidadeipi(BigDecimal quantidadeipi) {
        this.quantidadeipi = quantidadeipi;
    }

    public BigDecimal getValorunidadeipi() {
        return valorunidadeipi;
    }

    public void setValorunidadeipi(BigDecimal valorunidadeipi) {
        this.valorunidadeipi = valorunidadeipi;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuidorcamento() {
        return guidorcamento;
    }

    public void setGuidorcamento(String guidorcamento) {
        this.guidorcamento = guidorcamento;
    }

    public Short getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(Short numeroitem) {
        this.numeroitem = numeroitem;
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Character getTipotributacao() {
        return tipotributacao;
    }

    public void setTipotributacao(Character tipotributacao) {
        this.tipotributacao = tipotributacao;
    }

    public BigDecimal getAliqtributacao() {
        return aliqtributacao;
    }

    public void setAliqtributacao(BigDecimal aliqtributacao) {
        this.aliqtributacao = aliqtributacao;
    }

    public String getNumeroorcamento() {
        return numeroorcamento;
    }

    public void setNumeroorcamento(String numeroorcamento) {
        this.numeroorcamento = numeroorcamento;
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        this.aliqfcp = aliqfcp;
    }

    public BigDecimal getValorfcp() {
        return valorfcp;
    }

    public void setValorfcp(BigDecimal valorfcp) {
        this.valorfcp = valorfcp;
    }

    public BigDecimal getValorfcpsubsttributaria() {
        return valorfcpsubsttributaria;
    }

    public void setValorfcpsubsttributaria(BigDecimal valorfcpsubsttributaria) {
        this.valorfcpsubsttributaria = valorfcpsubsttributaria;
    }

    public BigDecimal getAliqfcpStUfDestino() {
        return aliqfcpStUfDestino;
    }

    public void setAliqfcpStUfDestino(BigDecimal aliqfcpStUfDestino) {
        this.aliqfcpStUfDestino = aliqfcpStUfDestino;
    }

    public BigDecimal getAliqmva() {
        return aliqmva;
    }

    public void setAliqmva(BigDecimal aliqmva) {
        this.aliqmva = aliqmva;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getGtintrib() {
        return gtintrib;
    }

    public void setGtintrib(String gtintrib) {
        this.gtintrib = gtintrib;
    }

    public String getUnidadetrib() {
        return unidadetrib;
    }

    public void setUnidadetrib(String unidadetrib) {
        this.unidadetrib = unidadetrib;
    }

    public BigDecimal getQuantidadeembalagem() {
        return quantidadeembalagem;
    }

    public void setQuantidadeembalagem(BigDecimal quantidadeembalagem) {
        this.quantidadeembalagem = quantidadeembalagem;
    }

    public BigDecimal getAliqreducaobaseicmsefetivo() {
        return aliqreducaobaseicmsefetivo;
    }

    public void setAliqreducaobaseicmsefetivo(BigDecimal aliqreducaobaseicmsefetivo) {
        this.aliqreducaobaseicmsefetivo = aliqreducaobaseicmsefetivo;
    }

    public BigDecimal getBaseicmsefetivo() {
        return baseicmsefetivo;
    }

    public void setBaseicmsefetivo(BigDecimal baseicmsefetivo) {
        this.baseicmsefetivo = baseicmsefetivo;
    }

    public BigDecimal getAliqicmsefetivo() {
        return aliqicmsefetivo;
    }

    public void setAliqicmsefetivo(BigDecimal aliqicmsefetivo) {
        this.aliqicmsefetivo = aliqicmsefetivo;
    }

    public BigDecimal getValoricmsefetivo() {
        return valoricmsefetivo;
    }

    public void setValoricmsefetivo(BigDecimal valoricmsefetivo) {
        this.valoricmsefetivo = valoricmsefetivo;
    }

    public BigDecimal getValoricmsoperacao() {
        return valoricmsoperacao;
    }

    public void setValoricmsoperacao(BigDecimal valoricmsoperacao) {
        this.valoricmsoperacao = valoricmsoperacao;
    }

    public String getCodigomotivodeso() {
        return codigomotivodeso;
    }

    public void setCodigomotivodeso(String codigomotivodeso) {
        this.codigomotivodeso = codigomotivodeso;
    }

    public BigDecimal getValoricmsdesonerado() {
        return valoricmsdesonerado;
    }

    public void setValoricmsdesonerado(BigDecimal valoricmsdesonerado) {
        this.valoricmsdesonerado = valoricmsdesonerado;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getNumeropedidoforn() {
        return numeropedidoforn;
    }

    public void setNumeropedidoforn(String numeropedidoforn) {
        this.numeropedidoforn = numeropedidoforn;
    }

    public Integer getNumeroitempedidoforn() {
        return numeroitempedidoforn;
    }

    public void setNumeroitempedidoforn(Integer numeroitempedidoforn) {
        this.numeroitempedidoforn = numeroitempedidoforn;
    }

    @XmlTransient
    public Collection<Orcamentoprodlote> getOrcamentoprodloteCollection() {
        return orcamentoprodloteCollection;
    }

    public void setOrcamentoprodloteCollection(Collection<Orcamentoprodlote> orcamentoprodloteCollection) {
        this.orcamentoprodloteCollection = orcamentoprodloteCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprodpharma> getOrcamentoprodpharmaCollection() {
        return orcamentoprodpharmaCollection;
    }

    public void setOrcamentoprodpharmaCollection(Collection<Orcamentoprodpharma> orcamentoprodpharmaCollection) {
        this.orcamentoprodpharmaCollection = orcamentoprodpharmaCollection;
    }

    @XmlTransient
    public Collection<Orcamentovenda> getOrcamentovendaCollection() {
        return orcamentovendaCollection;
    }

    public void setOrcamentovendaCollection(Collection<Orcamentovenda> orcamentovendaCollection) {
        this.orcamentovendaCollection = orcamentovendaCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprodserial> getOrcamentoprodserialCollection() {
        return orcamentoprodserialCollection;
    }

    public void setOrcamentoprodserialCollection(Collection<Orcamentoprodserial> orcamentoprodserialCollection) {
        this.orcamentoprodserialCollection = orcamentoprodserialCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Empresa getCodempresaestoque() {
        return codempresaestoque;
    }

    public void setCodempresaestoque(Empresa codempresaestoque) {
        this.codempresaestoque = codempresaestoque;
    }

    public Orcamento getCodorc() {
        return codorc;
    }

    public void setCodorc(Orcamento codorc) {
        this.codorc = codorc;
    }

    public OsTecnico getCodtec() {
        return codtec;
    }

    public void setCodtec(OsTecnico codtec) {
        this.codtec = codtec;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorcprod != null ? codorcprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentoprod)) {
            return false;
        }
        Orcamentoprod other = (Orcamentoprod) object;
        if ((this.codorcprod == null && other.codorcprod != null) || (this.codorcprod != null && !this.codorcprod.equals(other.codorcprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamentoprod[ codorcprod=" + codorcprod + " ]";
    }

    public BigDecimal getAliqdiferimento() {
        return aliqdiferimento;
    }

    public void setAliqdiferimento(BigDecimal aliqdiferimento) {
        this.aliqdiferimento = aliqdiferimento;
    }

    public BigDecimal getValoricmsdiferimento() {
        return valoricmsdiferimento;
    }

    public void setValoricmsdiferimento(BigDecimal valoricmsdiferimento) {
        this.valoricmsdiferimento = valoricmsdiferimento;
    }

    public BigDecimal getValorfcpdiferimento() {
        return valorfcpdiferimento;
    }

    public void setValorfcpdiferimento(BigDecimal valorfcpdiferimento) {
        this.valorfcpdiferimento = valorfcpdiferimento;
    }

    public BigDecimal getValorfcpefetivo() {
        return valorfcpefetivo;
    }

    public void setValorfcpefetivo(BigDecimal valorfcpefetivo) {
        this.valorfcpefetivo = valorfcpefetivo;
    }

    public BigDecimal getAliqfcpdiferimento() {
        return aliqfcpdiferimento;
    }

    public void setAliqfcpdiferimento(BigDecimal aliqfcpdiferimento) {
        this.aliqfcpdiferimento = aliqfcpdiferimento;
    }

    public BigDecimal getValoricmsstdesonerado() {
        return valoricmsstdesonerado;
    }

    public void setValoricmsstdesonerado(BigDecimal valoricmsstdesonerado) {
        this.valoricmsstdesonerado = valoricmsstdesonerado;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
    }
    
}
