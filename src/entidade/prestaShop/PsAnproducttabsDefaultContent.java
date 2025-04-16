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
@Table(name = "ps_anproducttabs_default_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnproducttabsDefaultContent.findAll", query = "SELECT p FROM PsAnproducttabsDefaultContent p")})
public class PsAnproducttabsDefaultContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anproducttabs_default_content")
    private Integer idAnproducttabsDefaultContent;
    @Basic(optional = false)
    @Column(name = "id_anproducttabs")
    private int idAnproducttabs;

    public PsAnproducttabsDefaultContent() {
    }

    public PsAnproducttabsDefaultContent(Integer idAnproducttabsDefaultContent) {
        this.idAnproducttabsDefaultContent = idAnproducttabsDefaultContent;
    }

    public PsAnproducttabsDefaultContent(Integer idAnproducttabsDefaultContent, int idAnproducttabs) {
        this.idAnproducttabsDefaultContent = idAnproducttabsDefaultContent;
        this.idAnproducttabs = idAnproducttabs;
    }

    public Integer getIdAnproducttabsDefaultContent() {
        return idAnproducttabsDefaultContent;
    }

    public void setIdAnproducttabsDefaultContent(Integer idAnproducttabsDefaultContent) {
        this.idAnproducttabsDefaultContent = idAnproducttabsDefaultContent;
    }

    public int getIdAnproducttabs() {
        return idAnproducttabs;
    }

    public void setIdAnproducttabs(int idAnproducttabs) {
        this.idAnproducttabs = idAnproducttabs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnproducttabsDefaultContent != null ? idAnproducttabsDefaultContent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnproducttabsDefaultContent)) {
            return false;
        }
        PsAnproducttabsDefaultContent other = (PsAnproducttabsDefaultContent) object;
        if ((this.idAnproducttabsDefaultContent == null && other.idAnproducttabsDefaultContent != null) || (this.idAnproducttabsDefaultContent != null && !this.idAnproducttabsDefaultContent.equals(other.idAnproducttabsDefaultContent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnproducttabsDefaultContent[ idAnproducttabsDefaultContent=" + idAnproducttabsDefaultContent + " ]";
    }
    
}
