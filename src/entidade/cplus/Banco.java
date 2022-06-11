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
@Table(name = "BANCO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banco.findAll", query = "SELECT b FROM Banco b")
    , @NamedQuery(name = "Banco.findByCodbanco", query = "SELECT b FROM Banco b WHERE b.codbanco = :codbanco")
    , @NamedQuery(name = "Banco.findByCodigo", query = "SELECT b FROM Banco b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Banco.findByNomebanco", query = "SELECT b FROM Banco b WHERE b.nomebanco = :nomebanco")})
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBANCO")
    private String codbanco;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEBANCO")
    private String nomebanco;
    @OneToMany(mappedBy = "codbanco")
    private Collection<Montagemarquivo> montagemarquivoCollection;
    @OneToMany(mappedBy = "codbanco")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codbanco")
    private Collection<Contabancaria> contabancariaCollection;

    public Banco() {
    }

    public Banco(String codbanco) {
        this.codbanco = codbanco;
    }

    public String getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(String codbanco) {
        this.codbanco = codbanco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomebanco() {
        return nomebanco;
    }

    public void setNomebanco(String nomebanco) {
        this.nomebanco = nomebanco;
    }

    @XmlTransient
    public Collection<Montagemarquivo> getMontagemarquivoCollection() {
        return montagemarquivoCollection;
    }

    public void setMontagemarquivoCollection(Collection<Montagemarquivo> montagemarquivoCollection) {
        this.montagemarquivoCollection = montagemarquivoCollection;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Contabancaria> getContabancariaCollection() {
        return contabancariaCollection;
    }

    public void setContabancariaCollection(Collection<Contabancaria> contabancariaCollection) {
        this.contabancariaCollection = contabancariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbanco != null ? codbanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.codbanco == null && other.codbanco != null) || (this.codbanco != null && !this.codbanco.equals(other.codbanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Banco[ codbanco=" + codbanco + " ]";
    }
    
}
