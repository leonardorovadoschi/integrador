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
@Table(name = "ps_memcached_servers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsMemcachedServers.findAll", query = "SELECT p FROM PsMemcachedServers p")
    , @NamedQuery(name = "PsMemcachedServers.findByIdMemcachedServer", query = "SELECT p FROM PsMemcachedServers p WHERE p.idMemcachedServer = :idMemcachedServer")
    , @NamedQuery(name = "PsMemcachedServers.findByIp", query = "SELECT p FROM PsMemcachedServers p WHERE p.ip = :ip")
    , @NamedQuery(name = "PsMemcachedServers.findByPort", query = "SELECT p FROM PsMemcachedServers p WHERE p.port = :port")
    , @NamedQuery(name = "PsMemcachedServers.findByWeight", query = "SELECT p FROM PsMemcachedServers p WHERE p.weight = :weight")})
public class PsMemcachedServers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_memcached_server")
    private Integer idMemcachedServer;
    @Basic(optional = false)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @Column(name = "port")
    private int port;
    @Basic(optional = false)
    @Column(name = "weight")
    private int weight;

    public PsMemcachedServers() {
    }

    public PsMemcachedServers(Integer idMemcachedServer) {
        this.idMemcachedServer = idMemcachedServer;
    }

    public PsMemcachedServers(Integer idMemcachedServer, String ip, int port, int weight) {
        this.idMemcachedServer = idMemcachedServer;
        this.ip = ip;
        this.port = port;
        this.weight = weight;
    }

    public Integer getIdMemcachedServer() {
        return idMemcachedServer;
    }

    public void setIdMemcachedServer(Integer idMemcachedServer) {
        this.idMemcachedServer = idMemcachedServer;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMemcachedServer != null ? idMemcachedServer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsMemcachedServers)) {
            return false;
        }
        PsMemcachedServers other = (PsMemcachedServers) object;
        if ((this.idMemcachedServer == null && other.idMemcachedServer != null) || (this.idMemcachedServer != null && !this.idMemcachedServer.equals(other.idMemcachedServer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsMemcachedServers[ idMemcachedServer=" + idMemcachedServer + " ]";
    }
    
}
