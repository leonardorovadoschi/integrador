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
@Table(name = "CONHECIMENTOTRANSPORTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conhecimentotransporte.findAll", query = "SELECT c FROM Conhecimentotransporte c")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodconhecimentotransporte", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codconhecimentotransporte = :codconhecimentotransporte")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodcliorigem", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codcliorigem = :codcliorigem")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodclidestino", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codclidestino = :codclidestino")
    , @NamedQuery(name = "Conhecimentotransporte.findByDataemissao", query = "SELECT c FROM Conhecimentotransporte c WHERE c.dataemissao = :dataemissao")
    , @NamedQuery(name = "Conhecimentotransporte.findByNaturezacarga", query = "SELECT c FROM Conhecimentotransporte c WHERE c.naturezacarga = :naturezacarga")
    , @NamedQuery(name = "Conhecimentotransporte.findByQuantidade", query = "SELECT c FROM Conhecimentotransporte c WHERE c.quantidade = :quantidade")
    , @NamedQuery(name = "Conhecimentotransporte.findByEspecie", query = "SELECT c FROM Conhecimentotransporte c WHERE c.especie = :especie")
    , @NamedQuery(name = "Conhecimentotransporte.findByPesokg", query = "SELECT c FROM Conhecimentotransporte c WHERE c.pesokg = :pesokg")
    , @NamedQuery(name = "Conhecimentotransporte.findByMetrocubicolitro", query = "SELECT c FROM Conhecimentotransporte c WHERE c.metrocubicolitro = :metrocubicolitro")
    , @NamedQuery(name = "Conhecimentotransporte.findByNumnota", query = "SELECT c FROM Conhecimentotransporte c WHERE c.numnota = :numnota")
    , @NamedQuery(name = "Conhecimentotransporte.findByValortotalnota", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valortotalnota = :valortotalnota")
    , @NamedQuery(name = "Conhecimentotransporte.findByFretepesovolume", query = "SELECT c FROM Conhecimentotransporte c WHERE c.fretepesovolume = :fretepesovolume")
    , @NamedQuery(name = "Conhecimentotransporte.findByValorfrete", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valorfrete = :valorfrete")
    , @NamedQuery(name = "Conhecimentotransporte.findByValorseccat", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valorseccat = :valorseccat")
    , @NamedQuery(name = "Conhecimentotransporte.findByValordespacho", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valordespacho = :valordespacho")
    , @NamedQuery(name = "Conhecimentotransporte.findByValorpedagio", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valorpedagio = :valorpedagio")
    , @NamedQuery(name = "Conhecimentotransporte.findByValoroutros", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valoroutros = :valoroutros")
    , @NamedQuery(name = "Conhecimentotransporte.findByValortotalprestacao", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valortotalprestacao = :valortotalprestacao")
    , @NamedQuery(name = "Conhecimentotransporte.findByFlagfretepago", query = "SELECT c FROM Conhecimentotransporte c WHERE c.flagfretepago = :flagfretepago")
    , @NamedQuery(name = "Conhecimentotransporte.findByBasecalculo", query = "SELECT c FROM Conhecimentotransporte c WHERE c.basecalculo = :basecalculo")
    , @NamedQuery(name = "Conhecimentotransporte.findByAliqicms", query = "SELECT c FROM Conhecimentotransporte c WHERE c.aliqicms = :aliqicms")
    , @NamedQuery(name = "Conhecimentotransporte.findByValoricms", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valoricms = :valoricms")
    , @NamedQuery(name = "Conhecimentotransporte.findByVeiculomarca", query = "SELECT c FROM Conhecimentotransporte c WHERE c.veiculomarca = :veiculomarca")
    , @NamedQuery(name = "Conhecimentotransporte.findByVeiculoplaca", query = "SELECT c FROM Conhecimentotransporte c WHERE c.veiculoplaca = :veiculoplaca")
    , @NamedQuery(name = "Conhecimentotransporte.findByVeiculolocal", query = "SELECT c FROM Conhecimentotransporte c WHERE c.veiculolocal = :veiculolocal")
    , @NamedQuery(name = "Conhecimentotransporte.findByVeiculouf", query = "SELECT c FROM Conhecimentotransporte c WHERE c.veiculouf = :veiculouf")
    , @NamedQuery(name = "Conhecimentotransporte.findByNumdoc", query = "SELECT c FROM Conhecimentotransporte c WHERE c.numdoc = :numdoc")
    , @NamedQuery(name = "Conhecimentotransporte.findByFlagsite", query = "SELECT c FROM Conhecimentotransporte c WHERE c.flagsite = :flagsite")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodconhecimentostatus", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codconhecimentostatus = :codconhecimentostatus")
    , @NamedQuery(name = "Conhecimentotransporte.findByFlaglancamento", query = "SELECT c FROM Conhecimentotransporte c WHERE c.flaglancamento = :flaglancamento")
    , @NamedQuery(name = "Conhecimentotransporte.findByNotasfiscais", query = "SELECT c FROM Conhecimentotransporte c WHERE c.notasfiscais = :notasfiscais")
    , @NamedQuery(name = "Conhecimentotransporte.findByManifesto", query = "SELECT c FROM Conhecimentotransporte c WHERE c.manifesto = :manifesto")
    , @NamedQuery(name = "Conhecimentotransporte.findByFlagentregue", query = "SELECT c FROM Conhecimentotransporte c WHERE c.flagentregue = :flagentregue")
    , @NamedQuery(name = "Conhecimentotransporte.findByCoduser", query = "SELECT c FROM Conhecimentotransporte c WHERE c.coduser = :coduser")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodempresaorigem", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codempresaorigem = :codempresaorigem")
    , @NamedQuery(name = "Conhecimentotransporte.findByCodempresadestino", query = "SELECT c FROM Conhecimentotransporte c WHERE c.codempresadestino = :codempresadestino")
    , @NamedQuery(name = "Conhecimentotransporte.findByHorarioini", query = "SELECT c FROM Conhecimentotransporte c WHERE c.horarioini = :horarioini")
    , @NamedQuery(name = "Conhecimentotransporte.findByHorariofin", query = "SELECT c FROM Conhecimentotransporte c WHERE c.horariofin = :horariofin")
    , @NamedQuery(name = "Conhecimentotransporte.findByIntervaloini", query = "SELECT c FROM Conhecimentotransporte c WHERE c.intervaloini = :intervaloini")
    , @NamedQuery(name = "Conhecimentotransporte.findByIntervalofin", query = "SELECT c FROM Conhecimentotransporte c WHERE c.intervalofin = :intervalofin")
    , @NamedQuery(name = "Conhecimentotransporte.findByFlagcalculo", query = "SELECT c FROM Conhecimentotransporte c WHERE c.flagcalculo = :flagcalculo")
    , @NamedQuery(name = "Conhecimentotransporte.findByValortotalmercadorias", query = "SELECT c FROM Conhecimentotransporte c WHERE c.valortotalmercadorias = :valortotalmercadorias")
    , @NamedQuery(name = "Conhecimentotransporte.findByAliqicms2", query = "SELECT c FROM Conhecimentotransporte c WHERE c.aliqicms2 = :aliqicms2")
    , @NamedQuery(name = "Conhecimentotransporte.findByAliqfrete", query = "SELECT c FROM Conhecimentotransporte c WHERE c.aliqfrete = :aliqfrete")
    , @NamedQuery(name = "Conhecimentotransporte.findByIdconhecimentotransporte", query = "SELECT c FROM Conhecimentotransporte c WHERE c.idconhecimentotransporte = :idconhecimentotransporte")
    , @NamedQuery(name = "Conhecimentotransporte.findByLastChange", query = "SELECT c FROM Conhecimentotransporte c WHERE c.lastChange = :lastChange")})
public class Conhecimentotransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONHECIMENTOTRANSPORTE")
    private String codconhecimentotransporte;
    @Column(name = "CODCLIORIGEM")
    private String codcliorigem;
    @Column(name = "CODCLIDESTINO")
    private String codclidestino;
    @Column(name = "DATAEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataemissao;
    @Column(name = "NATUREZACARGA")
    private String naturezacarga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "ESPECIE")
    private String especie;
    @Column(name = "PESOKG")
    private BigDecimal pesokg;
    @Column(name = "METROCUBICOLITRO")
    private BigDecimal metrocubicolitro;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "VALORTOTALNOTA")
    private BigDecimal valortotalnota;
    @Column(name = "FRETEPESOVOLUME")
    private BigDecimal fretepesovolume;
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "VALORSECCAT")
    private BigDecimal valorseccat;
    @Column(name = "VALORDESPACHO")
    private BigDecimal valordespacho;
    @Column(name = "VALORPEDAGIO")
    private BigDecimal valorpedagio;
    @Column(name = "VALOROUTROS")
    private BigDecimal valoroutros;
    @Column(name = "VALORTOTALPRESTACAO")
    private BigDecimal valortotalprestacao;
    @Column(name = "FLAGFRETEPAGO")
    private Character flagfretepago;
    @Column(name = "BASECALCULO")
    private BigDecimal basecalculo;
    @Column(name = "ALIQICMS")
    private BigDecimal aliqicms;
    @Column(name = "VALORICMS")
    private BigDecimal valoricms;
    @Column(name = "VEICULOMARCA")
    private String veiculomarca;
    @Column(name = "VEICULOPLACA")
    private String veiculoplaca;
    @Column(name = "VEICULOLOCAL")
    private String veiculolocal;
    @Column(name = "VEICULOUF")
    private String veiculouf;
    @Column(name = "NUMDOC")
    private String numdoc;
    @Column(name = "FLAGSITE")
    private Character flagsite;
    @Column(name = "CODCONHECIMENTOSTATUS")
    private String codconhecimentostatus;
    @Column(name = "FLAGLANCAMENTO")
    private Character flaglancamento;
    @Column(name = "NOTASFISCAIS")
    private String notasfiscais;
    @Column(name = "MANIFESTO")
    private String manifesto;
    @Column(name = "FLAGENTREGUE")
    private Character flagentregue;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "CODEMPRESAORIGEM")
    private Integer codempresaorigem;
    @Column(name = "CODEMPRESADESTINO")
    private Integer codempresadestino;
    @Column(name = "HORARIOINI")
    @Temporal(TemporalType.TIME)
    private Date horarioini;
    @Column(name = "HORARIOFIN")
    @Temporal(TemporalType.TIME)
    private Date horariofin;
    @Column(name = "INTERVALOINI")
    @Temporal(TemporalType.TIME)
    private Date intervaloini;
    @Column(name = "INTERVALOFIN")
    @Temporal(TemporalType.TIME)
    private Date intervalofin;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "FLAGCALCULO")
    private Integer flagcalculo;
    @Column(name = "VALORTOTALMERCADORIAS")
    private BigDecimal valortotalmercadorias;
    @Column(name = "ALIQICMS2")
    private BigDecimal aliqicms2;
    @Column(name = "ALIQFRETE")
    private BigDecimal aliqfrete;
    @Column(name = "IDCONHECIMENTOTRANSPORTE")
    private Integer idconhecimentotransporte;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @OneToMany(mappedBy = "codconhecimentotransporte")
    private Collection<Contareceber> contareceberCollection;
    @JoinColumn(name = "CODCONTRATOTRANSPORTE", referencedColumnName = "CODCONTRATOTRANSPORTE")
    @ManyToOne
    private Contratotransporte codcontratotransporte;

    public Conhecimentotransporte() {
    }

    public Conhecimentotransporte(String codconhecimentotransporte) {
        this.codconhecimentotransporte = codconhecimentotransporte;
    }

    public String getCodconhecimentotransporte() {
        return codconhecimentotransporte;
    }

    public void setCodconhecimentotransporte(String codconhecimentotransporte) {
        this.codconhecimentotransporte = codconhecimentotransporte;
    }

    public String getCodcliorigem() {
        return codcliorigem;
    }

    public void setCodcliorigem(String codcliorigem) {
        this.codcliorigem = codcliorigem;
    }

    public String getCodclidestino() {
        return codclidestino;
    }

    public void setCodclidestino(String codclidestino) {
        this.codclidestino = codclidestino;
    }

    public Date getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(Date dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getNaturezacarga() {
        return naturezacarga;
    }

    public void setNaturezacarga(String naturezacarga) {
        this.naturezacarga = naturezacarga;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public BigDecimal getPesokg() {
        return pesokg;
    }

    public void setPesokg(BigDecimal pesokg) {
        this.pesokg = pesokg;
    }

    public BigDecimal getMetrocubicolitro() {
        return metrocubicolitro;
    }

    public void setMetrocubicolitro(BigDecimal metrocubicolitro) {
        this.metrocubicolitro = metrocubicolitro;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public BigDecimal getValortotalnota() {
        return valortotalnota;
    }

    public void setValortotalnota(BigDecimal valortotalnota) {
        this.valortotalnota = valortotalnota;
    }

    public BigDecimal getFretepesovolume() {
        return fretepesovolume;
    }

    public void setFretepesovolume(BigDecimal fretepesovolume) {
        this.fretepesovolume = fretepesovolume;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public BigDecimal getValorseccat() {
        return valorseccat;
    }

    public void setValorseccat(BigDecimal valorseccat) {
        this.valorseccat = valorseccat;
    }

    public BigDecimal getValordespacho() {
        return valordespacho;
    }

    public void setValordespacho(BigDecimal valordespacho) {
        this.valordespacho = valordespacho;
    }

    public BigDecimal getValorpedagio() {
        return valorpedagio;
    }

    public void setValorpedagio(BigDecimal valorpedagio) {
        this.valorpedagio = valorpedagio;
    }

    public BigDecimal getValoroutros() {
        return valoroutros;
    }

    public void setValoroutros(BigDecimal valoroutros) {
        this.valoroutros = valoroutros;
    }

    public BigDecimal getValortotalprestacao() {
        return valortotalprestacao;
    }

    public void setValortotalprestacao(BigDecimal valortotalprestacao) {
        this.valortotalprestacao = valortotalprestacao;
    }

    public Character getFlagfretepago() {
        return flagfretepago;
    }

    public void setFlagfretepago(Character flagfretepago) {
        this.flagfretepago = flagfretepago;
    }

    public BigDecimal getBasecalculo() {
        return basecalculo;
    }

    public void setBasecalculo(BigDecimal basecalculo) {
        this.basecalculo = basecalculo;
    }

    public BigDecimal getAliqicms() {
        return aliqicms;
    }

    public void setAliqicms(BigDecimal aliqicms) {
        this.aliqicms = aliqicms;
    }

    public BigDecimal getValoricms() {
        return valoricms;
    }

    public void setValoricms(BigDecimal valoricms) {
        this.valoricms = valoricms;
    }

    public String getVeiculomarca() {
        return veiculomarca;
    }

    public void setVeiculomarca(String veiculomarca) {
        this.veiculomarca = veiculomarca;
    }

    public String getVeiculoplaca() {
        return veiculoplaca;
    }

    public void setVeiculoplaca(String veiculoplaca) {
        this.veiculoplaca = veiculoplaca;
    }

    public String getVeiculolocal() {
        return veiculolocal;
    }

    public void setVeiculolocal(String veiculolocal) {
        this.veiculolocal = veiculolocal;
    }

    public String getVeiculouf() {
        return veiculouf;
    }

    public void setVeiculouf(String veiculouf) {
        this.veiculouf = veiculouf;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public Character getFlagsite() {
        return flagsite;
    }

    public void setFlagsite(Character flagsite) {
        this.flagsite = flagsite;
    }

    public String getCodconhecimentostatus() {
        return codconhecimentostatus;
    }

    public void setCodconhecimentostatus(String codconhecimentostatus) {
        this.codconhecimentostatus = codconhecimentostatus;
    }

    public Character getFlaglancamento() {
        return flaglancamento;
    }

    public void setFlaglancamento(Character flaglancamento) {
        this.flaglancamento = flaglancamento;
    }

    public String getNotasfiscais() {
        return notasfiscais;
    }

    public void setNotasfiscais(String notasfiscais) {
        this.notasfiscais = notasfiscais;
    }

    public String getManifesto() {
        return manifesto;
    }

    public void setManifesto(String manifesto) {
        this.manifesto = manifesto;
    }

    public Character getFlagentregue() {
        return flagentregue;
    }

    public void setFlagentregue(Character flagentregue) {
        this.flagentregue = flagentregue;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Integer getCodempresaorigem() {
        return codempresaorigem;
    }

    public void setCodempresaorigem(Integer codempresaorigem) {
        this.codempresaorigem = codempresaorigem;
    }

    public Integer getCodempresadestino() {
        return codempresadestino;
    }

    public void setCodempresadestino(Integer codempresadestino) {
        this.codempresadestino = codempresadestino;
    }

    public Date getHorarioini() {
        return horarioini;
    }

    public void setHorarioini(Date horarioini) {
        this.horarioini = horarioini;
    }

    public Date getHorariofin() {
        return horariofin;
    }

    public void setHorariofin(Date horariofin) {
        this.horariofin = horariofin;
    }

    public Date getIntervaloini() {
        return intervaloini;
    }

    public void setIntervaloini(Date intervaloini) {
        this.intervaloini = intervaloini;
    }

    public Date getIntervalofin() {
        return intervalofin;
    }

    public void setIntervalofin(Date intervalofin) {
        this.intervalofin = intervalofin;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getFlagcalculo() {
        return flagcalculo;
    }

    public void setFlagcalculo(Integer flagcalculo) {
        this.flagcalculo = flagcalculo;
    }

    public BigDecimal getValortotalmercadorias() {
        return valortotalmercadorias;
    }

    public void setValortotalmercadorias(BigDecimal valortotalmercadorias) {
        this.valortotalmercadorias = valortotalmercadorias;
    }

    public BigDecimal getAliqicms2() {
        return aliqicms2;
    }

    public void setAliqicms2(BigDecimal aliqicms2) {
        this.aliqicms2 = aliqicms2;
    }

    public BigDecimal getAliqfrete() {
        return aliqfrete;
    }

    public void setAliqfrete(BigDecimal aliqfrete) {
        this.aliqfrete = aliqfrete;
    }

    public Integer getIdconhecimentotransporte() {
        return idconhecimentotransporte;
    }

    public void setIdconhecimentotransporte(Integer idconhecimentotransporte) {
        this.idconhecimentotransporte = idconhecimentotransporte;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    public Contratotransporte getCodcontratotransporte() {
        return codcontratotransporte;
    }

    public void setCodcontratotransporte(Contratotransporte codcontratotransporte) {
        this.codcontratotransporte = codcontratotransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconhecimentotransporte != null ? codconhecimentotransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conhecimentotransporte)) {
            return false;
        }
        Conhecimentotransporte other = (Conhecimentotransporte) object;
        if ((this.codconhecimentotransporte == null && other.codconhecimentotransporte != null) || (this.codconhecimentotransporte != null && !this.codconhecimentotransporte.equals(other.codconhecimentotransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conhecimentotransporte[ codconhecimentotransporte=" + codconhecimentotransporte + " ]";
    }
    
}
