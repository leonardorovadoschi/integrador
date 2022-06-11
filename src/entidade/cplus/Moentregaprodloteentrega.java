/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "MOENTREGAPRODLOTEENTREGA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moentregaprodloteentrega.findAll", query = "SELECT m FROM Moentregaprodloteentrega m")
    , @NamedQuery(name = "Moentregaprodloteentrega.findByCodmoentregaprodloteentrega", query = "SELECT m FROM Moentregaprodloteentrega m WHERE m.codmoentregaprodloteentrega = :codmoentregaprodloteentrega")
    , @NamedQuery(name = "Moentregaprodloteentrega.findByNumeroentrega", query = "SELECT m FROM Moentregaprodloteentrega m WHERE m.numeroentrega = :numeroentrega")
    , @NamedQuery(name = "Moentregaprodloteentrega.findByFlagcancelada", query = "SELECT m FROM Moentregaprodloteentrega m WHERE m.flagcancelada = :flagcancelada")
    , @NamedQuery(name = "Moentregaprodloteentrega.findByData", query = "SELECT m FROM Moentregaprodloteentrega m WHERE m.data = :data")
    , @NamedQuery(name = "Moentregaprodloteentrega.findByCodmovenda", query = "SELECT m FROM Moentregaprodloteentrega m WHERE m.codmovenda = :codmovenda")})
public class Moentregaprodloteentrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMOENTREGAPRODLOTEENTREGA")
    private String codmoentregaprodloteentrega;
    @Basic(optional = false)
    @Column(name = "NUMEROENTREGA")
    private int numeroentrega;
    @Column(name = "FLAGCANCELADA")
    private Character flagcancelada;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODMOVENDA")
    private String codmovenda;

    public Moentregaprodloteentrega() {
    }

    public Moentregaprodloteentrega(String codmoentregaprodloteentrega) {
        this.codmoentregaprodloteentrega = codmoentregaprodloteentrega;
    }

    public Moentregaprodloteentrega(String codmoentregaprodloteentrega, int numeroentrega) {
        this.codmoentregaprodloteentrega = codmoentregaprodloteentrega;
        this.numeroentrega = numeroentrega;
    }

    public String getCodmoentregaprodloteentrega() {
        return codmoentregaprodloteentrega;
    }

    public void setCodmoentregaprodloteentrega(String codmoentregaprodloteentrega) {
        this.codmoentregaprodloteentrega = codmoentregaprodloteentrega;
    }

    public int getNumeroentrega() {
        return numeroentrega;
    }

    public void setNumeroentrega(int numeroentrega) {
        this.numeroentrega = numeroentrega;
    }

    public Character getFlagcancelada() {
        return flagcancelada;
    }

    public void setFlagcancelada(Character flagcancelada) {
        this.flagcancelada = flagcancelada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCodmovenda() {
        return codmovenda;
    }

    public void setCodmovenda(String codmovenda) {
        this.codmovenda = codmovenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmoentregaprodloteentrega != null ? codmoentregaprodloteentrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moentregaprodloteentrega)) {
            return false;
        }
        Moentregaprodloteentrega other = (Moentregaprodloteentrega) object;
        if ((this.codmoentregaprodloteentrega == null && other.codmoentregaprodloteentrega != null) || (this.codmoentregaprodloteentrega != null && !this.codmoentregaprodloteentrega.equals(other.codmoentregaprodloteentrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Moentregaprodloteentrega[ codmoentregaprodloteentrega=" + codmoentregaprodloteentrega + " ]";
    }
    
}
