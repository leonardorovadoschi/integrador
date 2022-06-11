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
@Table(name = "REGIAOCIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiaocidade.findAll", query = "SELECT r FROM Regiaocidade r")
    , @NamedQuery(name = "Regiaocidade.findByCodregiaocidade", query = "SELECT r FROM Regiaocidade r WHERE r.codregiaocidade = :codregiaocidade")})
public class Regiaocidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREGIAOCIDADE")
    private String codregiaocidade;
    @JoinColumn(name = "CODCIDADE", referencedColumnName = "CODCIDADE")
    @ManyToOne
    private Cidade codcidade;
    @JoinColumn(name = "CODREGIAO", referencedColumnName = "CODREGIAO")
    @ManyToOne(optional = false)
    private Regiao codregiao;

    public Regiaocidade() {
    }

    public Regiaocidade(String codregiaocidade) {
        this.codregiaocidade = codregiaocidade;
    }

    public String getCodregiaocidade() {
        return codregiaocidade;
    }

    public void setCodregiaocidade(String codregiaocidade) {
        this.codregiaocidade = codregiaocidade;
    }

    public Cidade getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Cidade codcidade) {
        this.codcidade = codcidade;
    }

    public Regiao getCodregiao() {
        return codregiao;
    }

    public void setCodregiao(Regiao codregiao) {
        this.codregiao = codregiao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codregiaocidade != null ? codregiaocidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiaocidade)) {
            return false;
        }
        Regiaocidade other = (Regiaocidade) object;
        if ((this.codregiaocidade == null && other.codregiaocidade != null) || (this.codregiaocidade != null && !this.codregiaocidade.equals(other.codregiaocidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Regiaocidade[ codregiaocidade=" + codregiaocidade + " ]";
    }
    
}
