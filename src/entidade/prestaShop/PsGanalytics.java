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
@Table(name = "ps_ganalytics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGanalytics.findAll", query = "SELECT p FROM PsGanalytics p")})
public class PsGanalytics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_google_analytics")
    private Integer idGoogleAnalytics;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Column(name = "sent")
    private Boolean sent;
    @Column(name = "refund_sent")
    private Boolean refundSent;
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsGanalytics() {
    }

    public PsGanalytics(Integer idGoogleAnalytics) {
        this.idGoogleAnalytics = idGoogleAnalytics;
    }

    public PsGanalytics(Integer idGoogleAnalytics, int idOrder, int idCustomer, int idShop) {
        this.idGoogleAnalytics = idGoogleAnalytics;
        this.idOrder = idOrder;
        this.idCustomer = idCustomer;
        this.idShop = idShop;
    }

    public Integer getIdGoogleAnalytics() {
        return idGoogleAnalytics;
    }

    public void setIdGoogleAnalytics(Integer idGoogleAnalytics) {
        this.idGoogleAnalytics = idGoogleAnalytics;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Boolean getRefundSent() {
        return refundSent;
    }

    public void setRefundSent(Boolean refundSent) {
        this.refundSent = refundSent;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGoogleAnalytics != null ? idGoogleAnalytics.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGanalytics)) {
            return false;
        }
        PsGanalytics other = (PsGanalytics) object;
        if ((this.idGoogleAnalytics == null && other.idGoogleAnalytics != null) || (this.idGoogleAnalytics != null && !this.idGoogleAnalytics.equals(other.idGoogleAnalytics))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGanalytics[ idGoogleAnalytics=" + idGoogleAnalytics + " ]";
    }
    
}
