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
@Table(name = "TINTASUVINILCOLORANTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tintasuvinilcolorante.findAll", query = "SELECT t FROM Tintasuvinilcolorante t")
    , @NamedQuery(name = "Tintasuvinilcolorante.findByCodtintasuvinilcolorante", query = "SELECT t FROM Tintasuvinilcolorante t WHERE t.codtintasuvinilcolorante = :codtintasuvinilcolorante")
    , @NamedQuery(name = "Tintasuvinilcolorante.findByNomecolorante", query = "SELECT t FROM Tintasuvinilcolorante t WHERE t.nomecolorante = :nomecolorante")
    , @NamedQuery(name = "Tintasuvinilcolorante.findBySigla", query = "SELECT t FROM Tintasuvinilcolorante t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "Tintasuvinilcolorante.findByCodprod", query = "SELECT t FROM Tintasuvinilcolorante t WHERE t.codprod = :codprod")})
public class Tintasuvinilcolorante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTINTASUVINILCOLORANTE")
    private Integer codtintasuvinilcolorante;
    @Column(name = "NOMECOLORANTE")
    private String nomecolorante;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "CODPROD")
    private String codprod;

    public Tintasuvinilcolorante() {
    }

    public Tintasuvinilcolorante(Integer codtintasuvinilcolorante) {
        this.codtintasuvinilcolorante = codtintasuvinilcolorante;
    }

    public Integer getCodtintasuvinilcolorante() {
        return codtintasuvinilcolorante;
    }

    public void setCodtintasuvinilcolorante(Integer codtintasuvinilcolorante) {
        this.codtintasuvinilcolorante = codtintasuvinilcolorante;
    }

    public String getNomecolorante() {
        return nomecolorante;
    }

    public void setNomecolorante(String nomecolorante) {
        this.nomecolorante = nomecolorante;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtintasuvinilcolorante != null ? codtintasuvinilcolorante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tintasuvinilcolorante)) {
            return false;
        }
        Tintasuvinilcolorante other = (Tintasuvinilcolorante) object;
        if ((this.codtintasuvinilcolorante == null && other.codtintasuvinilcolorante != null) || (this.codtintasuvinilcolorante != null && !this.codtintasuvinilcolorante.equals(other.codtintasuvinilcolorante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tintasuvinilcolorante[ codtintasuvinilcolorante=" + codtintasuvinilcolorante + " ]";
    }
    
}
