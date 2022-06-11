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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PESSOACATEGORIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoacategoria.findAll", query = "SELECT p FROM Pessoacategoria p")
    , @NamedQuery(name = "Pessoacategoria.findByCodpessoacategoria", query = "SELECT p FROM Pessoacategoria p WHERE p.codpessoacategoria = :codpessoacategoria")})
public class Pessoacategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESSOACATEGORIA")
    private String codpessoacategoria;
    @JoinColumn(name = "CODCATEGORIAPESSOA", referencedColumnName = "CODCATEGORIAPESSOA")
    @ManyToOne
    private Categoriapessoa codcategoriapessoa;
    @JoinColumn(name = "CODPESSOA", referencedColumnName = "CODPESSOA")
    @ManyToOne
    private Pessoa codpessoa;

    public Pessoacategoria() {
    }

    public Pessoacategoria(String codpessoacategoria) {
        this.codpessoacategoria = codpessoacategoria;
    }

    public String getCodpessoacategoria() {
        return codpessoacategoria;
    }

    public void setCodpessoacategoria(String codpessoacategoria) {
        this.codpessoacategoria = codpessoacategoria;
    }

    public Categoriapessoa getCodcategoriapessoa() {
        return codcategoriapessoa;
    }

    public void setCodcategoriapessoa(Categoriapessoa codcategoriapessoa) {
        this.codcategoriapessoa = codcategoriapessoa;
    }

    public Pessoa getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Pessoa codpessoa) {
        this.codpessoa = codpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpessoacategoria != null ? codpessoacategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoacategoria)) {
            return false;
        }
        Pessoacategoria other = (Pessoacategoria) object;
        if ((this.codpessoacategoria == null && other.codpessoacategoria != null) || (this.codpessoacategoria != null && !this.codpessoacategoria.equals(other.codpessoacategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pessoacategoria[ codpessoacategoria=" + codpessoacategoria + " ]";
    }
    
}
