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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "VENDEDORCARACTERISTICA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedorcaracteristica.findAll", query = "SELECT v FROM Vendedorcaracteristica v")
    , @NamedQuery(name = "Vendedorcaracteristica.findByCodvendedorcaracteristica", query = "SELECT v FROM Vendedorcaracteristica v WHERE v.codvendedorcaracteristica = :codvendedorcaracteristica")
    , @NamedQuery(name = "Vendedorcaracteristica.findByDatacaracteristica", query = "SELECT v FROM Vendedorcaracteristica v WHERE v.datacaracteristica = :datacaracteristica")})
public class Vendedorcaracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVENDEDORCARACTERISTICA")
    private String codvendedorcaracteristica;
    @Column(name = "DATACARACTERISTICA")
    @Temporal(TemporalType.DATE)
    private Date datacaracteristica;
    @JoinColumn(name = "CODCARACTERISTICAPESSOA", referencedColumnName = "CODCARACTERISTICAPESSOA")
    @ManyToOne(optional = false)
    private Caracteristicapessoa codcaracteristicapessoa;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne(optional = false)
    private Vendedor codvended;

    public Vendedorcaracteristica() {
    }

    public Vendedorcaracteristica(String codvendedorcaracteristica) {
        this.codvendedorcaracteristica = codvendedorcaracteristica;
    }

    public String getCodvendedorcaracteristica() {
        return codvendedorcaracteristica;
    }

    public void setCodvendedorcaracteristica(String codvendedorcaracteristica) {
        this.codvendedorcaracteristica = codvendedorcaracteristica;
    }

    public Date getDatacaracteristica() {
        return datacaracteristica;
    }

    public void setDatacaracteristica(Date datacaracteristica) {
        this.datacaracteristica = datacaracteristica;
    }

    public Caracteristicapessoa getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(Caracteristicapessoa codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvendedorcaracteristica != null ? codvendedorcaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedorcaracteristica)) {
            return false;
        }
        Vendedorcaracteristica other = (Vendedorcaracteristica) object;
        if ((this.codvendedorcaracteristica == null && other.codvendedorcaracteristica != null) || (this.codvendedorcaracteristica != null && !this.codvendedorcaracteristica.equals(other.codvendedorcaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Vendedorcaracteristica[ codvendedorcaracteristica=" + codvendedorcaracteristica + " ]";
    }
    
}
