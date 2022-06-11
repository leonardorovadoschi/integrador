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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MOVENDAREC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movendarec.findAll", query = "SELECT m FROM Movendarec m")
    , @NamedQuery(name = "Movendarec.findById", query = "SELECT m FROM Movendarec m WHERE m.id = :id")
    , @NamedQuery(name = "Movendarec.findByValor", query = "SELECT m FROM Movendarec m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movendarec.findByNumparcelas", query = "SELECT m FROM Movendarec m WHERE m.numparcelas = :numparcelas")
    , @NamedQuery(name = "Movendarec.findByNumparcelasrecebimento", query = "SELECT m FROM Movendarec m WHERE m.numparcelasrecebimento = :numparcelasrecebimento")
    , @NamedQuery(name = "Movendarec.findByNumdiasprimeiraparcelavenda", query = "SELECT m FROM Movendarec m WHERE m.numdiasprimeiraparcelavenda = :numdiasprimeiraparcelavenda")
    , @NamedQuery(name = "Movendarec.findByNumdiasrecebimento", query = "SELECT m FROM Movendarec m WHERE m.numdiasrecebimento = :numdiasrecebimento")
    , @NamedQuery(name = "Movendarec.findByNumdiasintervalo", query = "SELECT m FROM Movendarec m WHERE m.numdiasintervalo = :numdiasintervalo")
    , @NamedQuery(name = "Movendarec.findByValortacconvenio", query = "SELECT m FROM Movendarec m WHERE m.valortacconvenio = :valortacconvenio")
    , @NamedQuery(name = "Movendarec.findByAliqtacconvenio", query = "SELECT m FROM Movendarec m WHERE m.aliqtacconvenio = :aliqtacconvenio")
    , @NamedQuery(name = "Movendarec.findByAliqconvenio", query = "SELECT m FROM Movendarec m WHERE m.aliqconvenio = :aliqconvenio")
    , @NamedQuery(name = "Movendarec.findByCodcli", query = "SELECT m FROM Movendarec m WHERE m.codcli = :codcli")
    , @NamedQuery(name = "Movendarec.findByNumcartao", query = "SELECT m FROM Movendarec m WHERE m.numcartao = :numcartao")
    , @NamedQuery(name = "Movendarec.findByGuid", query = "SELECT m FROM Movendarec m WHERE m.guid = :guid")
    , @NamedQuery(name = "Movendarec.findByFlagtrocotef", query = "SELECT m FROM Movendarec m WHERE m.flagtrocotef = :flagtrocotef")
    , @NamedQuery(name = "Movendarec.findByNsu", query = "SELECT m FROM Movendarec m WHERE m.nsu = :nsu")
    , @NamedQuery(name = "Movendarec.findByRede", query = "SELECT m FROM Movendarec m WHERE m.rede = :rede")
    , @NamedQuery(name = "Movendarec.findByTipoparcelamento", query = "SELECT m FROM Movendarec m WHERE m.tipoparcelamento = :tipoparcelamento")
    , @NamedQuery(name = "Movendarec.findByAutorizacaotef", query = "SELECT m FROM Movendarec m WHERE m.autorizacaotef = :autorizacaotef")
    , @NamedQuery(name = "Movendarec.findByValorsaquecartao", query = "SELECT m FROM Movendarec m WHERE m.valorsaquecartao = :valorsaquecartao")
    , @NamedQuery(name = "Movendarec.findByCodpessoa", query = "SELECT m FROM Movendarec m WHERE m.codpessoa = :codpessoa")
    , @NamedQuery(name = "Movendarec.findByFlagdoacao", query = "SELECT m FROM Movendarec m WHERE m.flagdoacao = :flagdoacao")
    , @NamedQuery(name = "Movendarec.findByNomecartao", query = "SELECT m FROM Movendarec m WHERE m.nomecartao = :nomecartao")
    , @NamedQuery(name = "Movendarec.findByFinalizacao", query = "SELECT m FROM Movendarec m WHERE m.finalizacao = :finalizacao")
    , @NamedQuery(name = "Movendarec.findByCodtipotransacao", query = "SELECT m FROM Movendarec m WHERE m.codtipotransacao = :codtipotransacao")
    , @NamedQuery(name = "Movendarec.findByDatatransacao", query = "SELECT m FROM Movendarec m WHERE m.datatransacao = :datatransacao")
    , @NamedQuery(name = "Movendarec.findByHoratransacao", query = "SELECT m FROM Movendarec m WHERE m.horatransacao = :horatransacao")
    , @NamedQuery(name = "Movendarec.findByCnpjcredenciadoracartao", query = "SELECT m FROM Movendarec m WHERE m.cnpjcredenciadoracartao = :cnpjcredenciadoracartao")
    , @NamedQuery(name = "Movendarec.findByCnpjentidadefilantropica", query = "SELECT m FROM Movendarec m WHERE m.cnpjentidadefilantropica = :cnpjentidadefilantropica")
    , @NamedQuery(name = "Movendarec.findByTitulocaptalizacaocartao", query = "SELECT m FROM Movendarec m WHERE m.titulocaptalizacaocartao = :titulocaptalizacaocartao")
    , @NamedQuery(name = "Movendarec.findByCodvfpe", query = "SELECT m FROM Movendarec m WHERE m.codvfpe = :codvfpe")
    , @NamedQuery(name = "Movendarec.findByValordevido", query = "SELECT m FROM Movendarec m WHERE m.valordevido = :valordevido")
    , @NamedQuery(name = "Movendarec.findByValororiginal", query = "SELECT m FROM Movendarec m WHERE m.valororiginal = :valororiginal")
    , @NamedQuery(name = "Movendarec.findByValorreajustado", query = "SELECT m FROM Movendarec m WHERE m.valorreajustado = :valorreajustado")
    , @NamedQuery(name = "Movendarec.findByValordescontocartao", query = "SELECT m FROM Movendarec m WHERE m.valordescontocartao = :valordescontocartao")
    , @NamedQuery(name = "Movendarec.findByFlagaltpaf", query = "SELECT m FROM Movendarec m WHERE m.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Movendarec.findByIdterminal", query = "SELECT m FROM Movendarec m WHERE m.idterminal = :idterminal")
    , @NamedQuery(name = "Movendarec.findByIdestabelecimento", query = "SELECT m FROM Movendarec m WHERE m.idestabelecimento = :idestabelecimento")})
public class Movendarec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "NUMPARCELAS")
    private Integer numparcelas;
    @Column(name = "NUMPARCELASRECEBIMENTO")
    private Integer numparcelasrecebimento;
    @Column(name = "NUMDIASPRIMEIRAPARCELAVENDA")
    private Integer numdiasprimeiraparcelavenda;
    @Column(name = "NUMDIASRECEBIMENTO")
    private Integer numdiasrecebimento;
    @Column(name = "NUMDIASINTERVALO")
    private Integer numdiasintervalo;
    @Column(name = "VALORTACCONVENIO")
    private BigDecimal valortacconvenio;
    @Column(name = "ALIQTACCONVENIO")
    private BigDecimal aliqtacconvenio;
    @Column(name = "ALIQCONVENIO")
    private BigDecimal aliqconvenio;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "NUMCARTAO")
    private String numcartao;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "FLAGTROCOTEF")
    private Character flagtrocotef;
    @Column(name = "NSU")
    private String nsu;
    @Column(name = "REDE")
    private String rede;
    @Column(name = "TIPOPARCELAMENTO")
    private Character tipoparcelamento;
    @Column(name = "AUTORIZACAOTEF")
    private String autorizacaotef;
    @Column(name = "VALORSAQUECARTAO")
    private BigDecimal valorsaquecartao;
    @Column(name = "CODPESSOA")
    private String codpessoa;
    @Column(name = "FLAGDOACAO")
    private Character flagdoacao;
    @Column(name = "NOMECARTAO")
    private String nomecartao;
    @Column(name = "FINALIZACAO")
    private String finalizacao;
    @Column(name = "CODTIPOTRANSACAO")
    private Short codtipotransacao;
    @Column(name = "DATATRANSACAO")
    @Temporal(TemporalType.DATE)
    private Date datatransacao;
    @Column(name = "HORATRANSACAO")
    @Temporal(TemporalType.TIME)
    private Date horatransacao;
    @Column(name = "CNPJCREDENCIADORACARTAO")
    private String cnpjcredenciadoracartao;
    @Column(name = "CNPJENTIDADEFILANTROPICA")
    private String cnpjentidadefilantropica;
    @Column(name = "TITULOCAPTALIZACAOCARTAO")
    private String titulocaptalizacaocartao;
    @Column(name = "CODVFPE")
    private String codvfpe;
    @Column(name = "VALORDEVIDO")
    private BigDecimal valordevido;
    @Column(name = "VALORORIGINAL")
    private BigDecimal valororiginal;
    @Column(name = "VALORREAJUSTADO")
    private BigDecimal valorreajustado;
    @Column(name = "VALORDESCONTOCARTAO")
    private BigDecimal valordescontocartao;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "IDTERMINAL")
    private String idterminal;
    @Column(name = "IDESTABELECIMENTO")
    private String idestabelecimento;
    @JoinColumn(name = "CODMOVENDA", referencedColumnName = "CODMOVENDA")
    @ManyToOne(optional = false)
    private Movenda codmovenda;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne(optional = false)
    private Recebimento codrec;

    public Movendarec() {
    }

    public Movendarec(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getNumparcelas() {
        return numparcelas;
    }

    public void setNumparcelas(Integer numparcelas) {
        this.numparcelas = numparcelas;
    }

    public Integer getNumparcelasrecebimento() {
        return numparcelasrecebimento;
    }

    public void setNumparcelasrecebimento(Integer numparcelasrecebimento) {
        this.numparcelasrecebimento = numparcelasrecebimento;
    }

    public Integer getNumdiasprimeiraparcelavenda() {
        return numdiasprimeiraparcelavenda;
    }

    public void setNumdiasprimeiraparcelavenda(Integer numdiasprimeiraparcelavenda) {
        this.numdiasprimeiraparcelavenda = numdiasprimeiraparcelavenda;
    }

    public Integer getNumdiasrecebimento() {
        return numdiasrecebimento;
    }

    public void setNumdiasrecebimento(Integer numdiasrecebimento) {
        this.numdiasrecebimento = numdiasrecebimento;
    }

    public Integer getNumdiasintervalo() {
        return numdiasintervalo;
    }

    public void setNumdiasintervalo(Integer numdiasintervalo) {
        this.numdiasintervalo = numdiasintervalo;
    }

    public BigDecimal getValortacconvenio() {
        return valortacconvenio;
    }

    public void setValortacconvenio(BigDecimal valortacconvenio) {
        this.valortacconvenio = valortacconvenio;
    }

    public BigDecimal getAliqtacconvenio() {
        return aliqtacconvenio;
    }

    public void setAliqtacconvenio(BigDecimal aliqtacconvenio) {
        this.aliqtacconvenio = aliqtacconvenio;
    }

    public BigDecimal getAliqconvenio() {
        return aliqconvenio;
    }

    public void setAliqconvenio(BigDecimal aliqconvenio) {
        this.aliqconvenio = aliqconvenio;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getNumcartao() {
        return numcartao;
    }

    public void setNumcartao(String numcartao) {
        this.numcartao = numcartao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getFlagtrocotef() {
        return flagtrocotef;
    }

    public void setFlagtrocotef(Character flagtrocotef) {
        this.flagtrocotef = flagtrocotef;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getRede() {
        return rede;
    }

    public void setRede(String rede) {
        this.rede = rede;
    }

    public Character getTipoparcelamento() {
        return tipoparcelamento;
    }

    public void setTipoparcelamento(Character tipoparcelamento) {
        this.tipoparcelamento = tipoparcelamento;
    }

    public String getAutorizacaotef() {
        return autorizacaotef;
    }

    public void setAutorizacaotef(String autorizacaotef) {
        this.autorizacaotef = autorizacaotef;
    }

    public BigDecimal getValorsaquecartao() {
        return valorsaquecartao;
    }

    public void setValorsaquecartao(BigDecimal valorsaquecartao) {
        this.valorsaquecartao = valorsaquecartao;
    }

    public String getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(String codpessoa) {
        this.codpessoa = codpessoa;
    }

    public Character getFlagdoacao() {
        return flagdoacao;
    }

    public void setFlagdoacao(Character flagdoacao) {
        this.flagdoacao = flagdoacao;
    }

    public String getNomecartao() {
        return nomecartao;
    }

    public void setNomecartao(String nomecartao) {
        this.nomecartao = nomecartao;
    }

    public String getFinalizacao() {
        return finalizacao;
    }

    public void setFinalizacao(String finalizacao) {
        this.finalizacao = finalizacao;
    }

    public Short getCodtipotransacao() {
        return codtipotransacao;
    }

    public void setCodtipotransacao(Short codtipotransacao) {
        this.codtipotransacao = codtipotransacao;
    }

    public Date getDatatransacao() {
        return datatransacao;
    }

    public void setDatatransacao(Date datatransacao) {
        this.datatransacao = datatransacao;
    }

    public Date getHoratransacao() {
        return horatransacao;
    }

    public void setHoratransacao(Date horatransacao) {
        this.horatransacao = horatransacao;
    }

    public String getCnpjcredenciadoracartao() {
        return cnpjcredenciadoracartao;
    }

    public void setCnpjcredenciadoracartao(String cnpjcredenciadoracartao) {
        this.cnpjcredenciadoracartao = cnpjcredenciadoracartao;
    }

    public String getCnpjentidadefilantropica() {
        return cnpjentidadefilantropica;
    }

    public void setCnpjentidadefilantropica(String cnpjentidadefilantropica) {
        this.cnpjentidadefilantropica = cnpjentidadefilantropica;
    }

    public String getTitulocaptalizacaocartao() {
        return titulocaptalizacaocartao;
    }

    public void setTitulocaptalizacaocartao(String titulocaptalizacaocartao) {
        this.titulocaptalizacaocartao = titulocaptalizacaocartao;
    }

    public String getCodvfpe() {
        return codvfpe;
    }

    public void setCodvfpe(String codvfpe) {
        this.codvfpe = codvfpe;
    }

    public BigDecimal getValordevido() {
        return valordevido;
    }

    public void setValordevido(BigDecimal valordevido) {
        this.valordevido = valordevido;
    }

    public BigDecimal getValororiginal() {
        return valororiginal;
    }

    public void setValororiginal(BigDecimal valororiginal) {
        this.valororiginal = valororiginal;
    }

    public BigDecimal getValorreajustado() {
        return valorreajustado;
    }

    public void setValorreajustado(BigDecimal valorreajustado) {
        this.valorreajustado = valorreajustado;
    }

    public BigDecimal getValordescontocartao() {
        return valordescontocartao;
    }

    public void setValordescontocartao(BigDecimal valordescontocartao) {
        this.valordescontocartao = valordescontocartao;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getIdterminal() {
        return idterminal;
    }

    public void setIdterminal(String idterminal) {
        this.idterminal = idterminal;
    }

    public String getIdestabelecimento() {
        return idestabelecimento;
    }

    public void setIdestabelecimento(String idestabelecimento) {
        this.idestabelecimento = idestabelecimento;
    }

    public Movenda getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(Movenda codmovenda) {
        this.codmovenda = codmovenda;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movendarec)) {
            return false;
        }
        Movendarec other = (Movendarec) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movendarec[ id=" + id + " ]";
    }
    
}
