/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsConfiguration.findAll", query = "SELECT p FROM PsConfiguration p")
    , @NamedQuery(name = "PsConfiguration.findByIdConfiguration", query = "SELECT p FROM PsConfiguration p WHERE p.idConfiguration = :idConfiguration")
    , @NamedQuery(name = "PsConfiguration.findByIdShopGroup", query = "SELECT p FROM PsConfiguration p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsConfiguration.findByIdShop", query = "SELECT p FROM PsConfiguration p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsConfiguration.findByName", query = "SELECT p FROM PsConfiguration p WHERE p.name = :name")
    , @NamedQuery(name = "PsConfiguration.findByDateAdd", query = "SELECT p FROM PsConfiguration p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsConfiguration.findByDateUpd", query = "SELECT p FROM PsConfiguration p WHERE p.dateUpd = :dateUpd")})
public class PsConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_configuration")
    private Integer idConfiguration;
    @Column(name = "id_shop_group")
    private Integer idShopGroup;
    @Column(name = "id_shop")
    private Integer idShop;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;

    public PsConfiguration() {
    }

    public PsConfiguration(Integer idConfiguration) {
        this.idConfiguration = idConfiguration;
    }

    public PsConfiguration(Integer idConfiguration, String name, Date dateAdd, Date dateUpd) {
        this.idConfiguration = idConfiguration;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getIdConfiguration() {
        return idConfiguration;
    }

    public void setIdConfiguration(Integer idConfiguration) {
        this.idConfiguration = idConfiguration;
    }

    public Integer getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(Integer idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguration != null ? idConfiguration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsConfiguration)) {
            return false;
        }
        PsConfiguration other = (PsConfiguration) object;
        if ((this.idConfiguration == null && other.idConfiguration != null) || (this.idConfiguration != null && !this.idConfiguration.equals(other.idConfiguration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsConfiguration[ idConfiguration=" + idConfiguration + " ]";
    }
    
}
