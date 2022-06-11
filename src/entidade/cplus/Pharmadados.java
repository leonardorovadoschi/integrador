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
@Table(name = "PHARMADADOS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pharmadados.findAll", query = "SELECT p FROM Pharmadados p")
    , @NamedQuery(name = "Pharmadados.findByCodpharmadados", query = "SELECT p FROM Pharmadados p WHERE p.codpharmadados = :codpharmadados")
    , @NamedQuery(name = "Pharmadados.findByTipoinformacao", query = "SELECT p FROM Pharmadados p WHERE p.tipoinformacao = :tipoinformacao")
    , @NamedQuery(name = "Pharmadados.findByNomeinformacao", query = "SELECT p FROM Pharmadados p WHERE p.nomeinformacao = :nomeinformacao")
    , @NamedQuery(name = "Pharmadados.findByCodigoinformacaoanvisa", query = "SELECT p FROM Pharmadados p WHERE p.codigoinformacaoanvisa = :codigoinformacaoanvisa")})
public class Pharmadados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPHARMADADOS")
    private String codpharmadados;
    @Column(name = "TIPOINFORMACAO")
    private String tipoinformacao;
    @Column(name = "NOMEINFORMACAO")
    private String nomeinformacao;
    @Column(name = "CODIGOINFORMACAOANVISA")
    private String codigoinformacaoanvisa;

    public Pharmadados() {
    }

    public Pharmadados(String codpharmadados) {
        this.codpharmadados = codpharmadados;
    }

    public String getCodpharmadados() {
        return codpharmadados;
    }

    public void setCodpharmadados(String codpharmadados) {
        this.codpharmadados = codpharmadados;
    }

    public String getTipoinformacao() {
        return tipoinformacao;
    }

    public void setTipoinformacao(String tipoinformacao) {
        this.tipoinformacao = tipoinformacao;
    }

    public String getNomeinformacao() {
        return nomeinformacao;
    }

    public void setNomeinformacao(String nomeinformacao) {
        this.nomeinformacao = nomeinformacao;
    }

    public String getCodigoinformacaoanvisa() {
        return codigoinformacaoanvisa;
    }

    public void setCodigoinformacaoanvisa(String codigoinformacaoanvisa) {
        this.codigoinformacaoanvisa = codigoinformacaoanvisa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpharmadados != null ? codpharmadados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pharmadados)) {
            return false;
        }
        Pharmadados other = (Pharmadados) object;
        if ((this.codpharmadados == null && other.codpharmadados != null) || (this.codpharmadados != null && !this.codpharmadados.equals(other.codpharmadados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pharmadados[ codpharmadados=" + codpharmadados + " ]";
    }
    
}
