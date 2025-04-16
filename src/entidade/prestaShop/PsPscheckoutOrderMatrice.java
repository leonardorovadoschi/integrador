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
@Table(name = "ps_pscheckout_order_matrice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPscheckoutOrderMatrice.findAll", query = "SELECT p FROM PsPscheckoutOrderMatrice p")})
public class PsPscheckoutOrderMatrice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_matrice")
    private Integer idOrderMatrice;
    @Basic(optional = false)
    @Column(name = "id_order_prestashop")
    private int idOrderPrestashop;
    @Basic(optional = false)
    @Column(name = "id_order_paypal")
    private String idOrderPaypal;

    public PsPscheckoutOrderMatrice() {
    }

    public PsPscheckoutOrderMatrice(Integer idOrderMatrice) {
        this.idOrderMatrice = idOrderMatrice;
    }

    public PsPscheckoutOrderMatrice(Integer idOrderMatrice, int idOrderPrestashop, String idOrderPaypal) {
        this.idOrderMatrice = idOrderMatrice;
        this.idOrderPrestashop = idOrderPrestashop;
        this.idOrderPaypal = idOrderPaypal;
    }

    public Integer getIdOrderMatrice() {
        return idOrderMatrice;
    }

    public void setIdOrderMatrice(Integer idOrderMatrice) {
        this.idOrderMatrice = idOrderMatrice;
    }

    public int getIdOrderPrestashop() {
        return idOrderPrestashop;
    }

    public void setIdOrderPrestashop(int idOrderPrestashop) {
        this.idOrderPrestashop = idOrderPrestashop;
    }

    public String getIdOrderPaypal() {
        return idOrderPaypal;
    }

    public void setIdOrderPaypal(String idOrderPaypal) {
        this.idOrderPaypal = idOrderPaypal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderMatrice != null ? idOrderMatrice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPscheckoutOrderMatrice)) {
            return false;
        }
        PsPscheckoutOrderMatrice other = (PsPscheckoutOrderMatrice) object;
        if ((this.idOrderMatrice == null && other.idOrderMatrice != null) || (this.idOrderMatrice != null && !this.idOrderMatrice.equals(other.idOrderMatrice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPscheckoutOrderMatrice[ idOrderMatrice=" + idOrderMatrice + " ]";
    }
    
}
