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
@Table(name = "SITUACAOADMINISTRATIVA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Situacaoadministrativa.findAll", query = "SELECT s FROM Situacaoadministrativa s")
    , @NamedQuery(name = "Situacaoadministrativa.findByCodsituacaoadministrativa", query = "SELECT s FROM Situacaoadministrativa s WHERE s.codsituacaoadministrativa = :codsituacaoadministrativa")
    , @NamedQuery(name = "Situacaoadministrativa.findByCodigo", query = "SELECT s FROM Situacaoadministrativa s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Situacaoadministrativa.findByNomesituacaoadministrativa", query = "SELECT s FROM Situacaoadministrativa s WHERE s.nomesituacaoadministrativa = :nomesituacaoadministrativa")
    , @NamedQuery(name = "Situacaoadministrativa.findByFlagnaoentranacobranca", query = "SELECT s FROM Situacaoadministrativa s WHERE s.flagnaoentranacobranca = :flagnaoentranacobranca")
    , @NamedQuery(name = "Situacaoadministrativa.findByCor", query = "SELECT s FROM Situacaoadministrativa s WHERE s.cor = :cor")})
public class Situacaoadministrativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODSITUACAOADMINISTRATIVA")
    private String codsituacaoadministrativa;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMESITUACAOADMINISTRATIVA")
    private String nomesituacaoadministrativa;
    @Column(name = "FLAGNAOENTRANACOBRANCA")
    private Character flagnaoentranacobranca;
    @Column(name = "COR")
    private Integer cor;
    @OneToMany(mappedBy = "codsituacaoadministrativa")
    private Collection<Contapagar> contapagarCollection;
    @OneToMany(mappedBy = "codsituacaoadministrativa")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "codsituacaoadministrativa")
    private Collection<Contareceber> contareceberCollection;

    public Situacaoadministrativa() {
    }

    public Situacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public Situacaoadministrativa(String codsituacaoadministrativa, String codigo) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
        this.codigo = codigo;
    }

    public String getCodsituacaoadministrativa() {
        return codsituacaoadministrativa;
    }

    public void setCodsituacaoadministrativa(String codsituacaoadministrativa) {
        this.codsituacaoadministrativa = codsituacaoadministrativa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomesituacaoadministrativa() {
        return nomesituacaoadministrativa;
    }

    public void setNomesituacaoadministrativa(String nomesituacaoadministrativa) {
        this.nomesituacaoadministrativa = nomesituacaoadministrativa;
    }

    public Character getFlagnaoentranacobranca() {
        return flagnaoentranacobranca;
    }

    public void setFlagnaoentranacobranca(Character flagnaoentranacobranca) {
        this.flagnaoentranacobranca = flagnaoentranacobranca;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    @XmlTransient
    public Collection<Contapagar> getContapagarCollection() {
        return contapagarCollection;
    }

    public void setContapagarCollection(Collection<Contapagar> contapagarCollection) {
        this.contapagarCollection = contapagarCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Contareceber> getContareceberCollection() {
        return contareceberCollection;
    }

    public void setContareceberCollection(Collection<Contareceber> contareceberCollection) {
        this.contareceberCollection = contareceberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsituacaoadministrativa != null ? codsituacaoadministrativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Situacaoadministrativa)) {
            return false;
        }
        Situacaoadministrativa other = (Situacaoadministrativa) object;
        if ((this.codsituacaoadministrativa == null && other.codsituacaoadministrativa != null) || (this.codsituacaoadministrativa != null && !this.codsituacaoadministrativa.equals(other.codsituacaoadministrativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Situacaoadministrativa[ codsituacaoadministrativa=" + codsituacaoadministrativa + " ]";
    }
    
}
