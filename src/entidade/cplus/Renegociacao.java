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
@Table(name = "RENEGOCIACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renegociacao.findAll", query = "SELECT r FROM Renegociacao r")
    , @NamedQuery(name = "Renegociacao.findByCodrenegociacao", query = "SELECT r FROM Renegociacao r WHERE r.codrenegociacao = :codrenegociacao")
    , @NamedQuery(name = "Renegociacao.findByCodempresa", query = "SELECT r FROM Renegociacao r WHERE r.codempresa = :codempresa")
    , @NamedQuery(name = "Renegociacao.findByCodcli", query = "SELECT r FROM Renegociacao r WHERE r.codcli = :codcli")
    , @NamedQuery(name = "Renegociacao.findByData", query = "SELECT r FROM Renegociacao r WHERE r.data = :data")
    , @NamedQuery(name = "Renegociacao.findByCoduser", query = "SELECT r FROM Renegociacao r WHERE r.coduser = :coduser")})
public class Renegociacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRENEGOCIACAO")
    private String codrenegociacao;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;
    @Column(name = "CODCLI")
    private String codcli;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "CODUSER")
    private String coduser;
    @OneToMany(mappedBy = "codrenegociacao")
    private Collection<Contareceber> contareceberCollection;

    public Renegociacao() {
    }

    public Renegociacao(String codrenegociacao) {
        this.codrenegociacao = codrenegociacao;
    }

    public String getCodrenegociacao() {
        return codrenegociacao;
    }

    public void setCodrenegociacao(String codrenegociacao) {
        this.codrenegociacao = codrenegociacao;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
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
        hash += (codrenegociacao != null ? codrenegociacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Renegociacao)) {
            return false;
        }
        Renegociacao other = (Renegociacao) object;
        if ((this.codrenegociacao == null && other.codrenegociacao != null) || (this.codrenegociacao != null && !this.codrenegociacao.equals(other.codrenegociacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Renegociacao[ codrenegociacao=" + codrenegociacao + " ]";
    }
    
}
