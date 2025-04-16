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
import javax.persistence.Lob;
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
@Table(name = "ps_anblog_blog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlog.findAll", query = "SELECT p FROM PsAnblogBlog p")})
public class PsAnblogBlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anblog_blog")
    private Integer idAnblogBlog;
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private int idAnblogcat;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.DATE)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "hits")
    private int hits;
    @Column(name = "image")
    private String image;
    @Column(name = "thumb")
    private String thumb;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Lob
    @Column(name = "video_code")
    private String videoCode;
    @Lob
    @Column(name = "params")
    private String params;
    @Lob
    @Column(name = "products")
    private String products;
    @Basic(optional = false)
    @Column(name = "featured")
    private boolean featured;
    @Basic(optional = false)
    @Column(name = "indexation")
    private int indexation;
    @Basic(optional = false)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "product_ids")
    private String productIds;
    @Column(name = "author_name")
    private String authorName;
    @Basic(optional = false)
    @Column(name = "likes")
    private int likes;

    public PsAnblogBlog() {
    }

    public PsAnblogBlog(Integer idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public PsAnblogBlog(Integer idAnblogBlog, int idAnblogcat, int position, Date dateAdd, boolean active, int userId, int hits, Date dateUpd, boolean featured, int indexation, int idEmployee, int likes) {
        this.idAnblogBlog = idAnblogBlog;
        this.idAnblogcat = idAnblogcat;
        this.position = position;
        this.dateAdd = dateAdd;
        this.active = active;
        this.userId = userId;
        this.hits = hits;
        this.dateUpd = dateUpd;
        this.featured = featured;
        this.indexation = indexation;
        this.idEmployee = idEmployee;
        this.likes = likes;
    }

    public Integer getIdAnblogBlog() {
        return idAnblogBlog;
    }

    public void setIdAnblogBlog(Integer idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public int getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(int idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public boolean getFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getIndexation() {
        return indexation;
    }

    public void setIndexation(int indexation) {
        this.indexation = indexation;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnblogBlog != null ? idAnblogBlog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlog)) {
            return false;
        }
        PsAnblogBlog other = (PsAnblogBlog) object;
        if ((this.idAnblogBlog == null && other.idAnblogBlog != null) || (this.idAnblogBlog != null && !this.idAnblogBlog.equals(other.idAnblogBlog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlog[ idAnblogBlog=" + idAnblogBlog + " ]";
    }
    
}
