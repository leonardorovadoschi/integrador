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
@Table(name = "ps_sekeyword")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsSekeyword.findAll", query = "SELECT p FROM PsSekeyword p")
    , @NamedQuery(name = "PsSekeyword.findByIdSekeyword", query = "SELECT p FROM PsSekeyword p WHERE p.idSekeyword = :idSekeyword")
    , @NamedQuery(name = "PsSekeyword.findByIdShop", query = "SELECT p FROM PsSekeyword p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsSekeyword.findByIdShopGroup", query = "SELECT p FROM PsSekeyword p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsSekeyword.findByKeyword", query = "SELECT p FROM PsSekeyword p WHERE p.keyword = :keyword")
    , @NamedQuery(name = "PsSekeyword.findByDateAdd", query = "SELECT p FROM PsSekeyword p WHERE p.dateAdd = :dateAdd")})
public class PsSekeyword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sekeyword")
    private Integer idSekeyword;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "keyword")
    private String keyword;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsSekeyword() {
    }

    public PsSekeyword(Integer idSekeyword) {
        this.idSekeyword = idSekeyword;
    }

    public PsSekeyword(Integer idSekeyword, int idShop, int idShopGroup, String keyword, Date dateAdd) {
        this.idSekeyword = idSekeyword;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.keyword = keyword;
        this.dateAdd = dateAdd;
    }

    public Integer getIdSekeyword() {
        return idSekeyword;
    }

    public void setIdSekeyword(Integer idSekeyword) {
        this.idSekeyword = idSekeyword;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSekeyword != null ? idSekeyword.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsSekeyword)) {
            return false;
        }
        PsSekeyword other = (PsSekeyword) object;
        if ((this.idSekeyword == null && other.idSekeyword != null) || (this.idSekeyword != null && !this.idSekeyword.equals(other.idSekeyword))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsSekeyword[ idSekeyword=" + idSekeyword + " ]";
    }
    
}
