/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_customized_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsCustomizedData.findAll", query = "SELECT p FROM PsCustomizedData p")
    , @NamedQuery(name = "PsCustomizedData.findByIdCustomization", query = "SELECT p FROM PsCustomizedData p WHERE p.psCustomizedDataPK.idCustomization = :idCustomization")
    , @NamedQuery(name = "PsCustomizedData.findByType", query = "SELECT p FROM PsCustomizedData p WHERE p.psCustomizedDataPK.type = :type")
    , @NamedQuery(name = "PsCustomizedData.findByIndex", query = "SELECT p FROM PsCustomizedData p WHERE p.psCustomizedDataPK.index = :index")
    , @NamedQuery(name = "PsCustomizedData.findByValue", query = "SELECT p FROM PsCustomizedData p WHERE p.value = :value")
    , @NamedQuery(name = "PsCustomizedData.findByIdModule", query = "SELECT p FROM PsCustomizedData p WHERE p.idModule = :idModule")
    , @NamedQuery(name = "PsCustomizedData.findByPrice", query = "SELECT p FROM PsCustomizedData p WHERE p.price = :price")
    , @NamedQuery(name = "PsCustomizedData.findByWeight", query = "SELECT p FROM PsCustomizedData p WHERE p.weight = :weight")})
public class PsCustomizedData implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsCustomizedDataPK psCustomizedDataPK;
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;

    public PsCustomizedData() {
    }

    public PsCustomizedData(PsCustomizedDataPK psCustomizedDataPK) {
        this.psCustomizedDataPK = psCustomizedDataPK;
    }

    public PsCustomizedData(PsCustomizedDataPK psCustomizedDataPK, String value, int idModule, BigDecimal price, BigDecimal weight) {
        this.psCustomizedDataPK = psCustomizedDataPK;
        this.value = value;
        this.idModule = idModule;
        this.price = price;
        this.weight = weight;
    }

    public PsCustomizedData(int idCustomization, boolean type, int index) {
        this.psCustomizedDataPK = new PsCustomizedDataPK(idCustomization, type, index);
    }

    public PsCustomizedDataPK getPsCustomizedDataPK() {
        return psCustomizedDataPK;
    }

    public void setPsCustomizedDataPK(PsCustomizedDataPK psCustomizedDataPK) {
        this.psCustomizedDataPK = psCustomizedDataPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psCustomizedDataPK != null ? psCustomizedDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsCustomizedData)) {
            return false;
        }
        PsCustomizedData other = (PsCustomizedData) object;
        if ((this.psCustomizedDataPK == null && other.psCustomizedDataPK != null) || (this.psCustomizedDataPK != null && !this.psCustomizedDataPK.equals(other.psCustomizedDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsCustomizedData[ psCustomizedDataPK=" + psCustomizedDataPK + " ]";
    }
    
}
