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
@Table(name = "ps_product_download")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductDownload.findAll", query = "SELECT p FROM PsProductDownload p")
    , @NamedQuery(name = "PsProductDownload.findByIdProductDownload", query = "SELECT p FROM PsProductDownload p WHERE p.idProductDownload = :idProductDownload")
    , @NamedQuery(name = "PsProductDownload.findByIdProduct", query = "SELECT p FROM PsProductDownload p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductDownload.findByDisplayFilename", query = "SELECT p FROM PsProductDownload p WHERE p.displayFilename = :displayFilename")
    , @NamedQuery(name = "PsProductDownload.findByFilename", query = "SELECT p FROM PsProductDownload p WHERE p.filename = :filename")
    , @NamedQuery(name = "PsProductDownload.findByDateAdd", query = "SELECT p FROM PsProductDownload p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsProductDownload.findByDateExpiration", query = "SELECT p FROM PsProductDownload p WHERE p.dateExpiration = :dateExpiration")
    , @NamedQuery(name = "PsProductDownload.findByNbDaysAccessible", query = "SELECT p FROM PsProductDownload p WHERE p.nbDaysAccessible = :nbDaysAccessible")
    , @NamedQuery(name = "PsProductDownload.findByNbDownloadable", query = "SELECT p FROM PsProductDownload p WHERE p.nbDownloadable = :nbDownloadable")
    , @NamedQuery(name = "PsProductDownload.findByActive", query = "SELECT p FROM PsProductDownload p WHERE p.active = :active")
    , @NamedQuery(name = "PsProductDownload.findByIsShareable", query = "SELECT p FROM PsProductDownload p WHERE p.isShareable = :isShareable")})
public class PsProductDownload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_download")
    private Integer idProductDownload;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "display_filename")
    private String displayFilename;
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Column(name = "date_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateExpiration;
    @Column(name = "nb_days_accessible")
    private Integer nbDaysAccessible;
    @Column(name = "nb_downloadable")
    private Integer nbDownloadable;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "is_shareable")
    private boolean isShareable;

    public PsProductDownload() {
    }

    public PsProductDownload(Integer idProductDownload) {
        this.idProductDownload = idProductDownload;
    }

    public PsProductDownload(Integer idProductDownload, int idProduct, Date dateAdd, boolean active, boolean isShareable) {
        this.idProductDownload = idProductDownload;
        this.idProduct = idProduct;
        this.dateAdd = dateAdd;
        this.active = active;
        this.isShareable = isShareable;
    }

    public Integer getIdProductDownload() {
        return idProductDownload;
    }

    public void setIdProductDownload(Integer idProductDownload) {
        this.idProductDownload = idProductDownload;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDisplayFilename() {
        return displayFilename;
    }

    public void setDisplayFilename(String displayFilename) {
        this.displayFilename = displayFilename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Integer getNbDaysAccessible() {
        return nbDaysAccessible;
    }

    public void setNbDaysAccessible(Integer nbDaysAccessible) {
        this.nbDaysAccessible = nbDaysAccessible;
    }

    public Integer getNbDownloadable() {
        return nbDownloadable;
    }

    public void setNbDownloadable(Integer nbDownloadable) {
        this.nbDownloadable = nbDownloadable;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getIsShareable() {
        return isShareable;
    }

    public void setIsShareable(boolean isShareable) {
        this.isShareable = isShareable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductDownload != null ? idProductDownload.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductDownload)) {
            return false;
        }
        PsProductDownload other = (PsProductDownload) object;
        if ((this.idProductDownload == null && other.idProductDownload != null) || (this.idProductDownload != null && !this.idProductDownload.equals(other.idProductDownload))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductDownload[ idProductDownload=" + idProductDownload + " ]";
    }
    
}
