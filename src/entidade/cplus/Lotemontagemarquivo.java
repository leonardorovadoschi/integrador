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
@Table(name = "LOTEMONTAGEMARQUIVO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotemontagemarquivo.findAll", query = "SELECT l FROM Lotemontagemarquivo l")
    , @NamedQuery(name = "Lotemontagemarquivo.findByCodlotemontagemarquivo", query = "SELECT l FROM Lotemontagemarquivo l WHERE l.codlotemontagemarquivo = :codlotemontagemarquivo")
    , @NamedQuery(name = "Lotemontagemarquivo.findByCodigo", query = "SELECT l FROM Lotemontagemarquivo l WHERE l.codigo = :codigo")
    , @NamedQuery(name = "Lotemontagemarquivo.findByNomelotemontagemarquivo", query = "SELECT l FROM Lotemontagemarquivo l WHERE l.nomelotemontagemarquivo = :nomelotemontagemarquivo")})
public class Lotemontagemarquivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODLOTEMONTAGEMARQUIVO")
    private String codlotemontagemarquivo;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMELOTEMONTAGEMARQUIVO")
    private String nomelotemontagemarquivo;
    @OneToMany(mappedBy = "codlotemontagemarquivo")
    private Collection<Montagemarquivoitem> montagemarquivoitemCollection;

    public Lotemontagemarquivo() {
    }

    public Lotemontagemarquivo(String codlotemontagemarquivo) {
        this.codlotemontagemarquivo = codlotemontagemarquivo;
    }

    public Lotemontagemarquivo(String codlotemontagemarquivo, String codigo) {
        this.codlotemontagemarquivo = codlotemontagemarquivo;
        this.codigo = codigo;
    }

    public String getCodlotemontagemarquivo() {
        return codlotemontagemarquivo;
    }

    public void setCodlotemontagemarquivo(String codlotemontagemarquivo) {
        this.codlotemontagemarquivo = codlotemontagemarquivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomelotemontagemarquivo() {
        return nomelotemontagemarquivo;
    }

    public void setNomelotemontagemarquivo(String nomelotemontagemarquivo) {
        this.nomelotemontagemarquivo = nomelotemontagemarquivo;
    }

    @XmlTransient
    public Collection<Montagemarquivoitem> getMontagemarquivoitemCollection() {
        return montagemarquivoitemCollection;
    }

    public void setMontagemarquivoitemCollection(Collection<Montagemarquivoitem> montagemarquivoitemCollection) {
        this.montagemarquivoitemCollection = montagemarquivoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlotemontagemarquivo != null ? codlotemontagemarquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lotemontagemarquivo)) {
            return false;
        }
        Lotemontagemarquivo other = (Lotemontagemarquivo) object;
        if ((this.codlotemontagemarquivo == null && other.codlotemontagemarquivo != null) || (this.codlotemontagemarquivo != null && !this.codlotemontagemarquivo.equals(other.codlotemontagemarquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Lotemontagemarquivo[ codlotemontagemarquivo=" + codlotemontagemarquivo + " ]";
    }
    
}
