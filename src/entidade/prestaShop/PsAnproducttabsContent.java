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
@Table(name = "ps_anproducttabs_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabsContent.findAll", query = "SELECT p FROM PsAnproducttabsContent p")})
public class PsAnproducttabsContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anproducttabs_content")
    private Integer idAnproducttabsContent;
    @Basic(optional = false)
    @Column(name = "id_anproducttabs")
    private int idAnproducttabs;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;

    public PsAnproducttabsContent() {
    }

    public PsAnproducttabsContent(Integer idAnproducttabsContent) {
        this.idAnproducttabsContent = idAnproducttabsContent;
    }

    public PsAnproducttabsContent(Integer idAnproducttabsContent, int idAnproducttabs, int idProduct, boolean active) {
        this.idAnproducttabsContent = idAnproducttabsContent;
        this.idAnproducttabs = idAnproducttabs;
        this.idProduct = idProduct;
        this.active = active;
    }

    public Integer getIdAnproducttabsContent() {
        return idAnproducttabsContent;
    }

    public void setIdAnproducttabsContent(Integer idAnproducttabsContent) {
        this.idAnproducttabsContent = idAnproducttabsContent;
    }

    public int getIdAnproducttabs() {
        return idAnproducttabs;
    }

    public void setIdAnproducttabs(int idAnproducttabs) {
        this.idAnproducttabs = idAnproducttabs;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnproducttabsContent != null ? idAnproducttabsContent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsContent)) {
            return false;
        }
        PsAnproducttabsContent other = (PsAnproducttabsContent) object;
        if ((this.idAnproducttabsContent == null && other.idAnproducttabsContent != null) || (this.idAnproducttabsContent != null && !this.idAnproducttabsContent.equals(other.idAnproducttabsContent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsContent[ idAnproducttabsContent=" + idAnproducttabsContent + " ]";
    }
    
}
