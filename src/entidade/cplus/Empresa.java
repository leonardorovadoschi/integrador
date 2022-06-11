/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "EMPRESA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByCodempresa", query = "SELECT e FROM Empresa e WHERE e.codempresa = :codempresa")
    , @NamedQuery(name = "Empresa.findByNomeempresa", query = "SELECT e FROM Empresa e WHERE e.nomeempresa = :nomeempresa")
    , @NamedQuery(name = "Empresa.findByEndereco", query = "SELECT e FROM Empresa e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Empresa.findByBairro", query = "SELECT e FROM Empresa e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Empresa.findByCidade", query = "SELECT e FROM Empresa e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")
    , @NamedQuery(name = "Empresa.findByCep", query = "SELECT e FROM Empresa e WHERE e.cep = :cep")
    , @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "Empresa.findByFax", query = "SELECT e FROM Empresa e WHERE e.fax = :fax")
    , @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Empresa.findByUsaecf", query = "SELECT e FROM Empresa e WHERE e.usaecf = :usaecf")
    , @NamedQuery(name = "Empresa.findByInativa", query = "SELECT e FROM Empresa e WHERE e.inativa = :inativa")
    , @NamedQuery(name = "Empresa.findByNumnota", query = "SELECT e FROM Empresa e WHERE e.numnota = :numnota")
    , @NamedQuery(name = "Empresa.findByInscricaoestadual", query = "SELECT e FROM Empresa e WHERE e.inscricaoestadual = :inscricaoestadual")
    , @NamedQuery(name = "Empresa.findByInscricaomunicipal", query = "SELECT e FROM Empresa e WHERE e.inscricaomunicipal = :inscricaomunicipal")
    , @NamedQuery(name = "Empresa.findByModelonota", query = "SELECT e FROM Empresa e WHERE e.modelonota = :modelonota")
    , @NamedQuery(name = "Empresa.findBySerienf", query = "SELECT e FROM Empresa e WHERE e.serienf = :serienf")
    , @NamedQuery(name = "Empresa.findByEspecienf", query = "SELECT e FROM Empresa e WHERE e.especienf = :especienf")
    , @NamedQuery(name = "Empresa.findByIdlayoutnf", query = "SELECT e FROM Empresa e WHERE e.idlayoutnf = :idlayoutnf")
    , @NamedQuery(name = "Empresa.findByQtdeitensnotafiscal", query = "SELECT e FROM Empresa e WHERE e.qtdeitensnotafiscal = :qtdeitensnotafiscal")
    , @NamedQuery(name = "Empresa.findByFlagimpnotaautomatico", query = "SELECT e FROM Empresa e WHERE e.flagimpnotaautomatico = :flagimpnotaautomatico")
    , @NamedQuery(name = "Empresa.findByNomefantasia", query = "SELECT e FROM Empresa e WHERE e.nomefantasia = :nomefantasia")
    , @NamedQuery(name = "Empresa.findByNumnfe", query = "SELECT e FROM Empresa e WHERE e.numnfe = :numnfe")
    , @NamedQuery(name = "Empresa.findBySerienfe", query = "SELECT e FROM Empresa e WHERE e.serienfe = :serienfe")
    , @NamedQuery(name = "Empresa.findByIdlayoutdanfe", query = "SELECT e FROM Empresa e WHERE e.idlayoutdanfe = :idlayoutdanfe")
    , @NamedQuery(name = "Empresa.findByIdlayoutcomprovante", query = "SELECT e FROM Empresa e WHERE e.idlayoutcomprovante = :idlayoutcomprovante")
    , @NamedQuery(name = "Empresa.findByIdlayoutorcamento", query = "SELECT e FROM Empresa e WHERE e.idlayoutorcamento = :idlayoutorcamento")
    , @NamedQuery(name = "Empresa.findByIdlayoutnfentrada", query = "SELECT e FROM Empresa e WHERE e.idlayoutnfentrada = :idlayoutnfentrada")
    , @NamedQuery(name = "Empresa.findByPerfilsped", query = "SELECT e FROM Empresa e WHERE e.perfilsped = :perfilsped")
    , @NamedQuery(name = "Empresa.findByTipoatividade", query = "SELECT e FROM Empresa e WHERE e.tipoatividade = :tipoatividade")
    , @NamedQuery(name = "Empresa.findByFlagapuraipi", query = "SELECT e FROM Empresa e WHERE e.flagapuraipi = :flagapuraipi")
    , @NamedQuery(name = "Empresa.findByCodpessoacontador", query = "SELECT e FROM Empresa e WHERE e.codpessoacontador = :codpessoacontador")
    , @NamedQuery(name = "Empresa.findByAliqcreditosimplesnacional", query = "SELECT e FROM Empresa e WHERE e.aliqcreditosimplesnacional = :aliqcreditosimplesnacional")
    , @NamedQuery(name = "Empresa.findByFlagsimplesnacional", query = "SELECT e FROM Empresa e WHERE e.flagsimplesnacional = :flagsimplesnacional")
    , @NamedQuery(name = "Empresa.findByLotenfse", query = "SELECT e FROM Empresa e WHERE e.lotenfse = :lotenfse")
    , @NamedQuery(name = "Empresa.findByFlagregimeespecialtributacao", query = "SELECT e FROM Empresa e WHERE e.flagregimeespecialtributacao = :flagregimeespecialtributacao")
    , @NamedQuery(name = "Empresa.findByFlagcrt", query = "SELECT e FROM Empresa e WHERE e.flagcrt = :flagcrt")
    , @NamedQuery(name = "Empresa.findByCnae", query = "SELECT e FROM Empresa e WHERE e.cnae = :cnae")
    , @NamedQuery(name = "Empresa.findByNumerologradouro", query = "SELECT e FROM Empresa e WHERE e.numerologradouro = :numerologradouro")
    , @NamedQuery(name = "Empresa.findByComplementologradouro", query = "SELECT e FROM Empresa e WHERE e.complementologradouro = :complementologradouro")
    , @NamedQuery(name = "Empresa.findByNomeresponsavel", query = "SELECT e FROM Empresa e WHERE e.nomeresponsavel = :nomeresponsavel")
    , @NamedQuery(name = "Empresa.findByMetames01", query = "SELECT e FROM Empresa e WHERE e.metames01 = :metames01")
    , @NamedQuery(name = "Empresa.findByMetames02", query = "SELECT e FROM Empresa e WHERE e.metames02 = :metames02")
    , @NamedQuery(name = "Empresa.findByMetames03", query = "SELECT e FROM Empresa e WHERE e.metames03 = :metames03")
    , @NamedQuery(name = "Empresa.findByMetames04", query = "SELECT e FROM Empresa e WHERE e.metames04 = :metames04")
    , @NamedQuery(name = "Empresa.findByMetames05", query = "SELECT e FROM Empresa e WHERE e.metames05 = :metames05")
    , @NamedQuery(name = "Empresa.findByMetames06", query = "SELECT e FROM Empresa e WHERE e.metames06 = :metames06")
    , @NamedQuery(name = "Empresa.findByMetames07", query = "SELECT e FROM Empresa e WHERE e.metames07 = :metames07")
    , @NamedQuery(name = "Empresa.findByMetames08", query = "SELECT e FROM Empresa e WHERE e.metames08 = :metames08")
    , @NamedQuery(name = "Empresa.findByMetames09", query = "SELECT e FROM Empresa e WHERE e.metames09 = :metames09")
    , @NamedQuery(name = "Empresa.findByMetames10", query = "SELECT e FROM Empresa e WHERE e.metames10 = :metames10")
    , @NamedQuery(name = "Empresa.findByMetames11", query = "SELECT e FROM Empresa e WHERE e.metames11 = :metames11")
    , @NamedQuery(name = "Empresa.findByMetames12", query = "SELECT e FROM Empresa e WHERE e.metames12 = :metames12")
    , @NamedQuery(name = "Empresa.findByCodigointegracaofiscal", query = "SELECT e FROM Empresa e WHERE e.codigointegracaofiscal = :codigointegracaofiscal")
    , @NamedQuery(name = "Empresa.findByDiretoriocplusnfe", query = "SELECT e FROM Empresa e WHERE e.diretoriocplusnfe = :diretoriocplusnfe")
    , @NamedQuery(name = "Empresa.findByIdlayoutorcamentooffline", query = "SELECT e FROM Empresa e WHERE e.idlayoutorcamentooffline = :idlayoutorcamentooffline")
    , @NamedQuery(name = "Empresa.findByIdlayoutorcamentoemail", query = "SELECT e FROM Empresa e WHERE e.idlayoutorcamentoemail = :idlayoutorcamentoemail")
    , @NamedQuery(name = "Empresa.findByNumnfescan", query = "SELECT e FROM Empresa e WHERE e.numnfescan = :numnfescan")
    , @NamedQuery(name = "Empresa.findBySerienfescan", query = "SELECT e FROM Empresa e WHERE e.serienfescan = :serienfescan")
    , @NamedQuery(name = "Empresa.findBySeqconhecimento", query = "SELECT e FROM Empresa e WHERE e.seqconhecimento = :seqconhecimento")
    , @NamedQuery(name = "Empresa.findByIdlayoutnfservico", query = "SELECT e FROM Empresa e WHERE e.idlayoutnfservico = :idlayoutnfservico")
    , @NamedQuery(name = "Empresa.findByNumnotaservico", query = "SELECT e FROM Empresa e WHERE e.numnotaservico = :numnotaservico")
    , @NamedQuery(name = "Empresa.findBySerienfservico", query = "SELECT e FROM Empresa e WHERE e.serienfservico = :serienfservico")
    , @NamedQuery(name = "Empresa.findByFlagnfservico", query = "SELECT e FROM Empresa e WHERE e.flagnfservico = :flagnfservico")
    , @NamedQuery(name = "Empresa.findByModelonotaservico", query = "SELECT e FROM Empresa e WHERE e.modelonotaservico = :modelonotaservico")
    , @NamedQuery(name = "Empresa.findByIdlayoutcomprovanteemail", query = "SELECT e FROM Empresa e WHERE e.idlayoutcomprovanteemail = :idlayoutcomprovanteemail")
    , @NamedQuery(name = "Empresa.findByEmail", query = "SELECT e FROM Empresa e WHERE e.email = :email")
    , @NamedQuery(name = "Empresa.findByWebsite", query = "SELECT e FROM Empresa e WHERE e.website = :website")
    , @NamedQuery(name = "Empresa.findByCodterminalintegracao", query = "SELECT e FROM Empresa e WHERE e.codterminalintegracao = :codterminalintegracao")
    , @NamedQuery(name = "Empresa.findByArquivosexportacao", query = "SELECT e FROM Empresa e WHERE e.arquivosexportacao = :arquivosexportacao")
    , @NamedQuery(name = "Empresa.findByArquivosimportacao", query = "SELECT e FROM Empresa e WHERE e.arquivosimportacao = :arquivosimportacao")
    , @NamedQuery(name = "Empresa.findByCodprecoecf", query = "SELECT e FROM Empresa e WHERE e.codprecoecf = :codprecoecf")
    , @NamedQuery(name = "Empresa.findByGuid", query = "SELECT e FROM Empresa e WHERE e.guid = :guid")
    , @NamedQuery(name = "Empresa.findByFlagsempregeranovolote", query = "SELECT e FROM Empresa e WHERE e.flagsempregeranovolote = :flagsempregeranovolote")
    , @NamedQuery(name = "Empresa.findByIdlayoutcce", query = "SELECT e FROM Empresa e WHERE e.idlayoutcce = :idlayoutcce")
    , @NamedQuery(name = "Empresa.findByIdtoken", query = "SELECT e FROM Empresa e WHERE e.idtoken = :idtoken")
    , @NamedQuery(name = "Empresa.findByToken", query = "SELECT e FROM Empresa e WHERE e.token = :token")
    , @NamedQuery(name = "Empresa.findByFlaghorarioverao", query = "SELECT e FROM Empresa e WHERE e.flaghorarioverao = :flaghorarioverao")
    , @NamedQuery(name = "Empresa.findByFlagfusohorario", query = "SELECT e FROM Empresa e WHERE e.flagfusohorario = :flagfusohorario")
    , @NamedQuery(name = "Empresa.findByNfceservidorsmtp", query = "SELECT e FROM Empresa e WHERE e.nfceservidorsmtp = :nfceservidorsmtp")
    , @NamedQuery(name = "Empresa.findByNfceemailporta", query = "SELECT e FROM Empresa e WHERE e.nfceemailporta = :nfceemailporta")
    , @NamedQuery(name = "Empresa.findByNfceemaillogin", query = "SELECT e FROM Empresa e WHERE e.nfceemaillogin = :nfceemaillogin")
    , @NamedQuery(name = "Empresa.findByNfceemailsenha", query = "SELECT e FROM Empresa e WHERE e.nfceemailsenha = :nfceemailsenha")
    , @NamedQuery(name = "Empresa.findByNfceemailtimeout", query = "SELECT e FROM Empresa e WHERE e.nfceemailtimeout = :nfceemailtimeout")
    , @NamedQuery(name = "Empresa.findByNfceemailautenticacao", query = "SELECT e FROM Empresa e WHERE e.nfceemailautenticacao = :nfceemailautenticacao")
    , @NamedQuery(name = "Empresa.findByNfceemailremetente", query = "SELECT e FROM Empresa e WHERE e.nfceemailremetente = :nfceemailremetente")
    , @NamedQuery(name = "Empresa.findByNfceemailcomcopia", query = "SELECT e FROM Empresa e WHERE e.nfceemailcomcopia = :nfceemailcomcopia")
    , @NamedQuery(name = "Empresa.findByNfceemailcomcopiaoculta", query = "SELECT e FROM Empresa e WHERE e.nfceemailcomcopiaoculta = :nfceemailcomcopiaoculta")
    , @NamedQuery(name = "Empresa.findByNfceemailassunto", query = "SELECT e FROM Empresa e WHERE e.nfceemailassunto = :nfceemailassunto")
    , @NamedQuery(name = "Empresa.findByLotenfce", query = "SELECT e FROM Empresa e WHERE e.lotenfce = :lotenfce")
    , @NamedQuery(name = "Empresa.findByCodigomunicipioibge", query = "SELECT e FROM Empresa e WHERE e.codigomunicipioibge = :codigomunicipioibge")
    , @NamedQuery(name = "Empresa.findByNfcecpfautorizado", query = "SELECT e FROM Empresa e WHERE e.nfcecpfautorizado = :nfcecpfautorizado")
    , @NamedQuery(name = "Empresa.findByNfcecnpjautorizado", query = "SELECT e FROM Empresa e WHERE e.nfcecnpjautorizado = :nfcecnpjautorizado")
    , @NamedQuery(name = "Empresa.findByFlagfilial", query = "SELECT e FROM Empresa e WHERE e.flagfilial = :flagfilial")
    , @NamedQuery(name = "Empresa.findByHashcodesat", query = "SELECT e FROM Empresa e WHERE e.hashcodesat = :hashcodesat")
    , @NamedQuery(name = "Empresa.findByIssrateadosat", query = "SELECT e FROM Empresa e WHERE e.issrateadosat = :issrateadosat")
    , @NamedQuery(name = "Empresa.findByFlagtrataserviconfce", query = "SELECT e FROM Empresa e WHERE e.flagtrataserviconfce = :flagtrataserviconfce")
    , @NamedQuery(name = "Empresa.findByCodcfoppdv", query = "SELECT e FROM Empresa e WHERE e.codcfoppdv = :codcfoppdv")
    , @NamedQuery(name = "Empresa.findByProximodav", query = "SELECT e FROM Empresa e WHERE e.proximodav = :proximodav")
    , @NamedQuery(name = "Empresa.findByProximodavos", query = "SELECT e FROM Empresa e WHERE e.proximodavos = :proximodavos")
    , @NamedQuery(name = "Empresa.findByProximaprevenda", query = "SELECT e FROM Empresa e WHERE e.proximaprevenda = :proximaprevenda")
    , @NamedQuery(name = "Empresa.findByMensagemfinalpdv", query = "SELECT e FROM Empresa e WHERE e.mensagemfinalpdv = :mensagemfinalpdv")
    , @NamedQuery(name = "Empresa.findByNfceemailconteudohtml", query = "SELECT e FROM Empresa e WHERE e.nfceemailconteudohtml = :nfceemailconteudohtml")
    , @NamedQuery(name = "Empresa.findByMfeChavevalidador", query = "SELECT e FROM Empresa e WHERE e.mfeChavevalidador = :mfeChavevalidador")
    , @NamedQuery(name = "Empresa.findByFlagcontribuinteipi", query = "SELECT e FROM Empresa e WHERE e.flagcontribuinteipi = :flagcontribuinteipi")
    , @NamedQuery(name = "Empresa.findByFlagsaidaconjugada", query = "SELECT e FROM Empresa e WHERE e.flagsaidaconjugada = :flagsaidaconjugada")
    , @NamedQuery(name = "Empresa.findByFlagintegracartaonfe", query = "SELECT e FROM Empresa e WHERE e.flagintegracartaonfe = :flagintegracartaonfe")
    , @NamedQuery(name = "Empresa.findByNumerocredenciamentopafecf", query = "SELECT e FROM Empresa e WHERE e.numerocredenciamentopafecf = :numerocredenciamentopafecf")
    , @NamedQuery(name = "Empresa.findByFlagserieofflinenfce", query = "SELECT e FROM Empresa e WHERE e.flagserieofflinenfce = :flagserieofflinenfce")
    , @NamedQuery(name = "Empresa.findByFlaggerahashcrst", query = "SELECT e FROM Empresa e WHERE e.flaggerahashcrst = :flaggerahashcrst")
    , @NamedQuery(name = "Empresa.findByFlaggerahashcrstnfce", query = "SELECT e FROM Empresa e WHERE e.flaggerahashcrstnfce = :flaggerahashcrstnfce")
    , @NamedQuery(name = "Empresa.findByFlagaltpaf", query = "SELECT e FROM Empresa e WHERE e.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Empresa.findByTipoatividadeindustrial", query = "SELECT e FROM Empresa e WHERE e.tipoatividadeindustrial = :tipoatividadeindustrial")})
public class Empresa implements Serializable {

    @Lob
    @Column(name = "LOGO")
    private byte[] logo;
    @Lob
    @Column(name = "LOGOTIPO")
    private byte[] logotipo;
    @Lob
    @Column(name = "LOGONFE")
    private byte[] logonfe;
    @Lob
    @Column(name = "LOGONFSE")
    private byte[] logonfse;
    @Lob
    @Column(name = "LOGONFCE")
    private byte[] logonfce;
    @Lob
    @Column(name = "LOGOCFESAT")
    private byte[] logocfesat;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "NOMEEMPRESA")
    private String nomeempresa;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "CNPJ")
    private String cnpj;
    @Column(name = "USAECF")
    private Character usaecf;
    @Column(name = "INATIVA")
    private Character inativa;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "INSCRICAOESTADUAL")
    private String inscricaoestadual;
    @Column(name = "INSCRICAOMUNICIPAL")
    private String inscricaomunicipal;
    @Column(name = "MODELONOTA")
    private String modelonota;
    @Column(name = "SERIENF")
    private String serienf;
    @Column(name = "ESPECIENF")
    private String especienf;
    @Column(name = "IDLAYOUTNF")
    private String idlayoutnf;
    @Lob
    @Column(name = "OBSCOMPROVANTE")
    private String obscomprovante;
    @Lob
    @Column(name = "RODAPECOMPROVANTE")
    private String rodapecomprovante;
    @Lob
    @Column(name = "CABECALHOCOMPROVANTE")
    private String cabecalhocomprovante;
    @Column(name = "QTDEITENSNOTAFISCAL")
    private Integer qtdeitensnotafiscal;
    @Column(name = "FLAGIMPNOTAAUTOMATICO")
    private Character flagimpnotaautomatico;
    @Column(name = "NOMEFANTASIA")
    private String nomefantasia;
    @Column(name = "NUMNFE")
    private Integer numnfe;
    @Column(name = "SERIENFE")
    private String serienfe;
    @Column(name = "IDLAYOUTDANFE")
    private String idlayoutdanfe;
    @Column(name = "IDLAYOUTCOMPROVANTE")
    private String idlayoutcomprovante;
    @Column(name = "IDLAYOUTORCAMENTO")
    private String idlayoutorcamento;
    @Column(name = "IDLAYOUTNFENTRADA")
    private String idlayoutnfentrada;
    @Lob
    @Column(name = "CABECALHOORCAMENTO")
    private String cabecalhoorcamento;
    @Lob
    @Column(name = "RODAPEORCAMENTO")
    private String rodapeorcamento;
    @Lob
    @Column(name = "OBSORCAMENTO")
    private String obsorcamento;
    @Column(name = "PERFILSPED")
    private Character perfilsped;
    @Column(name = "TIPOATIVIDADE")
    private Character tipoatividade;
    @Column(name = "FLAGAPURAIPI")
    private Character flagapuraipi;
    @Column(name = "CODPESSOACONTADOR")
    private String codpessoacontador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQCREDITOSIMPLESNACIONAL")
    private BigDecimal aliqcreditosimplesnacional;
    @Column(name = "FLAGSIMPLESNACIONAL")
    private Character flagsimplesnacional;
    @Column(name = "LOTENFSE")
    private BigInteger lotenfse;
    @Column(name = "FLAGREGIMEESPECIALTRIBUTACAO")
    private Character flagregimeespecialtributacao;
    @Column(name = "FLAGCRT")
    private Character flagcrt;
    @Column(name = "CNAE")
    private String cnae;
    @Column(name = "NUMEROLOGRADOURO")
    private String numerologradouro;
    @Column(name = "COMPLEMENTOLOGRADOURO")
    private String complementologradouro;
    @Column(name = "NOMERESPONSAVEL")
    private String nomeresponsavel;
    @Column(name = "METAMES01")
    private BigDecimal metames01;
    @Column(name = "METAMES02")
    private BigDecimal metames02;
    @Column(name = "METAMES03")
    private BigDecimal metames03;
    @Column(name = "METAMES04")
    private BigDecimal metames04;
    @Column(name = "METAMES05")
    private BigDecimal metames05;
    @Column(name = "METAMES06")
    private BigDecimal metames06;
    @Column(name = "METAMES07")
    private BigDecimal metames07;
    @Column(name = "METAMES08")
    private BigDecimal metames08;
    @Column(name = "METAMES09")
    private BigDecimal metames09;
    @Column(name = "METAMES10")
    private BigDecimal metames10;
    @Column(name = "METAMES11")
    private BigDecimal metames11;
    @Column(name = "METAMES12")
    private BigDecimal metames12;
    @Column(name = "CODIGOINTEGRACAOFISCAL")
    private String codigointegracaofiscal;
    @Column(name = "DIRETORIOCPLUSNFE")
    private String diretoriocplusnfe;
    @Column(name = "IDLAYOUTORCAMENTOOFFLINE")
    private String idlayoutorcamentooffline;
    @Column(name = "IDLAYOUTORCAMENTOEMAIL")
    private String idlayoutorcamentoemail;
    @Column(name = "NUMNFESCAN")
    private Integer numnfescan;
    @Column(name = "SERIENFESCAN")
    private String serienfescan;
    @Column(name = "SEQCONHECIMENTO")
    private Integer seqconhecimento;
    @Column(name = "IDLAYOUTNFSERVICO")
    private String idlayoutnfservico;
    @Column(name = "NUMNOTASERVICO")
    private Integer numnotaservico;
    @Column(name = "SERIENFSERVICO")
    private String serienfservico;
    @Column(name = "FLAGNFSERVICO")
    private Character flagnfservico;
    @Column(name = "MODELONOTASERVICO")
    private String modelonotaservico;
    @Column(name = "IDLAYOUTCOMPROVANTEEMAIL")
    private String idlayoutcomprovanteemail;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "CODTERMINALINTEGRACAO")
    private String codterminalintegracao;
    @Column(name = "ARQUIVOSEXPORTACAO")
    private String arquivosexportacao;
    @Column(name = "ARQUIVOSIMPORTACAO")
    private String arquivosimportacao;
    @Column(name = "CODPRECOECF")
    private String codprecoecf;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGSEMPREGERANOVOLOTE")
    private Character flagsempregeranovolote;
    @Column(name = "IDLAYOUTCCE")
    private String idlayoutcce;
    @Column(name = "IDTOKEN")
    private String idtoken;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "FLAGHORARIOVERAO")
    private Character flaghorarioverao;
    @Column(name = "FLAGFUSOHORARIO")
    private Character flagfusohorario;
    @Column(name = "NFCESERVIDORSMTP")
    private String nfceservidorsmtp;
    @Column(name = "NFCEEMAILPORTA")
    private Integer nfceemailporta;
    @Column(name = "NFCEEMAILLOGIN")
    private String nfceemaillogin;
    @Column(name = "NFCEEMAILSENHA")
    private String nfceemailsenha;
    @Column(name = "NFCEEMAILTIMEOUT")
    private Integer nfceemailtimeout;
    @Column(name = "NFCEEMAILAUTENTICACAO")
    private Character nfceemailautenticacao;
    @Column(name = "NFCEEMAILREMETENTE")
    private String nfceemailremetente;
    @Column(name = "NFCEEMAILCOMCOPIA")
    private String nfceemailcomcopia;
    @Column(name = "NFCEEMAILCOMCOPIAOCULTA")
    private String nfceemailcomcopiaoculta;
    @Column(name = "NFCEEMAILASSUNTO")
    private String nfceemailassunto;
    @Lob
    @Column(name = "NFCEEMAILMENSAGEM")
    private String nfceemailmensagem;
    @Column(name = "LOTENFCE")
    private Integer lotenfce;
    @Column(name = "CODIGOMUNICIPIOIBGE")
    private String codigomunicipioibge;
    @Column(name = "NFCECPFAUTORIZADO")
    private String nfcecpfautorizado;
    @Column(name = "NFCECNPJAUTORIZADO")
    private String nfcecnpjautorizado;
    @Column(name = "FLAGFILIAL")
    private Character flagfilial;
    @Column(name = "HASHCODESAT")
    private String hashcodesat;
    @Column(name = "ISSRATEADOSAT")
    private Character issrateadosat;
    @Column(name = "FLAGTRATASERVICONFCE")
    private Character flagtrataserviconfce;
    @Column(name = "CODCFOPPDV")
    private String codcfoppdv;
    @Column(name = "PROXIMODAV")
    private BigInteger proximodav;
    @Column(name = "PROXIMODAVOS")
    private BigInteger proximodavos;
    @Column(name = "PROXIMAPREVENDA")
    private BigInteger proximaprevenda;
    @Column(name = "MENSAGEMFINALPDV")
    private String mensagemfinalpdv;
    @Column(name = "NFCEEMAILCONTEUDOHTML")
    private Character nfceemailconteudohtml;
    @Column(name = "MFE_CHAVEVALIDADOR")
    private String mfeChavevalidador;
    @Column(name = "FLAGCONTRIBUINTEIPI")
    private Character flagcontribuinteipi;
    @Column(name = "FLAGSAIDACONJUGADA")
    private Character flagsaidaconjugada;
    @Column(name = "FLAGINTEGRACARTAONFE")
    private Character flagintegracartaonfe;
    @Column(name = "NUMEROCREDENCIAMENTOPAFECF")
    private String numerocredenciamentopafecf;
    @Column(name = "FLAGSERIEOFFLINENFCE")
    private Character flagserieofflinenfce;
    @Column(name = "FLAGGERAHASHCRST")
    private Character flaggerahashcrst;
    @Column(name = "FLAGGERAHASHCRSTNFCE")
    private Character flaggerahashcrstnfce;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "TIPOATIVIDADEINDUSTRIAL")
    private String tipoatividadeindustrial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Moventrada> moventradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Caixa> caixaCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Manifestacaodestinatario> manifestacaodestinatarioCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Recibo> reciboCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Moconvenio> moconvenioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Empresauf> empresaufCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Movecfrzitem> movecfrzitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Lancafinanceira> lancafinanceiraCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Documento> documentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Contapagarpag> contapagarpagCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Contareceberrec> contareceberrecCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<Produtoestoque> produtoestoqueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Atendimento> atendimentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Cheques> chequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Acerto> acertoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Veiculos> veiculosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Lancacartao> lancacartaoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Movecfdocumento> movecfdocumentoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Contratocobranca> contratocobrancaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<OsOrdemservico> osOrdemservicoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Produtoestoquelote> produtoestoqueloteCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Cotacao> cotacaoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Movenda> movendaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Contabancaria> contabancariaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Orcamentoprod> orcamentoprodCollection;
    @OneToMany(mappedBy = "codempresaestoque")
    private Collection<Orcamentoprod> orcamentoprodCollection1;
    @OneToMany(mappedBy = "codempresa")
    private Collection<AcertoProdlote> acertoProdloteCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Loteentrega> loteentregaCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<AcertoProdfci> acertoProdfciCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Empresatipodocumento> empresatipodocumentoCollection;
    @OneToMany(mappedBy = "codempresa")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codempresa")
    private Collection<Mdfeletronico> mdfeletronicoCollection;

    public Empresa() {
    }

    public Empresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getNomeempresa() {
        return nomeempresa;
    }

    public void setNomeempresa(String nomeempresa) {
        this.nomeempresa = nomeempresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Character getUsaecf() {
        return usaecf;
    }

    public void setUsaecf(Character usaecf) {
        this.usaecf = usaecf;
    }

    public Character getInativa() {
        return inativa;
    }

    public void setInativa(Character inativa) {
        this.inativa = inativa;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }


    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getInscricaomunicipal() {
        return inscricaomunicipal;
    }

    public void setInscricaomunicipal(String inscricaomunicipal) {
        this.inscricaomunicipal = inscricaomunicipal;
    }

    public String getModelonota() {
        return modelonota;
    }

    public void setModelonota(String modelonota) {
        this.modelonota = modelonota;
    }

    public String getSerienf() {
        return serienf;
    }

    public void setSerienf(String serienf) {
        this.serienf = serienf;
    }

    public String getEspecienf() {
        return especienf;
    }

    public void setEspecienf(String especienf) {
        this.especienf = especienf;
    }

    public String getIdlayoutnf() {
        return idlayoutnf;
    }

    public void setIdlayoutnf(String idlayoutnf) {
        this.idlayoutnf = idlayoutnf;
    }

    public String getObscomprovante() {
        return obscomprovante;
    }

    public void setObscomprovante(String obscomprovante) {
        this.obscomprovante = obscomprovante;
    }

    public String getRodapecomprovante() {
        return rodapecomprovante;
    }

    public void setRodapecomprovante(String rodapecomprovante) {
        this.rodapecomprovante = rodapecomprovante;
    }

    public String getCabecalhocomprovante() {
        return cabecalhocomprovante;
    }

    public void setCabecalhocomprovante(String cabecalhocomprovante) {
        this.cabecalhocomprovante = cabecalhocomprovante;
    }

    public Integer getQtdeitensnotafiscal() {
        return qtdeitensnotafiscal;
    }

    public void setQtdeitensnotafiscal(Integer qtdeitensnotafiscal) {
        this.qtdeitensnotafiscal = qtdeitensnotafiscal;
    }

    public Character getFlagimpnotaautomatico() {
        return flagimpnotaautomatico;
    }

    public void setFlagimpnotaautomatico(Character flagimpnotaautomatico) {
        this.flagimpnotaautomatico = flagimpnotaautomatico;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public Integer getNumnfe() {
        return numnfe;
    }

    public void setNumnfe(Integer numnfe) {
        this.numnfe = numnfe;
    }

    public String getSerienfe() {
        return serienfe;
    }

    public void setSerienfe(String serienfe) {
        this.serienfe = serienfe;
    }

    public String getIdlayoutdanfe() {
        return idlayoutdanfe;
    }

    public void setIdlayoutdanfe(String idlayoutdanfe) {
        this.idlayoutdanfe = idlayoutdanfe;
    }

    public String getIdlayoutcomprovante() {
        return idlayoutcomprovante;
    }

    public void setIdlayoutcomprovante(String idlayoutcomprovante) {
        this.idlayoutcomprovante = idlayoutcomprovante;
    }

    public String getIdlayoutorcamento() {
        return idlayoutorcamento;
    }

    public void setIdlayoutorcamento(String idlayoutorcamento) {
        this.idlayoutorcamento = idlayoutorcamento;
    }

    public String getIdlayoutnfentrada() {
        return idlayoutnfentrada;
    }

    public void setIdlayoutnfentrada(String idlayoutnfentrada) {
        this.idlayoutnfentrada = idlayoutnfentrada;
    }

    public String getCabecalhoorcamento() {
        return cabecalhoorcamento;
    }

    public void setCabecalhoorcamento(String cabecalhoorcamento) {
        this.cabecalhoorcamento = cabecalhoorcamento;
    }

    public String getRodapeorcamento() {
        return rodapeorcamento;
    }

    public void setRodapeorcamento(String rodapeorcamento) {
        this.rodapeorcamento = rodapeorcamento;
    }

    public String getObsorcamento() {
        return obsorcamento;
    }

    public void setObsorcamento(String obsorcamento) {
        this.obsorcamento = obsorcamento;
    }


    public Character getPerfilsped() {
        return perfilsped;
    }

    public void setPerfilsped(Character perfilsped) {
        this.perfilsped = perfilsped;
    }

    public Character getTipoatividade() {
        return tipoatividade;
    }

    public void setTipoatividade(Character tipoatividade) {
        this.tipoatividade = tipoatividade;
    }

    public Character getFlagapuraipi() {
        return flagapuraipi;
    }

    public void setFlagapuraipi(Character flagapuraipi) {
        this.flagapuraipi = flagapuraipi;
    }

    public String getCodpessoacontador() {
        return codpessoacontador;
    }

    public void setCodpessoacontador(String codpessoacontador) {
        this.codpessoacontador = codpessoacontador;
    }

    public BigDecimal getAliqcreditosimplesnacional() {
        return aliqcreditosimplesnacional;
    }

    public void setAliqcreditosimplesnacional(BigDecimal aliqcreditosimplesnacional) {
        this.aliqcreditosimplesnacional = aliqcreditosimplesnacional;
    }

    public Character getFlagsimplesnacional() {
        return flagsimplesnacional;
    }

    public void setFlagsimplesnacional(Character flagsimplesnacional) {
        this.flagsimplesnacional = flagsimplesnacional;
    }

    public BigInteger getLotenfse() {
        return lotenfse;
    }

    public void setLotenfse(BigInteger lotenfse) {
        this.lotenfse = lotenfse;
    }

    public Character getFlagregimeespecialtributacao() {
        return flagregimeespecialtributacao;
    }

    public void setFlagregimeespecialtributacao(Character flagregimeespecialtributacao) {
        this.flagregimeespecialtributacao = flagregimeespecialtributacao;
    }

    public Character getFlagcrt() {
        return flagcrt;
    }

    public void setFlagcrt(Character flagcrt) {
        this.flagcrt = flagcrt;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getNumerologradouro() {
        return numerologradouro;
    }

    public void setNumerologradouro(String numerologradouro) {
        this.numerologradouro = numerologradouro;
    }

    public String getComplementologradouro() {
        return complementologradouro;
    }

    public void setComplementologradouro(String complementologradouro) {
        this.complementologradouro = complementologradouro;
    }

    public String getNomeresponsavel() {
        return nomeresponsavel;
    }

    public void setNomeresponsavel(String nomeresponsavel) {
        this.nomeresponsavel = nomeresponsavel;
    }

    public BigDecimal getMetames01() {
        return metames01;
    }

    public void setMetames01(BigDecimal metames01) {
        this.metames01 = metames01;
    }

    public BigDecimal getMetames02() {
        return metames02;
    }

    public void setMetames02(BigDecimal metames02) {
        this.metames02 = metames02;
    }

    public BigDecimal getMetames03() {
        return metames03;
    }

    public void setMetames03(BigDecimal metames03) {
        this.metames03 = metames03;
    }

    public BigDecimal getMetames04() {
        return metames04;
    }

    public void setMetames04(BigDecimal metames04) {
        this.metames04 = metames04;
    }

    public BigDecimal getMetames05() {
        return metames05;
    }

    public void setMetames05(BigDecimal metames05) {
        this.metames05 = metames05;
    }

    public BigDecimal getMetames06() {
        return metames06;
    }

    public void setMetames06(BigDecimal metames06) {
        this.metames06 = metames06;
    }

    public BigDecimal getMetames07() {
        return metames07;
    }

    public void setMetames07(BigDecimal metames07) {
        this.metames07 = metames07;
    }

    public BigDecimal getMetames08() {
        return metames08;
    }

    public void setMetames08(BigDecimal metames08) {
        this.metames08 = metames08;
    }

    public BigDecimal getMetames09() {
        return metames09;
    }

    public void setMetames09(BigDecimal metames09) {
        this.metames09 = metames09;
    }

    public BigDecimal getMetames10() {
        return metames10;
    }

    public void setMetames10(BigDecimal metames10) {
        this.metames10 = metames10;
    }

    public BigDecimal getMetames11() {
        return metames11;
    }

    public void setMetames11(BigDecimal metames11) {
        this.metames11 = metames11;
    }

    public BigDecimal getMetames12() {
        return metames12;
    }

    public void setMetames12(BigDecimal metames12) {
        this.metames12 = metames12;
    }

    public String getCodigointegracaofiscal() {
        return codigointegracaofiscal;
    }

    public void setCodigointegracaofiscal(String codigointegracaofiscal) {
        this.codigointegracaofiscal = codigointegracaofiscal;
    }

    public String getDiretoriocplusnfe() {
        return diretoriocplusnfe;
    }

    public void setDiretoriocplusnfe(String diretoriocplusnfe) {
        this.diretoriocplusnfe = diretoriocplusnfe;
    }

    public String getIdlayoutorcamentooffline() {
        return idlayoutorcamentooffline;
    }

    public void setIdlayoutorcamentooffline(String idlayoutorcamentooffline) {
        this.idlayoutorcamentooffline = idlayoutorcamentooffline;
    }

    public String getIdlayoutorcamentoemail() {
        return idlayoutorcamentoemail;
    }

    public void setIdlayoutorcamentoemail(String idlayoutorcamentoemail) {
        this.idlayoutorcamentoemail = idlayoutorcamentoemail;
    }

    public Integer getNumnfescan() {
        return numnfescan;
    }

    public void setNumnfescan(Integer numnfescan) {
        this.numnfescan = numnfescan;
    }

    public String getSerienfescan() {
        return serienfescan;
    }

    public void setSerienfescan(String serienfescan) {
        this.serienfescan = serienfescan;
    }

    public Integer getSeqconhecimento() {
        return seqconhecimento;
    }

    public void setSeqconhecimento(Integer seqconhecimento) {
        this.seqconhecimento = seqconhecimento;
    }

    public String getIdlayoutnfservico() {
        return idlayoutnfservico;
    }

    public void setIdlayoutnfservico(String idlayoutnfservico) {
        this.idlayoutnfservico = idlayoutnfservico;
    }

    public Integer getNumnotaservico() {
        return numnotaservico;
    }

    public void setNumnotaservico(Integer numnotaservico) {
        this.numnotaservico = numnotaservico;
    }

    public String getSerienfservico() {
        return serienfservico;
    }

    public void setSerienfservico(String serienfservico) {
        this.serienfservico = serienfservico;
    }

    public Character getFlagnfservico() {
        return flagnfservico;
    }

    public void setFlagnfservico(Character flagnfservico) {
        this.flagnfservico = flagnfservico;
    }

    public String getModelonotaservico() {
        return modelonotaservico;
    }

    public void setModelonotaservico(String modelonotaservico) {
        this.modelonotaservico = modelonotaservico;
    }


    public String getIdlayoutcomprovanteemail() {
        return idlayoutcomprovanteemail;
    }

    public void setIdlayoutcomprovanteemail(String idlayoutcomprovanteemail) {
        this.idlayoutcomprovanteemail = idlayoutcomprovanteemail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCodterminalintegracao() {
        return codterminalintegracao;
    }

    public void setCodterminalintegracao(String codterminalintegracao) {
        this.codterminalintegracao = codterminalintegracao;
    }

    public String getArquivosexportacao() {
        return arquivosexportacao;
    }

    public void setArquivosexportacao(String arquivosexportacao) {
        this.arquivosexportacao = arquivosexportacao;
    }

    public String getArquivosimportacao() {
        return arquivosimportacao;
    }

    public void setArquivosimportacao(String arquivosimportacao) {
        this.arquivosimportacao = arquivosimportacao;
    }

    public String getCodprecoecf() {
        return codprecoecf;
    }

    public void setCodprecoecf(String codprecoecf) {
        this.codprecoecf = codprecoecf;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagsempregeranovolote() {
        return flagsempregeranovolote;
    }

    public void setFlagsempregeranovolote(Character flagsempregeranovolote) {
        this.flagsempregeranovolote = flagsempregeranovolote;
    }

    public String getIdlayoutcce() {
        return idlayoutcce;
    }

    public void setIdlayoutcce(String idlayoutcce) {
        this.idlayoutcce = idlayoutcce;
    }

    public String getIdtoken() {
        return idtoken;
    }

    public void setIdtoken(String idtoken) {
        this.idtoken = idtoken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Character getFlaghorarioverao() {
        return flaghorarioverao;
    }

    public void setFlaghorarioverao(Character flaghorarioverao) {
        this.flaghorarioverao = flaghorarioverao;
    }

    public Character getFlagfusohorario() {
        return flagfusohorario;
    }

    public void setFlagfusohorario(Character flagfusohorario) {
        this.flagfusohorario = flagfusohorario;
    }

    public String getNfceservidorsmtp() {
        return nfceservidorsmtp;
    }

    public void setNfceservidorsmtp(String nfceservidorsmtp) {
        this.nfceservidorsmtp = nfceservidorsmtp;
    }

    public Integer getNfceemailporta() {
        return nfceemailporta;
    }

    public void setNfceemailporta(Integer nfceemailporta) {
        this.nfceemailporta = nfceemailporta;
    }

    public String getNfceemaillogin() {
        return nfceemaillogin;
    }

    public void setNfceemaillogin(String nfceemaillogin) {
        this.nfceemaillogin = nfceemaillogin;
    }

    public String getNfceemailsenha() {
        return nfceemailsenha;
    }

    public void setNfceemailsenha(String nfceemailsenha) {
        this.nfceemailsenha = nfceemailsenha;
    }

    public Integer getNfceemailtimeout() {
        return nfceemailtimeout;
    }

    public void setNfceemailtimeout(Integer nfceemailtimeout) {
        this.nfceemailtimeout = nfceemailtimeout;
    }

    public Character getNfceemailautenticacao() {
        return nfceemailautenticacao;
    }

    public void setNfceemailautenticacao(Character nfceemailautenticacao) {
        this.nfceemailautenticacao = nfceemailautenticacao;
    }

    public String getNfceemailremetente() {
        return nfceemailremetente;
    }

    public void setNfceemailremetente(String nfceemailremetente) {
        this.nfceemailremetente = nfceemailremetente;
    }

    public String getNfceemailcomcopia() {
        return nfceemailcomcopia;
    }

    public void setNfceemailcomcopia(String nfceemailcomcopia) {
        this.nfceemailcomcopia = nfceemailcomcopia;
    }

    public String getNfceemailcomcopiaoculta() {
        return nfceemailcomcopiaoculta;
    }

    public void setNfceemailcomcopiaoculta(String nfceemailcomcopiaoculta) {
        this.nfceemailcomcopiaoculta = nfceemailcomcopiaoculta;
    }

    public String getNfceemailassunto() {
        return nfceemailassunto;
    }

    public void setNfceemailassunto(String nfceemailassunto) {
        this.nfceemailassunto = nfceemailassunto;
    }

    public String getNfceemailmensagem() {
        return nfceemailmensagem;
    }

    public void setNfceemailmensagem(String nfceemailmensagem) {
        this.nfceemailmensagem = nfceemailmensagem;
    }

    public Integer getLotenfce() {
        return lotenfce;
    }

    public void setLotenfce(Integer lotenfce) {
        this.lotenfce = lotenfce;
    }

    public String getCodigomunicipioibge() {
        return codigomunicipioibge;
    }

    public void setCodigomunicipioibge(String codigomunicipioibge) {
        this.codigomunicipioibge = codigomunicipioibge;
    }

    public String getNfcecpfautorizado() {
        return nfcecpfautorizado;
    }

    public void setNfcecpfautorizado(String nfcecpfautorizado) {
        this.nfcecpfautorizado = nfcecpfautorizado;
    }

    public String getNfcecnpjautorizado() {
        return nfcecnpjautorizado;
    }

    public void setNfcecnpjautorizado(String nfcecnpjautorizado) {
        this.nfcecnpjautorizado = nfcecnpjautorizado;
    }

    public Character getFlagfilial() {
        return flagfilial;
    }

    public void setFlagfilial(Character flagfilial) {
        this.flagfilial = flagfilial;
    }

    public String getHashcodesat() {
        return hashcodesat;
    }

    public void setHashcodesat(String hashcodesat) {
        this.hashcodesat = hashcodesat;
    }

    public Character getIssrateadosat() {
        return issrateadosat;
    }

    public void setIssrateadosat(Character issrateadosat) {
        this.issrateadosat = issrateadosat;
    }


    public Character getFlagtrataserviconfce() {
        return flagtrataserviconfce;
    }

    public void setFlagtrataserviconfce(Character flagtrataserviconfce) {
        this.flagtrataserviconfce = flagtrataserviconfce;
    }

    public String getCodcfoppdv() {
        return codcfoppdv;
    }

    public void setCodcfoppdv(String codcfoppdv) {
        this.codcfoppdv = codcfoppdv;
    }

    public BigInteger getProximodav() {
        return proximodav;
    }

    public void setProximodav(BigInteger proximodav) {
        this.proximodav = proximodav;
    }

    public BigInteger getProximodavos() {
        return proximodavos;
    }

    public void setProximodavos(BigInteger proximodavos) {
        this.proximodavos = proximodavos;
    }

    public BigInteger getProximaprevenda() {
        return proximaprevenda;
    }

    public void setProximaprevenda(BigInteger proximaprevenda) {
        this.proximaprevenda = proximaprevenda;
    }

    public String getMensagemfinalpdv() {
        return mensagemfinalpdv;
    }

    public void setMensagemfinalpdv(String mensagemfinalpdv) {
        this.mensagemfinalpdv = mensagemfinalpdv;
    }

    public Character getNfceemailconteudohtml() {
        return nfceemailconteudohtml;
    }

    public void setNfceemailconteudohtml(Character nfceemailconteudohtml) {
        this.nfceemailconteudohtml = nfceemailconteudohtml;
    }

    public String getMfeChavevalidador() {
        return mfeChavevalidador;
    }

    public void setMfeChavevalidador(String mfeChavevalidador) {
        this.mfeChavevalidador = mfeChavevalidador;
    }

    public Character getFlagcontribuinteipi() {
        return flagcontribuinteipi;
    }

    public void setFlagcontribuinteipi(Character flagcontribuinteipi) {
        this.flagcontribuinteipi = flagcontribuinteipi;
    }

    public Character getFlagsaidaconjugada() {
        return flagsaidaconjugada;
    }

    public void setFlagsaidaconjugada(Character flagsaidaconjugada) {
        this.flagsaidaconjugada = flagsaidaconjugada;
    }

    public Character getFlagintegracartaonfe() {
        return flagintegracartaonfe;
    }

    public void setFlagintegracartaonfe(Character flagintegracartaonfe) {
        this.flagintegracartaonfe = flagintegracartaonfe;
    }

    public String getNumerocredenciamentopafecf() {
        return numerocredenciamentopafecf;
    }

    public void setNumerocredenciamentopafecf(String numerocredenciamentopafecf) {
        this.numerocredenciamentopafecf = numerocredenciamentopafecf;
    }

    public Character getFlagserieofflinenfce() {
        return flagserieofflinenfce;
    }

    public void setFlagserieofflinenfce(Character flagserieofflinenfce) {
        this.flagserieofflinenfce = flagserieofflinenfce;
    }

    public Character getFlaggerahashcrst() {
        return flaggerahashcrst;
    }

    public void setFlaggerahashcrst(Character flaggerahashcrst) {
        this.flaggerahashcrst = flaggerahashcrst;
    }

    public Character getFlaggerahashcrstnfce() {
        return flaggerahashcrstnfce;
    }

    public void setFlaggerahashcrstnfce(Character flaggerahashcrstnfce) {
        this.flaggerahashcrstnfce = flaggerahashcrstnfce;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getTipoatividadeindustrial() {
        return tipoatividadeindustrial;
    }

    public void setTipoatividadeindustrial(String tipoatividadeindustrial) {
        this.tipoatividadeindustrial = tipoatividadeindustrial;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Moventrada> getMoventradaCollection() {
        return moventradaCollection;
    }

    public void setMoventradaCollection(Collection<Moventrada> moventradaCollection) {
        this.moventradaCollection = moventradaCollection;
    }

    @XmlTransient
    public Collection<Caixa> getCaixaCollection() {
        return caixaCollection;
    }

    public void setCaixaCollection(Collection<Caixa> caixaCollection) {
        this.caixaCollection = caixaCollection;
    }

    @XmlTransient
    public Collection<Manifestacaodestinatario> getManifestacaodestinatarioCollection() {
        return manifestacaodestinatarioCollection;
    }

    public void setManifestacaodestinatarioCollection(Collection<Manifestacaodestinatario> manifestacaodestinatarioCollection) {
        this.manifestacaodestinatarioCollection = manifestacaodestinatarioCollection;
    }

    @XmlTransient
    public Collection<Recibo> getReciboCollection() {
        return reciboCollection;
    }

    public void setReciboCollection(Collection<Recibo> reciboCollection) {
        this.reciboCollection = reciboCollection;
    }

    @XmlTransient
    public Collection<Moconvenio> getMoconvenioCollection() {
        return moconvenioCollection;
    }

    public void setMoconvenioCollection(Collection<Moconvenio> moconvenioCollection) {
        this.moconvenioCollection = moconvenioCollection;
    }

    @XmlTransient
    public Collection<Empresauf> getEmpresaufCollection() {
        return empresaufCollection;
    }

    public void setEmpresaufCollection(Collection<Empresauf> empresaufCollection) {
        this.empresaufCollection = empresaufCollection;
    }

    @XmlTransient
    public Collection<Movecfrzitem> getMovecfrzitemCollection() {
        return movecfrzitemCollection;
    }

    public void setMovecfrzitemCollection(Collection<Movecfrzitem> movecfrzitemCollection) {
        this.movecfrzitemCollection = movecfrzitemCollection;
    }

    @XmlTransient
    public Collection<Lancafinanceira> getLancafinanceiraCollection() {
        return lancafinanceiraCollection;
    }

    public void setLancafinanceiraCollection(Collection<Lancafinanceira> lancafinanceiraCollection) {
        this.lancafinanceiraCollection = lancafinanceiraCollection;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    @XmlTransient
    public Collection<Contapagarpag> getContapagarpagCollection() {
        return contapagarpagCollection;
    }

    public void setContapagarpagCollection(Collection<Contapagarpag> contapagarpagCollection) {
        this.contapagarpagCollection = contapagarpagCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Contareceberrec> getContareceberrecCollection() {
        return contareceberrecCollection;
    }

    public void setContareceberrecCollection(Collection<Contareceberrec> contareceberrecCollection) {
        this.contareceberrecCollection = contareceberrecCollection;
    }

    @XmlTransient
    public Collection<Produtoestoque> getProdutoestoqueCollection() {
        return produtoestoqueCollection;
    }

    public void setProdutoestoqueCollection(Collection<Produtoestoque> produtoestoqueCollection) {
        this.produtoestoqueCollection = produtoestoqueCollection;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    @XmlTransient
    public Collection<Cheques> getChequesCollection() {
        return chequesCollection;
    }

    public void setChequesCollection(Collection<Cheques> chequesCollection) {
        this.chequesCollection = chequesCollection;
    }

    @XmlTransient
    public Collection<Acerto> getAcertoCollection() {
        return acertoCollection;
    }

    public void setAcertoCollection(Collection<Acerto> acertoCollection) {
        this.acertoCollection = acertoCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Movecfdocumentocaixa> getMovecfdocumentocaixaCollection() {
        return movecfdocumentocaixaCollection;
    }

    public void setMovecfdocumentocaixaCollection(Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection) {
        this.movecfdocumentocaixaCollection = movecfdocumentocaixaCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Veiculos> getVeiculosCollection() {
        return veiculosCollection;
    }

    public void setVeiculosCollection(Collection<Veiculos> veiculosCollection) {
        this.veiculosCollection = veiculosCollection;
    }

    @XmlTransient
    public Collection<Lancacartao> getLancacartaoCollection() {
        return lancacartaoCollection;
    }

    public void setLancacartaoCollection(Collection<Lancacartao> lancacartaoCollection) {
        this.lancacartaoCollection = lancacartaoCollection;
    }

    @XmlTransient
    public Collection<Movecfdocumento> getMovecfdocumentoCollection() {
        return movecfdocumentoCollection;
    }

    public void setMovecfdocumentoCollection(Collection<Movecfdocumento> movecfdocumentoCollection) {
        this.movecfdocumentoCollection = movecfdocumentoCollection;
    }

    @XmlTransient
    public Collection<Contratocobranca> getContratocobrancaCollection() {
        return contratocobrancaCollection;
    }

    public void setContratocobrancaCollection(Collection<Contratocobranca> contratocobrancaCollection) {
        this.contratocobrancaCollection = contratocobrancaCollection;
    }

    @XmlTransient
    public Collection<OsOrdemservico> getOsOrdemservicoCollection() {
        return osOrdemservicoCollection;
    }

    public void setOsOrdemservicoCollection(Collection<OsOrdemservico> osOrdemservicoCollection) {
        this.osOrdemservicoCollection = osOrdemservicoCollection;
    }

    @XmlTransient
    public Collection<Produtoestoquelote> getProdutoestoqueloteCollection() {
        return produtoestoqueloteCollection;
    }

    public void setProdutoestoqueloteCollection(Collection<Produtoestoquelote> produtoestoqueloteCollection) {
        this.produtoestoqueloteCollection = produtoestoqueloteCollection;
    }

    @XmlTransient
    public Collection<Cotacao> getCotacaoCollection() {
        return cotacaoCollection;
    }

    public void setCotacaoCollection(Collection<Cotacao> cotacaoCollection) {
        this.cotacaoCollection = cotacaoCollection;
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
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Contabancaria> getContabancariaCollection() {
        return contabancariaCollection;
    }

    public void setContabancariaCollection(Collection<Contabancaria> contabancariaCollection) {
        this.contabancariaCollection = contabancariaCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection1() {
        return orcamentoprodCollection1;
    }

    public void setOrcamentoprodCollection1(Collection<Orcamentoprod> orcamentoprodCollection1) {
        this.orcamentoprodCollection1 = orcamentoprodCollection1;
    }

    @XmlTransient
    public Collection<AcertoProdlote> getAcertoProdloteCollection() {
        return acertoProdloteCollection;
    }

    public void setAcertoProdloteCollection(Collection<AcertoProdlote> acertoProdloteCollection) {
        this.acertoProdloteCollection = acertoProdloteCollection;
    }

    @XmlTransient
    public Collection<Loteentrega> getLoteentregaCollection() {
        return loteentregaCollection;
    }

    public void setLoteentregaCollection(Collection<Loteentrega> loteentregaCollection) {
        this.loteentregaCollection = loteentregaCollection;
    }

    @XmlTransient
    public Collection<AcertoProdfci> getAcertoProdfciCollection() {
        return acertoProdfciCollection;
    }

    public void setAcertoProdfciCollection(Collection<AcertoProdfci> acertoProdfciCollection) {
        this.acertoProdfciCollection = acertoProdfciCollection;
    }

    @XmlTransient
    public Collection<Empresatipodocumento> getEmpresatipodocumentoCollection() {
        return empresatipodocumentoCollection;
    }

    public void setEmpresatipodocumentoCollection(Collection<Empresatipodocumento> empresatipodocumentoCollection) {
        this.empresatipodocumentoCollection = empresatipodocumentoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronico> getMdfeletronicoCollection() {
        return mdfeletronicoCollection;
    }

    public void setMdfeletronicoCollection(Collection<Mdfeletronico> mdfeletronicoCollection) {
        this.mdfeletronicoCollection = mdfeletronicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresa != null ? codempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codempresa == null && other.codempresa != null) || (this.codempresa != null && !this.codempresa.equals(other.codempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresa[ codempresa=" + codempresa + " ]";
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public byte[] getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(byte[] logotipo) {
        this.logotipo = logotipo;
    }

    public byte[] getLogonfe() {
        return logonfe;
    }

    public void setLogonfe(byte[] logonfe) {
        this.logonfe = logonfe;
    }

    public byte[] getLogonfse() {
        return logonfse;
    }

    public void setLogonfse(byte[] logonfse) {
        this.logonfse = logonfse;
    }

    public byte[] getLogonfce() {
        return logonfce;
    }

    public void setLogonfce(byte[] logonfce) {
        this.logonfce = logonfce;
    }

    public byte[] getLogocfesat() {
        return logocfesat;
    }

    public void setLogocfesat(byte[] logocfesat) {
        this.logocfesat = logocfesat;
    }
    
}
