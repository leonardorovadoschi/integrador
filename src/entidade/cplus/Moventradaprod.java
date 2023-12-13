/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "MOVENTRADAPROD", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moventradaprod.findAll", query = "SELECT m FROM Moventradaprod m")
    , @NamedQuery(name = "Moventradaprod.findByCodmoveprod", query = "SELECT m FROM Moventradaprod m WHERE m.codmoveprod = :codmoveprod")
    , @NamedQuery(name = "Moventradaprod.findByComplemento", query = "SELECT m FROM Moventradaprod m WHERE m.complemento = :complemento")
    , @NamedQuery(name = "Moventradaprod.findByQuantidade", query = "SELECT m FROM Moventradaprod m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Moventradaprod.findByQuantidadeembalagem", query = "SELECT m FROM Moventradaprod m WHERE m.quantidadeembalagem = :quantidadeembalagem")
    , @NamedQuery(name = "Moventradaprod.findByValorunitario", query = "SELECT m FROM Moventradaprod m WHERE m.valorunitario = :valorunitario")
    , @NamedQuery(name = "Moventradaprod.findByFlagtipoacrescimoitem", query = "SELECT m FROM Moventradaprod m WHERE m.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "Moventradaprod.findByAliqacrescimoitem", query = "SELECT m FROM Moventradaprod m WHERE m.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "Moventradaprod.findByValoracrescimoitem", query = "SELECT m FROM Moventradaprod m WHERE m.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "Moventradaprod.findByFlagtipodescontoitem", query = "SELECT m FROM Moventradaprod m WHERE m.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "Moventradaprod.findByAliqdescontoitem", query = "SELECT m FROM Moventradaprod m WHERE m.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "Moventradaprod.findByValordescontoitem", query = "SELECT m FROM Moventradaprod m WHERE m.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "Moventradaprod.findByValortotal", query = "SELECT m FROM Moventradaprod m WHERE m.valortotal = :valortotal")
    , @NamedQuery(name = "Moventradaprod.findByBaseipi", query = "SELECT m FROM Moventradaprod m WHERE m.baseipi = :baseipi")
    , @NamedQuery(name = "Moventradaprod.findByFlagtipoipi", query = "SELECT m FROM Moventradaprod m WHERE m.flagtipoipi = :flagtipoipi")
    , @NamedQuery(name = "Moventradaprod.findByAliqipi", query = "SELECT m FROM Moventradaprod m WHERE m.aliqipi = :aliqipi")
    , @NamedQuery(name = "Moventradaprod.findByValoripi", query = "SELECT m FROM Moventradaprod m WHERE m.valoripi = :valoripi")
    , @NamedQuery(name = "Moventradaprod.findByBaseicms", query = "SELECT m FROM Moventradaprod m WHERE m.baseicms = :baseicms")
    , @NamedQuery(name = "Moventradaprod.findByAliqicms", query = "SELECT m FROM Moventradaprod m WHERE m.aliqicms = :aliqicms")
    , @NamedQuery(name = "Moventradaprod.findByValoricms", query = "SELECT m FROM Moventradaprod m WHERE m.valoricms = :valoricms")
    , @NamedQuery(name = "Moventradaprod.findByFlagtipoiss", query = "SELECT m FROM Moventradaprod m WHERE m.flagtipoiss = :flagtipoiss")
    , @NamedQuery(name = "Moventradaprod.findByAliqiss", query = "SELECT m FROM Moventradaprod m WHERE m.aliqiss = :aliqiss")
    , @NamedQuery(name = "Moventradaprod.findByValoriss", query = "SELECT m FROM Moventradaprod m WHERE m.valoriss = :valoriss")
    , @NamedQuery(name = "Moventradaprod.findByBasesubsttributaria", query = "SELECT m FROM Moventradaprod m WHERE m.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "Moventradaprod.findByValorsubsttributaria", query = "SELECT m FROM Moventradaprod m WHERE m.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "Moventradaprod.findByFlagorigemproduto", query = "SELECT m FROM Moventradaprod m WHERE m.flagorigemproduto = :flagorigemproduto")
    , @NamedQuery(name = "Moventradaprod.findByCodsituacaotributaria", query = "SELECT m FROM Moventradaprod m WHERE m.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Moventradaprod.findByFlagcomposto", query = "SELECT m FROM Moventradaprod m WHERE m.flagcomposto = :flagcomposto")
    , @NamedQuery(name = "Moventradaprod.findByDatavalidade", query = "SELECT m FROM Moventradaprod m WHERE m.datavalidade = :datavalidade")
    , @NamedQuery(name = "Moventradaprod.findByCodmoeda", query = "SELECT m FROM Moventradaprod m WHERE m.codmoeda = :codmoeda")
    , @NamedQuery(name = "Moventradaprod.findByCodclassificacaofiscal", query = "SELECT m FROM Moventradaprod m WHERE m.codclassificacaofiscal = :codclassificacaofiscal")
    , @NamedQuery(name = "Moventradaprod.findByValorfreterateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorfreterateado = :valorfreterateado")
    , @NamedQuery(name = "Moventradaprod.findByValoracrescimorateado", query = "SELECT m FROM Moventradaprod m WHERE m.valoracrescimorateado = :valoracrescimorateado")
    , @NamedQuery(name = "Moventradaprod.findByValordescontorateado", query = "SELECT m FROM Moventradaprod m WHERE m.valordescontorateado = :valordescontorateado")
    , @NamedQuery(name = "Moventradaprod.findByValorsegurorateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorsegurorateado = :valorsegurorateado")
    , @NamedQuery(name = "Moventradaprod.findByValoroutrasdesprateado", query = "SELECT m FROM Moventradaprod m WHERE m.valoroutrasdesprateado = :valoroutrasdesprateado")
    , @NamedQuery(name = "Moventradaprod.findByHora", query = "SELECT m FROM Moventradaprod m WHERE m.hora = :hora")
    , @NamedQuery(name = "Moventradaprod.findByCodcor", query = "SELECT m FROM Moventradaprod m WHERE m.codcor = :codcor")
    , @NamedQuery(name = "Moventradaprod.findByCodmovproddevolucao", query = "SELECT m FROM Moventradaprod m WHERE m.codmovproddevolucao = :codmovproddevolucao")
    , @NamedQuery(name = "Moventradaprod.findByAliqreducaobasesubsttributaria", query = "SELECT m FROM Moventradaprod m WHERE m.aliqreducaobasesubsttributaria = :aliqreducaobasesubsttributaria")
    , @NamedQuery(name = "Moventradaprod.findByCodsituacaotributariaipi", query = "SELECT m FROM Moventradaprod m WHERE m.codsituacaotributariaipi = :codsituacaotributariaipi")
    , @NamedQuery(name = "Moventradaprod.findByValorpisfreterateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorpisfreterateado = :valorpisfreterateado")
    , @NamedQuery(name = "Moventradaprod.findByValorcofinsfreterateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorcofinsfreterateado = :valorcofinsfreterateado")
    , @NamedQuery(name = "Moventradaprod.findByBaseirrf", query = "SELECT m FROM Moventradaprod m WHERE m.baseirrf = :baseirrf")
    , @NamedQuery(name = "Moventradaprod.findByAliqirrf", query = "SELECT m FROM Moventradaprod m WHERE m.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "Moventradaprod.findByValorirrf", query = "SELECT m FROM Moventradaprod m WHERE m.valorirrf = :valorirrf")
    , @NamedQuery(name = "Moventradaprod.findByBasecsll", query = "SELECT m FROM Moventradaprod m WHERE m.basecsll = :basecsll")
    , @NamedQuery(name = "Moventradaprod.findByAliqcsll", query = "SELECT m FROM Moventradaprod m WHERE m.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "Moventradaprod.findByValorcsll", query = "SELECT m FROM Moventradaprod m WHERE m.valorcsll = :valorcsll")
    , @NamedQuery(name = "Moventradaprod.findByBaseii", query = "SELECT m FROM Moventradaprod m WHERE m.baseii = :baseii")
    , @NamedQuery(name = "Moventradaprod.findByAliqii", query = "SELECT m FROM Moventradaprod m WHERE m.aliqii = :aliqii")
    , @NamedQuery(name = "Moventradaprod.findByValorii", query = "SELECT m FROM Moventradaprod m WHERE m.valorii = :valorii")
    , @NamedQuery(name = "Moventradaprod.findByBasecofins", query = "SELECT m FROM Moventradaprod m WHERE m.basecofins = :basecofins")
    , @NamedQuery(name = "Moventradaprod.findByAliqcofins", query = "SELECT m FROM Moventradaprod m WHERE m.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Moventradaprod.findByValorcofins", query = "SELECT m FROM Moventradaprod m WHERE m.valorcofins = :valorcofins")
    , @NamedQuery(name = "Moventradaprod.findByBasepis", query = "SELECT m FROM Moventradaprod m WHERE m.basepis = :basepis")
    , @NamedQuery(name = "Moventradaprod.findByAliqpis", query = "SELECT m FROM Moventradaprod m WHERE m.aliqpis = :aliqpis")
    , @NamedQuery(name = "Moventradaprod.findByValorpis", query = "SELECT m FROM Moventradaprod m WHERE m.valorpis = :valorpis")
    , @NamedQuery(name = "Moventradaprod.findByAliqreducaobaseicms", query = "SELECT m FROM Moventradaprod m WHERE m.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "Moventradaprod.findByCodunidade", query = "SELECT m FROM Moventradaprod m WHERE m.codunidade = :codunidade")
    , @NamedQuery(name = "Moventradaprod.findByFatorconversao", query = "SELECT m FROM Moventradaprod m WHERE m.fatorconversao = :fatorconversao")
    , @NamedQuery(name = "Moventradaprod.findByNumeroecf", query = "SELECT m FROM Moventradaprod m WHERE m.numeroecf = :numeroecf")
    , @NamedQuery(name = "Moventradaprod.findByNumcupomdevolucao", query = "SELECT m FROM Moventradaprod m WHERE m.numcupomdevolucao = :numcupomdevolucao")
    , @NamedQuery(name = "Moventradaprod.findByDatacupomdevolucao", query = "SELECT m FROM Moventradaprod m WHERE m.datacupomdevolucao = :datacupomdevolucao")
    , @NamedQuery(name = "Moventradaprod.findByCstpis", query = "SELECT m FROM Moventradaprod m WHERE m.cstpis = :cstpis")
    , @NamedQuery(name = "Moventradaprod.findByCstcofins", query = "SELECT m FROM Moventradaprod m WHERE m.cstcofins = :cstcofins")
    , @NamedQuery(name = "Moventradaprod.findByCsosn", query = "SELECT m FROM Moventradaprod m WHERE m.csosn = :csosn")
    , @NamedQuery(name = "Moventradaprod.findByAliqcreditosimplesnacional", query = "SELECT m FROM Moventradaprod m WHERE m.aliqcreditosimplesnacional = :aliqcreditosimplesnacional")
    , @NamedQuery(name = "Moventradaprod.findByValorcreditosimplesnacional", query = "SELECT m FROM Moventradaprod m WHERE m.valorcreditosimplesnacional = :valorcreditosimplesnacional")
    , @NamedQuery(name = "Moventradaprod.findByValorabatimentonaotribicms", query = "SELECT m FROM Moventradaprod m WHERE m.valorabatimentonaotribicms = :valorabatimentonaotribicms")
    , @NamedQuery(name = "Moventradaprod.findByValorabatimentonaotribpis", query = "SELECT m FROM Moventradaprod m WHERE m.valorabatimentonaotribpis = :valorabatimentonaotribpis")
    , @NamedQuery(name = "Moventradaprod.findByValorabatimentonaotribcofins", query = "SELECT m FROM Moventradaprod m WHERE m.valorabatimentonaotribcofins = :valorabatimentonaotribcofins")
    , @NamedQuery(name = "Moventradaprod.findByValorabatimentonaotribipi", query = "SELECT m FROM Moventradaprod m WHERE m.valorabatimentonaotribipi = :valorabatimentonaotribipi")
    , @NamedQuery(name = "Moventradaprod.findByAliqicmsStUfDestino", query = "SELECT m FROM Moventradaprod m WHERE m.aliqicmsStUfDestino = :aliqicmsStUfDestino")
    , @NamedQuery(name = "Moventradaprod.findByNumeroserieecf", query = "SELECT m FROM Moventradaprod m WHERE m.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Moventradaprod.findByNumerocaixaecf", query = "SELECT m FROM Moventradaprod m WHERE m.numerocaixaecf = :numerocaixaecf")
    , @NamedQuery(name = "Moventradaprod.findByGuid", query = "SELECT m FROM Moventradaprod m WHERE m.guid = :guid")
    , @NamedQuery(name = "Moventradaprod.findByValorsubstantecipadarateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorsubstantecipadarateado = :valorsubstantecipadarateado")
    , @NamedQuery(name = "Moventradaprod.findByValorconhecimentotransrateado", query = "SELECT m FROM Moventradaprod m WHERE m.valorconhecimentotransrateado = :valorconhecimentotransrateado")
    , @NamedQuery(name = "Moventradaprod.findByValorfreteredespachorat", query = "SELECT m FROM Moventradaprod m WHERE m.valorfreteredespachorat = :valorfreteredespachorat")
    , @NamedQuery(name = "Moventradaprod.findByQuantidadeipi", query = "SELECT m FROM Moventradaprod m WHERE m.quantidadeipi = :quantidadeipi")
    , @NamedQuery(name = "Moventradaprod.findByValorunidadeipi", query = "SELECT m FROM Moventradaprod m WHERE m.valorunidadeipi = :valorunidadeipi")
    , @NamedQuery(name = "Moventradaprod.findByValoricmsincentfiscalrat", query = "SELECT m FROM Moventradaprod m WHERE m.valoricmsincentfiscalrat = :valoricmsincentfiscalrat")
    , @NamedQuery(name = "Moventradaprod.findByGuidmoventrada", query = "SELECT m FROM Moventradaprod m WHERE m.guidmoventrada = :guidmoventrada")
    , @NamedQuery(name = "Moventradaprod.findByCodcalculoicms", query = "SELECT m FROM Moventradaprod m WHERE m.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "Moventradaprod.findByNumcfesatdevolucao", query = "SELECT m FROM Moventradaprod m WHERE m.numcfesatdevolucao = :numcfesatdevolucao")
    , @NamedQuery(name = "Moventradaprod.findByDatacfesatdevolucao", query = "SELECT m FROM Moventradaprod m WHERE m.datacfesatdevolucao = :datacfesatdevolucao")
    , @NamedQuery(name = "Moventradaprod.findByChavecfe", query = "SELECT m FROM Moventradaprod m WHERE m.chavecfe = :chavecfe")
    , @NamedQuery(name = "Moventradaprod.findByNumeroseriesat", query = "SELECT m FROM Moventradaprod m WHERE m.numeroseriesat = :numeroseriesat")
    , @NamedQuery(name = "Moventradaprod.findByCodenquadramentoipi", query = "SELECT m FROM Moventradaprod m WHERE m.codenquadramentoipi = :codenquadramentoipi")
    , @NamedQuery(name = "Moventradaprod.findByValoraduaneiro", query = "SELECT m FROM Moventradaprod m WHERE m.valoraduaneiro = :valoraduaneiro")
    , @NamedQuery(name = "Moventradaprod.findByValorsiscomex", query = "SELECT m FROM Moventradaprod m WHERE m.valorsiscomex = :valorsiscomex")
    , @NamedQuery(name = "Moventradaprod.findByCodigomotivodeso", query = "SELECT m FROM Moventradaprod m WHERE m.codigomotivodeso = :codigomotivodeso")
    , @NamedQuery(name = "Moventradaprod.findByAliqfcp", query = "SELECT m FROM Moventradaprod m WHERE m.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Moventradaprod.findByValorfcp", query = "SELECT m FROM Moventradaprod m WHERE m.valorfcp = :valorfcp")
    , @NamedQuery(name = "Moventradaprod.findByValorfcpsubsttributaria", query = "SELECT m FROM Moventradaprod m WHERE m.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "Moventradaprod.findByAliqfcpStUfDestino", query = "SELECT m FROM Moventradaprod m WHERE m.aliqfcpStUfDestino = :aliqfcpStUfDestino")
    , @NamedQuery(name = "Moventradaprod.findByGtin", query = "SELECT m FROM Moventradaprod m WHERE m.gtin = :gtin")
    , @NamedQuery(name = "Moventradaprod.findByGtintrib", query = "SELECT m FROM Moventradaprod m WHERE m.gtintrib = :gtintrib")
    , @NamedQuery(name = "Moventradaprod.findByUnidadetrib", query = "SELECT m FROM Moventradaprod m WHERE m.unidadetrib = :unidadetrib")
    , @NamedQuery(name = "Moventradaprod.findByQuantidadeembalagemtrib", query = "SELECT m FROM Moventradaprod m WHERE m.quantidadeembalagemtrib = :quantidadeembalagemtrib")
    , @NamedQuery(name = "Moventradaprod.findByValoricmsoperacao", query = "SELECT m FROM Moventradaprod m WHERE m.valoricmsoperacao = :valoricmsoperacao")
    , @NamedQuery(name = "Moventradaprod.findByValoricmsdesonerado", query = "SELECT m FROM Moventradaprod m WHERE m.valoricmsdesonerado = :valoricmsdesonerado")
    , @NamedQuery(name = "Moventradaprod.findByAliqdiferimento", query = "SELECT m FROM Moventradaprod m WHERE m.aliqdiferimento = :aliqdiferimento")
    , @NamedQuery(name = "Moventradaprod.findByValoricmsdiferimento", query = "SELECT m FROM Moventradaprod m WHERE m.valoricmsdiferimento = :valoricmsdiferimento")
    , @NamedQuery(name = "Moventradaprod.findByCodbeneficiofiscal", query = "SELECT m FROM Moventradaprod m WHERE m.codbeneficiofiscal = :codbeneficiofiscal")})
public class Moventradaprod implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVEPROD")
    private String codmoveprod;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "QUANTIDADEEMBALAGEM")
    private BigDecimal quantidadeembalagem;
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "FLAGTIPOACRESCIMOITEM")
    private Character flagtipoacrescimoitem;
    @Column(name = "ALIQACRESCIMOITEM")
    private BigDecimal aliqacrescimoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "FLAGTIPODESCONTOITEM")
    private Character flagtipodescontoitem;
    @Column(name = "ALIQDESCONTOITEM")
    private BigDecimal aliqdescontoitem;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Basic(optional = false)
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "BASEIPI")
    private BigDecimal baseipi;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Basic(optional = false)
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "VALORIPI")
    private BigDecimal valoripi;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Basic(optional = false)
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @Column(name = "FLAGCOMPOSTO")
    private Character flagcomposto;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "CODMOEDA")
    private String codmoeda;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "VALORFRETERATEADO")
    private BigDecimal valorfreterateado;
    @Column(name = "VALORACRESCIMORATEADO")
    private BigDecimal valoracrescimorateado;
    @Column(name = "VALORDESCONTORATEADO")
    private BigDecimal valordescontorateado;
    @Column(name = "VALORSEGURORATEADO")
    private BigDecimal valorsegurorateado;
    @Column(name = "VALOROUTRASDESPRATEADO")
    private BigDecimal valoroutrasdesprateado;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Column(name = "CODCOR")
    private String codcor;
    @Column(name = "CODMOVPRODDEVOLUCAO")
    private String codmovproddevolucao;
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
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "CODUNIDADE")
    private String codunidade;
    @Column(name = "FATORCONVERSAO")
    private BigDecimal fatorconversao;
    @Column(name = "NUMEROECF")
    private String numeroecf;
    @Column(name = "NUMCUPOMDEVOLUCAO")
    private Integer numcupomdevolucao;
    @Column(name = "DATACUPOMDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date datacupomdevolucao;
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
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "NUMEROCAIXAECF")
    private Integer numerocaixaecf;
    @Column(name = "GUID")
    private String guid;
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
    @Column(name = "VALORICMSINCENTFISCALRAT")
    private BigDecimal valoricmsincentfiscalrat;
    @Column(name = "GUIDMOVENTRADA")
    private String guidmoventrada;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "NUMCFESATDEVOLUCAO")
    private Integer numcfesatdevolucao;
    @Column(name = "DATACFESATDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date datacfesatdevolucao;
    @Column(name = "CHAVECFE")
    private String chavecfe;
    @Column(name = "NUMEROSERIESAT")
    private String numeroseriesat;
    @Column(name = "CODENQUADRAMENTOIPI")
    private String codenquadramentoipi;
    @Column(name = "VALORADUANEIRO")
    private BigDecimal valoraduaneiro;
    @Column(name = "VALORSISCOMEX")
    private BigDecimal valorsiscomex;
    @Column(name = "CODIGOMOTIVODESO")
    private String codigomotivodeso;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "ALIQFCP_ST_UF_DESTINO")
    private BigDecimal aliqfcpStUfDestino;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "GTINTRIB")
    private String gtintrib;
    @Column(name = "UNIDADETRIB")
    private String unidadetrib;
    @Column(name = "QUANTIDADEEMBALAGEMTRIB")
    private BigDecimal quantidadeembalagemtrib;
    @Column(name = "VALORICMSOPERACAO")
    private BigDecimal valoricmsoperacao;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "ALIQDIFERIMENTO")
    private BigDecimal aliqdiferimento;
    @Column(name = "VALORICMSDIFERIMENTO")
    private BigDecimal valoricmsdiferimento;
    @Column(name = "CODBENEFICIOFISCAL")
    private String codbeneficiofiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoveprod")
    private Collection<Moventradaprodcomp> moventradaprodcompCollection;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODMOVENTR", referencedColumnName = "CODMOVENTR")
    @ManyToOne(optional = false)
    private Moventrada codmoventr;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne
    private Produto codprod;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoveprod")
    private Collection<Moventradaprodlote> moventradaprodloteCollection;
    @OneToMany(mappedBy = "codmoveprod")
    private Collection<Moventradaprodserial> moventradaprodserialCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoveprod")
    private Collection<Pedidoentrada> pedidoentradaCollection;
    @OneToMany(mappedBy = "codmoveprod")
    private Collection<Rma> rmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmoveprod")
    private Collection<Moventradaprodfci> moventradaprodfciCollection;
    @OneToMany(mappedBy = "codmoveprod")
    private Collection<OsOrdemservico> osOrdemservicoCollection;
    @OneToMany(mappedBy = "codmoveprod")
    private Collection<Vendedordesconto> vendedordescontoCollection;

    public Moventradaprod() {
    }

    public Moventradaprod(String codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Moventradaprod(String codmoveprod, BigDecimal quantidade, BigDecimal valortotal, BigDecimal aliqipi, BigDecimal aliqicms) {
        this.codmoveprod = codmoveprod;
        this.quantidade = quantidade;
        this.valortotal = valortotal;
        this.aliqipi = aliqipi;
        this.aliqicms = aliqicms;
    }

    public String getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(String codmoveprod) {
        String oldCodmoveprod = this.codmoveprod;
        this.codmoveprod = codmoveprod;
        changeSupport.firePropertyChange("codmoveprod", oldCodmoveprod, codmoveprod);
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        String oldComplemento = this.complemento;
        this.complemento = complemento;
        changeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        BigDecimal oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public BigDecimal getQuantidadeembalagem() {
        return quantidadeembalagem;
    }

    public void setQuantidadeembalagem(BigDecimal quantidadeembalagem) {
        BigDecimal oldQuantidadeembalagem = this.quantidadeembalagem;
        this.quantidadeembalagem = quantidadeembalagem;
        changeSupport.firePropertyChange("quantidadeembalagem", oldQuantidadeembalagem, quantidadeembalagem);
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        BigDecimal oldValorunitario = this.valorunitario;
        this.valorunitario = valorunitario;
        changeSupport.firePropertyChange("valorunitario", oldValorunitario, valorunitario);
    }

    public Character getFlagtipoacrescimoitem() {
        return flagtipoacrescimoitem;
    }

    public void setFlagtipoacrescimoitem(Character flagtipoacrescimoitem) {
        Character oldFlagtipoacrescimoitem = this.flagtipoacrescimoitem;
        this.flagtipoacrescimoitem = flagtipoacrescimoitem;
        changeSupport.firePropertyChange("flagtipoacrescimoitem", oldFlagtipoacrescimoitem, flagtipoacrescimoitem);
    }

    public BigDecimal getAliqacrescimoitem() {
        return aliqacrescimoitem;
    }

    public void setAliqacrescimoitem(BigDecimal aliqacrescimoitem) {
        BigDecimal oldAliqacrescimoitem = this.aliqacrescimoitem;
        this.aliqacrescimoitem = aliqacrescimoitem;
        changeSupport.firePropertyChange("aliqacrescimoitem", oldAliqacrescimoitem, aliqacrescimoitem);
    }

    public BigDecimal getValoracrescimoitem() {
        return valoracrescimoitem;
    }

    public void setValoracrescimoitem(BigDecimal valoracrescimoitem) {
        BigDecimal oldValoracrescimoitem = this.valoracrescimoitem;
        this.valoracrescimoitem = valoracrescimoitem;
        changeSupport.firePropertyChange("valoracrescimoitem", oldValoracrescimoitem, valoracrescimoitem);
    }

    public Character getFlagtipodescontoitem() {
        return flagtipodescontoitem;
    }

    public void setFlagtipodescontoitem(Character flagtipodescontoitem) {
        Character oldFlagtipodescontoitem = this.flagtipodescontoitem;
        this.flagtipodescontoitem = flagtipodescontoitem;
        changeSupport.firePropertyChange("flagtipodescontoitem", oldFlagtipodescontoitem, flagtipodescontoitem);
    }

    public BigDecimal getAliqdescontoitem() {
        return aliqdescontoitem;
    }

    public void setAliqdescontoitem(BigDecimal aliqdescontoitem) {
        BigDecimal oldAliqdescontoitem = this.aliqdescontoitem;
        this.aliqdescontoitem = aliqdescontoitem;
        changeSupport.firePropertyChange("aliqdescontoitem", oldAliqdescontoitem, aliqdescontoitem);
    }

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        BigDecimal oldValordescontoitem = this.valordescontoitem;
        this.valordescontoitem = valordescontoitem;
        changeSupport.firePropertyChange("valordescontoitem", oldValordescontoitem, valordescontoitem);
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        BigDecimal oldValortotal = this.valortotal;
        this.valortotal = valortotal;
        changeSupport.firePropertyChange("valortotal", oldValortotal, valortotal);
    }

    public BigDecimal getBaseipi() {
        return baseipi;
    }

    public void setBaseipi(BigDecimal baseipi) {
        BigDecimal oldBaseipi = this.baseipi;
        this.baseipi = baseipi;
        changeSupport.firePropertyChange("baseipi", oldBaseipi, baseipi);
    }

    public Character getFlagtipoipi() {
        return flagtipoipi;
    }

    public void setFlagtipoipi(Character flagtipoipi) {
        Character oldFlagtipoipi = this.flagtipoipi;
        this.flagtipoipi = flagtipoipi;
        changeSupport.firePropertyChange("flagtipoipi", oldFlagtipoipi, flagtipoipi);
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        BigDecimal oldAliqipi = this.aliqipi;
        this.aliqipi = aliqipi;
        changeSupport.firePropertyChange("aliqipi", oldAliqipi, aliqipi);
    }

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        BigDecimal oldValoripi = this.valoripi;
        this.valoripi = valoripi;
        changeSupport.firePropertyChange("valoripi", oldValoripi, valoripi);
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        BigDecimal oldBaseicms = this.baseicms;
        this.baseicms = baseicms;
        changeSupport.firePropertyChange("baseicms", oldBaseicms, baseicms);
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        BigDecimal oldAliqicms = this.aliqicms;
        this.aliqicms = aliqicms;
        changeSupport.firePropertyChange("aliqicms", oldAliqicms, aliqicms);
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        BigDecimal oldValoricms = this.valoricms;
        this.valoricms = valoricms;
        changeSupport.firePropertyChange("valoricms", oldValoricms, valoricms);
    }

    public Character getFlagtipoiss() {
        return flagtipoiss;
    }

    public void setFlagtipoiss(Character flagtipoiss) {
        Character oldFlagtipoiss = this.flagtipoiss;
        this.flagtipoiss = flagtipoiss;
        changeSupport.firePropertyChange("flagtipoiss", oldFlagtipoiss, flagtipoiss);
    }

    public BigDecimal getAliqiss() {
        return aliqiss;
    }

    public void setAliqiss(BigDecimal aliqiss) {
        BigDecimal oldAliqiss = this.aliqiss;
        this.aliqiss = aliqiss;
        changeSupport.firePropertyChange("aliqiss", oldAliqiss, aliqiss);
    }

    public BigDecimal getValoriss() {
        return valoriss;
    }

    public void setValoriss(BigDecimal valoriss) {
        BigDecimal oldValoriss = this.valoriss;
        this.valoriss = valoriss;
        changeSupport.firePropertyChange("valoriss", oldValoriss, valoriss);
    }

    public BigDecimal getBasesubsttributaria() {
        return basesubsttributaria;
    }

    public void setBasesubsttributaria(BigDecimal basesubsttributaria) {
        BigDecimal oldBasesubsttributaria = this.basesubsttributaria;
        this.basesubsttributaria = basesubsttributaria;
        changeSupport.firePropertyChange("basesubsttributaria", oldBasesubsttributaria, basesubsttributaria);
    }

    public BigDecimal getValorsubsttributaria() {
        return valorsubsttributaria;
    }

    public void setValorsubsttributaria(BigDecimal valorsubsttributaria) {
        BigDecimal oldValorsubsttributaria = this.valorsubsttributaria;
        this.valorsubsttributaria = valorsubsttributaria;
        changeSupport.firePropertyChange("valorsubsttributaria", oldValorsubsttributaria, valorsubsttributaria);
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        Character oldFlagorigemproduto = this.flagorigemproduto;
        this.flagorigemproduto = flagorigemproduto;
        changeSupport.firePropertyChange("flagorigemproduto", oldFlagorigemproduto, flagorigemproduto);
    }

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        String oldCodsituacaotributaria = this.codsituacaotributaria;
        this.codsituacaotributaria = codsituacaotributaria;
        changeSupport.firePropertyChange("codsituacaotributaria", oldCodsituacaotributaria, codsituacaotributaria);
    }

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        Character oldFlagcomposto = this.flagcomposto;
        this.flagcomposto = flagcomposto;
        changeSupport.firePropertyChange("flagcomposto", oldFlagcomposto, flagcomposto);
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        Date oldDatavalidade = this.datavalidade;
        this.datavalidade = datavalidade;
        changeSupport.firePropertyChange("datavalidade", oldDatavalidade, datavalidade);
    }

    public String getCodmoeda() {
        return codmoeda;
    }

    public void setCodmoeda(String codmoeda) {
        String oldCodmoeda = this.codmoeda;
        this.codmoeda = codmoeda;
        changeSupport.firePropertyChange("codmoeda", oldCodmoeda, codmoeda);
    }

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        String oldCodclassificacaofiscal = this.codclassificacaofiscal;
        this.codclassificacaofiscal = codclassificacaofiscal;
        changeSupport.firePropertyChange("codclassificacaofiscal", oldCodclassificacaofiscal, codclassificacaofiscal);
    }

    public BigDecimal getValorfreterateado() {
        return valorfreterateado;
    }

    public void setValorfreterateado(BigDecimal valorfreterateado) {
        BigDecimal oldValorfreterateado = this.valorfreterateado;
        this.valorfreterateado = valorfreterateado;
        changeSupport.firePropertyChange("valorfreterateado", oldValorfreterateado, valorfreterateado);
    }

    public BigDecimal getValoracrescimorateado() {
        return valoracrescimorateado;
    }

    public void setValoracrescimorateado(BigDecimal valoracrescimorateado) {
        BigDecimal oldValoracrescimorateado = this.valoracrescimorateado;
        this.valoracrescimorateado = valoracrescimorateado;
        changeSupport.firePropertyChange("valoracrescimorateado", oldValoracrescimorateado, valoracrescimorateado);
    }

    public BigDecimal getValordescontorateado() {
        return valordescontorateado;
    }

    public void setValordescontorateado(BigDecimal valordescontorateado) {
        BigDecimal oldValordescontorateado = this.valordescontorateado;
        this.valordescontorateado = valordescontorateado;
        changeSupport.firePropertyChange("valordescontorateado", oldValordescontorateado, valordescontorateado);
    }

    public BigDecimal getValorsegurorateado() {
        return valorsegurorateado;
    }

    public void setValorsegurorateado(BigDecimal valorsegurorateado) {
        BigDecimal oldValorsegurorateado = this.valorsegurorateado;
        this.valorsegurorateado = valorsegurorateado;
        changeSupport.firePropertyChange("valorsegurorateado", oldValorsegurorateado, valorsegurorateado);
    }

    public BigDecimal getValoroutrasdesprateado() {
        return valoroutrasdesprateado;
    }

    public void setValoroutrasdesprateado(BigDecimal valoroutrasdesprateado) {
        BigDecimal oldValoroutrasdesprateado = this.valoroutrasdesprateado;
        this.valoroutrasdesprateado = valoroutrasdesprateado;
        changeSupport.firePropertyChange("valoroutrasdesprateado", oldValoroutrasdesprateado, valoroutrasdesprateado);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public String getCodcor() {
        return codcor;
    }

    public void setCodcor(String codcor) {
        String oldCodcor = this.codcor;
        this.codcor = codcor;
        changeSupport.firePropertyChange("codcor", oldCodcor, codcor);
    }

    public String getCodmovproddevolucao() {
        return codmovproddevolucao;
    }

    public void setCodmovproddevolucao(String codmovproddevolucao) {
        String oldCodmovproddevolucao = this.codmovproddevolucao;
        this.codmovproddevolucao = codmovproddevolucao;
        changeSupport.firePropertyChange("codmovproddevolucao", oldCodmovproddevolucao, codmovproddevolucao);
    }

    public BigDecimal getAliqreducaobasesubsttributaria() {
        return aliqreducaobasesubsttributaria;
    }

    public void setAliqreducaobasesubsttributaria(BigDecimal aliqreducaobasesubsttributaria) {
        BigDecimal oldAliqreducaobasesubsttributaria = this.aliqreducaobasesubsttributaria;
        this.aliqreducaobasesubsttributaria = aliqreducaobasesubsttributaria;
        changeSupport.firePropertyChange("aliqreducaobasesubsttributaria", oldAliqreducaobasesubsttributaria, aliqreducaobasesubsttributaria);
    }

    public String getCodsituacaotributariaipi() {
        return codsituacaotributariaipi;
    }

    public void setCodsituacaotributariaipi(String codsituacaotributariaipi) {
        String oldCodsituacaotributariaipi = this.codsituacaotributariaipi;
        this.codsituacaotributariaipi = codsituacaotributariaipi;
        changeSupport.firePropertyChange("codsituacaotributariaipi", oldCodsituacaotributariaipi, codsituacaotributariaipi);
    }

    public BigDecimal getValorpisfreterateado() {
        return valorpisfreterateado;
    }

    public void setValorpisfreterateado(BigDecimal valorpisfreterateado) {
        BigDecimal oldValorpisfreterateado = this.valorpisfreterateado;
        this.valorpisfreterateado = valorpisfreterateado;
        changeSupport.firePropertyChange("valorpisfreterateado", oldValorpisfreterateado, valorpisfreterateado);
    }

    public BigDecimal getValorcofinsfreterateado() {
        return valorcofinsfreterateado;
    }

    public void setValorcofinsfreterateado(BigDecimal valorcofinsfreterateado) {
        BigDecimal oldValorcofinsfreterateado = this.valorcofinsfreterateado;
        this.valorcofinsfreterateado = valorcofinsfreterateado;
        changeSupport.firePropertyChange("valorcofinsfreterateado", oldValorcofinsfreterateado, valorcofinsfreterateado);
    }

    public BigDecimal getBaseirrf() {
        return baseirrf;
    }

    public void setBaseirrf(BigDecimal baseirrf) {
        BigDecimal oldBaseirrf = this.baseirrf;
        this.baseirrf = baseirrf;
        changeSupport.firePropertyChange("baseirrf", oldBaseirrf, baseirrf);
    }

    public BigDecimal getAliqirrf() {
        return aliqirrf;
    }

    public void setAliqirrf(BigDecimal aliqirrf) {
        BigDecimal oldAliqirrf = this.aliqirrf;
        this.aliqirrf = aliqirrf;
        changeSupport.firePropertyChange("aliqirrf", oldAliqirrf, aliqirrf);
    }

    public BigDecimal getValorirrf() {
        return valorirrf;
    }

    public void setValorirrf(BigDecimal valorirrf) {
        BigDecimal oldValorirrf = this.valorirrf;
        this.valorirrf = valorirrf;
        changeSupport.firePropertyChange("valorirrf", oldValorirrf, valorirrf);
    }

    public BigDecimal getBasecsll() {
        return basecsll;
    }

    public void setBasecsll(BigDecimal basecsll) {
        BigDecimal oldBasecsll = this.basecsll;
        this.basecsll = basecsll;
        changeSupport.firePropertyChange("basecsll", oldBasecsll, basecsll);
    }

    public BigDecimal getAliqcsll() {
        return aliqcsll;
    }

    public void setAliqcsll(BigDecimal aliqcsll) {
        BigDecimal oldAliqcsll = this.aliqcsll;
        this.aliqcsll = aliqcsll;
        changeSupport.firePropertyChange("aliqcsll", oldAliqcsll, aliqcsll);
    }

    public BigDecimal getValorcsll() {
        return valorcsll;
    }

    public void setValorcsll(BigDecimal valorcsll) {
        BigDecimal oldValorcsll = this.valorcsll;
        this.valorcsll = valorcsll;
        changeSupport.firePropertyChange("valorcsll", oldValorcsll, valorcsll);
    }

    public BigDecimal getBaseii() {
        return baseii;
    }

    public void setBaseii(BigDecimal baseii) {
        BigDecimal oldBaseii = this.baseii;
        this.baseii = baseii;
        changeSupport.firePropertyChange("baseii", oldBaseii, baseii);
    }

    public BigDecimal getAliqii() {
        return aliqii;
    }

    public void setAliqii(BigDecimal aliqii) {
        BigDecimal oldAliqii = this.aliqii;
        this.aliqii = aliqii;
        changeSupport.firePropertyChange("aliqii", oldAliqii, aliqii);
    }

    public BigDecimal getValorii() {
        return valorii;
    }

    public void setValorii(BigDecimal valorii) {
        BigDecimal oldValorii = this.valorii;
        this.valorii = valorii;
        changeSupport.firePropertyChange("valorii", oldValorii, valorii);
    }

    public BigDecimal getBasecofins() {
        return basecofins;
    }

    public void setBasecofins(BigDecimal basecofins) {
        BigDecimal oldBasecofins = this.basecofins;
        this.basecofins = basecofins;
        changeSupport.firePropertyChange("basecofins", oldBasecofins, basecofins);
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        BigDecimal oldAliqcofins = this.aliqcofins;
        this.aliqcofins = aliqcofins;
        changeSupport.firePropertyChange("aliqcofins", oldAliqcofins, aliqcofins);
    }

    public BigDecimal getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(BigDecimal valorcofins) {
        BigDecimal oldValorcofins = this.valorcofins;
        this.valorcofins = valorcofins;
        changeSupport.firePropertyChange("valorcofins", oldValorcofins, valorcofins);
    }

    public BigDecimal getBasepis() {
        return basepis;
    }

    public void setBasepis(BigDecimal basepis) {
        BigDecimal oldBasepis = this.basepis;
        this.basepis = basepis;
        changeSupport.firePropertyChange("basepis", oldBasepis, basepis);
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        BigDecimal oldAliqpis = this.aliqpis;
        this.aliqpis = aliqpis;
        changeSupport.firePropertyChange("aliqpis", oldAliqpis, aliqpis);
    }

    public BigDecimal getValorpis() {
        return valorpis;
    }

    public void setValorpis(BigDecimal valorpis) {
        BigDecimal oldValorpis = this.valorpis;
        this.valorpis = valorpis;
        changeSupport.firePropertyChange("valorpis", oldValorpis, valorpis);
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        BigDecimal oldAliqreducaobaseicms = this.aliqreducaobaseicms;
        this.aliqreducaobaseicms = aliqreducaobaseicms;
        changeSupport.firePropertyChange("aliqreducaobaseicms", oldAliqreducaobaseicms, aliqreducaobaseicms);
    }

    public String getCodunidade() {
        return codunidade;
    }

    public void setCodunidade(String codunidade) {
        String oldCodunidade = this.codunidade;
        this.codunidade = codunidade;
        changeSupport.firePropertyChange("codunidade", oldCodunidade, codunidade);
    }

    public BigDecimal getFatorconversao() {
        return fatorconversao;
    }

    public void setFatorconversao(BigDecimal fatorconversao) {
        BigDecimal oldFatorconversao = this.fatorconversao;
        this.fatorconversao = fatorconversao;
        changeSupport.firePropertyChange("fatorconversao", oldFatorconversao, fatorconversao);
    }

    public String getNumeroecf() {
        return numeroecf;
    }

    public void setNumeroecf(String numeroecf) {
        String oldNumeroecf = this.numeroecf;
        this.numeroecf = numeroecf;
        changeSupport.firePropertyChange("numeroecf", oldNumeroecf, numeroecf);
    }

    public Integer getNumcupomdevolucao() {
        return numcupomdevolucao;
    }

    public void setNumcupomdevolucao(Integer numcupomdevolucao) {
        Integer oldNumcupomdevolucao = this.numcupomdevolucao;
        this.numcupomdevolucao = numcupomdevolucao;
        changeSupport.firePropertyChange("numcupomdevolucao", oldNumcupomdevolucao, numcupomdevolucao);
    }

    public Date getDatacupomdevolucao() {
        return datacupomdevolucao;
    }

    public void setDatacupomdevolucao(Date datacupomdevolucao) {
        Date oldDatacupomdevolucao = this.datacupomdevolucao;
        this.datacupomdevolucao = datacupomdevolucao;
        changeSupport.firePropertyChange("datacupomdevolucao", oldDatacupomdevolucao, datacupomdevolucao);
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        String oldCstpis = this.cstpis;
        this.cstpis = cstpis;
        changeSupport.firePropertyChange("cstpis", oldCstpis, cstpis);
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        String oldCstcofins = this.cstcofins;
        this.cstcofins = cstcofins;
        changeSupport.firePropertyChange("cstcofins", oldCstcofins, cstcofins);
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        String oldCsosn = this.csosn;
        this.csosn = csosn;
        changeSupport.firePropertyChange("csosn", oldCsosn, csosn);
    }

    public BigDecimal getAliqcreditosimplesnacional() {
        return aliqcreditosimplesnacional;
    }

    public void setAliqcreditosimplesnacional(BigDecimal aliqcreditosimplesnacional) {
        BigDecimal oldAliqcreditosimplesnacional = this.aliqcreditosimplesnacional;
        this.aliqcreditosimplesnacional = aliqcreditosimplesnacional;
        changeSupport.firePropertyChange("aliqcreditosimplesnacional", oldAliqcreditosimplesnacional, aliqcreditosimplesnacional);
    }

    public BigDecimal getValorcreditosimplesnacional() {
        return valorcreditosimplesnacional;
    }

    public void setValorcreditosimplesnacional(BigDecimal valorcreditosimplesnacional) {
        BigDecimal oldValorcreditosimplesnacional = this.valorcreditosimplesnacional;
        this.valorcreditosimplesnacional = valorcreditosimplesnacional;
        changeSupport.firePropertyChange("valorcreditosimplesnacional", oldValorcreditosimplesnacional, valorcreditosimplesnacional);
    }

    public BigDecimal getValorabatimentonaotribicms() {
        return valorabatimentonaotribicms;
    }

    public void setValorabatimentonaotribicms(BigDecimal valorabatimentonaotribicms) {
        BigDecimal oldValorabatimentonaotribicms = this.valorabatimentonaotribicms;
        this.valorabatimentonaotribicms = valorabatimentonaotribicms;
        changeSupport.firePropertyChange("valorabatimentonaotribicms", oldValorabatimentonaotribicms, valorabatimentonaotribicms);
    }

    public BigDecimal getValorabatimentonaotribpis() {
        return valorabatimentonaotribpis;
    }

    public void setValorabatimentonaotribpis(BigDecimal valorabatimentonaotribpis) {
        BigDecimal oldValorabatimentonaotribpis = this.valorabatimentonaotribpis;
        this.valorabatimentonaotribpis = valorabatimentonaotribpis;
        changeSupport.firePropertyChange("valorabatimentonaotribpis", oldValorabatimentonaotribpis, valorabatimentonaotribpis);
    }

    public BigDecimal getValorabatimentonaotribcofins() {
        return valorabatimentonaotribcofins;
    }

    public void setValorabatimentonaotribcofins(BigDecimal valorabatimentonaotribcofins) {
        BigDecimal oldValorabatimentonaotribcofins = this.valorabatimentonaotribcofins;
        this.valorabatimentonaotribcofins = valorabatimentonaotribcofins;
        changeSupport.firePropertyChange("valorabatimentonaotribcofins", oldValorabatimentonaotribcofins, valorabatimentonaotribcofins);
    }

    public BigDecimal getValorabatimentonaotribipi() {
        return valorabatimentonaotribipi;
    }

    public void setValorabatimentonaotribipi(BigDecimal valorabatimentonaotribipi) {
        BigDecimal oldValorabatimentonaotribipi = this.valorabatimentonaotribipi;
        this.valorabatimentonaotribipi = valorabatimentonaotribipi;
        changeSupport.firePropertyChange("valorabatimentonaotribipi", oldValorabatimentonaotribipi, valorabatimentonaotribipi);
    }

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        BigDecimal oldAliqicmsStUfDestino = this.aliqicmsStUfDestino;
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
        changeSupport.firePropertyChange("aliqicmsStUfDestino", oldAliqicmsStUfDestino, aliqicmsStUfDestino);
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        String oldNumeroserieecf = this.numeroserieecf;
        this.numeroserieecf = numeroserieecf;
        changeSupport.firePropertyChange("numeroserieecf", oldNumeroserieecf, numeroserieecf);
    }

    public Integer getNumerocaixaecf() {
        return numerocaixaecf;
    }

    public void setNumerocaixaecf(Integer numerocaixaecf) {
        Integer oldNumerocaixaecf = this.numerocaixaecf;
        this.numerocaixaecf = numerocaixaecf;
        changeSupport.firePropertyChange("numerocaixaecf", oldNumerocaixaecf, numerocaixaecf);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        String oldGuid = this.guid;
        this.guid = guid;
        changeSupport.firePropertyChange("guid", oldGuid, guid);
    }

    public BigDecimal getValorsubstantecipadarateado() {
        return valorsubstantecipadarateado;
    }

    public void setValorsubstantecipadarateado(BigDecimal valorsubstantecipadarateado) {
        BigDecimal oldValorsubstantecipadarateado = this.valorsubstantecipadarateado;
        this.valorsubstantecipadarateado = valorsubstantecipadarateado;
        changeSupport.firePropertyChange("valorsubstantecipadarateado", oldValorsubstantecipadarateado, valorsubstantecipadarateado);
    }

    public BigDecimal getValorconhecimentotransrateado() {
        return valorconhecimentotransrateado;
    }

    public void setValorconhecimentotransrateado(BigDecimal valorconhecimentotransrateado) {
        BigDecimal oldValorconhecimentotransrateado = this.valorconhecimentotransrateado;
        this.valorconhecimentotransrateado = valorconhecimentotransrateado;
        changeSupport.firePropertyChange("valorconhecimentotransrateado", oldValorconhecimentotransrateado, valorconhecimentotransrateado);
    }

    public BigDecimal getValorfreteredespachorat() {
        return valorfreteredespachorat;
    }

    public void setValorfreteredespachorat(BigDecimal valorfreteredespachorat) {
        BigDecimal oldValorfreteredespachorat = this.valorfreteredespachorat;
        this.valorfreteredespachorat = valorfreteredespachorat;
        changeSupport.firePropertyChange("valorfreteredespachorat", oldValorfreteredespachorat, valorfreteredespachorat);
    }

    public BigDecimal getQuantidadeipi() {
        return quantidadeipi;
    }

    public void setQuantidadeipi(BigDecimal quantidadeipi) {
        BigDecimal oldQuantidadeipi = this.quantidadeipi;
        this.quantidadeipi = quantidadeipi;
        changeSupport.firePropertyChange("quantidadeipi", oldQuantidadeipi, quantidadeipi);
    }

    public BigDecimal getValorunidadeipi() {
        return valorunidadeipi;
    }

    public void setValorunidadeipi(BigDecimal valorunidadeipi) {
        BigDecimal oldValorunidadeipi = this.valorunidadeipi;
        this.valorunidadeipi = valorunidadeipi;
        changeSupport.firePropertyChange("valorunidadeipi", oldValorunidadeipi, valorunidadeipi);
    }

    public BigDecimal getValoricmsincentfiscalrat() {
        return valoricmsincentfiscalrat;
    }

    public void setValoricmsincentfiscalrat(BigDecimal valoricmsincentfiscalrat) {
        BigDecimal oldValoricmsincentfiscalrat = this.valoricmsincentfiscalrat;
        this.valoricmsincentfiscalrat = valoricmsincentfiscalrat;
        changeSupport.firePropertyChange("valoricmsincentfiscalrat", oldValoricmsincentfiscalrat, valoricmsincentfiscalrat);
    }

    public String getGuidmoventrada() {
        return guidmoventrada;
    }

    public void setGuidmoventrada(String guidmoventrada) {
        String oldGuidmoventrada = this.guidmoventrada;
        this.guidmoventrada = guidmoventrada;
        changeSupport.firePropertyChange("guidmoventrada", oldGuidmoventrada, guidmoventrada);
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        String oldCodcalculoicms = this.codcalculoicms;
        this.codcalculoicms = codcalculoicms;
        changeSupport.firePropertyChange("codcalculoicms", oldCodcalculoicms, codcalculoicms);
    }

    public Integer getNumcfesatdevolucao() {
        return numcfesatdevolucao;
    }

    public void setNumcfesatdevolucao(Integer numcfesatdevolucao) {
        Integer oldNumcfesatdevolucao = this.numcfesatdevolucao;
        this.numcfesatdevolucao = numcfesatdevolucao;
        changeSupport.firePropertyChange("numcfesatdevolucao", oldNumcfesatdevolucao, numcfesatdevolucao);
    }

    public Date getDatacfesatdevolucao() {
        return datacfesatdevolucao;
    }

    public void setDatacfesatdevolucao(Date datacfesatdevolucao) {
        Date oldDatacfesatdevolucao = this.datacfesatdevolucao;
        this.datacfesatdevolucao = datacfesatdevolucao;
        changeSupport.firePropertyChange("datacfesatdevolucao", oldDatacfesatdevolucao, datacfesatdevolucao);
    }

    public String getChavecfe() {
        return chavecfe;
    }

    public void setChavecfe(String chavecfe) {
        String oldChavecfe = this.chavecfe;
        this.chavecfe = chavecfe;
        changeSupport.firePropertyChange("chavecfe", oldChavecfe, chavecfe);
    }

    public String getNumeroseriesat() {
        return numeroseriesat;
    }

    public void setNumeroseriesat(String numeroseriesat) {
        String oldNumeroseriesat = this.numeroseriesat;
        this.numeroseriesat = numeroseriesat;
        changeSupport.firePropertyChange("numeroseriesat", oldNumeroseriesat, numeroseriesat);
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        String oldCodenquadramentoipi = this.codenquadramentoipi;
        this.codenquadramentoipi = codenquadramentoipi;
        changeSupport.firePropertyChange("codenquadramentoipi", oldCodenquadramentoipi, codenquadramentoipi);
    }

    public BigDecimal getValoraduaneiro() {
        return valoraduaneiro;
    }

    public void setValoraduaneiro(BigDecimal valoraduaneiro) {
        BigDecimal oldValoraduaneiro = this.valoraduaneiro;
        this.valoraduaneiro = valoraduaneiro;
        changeSupport.firePropertyChange("valoraduaneiro", oldValoraduaneiro, valoraduaneiro);
    }

    public BigDecimal getValorsiscomex() {
        return valorsiscomex;
    }

    public void setValorsiscomex(BigDecimal valorsiscomex) {
        BigDecimal oldValorsiscomex = this.valorsiscomex;
        this.valorsiscomex = valorsiscomex;
        changeSupport.firePropertyChange("valorsiscomex", oldValorsiscomex, valorsiscomex);
    }

    public String getCodigomotivodeso() {
        return codigomotivodeso;
    }

    public void setCodigomotivodeso(String codigomotivodeso) {
        String oldCodigomotivodeso = this.codigomotivodeso;
        this.codigomotivodeso = codigomotivodeso;
        changeSupport.firePropertyChange("codigomotivodeso", oldCodigomotivodeso, codigomotivodeso);
    }

    public BigDecimal getAliqfcp() {
        return aliqfcp;
    }

    public void setAliqfcp(BigDecimal aliqfcp) {
        BigDecimal oldAliqfcp = this.aliqfcp;
        this.aliqfcp = aliqfcp;
        changeSupport.firePropertyChange("aliqfcp", oldAliqfcp, aliqfcp);
    }

    public BigDecimal getValorfcp() {
        return valorfcp;
    }

    public void setValorfcp(BigDecimal valorfcp) {
        BigDecimal oldValorfcp = this.valorfcp;
        this.valorfcp = valorfcp;
        changeSupport.firePropertyChange("valorfcp", oldValorfcp, valorfcp);
    }

    public BigDecimal getValorfcpsubsttributaria() {
        return valorfcpsubsttributaria;
    }

    public void setValorfcpsubsttributaria(BigDecimal valorfcpsubsttributaria) {
        BigDecimal oldValorfcpsubsttributaria = this.valorfcpsubsttributaria;
        this.valorfcpsubsttributaria = valorfcpsubsttributaria;
        changeSupport.firePropertyChange("valorfcpsubsttributaria", oldValorfcpsubsttributaria, valorfcpsubsttributaria);
    }

    public BigDecimal getAliqfcpStUfDestino() {
        return aliqfcpStUfDestino;
    }

    public void setAliqfcpStUfDestino(BigDecimal aliqfcpStUfDestino) {
        BigDecimal oldAliqfcpStUfDestino = this.aliqfcpStUfDestino;
        this.aliqfcpStUfDestino = aliqfcpStUfDestino;
        changeSupport.firePropertyChange("aliqfcpStUfDestino", oldAliqfcpStUfDestino, aliqfcpStUfDestino);
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        String oldGtin = this.gtin;
        this.gtin = gtin;
        changeSupport.firePropertyChange("gtin", oldGtin, gtin);
    }

    public String getGtintrib() {
        return gtintrib;
    }

    public void setGtintrib(String gtintrib) {
        String oldGtintrib = this.gtintrib;
        this.gtintrib = gtintrib;
        changeSupport.firePropertyChange("gtintrib", oldGtintrib, gtintrib);
    }

    public String getUnidadetrib() {
        return unidadetrib;
    }

    public void setUnidadetrib(String unidadetrib) {
        String oldUnidadetrib = this.unidadetrib;
        this.unidadetrib = unidadetrib;
        changeSupport.firePropertyChange("unidadetrib", oldUnidadetrib, unidadetrib);
    }

    public BigDecimal getQuantidadeembalagemtrib() {
        return quantidadeembalagemtrib;
    }

    public void setQuantidadeembalagemtrib(BigDecimal quantidadeembalagemtrib) {
        BigDecimal oldQuantidadeembalagemtrib = this.quantidadeembalagemtrib;
        this.quantidadeembalagemtrib = quantidadeembalagemtrib;
        changeSupport.firePropertyChange("quantidadeembalagemtrib", oldQuantidadeembalagemtrib, quantidadeembalagemtrib);
    }

    public BigDecimal getValoricmsoperacao() {
        return valoricmsoperacao;
    }

    public void setValoricmsoperacao(BigDecimal valoricmsoperacao) {
        BigDecimal oldValoricmsoperacao = this.valoricmsoperacao;
        this.valoricmsoperacao = valoricmsoperacao;
        changeSupport.firePropertyChange("valoricmsoperacao", oldValoricmsoperacao, valoricmsoperacao);
    }

    public BigDecimal getValoricmsdesonerado() {
        return valoricmsdesonerado;
    }

    public void setValoricmsdesonerado(BigDecimal valoricmsdesonerado) {
        BigDecimal oldValoricmsdesonerado = this.valoricmsdesonerado;
        this.valoricmsdesonerado = valoricmsdesonerado;
        changeSupport.firePropertyChange("valoricmsdesonerado", oldValoricmsdesonerado, valoricmsdesonerado);
    }

    public BigDecimal getAliqdiferimento() {
        return aliqdiferimento;
    }

    public void setAliqdiferimento(BigDecimal aliqdiferimento) {
        BigDecimal oldAliqdiferimento = this.aliqdiferimento;
        this.aliqdiferimento = aliqdiferimento;
        changeSupport.firePropertyChange("aliqdiferimento", oldAliqdiferimento, aliqdiferimento);
    }

    public BigDecimal getValoricmsdiferimento() {
        return valoricmsdiferimento;
    }

    public void setValoricmsdiferimento(BigDecimal valoricmsdiferimento) {
        BigDecimal oldValoricmsdiferimento = this.valoricmsdiferimento;
        this.valoricmsdiferimento = valoricmsdiferimento;
        changeSupport.firePropertyChange("valoricmsdiferimento", oldValoricmsdiferimento, valoricmsdiferimento);
    }

    public String getCodbeneficiofiscal() {
        return codbeneficiofiscal;
    }

    public void setCodbeneficiofiscal(String codbeneficiofiscal) {
        String oldCodbeneficiofiscal = this.codbeneficiofiscal;
        this.codbeneficiofiscal = codbeneficiofiscal;
        changeSupport.firePropertyChange("codbeneficiofiscal", oldCodbeneficiofiscal, codbeneficiofiscal);
    }

    @XmlTransient
    public Collection<Moventradaprodcomp> getMoventradaprodcompCollection() {
        return moventradaprodcompCollection;
    }

    public void setMoventradaprodcompCollection(Collection<Moventradaprodcomp> moventradaprodcompCollection) {
        this.moventradaprodcompCollection = moventradaprodcompCollection;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        Cfop oldCodcfop = this.codcfop;
        this.codcfop = codcfop;
        changeSupport.firePropertyChange("codcfop", oldCodcfop, codcfop);
    }

    public Moventrada getCodmoventr() {
        return codmoventr;
    }

    public void setCodmoventr(Moventrada codmoventr) {
        Moventrada oldCodmoventr = this.codmoventr;
        this.codmoventr = codmoventr;
        changeSupport.firePropertyChange("codmoventr", oldCodmoventr, codmoventr);
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        Produto oldCodprod = this.codprod;
        this.codprod = codprod;
        changeSupport.firePropertyChange("codprod", oldCodprod, codprod);
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        Setorestoque oldCodsetorestoque = this.codsetorestoque;
        this.codsetorestoque = codsetorestoque;
        changeSupport.firePropertyChange("codsetorestoque", oldCodsetorestoque, codsetorestoque);
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        Vendedor oldCodvended = this.codvended;
        this.codvended = codvended;
        changeSupport.firePropertyChange("codvended", oldCodvended, codvended);
    }

    @XmlTransient
    public Collection<Moventradaprodlote> getMoventradaprodloteCollection() {
        return moventradaprodloteCollection;
    }

    public void setMoventradaprodloteCollection(Collection<Moventradaprodlote> moventradaprodloteCollection) {
        this.moventradaprodloteCollection = moventradaprodloteCollection;
    }

    @XmlTransient
    public Collection<Moventradaprodserial> getMoventradaprodserialCollection() {
        return moventradaprodserialCollection;
    }

    public void setMoventradaprodserialCollection(Collection<Moventradaprodserial> moventradaprodserialCollection) {
        this.moventradaprodserialCollection = moventradaprodserialCollection;
    }

    @XmlTransient
    public Collection<Pedidoentrada> getPedidoentradaCollection() {
        return pedidoentradaCollection;
    }

    public void setPedidoentradaCollection(Collection<Pedidoentrada> pedidoentradaCollection) {
        this.pedidoentradaCollection = pedidoentradaCollection;
    }

    @XmlTransient
    public Collection<Rma> getRmaCollection() {
        return rmaCollection;
    }

    public void setRmaCollection(Collection<Rma> rmaCollection) {
        this.rmaCollection = rmaCollection;
    }

    @XmlTransient
    public Collection<Moventradaprodfci> getMoventradaprodfciCollection() {
        return moventradaprodfciCollection;
    }

    public void setMoventradaprodfciCollection(Collection<Moventradaprodfci> moventradaprodfciCollection) {
        this.moventradaprodfciCollection = moventradaprodfciCollection;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @XmlTransient
    public Collection<Vendedordesconto> getVendedordescontoCollection() {
        return vendedordescontoCollection;
    }

    public void setVendedordescontoCollection(Collection<Vendedordesconto> vendedordescontoCollection) {
        this.vendedordescontoCollection = vendedordescontoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoveprod != null ? codmoveprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moventradaprod)) {
            return false;
        }
        Moventradaprod other = (Moventradaprod) object;
        if ((this.codmoveprod == null && other.codmoveprod != null) || (this.codmoveprod != null && !this.codmoveprod.equals(other.codmoveprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moventradaprod[ codmoveprod=" + codmoveprod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
