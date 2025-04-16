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
@Table(name = "ps_an_trust_badges_icons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnTrustBadgesIcons.findAll", query = "SELECT p FROM PsAnTrustBadgesIcons p")})
public class PsAnTrustBadgesIcons implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "icon_id")
    private Integer iconId;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "icon_title")
    private String iconTitle;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @Lob
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "type_icon")
    private int typeIcon;

    public PsAnTrustBadgesIcons() {
    }

    public PsAnTrustBadgesIcons(Integer iconId) {
        this.iconId = iconId;
    }

    public PsAnTrustBadgesIcons(Integer iconId, short active, int position, String iconTitle, String fileName, String code, int typeIcon) {
        this.iconId = iconId;
        this.active = active;
        this.position = position;
        this.iconTitle = iconTitle;
        this.fileName = fileName;
        this.code = code;
        this.typeIcon = typeIcon;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
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

    public String getIconTitle() {
        return iconTitle;
    }

    public void setIconTitle(String iconTitle) {
        this.iconTitle = iconTitle;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTypeIcon() {
        return typeIcon;
    }

    public void setTypeIcon(int typeIcon) {
        this.typeIcon = typeIcon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iconId != null ? iconId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnTrustBadgesIcons)) {
            return false;
        }
        PsAnTrustBadgesIcons other = (PsAnTrustBadgesIcons) object;
        if ((this.iconId == null && other.iconId != null) || (this.iconId != null && !this.iconId.equals(other.iconId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnTrustBadgesIcons[ iconId=" + iconId + " ]";
    }
    
}
