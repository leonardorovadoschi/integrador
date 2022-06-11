/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PAIS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
    , @NamedQuery(name = "Pais.findByCodpais", query = "SELECT p FROM Pais p WHERE p.codpais = :codpais")
    , @NamedQuery(name = "Pais.findByNomepais", query = "SELECT p FROM Pais p WHERE p.nomepais = :nomepais")
    , @NamedQuery(name = "Pais.findByCodigoibge", query = "SELECT p FROM Pais p WHERE p.codigoibge = :codigoibge")
    , @NamedQuery(name = "Pais.findByCodigo", query = "SELECT p FROM Pais p WHERE p.codigo = :codigo")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPAIS")
    private String codpais;
    @Basic(optional = false)
    @Column(name = "NOMEPAIS")
    private String nomepais;
    @Column(name = "CODIGOIBGE")
    private String codigoibge;
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "codpais")
    private Collection<Cidade> cidadeCollection;

    public Pais() {
    }

    public Pais(String codpais) {
        this.codpais = codpais;
    }

    public Pais(String codpais, String nomepais) {
        this.codpais = codpais;
        this.nomepais = nomepais;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

    public String getNomepais() {
        return nomepais;
    }

    public void setNomepais(String nomepais) {
        this.nomepais = nomepais;
    }

    public String getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(String codigoibge) {
        this.codigoibge = codigoibge;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpais != null ? codpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codpais == null && other.codpais != null) || (this.codpais != null && !this.codpais.equals(other.codpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pais[ codpais=" + codpais + " ]";
    }
    
}
