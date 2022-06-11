/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "MOENTREGAPRODENT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentregaprodent.findAll", query = "SELECT m FROM Moentregaprodent m")
    , @NamedQuery(name = "Moentregaprodent.findByIdmoentregaprod", query = "SELECT m FROM Moentregaprodent m WHERE m.idmoentregaprod = :idmoentregaprod")
    , @NamedQuery(name = "Moentregaprodent.findByQuantidade", query = "SELECT m FROM Moentregaprodent m WHERE m.quantidade = :quantidade")
    , @NamedQuery(name = "Moentregaprodent.findById", query = "SELECT m FROM Moentregaprodent m WHERE m.id = :id")
    , @NamedQuery(name = "Moentregaprodent.findByLoteentrega", query = "SELECT m FROM Moentregaprodent m WHERE m.loteentrega = :loteentrega")
    , @NamedQuery(name = "Moentregaprodent.findByFlagstatus", query = "SELECT m FROM Moentregaprodent m WHERE m.flagstatus = :flagstatus")})
public class Moentregaprodent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "IDMOENTREGAPROD")
    private Integer idmoentregaprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOTEENTREGA")
    private Integer loteentrega;
    @Column(name = "FLAGSTATUS")
    private Character flagstatus;

    public Moentregaprodent() {
    }

    public Moentregaprodent(Integer id) {
        this.id = id;
    }

    public Integer getIdmoentregaprod() {
        return idmoentregaprod;
    }

    public void setIdmoentregaprod(Integer idmoentregaprod) {
        this.idmoentregaprod = idmoentregaprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoteentrega() {
        return loteentrega;
    }

    public void setLoteentrega(Integer loteentrega) {
        this.loteentrega = loteentrega;
    }

    public Character getFlagstatus() {
        return flagstatus;
    }

    public void setFlagstatus(Character flagstatus) {
        this.flagstatus = flagstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moentregaprodent)) {
            return false;
        }
        Moentregaprodent other = (Moentregaprodent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentregaprodent[ id=" + id + " ]";
    }
    
}
