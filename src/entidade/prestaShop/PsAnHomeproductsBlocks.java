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
@Table(name = "ps_an_homeproducts_blocks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomeproductsBlocks.findAll", query = "SELECT p FROM PsAnHomeproductsBlocks p")})
public class PsAnHomeproductsBlocks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_block")
    private Integer idBlock;
    @Basic(optional = false)
    @Column(name = "special_id_block")
    private String specialIdBlock;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "show_sort")
    private short showSort;
    @Basic(optional = false)
    @Column(name = "products_display")
    private int productsDisplay;
    @Basic(optional = false)
    @Column(name = "id_category")
    private int idCategory;
    @Basic(optional = false)
    @Column(name = "show_sub_cat")
    private short showSubCat;
    @Basic(optional = false)
    @Column(name = "randomize")
    private short randomize;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnHomeproductsBlocks() {
    }

    public PsAnHomeproductsBlocks(Integer idBlock) {
        this.idBlock = idBlock;
    }

    public PsAnHomeproductsBlocks(Integer idBlock, String specialIdBlock, String type, short active, short showSort, int productsDisplay, int idCategory, short showSubCat, short randomize, int position) {
        this.idBlock = idBlock;
        this.specialIdBlock = specialIdBlock;
        this.type = type;
        this.active = active;
        this.showSort = showSort;
        this.productsDisplay = productsDisplay;
        this.idCategory = idCategory;
        this.showSubCat = showSubCat;
        this.randomize = randomize;
        this.position = position;
    }

    public Integer getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(Integer idBlock) {
        this.idBlock = idBlock;
    }

    public String getSpecialIdBlock() {
        return specialIdBlock;
    }

    public void setSpecialIdBlock(String specialIdBlock) {
        this.specialIdBlock = specialIdBlock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getShowSort() {
        return showSort;
    }

    public void setShowSort(short showSort) {
        this.showSort = showSort;
    }

    public int getProductsDisplay() {
        return productsDisplay;
    }

    public void setProductsDisplay(int productsDisplay) {
        this.productsDisplay = productsDisplay;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public short getShowSubCat() {
        return showSubCat;
    }

    public void setShowSubCat(short showSubCat) {
        this.showSubCat = showSubCat;
    }

    public short getRandomize() {
        return randomize;
    }

    public void setRandomize(short randomize) {
        this.randomize = randomize;
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
        hash += (idBlock != null ? idBlock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomeproductsBlocks)) {
            return false;
        }
        PsAnHomeproductsBlocks other = (PsAnHomeproductsBlocks) object;
        if ((this.idBlock == null && other.idBlock != null) || (this.idBlock != null && !this.idBlock.equals(other.idBlock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomeproductsBlocks[ idBlock=" + idBlock + " ]";
    }
    
}
