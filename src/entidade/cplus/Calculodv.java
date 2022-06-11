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
@Table(name = "CALCULODV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculodv.findAll", query = "SELECT c FROM Calculodv c")
    , @NamedQuery(name = "Calculodv.findByCodcalculodv", query = "SELECT c FROM Calculodv c WHERE c.codcalculodv = :codcalculodv")
    , @NamedQuery(name = "Calculodv.findByCodigo", query = "SELECT c FROM Calculodv c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Calculodv.findByNomecalculodv", query = "SELECT c FROM Calculodv c WHERE c.nomecalculodv = :nomecalculodv")})
public class Calculodv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCALCULODV")
    private String codcalculodv;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECALCULODV")
    private String nomecalculodv;
    @OneToMany(mappedBy = "codcalculodv")
    private Collection<Contabancaria> contabancariaCollection;

    public Calculodv() {
    }

    public Calculodv(String codcalculodv) {
        this.codcalculodv = codcalculodv;
    }

    public String getCodcalculodv() {
        return codcalculodv;
    }

    public void setCodcalculodv(String codcalculodv) {
        this.codcalculodv = codcalculodv;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecalculodv() {
        return nomecalculodv;
    }

    public void setNomecalculodv(String nomecalculodv) {
        this.nomecalculodv = nomecalculodv;
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
        hash += (codcalculodv != null ? codcalculodv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calculodv)) {
            return false;
        }
        Calculodv other = (Calculodv) object;
        if ((this.codcalculodv == null && other.codcalculodv != null) || (this.codcalculodv != null && !this.codcalculodv.equals(other.codcalculodv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Calculodv[ codcalculodv=" + codcalculodv + " ]";
    }
    
}
