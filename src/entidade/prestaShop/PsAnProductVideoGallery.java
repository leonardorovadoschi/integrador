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
@Table(name = "ps_an_product_video_gallery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductVideoGallery.findAll", query = "SELECT p FROM PsAnProductVideoGallery p")})
public class PsAnProductVideoGallery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_video")
    private Integer idVideo;
    @Basic(optional = false)
    @Column(name = "preview")
    private String preview;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "type_video")
    private short typeVideo;
    @Basic(optional = false)
    @Column(name = "relation")
    private int relation;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnProductVideoGallery() {
    }

    public PsAnProductVideoGallery(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public PsAnProductVideoGallery(Integer idVideo, String preview, short active, short typeVideo, int relation, int position) {
        this.idVideo = idVideo;
        this.preview = preview;
        this.active = active;
        this.typeVideo = typeVideo;
        this.relation = relation;
        this.position = position;
    }

    public Integer getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(Integer idVideo) {
        this.idVideo = idVideo;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short getTypeVideo() {
        return typeVideo;
    }

    public void setTypeVideo(short typeVideo) {
        this.typeVideo = typeVideo;
    }

    public int getRelation() {
        return relation;
    }

    public void setRelation(int relation) {
        this.relation = relation;
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
        hash += (idVideo != null ? idVideo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductVideoGallery)) {
            return false;
        }
        PsAnProductVideoGallery other = (PsAnProductVideoGallery) object;
        if ((this.idVideo == null && other.idVideo != null) || (this.idVideo != null && !this.idVideo.equals(other.idVideo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductVideoGallery[ idVideo=" + idVideo + " ]";
    }
    
}
