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
@Table(name = "ps_order_return_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsOrderReturnState.findAll", query = "SELECT p FROM PsOrderReturnState p")
    , @NamedQuery(name = "PsOrderReturnState.findByIdOrderReturnState", query = "SELECT p FROM PsOrderReturnState p WHERE p.idOrderReturnState = :idOrderReturnState")
    , @NamedQuery(name = "PsOrderReturnState.findByColor", query = "SELECT p FROM PsOrderReturnState p WHERE p.color = :color")})
public class PsOrderReturnState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order_return_state")
    private Integer idOrderReturnState;
    @Column(name = "color")
    private String color;

    public PsOrderReturnState() {
    }

    public PsOrderReturnState(Integer idOrderReturnState) {
        this.idOrderReturnState = idOrderReturnState;
    }

    public Integer getIdOrderReturnState() {
        return idOrderReturnState;
    }

    public void setIdOrderReturnState(Integer idOrderReturnState) {
        this.idOrderReturnState = idOrderReturnState;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderReturnState != null ? idOrderReturnState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsOrderReturnState)) {
            return false;
        }
        PsOrderReturnState other = (PsOrderReturnState) object;
        if ((this.idOrderReturnState == null && other.idOrderReturnState != null) || (this.idOrderReturnState != null && !this.idOrderReturnState.equals(other.idOrderReturnState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsOrderReturnState[ idOrderReturnState=" + idOrderReturnState + " ]";
    }
    
}
