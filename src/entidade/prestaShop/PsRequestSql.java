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
@Table(name = "ps_request_sql")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsRequestSql.findAll", query = "SELECT p FROM PsRequestSql p")
    , @NamedQuery(name = "PsRequestSql.findByIdRequestSql", query = "SELECT p FROM PsRequestSql p WHERE p.idRequestSql = :idRequestSql")
    , @NamedQuery(name = "PsRequestSql.findByName", query = "SELECT p FROM PsRequestSql p WHERE p.name = :name")})
public class PsRequestSql implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_request_sql")
    private Integer idRequestSql;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "sql")
    private String sql;

    public PsRequestSql() {
    }

    public PsRequestSql(Integer idRequestSql) {
        this.idRequestSql = idRequestSql;
    }

    public PsRequestSql(Integer idRequestSql, String name, String sql) {
        this.idRequestSql = idRequestSql;
        this.name = name;
        this.sql = sql;
    }

    public Integer getIdRequestSql() {
        return idRequestSql;
    }

    public void setIdRequestSql(Integer idRequestSql) {
        this.idRequestSql = idRequestSql;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequestSql != null ? idRequestSql.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsRequestSql)) {
            return false;
        }
        PsRequestSql other = (PsRequestSql) object;
        if ((this.idRequestSql == null && other.idRequestSql != null) || (this.idRequestSql != null && !this.idRequestSql.equals(other.idRequestSql))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsRequestSql[ idRequestSql=" + idRequestSql + " ]";
    }
    
}
