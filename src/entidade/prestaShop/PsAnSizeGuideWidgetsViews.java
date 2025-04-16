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
@Table(name = "ps_an_size_guide_widgets_views")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnSizeGuideWidgetsViews.findAll", query = "SELECT p FROM PsAnSizeGuideWidgetsViews p")})
public class PsAnSizeGuideWidgetsViews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_views")
    private Integer idViews;
    @Basic(optional = false)
    @Column(name = "id_widget")
    private int idWidget;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "views")
    private int views;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.DATE)
    private Date dateAdd;

    public PsAnSizeGuideWidgetsViews() {
    }

    public PsAnSizeGuideWidgetsViews(Integer idViews) {
        this.idViews = idViews;
    }

    public PsAnSizeGuideWidgetsViews(Integer idViews, int idWidget, int idProduct, int views, Date dateAdd) {
        this.idViews = idViews;
        this.idWidget = idWidget;
        this.idProduct = idProduct;
        this.views = views;
        this.dateAdd = dateAdd;
    }

    public Integer getIdViews() {
        return idViews;
    }

    public void setIdViews(Integer idViews) {
        this.idViews = idViews;
    }

    public int getIdWidget() {
        return idWidget;
    }

    public void setIdWidget(int idWidget) {
        this.idWidget = idWidget;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
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
        hash += (idViews != null ? idViews.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnSizeGuideWidgetsViews)) {
            return false;
        }
        PsAnSizeGuideWidgetsViews other = (PsAnSizeGuideWidgetsViews) object;
        if ((this.idViews == null && other.idViews != null) || (this.idViews != null && !this.idViews.equals(other.idViews))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnSizeGuideWidgetsViews[ idViews=" + idViews + " ]";
    }
    
}
