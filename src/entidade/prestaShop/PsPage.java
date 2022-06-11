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
@Table(name = "ps_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsPage.findAll", query = "SELECT p FROM PsPage p")
    , @NamedQuery(name = "PsPage.findByIdPage", query = "SELECT p FROM PsPage p WHERE p.idPage = :idPage")
    , @NamedQuery(name = "PsPage.findByIdPageType", query = "SELECT p FROM PsPage p WHERE p.idPageType = :idPageType")
    , @NamedQuery(name = "PsPage.findByIdObject", query = "SELECT p FROM PsPage p WHERE p.idObject = :idObject")})
public class PsPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_page")
    private Integer idPage;
    @Basic(optional = false)
    @Column(name = "id_page_type")
    private int idPageType;
    @Column(name = "id_object")
    private Integer idObject;

    public PsPage() {
    }

    public PsPage(Integer idPage) {
        this.idPage = idPage;
    }

    public PsPage(Integer idPage, int idPageType) {
        this.idPage = idPage;
        this.idPageType = idPageType;
    }

    public Integer getIdPage() {
        return idPage;
    }

    public void setIdPage(Integer idPage) {
        this.idPage = idPage;
    }

    public int getIdPageType() {
        return idPageType;
    }

    public void setIdPageType(int idPageType) {
        this.idPageType = idPageType;
    }

    public Integer getIdObject() {
        return idObject;
    }

    public void setIdObject(Integer idObject) {
        this.idObject = idObject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPage != null ? idPage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsPage)) {
            return false;
        }
        PsPage other = (PsPage) object;
        if ((this.idPage == null && other.idPage != null) || (this.idPage != null && !this.idPage.equals(other.idPage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsPage[ idPage=" + idPage + " ]";
    }
    
}
