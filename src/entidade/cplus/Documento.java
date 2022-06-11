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
@Table(name = "DOCUMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByCoddocumento", query = "SELECT d FROM Documento d WHERE d.coddocumento = :coddocumento")
    , @NamedQuery(name = "Documento.findByBaseicms", query = "SELECT d FROM Documento d WHERE d.baseicms = :baseicms")
    , @NamedQuery(name = "Documento.findByValoricms", query = "SELECT d FROM Documento d WHERE d.valoricms = :valoricms")
    , @NamedQuery(name = "Documento.findByBasesubsttributaria", query = "SELECT d FROM Documento d WHERE d.basesubsttributaria = :basesubsttributaria")
    , @NamedQuery(name = "Documento.findByValorsubsttributaria", query = "SELECT d FROM Documento d WHERE d.valorsubsttributaria = :valorsubsttributaria")
    , @NamedQuery(name = "Documento.findByValorseguro", query = "SELECT d FROM Documento d WHERE d.valorseguro = :valorseguro")
    , @NamedQuery(name = "Documento.findByValorfrete", query = "SELECT d FROM Documento d WHERE d.valorfrete = :valorfrete")
    , @NamedQuery(name = "Documento.findByValoroutrasdespesas", query = "SELECT d FROM Documento d WHERE d.valoroutrasdespesas = :valoroutrasdespesas")
    , @NamedQuery(name = "Documento.findByValordesconto", query = "SELECT d FROM Documento d WHERE d.valordesconto = :valordesconto")
    , @NamedQuery(name = "Documento.findByValoracrescimo", query = "SELECT d FROM Documento d WHERE d.valoracrescimo = :valoracrescimo")
    , @NamedQuery(name = "Documento.findByAliqacrescimo", query = "SELECT d FROM Documento d WHERE d.aliqacrescimo = :aliqacrescimo")
    , @NamedQuery(name = "Documento.findByAliqdesconto", query = "SELECT d FROM Documento d WHERE d.aliqdesconto = :aliqdesconto")
    , @NamedQuery(name = "Documento.findByValortotalnota", query = "SELECT d FROM Documento d WHERE d.valortotalnota = :valortotalnota")
    , @NamedQuery(name = "Documento.findByValortotalprodutos", query = "SELECT d FROM Documento d WHERE d.valortotalprodutos = :valortotalprodutos")
    , @NamedQuery(name = "Documento.findByValortotalipi", query = "SELECT d FROM Documento d WHERE d.valortotalipi = :valortotalipi")
    , @NamedQuery(name = "Documento.findByCampovalor1", query = "SELECT d FROM Documento d WHERE d.campovalor1 = :campovalor1")
    , @NamedQuery(name = "Documento.findByPesoadicionalembalagem", query = "SELECT d FROM Documento d WHERE d.pesoadicionalembalagem = :pesoadicionalembalagem")
    , @NamedQuery(name = "Documento.findByFlagtipo", query = "SELECT d FROM Documento d WHERE d.flagtipo = :flagtipo")
    , @NamedQuery(name = "Documento.findByNomeentidadeorigem", query = "SELECT d FROM Documento d WHERE d.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Documento.findByIdentidadeorigem", query = "SELECT d FROM Documento d WHERE d.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Documento.findByFlagcancelada", query = "SELECT d FROM Documento d WHERE d.flagcancelada = :flagcancelada")
    , @NamedQuery(name = "Documento.findByNumnota", query = "SELECT d FROM Documento d WHERE d.numnota = :numnota")
    , @NamedQuery(name = "Documento.findByQuantidadevolumes", query = "SELECT d FROM Documento d WHERE d.quantidadevolumes = :quantidadevolumes")
    , @NamedQuery(name = "Documento.findByValoricmsdeduzido", query = "SELECT d FROM Documento d WHERE d.valoricmsdeduzido = :valoricmsdeduzido")
    , @NamedQuery(name = "Documento.findByBaseicmsdeduzido", query = "SELECT d FROM Documento d WHERE d.baseicmsdeduzido = :baseicmsdeduzido")
    , @NamedQuery(name = "Documento.findByCampostr1", query = "SELECT d FROM Documento d WHERE d.campostr1 = :campostr1")
    , @NamedQuery(name = "Documento.findByCodpais", query = "SELECT d FROM Documento d WHERE d.codpais = :codpais")
    , @NamedQuery(name = "Documento.findByEmitcomplementologradouro", query = "SELECT d FROM Documento d WHERE d.emitcomplementologradouro = :emitcomplementologradouro")
    , @NamedQuery(name = "Documento.findByDestcomplementologradouro", query = "SELECT d FROM Documento d WHERE d.destcomplementologradouro = :destcomplementologradouro")
    , @NamedQuery(name = "Documento.findByNumcupom", query = "SELECT d FROM Documento d WHERE d.numcupom = :numcupom")
    , @NamedQuery(name = "Documento.findByTransplocalembarque", query = "SELECT d FROM Documento d WHERE d.transplocalembarque = :transplocalembarque")
    , @NamedQuery(name = "Documento.findByTranspufembarque", query = "SELECT d FROM Documento d WHERE d.transpufembarque = :transpufembarque")
    , @NamedQuery(name = "Documento.findByChaveacessonfeletronica", query = "SELECT d FROM Documento d WHERE d.chaveacessonfeletronica = :chaveacessonfeletronica")
    , @NamedQuery(name = "Documento.findByEmitinscrsubsttrib", query = "SELECT d FROM Documento d WHERE d.emitinscrsubsttrib = :emitinscrsubsttrib")
    , @NamedQuery(name = "Documento.findByEmitcnae", query = "SELECT d FROM Documento d WHERE d.emitcnae = :emitcnae")
    , @NamedQuery(name = "Documento.findByFlagnfcomplementar", query = "SELECT d FROM Documento d WHERE d.flagnfcomplementar = :flagnfcomplementar")
    , @NamedQuery(name = "Documento.findByCoddocumentoreferenciado", query = "SELECT d FROM Documento d WHERE d.coddocumentoreferenciado = :coddocumentoreferenciado")
    , @NamedQuery(name = "Documento.findByChaveacessonfereferenciada", query = "SELECT d FROM Documento d WHERE d.chaveacessonfereferenciada = :chaveacessonfereferenciada")
    , @NamedQuery(name = "Documento.findByCodtransredespacho", query = "SELECT d FROM Documento d WHERE d.codtransredespacho = :codtransredespacho")
    , @NamedQuery(name = "Documento.findByFlagimpressao", query = "SELECT d FROM Documento d WHERE d.flagimpressao = :flagimpressao")
    , @NamedQuery(name = "Documento.findByDatavenda", query = "SELECT d FROM Documento d WHERE d.datavenda = :datavenda")
    , @NamedQuery(name = "Documento.findByValortotalpis", query = "SELECT d FROM Documento d WHERE d.valortotalpis = :valortotalpis")
    , @NamedQuery(name = "Documento.findByValortotalcofins", query = "SELECT d FROM Documento d WHERE d.valortotalcofins = :valortotalcofins")
    , @NamedQuery(name = "Documento.findByNomevendedor", query = "SELECT d FROM Documento d WHERE d.nomevendedor = :nomevendedor")
    , @NamedQuery(name = "Documento.findByFormapagamento", query = "SELECT d FROM Documento d WHERE d.formapagamento = :formapagamento")
    , @NamedQuery(name = "Documento.findByEmitnumerologradouro", query = "SELECT d FROM Documento d WHERE d.emitnumerologradouro = :emitnumerologradouro")
    , @NamedQuery(name = "Documento.findByDestnumerologradouro", query = "SELECT d FROM Documento d WHERE d.destnumerologradouro = :destnumerologradouro")
    , @NamedQuery(name = "Documento.findByEmitinscricaomunicipal", query = "SELECT d FROM Documento d WHERE d.emitinscricaomunicipal = :emitinscricaomunicipal")
    , @NamedQuery(name = "Documento.findByModelodocumento", query = "SELECT d FROM Documento d WHERE d.modelodocumento = :modelodocumento")
    , @NamedQuery(name = "Documento.findByDatalancamento", query = "SELECT d FROM Documento d WHERE d.datalancamento = :datalancamento")
    , @NamedQuery(name = "Documento.findByValorfatura1", query = "SELECT d FROM Documento d WHERE d.valorfatura1 = :valorfatura1")
    , @NamedQuery(name = "Documento.findByNumerofatura1", query = "SELECT d FROM Documento d WHERE d.numerofatura1 = :numerofatura1")
    , @NamedQuery(name = "Documento.findByVencimentofatura1", query = "SELECT d FROM Documento d WHERE d.vencimentofatura1 = :vencimentofatura1")
    , @NamedQuery(name = "Documento.findByCodcrfatura1", query = "SELECT d FROM Documento d WHERE d.codcrfatura1 = :codcrfatura1")
    , @NamedQuery(name = "Documento.findByValorfatura2", query = "SELECT d FROM Documento d WHERE d.valorfatura2 = :valorfatura2")
    , @NamedQuery(name = "Documento.findByNumerofatura2", query = "SELECT d FROM Documento d WHERE d.numerofatura2 = :numerofatura2")
    , @NamedQuery(name = "Documento.findByVencimentofatura2", query = "SELECT d FROM Documento d WHERE d.vencimentofatura2 = :vencimentofatura2")
    , @NamedQuery(name = "Documento.findByCodcrfatura2", query = "SELECT d FROM Documento d WHERE d.codcrfatura2 = :codcrfatura2")
    , @NamedQuery(name = "Documento.findByValorfatura3", query = "SELECT d FROM Documento d WHERE d.valorfatura3 = :valorfatura3")
    , @NamedQuery(name = "Documento.findByNumerofatura3", query = "SELECT d FROM Documento d WHERE d.numerofatura3 = :numerofatura3")
    , @NamedQuery(name = "Documento.findByVencimentofatura3", query = "SELECT d FROM Documento d WHERE d.vencimentofatura3 = :vencimentofatura3")
    , @NamedQuery(name = "Documento.findByCodcrfatura3", query = "SELECT d FROM Documento d WHERE d.codcrfatura3 = :codcrfatura3")
    , @NamedQuery(name = "Documento.findByValorfatura4", query = "SELECT d FROM Documento d WHERE d.valorfatura4 = :valorfatura4")
    , @NamedQuery(name = "Documento.findByNumerofatura4", query = "SELECT d FROM Documento d WHERE d.numerofatura4 = :numerofatura4")
    , @NamedQuery(name = "Documento.findByVencimentofatura4", query = "SELECT d FROM Documento d WHERE d.vencimentofatura4 = :vencimentofatura4")
    , @NamedQuery(name = "Documento.findByCodcrfatura4", query = "SELECT d FROM Documento d WHERE d.codcrfatura4 = :codcrfatura4")
    , @NamedQuery(name = "Documento.findByValorfatura5", query = "SELECT d FROM Documento d WHERE d.valorfatura5 = :valorfatura5")
    , @NamedQuery(name = "Documento.findByNumerofatura5", query = "SELECT d FROM Documento d WHERE d.numerofatura5 = :numerofatura5")
    , @NamedQuery(name = "Documento.findByVencimentofatura5", query = "SELECT d FROM Documento d WHERE d.vencimentofatura5 = :vencimentofatura5")
    , @NamedQuery(name = "Documento.findByCodcrfatura5", query = "SELECT d FROM Documento d WHERE d.codcrfatura5 = :codcrfatura5")
    , @NamedQuery(name = "Documento.findByValorfatura6", query = "SELECT d FROM Documento d WHERE d.valorfatura6 = :valorfatura6")
    , @NamedQuery(name = "Documento.findByNumerofatura6", query = "SELECT d FROM Documento d WHERE d.numerofatura6 = :numerofatura6")
    , @NamedQuery(name = "Documento.findByVencimentofatura6", query = "SELECT d FROM Documento d WHERE d.vencimentofatura6 = :vencimentofatura6")
    , @NamedQuery(name = "Documento.findByCodcrfatura6", query = "SELECT d FROM Documento d WHERE d.codcrfatura6 = :codcrfatura6")
    , @NamedQuery(name = "Documento.findByValorfatura7", query = "SELECT d FROM Documento d WHERE d.valorfatura7 = :valorfatura7")
    , @NamedQuery(name = "Documento.findByNumerofatura7", query = "SELECT d FROM Documento d WHERE d.numerofatura7 = :numerofatura7")
    , @NamedQuery(name = "Documento.findByVencimentofatura7", query = "SELECT d FROM Documento d WHERE d.vencimentofatura7 = :vencimentofatura7")
    , @NamedQuery(name = "Documento.findByCodcrfatura7", query = "SELECT d FROM Documento d WHERE d.codcrfatura7 = :codcrfatura7")
    , @NamedQuery(name = "Documento.findByValorfatura8", query = "SELECT d FROM Documento d WHERE d.valorfatura8 = :valorfatura8")
    , @NamedQuery(name = "Documento.findByNumerofatura8", query = "SELECT d FROM Documento d WHERE d.numerofatura8 = :numerofatura8")
    , @NamedQuery(name = "Documento.findByVencimentofatura8", query = "SELECT d FROM Documento d WHERE d.vencimentofatura8 = :vencimentofatura8")
    , @NamedQuery(name = "Documento.findByCodcrfatura8", query = "SELECT d FROM Documento d WHERE d.codcrfatura8 = :codcrfatura8")
    , @NamedQuery(name = "Documento.findByValorfatura9", query = "SELECT d FROM Documento d WHERE d.valorfatura9 = :valorfatura9")
    , @NamedQuery(name = "Documento.findByNumerofatura9", query = "SELECT d FROM Documento d WHERE d.numerofatura9 = :numerofatura9")
    , @NamedQuery(name = "Documento.findByVencimentofatura9", query = "SELECT d FROM Documento d WHERE d.vencimentofatura9 = :vencimentofatura9")
    , @NamedQuery(name = "Documento.findByCodcrfatura9", query = "SELECT d FROM Documento d WHERE d.codcrfatura9 = :codcrfatura9")
    , @NamedQuery(name = "Documento.findByValorfatura10", query = "SELECT d FROM Documento d WHERE d.valorfatura10 = :valorfatura10")
    , @NamedQuery(name = "Documento.findByNumerofatura10", query = "SELECT d FROM Documento d WHERE d.numerofatura10 = :numerofatura10")
    , @NamedQuery(name = "Documento.findByVencimentofatura10", query = "SELECT d FROM Documento d WHERE d.vencimentofatura10 = :vencimentofatura10")
    , @NamedQuery(name = "Documento.findByCodcrfatura10", query = "SELECT d FROM Documento d WHERE d.codcrfatura10 = :codcrfatura10")
    , @NamedQuery(name = "Documento.findByValorfatura11", query = "SELECT d FROM Documento d WHERE d.valorfatura11 = :valorfatura11")
    , @NamedQuery(name = "Documento.findByNumerofatura11", query = "SELECT d FROM Documento d WHERE d.numerofatura11 = :numerofatura11")
    , @NamedQuery(name = "Documento.findByVencimentofatura11", query = "SELECT d FROM Documento d WHERE d.vencimentofatura11 = :vencimentofatura11")
    , @NamedQuery(name = "Documento.findByCodcrfatura11", query = "SELECT d FROM Documento d WHERE d.codcrfatura11 = :codcrfatura11")
    , @NamedQuery(name = "Documento.findByValorfatura12", query = "SELECT d FROM Documento d WHERE d.valorfatura12 = :valorfatura12")
    , @NamedQuery(name = "Documento.findByNumerofatura12", query = "SELECT d FROM Documento d WHERE d.numerofatura12 = :numerofatura12")
    , @NamedQuery(name = "Documento.findByVencimentofatura12", query = "SELECT d FROM Documento d WHERE d.vencimentofatura12 = :vencimentofatura12")
    , @NamedQuery(name = "Documento.findByCodcrfatura12", query = "SELECT d FROM Documento d WHERE d.codcrfatura12 = :codcrfatura12")
    , @NamedQuery(name = "Documento.findByValorfatura13", query = "SELECT d FROM Documento d WHERE d.valorfatura13 = :valorfatura13")
    , @NamedQuery(name = "Documento.findByNumerofatura13", query = "SELECT d FROM Documento d WHERE d.numerofatura13 = :numerofatura13")
    , @NamedQuery(name = "Documento.findByVencimentofatura13", query = "SELECT d FROM Documento d WHERE d.vencimentofatura13 = :vencimentofatura13")
    , @NamedQuery(name = "Documento.findByCodcrfatura13", query = "SELECT d FROM Documento d WHERE d.codcrfatura13 = :codcrfatura13")
    , @NamedQuery(name = "Documento.findByValorfatura14", query = "SELECT d FROM Documento d WHERE d.valorfatura14 = :valorfatura14")
    , @NamedQuery(name = "Documento.findByNumerofatura14", query = "SELECT d FROM Documento d WHERE d.numerofatura14 = :numerofatura14")
    , @NamedQuery(name = "Documento.findByVencimentofatura14", query = "SELECT d FROM Documento d WHERE d.vencimentofatura14 = :vencimentofatura14")
    , @NamedQuery(name = "Documento.findByCodcrfatura14", query = "SELECT d FROM Documento d WHERE d.codcrfatura14 = :codcrfatura14")
    , @NamedQuery(name = "Documento.findByValorfatura15", query = "SELECT d FROM Documento d WHERE d.valorfatura15 = :valorfatura15")
    , @NamedQuery(name = "Documento.findByNumerofatura15", query = "SELECT d FROM Documento d WHERE d.numerofatura15 = :numerofatura15")
    , @NamedQuery(name = "Documento.findByVencimentofatura15", query = "SELECT d FROM Documento d WHERE d.vencimentofatura15 = :vencimentofatura15")
    , @NamedQuery(name = "Documento.findByCodcrfatura15", query = "SELECT d FROM Documento d WHERE d.codcrfatura15 = :codcrfatura15")
    , @NamedQuery(name = "Documento.findByValorfatura16", query = "SELECT d FROM Documento d WHERE d.valorfatura16 = :valorfatura16")
    , @NamedQuery(name = "Documento.findByNumerofatura16", query = "SELECT d FROM Documento d WHERE d.numerofatura16 = :numerofatura16")
    , @NamedQuery(name = "Documento.findByVencimentofatura16", query = "SELECT d FROM Documento d WHERE d.vencimentofatura16 = :vencimentofatura16")
    , @NamedQuery(name = "Documento.findByCodcrfatura16", query = "SELECT d FROM Documento d WHERE d.codcrfatura16 = :codcrfatura16")
    , @NamedQuery(name = "Documento.findByValorfatura17", query = "SELECT d FROM Documento d WHERE d.valorfatura17 = :valorfatura17")
    , @NamedQuery(name = "Documento.findByNumerofatura17", query = "SELECT d FROM Documento d WHERE d.numerofatura17 = :numerofatura17")
    , @NamedQuery(name = "Documento.findByVencimentofatura17", query = "SELECT d FROM Documento d WHERE d.vencimentofatura17 = :vencimentofatura17")
    , @NamedQuery(name = "Documento.findByCodcrfatura17", query = "SELECT d FROM Documento d WHERE d.codcrfatura17 = :codcrfatura17")
    , @NamedQuery(name = "Documento.findByValorfatura18", query = "SELECT d FROM Documento d WHERE d.valorfatura18 = :valorfatura18")
    , @NamedQuery(name = "Documento.findByNumerofatura18", query = "SELECT d FROM Documento d WHERE d.numerofatura18 = :numerofatura18")
    , @NamedQuery(name = "Documento.findByVencimentofatura18", query = "SELECT d FROM Documento d WHERE d.vencimentofatura18 = :vencimentofatura18")
    , @NamedQuery(name = "Documento.findByCodcrfatura18", query = "SELECT d FROM Documento d WHERE d.codcrfatura18 = :codcrfatura18")
    , @NamedQuery(name = "Documento.findByValorfatura19", query = "SELECT d FROM Documento d WHERE d.valorfatura19 = :valorfatura19")
    , @NamedQuery(name = "Documento.findByNumerofatura19", query = "SELECT d FROM Documento d WHERE d.numerofatura19 = :numerofatura19")
    , @NamedQuery(name = "Documento.findByVencimentofatura19", query = "SELECT d FROM Documento d WHERE d.vencimentofatura19 = :vencimentofatura19")
    , @NamedQuery(name = "Documento.findByCodcrfatura19", query = "SELECT d FROM Documento d WHERE d.codcrfatura19 = :codcrfatura19")
    , @NamedQuery(name = "Documento.findByValorfatura20", query = "SELECT d FROM Documento d WHERE d.valorfatura20 = :valorfatura20")
    , @NamedQuery(name = "Documento.findByNumerofatura20", query = "SELECT d FROM Documento d WHERE d.numerofatura20 = :numerofatura20")
    , @NamedQuery(name = "Documento.findByVencimentofatura20", query = "SELECT d FROM Documento d WHERE d.vencimentofatura20 = :vencimentofatura20")
    , @NamedQuery(name = "Documento.findByCodcrfatura20", query = "SELECT d FROM Documento d WHERE d.codcrfatura20 = :codcrfatura20")
    , @NamedQuery(name = "Documento.findByValorfatura21", query = "SELECT d FROM Documento d WHERE d.valorfatura21 = :valorfatura21")
    , @NamedQuery(name = "Documento.findByNumerofatura21", query = "SELECT d FROM Documento d WHERE d.numerofatura21 = :numerofatura21")
    , @NamedQuery(name = "Documento.findByVencimentofatura21", query = "SELECT d FROM Documento d WHERE d.vencimentofatura21 = :vencimentofatura21")
    , @NamedQuery(name = "Documento.findByCodcrfatura21", query = "SELECT d FROM Documento d WHERE d.codcrfatura21 = :codcrfatura21")
    , @NamedQuery(name = "Documento.findByValorfatura22", query = "SELECT d FROM Documento d WHERE d.valorfatura22 = :valorfatura22")
    , @NamedQuery(name = "Documento.findByNumerofatura22", query = "SELECT d FROM Documento d WHERE d.numerofatura22 = :numerofatura22")
    , @NamedQuery(name = "Documento.findByVencimentofatura22", query = "SELECT d FROM Documento d WHERE d.vencimentofatura22 = :vencimentofatura22")
    , @NamedQuery(name = "Documento.findByCodcrfatura22", query = "SELECT d FROM Documento d WHERE d.codcrfatura22 = :codcrfatura22")
    , @NamedQuery(name = "Documento.findByValorfatura23", query = "SELECT d FROM Documento d WHERE d.valorfatura23 = :valorfatura23")
    , @NamedQuery(name = "Documento.findByNumerofatura23", query = "SELECT d FROM Documento d WHERE d.numerofatura23 = :numerofatura23")
    , @NamedQuery(name = "Documento.findByVencimentofatura23", query = "SELECT d FROM Documento d WHERE d.vencimentofatura23 = :vencimentofatura23")
    , @NamedQuery(name = "Documento.findByCodcrfatura23", query = "SELECT d FROM Documento d WHERE d.codcrfatura23 = :codcrfatura23")
    , @NamedQuery(name = "Documento.findByValorfatura24", query = "SELECT d FROM Documento d WHERE d.valorfatura24 = :valorfatura24")
    , @NamedQuery(name = "Documento.findByNumerofatura24", query = "SELECT d FROM Documento d WHERE d.numerofatura24 = :numerofatura24")
    , @NamedQuery(name = "Documento.findByVencimentofatura24", query = "SELECT d FROM Documento d WHERE d.vencimentofatura24 = :vencimentofatura24")
    , @NamedQuery(name = "Documento.findByCodcrfatura24", query = "SELECT d FROM Documento d WHERE d.codcrfatura24 = :codcrfatura24")
    , @NamedQuery(name = "Documento.findByDestrazaosocial", query = "SELECT d FROM Documento d WHERE d.destrazaosocial = :destrazaosocial")
    , @NamedQuery(name = "Documento.findByDestfantasia", query = "SELECT d FROM Documento d WHERE d.destfantasia = :destfantasia")
    , @NamedQuery(name = "Documento.findByDestendereco", query = "SELECT d FROM Documento d WHERE d.destendereco = :destendereco")
    , @NamedQuery(name = "Documento.findByDestbairro", query = "SELECT d FROM Documento d WHERE d.destbairro = :destbairro")
    , @NamedQuery(name = "Documento.findByDestcidade", query = "SELECT d FROM Documento d WHERE d.destcidade = :destcidade")
    , @NamedQuery(name = "Documento.findByDestestado", query = "SELECT d FROM Documento d WHERE d.destestado = :destestado")
    , @NamedQuery(name = "Documento.findByDestcep", query = "SELECT d FROM Documento d WHERE d.destcep = :destcep")
    , @NamedQuery(name = "Documento.findByDesttelefone", query = "SELECT d FROM Documento d WHERE d.desttelefone = :desttelefone")
    , @NamedQuery(name = "Documento.findByDestinscr", query = "SELECT d FROM Documento d WHERE d.destinscr = :destinscr")
    , @NamedQuery(name = "Documento.findByDestsuframa", query = "SELECT d FROM Documento d WHERE d.destsuframa = :destsuframa")
    , @NamedQuery(name = "Documento.findByDestcnpjcpf", query = "SELECT d FROM Documento d WHERE d.destcnpjcpf = :destcnpjcpf")
    , @NamedQuery(name = "Documento.findByDesttipopessoa", query = "SELECT d FROM Documento d WHERE d.desttipopessoa = :desttipopessoa")
    , @NamedQuery(name = "Documento.findByDestidentidade", query = "SELECT d FROM Documento d WHERE d.destidentidade = :destidentidade")
    , @NamedQuery(name = "Documento.findByDestnomeentidade", query = "SELECT d FROM Documento d WHERE d.destnomeentidade = :destnomeentidade")
    , @NamedQuery(name = "Documento.findByEmitrazaosocial", query = "SELECT d FROM Documento d WHERE d.emitrazaosocial = :emitrazaosocial")
    , @NamedQuery(name = "Documento.findByEmitfantasia", query = "SELECT d FROM Documento d WHERE d.emitfantasia = :emitfantasia")
    , @NamedQuery(name = "Documento.findByEmitendereco", query = "SELECT d FROM Documento d WHERE d.emitendereco = :emitendereco")
    , @NamedQuery(name = "Documento.findByEmitbairro", query = "SELECT d FROM Documento d WHERE d.emitbairro = :emitbairro")
    , @NamedQuery(name = "Documento.findByEmitcidade", query = "SELECT d FROM Documento d WHERE d.emitcidade = :emitcidade")
    , @NamedQuery(name = "Documento.findByEmitestado", query = "SELECT d FROM Documento d WHERE d.emitestado = :emitestado")
    , @NamedQuery(name = "Documento.findByEmitcep", query = "SELECT d FROM Documento d WHERE d.emitcep = :emitcep")
    , @NamedQuery(name = "Documento.findByEmittelefone", query = "SELECT d FROM Documento d WHERE d.emittelefone = :emittelefone")
    , @NamedQuery(name = "Documento.findByEmitinscr", query = "SELECT d FROM Documento d WHERE d.emitinscr = :emitinscr")
    , @NamedQuery(name = "Documento.findByEmitcnpjcpf", query = "SELECT d FROM Documento d WHERE d.emitcnpjcpf = :emitcnpjcpf")
    , @NamedQuery(name = "Documento.findByTranspnome", query = "SELECT d FROM Documento d WHERE d.transpnome = :transpnome")
    , @NamedQuery(name = "Documento.findByTranspendereco", query = "SELECT d FROM Documento d WHERE d.transpendereco = :transpendereco")
    , @NamedQuery(name = "Documento.findByTranspbairro", query = "SELECT d FROM Documento d WHERE d.transpbairro = :transpbairro")
    , @NamedQuery(name = "Documento.findByTranspcidade", query = "SELECT d FROM Documento d WHERE d.transpcidade = :transpcidade")
    , @NamedQuery(name = "Documento.findByTranspestado", query = "SELECT d FROM Documento d WHERE d.transpestado = :transpestado")
    , @NamedQuery(name = "Documento.findByTranspinscr", query = "SELECT d FROM Documento d WHERE d.transpinscr = :transpinscr")
    , @NamedQuery(name = "Documento.findByTranspcnpj", query = "SELECT d FROM Documento d WHERE d.transpcnpj = :transpcnpj")
    , @NamedQuery(name = "Documento.findByTranspantt", query = "SELECT d FROM Documento d WHERE d.transpantt = :transpantt")
    , @NamedQuery(name = "Documento.findByCobrancaendereco", query = "SELECT d FROM Documento d WHERE d.cobrancaendereco = :cobrancaendereco")
    , @NamedQuery(name = "Documento.findByCobrancabairro", query = "SELECT d FROM Documento d WHERE d.cobrancabairro = :cobrancabairro")
    , @NamedQuery(name = "Documento.findByCobrancacidade", query = "SELECT d FROM Documento d WHERE d.cobrancacidade = :cobrancacidade")
    , @NamedQuery(name = "Documento.findByCobrancaestado", query = "SELECT d FROM Documento d WHERE d.cobrancaestado = :cobrancaestado")
    , @NamedQuery(name = "Documento.findByCobrancacep", query = "SELECT d FROM Documento d WHERE d.cobrancacep = :cobrancacep")
    , @NamedQuery(name = "Documento.findByCobrancatelefone", query = "SELECT d FROM Documento d WHERE d.cobrancatelefone = :cobrancatelefone")
    , @NamedQuery(name = "Documento.findByEntregaendereco", query = "SELECT d FROM Documento d WHERE d.entregaendereco = :entregaendereco")
    , @NamedQuery(name = "Documento.findByEntregabairro", query = "SELECT d FROM Documento d WHERE d.entregabairro = :entregabairro")
    , @NamedQuery(name = "Documento.findByEntregacidade", query = "SELECT d FROM Documento d WHERE d.entregacidade = :entregacidade")
    , @NamedQuery(name = "Documento.findByEntregaestado", query = "SELECT d FROM Documento d WHERE d.entregaestado = :entregaestado")
    , @NamedQuery(name = "Documento.findByEntregacep", query = "SELECT d FROM Documento d WHERE d.entregacep = :entregacep")
    , @NamedQuery(name = "Documento.findByEntregareferencia", query = "SELECT d FROM Documento d WHERE d.entregareferencia = :entregareferencia")
    , @NamedQuery(name = "Documento.findByEntregatelefone", query = "SELECT d FROM Documento d WHERE d.entregatelefone = :entregatelefone")
    , @NamedQuery(name = "Documento.findByFlagtipodesconto", query = "SELECT d FROM Documento d WHERE d.flagtipodesconto = :flagtipodesconto")
    , @NamedQuery(name = "Documento.findByFlagtipoacrescimo", query = "SELECT d FROM Documento d WHERE d.flagtipoacrescimo = :flagtipoacrescimo")
    , @NamedQuery(name = "Documento.findByValortotalservicos", query = "SELECT d FROM Documento d WHERE d.valortotalservicos = :valortotalservicos")
    , @NamedQuery(name = "Documento.findByValortotalitens", query = "SELECT d FROM Documento d WHERE d.valortotalitens = :valortotalitens")
    , @NamedQuery(name = "Documento.findByValoriss", query = "SELECT d FROM Documento d WHERE d.valoriss = :valoriss")
    , @NamedQuery(name = "Documento.findByCampostr2", query = "SELECT d FROM Documento d WHERE d.campostr2 = :campostr2")
    , @NamedQuery(name = "Documento.findByNumerocupomfiscal", query = "SELECT d FROM Documento d WHERE d.numerocupomfiscal = :numerocupomfiscal")
    , @NamedQuery(name = "Documento.findByNumeropedido", query = "SELECT d FROM Documento d WHERE d.numeropedido = :numeropedido")
    , @NamedQuery(name = "Documento.findByDadosadicionais", query = "SELECT d FROM Documento d WHERE d.dadosadicionais = :dadosadicionais")
    , @NamedQuery(name = "Documento.findByMensagem", query = "SELECT d FROM Documento d WHERE d.mensagem = :mensagem")
    , @NamedQuery(name = "Documento.findByDatainclusao", query = "SELECT d FROM Documento d WHERE d.datainclusao = :datainclusao")
    , @NamedQuery(name = "Documento.findByDataemissao", query = "SELECT d FROM Documento d WHERE d.dataemissao = :dataemissao")
    , @NamedQuery(name = "Documento.findByDatasaida", query = "SELECT d FROM Documento d WHERE d.datasaida = :datasaida")
    , @NamedQuery(name = "Documento.findByHorasaida", query = "SELECT d FROM Documento d WHERE d.horasaida = :horasaida")
    , @NamedQuery(name = "Documento.findByEspeciecarga", query = "SELECT d FROM Documento d WHERE d.especiecarga = :especiecarga")
    , @NamedQuery(name = "Documento.findByMarcacarga", query = "SELECT d FROM Documento d WHERE d.marcacarga = :marcacarga")
    , @NamedQuery(name = "Documento.findByNumerovolume", query = "SELECT d FROM Documento d WHERE d.numerovolume = :numerovolume")
    , @NamedQuery(name = "Documento.findByPesobruto", query = "SELECT d FROM Documento d WHERE d.pesobruto = :pesobruto")
    , @NamedQuery(name = "Documento.findByPesoliquido", query = "SELECT d FROM Documento d WHERE d.pesoliquido = :pesoliquido")
    , @NamedQuery(name = "Documento.findByPlacaveiculo", query = "SELECT d FROM Documento d WHERE d.placaveiculo = :placaveiculo")
    , @NamedQuery(name = "Documento.findByEstadoplacaveiculo", query = "SELECT d FROM Documento d WHERE d.estadoplacaveiculo = :estadoplacaveiculo")
    , @NamedQuery(name = "Documento.findByNaturezaoperacao", query = "SELECT d FROM Documento d WHERE d.naturezaoperacao = :naturezaoperacao")
    , @NamedQuery(name = "Documento.findBySerienota", query = "SELECT d FROM Documento d WHERE d.serienota = :serienota")
    , @NamedQuery(name = "Documento.findByCodempresatipodocumento", query = "SELECT d FROM Documento d WHERE d.codempresatipodocumento = :codempresatipodocumento")
    , @NamedQuery(name = "Documento.findByAliqpis", query = "SELECT d FROM Documento d WHERE d.aliqpis = :aliqpis")
    , @NamedQuery(name = "Documento.findByAliqcofins", query = "SELECT d FROM Documento d WHERE d.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Documento.findByValorqpis", query = "SELECT d FROM Documento d WHERE d.valorqpis = :valorqpis")
    , @NamedQuery(name = "Documento.findByValorcofins", query = "SELECT d FROM Documento d WHERE d.valorcofins = :valorcofins")
    , @NamedQuery(name = "Documento.findByValorabatimentonaotribicms", query = "SELECT d FROM Documento d WHERE d.valorabatimentonaotribicms = :valorabatimentonaotribicms")
    , @NamedQuery(name = "Documento.findByValorabatimentonaotribpis", query = "SELECT d FROM Documento d WHERE d.valorabatimentonaotribpis = :valorabatimentonaotribpis")
    , @NamedQuery(name = "Documento.findByValorabatimentonaotribcofins", query = "SELECT d FROM Documento d WHERE d.valorabatimentonaotribcofins = :valorabatimentonaotribcofins")
    , @NamedQuery(name = "Documento.findByValorabatimentonaotribipi", query = "SELECT d FROM Documento d WHERE d.valorabatimentonaotribipi = :valorabatimentonaotribipi")
    , @NamedQuery(name = "Documento.findByTipopagamento", query = "SELECT d FROM Documento d WHERE d.tipopagamento = :tipopagamento")
    , @NamedQuery(name = "Documento.findByFlagcrt", query = "SELECT d FROM Documento d WHERE d.flagcrt = :flagcrt")
    , @NamedQuery(name = "Documento.findByBaseiss", query = "SELECT d FROM Documento d WHERE d.baseiss = :baseiss")
    , @NamedQuery(name = "Documento.findBySubserie", query = "SELECT d FROM Documento d WHERE d.subserie = :subserie")
    , @NamedQuery(name = "Documento.findByValortotalii", query = "SELECT d FROM Documento d WHERE d.valortotalii = :valortotalii")
    , @NamedQuery(name = "Documento.findByDestemail", query = "SELECT d FROM Documento d WHERE d.destemail = :destemail")
    , @NamedQuery(name = "Documento.findByValorpisdesonerado", query = "SELECT d FROM Documento d WHERE d.valorpisdesonerado = :valorpisdesonerado")
    , @NamedQuery(name = "Documento.findByValorcofinsdesonerado", query = "SELECT d FROM Documento d WHERE d.valorcofinsdesonerado = :valorcofinsdesonerado")
    , @NamedQuery(name = "Documento.findByFlagnfajuste", query = "SELECT d FROM Documento d WHERE d.flagnfajuste = :flagnfajuste")
    , @NamedQuery(name = "Documento.findByCodclifidelizacao", query = "SELECT d FROM Documento d WHERE d.codclifidelizacao = :codclifidelizacao")
    , @NamedQuery(name = "Documento.findByFlagnfdevolucao", query = "SELECT d FROM Documento d WHERE d.flagnfdevolucao = :flagnfdevolucao")
    , @NamedQuery(name = "Documento.findByIndpresenca", query = "SELECT d FROM Documento d WHERE d.indpresenca = :indpresenca")
    , @NamedQuery(name = "Documento.findByIndoperacao", query = "SELECT d FROM Documento d WHERE d.indoperacao = :indoperacao")
    , @NamedQuery(name = "Documento.findByIndiedest", query = "SELECT d FROM Documento d WHERE d.indiedest = :indiedest")
    , @NamedQuery(name = "Documento.findByIdestrangeiro", query = "SELECT d FROM Documento d WHERE d.idestrangeiro = :idestrangeiro")
    , @NamedQuery(name = "Documento.findByValoricmsdestinopart", query = "SELECT d FROM Documento d WHERE d.valoricmsdestinopart = :valoricmsdestinopart")
    , @NamedQuery(name = "Documento.findByValoricmsorigempart", query = "SELECT d FROM Documento d WHERE d.valoricmsorigempart = :valoricmsorigempart")
    , @NamedQuery(name = "Documento.findByValorfcppart", query = "SELECT d FROM Documento d WHERE d.valorfcppart = :valorfcppart")
    , @NamedQuery(name = "Documento.findByFlagdocreferenciado", query = "SELECT d FROM Documento d WHERE d.flagdocreferenciado = :flagdocreferenciado")
    , @NamedQuery(name = "Documento.findByEntreganumerologradouro", query = "SELECT d FROM Documento d WHERE d.entreganumerologradouro = :entreganumerologradouro")
    , @NamedQuery(name = "Documento.findByEntregacomplementologradouro", query = "SELECT d FROM Documento d WHERE d.entregacomplementologradouro = :entregacomplementologradouro")
    , @NamedQuery(name = "Documento.findByValortotalpisissqn", query = "SELECT d FROM Documento d WHERE d.valortotalpisissqn = :valortotalpisissqn")
    , @NamedQuery(name = "Documento.findByValortotalcofinsissqn", query = "SELECT d FROM Documento d WHERE d.valortotalcofinsissqn = :valortotalcofinsissqn")
    , @NamedQuery(name = "Documento.findByIdentificadordestino", query = "SELECT d FROM Documento d WHERE d.identificadordestino = :identificadordestino")
    , @NamedQuery(name = "Documento.findByTributofederal", query = "SELECT d FROM Documento d WHERE d.tributofederal = :tributofederal")
    , @NamedQuery(name = "Documento.findByTributoestadual", query = "SELECT d FROM Documento d WHERE d.tributoestadual = :tributoestadual")
    , @NamedQuery(name = "Documento.findByTributomunicipal", query = "SELECT d FROM Documento d WHERE d.tributomunicipal = :tributomunicipal")
    , @NamedQuery(name = "Documento.findByAliqaprox", query = "SELECT d FROM Documento d WHERE d.aliqaprox = :aliqaprox")
    , @NamedQuery(name = "Documento.findByValortroco", query = "SELECT d FROM Documento d WHERE d.valortroco = :valortroco")
    , @NamedQuery(name = "Documento.findByValorfcp", query = "SELECT d FROM Documento d WHERE d.valorfcp = :valorfcp")
    , @NamedQuery(name = "Documento.findByValorfcpsubsttributaria", query = "SELECT d FROM Documento d WHERE d.valorfcpsubsttributaria = :valorfcpsubsttributaria")
    , @NamedQuery(name = "Documento.findByValortotalipidevolvido", query = "SELECT d FROM Documento d WHERE d.valortotalipidevolvido = :valortotalipidevolvido")
    , @NamedQuery(name = "Documento.findByCodmodalidadefrete", query = "SELECT d FROM Documento d WHERE d.codmodalidadefrete = :codmodalidadefrete")
    , @NamedQuery(name = "Documento.findByNumpedcliente", query = "SELECT d FROM Documento d WHERE d.numpedcliente = :numpedcliente")
    , @NamedQuery(name = "Documento.findByFlagaltpaf", query = "SELECT d FROM Documento d WHERE d.flagaltpaf = :flagaltpaf")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDOCUMENTO")
    private String coddocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALORSEGURO")
    private BigDecimal valorseguro;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "VALOROUTRASDESPESAS")
    private BigDecimal valoroutrasdespesas;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Column(name = "CAMPOVALOR1")
    private BigDecimal campovalor1;
    @Column(name = "PESOADICIONALEMBALAGEM")
    private BigDecimal pesoadicionalembalagem;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "FLAGCANCELADA")
    private Character flagcancelada;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "QUANTIDADEVOLUMES")
    private Integer quantidadevolumes;
    @Column(name = "VALORICMSDEDUZIDO")
    private BigDecimal valoricmsdeduzido;
    @Column(name = "BASEICMSDEDUZIDO")
    private BigDecimal baseicmsdeduzido;
    @Column(name = "CAMPOSTR1")
    private String campostr1;
    @Column(name = "CODPAIS")
    private String codpais;
    @Column(name = "EMITCOMPLEMENTOLOGRADOURO")
    private String emitcomplementologradouro;
    @Column(name = "DESTCOMPLEMENTOLOGRADOURO")
    private String destcomplementologradouro;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Column(name = "TRANSPLOCALEMBARQUE")
    private String transplocalembarque;
    @Column(name = "TRANSPUFEMBARQUE")
    private String transpufembarque;
    @Column(name = "CHAVEACESSONFELETRONICA")
    private String chaveacessonfeletronica;
    @Column(name = "EMITINSCRSUBSTTRIB")
    private String emitinscrsubsttrib;
    @Column(name = "EMITCNAE")
    private String emitcnae;
    @Column(name = "FLAGNFCOMPLEMENTAR")
    private Character flagnfcomplementar;
    @Column(name = "CODDOCUMENTOREFERENCIADO")
    private String coddocumentoreferenciado;
    @Column(name = "CHAVEACESSONFEREFERENCIADA")
    private String chaveacessonfereferenciada;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Column(name = "FLAGIMPRESSAO")
    private Character flagimpressao;
    @Column(name = "DATAVENDA")
    @Temporal(TemporalType.DATE)
    private Date datavenda;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "NOMEVENDEDOR")
    private String nomevendedor;
    @Column(name = "FORMAPAGAMENTO")
    private String formapagamento;
    @Column(name = "EMITNUMEROLOGRADOURO")
    private String emitnumerologradouro;
    @Column(name = "DESTNUMEROLOGRADOURO")
    private String destnumerologradouro;
    @Column(name = "EMITINSCRICAOMUNICIPAL")
    private String emitinscricaomunicipal;
    @Column(name = "MODELODOCUMENTO")
    private String modelodocumento;
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
    @Column(name = "VALORFATURA1")
    private BigDecimal valorfatura1;
    @Column(name = "NUMEROFATURA1")
    private String numerofatura1;
    @Column(name = "VENCIMENTOFATURA1")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura1;
    @Column(name = "CODCRFATURA1")
    private String codcrfatura1;
    @Column(name = "VALORFATURA2")
    private BigDecimal valorfatura2;
    @Column(name = "NUMEROFATURA2")
    private String numerofatura2;
    @Column(name = "VENCIMENTOFATURA2")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura2;
    @Column(name = "CODCRFATURA2")
    private String codcrfatura2;
    @Column(name = "VALORFATURA3")
    private BigDecimal valorfatura3;
    @Column(name = "NUMEROFATURA3")
    private String numerofatura3;
    @Column(name = "VENCIMENTOFATURA3")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura3;
    @Column(name = "CODCRFATURA3")
    private String codcrfatura3;
    @Column(name = "VALORFATURA4")
    private BigDecimal valorfatura4;
    @Column(name = "NUMEROFATURA4")
    private String numerofatura4;
    @Column(name = "VENCIMENTOFATURA4")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura4;
    @Column(name = "CODCRFATURA4")
    private String codcrfatura4;
    @Column(name = "VALORFATURA5")
    private BigDecimal valorfatura5;
    @Column(name = "NUMEROFATURA5")
    private String numerofatura5;
    @Column(name = "VENCIMENTOFATURA5")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura5;
    @Column(name = "CODCRFATURA5")
    private String codcrfatura5;
    @Column(name = "VALORFATURA6")
    private BigDecimal valorfatura6;
    @Column(name = "NUMEROFATURA6")
    private String numerofatura6;
    @Column(name = "VENCIMENTOFATURA6")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura6;
    @Column(name = "CODCRFATURA6")
    private String codcrfatura6;
    @Column(name = "VALORFATURA7")
    private BigDecimal valorfatura7;
    @Column(name = "NUMEROFATURA7")
    private String numerofatura7;
    @Column(name = "VENCIMENTOFATURA7")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura7;
    @Column(name = "CODCRFATURA7")
    private String codcrfatura7;
    @Column(name = "VALORFATURA8")
    private BigDecimal valorfatura8;
    @Column(name = "NUMEROFATURA8")
    private String numerofatura8;
    @Column(name = "VENCIMENTOFATURA8")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura8;
    @Column(name = "CODCRFATURA8")
    private String codcrfatura8;
    @Column(name = "VALORFATURA9")
    private BigDecimal valorfatura9;
    @Column(name = "NUMEROFATURA9")
    private String numerofatura9;
    @Column(name = "VENCIMENTOFATURA9")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura9;
    @Column(name = "CODCRFATURA9")
    private String codcrfatura9;
    @Column(name = "VALORFATURA10")
    private BigDecimal valorfatura10;
    @Column(name = "NUMEROFATURA10")
    private String numerofatura10;
    @Column(name = "VENCIMENTOFATURA10")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura10;
    @Column(name = "CODCRFATURA10")
    private String codcrfatura10;
    @Column(name = "VALORFATURA11")
    private BigDecimal valorfatura11;
    @Column(name = "NUMEROFATURA11")
    private String numerofatura11;
    @Column(name = "VENCIMENTOFATURA11")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura11;
    @Column(name = "CODCRFATURA11")
    private String codcrfatura11;
    @Column(name = "VALORFATURA12")
    private BigDecimal valorfatura12;
    @Column(name = "NUMEROFATURA12")
    private String numerofatura12;
    @Column(name = "VENCIMENTOFATURA12")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura12;
    @Column(name = "CODCRFATURA12")
    private String codcrfatura12;
    @Column(name = "VALORFATURA13")
    private BigDecimal valorfatura13;
    @Column(name = "NUMEROFATURA13")
    private String numerofatura13;
    @Column(name = "VENCIMENTOFATURA13")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura13;
    @Column(name = "CODCRFATURA13")
    private String codcrfatura13;
    @Column(name = "VALORFATURA14")
    private BigDecimal valorfatura14;
    @Column(name = "NUMEROFATURA14")
    private String numerofatura14;
    @Column(name = "VENCIMENTOFATURA14")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura14;
    @Column(name = "CODCRFATURA14")
    private String codcrfatura14;
    @Column(name = "VALORFATURA15")
    private BigDecimal valorfatura15;
    @Column(name = "NUMEROFATURA15")
    private String numerofatura15;
    @Column(name = "VENCIMENTOFATURA15")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura15;
    @Column(name = "CODCRFATURA15")
    private String codcrfatura15;
    @Column(name = "VALORFATURA16")
    private BigDecimal valorfatura16;
    @Column(name = "NUMEROFATURA16")
    private String numerofatura16;
    @Column(name = "VENCIMENTOFATURA16")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura16;
    @Column(name = "CODCRFATURA16")
    private String codcrfatura16;
    @Column(name = "VALORFATURA17")
    private BigDecimal valorfatura17;
    @Column(name = "NUMEROFATURA17")
    private String numerofatura17;
    @Column(name = "VENCIMENTOFATURA17")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura17;
    @Column(name = "CODCRFATURA17")
    private String codcrfatura17;
    @Column(name = "VALORFATURA18")
    private BigDecimal valorfatura18;
    @Column(name = "NUMEROFATURA18")
    private String numerofatura18;
    @Column(name = "VENCIMENTOFATURA18")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura18;
    @Column(name = "CODCRFATURA18")
    private String codcrfatura18;
    @Column(name = "VALORFATURA19")
    private BigDecimal valorfatura19;
    @Column(name = "NUMEROFATURA19")
    private String numerofatura19;
    @Column(name = "VENCIMENTOFATURA19")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura19;
    @Column(name = "CODCRFATURA19")
    private String codcrfatura19;
    @Column(name = "VALORFATURA20")
    private BigDecimal valorfatura20;
    @Column(name = "NUMEROFATURA20")
    private String numerofatura20;
    @Column(name = "VENCIMENTOFATURA20")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura20;
    @Column(name = "CODCRFATURA20")
    private String codcrfatura20;
    @Column(name = "VALORFATURA21")
    private BigDecimal valorfatura21;
    @Column(name = "NUMEROFATURA21")
    private String numerofatura21;
    @Column(name = "VENCIMENTOFATURA21")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura21;
    @Column(name = "CODCRFATURA21")
    private String codcrfatura21;
    @Column(name = "VALORFATURA22")
    private BigDecimal valorfatura22;
    @Column(name = "NUMEROFATURA22")
    private String numerofatura22;
    @Column(name = "VENCIMENTOFATURA22")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura22;
    @Column(name = "CODCRFATURA22")
    private String codcrfatura22;
    @Column(name = "VALORFATURA23")
    private BigDecimal valorfatura23;
    @Column(name = "NUMEROFATURA23")
    private String numerofatura23;
    @Column(name = "VENCIMENTOFATURA23")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura23;
    @Column(name = "CODCRFATURA23")
    private String codcrfatura23;
    @Column(name = "VALORFATURA24")
    private BigDecimal valorfatura24;
    @Column(name = "NUMEROFATURA24")
    private String numerofatura24;
    @Column(name = "VENCIMENTOFATURA24")
    @Temporal(TemporalType.DATE)
    private Date vencimentofatura24;
    @Column(name = "CODCRFATURA24")
    private String codcrfatura24;
    @Column(name = "DESTRAZAOSOCIAL")
    private String destrazaosocial;
    @Column(name = "DESTFANTASIA")
    private String destfantasia;
    @Column(name = "DESTENDERECO")
    private String destendereco;
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
    @Column(name = "DESTSUFRAMA")
    private String destsuframa;
    @Column(name = "DESTCNPJCPF")
    private String destcnpjcpf;
    @Column(name = "DESTTIPOPESSOA")
    private Character desttipopessoa;
    @Column(name = "DESTIDENTIDADE")
    private String destidentidade;
    @Column(name = "DESTNOMEENTIDADE")
    private String destnomeentidade;
    @Column(name = "EMITRAZAOSOCIAL")
    private String emitrazaosocial;
    @Column(name = "EMITFANTASIA")
    private String emitfantasia;
    @Column(name = "EMITENDERECO")
    private String emitendereco;
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
    @Column(name = "EMITCNPJCPF")
    private String emitcnpjcpf;
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
    @Column(name = "TRANSPINSCR")
    private String transpinscr;
    @Column(name = "TRANSPCNPJ")
    private String transpcnpj;
    @Column(name = "TRANSPANTT")
    private String transpantt;
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
    @Column(name = "ENTREGAREFERENCIA")
    private String entregareferencia;
    @Column(name = "ENTREGATELEFONE")
    private String entregatelefone;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALITENS")
    private BigDecimal valortotalitens;
    @Column(name = "VALORISS")
    private BigDecimal valoriss;
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "CAMPOSTR2")
    private String campostr2;
    @Column(name = "NUMEROCUPOMFISCAL")
    private Integer numerocupomfiscal;
    @Column(name = "NUMEROPEDIDO")
    private String numeropedido;
    @Column(name = "DADOSADICIONAIS")
    private String dadosadicionais;
    @Column(name = "MENSAGEM")
    private String mensagem;
    @Lob
    @Column(name = "OBSERVACAONOTAFISCAL")
    private String observacaonotafiscal;
    @Column(name = "DATAINCLUSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datainclusao;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "HORASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horasaida;
    @Column(name = "ESPECIECARGA")
    private String especiecarga;
    @Column(name = "MARCACARGA")
    private String marcacarga;
    @Column(name = "NUMEROVOLUME")
    private String numerovolume;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "PLACAVEICULO")
    private String placaveiculo;
    @Column(name = "ESTADOPLACAVEICULO")
    private String estadoplacaveiculo;
    @Column(name = "NATUREZAOPERACAO")
    private String naturezaoperacao;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "CODEMPRESATIPODOCUMENTO")
    private String codempresatipodocumento;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "VALORQPIS")
    private BigDecimal valorqpis;
    @Column(name = "VALORCOFINS")
    private BigDecimal valorcofins;
    @Lob
    @Column(name = "MOTIVOCANCELAMENTO")
    private String motivocancelamento;
    @Column(name = "VALORABATIMENTONAOTRIBICMS")
    private BigDecimal valorabatimentonaotribicms;
    @Column(name = "VALORABATIMENTONAOTRIBPIS")
    private BigDecimal valorabatimentonaotribpis;
    @Column(name = "VALORABATIMENTONAOTRIBCOFINS")
    private BigDecimal valorabatimentonaotribcofins;
    @Column(name = "VALORABATIMENTONAOTRIBIPI")
    private BigDecimal valorabatimentonaotribipi;
    @Column(name = "TIPOPAGAMENTO")
    private Character tipopagamento;
    @Column(name = "FLAGCRT")
    private Character flagcrt;
    @Column(name = "BASEISS")
    private BigDecimal baseiss;
    @Column(name = "SUBSERIE")
    private Integer subserie;
    @Column(name = "VALORTOTALII")
    private BigDecimal valortotalii;
    @Column(name = "DESTEMAIL")
    private String destemail;
    @Column(name = "VALORPISDESONERADO")
    private BigDecimal valorpisdesonerado;
    @Column(name = "VALORCOFINSDESONERADO")
    private BigDecimal valorcofinsdesonerado;
    @Column(name = "FLAGNFAJUSTE")
    private Character flagnfajuste;
    @Column(name = "CODCLIFIDELIZACAO")
    private String codclifidelizacao;
    @Lob
    @Column(name = "EMAILCCDANFE")
    private String emailccdanfe;
    @Column(name = "FLAGNFDEVOLUCAO")
    private Character flagnfdevolucao;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "INDOPERACAO")
    private Character indoperacao;
    @Column(name = "INDIEDEST")
    private Character indiedest;
    @Column(name = "IDESTRANGEIRO")
    private String idestrangeiro;
    @Lob
    @Column(name = "DADOSADICIONAISFISCO")
    private String dadosadicionaisfisco;
    @Column(name = "VALORICMSDESTINOPART")
    private BigDecimal valoricmsdestinopart;
    @Column(name = "VALORICMSORIGEMPART")
    private BigDecimal valoricmsorigempart;
    @Column(name = "VALORFCPPART")
    private BigDecimal valorfcppart;
    @Column(name = "FLAGDOCREFERENCIADO")
    private Character flagdocreferenciado;
    @Column(name = "ENTREGANUMEROLOGRADOURO")
    private String entreganumerologradouro;
    @Column(name = "ENTREGACOMPLEMENTOLOGRADOURO")
    private String entregacomplementologradouro;
    @Column(name = "VALORTOTALPISISSQN")
    private BigDecimal valortotalpisissqn;
    @Column(name = "VALORTOTALCOFINSISSQN")
    private BigDecimal valortotalcofinsissqn;
    @Column(name = "IDENTIFICADORDESTINO")
    private Character identificadordestino;
    @Column(name = "TRIBUTOFEDERAL")
    private BigDecimal tributofederal;
    @Column(name = "TRIBUTOESTADUAL")
    private BigDecimal tributoestadual;
    @Column(name = "TRIBUTOMUNICIPAL")
    private BigDecimal tributomunicipal;
    @Column(name = "ALIQAPROX")
    private BigDecimal aliqaprox;
    @Column(name = "VALORTROCO")
    private BigDecimal valortroco;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "VALORTOTALIPIDEVOLVIDO")
    private BigDecimal valortotalipidevolvido;
    @Column(name = "CODMODALIDADEFRETE")
    private Character codmodalidadefrete;
    @Column(name = "NUMPEDCLIENTE")
    private String numpedcliente;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentocfesatreferenciado> documentocfesatreferenciadoCollection;
    @OneToMany(mappedBy = "coddocumento")
    private Collection<Documentotransporte> documentotransporteCollection;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @JoinColumn(name = "CODUSER", referencedColumnName = "CODUSER")
    @ManyToOne
    private Usuario coduser;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @JoinColumn(name = "CODVENDEDEXT", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentodocref> documentodocrefCollection;
    @OneToMany(mappedBy = "coddocumento")
    private Collection<Mdfeletroniconf> mdfeletroniconfCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentoentrega> documentoentregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentoentidade> documentoentidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentoitem> documentoitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddocumento")
    private Collection<Documentopagamento> documentopagamentoCollection;

    public Documento() {
    }

    public Documento(String coddocumento) {
        this.coddocumento = coddocumento;
    }

    public String getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(String coddocumento) {
        this.coddocumento = coddocumento;
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

    public BigDecimal getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(BigDecimal valorseguro) {
        this.valorseguro = valorseguro;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public BigDecimal getValoroutrasdespesas() {
        return valoroutrasdespesas;
    }

    public void setValoroutrasdespesas(BigDecimal valoroutrasdespesas) {
        this.valoroutrasdespesas = valoroutrasdespesas;
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

    public BigDecimal getAliqacrescimo() {
        return aliqacrescimo;
    }

    public void setAliqacrescimo(BigDecimal aliqacrescimo) {
        this.aliqacrescimo = aliqacrescimo;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public BigDecimal getValortotalprodutos() {
        return valortotalprodutos;
    }

    public void setValortotalprodutos(BigDecimal valortotalprodutos) {
        this.valortotalprodutos = valortotalprodutos;
    }

    public BigDecimal getValortotalipi() {
        return valortotalipi;
    }

    public void setValortotalipi(BigDecimal valortotalipi) {
        this.valortotalipi = valortotalipi;
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

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public Character getFlagcancelada() {
        return flagcancelada;
    }

    public void setFlagcancelada(Character flagcancelada) {
        this.flagcancelada = flagcancelada;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public Integer getQuantidadevolumes() {
        return quantidadevolumes;
    }

    public void setQuantidadevolumes(Integer quantidadevolumes) {
        this.quantidadevolumes = quantidadevolumes;
    }

    public BigDecimal getValoricmsdeduzido() {
        return valoricmsdeduzido;
    }

    public void setValoricmsdeduzido(BigDecimal valoricmsdeduzido) {
        this.valoricmsdeduzido = valoricmsdeduzido;
    }

    public BigDecimal getBaseicmsdeduzido() {
        return baseicmsdeduzido;
    }

    public void setBaseicmsdeduzido(BigDecimal baseicmsdeduzido) {
        this.baseicmsdeduzido = baseicmsdeduzido;
    }

    public String getCampostr1() {
        return campostr1;
    }

    public void setCampostr1(String campostr1) {
        this.campostr1 = campostr1;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getEmitcomplementologradouro() {
        return emitcomplementologradouro;
    }

    public void setEmitcomplementologradouro(String emitcomplementologradouro) {
        this.emitcomplementologradouro = emitcomplementologradouro;
    }

    public String getDestcomplementologradouro() {
        return destcomplementologradouro;
    }

    public void setDestcomplementologradouro(String destcomplementologradouro) {
        this.destcomplementologradouro = destcomplementologradouro;
    }

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
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

    public String getChaveacessonfeletronica() {
        return chaveacessonfeletronica;
    }

    public void setChaveacessonfeletronica(String chaveacessonfeletronica) {
        this.chaveacessonfeletronica = chaveacessonfeletronica;
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

    public Character getFlagnfcomplementar() {
        return flagnfcomplementar;
    }

    public void setFlagnfcomplementar(Character flagnfcomplementar) {
        this.flagnfcomplementar = flagnfcomplementar;
    }

    public String getCoddocumentoreferenciado() {
        return coddocumentoreferenciado;
    }

    public void setCoddocumentoreferenciado(String coddocumentoreferenciado) {
        this.coddocumentoreferenciado = coddocumentoreferenciado;
    }

    public String getChaveacessonfereferenciada() {
        return chaveacessonfereferenciada;
    }

    public void setChaveacessonfereferenciada(String chaveacessonfereferenciada) {
        this.chaveacessonfereferenciada = chaveacessonfereferenciada;
    }

    public String getCodtransredespacho() {
        return codtransredespacho;
    }

    public void setCodtransredespacho(String codtransredespacho) {
        this.codtransredespacho = codtransredespacho;
    }

    public Character getFlagimpressao() {
        return flagimpressao;
    }

    public void setFlagimpressao(Character flagimpressao) {
        this.flagimpressao = flagimpressao;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
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

    public String getEmitnumerologradouro() {
        return emitnumerologradouro;
    }

    public void setEmitnumerologradouro(String emitnumerologradouro) {
        this.emitnumerologradouro = emitnumerologradouro;
    }

    public String getDestnumerologradouro() {
        return destnumerologradouro;
    }

    public void setDestnumerologradouro(String destnumerologradouro) {
        this.destnumerologradouro = destnumerologradouro;
    }

    public String getEmitinscricaomunicipal() {
        return emitinscricaomunicipal;
    }

    public void setEmitinscricaomunicipal(String emitinscricaomunicipal) {
        this.emitinscricaomunicipal = emitinscricaomunicipal;
    }

    public String getModelodocumento() {
        return modelodocumento;
    }

    public void setModelodocumento(String modelodocumento) {
        this.modelodocumento = modelodocumento;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }

    public BigDecimal getValorfatura1() {
        return valorfatura1;
    }

    public void setValorfatura1(BigDecimal valorfatura1) {
        this.valorfatura1 = valorfatura1;
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

    public String getCodcrfatura1() {
        return codcrfatura1;
    }

    public void setCodcrfatura1(String codcrfatura1) {
        this.codcrfatura1 = codcrfatura1;
    }

    public BigDecimal getValorfatura2() {
        return valorfatura2;
    }

    public void setValorfatura2(BigDecimal valorfatura2) {
        this.valorfatura2 = valorfatura2;
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

    public String getCodcrfatura2() {
        return codcrfatura2;
    }

    public void setCodcrfatura2(String codcrfatura2) {
        this.codcrfatura2 = codcrfatura2;
    }

    public BigDecimal getValorfatura3() {
        return valorfatura3;
    }

    public void setValorfatura3(BigDecimal valorfatura3) {
        this.valorfatura3 = valorfatura3;
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

    public String getCodcrfatura3() {
        return codcrfatura3;
    }

    public void setCodcrfatura3(String codcrfatura3) {
        this.codcrfatura3 = codcrfatura3;
    }

    public BigDecimal getValorfatura4() {
        return valorfatura4;
    }

    public void setValorfatura4(BigDecimal valorfatura4) {
        this.valorfatura4 = valorfatura4;
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

    public String getCodcrfatura4() {
        return codcrfatura4;
    }

    public void setCodcrfatura4(String codcrfatura4) {
        this.codcrfatura4 = codcrfatura4;
    }

    public BigDecimal getValorfatura5() {
        return valorfatura5;
    }

    public void setValorfatura5(BigDecimal valorfatura5) {
        this.valorfatura5 = valorfatura5;
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

    public String getCodcrfatura5() {
        return codcrfatura5;
    }

    public void setCodcrfatura5(String codcrfatura5) {
        this.codcrfatura5 = codcrfatura5;
    }

    public BigDecimal getValorfatura6() {
        return valorfatura6;
    }

    public void setValorfatura6(BigDecimal valorfatura6) {
        this.valorfatura6 = valorfatura6;
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

    public String getCodcrfatura6() {
        return codcrfatura6;
    }

    public void setCodcrfatura6(String codcrfatura6) {
        this.codcrfatura6 = codcrfatura6;
    }

    public BigDecimal getValorfatura7() {
        return valorfatura7;
    }

    public void setValorfatura7(BigDecimal valorfatura7) {
        this.valorfatura7 = valorfatura7;
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

    public String getCodcrfatura7() {
        return codcrfatura7;
    }

    public void setCodcrfatura7(String codcrfatura7) {
        this.codcrfatura7 = codcrfatura7;
    }

    public BigDecimal getValorfatura8() {
        return valorfatura8;
    }

    public void setValorfatura8(BigDecimal valorfatura8) {
        this.valorfatura8 = valorfatura8;
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

    public String getCodcrfatura8() {
        return codcrfatura8;
    }

    public void setCodcrfatura8(String codcrfatura8) {
        this.codcrfatura8 = codcrfatura8;
    }

    public BigDecimal getValorfatura9() {
        return valorfatura9;
    }

    public void setValorfatura9(BigDecimal valorfatura9) {
        this.valorfatura9 = valorfatura9;
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

    public String getCodcrfatura9() {
        return codcrfatura9;
    }

    public void setCodcrfatura9(String codcrfatura9) {
        this.codcrfatura9 = codcrfatura9;
    }

    public BigDecimal getValorfatura10() {
        return valorfatura10;
    }

    public void setValorfatura10(BigDecimal valorfatura10) {
        this.valorfatura10 = valorfatura10;
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

    public String getCodcrfatura10() {
        return codcrfatura10;
    }

    public void setCodcrfatura10(String codcrfatura10) {
        this.codcrfatura10 = codcrfatura10;
    }

    public BigDecimal getValorfatura11() {
        return valorfatura11;
    }

    public void setValorfatura11(BigDecimal valorfatura11) {
        this.valorfatura11 = valorfatura11;
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

    public String getCodcrfatura11() {
        return codcrfatura11;
    }

    public void setCodcrfatura11(String codcrfatura11) {
        this.codcrfatura11 = codcrfatura11;
    }

    public BigDecimal getValorfatura12() {
        return valorfatura12;
    }

    public void setValorfatura12(BigDecimal valorfatura12) {
        this.valorfatura12 = valorfatura12;
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

    public String getCodcrfatura12() {
        return codcrfatura12;
    }

    public void setCodcrfatura12(String codcrfatura12) {
        this.codcrfatura12 = codcrfatura12;
    }

    public BigDecimal getValorfatura13() {
        return valorfatura13;
    }

    public void setValorfatura13(BigDecimal valorfatura13) {
        this.valorfatura13 = valorfatura13;
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

    public String getCodcrfatura13() {
        return codcrfatura13;
    }

    public void setCodcrfatura13(String codcrfatura13) {
        this.codcrfatura13 = codcrfatura13;
    }

    public BigDecimal getValorfatura14() {
        return valorfatura14;
    }

    public void setValorfatura14(BigDecimal valorfatura14) {
        this.valorfatura14 = valorfatura14;
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

    public String getCodcrfatura14() {
        return codcrfatura14;
    }

    public void setCodcrfatura14(String codcrfatura14) {
        this.codcrfatura14 = codcrfatura14;
    }

    public BigDecimal getValorfatura15() {
        return valorfatura15;
    }

    public void setValorfatura15(BigDecimal valorfatura15) {
        this.valorfatura15 = valorfatura15;
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

    public String getCodcrfatura15() {
        return codcrfatura15;
    }

    public void setCodcrfatura15(String codcrfatura15) {
        this.codcrfatura15 = codcrfatura15;
    }

    public BigDecimal getValorfatura16() {
        return valorfatura16;
    }

    public void setValorfatura16(BigDecimal valorfatura16) {
        this.valorfatura16 = valorfatura16;
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

    public String getCodcrfatura16() {
        return codcrfatura16;
    }

    public void setCodcrfatura16(String codcrfatura16) {
        this.codcrfatura16 = codcrfatura16;
    }

    public BigDecimal getValorfatura17() {
        return valorfatura17;
    }

    public void setValorfatura17(BigDecimal valorfatura17) {
        this.valorfatura17 = valorfatura17;
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

    public String getCodcrfatura17() {
        return codcrfatura17;
    }

    public void setCodcrfatura17(String codcrfatura17) {
        this.codcrfatura17 = codcrfatura17;
    }

    public BigDecimal getValorfatura18() {
        return valorfatura18;
    }

    public void setValorfatura18(BigDecimal valorfatura18) {
        this.valorfatura18 = valorfatura18;
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

    public String getCodcrfatura18() {
        return codcrfatura18;
    }

    public void setCodcrfatura18(String codcrfatura18) {
        this.codcrfatura18 = codcrfatura18;
    }

    public BigDecimal getValorfatura19() {
        return valorfatura19;
    }

    public void setValorfatura19(BigDecimal valorfatura19) {
        this.valorfatura19 = valorfatura19;
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

    public String getCodcrfatura19() {
        return codcrfatura19;
    }

    public void setCodcrfatura19(String codcrfatura19) {
        this.codcrfatura19 = codcrfatura19;
    }

    public BigDecimal getValorfatura20() {
        return valorfatura20;
    }

    public void setValorfatura20(BigDecimal valorfatura20) {
        this.valorfatura20 = valorfatura20;
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

    public String getCodcrfatura20() {
        return codcrfatura20;
    }

    public void setCodcrfatura20(String codcrfatura20) {
        this.codcrfatura20 = codcrfatura20;
    }

    public BigDecimal getValorfatura21() {
        return valorfatura21;
    }

    public void setValorfatura21(BigDecimal valorfatura21) {
        this.valorfatura21 = valorfatura21;
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

    public String getCodcrfatura21() {
        return codcrfatura21;
    }

    public void setCodcrfatura21(String codcrfatura21) {
        this.codcrfatura21 = codcrfatura21;
    }

    public BigDecimal getValorfatura22() {
        return valorfatura22;
    }

    public void setValorfatura22(BigDecimal valorfatura22) {
        this.valorfatura22 = valorfatura22;
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

    public String getCodcrfatura22() {
        return codcrfatura22;
    }

    public void setCodcrfatura22(String codcrfatura22) {
        this.codcrfatura22 = codcrfatura22;
    }

    public BigDecimal getValorfatura23() {
        return valorfatura23;
    }

    public void setValorfatura23(BigDecimal valorfatura23) {
        this.valorfatura23 = valorfatura23;
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

    public String getCodcrfatura23() {
        return codcrfatura23;
    }

    public void setCodcrfatura23(String codcrfatura23) {
        this.codcrfatura23 = codcrfatura23;
    }

    public BigDecimal getValorfatura24() {
        return valorfatura24;
    }

    public void setValorfatura24(BigDecimal valorfatura24) {
        this.valorfatura24 = valorfatura24;
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

    public String getCodcrfatura24() {
        return codcrfatura24;
    }

    public void setCodcrfatura24(String codcrfatura24) {
        this.codcrfatura24 = codcrfatura24;
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

    public String getDestsuframa() {
        return destsuframa;
    }

    public void setDestsuframa(String destsuframa) {
        this.destsuframa = destsuframa;
    }

    public String getDestcnpjcpf() {
        return destcnpjcpf;
    }

    public void setDestcnpjcpf(String destcnpjcpf) {
        this.destcnpjcpf = destcnpjcpf;
    }

    public Character getDesttipopessoa() {
        return desttipopessoa;
    }

    public void setDesttipopessoa(Character desttipopessoa) {
        this.desttipopessoa = desttipopessoa;
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

    public String getEmitcnpjcpf() {
        return emitcnpjcpf;
    }

    public void setEmitcnpjcpf(String emitcnpjcpf) {
        this.emitcnpjcpf = emitcnpjcpf;
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

    public String getTranspinscr() {
        return transpinscr;
    }

    public void setTranspinscr(String transpinscr) {
        this.transpinscr = transpinscr;
    }

    public String getTranspcnpj() {
        return transpcnpj;
    }

    public void setTranspcnpj(String transpcnpj) {
        this.transpcnpj = transpcnpj;
    }

    public String getTranspantt() {
        return transpantt;
    }

    public void setTranspantt(String transpantt) {
        this.transpantt = transpantt;
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

    public String getEntregareferencia() {
        return entregareferencia;
    }

    public void setEntregareferencia(String entregareferencia) {
        this.entregareferencia = entregareferencia;
    }

    public String getEntregatelefone() {
        return entregatelefone;
    }

    public void setEntregatelefone(String entregatelefone) {
        this.entregatelefone = entregatelefone;
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

    public BigDecimal getValoriss() {
        return valoriss;
    }

    public void setValoriss(BigDecimal valoriss) {
        this.valoriss = valoriss;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getCampostr2() {
        return campostr2;
    }

    public void setCampostr2(String campostr2) {
        this.campostr2 = campostr2;
    }

    public Integer getNumerocupomfiscal() {
        return numerocupomfiscal;
    }

    public void setNumerocupomfiscal(Integer numerocupomfiscal) {
        this.numerocupomfiscal = numerocupomfiscal;
    }

    public String getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(String numeropedido) {
        this.numeropedido = numeropedido;
    }

    public String getDadosadicionais() {
        return dadosadicionais;
    }

    public void setDadosadicionais(String dadosadicionais) {
        this.dadosadicionais = dadosadicionais;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getObservacaonotafiscal() {
        return observacaonotafiscal;
    }

    public void setObservacaonotafiscal(String observacaonotafiscal) {
        this.observacaonotafiscal = observacaonotafiscal;
    }

    public Date getDatainclusao() {
        return datainclusao;
    }

    public void setDatainclusao(Date datainclusao) {
        this.datainclusao = datainclusao;
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

    public String getNaturezaoperacao() {
        return naturezaoperacao;
    }

    public void setNaturezaoperacao(String naturezaoperacao) {
        this.naturezaoperacao = naturezaoperacao;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public String getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(String codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public BigDecimal getValorqpis() {
        return valorqpis;
    }

    public void setValorqpis(BigDecimal valorqpis) {
        this.valorqpis = valorqpis;
    }

    public BigDecimal getValorcofins() {
        return valorcofins;
    }

    public void setValorcofins(BigDecimal valorcofins) {
        this.valorcofins = valorcofins;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
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

    public Character getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(Character tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public Character getFlagcrt() {
        return flagcrt;
    }

    public void setFlagcrt(Character flagcrt) {
        this.flagcrt = flagcrt;
    }

    public BigDecimal getBaseiss() {
        return baseiss;
    }

    public void setBaseiss(BigDecimal baseiss) {
        this.baseiss = baseiss;
    }

    public Integer getSubserie() {
        return subserie;
    }

    public void setSubserie(Integer subserie) {
        this.subserie = subserie;
    }

    public BigDecimal getValortotalii() {
        return valortotalii;
    }

    public void setValortotalii(BigDecimal valortotalii) {
        this.valortotalii = valortotalii;
    }

    public String getDestemail() {
        return destemail;
    }

    public void setDestemail(String destemail) {
        this.destemail = destemail;
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

    public Character getFlagnfajuste() {
        return flagnfajuste;
    }

    public void setFlagnfajuste(Character flagnfajuste) {
        this.flagnfajuste = flagnfajuste;
    }

    public String getCodclifidelizacao() {
        return codclifidelizacao;
    }

    public void setCodclifidelizacao(String codclifidelizacao) {
        this.codclifidelizacao = codclifidelizacao;
    }

    public String getEmailccdanfe() {
        return emailccdanfe;
    }

    public void setEmailccdanfe(String emailccdanfe) {
        this.emailccdanfe = emailccdanfe;
    }

    public Character getFlagnfdevolucao() {
        return flagnfdevolucao;
    }

    public void setFlagnfdevolucao(Character flagnfdevolucao) {
        this.flagnfdevolucao = flagnfdevolucao;
    }

    public Character getIndpresenca() {
        return indpresenca;
    }

    public void setIndpresenca(Character indpresenca) {
        this.indpresenca = indpresenca;
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

    public String getDadosadicionaisfisco() {
        return dadosadicionaisfisco;
    }

    public void setDadosadicionaisfisco(String dadosadicionaisfisco) {
        this.dadosadicionaisfisco = dadosadicionaisfisco;
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

    public BigDecimal getValorfcppart() {
        return valorfcppart;
    }

    public void setValorfcppart(BigDecimal valorfcppart) {
        this.valorfcppart = valorfcppart;
    }

    public Character getFlagdocreferenciado() {
        return flagdocreferenciado;
    }

    public void setFlagdocreferenciado(Character flagdocreferenciado) {
        this.flagdocreferenciado = flagdocreferenciado;
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

    public Character getIdentificadordestino() {
        return identificadordestino;
    }

    public void setIdentificadordestino(Character identificadordestino) {
        this.identificadordestino = identificadordestino;
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

    public BigDecimal getAliqaprox() {
        return aliqaprox;
    }

    public void setAliqaprox(BigDecimal aliqaprox) {
        this.aliqaprox = aliqaprox;
    }

    public BigDecimal getValortroco() {
        return valortroco;
    }

    public void setValortroco(BigDecimal valortroco) {
        this.valortroco = valortroco;
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

    public BigDecimal getValortotalipidevolvido() {
        return valortotalipidevolvido;
    }

    public void setValortotalipidevolvido(BigDecimal valortotalipidevolvido) {
        this.valortotalipidevolvido = valortotalipidevolvido;
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

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    @XmlTransient
    public Collection<Documentocfesatreferenciado> getDocumentocfesatreferenciadoCollection() {
        return documentocfesatreferenciadoCollection;
    }

    public void setDocumentocfesatreferenciadoCollection(Collection<Documentocfesatreferenciado> documentocfesatreferenciadoCollection) {
        this.documentocfesatreferenciadoCollection = documentocfesatreferenciadoCollection;
    }

    @XmlTransient
    public Collection<Documentotransporte> getDocumentotransporteCollection() {
        return documentotransporteCollection;
    }

    public void setDocumentotransporteCollection(Collection<Documentotransporte> documentotransporteCollection) {
        this.documentotransporteCollection = documentotransporteCollection;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Tipomovimento getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(Tipomovimento codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    public Usuario getCoduser() {
        return coduser;
    }

    public void setCoduser(Usuario coduser) {
        this.coduser = coduser;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    public Vendedor getCodvendedext() {
        return codvendedext;
    }

    public void setCodvendedext(Vendedor codvendedext) {
        this.codvendedext = codvendedext;
    }

    @XmlTransient
    public Collection<Documentodocref> getDocumentodocrefCollection() {
        return documentodocrefCollection;
    }

    public void setDocumentodocrefCollection(Collection<Documentodocref> documentodocrefCollection) {
        this.documentodocrefCollection = documentodocrefCollection;
    }

    @XmlTransient
    public Collection<Mdfeletroniconf> getMdfeletroniconfCollection() {
        return mdfeletroniconfCollection;
    }

    public void setMdfeletroniconfCollection(Collection<Mdfeletroniconf> mdfeletroniconfCollection) {
        this.mdfeletroniconfCollection = mdfeletroniconfCollection;
    }

    @XmlTransient
    public Collection<Documentoentrega> getDocumentoentregaCollection() {
        return documentoentregaCollection;
    }

    public void setDocumentoentregaCollection(Collection<Documentoentrega> documentoentregaCollection) {
        this.documentoentregaCollection = documentoentregaCollection;
    }

    @XmlTransient
    public Collection<Documentoentidade> getDocumentoentidadeCollection() {
        return documentoentidadeCollection;
    }

    public void setDocumentoentidadeCollection(Collection<Documentoentidade> documentoentidadeCollection) {
        this.documentoentidadeCollection = documentoentidadeCollection;
    }

    @XmlTransient
    public Collection<Documentoitem> getDocumentoitemCollection() {
        return documentoitemCollection;
    }

    public void setDocumentoitemCollection(Collection<Documentoitem> documentoitemCollection) {
        this.documentoitemCollection = documentoitemCollection;
    }

    @XmlTransient
    public Collection<Documentopagamento> getDocumentopagamentoCollection() {
        return documentopagamentoCollection;
    }

    public void setDocumentopagamentoCollection(Collection<Documentopagamento> documentopagamentoCollection) {
        this.documentopagamentoCollection = documentopagamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddocumento != null ? coddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.coddocumento == null && other.coddocumento != null) || (this.coddocumento != null && !this.coddocumento.equals(other.coddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Documento[ coddocumento=" + coddocumento + " ]";
    }
    
}
