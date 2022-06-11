/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ECFMODELO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecfmodelo.findAll", query = "SELECT e FROM Ecfmodelo e")
    , @NamedQuery(name = "Ecfmodelo.findByCodecfmodelo", query = "SELECT e FROM Ecfmodelo e WHERE e.codecfmodelo = :codecfmodelo")
    , @NamedQuery(name = "Ecfmodelo.findByModelo", query = "SELECT e FROM Ecfmodelo e WHERE e.modelo = :modelo")
    , @NamedQuery(name = "Ecfmodelo.findByFlagaltpaf", query = "SELECT e FROM Ecfmodelo e WHERE e.flagaltpaf = :flagaltpaf")
    , @NamedQuery(name = "Ecfmodelo.findByGuid", query = "SELECT e FROM Ecfmodelo e WHERE e.guid = :guid")
    , @NamedQuery(name = "Ecfmodelo.findByConvenio0909", query = "SELECT e FROM Ecfmodelo e WHERE e.convenio0909 = :convenio0909")})
public class Ecfmodelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODECFMODELO")
    private String codecfmodelo;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Column(name = "GUID")
    private String guid;
    @Column(name = "CONVENIO0909")
    private Character convenio0909;
    @OneToMany(mappedBy = "codecfmodelo")
    private Collection<Ecfcodigoid> ecfcodigoidCollection;
    @JoinColumn(name = "CODECFMARCA", referencedColumnName = "CODECFMARCA")
    @ManyToOne(optional = false)
    private Ecfmarca codecfmarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codecfmodelo")
    private Collection<Ecf> ecfCollection;

    public Ecfmodelo() {
    }

    public Ecfmodelo(String codecfmodelo) {
        this.codecfmodelo = codecfmodelo;
    }

    public String getCodecfmodelo() {
        return codecfmodelo;
    }

    public void setCodecfmodelo(String codecfmodelo) {
        this.codecfmodelo = codecfmodelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Character getConvenio0909() {
        return convenio0909;
    }

    public void setConvenio0909(Character convenio0909) {
        this.convenio0909 = convenio0909;
    }

    @XmlTransient
    public Collection<Ecfcodigoid> getEcfcodigoidCollection() {
        return ecfcodigoidCollection;
    }

    public void setEcfcodigoidCollection(Collection<Ecfcodigoid> ecfcodigoidCollection) {
        this.ecfcodigoidCollection = ecfcodigoidCollection;
    }

    public Ecfmarca getCodecfmarca() {
        return codecfmarca;
    }

    public void setCodecfmarca(Ecfmarca codecfmarca) {
        this.codecfmarca = codecfmarca;
    }

    @XmlTransient
    public Collection<Ecf> getEcfCollection() {
        return ecfCollection;
    }

    public void setEcfCollection(Collection<Ecf> ecfCollection) {
        this.ecfCollection = ecfCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codecfmodelo != null ? codecfmodelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecfmodelo)) {
            return false;
        }
        Ecfmodelo other = (Ecfmodelo) object;
        if ((this.codecfmodelo == null && other.codecfmodelo != null) || (this.codecfmodelo != null && !this.codecfmodelo.equals(other.codecfmodelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Ecfmodelo[ codecfmodelo=" + codecfmodelo + " ]";
    }
    
}
