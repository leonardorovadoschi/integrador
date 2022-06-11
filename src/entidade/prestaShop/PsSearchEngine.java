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
@Table(name = "ps_search_engine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSearchEngine.findAll", query = "SELECT p FROM PsSearchEngine p")
    , @NamedQuery(name = "PsSearchEngine.findByIdSearchEngine", query = "SELECT p FROM PsSearchEngine p WHERE p.idSearchEngine = :idSearchEngine")
    , @NamedQuery(name = "PsSearchEngine.findByServer", query = "SELECT p FROM PsSearchEngine p WHERE p.server = :server")
    , @NamedQuery(name = "PsSearchEngine.findByGetvar", query = "SELECT p FROM PsSearchEngine p WHERE p.getvar = :getvar")})
public class PsSearchEngine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_search_engine")
    private Integer idSearchEngine;
    @Basic(optional = false)
    @Column(name = "server")
    private String server;
    @Basic(optional = false)
    @Column(name = "getvar")
    private String getvar;

    public PsSearchEngine() {
    }

    public PsSearchEngine(Integer idSearchEngine) {
        this.idSearchEngine = idSearchEngine;
    }

    public PsSearchEngine(Integer idSearchEngine, String server, String getvar) {
        this.idSearchEngine = idSearchEngine;
        this.server = server;
        this.getvar = getvar;
    }

    public Integer getIdSearchEngine() {
        return idSearchEngine;
    }

    public void setIdSearchEngine(Integer idSearchEngine) {
        this.idSearchEngine = idSearchEngine;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getGetvar() {
        return getvar;
    }

    public void setGetvar(String getvar) {
        this.getvar = getvar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSearchEngine != null ? idSearchEngine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSearchEngine)) {
            return false;
        }
        PsSearchEngine other = (PsSearchEngine) object;
        if ((this.idSearchEngine == null && other.idSearchEngine != null) || (this.idSearchEngine != null && !this.idSearchEngine.equals(other.idSearchEngine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSearchEngine[ idSearchEngine=" + idSearchEngine + " ]";
    }
    
}
