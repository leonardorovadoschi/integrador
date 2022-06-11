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
@Table(name = "TIPOMOVIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomovimento.findAll", query = "SELECT t FROM Tipomovimento t")
    , @NamedQuery(name = "Tipomovimento.findByCodtipomovimento", query = "SELECT t FROM Tipomovimento t WHERE t.codtipomovimento = :codtipomovimento")
    , @NamedQuery(name = "Tipomovimento.findByCodigo", query = "SELECT t FROM Tipomovimento t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipomovimento.findByNometipomovimento", query = "SELECT t FROM Tipomovimento t WHERE t.nometipomovimento = :nometipomovimento")
    , @NamedQuery(name = "Tipomovimento.findByFlagforncli", query = "SELECT t FROM Tipomovimento t WHERE t.flagforncli = :flagforncli")
    , @NamedQuery(name = "Tipomovimento.findByFlagimprimirnotafiscal", query = "SELECT t FROM Tipomovimento t WHERE t.flagimprimirnotafiscal = :flagimprimirnotafiscal")
    , @NamedQuery(name = "Tipomovimento.findByFlagreajustaprecovenda", query = "SELECT t FROM Tipomovimento t WHERE t.flagreajustaprecovenda = :flagreajustaprecovenda")
    , @NamedQuery(name = "Tipomovimento.findByFlaglancafinanceiro", query = "SELECT t FROM Tipomovimento t WHERE t.flaglancafinanceiro = :flaglancafinanceiro")
    , @NamedQuery(name = "Tipomovimento.findByFlagatualizacustoproduto", query = "SELECT t FROM Tipomovimento t WHERE t.flagatualizacustoproduto = :flagatualizacustoproduto")
    , @NamedQuery(name = "Tipomovimento.findByFlagatualizafornecedor", query = "SELECT t FROM Tipomovimento t WHERE t.flagatualizafornecedor = :flagatualizafornecedor")
    , @NamedQuery(name = "Tipomovimento.findByFlagatualizacustomedio", query = "SELECT t FROM Tipomovimento t WHERE t.flagatualizacustomedio = :flagatualizacustomedio")
    , @NamedQuery(name = "Tipomovimento.findByFlagatualizaestoque", query = "SELECT t FROM Tipomovimento t WHERE t.flagatualizaestoque = :flagatualizaestoque")
    , @NamedQuery(name = "Tipomovimento.findByFlagtipomovimento", query = "SELECT t FROM Tipomovimento t WHERE t.flagtipomovimento = :flagtipomovimento")
    , @NamedQuery(name = "Tipomovimento.findByFlagacerto", query = "SELECT t FROM Tipomovimento t WHERE t.flagacerto = :flagacerto")
    , @NamedQuery(name = "Tipomovimento.findByFlagconsignacao", query = "SELECT t FROM Tipomovimento t WHERE t.flagconsignacao = :flagconsignacao")
    , @NamedQuery(name = "Tipomovimento.findByFlagdevolucao", query = "SELECT t FROM Tipomovimento t WHERE t.flagdevolucao = :flagdevolucao")
    , @NamedQuery(name = "Tipomovimento.findByFlagtransferencia", query = "SELECT t FROM Tipomovimento t WHERE t.flagtransferencia = :flagtransferencia")
    , @NamedQuery(name = "Tipomovimento.findByCodcfopdentrouf", query = "SELECT t FROM Tipomovimento t WHERE t.codcfopdentrouf = :codcfopdentrouf")
    , @NamedQuery(name = "Tipomovimento.findByCodcfopforauf", query = "SELECT t FROM Tipomovimento t WHERE t.codcfopforauf = :codcfopforauf")
    , @NamedQuery(name = "Tipomovimento.findByCodcfopexterior", query = "SELECT t FROM Tipomovimento t WHERE t.codcfopexterior = :codcfopexterior")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculaipi", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculaipi = :flagcalculaipi")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculaicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculaicms = :flagcalculaicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculasubsttributaria", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculasubsttributaria = :flagcalculasubsttributaria")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculaiss", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculaiss = :flagcalculaiss")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaipibaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaipibaseicms = :flagsomaipibaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagpossuireducaobaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagpossuireducaobaseicms = :flagpossuireducaobaseicms")
    , @NamedQuery(name = "Tipomovimento.findBySomaipiantesreducaobaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.somaipiantesreducaobaseicms = :somaipiantesreducaobaseicms")
    , @NamedQuery(name = "Tipomovimento.findByCodmensagem1", query = "SELECT t FROM Tipomovimento t WHERE t.codmensagem1 = :codmensagem1")
    , @NamedQuery(name = "Tipomovimento.findByCodmensagem2", query = "SELECT t FROM Tipomovimento t WHERE t.codmensagem2 = :codmensagem2")
    , @NamedQuery(name = "Tipomovimento.findByCodmensagem3", query = "SELECT t FROM Tipomovimento t WHERE t.codmensagem3 = :codmensagem3")
    , @NamedQuery(name = "Tipomovimento.findByFlagdeduzicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagdeduzicms = :flagdeduzicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomafretebaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomafretebaseicms = :flagsomafretebaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomasegurobaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomasegurobaseicms = :flagsomasegurobaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaoutrasdespesasbaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaoutrasdespesasbaseicms = :flagsomaoutrasdespesasbaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagnfpropria", query = "SELECT t FROM Tipomovimento t WHERE t.flagnfpropria = :flagnfpropria")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculasubsttribcusto", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculasubsttribcusto = :flagcalculasubsttribcusto")
    , @NamedQuery(name = "Tipomovimento.findByFlaginativo", query = "SELECT t FROM Tipomovimento t WHERE t.flaginativo = :flaginativo")
    , @NamedQuery(name = "Tipomovimento.findByCodtipomovimentodevolucao", query = "SELECT t FROM Tipomovimento t WHERE t.codtipomovimentodevolucao = :codtipomovimentodevolucao")
    , @NamedQuery(name = "Tipomovimento.findByFlagdevolucaocompra", query = "SELECT t FROM Tipomovimento t WHERE t.flagdevolucaocompra = :flagdevolucaocompra")
    , @NamedQuery(name = "Tipomovimento.findByAliqicmsfixa", query = "SELECT t FROM Tipomovimento t WHERE t.aliqicmsfixa = :aliqicmsfixa")
    , @NamedQuery(name = "Tipomovimento.findByFlagprioridadecfop", query = "SELECT t FROM Tipomovimento t WHERE t.flagprioridadecfop = :flagprioridadecfop")
    , @NamedQuery(name = "Tipomovimento.findByFlagcupomfiscalconjugado", query = "SELECT t FROM Tipomovimento t WHERE t.flagcupomfiscalconjugado = :flagcupomfiscalconjugado")
    , @NamedQuery(name = "Tipomovimento.findByFlagpis", query = "SELECT t FROM Tipomovimento t WHERE t.flagpis = :flagpis")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomafretebasesubsttrib", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomafretebasesubsttrib = :flagsomafretebasesubsttrib")
    , @NamedQuery(name = "Tipomovimento.findByFlagcofins", query = "SELECT t FROM Tipomovimento t WHERE t.flagcofins = :flagcofins")
    , @NamedQuery(name = "Tipomovimento.findByFlagdeduzipi", query = "SELECT t FROM Tipomovimento t WHERE t.flagdeduzipi = :flagdeduzipi")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculapis", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculapis = :flagcalculapis")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaipibasepis", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaipibasepis = :flagsomaipibasepis")
    , @NamedQuery(name = "Tipomovimento.findByAliqpis", query = "SELECT t FROM Tipomovimento t WHERE t.aliqpis = :aliqpis")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculacofins", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculacofins = :flagcalculacofins")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaipibasecofins", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaipibasecofins = :flagsomaipibasecofins")
    , @NamedQuery(name = "Tipomovimento.findByAliqcofins", query = "SELECT t FROM Tipomovimento t WHERE t.aliqcofins = :aliqcofins")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculairrf", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculairrf = :flagcalculairrf")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculaii", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculaii = :flagcalculaii")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomadespacessbaseii", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomadespacessbaseii = :flagsomadespacessbaseii")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomacofinsbaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomacofinsbaseicms = :flagsomacofinsbaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomapisbaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomapisbaseicms = :flagsomapisbaseicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaiibaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaiibaseicms = :flagsomaiibaseicms")
    , @NamedQuery(name = "Tipomovimento.findByAliqirrf", query = "SELECT t FROM Tipomovimento t WHERE t.aliqirrf = :aliqirrf")
    , @NamedQuery(name = "Tipomovimento.findByValorminimodarf", query = "SELECT t FROM Tipomovimento t WHERE t.valorminimodarf = :valorminimodarf")
    , @NamedQuery(name = "Tipomovimento.findByAliqcsll", query = "SELECT t FROM Tipomovimento t WHERE t.aliqcsll = :aliqcsll")
    , @NamedQuery(name = "Tipomovimento.findByFlagimportacao", query = "SELECT t FROM Tipomovimento t WHERE t.flagimportacao = :flagimportacao")
    , @NamedQuery(name = "Tipomovimento.findByFlagvendaconsumidorfinal", query = "SELECT t FROM Tipomovimento t WHERE t.flagvendaconsumidorfinal = :flagvendaconsumidorfinal")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaipibasesubsttributaria", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaipibasesubsttributaria = :flagsomaipibasesubsttributaria")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaicms = :flagsomaicms")
    , @NamedQuery(name = "Tipomovimento.findByFlagabatedescontosbaseipi", query = "SELECT t FROM Tipomovimento t WHERE t.flagabatedescontosbaseipi = :flagabatedescontosbaseipi")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomadespacessbaseipi", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomadespacessbaseipi = :flagsomadespacessbaseipi")
    , @NamedQuery(name = "Tipomovimento.findByFlagescrituracaoipi", query = "SELECT t FROM Tipomovimento t WHERE t.flagescrituracaoipi = :flagescrituracaoipi")
    , @NamedQuery(name = "Tipomovimento.findByFlagescrituracaoicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagescrituracaoicms = :flagescrituracaoicms")
    , @NamedQuery(name = "Tipomovimento.findByCstpis", query = "SELECT t FROM Tipomovimento t WHERE t.cstpis = :cstpis")
    , @NamedQuery(name = "Tipomovimento.findByCstcofins", query = "SELECT t FROM Tipomovimento t WHERE t.cstcofins = :cstcofins")
    , @NamedQuery(name = "Tipomovimento.findByNaturezaoperacao", query = "SELECT t FROM Tipomovimento t WHERE t.naturezaoperacao = :naturezaoperacao")
    , @NamedQuery(name = "Tipomovimento.findByFlagusaaliqdiferenciada", query = "SELECT t FROM Tipomovimento t WHERE t.flagusaaliqdiferenciada = :flagusaaliqdiferenciada")
    , @NamedQuery(name = "Tipomovimento.findByFlagiss", query = "SELECT t FROM Tipomovimento t WHERE t.flagiss = :flagiss")
    , @NamedQuery(name = "Tipomovimento.findByCodtipomovimentoentregafutura", query = "SELECT t FROM Tipomovimento t WHERE t.codtipomovimentoentregafutura = :codtipomovimentoentregafutura")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomaoutrasdespesassubsttrib", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomaoutrasdespesassubsttrib = :flagsomaoutrasdespesassubsttrib")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomasegurosubsttrib", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomasegurosubsttrib = :flagsomasegurosubsttrib")
    , @NamedQuery(name = "Tipomovimento.findByFlagnaoabatedescontosubsttrib", query = "SELECT t FROM Tipomovimento t WHERE t.flagnaoabatedescontosubsttrib = :flagnaoabatedescontosubsttrib")
    , @NamedQuery(name = "Tipomovimento.findByFlagnaoabatedescontobaseicms", query = "SELECT t FROM Tipomovimento t WHERE t.flagnaoabatedescontobaseicms = :flagnaoabatedescontobaseicms")
    , @NamedQuery(name = "Tipomovimento.findByCasasdecimais", query = "SELECT t FROM Tipomovimento t WHERE t.casasdecimais = :casasdecimais")
    , @NamedQuery(name = "Tipomovimento.findByFlagsomafrete", query = "SELECT t FROM Tipomovimento t WHERE t.flagsomafrete = :flagsomafrete")
    , @NamedQuery(name = "Tipomovimento.findByFlagprecosaida", query = "SELECT t FROM Tipomovimento t WHERE t.flagprecosaida = :flagprecosaida")
    , @NamedQuery(name = "Tipomovimento.findByFlagentregafutura", query = "SELECT t FROM Tipomovimento t WHERE t.flagentregafutura = :flagentregafutura")
    , @NamedQuery(name = "Tipomovimento.findByFlagdeduzissreceb", query = "SELECT t FROM Tipomovimento t WHERE t.flagdeduzissreceb = :flagdeduzissreceb")
    , @NamedQuery(name = "Tipomovimento.findByComissao", query = "SELECT t FROM Tipomovimento t WHERE t.comissao = :comissao")
    , @NamedQuery(name = "Tipomovimento.findByFlagedicao", query = "SELECT t FROM Tipomovimento t WHERE t.flagedicao = :flagedicao")
    , @NamedQuery(name = "Tipomovimento.findByFlagexibirmensagemaprovcred", query = "SELECT t FROM Tipomovimento t WHERE t.flagexibirmensagemaprovcred = :flagexibirmensagemaprovcred")
    , @NamedQuery(name = "Tipomovimento.findByFlagexibirmensagemolhoimposto", query = "SELECT t FROM Tipomovimento t WHERE t.flagexibirmensagemolhoimposto = :flagexibirmensagemolhoimposto")
    , @NamedQuery(name = "Tipomovimento.findByFlagnaocalcularmva", query = "SELECT t FROM Tipomovimento t WHERE t.flagnaocalcularmva = :flagnaocalcularmva")
    , @NamedQuery(name = "Tipomovimento.findByDiassaidanfe", query = "SELECT t FROM Tipomovimento t WHERE t.diassaidanfe = :diassaidanfe")
    , @NamedQuery(name = "Tipomovimento.findByFlagbloqueargeracaonfe", query = "SELECT t FROM Tipomovimento t WHERE t.flagbloqueargeracaonfe = :flagbloqueargeracaonfe")
    , @NamedQuery(name = "Tipomovimento.findByFlagpresenca", query = "SELECT t FROM Tipomovimento t WHERE t.flagpresenca = :flagpresenca")
    , @NamedQuery(name = "Tipomovimento.findByFlagconsumidorfinal", query = "SELECT t FROM Tipomovimento t WHERE t.flagconsumidorfinal = :flagconsumidorfinal")
    , @NamedQuery(name = "Tipomovimento.findByFlagoperacaowms", query = "SELECT t FROM Tipomovimento t WHERE t.flagoperacaowms = :flagoperacaowms")
    , @NamedQuery(name = "Tipomovimento.findByFlagdocreferenciado", query = "SELECT t FROM Tipomovimento t WHERE t.flagdocreferenciado = :flagdocreferenciado")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculacsll", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculacsll = :flagcalculacsll")
    , @NamedQuery(name = "Tipomovimento.findByFlagdelivery", query = "SELECT t FROM Tipomovimento t WHERE t.flagdelivery = :flagdelivery")
    , @NamedQuery(name = "Tipomovimento.findByAliqfcpfixa", query = "SELECT t FROM Tipomovimento t WHERE t.aliqfcpfixa = :aliqfcpfixa")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculainss", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculainss = :flagcalculainss")
    , @NamedQuery(name = "Tipomovimento.findByAliqinss", query = "SELECT t FROM Tipomovimento t WHERE t.aliqinss = :aliqinss")
    , @NamedQuery(name = "Tipomovimento.findByFlagcalculaicmsefetivo", query = "SELECT t FROM Tipomovimento t WHERE t.flagcalculaicmsefetivo = :flagcalculaicmsefetivo")
    , @NamedQuery(name = "Tipomovimento.findByTipooperacaowms", query = "SELECT t FROM Tipomovimento t WHERE t.tipooperacaowms = :tipooperacaowms")
    , @NamedQuery(name = "Tipomovimento.findByFlagdeduzicmsdesonerado", query = "SELECT t FROM Tipomovimento t WHERE t.flagdeduzicmsdesonerado = :flagdeduzicmsdesonerado")
    , @NamedQuery(name = "Tipomovimento.findByCstipi", query = "SELECT t FROM Tipomovimento t WHERE t.cstipi = :cstipi")
    , @NamedQuery(name = "Tipomovimento.findByGuid", query = "SELECT t FROM Tipomovimento t WHERE t.guid = :guid")})
public class Tipomovimento implements Serializable {

    @Column(name = "FLAGCALCULAIPIDEVOLVIDO")
    private Character flagcalculaipidevolvido;
    @JoinColumn(name = "CODINTERMEDIADOR", referencedColumnName = "CODINTERMEDIADOR")
    @ManyToOne
    private Intermediador codintermediador;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOMOVIMENTO")
    private String codtipomovimento;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOMOVIMENTO")
    private String nometipomovimento;
    @Column(name = "FLAGFORNCLI")
    private Character flagforncli;
    @Column(name = "FLAGIMPRIMIRNOTAFISCAL")
    private Character flagimprimirnotafiscal;
    @Column(name = "FLAGREAJUSTAPRECOVENDA")
    private Character flagreajustaprecovenda;
    @Column(name = "FLAGLANCAFINANCEIRO")
    private Character flaglancafinanceiro;
    @Column(name = "FLAGATUALIZACUSTOPRODUTO")
    private Character flagatualizacustoproduto;
    @Column(name = "FLAGATUALIZAFORNECEDOR")
    private Character flagatualizafornecedor;
    @Column(name = "FLAGATUALIZACUSTOMEDIO")
    private Character flagatualizacustomedio;
    @Column(name = "FLAGATUALIZAESTOQUE")
    private Character flagatualizaestoque;
    @Column(name = "FLAGTIPOMOVIMENTO")
    private Character flagtipomovimento;
    @Column(name = "FLAGACERTO")
    private Character flagacerto;
    @Column(name = "FLAGCONSIGNACAO")
    private Character flagconsignacao;
    @Column(name = "FLAGDEVOLUCAO")
    private Character flagdevolucao;
    @Column(name = "FLAGTRANSFERENCIA")
    private Character flagtransferencia;
    @Column(name = "CODCFOPDENTROUF")
    private String codcfopdentrouf;
    @Column(name = "CODCFOPFORAUF")
    private String codcfopforauf;
    @Column(name = "CODCFOPEXTERIOR")
    private String codcfopexterior;
    @Column(name = "FLAGCALCULAIPI")
    private Character flagcalculaipi;
    @Column(name = "FLAGCALCULAICMS")
    private Character flagcalculaicms;
    @Column(name = "FLAGCALCULASUBSTTRIBUTARIA")
    private Character flagcalculasubsttributaria;
    @Column(name = "FLAGCALCULAISS")
    private Character flagcalculaiss;
    @Column(name = "FLAGSOMAIPIBASEICMS")
    private Character flagsomaipibaseicms;
    @Column(name = "FLAGPOSSUIREDUCAOBASEICMS")
    private Character flagpossuireducaobaseicms;
    @Column(name = "SOMAIPIANTESREDUCAOBASEICMS")
    private Character somaipiantesreducaobaseicms;
    @Column(name = "CODMENSAGEM1")
    private String codmensagem1;
    @Column(name = "CODMENSAGEM2")
    private String codmensagem2;
    @Column(name = "CODMENSAGEM3")
    private String codmensagem3;
    @Column(name = "FLAGDEDUZICMS")
    private Character flagdeduzicms;
    @Column(name = "FLAGSOMAFRETEBASEICMS")
    private Character flagsomafretebaseicms;
    @Column(name = "FLAGSOMASEGUROBASEICMS")
    private Character flagsomasegurobaseicms;
    @Column(name = "FLAGSOMAOUTRASDESPESASBASEICMS")
    private Character flagsomaoutrasdespesasbaseicms;
    @Column(name = "FLAGNFPROPRIA")
    private Character flagnfpropria;
    @Column(name = "FLAGCALCULASUBSTTRIBCUSTO")
    private Character flagcalculasubsttribcusto;
    @Column(name = "FLAGINATIVO")
    private Character flaginativo;
    @Column(name = "CODTIPOMOVIMENTODEVOLUCAO")
    private String codtipomovimentodevolucao;
    @Column(name = "FLAGDEVOLUCAOCOMPRA")
    private Character flagdevolucaocompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQICMSFIXA")
    private BigDecimal aliqicmsfixa;
    @Column(name = "FLAGPRIORIDADECFOP")
    private Character flagprioridadecfop;
    @Column(name = "FLAGCUPOMFISCALCONJUGADO")
    private Character flagcupomfiscalconjugado;
    @Column(name = "FLAGPIS")
    private Character flagpis;
    @Column(name = "FLAGSOMAFRETEBASESUBSTTRIB")
    private Character flagsomafretebasesubsttrib;
    @Column(name = "FLAGCOFINS")
    private Character flagcofins;
    @Column(name = "FLAGDEDUZIPI")
    private Character flagdeduzipi;
    @Column(name = "FLAGCALCULAPIS")
    private Character flagcalculapis;
    @Column(name = "FLAGSOMAIPIBASEPIS")
    private Character flagsomaipibasepis;
    @Column(name = "ALIQPIS")
    private BigDecimal aliqpis;
    @Column(name = "FLAGCALCULACOFINS")
    private Character flagcalculacofins;
    @Column(name = "FLAGSOMAIPIBASECOFINS")
    private Character flagsomaipibasecofins;
    @Column(name = "ALIQCOFINS")
    private BigDecimal aliqcofins;
    @Column(name = "FLAGCALCULAIRRF")
    private Character flagcalculairrf;
    @Column(name = "FLAGCALCULAII")
    private Character flagcalculaii;
    @Column(name = "FLAGSOMADESPACESSBASEII")
    private Character flagsomadespacessbaseii;
    @Column(name = "FLAGSOMACOFINSBASEICMS")
    private Character flagsomacofinsbaseicms;
    @Column(name = "FLAGSOMAPISBASEICMS")
    private Character flagsomapisbaseicms;
    @Column(name = "FLAGSOMAIIBASEICMS")
    private Character flagsomaiibaseicms;
    @Column(name = "ALIQIRRF")
    private BigDecimal aliqirrf;
    @Column(name = "VALORMINIMODARF")
    private BigDecimal valorminimodarf;
    @Column(name = "ALIQCSLL")
    private BigDecimal aliqcsll;
    @Column(name = "FLAGIMPORTACAO")
    private Character flagimportacao;
    @Column(name = "FLAGVENDACONSUMIDORFINAL")
    private Character flagvendaconsumidorfinal;
    @Column(name = "FLAGSOMAIPIBASESUBSTTRIBUTARIA")
    private Character flagsomaipibasesubsttributaria;
    @Column(name = "FLAGSOMAICMS")
    private Character flagsomaicms;
    @Column(name = "FLAGABATEDESCONTOSBASEIPI")
    private Character flagabatedescontosbaseipi;
    @Column(name = "FLAGSOMADESPACESSBASEIPI")
    private Character flagsomadespacessbaseipi;
    @Column(name = "FLAGESCRITURACAOIPI")
    private Character flagescrituracaoipi;
    @Column(name = "FLAGESCRITURACAOICMS")
    private Character flagescrituracaoicms;
    @Column(name = "CSTPIS")
    private String cstpis;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "NATUREZAOPERACAO")
    private String naturezaoperacao;
    @Column(name = "FLAGUSAALIQDIFERENCIADA")
    private Character flagusaaliqdiferenciada;
    @Column(name = "FLAGISS")
    private Character flagiss;
    @Column(name = "CODTIPOMOVIMENTOENTREGAFUTURA")
    private String codtipomovimentoentregafutura;
    @Column(name = "FLAGSOMAOUTRASDESPESASSUBSTTRIB")
    private Character flagsomaoutrasdespesassubsttrib;
    @Column(name = "FLAGSOMASEGUROSUBSTTRIB")
    private Character flagsomasegurosubsttrib;
    @Column(name = "FLAGNAOABATEDESCONTOSUBSTTRIB")
    private Character flagnaoabatedescontosubsttrib;
    @Column(name = "FLAGNAOABATEDESCONTOBASEICMS")
    private Character flagnaoabatedescontobaseicms;
    @Column(name = "CASASDECIMAIS")
    private Integer casasdecimais;
    @Column(name = "FLAGSOMAFRETE")
    private Character flagsomafrete;
    @Column(name = "FLAGPRECOSAIDA")
    private Character flagprecosaida;
    @Column(name = "FLAGENTREGAFUTURA")
    private Character flagentregafutura;
    @Column(name = "FLAGDEDUZISSRECEB")
    private Character flagdeduzissreceb;
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "FLAGEDICAO")
    private Character flagedicao;
    @Column(name = "FLAGEXIBIRMENSAGEMAPROVCRED")
    private Character flagexibirmensagemaprovcred;
    @Column(name = "FLAGEXIBIRMENSAGEMOLHOIMPOSTO")
    private Character flagexibirmensagemolhoimposto;
    @Column(name = "FLAGNAOCALCULARMVA")
    private Character flagnaocalcularmva;
    @Column(name = "DIASSAIDANFE")
    private Short diassaidanfe;
    @Column(name = "FLAGBLOQUEARGERACAONFE")
    private Character flagbloqueargeracaonfe;
    @Column(name = "FLAGPRESENCA")
    private Character flagpresenca;
    @Column(name = "FLAGCONSUMIDORFINAL")
    private Character flagconsumidorfinal;
    @Column(name = "FLAGOPERACAOWMS")
    private Character flagoperacaowms;
    @Column(name = "FLAGDOCREFERENCIADO")
    private Character flagdocreferenciado;
    @Column(name = "FLAGCALCULACSLL")
    private Character flagcalculacsll;
    @Column(name = "FLAGDELIVERY")
    private Character flagdelivery;
    @Column(name = "ALIQFCPFIXA")
    private BigDecimal aliqfcpfixa;
    @Column(name = "FLAGCALCULAINSS")
    private Character flagcalculainss;
    @Column(name = "ALIQINSS")
    private BigDecimal aliqinss;
    @Column(name = "FLAGCALCULAICMSEFETIVO")
    private Character flagcalculaicmsefetivo;
    @Column(name = "TIPOOPERACAOWMS")
    private String tipooperacaowms;
    @Column(name = "FLAGDEDUZICMSDESONERADO")
    private Character flagdeduzicmsdesonerado;
    @Column(name = "CSTIPI")
    private String cstipi;
    @Column(name = "GUID")
    private String guid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipomovimento")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(mappedBy = "codtipomovimento")
    private Collection<Documento> documentoCollection;
    @OneToMany(mappedBy = "codtipomovimento")
    private Collection<Regracfopitem> regracfopitemCollection;
    @OneToMany(mappedBy = "codtipomovimento")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipomovimento")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codtipomovimento")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codtipomovimento")
    private Collection<Planocontacfop> planocontacfopCollection;

    public Tipomovimento() {
    }

    public Tipomovimento(String codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public Tipomovimento(String codtipomovimento, String codigo) {
        this.codtipomovimento = codtipomovimento;
        this.codigo = codigo;
    }

    public String getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(String codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipomovimento() {
        return nometipomovimento;
    }

    public void setNometipomovimento(String nometipomovimento) {
        this.nometipomovimento = nometipomovimento;
    }

    public Character getFlagforncli() {
        return flagforncli;
    }

    public void setFlagforncli(Character flagforncli) {
        this.flagforncli = flagforncli;
    }

    public Character getFlagimprimirnotafiscal() {
        return flagimprimirnotafiscal;
    }

    public void setFlagimprimirnotafiscal(Character flagimprimirnotafiscal) {
        this.flagimprimirnotafiscal = flagimprimirnotafiscal;
    }

    public Character getFlagreajustaprecovenda() {
        return flagreajustaprecovenda;
    }

    public void setFlagreajustaprecovenda(Character flagreajustaprecovenda) {
        this.flagreajustaprecovenda = flagreajustaprecovenda;
    }

    public Character getFlaglancafinanceiro() {
        return flaglancafinanceiro;
    }

    public void setFlaglancafinanceiro(Character flaglancafinanceiro) {
        this.flaglancafinanceiro = flaglancafinanceiro;
    }

    public Character getFlagatualizacustoproduto() {
        return flagatualizacustoproduto;
    }

    public void setFlagatualizacustoproduto(Character flagatualizacustoproduto) {
        this.flagatualizacustoproduto = flagatualizacustoproduto;
    }

    public Character getFlagatualizafornecedor() {
        return flagatualizafornecedor;
    }

    public void setFlagatualizafornecedor(Character flagatualizafornecedor) {
        this.flagatualizafornecedor = flagatualizafornecedor;
    }

    public Character getFlagatualizacustomedio() {
        return flagatualizacustomedio;
    }

    public void setFlagatualizacustomedio(Character flagatualizacustomedio) {
        this.flagatualizacustomedio = flagatualizacustomedio;
    }

    public Character getFlagatualizaestoque() {
        return flagatualizaestoque;
    }

    public void setFlagatualizaestoque(Character flagatualizaestoque) {
        this.flagatualizaestoque = flagatualizaestoque;
    }

    public Character getFlagtipomovimento() {
        return flagtipomovimento;
    }

    public void setFlagtipomovimento(Character flagtipomovimento) {
        this.flagtipomovimento = flagtipomovimento;
    }

    public Character getFlagacerto() {
        return flagacerto;
    }

    public void setFlagacerto(Character flagacerto) {
        this.flagacerto = flagacerto;
    }

    public Character getFlagconsignacao() {
        return flagconsignacao;
    }

    public void setFlagconsignacao(Character flagconsignacao) {
        this.flagconsignacao = flagconsignacao;
    }

    public Character getFlagdevolucao() {
        return flagdevolucao;
    }

    public void setFlagdevolucao(Character flagdevolucao) {
        this.flagdevolucao = flagdevolucao;
    }

    public Character getFlagtransferencia() {
        return flagtransferencia;
    }

    public void setFlagtransferencia(Character flagtransferencia) {
        this.flagtransferencia = flagtransferencia;
    }

    public String getCodcfopdentrouf() {
        return codcfopdentrouf;
    }

    public void setCodcfopdentrouf(String codcfopdentrouf) {
        this.codcfopdentrouf = codcfopdentrouf;
    }

    public String getCodcfopforauf() {
        return codcfopforauf;
    }

    public void setCodcfopforauf(String codcfopforauf) {
        this.codcfopforauf = codcfopforauf;
    }

    public String getCodcfopexterior() {
        return codcfopexterior;
    }

    public void setCodcfopexterior(String codcfopexterior) {
        this.codcfopexterior = codcfopexterior;
    }

    public Character getFlagcalculaipi() {
        return flagcalculaipi;
    }

    public void setFlagcalculaipi(Character flagcalculaipi) {
        this.flagcalculaipi = flagcalculaipi;
    }

    public Character getFlagcalculaicms() {
        return flagcalculaicms;
    }

    public void setFlagcalculaicms(Character flagcalculaicms) {
        this.flagcalculaicms = flagcalculaicms;
    }

    public Character getFlagcalculasubsttributaria() {
        return flagcalculasubsttributaria;
    }

    public void setFlagcalculasubsttributaria(Character flagcalculasubsttributaria) {
        this.flagcalculasubsttributaria = flagcalculasubsttributaria;
    }

    public Character getFlagcalculaiss() {
        return flagcalculaiss;
    }

    public void setFlagcalculaiss(Character flagcalculaiss) {
        this.flagcalculaiss = flagcalculaiss;
    }

    public Character getFlagsomaipibaseicms() {
        return flagsomaipibaseicms;
    }

    public void setFlagsomaipibaseicms(Character flagsomaipibaseicms) {
        this.flagsomaipibaseicms = flagsomaipibaseicms;
    }

    public Character getFlagpossuireducaobaseicms() {
        return flagpossuireducaobaseicms;
    }

    public void setFlagpossuireducaobaseicms(Character flagpossuireducaobaseicms) {
        this.flagpossuireducaobaseicms = flagpossuireducaobaseicms;
    }

    public Character getSomaipiantesreducaobaseicms() {
        return somaipiantesreducaobaseicms;
    }

    public void setSomaipiantesreducaobaseicms(Character somaipiantesreducaobaseicms) {
        this.somaipiantesreducaobaseicms = somaipiantesreducaobaseicms;
    }

    public String getCodmensagem1() {
        return codmensagem1;
    }

    public void setCodmensagem1(String codmensagem1) {
        this.codmensagem1 = codmensagem1;
    }

    public String getCodmensagem2() {
        return codmensagem2;
    }

    public void setCodmensagem2(String codmensagem2) {
        this.codmensagem2 = codmensagem2;
    }

    public String getCodmensagem3() {
        return codmensagem3;
    }

    public void setCodmensagem3(String codmensagem3) {
        this.codmensagem3 = codmensagem3;
    }

    public Character getFlagdeduzicms() {
        return flagdeduzicms;
    }

    public void setFlagdeduzicms(Character flagdeduzicms) {
        this.flagdeduzicms = flagdeduzicms;
    }

    public Character getFlagsomafretebaseicms() {
        return flagsomafretebaseicms;
    }

    public void setFlagsomafretebaseicms(Character flagsomafretebaseicms) {
        this.flagsomafretebaseicms = flagsomafretebaseicms;
    }

    public Character getFlagsomasegurobaseicms() {
        return flagsomasegurobaseicms;
    }

    public void setFlagsomasegurobaseicms(Character flagsomasegurobaseicms) {
        this.flagsomasegurobaseicms = flagsomasegurobaseicms;
    }

    public Character getFlagsomaoutrasdespesasbaseicms() {
        return flagsomaoutrasdespesasbaseicms;
    }

    public void setFlagsomaoutrasdespesasbaseicms(Character flagsomaoutrasdespesasbaseicms) {
        this.flagsomaoutrasdespesasbaseicms = flagsomaoutrasdespesasbaseicms;
    }

    public Character getFlagnfpropria() {
        return flagnfpropria;
    }

    public void setFlagnfpropria(Character flagnfpropria) {
        this.flagnfpropria = flagnfpropria;
    }

    public Character getFlagcalculasubsttribcusto() {
        return flagcalculasubsttribcusto;
    }

    public void setFlagcalculasubsttribcusto(Character flagcalculasubsttribcusto) {
        this.flagcalculasubsttribcusto = flagcalculasubsttribcusto;
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        this.flaginativo = flaginativo;
    }

    public String getCodtipomovimentodevolucao() {
        return codtipomovimentodevolucao;
    }

    public void setCodtipomovimentodevolucao(String codtipomovimentodevolucao) {
        this.codtipomovimentodevolucao = codtipomovimentodevolucao;
    }

    public Character getFlagdevolucaocompra() {
        return flagdevolucaocompra;
    }

    public void setFlagdevolucaocompra(Character flagdevolucaocompra) {
        this.flagdevolucaocompra = flagdevolucaocompra;
    }

    public BigDecimal getAliqicmsfixa() {
        return aliqicmsfixa;
    }

    public void setAliqicmsfixa(BigDecimal aliqicmsfixa) {
        this.aliqicmsfixa = aliqicmsfixa;
    }

    public Character getFlagprioridadecfop() {
        return flagprioridadecfop;
    }

    public void setFlagprioridadecfop(Character flagprioridadecfop) {
        this.flagprioridadecfop = flagprioridadecfop;
    }

    public Character getFlagcupomfiscalconjugado() {
        return flagcupomfiscalconjugado;
    }

    public void setFlagcupomfiscalconjugado(Character flagcupomfiscalconjugado) {
        this.flagcupomfiscalconjugado = flagcupomfiscalconjugado;
    }

    public Character getFlagpis() {
        return flagpis;
    }

    public void setFlagpis(Character flagpis) {
        this.flagpis = flagpis;
    }

    public Character getFlagsomafretebasesubsttrib() {
        return flagsomafretebasesubsttrib;
    }

    public void setFlagsomafretebasesubsttrib(Character flagsomafretebasesubsttrib) {
        this.flagsomafretebasesubsttrib = flagsomafretebasesubsttrib;
    }

    public Character getFlagcofins() {
        return flagcofins;
    }

    public void setFlagcofins(Character flagcofins) {
        this.flagcofins = flagcofins;
    }

    public Character getFlagdeduzipi() {
        return flagdeduzipi;
    }

    public void setFlagdeduzipi(Character flagdeduzipi) {
        this.flagdeduzipi = flagdeduzipi;
    }

    public Character getFlagcalculapis() {
        return flagcalculapis;
    }

    public void setFlagcalculapis(Character flagcalculapis) {
        this.flagcalculapis = flagcalculapis;
    }

    public Character getFlagsomaipibasepis() {
        return flagsomaipibasepis;
    }

    public void setFlagsomaipibasepis(Character flagsomaipibasepis) {
        this.flagsomaipibasepis = flagsomaipibasepis;
    }

    public BigDecimal getAliqpis() {
        return aliqpis;
    }

    public void setAliqpis(BigDecimal aliqpis) {
        this.aliqpis = aliqpis;
    }

    public Character getFlagcalculacofins() {
        return flagcalculacofins;
    }

    public void setFlagcalculacofins(Character flagcalculacofins) {
        this.flagcalculacofins = flagcalculacofins;
    }

    public Character getFlagsomaipibasecofins() {
        return flagsomaipibasecofins;
    }

    public void setFlagsomaipibasecofins(Character flagsomaipibasecofins) {
        this.flagsomaipibasecofins = flagsomaipibasecofins;
    }

    public BigDecimal getAliqcofins() {
        return aliqcofins;
    }

    public void setAliqcofins(BigDecimal aliqcofins) {
        this.aliqcofins = aliqcofins;
    }

    public Character getFlagcalculairrf() {
        return flagcalculairrf;
    }

    public void setFlagcalculairrf(Character flagcalculairrf) {
        this.flagcalculairrf = flagcalculairrf;
    }

    public Character getFlagcalculaii() {
        return flagcalculaii;
    }

    public void setFlagcalculaii(Character flagcalculaii) {
        this.flagcalculaii = flagcalculaii;
    }

    public Character getFlagsomadespacessbaseii() {
        return flagsomadespacessbaseii;
    }

    public void setFlagsomadespacessbaseii(Character flagsomadespacessbaseii) {
        this.flagsomadespacessbaseii = flagsomadespacessbaseii;
    }

    public Character getFlagsomacofinsbaseicms() {
        return flagsomacofinsbaseicms;
    }

    public void setFlagsomacofinsbaseicms(Character flagsomacofinsbaseicms) {
        this.flagsomacofinsbaseicms = flagsomacofinsbaseicms;
    }

    public Character getFlagsomapisbaseicms() {
        return flagsomapisbaseicms;
    }

    public void setFlagsomapisbaseicms(Character flagsomapisbaseicms) {
        this.flagsomapisbaseicms = flagsomapisbaseicms;
    }

    public Character getFlagsomaiibaseicms() {
        return flagsomaiibaseicms;
    }

    public void setFlagsomaiibaseicms(Character flagsomaiibaseicms) {
        this.flagsomaiibaseicms = flagsomaiibaseicms;
    }

    public BigDecimal getAliqirrf() {
        return aliqirrf;
    }

    public void setAliqirrf(BigDecimal aliqirrf) {
        this.aliqirrf = aliqirrf;
    }

    public BigDecimal getValorminimodarf() {
        return valorminimodarf;
    }

    public void setValorminimodarf(BigDecimal valorminimodarf) {
        this.valorminimodarf = valorminimodarf;
    }

    public BigDecimal getAliqcsll() {
        return aliqcsll;
    }

    public void setAliqcsll(BigDecimal aliqcsll) {
        this.aliqcsll = aliqcsll;
    }

    public Character getFlagimportacao() {
        return flagimportacao;
    }

    public void setFlagimportacao(Character flagimportacao) {
        this.flagimportacao = flagimportacao;
    }

    public Character getFlagvendaconsumidorfinal() {
        return flagvendaconsumidorfinal;
    }

    public void setFlagvendaconsumidorfinal(Character flagvendaconsumidorfinal) {
        this.flagvendaconsumidorfinal = flagvendaconsumidorfinal;
    }

    public Character getFlagsomaipibasesubsttributaria() {
        return flagsomaipibasesubsttributaria;
    }

    public void setFlagsomaipibasesubsttributaria(Character flagsomaipibasesubsttributaria) {
        this.flagsomaipibasesubsttributaria = flagsomaipibasesubsttributaria;
    }

    public Character getFlagsomaicms() {
        return flagsomaicms;
    }

    public void setFlagsomaicms(Character flagsomaicms) {
        this.flagsomaicms = flagsomaicms;
    }

    public Character getFlagabatedescontosbaseipi() {
        return flagabatedescontosbaseipi;
    }

    public void setFlagabatedescontosbaseipi(Character flagabatedescontosbaseipi) {
        this.flagabatedescontosbaseipi = flagabatedescontosbaseipi;
    }

    public Character getFlagsomadespacessbaseipi() {
        return flagsomadespacessbaseipi;
    }

    public void setFlagsomadespacessbaseipi(Character flagsomadespacessbaseipi) {
        this.flagsomadespacessbaseipi = flagsomadespacessbaseipi;
    }

    public Character getFlagescrituracaoipi() {
        return flagescrituracaoipi;
    }

    public void setFlagescrituracaoipi(Character flagescrituracaoipi) {
        this.flagescrituracaoipi = flagescrituracaoipi;
    }

    public Character getFlagescrituracaoicms() {
        return flagescrituracaoicms;
    }

    public void setFlagescrituracaoicms(Character flagescrituracaoicms) {
        this.flagescrituracaoicms = flagescrituracaoicms;
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

    public String getNaturezaoperacao() {
        return naturezaoperacao;
    }

    public void setNaturezaoperacao(String naturezaoperacao) {
        this.naturezaoperacao = naturezaoperacao;
    }

    public Character getFlagusaaliqdiferenciada() {
        return flagusaaliqdiferenciada;
    }

    public void setFlagusaaliqdiferenciada(Character flagusaaliqdiferenciada) {
        this.flagusaaliqdiferenciada = flagusaaliqdiferenciada;
    }

    public Character getFlagiss() {
        return flagiss;
    }

    public void setFlagiss(Character flagiss) {
        this.flagiss = flagiss;
    }

    public String getCodtipomovimentoentregafutura() {
        return codtipomovimentoentregafutura;
    }

    public void setCodtipomovimentoentregafutura(String codtipomovimentoentregafutura) {
        this.codtipomovimentoentregafutura = codtipomovimentoentregafutura;
    }

    public Character getFlagsomaoutrasdespesassubsttrib() {
        return flagsomaoutrasdespesassubsttrib;
    }

    public void setFlagsomaoutrasdespesassubsttrib(Character flagsomaoutrasdespesassubsttrib) {
        this.flagsomaoutrasdespesassubsttrib = flagsomaoutrasdespesassubsttrib;
    }

    public Character getFlagsomasegurosubsttrib() {
        return flagsomasegurosubsttrib;
    }

    public void setFlagsomasegurosubsttrib(Character flagsomasegurosubsttrib) {
        this.flagsomasegurosubsttrib = flagsomasegurosubsttrib;
    }

    public Character getFlagnaoabatedescontosubsttrib() {
        return flagnaoabatedescontosubsttrib;
    }

    public void setFlagnaoabatedescontosubsttrib(Character flagnaoabatedescontosubsttrib) {
        this.flagnaoabatedescontosubsttrib = flagnaoabatedescontosubsttrib;
    }

    public Character getFlagnaoabatedescontobaseicms() {
        return flagnaoabatedescontobaseicms;
    }

    public void setFlagnaoabatedescontobaseicms(Character flagnaoabatedescontobaseicms) {
        this.flagnaoabatedescontobaseicms = flagnaoabatedescontobaseicms;
    }

    public Integer getCasasdecimais() {
        return casasdecimais;
    }

    public void setCasasdecimais(Integer casasdecimais) {
        this.casasdecimais = casasdecimais;
    }

    public Character getFlagsomafrete() {
        return flagsomafrete;
    }

    public void setFlagsomafrete(Character flagsomafrete) {
        this.flagsomafrete = flagsomafrete;
    }

    public Character getFlagprecosaida() {
        return flagprecosaida;
    }

    public void setFlagprecosaida(Character flagprecosaida) {
        this.flagprecosaida = flagprecosaida;
    }

    public Character getFlagentregafutura() {
        return flagentregafutura;
    }

    public void setFlagentregafutura(Character flagentregafutura) {
        this.flagentregafutura = flagentregafutura;
    }

    public Character getFlagdeduzissreceb() {
        return flagdeduzissreceb;
    }

    public void setFlagdeduzissreceb(Character flagdeduzissreceb) {
        this.flagdeduzissreceb = flagdeduzissreceb;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Character getFlagedicao() {
        return flagedicao;
    }

    public void setFlagedicao(Character flagedicao) {
        this.flagedicao = flagedicao;
    }

    public Character getFlagexibirmensagemaprovcred() {
        return flagexibirmensagemaprovcred;
    }

    public void setFlagexibirmensagemaprovcred(Character flagexibirmensagemaprovcred) {
        this.flagexibirmensagemaprovcred = flagexibirmensagemaprovcred;
    }

    public Character getFlagexibirmensagemolhoimposto() {
        return flagexibirmensagemolhoimposto;
    }

    public void setFlagexibirmensagemolhoimposto(Character flagexibirmensagemolhoimposto) {
        this.flagexibirmensagemolhoimposto = flagexibirmensagemolhoimposto;
    }

    public Character getFlagnaocalcularmva() {
        return flagnaocalcularmva;
    }

    public void setFlagnaocalcularmva(Character flagnaocalcularmva) {
        this.flagnaocalcularmva = flagnaocalcularmva;
    }

    public Short getDiassaidanfe() {
        return diassaidanfe;
    }

    public void setDiassaidanfe(Short diassaidanfe) {
        this.diassaidanfe = diassaidanfe;
    }

    public Character getFlagbloqueargeracaonfe() {
        return flagbloqueargeracaonfe;
    }

    public void setFlagbloqueargeracaonfe(Character flagbloqueargeracaonfe) {
        this.flagbloqueargeracaonfe = flagbloqueargeracaonfe;
    }

    public Character getFlagpresenca() {
        return flagpresenca;
    }

    public void setFlagpresenca(Character flagpresenca) {
        this.flagpresenca = flagpresenca;
    }

    public Character getFlagconsumidorfinal() {
        return flagconsumidorfinal;
    }

    public void setFlagconsumidorfinal(Character flagconsumidorfinal) {
        this.flagconsumidorfinal = flagconsumidorfinal;
    }

    public Character getFlagoperacaowms() {
        return flagoperacaowms;
    }

    public void setFlagoperacaowms(Character flagoperacaowms) {
        this.flagoperacaowms = flagoperacaowms;
    }

    public Character getFlagdocreferenciado() {
        return flagdocreferenciado;
    }

    public void setFlagdocreferenciado(Character flagdocreferenciado) {
        this.flagdocreferenciado = flagdocreferenciado;
    }

    public Character getFlagcalculacsll() {
        return flagcalculacsll;
    }

    public void setFlagcalculacsll(Character flagcalculacsll) {
        this.flagcalculacsll = flagcalculacsll;
    }

    public Character getFlagdelivery() {
        return flagdelivery;
    }

    public void setFlagdelivery(Character flagdelivery) {
        this.flagdelivery = flagdelivery;
    }

    public BigDecimal getAliqfcpfixa() {
        return aliqfcpfixa;
    }

    public void setAliqfcpfixa(BigDecimal aliqfcpfixa) {
        this.aliqfcpfixa = aliqfcpfixa;
    }

    public Character getFlagcalculainss() {
        return flagcalculainss;
    }

    public void setFlagcalculainss(Character flagcalculainss) {
        this.flagcalculainss = flagcalculainss;
    }

    public BigDecimal getAliqinss() {
        return aliqinss;
    }

    public void setAliqinss(BigDecimal aliqinss) {
        this.aliqinss = aliqinss;
    }

    public Character getFlagcalculaicmsefetivo() {
        return flagcalculaicmsefetivo;
    }

    public void setFlagcalculaicmsefetivo(Character flagcalculaicmsefetivo) {
        this.flagcalculaicmsefetivo = flagcalculaicmsefetivo;
    }

    public String getTipooperacaowms() {
        return tipooperacaowms;
    }

    public void setTipooperacaowms(String tipooperacaowms) {
        this.tipooperacaowms = tipooperacaowms;
    }

    public Character getFlagdeduzicmsdesonerado() {
        return flagdeduzicmsdesonerado;
    }

    public void setFlagdeduzicmsdesonerado(Character flagdeduzicmsdesonerado) {
        this.flagdeduzicmsdesonerado = flagdeduzicmsdesonerado;
    }

    public String getCstipi() {
        return cstipi;
    }

    public void setCstipi(String cstipi) {
        this.cstipi = cstipi;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Regracfopitem> getRegracfopitemCollection() {
        return regracfopitemCollection;
    }

    public void setRegracfopitemCollection(Collection<Regracfopitem> regracfopitemCollection) {
        this.regracfopitemCollection = regracfopitemCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Planocontacfop> getPlanocontacfopCollection() {
        return planocontacfopCollection;
    }

    public void setPlanocontacfopCollection(Collection<Planocontacfop> planocontacfopCollection) {
        this.planocontacfopCollection = planocontacfopCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipomovimento != null ? codtipomovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomovimento)) {
            return false;
        }
        Tipomovimento other = (Tipomovimento) object;
        if ((this.codtipomovimento == null && other.codtipomovimento != null) || (this.codtipomovimento != null && !this.codtipomovimento.equals(other.codtipomovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipomovimento[ codtipomovimento=" + codtipomovimento + " ]";
    }

    public Character getFlagcalculaipidevolvido() {
        return flagcalculaipidevolvido;
    }

    public void setFlagcalculaipidevolvido(Character flagcalculaipidevolvido) {
        this.flagcalculaipidevolvido = flagcalculaipidevolvido;
    }

    public Intermediador getCodintermediador() {
        return codintermediador;
    }

    public void setCodintermediador(Intermediador codintermediador) {
        this.codintermediador = codintermediador;
    }
    
}
