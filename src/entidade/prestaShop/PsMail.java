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
@Table(name = "ps_mail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMail.findAll", query = "SELECT p FROM PsMail p")
    , @NamedQuery(name = "PsMail.findByIdMail", query = "SELECT p FROM PsMail p WHERE p.idMail = :idMail")
    , @NamedQuery(name = "PsMail.findByRecipient", query = "SELECT p FROM PsMail p WHERE p.recipient = :recipient")
    , @NamedQuery(name = "PsMail.findByTemplate", query = "SELECT p FROM PsMail p WHERE p.template = :template")
    , @NamedQuery(name = "PsMail.findBySubject", query = "SELECT p FROM PsMail p WHERE p.subject = :subject")
    , @NamedQuery(name = "PsMail.findByIdLang", query = "SELECT p FROM PsMail p WHERE p.idLang = :idLang")
    , @NamedQuery(name = "PsMail.findByDateAdd", query = "SELECT p FROM PsMail p WHERE p.dateAdd = :dateAdd")})
public class PsMail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mail")
    private Integer idMail;
    @Basic(optional = false)
    @Column(name = "recipient")
    private String recipient;
    @Basic(optional = false)
    @Column(name = "template")
    private String template;
    @Basic(optional = false)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @Column(name = "id_lang")
    private int idLang;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsMail() {
    }

    public PsMail(Integer idMail) {
        this.idMail = idMail;
    }

    public PsMail(Integer idMail, String recipient, String template, String subject, int idLang, Date dateAdd) {
        this.idMail = idMail;
        this.recipient = recipient;
        this.template = template;
        this.subject = subject;
        this.idLang = idLang;
        this.dateAdd = dateAdd;
    }

    public Integer getIdMail() {
        return idMail;
    }

    public void setIdMail(Integer idMail) {
        this.idMail = idMail;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
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
        hash += (idMail != null ? idMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMail)) {
            return false;
        }
        PsMail other = (PsMail) object;
        if ((this.idMail == null && other.idMail != null) || (this.idMail != null && !this.idMail.equals(other.idMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMail[ idMail=" + idMail + " ]";
    }
    
}
