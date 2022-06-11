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
@Table(name = "DIAINUTILFIXO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diainutilfixo.findAll", query = "SELECT d FROM Diainutilfixo d")
    , @NamedQuery(name = "Diainutilfixo.findByCoddiainutilfixo", query = "SELECT d FROM Diainutilfixo d WHERE d.coddiainutilfixo = :coddiainutilfixo")
    , @NamedQuery(name = "Diainutilfixo.findByNumdia", query = "SELECT d FROM Diainutilfixo d WHERE d.numdia = :numdia")
    , @NamedQuery(name = "Diainutilfixo.findByNummes", query = "SELECT d FROM Diainutilfixo d WHERE d.nummes = :nummes")
    , @NamedQuery(name = "Diainutilfixo.findByNomediainutilfixo", query = "SELECT d FROM Diainutilfixo d WHERE d.nomediainutilfixo = :nomediainutilfixo")})
public class Diainutilfixo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDIAINUTILFIXO")
    private String coddiainutilfixo;
    @Basic(optional = false)
    @Column(name = "NUMDIA")
    private int numdia;
    @Basic(optional = false)
    @Column(name = "NUMMES")
    private int nummes;
    @Column(name = "NOMEDIAINUTILFIXO")
    private String nomediainutilfixo;

    public Diainutilfixo() {
    }

    public Diainutilfixo(String coddiainutilfixo) {
        this.coddiainutilfixo = coddiainutilfixo;
    }

    public Diainutilfixo(String coddiainutilfixo, int numdia, int nummes) {
        this.coddiainutilfixo = coddiainutilfixo;
        this.numdia = numdia;
        this.nummes = nummes;
    }

    public String getCoddiainutilfixo() {
        return coddiainutilfixo;
    }

    public void setCoddiainutilfixo(String coddiainutilfixo) {
        this.coddiainutilfixo = coddiainutilfixo;
    }

    public int getNumdia() {
        return numdia;
    }

    public void setNumdia(int numdia) {
        this.numdia = numdia;
    }

    public int getNummes() {
        return nummes;
    }

    public void setNummes(int nummes) {
        this.nummes = nummes;
    }

    public String getNomediainutilfixo() {
        return nomediainutilfixo;
    }

    public void setNomediainutilfixo(String nomediainutilfixo) {
        this.nomediainutilfixo = nomediainutilfixo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddiainutilfixo != null ? coddiainutilfixo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diainutilfixo)) {
            return false;
        }
        Diainutilfixo other = (Diainutilfixo) object;
        if ((this.coddiainutilfixo == null && other.coddiainutilfixo != null) || (this.coddiainutilfixo != null && !this.coddiainutilfixo.equals(other.coddiainutilfixo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Diainutilfixo[ coddiainutilfixo=" + coddiainutilfixo + " ]";
    }
    
}
