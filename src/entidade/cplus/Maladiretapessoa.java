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
@Table(name = "MALADIRETAPESSOA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maladiretapessoa.findAll", query = "SELECT m FROM Maladiretapessoa m")
    , @NamedQuery(name = "Maladiretapessoa.findByCodmaladiretapessoa", query = "SELECT m FROM Maladiretapessoa m WHERE m.codmaladiretapessoa = :codmaladiretapessoa")
    , @NamedQuery(name = "Maladiretapessoa.findByCodmaladireta", query = "SELECT m FROM Maladiretapessoa m WHERE m.codmaladireta = :codmaladireta")
    , @NamedQuery(name = "Maladiretapessoa.findByIdentidadepessoa", query = "SELECT m FROM Maladiretapessoa m WHERE m.identidadepessoa = :identidadepessoa")
    , @NamedQuery(name = "Maladiretapessoa.findByNomeentidadepessoa", query = "SELECT m FROM Maladiretapessoa m WHERE m.nomeentidadepessoa = :nomeentidadepessoa")
    , @NamedQuery(name = "Maladiretapessoa.findByEmailpessoa", query = "SELECT m FROM Maladiretapessoa m WHERE m.emailpessoa = :emailpessoa")
    , @NamedQuery(name = "Maladiretapessoa.findByStatusenvio", query = "SELECT m FROM Maladiretapessoa m WHERE m.statusenvio = :statusenvio")
    , @NamedQuery(name = "Maladiretapessoa.findByDataenvio", query = "SELECT m FROM Maladiretapessoa m WHERE m.dataenvio = :dataenvio")})
public class Maladiretapessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMALADIRETAPESSOA")
    private Integer codmaladiretapessoa;
    @Column(name = "CODMALADIRETA")
    private Integer codmaladireta;
    @Column(name = "IDENTIDADEPESSOA")
    private String identidadepessoa;
    @Column(name = "NOMEENTIDADEPESSOA")
    private String nomeentidadepessoa;
    @Column(name = "EMAILPESSOA")
    private String emailpessoa;
    @Column(name = "STATUSENVIO")
    private Character statusenvio;
    @Column(name = "DATAENVIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataenvio;

    public Maladiretapessoa() {
    }

    public Maladiretapessoa(Integer codmaladiretapessoa) {
        this.codmaladiretapessoa = codmaladiretapessoa;
    }

    public Integer getCodmaladiretapessoa() {
        return codmaladiretapessoa;
    }

    public void setCodmaladiretapessoa(Integer codmaladiretapessoa) {
        this.codmaladiretapessoa = codmaladiretapessoa;
    }

    public Integer getCodmaladireta() {
        return codmaladireta;
    }

    public void setCodmaladireta(Integer codmaladireta) {
        this.codmaladireta = codmaladireta;
    }

    public String getIdentidadepessoa() {
        return identidadepessoa;
    }

    public void setIdentidadepessoa(String identidadepessoa) {
        this.identidadepessoa = identidadepessoa;
    }

    public String getNomeentidadepessoa() {
        return nomeentidadepessoa;
    }

    public void setNomeentidadepessoa(String nomeentidadepessoa) {
        this.nomeentidadepessoa = nomeentidadepessoa;
    }

    public String getEmailpessoa() {
        return emailpessoa;
    }

    public void setEmailpessoa(String emailpessoa) {
        this.emailpessoa = emailpessoa;
    }

    public Character getStatusenvio() {
        return statusenvio;
    }

    public void setStatusenvio(Character statusenvio) {
        this.statusenvio = statusenvio;
    }

    public Date getDataenvio() {
        return dataenvio;
    }

    public void setDataenvio(Date dataenvio) {
        this.dataenvio = dataenvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmaladiretapessoa != null ? codmaladiretapessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maladiretapessoa)) {
            return false;
        }
        Maladiretapessoa other = (Maladiretapessoa) object;
        if ((this.codmaladiretapessoa == null && other.codmaladiretapessoa != null) || (this.codmaladiretapessoa != null && !this.codmaladiretapessoa.equals(other.codmaladiretapessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Maladiretapessoa[ codmaladiretapessoa=" + codmaladiretapessoa + " ]";
    }
    
}
