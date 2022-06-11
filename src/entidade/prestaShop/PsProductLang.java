/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_product_lang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsProductLang.findAll", query = "SELECT p FROM PsProductLang p")
    , @NamedQuery(name = "PsProductLang.findByIdProduct", query = "SELECT p FROM PsProductLang p WHERE p.psProductLangPK.idProduct = :idProduct")
    , @NamedQuery(name = "PsProductLang.findByIdShop", query = "SELECT p FROM PsProductLang p WHERE p.psProductLangPK.idShop = :idShop")
    , @NamedQuery(name = "PsProductLang.findByIdLang", query = "SELECT p FROM PsProductLang p WHERE p.psProductLangPK.idLang = :idLang")
    , @NamedQuery(name = "PsProductLang.findByLinkRewrite", query = "SELECT p FROM PsProductLang p WHERE p.linkRewrite = :linkRewrite")
    , @NamedQuery(name = "PsProductLang.findByMetaDescription", query = "SELECT p FROM PsProductLang p WHERE p.metaDescription = :metaDescription")
    , @NamedQuery(name = "PsProductLang.findByMetaKeywords", query = "SELECT p FROM PsProductLang p WHERE p.metaKeywords = :metaKeywords")
    , @NamedQuery(name = "PsProductLang.findByMetaTitle", query = "SELECT p FROM PsProductLang p WHERE p.metaTitle = :metaTitle")
    , @NamedQuery(name = "PsProductLang.findByName", query = "SELECT p FROM PsProductLang p WHERE p.name = :name")
    , @NamedQuery(name = "PsProductLang.findByAvailableNow", query = "SELECT p FROM PsProductLang p WHERE p.availableNow = :availableNow")
    , @NamedQuery(name = "PsProductLang.findByAvailableLater", query = "SELECT p FROM PsProductLang p WHERE p.availableLater = :availableLater")
    , @NamedQuery(name = "PsProductLang.findByDeliveryInStock", query = "SELECT p FROM PsProductLang p WHERE p.deliveryInStock = :deliveryInStock")
    , @NamedQuery(name = "PsProductLang.findByDeliveryOutStock", query = "SELECT p FROM PsProductLang p WHERE p.deliveryOutStock = :deliveryOutStock")})
public class PsProductLang implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PsProductLangPK psProductLangPK;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "description_short")
    private String descriptionShort;
    @Basic(optional = false)
    @Column(name = "link_rewrite")
    private String linkRewrite;
    @Column(name = "meta_description")
    private String metaDescription;
    @Column(name = "meta_keywords")
    private String metaKeywords;
    @Column(name = "meta_title")
    private String metaTitle;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "available_now")
    private String availableNow;
    @Column(name = "available_later")
    private String availableLater;
    @Column(name = "delivery_in_stock")
    private String deliveryInStock;
    @Column(name = "delivery_out_stock")
    private String deliveryOutStock;

    public PsProductLang() {
    }

    public PsProductLang(PsProductLangPK psProductLangPK) {
        this.psProductLangPK = psProductLangPK;
    }

    public PsProductLang(PsProductLangPK psProductLangPK, String linkRewrite, String name) {
        this.psProductLangPK = psProductLangPK;
        this.linkRewrite = linkRewrite;
        this.name = name;
    }

    public PsProductLang(int idProduct, int idShop, int idLang) {
        this.psProductLangPK = new PsProductLangPK(idProduct, idShop, idLang);
    }

    public PsProductLangPK getPsProductLangPK() {
        return psProductLangPK;
    }

    public void setPsProductLangPK(PsProductLangPK psProductLangPK) {
        this.psProductLangPK = psProductLangPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(String availableNow) {
        this.availableNow = availableNow;
    }

    public String getAvailableLater() {
        return availableLater;
    }

    public void setAvailableLater(String availableLater) {
        this.availableLater = availableLater;
    }

    public String getDeliveryInStock() {
        return deliveryInStock;
    }

    public void setDeliveryInStock(String deliveryInStock) {
        this.deliveryInStock = deliveryInStock;
    }

    public String getDeliveryOutStock() {
        return deliveryOutStock;
    }

    public void setDeliveryOutStock(String deliveryOutStock) {
        this.deliveryOutStock = deliveryOutStock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (psProductLangPK != null ? psProductLangPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsProductLang)) {
            return false;
        }
        PsProductLang other = (PsProductLang) object;
        if ((this.psProductLangPK == null && other.psProductLangPK != null) || (this.psProductLangPK != null && !this.psProductLangPK.equals(other.psProductLangPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsProductLang[ psProductLangPK=" + psProductLangPK + " ]";
    }
    
}
