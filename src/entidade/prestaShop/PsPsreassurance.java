/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_psreassurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPsreassurance.findAll", query = "SELECT p FROM PsPsreassurance p")})
public class PsPsreassurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_psreassurance")
    private Integer idPsreassurance;
    @Column(name = "icon")
    private String icon;
    @Column(name = "custom_icon")
    private String customIcon;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Column(name = "type_link")
    private Integer typeLink;
    @Column(name = "id_cms")
    private Integer idCms;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsPsreassurance() {
    }

    public PsPsreassurance(Integer idPsreassurance) {
        this.idPsreassurance = idPsreassurance;
    }

    public PsPsreassurance(Integer idPsreassurance, int status, int position, Date dateAdd) {
        this.idPsreassurance = idPsreassurance;
        this.status = status;
        this.position = position;
        this.dateAdd = dateAdd;
    }

    public Integer getIdPsreassurance() {
        return idPsreassurance;
    }

    public void setIdPsreassurance(Integer idPsreassurance) {
        this.idPsreassurance = idPsreassurance;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCustomIcon() {
        return customIcon;
    }

    public void setCustomIcon(String customIcon) {
        this.customIcon = customIcon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getTypeLink() {
        return typeLink;
    }

    public void setTypeLink(Integer typeLink) {
        this.typeLink = typeLink;
    }

    public Integer getIdCms() {
        return idCms;
    }

    public void setIdCms(Integer idCms) {
        this.idCms = idCms;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPsreassurance != null ? idPsreassurance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPsreassurance)) {
            return false;
        }
        PsPsreassurance other = (PsPsreassurance) object;
        if ((this.idPsreassurance == null && other.idPsreassurance != null) || (this.idPsreassurance != null && !this.idPsreassurance.equals(other.idPsreassurance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPsreassurance[ idPsreassurance=" + idPsreassurance + " ]";
    }
    
}
