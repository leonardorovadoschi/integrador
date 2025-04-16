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
@Table(name = "ps_anthemeblock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnthemeblock.findAll", query = "SELECT p FROM PsAnthemeblock p")})
public class PsAnthemeblock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anthemeblock")
    private Integer idAnthemeblock;
    @Basic(optional = false)
    @Column(name = "id_parent")
    private int idParent;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "block_identifier")
    private String blockIdentifier;
    @Lob
    @Column(name = "hook_ids")
    private String hookIds;
    @Basic(optional = false)
    @Column(name = "template")
    private String template;
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsAnthemeblock() {
    }

    public PsAnthemeblock(Integer idAnthemeblock) {
        this.idAnthemeblock = idAnthemeblock;
    }

    public PsAnthemeblock(Integer idAnthemeblock, int idParent, int status, String blockIdentifier, String template, int position, Date dateAdd, Date dateUpd) {
        this.idAnthemeblock = idAnthemeblock;
        this.idParent = idParent;
        this.status = status;
        this.blockIdentifier = blockIdentifier;
        this.template = template;
        this.position = position;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdAnthemeblock() {
        return idAnthemeblock;
    }

    public void setIdAnthemeblock(Integer idAnthemeblock) {
        this.idAnthemeblock = idAnthemeblock;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBlockIdentifier() {
        return blockIdentifier;
    }

    public void setBlockIdentifier(String blockIdentifier) {
        this.blockIdentifier = blockIdentifier;
    }

    public String getHookIds() {
        return hookIds;
    }

    public void setHookIds(String hookIds) {
        this.hookIds = hookIds;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnthemeblock != null ? idAnthemeblock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnthemeblock)) {
            return false;
        }
        PsAnthemeblock other = (PsAnthemeblock) object;
        if ((this.idAnthemeblock == null && other.idAnthemeblock != null) || (this.idAnthemeblock != null && !this.idAnthemeblock.equals(other.idAnthemeblock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnthemeblock[ idAnthemeblock=" + idAnthemeblock + " ]";
    }
    
}
