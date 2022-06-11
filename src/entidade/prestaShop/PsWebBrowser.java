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
@Table(name = "ps_web_browser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsWebBrowser.findAll", query = "SELECT p FROM PsWebBrowser p")
    , @NamedQuery(name = "PsWebBrowser.findByIdWebBrowser", query = "SELECT p FROM PsWebBrowser p WHERE p.idWebBrowser = :idWebBrowser")
    , @NamedQuery(name = "PsWebBrowser.findByName", query = "SELECT p FROM PsWebBrowser p WHERE p.name = :name")})
public class PsWebBrowser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_web_browser")
    private Integer idWebBrowser;
    @Column(name = "name")
    private String name;

    public PsWebBrowser() {
    }

    public PsWebBrowser(Integer idWebBrowser) {
        this.idWebBrowser = idWebBrowser;
    }

    public Integer getIdWebBrowser() {
        return idWebBrowser;
    }

    public void setIdWebBrowser(Integer idWebBrowser) {
        this.idWebBrowser = idWebBrowser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWebBrowser != null ? idWebBrowser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsWebBrowser)) {
            return false;
        }
        PsWebBrowser other = (PsWebBrowser) object;
        if ((this.idWebBrowser == null && other.idWebBrowser != null) || (this.idWebBrowser != null && !this.idWebBrowser.equals(other.idWebBrowser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsWebBrowser[ idWebBrowser=" + idWebBrowser + " ]";
    }
    
}
