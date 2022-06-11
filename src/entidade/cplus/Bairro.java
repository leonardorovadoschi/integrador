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
@Table(name = "BAIRRO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b")
    , @NamedQuery(name = "Bairro.findByCodbairro", query = "SELECT b FROM Bairro b WHERE b.codbairro = :codbairro")
    , @NamedQuery(name = "Bairro.findByCodigo", query = "SELECT b FROM Bairro b WHERE b.codigo = :codigo")
    , @NamedQuery(name = "Bairro.findByNomebairro", query = "SELECT b FROM Bairro b WHERE b.nomebairro = :nomebairro")
    , @NamedQuery(name = "Bairro.findByDnecodbai", query = "SELECT b FROM Bairro b WHERE b.dnecodbai = :dnecodbai")
    , @NamedQuery(name = "Bairro.findByCoduf", query = "SELECT b FROM Bairro b WHERE b.coduf = :coduf")
    , @NamedQuery(name = "Bairro.findByDnecodloc", query = "SELECT b FROM Bairro b WHERE b.dnecodloc = :dnecodloc")
    , @NamedQuery(name = "Bairro.findByBaiNoAbrev", query = "SELECT b FROM Bairro b WHERE b.baiNoAbrev = :baiNoAbrev")})
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBAIRRO")
    private String codbairro;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEBAIRRO")
    private String nomebairro;
    @Column(name = "DNECODBAI")
    private Integer dnecodbai;
    @Column(name = "CODUF")
    private String coduf;
    @Column(name = "DNECODLOC")
    private Integer dnecodloc;
    @Column(name = "BAI_NO_ABREV")
    private String baiNoAbrev;
    @OneToMany(mappedBy = "codbairro")
    private Collection<Cep> cepCollection;

    public Bairro() {
    }

    public Bairro(String codbairro) {
        this.codbairro = codbairro;
    }

    public String getCodbairro() {
        return codbairro;
    }

    public void setCodbairro(String codbairro) {
        this.codbairro = codbairro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomebairro() {
        return nomebairro;
    }

    public void setNomebairro(String nomebairro) {
        this.nomebairro = nomebairro;
    }

    public Integer getDnecodbai() {
        return dnecodbai;
    }

    public void setDnecodbai(Integer dnecodbai) {
        this.dnecodbai = dnecodbai;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public Integer getDnecodloc() {
        return dnecodloc;
    }

    public void setDnecodloc(Integer dnecodloc) {
        this.dnecodloc = dnecodloc;
    }

    public String getBaiNoAbrev() {
        return baiNoAbrev;
    }

    public void setBaiNoAbrev(String baiNoAbrev) {
        this.baiNoAbrev = baiNoAbrev;
    }

    @XmlTransient
    public Collection<Cep> getCepCollection() {
        return cepCollection;
    }

    public void setCepCollection(Collection<Cep> cepCollection) {
        this.cepCollection = cepCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbairro != null ? codbairro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.codbairro == null && other.codbairro != null) || (this.codbairro != null && !this.codbairro.equals(other.codbairro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Bairro[ codbairro=" + codbairro + " ]";
    }
    
}
