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
@Table(name = "ps_product_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductComment.findAll", query = "SELECT p FROM PsProductComment p")})
public class PsProductComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product_comment")
    private Integer idProductComment;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_customer")
    private int idCustomer;
    @Column(name = "id_guest")
    private Integer idGuest;
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "customer_name")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "grade")
    private float grade;
    @Basic(optional = false)
    @Column(name = "validate")
    private boolean validate;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsProductComment() {
    }

    public PsProductComment(Integer idProductComment) {
        this.idProductComment = idProductComment;
    }

    public PsProductComment(Integer idProductComment, int idProduct, int idCustomer, String content, float grade, boolean validate, boolean deleted, Date dateAdd) {
        this.idProductComment = idProductComment;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
        this.content = content;
        this.grade = grade;
        this.validate = validate;
        this.deleted = deleted;
        this.dateAdd = dateAdd;
    }

    public Integer getIdProductComment() {
        return idProductComment;
    }

    public void setIdProductComment(Integer idProductComment) {
        this.idProductComment = idProductComment;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public boolean getValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
        hash += (idProductComment != null ? idProductComment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductComment)) {
            return false;
        }
        PsProductComment other = (PsProductComment) object;
        if ((this.idProductComment == null && other.idProductComment != null) || (this.idProductComment != null && !this.idProductComment.equals(other.idProductComment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductComment[ idProductComment=" + idProductComment + " ]";
    }
    
}
