/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "TERMINAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t")
    , @NamedQuery(name = "Terminal.findByCodterminal", query = "SELECT t FROM Terminal t WHERE t.codterminal = :codterminal")
    , @NamedQuery(name = "Terminal.findByCodigo", query = "SELECT t FROM Terminal t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Terminal.findByNometerminal", query = "SELECT t FROM Terminal t WHERE t.nometerminal = :nometerminal")
    , @NamedQuery(name = "Terminal.findByCoddocumentocaixaabertura", query = "SELECT t FROM Terminal t WHERE t.coddocumentocaixaabertura = :coddocumentocaixaabertura")
    , @NamedQuery(name = "Terminal.findByStatusterminal", query = "SELECT t FROM Terminal t WHERE t.statusterminal = :statusterminal")
    , @NamedQuery(name = "Terminal.findByCoduser", query = "SELECT t FROM Terminal t WHERE t.coduser = :coduser")
    , @NamedQuery(name = "Terminal.findByPortaimpressora", query = "SELECT t FROM Terminal t WHERE t.portaimpressora = :portaimpressora")
    , @NamedQuery(name = "Terminal.findByDriverimpressora", query = "SELECT t FROM Terminal t WHERE t.driverimpressora = :driverimpressora")
    , @NamedQuery(name = "Terminal.findByModeloimpressora", query = "SELECT t FROM Terminal t WHERE t.modeloimpressora = :modeloimpressora")
    , @NamedQuery(name = "Terminal.findByRtmimpressora", query = "SELECT t FROM Terminal t WHERE t.rtmimpressora = :rtmimpressora")
    , @NamedQuery(name = "Terminal.findByRtmgerencial", query = "SELECT t FROM Terminal t WHERE t.rtmgerencial = :rtmgerencial")
    , @NamedQuery(name = "Terminal.findByDriverleitor", query = "SELECT t FROM Terminal t WHERE t.driverleitor = :driverleitor")
    , @NamedQuery(name = "Terminal.findByPortaleitor", query = "SELECT t FROM Terminal t WHERE t.portaleitor = :portaleitor")
    , @NamedQuery(name = "Terminal.findByDriverbalanca", query = "SELECT t FROM Terminal t WHERE t.driverbalanca = :driverbalanca")
    , @NamedQuery(name = "Terminal.findByPortabalanca", query = "SELECT t FROM Terminal t WHERE t.portabalanca = :portabalanca")
    , @NamedQuery(name = "Terminal.findByDriverdisplay", query = "SELECT t FROM Terminal t WHERE t.driverdisplay = :driverdisplay")
    , @NamedQuery(name = "Terminal.findByPortadisplay", query = "SELECT t FROM Terminal t WHERE t.portadisplay = :portadisplay")
    , @NamedQuery(name = "Terminal.findByCodecf", query = "SELECT t FROM Terminal t WHERE t.codecf = :codecf")
    , @NamedQuery(name = "Terminal.findByFlagusatef", query = "SELECT t FROM Terminal t WHERE t.flagusatef = :flagusatef")
    , @NamedQuery(name = "Terminal.findByCodempresa", query = "SELECT t FROM Terminal t WHERE t.codempresa = :codempresa")
    , @NamedQuery(name = "Terminal.findByCodsetorestoque", query = "SELECT t FROM Terminal t WHERE t.codsetorestoque = :codsetorestoque")
    , @NamedQuery(name = "Terminal.findByTipoarredondamento", query = "SELECT t FROM Terminal t WHERE t.tipoarredondamento = :tipoarredondamento")
    , @NamedQuery(name = "Terminal.findByModelobalanca", query = "SELECT t FROM Terminal t WHERE t.modelobalanca = :modelobalanca")
    , @NamedQuery(name = "Terminal.findByBaudratebalanca", query = "SELECT t FROM Terminal t WHERE t.baudratebalanca = :baudratebalanca")
    , @NamedQuery(name = "Terminal.findByFlagaltpaf", query = "SELECT t FROM Terminal t WHERE t.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Terminal.findByNumeroserieecf", query = "SELECT t FROM Terminal t WHERE t.numeroserieecf = :numeroserieecf")
    , @NamedQuery(name = "Terminal.findByCodplupdvpendente", query = "SELECT t FROM Terminal t WHERE t.codplupdvpendente = :codplupdvpendente")
    , @NamedQuery(name = "Terminal.findByCodplupdvatual", query = "SELECT t FROM Terminal t WHERE t.codplupdvatual = :codplupdvatual")
    , @NamedQuery(name = "Terminal.findByCodcomputador", query = "SELECT t FROM Terminal t WHERE t.codcomputador = :codcomputador")
    , @NamedQuery(name = "Terminal.findByUltimacomunicacao", query = "SELECT t FROM Terminal t WHERE t.ultimacomunicacao = :ultimacomunicacao")
    , @NamedQuery(name = "Terminal.findByUltimaplu", query = "SELECT t FROM Terminal t WHERE t.ultimaplu = :ultimaplu")
    , @NamedQuery(name = "Terminal.findByFlagnfce", query = "SELECT t FROM Terminal t WHERE t.flagnfce = :flagnfce")
    , @NamedQuery(name = "Terminal.findBySerienfce", query = "SELECT t FROM Terminal t WHERE t.serienfce = :serienfce")
    , @NamedQuery(name = "Terminal.findByCodsat", query = "SELECT t FROM Terminal t WHERE t.codsat = :codsat")
    , @NamedQuery(name = "Terminal.findByCodpos", query = "SELECT t FROM Terminal t WHERE t.codpos = :codpos")
    , @NamedQuery(name = "Terminal.findByFlagantifraudepos", query = "SELECT t FROM Terminal t WHERE t.flagantifraudepos = :flagantifraudepos")
    , @NamedQuery(name = "Terminal.findBySerienfceoffline", query = "SELECT t FROM Terminal t WHERE t.serienfceoffline = :serienfceoffline")})
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTERMINAL")
    private String codterminal;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMETERMINAL")
    private String nometerminal;
    @Column(name = "CODDOCUMENTOCAIXAABERTURA")
    private String coddocumentocaixaabertura;
    @Column(name = "STATUSTERMINAL")
    private Character statusterminal;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "PORTAIMPRESSORA")
    private String portaimpressora;
    @Column(name = "DRIVERIMPRESSORA")
    private String driverimpressora;
    @Column(name = "MODELOIMPRESSORA")
    private String modeloimpressora;
    @Column(name = "RTMIMPRESSORA")
    private String rtmimpressora;
    @Column(name = "RTMGERENCIAL")
    private String rtmgerencial;
    @Column(name = "DRIVERLEITOR")
    private String driverleitor;
    @Column(name = "PORTALEITOR")
    private String portaleitor;
    @Column(name = "DRIVERBALANCA")
    private String driverbalanca;
    @Column(name = "PORTABALANCA")
    private String portabalanca;
    @Column(name = "DRIVERDISPLAY")
    private String driverdisplay;
    @Column(name = "PORTADISPLAY")
    private String portadisplay;
    @Column(name = "CODECF")
    private String codecf;
    @Column(name = "FLAGUSATEF")
    private Character flagusatef;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODSETORESTOQUE")
    private String codsetorestoque;
    @Column(name = "TIPOARREDONDAMENTO")
    private Character tipoarredondamento;
    @Column(name = "MODELOBALANCA")
    private String modelobalanca;
    @Column(name = "BAUDRATEBALANCA")
    private String baudratebalanca;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "NUMEROSERIEECF")
    private String numeroserieecf;
    @Column(name = "CODPLUPDVPENDENTE")
    private String codplupdvpendente;
    @Column(name = "CODPLUPDVATUAL")
    private String codplupdvatual;
    @Column(name = "CODCOMPUTADOR")
    private String codcomputador;
    @Column(name = "ULTIMACOMUNICACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimacomunicacao;
    @Column(name = "ULTIMAPLU")
    private Integer ultimaplu;
    @Column(name = "FLAGNFCE")
    private Character flagnfce;
    @Column(name = "SERIENFCE")
    private Short serienfce;
    @Column(name = "CODSAT")
    private String codsat;
    @Column(name = "CODPOS")
    private String codpos;
    @Column(name = "FLAGANTIFRAUDEPOS")
    private Character flagantifraudepos;
    @Column(name = "SERIENFCEOFFLINE")
    private Short serienfceoffline;
    @JoinColumn(name = "CODCAIXAS", referencedColumnName = "CODCAIXAS")
    @ManyToOne
    private Caixas codcaixas;
    @JoinColumn(name = "CODPC", referencedColumnName = "CODPC")
    @ManyToOne
    private Planoconta codpc;
    @OneToMany(mappedBy = "codterminal")
    private Collection<Movenda> movendaCollection;

    public Terminal() {
    }

    public Terminal(String codterminal) {
        this.codterminal = codterminal;
    }

    public Terminal(String codterminal, String codigo, String nometerminal) {
        this.codterminal = codterminal;
        this.codigo = codigo;
        this.nometerminal = nometerminal;
    }

    public String getCodterminal() {
        return codterminal;
    }

    public void setCodterminal(String codterminal) {
        this.codterminal = codterminal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometerminal() {
        return nometerminal;
    }

    public void setNometerminal(String nometerminal) {
        this.nometerminal = nometerminal;
    }

    public String getCoddocumentocaixaabertura() {
        return coddocumentocaixaabertura;
    }

    public void setCoddocumentocaixaabertura(String coddocumentocaixaabertura) {
        this.coddocumentocaixaabertura = coddocumentocaixaabertura;
    }

    public Character getStatusterminal() {
        return statusterminal;
    }

    public void setStatusterminal(Character statusterminal) {
        this.statusterminal = statusterminal;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getPortaimpressora() {
        return portaimpressora;
    }

    public void setPortaimpressora(String portaimpressora) {
        this.portaimpressora = portaimpressora;
    }

    public String getDriverimpressora() {
        return driverimpressora;
    }

    public void setDriverimpressora(String driverimpressora) {
        this.driverimpressora = driverimpressora;
    }

    public String getModeloimpressora() {
        return modeloimpressora;
    }

    public void setModeloimpressora(String modeloimpressora) {
        this.modeloimpressora = modeloimpressora;
    }

    public String getRtmimpressora() {
        return rtmimpressora;
    }

    public void setRtmimpressora(String rtmimpressora) {
        this.rtmimpressora = rtmimpressora;
    }

    public String getRtmgerencial() {
        return rtmgerencial;
    }

    public void setRtmgerencial(String rtmgerencial) {
        this.rtmgerencial = rtmgerencial;
    }

    public String getDriverleitor() {
        return driverleitor;
    }

    public void setDriverleitor(String driverleitor) {
        this.driverleitor = driverleitor;
    }

    public String getPortaleitor() {
        return portaleitor;
    }

    public void setPortaleitor(String portaleitor) {
        this.portaleitor = portaleitor;
    }

    public String getDriverbalanca() {
        return driverbalanca;
    }

    public void setDriverbalanca(String driverbalanca) {
        this.driverbalanca = driverbalanca;
    }

    public String getPortabalanca() {
        return portabalanca;
    }

    public void setPortabalanca(String portabalanca) {
        this.portabalanca = portabalanca;
    }

    public String getDriverdisplay() {
        return driverdisplay;
    }

    public void setDriverdisplay(String driverdisplay) {
        this.driverdisplay = driverdisplay;
    }

    public String getPortadisplay() {
        return portadisplay;
    }

    public void setPortadisplay(String portadisplay) {
        this.portadisplay = portadisplay;
    }

    public String getCodecf() {
        return codecf;
    }

    public void setCodecf(String codecf) {
        this.codecf = codecf;
    }

    public Character getFlagusatef() {
        return flagusatef;
    }

    public void setFlagusatef(Character flagusatef) {
        this.flagusatef = flagusatef;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(String codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    public Character getTipoarredondamento() {
        return tipoarredondamento;
    }

    public void setTipoarredondamento(Character tipoarredondamento) {
        this.tipoarredondamento = tipoarredondamento;
    }

    public String getModelobalanca() {
        return modelobalanca;
    }

    public void setModelobalanca(String modelobalanca) {
        this.modelobalanca = modelobalanca;
    }

    public String getBaudratebalanca() {
        return baudratebalanca;
    }

    public void setBaudratebalanca(String baudratebalanca) {
        this.baudratebalanca = baudratebalanca;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getNumeroserieecf() {
        return numeroserieecf;
    }

    public void setNumeroserieecf(String numeroserieecf) {
        this.numeroserieecf = numeroserieecf;
    }

    public String getCodplupdvpendente() {
        return codplupdvpendente;
    }

    public void setCodplupdvpendente(String codplupdvpendente) {
        this.codplupdvpendente = codplupdvpendente;
    }

    public String getCodplupdvatual() {
        return codplupdvatual;
    }

    public void setCodplupdvatual(String codplupdvatual) {
        this.codplupdvatual = codplupdvatual;
    }

    public String getCodcomputador() {
        return codcomputador;
    }

    public void setCodcomputador(String codcomputador) {
        this.codcomputador = codcomputador;
    }

    public Date getUltimacomunicacao() {
        return ultimacomunicacao;
    }

    public void setUltimacomunicacao(Date ultimacomunicacao) {
        this.ultimacomunicacao = ultimacomunicacao;
    }

    public Integer getUltimaplu() {
        return ultimaplu;
    }

    public void setUltimaplu(Integer ultimaplu) {
        this.ultimaplu = ultimaplu;
    }

    public Character getFlagnfce() {
        return flagnfce;
    }

    public void setFlagnfce(Character flagnfce) {
        this.flagnfce = flagnfce;
    }

    public Short getSerienfce() {
        return serienfce;
    }

    public void setSerienfce(Short serienfce) {
        this.serienfce = serienfce;
    }

    public String getCodsat() {
        return codsat;
    }

    public void setCodsat(String codsat) {
        this.codsat = codsat;
    }

    public String getCodpos() {
        return codpos;
    }

    public void setCodpos(String codpos) {
        this.codpos = codpos;
    }

    public Character getFlagantifraudepos() {
        return flagantifraudepos;
    }

    public void setFlagantifraudepos(Character flagantifraudepos) {
        this.flagantifraudepos = flagantifraudepos;
    }

    public Short getSerienfceoffline() {
        return serienfceoffline;
    }

    public void setSerienfceoffline(Short serienfceoffline) {
        this.serienfceoffline = serienfceoffline;
    }

    public Caixas getCodcaixas() {
        return codcaixas;
    }

    public void setCodcaixas(Caixas codcaixas) {
        this.codcaixas = codcaixas;
    }

    public Planoconta getCodpc() {
        return codpc;
    }

    public void setCodpc(Planoconta codpc) {
        this.codpc = codpc;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codterminal != null ? codterminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.codterminal == null && other.codterminal != null) || (this.codterminal != null && !this.codterminal.equals(other.codterminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Terminal[ codterminal=" + codterminal + " ]";
    }
    
}
