/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CAMPOCUSTOMLISTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campocustomlista.findAll", query = "SELECT c FROM Campocustomlista c")
    , @NamedQuery(name = "Campocustomlista.findByCodcampocustomlista", query = "SELECT c FROM Campocustomlista c WHERE c.codcampocustomlista = :codcampocustomlista")
    , @NamedQuery(name = "Campocustomlista.findByValor", query = "SELECT c FROM Campocustomlista c WHERE c.valor = :valor")})
public class Campocustomlista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAMPOCUSTOMLISTA")
    private String codcampocustomlista;
    @Column(name = "VALOR")
    private String valor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "campocustomlista1")
    private Campocustomlista campocustomlista;
    @JoinColumn(name = "CODCAMPOCUSTOMLISTA", referencedColumnName = "CODCAMPOCUSTOMLISTA", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Campocustomlista campocustomlista1;
    @JoinColumn(name = "CODCAMPOCUSTOMMASTER", referencedColumnName = "CODCAMPOCUSTOMMASTER")
    @ManyToOne
    private Campocustommaster codcampocustommaster;

    public Campocustomlista() {
    }

    public Campocustomlista(String codcampocustomlista) {
        this.codcampocustomlista = codcampocustomlista;
    }

    public String getCodcampocustomlista() {
        return codcampocustomlista;
    }

    public void setCodcampocustomlista(String codcampocustomlista) {
        this.codcampocustomlista = codcampocustomlista;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Campocustomlista getCampocustomlista() {
        return campocustomlista;
    }

    public void setCampocustomlista(Campocustomlista campocustomlista) {
        this.campocustomlista = campocustomlista;
    }

    public Campocustomlista getCampocustomlista1() {
        return campocustomlista1;
    }

    public void setCampocustomlista1(Campocustomlista campocustomlista1) {
        this.campocustomlista1 = campocustomlista1;
    }

    public Campocustommaster getCodcampocustommaster() {
        return codcampocustommaster;
    }

    public void setCodcampocustommaster(Campocustommaster codcampocustommaster) {
        this.codcampocustommaster = codcampocustommaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcampocustomlista != null ? codcampocustomlista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campocustomlista)) {
            return false;
        }
        Campocustomlista other = (Campocustomlista) object;
        if ((this.codcampocustomlista == null && other.codcampocustomlista != null) || (this.codcampocustomlista != null && !this.codcampocustomlista.equals(other.codcampocustomlista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Campocustomlista[ codcampocustomlista=" + codcampocustomlista + " ]";
    }
    
}
