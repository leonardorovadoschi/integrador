/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_anblog_blog_widgets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogBlogWidgets.findAll", query = "SELECT p FROM PsAnblogBlogWidgets p")})
public class PsAnblogBlogWidgets implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anblog_blog_widgets")
    private Integer idAnblogBlogWidgets;
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private int idAnblogcat;
    @Basic(optional = false)
    @Column(name = "snow_on")
    private int snowOn;
    @Basic(optional = false)
    @Column(name = "sort")
    private String sort;
    @Basic(optional = false)
    @Column(name = "slider")
    private short slider;
    @Basic(optional = false)
    @Column(name = "limit")
    private int limit;
    @Basic(optional = false)
    @Column(name = "relation")
    private int relation;
    @Basic(optional = false)
    @Column(name = "show_read_more")
    private short showReadMore;

    public PsAnblogBlogWidgets() {
    }

    public PsAnblogBlogWidgets(Integer idAnblogBlogWidgets) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
    }

    public PsAnblogBlogWidgets(Integer idAnblogBlogWidgets, int idAnblogcat, int snowOn, String sort, short slider, int limit, int relation, short showReadMore) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
        this.idAnblogcat = idAnblogcat;
        this.snowOn = snowOn;
        this.sort = sort;
        this.slider = slider;
        this.limit = limit;
        this.relation = relation;
        this.showReadMore = showReadMore;
    }

    public Integer getIdAnblogBlogWidgets() {
        return idAnblogBlogWidgets;
    }

    public void setIdAnblogBlogWidgets(Integer idAnblogBlogWidgets) {
        this.idAnblogBlogWidgets = idAnblogBlogWidgets;
    }

    public int getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(int idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
    }

    public int getSnowOn() {
        return snowOn;
    }

    public void setSnowOn(int snowOn) {
        this.snowOn = snowOn;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public short getSlider() {
        return slider;
    }

    public void setSlider(short slider) {
        this.slider = slider;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
    }

    public short getShowReadMore() {
        return showReadMore;
    }

    public void setShowReadMore(short showReadMore) {
        this.showReadMore = showReadMore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnblogBlogWidgets != null ? idAnblogBlogWidgets.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogBlogWidgets)) {
            return false;
        }
        PsAnblogBlogWidgets other = (PsAnblogBlogWidgets) object;
        if ((this.idAnblogBlogWidgets == null && other.idAnblogBlogWidgets != null) || (this.idAnblogBlogWidgets != null && !this.idAnblogBlogWidgets.equals(other.idAnblogBlogWidgets))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogBlogWidgets[ idAnblogBlogWidgets=" + idAnblogBlogWidgets + " ]";
    }
    
}
