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
@Table(name = "BICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bico.findAll", query = "SELECT b FROM Bico b")
    , @NamedQuery(name = "Bico.findByCodbico", query = "SELECT b FROM Bico b WHERE b.codbico = :codbico")
    , @NamedQuery(name = "Bico.findByNumerobico", query = "SELECT b FROM Bico b WHERE b.numerobico = :numerobico")
    , @NamedQuery(name = "Bico.findByNomebico", query = "SELECT b FROM Bico b WHERE b.nomebico = :nomebico")})
public class Bico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBICO")
    private String codbico;
    @Basic(optional = false)
    @Column(name = "NUMEROBICO")
    private int numerobico;
    @Column(name = "NOMEBICO")
    private String nomebico;
    @JoinColumn(name = "CODTANQUE", referencedColumnName = "CODTANQUE")
    @ManyToOne(optional = false)
    private Tanque codtanque;

    public Bico() {
    }

    public Bico(String codbico) {
        this.codbico = codbico;
    }

    public Bico(String codbico, int numerobico) {
        this.codbico = codbico;
        this.numerobico = numerobico;
    }

    public String getCodbico() {
        return codbico;
    }

    public void setCodbico(String codbico) {
        this.codbico = codbico;
    }

    public int getNumerobico() {
        return numerobico;
    }

    public void setNumerobico(int numerobico) {
        this.numerobico = numerobico;
    }

    public String getNomebico() {
        return nomebico;
    }

    public void setNomebico(String nomebico) {
        this.nomebico = nomebico;
    }

    public Tanque getCodtanque() {
        return codtanque;
    }

    public void setCodtanque(Tanque codtanque) {
        this.codtanque = codtanque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbico != null ? codbico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bico)) {
            return false;
        }
        Bico other = (Bico) object;
        if ((this.codbico == null && other.codbico != null) || (this.codbico != null && !this.codbico.equals(other.codbico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Bico[ codbico=" + codbico + " ]";
    }
    
}
