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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "TIPOMOVIMENTO", catalog = "", schema = "")

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
