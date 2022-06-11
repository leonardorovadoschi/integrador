/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "VARIAVEL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Variavel.findAll", query = "SELECT v FROM Variavel v")
    , @NamedQuery(name = "Variavel.findByCodvariavel", query = "SELECT v FROM Variavel v WHERE v.codvariavel = :codvariavel")
    , @NamedQuery(name = "Variavel.findByNomevariavel", query = "SELECT v FROM Variavel v WHERE v.nomevariavel = :nomevariavel")
    , @NamedQuery(name = "Variavel.findByDescricaovariavel", query = "SELECT v FROM Variavel v WHERE v.descricaovariavel = :descricaovariavel")
    , @NamedQuery(name = "Variavel.findByFlagtipo", query = "SELECT v FROM Variavel v WHERE v.flagtipo = :flagtipo")})
public class Variavel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVARIAVEL")
    private String codvariavel;
    @Column(name = "NOMEVARIAVEL")
    private String nomevariavel;
    @Column(name = "DESCRICAOVARIAVEL")
    private String descricaovariavel;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;

    public Variavel() {
    }

    public Variavel(String codvariavel) {
        this.codvariavel = codvariavel;
    }

    public String getCodvariavel() {
        return codvariavel;
    }

    public void setCodvariavel(String codvariavel) {
        this.codvariavel = codvariavel;
    }

    public String getNomevariavel() {
        return nomevariavel;
    }

    public void setNomevariavel(String nomevariavel) {
        this.nomevariavel = nomevariavel;
    }

    public String getDescricaovariavel() {
        return descricaovariavel;
    }

    public void setDescricaovariavel(String descricaovariavel) {
        this.descricaovariavel = descricaovariavel;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codvariavel != null ? codvariavel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variavel)) {
            return false;
        }
        Variavel other = (Variavel) object;
        if ((this.codvariavel == null && other.codvariavel != null) || (this.codvariavel != null && !this.codvariavel.equals(other.codvariavel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Variavel[ codvariavel=" + codvariavel + " ]";
    }
    
}
