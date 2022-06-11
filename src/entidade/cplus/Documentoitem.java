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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "DOCUMENTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentoitem.findAll", query = "SELECT d FROM Documentoitem d")
    , @NamedQuery(name = "Documentoitem.findByCoddocumentoitem", query = "SELECT d FROM Documentoitem d WHERE d.coddocumentoitem = :coddocumentoitem")
    , @NamedQuery(name = "Documentoitem.findByIdentidadeorigem", query = "SELECT d FROM Documentoitem d WHERE d.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Documentoitem.findByNomeentidadeorigem", query = "SELECT d FROM Documentoitem d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documentoitem.findByValorunitario", query = "SELECT d FROM Documentoitem d WHERE d.valorunitario = :valorunitario")
    , @NamedQuery(name = "Documentoitem.findByAliqdescontoitem", query = "SELECT d FROM Documentoitem d WHERE d.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "Documentoitem.findByFlagtipodescontoitem", query = "SELECT d FROM Documentoitem d WHERE d.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "Documentoitem.findByValordescontoitem", query = "SELECT d FROM Documentoitem d WHERE d.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "Documentoitem.findByAliqacrescimoitem", query = "SELECT d FROM Documentoitem d WHERE d.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "Documentoitem.findByFlagtipoacrescimoitem", query = "SELECT d FROM Documentoitem d WHERE d.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "Documentoitem.findByValoracrescimoitem", query = "SELECT d FROM Documentoitem d WHERE d.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "Documentoitem.findByValortotal", query = "SELECT d FROM Documentoitem d WHERE d.valortotal = :valortotal")
    , @NamedQuery(name = "Documentoitem.findByValoripi", query = "SELECT d FROM Documentoitem d WHERE d.valoripi = :valoripi")
    , @NamedQuery(name = "Documentoitem.findByValoricms", query = "SELECT d FROM Documentoitem d WHERE d.valoricms = :valoricms")
    , @NamedQuery(name = "Documentoitem.findByBasesubsttributaria", query = "SELECT d FROM Documentoitem d WHERE d.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "Documentoitem.findByValorsubsttributaria", query = "SELECT d FROM Documentoitem d WHERE d.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "Documentoitem.findByValordescontorateado", query = "SELECT d FROM Documentoitem d WHERE d.valordescontorateado = :valordescontorateado")
    , @NamedQuery(name = "Documentoitem.findByValoracrescimorateado", query = "SELECT d FROM Documentoitem d WHERE d.valoracrescimorateado = :valoracrescimorateado")
    , @NamedQuery(name = "Documentoitem.findByValorsegurorateado", query = "SELECT d FROM Documentoitem d WHERE d.valorsegurorateado = :valorsegurorateado")
    , @NamedQuery(name = "Documentoitem.findByValoroutrasdesprateado", query = "SELECT d FROM Documentoitem d WHERE d.valoroutrasdesprateado = :valoroutrasdesprateado")
    , @NamedQuery(name = "Documentoitem.findByBaseicms", query = "SELECT d FROM Documentoitem d WHERE d.baseicms = :baseicms")
    , @NamedQuery(name = "Documentoitem.findByDinumerodocumento", query = "SELECT d FROM Documentoitem d WHERE d.dinumerodocumento = :dinumerodocumento")
    , @NamedQuery(name = "Documentoitem.findByDidataregistro", query = "SELECT d FROM Documentoitem d WHERE d.didataregistro = :didataregistro")
    , @NamedQuery(name = "Documentoitem.findByDilocaldesembaraco", query = "SELECT d FROM Documentoitem d WHERE d.dilocaldesembaraco = :dilocaldesembaraco")
    , @NamedQuery(name = "Documentoitem.findByDiufdesembaraco", query = "SELECT d FROM Documentoitem d WHERE d.diufdesembaraco = :diufdesembaraco")
    , @NamedQuery(name = "Documentoitem.findByDidatadesembaraco", query = "SELECT d FROM Documentoitem d WHERE d.didatadesembaraco = :didatadesembaraco")
    , @NamedQuery(name = "Documentoitem.findByDicodigoexportador", query = "SELECT d FROM Documentoitem d WHERE d.dicodigoexportador = :dicodigoexportador")
    , @NamedQuery(name = "Documentoitem.findByCodigolistaservico", query = "SELECT d FROM Documentoitem d WHERE d.codigolistaservico = :codigolistaservico")
    , @NamedQuery(name = "Documentoitem.findByCodsituacaotributariaipi", query = "SELECT d FROM Documentoitem d WHERE d.codsituacaotributariaipi = :codsituacaotributariaipi")
    , @NamedQuery(name = "Documentoitem.findByCodempresaestoque", query = "SELECT d FROM Documentoitem d WHERE d.codempresaestoque = :codempresaestoque")
    , @NamedQuery(name = "Documentoitem.findByCor", query = "SELECT d FROM Documentoitem d WHERE d.cor = :cor")
    , @NamedQuery(name = "Documentoitem.findByAliqicmsStUfDestino", query = "SELECT d FROM Documentoitem d WHERE d.aliqicmsStUfDestino = :aliqicmsStUfDestino")
    , @NamedQuery(name = "Documentoitem.findBySeriaisproduto", query = "SELECT d FROM Documentoitem d WHERE d.seriaisproduto = :seriaisproduto")
    , @NamedQuery(name = "Documentoitem.findByFlag1", query = "SELECT d FROM Documentoitem d WHERE d.flag1 = :flag1")
    , @NamedQuery(name = "Documentoitem.findByFlag2", query = "SELECT d FROM Documentoitem d WHERE d.flag2 = :flag2")
    , @NamedQuery(name = "Documentoitem.findByFlag3", query = "SELECT d FROM Documentoitem d WHERE d.flag3 = :flag3")
    , @NamedQuery(name = "Documentoitem.findByCodsetorestoque", query = "SELECT d FROM Documentoitem d WHERE d.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "Documentoitem.findByValorpisfreterateado", query = "SELECT d FROM Documentoitem d WHERE d.valorpisfreterateado = :valorpisfreterateado")
    , @NamedQuery(name = "Documentoitem.findByValorcofinsfreterateado", query = "SELECT d FROM Documentoitem d WHERE d.valorcofinsfreterateado = :valorcofinsfreterateado")
    , @NamedQuery(name = "Documentoitem.findByBaseirrf", query = "SELECT d FROM Documentoitem d WHERE d.baseirrf = :baseirrf")
    , @NamedQuery(name = "Documentoitem.findByAliqirrf", query = "SELECT d FROM Documentoitem d WHERE d.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "Documentoitem.findByValorirrf", query = "SELECT d FROM Documentoitem d WHERE d.valorirrf = :valorirrf")
    , @NamedQuery(name = "Documentoitem.findByBasecsll", query = "SELECT d FROM Documentoitem d WHERE d.basecsll = :basecsll")
    , @NamedQuery(name = "Documentoitem.findByAliqcsll", query = "SELECT d FROM Documentoitem d WHERE d.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "Documentoitem.findByValorcsll", query = "SELECT d FROM Documentoitem d WHERE d.valorcsll = :valorcsll")
    , @NamedQuery(name = "Documentoitem.findByBaseii", query = "SELECT d FROM Documentoitem d WHERE d.baseii = :baseii")
    , @NamedQuery(name = "Documentoitem.findByAliqii", query = "SELECT d FROM Documentoitem d WHERE d.aliqii = :aliqii")
    , @NamedQuery(name = "Documentoitem.findByValorii", query = "SELECT d FROM Documentoitem d WHERE d.valorii = :valorii")
    , @NamedQuery(name = "Documentoitem.findByBasecofins", query = "SELECT d FROM Documentoitem d WHERE d.basecofins = :basecofins")
    , @NamedQuery(name = "Documentoitem.findByAliqcofins", query = "SELECT d FROM Documentoitem d WHERE d.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Documentoitem.findByValorcofins", query = "SELECT d FROM Documentoitem d WHERE d.valorcofins = :valorcofins")
    , @NamedQuery(name = "Documentoitem.findByBasepis", query = "SELECT d FROM Documentoitem d WHERE d.basepis = :basepis")
    , @NamedQuery(name = "Documentoitem.findByAliqpis", query = "SELECT d FROM Documentoitem d WHERE d.aliqpis = :aliqpis")
    , @NamedQuery(name = "Documentoitem.findByValorpis", query = "SELECT d FROM Documentoitem d WHERE d.valorpis = :valorpis")
    , @NamedQuery(name = "Documentoitem.findByValortotalnotaitem", query = "SELECT d FROM Documentoitem d WHERE d.valortotalnotaitem = :valortotalnotaitem")
    , @NamedQuery(name = "Documentoitem.findByAliqicms", query = "SELECT d FROM Documentoitem d WHERE d.aliqicms = :aliqicms")
    , @NamedQuery(name = "Documentoitem.findByAliqipi", query = "SELECT d FROM Documentoitem d WHERE d.aliqipi = :aliqipi")
    , @NamedQuery(name = "Documentoitem.findByBaseipi", query = "SELECT d FROM Documentoitem d WHERE d.baseipi = :baseipi")
    , @NamedQuery(name = "Documentoitem.findByAliqiss", query = "SELECT d FROM Documentoitem d WHERE d.aliqiss = :aliqiss")
    , @NamedQuery(name = "Documentoitem.findByValoriss", query = "SELECT d FROM Documentoitem d WHERE d.valoriss = :valoriss")
    , @NamedQuery(name = "Documentoitem.findByCodclassificacaofiscal", query = "SELECT d FROM Documentoitem d WHERE d.codclassificacaofiscal = :codclassificacaofiscal")
    , @NamedQuery(name = "Documentoitem.findByCodcfop", query = "SELECT d FROM Documentoitem d WHERE d.codcfop = :codcfop")
    , @NamedQuery(name = "Documentoitem.findByCodsituacaotributaria", query = "SELECT d FROM Documentoitem d WHERE d.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "Documentoitem.findByValorfreterateado", query = "SELECT d FROM Documentoitem d WHERE d.valorfreterateado = :valorfreterateado")
    , @NamedQuery(name = "Documentoitem.findByComplemento", query = "SELECT d FROM Documentoitem d WHERE d.complemento = :complemento")
    , @NamedQuery(name = "Documentoitem.findByFlagtipoiss", query = "SELECT d FROM Documentoitem d WHERE d.flagtipoiss = :flagtipoiss")
    , @NamedQuery(name = "Documentoitem.findByFlagtipoipi", query = "SELECT d FROM Documentoitem d WHERE d.flagtipoipi = :flagtipoipi")
    , @NamedQuery(name = "Documentoitem.findByUnidade", query = "SELECT d FROM Documentoitem d WHERE d.unidade = :unidade")
    , @NamedQuery(name = "Documentoitem.findByFlagorigemproduto", query = "SELECT d FROM Documentoitem d WHERE d.flagorigemproduto = :flagorigemproduto")
    , @NamedQuery(name = "Documentoitem.findByAliqreducaobaseicms", query = "SELECT d FROM Documentoitem d WHERE d.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "Documentoitem.findByCodigoproduto", query = "SELECT d FROM Documentoitem d WHERE d.codigoproduto = :codigoproduto")
    , @NamedQuery(name = "Documentoitem.findByCodigoeanproduto", query = "SELECT d FROM Documentoitem d WHERE d.codigoeanproduto = :codigoeanproduto")
    , @NamedQuery(name = "Documentoitem.findByDescricaoproduto", query = "SELECT d FROM Documentoitem d WHERE d.descricaoproduto = :descricaoproduto")
    , @NamedQuery(name = "Documentoitem.findByDescricaocomplemento", query = "SELECT d FROM Documentoitem d WHERE d.descricaocomplemento = :descricaocomplemento")
    , @NamedQuery(name = "Documentoitem.findByQuantidade", query = "SELECT d FROM Documentoitem d WHERE d.quantidade = :quantidade")
    , @NamedQuery(name = "Documentoitem.findByFlagcontrolaserial", query = "SELECT d FROM Documentoitem d WHERE d.flagcontrolaserial = :flagcontrolaserial")
    , @NamedQuery(name = "Documentoitem.findByFlagcontrolalote", query = "SELECT d FROM Documentoitem d WHERE d.flagcontrolalote = :flagcontrolalote")
    , @NamedQuery(name = "Documentoitem.findByFlagservico", query = "SELECT d FROM Documentoitem d WHERE d.flagservico = :flagservico")
    , @NamedQuery(name = "Documentoitem.findByFlagcomposto", query = "SELECT d FROM Documentoitem d WHERE d.flagcomposto = :flagcomposto")
    , @NamedQuery(name = "Documentoitem.findByDatavalidade", query = "SELECT d FROM Documentoitem d WHERE d.datavalidade = :datavalidade")
    , @NamedQuery(name = "Documentoitem.findByPesoliquido", query = "SELECT d FROM Documentoitem d WHERE d.pesoliquido = :pesoliquido")
    , @NamedQuery(name = "Documentoitem.findByPesobruto", query = "SELECT d FROM Documentoitem d WHERE d.pesobruto = :pesobruto")
    , @NamedQuery(name = "Documentoitem.findByCodprod", query = "SELECT d FROM Documentoitem d WHERE d.codprod = :codprod")
    , @NamedQuery(name = "Documentoitem.findByCodcor", query = "SELECT d FROM Documentoitem d WHERE d.codcor = :codcor")
    , @NamedQuery(name = "Documentoitem.findByPrazogarantia", query = "SELECT d FROM Documentoitem d WHERE d.prazogarantia = :prazogarantia")
    , @NamedQuery(name = "Documentoitem.findByNumeroecf", query = "SELECT d FROM Documentoitem d WHERE d.numeroecf = :numeroecf")
    , @NamedQuery(name = "Documentoitem.findByNumcupomdevolucao", query = "SELECT d FROM Documentoitem d WHERE d.numcupomdevolucao = :numcupomdevolucao")
    , @NamedQuery(name = "Documentoitem.findByDatacupomdevolucao", query = "SELECT d FROM Documentoitem d WHERE d.datacupomdevolucao = :datacupomdevolucao")
    , @NamedQuery(name = "Documentoitem.findByCstpis", query = "SELECT d FROM Documentoitem d WHERE d.cstpis = :cstpis")
    , @NamedQuery(name = "Documentoitem.findByCstcofins", query = "SELECT d FROM Documentoitem d WHERE d.cstcofins = :cstcofins")
    , @NamedQuery(name = "Documentoitem.findByCsosn", query = "SELECT d FROM Documentoitem d WHERE d.csosn = :csosn")
    , @NamedQuery(name = "Documentoitem.findByAliqcreditosimplesnacional", query = "SELECT d FROM Documentoitem d WHERE d.aliqcreditosimplesnacional = :aliqcreditosimplesnacional")
    , @NamedQuery(name = "Documentoitem.findByValorcreditosimplesnacional", query = "SELECT d FROM Documentoitem d WHERE d.valorcreditosimplesnacional = :valorcreditosimplesnacional")
    , @NamedQuery(name = "Documentoitem.findByDescricaoclassificacaofiscal", query = "SELECT d FROM Documentoitem d WHERE d.descricaoclassificacaofiscal = :descricaoclassificacaofiscal")
    , @NamedQuery(name = "Documentoitem.findByValorabatimentonaotribicms", query = "SELECT d FROM Documentoitem d WHERE d.valorabatimentonaotribicms = :valorabatimentonaotribicms")
    , @NamedQuery(name = "Documentoitem.findByValorabatimentonaotribpis", query = "SELECT d FROM Documentoitem d WHERE d.valorabatimentonaotribpis = :valorabatimentonaotribpis")
    , @NamedQuery(name = "Documentoitem.findByValorabatimentonaotribcofins", query = "SELECT d FROM Documentoitem d WHERE d.valorabatimentonaotribcofins = :valorabatimentonaotribcofins")
    , @NamedQuery(name = "Documentoitem.findByValorabatimentonaotribipi", query = "SELECT d FROM Documentoitem d WHERE d.valorabatimentonaotribipi = :valorabatimentonaotribipi")
    , @NamedQuery(name = "Documentoitem.findByValorpisdesonerado", query = "SELECT d FROM Documentoitem d WHERE d.valorpisdesonerado = :valorpisdesonerado")
    , @NamedQuery(name = "Documentoitem.findByValorcofinsdesonerado", query = "SELECT d FROM Documentoitem d WHERE d.valorcofinsdesonerado = :valorcofinsdesonerado")
    , @NamedQuery(name = "Documentoitem.findByValoricmsdesonerado", query = "SELECT d FROM Documentoitem d WHERE d.valoricmsdesonerado = :valoricmsdesonerado")
    , @NamedQuery(name = "Documentoitem.findByBaseicmsdeduzido", query = "SELECT d FROM Documentoitem d WHERE d.baseicmsdeduzido = :baseicmsdeduzido")
    , @NamedQuery(name = "Documentoitem.findByCodigoean", query = "SELECT d FROM Documentoitem d WHERE d.codigoean = :codigoean")
    , @NamedQuery(name = "Documentoitem.findByCodigoanp", query = "SELECT d FROM Documentoitem d WHERE d.codigoanp = :codigoanp")
    , @NamedQuery(name = "Documentoitem.findByQuantidadeipi", query = "SELECT d FROM Documentoitem d WHERE d.quantidadeipi = :quantidadeipi")
    , @NamedQuery(name = "Documentoitem.findByValorunidadeipi", query = "SELECT d FROM Documentoitem d WHERE d.valorunidadeipi = :valorunidadeipi")
    , @NamedQuery(name = "Documentoitem.findByNumeropedidoforn", query = "SELECT d FROM Documentoitem d WHERE d.numeropedidoforn = :numeropedidoforn")
    , @NamedQuery(name = "Documentoitem.findByNumeroitempedidoforn", query = "SELECT d FROM Documentoitem d WHERE d.numeroitempedidoforn = :numeroitempedidoforn")
    , @NamedQuery(name = "Documentoitem.findByProdutoperigoso", query = "SELECT d FROM Documentoitem d WHERE d.produtoperigoso = :produtoperigoso")
    , @NamedQuery(name = "Documentoitem.findByDiviatransp", query = "SELECT d FROM Documentoitem d WHERE d.diviatransp = :diviatransp")
    , @NamedQuery(name = "Documentoitem.findByDivalorafrmm", query = "SELECT d FROM Documentoitem d WHERE d.divalorafrmm = :divalorafrmm")
    , @NamedQuery(name = "Documentoitem.findByDiformaimp", query = "SELECT d FROM Documentoitem d WHERE d.diformaimp = :diformaimp")
    , @NamedQuery(name = "Documentoitem.findByDicnpj", query = "SELECT d FROM Documentoitem d WHERE d.dicnpj = :dicnpj")
    , @NamedQuery(name = "Documentoitem.findByDiufadqenc", query = "SELECT d FROM Documentoitem d WHERE d.diufadqenc = :diufadqenc")
    , @NamedQuery(name = "Documentoitem.findByDenumdrawback", query = "SELECT d FROM Documentoitem d WHERE d.denumdrawback = :denumdrawback")
    , @NamedQuery(name = "Documentoitem.findByDenre", query = "SELECT d FROM Documentoitem d WHERE d.denre = :denre")
    , @NamedQuery(name = "Documentoitem.findByDechavenfe", query = "SELECT d FROM Documentoitem d WHERE d.dechavenfe = :dechavenfe")
    , @NamedQuery(name = "Documentoitem.findByDeqexport", query = "SELECT d FROM Documentoitem d WHERE d.deqexport = :deqexport")
    , @NamedQuery(name = "Documentoitem.findByCodcalculoicms", query = "SELECT d FROM Documentoitem d WHERE d.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "Documentoitem.findByNumcfesatdevolucao", query = "SELECT d FROM Documentoitem d WHERE d.numcfesatdevolucao = :numcfesatdevolucao")
    , @NamedQuery(name = "Documentoitem.findByDatacfesatdevolucao", query = "SELECT d FROM Documentoitem d WHERE d.datacfesatdevolucao = :datacfesatdevolucao")
    , @NamedQuery(name = "Documentoitem.findByChavecfe", query = "SELECT d FROM Documentoitem d WHERE d.chavecfe = :chavecfe")
    , @NamedQuery(name = "Documentoitem.findByCodcesticms", query = "SELECT d FROM Documentoitem d WHERE d.codcesticms = :codcesticms")
    , @NamedQuery(name = "Documentoitem.findByCodenquadramentoipi", query = "SELECT d FROM Documentoitem d WHERE d.codenquadramentoipi = :codenquadramentoipi")
    , @NamedQuery(name = "Documentoitem.findByFci", query = "SELECT d FROM Documentoitem d WHERE d.fci = :fci")
    , @NamedQuery(name = "Documentoitem.findByBasesubsttributariaret", query = "SELECT d FROM Documentoitem d WHERE d.basesubsttributariaret = :basesubsttributariaret")
    , @NamedQuery(name = "Documentoitem.findByValorsubsttributariaret", query = "SELECT d FROM Documentoitem d WHERE d.valorsubsttributariaret = :valorsubsttributariaret")
    , @NamedQuery(name = "Documentoitem.findByCodigodesoneracao", query = "SELECT d FROM Documentoitem d WHERE d.codigodesoneracao = :codigodesoneracao")
    , @NamedQuery(name = "Documentoitem.findByCodigoeantrib", query = "SELECT d FROM Documentoitem d WHERE d.codigoeantrib = :codigoeantrib")
    , @NamedQuery(name = "Documentoitem.findByUnidadetrib", query = "SELECT d FROM Documentoitem d WHERE d.unidadetrib = :unidadetrib")
    , @NamedQuery(name = "Documentoitem.findByQuantidadetrib", query = "SELECT d FROM Documentoitem d WHERE d.quantidadetrib = :quantidadetrib")
    , @NamedQuery(name = "Documentoitem.findByValorunitariotrib", query = "SELECT d FROM Documentoitem d WHERE d.valorunitariotrib = :valorunitariotrib")
    , @NamedQuery(name = "Documentoitem.findByValoricmsoperacao", query = "SELECT d FROM Documentoitem d WHERE d.valoricmsoperacao = :valoricmsoperacao")
    , @NamedQuery(name = "Documentoitem.findByAliqdiferimento", query = "SELECT d FROM Documentoitem d WHERE d.aliqdiferimento = :aliqdiferimento")
    , @NamedQuery(name = "Documentoitem.findByValoricmsdiferimento", query = "SELECT d FROM Documentoitem d WHERE d.valoricmsdiferimento = :valoricmsdiferimento")
    , @NamedQuery(name = "Documentoitem.findByTributofederal", query = "SELECT d FROM Documentoitem d WHERE d.tributofederal = :tributofederal")
    , @NamedQuery(name = "Documentoitem.findByTributoestadual", query = "SELECT d FROM Documentoitem d WHERE d.tributoestadual = :tributoestadual")
    , @NamedQuery(name = "Documentoitem.findByTributomunicipal", query = "SELECT d FROM Documentoitem d WHERE d.tributomunicipal = :tributomunicipal")
    , @NamedQuery(name = "Documentoitem.findByDescprodutoanp", query = "SELECT d FROM Documentoitem d WHERE d.descprodutoanp = :descprodutoanp")
    , @NamedQuery(name = "Documentoitem.findByAliqfcp", query = "SELECT d FROM Documentoitem d WHERE d.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "Documentoitem.findByValorfcp", query = "SELECT d FROM Documentoitem d WHERE d.valorfcp = :valorfcp")
    , @NamedQuery(name = "Documentoitem.findByValorfcpsubsttributaria", query = "SELECT d FROM Documentoitem d WHERE d.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "Documentoitem.findByAliqfcpStUfDestino", query = "SELECT d FROM Documentoitem d WHERE d.aliqfcpStUfDestino = :aliqfcpStUfDestino")
    , @NamedQuery(name = "Documentoitem.findByAliqreducaobasesubsttributaria", query = "SELECT d FROM Documentoitem d WHERE d.aliqreducaobasesubsttributaria = :aliqreducaobasesubsttributaria")
    , @NamedQuery(name = "Documentoitem.findByAliqmva", query = "SELECT d FROM Documentoitem d WHERE d.aliqmva = :aliqmva")
    , @NamedQuery(name = "Documentoitem.findByPercdevolvido", query = "SELECT d FROM Documentoitem d WHERE d.percdevolvido = :percdevolvido")
    , @NamedQuery(name = "Documentoitem.findByValoripidevolvido", query = "SELECT d FROM Documentoitem d WHERE d.valoripidevolvido = :valoripidevolvido")
    , @NamedQuery(name = "Documentoitem.findByFlagloterastreavel", query = "SELECT d FROM Documentoitem d WHERE d.flagloterastreavel = :flagloterastreavel")
    , @NamedQuery(name = "Documentoitem.findByGtintrib", query = "SELECT d FROM Documentoitem d WHERE d.gtintrib = :gtintrib")
    , @NamedQuery(name = "Documentoitem.findByQuantidadeembalagem", query = "SELECT d FROM Documentoitem d WHERE d.quantidadeembalagem = :quantidadeembalagem")
    , @NamedQuery(name = "Documentoitem.findByAliqreducaobaseicmsefetivo", query = "SELECT d FROM Documentoitem d WHERE d.aliqreducaobaseicmsefetivo = :aliqreducaobaseicmsefetivo")
    , @NamedQuery(name = "Documentoitem.findByBaseicmsefetivo", query = "SELECT d FROM Documentoitem d WHERE d.baseicmsefetivo = :baseicmsefetivo")
    , @NamedQuery(name = "Documentoitem.findByAliqicmsefetivo", query = "SELECT d FROM Documentoitem d WHERE d.aliqicmsefetivo = :aliqicmsefetivo")
    , @NamedQuery(name = "Documentoitem.findByValoricmsefetivo", query = "SELECT d FROM Documentoitem d WHERE d.valoricmsefetivo = :valoricmsefetivo")
    , @NamedQuery(name = "Documentoitem.findByBasesubsttributariadestino", query = "SELECT d FROM Documentoitem d WHERE d.basesubsttributariadestino = :basesubsttributariadestino")
    , @NamedQuery(name = "Documentoitem.findByValorsubsttributariadestino", query = "SELECT d FROM Documentoitem d WHERE d.valorsubsttributariadestino = :valorsubsttributariadestino")
    , @NamedQuery(name = "Documentoitem.findByAliqicmsstconsumidor", query = "SELECT d FROM Documentoitem d WHERE d.aliqicmsstconsumidor = :aliqicmsstconsumidor")
    , @NamedQuery(name = "Documentoitem.findByBaseicmsstfcpret", query = "SELECT d FROM Documentoitem d WHERE d.baseicmsstfcpret = :baseicmsstfcpret")
    , @NamedQuery(name = "Documentoitem.findByAliqfcpStRet", query = "SELECT d FROM Documentoitem d WHERE d.aliqfcpStRet = :aliqfcpStRet")
    , @NamedQuery(name = "Documentoitem.findByValorfcpstret", query = "SELECT d FROM Documentoitem d WHERE d.valorfcpstret = :valorfcpstret")
    , @NamedQuery(name = "Documentoitem.findByValoricmsstsubstituto", query = "SELECT d FROM Documentoitem d WHERE d.valoricmsstsubstituto = :valoricmsstsubstituto")
    , @NamedQuery(name = "Documentoitem.findByCodbeneficiofiscal", query = "SELECT d FROM Documentoitem d WHERE d.codbeneficiofiscal = :codbeneficiofiscal")})
public class Documentoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTOITEM")
    private String coddocumentoitem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORUNITARIO")
    private BigDecimal valorunitario;
    @Column(name = "ALIQDESCONTOITEM")
    private BigDecimal aliqdescontoitem;
    @Column(name = "FLAGTIPODESCONTOITEM")
    private Character flagtipodescontoitem;
    @Column(name = "VALORDESCONTOITEM")
    private BigDecimal valordescontoitem;
    @Column(name = "ALIQACRESCIMOITEM")
    private BigDecimal aliqacrescimoitem;
    @Column(name = "FLAGTIPOACRESCIMOITEM")
    private Character flagtipoacrescimoitem;
    @Column(name = "VALORACRESCIMOITEM")
    private BigDecimal valoracrescimoitem;
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "VALORIPI")
    private BigDecimal valoripi;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORDESCONTORATEADO")
    private BigDecimal valordescontorateado;
    @Column(name = "VALORACRESCIMORATEADO")
    private BigDecimal valoracrescimorateado;
    @Column(name = "VALORSEGURORATEADO")
    private BigDecimal valorsegurorateado;
    @Column(name = "VALOROUTRASDESPRATEADO")
    private BigDecimal valoroutrasdesprateado;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "DINUMERODOCUMENTO")
    private String dinumerodocumento;
    @Column(name = "DIDATAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date didataregistro;
    @Column(name = "DILOCALDESEMBARACO")
    private String dilocaldesembaraco;
    @Column(name = "DIUFDESEMBARACO")
    private String diufdesembaraco;
    @Column(name = "DIDATADESEMBARACO")
    @Temporal(TemporalType.DATE)
    private Date didatadesembaraco;
    @Column(name = "DICODIGOEXPORTADOR")
    private String dicodigoexportador;
    @Column(name = "CODIGOLISTASERVICO")
    private String codigolistaservico;
    @Column(name = "CODSITUACAOTRIBUTARIAIPI")
    private String codsituacaotributariaipi;
    @Column(name = "CODEMPRESAESTOQUE")
    private Integer codempresaestoque;
    @Column(name = "COR")
    private String cor;
    @Column(name = "ALIQICMS_ST_UF_DESTINO")
    private BigDecimal aliqicmsStUfDestino;
    @Column(name = "SERIAISPRODUTO")
    private String seriaisproduto;
    @Column(name = "FLAG1")
    private Character flag1;
    @Column(name = "FLAG2")
    private Character flag2;
    @Column(name = "FLAG3")
    private Character flag3;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
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
    @Column(name = "VALORTOTALNOTAITEM")
    private BigDecimal valortotalnotaitem;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "BASEIPI")
    private BigDecimal baseipi;
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @Column(name = "VALORFRETERATEADO")
    private BigDecimal valorfreterateado;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "FLAGTIPOISS")
    private Character flagtipoiss;
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Column(name = "UNIDADE")
    private String unidade;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "CODIGOPRODUTO")
    private String codigoproduto;
    @Column(name = "CODIGOEANPRODUTO")
    private String codigoeanproduto;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "DESCRICAOCOMPLEMENTO")
    private String descricaocomplemento;
    @Lob
    @Column(name = "OBSERVACOESPRODUTO")
    private String observacoesproduto;
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "FLAGCONTROLASERIAL")
    private Character flagcontrolaserial;
    @Column(name = "FLAGCONTROLALOTE")
    private Character flagcontrolalote;
    @Column(name = "FLAGSERVICO")
    private Character flagservico;
    @Column(name = "FLAGCOMPOSTO")
    private Character flagcomposto;
    @Column(name = "DATAVALIDADE")
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "CODCOR")
    private String codcor;
    @Column(name = "PRAZOGARANTIA")
    private Integer prazogarantia;
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
    @Column(name = "DESCRICAOCLASSIFICACAOFISCAL")
    private String descricaoclassificacaofiscal;
    @Column(name = "VALORABATIMENTONAOTRIBICMS")
    private BigDecimal valorabatimentonaotribicms;
    @Column(name = "VALORABATIMENTONAOTRIBPIS")
    private BigDecimal valorabatimentonaotribpis;
    @Column(name = "VALORABATIMENTONAOTRIBCOFINS")
    private BigDecimal valorabatimentonaotribcofins;
    @Column(name = "VALORABATIMENTONAOTRIBIPI")
    private BigDecimal valorabatimentonaotribipi;
    @Column(name = "VALORPISDESONERADO")
    private BigDecimal valorpisdesonerado;
    @Column(name = "VALORCOFINSDESONERADO")
    private BigDecimal valorcofinsdesonerado;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "BASEICMSDEDUZIDO")
    private BigDecimal baseicmsdeduzido;
    @Column(name = "CODIGOEAN")
    private String codigoean;
    @Column(name = "CODIGOANP")
    private String codigoanp;
    @Column(name = "QUANTIDADEIPI")
    private BigDecimal quantidadeipi;
    @Column(name = "VALORUNIDADEIPI")
    private BigDecimal valorunidadeipi;
    @Column(name = "NUMEROPEDIDOFORN")
    private String numeropedidoforn;
    @Column(name = "NUMEROITEMPEDIDOFORN")
    private String numeroitempedidoforn;
    @Column(name = "PRODUTOPERIGOSO")
    private Character produtoperigoso;
    @Column(name = "DIVIATRANSP")
    private String diviatransp;
    @Column(name = "DIVALORAFRMM")
    private BigDecimal divalorafrmm;
    @Column(name = "DIFORMAIMP")
    private Character diformaimp;
    @Column(name = "DICNPJ")
    private String dicnpj;
    @Column(name = "DIUFADQENC")
    private String diufadqenc;
    @Column(name = "DENUMDRAWBACK")
    private String denumdrawback;
    @Column(name = "DENRE")
    private String denre;
    @Column(name = "DECHAVENFE")
    private String dechavenfe;
    @Column(name = "DEQEXPORT")
    private BigDecimal deqexport;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "NUMCFESATDEVOLUCAO")
    private Integer numcfesatdevolucao;
    @Column(name = "DATACFESATDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date datacfesatdevolucao;
    @Column(name = "CHAVECFE")
    private String chavecfe;
    @Column(name = "CODCESTICMS")
    private String codcesticms;
    @Column(name = "CODENQUADRAMENTOIPI")
    private String codenquadramentoipi;
    @Column(name = "FCI")
    private String fci;
    @Column(name = "BASESUBSTTRIBUTARIARET")
    private BigDecimal basesubsttributariaret;
    @Column(name = "VALORSUBSTTRIBUTARIARET")
    private BigDecimal valorsubsttributariaret;
    @Column(name = "CODIGODESONERACAO")
    private String codigodesoneracao;
    @Column(name = "CODIGOEANTRIB")
    private String codigoeantrib;
    @Column(name = "UNIDADETRIB")
    private String unidadetrib;
    @Column(name = "QUANTIDADETRIB")
    private BigDecimal quantidadetrib;
    @Column(name = "VALORUNITARIOTRIB")
    private BigDecimal valorunitariotrib;
    @Column(name = "VALORICMSOPERACAO")
    private BigDecimal valoricmsoperacao;
    @Column(name = "ALIQDIFERIMENTO")
    private BigDecimal aliqdiferimento;
    @Column(name = "VALORICMSDIFERIMENTO")
    private BigDecimal valoricmsdiferimento;
    @Column(name = "TRIBUTOFEDERAL")
    private BigDecimal tributofederal;
    @Column(name = "TRIBUTOESTADUAL")
    private BigDecimal tributoestadual;
    @Column(name = "TRIBUTOMUNICIPAL")
    private BigDecimal tributomunicipal;
    @Column(name = "DESCPRODUTOANP")
    private String descprodutoanp;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "ALIQFCP_ST_UF_DESTINO")
    private BigDecimal aliqfcpStUfDestino;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBUTARIA")
    private BigDecimal aliqreducaobasesubsttributaria;
    @Column(name = "ALIQMVA")
    private BigDecimal aliqmva;
    @Column(name = "PERCDEVOLVIDO")
    private BigDecimal percdevolvido;
    @Column(name = "VALORIPIDEVOLVIDO")
    private BigDecimal valoripidevolvido;
    @Column(name = "FLAGLOTERASTREAVEL")
    private Character flagloterastreavel;
    @Column(name = "GTINTRIB")
    private String gtintrib;
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
    @Column(name = "BASESUBSTTRIBUTARIADESTINO")
    private BigDecimal basesubsttributariadestino;
    @Column(name = "VALORSUBSTTRIBUTARIADESTINO")
    private BigDecimal valorsubsttributariadestino;
    @Column(name = "ALIQICMSSTCONSUMIDOR")
    private BigDecimal aliqicmsstconsumidor;
    @Column(name = "BASEICMSSTFCPRET")
    private BigDecimal baseicmsstfcpret;
    @Column(name = "ALIQFCP_ST_RET")
    private BigDecimal aliqfcpStRet;
    @Column(name = "VALORFCPSTRET")
    private BigDecimal valorfcpstret;
    @Column(name = "VALORICMSSTSUBSTITUTO")
    private BigDecimal valoricmsstsubstituto;
    @Column(name = "CODBENEFICIOFISCAL")
    private String codbeneficiofiscal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumentoitem")
    private Collection<Documentoitementidade> documentoitementidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumentoitem")
    private Collection<Documentoitemperigoso> documentoitemperigosoCollection;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne(optional = false)
    private Documento coddocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumentoitem")
    private Collection<Documentoitemlote> documentoitemloteCollection;

    public Documentoitem() {
    }

    public Documentoitem(String coddocumentoitem) {
        this.coddocumentoitem = coddocumentoitem;
    }

    public String getCoddocumentoitem() {
        return coddocumentoitem;
    }

    public void setCoddocumentoitem(String coddocumentoitem) {
        this.coddocumentoitem = coddocumentoitem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public BigDecimal getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(BigDecimal valorunitario) {
        this.valorunitario = valorunitario;
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

    public BigDecimal getValordescontoitem() {
        return valordescontoitem;
    }

    public void setValordescontoitem(BigDecimal valordescontoitem) {
        this.valordescontoitem = valordescontoitem;
    }

    public BigDecimal getAliqacrescimoitem() {
        return aliqacrescimoitem;
    }

    public void setAliqacrescimoitem(BigDecimal aliqacrescimoitem) {
        this.aliqacrescimoitem = aliqacrescimoitem;
    }

    public Character getFlagtipoacrescimoitem() {
        return flagtipoacrescimoitem;
    }

    public void setFlagtipoacrescimoitem(Character flagtipoacrescimoitem) {
        this.flagtipoacrescimoitem = flagtipoacrescimoitem;
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

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        this.valoripi = valoripi;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
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

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public String getDinumerodocumento() {
        return dinumerodocumento;
    }

    public void setDinumerodocumento(String dinumerodocumento) {
        this.dinumerodocumento = dinumerodocumento;
    }

    public Date getDidataregistro() {
        return didataregistro;
    }

    public void setDidataregistro(Date didataregistro) {
        this.didataregistro = didataregistro;
    }

    public String getDilocaldesembaraco() {
        return dilocaldesembaraco;
    }

    public void setDilocaldesembaraco(String dilocaldesembaraco) {
        this.dilocaldesembaraco = dilocaldesembaraco;
    }

    public String getDiufdesembaraco() {
        return diufdesembaraco;
    }

    public void setDiufdesembaraco(String diufdesembaraco) {
        this.diufdesembaraco = diufdesembaraco;
    }

    public Date getDidatadesembaraco() {
        return didatadesembaraco;
    }

    public void setDidatadesembaraco(Date didatadesembaraco) {
        this.didatadesembaraco = didatadesembaraco;
    }

    public String getDicodigoexportador() {
        return dicodigoexportador;
    }

    public void setDicodigoexportador(String dicodigoexportador) {
        this.dicodigoexportador = dicodigoexportador;
    }

    public String getCodigolistaservico() {
        return codigolistaservico;
    }

    public void setCodigolistaservico(String codigolistaservico) {
        this.codigolistaservico = codigolistaservico;
    }

    public String getCodsituacaotributariaipi() {
        return codsituacaotributariaipi;
    }

    public void setCodsituacaotributariaipi(String codsituacaotributariaipi) {
        this.codsituacaotributariaipi = codsituacaotributariaipi;
    }

    public Integer getCodempresaestoque() {
        return codempresaestoque;
    }

    public void setCodempresaestoque(Integer codempresaestoque) {
        this.codempresaestoque = codempresaestoque;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
    }

    public String getSeriaisproduto() {
        return seriaisproduto;
    }

    public void setSeriaisproduto(String seriaisproduto) {
        this.seriaisproduto = seriaisproduto;
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

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
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

    public BigDecimal getValortotalnotaitem() {
        return valortotalnotaitem;
    }

    public void setValortotalnotaitem(BigDecimal valortotalnotaitem) {
        this.valortotalnotaitem = valortotalnotaitem;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getAliqipi() {
        return aliqipi;
    }

    public void setAliqipi(BigDecimal aliqipi) {
        this.aliqipi = aliqipi;
    }

    public BigDecimal getBaseipi() {
        return baseipi;
    }

    public void setBaseipi(BigDecimal baseipi) {
        this.baseipi = baseipi;
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

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        this.flagorigemproduto = flagorigemproduto;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
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

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getDescricaocomplemento() {
        return descricaocomplemento;
    }

    public void setDescricaocomplemento(String descricaocomplemento) {
        this.descricaocomplemento = descricaocomplemento;
    }

    public String getObservacoesproduto() {
        return observacoesproduto;
    }

    public void setObservacoesproduto(String observacoesproduto) {
        this.observacoesproduto = observacoesproduto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Character getFlagcontrolaserial() {
        return flagcontrolaserial;
    }

    public void setFlagcontrolaserial(Character flagcontrolaserial) {
        this.flagcontrolaserial = flagcontrolaserial;
    }

    public Character getFlagcontrolalote() {
        return flagcontrolalote;
    }

    public void setFlagcontrolalote(Character flagcontrolalote) {
        this.flagcontrolalote = flagcontrolalote;
    }

    public Character getFlagservico() {
        return flagservico;
    }

    public void setFlagservico(Character flagservico) {
        this.flagservico = flagservico;
    }

    public Character getFlagcomposto() {
        return flagcomposto;
    }

    public void setFlagcomposto(Character flagcomposto) {
        this.flagcomposto = flagcomposto;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getCodcor() {
        return codcor;
    }

    public void setCodcor(String codcor) {
        this.codcor = codcor;
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        this.prazogarantia = prazogarantia;
    }

    public String getNumeroecf() {
        return numeroecf;
    }

    public void setNumeroecf(String numeroecf) {
        this.numeroecf = numeroecf;
    }

    public Integer getNumcupomdevolucao() {
        return numcupomdevolucao;
    }

    public void setNumcupomdevolucao(Integer numcupomdevolucao) {
        this.numcupomdevolucao = numcupomdevolucao;
    }

    public Date getDatacupomdevolucao() {
        return datacupomdevolucao;
    }

    public void setDatacupomdevolucao(Date datacupomdevolucao) {
        this.datacupomdevolucao = datacupomdevolucao;
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

    public String getDescricaoclassificacaofiscal() {
        return descricaoclassificacaofiscal;
    }

    public void setDescricaoclassificacaofiscal(String descricaoclassificacaofiscal) {
        this.descricaoclassificacaofiscal = descricaoclassificacaofiscal;
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

    public BigDecimal getValorpisdesonerado() {
        return valorpisdesonerado;
    }

    public void setValorpisdesonerado(BigDecimal valorpisdesonerado) {
        this.valorpisdesonerado = valorpisdesonerado;
    }

    public BigDecimal getValorcofinsdesonerado() {
        return valorcofinsdesonerado;
    }

    public void setValorcofinsdesonerado(BigDecimal valorcofinsdesonerado) {
        this.valorcofinsdesonerado = valorcofinsdesonerado;
    }

    public BigDecimal getValoricmsdesonerado() {
        return valoricmsdesonerado;
    }

    public void setValoricmsdesonerado(BigDecimal valoricmsdesonerado) {
        this.valoricmsdesonerado = valoricmsdesonerado;
    }

    public BigDecimal getBaseicmsdeduzido() {
        return baseicmsdeduzido;
    }

    public void setBaseicmsdeduzido(BigDecimal baseicmsdeduzido) {
        this.baseicmsdeduzido = baseicmsdeduzido;
    }

    public String getCodigoean() {
        return codigoean;
    }

    public void setCodigoean(String codigoean) {
        this.codigoean = codigoean;
    }

    public String getCodigoanp() {
        return codigoanp;
    }

    public void setCodigoanp(String codigoanp) {
        this.codigoanp = codigoanp;
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

    public String getNumeropedidoforn() {
        return numeropedidoforn;
    }

    public void setNumeropedidoforn(String numeropedidoforn) {
        this.numeropedidoforn = numeropedidoforn;
    }

    public String getNumeroitempedidoforn() {
        return numeroitempedidoforn;
    }

    public void setNumeroitempedidoforn(String numeroitempedidoforn) {
        this.numeroitempedidoforn = numeroitempedidoforn;
    }

    public Character getProdutoperigoso() {
        return produtoperigoso;
    }

    public void setProdutoperigoso(Character produtoperigoso) {
        this.produtoperigoso = produtoperigoso;
    }

    public String getDiviatransp() {
        return diviatransp;
    }

    public void setDiviatransp(String diviatransp) {
        this.diviatransp = diviatransp;
    }

    public BigDecimal getDivalorafrmm() {
        return divalorafrmm;
    }

    public void setDivalorafrmm(BigDecimal divalorafrmm) {
        this.divalorafrmm = divalorafrmm;
    }

    public Character getDiformaimp() {
        return diformaimp;
    }

    public void setDiformaimp(Character diformaimp) {
        this.diformaimp = diformaimp;
    }

    public String getDicnpj() {
        return dicnpj;
    }

    public void setDicnpj(String dicnpj) {
        this.dicnpj = dicnpj;
    }

    public String getDiufadqenc() {
        return diufadqenc;
    }

    public void setDiufadqenc(String diufadqenc) {
        this.diufadqenc = diufadqenc;
    }

    public String getDenumdrawback() {
        return denumdrawback;
    }

    public void setDenumdrawback(String denumdrawback) {
        this.denumdrawback = denumdrawback;
    }

    public String getDenre() {
        return denre;
    }

    public void setDenre(String denre) {
        this.denre = denre;
    }

    public String getDechavenfe() {
        return dechavenfe;
    }

    public void setDechavenfe(String dechavenfe) {
        this.dechavenfe = dechavenfe;
    }

    public BigDecimal getDeqexport() {
        return deqexport;
    }

    public void setDeqexport(BigDecimal deqexport) {
        this.deqexport = deqexport;
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public Integer getNumcfesatdevolucao() {
        return numcfesatdevolucao;
    }

    public void setNumcfesatdevolucao(Integer numcfesatdevolucao) {
        this.numcfesatdevolucao = numcfesatdevolucao;
    }

    public Date getDatacfesatdevolucao() {
        return datacfesatdevolucao;
    }

    public void setDatacfesatdevolucao(Date datacfesatdevolucao) {
        this.datacfesatdevolucao = datacfesatdevolucao;
    }

    public String getChavecfe() {
        return chavecfe;
    }

    public void setChavecfe(String chavecfe) {
        this.chavecfe = chavecfe;
    }

    public String getCodcesticms() {
        return codcesticms;
    }

    public void setCodcesticms(String codcesticms) {
        this.codcesticms = codcesticms;
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        this.codenquadramentoipi = codenquadramentoipi;
    }

    public String getFci() {
        return fci;
    }

    public void setFci(String fci) {
        this.fci = fci;
    }

    public BigDecimal getBasesubsttributariaret() {
        return basesubsttributariaret;
    }

    public void setBasesubsttributariaret(BigDecimal basesubsttributariaret) {
        this.basesubsttributariaret = basesubsttributariaret;
    }

    public BigDecimal getValorsubsttributariaret() {
        return valorsubsttributariaret;
    }

    public void setValorsubsttributariaret(BigDecimal valorsubsttributariaret) {
        this.valorsubsttributariaret = valorsubsttributariaret;
    }

    public String getCodigodesoneracao() {
        return codigodesoneracao;
    }

    public void setCodigodesoneracao(String codigodesoneracao) {
        this.codigodesoneracao = codigodesoneracao;
    }

    public String getCodigoeantrib() {
        return codigoeantrib;
    }

    public void setCodigoeantrib(String codigoeantrib) {
        this.codigoeantrib = codigoeantrib;
    }

    public String getUnidadetrib() {
        return unidadetrib;
    }

    public void setUnidadetrib(String unidadetrib) {
        this.unidadetrib = unidadetrib;
    }

    public BigDecimal getQuantidadetrib() {
        return quantidadetrib;
    }

    public void setQuantidadetrib(BigDecimal quantidadetrib) {
        this.quantidadetrib = quantidadetrib;
    }

    public BigDecimal getValorunitariotrib() {
        return valorunitariotrib;
    }

    public void setValorunitariotrib(BigDecimal valorunitariotrib) {
        this.valorunitariotrib = valorunitariotrib;
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

    public BigDecimal getTributofederal() {
        return tributofederal;
    }

    public void setTributofederal(BigDecimal tributofederal) {
        this.tributofederal = tributofederal;
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

    public String getDescprodutoanp() {
        return descprodutoanp;
    }

    public void setDescprodutoanp(String descprodutoanp) {
        this.descprodutoanp = descprodutoanp;
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

    public BigDecimal getAliqreducaobasesubsttributaria() {
        return aliqreducaobasesubsttributaria;
    }

    public void setAliqreducaobasesubsttributaria(BigDecimal aliqreducaobasesubsttributaria) {
        this.aliqreducaobasesubsttributaria = aliqreducaobasesubsttributaria;
    }

    public BigDecimal getAliqmva() {
        return aliqmva;
    }

    public void setAliqmva(BigDecimal aliqmva) {
        this.aliqmva = aliqmva;
    }

    public BigDecimal getPercdevolvido() {
        return percdevolvido;
    }

    public void setPercdevolvido(BigDecimal percdevolvido) {
        this.percdevolvido = percdevolvido;
    }

    public BigDecimal getValoripidevolvido() {
        return valoripidevolvido;
    }

    public void setValoripidevolvido(BigDecimal valoripidevolvido) {
        this.valoripidevolvido = valoripidevolvido;
    }

    public Character getFlagloterastreavel() {
        return flagloterastreavel;
    }

    public void setFlagloterastreavel(Character flagloterastreavel) {
        this.flagloterastreavel = flagloterastreavel;
    }

    public String getGtintrib() {
        return gtintrib;
    }

    public void setGtintrib(String gtintrib) {
        this.gtintrib = gtintrib;
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

    public BigDecimal getBasesubsttributariadestino() {
        return basesubsttributariadestino;
    }

    public void setBasesubsttributariadestino(BigDecimal basesubsttributariadestino) {
        this.basesubsttributariadestino = basesubsttributariadestino;
    }

    public BigDecimal getValorsubsttributariadestino() {
        return valorsubsttributariadestino;
    }

    public void setValorsubsttributariadestino(BigDecimal valorsubsttributariadestino) {
        this.valorsubsttributariadestino = valorsubsttributariadestino;
    }

    public BigDecimal getAliqicmsstconsumidor() {
        return aliqicmsstconsumidor;
    }

    public void setAliqicmsstconsumidor(BigDecimal aliqicmsstconsumidor) {
        this.aliqicmsstconsumidor = aliqicmsstconsumidor;
    }

    public BigDecimal getBaseicmsstfcpret() {
        return baseicmsstfcpret;
    }

    public void setBaseicmsstfcpret(BigDecimal baseicmsstfcpret) {
        this.baseicmsstfcpret = baseicmsstfcpret;
    }

    public BigDecimal getAliqfcpStRet() {
        return aliqfcpStRet;
    }

    public void setAliqfcpStRet(BigDecimal aliqfcpStRet) {
        this.aliqfcpStRet = aliqfcpStRet;
    }

    public BigDecimal getValorfcpstret() {
        return valorfcpstret;
    }

    public void setValorfcpstret(BigDecimal valorfcpstret) {
        this.valorfcpstret = valorfcpstret;
    }

    public BigDecimal getValoricmsstsubstituto() {
        return valoricmsstsubstituto;
    }

    public void setValoricmsstsubstituto(BigDecimal valoricmsstsubstituto) {
        this.valoricmsstsubstituto = valoricmsstsubstituto;
    }

    public String getCodbeneficiofiscal() {
        return codbeneficiofiscal;
    }

    public void setCodbeneficiofiscal(String codbeneficiofiscal) {
        this.codbeneficiofiscal = codbeneficiofiscal;
    }

    @XmlTransient
    public Collection<Documentoitementidade> getDocumentoitementidadeCollection() {
        return documentoitementidadeCollection;
    }

    public void setDocumentoitementidadeCollection(Collection<Documentoitementidade> documentoitementidadeCollection) {
        this.documentoitementidadeCollection = documentoitementidadeCollection;
    }

    @XmlTransient
    public Collection<Documentoitemperigoso> getDocumentoitemperigosoCollection() {
        return documentoitemperigosoCollection;
    }

    public void setDocumentoitemperigosoCollection(Collection<Documentoitemperigoso> documentoitemperigosoCollection) {
        this.documentoitemperigosoCollection = documentoitemperigosoCollection;
    }

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    @XmlTransient
    public Collection<Documentoitemlote> getDocumentoitemloteCollection() {
        return documentoitemloteCollection;
    }

    public void setDocumentoitemloteCollection(Collection<Documentoitemlote> documentoitemloteCollection) {
        this.documentoitemloteCollection = documentoitemloteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumentoitem != null ? coddocumentoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentoitem)) {
            return false;
        }
        Documentoitem other = (Documentoitem) object;
        if ((this.coddocumentoitem == null && other.coddocumentoitem != null) || (this.coddocumentoitem != null && !this.coddocumentoitem.equals(other.coddocumentoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documentoitem[ coddocumentoitem=" + coddocumentoitem + " ]";
    }
    
}
