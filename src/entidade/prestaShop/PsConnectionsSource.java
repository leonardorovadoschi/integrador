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
@Table(name = "ps_connections_source")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConnectionsSource.findAll", query = "SELECT p FROM PsConnectionsSource p")
    , @NamedQuery(name = "PsConnectionsSource.findByIdConnectionsSource", query = "SELECT p FROM PsConnectionsSource p WHERE p.idConnectionsSource = :idConnectionsSource")
    , @NamedQuery(name = "PsConnectionsSource.findByIdConnections", query = "SELECT p FROM PsConnectionsSource p WHERE p.idConnections = :idConnections")
    , @NamedQuery(name = "PsConnectionsSource.findByHttpReferer", query = "SELECT p FROM PsConnectionsSource p WHERE p.httpReferer = :httpReferer")
    , @NamedQuery(name = "PsConnectionsSource.findByRequestUri", query = "SELECT p FROM PsConnectionsSource p WHERE p.requestUri = :requestUri")
    , @NamedQuery(name = "PsConnectionsSource.findByKeywords", query = "SELECT p FROM PsConnectionsSource p WHERE p.keywords = :keywords")
    , @NamedQuery(name = "PsConnectionsSource.findByDateAdd", query = "SELECT p FROM PsConnectionsSource p WHERE p.dateAdd = :dateAdd")})
public class PsConnectionsSource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_connections_source")
    private Integer idConnectionsSource;
    @Basic(optional = false)
    @Column(name = "id_connections")
    private int idConnections;
    @Column(name = "http_referer")
    private String httpReferer;
    @Column(name = "request_uri")
    private String requestUri;
    @Column(name = "keywords")
    private String keywords;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsConnectionsSource() {
    }

    public PsConnectionsSource(Integer idConnectionsSource) {
        this.idConnectionsSource = idConnectionsSource;
    }

    public PsConnectionsSource(Integer idConnectionsSource, int idConnections, Date dateAdd) {
        this.idConnectionsSource = idConnectionsSource;
        this.idConnections = idConnections;
        this.dateAdd = dateAdd;
    }

    public Integer getIdConnectionsSource() {
        return idConnectionsSource;
    }

    public void setIdConnectionsSource(Integer idConnectionsSource) {
        this.idConnectionsSource = idConnectionsSource;
    }

    public int getIdConnections() {
        return idConnections;
    }

    public void setIdConnections(int idConnections) {
        this.idConnections = idConnections;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
        hash += (idConnectionsSource != null ? idConnectionsSource.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConnectionsSource)) {
            return false;
        }
        PsConnectionsSource other = (PsConnectionsSource) object;
        if ((this.idConnectionsSource == null && other.idConnectionsSource != null) || (this.idConnectionsSource != null && !this.idConnectionsSource.equals(other.idConnectionsSource))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConnectionsSource[ idConnectionsSource=" + idConnectionsSource + " ]";
    }
    
}
