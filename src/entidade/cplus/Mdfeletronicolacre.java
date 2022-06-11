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
@Table(name = "MDFELETRONICOLACRE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicolacre.findAll", query = "SELECT m FROM Mdfeletronicolacre m")
    , @NamedQuery(name = "Mdfeletronicolacre.findByCodmdfeletronicolacre", query = "SELECT m FROM Mdfeletronicolacre m WHERE m.codmdfeletronicolacre = :codmdfeletronicolacre")
    , @NamedQuery(name = "Mdfeletronicolacre.findByNumerolacre", query = "SELECT m FROM Mdfeletronicolacre m WHERE m.numerolacre = :numerolacre")
    , @NamedQuery(name = "Mdfeletronicolacre.findByIdentidadeorigem", query = "SELECT m FROM Mdfeletronicolacre m WHERE m.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Mdfeletronicolacre.findByNomeentidadeorigem", query = "SELECT m FROM Mdfeletronicolacre m WHERE m.nomeentidadeorigem = :nomeentidadeorigem")})
public class Mdfeletronicolacre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOLACRE")
    private String codmdfeletronicolacre;
    @Basic(optional = false)
    @Column(name = "NUMEROLACRE")
    private String numerolacre;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;

    public Mdfeletronicolacre() {
    }

    public Mdfeletronicolacre(String codmdfeletronicolacre) {
        this.codmdfeletronicolacre = codmdfeletronicolacre;
    }

    public Mdfeletronicolacre(String codmdfeletronicolacre, String numerolacre) {
        this.codmdfeletronicolacre = codmdfeletronicolacre;
        this.numerolacre = numerolacre;
    }

    public String getCodmdfeletronicolacre() {
        return codmdfeletronicolacre;
    }

    public void setCodmdfeletronicolacre(String codmdfeletronicolacre) {
        this.codmdfeletronicolacre = codmdfeletronicolacre;
    }

    public String getNumerolacre() {
        return numerolacre;
    }

    public void setNumerolacre(String numerolacre) {
        this.numerolacre = numerolacre;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicolacre != null ? codmdfeletronicolacre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicolacre)) {
            return false;
        }
        Mdfeletronicolacre other = (Mdfeletronicolacre) object;
        if ((this.codmdfeletronicolacre == null && other.codmdfeletronicolacre != null) || (this.codmdfeletronicolacre != null && !this.codmdfeletronicolacre.equals(other.codmdfeletronicolacre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicolacre[ codmdfeletronicolacre=" + codmdfeletronicolacre + " ]";
    }
    
}
