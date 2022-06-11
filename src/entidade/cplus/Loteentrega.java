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
@Table(name = "LOTEENTREGA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loteentrega.findAll", query = "SELECT l FROM Loteentrega l")
    , @NamedQuery(name = "Loteentrega.findByCodloteentrega", query = "SELECT l FROM Loteentrega l WHERE l.codloteentrega = :codloteentrega")
    , @NamedQuery(name = "Loteentrega.findByDataprevistasaida", query = "SELECT l FROM Loteentrega l WHERE l.dataprevistasaida = :dataprevistasaida")
    , @NamedQuery(name = "Loteentrega.findByHoraprevistasaida", query = "SELECT l FROM Loteentrega l WHERE l.horaprevistasaida = :horaprevistasaida")
    , @NamedQuery(name = "Loteentrega.findByDatasaida", query = "SELECT l FROM Loteentrega l WHERE l.datasaida = :datasaida")
    , @NamedQuery(name = "Loteentrega.findByHorasaida", query = "SELECT l FROM Loteentrega l WHERE l.horasaida = :horasaida")
    , @NamedQuery(name = "Loteentrega.findByCoduser", query = "SELECT l FROM Loteentrega l WHERE l.coduser = :coduser")
    , @NamedQuery(name = "Loteentrega.findByNumloteentrega", query = "SELECT l FROM Loteentrega l WHERE l.numloteentrega = :numloteentrega")
    , @NamedQuery(name = "Loteentrega.findByDataretorno", query = "SELECT l FROM Loteentrega l WHERE l.dataretorno = :dataretorno")
    , @NamedQuery(name = "Loteentrega.findByHoraretorno", query = "SELECT l FROM Loteentrega l WHERE l.horaretorno = :horaretorno")
    , @NamedQuery(name = "Loteentrega.findByStatus", query = "SELECT l FROM Loteentrega l WHERE l.status = :status")
    , @NamedQuery(name = "Loteentrega.findByObs", query = "SELECT l FROM Loteentrega l WHERE l.obs = :obs")})
public class Loteentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOTEENTREGA")
    private Integer codloteentrega;
    @Column(name = "DATAPREVISTASAIDA")
    @Temporal(TemporalType.DATE)
    private Date dataprevistasaida;
    @Column(name = "HORAPREVISTASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horaprevistasaida;
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Column(name = "HORASAIDA")
    @Temporal(TemporalType.TIME)
    private Date horasaida;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "NUMLOTEENTREGA")
    private Integer numloteentrega;
    @Column(name = "DATARETORNO")
    @Temporal(TemporalType.DATE)
    private Date dataretorno;
    @Column(name = "HORARETORNO")
    @Temporal(TemporalType.TIME)
    private Date horaretorno;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "OBS")
    private String obs;
    @OneToMany(mappedBy = "codloteentrega")
    private Collection<Loteentregaitem> loteentregaitemCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODMOTORISTA", referencedColumnName = "CODENTREGAPESSOA")
    @ManyToOne
    private Entregapessoa codmotorista;
    @JoinColumn(name = "CODAJUDANTE", referencedColumnName = "CODENTREGAPESSOA")
    @ManyToOne
    private Entregapessoa codajudante;
    @JoinColumn(name = "CODAJUDANTE2", referencedColumnName = "CODENTREGAPESSOA")
    @ManyToOne
    private Entregapessoa codajudante2;
    @JoinColumn(name = "CODVEICULO", referencedColumnName = "CODVEICULO")
    @ManyToOne
    private Veiculos codveiculo;

    public Loteentrega() {
    }

    public Loteentrega(Integer codloteentrega) {
        this.codloteentrega = codloteentrega;
    }

    public Integer getCodloteentrega() {
        return codloteentrega;
    }

    public void setCodloteentrega(Integer codloteentrega) {
        this.codloteentrega = codloteentrega;
    }

    public Date getDataprevistasaida() {
        return dataprevistasaida;
    }

    public void setDataprevistasaida(Date dataprevistasaida) {
        this.dataprevistasaida = dataprevistasaida;
    }

    public Date getHoraprevistasaida() {
        return horaprevistasaida;
    }

    public void setHoraprevistasaida(Date horaprevistasaida) {
        this.horaprevistasaida = horaprevistasaida;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public Date getHorasaida() {
        return horasaida;
    }

    public void setHorasaida(Date horasaida) {
        this.horasaida = horasaida;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public Integer getNumloteentrega() {
        return numloteentrega;
    }

    public void setNumloteentrega(Integer numloteentrega) {
        this.numloteentrega = numloteentrega;
    }

    public Date getDataretorno() {
        return dataretorno;
    }

    public void setDataretorno(Date dataretorno) {
        this.dataretorno = dataretorno;
    }

    public Date getHoraretorno() {
        return horaretorno;
    }

    public void setHoraretorno(Date horaretorno) {
        this.horaretorno = horaretorno;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @XmlTransient
    public Collection<Loteentregaitem> getLoteentregaitemCollection() {
        return loteentregaitemCollection;
    }

    public void setLoteentregaitemCollection(Collection<Loteentregaitem> loteentregaitemCollection) {
        this.loteentregaitemCollection = loteentregaitemCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Entregapessoa getCodmotorista() {
        return codmotorista;
    }

    public void setCodmotorista(Entregapessoa codmotorista) {
        this.codmotorista = codmotorista;
    }

    public Entregapessoa getCodajudante() {
        return codajudante;
    }

    public void setCodajudante(Entregapessoa codajudante) {
        this.codajudante = codajudante;
    }

    public Entregapessoa getCodajudante2() {
        return codajudante2;
    }

    public void setCodajudante2(Entregapessoa codajudante2) {
        this.codajudante2 = codajudante2;
    }

    public Veiculos getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Veiculos codveiculo) {
        this.codveiculo = codveiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codloteentrega != null ? codloteentrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loteentrega)) {
            return false;
        }
        Loteentrega other = (Loteentrega) object;
        if ((this.codloteentrega == null && other.codloteentrega != null) || (this.codloteentrega != null && !this.codloteentrega.equals(other.codloteentrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Loteentrega[ codloteentrega=" + codloteentrega + " ]";
    }
    
}
