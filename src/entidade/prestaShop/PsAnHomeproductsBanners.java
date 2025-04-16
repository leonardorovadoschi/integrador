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
@Table(name = "ps_an_homeproducts_banners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBanners.findAll", query = "SELECT p FROM PsAnHomeproductsBanners p")})
public class PsAnHomeproductsBanners implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_banner")
    private Integer idBanner;
    @Basic(optional = false)
    @Column(name = "special_id_banner")
    private String specialIdBanner;
    @Basic(optional = false)
    @Column(name = "block")
    private String block;
    @Basic(optional = false)
    @Column(name = "block_position")
    private int blockPosition;
    @Basic(optional = false)
    @Column(name = "col")
    private int col;
    @Basic(optional = false)
    @Column(name = "color_title")
    private String colorTitle;
    @Basic(optional = false)
    @Column(name = "color_text")
    private String colorText;
    @Basic(optional = false)
    @Column(name = "template")
    private String template;
    @Basic(optional = false)
    @Column(name = "show_on")
    private int showOn;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnHomeproductsBanners() {
    }

    public PsAnHomeproductsBanners(Integer idBanner) {
        this.idBanner = idBanner;
    }

    public PsAnHomeproductsBanners(Integer idBanner, String specialIdBanner, String block, int blockPosition, int col, String colorTitle, String colorText, String template, int showOn, short active, int position) {
        this.idBanner = idBanner;
        this.specialIdBanner = specialIdBanner;
        this.block = block;
        this.blockPosition = blockPosition;
        this.col = col;
        this.colorTitle = colorTitle;
        this.colorText = colorText;
        this.template = template;
        this.showOn = showOn;
        this.active = active;
        this.position = position;
    }

    public Integer getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(Integer idBanner) {
        this.idBanner = idBanner;
    }

    public String getSpecialIdBanner() {
        return specialIdBanner;
    }

    public void setSpecialIdBanner(String specialIdBanner) {
        this.specialIdBanner = specialIdBanner;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getBlockPosition() {
        return blockPosition;
    }

    public void setBlockPosition(int blockPosition) {
        this.blockPosition = blockPosition;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getColorTitle() {
        return colorTitle;
    }

    public void setColorTitle(String colorTitle) {
        this.colorTitle = colorTitle;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getShowOn() {
        return showOn;
    }

    public void setShowOn(int showOn) {
        this.showOn = showOn;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanner != null ? idBanner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBanners)) {
            return false;
        }
        PsAnHomeproductsBanners other = (PsAnHomeproductsBanners) object;
        if ((this.idBanner == null && other.idBanner != null) || (this.idBanner != null && !this.idBanner.equals(other.idBanner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBanners[ idBanner=" + idBanner + " ]";
    }
    
}
