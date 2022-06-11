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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_advice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAdvice.findAll", query = "SELECT p FROM PsAdvice p")
    , @NamedQuery(name = "PsAdvice.findByIdAdvice", query = "SELECT p FROM PsAdvice p WHERE p.idAdvice = :idAdvice")
    , @NamedQuery(name = "PsAdvice.findByIdPsAdvice", query = "SELECT p FROM PsAdvice p WHERE p.idPsAdvice = :idPsAdvice")
    , @NamedQuery(name = "PsAdvice.findByIdTab", query = "SELECT p FROM PsAdvice p WHERE p.idTab = :idTab")
    , @NamedQuery(name = "PsAdvice.findByValidated", query = "SELECT p FROM PsAdvice p WHERE p.validated = :validated")
    , @NamedQuery(name = "PsAdvice.findByHide", query = "SELECT p FROM PsAdvice p WHERE p.hide = :hide")
    , @NamedQuery(name = "PsAdvice.findByLocation", query = "SELECT p FROM PsAdvice p WHERE p.location = :location")
    , @NamedQuery(name = "PsAdvice.findBySelector", query = "SELECT p FROM PsAdvice p WHERE p.selector = :selector")
    , @NamedQuery(name = "PsAdvice.findByStartDay", query = "SELECT p FROM PsAdvice p WHERE p.startDay = :startDay")
    , @NamedQuery(name = "PsAdvice.findByStopDay", query = "SELECT p FROM PsAdvice p WHERE p.stopDay = :stopDay")
    , @NamedQuery(name = "PsAdvice.findByWeight", query = "SELECT p FROM PsAdvice p WHERE p.weight = :weight")})
public class PsAdvice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_advice")
    private Integer idAdvice;
    @Basic(optional = false)
    @Column(name = "id_ps_advice")
    private int idPsAdvice;
    @Basic(optional = false)
    @Column(name = "id_tab")
    private int idTab;
    @Lob
    @Column(name = "ids_tab")
    private String idsTab;
    @Basic(optional = false)
    @Column(name = "validated")
    private boolean validated;
    @Basic(optional = false)
    @Column(name = "hide")
    private boolean hide;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Column(name = "selector")
    private String selector;
    @Basic(optional = false)
    @Column(name = "start_day")
    private int startDay;
    @Basic(optional = false)
    @Column(name = "stop_day")
    private int stopDay;
    @Column(name = "weight")
    private Integer weight;

    public PsAdvice() {
    }

    public PsAdvice(Integer idAdvice) {
        this.idAdvice = idAdvice;
    }

    public PsAdvice(Integer idAdvice, int idPsAdvice, int idTab, boolean validated, boolean hide, String location, int startDay, int stopDay) {
        this.idAdvice = idAdvice;
        this.idPsAdvice = idPsAdvice;
        this.idTab = idTab;
        this.validated = validated;
        this.hide = hide;
        this.location = location;
        this.startDay = startDay;
        this.stopDay = stopDay;
    }

    public Integer getIdAdvice() {
        return idAdvice;
    }

    public void setIdAdvice(Integer idAdvice) {
        this.idAdvice = idAdvice;
    }

    public int getIdPsAdvice() {
        return idPsAdvice;
    }

    public void setIdPsAdvice(int idPsAdvice) {
        this.idPsAdvice = idPsAdvice;
    }

    public int getIdTab() {
        return idTab;
    }

    public void setIdTab(int idTab) {
        this.idTab = idTab;
    }

    public String getIdsTab() {
        return idsTab;
    }

    public void setIdsTab(String idsTab) {
        this.idsTab = idsTab;
    }

    public boolean getValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public boolean getHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getStopDay() {
        return stopDay;
    }

    public void setStopDay(int stopDay) {
        this.stopDay = stopDay;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdvice != null ? idAdvice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAdvice)) {
            return false;
        }
        PsAdvice other = (PsAdvice) object;
        if ((this.idAdvice == null && other.idAdvice != null) || (this.idAdvice != null && !this.idAdvice.equals(other.idAdvice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAdvice[ idAdvice=" + idAdvice + " ]";
    }
    
}
