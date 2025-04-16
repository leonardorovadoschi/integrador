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
@Table(name = "ps_an_productextratabs_tpl_content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnProductextratabsTplContent.findAll", query = "SELECT p FROM PsAnProductextratabsTplContent p")})
public class PsAnProductextratabsTplContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_content")
    private Integer idContent;
    @Basic(optional = false)
    @Column(name = "content_active")
    private short contentActive;
    @Basic(optional = false)
    @Column(name = "content_combinations")
    private short contentCombinations;
    @Basic(optional = false)
    @Column(name = "content_contactform")
    private short contentContactform;
    @Basic(optional = false)
    @Column(name = "id_product")
    private int idProduct;
    @Basic(optional = false)
    @Column(name = "id_template")
    private int idTemplate;

    public PsAnProductextratabsTplContent() {
    }

    public PsAnProductextratabsTplContent(Integer idContent) {
        this.idContent = idContent;
    }

    public PsAnProductextratabsTplContent(Integer idContent, short contentActive, short contentCombinations, short contentContactform, int idProduct, int idTemplate) {
        this.idContent = idContent;
        this.contentActive = contentActive;
        this.contentCombinations = contentCombinations;
        this.contentContactform = contentContactform;
        this.idProduct = idProduct;
        this.idTemplate = idTemplate;
    }

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
    }

    public short getContentActive() {
        return contentActive;
    }

    public void setContentActive(short contentActive) {
        this.contentActive = contentActive;
    }

    public short getContentCombinations() {
        return contentCombinations;
    }

    public void setContentCombinations(short contentCombinations) {
        this.contentCombinations = contentCombinations;
    }

    public short getContentContactform() {
        return contentContactform;
    }

    public void setContentContactform(short contentContactform) {
        this.contentContactform = contentContactform;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(int idTemplate) {
        this.idTemplate = idTemplate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContent != null ? idContent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnProductextratabsTplContent)) {
            return false;
        }
        PsAnProductextratabsTplContent other = (PsAnProductextratabsTplContent) object;
        if ((this.idContent == null && other.idContent != null) || (this.idContent != null && !this.idContent.equals(other.idContent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnProductextratabsTplContent[ idContent=" + idContent + " ]";
    }
    
}
