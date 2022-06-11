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
import javax.persistence.OneToOne;
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
@Table(name = "MOVENDA", catalog = "", schema = "")

public class Movenda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "FLAGFORNCLI")
    private Character flagforncli;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Column(name = "NOMECLI")
    private String nomecli;
    
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codForn; 
    
    
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODUSERCANCELAMENTO")
    private String codusercancelamento;
    @Column(name = "CODEMPRESAAUX")
    private Integer codempresaaux;
    @Column(name = "CODENTREGAPESSOA")
    private String codentregapessoa;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataemissao;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Column(name = "NUMPED")
    private Integer numped;
    @Column(name = "NUMPEDLOJAVIRTUAL")
    private Integer numpedlojavirtual;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Lob
    @Column(name = "OBSNOTAFISCAL")
    private String obsnotafiscal;
    @Column(name = "FLAGVENDA")
    private Character flagvenda;
    @Column(name = "FLAGFRETE")
    private Character flagfrete;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "CODPRECO")
    private String codpreco;
    @Column(name = "TEMPO")
    @Temporal(TemporalType.TIME)
    private Date tempo;
    @Column(name = "PERCCOMISSAO")
    private BigDecimal perccomissao;
    @Column(name = "FLAGCANCELADA")
    private Character flagcancelada;
    @Column(name = "MODELONOTA")
    private String modelonota;
    @Column(name = "NUMCAIXA")
    private Integer numcaixa;
    @Column(name = "NUMTRANSF")
    private Integer numtransf;
    @Column(name = "IDENTREGA")
    private String identrega;
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
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "MOTIVOCANCELAMENTO")
    private String motivocancelamento;
    @Column(name = "FLAGDELIVERY")
    private Character flagdelivery;
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
    @Column(name = "FLAGTIPODESCONTO")
    private Character flagtipodesconto;
    @Column(name = "FLAGTIPOACRESCIMO")
    private Character flagtipoacrescimo;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "VALORTOTALPRODUTOS")
    private BigDecimal valortotalprodutos;
    @Column(name = "CAMPOSTR1")
    private String campostr1;
    @Column(name = "CAMPOSTR2")
    private String campostr2;
    @Column(name = "CODFP")
    private String codfp;
    @Column(name = "QUANTIDADEVOLUMES")
    private Integer quantidadevolumes;
    @Column(name = "ENTREGADATA")
    @Temporal(TemporalType.DATE)
    private Date entregadata;
    @Column(name = "ENTREGAREFERENCIA")
    private String entregareferencia;
    @Column(name = "DATALANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datalancamento;
    @Column(name = "VALORTOTALIPI")
    private BigDecimal valortotalipi;
    @Column(name = "CAMPOVALOR1")
    private BigDecimal campovalor1;
    @Column(name = "NUMPEDCLIENTE")
    private String numpedcliente;
    @Column(name = "PESOADICIONALEMBALAGEM")
    private BigDecimal pesoadicionalembalagem;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "PLACAVEICULO")
    private String placaveiculo;
    @Column(name = "ESTADOPLACAVEICULO")
    private String estadoplacaveiculo;
    @Column(name = "ESPECIECARGA")
    private String especiecarga;
    @Column(name = "MARCACARGA")
    private String marcacarga;
    @Column(name = "NUMEROVOLUME")
    private String numerovolume;
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Column(name = "PESOBRUTO")
    private BigDecimal pesobruto;
    @Column(name = "NATUREZAOPERACAO")
    private String naturezaoperacao;
    @Column(name = "FLAGCONTROLEENTREGA")
    private Character flagcontroleentrega;
    @Column(name = "ENTREGANUMEROLOGRADOURO")
    private String entreganumerologradouro;
    @Column(name = "ENTREGACOMPLEMENTOLOGRADOURO")
    private String entregacomplementologradouro;
    @Column(name = "FLAGESTOQUELIBERADO")
    private Character flagestoqueliberado;
    @Column(name = "CODCONTABANCARIA")
    private String codcontabancaria;
    @Column(name = "CODDOCUMENTOREFERENCIADO")
    private String coddocumentoreferenciado;
    @Column(name = "FLAGNFCOMPLEMENTAR")
    private Character flagnfcomplementar;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CODTRANSREDESPACHO")
    private String codtransredespacho;
    @Lob
    @Column(name = "OBSMONTAGEM")
    private String obsmontagem;
    @Lob
    @Column(name = "OBSENTREGA")
    private String obsentrega;
    @Lob
    @Column(name = "ENTREGAOBS")
    private String entregaobs;
    @Column(name = "ENTREGADESTINATARIO")
    private String entregadestinatario;
    @Column(name = "CODMONTADOR")
    private Integer codmontador;
    @Column(name = "STATUSMONTAGEM")
    private Character statusmontagem;
    @Column(name = "DATAENCMONTAGEM")
    @Temporal(TemporalType.DATE)
    private Date dataencmontagem;
    @Column(name = "NUMPEDIDOOFFLINE")
    private Integer numpedidooffline;
    @Column(name = "VALORTOTALSERVICOS")
    private BigDecimal valortotalservicos;
    @Column(name = "VALORTOTALISS")
    private BigDecimal valortotaliss;
    @Column(name = "VALORTOTALCOFINS")
    private BigDecimal valortotalcofins;
    @Column(name = "VALORTOTALPIS")
    private BigDecimal valortotalpis;
    @Column(name = "VALORTOTALREVENDA")
    private BigDecimal valortotalrevenda;
    @Column(name = "CODCONHECIMENTOTRANSPORTE")
    private String codconhecimentotransporte;
    @Column(name = "ANOMES")
    private String anomes;
    @Column(name = "FLAGVISTO")
    private Character flagvisto;
    @Column(name = "CODUSERVISTO")
    private String coduservisto;
    @Column(name = "HORASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horasaida;
    @Column(name = "CODUSERCONFTRANSF")
    private String coduserconftransf;
    @Column(name = "DATACONFTRANSF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataconftransf;
    @Column(name = "CODUSERLIBERACAOINTERNET")
    private String coduserliberacaointernet;
    @Column(name = "FLAGLIBERACAOINTERNET")
    private Character flagliberacaointernet;
    @Column(name = "DADOSADICIONAIS")
    private String dadosadicionais;
    @Column(name = "NUMCCF")
    private Integer numccf;
    @Column(name = "SUBSERIE")
    private String subserie;
    @Column(name = "FLAGR61")
    private Character flagr61;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "CODORDEMPRODUCAO")
    private String codordemproducao;
    @Column(name = "RENTABILIDADE")
    private BigDecimal rentabilidade;
    @Column(name = "FLAGLIBERAEXPEDICAO")
    private Character flagliberaexpedicao;
    @Column(name = "FLAGISSRETIDO")
    private Character flagissretido;
    @Column(name = "CNPJCPFCLIENTE")
    private String cnpjcpfcliente;
    @Column(name = "TRIBUTOAPROX")
    private BigDecimal tributoaprox;
    @Column(name = "ALIQAPROX")
    private BigDecimal aliqaprox;
    @Column(name = "FLAGNFAJUSTE")
    private Character flagnfajuste;
    @Column(name = "CODCLIFIDELIZACAO")
    private String codclifidelizacao;
    @Column(name = "CODMOVENDASAIDAREFERENCIA")
    private String codmovendasaidareferencia;
    @Column(name = "FLAGRESERVADO")
    private Character flagreservado;
    @Column(name = "TRIBUTOESTADUAL")
    private BigDecimal tributoestadual;
    @Column(name = "TRIBUTOMUNICIPAL")
    private BigDecimal tributomunicipal;
    @Column(name = "FLAGNFDEVOLUCAO")
    private Character flagnfdevolucao;
    @Column(name = "INDPRESENCA")
    private Character indpresenca;
    @Column(name = "INDOPERACAO")
    private Character indoperacao;
    @Column(name = "FLAGVENDAPDV")
    private Character flagvendapdv;
    @Column(name = "NUMTRANSFREF")
    private Integer numtransfref;
    @Column(name = "FLAGENVIOWMS")
    private Character flagenviowms;
    @Column(name = "FLAGDOCREFERENCIADO")
    private Character flagdocreferenciado;
    @Column(name = "CNPJEMITENTE")
    private String cnpjemitente;
    @Column(name = "IDENTIFICADORDESTINO")
    private Character identificadordestino;
    @Column(name = "SEGUNDOSDECORRIDOS")
    private Integer segundosdecorridos;
    @Column(name = "VALORFCP")
    private BigDecimal valorfcp;
    @Column(name = "VALORFCPSUBSTTRIBUTARIA")
    private BigDecimal valorfcpsubsttributaria;
    @Column(name = "CODACERTO")
    private String codacerto;
    @Column(name = "ENTREGACPFCNPJ")
    private String entregacpfcnpj;
    @Column(name = "ENTREGAFLAGFISICA")
    private Character entregaflagfisica;
    @Column(name = "VALORICMSDESONERADO")
    private BigDecimal valoricmsdesonerado;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "FLAGCLIENTEOMITIDONF")
    private Character flagclienteomitidonf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovenda")
    private Collection<Conferenciaseparacao> conferenciaseparacaoCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Loteentregaitem> loteentregaitemCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Vendedorcomissao> vendedorcomissaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovenda")
    private Collection<Movendarec> movendarecCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovenda")
    private Collection<Movendadocref> movendadocrefCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovenda")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Movecfnotamanual> movecfnotamanualCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Lancacartao> lancacartaoCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Movcfesat> movcfesatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codmovenda")
    private Collection<Moventradadocref> moventradadocrefCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "movenda")
    private Moentrega moentrega;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Movecfdocumento> movecfdocumentoCollection;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Moentregaprod> moentregaprodCollection;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne
    private Cfop codcfop;
    @JoinColumn(name = "CODCLIREVENDA", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codclirevenda;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVENDASTATUS", referencedColumnName = "CODMOVENDASTATUS")
    @ManyToOne
    private Movendastatus codmovendastatus;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne
    private Setorestoque codsetorestoque;
    @JoinColumn(name = "CODTERMINAL", referencedColumnName = "CODTERMINAL")
    @ManyToOne
    private Terminal codterminal;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne(optional = false)
    private Tipomovimento codtipomovimento;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @JoinColumn(name = "CODVEICULO", referencedColumnName = "CODVEICULO")
    @ManyToOne
    private Veiculos codveiculo;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @JoinColumn(name = "CODVENDEDEXT", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvendedext;
    @OneToMany(mappedBy = "codmovenda")
    private Collection<Nfceletronica> nfceletronicaCollection;

    public Movenda() {
    }

    public Movenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Character getFlagforncli() {
        return flagforncli;
    }

    public void setFlagforncli(Character flagforncli) {
        this.flagforncli = flagforncli;
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

    public Fornecedor getCodForn() {
        return codForn;
    }

    public void setCodForn(Fornecedor codForn) {
        //Fornecedor oldCodForn = this.codForn;
        this.codForn = codForn;
       // changeSupport.firePropertyChange("codForn", oldCodForn, codForn);
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getCodusercancelamento() {
        return codusercancelamento;
    }

    public void setCodusercancelamento(String codusercancelamento) {
        this.codusercancelamento = codusercancelamento;
    }

    public Integer getCodempresaaux() {
        return codempresaaux;
    }

    public void setCodempresaaux(Integer codempresaaux) {
        this.codempresaaux = codempresaaux;
    }

    public String getCodentregapessoa() {
        return codentregapessoa;
    }

    public void setCodentregapessoa(String codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
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

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    public Integer getNumped() {
        return numped;
    }

    public void setNumped(Integer numped) {
        this.numped = numped;
    }

    public Integer getNumpedlojavirtual() {
        return numpedlojavirtual;
    }

    public void setNumpedlojavirtual(Integer numpedlojavirtual) {
        this.numpedlojavirtual = numpedlojavirtual;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getObsnotafiscal() {
        return obsnotafiscal;
    }

    public void setObsnotafiscal(String obsnotafiscal) {
        this.obsnotafiscal = obsnotafiscal;
    }

    public Character getFlagvenda() {
        return flagvenda;
    }

    public void setFlagvenda(Character flagvenda) {
        this.flagvenda = flagvenda;
    }

    public Character getFlagfrete() {
        return flagfrete;
    }

    public void setFlagfrete(Character flagfrete) {
        this.flagfrete = flagfrete;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public String getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(String codpreco) {
        this.codpreco = codpreco;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public BigDecimal getPerccomissao() {
        return perccomissao;
    }

    public void setPerccomissao(BigDecimal perccomissao) {
        this.perccomissao = perccomissao;
    }

    public Character getFlagcancelada() {
        return flagcancelada;
    }

    public void setFlagcancelada(Character flagcancelada) {
        this.flagcancelada = flagcancelada;
    }

    public String getModelonota() {
        return modelonota;
    }

    public void setModelonota(String modelonota) {
        this.modelonota = modelonota;
    }

    public Integer getNumcaixa() {
        return numcaixa;
    }

    public void setNumcaixa(Integer numcaixa) {
        this.numcaixa = numcaixa;
    }

    public Integer getNumtransf() {
        return numtransf;
    }

    public void setNumtransf(Integer numtransf) {
        this.numtransf = numtransf;
    }

    public String getIdentrega() {
        return identrega;
    }

    public void setIdentrega(String identrega) {
        this.identrega = identrega;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getMotivocancelamento() {
        return motivocancelamento;
    }

    public void setMotivocancelamento(String motivocancelamento) {
        this.motivocancelamento = motivocancelamento;
    }

    public Character getFlagdelivery() {
        return flagdelivery;
    }

    public void setFlagdelivery(Character flagdelivery) {
        this.flagdelivery = flagdelivery;
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

    public String getCodfp() {
        return codfp;
    }

    public void setCodfp(String codfp) {
        this.codfp = codfp;
    }

    public Integer getQuantidadevolumes() {
        return quantidadevolumes;
    }

    public void setQuantidadevolumes(Integer quantidadevolumes) {
        this.quantidadevolumes = quantidadevolumes;
    }

    public Date getEntregadata() {
        return entregadata;
    }

    public void setEntregadata(Date entregadata) {
        this.entregadata = entregadata;
    }

    public String getEntregareferencia() {
        return entregareferencia;
    }

    public void setEntregareferencia(String entregareferencia) {
        this.entregareferencia = entregareferencia;
    }

    public Date getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
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

    public String getNumpedcliente() {
        return numpedcliente;
    }

    public void setNumpedcliente(String numpedcliente) {
        this.numpedcliente = numpedcliente;
    }

    public BigDecimal getPesoadicionalembalagem() {
        return pesoadicionalembalagem;
    }

    public void setPesoadicionalembalagem(BigDecimal pesoadicionalembalagem) {
        this.pesoadicionalembalagem = pesoadicionalembalagem;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
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

    public String getNaturezaoperacao() {
        return naturezaoperacao;
    }

    public void setNaturezaoperacao(String naturezaoperacao) {
        this.naturezaoperacao = naturezaoperacao;
    }

    public Character getFlagcontroleentrega() {
        return flagcontroleentrega;
    }

    public void setFlagcontroleentrega(Character flagcontroleentrega) {
        this.flagcontroleentrega = flagcontroleentrega;
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

    public Character getFlagestoqueliberado() {
        return flagestoqueliberado;
    }

    public void setFlagestoqueliberado(Character flagestoqueliberado) {
        this.flagestoqueliberado = flagestoqueliberado;
    }

    public String getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public String getCoddocumentoreferenciado() {
        return coddocumentoreferenciado;
    }

    public void setCoddocumentoreferenciado(String coddocumentoreferenciado) {
        this.coddocumentoreferenciado = coddocumentoreferenciado;
    }

    public Character getFlagnfcomplementar() {
        return flagnfcomplementar;
    }

    public void setFlagnfcomplementar(Character flagnfcomplementar) {
        this.flagnfcomplementar = flagnfcomplementar;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCodtransredespacho() {
        return codtransredespacho;
    }

    public void setCodtransredespacho(String codtransredespacho) {
        this.codtransredespacho = codtransredespacho;
    }

    public String getObsmontagem() {
        return obsmontagem;
    }

    public void setObsmontagem(String obsmontagem) {
        this.obsmontagem = obsmontagem;
    }

    public String getObsentrega() {
        return obsentrega;
    }

    public void setObsentrega(String obsentrega) {
        this.obsentrega = obsentrega;
    }

    public String getEntregaobs() {
        return entregaobs;
    }

    public void setEntregaobs(String entregaobs) {
        this.entregaobs = entregaobs;
    }

    public String getEntregadestinatario() {
        return entregadestinatario;
    }

    public void setEntregadestinatario(String entregadestinatario) {
        this.entregadestinatario = entregadestinatario;
    }

    public Integer getCodmontador() {
        return codmontador;
    }

    public void setCodmontador(Integer codmontador) {
        this.codmontador = codmontador;
    }

    public Character getStatusmontagem() {
        return statusmontagem;
    }

    public void setStatusmontagem(Character statusmontagem) {
        this.statusmontagem = statusmontagem;
    }

    public Date getDataencmontagem() {
        return dataencmontagem;
    }

    public void setDataencmontagem(Date dataencmontagem) {
        this.dataencmontagem = dataencmontagem;
    }

    public Integer getNumpedidooffline() {
        return numpedidooffline;
    }

    public void setNumpedidooffline(Integer numpedidooffline) {
        this.numpedidooffline = numpedidooffline;
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

    public BigDecimal getValortotalrevenda() {
        return valortotalrevenda;
    }

    public void setValortotalrevenda(BigDecimal valortotalrevenda) {
        this.valortotalrevenda = valortotalrevenda;
    }

    public String getCodconhecimentotransporte() {
        return codconhecimentotransporte;
    }

    public void setCodconhecimentotransporte(String codconhecimentotransporte) {
        this.codconhecimentotransporte = codconhecimentotransporte;
    }

    public String getAnomes() {
        return anomes;
    }

    public void setAnomes(String anomes) {
        this.anomes = anomes;
    }

    public Character getFlagvisto() {
        return flagvisto;
    }

    public void setFlagvisto(Character flagvisto) {
        this.flagvisto = flagvisto;
    }

    public String getCoduservisto() {
        return coduservisto;
    }

    public void setCoduservisto(String coduservisto) {
        this.coduservisto = coduservisto;
    }

    public Date getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(Date horasaida) {
        this.horasaida = horasaida;
    }

    public String getCoduserconftransf() {
        return coduserconftransf;
    }

    public void setCoduserconftransf(String coduserconftransf) {
        this.coduserconftransf = coduserconftransf;
    }

    public Date getDataconftransf() {
        return dataconftransf;
    }

    public void setDataconftransf(Date dataconftransf) {
        this.dataconftransf = dataconftransf;
    }

    public String getCoduserliberacaointernet() {
        return coduserliberacaointernet;
    }

    public void setCoduserliberacaointernet(String coduserliberacaointernet) {
        this.coduserliberacaointernet = coduserliberacaointernet;
    }

    public Character getFlagliberacaointernet() {
        return flagliberacaointernet;
    }

    public void setFlagliberacaointernet(Character flagliberacaointernet) {
        this.flagliberacaointernet = flagliberacaointernet;
    }

    public String getDadosadicionais() {
        return dadosadicionais;
    }

    public void setDadosadicionais(String dadosadicionais) {
        this.dadosadicionais = dadosadicionais;
    }

    public Integer getNumccf() {
        return numccf;
    }

    public void setNumccf(Integer numccf) {
        this.numccf = numccf;
    }

    public String getSubserie() {
        return subserie;
    }

    public void setSubserie(String subserie) {
        this.subserie = subserie;
    }

    public Character getFlagr61() {
        return flagr61;
    }

    public void setFlagr61(Character flagr61) {
        this.flagr61 = flagr61;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public String getCodordemproducao() {
        return codordemproducao;
    }

    public void setCodordemproducao(String codordemproducao) {
        this.codordemproducao = codordemproducao;
    }

    public BigDecimal getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(BigDecimal rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public Character getFlagliberaexpedicao() {
        return flagliberaexpedicao;
    }

    public void setFlagliberaexpedicao(Character flagliberaexpedicao) {
        this.flagliberaexpedicao = flagliberaexpedicao;
    }

    public Character getFlagissretido() {
        return flagissretido;
    }

    public void setFlagissretido(Character flagissretido) {
        this.flagissretido = flagissretido;
    }

    public String getCnpjcpfcliente() {
        return cnpjcpfcliente;
    }

    public void setCnpjcpfcliente(String cnpjcpfcliente) {
        this.cnpjcpfcliente = cnpjcpfcliente;
    }

    public BigDecimal getTributoaprox() {
        return tributoaprox;
    }

    public void setTributoaprox(BigDecimal tributoaprox) {
        this.tributoaprox = tributoaprox;
    }

    public BigDecimal getAliqaprox() {
        return aliqaprox;
    }

    public void setAliqaprox(BigDecimal aliqaprox) {
        this.aliqaprox = aliqaprox;
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

    public String getCodmovendasaidareferencia() {
        return codmovendasaidareferencia;
    }

    public void setCodmovendasaidareferencia(String codmovendasaidareferencia) {
        this.codmovendasaidareferencia = codmovendasaidareferencia;
    }

    public Character getFlagreservado() {
        return flagreservado;
    }

    public void setFlagreservado(Character flagreservado) {
        this.flagreservado = flagreservado;
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

    public Character getFlagvendapdv() {
        return flagvendapdv;
    }

    public void setFlagvendapdv(Character flagvendapdv) {
        this.flagvendapdv = flagvendapdv;
    }

    public Integer getNumtransfref() {
        return numtransfref;
    }

    public void setNumtransfref(Integer numtransfref) {
        this.numtransfref = numtransfref;
    }

    public Character getFlagenviowms() {
        return flagenviowms;
    }

    public void setFlagenviowms(Character flagenviowms) {
        this.flagenviowms = flagenviowms;
    }

    public Character getFlagdocreferenciado() {
        return flagdocreferenciado;
    }

    public void setFlagdocreferenciado(Character flagdocreferenciado) {
        this.flagdocreferenciado = flagdocreferenciado;
    }

    public String getCnpjemitente() {
        return cnpjemitente;
    }

    public void setCnpjemitente(String cnpjemitente) {
        this.cnpjemitente = cnpjemitente;
    }

    public Character getIdentificadordestino() {
        return identificadordestino;
    }

    public void setIdentificadordestino(Character identificadordestino) {
        this.identificadordestino = identificadordestino;
    }

    public Integer getSegundosdecorridos() {
        return segundosdecorridos;
    }

    public void setSegundosdecorridos(Integer segundosdecorridos) {
        this.segundosdecorridos = segundosdecorridos;
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

    public String getCodacerto() {
        return codacerto;
    }

    public void setCodacerto(String codacerto) {
        this.codacerto = codacerto;
    }

    public String getEntregacpfcnpj() {
        return entregacpfcnpj;
    }

    public void setEntregacpfcnpj(String entregacpfcnpj) {
        this.entregacpfcnpj = entregacpfcnpj;
    }

    public Character getEntregaflagfisica() {
        return entregaflagfisica;
    }

    public void setEntregaflagfisica(Character entregaflagfisica) {
        this.entregaflagfisica = entregaflagfisica;
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

    public Character getFlagclienteomitidonf() {
        return flagclienteomitidonf;
    }

    public void setFlagclienteomitidonf(Character flagclienteomitidonf) {
        this.flagclienteomitidonf = flagclienteomitidonf;
    }

    @XmlTransient
    public Collection<Conferenciaseparacao> getConferenciaseparacaoCollection() {
        return conferenciaseparacaoCollection;
    }

    public void setConferenciaseparacaoCollection(Collection<Conferenciaseparacao> conferenciaseparacaoCollection) {
        this.conferenciaseparacaoCollection = conferenciaseparacaoCollection;
    }

    @XmlTransient
    public Collection<Loteentregaitem> getLoteentregaitemCollection() {
        return loteentregaitemCollection;
    }

    public void setLoteentregaitemCollection(Collection<Loteentregaitem> loteentregaitemCollection) {
        this.loteentregaitemCollection = loteentregaitemCollection;
    }

    @XmlTransient
    public Collection<Vendedorcomissao> getVendedorcomissaoCollection() {
        return vendedorcomissaoCollection;
    }

    public void setVendedorcomissaoCollection(Collection<Vendedorcomissao> vendedorcomissaoCollection) {
        this.vendedorcomissaoCollection = vendedorcomissaoCollection;
    }

    @XmlTransient
    public Collection<Movendarec> getMovendarecCollection() {
        return movendarecCollection;
    }

    public void setMovendarecCollection(Collection<Movendarec> movendarecCollection) {
        this.movendarecCollection = movendarecCollection;
    }

    @XmlTransient
    public Collection<Movendadocref> getMovendadocrefCollection() {
        return movendadocrefCollection;
    }

    public void setMovendadocrefCollection(Collection<Movendadocref> movendadocrefCollection) {
        this.movendadocrefCollection = movendadocrefCollection;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<Movecfnotamanual> getMovecfnotamanualCollection() {
        return movecfnotamanualCollection;
    }

    public void setMovecfnotamanualCollection(Collection<Movecfnotamanual> movecfnotamanualCollection) {
        this.movecfnotamanualCollection = movecfnotamanualCollection;
    }

    @XmlTransient
    public Collection<Lancacartao> getLancacartaoCollection() {
        return lancacartaoCollection;
    }

    public void setLancacartaoCollection(Collection<Lancacartao> lancacartaoCollection) {
        this.lancacartaoCollection = lancacartaoCollection;
    }

    @XmlTransient
    public Collection<Movcfesat> getMovcfesatCollection() {
        return movcfesatCollection;
    }

    public void setMovcfesatCollection(Collection<Movcfesat> movcfesatCollection) {
        this.movcfesatCollection = movcfesatCollection;
    }

    @XmlTransient
    public Collection<Moventradadocref> getMoventradadocrefCollection() {
        return moventradadocrefCollection;
    }

    public void setMoventradadocrefCollection(Collection<Moventradadocref> moventradadocrefCollection) {
        this.moventradadocrefCollection = moventradadocrefCollection;
    }

    public Moentrega getMoentrega() {
        return moentrega;
    }

    public void setMoentrega(Moentrega moentrega) {
        this.moentrega = moentrega;
    }

    @XmlTransient
    public Collection<Movecfdocumento> getMovecfdocumentoCollection() {
        return movecfdocumentoCollection;
    }

    public void setMovecfdocumentoCollection(Collection<Movecfdocumento> movecfdocumentoCollection) {
        this.movecfdocumentoCollection = movecfdocumentoCollection;
    }

    @XmlTransient
    public Collection<Moentregaprod> getMoentregaprodCollection() {
        return moentregaprodCollection;
    }

    public void setMoentregaprodCollection(Collection<Moentregaprod> moentregaprodCollection) {
        this.moentregaprodCollection = moentregaprodCollection;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Cliente getCodclirevenda() {
        return codclirevenda;
    }

    public void setCodclirevenda(Cliente codclirevenda) {
        this.codclirevenda = codclirevenda;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Movendastatus getCodmovendastatus() {
        return codmovendastatus;
    }

    public void setCodmovendastatus(Movendastatus codmovendastatus) {
        this.codmovendastatus = codmovendastatus;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Terminal getCodterminal() {
        return codterminal;
    }

    public void setCodterminal(Terminal codterminal) {
        this.codterminal = codterminal;
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

    public Veiculos getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Veiculos codveiculo) {
        this.codveiculo = codveiculo;
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
    public Collection<Nfceletronica> getNfceletronicaCollection() {
        return nfceletronicaCollection;
    }

    public void setNfceletronicaCollection(Collection<Nfceletronica> nfceletronicaCollection) {
        this.nfceletronicaCollection = nfceletronicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmovenda != null ? codmovenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movenda)) {
            return false;
        }
        Movenda other = (Movenda) object;
        if ((this.codmovenda == null && other.codmovenda != null) || (this.codmovenda != null && !this.codmovenda.equals(other.codmovenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movenda[ codmovenda=" + codmovenda + " ]";
    }
    
}
