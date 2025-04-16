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
@Table(name = "ps_anblogcat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnblogcat.findAll", query = "SELECT p FROM PsAnblogcat p")})
public class PsAnblogcat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anblogcat")
    private Integer idAnblogcat;
    @Basic(optional = false)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Column(name = "item")
    private String item;
    @Basic(optional = false)
    @Column(name = "level_depth")
    private short levelDepth;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @Basic(optional = false)
    @Column(name = "show_title")
    private boolean showTitle;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Lob
    @Column(name = "submenu_content")
    private String submenuContent;
    @Column(name = "privacy")
    private Short privacy;
    @Column(name = "position_type")
    private String positionType;
    @Column(name = "menu_class")
    private String menuClass;
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "icon_class")
    private String iconClass;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @Basic(optional = false)
    @Column(name = "left")
    private int left;
    @Basic(optional = false)
    @Column(name = "right")
    private int right;
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @Basic(optional = false)
    @Column(name = "template")
    private String template;
    @Column(name = "randkey")
    private String randkey;
    @Lob
    @Column(name = "groups")
    private String groups;

    public PsAnblogcat() {
    }

    public PsAnblogcat(Integer idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
    }

    public PsAnblogcat(Integer idAnblogcat, String image, int idParent, short levelDepth, boolean active, boolean showTitle, int position, String submenuContent, int level, int left, int right, String template) {
        this.idAnblogcat = idAnblogcat;
        this.image = image;
        this.idParent = idParent;
        this.levelDepth = levelDepth;
        this.active = active;
        this.showTitle = showTitle;
        this.position = position;
        this.submenuContent = submenuContent;
        this.level = level;
        this.left = left;
        this.right = right;
        this.template = template;
    }

    public Integer getIdAnblogcat() {
        return idAnblogcat;
    }

    public void setIdAnblogcat(Integer idAnblogcat) {
        this.idAnblogcat = idAnblogcat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public short getLevelDepth() {
        return levelDepth;
    }

    public void setLevelDepth(short levelDepth) {
        this.levelDepth = levelDepth;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSubmenuContent() {
        return submenuContent;
    }

    public void setSubmenuContent(String submenuContent) {
        this.submenuContent = submenuContent;
    }

    public Short getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Short privacy) {
        this.privacy = privacy;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getRandkey() {
        return randkey;
    }

    public void setRandkey(String randkey) {
        this.randkey = randkey;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnblogcat != null ? idAnblogcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnblogcat)) {
            return false;
        }
        PsAnblogcat other = (PsAnblogcat) object;
        if ((this.idAnblogcat == null && other.idAnblogcat != null) || (this.idAnblogcat != null && !this.idAnblogcat.equals(other.idAnblogcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnblogcat[ idAnblogcat=" + idAnblogcat + " ]";
    }
    
}
