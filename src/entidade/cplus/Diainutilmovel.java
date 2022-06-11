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
@Table(name = "DIAINUTILMOVEL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diainutilmovel.findAll", query = "SELECT d FROM Diainutilmovel d")
    , @NamedQuery(name = "Diainutilmovel.findByCoddiainutilmovel", query = "SELECT d FROM Diainutilmovel d WHERE d.coddiainutilmovel = :coddiainutilmovel")
    , @NamedQuery(name = "Diainutilmovel.findByDatainutil", query = "SELECT d FROM Diainutilmovel d WHERE d.datainutil = :datainutil")
    , @NamedQuery(name = "Diainutilmovel.findByNomediainutilmovel", query = "SELECT d FROM Diainutilmovel d WHERE d.nomediainutilmovel = :nomediainutilmovel")})
public class Diainutilmovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDIAINUTILMOVEL")
    private String coddiainutilmovel;
    @Basic(optional = false)
    @Column(name = "DATAINUTIL")
    @Temporal(TemporalType.DATE)
    private Date datainutil;
    @Column(name = "NOMEDIAINUTILMOVEL")
    private String nomediainutilmovel;

    public Diainutilmovel() {
    }

    public Diainutilmovel(String coddiainutilmovel) {
        this.coddiainutilmovel = coddiainutilmovel;
    }

    public Diainutilmovel(String coddiainutilmovel, Date datainutil) {
        this.coddiainutilmovel = coddiainutilmovel;
        this.datainutil = datainutil;
    }

    public String getCoddiainutilmovel() {
        return coddiainutilmovel;
    }

    public void setCoddiainutilmovel(String coddiainutilmovel) {
        this.coddiainutilmovel = coddiainutilmovel;
    }

    public Date getDatainutil() {
        return datainutil;
    }

    public void setDatainutil(Date datainutil) {
        this.datainutil = datainutil;
    }

    public String getNomediainutilmovel() {
        return nomediainutilmovel;
    }

    public void setNomediainutilmovel(String nomediainutilmovel) {
        this.nomediainutilmovel = nomediainutilmovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddiainutilmovel != null ? coddiainutilmovel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diainutilmovel)) {
            return false;
        }
        Diainutilmovel other = (Diainutilmovel) object;
        if ((this.coddiainutilmovel == null && other.coddiainutilmovel != null) || (this.coddiainutilmovel != null && !this.coddiainutilmovel.equals(other.coddiainutilmovel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Diainutilmovel[ coddiainutilmovel=" + coddiainutilmovel + " ]";
    }
    
}
