/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "SAT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sat.findAll", query = "SELECT s FROM Sat s")
    , @NamedQuery(name = "Sat.findByCodsat", query = "SELECT s FROM Sat s WHERE s.codsat = :codsat")
    , @NamedQuery(name = "Sat.findByCodigo", query = "SELECT s FROM Sat s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Sat.findByNumeroserie", query = "SELECT s FROM Sat s WHERE s.numeroserie = :numeroserie")
    , @NamedQuery(name = "Sat.findByVersaosb", query = "SELECT s FROM Sat s WHERE s.versaosb = :versaosb")
    , @NamedQuery(name = "Sat.findByFlagbloqueio", query = "SELECT s FROM Sat s WHERE s.flagbloqueio = :flagbloqueio")
    , @NamedQuery(name = "Sat.findByFlagativo", query = "SELECT s FROM Sat s WHERE s.flagativo = :flagativo")
    , @NamedQuery(name = "Sat.findByCodempresa", query = "SELECT s FROM Sat s WHERE s.codempresa = :codempresa")
    , @NamedQuery(name = "Sat.findByDhcomunicasefaz", query = "SELECT s FROM Sat s WHERE s.dhcomunicasefaz = :dhcomunicasefaz")
    , @NamedQuery(name = "Sat.findByLastChange", query = "SELECT s FROM Sat s WHERE s.lastChange = :lastChange")
    , @NamedQuery(name = "Sat.findByDatacertificadoexpira", query = "SELECT s FROM Sat s WHERE s.datacertificadoexpira = :datacertificadoexpira")
    , @NamedQuery(name = "Sat.findByNivelbateria", query = "SELECT s FROM Sat s WHERE s.nivelbateria = :nivelbateria")
    , @NamedQuery(name = "Sat.findByMemoriatotal", query = "SELECT s FROM Sat s WHERE s.memoriatotal = :memoriatotal")
    , @NamedQuery(name = "Sat.findByMemoriausada", query = "SELECT s FROM Sat s WHERE s.memoriausada = :memoriausada")})
public class Sat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSAT")
    private String codsat;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMEROSERIE")
    private String numeroserie;
    @Column(name = "VERSAOSB")
    private String versaosb;
    @Column(name = "FLAGBLOQUEIO")
    private Character flagbloqueio;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "DHCOMUNICASEFAZ")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhcomunicasefaz;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @Column(name = "DATACERTIFICADOEXPIRA")
    @Temporal(TemporalType.DATE)
    private Date datacertificadoexpira;
    @Column(name = "NIVELBATERIA")
    private String nivelbateria;
    @Column(name = "MEMORIATOTAL")
    private String memoriatotal;
    @Column(name = "MEMORIAUSADA")
    private String memoriausada;
    @JoinColumn(name = "CODSATMARCA", referencedColumnName = "CODSATMARCA")
    @ManyToOne
    private Satmarca codsatmarca;

    public Sat() {
    }

    public Sat(String codsat) {
        this.codsat = codsat;
    }

    public String getCodsat() {
        return codsat;
    }

    public void setCodsat(String codsat) {
        this.codsat = codsat;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getVersaosb() {
        return versaosb;
    }

    public void setVersaosb(String versaosb) {
        this.versaosb = versaosb;
    }

    public Character getFlagbloqueio() {
        return flagbloqueio;
    }

    public void setFlagbloqueio(Character flagbloqueio) {
        this.flagbloqueio = flagbloqueio;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public Date getDhcomunicasefaz() {
        return dhcomunicasefaz;
    }

    public void setDhcomunicasefaz(Date dhcomunicasefaz) {
        this.dhcomunicasefaz = dhcomunicasefaz;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Date getDatacertificadoexpira() {
        return datacertificadoexpira;
    }

    public void setDatacertificadoexpira(Date datacertificadoexpira) {
        this.datacertificadoexpira = datacertificadoexpira;
    }

    public String getNivelbateria() {
        return nivelbateria;
    }

    public void setNivelbateria(String nivelbateria) {
        this.nivelbateria = nivelbateria;
    }

    public String getMemoriatotal() {
        return memoriatotal;
    }

    public void setMemoriatotal(String memoriatotal) {
        this.memoriatotal = memoriatotal;
    }

    public String getMemoriausada() {
        return memoriausada;
    }

    public void setMemoriausada(String memoriausada) {
        this.memoriausada = memoriausada;
    }

    public Satmarca getCodsatmarca() {
        return codsatmarca;
    }

    public void setCodsatmarca(Satmarca codsatmarca) {
        this.codsatmarca = codsatmarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsat != null ? codsat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sat)) {
            return false;
        }
        Sat other = (Sat) object;
        if ((this.codsat == null && other.codsat != null) || (this.codsat != null && !this.codsat.equals(other.codsat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Sat[ codsat=" + codsat + " ]";
    }
    
}
