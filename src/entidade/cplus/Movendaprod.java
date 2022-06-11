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
@Table(name = "MOVENDAPROD", catalog = "", schema = "")

public class Movendaprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVPROD")
    private String codmovprod;
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
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
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
    @Column(name = "PRECOTABELA")
    private BigDecimal precotabela;
    @Column(name = "CUSTOREAL")
    private BigDecimal custoreal;
    @Column(name = "CUSTOMEDIO")
    private BigDecimal customedio;
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "PRAZOGARANTIA")
    private Integer prazogarantia;
    @Column(name = "FLAGCOMPOSTO")
    private Character flagcomposto;
    @Column(name = "FLAG1")
    private Character flag1;
    @Column(name = "FLAG2")
    private Character flag2;
    @Column(name = "FLAG3")
    private Character flag3;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Column(name = "ALIQCOMISSAO")
    private BigDecimal aliqcomissao;
    @Column(name = "QUANTIDADEDEVOLVIDA")
    private BigDecimal quantidadedevolvida;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "CODIGOEANPRODUTO")
    private String codigoeanproduto;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
    @Column(name = "FLAGALTCOMISSAO")
    private Character flagaltcomissao;
    @Column(name = "ESTOQUEANTERIOR")
    private BigDecimal estoqueanterior;
    @Column(name = "NATUREZAOPERACAOSERVICO")
    private Character naturezaoperacaoservico;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBUTARIA")
    private BigDecimal aliqreducaobasesubsttributaria;
    @Column(name = "CODSITUACAOTRIBUTARIAIPI")
    private String codsituacaotributariaipi;
    @Column(name = "CODMAQUINATINTA")
    private String codmaquinatinta;
    @Column(name = "CODFORMULATINTA")
    private String codformulatinta;
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
    @Column(name = "VALORREVENDA")
    private BigDecimal valorrevenda;
    @Column(name = "CODEMPRESAESTOQUE")
    private Integer codempresaestoque;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "RENTABILIDADEPROD")
    private BigDecimal rentabilidadeprod;
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
    @Column(name = "VALORABATIMENTONAOTRIBICMS")
    private BigDecimal valorabatimentonaotribicms;
    @Column(name = "VALORABATIMENTONAOTRIBPIS")
    private BigDecimal valorabatimentonaotribpis;
    @Column(name = "VALORABATIMENTONAOTRIBCOFINS")
    private BigDecimal valorabatimentonaotribcofins;
    @Column(name = "VALORABATIMENTONAOTRIBIPI")
    private BigDecimal valorabatimentonaotribipi;
    @Column(name = "ALIQICMS_ST_UF_DESTINO")
    private BigDecimal aliqicmsStUfDestino;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "QUANTIDADEIPI")
    private BigDecimal quantidadeipi;
    @Column(name = "VALORUNIDADEIPI")
    private BigDecimal valorunidadeipi;
    @Column(name = "QUANTIDADECONFERIDA")
    private BigDecimal quantidadeconferida;
    @Column(name = "TRIBUTOAPROX")
    private BigDecimal tributoaprox;
    @Column(name = "TRIBUTOESTADUAL")
    private BigDecimal tributoestadual;
    @Column(name = "TRIBUTOMUNICIPAL")
    private BigDecimal tributomunicipal;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "CODENQUADRAMENTOIPI")
    private String codenquadramentoipi;
    @Column(name = "CASASDECIMAISQUANTIDADE")
    private Short casasdecimaisquantidade;
    @Column(name = "CASASDECIMAISVALORUNITARIO")
    private Short casasdecimaisvalorunitario;
    @Column(name = "CODIGOTOTALIZADORPARCIAL")
    private String codigototalizadorparcial;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "PESOLIDOBALANCA")
    private BigDecimal pesolidobalanca;
    @Column(name = "FLAGLIBERAEXPEDICAO")
    private Character flagliberaexpedicao;
    @Column(name = "CODIGOMOTIVODESO")
    private String codigomotivodeso;
    @Column(name = "VALORICMSOPERACAO")
    private BigDecimal valoricmsoperacao;
    @Column(name = "ALIQDIFERIMENTO")
    private BigDecimal aliqdiferimento;
    @Column(name = "VALORICMSDIFERIMENTO")
    private BigDecimal valoricmsdiferimento;
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
    @Column(name = "QUANTIDADERECEBIDA")
    private BigDecimal quantidaderecebida;
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
    @Column(name = "ALIQINSS")
    private BigDecimal aliqinss;
    @Column(name = "VALORINSS")
    private BigDecimal valorinss;
    @Column(name = "BASEINSS")
    private BigDecimal baseinss;
    @Column(name = "CODBENEFICIOFISCAL")
    private String codbeneficiofiscal;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "NUMEROPEDIDOFORN")
    private String numeropedidoforn;
    @Column(name = "NUMEROITEMPEDIDOFORN")
    private Integer numeroitempedidoforn;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Consignacaobaixa> consignacaobaixaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Movendaprodpharma> movendaprodpharmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Loteentregaitem> loteentregaitemCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Orcamentovenda> orcamentovendaCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Vendedorcomissao> vendedorcomissaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Movendaprodserial> movendaprodserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Movendaprodfci> movendaprodfciCollection;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne(optional = false)
    private Movenda codmovenda;
    @JoinColumn(name = "CODTEC", referencedColumnName = "CODTEC")
    @ManyToOne
    private OsTecnico codtec;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Movendaprodlote> movendaprodloteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovprod")
    private Collection<Movendaprodcomp> movendaprodcompCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Moentregaprod> moentregaprodCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Comissao> comissaoCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Vendedordesconto> vendedordescontoCollection;
    @OneToMany(mappedBy = "codmovprod")
    private Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection;

    public Movendaprod() {
    }

    public Movendaprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public Movendaprod(String codmovprod, BigDecimal quantidade, BigDecimal aliqicms) {
        this.codmovprod = codmovprod;
        this.quantidade = quantidade;
        this.aliqicms = aliqicms;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
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

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
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

    public BigDecimal getPrecotabela() {
        return precotabela;
    }

    public void setPrecotabela(BigDecimal precotabela) {
        this.precotabela = precotabela;
    }

    public BigDecimal getCustoreal() {
        return custoreal;
    }

    public void setCustoreal(BigDecimal custoreal) {
        this.custoreal = custoreal;
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        this.customedio = customedio;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        this.prazogarantia = prazogarantia;
    }

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        this.flagcomposto = flagcomposto;
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

    public Character getFlagtipoiss() {
        return flagtipoiss;
    }

    public void setFlagtipoiss(Character flagtipoiss) {
        this.flagtipoiss = flagtipoiss;
    }

    public Character getFlagtipoipi() {
        return flagtipoipi;
    }

    public void setFlagtipoipi(Character flagtipoipi) {
        this.flagtipoipi = flagtipoipi;
    }

    public BigDecimal getAliqcomissao() {
        return aliqcomissao;
    }

    public void setAliqcomissao(BigDecimal aliqcomissao) {
        this.aliqcomissao = aliqcomissao;
    }

    public BigDecimal getQuantidadedevolvida() {
        return quantidadedevolvida;
    }

    public void setQuantidadedevolvida(BigDecimal quantidadedevolvida) {
        this.quantidadedevolvida = quantidadedevolvida;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public String getCodigoeanproduto() {
        return codigoeanproduto;
    }

    public void setCodigoeanproduto(String codigoeanproduto) {
        this.codigoeanproduto = codigoeanproduto;
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        this.flagorigemproduto = flagorigemproduto;
    }

    public Character getFlagaltcomissao() {
        return flagaltcomissao;
    }

    public void setFlagaltcomissao(Character flagaltcomissao) {
        this.flagaltcomissao = flagaltcomissao;
    }

    public BigDecimal getEstoqueanterior() {
        return estoqueanterior;
    }

    public void setEstoqueanterior(BigDecimal estoqueanterior) {
        this.estoqueanterior = estoqueanterior;
    }

    public Character getNaturezaoperacaoservico() {
        return naturezaoperacaoservico;
    }

    public void setNaturezaoperacaoservico(Character naturezaoperacaoservico) {
        this.naturezaoperacaoservico = naturezaoperacaoservico;
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

    public String getCodmaquinatinta() {
        return codmaquinatinta;
    }

    public void setCodmaquinatinta(String codmaquinatinta) {
        this.codmaquinatinta = codmaquinatinta;
    }

    public String getCodformulatinta() {
        return codformulatinta;
    }

    public void setCodformulatinta(String codformulatinta) {
        this.codformulatinta = codformulatinta;
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

    public BigDecimal getValorrevenda() {
        return valorrevenda;
    }

    public void setValorrevenda(BigDecimal valorrevenda) {
        this.valorrevenda = valorrevenda;
    }

    public Integer getCodempresaestoque() {
        return codempresaestoque;
    }

    public void setCodempresaestoque(Integer codempresaestoque) {
        this.codempresaestoque = codempresaestoque;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
    }

    public BigDecimal getRentabilidadeprod() {
        return rentabilidadeprod;
    }

    public void setRentabilidadeprod(BigDecimal rentabilidadeprod) {
        this.rentabilidadeprod = rentabilidadeprod;
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

    public BigDecimal getValorabatimentonaotribicms() {
        return valorabatimentonaotribicms;
    }

    public void setValorabatimentonaotribicms(BigDecimal valorabatimentonaotribicms) {
        this.valorabatimentonaotribicms = valorabatimentonaotribicms;
    }

    public BigDecimal getValorabatimentonaotribpis() {
        return valorabatimentonaotribpis;
    }

    public void setValorabatimentonaotribpis(BigDecimal valorabatimentonaotribpis) {
        this.valorabatimentonaotribpis = valorabatimentonaotribpis;
    }

    public BigDecimal getValorabatimentonaotribcofins() {
        return valorabatimentonaotribcofins;
    }

    public void setValorabatimentonaotribcofins(BigDecimal valorabatimentonaotribcofins) {
        this.valorabatimentonaotribcofins = valorabatimentonaotribcofins;
    }

    public BigDecimal getValorabatimentonaotribipi() {
        return valorabatimentonaotribipi;
    }

    public void setValorabatimentonaotribipi(BigDecimal valorabatimentonaotribipi) {
        this.valorabatimentonaotribipi = valorabatimentonaotribipi;
    }

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public BigDecimal getQuantidadeconferida() {
        return quantidadeconferida;
    }

    public void setQuantidadeconferida(BigDecimal quantidadeconferida) {
        this.quantidadeconferida = quantidadeconferida;
    }

    public BigDecimal getTributoaprox() {
        return tributoaprox;
    }

    public void setTributoaprox(BigDecimal tributoaprox) {
        this.tributoaprox = tributoaprox;
    }

    public BigDecimal getTributoestadual() {
        return tributoestadual;
    }

    public void setTributoestadual(BigDecimal tributoestadual) {
        this.tributoestadual = tributoestadual;
    }

    public BigDecimal getTributomunicipal() {
        return tributomunicipal;
    }

    public void setTributomunicipal(BigDecimal tributomunicipal) {
        this.tributomunicipal = tributomunicipal;
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        this.codenquadramentoipi = codenquadramentoipi;
    }

    public Short getCasasdecimaisquantidade() {
        return casasdecimaisquantidade;
    }

    public void setCasasdecimaisquantidade(Short casasdecimaisquantidade) {
        this.casasdecimaisquantidade = casasdecimaisquantidade;
    }

    public Short getCasasdecimaisvalorunitario() {
        return casasdecimaisvalorunitario;
    }

    public void setCasasdecimaisvalorunitario(Short casasdecimaisvalorunitario) {
        this.casasdecimaisvalorunitario = casasdecimaisvalorunitario;
    }

    public String getCodigototalizadorparcial() {
        return codigototalizadorparcial;
    }

    public void setCodigototalizadorparcial(String codigototalizadorparcial) {
        this.codigototalizadorparcial = codigototalizadorparcial;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public BigDecimal getPesolidobalanca() {
        return pesolidobalanca;
    }

    public void setPesolidobalanca(BigDecimal pesolidobalanca) {
        this.pesolidobalanca = pesolidobalanca;
    }

    public Character getFlagliberaexpedicao() {
        return flagliberaexpedicao;
    }

    public void setFlagliberaexpedicao(Character flagliberaexpedicao) {
        this.flagliberaexpedicao = flagliberaexpedicao;
    }

    public String getCodigomotivodeso() {
        return codigomotivodeso;
    }

    public void setCodigomotivodeso(String codigomotivodeso) {
        this.codigomotivodeso = codigomotivodeso;
    }

    public BigDecimal getValoricmsoperacao() {
        return valoricmsoperacao;
    }

    public void setValoricmsoperacao(BigDecimal valoricmsoperacao) {
        this.valoricmsoperacao = valoricmsoperacao;
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

    public BigDecimal getQuantidaderecebida() {
        return quantidaderecebida;
    }

    public void setQuantidaderecebida(BigDecimal quantidaderecebida) {
        this.quantidaderecebida = quantidaderecebida;
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

    public BigDecimal getAliqinss() {
        return aliqinss;
    }

    public void setAliqinss(BigDecimal aliqinss) {
        this.aliqinss = aliqinss;
    }

    public BigDecimal getValorinss() {
        return valorinss;
    }

    public void setValorinss(BigDecimal valorinss) {
        this.valorinss = valorinss;
    }

    public BigDecimal getBaseinss() {
        return baseinss;
    }

    public void setBaseinss(BigDecimal baseinss) {
        this.baseinss = baseinss;
    }

    public String getCodbeneficiofiscal() {
        return codbeneficiofiscal;
    }

    public void setCodbeneficiofiscal(String codbeneficiofiscal) {
        this.codbeneficiofiscal = codbeneficiofiscal;
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
    public Collection<Consignacaobaixa> getConsignacaobaixaCollection() {
        return consignacaobaixaCollection;
    }

    public void setConsignacaobaixaCollection(Collection<Consignacaobaixa> consignacaobaixaCollection) {
        this.consignacaobaixaCollection = consignacaobaixaCollection;
    }

    @XmlTransient
    public Collection<Movendaprodpharma> getMovendaprodpharmaCollection() {
        return movendaprodpharmaCollection;
    }

    public void setMovendaprodpharmaCollection(Collection<Movendaprodpharma> movendaprodpharmaCollection) {
        this.movendaprodpharmaCollection = movendaprodpharmaCollection;
    }

    @XmlTransient
    public Collection<Loteentregaitem> getLoteentregaitemCollection() {
        return loteentregaitemCollection;
    }

    public void setLoteentregaitemCollection(Collection<Loteentregaitem> loteentregaitemCollection) {
        this.loteentregaitemCollection = loteentregaitemCollection;
    }

    @XmlTransient
    public Collection<Orcamentovenda> getOrcamentovendaCollection() {
        return orcamentovendaCollection;
    }

    public void setOrcamentovendaCollection(Collection<Orcamentovenda> orcamentovendaCollection) {
        this.orcamentovendaCollection = orcamentovendaCollection;
    }

    @XmlTransient
    public Collection<Vendedorcomissao> getVendedorcomissaoCollection() {
        return vendedorcomissaoCollection;
    }

    public void setVendedorcomissaoCollection(Collection<Vendedorcomissao> vendedorcomissaoCollection) {
        this.vendedorcomissaoCollection = vendedorcomissaoCollection;
    }

    @XmlTransient
    public Collection<Movendaprodserial> getMovendaprodserialCollection() {
        return movendaprodserialCollection;
    }

    public void setMovendaprodserialCollection(Collection<Movendaprodserial> movendaprodserialCollection) {
        this.movendaprodserialCollection = movendaprodserialCollection;
    }

    @XmlTransient
    public Collection<Movendaprodfci> getMovendaprodfciCollection() {
        return movendaprodfciCollection;
    }

    public void setMovendaprodfciCollection(Collection<Movendaprodfci> movendaprodfciCollection) {
        this.movendaprodfciCollection = movendaprodfciCollection;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
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

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @XmlTransient
    public Collection<Movendaprodlote> getMovendaprodloteCollection() {
        return movendaprodloteCollection;
    }

    public void setMovendaprodloteCollection(Collection<Movendaprodlote> movendaprodloteCollection) {
        this.movendaprodloteCollection = movendaprodloteCollection;
    }

    @XmlTransient
    public Collection<Movendaprodcomp> getMovendaprodcompCollection() {
        return movendaprodcompCollection;
    }

    public void setMovendaprodcompCollection(Collection<Movendaprodcomp> movendaprodcompCollection) {
        this.movendaprodcompCollection = movendaprodcompCollection;
    }

    @XmlTransient
    public Collection<Moentregaprod> getMoentregaprodCollection() {
        return moentregaprodCollection;
    }

    public void setMoentregaprodCollection(Collection<Moentregaprod> moentregaprodCollection) {
        this.moentregaprodCollection = moentregaprodCollection;
    }

    @XmlTransient
    public Collection<Comissao> getComissaoCollection() {
        return comissaoCollection;
    }

    public void setComissaoCollection(Collection<Comissao> comissaoCollection) {
        this.comissaoCollection = comissaoCollection;
    }

    @XmlTransient
    public Collection<Vendedordesconto> getVendedordescontoCollection() {
        return vendedordescontoCollection;
    }

    public void setVendedordescontoCollection(Collection<Vendedordesconto> vendedordescontoCollection) {
        this.vendedordescontoCollection = vendedordescontoCollection;
    }

    @XmlTransient
    public Collection<Movendaproddevolucaocompra> getMovendaproddevolucaocompraCollection() {
        return movendaproddevolucaocompraCollection;
    }

    public void setMovendaproddevolucaocompraCollection(Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection) {
        this.movendaproddevolucaocompraCollection = movendaproddevolucaocompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovprod != null ? codmovprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendaprod)) {
            return false;
        }
        Movendaprod other = (Movendaprod) object;
        if ((this.codmovprod == null && other.codmovprod != null) || (this.codmovprod != null && !this.codmovprod.equals(other.codmovprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendaprod[ codmovprod=" + codmovprod + " ]";
    }
    
}
