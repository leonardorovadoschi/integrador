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
@Table(name = "TIPOESPECIALIZACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoespecializacao.findAll", query = "SELECT t FROM Tipoespecializacao t")
    , @NamedQuery(name = "Tipoespecializacao.findByCodtipoespecializacao", query = "SELECT t FROM Tipoespecializacao t WHERE t.codtipoespecializacao = :codtipoespecializacao")
    , @NamedQuery(name = "Tipoespecializacao.findByCodigo", query = "SELECT t FROM Tipoespecializacao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoespecializacao.findByNometipoespecializacao", query = "SELECT t FROM Tipoespecializacao t WHERE t.nometipoespecializacao = :nometipoespecializacao")
    , @NamedQuery(name = "Tipoespecializacao.findByPontuacao", query = "SELECT t FROM Tipoespecializacao t WHERE t.pontuacao = :pontuacao")
    , @NamedQuery(name = "Tipoespecializacao.findByFlagativo", query = "SELECT t FROM Tipoespecializacao t WHERE t.flagativo = :flagativo")})
public class Tipoespecializacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTIPOESPECIALIZACAO")
    private String codtipoespecializacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMETIPOESPECIALIZACAO")
    private String nometipoespecializacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PONTUACAO")
    private BigDecimal pontuacao;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @OneToMany(mappedBy = "codtipoespecializacao")
    private Collection<Especializacao> especializacaoCollection;

    public Tipoespecializacao() {
    }

    public Tipoespecializacao(String codtipoespecializacao) {
        this.codtipoespecializacao = codtipoespecializacao;
    }

    public String getCodtipoespecializacao() {
        return codtipoespecializacao;
    }

    public void setCodtipoespecializacao(String codtipoespecializacao) {
        this.codtipoespecializacao = codtipoespecializacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNometipoespecializacao() {
        return nometipoespecializacao;
    }

    public void setNometipoespecializacao(String nometipoespecializacao) {
        this.nometipoespecializacao = nometipoespecializacao;
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
    public Collection<Especializacao> getEspecializacaoCollection() {
        return especializacaoCollection;
    }

    public void setEspecializacaoCollection(Collection<Especializacao> especializacaoCollection) {
        this.especializacaoCollection = especializacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtipoespecializacao != null ? codtipoespecializacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoespecializacao)) {
            return false;
        }
        Tipoespecializacao other = (Tipoespecializacao) object;
        if ((this.codtipoespecializacao == null && other.codtipoespecializacao != null) || (this.codtipoespecializacao != null && !this.codtipoespecializacao.equals(other.codtipoespecializacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipoespecializacao[ codtipoespecializacao=" + codtipoespecializacao + " ]";
    }
    
}
