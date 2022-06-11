/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ECFCODIGOID", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecfcodigoid.findAll", query = "SELECT e FROM Ecfcodigoid e")
    , @NamedQuery(name = "Ecfcodigoid.findByCodecfcodigoid", query = "SELECT e FROM Ecfcodigoid e WHERE e.codecfcodigoid = :codecfcodigoid")
    , @NamedQuery(name = "Ecfcodigoid.findByCodigonacional", query = "SELECT e FROM Ecfcodigoid e WHERE e.codigonacional = :codigonacional")
    , @NamedQuery(name = "Ecfcodigoid.findByVersaosb", query = "SELECT e FROM Ecfcodigoid e WHERE e.versaosb = :versaosb")
    , @NamedQuery(name = "Ecfcodigoid.findByAtocotepe", query = "SELECT e FROM Ecfcodigoid e WHERE e.atocotepe = :atocotepe")
    , @NamedQuery(name = "Ecfcodigoid.findByGuid", query = "SELECT e FROM Ecfcodigoid e WHERE e.guid = :guid")})
public class Ecfcodigoid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODECFCODIGOID")
    private String codecfcodigoid;
    @Column(name = "CODIGONACIONAL")
    private String codigonacional;
    @Column(name = "VERSAOSB")
    private String versaosb;
    @Column(name = "ATOCOTEPE")
    private String atocotepe;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODECFMARCA", referencedColumnName = "CODECFMARCA")
    @ManyToOne
    private Ecfmarca codecfmarca;
    @JoinColumn(name = "CODECFMODELO", referencedColumnName = "CODECFMODELO")
    @ManyToOne
    private Ecfmodelo codecfmodelo;

    public Ecfcodigoid() {
    }

    public Ecfcodigoid(String codecfcodigoid) {
        this.codecfcodigoid = codecfcodigoid;
    }

    public String getCodecfcodigoid() {
        return codecfcodigoid;
    }

    public void setCodecfcodigoid(String codecfcodigoid) {
        this.codecfcodigoid = codecfcodigoid;
    }

    public String getCodigonacional() {
        return codigonacional;
    }

    public void setCodigonacional(String codigonacional) {
        this.codigonacional = codigonacional;
    }

    public String getVersaosb() {
        return versaosb;
    }

    public void setVersaosb(String versaosb) {
        this.versaosb = versaosb;
    }

    public String getAtocotepe() {
        return atocotepe;
    }

    public void setAtocotepe(String atocotepe) {
        this.atocotepe = atocotepe;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Ecfmarca getCodecfmarca() {
        return codecfmarca;
    }

    public void setCodecfmarca(Ecfmarca codecfmarca) {
        this.codecfmarca = codecfmarca;
    }

    public Ecfmodelo getCodecfmodelo() {
        return codecfmodelo;
    }

    public void setCodecfmodelo(Ecfmodelo codecfmodelo) {
        this.codecfmodelo = codecfmodelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codecfcodigoid != null ? codecfcodigoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecfcodigoid)) {
            return false;
        }
        Ecfcodigoid other = (Ecfcodigoid) object;
        if ((this.codecfcodigoid == null && other.codecfcodigoid != null) || (this.codecfcodigoid != null && !this.codecfcodigoid.equals(other.codecfcodigoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ecfcodigoid[ codecfcodigoid=" + codecfcodigoid + " ]";
    }
    
}
