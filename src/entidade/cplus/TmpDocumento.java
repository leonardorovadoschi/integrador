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
@Table(name = "TMP_DOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpDocumento.findAll", query = "SELECT t FROM TmpDocumento t")
    , @NamedQuery(name = "TmpDocumento.findByCodtmpDocumento", query = "SELECT t FROM TmpDocumento t WHERE t.codtmpDocumento = :codtmpDocumento")
    , @NamedQuery(name = "TmpDocumento.findByNomevendedor", query = "SELECT t FROM TmpDocumento t WHERE t.nomevendedor = :nomevendedor")
    , @NamedQuery(name = "TmpDocumento.findByFormapagamento", query = "SELECT t FROM TmpDocumento t WHERE t.formapagamento = :formapagamento")
    , @NamedQuery(name = "TmpDocumento.findByEmitrazaosocial", query = "SELECT t FROM TmpDocumento t WHERE t.emitrazaosocial = :emitrazaosocial")
    , @NamedQuery(name = "TmpDocumento.findByEmitfantasia", query = "SELECT t FROM TmpDocumento t WHERE t.emitfantasia = :emitfantasia")
    , @NamedQuery(name = "TmpDocumento.findByEmitendereco", query = "SELECT t FROM TmpDocumento t WHERE t.emitendereco = :emitendereco")
    , @NamedQuery(name = "TmpDocumento.findByEmitnumerologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.emitnumerologradouro = :emitnumerologradouro")
    , @NamedQuery(name = "TmpDocumento.findByEmitcomplementologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.emitcomplementologradouro = :emitcomplementologradouro")
    , @NamedQuery(name = "TmpDocumento.findByEmitbairro", query = "SELECT t FROM TmpDocumento t WHERE t.emitbairro = :emitbairro")
    , @NamedQuery(name = "TmpDocumento.findByEmitcidade", query = "SELECT t FROM TmpDocumento t WHERE t.emitcidade = :emitcidade")
    , @NamedQuery(name = "TmpDocumento.findByEmitestado", query = "SELECT t FROM TmpDocumento t WHERE t.emitestado = :emitestado")
    , @NamedQuery(name = "TmpDocumento.findByEmitcep", query = "SELECT t FROM TmpDocumento t WHERE t.emitcep = :emitcep")
    , @NamedQuery(name = "TmpDocumento.findByEmittelefone", query = "SELECT t FROM TmpDocumento t WHERE t.emittelefone = :emittelefone")
    , @NamedQuery(name = "TmpDocumento.findByEmitinscr", query = "SELECT t FROM TmpDocumento t WHERE t.emitinscr = :emitinscr")
    , @NamedQuery(name = "TmpDocumento.findByEmitinscrsubsttrib", query = "SELECT t FROM TmpDocumento t WHERE t.emitinscrsubsttrib = :emitinscrsubsttrib")
    , @NamedQuery(name = "TmpDocumento.findByEmitcnae", query = "SELECT t FROM TmpDocumento t WHERE t.emitcnae = :emitcnae")
    , @NamedQuery(name = "TmpDocumento.findByChaveacessonfeletronica", query = "SELECT t FROM TmpDocumento t WHERE t.chaveacessonfeletronica = :chaveacessonfeletronica")
    , @NamedQuery(name = "TmpDocumento.findByChaveacessonfereferenciada", query = "SELECT t FROM TmpDocumento t WHERE t.chaveacessonfereferenciada = :chaveacessonfereferenciada")
    , @NamedQuery(name = "TmpDocumento.findByCoddocumentoreferenciado", query = "SELECT t FROM TmpDocumento t WHERE t.coddocumentoreferenciado = :coddocumentoreferenciado")
    , @NamedQuery(name = "TmpDocumento.findByEmitinscricaomunicipal", query = "SELECT t FROM TmpDocumento t WHERE t.emitinscricaomunicipal = :emitinscricaomunicipal")
    , @NamedQuery(name = "TmpDocumento.findByEmitcnpjcpf", query = "SELECT t FROM TmpDocumento t WHERE t.emitcnpjcpf = :emitcnpjcpf")
    , @NamedQuery(name = "TmpDocumento.findByEmitsuframa", query = "SELECT t FROM TmpDocumento t WHERE t.emitsuframa = :emitsuframa")
    , @NamedQuery(name = "TmpDocumento.findByDestrazaosocial", query = "SELECT t FROM TmpDocumento t WHERE t.destrazaosocial = :destrazaosocial")
    , @NamedQuery(name = "TmpDocumento.findByDestfantasia", query = "SELECT t FROM TmpDocumento t WHERE t.destfantasia = :destfantasia")
    , @NamedQuery(name = "TmpDocumento.findByDestendereco", query = "SELECT t FROM TmpDocumento t WHERE t.destendereco = :destendereco")
    , @NamedQuery(name = "TmpDocumento.findByDestnumerologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.destnumerologradouro = :destnumerologradouro")
    , @NamedQuery(name = "TmpDocumento.findByDestcomplementologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.destcomplementologradouro = :destcomplementologradouro")
    , @NamedQuery(name = "TmpDocumento.findByDestbairro", query = "SELECT t FROM TmpDocumento t WHERE t.destbairro = :destbairro")
    , @NamedQuery(name = "TmpDocumento.findByDestcidade", query = "SELECT t FROM TmpDocumento t WHERE t.destcidade = :destcidade")
    , @NamedQuery(name = "TmpDocumento.findByDestestado", query = "SELECT t FROM TmpDocumento t WHERE t.destestado = :destestado")
    , @NamedQuery(name = "TmpDocumento.findByDestcep", query = "SELECT t FROM TmpDocumento t WHERE t.destcep = :destcep")
    , @NamedQuery(name = "TmpDocumento.findByDesttelefone", query = "SELECT t FROM TmpDocumento t WHERE t.desttelefone = :desttelefone")
    , @NamedQuery(name = "TmpDocumento.findByDestinscr", query = "SELECT t FROM TmpDocumento t WHERE t.destinscr = :destinscr")
    , @NamedQuery(name = "TmpDocumento.findByDestcnpjcpf", query = "SELECT t FROM TmpDocumento t WHERE t.destcnpjcpf = :destcnpjcpf")
    , @NamedQuery(name = "TmpDocumento.findByDestsuframa", query = "SELECT t FROM TmpDocumento t WHERE t.destsuframa = :destsuframa")
    , @NamedQuery(name = "TmpDocumento.findByDesttipopessoa", query = "SELECT t FROM TmpDocumento t WHERE t.desttipopessoa = :desttipopessoa")
    , @NamedQuery(name = "TmpDocumento.findByDestemail", query = "SELECT t FROM TmpDocumento t WHERE t.destemail = :destemail")
    , @NamedQuery(name = "TmpDocumento.findByCodtransredespacho", query = "SELECT t FROM TmpDocumento t WHERE t.codtransredespacho = :codtransredespacho")
    , @NamedQuery(name = "TmpDocumento.findByCodtrans", query = "SELECT t FROM TmpDocumento t WHERE t.codtrans = :codtrans")
    , @NamedQuery(name = "TmpDocumento.findByTranspnome", query = "SELECT t FROM TmpDocumento t WHERE t.transpnome = :transpnome")
    , @NamedQuery(name = "TmpDocumento.findByTranspendereco", query = "SELECT t FROM TmpDocumento t WHERE t.transpendereco = :transpendereco")
    , @NamedQuery(name = "TmpDocumento.findByTranspbairro", query = "SELECT t FROM TmpDocumento t WHERE t.transpbairro = :transpbairro")
    , @NamedQuery(name = "TmpDocumento.findByTranspcidade", query = "SELECT t FROM TmpDocumento t WHERE t.transpcidade = :transpcidade")
    , @NamedQuery(name = "TmpDocumento.findByTranspestado", query = "SELECT t FROM TmpDocumento t WHERE t.transpestado = :transpestado")
    , @NamedQuery(name = "TmpDocumento.findByTranspcnpj", query = "SELECT t FROM TmpDocumento t WHERE t.transpcnpj = :transpcnpj")
    , @NamedQuery(name = "TmpDocumento.findByTranspinscr", query = "SELECT t FROM TmpDocumento t WHERE t.transpinscr = :transpinscr")
    , @NamedQuery(name = "TmpDocumento.findByTransplocalembarque", query = "SELECT t FROM TmpDocumento t WHERE t.transplocalembarque = :transplocalembarque")
    , @NamedQuery(name = "TmpDocumento.findByTranspufembarque", query = "SELECT t FROM TmpDocumento t WHERE t.transpufembarque = :transpufembarque")
    , @NamedQuery(name = "TmpDocumento.findByValortotalprodutos", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalprodutos = :valortotalprodutos")
    , @NamedQuery(name = "TmpDocumento.findByValortotalservicos", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalservicos = :valortotalservicos")
    , @NamedQuery(name = "TmpDocumento.findByValortotalitens", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalitens = :valortotalitens")
    , @NamedQuery(name = "TmpDocumento.findByValoroutrasdespesas", query = "SELECT t FROM TmpDocumento t WHERE t.valoroutrasdespesas = :valoroutrasdespesas")
    , @NamedQuery(name = "TmpDocumento.findByPesobruto", query = "SELECT t FROM TmpDocumento t WHERE t.pesobruto = :pesobruto")
    , @NamedQuery(name = "TmpDocumento.findByPesoliquido", query = "SELECT t FROM TmpDocumento t WHERE t.pesoliquido = :pesoliquido")
    , @NamedQuery(name = "TmpDocumento.findByBaseicms", query = "SELECT t FROM TmpDocumento t WHERE t.baseicms = :baseicms")
    , @NamedQuery(name = "TmpDocumento.findByValoricms", query = "SELECT t FROM TmpDocumento t WHERE t.valoricms = :valoricms")
    , @NamedQuery(name = "TmpDocumento.findByBasesubsttributaria", query = "SELECT t FROM TmpDocumento t WHERE t.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "TmpDocumento.findByValorsubsttributaria", query = "SELECT t FROM TmpDocumento t WHERE t.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "TmpDocumento.findByValorfrete", query = "SELECT t FROM TmpDocumento t WHERE t.valorfrete = :valorfrete")
    , @NamedQuery(name = "TmpDocumento.findByValorseguro", query = "SELECT t FROM TmpDocumento t WHERE t.valorseguro = :valorseguro")
    , @NamedQuery(name = "TmpDocumento.findByValortotalipi", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalipi = :valortotalipi")
    , @NamedQuery(name = "TmpDocumento.findByValortotalii", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalii = :valortotalii")
    , @NamedQuery(name = "TmpDocumento.findByValortotalpis", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalpis = :valortotalpis")
    , @NamedQuery(name = "TmpDocumento.findByValortotalcofins", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalcofins = :valortotalcofins")
    , @NamedQuery(name = "TmpDocumento.findByValordesconto", query = "SELECT t FROM TmpDocumento t WHERE t.valordesconto = :valordesconto")
    , @NamedQuery(name = "TmpDocumento.findByValoracrescimo", query = "SELECT t FROM TmpDocumento t WHERE t.valoracrescimo = :valoracrescimo")
    , @NamedQuery(name = "TmpDocumento.findByValortotalnota", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalnota = :valortotalnota")
    , @NamedQuery(name = "TmpDocumento.findByCfops", query = "SELECT t FROM TmpDocumento t WHERE t.cfops = :cfops")
    , @NamedQuery(name = "TmpDocumento.findByDataemissao", query = "SELECT t FROM TmpDocumento t WHERE t.dataemissao = :dataemissao")
    , @NamedQuery(name = "TmpDocumento.findByDatasaida", query = "SELECT t FROM TmpDocumento t WHERE t.datasaida = :datasaida")
    , @NamedQuery(name = "TmpDocumento.findByHorasaida", query = "SELECT t FROM TmpDocumento t WHERE t.horasaida = :horasaida")
    , @NamedQuery(name = "TmpDocumento.findByDadosadicionais", query = "SELECT t FROM TmpDocumento t WHERE t.dadosadicionais = :dadosadicionais")
    , @NamedQuery(name = "TmpDocumento.findByCodcfop", query = "SELECT t FROM TmpDocumento t WHERE t.codcfop = :codcfop")
    , @NamedQuery(name = "TmpDocumento.findByNaturezaoperacao", query = "SELECT t FROM TmpDocumento t WHERE t.naturezaoperacao = :naturezaoperacao")
    , @NamedQuery(name = "TmpDocumento.findByNumerocaixa", query = "SELECT t FROM TmpDocumento t WHERE t.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "TmpDocumento.findByNumerotransferencia", query = "SELECT t FROM TmpDocumento t WHERE t.numerotransferencia = :numerotransferencia")
    , @NamedQuery(name = "TmpDocumento.findByNumeropedidoexterno", query = "SELECT t FROM TmpDocumento t WHERE t.numeropedidoexterno = :numeropedidoexterno")
    , @NamedQuery(name = "TmpDocumento.findByCampostr1", query = "SELECT t FROM TmpDocumento t WHERE t.campostr1 = :campostr1")
    , @NamedQuery(name = "TmpDocumento.findByCampovalor1", query = "SELECT t FROM TmpDocumento t WHERE t.campovalor1 = :campovalor1")
    , @NamedQuery(name = "TmpDocumento.findByPesoadicionalembalagem", query = "SELECT t FROM TmpDocumento t WHERE t.pesoadicionalembalagem = :pesoadicionalembalagem")
    , @NamedQuery(name = "TmpDocumento.findByNumeropedido", query = "SELECT t FROM TmpDocumento t WHERE t.numeropedido = :numeropedido")
    , @NamedQuery(name = "TmpDocumento.findByNumerocupomfiscal", query = "SELECT t FROM TmpDocumento t WHERE t.numerocupomfiscal = :numerocupomfiscal")
    , @NamedQuery(name = "TmpDocumento.findByMensagem", query = "SELECT t FROM TmpDocumento t WHERE t.mensagem = :mensagem")
    , @NamedQuery(name = "TmpDocumento.findByTranspantt", query = "SELECT t FROM TmpDocumento t WHERE t.transpantt = :transpantt")
    , @NamedQuery(name = "TmpDocumento.findByQuantidadevolumes", query = "SELECT t FROM TmpDocumento t WHERE t.quantidadevolumes = :quantidadevolumes")
    , @NamedQuery(name = "TmpDocumento.findByEspeciecarga", query = "SELECT t FROM TmpDocumento t WHERE t.especiecarga = :especiecarga")
    , @NamedQuery(name = "TmpDocumento.findByMarcacarga", query = "SELECT t FROM TmpDocumento t WHERE t.marcacarga = :marcacarga")
    , @NamedQuery(name = "TmpDocumento.findByNumerovolume", query = "SELECT t FROM TmpDocumento t WHERE t.numerovolume = :numerovolume")
    , @NamedQuery(name = "TmpDocumento.findByPlacaveiculo", query = "SELECT t FROM TmpDocumento t WHERE t.placaveiculo = :placaveiculo")
    , @NamedQuery(name = "TmpDocumento.findByEstadoplacaveiculo", query = "SELECT t FROM TmpDocumento t WHERE t.estadoplacaveiculo = :estadoplacaveiculo")
    , @NamedQuery(name = "TmpDocumento.findByCodempresa", query = "SELECT t FROM TmpDocumento t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "TmpDocumento.findByNumnota", query = "SELECT t FROM TmpDocumento t WHERE t.numnota = :numnota")
    , @NamedQuery(name = "TmpDocumento.findBySerienota", query = "SELECT t FROM TmpDocumento t WHERE t.serienota = :serienota")
    , @NamedQuery(name = "TmpDocumento.findByModelodocumento", query = "SELECT t FROM TmpDocumento t WHERE t.modelodocumento = :modelodocumento")
    , @NamedQuery(name = "TmpDocumento.findByFlagnfcomplementar", query = "SELECT t FROM TmpDocumento t WHERE t.flagnfcomplementar = :flagnfcomplementar")
    , @NamedQuery(name = "TmpDocumento.findByFlagnfajuste", query = "SELECT t FROM TmpDocumento t WHERE t.flagnfajuste = :flagnfajuste")
    , @NamedQuery(name = "TmpDocumento.findByFlagnfdevolucao", query = "SELECT t FROM TmpDocumento t WHERE t.flagnfdevolucao = :flagnfdevolucao")
    , @NamedQuery(name = "TmpDocumento.findByFlagdocreferenciado", query = "SELECT t FROM TmpDocumento t WHERE t.flagdocreferenciado = :flagdocreferenciado")
    , @NamedQuery(name = "TmpDocumento.findByIndpresenca", query = "SELECT t FROM TmpDocumento t WHERE t.indpresenca = :indpresenca")
    , @NamedQuery(name = "TmpDocumento.findByIdentificadordestino", query = "SELECT t FROM TmpDocumento t WHERE t.identificadordestino = :identificadordestino")
    , @NamedQuery(name = "TmpDocumento.findByIndoperacao", query = "SELECT t FROM TmpDocumento t WHERE t.indoperacao = :indoperacao")
    , @NamedQuery(name = "TmpDocumento.findByIndiedest", query = "SELECT t FROM TmpDocumento t WHERE t.indiedest = :indiedest")
    , @NamedQuery(name = "TmpDocumento.findByIdestrangeiro", query = "SELECT t FROM TmpDocumento t WHERE t.idestrangeiro = :idestrangeiro")
    , @NamedQuery(name = "TmpDocumento.findByValoriss", query = "SELECT t FROM TmpDocumento t WHERE t.valoriss = :valoriss")
    , @NamedQuery(name = "TmpDocumento.findByDestidentidade", query = "SELECT t FROM TmpDocumento t WHERE t.destidentidade = :destidentidade")
    , @NamedQuery(name = "TmpDocumento.findByDestnomeentidade", query = "SELECT t FROM TmpDocumento t WHERE t.destnomeentidade = :destnomeentidade")
    , @NamedQuery(name = "TmpDocumento.findByCobrancaendereco", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancaendereco = :cobrancaendereco")
    , @NamedQuery(name = "TmpDocumento.findByCobrancabairro", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancabairro = :cobrancabairro")
    , @NamedQuery(name = "TmpDocumento.findByCobrancacidade", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancacidade = :cobrancacidade")
    , @NamedQuery(name = "TmpDocumento.findByCobrancaestado", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancaestado = :cobrancaestado")
    , @NamedQuery(name = "TmpDocumento.findByCobrancacep", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancacep = :cobrancacep")
    , @NamedQuery(name = "TmpDocumento.findByCobrancatelefone", query = "SELECT t FROM TmpDocumento t WHERE t.cobrancatelefone = :cobrancatelefone")
    , @NamedQuery(name = "TmpDocumento.findByEntregaendereco", query = "SELECT t FROM TmpDocumento t WHERE t.entregaendereco = :entregaendereco")
    , @NamedQuery(name = "TmpDocumento.findByEntregabairro", query = "SELECT t FROM TmpDocumento t WHERE t.entregabairro = :entregabairro")
    , @NamedQuery(name = "TmpDocumento.findByEntregacidade", query = "SELECT t FROM TmpDocumento t WHERE t.entregacidade = :entregacidade")
    , @NamedQuery(name = "TmpDocumento.findByEntregaestado", query = "SELECT t FROM TmpDocumento t WHERE t.entregaestado = :entregaestado")
    , @NamedQuery(name = "TmpDocumento.findByEntregacep", query = "SELECT t FROM TmpDocumento t WHERE t.entregacep = :entregacep")
    , @NamedQuery(name = "TmpDocumento.findByEntregatelefone", query = "SELECT t FROM TmpDocumento t WHERE t.entregatelefone = :entregatelefone")
    , @NamedQuery(name = "TmpDocumento.findByEntregareferencia", query = "SELECT t FROM TmpDocumento t WHERE t.entregareferencia = :entregareferencia")
    , @NamedQuery(name = "TmpDocumento.findByCodfp", query = "SELECT t FROM TmpDocumento t WHERE t.codfp = :codfp")
    , @NamedQuery(name = "TmpDocumento.findByFlagtipo", query = "SELECT t FROM TmpDocumento t WHERE t.flagtipo = :flagtipo")
    , @NamedQuery(name = "TmpDocumento.findByCodvended", query = "SELECT t FROM TmpDocumento t WHERE t.codvended = :codvended")
    , @NamedQuery(name = "TmpDocumento.findByCodvendedext", query = "SELECT t FROM TmpDocumento t WHERE t.codvendedext = :codvendedext")
    , @NamedQuery(name = "TmpDocumento.findByCodtipomovimento", query = "SELECT t FROM TmpDocumento t WHERE t.codtipomovimento = :codtipomovimento")
    , @NamedQuery(name = "TmpDocumento.findByCodcli", query = "SELECT t FROM TmpDocumento t WHERE t.codcli = :codcli")
    , @NamedQuery(name = "TmpDocumento.findByDatavenda", query = "SELECT t FROM TmpDocumento t WHERE t.datavenda = :datavenda")
    , @NamedQuery(name = "TmpDocumento.findByAliqdesconto", query = "SELECT t FROM TmpDocumento t WHERE t.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "TmpDocumento.findByValoricmsdeduzido", query = "SELECT t FROM TmpDocumento t WHERE t.valoricmsdeduzido = :valoricmsdeduzido")
    , @NamedQuery(name = "TmpDocumento.findByValorcofinsdesonerado", query = "SELECT t FROM TmpDocumento t WHERE t.valorcofinsdesonerado = :valorcofinsdesonerado")
    , @NamedQuery(name = "TmpDocumento.findByValorpisdesonerado", query = "SELECT t FROM TmpDocumento t WHERE t.valorpisdesonerado = :valorpisdesonerado")
    , @NamedQuery(name = "TmpDocumento.findByCampostr2", query = "SELECT t FROM TmpDocumento t WHERE t.campostr2 = :campostr2")
    , @NamedQuery(name = "TmpDocumento.findByFlagtipodesconto", query = "SELECT t FROM TmpDocumento t WHERE t.flagtipodesconto = :flagtipodesconto")
    , @NamedQuery(name = "TmpDocumento.findByFlagtipoacrescimo", query = "SELECT t FROM TmpDocumento t WHERE t.flagtipoacrescimo = :flagtipoacrescimo")
    , @NamedQuery(name = "TmpDocumento.findByAliqacrescimo", query = "SELECT t FROM TmpDocumento t WHERE t.aliqacrescimo = :aliqacrescimo")
    , @NamedQuery(name = "TmpDocumento.findByBaseicmsdeduzido", query = "SELECT t FROM TmpDocumento t WHERE t.baseicmsdeduzido = :baseicmsdeduzido")
    , @NamedQuery(name = "TmpDocumento.findByCodempresatipodocumento", query = "SELECT t FROM TmpDocumento t WHERE t.codempresatipodocumento = :codempresatipodocumento")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura1", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura1 = :numerofatura1")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura1", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura1 = :vencimentofatura1")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura1", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura1 = :valorfatura1")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura1", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura1 = :codcrfatura1")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura2", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura2 = :numerofatura2")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura2", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura2 = :vencimentofatura2")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura2", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura2 = :valorfatura2")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura2", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura2 = :codcrfatura2")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura3", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura3 = :numerofatura3")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura3", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura3 = :vencimentofatura3")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura3", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura3 = :valorfatura3")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura3", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura3 = :codcrfatura3")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura4", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura4 = :numerofatura4")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura4", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura4 = :vencimentofatura4")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura4", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura4 = :valorfatura4")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura4", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura4 = :codcrfatura4")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura5", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura5 = :numerofatura5")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura5", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura5 = :vencimentofatura5")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura5", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura5 = :valorfatura5")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura5", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura5 = :codcrfatura5")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura6", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura6 = :numerofatura6")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura6", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura6 = :vencimentofatura6")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura6", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura6 = :valorfatura6")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura6", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura6 = :codcrfatura6")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura7", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura7 = :numerofatura7")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura7", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura7 = :vencimentofatura7")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura7", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura7 = :valorfatura7")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura7", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura7 = :codcrfatura7")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura8", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura8 = :numerofatura8")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura8", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura8 = :vencimentofatura8")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura8", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura8 = :valorfatura8")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura8", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura8 = :codcrfatura8")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura9", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura9 = :numerofatura9")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura9", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura9 = :vencimentofatura9")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura9", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura9 = :valorfatura9")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura9", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura9 = :codcrfatura9")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura10", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura10 = :numerofatura10")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura10", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura10 = :vencimentofatura10")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura10", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura10 = :valorfatura10")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura10", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura10 = :codcrfatura10")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura11", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura11 = :numerofatura11")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura11", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura11 = :vencimentofatura11")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura11", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura11 = :valorfatura11")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura11", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura11 = :codcrfatura11")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura12", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura12 = :numerofatura12")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura12", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura12 = :vencimentofatura12")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura12", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura12 = :valorfatura12")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura12", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura12 = :codcrfatura12")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura13", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura13 = :numerofatura13")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura13", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura13 = :vencimentofatura13")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura13", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura13 = :valorfatura13")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura13", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura13 = :codcrfatura13")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura14", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura14 = :numerofatura14")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura14", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura14 = :vencimentofatura14")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura14", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura14 = :valorfatura14")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura14", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura14 = :codcrfatura14")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura15", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura15 = :numerofatura15")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura15", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura15 = :vencimentofatura15")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura15", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura15 = :valorfatura15")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura15", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura15 = :codcrfatura15")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura16", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura16 = :numerofatura16")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura16", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura16 = :vencimentofatura16")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura16", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura16 = :valorfatura16")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura16", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura16 = :codcrfatura16")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura17", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura17 = :numerofatura17")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura17", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura17 = :vencimentofatura17")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura17", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura17 = :valorfatura17")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura17", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura17 = :codcrfatura17")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura18", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura18 = :numerofatura18")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura18", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura18 = :vencimentofatura18")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura18", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura18 = :valorfatura18")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura18", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura18 = :codcrfatura18")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura19", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura19 = :numerofatura19")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura19", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura19 = :vencimentofatura19")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura19", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura19 = :valorfatura19")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura19", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura19 = :codcrfatura19")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura20", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura20 = :numerofatura20")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura20", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura20 = :vencimentofatura20")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura20", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura20 = :valorfatura20")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura20", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura20 = :codcrfatura20")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura21", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura21 = :numerofatura21")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura21", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura21 = :vencimentofatura21")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura21", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura21 = :valorfatura21")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura21", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura21 = :codcrfatura21")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura22", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura22 = :numerofatura22")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura22", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura22 = :vencimentofatura22")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura22", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura22 = :valorfatura22")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura22", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura22 = :codcrfatura22")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura23", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura23 = :numerofatura23")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura23", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura23 = :vencimentofatura23")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura23", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura23 = :valorfatura23")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura23", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura23 = :codcrfatura23")
    , @NamedQuery(name = "TmpDocumento.findByNumerofatura24", query = "SELECT t FROM TmpDocumento t WHERE t.numerofatura24 = :numerofatura24")
    , @NamedQuery(name = "TmpDocumento.findByVencimentofatura24", query = "SELECT t FROM TmpDocumento t WHERE t.vencimentofatura24 = :vencimentofatura24")
    , @NamedQuery(name = "TmpDocumento.findByValorfatura24", query = "SELECT t FROM TmpDocumento t WHERE t.valorfatura24 = :valorfatura24")
    , @NamedQuery(name = "TmpDocumento.findByCodcrfatura24", query = "SELECT t FROM TmpDocumento t WHERE t.codcrfatura24 = :codcrfatura24")
    , @NamedQuery(name = "TmpDocumento.findByCodsetorestoque", query = "SELECT t FROM TmpDocumento t WHERE t.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "TmpDocumento.findByTributofederal", query = "SELECT t FROM TmpDocumento t WHERE t.tributofederal = :tributofederal")
    , @NamedQuery(name = "TmpDocumento.findByTributoestadual", query = "SELECT t FROM TmpDocumento t WHERE t.tributoestadual = :tributoestadual")
    , @NamedQuery(name = "TmpDocumento.findByTributomunicipal", query = "SELECT t FROM TmpDocumento t WHERE t.tributomunicipal = :tributomunicipal")
    , @NamedQuery(name = "TmpDocumento.findByValortotalipidevolvido", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalipidevolvido = :valortotalipidevolvido")
    , @NamedQuery(name = "TmpDocumento.findByAliqaprox", query = "SELECT t FROM TmpDocumento t WHERE t.aliqaprox = :aliqaprox")
    , @NamedQuery(name = "TmpDocumento.findByValorfcp", query = "SELECT t FROM TmpDocumento t WHERE t.valorfcp = :valorfcp")
    , @NamedQuery(name = "TmpDocumento.findByValorfcpsubsttributaria", query = "SELECT t FROM TmpDocumento t WHERE t.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "TmpDocumento.findByValorfcppart", query = "SELECT t FROM TmpDocumento t WHERE t.valorfcppart = :valorfcppart")
    , @NamedQuery(name = "TmpDocumento.findByValoricmsdestinopart", query = "SELECT t FROM TmpDocumento t WHERE t.valoricmsdestinopart = :valoricmsdestinopart")
    , @NamedQuery(name = "TmpDocumento.findByValoricmsorigempart", query = "SELECT t FROM TmpDocumento t WHERE t.valoricmsorigempart = :valoricmsorigempart")
    , @NamedQuery(name = "TmpDocumento.findByValortotalfatura", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalfatura = :valortotalfatura")
    , @NamedQuery(name = "TmpDocumento.findByValortroco", query = "SELECT t FROM TmpDocumento t WHERE t.valortroco = :valortroco")
    , @NamedQuery(name = "TmpDocumento.findByCodmodalidadefrete", query = "SELECT t FROM TmpDocumento t WHERE t.codmodalidadefrete = :codmodalidadefrete")
    , @NamedQuery(name = "TmpDocumento.findByNumpedcliente", query = "SELECT t FROM TmpDocumento t WHERE t.numpedcliente = :numpedcliente")
    , @NamedQuery(name = "TmpDocumento.findByNumcupom", query = "SELECT t FROM TmpDocumento t WHERE t.numcupom = :numcupom")
    , @NamedQuery(name = "TmpDocumento.findByEntreganumerologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.entreganumerologradouro = :entreganumerologradouro")
    , @NamedQuery(name = "TmpDocumento.findByEntregacomplementologradouro", query = "SELECT t FROM TmpDocumento t WHERE t.entregacomplementologradouro = :entregacomplementologradouro")
    , @NamedQuery(name = "TmpDocumento.findByValortotalpisissqn", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalpisissqn = :valortotalpisissqn")
    , @NamedQuery(name = "TmpDocumento.findByValortotalcofinsissqn", query = "SELECT t FROM TmpDocumento t WHERE t.valortotalcofinsissqn = :valortotalcofinsissqn")})
public class TmpDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_DOCUMENTO")
    private Integer codtmpDocumento;
    @Column(name = "NOMEVENDEDOR")
    private String nomevendedor;
    @Column(name = "FORMAPAGAMENTO")
    private String formapagamento;
    @Column(name = "EMITRAZAOSOCIAL")
    private String emitrazaosocial;
    @Column(name = "EMITFANTASIA")
    private String emitfantasia;
    @Column(name = "EMITENDERECO")
    private String emitendereco;
    @Column(name = "EMITNUMEROLOGRADOURO")
    private String emitnumerologradouro;
    @Column(name = "EMITCOMPLEMENTOLOGRADOURO")
    private String emitcomplementologradouro;
    @Column(name = "EMITBAIRRO")
    private String emitbairro;
    @Column(name = "EMITCIDADE")
    private String emitcidade;
    @Column(name = "EMITESTADO")
    private String emitestado;
    @Column(name = "EMITCEP")
    private String emitcep;
    @Column(name = "EMITTELEFONE")
    private String emittelefone;
    @Column(name = "EMITINSCR")
    private String emitinscr;
    @Column(name = "EMITINSCRSUBSTTRIB")
    private String emitinscrsubsttrib;
    @Column(name = "EMITCNAE")
    private String emitcnae;
    @Column(name = "CHAVEACESSONFELETRONICA")
    private String chaveacessonfeletronica;
    @Column(name = "CHAVEACESSONFEREFERENCIADA")
    private String chaveacessonfereferenciada;
    @Column(name = "CODDOCUMENTOREFERENCIADO")
    private String coddocumentoreferenciado;
    @Column(name = "EMITINSCRICAOMUNICIPAL")
    private String emitinscricaomunicipal;
    @Column(name = "EMITCNPJCPF")
    private String emitcnpjcpf;
    @Column(name = "EMITSUFRAMA")
    private String emitsuframa;
    @Column(name = "DESTRAZAOSOCIAL")
    private String destrazaosocial;
    @Column(name = "DESTFANTASIA")
    private String destfantasia;
    @Column(name = "DESTENDERECO")
    private String destendereco;
    @Column(name = "DESTNUMEROLOGRADOURO")
    private String destnumerologradouro;
    @Column(name = "DESTCOMPLEMENTOLOGRADOURO")
    private String destcomplementologradouro;
    @Column(name = "DESTBAIRRO")
    private String destbairro;
    @Column(name = "DESTCIDADE")
    private String destcidade;
    @Column(name = "DESTESTADO")
    private String destestado;
    @Column(name = "DESTCEP")
    private String destcep;
    @Column(name = "DESTTELEFONE")
    private String desttelefone;
    @Column(name = "DESTINSCR")
    private String destinscr;
    @Column(name = "DESTCNPJCPF")
    private String destcnpjcpf;
    @Column(name = "DESTSUFRAMA")
    private String destsuframa;
    @Column(name = "DESTTIPOPESSOA")
    private Character desttipopessoa;
    @Column(name = "DESTEMAIL")
    private String destemail;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Column(name = "CODTRANS")
    private String codtrans;
    @Column(name = "TRANSPNOME")
    private String transpnome;
    @Column(name = "TRANSPENDERECO")
    private String transpendereco;
    @Column(name = "TRANSPBAIRRO")
    private String transpbairro;
    @Column(name = "TRANSPCIDADE")
    private String transpcidade;
    @Column(name = "TRANSPESTADO")
    private String transpestado;
    @Column(name = "TRANSPCNPJ")
    private String transpcnpj;
    @Column(name = "TRANSPINSCR")
    private String transpinscr;
    @Column(name = "TRANSPLOCALEMBARQUE")
    private String transplocalembarque;
    @Column(name = "TRANSPUFEMBARQUE")
    private String transpufembarque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALITENS")
    private BigDecimal valortotalitens;
    @Column(name = "VALOROUTRASDESPESAS")
    private BigDecimal valoroutrasdespesas;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "VALORSEGURO")
    private BigDecimal valorseguro;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Column(name = "VALORTOTALII")
    private BigDecimal valortotalii;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "CFOPS")
    private String cfops;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "HORASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horasaida;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Lob
    @Column(name = "OBSERVACAONOTAFISCAL")
    private String observacaonotafiscal;
    @Column(name = "DADOSADICIONAIS")
    private String dadosadicionais;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "NATUREZAOPERACAO")
    private String naturezaoperacao;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "NUMEROTRANSFERENCIA")
    private Integer numerotransferencia;
    @Column(name = "NUMEROPEDIDOEXTERNO")
    private Integer numeropedidoexterno;
    @Column(name = "CAMPOSTR1")
    private String campostr1;
    @Column(name = "CAMPOVALOR1")
    private BigDecimal campovalor1;
    @Column(name = "PESOADICIONALEMBALAGEM")
    private BigDecimal pesoadicionalembalagem;
    @Column(name = "NUMEROPEDIDO")
    private Integer numeropedido;
    @Column(name = "NUMEROCUPOMFISCAL")
    private Integer numerocupomfiscal;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Column(name = "TRANSPANTT")
    private String transpantt;
    @Column(name = "QUANTIDADEVOLUMES")
    private Integer quantidadevolumes;
    @Column(name = "ESPECIECARGA")
    private String especiecarga;
    @Column(name = "MARCACARGA")
    private String marcacarga;
    @Column(name = "NUMEROVOLUME")
    private String numerovolume;
    @Column(name = "PLACAVEICULO")
    private String placaveiculo;
    @Column(name = "ESTADOPLACAVEICULO")
    private String estadoplacaveiculo;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "MODELODOCUMENTO")
    private String modelodocumento;
    @Column(name = "FLAGNFCOMPLEMENTAR")
    private Character flagnfcomplementar;
    @Column(name = "FLAGNFAJUSTE")
    private Character flagnfajuste;
    @Column(name = "FLAGNFDEVOLUCAO")
    private Character flagnfdevolucao;
    @Column(name = "FLAGDOCREFERENCIADO")
    private Character flagdocreferenciado;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "IDENTIFICADORDESTINO")
    private Character identificadordestino;
    @Column(name = "INDOPERACAO")
    private Character indoperacao;
    @Column(name = "INDIEDEST")
    private Character indiedest;
    @Column(name = "IDESTRANGEIRO")
    private String idestrangeiro;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Column(name = "DESTIDENTIDADE")
    private String destidentidade;
    @Column(name = "DESTNOMEENTIDADE")
    private String destnomeentidade;
    @Column(name = "COBRANCAENDERECO")
    private String cobrancaendereco;
    @Column(name = "COBRANCABAIRRO")
    private String cobrancabairro;
    @Column(name = "COBRANCACIDADE")
    private String cobrancacidade;
    @Column(name = "COBRANCAESTADO")
    private String cobrancaestado;
    @Column(name = "COBRANCACEP")
    private String cobrancacep;
    @Column(name = "COBRANCATELEFONE")
    private String cobrancatelefone;
    @Column(name = "ENTREGAENDERECO")
    private String entregaendereco;
    @Column(name = "ENTREGABAIRRO")
    private String entregabairro;
    @Column(name = "ENTREGACIDADE")
    private String entregacidade;
    @Column(name = "ENTREGAESTADO")
    private String entregaestado;
    @Column(name = "ENTREGACEP")
    private String entregacep;
    @Column(name = "ENTREGATELEFONE")
    private String entregatelefone;
    @Column(name = "ENTREGAREFERENCIA")
    private String entregareferencia;
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CODVENDEDEXT")
    private String codvendedext;
    @Column(name = "CODTIPOMOVIMENTO")
    private String codtipomovimento;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "DATAVENDA")
    @Temporal(TemporalType.DATE)
    private Date datavenda;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "VALORICMSDEDUZIDO")
    private BigDecimal valoricmsdeduzido;
    @Column(name = "VALORCOFINSDESONERADO")
    private BigDecimal valorcofinsdesonerado;
    @Column(name = "VALORPISDESONERADO")
    private BigDecimal valorpisdesonerado;
    @Column(name = "CAMPOSTR2")
    private String campostr2;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "BASEICMSDEDUZIDO")
    private BigDecimal baseicmsdeduzido;
    @Column(name = "CODEMPRESATIPODOCUMENTO")
    private String codempresatipodocumento;
    @Column(name = "NUMEROFATURA1")
    private String numerofatura1;
    @Column(name = "VENCIMENTOFATURA1")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura1;
    @Column(name = "VALORFATURA1")
    private BigDecimal valorfatura1;
    @Column(name = "CODCRFATURA1")
    private String codcrfatura1;
    @Column(name = "NUMEROFATURA2")
    private String numerofatura2;
    @Column(name = "VENCIMENTOFATURA2")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura2;
    @Column(name = "VALORFATURA2")
    private BigDecimal valorfatura2;
    @Column(name = "CODCRFATURA2")
    private String codcrfatura2;
    @Column(name = "NUMEROFATURA3")
    private String numerofatura3;
    @Column(name = "VENCIMENTOFATURA3")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura3;
    @Column(name = "VALORFATURA3")
    private BigDecimal valorfatura3;
    @Column(name = "CODCRFATURA3")
    private String codcrfatura3;
    @Column(name = "NUMEROFATURA4")
    private String numerofatura4;
    @Column(name = "VENCIMENTOFATURA4")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura4;
    @Column(name = "VALORFATURA4")
    private BigDecimal valorfatura4;
    @Column(name = "CODCRFATURA4")
    private String codcrfatura4;
    @Column(name = "NUMEROFATURA5")
    private String numerofatura5;
    @Column(name = "VENCIMENTOFATURA5")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura5;
    @Column(name = "VALORFATURA5")
    private BigDecimal valorfatura5;
    @Column(name = "CODCRFATURA5")
    private String codcrfatura5;
    @Column(name = "NUMEROFATURA6")
    private String numerofatura6;
    @Column(name = "VENCIMENTOFATURA6")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura6;
    @Column(name = "VALORFATURA6")
    private BigDecimal valorfatura6;
    @Column(name = "CODCRFATURA6")
    private String codcrfatura6;
    @Column(name = "NUMEROFATURA7")
    private String numerofatura7;
    @Column(name = "VENCIMENTOFATURA7")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura7;
    @Column(name = "VALORFATURA7")
    private BigDecimal valorfatura7;
    @Column(name = "CODCRFATURA7")
    private String codcrfatura7;
    @Column(name = "NUMEROFATURA8")
    private String numerofatura8;
    @Column(name = "VENCIMENTOFATURA8")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura8;
    @Column(name = "VALORFATURA8")
    private BigDecimal valorfatura8;
    @Column(name = "CODCRFATURA8")
    private String codcrfatura8;
    @Column(name = "NUMEROFATURA9")
    private String numerofatura9;
    @Column(name = "VENCIMENTOFATURA9")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura9;
    @Column(name = "VALORFATURA9")
    private BigDecimal valorfatura9;
    @Column(name = "CODCRFATURA9")
    private String codcrfatura9;
    @Column(name = "NUMEROFATURA10")
    private String numerofatura10;
    @Column(name = "VENCIMENTOFATURA10")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura10;
    @Column(name = "VALORFATURA10")
    private BigDecimal valorfatura10;
    @Column(name = "CODCRFATURA10")
    private String codcrfatura10;
    @Column(name = "NUMEROFATURA11")
    private String numerofatura11;
    @Column(name = "VENCIMENTOFATURA11")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura11;
    @Column(name = "VALORFATURA11")
    private BigDecimal valorfatura11;
    @Column(name = "CODCRFATURA11")
    private String codcrfatura11;
    @Column(name = "NUMEROFATURA12")
    private String numerofatura12;
    @Column(name = "VENCIMENTOFATURA12")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura12;
    @Column(name = "VALORFATURA12")
    private BigDecimal valorfatura12;
    @Column(name = "CODCRFATURA12")
    private String codcrfatura12;
    @Column(name = "NUMEROFATURA13")
    private String numerofatura13;
    @Column(name = "VENCIMENTOFATURA13")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura13;
    @Column(name = "VALORFATURA13")
    private BigDecimal valorfatura13;
    @Column(name = "CODCRFATURA13")
    private String codcrfatura13;
    @Column(name = "NUMEROFATURA14")
    private String numerofatura14;
    @Column(name = "VENCIMENTOFATURA14")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura14;
    @Column(name = "VALORFATURA14")
    private BigDecimal valorfatura14;
    @Column(name = "CODCRFATURA14")
    private String codcrfatura14;
    @Column(name = "NUMEROFATURA15")
    private String numerofatura15;
    @Column(name = "VENCIMENTOFATURA15")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura15;
    @Column(name = "VALORFATURA15")
    private BigDecimal valorfatura15;
    @Column(name = "CODCRFATURA15")
    private String codcrfatura15;
    @Column(name = "NUMEROFATURA16")
    private String numerofatura16;
    @Column(name = "VENCIMENTOFATURA16")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura16;
    @Column(name = "VALORFATURA16")
    private BigDecimal valorfatura16;
    @Column(name = "CODCRFATURA16")
    private String codcrfatura16;
    @Column(name = "NUMEROFATURA17")
    private String numerofatura17;
    @Column(name = "VENCIMENTOFATURA17")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura17;
    @Column(name = "VALORFATURA17")
    private BigDecimal valorfatura17;
    @Column(name = "CODCRFATURA17")
    private String codcrfatura17;
    @Column(name = "NUMEROFATURA18")
    private String numerofatura18;
    @Column(name = "VENCIMENTOFATURA18")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura18;
    @Column(name = "VALORFATURA18")
    private BigDecimal valorfatura18;
    @Column(name = "CODCRFATURA18")
    private String codcrfatura18;
    @Column(name = "NUMEROFATURA19")
    private String numerofatura19;
    @Column(name = "VENCIMENTOFATURA19")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura19;
    @Column(name = "VALORFATURA19")
    private BigDecimal valorfatura19;
    @Column(name = "CODCRFATURA19")
    private String codcrfatura19;
    @Column(name = "NUMEROFATURA20")
    private String numerofatura20;
    @Column(name = "VENCIMENTOFATURA20")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura20;
    @Column(name = "VALORFATURA20")
    private BigDecimal valorfatura20;
    @Column(name = "CODCRFATURA20")
    private String codcrfatura20;
    @Column(name = "NUMEROFATURA21")
    private String numerofatura21;
    @Column(name = "VENCIMENTOFATURA21")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura21;
    @Column(name = "VALORFATURA21")
    private BigDecimal valorfatura21;
    @Column(name = "CODCRFATURA21")
    private String codcrfatura21;
    @Column(name = "NUMEROFATURA22")
    private String numerofatura22;
    @Column(name = "VENCIMENTOFATURA22")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura22;
    @Column(name = "VALORFATURA22")
    private BigDecimal valorfatura22;
    @Column(name = "CODCRFATURA22")
    private String codcrfatura22;
    @Column(name = "NUMEROFATURA23")
    private String numerofatura23;
    @Column(name = "VENCIMENTOFATURA23")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura23;
    @Column(name = "VALORFATURA23")
    private BigDecimal valorfatura23;
    @Column(name = "CODCRFATURA23")
    private String codcrfatura23;
    @Column(name = "NUMEROFATURA24")
    private String numerofatura24;
    @Column(name = "VENCIMENTOFATURA24")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura24;
    @Column(name = "VALORFATURA24")
    private BigDecimal valorfatura24;
    @Column(name = "CODCRFATURA24")
    private String codcrfatura24;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "TRIBUTOFEDERAL")
    private BigDecimal tributofederal;
    @Column(name = "TRIBUTOESTADUAL")
    private BigDecimal tributoestadual;
    @Column(name = "TRIBUTOMUNICIPAL")
    private BigDecimal tributomunicipal;
    @Column(name = "VALORTOTALIPIDEVOLVIDO")
    private BigDecimal valortotalipidevolvido;
    @Column(name = "ALIQAPROX")
    private BigDecimal aliqaprox;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "VALORFCPPART")
    private BigDecimal valorfcppart;
    @Column(name = "VALORICMSDESTINOPART")
    private BigDecimal valoricmsdestinopart;
    @Column(name = "VALORICMSORIGEMPART")
    private BigDecimal valoricmsorigempart;
    @Column(name = "VALORTOTALFATURA")
    private BigDecimal valortotalfatura;
    @Column(name = "VALORTROCO")
    private BigDecimal valortroco;
    @Column(name = "CODMODALIDADEFRETE")
    private Character codmodalidadefrete;
    @Column(name = "NUMPEDCLIENTE")
    private String numpedcliente;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Lob
    @Column(name = "OBSFISCO")
    private String obsfisco;
    @Lob
    @Column(name = "EMAILCCDANFE")
    private String emailccdanfe;
    @Column(name = "ENTREGANUMEROLOGRADOURO")
    private String entreganumerologradouro;
    @Column(name = "ENTREGACOMPLEMENTOLOGRADOURO")
    private String entregacomplementologradouro;
    @Column(name = "VALORTOTALPISISSQN")
    private BigDecimal valortotalpisissqn;
    @Column(name = "VALORTOTALCOFINSISSQN")
    private BigDecimal valortotalcofinsissqn;

    public TmpDocumento() {
    }

    public TmpDocumento(Integer codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public Integer getCodtmpDocumento() {
        return codtmpDocumento;
    }

    public void setCodtmpDocumento(Integer codtmpDocumento) {
        this.codtmpDocumento = codtmpDocumento;
    }

    public String getNomevendedor() {
        return nomevendedor;
    }

    public void setNomevendedor(String nomevendedor) {
        this.nomevendedor = nomevendedor;
    }

    public String getFormapagamento() {
        return formapagamento;
    }

    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    public String getEmitrazaosocial() {
        return emitrazaosocial;
    }

    public void setEmitrazaosocial(String emitrazaosocial) {
        this.emitrazaosocial = emitrazaosocial;
    }

    public String getEmitfantasia() {
        return emitfantasia;
    }

    public void setEmitfantasia(String emitfantasia) {
        this.emitfantasia = emitfantasia;
    }

    public String getEmitendereco() {
        return emitendereco;
    }

    public void setEmitendereco(String emitendereco) {
        this.emitendereco = emitendereco;
    }

    public String getEmitnumerologradouro() {
        return emitnumerologradouro;
    }

    public void setEmitnumerologradouro(String emitnumerologradouro) {
        this.emitnumerologradouro = emitnumerologradouro;
    }

    public String getEmitcomplementologradouro() {
        return emitcomplementologradouro;
    }

    public void setEmitcomplementologradouro(String emitcomplementologradouro) {
        this.emitcomplementologradouro = emitcomplementologradouro;
    }

    public String getEmitbairro() {
        return emitbairro;
    }

    public void setEmitbairro(String emitbairro) {
        this.emitbairro = emitbairro;
    }

    public String getEmitcidade() {
        return emitcidade;
    }

    public void setEmitcidade(String emitcidade) {
        this.emitcidade = emitcidade;
    }

    public String getEmitestado() {
        return emitestado;
    }

    public void setEmitestado(String emitestado) {
        this.emitestado = emitestado;
    }

    public String getEmitcep() {
        return emitcep;
    }

    public void setEmitcep(String emitcep) {
        this.emitcep = emitcep;
    }

    public String getEmittelefone() {
        return emittelefone;
    }

    public void setEmittelefone(String emittelefone) {
        this.emittelefone = emittelefone;
    }

    public String getEmitinscr() {
        return emitinscr;
    }

    public void setEmitinscr(String emitinscr) {
        this.emitinscr = emitinscr;
    }

    public String getEmitinscrsubsttrib() {
        return emitinscrsubsttrib;
    }

    public void setEmitinscrsubsttrib(String emitinscrsubsttrib) {
        this.emitinscrsubsttrib = emitinscrsubsttrib;
    }

    public String getEmitcnae() {
        return emitcnae;
    }

    public void setEmitcnae(String emitcnae) {
        this.emitcnae = emitcnae;
    }

    public String getChaveacessonfeletronica() {
        return chaveacessonfeletronica;
    }

    public void setChaveacessonfeletronica(String chaveacessonfeletronica) {
        this.chaveacessonfeletronica = chaveacessonfeletronica;
    }

    public String getChaveacessonfereferenciada() {
        return chaveacessonfereferenciada;
    }

    public void setChaveacessonfereferenciada(String chaveacessonfereferenciada) {
        this.chaveacessonfereferenciada = chaveacessonfereferenciada;
    }

    public String getCoddocumentoreferenciado() {
        return coddocumentoreferenciado;
    }

    public void setCoddocumentoreferenciado(String coddocumentoreferenciado) {
        this.coddocumentoreferenciado = coddocumentoreferenciado;
    }

    public String getEmitinscricaomunicipal() {
        return emitinscricaomunicipal;
    }

    public void setEmitinscricaomunicipal(String emitinscricaomunicipal) {
        this.emitinscricaomunicipal = emitinscricaomunicipal;
    }

    public String getEmitcnpjcpf() {
        return emitcnpjcpf;
    }

    public void setEmitcnpjcpf(String emitcnpjcpf) {
        this.emitcnpjcpf = emitcnpjcpf;
    }

    public String getEmitsuframa() {
        return emitsuframa;
    }

    public void setEmitsuframa(String emitsuframa) {
        this.emitsuframa = emitsuframa;
    }

    public String getDestrazaosocial() {
        return destrazaosocial;
    }

    public void setDestrazaosocial(String destrazaosocial) {
        this.destrazaosocial = destrazaosocial;
    }

    public String getDestfantasia() {
        return destfantasia;
    }

    public void setDestfantasia(String destfantasia) {
        this.destfantasia = destfantasia;
    }

    public String getDestendereco() {
        return destendereco;
    }

    public void setDestendereco(String destendereco) {
        this.destendereco = destendereco;
    }

    public String getDestnumerologradouro() {
        return destnumerologradouro;
    }

    public void setDestnumerologradouro(String destnumerologradouro) {
        this.destnumerologradouro = destnumerologradouro;
    }

    public String getDestcomplementologradouro() {
        return destcomplementologradouro;
    }

    public void setDestcomplementologradouro(String destcomplementologradouro) {
        this.destcomplementologradouro = destcomplementologradouro;
    }

    public String getDestbairro() {
        return destbairro;
    }

    public void setDestbairro(String destbairro) {
        this.destbairro = destbairro;
    }

    public String getDestcidade() {
        return destcidade;
    }

    public void setDestcidade(String destcidade) {
        this.destcidade = destcidade;
    }

    public String getDestestado() {
        return destestado;
    }

    public void setDestestado(String destestado) {
        this.destestado = destestado;
    }

    public String getDestcep() {
        return destcep;
    }

    public void setDestcep(String destcep) {
        this.destcep = destcep;
    }

    public String getDesttelefone() {
        return desttelefone;
    }

    public void setDesttelefone(String desttelefone) {
        this.desttelefone = desttelefone;
    }

    public String getDestinscr() {
        return destinscr;
    }

    public void setDestinscr(String destinscr) {
        this.destinscr = destinscr;
    }

    public String getDestcnpjcpf() {
        return destcnpjcpf;
    }

    public void setDestcnpjcpf(String destcnpjcpf) {
        this.destcnpjcpf = destcnpjcpf;
    }

    public String getDestsuframa() {
        return destsuframa;
    }

    public void setDestsuframa(String destsuframa) {
        this.destsuframa = destsuframa;
    }

    public Character getDesttipopessoa() {
        return desttipopessoa;
    }

    public void setDesttipopessoa(Character desttipopessoa) {
        this.desttipopessoa = desttipopessoa;
    }

    public String getDestemail() {
        return destemail;
    }

    public void setDestemail(String destemail) {
        this.destemail = destemail;
    }

    public String getCodtransredespacho() {
        return codtransredespacho;
    }

    public void setCodtransredespacho(String codtransredespacho) {
        this.codtransredespacho = codtransredespacho;
    }

    public String getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(String codtrans) {
        this.codtrans = codtrans;
    }

    public String getTranspnome() {
        return transpnome;
    }

    public void setTranspnome(String transpnome) {
        this.transpnome = transpnome;
    }

    public String getTranspendereco() {
        return transpendereco;
    }

    public void setTranspendereco(String transpendereco) {
        this.transpendereco = transpendereco;
    }

    public String getTranspbairro() {
        return transpbairro;
    }

    public void setTranspbairro(String transpbairro) {
        this.transpbairro = transpbairro;
    }

    public String getTranspcidade() {
        return transpcidade;
    }

    public void setTranspcidade(String transpcidade) {
        this.transpcidade = transpcidade;
    }

    public String getTranspestado() {
        return transpestado;
    }

    public void setTranspestado(String transpestado) {
        this.transpestado = transpestado;
    }

    public String getTranspcnpj() {
        return transpcnpj;
    }

    public void setTranspcnpj(String transpcnpj) {
        this.transpcnpj = transpcnpj;
    }

    public String getTranspinscr() {
        return transpinscr;
    }

    public void setTranspinscr(String transpinscr) {
        this.transpinscr = transpinscr;
    }

    public String getTransplocalembarque() {
        return transplocalembarque;
    }

    public void setTransplocalembarque(String transplocalembarque) {
        this.transplocalembarque = transplocalembarque;
    }

    public String getTranspufembarque() {
        return transpufembarque;
    }

    public void setTranspufembarque(String transpufembarque) {
        this.transpufembarque = transpufembarque;
    }

    public BigDecimal getValortotalprodutos() {
        return valortotalprodutos;
    }

    public void setValortotalprodutos(BigDecimal valortotalprodutos) {
        this.valortotalprodutos = valortotalprodutos;
    }

    public BigDecimal getValortotalservicos() {
        return valortotalservicos;
    }

    public void setValortotalservicos(BigDecimal valortotalservicos) {
        this.valortotalservicos = valortotalservicos;
    }

    public BigDecimal getValortotalitens() {
        return valortotalitens;
    }

    public void setValortotalitens(BigDecimal valortotalitens) {
        this.valortotalitens = valortotalitens;
    }

    public BigDecimal getValoroutrasdespesas() {
        return valoroutrasdespesas;
    }

    public void setValoroutrasdespesas(BigDecimal valoroutrasdespesas) {
        this.valoroutrasdespesas = valoroutrasdespesas;
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

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
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

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public BigDecimal getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(BigDecimal valorseguro) {
        this.valorseguro = valorseguro;
    }

    public BigDecimal getValortotalipi() {
        return valortotalipi;
    }

    public void setValortotalipi(BigDecimal valortotalipi) {
        this.valortotalipi = valortotalipi;
    }

    public BigDecimal getValortotalii() {
        return valortotalii;
    }

    public void setValortotalii(BigDecimal valortotalii) {
        this.valortotalii = valortotalii;
    }

    public BigDecimal getValortotalpis() {
        return valortotalpis;
    }

    public void setValortotalpis(BigDecimal valortotalpis) {
        this.valortotalpis = valortotalpis;
    }

    public BigDecimal getValortotalcofins() {
        return valortotalcofins;
    }

    public void setValortotalcofins(BigDecimal valortotalcofins) {
        this.valortotalcofins = valortotalcofins;
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

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public String getCfops() {
        return cfops;
    }

    public void setCfops(String cfops) {
        this.cfops = cfops;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public Date getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(Date horasaida) {
        this.horasaida = horasaida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacaonotafiscal() {
        return observacaonotafiscal;
    }

    public void setObservacaonotafiscal(String observacaonotafiscal) {
        this.observacaonotafiscal = observacaonotafiscal;
    }

    public String getDadosadicionais() {
        return dadosadicionais;
    }

    public void setDadosadicionais(String dadosadicionais) {
        this.dadosadicionais = dadosadicionais;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public String getNaturezaoperacao() {
        return naturezaoperacao;
    }

    public void setNaturezaoperacao(String naturezaoperacao) {
        this.naturezaoperacao = naturezaoperacao;
    }

    public Integer getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Integer numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public Integer getNumerotransferencia() {
        return numerotransferencia;
    }

    public void setNumerotransferencia(Integer numerotransferencia) {
        this.numerotransferencia = numerotransferencia;
    }

    public Integer getNumeropedidoexterno() {
        return numeropedidoexterno;
    }

    public void setNumeropedidoexterno(Integer numeropedidoexterno) {
        this.numeropedidoexterno = numeropedidoexterno;
    }

    public String getCampostr1() {
        return campostr1;
    }

    public void setCampostr1(String campostr1) {
        this.campostr1 = campostr1;
    }

    public BigDecimal getCampovalor1() {
        return campovalor1;
    }

    public void setCampovalor1(BigDecimal campovalor1) {
        this.campovalor1 = campovalor1;
    }

    public BigDecimal getPesoadicionalembalagem() {
        return pesoadicionalembalagem;
    }

    public void setPesoadicionalembalagem(BigDecimal pesoadicionalembalagem) {
        this.pesoadicionalembalagem = pesoadicionalembalagem;
    }

    public Integer getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(Integer numeropedido) {
        this.numeropedido = numeropedido;
    }

    public Integer getNumerocupomfiscal() {
        return numerocupomfiscal;
    }

    public void setNumerocupomfiscal(Integer numerocupomfiscal) {
        this.numerocupomfiscal = numerocupomfiscal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTranspantt() {
        return transpantt;
    }

    public void setTranspantt(String transpantt) {
        this.transpantt = transpantt;
    }

    public Integer getQuantidadevolumes() {
        return quantidadevolumes;
    }

    public void setQuantidadevolumes(Integer quantidadevolumes) {
        this.quantidadevolumes = quantidadevolumes;
    }

    public String getEspeciecarga() {
        return especiecarga;
    }

    public void setEspeciecarga(String especiecarga) {
        this.especiecarga = especiecarga;
    }

    public String getMarcacarga() {
        return marcacarga;
    }

    public void setMarcacarga(String marcacarga) {
        this.marcacarga = marcacarga;
    }

    public String getNumerovolume() {
        return numerovolume;
    }

    public void setNumerovolume(String numerovolume) {
        this.numerovolume = numerovolume;
    }

    public String getPlacaveiculo() {
        return placaveiculo;
    }

    public void setPlacaveiculo(String placaveiculo) {
        this.placaveiculo = placaveiculo;
    }

    public String getEstadoplacaveiculo() {
        return estadoplacaveiculo;
    }

    public void setEstadoplacaveiculo(String estadoplacaveiculo) {
        this.estadoplacaveiculo = estadoplacaveiculo;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public String getModelodocumento() {
        return modelodocumento;
    }

    public void setModelodocumento(String modelodocumento) {
        this.modelodocumento = modelodocumento;
    }

    public Character getFlagnfcomplementar() {
        return flagnfcomplementar;
    }

    public void setFlagnfcomplementar(Character flagnfcomplementar) {
        this.flagnfcomplementar = flagnfcomplementar;
    }

    public Character getFlagnfajuste() {
        return flagnfajuste;
    }

    public void setFlagnfajuste(Character flagnfajuste) {
        this.flagnfajuste = flagnfajuste;
    }

    public Character getFlagnfdevolucao() {
        return flagnfdevolucao;
    }

    public void setFlagnfdevolucao(Character flagnfdevolucao) {
        this.flagnfdevolucao = flagnfdevolucao;
    }

    public Character getFlagdocreferenciado() {
        return flagdocreferenciado;
    }

    public void setFlagdocreferenciado(Character flagdocreferenciado) {
        this.flagdocreferenciado = flagdocreferenciado;
    }

    public Character getIndpresenca() {
        return indpresenca;
    }

    public void setIndpresenca(Character indpresenca) {
        this.indpresenca = indpresenca;
    }

    public Character getIdentificadordestino() {
        return identificadordestino;
    }

    public void setIdentificadordestino(Character identificadordestino) {
        this.identificadordestino = identificadordestino;
    }

    public Character getIndoperacao() {
        return indoperacao;
    }

    public void setIndoperacao(Character indoperacao) {
        this.indoperacao = indoperacao;
    }

    public Character getIndiedest() {
        return indiedest;
    }

    public void setIndiedest(Character indiedest) {
        this.indiedest = indiedest;
    }

    public String getIdestrangeiro() {
        return idestrangeiro;
    }

    public void setIdestrangeiro(String idestrangeiro) {
        this.idestrangeiro = idestrangeiro;
    }

    public BigDecimal getValoriss() {
        return valoriss;
    }

    public void setValoriss(BigDecimal valoriss) {
        this.valoriss = valoriss;
    }

    public String getDestidentidade() {
        return destidentidade;
    }

    public void setDestidentidade(String destidentidade) {
        this.destidentidade = destidentidade;
    }

    public String getDestnomeentidade() {
        return destnomeentidade;
    }

    public void setDestnomeentidade(String destnomeentidade) {
        this.destnomeentidade = destnomeentidade;
    }

    public String getCobrancaendereco() {
        return cobrancaendereco;
    }

    public void setCobrancaendereco(String cobrancaendereco) {
        this.cobrancaendereco = cobrancaendereco;
    }

    public String getCobrancabairro() {
        return cobrancabairro;
    }

    public void setCobrancabairro(String cobrancabairro) {
        this.cobrancabairro = cobrancabairro;
    }

    public String getCobrancacidade() {
        return cobrancacidade;
    }

    public void setCobrancacidade(String cobrancacidade) {
        this.cobrancacidade = cobrancacidade;
    }

    public String getCobrancaestado() {
        return cobrancaestado;
    }

    public void setCobrancaestado(String cobrancaestado) {
        this.cobrancaestado = cobrancaestado;
    }

    public String getCobrancacep() {
        return cobrancacep;
    }

    public void setCobrancacep(String cobrancacep) {
        this.cobrancacep = cobrancacep;
    }

    public String getCobrancatelefone() {
        return cobrancatelefone;
    }

    public void setCobrancatelefone(String cobrancatelefone) {
        this.cobrancatelefone = cobrancatelefone;
    }

    public String getEntregaendereco() {
        return entregaendereco;
    }

    public void setEntregaendereco(String entregaendereco) {
        this.entregaendereco = entregaendereco;
    }

    public String getEntregabairro() {
        return entregabairro;
    }

    public void setEntregabairro(String entregabairro) {
        this.entregabairro = entregabairro;
    }

    public String getEntregacidade() {
        return entregacidade;
    }

    public void setEntregacidade(String entregacidade) {
        this.entregacidade = entregacidade;
    }

    public String getEntregaestado() {
        return entregaestado;
    }

    public void setEntregaestado(String entregaestado) {
        this.entregaestado = entregaestado;
    }

    public String getEntregacep() {
        return entregacep;
    }

    public void setEntregacep(String entregacep) {
        this.entregacep = entregacep;
    }

    public String getEntregatelefone() {
        return entregatelefone;
    }

    public void setEntregatelefone(String entregatelefone) {
        this.entregatelefone = entregatelefone;
    }

    public String getEntregareferencia() {
        return entregareferencia;
    }

    public void setEntregareferencia(String entregareferencia) {
        this.entregareferencia = entregareferencia;
    }

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getCodvendedext() {
        return codvendedext;
    }

    public void setCodvendedext(String codvendedext) {
        this.codvendedext = codvendedext;
    }

    public String getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(String codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public BigDecimal getValoricmsdeduzido() {
        return valoricmsdeduzido;
    }

    public void setValoricmsdeduzido(BigDecimal valoricmsdeduzido) {
        this.valoricmsdeduzido = valoricmsdeduzido;
    }

    public BigDecimal getValorcofinsdesonerado() {
        return valorcofinsdesonerado;
    }

    public void setValorcofinsdesonerado(BigDecimal valorcofinsdesonerado) {
        this.valorcofinsdesonerado = valorcofinsdesonerado;
    }

    public BigDecimal getValorpisdesonerado() {
        return valorpisdesonerado;
    }

    public void setValorpisdesonerado(BigDecimal valorpisdesonerado) {
        this.valorpisdesonerado = valorpisdesonerado;
    }

    public String getCampostr2() {
        return campostr2;
    }

    public void setCampostr2(String campostr2) {
        this.campostr2 = campostr2;
    }

    public Character getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(Character flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public Character getFlagtipoacrescimo() {
        return flagtipoacrescimo;
    }

    public void setFlagtipoacrescimo(Character flagtipoacrescimo) {
        this.flagtipoacrescimo = flagtipoacrescimo;
    }

    public BigDecimal getAliqacrescimo() {
        return aliqacrescimo;
    }

    public void setAliqacrescimo(BigDecimal aliqacrescimo) {
        this.aliqacrescimo = aliqacrescimo;
    }

    public BigDecimal getBaseicmsdeduzido() {
        return baseicmsdeduzido;
    }

    public void setBaseicmsdeduzido(BigDecimal baseicmsdeduzido) {
        this.baseicmsdeduzido = baseicmsdeduzido;
    }

    public String getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(String codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public String getNumerofatura1() {
        return numerofatura1;
    }

    public void setNumerofatura1(String numerofatura1) {
        this.numerofatura1 = numerofatura1;
    }

    public Date getVencimentofatura1() {
        return vencimentofatura1;
    }

    public void setVencimentofatura1(Date vencimentofatura1) {
        this.vencimentofatura1 = vencimentofatura1;
    }

    public BigDecimal getValorfatura1() {
        return valorfatura1;
    }

    public void setValorfatura1(BigDecimal valorfatura1) {
        this.valorfatura1 = valorfatura1;
    }

    public String getCodcrfatura1() {
        return codcrfatura1;
    }

    public void setCodcrfatura1(String codcrfatura1) {
        this.codcrfatura1 = codcrfatura1;
    }

    public String getNumerofatura2() {
        return numerofatura2;
    }

    public void setNumerofatura2(String numerofatura2) {
        this.numerofatura2 = numerofatura2;
    }

    public Date getVencimentofatura2() {
        return vencimentofatura2;
    }

    public void setVencimentofatura2(Date vencimentofatura2) {
        this.vencimentofatura2 = vencimentofatura2;
    }

    public BigDecimal getValorfatura2() {
        return valorfatura2;
    }

    public void setValorfatura2(BigDecimal valorfatura2) {
        this.valorfatura2 = valorfatura2;
    }

    public String getCodcrfatura2() {
        return codcrfatura2;
    }

    public void setCodcrfatura2(String codcrfatura2) {
        this.codcrfatura2 = codcrfatura2;
    }

    public String getNumerofatura3() {
        return numerofatura3;
    }

    public void setNumerofatura3(String numerofatura3) {
        this.numerofatura3 = numerofatura3;
    }

    public Date getVencimentofatura3() {
        return vencimentofatura3;
    }

    public void setVencimentofatura3(Date vencimentofatura3) {
        this.vencimentofatura3 = vencimentofatura3;
    }

    public BigDecimal getValorfatura3() {
        return valorfatura3;
    }

    public void setValorfatura3(BigDecimal valorfatura3) {
        this.valorfatura3 = valorfatura3;
    }

    public String getCodcrfatura3() {
        return codcrfatura3;
    }

    public void setCodcrfatura3(String codcrfatura3) {
        this.codcrfatura3 = codcrfatura3;
    }

    public String getNumerofatura4() {
        return numerofatura4;
    }

    public void setNumerofatura4(String numerofatura4) {
        this.numerofatura4 = numerofatura4;
    }

    public Date getVencimentofatura4() {
        return vencimentofatura4;
    }

    public void setVencimentofatura4(Date vencimentofatura4) {
        this.vencimentofatura4 = vencimentofatura4;
    }

    public BigDecimal getValorfatura4() {
        return valorfatura4;
    }

    public void setValorfatura4(BigDecimal valorfatura4) {
        this.valorfatura4 = valorfatura4;
    }

    public String getCodcrfatura4() {
        return codcrfatura4;
    }

    public void setCodcrfatura4(String codcrfatura4) {
        this.codcrfatura4 = codcrfatura4;
    }

    public String getNumerofatura5() {
        return numerofatura5;
    }

    public void setNumerofatura5(String numerofatura5) {
        this.numerofatura5 = numerofatura5;
    }

    public Date getVencimentofatura5() {
        return vencimentofatura5;
    }

    public void setVencimentofatura5(Date vencimentofatura5) {
        this.vencimentofatura5 = vencimentofatura5;
    }

    public BigDecimal getValorfatura5() {
        return valorfatura5;
    }

    public void setValorfatura5(BigDecimal valorfatura5) {
        this.valorfatura5 = valorfatura5;
    }

    public String getCodcrfatura5() {
        return codcrfatura5;
    }

    public void setCodcrfatura5(String codcrfatura5) {
        this.codcrfatura5 = codcrfatura5;
    }

    public String getNumerofatura6() {
        return numerofatura6;
    }

    public void setNumerofatura6(String numerofatura6) {
        this.numerofatura6 = numerofatura6;
    }

    public Date getVencimentofatura6() {
        return vencimentofatura6;
    }

    public void setVencimentofatura6(Date vencimentofatura6) {
        this.vencimentofatura6 = vencimentofatura6;
    }

    public BigDecimal getValorfatura6() {
        return valorfatura6;
    }

    public void setValorfatura6(BigDecimal valorfatura6) {
        this.valorfatura6 = valorfatura6;
    }

    public String getCodcrfatura6() {
        return codcrfatura6;
    }

    public void setCodcrfatura6(String codcrfatura6) {
        this.codcrfatura6 = codcrfatura6;
    }

    public String getNumerofatura7() {
        return numerofatura7;
    }

    public void setNumerofatura7(String numerofatura7) {
        this.numerofatura7 = numerofatura7;
    }

    public Date getVencimentofatura7() {
        return vencimentofatura7;
    }

    public void setVencimentofatura7(Date vencimentofatura7) {
        this.vencimentofatura7 = vencimentofatura7;
    }

    public BigDecimal getValorfatura7() {
        return valorfatura7;
    }

    public void setValorfatura7(BigDecimal valorfatura7) {
        this.valorfatura7 = valorfatura7;
    }

    public String getCodcrfatura7() {
        return codcrfatura7;
    }

    public void setCodcrfatura7(String codcrfatura7) {
        this.codcrfatura7 = codcrfatura7;
    }

    public String getNumerofatura8() {
        return numerofatura8;
    }

    public void setNumerofatura8(String numerofatura8) {
        this.numerofatura8 = numerofatura8;
    }

    public Date getVencimentofatura8() {
        return vencimentofatura8;
    }

    public void setVencimentofatura8(Date vencimentofatura8) {
        this.vencimentofatura8 = vencimentofatura8;
    }

    public BigDecimal getValorfatura8() {
        return valorfatura8;
    }

    public void setValorfatura8(BigDecimal valorfatura8) {
        this.valorfatura8 = valorfatura8;
    }

    public String getCodcrfatura8() {
        return codcrfatura8;
    }

    public void setCodcrfatura8(String codcrfatura8) {
        this.codcrfatura8 = codcrfatura8;
    }

    public String getNumerofatura9() {
        return numerofatura9;
    }

    public void setNumerofatura9(String numerofatura9) {
        this.numerofatura9 = numerofatura9;
    }

    public Date getVencimentofatura9() {
        return vencimentofatura9;
    }

    public void setVencimentofatura9(Date vencimentofatura9) {
        this.vencimentofatura9 = vencimentofatura9;
    }

    public BigDecimal getValorfatura9() {
        return valorfatura9;
    }

    public void setValorfatura9(BigDecimal valorfatura9) {
        this.valorfatura9 = valorfatura9;
    }

    public String getCodcrfatura9() {
        return codcrfatura9;
    }

    public void setCodcrfatura9(String codcrfatura9) {
        this.codcrfatura9 = codcrfatura9;
    }

    public String getNumerofatura10() {
        return numerofatura10;
    }

    public void setNumerofatura10(String numerofatura10) {
        this.numerofatura10 = numerofatura10;
    }

    public Date getVencimentofatura10() {
        return vencimentofatura10;
    }

    public void setVencimentofatura10(Date vencimentofatura10) {
        this.vencimentofatura10 = vencimentofatura10;
    }

    public BigDecimal getValorfatura10() {
        return valorfatura10;
    }

    public void setValorfatura10(BigDecimal valorfatura10) {
        this.valorfatura10 = valorfatura10;
    }

    public String getCodcrfatura10() {
        return codcrfatura10;
    }

    public void setCodcrfatura10(String codcrfatura10) {
        this.codcrfatura10 = codcrfatura10;
    }

    public String getNumerofatura11() {
        return numerofatura11;
    }

    public void setNumerofatura11(String numerofatura11) {
        this.numerofatura11 = numerofatura11;
    }

    public Date getVencimentofatura11() {
        return vencimentofatura11;
    }

    public void setVencimentofatura11(Date vencimentofatura11) {
        this.vencimentofatura11 = vencimentofatura11;
    }

    public BigDecimal getValorfatura11() {
        return valorfatura11;
    }

    public void setValorfatura11(BigDecimal valorfatura11) {
        this.valorfatura11 = valorfatura11;
    }

    public String getCodcrfatura11() {
        return codcrfatura11;
    }

    public void setCodcrfatura11(String codcrfatura11) {
        this.codcrfatura11 = codcrfatura11;
    }

    public String getNumerofatura12() {
        return numerofatura12;
    }

    public void setNumerofatura12(String numerofatura12) {
        this.numerofatura12 = numerofatura12;
    }

    public Date getVencimentofatura12() {
        return vencimentofatura12;
    }

    public void setVencimentofatura12(Date vencimentofatura12) {
        this.vencimentofatura12 = vencimentofatura12;
    }

    public BigDecimal getValorfatura12() {
        return valorfatura12;
    }

    public void setValorfatura12(BigDecimal valorfatura12) {
        this.valorfatura12 = valorfatura12;
    }

    public String getCodcrfatura12() {
        return codcrfatura12;
    }

    public void setCodcrfatura12(String codcrfatura12) {
        this.codcrfatura12 = codcrfatura12;
    }

    public String getNumerofatura13() {
        return numerofatura13;
    }

    public void setNumerofatura13(String numerofatura13) {
        this.numerofatura13 = numerofatura13;
    }

    public Date getVencimentofatura13() {
        return vencimentofatura13;
    }

    public void setVencimentofatura13(Date vencimentofatura13) {
        this.vencimentofatura13 = vencimentofatura13;
    }

    public BigDecimal getValorfatura13() {
        return valorfatura13;
    }

    public void setValorfatura13(BigDecimal valorfatura13) {
        this.valorfatura13 = valorfatura13;
    }

    public String getCodcrfatura13() {
        return codcrfatura13;
    }

    public void setCodcrfatura13(String codcrfatura13) {
        this.codcrfatura13 = codcrfatura13;
    }

    public String getNumerofatura14() {
        return numerofatura14;
    }

    public void setNumerofatura14(String numerofatura14) {
        this.numerofatura14 = numerofatura14;
    }

    public Date getVencimentofatura14() {
        return vencimentofatura14;
    }

    public void setVencimentofatura14(Date vencimentofatura14) {
        this.vencimentofatura14 = vencimentofatura14;
    }

    public BigDecimal getValorfatura14() {
        return valorfatura14;
    }

    public void setValorfatura14(BigDecimal valorfatura14) {
        this.valorfatura14 = valorfatura14;
    }

    public String getCodcrfatura14() {
        return codcrfatura14;
    }

    public void setCodcrfatura14(String codcrfatura14) {
        this.codcrfatura14 = codcrfatura14;
    }

    public String getNumerofatura15() {
        return numerofatura15;
    }

    public void setNumerofatura15(String numerofatura15) {
        this.numerofatura15 = numerofatura15;
    }

    public Date getVencimentofatura15() {
        return vencimentofatura15;
    }

    public void setVencimentofatura15(Date vencimentofatura15) {
        this.vencimentofatura15 = vencimentofatura15;
    }

    public BigDecimal getValorfatura15() {
        return valorfatura15;
    }

    public void setValorfatura15(BigDecimal valorfatura15) {
        this.valorfatura15 = valorfatura15;
    }

    public String getCodcrfatura15() {
        return codcrfatura15;
    }

    public void setCodcrfatura15(String codcrfatura15) {
        this.codcrfatura15 = codcrfatura15;
    }

    public String getNumerofatura16() {
        return numerofatura16;
    }

    public void setNumerofatura16(String numerofatura16) {
        this.numerofatura16 = numerofatura16;
    }

    public Date getVencimentofatura16() {
        return vencimentofatura16;
    }

    public void setVencimentofatura16(Date vencimentofatura16) {
        this.vencimentofatura16 = vencimentofatura16;
    }

    public BigDecimal getValorfatura16() {
        return valorfatura16;
    }

    public void setValorfatura16(BigDecimal valorfatura16) {
        this.valorfatura16 = valorfatura16;
    }

    public String getCodcrfatura16() {
        return codcrfatura16;
    }

    public void setCodcrfatura16(String codcrfatura16) {
        this.codcrfatura16 = codcrfatura16;
    }

    public String getNumerofatura17() {
        return numerofatura17;
    }

    public void setNumerofatura17(String numerofatura17) {
        this.numerofatura17 = numerofatura17;
    }

    public Date getVencimentofatura17() {
        return vencimentofatura17;
    }

    public void setVencimentofatura17(Date vencimentofatura17) {
        this.vencimentofatura17 = vencimentofatura17;
    }

    public BigDecimal getValorfatura17() {
        return valorfatura17;
    }

    public void setValorfatura17(BigDecimal valorfatura17) {
        this.valorfatura17 = valorfatura17;
    }

    public String getCodcrfatura17() {
        return codcrfatura17;
    }

    public void setCodcrfatura17(String codcrfatura17) {
        this.codcrfatura17 = codcrfatura17;
    }

    public String getNumerofatura18() {
        return numerofatura18;
    }

    public void setNumerofatura18(String numerofatura18) {
        this.numerofatura18 = numerofatura18;
    }

    public Date getVencimentofatura18() {
        return vencimentofatura18;
    }

    public void setVencimentofatura18(Date vencimentofatura18) {
        this.vencimentofatura18 = vencimentofatura18;
    }

    public BigDecimal getValorfatura18() {
        return valorfatura18;
    }

    public void setValorfatura18(BigDecimal valorfatura18) {
        this.valorfatura18 = valorfatura18;
    }

    public String getCodcrfatura18() {
        return codcrfatura18;
    }

    public void setCodcrfatura18(String codcrfatura18) {
        this.codcrfatura18 = codcrfatura18;
    }

    public String getNumerofatura19() {
        return numerofatura19;
    }

    public void setNumerofatura19(String numerofatura19) {
        this.numerofatura19 = numerofatura19;
    }

    public Date getVencimentofatura19() {
        return vencimentofatura19;
    }

    public void setVencimentofatura19(Date vencimentofatura19) {
        this.vencimentofatura19 = vencimentofatura19;
    }

    public BigDecimal getValorfatura19() {
        return valorfatura19;
    }

    public void setValorfatura19(BigDecimal valorfatura19) {
        this.valorfatura19 = valorfatura19;
    }

    public String getCodcrfatura19() {
        return codcrfatura19;
    }

    public void setCodcrfatura19(String codcrfatura19) {
        this.codcrfatura19 = codcrfatura19;
    }

    public String getNumerofatura20() {
        return numerofatura20;
    }

    public void setNumerofatura20(String numerofatura20) {
        this.numerofatura20 = numerofatura20;
    }

    public Date getVencimentofatura20() {
        return vencimentofatura20;
    }

    public void setVencimentofatura20(Date vencimentofatura20) {
        this.vencimentofatura20 = vencimentofatura20;
    }

    public BigDecimal getValorfatura20() {
        return valorfatura20;
    }

    public void setValorfatura20(BigDecimal valorfatura20) {
        this.valorfatura20 = valorfatura20;
    }

    public String getCodcrfatura20() {
        return codcrfatura20;
    }

    public void setCodcrfatura20(String codcrfatura20) {
        this.codcrfatura20 = codcrfatura20;
    }

    public String getNumerofatura21() {
        return numerofatura21;
    }

    public void setNumerofatura21(String numerofatura21) {
        this.numerofatura21 = numerofatura21;
    }

    public Date getVencimentofatura21() {
        return vencimentofatura21;
    }

    public void setVencimentofatura21(Date vencimentofatura21) {
        this.vencimentofatura21 = vencimentofatura21;
    }

    public BigDecimal getValorfatura21() {
        return valorfatura21;
    }

    public void setValorfatura21(BigDecimal valorfatura21) {
        this.valorfatura21 = valorfatura21;
    }

    public String getCodcrfatura21() {
        return codcrfatura21;
    }

    public void setCodcrfatura21(String codcrfatura21) {
        this.codcrfatura21 = codcrfatura21;
    }

    public String getNumerofatura22() {
        return numerofatura22;
    }

    public void setNumerofatura22(String numerofatura22) {
        this.numerofatura22 = numerofatura22;
    }

    public Date getVencimentofatura22() {
        return vencimentofatura22;
    }

    public void setVencimentofatura22(Date vencimentofatura22) {
        this.vencimentofatura22 = vencimentofatura22;
    }

    public BigDecimal getValorfatura22() {
        return valorfatura22;
    }

    public void setValorfatura22(BigDecimal valorfatura22) {
        this.valorfatura22 = valorfatura22;
    }

    public String getCodcrfatura22() {
        return codcrfatura22;
    }

    public void setCodcrfatura22(String codcrfatura22) {
        this.codcrfatura22 = codcrfatura22;
    }

    public String getNumerofatura23() {
        return numerofatura23;
    }

    public void setNumerofatura23(String numerofatura23) {
        this.numerofatura23 = numerofatura23;
    }

    public Date getVencimentofatura23() {
        return vencimentofatura23;
    }

    public void setVencimentofatura23(Date vencimentofatura23) {
        this.vencimentofatura23 = vencimentofatura23;
    }

    public BigDecimal getValorfatura23() {
        return valorfatura23;
    }

    public void setValorfatura23(BigDecimal valorfatura23) {
        this.valorfatura23 = valorfatura23;
    }

    public String getCodcrfatura23() {
        return codcrfatura23;
    }

    public void setCodcrfatura23(String codcrfatura23) {
        this.codcrfatura23 = codcrfatura23;
    }

    public String getNumerofatura24() {
        return numerofatura24;
    }

    public void setNumerofatura24(String numerofatura24) {
        this.numerofatura24 = numerofatura24;
    }

    public Date getVencimentofatura24() {
        return vencimentofatura24;
    }

    public void setVencimentofatura24(Date vencimentofatura24) {
        this.vencimentofatura24 = vencimentofatura24;
    }

    public BigDecimal getValorfatura24() {
        return valorfatura24;
    }

    public void setValorfatura24(BigDecimal valorfatura24) {
        this.valorfatura24 = valorfatura24;
    }

    public String getCodcrfatura24() {
        return codcrfatura24;
    }

    public void setCodcrfatura24(String codcrfatura24) {
        this.codcrfatura24 = codcrfatura24;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
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

    public BigDecimal getValortotalipidevolvido() {
        return valortotalipidevolvido;
    }

    public void setValortotalipidevolvido(BigDecimal valortotalipidevolvido) {
        this.valortotalipidevolvido = valortotalipidevolvido;
    }

    public BigDecimal getAliqaprox() {
        return aliqaprox;
    }

    public void setAliqaprox(BigDecimal aliqaprox) {
        this.aliqaprox = aliqaprox;
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

    public BigDecimal getValorfcppart() {
        return valorfcppart;
    }

    public void setValorfcppart(BigDecimal valorfcppart) {
        this.valorfcppart = valorfcppart;
    }

    public BigDecimal getValoricmsdestinopart() {
        return valoricmsdestinopart;
    }

    public void setValoricmsdestinopart(BigDecimal valoricmsdestinopart) {
        this.valoricmsdestinopart = valoricmsdestinopart;
    }

    public BigDecimal getValoricmsorigempart() {
        return valoricmsorigempart;
    }

    public void setValoricmsorigempart(BigDecimal valoricmsorigempart) {
        this.valoricmsorigempart = valoricmsorigempart;
    }

    public BigDecimal getValortotalfatura() {
        return valortotalfatura;
    }

    public void setValortotalfatura(BigDecimal valortotalfatura) {
        this.valortotalfatura = valortotalfatura;
    }

    public BigDecimal getValortroco() {
        return valortroco;
    }

    public void setValortroco(BigDecimal valortroco) {
        this.valortroco = valortroco;
    }

    public Character getCodmodalidadefrete() {
        return codmodalidadefrete;
    }

    public void setCodmodalidadefrete(Character codmodalidadefrete) {
        this.codmodalidadefrete = codmodalidadefrete;
    }

    public String getNumpedcliente() {
        return numpedcliente;
    }

    public void setNumpedcliente(String numpedcliente) {
        this.numpedcliente = numpedcliente;
    }

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    public String getObsfisco() {
        return obsfisco;
    }

    public void setObsfisco(String obsfisco) {
        this.obsfisco = obsfisco;
    }

    public String getEmailccdanfe() {
        return emailccdanfe;
    }

    public void setEmailccdanfe(String emailccdanfe) {
        this.emailccdanfe = emailccdanfe;
    }

    public String getEntreganumerologradouro() {
        return entreganumerologradouro;
    }

    public void setEntreganumerologradouro(String entreganumerologradouro) {
        this.entreganumerologradouro = entreganumerologradouro;
    }

    public String getEntregacomplementologradouro() {
        return entregacomplementologradouro;
    }

    public void setEntregacomplementologradouro(String entregacomplementologradouro) {
        this.entregacomplementologradouro = entregacomplementologradouro;
    }

    public BigDecimal getValortotalpisissqn() {
        return valortotalpisissqn;
    }

    public void setValortotalpisissqn(BigDecimal valortotalpisissqn) {
        this.valortotalpisissqn = valortotalpisissqn;
    }

    public BigDecimal getValortotalcofinsissqn() {
        return valortotalcofinsissqn;
    }

    public void setValortotalcofinsissqn(BigDecimal valortotalcofinsissqn) {
        this.valortotalcofinsissqn = valortotalcofinsissqn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpDocumento != null ? codtmpDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpDocumento)) {
            return false;
        }
        TmpDocumento other = (TmpDocumento) object;
        if ((this.codtmpDocumento == null && other.codtmpDocumento != null) || (this.codtmpDocumento != null && !this.codtmpDocumento.equals(other.codtmpDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpDocumento[ codtmpDocumento=" + codtmpDocumento + " ]";
    }
    
}
