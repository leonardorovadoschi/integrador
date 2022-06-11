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
@Table(name = "CONTABANCARIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contabancaria.findAll", query = "SELECT c FROM Contabancaria c")
    , @NamedQuery(name = "Contabancaria.findByCodcontabancaria", query = "SELECT c FROM Contabancaria c WHERE c.codcontabancaria = :codcontabancaria")
    , @NamedQuery(name = "Contabancaria.findByCodigo", query = "SELECT c FROM Contabancaria c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Contabancaria.findByNumeroconta", query = "SELECT c FROM Contabancaria c WHERE c.numeroconta = :numeroconta")
    , @NamedQuery(name = "Contabancaria.findByDvconta", query = "SELECT c FROM Contabancaria c WHERE c.dvconta = :dvconta")
    , @NamedQuery(name = "Contabancaria.findByCodigocedente", query = "SELECT c FROM Contabancaria c WHERE c.codigocedente = :codigocedente")
    , @NamedQuery(name = "Contabancaria.findByCodigoclientebanco", query = "SELECT c FROM Contabancaria c WHERE c.codigoclientebanco = :codigoclientebanco")
    , @NamedQuery(name = "Contabancaria.findByCarteira", query = "SELECT c FROM Contabancaria c WHERE c.carteira = :carteira")
    , @NamedQuery(name = "Contabancaria.findByNumeroconvenio", query = "SELECT c FROM Contabancaria c WHERE c.numeroconvenio = :numeroconvenio")
    , @NamedQuery(name = "Contabancaria.findByNaopreenchernossonumero", query = "SELECT c FROM Contabancaria c WHERE c.naopreenchernossonumero = :naopreenchernossonumero")
    , @NamedQuery(name = "Contabancaria.findByFlagativo", query = "SELECT c FROM Contabancaria c WHERE c.flagativo = :flagativo")
    , @NamedQuery(name = "Contabancaria.findByIdlayoutboleto", query = "SELECT c FROM Contabancaria c WHERE c.idlayoutboleto = :idlayoutboleto")
    , @NamedQuery(name = "Contabancaria.findByNometitular", query = "SELECT c FROM Contabancaria c WHERE c.nometitular = :nometitular")
    , @NamedQuery(name = "Contabancaria.findByNumeroagencia", query = "SELECT c FROM Contabancaria c WHERE c.numeroagencia = :numeroagencia")
    , @NamedQuery(name = "Contabancaria.findByDvagencia", query = "SELECT c FROM Contabancaria c WHERE c.dvagencia = :dvagencia")
    , @NamedQuery(name = "Contabancaria.findByCnpjcpffavorecido", query = "SELECT c FROM Contabancaria c WHERE c.cnpjcpffavorecido = :cnpjcpffavorecido")
    , @NamedQuery(name = "Contabancaria.findBySequencial", query = "SELECT c FROM Contabancaria c WHERE c.sequencial = :sequencial")
    , @NamedQuery(name = "Contabancaria.findByNomecontabancaria", query = "SELECT c FROM Contabancaria c WHERE c.nomecontabancaria = :nomecontabancaria")
    , @NamedQuery(name = "Contabancaria.findByTaxa", query = "SELECT c FROM Contabancaria c WHERE c.taxa = :taxa")
    , @NamedQuery(name = "Contabancaria.findByCodcontabancariaaux", query = "SELECT c FROM Contabancaria c WHERE c.codcontabancariaaux = :codcontabancariaaux")
    , @NamedQuery(name = "Contabancaria.findBySequencialdiario", query = "SELECT c FROM Contabancaria c WHERE c.sequencialdiario = :sequencialdiario")
    , @NamedQuery(name = "Contabancaria.findBySequencialremessa", query = "SELECT c FROM Contabancaria c WHERE c.sequencialremessa = :sequencialremessa")
    , @NamedQuery(name = "Contabancaria.findByDataultimasequencia", query = "SELECT c FROM Contabancaria c WHERE c.dataultimasequencia = :dataultimasequencia")
    , @NamedQuery(name = "Contabancaria.findByFlagnaogerarnossonumero", query = "SELECT c FROM Contabancaria c WHERE c.flagnaogerarnossonumero = :flagnaogerarnossonumero")
    , @NamedQuery(name = "Contabancaria.findByFlagbancoemiteboleto", query = "SELECT c FROM Contabancaria c WHERE c.flagbancoemiteboleto = :flagbancoemiteboleto")
    , @NamedQuery(name = "Contabancaria.findByValoremissaopadrao", query = "SELECT c FROM Contabancaria c WHERE c.valoremissaopadrao = :valoremissaopadrao")
    , @NamedQuery(name = "Contabancaria.findByValoremissaobanco", query = "SELECT c FROM Contabancaria c WHERE c.valoremissaobanco = :valoremissaobanco")
    , @NamedQuery(name = "Contabancaria.findByValoremissaoempresa", query = "SELECT c FROM Contabancaria c WHERE c.valoremissaoempresa = :valoremissaoempresa")
    , @NamedQuery(name = "Contabancaria.findBySigla", query = "SELECT c FROM Contabancaria c WHERE c.sigla = :sigla")
    , @NamedQuery(name = "Contabancaria.findByVariacaocarteira", query = "SELECT c FROM Contabancaria c WHERE c.variacaocarteira = :variacaocarteira")
    , @NamedQuery(name = "Contabancaria.findByCodmontagemarquivo", query = "SELECT c FROM Contabancaria c WHERE c.codmontagemarquivo = :codmontagemarquivo")
    , @NamedQuery(name = "Contabancaria.findByCaminhoremessa", query = "SELECT c FROM Contabancaria c WHERE c.caminhoremessa = :caminhoremessa")
    , @NamedQuery(name = "Contabancaria.findByLayoutcnab", query = "SELECT c FROM Contabancaria c WHERE c.layoutcnab = :layoutcnab")
    , @NamedQuery(name = "Contabancaria.findByTamanhodvretorno", query = "SELECT c FROM Contabancaria c WHERE c.tamanhodvretorno = :tamanhodvretorno")
    , @NamedQuery(name = "Contabancaria.findByDiasprotesto", query = "SELECT c FROM Contabancaria c WHERE c.diasprotesto = :diasprotesto")
    , @NamedQuery(name = "Contabancaria.findByDadosconfig1", query = "SELECT c FROM Contabancaria c WHERE c.dadosconfig1 = :dadosconfig1")
    , @NamedQuery(name = "Contabancaria.findByDadosconfig2", query = "SELECT c FROM Contabancaria c WHERE c.dadosconfig2 = :dadosconfig2")
    , @NamedQuery(name = "Contabancaria.findByDadosconfig3", query = "SELECT c FROM Contabancaria c WHERE c.dadosconfig3 = :dadosconfig3")
    , @NamedQuery(name = "Contabancaria.findByDadosconfig4", query = "SELECT c FROM Contabancaria c WHERE c.dadosconfig4 = :dadosconfig4")
    , @NamedQuery(name = "Contabancaria.findByDadosconfig5", query = "SELECT c FROM Contabancaria c WHERE c.dadosconfig5 = :dadosconfig5")
    , @NamedQuery(name = "Contabancaria.findByInicionossonumero", query = "SELECT c FROM Contabancaria c WHERE c.inicionossonumero = :inicionossonumero")
    , @NamedQuery(name = "Contabancaria.findByFimnossonumero", query = "SELECT c FROM Contabancaria c WHERE c.fimnossonumero = :fimnossonumero")
    , @NamedQuery(name = "Contabancaria.findByParametrosadicionais", query = "SELECT c FROM Contabancaria c WHERE c.parametrosadicionais = :parametrosadicionais")
    , @NamedQuery(name = "Contabancaria.findByTamanhoprefixoretorno", query = "SELECT c FROM Contabancaria c WHERE c.tamanhoprefixoretorno = :tamanhoprefixoretorno")
    , @NamedQuery(name = "Contabancaria.findByAceite", query = "SELECT c FROM Contabancaria c WHERE c.aceite = :aceite")
    , @NamedQuery(name = "Contabancaria.findByCodchamadacredora", query = "SELECT c FROM Contabancaria c WHERE c.codchamadacredora = :codchamadacredora")
    , @NamedQuery(name = "Contabancaria.findByCodhistoricopadrao", query = "SELECT c FROM Contabancaria c WHERE c.codhistoricopadrao = :codhistoricopadrao")})
public class Contabancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTABANCARIA")
    private String codcontabancaria;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMEROCONTA")
    private String numeroconta;
    @Column(name = "DVCONTA")
    private String dvconta;
    @Column(name = "CODIGOCEDENTE")
    private String codigocedente;
    @Column(name = "CODIGOCLIENTEBANCO")
    private String codigoclientebanco;
    @Column(name = "CARTEIRA")
    private String carteira;
    @Column(name = "NUMEROCONVENIO")
    private String numeroconvenio;
    @Column(name = "NAOPREENCHERNOSSONUMERO")
    private Character naopreenchernossonumero;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "IDLAYOUTBOLETO")
    private String idlayoutboleto;
    @Column(name = "NOMETITULAR")
    private String nometitular;
    @Column(name = "NUMEROAGENCIA")
    private String numeroagencia;
    @Column(name = "DVAGENCIA")
    private String dvagencia;
    @Column(name = "CNPJCPFFAVORECIDO")
    private String cnpjcpffavorecido;
    @Column(name = "SEQUENCIAL")
    private BigInteger sequencial;
    @Column(name = "NOMECONTABANCARIA")
    private String nomecontabancaria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAXA")
    private BigDecimal taxa;
    @Column(name = "CODCONTABANCARIAAUX")
    private String codcontabancariaaux;
    @Column(name = "SEQUENCIALDIARIO")
    private Integer sequencialdiario;
    @Column(name = "SEQUENCIALREMESSA")
    private Integer sequencialremessa;
    @Column(name = "DATAULTIMASEQUENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataultimasequencia;
    @Column(name = "FLAGNAOGERARNOSSONUMERO")
    private Character flagnaogerarnossonumero;
    @Column(name = "FLAGBANCOEMITEBOLETO")
    private Character flagbancoemiteboleto;
    @Column(name = "VALOREMISSAOPADRAO")
    private String valoremissaopadrao;
    @Column(name = "VALOREMISSAOBANCO")
    private String valoremissaobanco;
    @Column(name = "VALOREMISSAOEMPRESA")
    private String valoremissaoempresa;
    @Lob
    @Column(name = "INSTRUCOESCOBRANCA")
    private String instrucoescobranca;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "VARIACAOCARTEIRA")
    private String variacaocarteira;
    @Column(name = "CODMONTAGEMARQUIVO")
    private String codmontagemarquivo;
    @Column(name = "CAMINHOREMESSA")
    private String caminhoremessa;
    @Column(name = "LAYOUTCNAB")
    private Character layoutcnab;
    @Column(name = "TAMANHODVRETORNO")
    private Integer tamanhodvretorno;
    @Lob
    @Column(name = "LICENCACOBREBEM")
    private String licencacobrebem;
    @Column(name = "DIASPROTESTO")
    private Integer diasprotesto;
    @Column(name = "DADOSCONFIG1")
    private String dadosconfig1;
    @Column(name = "DADOSCONFIG2")
    private String dadosconfig2;
    @Column(name = "DADOSCONFIG3")
    private String dadosconfig3;
    @Column(name = "DADOSCONFIG4")
    private String dadosconfig4;
    @Column(name = "DADOSCONFIG5")
    private String dadosconfig5;
    @Column(name = "INICIONOSSONUMERO")
    private String inicionossonumero;
    @Column(name = "FIMNOSSONUMERO")
    private String fimnossonumero;
    @Column(name = "PARAMETROSADICIONAIS")
    private String parametrosadicionais;
    @Column(name = "TAMANHOPREFIXORETORNO")
    private Integer tamanhoprefixoretorno;
    @Column(name = "ACEITE")
    private Character aceite;
    @Column(name = "CODCHAMADACREDORA")
    private String codchamadacredora;
    @Column(name = "CODHISTORICOPADRAO")
    private String codhistoricopadrao;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Chequesfirma> chequesfirmaCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Contapagarpag> contapagarpagCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Contareceberfixa> contareceberfixaCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Recebimento> recebimentoCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Contareceber> contareceberCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Contratocobranca> contratocobrancaCollection;
    @OneToMany(mappedBy = "codcontabancaria")
    private Collection<Orcamento> orcamentoCollection;
    @JoinColumn(name = "CODBANCO", referencedColumnName = "CODBANCO")
    @ManyToOne
    private Banco codbanco;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODCALCULODV", referencedColumnName = "CODCALCULODV")
    @ManyToOne
    private Calculodv codcalculodv;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcontabancaria")
    private Collection<Historicocarteira> historicocarteiraCollection;

    public Contabancaria() {
    }

    public Contabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public String getCodcontabancaria() {
        return codcontabancaria;
    }

    public void setCodcontabancaria(String codcontabancaria) {
        this.codcontabancaria = codcontabancaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroconta() {
        return numeroconta;
    }

    public void setNumeroconta(String numeroconta) {
        this.numeroconta = numeroconta;
    }

    public String getDvconta() {
        return dvconta;
    }

    public void setDvconta(String dvconta) {
        this.dvconta = dvconta;
    }

    public String getCodigocedente() {
        return codigocedente;
    }

    public void setCodigocedente(String codigocedente) {
        this.codigocedente = codigocedente;
    }

    public String getCodigoclientebanco() {
        return codigoclientebanco;
    }

    public void setCodigoclientebanco(String codigoclientebanco) {
        this.codigoclientebanco = codigoclientebanco;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getNumeroconvenio() {
        return numeroconvenio;
    }

    public void setNumeroconvenio(String numeroconvenio) {
        this.numeroconvenio = numeroconvenio;
    }

    public Character getNaopreenchernossonumero() {
        return naopreenchernossonumero;
    }

    public void setNaopreenchernossonumero(Character naopreenchernossonumero) {
        this.naopreenchernossonumero = naopreenchernossonumero;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public String getIdlayoutboleto() {
        return idlayoutboleto;
    }

    public void setIdlayoutboleto(String idlayoutboleto) {
        this.idlayoutboleto = idlayoutboleto;
    }

    public String getNometitular() {
        return nometitular;
    }

    public void setNometitular(String nometitular) {
        this.nometitular = nometitular;
    }

    public String getNumeroagencia() {
        return numeroagencia;
    }

    public void setNumeroagencia(String numeroagencia) {
        this.numeroagencia = numeroagencia;
    }

    public String getDvagencia() {
        return dvagencia;
    }

    public void setDvagencia(String dvagencia) {
        this.dvagencia = dvagencia;
    }

    public String getCnpjcpffavorecido() {
        return cnpjcpffavorecido;
    }

    public void setCnpjcpffavorecido(String cnpjcpffavorecido) {
        this.cnpjcpffavorecido = cnpjcpffavorecido;
    }

    public BigInteger getSequencial() {
        return sequencial;
    }

    public void setSequencial(BigInteger sequencial) {
        this.sequencial = sequencial;
    }

    public String getNomecontabancaria() {
        return nomecontabancaria;
    }

    public void setNomecontabancaria(String nomecontabancaria) {
        this.nomecontabancaria = nomecontabancaria;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public String getCodcontabancariaaux() {
        return codcontabancariaaux;
    }

    public void setCodcontabancariaaux(String codcontabancariaaux) {
        this.codcontabancariaaux = codcontabancariaaux;
    }

    public Integer getSequencialdiario() {
        return sequencialdiario;
    }

    public void setSequencialdiario(Integer sequencialdiario) {
        this.sequencialdiario = sequencialdiario;
    }

    public Integer getSequencialremessa() {
        return sequencialremessa;
    }

    public void setSequencialremessa(Integer sequencialremessa) {
        this.sequencialremessa = sequencialremessa;
    }

    public Date getDataultimasequencia() {
        return dataultimasequencia;
    }

    public void setDataultimasequencia(Date dataultimasequencia) {
        this.dataultimasequencia = dataultimasequencia;
    }

    public Character getFlagnaogerarnossonumero() {
        return flagnaogerarnossonumero;
    }

    public void setFlagnaogerarnossonumero(Character flagnaogerarnossonumero) {
        this.flagnaogerarnossonumero = flagnaogerarnossonumero;
    }

    public Character getFlagbancoemiteboleto() {
        return flagbancoemiteboleto;
    }

    public void setFlagbancoemiteboleto(Character flagbancoemiteboleto) {
        this.flagbancoemiteboleto = flagbancoemiteboleto;
    }

    public String getValoremissaopadrao() {
        return valoremissaopadrao;
    }

    public void setValoremissaopadrao(String valoremissaopadrao) {
        this.valoremissaopadrao = valoremissaopadrao;
    }

    public String getValoremissaobanco() {
        return valoremissaobanco;
    }

    public void setValoremissaobanco(String valoremissaobanco) {
        this.valoremissaobanco = valoremissaobanco;
    }

    public String getValoremissaoempresa() {
        return valoremissaoempresa;
    }

    public void setValoremissaoempresa(String valoremissaoempresa) {
        this.valoremissaoempresa = valoremissaoempresa;
    }

    public String getInstrucoescobranca() {
        return instrucoescobranca;
    }

    public void setInstrucoescobranca(String instrucoescobranca) {
        this.instrucoescobranca = instrucoescobranca;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getVariacaocarteira() {
        return variacaocarteira;
    }

    public void setVariacaocarteira(String variacaocarteira) {
        this.variacaocarteira = variacaocarteira;
    }

    public String getCodmontagemarquivo() {
        return codmontagemarquivo;
    }

    public void setCodmontagemarquivo(String codmontagemarquivo) {
        this.codmontagemarquivo = codmontagemarquivo;
    }

    public String getCaminhoremessa() {
        return caminhoremessa;
    }

    public void setCaminhoremessa(String caminhoremessa) {
        this.caminhoremessa = caminhoremessa;
    }

    public Character getLayoutcnab() {
        return layoutcnab;
    }

    public void setLayoutcnab(Character layoutcnab) {
        this.layoutcnab = layoutcnab;
    }

    public Integer getTamanhodvretorno() {
        return tamanhodvretorno;
    }

    public void setTamanhodvretorno(Integer tamanhodvretorno) {
        this.tamanhodvretorno = tamanhodvretorno;
    }

    public String getLicencacobrebem() {
        return licencacobrebem;
    }

    public void setLicencacobrebem(String licencacobrebem) {
        this.licencacobrebem = licencacobrebem;
    }

    public Integer getDiasprotesto() {
        return diasprotesto;
    }

    public void setDiasprotesto(Integer diasprotesto) {
        this.diasprotesto = diasprotesto;
    }

    public String getDadosconfig1() {
        return dadosconfig1;
    }

    public void setDadosconfig1(String dadosconfig1) {
        this.dadosconfig1 = dadosconfig1;
    }

    public String getDadosconfig2() {
        return dadosconfig2;
    }

    public void setDadosconfig2(String dadosconfig2) {
        this.dadosconfig2 = dadosconfig2;
    }

    public String getDadosconfig3() {
        return dadosconfig3;
    }

    public void setDadosconfig3(String dadosconfig3) {
        this.dadosconfig3 = dadosconfig3;
    }

    public String getDadosconfig4() {
        return dadosconfig4;
    }

    public void setDadosconfig4(String dadosconfig4) {
        this.dadosconfig4 = dadosconfig4;
    }

    public String getDadosconfig5() {
        return dadosconfig5;
    }

    public void setDadosconfig5(String dadosconfig5) {
        this.dadosconfig5 = dadosconfig5;
    }

    public String getInicionossonumero() {
        return inicionossonumero;
    }

    public void setInicionossonumero(String inicionossonumero) {
        this.inicionossonumero = inicionossonumero;
    }

    public String getFimnossonumero() {
        return fimnossonumero;
    }

    public void setFimnossonumero(String fimnossonumero) {
        this.fimnossonumero = fimnossonumero;
    }

    public String getParametrosadicionais() {
        return parametrosadicionais;
    }

    public void setParametrosadicionais(String parametrosadicionais) {
        this.parametrosadicionais = parametrosadicionais;
    }

    public Integer getTamanhoprefixoretorno() {
        return tamanhoprefixoretorno;
    }

    public void setTamanhoprefixoretorno(Integer tamanhoprefixoretorno) {
        this.tamanhoprefixoretorno = tamanhoprefixoretorno;
    }

    public Character getAceite() {
        return aceite;
    }

    public void setAceite(Character aceite) {
        this.aceite = aceite;
    }

    public String getCodchamadacredora() {
        return codchamadacredora;
    }

    public void setCodchamadacredora(String codchamadacredora) {
        this.codchamadacredora = codchamadacredora;
    }

    public String getCodhistoricopadrao() {
        return codhistoricopadrao;
    }

    public void setCodhistoricopadrao(String codhistoricopadrao) {
        this.codhistoricopadrao = codhistoricopadrao;
    }

    @XmlTransient
    public Collection<Chequesfirma> getChequesfirmaCollection() {
        return chequesfirmaCollection;
    }

    public void setChequesfirmaCollection(Collection<Chequesfirma> chequesfirmaCollection) {
        this.chequesfirmaCollection = chequesfirmaCollection;
    }

    @XmlTransient
    public Collection<Contapagarpag> getContapagarpagCollection() {
        return contapagarpagCollection;
    }

    public void setContapagarpagCollection(Collection<Contapagarpag> contapagarpagCollection) {
        this.contapagarpagCollection = contapagarpagCollection;
    }

    @XmlTransient
    public Collection<Contareceberfixa> getContareceberfixaCollection() {
        return contareceberfixaCollection;
    }

    public void setContareceberfixaCollection(Collection<Contareceberfixa> contareceberfixaCollection) {
        this.contareceberfixaCollection = contareceberfixaCollection;
    }

    @XmlTransient
    public Collection<Recebimento> getRecebimentoCollection() {
        return recebimentoCollection;
    }

    public void setRecebimentoCollection(Collection<Recebimento> recebimentoCollection) {
        this.recebimentoCollection = recebimentoCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @XmlTransient
    public Collection<Contratocobranca> getContratocobrancaCollection() {
        return contratocobrancaCollection;
    }

    public void setContratocobrancaCollection(Collection<Contratocobranca> contratocobrancaCollection) {
        this.contratocobrancaCollection = contratocobrancaCollection;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    public Banco getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(Banco codbanco) {
        this.codbanco = codbanco;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Calculodv getCodcalculodv() {
        return codcalculodv;
    }

    public void setCodcalculodv(Calculodv codcalculodv) {
        this.codcalculodv = codcalculodv;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    @XmlTransient
    public Collection<Historicocarteira> getHistoricocarteiraCollection() {
        return historicocarteiraCollection;
    }

    public void setHistoricocarteiraCollection(Collection<Historicocarteira> historicocarteiraCollection) {
        this.historicocarteiraCollection = historicocarteiraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontabancaria != null ? codcontabancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contabancaria)) {
            return false;
        }
        Contabancaria other = (Contabancaria) object;
        if ((this.codcontabancaria == null && other.codcontabancaria != null) || (this.codcontabancaria != null && !this.codcontabancaria.equals(other.codcontabancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contabancaria[ codcontabancaria=" + codcontabancaria + " ]";
    }
    
}
