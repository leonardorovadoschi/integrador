/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PEDIDOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoitem.findAll", query = "SELECT p FROM Pedidoitem p")
    , @NamedQuery(name = "Pedidoitem.findByCodpedidoitem", query = "SELECT p FROM Pedidoitem p WHERE p.codpedidoitem = :codpedidoitem")
    , @NamedQuery(name = "Pedidoitem.findByCodsituacaotributaria", query = "SELECT p FROM Pedidoitem p WHERE p.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Pedidoitem.findByQuantidade", query = "SELECT p FROM Pedidoitem p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Pedidoitem.findByQuantidaderecebida", query = "SELECT p FROM Pedidoitem p WHERE p.quantidaderecebida = :quantidaderecebida")
    , @NamedQuery(name = "Pedidoitem.findByValorunitario", query = "SELECT p FROM Pedidoitem p WHERE p.valorunitario = :valorunitario")
    , @NamedQuery(name = "Pedidoitem.findByFlagtipodescontoitem", query = "SELECT p FROM Pedidoitem p WHERE p.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "Pedidoitem.findByAliqdescontoitem", query = "SELECT p FROM Pedidoitem p WHERE p.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "Pedidoitem.findByValordescontoitem", query = "SELECT p FROM Pedidoitem p WHERE p.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "Pedidoitem.findByFlagtipoacrescimoitem", query = "SELECT p FROM Pedidoitem p WHERE p.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "Pedidoitem.findByAliqacrescimoitem", query = "SELECT p FROM Pedidoitem p WHERE p.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "Pedidoitem.findByValoracrescimoitem", query = "SELECT p FROM Pedidoitem p WHERE p.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "Pedidoitem.findByValortotal", query = "SELECT p FROM Pedidoitem p WHERE p.valortotal = :valortotal")
    , @NamedQuery(name = "Pedidoitem.findByBaseicms", query = "SELECT p FROM Pedidoitem p WHERE p.baseicms = :baseicms")
    , @NamedQuery(name = "Pedidoitem.findByAliqicms", query = "SELECT p FROM Pedidoitem p WHERE p.aliqicms = :aliqicms")
    , @NamedQuery(name = "Pedidoitem.findByValoricms", query = "SELECT p FROM Pedidoitem p WHERE p.valoricms = :valoricms")
    , @NamedQuery(name = "Pedidoitem.findByBaseipi", query = "SELECT p FROM Pedidoitem p WHERE p.baseipi = :baseipi")
    , @NamedQuery(name = "Pedidoitem.findByAliqipi", query = "SELECT p FROM Pedidoitem p WHERE p.aliqipi = :aliqipi")
    , @NamedQuery(name = "Pedidoitem.findByValoripi", query = "SELECT p FROM Pedidoitem p WHERE p.valoripi = :valoripi")
    , @NamedQuery(name = "Pedidoitem.findByAliqiss", query = "SELECT p FROM Pedidoitem p WHERE p.aliqiss = :aliqiss")
    , @NamedQuery(name = "Pedidoitem.findByValoriss", query = "SELECT p FROM Pedidoitem p WHERE p.valoriss = :valoriss")
    , @NamedQuery(name = "Pedidoitem.findByBasesubsttributaria", query = "SELECT p FROM Pedidoitem p WHERE p.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "Pedidoitem.findByValorsubsttributaria", query = "SELECT p FROM Pedidoitem p WHERE p.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "Pedidoitem.findByValorfreterateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorfreterateado = :valorfreterateado")
    , @NamedQuery(name = "Pedidoitem.findByValorsegurorateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorsegurorateado = :valorsegurorateado")
    , @NamedQuery(name = "Pedidoitem.findByValoroutrasdesprateado", query = "SELECT p FROM Pedidoitem p WHERE p.valoroutrasdesprateado = :valoroutrasdesprateado")
    , @NamedQuery(name = "Pedidoitem.findByValoracrescimorateado", query = "SELECT p FROM Pedidoitem p WHERE p.valoracrescimorateado = :valoracrescimorateado")
    , @NamedQuery(name = "Pedidoitem.findByValordescontorateado", query = "SELECT p FROM Pedidoitem p WHERE p.valordescontorateado = :valordescontorateado")
    , @NamedQuery(name = "Pedidoitem.findByComplemento", query = "SELECT p FROM Pedidoitem p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Pedidoitem.findByFlagcomposto", query = "SELECT p FROM Pedidoitem p WHERE p.flagcomposto = :flagcomposto")
    , @NamedQuery(name = "Pedidoitem.findByFlagtipoiss", query = "SELECT p FROM Pedidoitem p WHERE p.flagtipoiss = :flagtipoiss")
    , @NamedQuery(name = "Pedidoitem.findByFlagtipoipi", query = "SELECT p FROM Pedidoitem p WHERE p.flagtipoipi = :flagtipoipi")
    , @NamedQuery(name = "Pedidoitem.findByValorpisfreterateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorpisfreterateado = :valorpisfreterateado")
    , @NamedQuery(name = "Pedidoitem.findByValorcofinsfreterateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorcofinsfreterateado = :valorcofinsfreterateado")
    , @NamedQuery(name = "Pedidoitem.findByBaseirrf", query = "SELECT p FROM Pedidoitem p WHERE p.baseirrf = :baseirrf")
    , @NamedQuery(name = "Pedidoitem.findByAliqirrf", query = "SELECT p FROM Pedidoitem p WHERE p.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "Pedidoitem.findByValorirrf", query = "SELECT p FROM Pedidoitem p WHERE p.valorirrf = :valorirrf")
    , @NamedQuery(name = "Pedidoitem.findByBasecsll", query = "SELECT p FROM Pedidoitem p WHERE p.basecsll = :basecsll")
    , @NamedQuery(name = "Pedidoitem.findByAliqcsll", query = "SELECT p FROM Pedidoitem p WHERE p.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "Pedidoitem.findByValorcsll", query = "SELECT p FROM Pedidoitem p WHERE p.valorcsll = :valorcsll")
    , @NamedQuery(name = "Pedidoitem.findByBaseii", query = "SELECT p FROM Pedidoitem p WHERE p.baseii = :baseii")
    , @NamedQuery(name = "Pedidoitem.findByAliqii", query = "SELECT p FROM Pedidoitem p WHERE p.aliqii = :aliqii")
    , @NamedQuery(name = "Pedidoitem.findByValorii", query = "SELECT p FROM Pedidoitem p WHERE p.valorii = :valorii")
    , @NamedQuery(name = "Pedidoitem.findByBasecofins", query = "SELECT p FROM Pedidoitem p WHERE p.basecofins = :basecofins")
    , @NamedQuery(name = "Pedidoitem.findByAliqcofins", query = "SELECT p FROM Pedidoitem p WHERE p.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Pedidoitem.findByValorcofins", query = "SELECT p FROM Pedidoitem p WHERE p.valorcofins = :valorcofins")
    , @NamedQuery(name = "Pedidoitem.findByBasepis", query = "SELECT p FROM Pedidoitem p WHERE p.basepis = :basepis")
    , @NamedQuery(name = "Pedidoitem.findByAliqpis", query = "SELECT p FROM Pedidoitem p WHERE p.aliqpis = :aliqpis")
    , @NamedQuery(name = "Pedidoitem.findByValorpis", query = "SELECT p FROM Pedidoitem p WHERE p.valorpis = :valorpis")
    , @NamedQuery(name = "Pedidoitem.findByCstpis", query = "SELECT p FROM Pedidoitem p WHERE p.cstpis = :cstpis")
    , @NamedQuery(name = "Pedidoitem.findByCstcofins", query = "SELECT p FROM Pedidoitem p WHERE p.cstcofins = :cstcofins")
    , @NamedQuery(name = "Pedidoitem.findByCsosn", query = "SELECT p FROM Pedidoitem p WHERE p.csosn = :csosn")
    , @NamedQuery(name = "Pedidoitem.findByAliqcreditosimplesnacional", query = "SELECT p FROM Pedidoitem p WHERE p.aliqcreditosimplesnacional = :aliqcreditosimplesnacional")
    , @NamedQuery(name = "Pedidoitem.findByValorcreditosimplesnacional", query = "SELECT p FROM Pedidoitem p WHERE p.valorcreditosimplesnacional = :valorcreditosimplesnacional")
    , @NamedQuery(name = "Pedidoitem.findByCodigoprodforn", query = "SELECT p FROM Pedidoitem p WHERE p.codigoprodforn = :codigoprodforn")
    , @NamedQuery(name = "Pedidoitem.findByValorsubstantecipadarateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorsubstantecipadarateado = :valorsubstantecipadarateado")
    , @NamedQuery(name = "Pedidoitem.findByValorconhecimentotransrateado", query = "SELECT p FROM Pedidoitem p WHERE p.valorconhecimentotransrateado = :valorconhecimentotransrateado")
    , @NamedQuery(name = "Pedidoitem.findByValorfreteredespachorat", query = "SELECT p FROM Pedidoitem p WHERE p.valorfreteredespachorat = :valorfreteredespachorat")
    , @NamedQuery(name = "Pedidoitem.findByQuantidadeipi", query = "SELECT p FROM Pedidoitem p WHERE p.quantidadeipi = :quantidadeipi")
    , @NamedQuery(name = "Pedidoitem.findByValorunidadeipi", query = "SELECT p FROM Pedidoitem p WHERE p.valorunidadeipi = :valorunidadeipi")
    , @NamedQuery(name = "Pedidoitem.findByCodcalculoicms", query = "SELECT p FROM Pedidoitem p WHERE p.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "Pedidoitem.findByAliqfcp", query = "SELECT p FROM Pedidoitem p WHERE p.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Pedidoitem.findByValorfcp", query = "SELECT p FROM Pedidoitem p WHERE p.valorfcp = :valorfcp")
    , @NamedQuery(name = "Pedidoitem.findByValorfcpsubsttributaria", query = "SELECT p FROM Pedidoitem p WHERE p.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "Pedidoitem.findByAliqfcpStUfDestino", query = "SELECT p FROM Pedidoitem p WHERE p.aliqfcpStUfDestino = :aliqfcpStUfDestino")
    , @NamedQuery(name = "Pedidoitem.findByAliqicmsStUfDestino", query = "SELECT p FROM Pedidoitem p WHERE p.aliqicmsStUfDestino = :aliqicmsStUfDestino")})
public class Pedidoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPEDIDOITEM")
    private String codpedidoitem;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "QUANTIDADERECEBIDA")
    private BigDecimal quantidaderecebida;
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
    @Column(name = "FLAGCOMPOSTO")
    private Character flagcomposto;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
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
    @Column(name = "CODIGOPRODFORN")
    private String codigoprodforn;
    @Column(name = "VALORSUBSTANTECIPADARATEADO")
    private BigDecimal valorsubstantecipadarateado;
    @Column(name = "VALORCONHECIMENTOTRANSRATEADO")
    private BigDecimal valorconhecimentotransrateado;
    @Column(name = "VALORFRETEREDESPACHORAT")
    private BigDecimal valorfreteredespachorat;
    @Column(name = "QUANTIDADEIPI")
    private BigDecimal quantidadeipi;
    @Column(name = "VALORUNIDADEIPI")
    private BigDecimal valorunidadeipi;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "ALIQFCP_ST_UF_DESTINO")
    private BigDecimal aliqfcpStUfDestino;
    @Column(name = "ALIQICMS_ST_UF_DESTINO")
    private BigDecimal aliqicmsStUfDestino;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODCLASSIFICACAOFISCAL", referencedColumnName = "CODCLASSIFICACAOFISCAL")
    @ManyToOne
    private Classificacaofiscal codclassificacaofiscal;
    @JoinColumn(name = "CODCOR", referencedColumnName = "CODCOR")
    @ManyToOne
    private Cor codcor;
    @JoinColumn(name = "CODPED", referencedColumnName = "CODPED")
    @ManyToOne(optional = false)
    private Pedido codped;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpedidoitem")
    private Collection<Pedidoentrada> pedidoentradaCollection;

    public Pedidoitem() {
    }

    public Pedidoitem(String codpedidoitem) {
        this.codpedidoitem = codpedidoitem;
    }

    public String getCodpedidoitem() {
        return codpedidoitem;
    }

    public void setCodpedidoitem(String codpedidoitem) {
        this.codpedidoitem = codpedidoitem;
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidaderecebida() {
        return quantidaderecebida;
    }

    public void setQuantidaderecebida(BigDecimal quantidaderecebida) {
        this.quantidaderecebida = quantidaderecebida;
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

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        this.flagcomposto = flagcomposto;
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

    public String getCodigoprodforn() {
        return codigoprodforn;
    }

    public void setCodigoprodforn(String codigoprodforn) {
        this.codigoprodforn = codigoprodforn;
    }

    public BigDecimal getValorsubstantecipadarateado() {
        return valorsubstantecipadarateado;
    }

    public void setValorsubstantecipadarateado(BigDecimal valorsubstantecipadarateado) {
        this.valorsubstantecipadarateado = valorsubstantecipadarateado;
    }

    public BigDecimal getValorconhecimentotransrateado() {
        return valorconhecimentotransrateado;
    }

    public void setValorconhecimentotransrateado(BigDecimal valorconhecimentotransrateado) {
        this.valorconhecimentotransrateado = valorconhecimentotransrateado;
    }

    public BigDecimal getValorfreteredespachorat() {
        return valorfreteredespachorat;
    }

    public void setValorfreteredespachorat(BigDecimal valorfreteredespachorat) {
        this.valorfreteredespachorat = valorfreteredespachorat;
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

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
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

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Classificacaofiscal getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(Classificacaofiscal codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public Cor getCodcor() {
        return codcor;
    }

    public void setCodcor(Cor codcor) {
        this.codcor = codcor;
    }

    public Pedido getCodped() {
        return codped;
    }

    public void setCodped(Pedido codped) {
        this.codped = codped;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @XmlTransient
    public Collection<Pedidoentrada> getPedidoentradaCollection() {
        return pedidoentradaCollection;
    }

    public void setPedidoentradaCollection(Collection<Pedidoentrada> pedidoentradaCollection) {
        this.pedidoentradaCollection = pedidoentradaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpedidoitem != null ? codpedidoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidoitem)) {
            return false;
        }
        Pedidoitem other = (Pedidoitem) object;
        if ((this.codpedidoitem == null && other.codpedidoitem != null) || (this.codpedidoitem != null && !this.codpedidoitem.equals(other.codpedidoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pedidoitem[ codpedidoitem=" + codpedidoitem + " ]";
    }
    
}
