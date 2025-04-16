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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo-note
 */
@Entity
@Table(name = "ps_andropdown")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAndropdown.findAll", query = "SELECT p FROM PsAndropdown p")})
public class PsAndropdown implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_andropdown")
    private Integer idAndropdown;
    @Basic(optional = false)
    @Column(name = "id_anmenu")
    private int idAnmenu;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Column(name = "column")
    private Integer column;
    @Basic(optional = false)
    @Column(name = "content_type")
    private String contentType;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "categories")
    private String categories;
    @Lob
    @Column(name = "products")
    private String products;
    @Lob
    @Column(name = "manufacturers")
    private String manufacturers;
    @Column(name = "drop_bgimage")
    private String dropBgimage;

    public PsAndropdown() {
    }

    public PsAndropdown(Integer idAndropdown) {
        this.idAndropdown = idAndropdown;
    }

    public PsAndropdown(Integer idAndropdown, int idAnmenu, short active, int position, String contentType, String title) {
        this.idAndropdown = idAndropdown;
        this.idAnmenu = idAnmenu;
        this.active = active;
        this.position = position;
        this.contentType = contentType;
        this.title = title;
    }

    public Integer getIdAndropdown() {
        return idAndropdown;
    }

    public void setIdAndropdown(Integer idAndropdown) {
        this.idAndropdown = idAndropdown;
    }

    public int getIdAnmenu() {
        return idAnmenu;
    }

    public void setIdAnmenu(int idAnmenu) {
        this.idAnmenu = idAnmenu;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getDropBgimage() {
        return dropBgimage;
    }

    public void setDropBgimage(String dropBgimage) {
        this.dropBgimage = dropBgimage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAndropdown != null ? idAndropdown.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAndropdown)) {
            return false;
        }
        PsAndropdown other = (PsAndropdown) object;
        if ((this.idAndropdown == null && other.idAndropdown != null) || (this.idAndropdown != null && !this.idAndropdown.equals(other.idAndropdown))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAndropdown[ idAndropdown=" + idAndropdown + " ]";
    }
    
}
