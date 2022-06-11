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
import javax.persistence.Lob;
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
@Table(name = "TMP_DOCUMENTOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumentoitem.findAll", query = "SELECT t FROM TmpDocumentoitem t")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodtmpDocumentoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codtmpDocumentoitem = :codtmpDocumentoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodmovprod", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codmovprod = :codmovprod")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigointernoproduto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigointernoproduto = :codigointernoproduto")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoprincipalproduto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoprincipalproduto = :codigoprincipalproduto")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoean", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoean = :codigoean")
    , @NamedQuery(name = "TmpDocumentoitem.findByDescricaoproduto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.descricaoproduto = :descricaoproduto")
    , @NamedQuery(name = "TmpDocumentoitem.findByComplemento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.complemento = :complemento")
    , @NamedQuery(name = "TmpDocumentoitem.findByDescricaocomplemento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.descricaocomplemento = :descricaocomplemento")
    , @NamedQuery(name = "TmpDocumentoitem.findBySeriaisproduto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.seriaisproduto = :seriaisproduto")
    , @NamedQuery(name = "TmpDocumentoitem.findByUnidade", query = "SELECT t FROM TmpDocumentoitem t WHERE t.unidade = :unidade")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigofabricante", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigofabricante = :codigofabricante")
    , @NamedQuery(name = "TmpDocumentoitem.findByNomefabricante", query = "SELECT t FROM TmpDocumentoitem t WHERE t.nomefabricante = :nomefabricante")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigofornecedor", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigofornecedor = :codigofornecedor")
    , @NamedQuery(name = "TmpDocumentoitem.findByNomefornecedor", query = "SELECT t FROM TmpDocumentoitem t WHERE t.nomefornecedor = :nomefornecedor")
    , @NamedQuery(name = "TmpDocumentoitem.findByLocalizacao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.localizacao = :localizacao")
    , @NamedQuery(name = "TmpDocumentoitem.findByCst", query = "SELECT t FROM TmpDocumentoitem t WHERE t.cst = :cst")
    , @NamedQuery(name = "TmpDocumentoitem.findByPrazogarantia", query = "SELECT t FROM TmpDocumentoitem t WHERE t.prazogarantia = :prazogarantia")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodcfop", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codcfop = :codcfop")
    , @NamedQuery(name = "TmpDocumentoitem.findByQuantidade", query = "SELECT t FROM TmpDocumentoitem t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorunitario", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorunitario = :valorunitario")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqdescontoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqdescontoitem = :aliqdescontoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagtipodescontoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagtipodescontoitem = :flagtipodescontoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByValordescontoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valordescontoitem = :valordescontoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqacrescimoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqacrescimoitem = :aliqacrescimoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagtipoacrescimoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagtipoacrescimoitem = :flagtipoacrescimoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoracrescimoitem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoracrescimoitem = :valoracrescimoitem")
    , @NamedQuery(name = "TmpDocumentoitem.findByValortotal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valortotal = :valortotal")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagtipoipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagtipoipi = :flagtipoipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodsituacaotributariaipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codsituacaotributariaipi = :codsituacaotributariaipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseipi = :baseipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqipi = :aliqipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByQuantidadeipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.quantidadeipi = :quantidadeipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorunidadeipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorunidadeipi = :valorunidadeipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoripi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoripi = :valoripi")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqreducaobaseicms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqreducaobaseicms = :aliqreducaobaseicms")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqicmsStUfDestino", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqicmsStUfDestino = :aliqicmsStUfDestino")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseicms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseicms = :baseicms")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqicms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqicms = :aliqicms")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricms = :valoricms")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricmsdesonerado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricmsdesonerado = :valoricmsdesonerado")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasesubsttributaria", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorsubsttributaria", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoroutrasdesprateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoroutrasdesprateado = :valoroutrasdesprateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorsegurorateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorsegurorateado = :valorsegurorateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorfreterateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorfreterateado = :valorfreterateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByValordescontorateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valordescontorateado = :valordescontorateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoracrescimorateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoracrescimorateado = :valoracrescimorateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByPrecotabela", query = "SELECT t FROM TmpDocumentoitem t WHERE t.precotabela = :precotabela")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodpreco", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codpreco = :codpreco")
    , @NamedQuery(name = "TmpDocumentoitem.findByCustomedio", query = "SELECT t FROM TmpDocumentoitem t WHERE t.customedio = :customedio")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagcontrolaserial", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagcontrolaserial = :flagcontrolaserial")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagcontrolalote", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagcontrolalote = :flagcontrolalote")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagservico", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagservico = :flagservico")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagcomposto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagcomposto = :flagcomposto")
    , @NamedQuery(name = "TmpDocumentoitem.findByDatavalidade", query = "SELECT t FROM TmpDocumentoitem t WHERE t.datavalidade = :datavalidade")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodclassificacaofiscal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codclassificacaofiscal = :codclassificacaofiscal")
    , @NamedQuery(name = "TmpDocumentoitem.findByCfreduzido", query = "SELECT t FROM TmpDocumentoitem t WHERE t.cfreduzido = :cfreduzido")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlag1", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flag1 = :flag1")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlag2", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flag2 = :flag2")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlag3", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flag3 = :flag3")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodsetorestoque", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodempresaestoque", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codempresaestoque = :codempresaestoque")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoclassificacaofiscal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoclassificacaofiscal = :codigoclassificacaofiscal")
    , @NamedQuery(name = "TmpDocumentoitem.findByCor", query = "SELECT t FROM TmpDocumentoitem t WHERE t.cor = :cor")
    , @NamedQuery(name = "TmpDocumentoitem.findByPesobruto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.pesobruto = :pesobruto")
    , @NamedQuery(name = "TmpDocumentoitem.findByPesoliquido", query = "SELECT t FROM TmpDocumentoitem t WHERE t.pesoliquido = :pesoliquido")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqiss", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqiss = :aliqiss")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoriss", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoriss = :valoriss")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodprod", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codprod = :codprod")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodcor", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codcor = :codcor")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodsituacaotributaria", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codsituacaotributaria = :codsituacaotributaria")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagorigemproduto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagorigemproduto = :flagorigemproduto")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorpisfreterateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorpisfreterateado = :valorpisfreterateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorcofinsfreterateado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorcofinsfreterateado = :valorcofinsfreterateado")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseirrf", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseirrf = :baseirrf")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqirrf", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorirrf", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorirrf = :valorirrf")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasecsll", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basecsll = :basecsll")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqcsll", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorcsll", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorcsll = :valorcsll")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseii", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseii = :baseii")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqii", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqii = :aliqii")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorii", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorii = :valorii")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasecofins", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basecofins = :basecofins")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqcofins", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorcofins", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorcofins = :valorcofins")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorcofinsdesonerado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorcofinsdesonerado = :valorcofinsdesonerado")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasepis", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basepis = :basepis")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqpis", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqpis = :aliqpis")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorpis", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorpis = :valorpis")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorpisdesonerado", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorpisdesonerado = :valorpisdesonerado")
    , @NamedQuery(name = "TmpDocumentoitem.findByNumeroecf", query = "SELECT t FROM TmpDocumentoitem t WHERE t.numeroecf = :numeroecf")
    , @NamedQuery(name = "TmpDocumentoitem.findByNumcupomdevolucao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.numcupomdevolucao = :numcupomdevolucao")
    , @NamedQuery(name = "TmpDocumentoitem.findByNumcfesatdevolucao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.numcfesatdevolucao = :numcfesatdevolucao")
    , @NamedQuery(name = "TmpDocumentoitem.findByDatacupomdevolucao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.datacupomdevolucao = :datacupomdevolucao")
    , @NamedQuery(name = "TmpDocumentoitem.findByDatacfesatdevolucao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.datacfesatdevolucao = :datacfesatdevolucao")
    , @NamedQuery(name = "TmpDocumentoitem.findByChavecfe", query = "SELECT t FROM TmpDocumentoitem t WHERE t.chavecfe = :chavecfe")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigolistaservico", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigolistaservico = :codigolistaservico")
    , @NamedQuery(name = "TmpDocumentoitem.findByDinumerodocumento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.dinumerodocumento = :dinumerodocumento")
    , @NamedQuery(name = "TmpDocumentoitem.findByDidataregistro", query = "SELECT t FROM TmpDocumentoitem t WHERE t.didataregistro = :didataregistro")
    , @NamedQuery(name = "TmpDocumentoitem.findByDilocaldesembaraco", query = "SELECT t FROM TmpDocumentoitem t WHERE t.dilocaldesembaraco = :dilocaldesembaraco")
    , @NamedQuery(name = "TmpDocumentoitem.findByDiufdesembaraco", query = "SELECT t FROM TmpDocumentoitem t WHERE t.diufdesembaraco = :diufdesembaraco")
    , @NamedQuery(name = "TmpDocumentoitem.findByNumeropedidoforn", query = "SELECT t FROM TmpDocumentoitem t WHERE t.numeropedidoforn = :numeropedidoforn")
    , @NamedQuery(name = "TmpDocumentoitem.findByNumeroitempedidoforn", query = "SELECT t FROM TmpDocumentoitem t WHERE t.numeroitempedidoforn = :numeroitempedidoforn")
    , @NamedQuery(name = "TmpDocumentoitem.findByDidatadesembaraco", query = "SELECT t FROM TmpDocumentoitem t WHERE t.didatadesembaraco = :didatadesembaraco")
    , @NamedQuery(name = "TmpDocumentoitem.findByDicodigoexportador", query = "SELECT t FROM TmpDocumentoitem t WHERE t.dicodigoexportador = :dicodigoexportador")
    , @NamedQuery(name = "TmpDocumentoitem.findByCstcofins", query = "SELECT t FROM TmpDocumentoitem t WHERE t.cstcofins = :cstcofins")
    , @NamedQuery(name = "TmpDocumentoitem.findByCstpis", query = "SELECT t FROM TmpDocumentoitem t WHERE t.cstpis = :cstpis")
    , @NamedQuery(name = "TmpDocumentoitem.findByCsosn", query = "SELECT t FROM TmpDocumentoitem t WHERE t.csosn = :csosn")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoanp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoanp = :codigoanp")
    , @NamedQuery(name = "TmpDocumentoitem.findByDescprodutoanp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.descprodutoanp = :descprodutoanp")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqcreditosimplesnacional", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqcreditosimplesnacional = :aliqcreditosimplesnacional")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorcreditosimplesnacional", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorcreditosimplesnacional = :valorcreditosimplesnacional")
    , @NamedQuery(name = "TmpDocumentoitem.findByDiviatransp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.diviatransp = :diviatransp")
    , @NamedQuery(name = "TmpDocumentoitem.findByDivalorafrmm", query = "SELECT t FROM TmpDocumentoitem t WHERE t.divalorafrmm = :divalorafrmm")
    , @NamedQuery(name = "TmpDocumentoitem.findByDiformaimp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.diformaimp = :diformaimp")
    , @NamedQuery(name = "TmpDocumentoitem.findByDicnpj", query = "SELECT t FROM TmpDocumentoitem t WHERE t.dicnpj = :dicnpj")
    , @NamedQuery(name = "TmpDocumentoitem.findByDiufadqenc", query = "SELECT t FROM TmpDocumentoitem t WHERE t.diufadqenc = :diufadqenc")
    , @NamedQuery(name = "TmpDocumentoitem.findByDenumdrawback", query = "SELECT t FROM TmpDocumentoitem t WHERE t.denumdrawback = :denumdrawback")
    , @NamedQuery(name = "TmpDocumentoitem.findByDenre", query = "SELECT t FROM TmpDocumentoitem t WHERE t.denre = :denre")
    , @NamedQuery(name = "TmpDocumentoitem.findByDechavenfe", query = "SELECT t FROM TmpDocumentoitem t WHERE t.dechavenfe = :dechavenfe")
    , @NamedQuery(name = "TmpDocumentoitem.findByDeqexport", query = "SELECT t FROM TmpDocumentoitem t WHERE t.deqexport = :deqexport")
    , @NamedQuery(name = "TmpDocumentoitem.findByFlagloterastreavel", query = "SELECT t FROM TmpDocumentoitem t WHERE t.flagloterastreavel = :flagloterastreavel")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricmsoperacao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricmsoperacao = :valoricmsoperacao")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqdiferimento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqdiferimento = :aliqdiferimento")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricmsdiferimento", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricmsdiferimento = :valoricmsdiferimento")
    , @NamedQuery(name = "TmpDocumentoitem.findByTributofederal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.tributofederal = :tributofederal")
    , @NamedQuery(name = "TmpDocumentoitem.findByTributoestadual", query = "SELECT t FROM TmpDocumentoitem t WHERE t.tributoestadual = :tributoestadual")
    , @NamedQuery(name = "TmpDocumentoitem.findByTributomunicipal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.tributomunicipal = :tributomunicipal")
    , @NamedQuery(name = "TmpDocumentoitem.findByPercdevolvido", query = "SELECT t FROM TmpDocumentoitem t WHERE t.percdevolvido = :percdevolvido")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoripidevolvido", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoripidevolvido = :valoripidevolvido")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqmva", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqmva = :aliqmva")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqreducaobasesubsttributaria", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqreducaobasesubsttributaria = :aliqreducaobasesubsttributaria")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqfcp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqfcp = :aliqfcp")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorfcp", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorfcp = :valorfcp")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorfcpsubsttributaria", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqfcpStUfDestino", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqfcpStUfDestino = :aliqfcpStUfDestino")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseicmsfcpdestino", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseicmsfcpdestino = :baseicmsfcpdestino")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasesubsttributariadestino", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basesubsttributariadestino = :basesubsttributariadestino")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorsubsttributariadestino", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorsubsttributariadestino = :valorsubsttributariadestino")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqreducaobaseicmsefetivo", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqreducaobaseicmsefetivo = :aliqreducaobaseicmsefetivo")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseicmsefetivo", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseicmsefetivo = :baseicmsefetivo")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqicmsefetivo", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqicmsefetivo = :aliqicmsefetivo")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricmsefetivo", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricmsefetivo = :valoricmsefetivo")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqicmsstconsumidor", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqicmsstconsumidor = :aliqicmsstconsumidor")
    , @NamedQuery(name = "TmpDocumentoitem.findByValoricmsstsubstituto", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valoricmsstsubstituto = :valoricmsstsubstituto")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseicmsstfcpret", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseicmsstfcpret = :baseicmsstfcpret")
    , @NamedQuery(name = "TmpDocumentoitem.findByAliqfcpStRet", query = "SELECT t FROM TmpDocumentoitem t WHERE t.aliqfcpStRet = :aliqfcpStRet")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorfcpstret", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorfcpstret = :valorfcpstret")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodbeneficiofiscal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codbeneficiofiscal = :codbeneficiofiscal")
    , @NamedQuery(name = "TmpDocumentoitem.findByBaseicmsdeduzido", query = "SELECT t FROM TmpDocumentoitem t WHERE t.baseicmsdeduzido = :baseicmsdeduzido")
    , @NamedQuery(name = "TmpDocumentoitem.findByDescricaoclassificacaofiscal", query = "SELECT t FROM TmpDocumentoitem t WHERE t.descricaoclassificacaofiscal = :descricaoclassificacaofiscal")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodcalculoicms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codcalculoicms = :codcalculoicms")
    , @NamedQuery(name = "TmpDocumentoitem.findByProdutoperigoso", query = "SELECT t FROM TmpDocumentoitem t WHERE t.produtoperigoso = :produtoperigoso")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodcesticms", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codcesticms = :codcesticms")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodenquadramentoipi", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codenquadramentoipi = :codenquadramentoipi")
    , @NamedQuery(name = "TmpDocumentoitem.findByFci", query = "SELECT t FROM TmpDocumentoitem t WHERE t.fci = :fci")
    , @NamedQuery(name = "TmpDocumentoitem.findByBasesubsttributariaret", query = "SELECT t FROM TmpDocumentoitem t WHERE t.basesubsttributariaret = :basesubsttributariaret")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorsubsttributariaret", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorsubsttributariaret = :valorsubsttributariaret")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigodesoneracao", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigodesoneracao = :codigodesoneracao")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoeantrib", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoeantrib = :codigoeantrib")
    , @NamedQuery(name = "TmpDocumentoitem.findByUnidadetrib", query = "SELECT t FROM TmpDocumentoitem t WHERE t.unidadetrib = :unidadetrib")
    , @NamedQuery(name = "TmpDocumentoitem.findByQuantidadetrib", query = "SELECT t FROM TmpDocumentoitem t WHERE t.quantidadetrib = :quantidadetrib")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigoonu", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigoonu = :codigoonu")
    , @NamedQuery(name = "TmpDocumentoitem.findByDescricaoprodutoperigosoclasse", query = "SELECT t FROM TmpDocumentoitem t WHERE t.descricaoprodutoperigosoclasse = :descricaoprodutoperigosoclasse")
    , @NamedQuery(name = "TmpDocumentoitem.findByNomeprodembarque", query = "SELECT t FROM TmpDocumentoitem t WHERE t.nomeprodembarque = :nomeprodembarque")
    , @NamedQuery(name = "TmpDocumentoitem.findByCodigogrupoembalagem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.codigogrupoembalagem = :codigogrupoembalagem")
    , @NamedQuery(name = "TmpDocumentoitem.findByGtintrib", query = "SELECT t FROM TmpDocumentoitem t WHERE t.gtintrib = :gtintrib")
    , @NamedQuery(name = "TmpDocumentoitem.findByQuantidadeembalagem", query = "SELECT t FROM TmpDocumentoitem t WHERE t.quantidadeembalagem = :quantidadeembalagem")
    , @NamedQuery(name = "TmpDocumentoitem.findByValorunitariotrib", query = "SELECT t FROM TmpDocumentoitem t WHERE t.valorunitariotrib = :valorunitariotrib")})
public class TmpDocumentoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTOITEM")
    private Integer codtmpDocumentoitem;
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTO")
    private int codtmpDocumento;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "CODIGOINTERNOPRODUTO")
    private String codigointernoproduto;
    @Column(name = "CODIGOPRINCIPALPRODUTO")
    private String codigoprincipalproduto;
    @Column(name = "CODIGOEAN")
    private String codigoean;
    @Column(name = "DESCRICAOPRODUTO")
    private String descricaoproduto;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "DESCRICAOCOMPLEMENTO")
    private String descricaocomplemento;
    @Column(name = "SERIAISPRODUTO")
    private String seriaisproduto;
    @Column(name = "UNIDADE")
    private String unidade;
    @Lob
    @Column(name = "OBSERVACOESPRODUTO")
    private String observacoesproduto;
    @Column(name = "CODIGOFABRICANTE")
    private String codigofabricante;
    @Column(name = "NOMEFABRICANTE")
    private String nomefabricante;
    @Column(name = "CODIGOFORNECEDOR")
    private String codigofornecedor;
    @Column(name = "NOMEFORNECEDOR")
    private String nomefornecedor;
    @Column(name = "LOCALIZACAO")
    private String localizacao;
    @Column(name = "CST")
    private String cst;
    @Column(name = "PRAZOGARANTIA")
    private Integer prazogarantia;
    @Column(name = "CODCFOP")
    private String codcfop;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
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
    @Column(name = "FLAGTIPOIPI")
    private Character flagtipoipi;
    @Column(name = "CODSITUACAOTRIBUTARIAIPI")
    private String codsituacaotributariaipi;
    @Column(name = "BASEIPI")
    private BigDecimal baseipi;
    @Column(name = "ALIQIPI")
    private BigDecimal aliqipi;
    @Column(name = "QUANTIDADEIPI")
    private BigDecimal quantidadeipi;
    @Column(name = "VALORUNIDADEIPI")
    private BigDecimal valorunidadeipi;
    @Column(name = "VALORIPI")
    private BigDecimal valoripi;
    @Column(name = "ALIQREDUCAOBASEICMS")
    private BigDecimal aliqreducaobaseicms;
    @Column(name = "ALIQICMS_ST_UF_DESTINO")
    private BigDecimal aliqicmsStUfDestino;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALOROUTRASDESPRATEADO")
    private BigDecimal valoroutrasdesprateado;
    @Column(name = "VALORSEGURORATEADO")
    private BigDecimal valorsegurorateado;
    @Column(name = "VALORFRETERATEADO")
    private BigDecimal valorfreterateado;
    @Column(name = "VALORDESCONTORATEADO")
    private BigDecimal valordescontorateado;
    @Column(name = "VALORACRESCIMORATEADO")
    private BigDecimal valoracrescimorateado;
    @Column(name = "PRECOTABELA")
    private BigDecimal precotabela;
    @Column(name = "CODPRECO")
    private String codpreco;
    @Column(name = "CUSTOMEDIO")
    private BigDecimal customedio;
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
    @Column(name = "CODCLASSIFICACAOFISCAL")
    private String codclassificacaofiscal;
    @Column(name = "CFREDUZIDO")
    private String cfreduzido;
    @Column(name = "FLAG1")
    private Character flag1;
    @Column(name = "FLAG2")
    private Character flag2;
    @Column(name = "FLAG3")
    private Character flag3;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "CODEMPRESAESTOQUE")
    private Integer codempresaestoque;
    @Column(name = "CODIGOCLASSIFICACAOFISCAL")
    private String codigoclassificacaofiscal;
    @Column(name = "COR")
    private String cor;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "ALIQISS")
    private BigDecimal aliqiss;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "CODPROD")
    private String codprod;
    @Column(name = "CODCOR")
    private String codcor;
    @Column(name = "CODSITUACAOTRIBUTARIA")
    private String codsituacaotributaria;
    @Column(name = "FLAGORIGEMPRODUTO")
    private Character flagorigemproduto;
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
    @Column(name = "VALORCOFINSDESONERADO")
    private BigDecimal valorcofinsdesonerado;
    @Column(name = "BASEPIS")
    private BigDecimal basepis;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "VALORPIS")
    private BigDecimal valorpis;
    @Column(name = "VALORPISDESONERADO")
    private BigDecimal valorpisdesonerado;
    @Column(name = "NUMEROECF")
    private String numeroecf;
    @Column(name = "NUMCUPOMDEVOLUCAO")
    private Integer numcupomdevolucao;
    @Column(name = "NUMCFESATDEVOLUCAO")
    private Integer numcfesatdevolucao;
    @Column(name = "DATACUPOMDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date datacupomdevolucao;
    @Column(name = "DATACFESATDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date datacfesatdevolucao;
    @Column(name = "CHAVECFE")
    private String chavecfe;
    @Column(name = "CODIGOLISTASERVICO")
    private String codigolistaservico;
    @Column(name = "DINUMERODOCUMENTO")
    private String dinumerodocumento;
    @Column(name = "DIDATAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date didataregistro;
    @Column(name = "DILOCALDESEMBARACO")
    private String dilocaldesembaraco;
    @Column(name = "DIUFDESEMBARACO")
    private String diufdesembaraco;
    @Column(name = "NUMEROPEDIDOFORN")
    private String numeropedidoforn;
    @Column(name = "NUMEROITEMPEDIDOFORN")
    private String numeroitempedidoforn;
    @Column(name = "DIDATADESEMBARACO")
    @Temporal(TemporalType.DATE)
    private Date didatadesembaraco;
    @Column(name = "DICODIGOEXPORTADOR")
    private String dicodigoexportador;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "CODIGOANP")
    private String codigoanp;
    @Column(name = "DESCPRODUTOANP")
    private String descprodutoanp;
    @Column(name = "ALIQCREDITOSIMPLESNACIONAL")
    private BigDecimal aliqcreditosimplesnacional;
    @Column(name = "VALORCREDITOSIMPLESNACIONAL")
    private BigDecimal valorcreditosimplesnacional;
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
    @Column(name = "FLAGLOTERASTREAVEL")
    private Character flagloterastreavel;
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
    @Column(name = "PERCDEVOLVIDO")
    private BigDecimal percdevolvido;
    @Column(name = "VALORIPIDEVOLVIDO")
    private BigDecimal valoripidevolvido;
    @Column(name = "ALIQMVA")
    private BigDecimal aliqmva;
    @Column(name = "ALIQREDUCAOBASESUBSTTRIBUTARIA")
    private BigDecimal aliqreducaobasesubsttributaria;
    @Column(name = "ALIQFCP")
    private BigDecimal aliqfcp;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "ALIQFCP_ST_UF_DESTINO")
    private BigDecimal aliqfcpStUfDestino;
    @Column(name = "BASEICMSFCPDESTINO")
    private BigDecimal baseicmsfcpdestino;
    @Column(name = "BASESUBSTTRIBUTARIADESTINO")
    private BigDecimal basesubsttributariadestino;
    @Column(name = "VALORSUBSTTRIBUTARIADESTINO")
    private BigDecimal valorsubsttributariadestino;
    @Column(name = "ALIQREDUCAOBASEICMSEFETIVO")
    private BigDecimal aliqreducaobaseicmsefetivo;
    @Column(name = "BASEICMSEFETIVO")
    private BigDecimal baseicmsefetivo;
    @Column(name = "ALIQICMSEFETIVO")
    private BigDecimal aliqicmsefetivo;
    @Column(name = "VALORICMSEFETIVO")
    private BigDecimal valoricmsefetivo;
    @Column(name = "ALIQICMSSTCONSUMIDOR")
    private BigDecimal aliqicmsstconsumidor;
    @Column(name = "VALORICMSSTSUBSTITUTO")
    private BigDecimal valoricmsstsubstituto;
    @Column(name = "BASEICMSSTFCPRET")
    private BigDecimal baseicmsstfcpret;
    @Column(name = "ALIQFCP_ST_RET")
    private BigDecimal aliqfcpStRet;
    @Column(name = "VALORFCPSTRET")
    private BigDecimal valorfcpstret;
    @Column(name = "CODBENEFICIOFISCAL")
    private String codbeneficiofiscal;
    @Column(name = "BASEICMSDEDUZIDO")
    private BigDecimal baseicmsdeduzido;
    @Column(name = "DESCRICAOCLASSIFICACAOFISCAL")
    private String descricaoclassificacaofiscal;
    @Column(name = "CODCALCULOICMS")
    private String codcalculoicms;
    @Column(name = "PRODUTOPERIGOSO")
    private Character produtoperigoso;
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
    @Column(name = "CODIGOONU")
    private String codigoonu;
    @Column(name = "DESCRICAOPRODUTOPERIGOSOCLASSE")
    private String descricaoprodutoperigosoclasse;
    @Column(name = "NOMEPRODEMBARQUE")
    private String nomeprodembarque;
    @Column(name = "CODIGOGRUPOEMBALAGEM")
    private String codigogrupoembalagem;
    @Column(name = "GTINTRIB")
    private String gtintrib;
    @Column(name = "QUANTIDADEEMBALAGEM")
    private BigDecimal quantidadeembalagem;
    @Column(name = "VALORUNITARIOTRIB")
    private BigDecimal valorunitariotrib;

    public TmpDocumentoitem() {
    }

    public TmpDocumentoitem(Integer codtmpDocumentoitem) {
        this.codtmpDocumentoitem = codtmpDocumentoitem;
    }

    public TmpDocumentoitem(Integer codtmpDocumentoitem, int codtmpDocumento) {
        this.codtmpDocumentoitem = codtmpDocumentoitem;
        this.codtmpDocumento = codtmpDocumento;
    }

    public Integer getCodtmpDocumentoitem() {
        return codtmpDocumentoitem;
    }

    public void setCodtmpDocumentoitem(Integer codtmpDocumentoitem) {
        this.codtmpDocumentoitem = codtmpDocumentoitem;
    }

    public int getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(int codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public String getCodigointernoproduto() {
        return codigointernoproduto;
    }

    public void setCodigointernoproduto(String codigointernoproduto) {
        this.codigointernoproduto = codigointernoproduto;
    }

    public String getCodigoprincipalproduto() {
        return codigoprincipalproduto;
    }

    public void setCodigoprincipalproduto(String codigoprincipalproduto) {
        this.codigoprincipalproduto = codigoprincipalproduto;
    }

    public String getCodigoean() {
        return codigoean;
    }

    public void setCodigoean(String codigoean) {
        this.codigoean = codigoean;
    }

    public String getDescricaoproduto() {
        return descricaoproduto;
    }

    public void setDescricaoproduto(String descricaoproduto) {
        this.descricaoproduto = descricaoproduto;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDescricaocomplemento() {
        return descricaocomplemento;
    }

    public void setDescricaocomplemento(String descricaocomplemento) {
        this.descricaocomplemento = descricaocomplemento;
    }

    public String getSeriaisproduto() {
        return seriaisproduto;
    }

    public void setSeriaisproduto(String seriaisproduto) {
        this.seriaisproduto = seriaisproduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getObservacoesproduto() {
        return observacoesproduto;
    }

    public void setObservacoesproduto(String observacoesproduto) {
        this.observacoesproduto = observacoesproduto;
    }

    public String getCodigofabricante() {
        return codigofabricante;
    }

    public void setCodigofabricante(String codigofabricante) {
        this.codigofabricante = codigofabricante;
    }

    public String getNomefabricante() {
        return nomefabricante;
    }

    public void setNomefabricante(String nomefabricante) {
        this.nomefabricante = nomefabricante;
    }

    public String getCodigofornecedor() {
        return codigofornecedor;
    }

    public void setCodigofornecedor(String codigofornecedor) {
        this.codigofornecedor = codigofornecedor;
    }

    public String getNomefornecedor() {
        return nomefornecedor;
    }

    public void setNomefornecedor(String nomefornecedor) {
        this.nomefornecedor = nomefornecedor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        this.prazogarantia = prazogarantia;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
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

    public Character getFlagtipoipi() {
        return flagtipoipi;
    }

    public void setFlagtipoipi(Character flagtipoipi) {
        this.flagtipoipi = flagtipoipi;
    }

    public String getCodsituacaotributariaipi() {
        return codsituacaotributariaipi;
    }

    public void setCodsituacaotributariaipi(String codsituacaotributariaipi) {
        this.codsituacaotributariaipi = codsituacaotributariaipi;
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

    public BigDecimal getValoripi() {
        return valoripi;
    }

    public void setValoripi(BigDecimal valoripi) {
        this.valoripi = valoripi;
    }

    public BigDecimal getAliqreducaobaseicms() {
        return aliqreducaobaseicms;
    }

    public void setAliqreducaobaseicms(BigDecimal aliqreducaobaseicms) {
        this.aliqreducaobaseicms = aliqreducaobaseicms;
    }

    public BigDecimal getAliqicmsStUfDestino() {
        return aliqicmsStUfDestino;
    }

    public void setAliqicmsStUfDestino(BigDecimal aliqicmsStUfDestino) {
        this.aliqicmsStUfDestino = aliqicmsStUfDestino;
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

    public BigDecimal getValoricmsdesonerado() {
        return valoricmsdesonerado;
    }

    public void setValoricmsdesonerado(BigDecimal valoricmsdesonerado) {
        this.valoricmsdesonerado = valoricmsdesonerado;
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

    public BigDecimal getValoroutrasdesprateado() {
        return valoroutrasdesprateado;
    }

    public void setValoroutrasdesprateado(BigDecimal valoroutrasdesprateado) {
        this.valoroutrasdesprateado = valoroutrasdesprateado;
    }

    public BigDecimal getValorsegurorateado() {
        return valorsegurorateado;
    }

    public void setValorsegurorateado(BigDecimal valorsegurorateado) {
        this.valorsegurorateado = valorsegurorateado;
    }

    public BigDecimal getValorfreterateado() {
        return valorfreterateado;
    }

    public void setValorfreterateado(BigDecimal valorfreterateado) {
        this.valorfreterateado = valorfreterateado;
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

    public BigDecimal getPrecotabela() {
        return precotabela;
    }

    public void setPrecotabela(BigDecimal precotabela) {
        this.precotabela = precotabela;
    }

    public String getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(String codpreco) {
        this.codpreco = codpreco;
    }

    public BigDecimal getCustomedio() {
        return customedio;
    }

    public void setCustomedio(BigDecimal customedio) {
        this.customedio = customedio;
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

    public String getCodclassificacaofiscal() {
        return codclassificacaofiscal;
    }

    public void setCodclassificacaofiscal(String codclassificacaofiscal) {
        this.codclassificacaofiscal = codclassificacaofiscal;
    }

    public String getCfreduzido() {
        return cfreduzido;
    }

    public void setCfreduzido(String cfreduzido) {
        this.cfreduzido = cfreduzido;
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

    public Integer getCodempresaestoque() {
        return codempresaestoque;
    }

    public void setCodempresaestoque(Integer codempresaestoque) {
        this.codempresaestoque = codempresaestoque;
    }

    public String getCodigoclassificacaofiscal() {
        return codigoclassificacaofiscal;
    }

    public void setCodigoclassificacaofiscal(String codigoclassificacaofiscal) {
        this.codigoclassificacaofiscal = codigoclassificacaofiscal;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPesobruto() {
        return pesobruto;
    }

    public void setPesobruto(BigDecimal pesobruto) {
        this.pesobruto = pesobruto;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
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

    public String getCodsituacaotributaria() {
        return codsituacaotributaria;
    }

    public void setCodsituacaotributaria(String codsituacaotributaria) {
        this.codsituacaotributaria = codsituacaotributaria;
    }

    public Character getFlagorigemproduto() {
        return flagorigemproduto;
    }

    public void setFlagorigemproduto(Character flagorigemproduto) {
        this.flagorigemproduto = flagorigemproduto;
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

    public BigDecimal getValorcofinsdesonerado() {
        return valorcofinsdesonerado;
    }

    public void setValorcofinsdesonerado(BigDecimal valorcofinsdesonerado) {
        this.valorcofinsdesonerado = valorcofinsdesonerado;
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

    public BigDecimal getValorpisdesonerado() {
        return valorpisdesonerado;
    }

    public void setValorpisdesonerado(BigDecimal valorpisdesonerado) {
        this.valorpisdesonerado = valorpisdesonerado;
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

    public Integer getNumcfesatdevolucao() {
        return numcfesatdevolucao;
    }

    public void setNumcfesatdevolucao(Integer numcfesatdevolucao) {
        this.numcfesatdevolucao = numcfesatdevolucao;
    }

    public Date getDatacupomdevolucao() {
        return datacupomdevolucao;
    }

    public void setDatacupomdevolucao(Date datacupomdevolucao) {
        this.datacupomdevolucao = datacupomdevolucao;
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

    public String getCodigolistaservico() {
        return codigolistaservico;
    }

    public void setCodigolistaservico(String codigolistaservico) {
        this.codigolistaservico = codigolistaservico;
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

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCodigoanp() {
        return codigoanp;
    }

    public void setCodigoanp(String codigoanp) {
        this.codigoanp = codigoanp;
    }

    public String getDescprodutoanp() {
        return descprodutoanp;
    }

    public void setDescprodutoanp(String descprodutoanp) {
        this.descprodutoanp = descprodutoanp;
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

    public Character getFlagloterastreavel() {
        return flagloterastreavel;
    }

    public void setFlagloterastreavel(Character flagloterastreavel) {
        this.flagloterastreavel = flagloterastreavel;
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

    public BigDecimal getAliqmva() {
        return aliqmva;
    }

    public void setAliqmva(BigDecimal aliqmva) {
        this.aliqmva = aliqmva;
    }

    public BigDecimal getAliqreducaobasesubsttributaria() {
        return aliqreducaobasesubsttributaria;
    }

    public void setAliqreducaobasesubsttributaria(BigDecimal aliqreducaobasesubsttributaria) {
        this.aliqreducaobasesubsttributaria = aliqreducaobasesubsttributaria;
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

    public BigDecimal getBaseicmsfcpdestino() {
        return baseicmsfcpdestino;
    }

    public void setBaseicmsfcpdestino(BigDecimal baseicmsfcpdestino) {
        this.baseicmsfcpdestino = baseicmsfcpdestino;
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

    public BigDecimal getAliqicmsstconsumidor() {
        return aliqicmsstconsumidor;
    }

    public void setAliqicmsstconsumidor(BigDecimal aliqicmsstconsumidor) {
        this.aliqicmsstconsumidor = aliqicmsstconsumidor;
    }

    public BigDecimal getValoricmsstsubstituto() {
        return valoricmsstsubstituto;
    }

    public void setValoricmsstsubstituto(BigDecimal valoricmsstsubstituto) {
        this.valoricmsstsubstituto = valoricmsstsubstituto;
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

    public String getCodbeneficiofiscal() {
        return codbeneficiofiscal;
    }

    public void setCodbeneficiofiscal(String codbeneficiofiscal) {
        this.codbeneficiofiscal = codbeneficiofiscal;
    }

    public BigDecimal getBaseicmsdeduzido() {
        return baseicmsdeduzido;
    }

    public void setBaseicmsdeduzido(BigDecimal baseicmsdeduzido) {
        this.baseicmsdeduzido = baseicmsdeduzido;
    }

    public String getDescricaoclassificacaofiscal() {
        return descricaoclassificacaofiscal;
    }

    public void setDescricaoclassificacaofiscal(String descricaoclassificacaofiscal) {
        this.descricaoclassificacaofiscal = descricaoclassificacaofiscal;
    }

    public String getCodcalculoicms() {
        return codcalculoicms;
    }

    public void setCodcalculoicms(String codcalculoicms) {
        this.codcalculoicms = codcalculoicms;
    }

    public Character getProdutoperigoso() {
        return produtoperigoso;
    }

    public void setProdutoperigoso(Character produtoperigoso) {
        this.produtoperigoso = produtoperigoso;
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

    public String getCodigoonu() {
        return codigoonu;
    }

    public void setCodigoonu(String codigoonu) {
        this.codigoonu = codigoonu;
    }

    public String getDescricaoprodutoperigosoclasse() {
        return descricaoprodutoperigosoclasse;
    }

    public void setDescricaoprodutoperigosoclasse(String descricaoprodutoperigosoclasse) {
        this.descricaoprodutoperigosoclasse = descricaoprodutoperigosoclasse;
    }

    public String getNomeprodembarque() {
        return nomeprodembarque;
    }

    public void setNomeprodembarque(String nomeprodembarque) {
        this.nomeprodembarque = nomeprodembarque;
    }

    public String getCodigogrupoembalagem() {
        return codigogrupoembalagem;
    }

    public void setCodigogrupoembalagem(String codigogrupoembalagem) {
        this.codigogrupoembalagem = codigogrupoembalagem;
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

    public BigDecimal getValorunitariotrib() {
        return valorunitariotrib;
    }

    public void setValorunitariotrib(BigDecimal valorunitariotrib) {
        this.valorunitariotrib = valorunitariotrib;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumentoitem != null ? codtmpDocumentoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumentoitem)) {
            return false;
        }
        TmpDocumentoitem other = (TmpDocumentoitem) object;
        if ((this.codtmpDocumentoitem == null && other.codtmpDocumentoitem != null) || (this.codtmpDocumentoitem != null && !this.codtmpDocumentoitem.equals(other.codtmpDocumentoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumentoitem[ codtmpDocumentoitem=" + codtmpDocumentoitem + " ]";
    }
    
}
