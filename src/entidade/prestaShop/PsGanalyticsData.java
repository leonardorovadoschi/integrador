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
@Table(name = "ps_ganalytics_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGanalyticsData.findAll", query = "SELECT p FROM PsGanalyticsData p")})
public class PsGanalyticsData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cart")
    private Integer idCart;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Lob
    @Column(name = "data")
    private String data;

    public PsGanalyticsData() {
    }

    public PsGanalyticsData(Integer idCart) {
        this.idCart = idCart;
    }

    public PsGanalyticsData(Integer idCart, int idShop) {
        this.idCart = idCart;
        this.idShop = idShop;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCart != null ? idCart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGanalyticsData)) {
            return false;
        }
        PsGanalyticsData other = (PsGanalyticsData) object;
        if ((this.idCart == null && other.idCart != null) || (this.idCart != null && !this.idCart.equals(other.idCart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGanalyticsData[ idCart=" + idCart + " ]";
    }
    
}
