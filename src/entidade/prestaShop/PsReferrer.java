/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ps_referrer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsReferrer.findAll", query = "SELECT p FROM PsReferrer p")
    , @NamedQuery(name = "PsReferrer.findByIdReferrer", query = "SELECT p FROM PsReferrer p WHERE p.idReferrer = :idReferrer")
    , @NamedQuery(name = "PsReferrer.findByName", query = "SELECT p FROM PsReferrer p WHERE p.name = :name")
    , @NamedQuery(name = "PsReferrer.findByPasswd", query = "SELECT p FROM PsReferrer p WHERE p.passwd = :passwd")
    , @NamedQuery(name = "PsReferrer.findByHttpRefererRegexp", query = "SELECT p FROM PsReferrer p WHERE p.httpRefererRegexp = :httpRefererRegexp")
    , @NamedQuery(name = "PsReferrer.findByHttpRefererLike", query = "SELECT p FROM PsReferrer p WHERE p.httpRefererLike = :httpRefererLike")
    , @NamedQuery(name = "PsReferrer.findByRequestUriRegexp", query = "SELECT p FROM PsReferrer p WHERE p.requestUriRegexp = :requestUriRegexp")
    , @NamedQuery(name = "PsReferrer.findByRequestUriLike", query = "SELECT p FROM PsReferrer p WHERE p.requestUriLike = :requestUriLike")
    , @NamedQuery(name = "PsReferrer.findByHttpRefererRegexpNot", query = "SELECT p FROM PsReferrer p WHERE p.httpRefererRegexpNot = :httpRefererRegexpNot")
    , @NamedQuery(name = "PsReferrer.findByHttpRefererLikeNot", query = "SELECT p FROM PsReferrer p WHERE p.httpRefererLikeNot = :httpRefererLikeNot")
    , @NamedQuery(name = "PsReferrer.findByRequestUriRegexpNot", query = "SELECT p FROM PsReferrer p WHERE p.requestUriRegexpNot = :requestUriRegexpNot")
    , @NamedQuery(name = "PsReferrer.findByRequestUriLikeNot", query = "SELECT p FROM PsReferrer p WHERE p.requestUriLikeNot = :requestUriLikeNot")
    , @NamedQuery(name = "PsReferrer.findByBaseFee", query = "SELECT p FROM PsReferrer p WHERE p.baseFee = :baseFee")
    , @NamedQuery(name = "PsReferrer.findByPercentFee", query = "SELECT p FROM PsReferrer p WHERE p.percentFee = :percentFee")
    , @NamedQuery(name = "PsReferrer.findByClickFee", query = "SELECT p FROM PsReferrer p WHERE p.clickFee = :clickFee")
    , @NamedQuery(name = "PsReferrer.findByDateAdd", query = "SELECT p FROM PsReferrer p WHERE p.dateAdd = :dateAdd")})
public class PsReferrer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_referrer")
    private Integer idReferrer;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "http_referer_regexp")
    private String httpRefererRegexp;
    @Column(name = "http_referer_like")
    private String httpRefererLike;
    @Column(name = "request_uri_regexp")
    private String requestUriRegexp;
    @Column(name = "request_uri_like")
    private String requestUriLike;
    @Column(name = "http_referer_regexp_not")
    private String httpRefererRegexpNot;
    @Column(name = "http_referer_like_not")
    private String httpRefererLikeNot;
    @Column(name = "request_uri_regexp_not")
    private String requestUriRegexpNot;
    @Column(name = "request_uri_like_not")
    private String requestUriLikeNot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "base_fee")
    private BigDecimal baseFee;
    @Basic(optional = false)
    @Column(name = "percent_fee")
    private BigDecimal percentFee;
    @Basic(optional = false)
    @Column(name = "click_fee")
    private BigDecimal clickFee;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsReferrer() {
    }

    public PsReferrer(Integer idReferrer) {
        this.idReferrer = idReferrer;
    }

    public PsReferrer(Integer idReferrer, String name, BigDecimal baseFee, BigDecimal percentFee, BigDecimal clickFee, Date dateAdd) {
        this.idReferrer = idReferrer;
        this.name = name;
        this.baseFee = baseFee;
        this.percentFee = percentFee;
        this.clickFee = clickFee;
        this.dateAdd = dateAdd;
    }

    public Integer getIdReferrer() {
        return idReferrer;
    }

    public void setIdReferrer(Integer idReferrer) {
        this.idReferrer = idReferrer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getHttpRefererRegexp() {
        return httpRefererRegexp;
    }

    public void setHttpRefererRegexp(String httpRefererRegexp) {
        this.httpRefererRegexp = httpRefererRegexp;
    }

    public String getHttpRefererLike() {
        return httpRefererLike;
    }

    public void setHttpRefererLike(String httpRefererLike) {
        this.httpRefererLike = httpRefererLike;
    }

    public String getRequestUriRegexp() {
        return requestUriRegexp;
    }

    public void setRequestUriRegexp(String requestUriRegexp) {
        this.requestUriRegexp = requestUriRegexp;
    }

    public String getRequestUriLike() {
        return requestUriLike;
    }

    public void setRequestUriLike(String requestUriLike) {
        this.requestUriLike = requestUriLike;
    }

    public String getHttpRefererRegexpNot() {
        return httpRefererRegexpNot;
    }

    public void setHttpRefererRegexpNot(String httpRefererRegexpNot) {
        this.httpRefererRegexpNot = httpRefererRegexpNot;
    }

    public String getHttpRefererLikeNot() {
        return httpRefererLikeNot;
    }

    public void setHttpRefererLikeNot(String httpRefererLikeNot) {
        this.httpRefererLikeNot = httpRefererLikeNot;
    }

    public String getRequestUriRegexpNot() {
        return requestUriRegexpNot;
    }

    public void setRequestUriRegexpNot(String requestUriRegexpNot) {
        this.requestUriRegexpNot = requestUriRegexpNot;
    }

    public String getRequestUriLikeNot() {
        return requestUriLikeNot;
    }

    public void setRequestUriLikeNot(String requestUriLikeNot) {
        this.requestUriLikeNot = requestUriLikeNot;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getPercentFee() {
        return percentFee;
    }

    public void setPercentFee(BigDecimal percentFee) {
        this.percentFee = percentFee;
    }

    public BigDecimal getClickFee() {
        return clickFee;
    }

    public void setClickFee(BigDecimal clickFee) {
        this.clickFee = clickFee;
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
        hash += (idReferrer != null ? idReferrer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReferrer)) {
            return false;
        }
        PsReferrer other = (PsReferrer) object;
        if ((this.idReferrer == null && other.idReferrer != null) || (this.idReferrer != null && !this.idReferrer.equals(other.idReferrer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReferrer[ idReferrer=" + idReferrer + " ]";
    }
    
}
