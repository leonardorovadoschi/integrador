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
@Table(name = "ORCAMENTO", catalog = "", schema = "")

public class Orcamento implements Serializable {

    @JoinColumn(name = "CODINTERMEDIADOR", referencedColumnName = "CODINTERMEDIADOR")
    @ManyToOne
    private Intermediador codintermediador;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODORC")
    private String codorc;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Column(name = "NOMECLI")
    private String nomecli;
    @Column(name = "CONTATO")
    private String contato;
    @Lob
    @Column(name = "OBS")
    private String obs;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORTOTAL")
    private BigDecimal valortotal;
    @Column(name = "FLAGRESERVADO")
    private Character flagreservado;
    @Column(name = "ALIQDESCONTO")
    private BigDecimal aliqdesconto;
    @Column(name = "FLAGPALM")
    private Short flagpalm;
    @Column(name = "FLAGSTATUS")
    private Character flagstatus;
    @Column(name = "PARCELA")
    private Integer parcela;
    @Column(name = "NUMPEDLOJAVIRTUAL")
    private Integer numpedlojavirtual;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
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
    @Column(name = "ENTREGAPAIS")
    private String entregapais;
    @Column(name = "ENTREGATELEFONE")
    private String entregatelefone;
    @Column(name = "ENTREGAREFERENCIA")
    private String entregareferencia;
    @Column(name = "ENTREGADATA")
    @Temporal(TemporalType.DATE)
    private Date entregadata;
    @Column(name = "VALORACRESCIMO")
    private BigDecimal valoracrescimo;
    @Column(name = "FLAGDELIVERY")
    private Character flagdelivery;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "CODUSER")
    private String coduser;
    @Lob
    @Column(name = "OBSNOTAFISCAL")
    private String obsnotafiscal;
    @Column(name = "FLAGPREVENDA")
    private Character flagprevenda;
    @Column(name = "CODCFOP")
    private String codcfop;
    @Column(name = "VALORSEGURO")
    private BigDecimal valorseguro;
    @Column(name = "BASESUBSTTRIBUTARIA")
    private BigDecimal basesubsttributaria;
    @Column(name = "VALORSUBSTTRIBUTARIA")
    private BigDecimal valorsubsttributaria;
    @Column(name = "VALOROUTRASDESPESAS")
    private BigDecimal valoroutrasdespesas;
    @Column(name = "BASEICMS")
    private BigDecimal baseicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "VALORDESCONTO")
    private BigDecimal valordesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "ALIQACRESCIMO")
    private BigDecimal aliqacrescimo;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "VALORTOTALORCAMENTO")
    private BigDecimal valortotalorcamento;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "CAMPOSTR1")
    private String campostr1;
    @Column(name = "CAMPOSTR2")
    private String campostr2;
    @Column(name = "CAMPOVALOR1")
    private BigDecimal campovalor1;
    @Column(name = "NUMPEDCLIENTE")
    private String numpedcliente;
    @Column(name = "MOTIVOCANCELAMENTO")
    private String motivocancelamento;
    @Column(name = "FLAGCANCELADO")
    private Character flagcancelado;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @Column(name = "DATACADASTRO")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    @Column(name = "NUMEROORCAMENTO")
    private String numeroorcamento;
    @Column(name = "FLAGESTOQUELIBERADO")
    private Character flagestoqueliberado;
    @Lob
    @Column(name = "ENTREGAOBS")
    private String entregaobs;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Column(name = "DATAARQUIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataarquivo;
    @Column(name = "TEMPO")
    @Temporal(TemporalType.TIME)
    private Date tempo;
    @Column(name = "VALORENTRADA")
    private BigDecimal valorentrada;
    @Column(name = "CODRECENTRADA")
    private String codrecentrada;
    @Column(name = "CODRECPARCELA")
    private String codrecparcela;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "DATAHORARESERVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahorareserva;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALISS")
    private BigDecimal valortotaliss;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Column(name = "ARQUIVOORIGEM")
    private String arquivoorigem;
    @Column(name = "NUMEROCCF")
    private Integer numeroccf;
    @Column(name = "RENTABILIDADE")
    private BigDecimal rentabilidade;
    @Column(name = "ENTREGANUMERO")
    private String entreganumero;
    @Column(name = "ENTREGACOMPLEMENTO")
    private String entregacomplemento;
    @Column(name = "FLAGCONFERIDO")
    private Character flagconferido;
    @Column(name = "FLAGIMPRESSO")
    private Character flagimpresso;
    @Column(name = "NUMPREVENDA")
    private Integer numprevenda;
    @Column(name = "DATAFATURADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafaturado;
    @Column(name = "QUANTIDADEVOLUMES")
    private Integer quantidadevolumes;
    @Column(name = "CODUSERVISTO")
    private String coduservisto;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGDESCAUTORIZADO")
    private Character flagdescautorizado;
    @Column(name = "CODCLIFIDELIZACAO")
    private String codclifidelizacao;
    @Column(name = "COORG")
    private Integer coorg;
    @Column(name = "FLAGFORMULAMANIPULADA")
    private Character flagformulamanipulada;
    @Column(name = "FLAGBLOQUEADO")
    private Character flagbloqueado;
    @Column(name = "FLAGENTREGAENDERECOIGUAL")
    private Character flagentregaenderecoigual;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "CNPJEMITENTE")
    private String cnpjemitente;
    @Column(name = "CNPJCPFCLIENTE")
    private String cnpjcpfcliente;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "IDENTIFICADORDESTINO")
    private Character identificadordestino;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "CODENTREGAPESSOA")
    private Integer codentregapessoa;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codorc")
    private Collection<Orcamentorec> orcamentorecCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCONTABANCARIA", referencedColumnName = "CODCONTABANCARIA")
    @ManyToOne
    private Contabancaria codcontabancaria;
    @JoinColumn(name = "CODFP", referencedColumnName = "CODFP")
    @ManyToOne
    private Formapag codfp;
    @JoinColumn(name = "CODORCAMENTOSTATUS", referencedColumnName = "CODORCAMENTOSTATUS")
    @ManyToOne
    private Orcamentostatus codorcamentostatus;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne
    private OsOrdemservico codos;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @JoinColumn(name = "CODVEICULO", referencedColumnName = "CODVEICULO")
    @ManyToOne
    private Veiculos codveiculo;
    @JoinColumn(name = "CODVENDEDEXT", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codorc")
    private Collection<Orcamentoprod> orcamentoprodCollection;

    public Orcamento() {
    }

    public Orcamento(String codorc) {
        this.codorc = codorc;
    }

    public String getCodorc() {
        return codorc;
    }

    public void setCodorc(String codorc) {
        this.codorc = codorc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Character getFlagcli() {
        return flagcli;
    }

    public void setFlagcli(Character flagcli) {
        this.flagcli = flagcli;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public Character getFlagreservado() {
        return flagreservado;
    }

    public void setFlagreservado(Character flagreservado) {
        this.flagreservado = flagreservado;
    }

    public BigDecimal getAliqdesconto() {
        return aliqdesconto;
    }

    public void setAliqdesconto(BigDecimal aliqdesconto) {
        this.aliqdesconto = aliqdesconto;
    }

    public Short getFlagpalm() {
        return flagpalm;
    }

    public void setFlagpalm(Short flagpalm) {
        this.flagpalm = flagpalm;
    }

    public Character getFlagstatus() {
        return flagstatus;
    }

    public void setFlagstatus(Character flagstatus) {
        this.flagstatus = flagstatus;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Integer getNumpedlojavirtual() {
        return numpedlojavirtual;
    }

    public void setNumpedlojavirtual(Integer numpedlojavirtual) {
        this.numpedlojavirtual = numpedlojavirtual;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
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

    public String getEntregapais() {
        return entregapais;
    }

    public void setEntregapais(String entregapais) {
        this.entregapais = entregapais;
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

    public Date getEntregadata() {
        return entregadata;
    }

    public void setEntregadata(Date entregadata) {
        this.entregadata = entregadata;
    }

    public BigDecimal getValoracrescimo() {
        return valoracrescimo;
    }

    public void setValoracrescimo(BigDecimal valoracrescimo) {
        this.valoracrescimo = valoracrescimo;
    }

    public Character getFlagdelivery() {
        return flagdelivery;
    }

    public void setFlagdelivery(Character flagdelivery) {
        this.flagdelivery = flagdelivery;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getObsnotafiscal() {
        return obsnotafiscal;
    }

    public void setObsnotafiscal(String obsnotafiscal) {
        this.obsnotafiscal = obsnotafiscal;
    }

    public Character getFlagprevenda() {
        return flagprevenda;
    }

    public void setFlagprevenda(Character flagprevenda) {
        this.flagprevenda = flagprevenda;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getValorseguro() {
        return valorseguro;
    }

    public void setValorseguro(BigDecimal valorseguro) {
        this.valorseguro = valorseguro;
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

    public BigDecimal getValoroutrasdespesas() {
        return valoroutrasdespesas;
    }

    public void setValoroutrasdespesas(BigDecimal valoroutrasdespesas) {
        this.valoroutrasdespesas = valoroutrasdespesas;
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

    public Character getFlagtipodesconto() {
        return flagtipodesconto;
    }

    public void setFlagtipodesconto(Character flagtipodesconto) {
        this.flagtipodesconto = flagtipodesconto;
    }

    public BigDecimal getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(BigDecimal valordesconto) {
        this.valordesconto = valordesconto;
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

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public BigDecimal getValortotalorcamento() {
        return valortotalorcamento;
    }

    public void setValortotalorcamento(BigDecimal valortotalorcamento) {
        this.valortotalorcamento = valortotalorcamento;
    }

    public BigDecimal getValortotalipi() {
        return valortotalipi;
    }

    public void setValortotalipi(BigDecimal valortotalipi) {
        this.valortotalipi = valortotalipi;
    }

    public BigDecimal getValortotalprodutos() {
        return valortotalprodutos;
    }

    public void setValortotalprodutos(BigDecimal valortotalprodutos) {
        this.valortotalprodutos = valortotalprodutos;
    }

    public String getCampostr1() {
        return campostr1;
    }

    public void setCampostr1(String campostr1) {
        this.campostr1 = campostr1;
    }

    public String getCampostr2() {
        return campostr2;
    }

    public void setCampostr2(String campostr2) {
        this.campostr2 = campostr2;
    }

    public BigDecimal getCampovalor1() {
        return campovalor1;
    }

    public void setCampovalor1(BigDecimal campovalor1) {
        this.campovalor1 = campovalor1;
    }

    public String getNumpedcliente() {
        return numpedcliente;
    }

    public void setNumpedcliente(String numpedcliente) {
        this.numpedcliente = numpedcliente;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public Character getFlagcancelado() {
        return flagcancelado;
    }

    public void setFlagcancelado(Character flagcancelado) {
        this.flagcancelado = flagcancelado;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getNumeroorcamento() {
        return numeroorcamento;
    }

    public void setNumeroorcamento(String numeroorcamento) {
        this.numeroorcamento = numeroorcamento;
    }

    public Character getFlagestoqueliberado() {
        return flagestoqueliberado;
    }

    public void setFlagestoqueliberado(Character flagestoqueliberado) {
        this.flagestoqueliberado = flagestoqueliberado;
    }

    public String getEntregaobs() {
        return entregaobs;
    }

    public void setEntregaobs(String entregaobs) {
        this.entregaobs = entregaobs;
    }

    public String getCodtransredespacho() {
        return codtransredespacho;
    }

    public void setCodtransredespacho(String codtransredespacho) {
        this.codtransredespacho = codtransredespacho;
    }

    public Date getDataarquivo() {
        return dataarquivo;
    }

    public void setDataarquivo(Date dataarquivo) {
        this.dataarquivo = dataarquivo;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public BigDecimal getValorentrada() {
        return valorentrada;
    }

    public void setValorentrada(BigDecimal valorentrada) {
        this.valorentrada = valorentrada;
    }

    public String getCodrecentrada() {
        return codrecentrada;
    }

    public void setCodrecentrada(String codrecentrada) {
        this.codrecentrada = codrecentrada;
    }

    public String getCodrecparcela() {
        return codrecparcela;
    }

    public void setCodrecparcela(String codrecparcela) {
        this.codrecparcela = codrecparcela;
    }

    public BigDecimal getValortotalcofins() {
        return valortotalcofins;
    }

    public void setValortotalcofins(BigDecimal valortotalcofins) {
        this.valortotalcofins = valortotalcofins;
    }

    public BigDecimal getValortotalpis() {
        return valortotalpis;
    }

    public void setValortotalpis(BigDecimal valortotalpis) {
        this.valortotalpis = valortotalpis;
    }

    public Date getDatahorareserva() {
        return datahorareserva;
    }

    public void setDatahorareserva(Date datahorareserva) {
        this.datahorareserva = datahorareserva;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public String getMarcaecf() {
        return marcaecf;
    }

    public void setMarcaecf(String marcaecf) {
        this.marcaecf = marcaecf;
    }

    public String getModeloecf() {
        return modeloecf;
    }

    public void setModeloecf(String modeloecf) {
        this.modeloecf = modeloecf;
    }

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
    }

    public BigDecimal getValortotalservicos() {
        return valortotalservicos;
    }

    public void setValortotalservicos(BigDecimal valortotalservicos) {
        this.valortotalservicos = valortotalservicos;
    }

    public BigDecimal getValortotaliss() {
        return valortotaliss;
    }

    public void setValortotaliss(BigDecimal valortotaliss) {
        this.valortotaliss = valortotaliss;
    }

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    public String getArquivoorigem() {
        return arquivoorigem;
    }

    public void setArquivoorigem(String arquivoorigem) {
        this.arquivoorigem = arquivoorigem;
    }

    public Integer getNumeroccf() {
        return numeroccf;
    }

    public void setNumeroccf(Integer numeroccf) {
        this.numeroccf = numeroccf;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public String getEntreganumero() {
        return entreganumero;
    }

    public void setEntreganumero(String entreganumero) {
        this.entreganumero = entreganumero;
    }

    public String getEntregacomplemento() {
        return entregacomplemento;
    }

    public void setEntregacomplemento(String entregacomplemento) {
        this.entregacomplemento = entregacomplemento;
    }

    public Character getFlagconferido() {
        return flagconferido;
    }

    public void setFlagconferido(Character flagconferido) {
        this.flagconferido = flagconferido;
    }

    public Character getFlagimpresso() {
        return flagimpresso;
    }

    public void setFlagimpresso(Character flagimpresso) {
        this.flagimpresso = flagimpresso;
    }

    public Integer getNumprevenda() {
        return numprevenda;
    }

    public void setNumprevenda(Integer numprevenda) {
        this.numprevenda = numprevenda;
    }

    public Date getDatafaturado() {
        return datafaturado;
    }

    public void setDatafaturado(Date datafaturado) {
        this.datafaturado = datafaturado;
    }

    public Integer getQuantidadevolumes() {
        return quantidadevolumes;
    }

    public void setQuantidadevolumes(Integer quantidadevolumes) {
        this.quantidadevolumes = quantidadevolumes;
    }

    public String getCoduservisto() {
        return coduservisto;
    }

    public void setCoduservisto(String coduservisto) {
        this.coduservisto = coduservisto;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagdescautorizado() {
        return flagdescautorizado;
    }

    public void setFlagdescautorizado(Character flagdescautorizado) {
        this.flagdescautorizado = flagdescautorizado;
    }

    public String getCodclifidelizacao() {
        return codclifidelizacao;
    }

    public void setCodclifidelizacao(String codclifidelizacao) {
        this.codclifidelizacao = codclifidelizacao;
    }

    public Integer getCoorg() {
        return coorg;
    }

    public void setCoorg(Integer coorg) {
        this.coorg = coorg;
    }

    public Character getFlagformulamanipulada() {
        return flagformulamanipulada;
    }

    public void setFlagformulamanipulada(Character flagformulamanipulada) {
        this.flagformulamanipulada = flagformulamanipulada;
    }

    public Character getFlagbloqueado() {
        return flagbloqueado;
    }

    public void setFlagbloqueado(Character flagbloqueado) {
        this.flagbloqueado = flagbloqueado;
    }

    public Character getFlagentregaenderecoigual() {
        return flagentregaenderecoigual;
    }

    public void setFlagentregaenderecoigual(Character flagentregaenderecoigual) {
        this.flagentregaenderecoigual = flagentregaenderecoigual;
    }

    public Character getIndpresenca() {
        return indpresenca;
    }

    public void setIndpresenca(Character indpresenca) {
        this.indpresenca = indpresenca;
    }

    public String getCnpjemitente() {
        return cnpjemitente;
    }

    public void setCnpjemitente(String cnpjemitente) {
        this.cnpjemitente = cnpjemitente;
    }

    public String getCnpjcpfcliente() {
        return cnpjcpfcliente;
    }

    public void setCnpjcpfcliente(String cnpjcpfcliente) {
        this.cnpjcpfcliente = cnpjcpfcliente;
    }

    public Integer getNumerocaixa() {
        return numerocaixa;
    }

    public void setNumerocaixa(Integer numerocaixa) {
        this.numerocaixa = numerocaixa;
    }

    public Character getIdentificadordestino() {
        return identificadordestino;
    }

    public void setIdentificadordestino(Character identificadordestino) {
        this.identificadordestino = identificadordestino;
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

    public Integer getCodentregapessoa() {
        return codentregapessoa;
    }

    public void setCodentregapessoa(Integer codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
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

    @XmlTransient
    public Collection<Orcamentorec> getOrcamentorecCollection() {
        return orcamentorecCollection;
    }

    public void setOrcamentorecCollection(Collection<Orcamentorec> orcamentorecCollection) {
        this.orcamentorecCollection = orcamentorecCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Contabancaria getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(Contabancaria codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public Formapag getCodfp() {
        return codfp;
    }

    public void setCodfp(Formapag codfp) {
        this.codfp = codfp;
    }

    public Orcamentostatus getCodorcamentostatus() {
        return codorcamentostatus;
    }

    public void setCodorcamentostatus(Orcamentostatus codorcamentostatus) {
        this.codorcamentostatus = codorcamentostatus;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
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

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    public Veiculos getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Veiculos codveiculo) {
        this.codveiculo = codveiculo;
    }

    public Vendedor getCodvendedext() {
        return codvendedext;
    }

    public void setCodvendedext(Vendedor codvendedext) {
        this.codvendedext = codvendedext;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codorc != null ? codorc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamento)) {
            return false;
        }
        Orcamento other = (Orcamento) object;
        if ((this.codorc == null && other.codorc != null) || (this.codorc != null && !this.codorc.equals(other.codorc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Orcamento[ codorc=" + codorc + " ]";
    }

    public Intermediador getCodintermediador() {
        return codintermediador;
    }

    public void setCodintermediador(Intermediador codintermediador) {
        this.codintermediador = codintermediador;
    }
    
}
