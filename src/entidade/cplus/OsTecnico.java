/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OS_TECNICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsTecnico.findAll", query = "SELECT o FROM OsTecnico o")
    , @NamedQuery(name = "OsTecnico.findByCodtec", query = "SELECT o FROM OsTecnico o WHERE o.codtec = :codtec")
    , @NamedQuery(name = "OsTecnico.findByCodigo", query = "SELECT o FROM OsTecnico o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsTecnico.findByTecnico", query = "SELECT o FROM OsTecnico o WHERE o.tecnico = :tecnico")
    , @NamedQuery(name = "OsTecnico.findByComissao", query = "SELECT o FROM OsTecnico o WHERE o.comissao = :comissao")
    , @NamedQuery(name = "OsTecnico.findByValorhora", query = "SELECT o FROM OsTecnico o WHERE o.valorhora = :valorhora")
    , @NamedQuery(name = "OsTecnico.findByFlaginativo", query = "SELECT o FROM OsTecnico o WHERE o.flaginativo = :flaginativo")})
public class OsTecnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTEC")
    private String codtec;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TECNICO")
    private String tecnico;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "VALORHORA")
    private BigDecimal valorhora;
    @Column(name = "FLAGINATIVO")
    private Character flaginativo;
    @OneToMany(mappedBy = "codtecsupervisor")
    private Collection<OsTecnico> osTecnicoCollection;
    @JoinColumn(name = "CODTECSUPERVISOR", referencedColumnName = "CODTEC")
    @ManyToOne
    private OsTecnico codtecsupervisor;
    @JoinColumn(name = "CODVENDED", referencedColumnName = "CODVENDED")
    @ManyToOne
    private Vendedor codvended;
    @OneToMany(mappedBy = "codtec")
    private Collection<OsLaudo> osLaudoCollection;
    @OneToMany(mappedBy = "codtec")
    private Collection<Movendaprod> movendaprodCollection;
    @OneToMany(mappedBy = "codtec")
    private Collection<Orcamentoprod> orcamentoprodCollection;

    public OsTecnico() {
    }

    public OsTecnico(String codtec) {
        this.codtec = codtec;
    }

    public OsTecnico(String codtec, String codigo) {
        this.codtec = codtec;
        this.codigo = codigo;
    }

    public String getCodtec() {
        return codtec;
    }

    public void setCodtec(String codtec) {
        this.codtec = codtec;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public BigDecimal getValorhora() {
        return valorhora;
    }

    public void setValorhora(BigDecimal valorhora) {
        this.valorhora = valorhora;
    }

    public Character getFlaginativo() {
        return flaginativo;
    }

    public void setFlaginativo(Character flaginativo) {
        this.flaginativo = flaginativo;
    }

    @XmlTransient
    public Collection<OsTecnico> getOsTecnicoCollection() {
        return osTecnicoCollection;
    }

    public void setOsTecnicoCollection(Collection<OsTecnico> osTecnicoCollection) {
        this.osTecnicoCollection = osTecnicoCollection;
    }

    public OsTecnico getCodtecsupervisor() {
        return codtecsupervisor;
    }

    public void setCodtecsupervisor(OsTecnico codtecsupervisor) {
        this.codtecsupervisor = codtecsupervisor;
    }

    public Vendedor getCodvended() {
        return codvended;
    }

    public void setCodvended(Vendedor codvended) {
        this.codvended = codvended;
    }

    @XmlTransient
    public Collection<OsLaudo> getOsLaudoCollection() {
        return osLaudoCollection;
    }

    public void setOsLaudoCollection(Collection<OsLaudo> osLaudoCollection) {
        this.osLaudoCollection = osLaudoCollection;
    }

    @XmlTransient
    public Collection<Movendaprod> getMovendaprodCollection() {
        return movendaprodCollection;
    }

    public void setMovendaprodCollection(Collection<Movendaprod> movendaprodCollection) {
        this.movendaprodCollection = movendaprodCollection;
    }

    @XmlTransient
    public Collection<Orcamentoprod> getOrcamentoprodCollection() {
        return orcamentoprodCollection;
    }

    public void setOrcamentoprodCollection(Collection<Orcamentoprod> orcamentoprodCollection) {
        this.orcamentoprodCollection = orcamentoprodCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtec != null ? codtec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsTecnico)) {
            return false;
        }
        OsTecnico other = (OsTecnico) object;
        if ((this.codtec == null && other.codtec != null) || (this.codtec != null && !this.codtec.equals(other.codtec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsTecnico[ codtec=" + codtec + " ]";
    }
    
}
