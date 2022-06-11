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
 * @author leo
 */
@Entity
@Table(name = "ps_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsImage.findAll", query = "SELECT p FROM PsImage p")
    , @NamedQuery(name = "PsImage.findByIdImage", query = "SELECT p FROM PsImage p WHERE p.idImage = :idImage")
    , @NamedQuery(name = "PsImage.findByIdProduct", query = "SELECT p FROM PsImage p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "PsImage.findByPosition", query = "SELECT p FROM PsImage p WHERE p.position = :position")
    , @NamedQuery(name = "PsImage.findByCover", query = "SELECT p FROM PsImage p WHERE p.cover = :cover")})
public class PsImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_image")
    private Integer idImage;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "position")
    private short position;
    @Column(name = "cover")
    private Boolean cover;

    public PsImage() {
    }

    public PsImage(Integer idImage) {
        this.idImage = idImage;
    }

    public PsImage(Integer idImage, int idProduct, short position) {
        this.idImage = idImage;
        this.idProduct = idProduct;
        this.position = position;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    public Boolean getCover() {
        return cover;
    }

    public void setCover(Boolean cover) {
        this.cover = cover;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImage != null ? idImage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsImage)) {
            return false;
        }
        PsImage other = (PsImage) object;
        if ((this.idImage == null && other.idImage != null) || (this.idImage != null && !this.idImage.equals(other.idImage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsImage[ idImage=" + idImage + " ]";
    }
    
}
