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
@Table(name = "OS_ORDEMSERVICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsOrdemservico.findAll", query = "SELECT o FROM OsOrdemservico o")
    , @NamedQuery(name = "OsOrdemservico.findByCodos", query = "SELECT o FROM OsOrdemservico o WHERE o.codos = :codos")
    , @NamedQuery(name = "OsOrdemservico.findByCodmod", query = "SELECT o FROM OsOrdemservico o WHERE o.codmod = :codmod")
    , @NamedQuery(name = "OsOrdemservico.findByCodforn", query = "SELECT o FROM OsOrdemservico o WHERE o.codforn = :codforn")
    , @NamedQuery(name = "OsOrdemservico.findByCodstatus", query = "SELECT o FROM OsOrdemservico o WHERE o.codstatus = :codstatus")
    , @NamedQuery(name = "OsOrdemservico.findByCodle", query = "SELECT o FROM OsOrdemservico o WHERE o.codle = :codle")
    , @NamedQuery(name = "OsOrdemservico.findByCodta", query = "SELECT o FROM OsOrdemservico o WHERE o.codta = :codta")
    , @NamedQuery(name = "OsOrdemservico.findByCodprioridade", query = "SELECT o FROM OsOrdemservico o WHERE o.codprioridade = :codprioridade")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovenda", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovenda = :codmovenda")
    , @NamedQuery(name = "OsOrdemservico.findByCodtec", query = "SELECT o FROM OsOrdemservico o WHERE o.codtec = :codtec")
    , @NamedQuery(name = "OsOrdemservico.findByCodvended", query = "SELECT o FROM OsOrdemservico o WHERE o.codvended = :codvended")
    , @NamedQuery(name = "OsOrdemservico.findByCoduser", query = "SELECT o FROM OsOrdemservico o WHERE o.coduser = :coduser")
    , @NamedQuery(name = "OsOrdemservico.findByEquipamento", query = "SELECT o FROM OsOrdemservico o WHERE o.equipamento = :equipamento")
    , @NamedQuery(name = "OsOrdemservico.findByIdentificador", query = "SELECT o FROM OsOrdemservico o WHERE o.identificador = :identificador")
    , @NamedQuery(name = "OsOrdemservico.findByMarcamodelo", query = "SELECT o FROM OsOrdemservico o WHERE o.marcamodelo = :marcamodelo")
    , @NamedQuery(name = "OsOrdemservico.findByTipo", query = "SELECT o FROM OsOrdemservico o WHERE o.tipo = :tipo")
    , @NamedQuery(name = "OsOrdemservico.findByValremessa", query = "SELECT o FROM OsOrdemservico o WHERE o.valremessa = :valremessa")
    , @NamedQuery(name = "OsOrdemservico.findByOsexterna", query = "SELECT o FROM OsOrdemservico o WHERE o.osexterna = :osexterna")
    , @NamedQuery(name = "OsOrdemservico.findByContato", query = "SELECT o FROM OsOrdemservico o WHERE o.contato = :contato")
    , @NamedQuery(name = "OsOrdemservico.findByData", query = "SELECT o FROM OsOrdemservico o WHERE o.data = :data")
    , @NamedQuery(name = "OsOrdemservico.findByStatus", query = "SELECT o FROM OsOrdemservico o WHERE o.status = :status")
    , @NamedQuery(name = "OsOrdemservico.findByDatsai", query = "SELECT o FROM OsOrdemservico o WHERE o.datsai = :datsai")
    , @NamedQuery(name = "OsOrdemservico.findByTelefone", query = "SELECT o FROM OsOrdemservico o WHERE o.telefone = :telefone")
    , @NamedQuery(name = "OsOrdemservico.findByNumos", query = "SELECT o FROM OsOrdemservico o WHERE o.numos = :numos")
    , @NamedQuery(name = "OsOrdemservico.findByDatsol", query = "SELECT o FROM OsOrdemservico o WHERE o.datsol = :datsol")
    , @NamedQuery(name = "OsOrdemservico.findByGarantia", query = "SELECT o FROM OsOrdemservico o WHERE o.garantia = :garantia")
    , @NamedQuery(name = "OsOrdemservico.findByLacre", query = "SELECT o FROM OsOrdemservico o WHERE o.lacre = :lacre")
    , @NamedQuery(name = "OsOrdemservico.findByFlagreservado", query = "SELECT o FROM OsOrdemservico o WHERE o.flagreservado = :flagreservado")
    , @NamedQuery(name = "OsOrdemservico.findByFlagexterno", query = "SELECT o FROM OsOrdemservico o WHERE o.flagexterno = :flagexterno")
    , @NamedQuery(name = "OsOrdemservico.findByDatatend", query = "SELECT o FROM OsOrdemservico o WHERE o.datatend = :datatend")
    , @NamedQuery(name = "OsOrdemservico.findByHorachegada", query = "SELECT o FROM OsOrdemservico o WHERE o.horachegada = :horachegada")
    , @NamedQuery(name = "OsOrdemservico.findByHorasaida", query = "SELECT o FROM OsOrdemservico o WHERE o.horasaida = :horasaida")
    , @NamedQuery(name = "OsOrdemservico.findByDataagenda", query = "SELECT o FROM OsOrdemservico o WHERE o.dataagenda = :dataagenda")
    , @NamedQuery(name = "OsOrdemservico.findByHoraagenda", query = "SELECT o FROM OsOrdemservico o WHERE o.horaagenda = :horaagenda")
    , @NamedQuery(name = "OsOrdemservico.findByHoratend", query = "SELECT o FROM OsOrdemservico o WHERE o.horatend = :horatend")
    , @NamedQuery(name = "OsOrdemservico.findByPrazoatend", query = "SELECT o FROM OsOrdemservico o WHERE o.prazoatend = :prazoatend")
    , @NamedQuery(name = "OsOrdemservico.findByDatasaidacampo", query = "SELECT o FROM OsOrdemservico o WHERE o.datasaidacampo = :datasaidacampo")
    , @NamedQuery(name = "OsOrdemservico.findByHorasaidacampo", query = "SELECT o FROM OsOrdemservico o WHERE o.horasaidacampo = :horasaidacampo")
    , @NamedQuery(name = "OsOrdemservico.findByDataretornocampo", query = "SELECT o FROM OsOrdemservico o WHERE o.dataretornocampo = :dataretornocampo")
    , @NamedQuery(name = "OsOrdemservico.findByHoraretornocampo", query = "SELECT o FROM OsOrdemservico o WHERE o.horaretornocampo = :horaretornocampo")
    , @NamedQuery(name = "OsOrdemservico.findByKmrodados", query = "SELECT o FROM OsOrdemservico o WHERE o.kmrodados = :kmrodados")
    , @NamedQuery(name = "OsOrdemservico.findByHorafinalagenda", query = "SELECT o FROM OsOrdemservico o WHERE o.horafinalagenda = :horafinalagenda")
    , @NamedQuery(name = "OsOrdemservico.findByNumhorasatend", query = "SELECT o FROM OsOrdemservico o WHERE o.numhorasatend = :numhorasatend")
    , @NamedQuery(name = "OsOrdemservico.findByKminicial", query = "SELECT o FROM OsOrdemservico o WHERE o.kminicial = :kminicial")
    , @NamedQuery(name = "OsOrdemservico.findByKmfinal", query = "SELECT o FROM OsOrdemservico o WHERE o.kmfinal = :kmfinal")
    , @NamedQuery(name = "OsOrdemservico.findByPercdesconto", query = "SELECT o FROM OsOrdemservico o WHERE o.percdesconto = :percdesconto")
    , @NamedQuery(name = "OsOrdemservico.findByCodsetorestoque", query = "SELECT o FROM OsOrdemservico o WHERE o.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "OsOrdemservico.findByNotafiscalentrada", query = "SELECT o FROM OsOrdemservico o WHERE o.notafiscalentrada = :notafiscalentrada")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovendadevolucao", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovendadevolucao = :codmovendadevolucao")
    , @NamedQuery(name = "OsOrdemservico.findByFlagpesquisa", query = "SELECT o FROM OsOrdemservico o WHERE o.flagpesquisa = :flagpesquisa")
    , @NamedQuery(name = "OsOrdemservico.findByCodprodgarantia2", query = "SELECT o FROM OsOrdemservico o WHERE o.codprodgarantia2 = :codprodgarantia2")
    , @NamedQuery(name = "OsOrdemservico.findByNumcupom", query = "SELECT o FROM OsOrdemservico o WHERE o.numcupom = :numcupom")
    , @NamedQuery(name = "OsOrdemservico.findByDatabaixa", query = "SELECT o FROM OsOrdemservico o WHERE o.databaixa = :databaixa")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovprod", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovprod = :codmovprod")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovendagarantia", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovendagarantia = :codmovendagarantia")
    , @NamedQuery(name = "OsOrdemservico.findByCodprodgarantia", query = "SELECT o FROM OsOrdemservico o WHERE o.codprodgarantia = :codprodgarantia")
    , @NamedQuery(name = "OsOrdemservico.findByCodusersolucao", query = "SELECT o FROM OsOrdemservico o WHERE o.codusersolucao = :codusersolucao")
    , @NamedQuery(name = "OsOrdemservico.findByCoduservisto", query = "SELECT o FROM OsOrdemservico o WHERE o.coduservisto = :coduservisto")
    , @NamedQuery(name = "OsOrdemservico.findByFlagvisto", query = "SELECT o FROM OsOrdemservico o WHERE o.flagvisto = :flagvisto")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovendaorigem", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovendaorigem = :codmovendaorigem")
    , @NamedQuery(name = "OsOrdemservico.findByCodprodorigem", query = "SELECT o FROM OsOrdemservico o WHERE o.codprodorigem = :codprodorigem")
    , @NamedQuery(name = "OsOrdemservico.findByNumeroccf", query = "SELECT o FROM OsOrdemservico o WHERE o.numeroccf = :numeroccf")
    , @NamedQuery(name = "OsOrdemservico.findByEcflacremfd", query = "SELECT o FROM OsOrdemservico o WHERE o.ecflacremfd = :ecflacremfd")
    , @NamedQuery(name = "OsOrdemservico.findByEcfnumeroprotecaosb", query = "SELECT o FROM OsOrdemservico o WHERE o.ecfnumeroprotecaosb = :ecfnumeroprotecaosb")
    , @NamedQuery(name = "OsOrdemservico.findByEcflacre1", query = "SELECT o FROM OsOrdemservico o WHERE o.ecflacre1 = :ecflacre1")
    , @NamedQuery(name = "OsOrdemservico.findByEcflacre2", query = "SELECT o FROM OsOrdemservico o WHERE o.ecflacre2 = :ecflacre2")
    , @NamedQuery(name = "OsOrdemservico.findByEcflacre3", query = "SELECT o FROM OsOrdemservico o WHERE o.ecflacre3 = :ecflacre3")
    , @NamedQuery(name = "OsOrdemservico.findByEcflacre4", query = "SELECT o FROM OsOrdemservico o WHERE o.ecflacre4 = :ecflacre4")
    , @NamedQuery(name = "OsOrdemservico.findByEcftipoprotecaomfd", query = "SELECT o FROM OsOrdemservico o WHERE o.ecftipoprotecaomfd = :ecftipoprotecaomfd")
    , @NamedQuery(name = "OsOrdemservico.findByEcftipofinalidade", query = "SELECT o FROM OsOrdemservico o WHERE o.ecftipofinalidade = :ecftipofinalidade")
    , @NamedQuery(name = "OsOrdemservico.findByEcftipointervencao", query = "SELECT o FROM OsOrdemservico o WHERE o.ecftipointervencao = :ecftipointervencao")
    , @NamedQuery(name = "OsOrdemservico.findByEcfcni", query = "SELECT o FROM OsOrdemservico o WHERE o.ecfcni = :ecfcni")
    , @NamedQuery(name = "OsOrdemservico.findByEcfserialmfd", query = "SELECT o FROM OsOrdemservico o WHERE o.ecfserialmfd = :ecfserialmfd")
    , @NamedQuery(name = "OsOrdemservico.findByCodmovendaprodserial", query = "SELECT o FROM OsOrdemservico o WHERE o.codmovendaprodserial = :codmovendaprodserial")
    , @NamedQuery(name = "OsOrdemservico.findByFlagimpresso", query = "SELECT o FROM OsOrdemservico o WHERE o.flagimpresso = :flagimpresso")
    , @NamedQuery(name = "OsOrdemservico.findByNumeroserieecf", query = "SELECT o FROM OsOrdemservico o WHERE o.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "OsOrdemservico.findByFlagcli", query = "SELECT o FROM OsOrdemservico o WHERE o.flagcli = :flagcli")
    , @NamedQuery(name = "OsOrdemservico.findByNomecli", query = "SELECT o FROM OsOrdemservico o WHERE o.nomecli = :nomecli")
    , @NamedQuery(name = "OsOrdemservico.findByTipoecf", query = "SELECT o FROM OsOrdemservico o WHERE o.tipoecf = :tipoecf")
    , @NamedQuery(name = "OsOrdemservico.findByMarcaecf", query = "SELECT o FROM OsOrdemservico o WHERE o.marcaecf = :marcaecf")
    , @NamedQuery(name = "OsOrdemservico.findByModeloecf", query = "SELECT o FROM OsOrdemservico o WHERE o.modeloecf = :modeloecf")
    , @NamedQuery(name = "OsOrdemservico.findByCnpjemitente", query = "SELECT o FROM OsOrdemservico o WHERE o.cnpjemitente = :cnpjemitente")
    , @NamedQuery(name = "OsOrdemservico.findByCnpjcpfcliente", query = "SELECT o FROM OsOrdemservico o WHERE o.cnpjcpfcliente = :cnpjcpfcliente")
    , @NamedQuery(name = "OsOrdemservico.findByNumerocaixa", query = "SELECT o FROM OsOrdemservico o WHERE o.numerocaixa = :numerocaixa")
    , @NamedQuery(name = "OsOrdemservico.findByValortotalos", query = "SELECT o FROM OsOrdemservico o WHERE o.valortotalos = :valortotalos")
    , @NamedQuery(name = "OsOrdemservico.findByFlagaltpaf", query = "SELECT o FROM OsOrdemservico o WHERE o.flagaltpaf = :flagaltpaf")})
public class OsOrdemservico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODOS")
    private String codos;
    @Column(name = "CODMOD")
    private String codmod;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "CODSTATUS")
    private String codstatus;
    @Column(name = "CODLE")
    private String codle;
    @Column(name = "CODTA")
    private String codta;
    @Column(name = "CODPRIORIDADE")
    private String codprioridade;
    @Column(name = "CODMOVENDA")
    private String codmovenda;
    @Column(name = "CODTEC")
    private String codtec;
    @Column(name = "CODVENDED")
    private String codvended;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "EQUIPAMENTO")
    private String equipamento;
    @Column(name = "IDENTIFICADOR")
    private String identificador;
    @Column(name = "MARCAMODELO")
    private String marcamodelo;
    @Column(name = "TIPO")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALREMESSA")
    private BigDecimal valremessa;
    @Lob
    @Column(name = "OCORRENCIA")
    private String ocorrencia;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "OSEXTERNA")
    private Integer osexterna;
    @Column(name = "CONTATO")
    private String contato;
    @Lob
    @Column(name = "SOLUCAO")
    private String solucao;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "STATUS")
    private Short status;
    @Column(name = "DATSAI")
    @Temporal(TemporalType.DATE)
    private Date datsai;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "NUMOS")
    private Integer numos;
    @Column(name = "DATSOL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datsol;
    @Column(name = "GARANTIA")
    private Integer garantia;
    @Column(name = "LACRE")
    private String lacre;
    @Column(name = "FLAGRESERVADO")
    private Character flagreservado;
    @Column(name = "FLAGEXTERNO")
    private Character flagexterno;
    @Column(name = "DATATEND")
    @Temporal(TemporalType.DATE)
    private Date datatend;
    @Column(name = "HORACHEGADA")
    @Temporal(TemporalType.TIME)
    private Date horachegada;
    @Column(name = "HORASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horasaida;
    @Column(name = "DATAAGENDA")
    @Temporal(TemporalType.DATE)
    private Date dataagenda;
    @Column(name = "HORAAGENDA")
    @Temporal(TemporalType.TIME)
    private Date horaagenda;
    @Column(name = "HORATEND")
    @Temporal(TemporalType.TIME)
    private Date horatend;
    @Column(name = "PRAZOATEND")
    private Integer prazoatend;
    @Column(name = "DATASAIDACAMPO")
    @Temporal(TemporalType.DATE)
    private Date datasaidacampo;
    @Column(name = "HORASAIDACAMPO")
    @Temporal(TemporalType.TIME)
    private Date horasaidacampo;
    @Column(name = "DATARETORNOCAMPO")
    @Temporal(TemporalType.DATE)
    private Date dataretornocampo;
    @Column(name = "HORARETORNOCAMPO")
    @Temporal(TemporalType.TIME)
    private Date horaretornocampo;
    @Column(name = "KMRODADOS")
    private Integer kmrodados;
    @Column(name = "HORAFINALAGENDA")
    @Temporal(TemporalType.TIME)
    private Date horafinalagenda;
    @Column(name = "NUMHORASATEND")
    private Short numhorasatend;
    @Column(name = "KMINICIAL")
    private Integer kminicial;
    @Column(name = "KMFINAL")
    private Integer kmfinal;
    @Column(name = "PERCDESCONTO")
    private BigDecimal percdesconto;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "NOTAFISCALENTRADA")
    private Integer notafiscalentrada;
    @Column(name = "CODMOVENDADEVOLUCAO")
    private String codmovendadevolucao;
    @Column(name = "FLAGPESQUISA")
    private Character flagpesquisa;
    @Column(name = "CODPRODGARANTIA2")
    private String codprodgarantia2;
    @Column(name = "NUMCUPOM")
    private Integer numcupom;
    @Column(name = "DATABAIXA")
    @Temporal(TemporalType.DATE)
    private Date databaixa;
    @Column(name = "CODMOVPROD")
    private String codmovprod;
    @Column(name = "CODMOVENDAGARANTIA")
    private String codmovendagarantia;
    @Column(name = "CODPRODGARANTIA")
    private String codprodgarantia;
    @Column(name = "CODUSERSOLUCAO")
    private String codusersolucao;
    @Column(name = "CODUSERVISTO")
    private String coduservisto;
    @Column(name = "FLAGVISTO")
    private Character flagvisto;
    @Column(name = "CODMOVENDAORIGEM")
    private String codmovendaorigem;
    @Column(name = "CODPRODORIGEM")
    private String codprodorigem;
    @Column(name = "NUMEROCCF")
    private Integer numeroccf;
    @Column(name = "ECFLACREMFD")
    private String ecflacremfd;
    @Column(name = "ECFNUMEROPROTECAOSB")
    private String ecfnumeroprotecaosb;
    @Column(name = "ECFLACRE1")
    private String ecflacre1;
    @Column(name = "ECFLACRE2")
    private String ecflacre2;
    @Column(name = "ECFLACRE3")
    private String ecflacre3;
    @Column(name = "ECFLACRE4")
    private String ecflacre4;
    @Column(name = "ECFTIPOPROTECAOMFD")
    private Integer ecftipoprotecaomfd;
    @Column(name = "ECFTIPOFINALIDADE")
    private Integer ecftipofinalidade;
    @Column(name = "ECFTIPOINTERVENCAO")
    private Integer ecftipointervencao;
    @Column(name = "ECFCNI")
    private String ecfcni;
    @Column(name = "ECFSERIALMFD")
    private String ecfserialmfd;
    @Column(name = "CODMOVENDAPRODSERIAL")
    private String codmovendaprodserial;
    @Column(name = "FLAGIMPRESSO")
    private Character flagimpresso;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "FLAGCLI")
    private Character flagcli;
    @Column(name = "NOMECLI")
    private String nomecli;
    @Column(name = "TIPOECF")
    private String tipoecf;
    @Column(name = "MARCAECF")
    private String marcaecf;
    @Column(name = "MODELOECF")
    private String modeloecf;
    @Column(name = "CNPJEMITENTE")
    private String cnpjemitente;
    @Column(name = "CNPJCPFCLIENTE")
    private String cnpjcpfcliente;
    @Column(name = "NUMEROCAIXA")
    private Integer numerocaixa;
    @Column(name = "VALORTOTALOS")
    private BigDecimal valortotalos;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @OneToMany(mappedBy = "codos")
    private Collection<OsLaudo> osLaudoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codos")
    private Collection<OsProdserv> osProdservCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codos")
    private Collection<OsStatushistorico> osStatushistoricoCollection;
    @OneToMany(mappedBy = "codos")
    private Collection<OsImagens> osImagensCollection;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;
    @JoinColumn(name = "CODCLIENTEENDERECO", referencedColumnName = "CODCLIENTEENDERECO")
    @ManyToOne
    private Clienteendereco codclienteendereco;
    @JoinColumn(name = "CODCLIENTEEQUIPAMENTO", referencedColumnName = "CODCLIENTEEQUIPAMENTO")
    @ManyToOne
    private Clienteequipamento codclienteequipamento;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODMOVEPROD", referencedColumnName = "CODMOVEPROD")
    @ManyToOne
    private Moventradaprod codmoveprod;
    @JoinColumn(name = "CODPRECO", referencedColumnName = "CODPRECO")
    @ManyToOne
    private Preco codpreco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codos")
    private Collection<OsPesquisa> osPesquisaCollection;
    @OneToMany(mappedBy = "codos")
    private Collection<Orcamento> orcamentoCollection;

    public OsOrdemservico() {
    }

    public OsOrdemservico(String codos) {
        this.codos = codos;
    }

    public String getCodos() {
        return codos;
    }

    public void setCodos(String codos) {
        this.codos = codos;
    }

    public String getCodmod() {
        return codmod;
    }

    public void setCodmod(String codmod) {
        this.codmod = codmod;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public String getCodstatus() {
        return codstatus;
    }

    public void setCodstatus(String codstatus) {
        this.codstatus = codstatus;
    }

    public String getCodle() {
        return codle;
    }

    public void setCodle(String codle) {
        this.codle = codle;
    }

    public String getCodta() {
        return codta;
    }

    public void setCodta(String codta) {
        this.codta = codta;
    }

    public String getCodprioridade() {
        return codprioridade;
    }

    public void setCodprioridade(String codprioridade) {
        this.codprioridade = codprioridade;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    public String getCodtec() {
        return codtec;
    }

    public void setCodtec(String codtec) {
        this.codtec = codtec;
    }

    public String getCodvended() {
        return codvended;
    }

    public void setCodvended(String codvended) {
        this.codvended = codvended;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValremessa() {
        return valremessa;
    }

    public void setValremessa(BigDecimal valremessa) {
        this.valremessa = valremessa;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getOsexterna() {
        return osexterna;
    }

    public void setOsexterna(Integer osexterna) {
        this.osexterna = osexterna;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Date getDatsai() {
        return datsai;
    }

    public void setDatsai(Date datsai) {
        this.datsai = datsai;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNumos() {
        return numos;
    }

    public void setNumos(Integer numos) {
        this.numos = numos;
    }

    public Date getDatsol() {
        return datsol;
    }

    public void setDatsol(Date datsol) {
        this.datsol = datsol;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }

    public String getLacre() {
        return lacre;
    }

    public void setLacre(String lacre) {
        this.lacre = lacre;
    }

    public Character getFlagreservado() {
        return flagreservado;
    }

    public void setFlagreservado(Character flagreservado) {
        this.flagreservado = flagreservado;
    }

    public Character getFlagexterno() {
        return flagexterno;
    }

    public void setFlagexterno(Character flagexterno) {
        this.flagexterno = flagexterno;
    }

    public Date getDatatend() {
        return datatend;
    }

    public void setDatatend(Date datatend) {
        this.datatend = datatend;
    }

    public Date getHorachegada() {
        return horachegada;
    }

    public void setHorachegada(Date horachegada) {
        this.horachegada = horachegada;
    }

    public Date getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(Date horasaida) {
        this.horasaida = horasaida;
    }

    public Date getDataagenda() {
        return dataagenda;
    }

    public void setDataagenda(Date dataagenda) {
        this.dataagenda = dataagenda;
    }

    public Date getHoraagenda() {
        return horaagenda;
    }

    public void setHoraagenda(Date horaagenda) {
        this.horaagenda = horaagenda;
    }

    public Date getHoratend() {
        return horatend;
    }

    public void setHoratend(Date horatend) {
        this.horatend = horatend;
    }

    public Integer getPrazoatend() {
        return prazoatend;
    }

    public void setPrazoatend(Integer prazoatend) {
        this.prazoatend = prazoatend;
    }

    public Date getDatasaidacampo() {
        return datasaidacampo;
    }

    public void setDatasaidacampo(Date datasaidacampo) {
        this.datasaidacampo = datasaidacampo;
    }

    public Date getHorasaidacampo() {
        return horasaidacampo;
    }

    public void setHorasaidacampo(Date horasaidacampo) {
        this.horasaidacampo = horasaidacampo;
    }

    public Date getDataretornocampo() {
        return dataretornocampo;
    }

    public void setDataretornocampo(Date dataretornocampo) {
        this.dataretornocampo = dataretornocampo;
    }

    public Date getHoraretornocampo() {
        return horaretornocampo;
    }

    public void setHoraretornocampo(Date horaretornocampo) {
        this.horaretornocampo = horaretornocampo;
    }

    public Integer getKmrodados() {
        return kmrodados;
    }

    public void setKmrodados(Integer kmrodados) {
        this.kmrodados = kmrodados;
    }

    public Date getHorafinalagenda() {
        return horafinalagenda;
    }

    public void setHorafinalagenda(Date horafinalagenda) {
        this.horafinalagenda = horafinalagenda;
    }

    public Short getNumhorasatend() {
        return numhorasatend;
    }

    public void setNumhorasatend(Short numhorasatend) {
        this.numhorasatend = numhorasatend;
    }

    public Integer getKminicial() {
        return kminicial;
    }

    public void setKminicial(Integer kminicial) {
        this.kminicial = kminicial;
    }

    public Integer getKmfinal() {
        return kmfinal;
    }

    public void setKmfinal(Integer kmfinal) {
        this.kmfinal = kmfinal;
    }

    public BigDecimal getPercdesconto() {
        return percdesconto;
    }

    public void setPercdesconto(BigDecimal percdesconto) {
        this.percdesconto = percdesconto;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Integer getNotafiscalentrada() {
        return notafiscalentrada;
    }

    public void setNotafiscalentrada(Integer notafiscalentrada) {
        this.notafiscalentrada = notafiscalentrada;
    }

    public String getCodmovendadevolucao() {
        return codmovendadevolucao;
    }

    public void setCodmovendadevolucao(String codmovendadevolucao) {
        this.codmovendadevolucao = codmovendadevolucao;
    }

    public Character getFlagpesquisa() {
        return flagpesquisa;
    }

    public void setFlagpesquisa(Character flagpesquisa) {
        this.flagpesquisa = flagpesquisa;
    }

    public String getCodprodgarantia2() {
        return codprodgarantia2;
    }

    public void setCodprodgarantia2(String codprodgarantia2) {
        this.codprodgarantia2 = codprodgarantia2;
    }

    public Integer getNumcupom() {
        return numcupom;
    }

    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    public Date getDatabaixa() {
        return databaixa;
    }

    public void setDatabaixa(Date databaixa) {
        this.databaixa = databaixa;
    }

    public String getCodmovprod() {
        return codmovprod;
    }

    public void setCodmovprod(String codmovprod) {
        this.codmovprod = codmovprod;
    }

    public String getCodmovendagarantia() {
        return codmovendagarantia;
    }

    public void setCodmovendagarantia(String codmovendagarantia) {
        this.codmovendagarantia = codmovendagarantia;
    }

    public String getCodprodgarantia() {
        return codprodgarantia;
    }

    public void setCodprodgarantia(String codprodgarantia) {
        this.codprodgarantia = codprodgarantia;
    }

    public String getCodusersolucao() {
        return codusersolucao;
    }

    public void setCodusersolucao(String codusersolucao) {
        this.codusersolucao = codusersolucao;
    }

    public String getCoduservisto() {
        return coduservisto;
    }

    public void setCoduservisto(String coduservisto) {
        this.coduservisto = coduservisto;
    }

    public Character getFlagvisto() {
        return flagvisto;
    }

    public void setFlagvisto(Character flagvisto) {
        this.flagvisto = flagvisto;
    }

    public String getCodmovendaorigem() {
        return codmovendaorigem;
    }

    public void setCodmovendaorigem(String codmovendaorigem) {
        this.codmovendaorigem = codmovendaorigem;
    }

    public String getCodprodorigem() {
        return codprodorigem;
    }

    public void setCodprodorigem(String codprodorigem) {
        this.codprodorigem = codprodorigem;
    }

    public Integer getNumeroccf() {
        return numeroccf;
    }

    public void setNumeroccf(Integer numeroccf) {
        this.numeroccf = numeroccf;
    }

    public String getEcflacremfd() {
        return ecflacremfd;
    }

    public void setEcflacremfd(String ecflacremfd) {
        this.ecflacremfd = ecflacremfd;
    }

    public String getEcfnumeroprotecaosb() {
        return ecfnumeroprotecaosb;
    }

    public void setEcfnumeroprotecaosb(String ecfnumeroprotecaosb) {
        this.ecfnumeroprotecaosb = ecfnumeroprotecaosb;
    }

    public String getEcflacre1() {
        return ecflacre1;
    }

    public void setEcflacre1(String ecflacre1) {
        this.ecflacre1 = ecflacre1;
    }

    public String getEcflacre2() {
        return ecflacre2;
    }

    public void setEcflacre2(String ecflacre2) {
        this.ecflacre2 = ecflacre2;
    }

    public String getEcflacre3() {
        return ecflacre3;
    }

    public void setEcflacre3(String ecflacre3) {
        this.ecflacre3 = ecflacre3;
    }

    public String getEcflacre4() {
        return ecflacre4;
    }

    public void setEcflacre4(String ecflacre4) {
        this.ecflacre4 = ecflacre4;
    }

    public Integer getEcftipoprotecaomfd() {
        return ecftipoprotecaomfd;
    }

    public void setEcftipoprotecaomfd(Integer ecftipoprotecaomfd) {
        this.ecftipoprotecaomfd = ecftipoprotecaomfd;
    }

    public Integer getEcftipofinalidade() {
        return ecftipofinalidade;
    }

    public void setEcftipofinalidade(Integer ecftipofinalidade) {
        this.ecftipofinalidade = ecftipofinalidade;
    }

    public Integer getEcftipointervencao() {
        return ecftipointervencao;
    }

    public void setEcftipointervencao(Integer ecftipointervencao) {
        this.ecftipointervencao = ecftipointervencao;
    }

    public String getEcfcni() {
        return ecfcni;
    }

    public void setEcfcni(String ecfcni) {
        this.ecfcni = ecfcni;
    }

    public String getEcfserialmfd() {
        return ecfserialmfd;
    }

    public void setEcfserialmfd(String ecfserialmfd) {
        this.ecfserialmfd = ecfserialmfd;
    }

    public String getCodmovendaprodserial() {
        return codmovendaprodserial;
    }

    public void setCodmovendaprodserial(String codmovendaprodserial) {
        this.codmovendaprodserial = codmovendaprodserial;
    }

    public Character getFlagimpresso() {
        return flagimpresso;
    }

    public void setFlagimpresso(Character flagimpresso) {
        this.flagimpresso = flagimpresso;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
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

    public String getTipoecf() {
        return tipoecf;
    }

    public void setTipoecf(String tipoecf) {
        this.tipoecf = tipoecf;
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

    public BigDecimal getValortotalos() {
        return valortotalos;
    }

    public void setValortotalos(BigDecimal valortotalos) {
        this.valortotalos = valortotalos;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    @XmlTransient
    public Collection<OsLaudo> getOsLaudoCollection() {
        return osLaudoCollection;
    }

    public void setOsLaudoCollection(Collection<OsLaudo> osLaudoCollection) {
        this.osLaudoCollection = osLaudoCollection;
    }

    @XmlTransient
    public Collection<OsProdserv> getOsProdservCollection() {
        return osProdservCollection;
    }

    public void setOsProdservCollection(Collection<OsProdserv> osProdservCollection) {
        this.osProdservCollection = osProdservCollection;
    }

    @XmlTransient
    public Collection<OsStatushistorico> getOsStatushistoricoCollection() {
        return osStatushistoricoCollection;
    }

    public void setOsStatushistoricoCollection(Collection<OsStatushistorico> osStatushistoricoCollection) {
        this.osStatushistoricoCollection = osStatushistoricoCollection;
    }

    @XmlTransient
    public Collection<OsImagens> getOsImagensCollection() {
        return osImagensCollection;
    }

    public void setOsImagensCollection(Collection<OsImagens> osImagensCollection) {
        this.osImagensCollection = osImagensCollection;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    public Clienteendereco getCodclienteendereco() {
        return codclienteendereco;
    }

    public void setCodclienteendereco(Clienteendereco codclienteendereco) {
        this.codclienteendereco = codclienteendereco;
    }

    public Clienteequipamento getCodclienteequipamento() {
        return codclienteequipamento;
    }

    public void setCodclienteequipamento(Clienteequipamento codclienteequipamento) {
        this.codclienteequipamento = codclienteequipamento;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Moventradaprod getCodmoveprod() {
        return codmoveprod;
    }

    public void setCodmoveprod(Moventradaprod codmoveprod) {
        this.codmoveprod = codmoveprod;
    }

    public Preco getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(Preco codpreco) {
        this.codpreco = codpreco;
    }

    @XmlTransient
    public Collection<OsPesquisa> getOsPesquisaCollection() {
        return osPesquisaCollection;
    }

    public void setOsPesquisaCollection(Collection<OsPesquisa> osPesquisaCollection) {
        this.osPesquisaCollection = osPesquisaCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codos != null ? codos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsOrdemservico)) {
            return false;
        }
        OsOrdemservico other = (OsOrdemservico) object;
        if ((this.codos == null && other.codos != null) || (this.codos != null && !this.codos.equals(other.codos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsOrdemservico[ codos=" + codos + " ]";
    }
    
}
