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
@Table(name = "ps_anmenu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnmenu.findAll", query = "SELECT p FROM PsAnmenu p")})
public class PsAnmenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anmenu")
    private Integer idAnmenu;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Column(name = "label_color")
    private String labelColor;
    @Column(name = "drop_column")
    private Integer dropColumn;
    @Column(name = "drop_bgcolor")
    private String dropBgcolor;
    @Column(name = "drop_bgimage")
    private String dropBgimage;
    @Column(name = "bgimage_position")
    private String bgimagePosition;
    @Column(name = "position_x")
    private Integer positionX;
    @Column(name = "position_y")
    private Integer positionY;

    public PsAnmenu() {
    }

    public PsAnmenu(Integer idAnmenu) {
        this.idAnmenu = idAnmenu;
    }

    public PsAnmenu(Integer idAnmenu, int idShop, short active, int position) {
        this.idAnmenu = idAnmenu;
        this.idShop = idShop;
        this.active = active;
        this.position = position;
    }

    public Integer getIdAnmenu() {
        return idAnmenu;
    }

    public void setIdAnmenu(Integer idAnmenu) {
        this.idAnmenu = idAnmenu;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

    public Integer getDropColumn() {
        return dropColumn;
    }

    public void setDropColumn(Integer dropColumn) {
        this.dropColumn = dropColumn;
    }

    public String getDropBgcolor() {
        return dropBgcolor;
    }

    public void setDropBgcolor(String dropBgcolor) {
        this.dropBgcolor = dropBgcolor;
    }

    public String getDropBgimage() {
        return dropBgimage;
    }

    public void setDropBgimage(String dropBgimage) {
        this.dropBgimage = dropBgimage;
    }

    public String getBgimagePosition() {
        return bgimagePosition;
    }

    public void setBgimagePosition(String bgimagePosition) {
        this.bgimagePosition = bgimagePosition;
    }

    public Integer getPositionX() {
        return positionX;
    }

    public void setPositionX(Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public void setPositionY(Integer positionY) {
        this.positionY = positionY;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnmenu != null ? idAnmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnmenu)) {
            return false;
        }
        PsAnmenu other = (PsAnmenu) object;
        if ((this.idAnmenu == null && other.idAnmenu != null) || (this.idAnmenu != null && !this.idAnmenu.equals(other.idAnmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnmenu[ idAnmenu=" + idAnmenu + " ]";
    }
    
}
