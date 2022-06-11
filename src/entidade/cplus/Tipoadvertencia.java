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
@Table(name = "TIPOADVERTENCIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoadvertencia.findAll", query = "SELECT t FROM Tipoadvertencia t")
    , @NamedQuery(name = "Tipoadvertencia.findByCodtipoadvertencia", query = "SELECT t FROM Tipoadvertencia t WHERE t.codtipoadvertencia = :codtipoadvertencia")
    , @NamedQuery(name = "Tipoadvertencia.findByCodigo", query = "SELECT t FROM Tipoadvertencia t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoadvertencia.findByDesctipoadvertencia", query = "SELECT t FROM Tipoadvertencia t WHERE t.desctipoadvertencia = :desctipoadvertencia")
    , @NamedQuery(name = "Tipoadvertencia.findByPontuacao", query = "SELECT t FROM Tipoadvertencia t WHERE t.pontuacao = :pontuacao")
    , @NamedQuery(name = "Tipoadvertencia.findByFlagativo", query = "SELECT t FROM Tipoadvertencia t WHERE t.flagativo = :flagativo")})
public class Tipoadvertencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOADVERTENCIA")
    private String codtipoadvertencia;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCTIPOADVERTENCIA")
    private String desctipoadvertencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PONTUACAO")
    private BigDecimal pontuacao;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @OneToMany(mappedBy = "codtipoadvertencia")
    private Collection<Advertencia> advertenciaCollection;

    public Tipoadvertencia() {
    }

    public Tipoadvertencia(String codtipoadvertencia) {
        this.codtipoadvertencia = codtipoadvertencia;
    }

    public String getCodtipoadvertencia() {
        return codtipoadvertencia;
    }

    public void setCodtipoadvertencia(String codtipoadvertencia) {
        this.codtipoadvertencia = codtipoadvertencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDesctipoadvertencia() {
        return desctipoadvertencia;
    }

    public void setDesctipoadvertencia(String desctipoadvertencia) {
        this.desctipoadvertencia = desctipoadvertencia;
    }

    public BigDecimal getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(BigDecimal pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    @XmlTransient
    public Collection<Advertencia> getAdvertenciaCollection() {
        return advertenciaCollection;
    }

    public void setAdvertenciaCollection(Collection<Advertencia> advertenciaCollection) {
        this.advertenciaCollection = advertenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoadvertencia != null ? codtipoadvertencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoadvertencia)) {
            return false;
        }
        Tipoadvertencia other = (Tipoadvertencia) object;
        if ((this.codtipoadvertencia == null && other.codtipoadvertencia != null) || (this.codtipoadvertencia != null && !this.codtipoadvertencia.equals(other.codtipoadvertencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipoadvertencia[ codtipoadvertencia=" + codtipoadvertencia + " ]";
    }
    
}
