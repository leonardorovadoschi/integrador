/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CARTACORRECAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartacorrecao.findAll", query = "SELECT c FROM Cartacorrecao c")
    , @NamedQuery(name = "Cartacorrecao.findByCodcartacorrecao", query = "SELECT c FROM Cartacorrecao c WHERE c.codcartacorrecao = :codcartacorrecao")
    , @NamedQuery(name = "Cartacorrecao.findByNumnota", query = "SELECT c FROM Cartacorrecao c WHERE c.numnota = :numnota")
    , @NamedQuery(name = "Cartacorrecao.findBySerienota", query = "SELECT c FROM Cartacorrecao c WHERE c.serienota = :serienota")
    , @NamedQuery(name = "Cartacorrecao.findByFlagforncli", query = "SELECT c FROM Cartacorrecao c WHERE c.flagforncli = :flagforncli")
    , @NamedQuery(name = "Cartacorrecao.findByCodcli", query = "SELECT c FROM Cartacorrecao c WHERE c.codcli = :codcli")
    , @NamedQuery(name = "Cartacorrecao.findByCodforn", query = "SELECT c FROM Cartacorrecao c WHERE c.codforn = :codforn")
    , @NamedQuery(name = "Cartacorrecao.findByDatadocumento", query = "SELECT c FROM Cartacorrecao c WHERE c.datadocumento = :datadocumento")
    , @NamedQuery(name = "Cartacorrecao.findByData", query = "SELECT c FROM Cartacorrecao c WHERE c.data = :data")
    , @NamedQuery(name = "Cartacorrecao.findByCodempresa", query = "SELECT c FROM Cartacorrecao c WHERE c.codempresa = :codempresa")
    , @NamedQuery(name = "Cartacorrecao.findByCoddocumento", query = "SELECT c FROM Cartacorrecao c WHERE c.coddocumento = :coddocumento")})
public class Cartacorrecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARTACORRECAO")
    private String codcartacorrecao;
    @Column(name = "NUMNOTA")
    private Integer numnota;
    @Column(name = "SERIENOTA")
    private String serienota;
    @Column(name = "FLAGFORNCLI")
    private Character flagforncli;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "CODFORN")
    private String codforn;
    @Column(name = "DATADOCUMENTO")
    @Temporal(TemporalType.DATE)
    private Date datadocumento;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODDOCUMENTO")
    private String coddocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartacorrecao")
    private Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollection;

    public Cartacorrecao() {
    }

    public Cartacorrecao(String codcartacorrecao) {
        this.codcartacorrecao = codcartacorrecao;
    }

    public String getCodcartacorrecao() {
        return codcartacorrecao;
    }

    public void setCodcartacorrecao(String codcartacorrecao) {
        this.codcartacorrecao = codcartacorrecao;
    }

    public Integer getNumnota() {
        return numnota;
    }

    public void setNumnota(Integer numnota) {
        this.numnota = numnota;
    }

    public String getSerienota() {
        return serienota;
    }

    public void setSerienota(String serienota) {
        this.serienota = serienota;
    }

    public Character getFlagforncli() {
        return flagforncli;
    }

    public void setFlagforncli(Character flagforncli) {
        this.flagforncli = flagforncli;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public String getCodforn() {
        return codforn;
    }

    public void setCodforn(String codforn) {
        this.codforn = codforn;
    }

    public Date getDatadocumento() {
        return datadocumento;
    }

    public void setDatadocumento(Date datadocumento) {
        this.datadocumento = datadocumento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(String coddocumento) {
        this.coddocumento = coddocumento;
    }

    @XmlTransient
    public Collection<Cartacorrecaoretificacao> getCartacorrecaoretificacaoCollection() {
        return cartacorrecaoretificacaoCollection;
    }

    public void setCartacorrecaoretificacaoCollection(Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollection) {
        this.cartacorrecaoretificacaoCollection = cartacorrecaoretificacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcartacorrecao != null ? codcartacorrecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartacorrecao)) {
            return false;
        }
        Cartacorrecao other = (Cartacorrecao) object;
        if ((this.codcartacorrecao == null && other.codcartacorrecao != null) || (this.codcartacorrecao != null && !this.codcartacorrecao.equals(other.codcartacorrecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cartacorrecao[ codcartacorrecao=" + codcartacorrecao + " ]";
    }
    
}
