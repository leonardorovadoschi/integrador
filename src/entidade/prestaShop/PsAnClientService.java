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
@Table(name = "ps_an_client_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnClientService.findAll", query = "SELECT p FROM PsAnClientService p")})
public class PsAnClientService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client_service")
    private Integer idClientService;
    @Basic(optional = false)
    @Column(name = "file_name")
    private String fileName;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;

    public PsAnClientService() {
    }

    public PsAnClientService(Integer idClientService) {
        this.idClientService = idClientService;
    }

    public PsAnClientService(Integer idClientService, String fileName, short active, int position) {
        this.idClientService = idClientService;
        this.fileName = fileName;
        this.active = active;
        this.position = position;
    }

    public Integer getIdClientService() {
        return idClientService;
    }

    public void setIdClientService(Integer idClientService) {
        this.idClientService = idClientService;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
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
        hash += (idClientService != null ? idClientService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnClientService)) {
            return false;
        }
        PsAnClientService other = (PsAnClientService) object;
        if ((this.idClientService == null && other.idClientService != null) || (this.idClientService != null && !this.idClientService.equals(other.idClientService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnClientService[ idClientService=" + idClientService + " ]";
    }
    
}
