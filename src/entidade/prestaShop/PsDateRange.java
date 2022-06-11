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
 * @author leo
 */
@Entity
@Table(name = "ps_date_range")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsDateRange.findAll", query = "SELECT p FROM PsDateRange p")
    , @NamedQuery(name = "PsDateRange.findByIdDateRange", query = "SELECT p FROM PsDateRange p WHERE p.idDateRange = :idDateRange")
    , @NamedQuery(name = "PsDateRange.findByTimeStart", query = "SELECT p FROM PsDateRange p WHERE p.timeStart = :timeStart")
    , @NamedQuery(name = "PsDateRange.findByTimeEnd", query = "SELECT p FROM PsDateRange p WHERE p.timeEnd = :timeEnd")})
public class PsDateRange implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_date_range")
    private Integer idDateRange;
    @Basic(optional = false)
    @Column(name = "time_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;
    @Basic(optional = false)
    @Column(name = "time_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;

    public PsDateRange() {
    }

    public PsDateRange(Integer idDateRange) {
        this.idDateRange = idDateRange;
    }

    public PsDateRange(Integer idDateRange, Date timeStart, Date timeEnd) {
        this.idDateRange = idDateRange;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Integer getIdDateRange() {
        return idDateRange;
    }

    public void setIdDateRange(Integer idDateRange) {
        this.idDateRange = idDateRange;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDateRange != null ? idDateRange.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsDateRange)) {
            return false;
        }
        PsDateRange other = (PsDateRange) object;
        if ((this.idDateRange == null && other.idDateRange != null) || (this.idDateRange != null && !this.idDateRange.equals(other.idDateRange))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsDateRange[ idDateRange=" + idDateRange + " ]";
    }
    
}
