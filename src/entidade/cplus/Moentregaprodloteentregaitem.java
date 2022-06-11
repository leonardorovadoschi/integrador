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
@Table(name = "MOENTREGAPRODLOTEENTREGAITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentregaprodloteentregaitem.findAll", query = "SELECT m FROM Moentregaprodloteentregaitem m")
    , @NamedQuery(name = "Moentregaprodloteentregaitem.findByCodmoentregaprodloteentregaitem", query = "SELECT m FROM Moentregaprodloteentregaitem m WHERE m.codmoentregaprodloteentregaitem = :codmoentregaprodloteentregaitem")
    , @NamedQuery(name = "Moentregaprodloteentregaitem.findByCodmoentregaprodloteentrega", query = "SELECT m FROM Moentregaprodloteentregaitem m WHERE m.codmoentregaprodloteentrega = :codmoentregaprodloteentrega")
    , @NamedQuery(name = "Moentregaprodloteentregaitem.findByIdmoentregaprod", query = "SELECT m FROM Moentregaprodloteentregaitem m WHERE m.idmoentregaprod = :idmoentregaprod")
    , @NamedQuery(name = "Moentregaprodloteentregaitem.findByQuantidade", query = "SELECT m FROM Moentregaprodloteentregaitem m WHERE m.quantidade = :quantidade")})
public class Moentregaprodloteentregaitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOENTREGAPRODLOTEENTREGAITEM")
    private String codmoentregaprodloteentregaitem;
    @Basic(optional = false)
    @Column(name = "CODMOENTREGAPRODLOTEENTREGA")
    private String codmoentregaprodloteentrega;
    @Column(name = "IDMOENTREGAPROD")
    private String idmoentregaprod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;

    public Moentregaprodloteentregaitem() {
    }

    public Moentregaprodloteentregaitem(String codmoentregaprodloteentregaitem) {
        this.codmoentregaprodloteentregaitem = codmoentregaprodloteentregaitem;
    }

    public Moentregaprodloteentregaitem(String codmoentregaprodloteentregaitem, String codmoentregaprodloteentrega) {
        this.codmoentregaprodloteentregaitem = codmoentregaprodloteentregaitem;
        this.codmoentregaprodloteentrega = codmoentregaprodloteentrega;
    }

    public String getCodmoentregaprodloteentregaitem() {
        return codmoentregaprodloteentregaitem;
    }

    public void setCodmoentregaprodloteentregaitem(String codmoentregaprodloteentregaitem) {
        this.codmoentregaprodloteentregaitem = codmoentregaprodloteentregaitem;
    }

    public String getCodmoentregaprodloteentrega() {
        return codmoentregaprodloteentrega;
    }

    public void setCodmoentregaprodloteentrega(String codmoentregaprodloteentrega) {
        this.codmoentregaprodloteentrega = codmoentregaprodloteentrega;
    }

    public String getIdmoentregaprod() {
        return idmoentregaprod;
    }

    public void setIdmoentregaprod(String idmoentregaprod) {
        this.idmoentregaprod = idmoentregaprod;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoentregaprodloteentregaitem != null ? codmoentregaprodloteentregaitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moentregaprodloteentregaitem)) {
            return false;
        }
        Moentregaprodloteentregaitem other = (Moentregaprodloteentregaitem) object;
        if ((this.codmoentregaprodloteentregaitem == null && other.codmoentregaprodloteentregaitem != null) || (this.codmoentregaprodloteentregaitem != null && !this.codmoentregaprodloteentregaitem.equals(other.codmoentregaprodloteentregaitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentregaprodloteentregaitem[ codmoentregaprodloteentregaitem=" + codmoentregaprodloteentregaitem + " ]";
    }
    
}
