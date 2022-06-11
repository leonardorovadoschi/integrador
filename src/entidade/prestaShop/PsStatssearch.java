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
@Table(name = "ps_statssearch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsStatssearch.findAll", query = "SELECT p FROM PsStatssearch p")
    , @NamedQuery(name = "PsStatssearch.findByIdStatssearch", query = "SELECT p FROM PsStatssearch p WHERE p.idStatssearch = :idStatssearch")
    , @NamedQuery(name = "PsStatssearch.findByIdShop", query = "SELECT p FROM PsStatssearch p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsStatssearch.findByIdShopGroup", query = "SELECT p FROM PsStatssearch p WHERE p.idShopGroup = :idShopGroup")
    , @NamedQuery(name = "PsStatssearch.findByKeywords", query = "SELECT p FROM PsStatssearch p WHERE p.keywords = :keywords")
    , @NamedQuery(name = "PsStatssearch.findByResults", query = "SELECT p FROM PsStatssearch p WHERE p.results = :results")
    , @NamedQuery(name = "PsStatssearch.findByDateAdd", query = "SELECT p FROM PsStatssearch p WHERE p.dateAdd = :dateAdd")})
public class PsStatssearch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_statssearch")
    private Integer idStatssearch;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_shop_group")
    private int idShopGroup;
    @Basic(optional = false)
    @Column(name = "keywords")
    private String keywords;
    @Basic(optional = false)
    @Column(name = "results")
    private int results;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public PsStatssearch() {
    }

    public PsStatssearch(Integer idStatssearch) {
        this.idStatssearch = idStatssearch;
    }

    public PsStatssearch(Integer idStatssearch, int idShop, int idShopGroup, String keywords, int results, Date dateAdd) {
        this.idStatssearch = idStatssearch;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.keywords = keywords;
        this.results = results;
        this.dateAdd = dateAdd;
    }

    public Integer getIdStatssearch() {
        return idStatssearch;
    }

    public void setIdStatssearch(Integer idStatssearch) {
        this.idStatssearch = idStatssearch;
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

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
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
        hash += (idStatssearch != null ? idStatssearch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsStatssearch)) {
            return false;
        }
        PsStatssearch other = (PsStatssearch) object;
        if ((this.idStatssearch == null && other.idStatssearch != null) || (this.idStatssearch != null && !this.idStatssearch.equals(other.idStatssearch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsStatssearch[ idStatssearch=" + idStatssearch + " ]";
    }
    
}
