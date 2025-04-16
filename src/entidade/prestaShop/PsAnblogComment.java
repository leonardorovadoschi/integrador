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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ps_anblog_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogComment.findAll", query = "SELECT p FROM PsAnblogComment p")})
public class PsAnblogComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsAnblogCommentPK psAnblogCommentPK;
    @Basic(optional = false)
    @Column(name = "id_anblog_blog")
    private int idAnblogBlog;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    public PsAnblogComment() {
    }

    public PsAnblogComment(PsAnblogCommentPK psAnblogCommentPK) {
        this.psAnblogCommentPK = psAnblogCommentPK;
    }

    public PsAnblogComment(PsAnblogCommentPK psAnblogCommentPK, int idAnblogBlog, String comment, boolean active, String user, String email) {
        this.psAnblogCommentPK = psAnblogCommentPK;
        this.idAnblogBlog = idAnblogBlog;
        this.comment = comment;
        this.active = active;
        this.user = user;
        this.email = email;
    }

    public PsAnblogComment(int idAnblogComment, int idShop) {
        this.psAnblogCommentPK = new PsAnblogCommentPK(idAnblogComment, idShop);
    }

    public PsAnblogCommentPK getPsAnblogCommentPK() {
        return psAnblogCommentPK;
    }

    public void setPsAnblogCommentPK(PsAnblogCommentPK psAnblogCommentPK) {
        this.psAnblogCommentPK = psAnblogCommentPK;
    }

    public int getIdAnblogBlog() {
        return idAnblogBlog;
    }

    public void setIdAnblogBlog(int idAnblogBlog) {
        this.idAnblogBlog = idAnblogBlog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psAnblogCommentPK != null ? psAnblogCommentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogComment)) {
            return false;
        }
        PsAnblogComment other = (PsAnblogComment) object;
        if ((this.psAnblogCommentPK == null && other.psAnblogCommentPK != null) || (this.psAnblogCommentPK != null && !this.psAnblogCommentPK.equals(other.psAnblogCommentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogComment[ psAnblogCommentPK=" + psAnblogCommentPK + " ]";
    }
    
}
