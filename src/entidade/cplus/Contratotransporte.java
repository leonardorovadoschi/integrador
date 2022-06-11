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
@Table(name = "CONTRATOTRANSPORTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratotransporte.findAll", query = "SELECT c FROM Contratotransporte c")
    , @NamedQuery(name = "Contratotransporte.findByCodcontratotransporte", query = "SELECT c FROM Contratotransporte c WHERE c.codcontratotransporte = :codcontratotransporte")
    , @NamedQuery(name = "Contratotransporte.findByContratadonome", query = "SELECT c FROM Contratotransporte c WHERE c.contratadonome = :contratadonome")
    , @NamedQuery(name = "Contratotransporte.findByContratadoendereco", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoendereco = :contratadoendereco")
    , @NamedQuery(name = "Contratotransporte.findByContratadobairro", query = "SELECT c FROM Contratotransporte c WHERE c.contratadobairro = :contratadobairro")
    , @NamedQuery(name = "Contratotransporte.findByContratadocidade", query = "SELECT c FROM Contratotransporte c WHERE c.contratadocidade = :contratadocidade")
    , @NamedQuery(name = "Contratotransporte.findByContratadoestado", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoestado = :contratadoestado")
    , @NamedQuery(name = "Contratotransporte.findByContratadocep", query = "SELECT c FROM Contratotransporte c WHERE c.contratadocep = :contratadocep")
    , @NamedQuery(name = "Contratotransporte.findByContratadocpf", query = "SELECT c FROM Contratotransporte c WHERE c.contratadocpf = :contratadocpf")
    , @NamedQuery(name = "Contratotransporte.findByContratadoidentidade", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoidentidade = :contratadoidentidade")
    , @NamedQuery(name = "Contratotransporte.findByContratadoorgaoexpedidor", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoorgaoexpedidor = :contratadoorgaoexpedidor")
    , @NamedQuery(name = "Contratotransporte.findByContratadoinps", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoinps = :contratadoinps")
    , @NamedQuery(name = "Contratotransporte.findByContratadomarca", query = "SELECT c FROM Contratotransporte c WHERE c.contratadomarca = :contratadomarca")
    , @NamedQuery(name = "Contratotransporte.findByContratadomodelo", query = "SELECT c FROM Contratotransporte c WHERE c.contratadomodelo = :contratadomodelo")
    , @NamedQuery(name = "Contratotransporte.findByContratadochassis", query = "SELECT c FROM Contratotransporte c WHERE c.contratadochassis = :contratadochassis")
    , @NamedQuery(name = "Contratotransporte.findByContratadoanofabricacao", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoanofabricacao = :contratadoanofabricacao")
    , @NamedQuery(name = "Contratotransporte.findByContratadocapacidadecarga", query = "SELECT c FROM Contratotransporte c WHERE c.contratadocapacidadecarga = :contratadocapacidadecarga")
    , @NamedQuery(name = "Contratotransporte.findByContratadoestadoveiculo", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoestadoveiculo = :contratadoestadoveiculo")
    , @NamedQuery(name = "Contratotransporte.findByContratadoplaca", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoplaca = :contratadoplaca")
    , @NamedQuery(name = "Contratotransporte.findByContratadocidadeveiculo", query = "SELECT c FROM Contratotransporte c WHERE c.contratadocidadeveiculo = :contratadocidadeveiculo")
    , @NamedQuery(name = "Contratotransporte.findByContratadoutil", query = "SELECT c FROM Contratotransporte c WHERE c.contratadoutil = :contratadoutil")
    , @NamedQuery(name = "Contratotransporte.findByContratadopbt", query = "SELECT c FROM Contratotransporte c WHERE c.contratadopbt = :contratadopbt")
    , @NamedQuery(name = "Contratotransporte.findByMotoristanome", query = "SELECT c FROM Contratotransporte c WHERE c.motoristanome = :motoristanome")
    , @NamedQuery(name = "Contratotransporte.findByMotoristaendereco", query = "SELECT c FROM Contratotransporte c WHERE c.motoristaendereco = :motoristaendereco")
    , @NamedQuery(name = "Contratotransporte.findByMotoristacidade", query = "SELECT c FROM Contratotransporte c WHERE c.motoristacidade = :motoristacidade")
    , @NamedQuery(name = "Contratotransporte.findByMotoristaestado", query = "SELECT c FROM Contratotransporte c WHERE c.motoristaestado = :motoristaestado")
    , @NamedQuery(name = "Contratotransporte.findByMotoristacep", query = "SELECT c FROM Contratotransporte c WHERE c.motoristacep = :motoristacep")
    , @NamedQuery(name = "Contratotransporte.findByMotoristacnh", query = "SELECT c FROM Contratotransporte c WHERE c.motoristacnh = :motoristacnh")
    , @NamedQuery(name = "Contratotransporte.findByMotoristacpf", query = "SELECT c FROM Contratotransporte c WHERE c.motoristacpf = :motoristacpf")
    , @NamedQuery(name = "Contratotransporte.findByMotoristaidentidade", query = "SELECT c FROM Contratotransporte c WHERE c.motoristaidentidade = :motoristaidentidade")
    , @NamedQuery(name = "Contratotransporte.findByMotoristaorgaoexpedidor", query = "SELECT c FROM Contratotransporte c WHERE c.motoristaorgaoexpedidor = :motoristaorgaoexpedidor")
    , @NamedQuery(name = "Contratotransporte.findByManifesto", query = "SELECT c FROM Contratotransporte c WHERE c.manifesto = :manifesto")
    , @NamedQuery(name = "Contratotransporte.findByPeso", query = "SELECT c FROM Contratotransporte c WHERE c.peso = :peso")
    , @NamedQuery(name = "Contratotransporte.findByLocalcarregamento", query = "SELECT c FROM Contratotransporte c WHERE c.localcarregamento = :localcarregamento")
    , @NamedQuery(name = "Contratotransporte.findByLocaldescarregamento", query = "SELECT c FROM Contratotransporte c WHERE c.localdescarregamento = :localdescarregamento")
    , @NamedQuery(name = "Contratotransporte.findByValorfrete", query = "SELECT c FROM Contratotransporte c WHERE c.valorfrete = :valorfrete")
    , @NamedQuery(name = "Contratotransporte.findByDatasaida", query = "SELECT c FROM Contratotransporte c WHERE c.datasaida = :datasaida")
    , @NamedQuery(name = "Contratotransporte.findByHorasaida", query = "SELECT c FROM Contratotransporte c WHERE c.horasaida = :horasaida")
    , @NamedQuery(name = "Contratotransporte.findByDatachegada", query = "SELECT c FROM Contratotransporte c WHERE c.datachegada = :datachegada")
    , @NamedQuery(name = "Contratotransporte.findByHorachegada", query = "SELECT c FROM Contratotransporte c WHERE c.horachegada = :horachegada")
    , @NamedQuery(name = "Contratotransporte.findByReenbolsoinps", query = "SELECT c FROM Contratotransporte c WHERE c.reenbolsoinps = :reenbolsoinps")
    , @NamedQuery(name = "Contratotransporte.findByEstadia", query = "SELECT c FROM Contratotransporte c WHERE c.estadia = :estadia")
    , @NamedQuery(name = "Contratotransporte.findByMultamora", query = "SELECT c FROM Contratotransporte c WHERE c.multamora = :multamora")
    , @NamedQuery(name = "Contratotransporte.findByDescontos", query = "SELECT c FROM Contratotransporte c WHERE c.descontos = :descontos")
    , @NamedQuery(name = "Contratotransporte.findByAdiantamentoorigem", query = "SELECT c FROM Contratotransporte c WHERE c.adiantamentoorigem = :adiantamentoorigem")
    , @NamedQuery(name = "Contratotransporte.findByOutrosadiantamentos", query = "SELECT c FROM Contratotransporte c WHERE c.outrosadiantamentos = :outrosadiantamentos")
    , @NamedQuery(name = "Contratotransporte.findByMultahora", query = "SELECT c FROM Contratotransporte c WHERE c.multahora = :multahora")
    , @NamedQuery(name = "Contratotransporte.findByIss", query = "SELECT c FROM Contratotransporte c WHERE c.iss = :iss")
    , @NamedQuery(name = "Contratotransporte.findByIrrf", query = "SELECT c FROM Contratotransporte c WHERE c.irrf = :irrf")
    , @NamedQuery(name = "Contratotransporte.findByValorliquido", query = "SELECT c FROM Contratotransporte c WHERE c.valorliquido = :valorliquido")
    , @NamedQuery(name = "Contratotransporte.findByUsuario", query = "SELECT c FROM Contratotransporte c WHERE c.usuario = :usuario")})
public class Contratotransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONTRATOTRANSPORTE")
    private String codcontratotransporte;
    @Column(name = "CONTRATADONOME")
    private String contratadonome;
    @Column(name = "CONTRATADOENDERECO")
    private String contratadoendereco;
    @Column(name = "CONTRATADOBAIRRO")
    private String contratadobairro;
    @Column(name = "CONTRATADOCIDADE")
    private String contratadocidade;
    @Column(name = "CONTRATADOESTADO")
    private String contratadoestado;
    @Column(name = "CONTRATADOCEP")
    private String contratadocep;
    @Column(name = "CONTRATADOCPF")
    private String contratadocpf;
    @Column(name = "CONTRATADOIDENTIDADE")
    private String contratadoidentidade;
    @Column(name = "CONTRATADOORGAOEXPEDIDOR")
    private String contratadoorgaoexpedidor;
    @Column(name = "CONTRATADOINPS")
    private String contratadoinps;
    @Column(name = "CONTRATADOMARCA")
    private String contratadomarca;
    @Column(name = "CONTRATADOMODELO")
    private String contratadomodelo;
    @Column(name = "CONTRATADOCHASSIS")
    private String contratadochassis;
    @Column(name = "CONTRATADOANOFABRICACAO")
    private String contratadoanofabricacao;
    @Column(name = "CONTRATADOCAPACIDADECARGA")
    private String contratadocapacidadecarga;
    @Column(name = "CONTRATADOESTADOVEICULO")
    private String contratadoestadoveiculo;
    @Column(name = "CONTRATADOPLACA")
    private String contratadoplaca;
    @Column(name = "CONTRATADOCIDADEVEICULO")
    private String contratadocidadeveiculo;
    @Column(name = "CONTRATADOUTIL")
    private String contratadoutil;
    @Column(name = "CONTRATADOPBT")
    private String contratadopbt;
    @Column(name = "MOTORISTANOME")
    private String motoristanome;
    @Column(name = "MOTORISTAENDERECO")
    private String motoristaendereco;
    @Column(name = "MOTORISTACIDADE")
    private String motoristacidade;
    @Column(name = "MOTORISTAESTADO")
    private String motoristaestado;
    @Column(name = "MOTORISTACEP")
    private String motoristacep;
    @Column(name = "MOTORISTACNH")
    private String motoristacnh;
    @Column(name = "MOTORISTACPF")
    private String motoristacpf;
    @Column(name = "MOTORISTAIDENTIDADE")
    private String motoristaidentidade;
    @Column(name = "MOTORISTAORGAOEXPEDIDOR")
    private String motoristaorgaoexpedidor;
    @Column(name = "MANIFESTO")
    private String manifesto;
    @Column(name = "PESO")
    private String peso;
    @Column(name = "LOCALCARREGAMENTO")
    private String localcarregamento;
    @Column(name = "LOCALDESCARREGAMENTO")
    private String localdescarregamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORFRETE")
    private BigDecimal valorfrete;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "HORASAIDA")
    private String horasaida;
    @Column(name = "DATACHEGADA")
    @Temporal(TemporalType.DATE)
    private Date datachegada;
    @Column(name = "HORACHEGADA")
    private String horachegada;
    @Column(name = "REENBOLSOINPS")
    private BigDecimal reenbolsoinps;
    @Column(name = "ESTADIA")
    private BigDecimal estadia;
    @Column(name = "MULTAMORA")
    private BigDecimal multamora;
    @Column(name = "DESCONTOS")
    private BigDecimal descontos;
    @Column(name = "ADIANTAMENTOORIGEM")
    private BigDecimal adiantamentoorigem;
    @Column(name = "OUTROSADIANTAMENTOS")
    private BigDecimal outrosadiantamentos;
    @Column(name = "MULTAHORA")
    private BigDecimal multahora;
    @Column(name = "ISS")
    private BigDecimal iss;
    @Column(name = "IRRF")
    private BigDecimal irrf;
    @Column(name = "VALORLIQUIDO")
    private BigDecimal valorliquido;
    @Column(name = "USUARIO")
    private String usuario;
    @OneToMany(mappedBy = "codcontratotransporte")
    private Collection<Conhecimentotransporte> conhecimentotransporteCollection;

    public Contratotransporte() {
    }

    public Contratotransporte(String codcontratotransporte) {
        this.codcontratotransporte = codcontratotransporte;
    }

    public String getCodcontratotransporte() {
        return codcontratotransporte;
    }

    public void setCodcontratotransporte(String codcontratotransporte) {
        this.codcontratotransporte = codcontratotransporte;
    }

    public String getContratadonome() {
        return contratadonome;
    }

    public void setContratadonome(String contratadonome) {
        this.contratadonome = contratadonome;
    }

    public String getContratadoendereco() {
        return contratadoendereco;
    }

    public void setContratadoendereco(String contratadoendereco) {
        this.contratadoendereco = contratadoendereco;
    }

    public String getContratadobairro() {
        return contratadobairro;
    }

    public void setContratadobairro(String contratadobairro) {
        this.contratadobairro = contratadobairro;
    }

    public String getContratadocidade() {
        return contratadocidade;
    }

    public void setContratadocidade(String contratadocidade) {
        this.contratadocidade = contratadocidade;
    }

    public String getContratadoestado() {
        return contratadoestado;
    }

    public void setContratadoestado(String contratadoestado) {
        this.contratadoestado = contratadoestado;
    }

    public String getContratadocep() {
        return contratadocep;
    }

    public void setContratadocep(String contratadocep) {
        this.contratadocep = contratadocep;
    }

    public String getContratadocpf() {
        return contratadocpf;
    }

    public void setContratadocpf(String contratadocpf) {
        this.contratadocpf = contratadocpf;
    }

    public String getContratadoidentidade() {
        return contratadoidentidade;
    }

    public void setContratadoidentidade(String contratadoidentidade) {
        this.contratadoidentidade = contratadoidentidade;
    }

    public String getContratadoorgaoexpedidor() {
        return contratadoorgaoexpedidor;
    }

    public void setContratadoorgaoexpedidor(String contratadoorgaoexpedidor) {
        this.contratadoorgaoexpedidor = contratadoorgaoexpedidor;
    }

    public String getContratadoinps() {
        return contratadoinps;
    }

    public void setContratadoinps(String contratadoinps) {
        this.contratadoinps = contratadoinps;
    }

    public String getContratadomarca() {
        return contratadomarca;
    }

    public void setContratadomarca(String contratadomarca) {
        this.contratadomarca = contratadomarca;
    }

    public String getContratadomodelo() {
        return contratadomodelo;
    }

    public void setContratadomodelo(String contratadomodelo) {
        this.contratadomodelo = contratadomodelo;
    }

    public String getContratadochassis() {
        return contratadochassis;
    }

    public void setContratadochassis(String contratadochassis) {
        this.contratadochassis = contratadochassis;
    }

    public String getContratadoanofabricacao() {
        return contratadoanofabricacao;
    }

    public void setContratadoanofabricacao(String contratadoanofabricacao) {
        this.contratadoanofabricacao = contratadoanofabricacao;
    }

    public String getContratadocapacidadecarga() {
        return contratadocapacidadecarga;
    }

    public void setContratadocapacidadecarga(String contratadocapacidadecarga) {
        this.contratadocapacidadecarga = contratadocapacidadecarga;
    }

    public String getContratadoestadoveiculo() {
        return contratadoestadoveiculo;
    }

    public void setContratadoestadoveiculo(String contratadoestadoveiculo) {
        this.contratadoestadoveiculo = contratadoestadoveiculo;
    }

    public String getContratadoplaca() {
        return contratadoplaca;
    }

    public void setContratadoplaca(String contratadoplaca) {
        this.contratadoplaca = contratadoplaca;
    }

    public String getContratadocidadeveiculo() {
        return contratadocidadeveiculo;
    }

    public void setContratadocidadeveiculo(String contratadocidadeveiculo) {
        this.contratadocidadeveiculo = contratadocidadeveiculo;
    }

    public String getContratadoutil() {
        return contratadoutil;
    }

    public void setContratadoutil(String contratadoutil) {
        this.contratadoutil = contratadoutil;
    }

    public String getContratadopbt() {
        return contratadopbt;
    }

    public void setContratadopbt(String contratadopbt) {
        this.contratadopbt = contratadopbt;
    }

    public String getMotoristanome() {
        return motoristanome;
    }

    public void setMotoristanome(String motoristanome) {
        this.motoristanome = motoristanome;
    }

    public String getMotoristaendereco() {
        return motoristaendereco;
    }

    public void setMotoristaendereco(String motoristaendereco) {
        this.motoristaendereco = motoristaendereco;
    }

    public String getMotoristacidade() {
        return motoristacidade;
    }

    public void setMotoristacidade(String motoristacidade) {
        this.motoristacidade = motoristacidade;
    }

    public String getMotoristaestado() {
        return motoristaestado;
    }

    public void setMotoristaestado(String motoristaestado) {
        this.motoristaestado = motoristaestado;
    }

    public String getMotoristacep() {
        return motoristacep;
    }

    public void setMotoristacep(String motoristacep) {
        this.motoristacep = motoristacep;
    }

    public String getMotoristacnh() {
        return motoristacnh;
    }

    public void setMotoristacnh(String motoristacnh) {
        this.motoristacnh = motoristacnh;
    }

    public String getMotoristacpf() {
        return motoristacpf;
    }

    public void setMotoristacpf(String motoristacpf) {
        this.motoristacpf = motoristacpf;
    }

    public String getMotoristaidentidade() {
        return motoristaidentidade;
    }

    public void setMotoristaidentidade(String motoristaidentidade) {
        this.motoristaidentidade = motoristaidentidade;
    }

    public String getMotoristaorgaoexpedidor() {
        return motoristaorgaoexpedidor;
    }

    public void setMotoristaorgaoexpedidor(String motoristaorgaoexpedidor) {
        this.motoristaorgaoexpedidor = motoristaorgaoexpedidor;
    }

    public String getManifesto() {
        return manifesto;
    }

    public void setManifesto(String manifesto) {
        this.manifesto = manifesto;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getLocalcarregamento() {
        return localcarregamento;
    }

    public void setLocalcarregamento(String localcarregamento) {
        this.localcarregamento = localcarregamento;
    }

    public String getLocaldescarregamento() {
        return localdescarregamento;
    }

    public void setLocaldescarregamento(String localdescarregamento) {
        this.localdescarregamento = localdescarregamento;
    }

    public BigDecimal getValorfrete() {
        return valorfrete;
    }

    public void setValorfrete(BigDecimal valorfrete) {
        this.valorfrete = valorfrete;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public String getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(String horasaida) {
        this.horasaida = horasaida;
    }

    public Date getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(Date datachegada) {
        this.datachegada = datachegada;
    }

    public String getHorachegada() {
        return horachegada;
    }

    public void setHorachegada(String horachegada) {
        this.horachegada = horachegada;
    }

    public BigDecimal getReenbolsoinps() {
        return reenbolsoinps;
    }

    public void setReenbolsoinps(BigDecimal reenbolsoinps) {
        this.reenbolsoinps = reenbolsoinps;
    }

    public BigDecimal getEstadia() {
        return estadia;
    }

    public void setEstadia(BigDecimal estadia) {
        this.estadia = estadia;
    }

    public BigDecimal getMultamora() {
        return multamora;
    }

    public void setMultamora(BigDecimal multamora) {
        this.multamora = multamora;
    }

    public BigDecimal getDescontos() {
        return descontos;
    }

    public void setDescontos(BigDecimal descontos) {
        this.descontos = descontos;
    }

    public BigDecimal getAdiantamentoorigem() {
        return adiantamentoorigem;
    }

    public void setAdiantamentoorigem(BigDecimal adiantamentoorigem) {
        this.adiantamentoorigem = adiantamentoorigem;
    }

    public BigDecimal getOutrosadiantamentos() {
        return outrosadiantamentos;
    }

    public void setOutrosadiantamentos(BigDecimal outrosadiantamentos) {
        this.outrosadiantamentos = outrosadiantamentos;
    }

    public BigDecimal getMultahora() {
        return multahora;
    }

    public void setMultahora(BigDecimal multahora) {
        this.multahora = multahora;
    }

    public BigDecimal getIss() {
        return iss;
    }

    public void setIss(BigDecimal iss) {
        this.iss = iss;
    }

    public BigDecimal getIrrf() {
        return irrf;
    }

    public void setIrrf(BigDecimal irrf) {
        this.irrf = irrf;
    }

    public BigDecimal getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(BigDecimal valorliquido) {
        this.valorliquido = valorliquido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Conhecimentotransporte> getConhecimentotransporteCollection() {
        return conhecimentotransporteCollection;
    }

    public void setConhecimentotransporteCollection(Collection<Conhecimentotransporte> conhecimentotransporteCollection) {
        this.conhecimentotransporteCollection = conhecimentotransporteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcontratotransporte != null ? codcontratotransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratotransporte)) {
            return false;
        }
        Contratotransporte other = (Contratotransporte) object;
        if ((this.codcontratotransporte == null && other.codcontratotransporte != null) || (this.codcontratotransporte != null && !this.codcontratotransporte.equals(other.codcontratotransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Contratotransporte[ codcontratotransporte=" + codcontratotransporte + " ]";
    }
    
}
