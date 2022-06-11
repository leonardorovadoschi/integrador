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
@Table(name = "CAMPOCUSTOMVALOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campocustomvalor.findAll", query = "SELECT c FROM Campocustomvalor c")
    , @NamedQuery(name = "Campocustomvalor.findByCodcampocustomvalor", query = "SELECT c FROM Campocustomvalor c WHERE c.codcampocustomvalor = :codcampocustomvalor")
    , @NamedQuery(name = "Campocustomvalor.findByCodcampocustomlista", query = "SELECT c FROM Campocustomvalor c WHERE c.codcampocustomlista = :codcampocustomlista")
    , @NamedQuery(name = "Campocustomvalor.findByIdentidadeorigem", query = "SELECT c FROM Campocustomvalor c WHERE c.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Campocustomvalor.findByNomeentidadeorigem", query = "SELECT c FROM Campocustomvalor c WHERE c.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Campocustomvalor.findByValor", query = "SELECT c FROM Campocustomvalor c WHERE c.valor = :valor")})
public class Campocustomvalor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCAMPOCUSTOMVALOR")
    private String codcampocustomvalor;
    @Column(name = "CODCAMPOCUSTOMLISTA")
    private String codcampocustomlista;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "CODCAMPOCUSTOMMASTER", referencedColumnName = "CODCAMPOCUSTOMMASTER")
    @ManyToOne
    private Campocustommaster codcampocustommaster;

    public Campocustomvalor() {
    }

    public Campocustomvalor(String codcampocustomvalor) {
        this.codcampocustomvalor = codcampocustomvalor;
    }

    public String getCodcampocustomvalor() {
        return codcampocustomvalor;
    }

    public void setCodcampocustomvalor(String codcampocustomvalor) {
        this.codcampocustomvalor = codcampocustomvalor;
    }

    public String getCodcampocustomlista() {
        return codcampocustomlista;
    }

    public void setCodcampocustomlista(String codcampocustomlista) {
        this.codcampocustomlista = codcampocustomlista;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Campocustommaster getCodcampocustommaster() {
        return codcampocustommaster;
    }

    public void setCodcampocustommaster(Campocustommaster codcampocustommaster) {
        this.codcampocustommaster = codcampocustommaster;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcampocustomvalor != null ? codcampocustomvalor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campocustomvalor)) {
            return false;
        }
        Campocustomvalor other = (Campocustomvalor) object;
        if ((this.codcampocustomvalor == null && other.codcampocustomvalor != null) || (this.codcampocustomvalor != null && !this.codcampocustomvalor.equals(other.codcampocustomvalor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Campocustomvalor[ codcampocustomvalor=" + codcampocustomvalor + " ]";
    }
    
}
