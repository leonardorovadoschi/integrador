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
@Table(name = "ps_reassurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsReassurance.findAll", query = "SELECT p FROM PsReassurance p")
    , @NamedQuery(name = "PsReassurance.findByIdReassurance", query = "SELECT p FROM PsReassurance p WHERE p.idReassurance = :idReassurance")
    , @NamedQuery(name = "PsReassurance.findByIdShop", query = "SELECT p FROM PsReassurance p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsReassurance.findByFileName", query = "SELECT p FROM PsReassurance p WHERE p.fileName = :fileName")})
public class PsReassurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reassurance")
    private Integer idReassurance;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;

    public PsReassurance() {
    }

    public PsReassurance(Integer idReassurance) {
        this.idReassurance = idReassurance;
    }

    public PsReassurance(Integer idReassurance, int idShop, String fileName) {
        this.idReassurance = idReassurance;
        this.idShop = idShop;
        this.fileName = fileName;
    }

    public Integer getIdReassurance() {
        return idReassurance;
    }

    public void setIdReassurance(Integer idReassurance) {
        this.idReassurance = idReassurance;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReassurance != null ? idReassurance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsReassurance)) {
            return false;
        }
        PsReassurance other = (PsReassurance) object;
        if ((this.idReassurance == null && other.idReassurance != null) || (this.idReassurance != null && !this.idReassurance.equals(other.idReassurance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsReassurance[ idReassurance=" + idReassurance + " ]";
    }
    
}
