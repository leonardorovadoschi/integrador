/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsState.findAll", query = "SELECT p FROM PsState p")
    , @NamedQuery(name = "PsState.findByIdState", query = "SELECT p FROM PsState p WHERE p.idState = :idState")
    , @NamedQuery(name = "PsState.findByIdCountry", query = "SELECT p FROM PsState p WHERE p.idCountry = :idCountry")
    , @NamedQuery(name = "PsState.findByIdZone", query = "SELECT p FROM PsState p WHERE p.idZone = :idZone")
    , @NamedQuery(name = "PsState.findByName", query = "SELECT p FROM PsState p WHERE p.name = :name")
    , @NamedQuery(name = "PsState.findByIsoCode", query = "SELECT p FROM PsState p WHERE p.isoCode = :isoCode")
    , @NamedQuery(name = "PsState.findByTaxBehavior", query = "SELECT p FROM PsState p WHERE p.taxBehavior = :taxBehavior")
    , @NamedQuery(name = "PsState.findByActive", query = "SELECT p FROM PsState p WHERE p.active = :active")})
public class PsState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_state")
    private Integer idState;
    @Basic(optional = false)
    @Column(name = "id_country")
    private int idCountry;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "iso_code")
    private String isoCode;
    @Basic(optional = false)
    @Column(name = "tax_behavior")
    private short taxBehavior;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsState() {
    }

    public PsState(Integer idState) {
        this.idState = idState;
    }

    public PsState(Integer idState, int idCountry, int idZone, String name, String isoCode, short taxBehavior, boolean active) {
        this.idState = idState;
        this.idCountry = idCountry;
        this.idZone = idZone;
        this.name = name;
        this.isoCode = isoCode;
        this.taxBehavior = taxBehavior;
        this.active = active;
    }

    public Integer getIdState() {
        return idState;
    }

    public void setIdState(Integer idState) {
        this.idState = idState;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public short getTaxBehavior() {
        return taxBehavior;
    }

    public void setTaxBehavior(short taxBehavior) {
        this.taxBehavior = taxBehavior;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idState != null ? idState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsState)) {
            return false;
        }
        PsState other = (PsState) object;
        if ((this.idState == null && other.idState != null) || (this.idState != null && !this.idState.equals(other.idState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsState[ idState=" + idState + " ]";
    }
    
}
