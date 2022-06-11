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
@Table(name = "BANCOOCORRENCIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancoocorrencia.findAll", query = "SELECT b FROM Bancoocorrencia b")
    , @NamedQuery(name = "Bancoocorrencia.findByCodbancoocorrencia", query = "SELECT b FROM Bancoocorrencia b WHERE b.codbancoocorrencia = :codbancoocorrencia")
    , @NamedQuery(name = "Bancoocorrencia.findByCodigoocorrencia", query = "SELECT b FROM Bancoocorrencia b WHERE b.codigoocorrencia = :codigoocorrencia")
    , @NamedQuery(name = "Bancoocorrencia.findByCodbanco", query = "SELECT b FROM Bancoocorrencia b WHERE b.codbanco = :codbanco")
    , @NamedQuery(name = "Bancoocorrencia.findByDescricaoocorrencia", query = "SELECT b FROM Bancoocorrencia b WHERE b.descricaoocorrencia = :descricaoocorrencia")
    , @NamedQuery(name = "Bancoocorrencia.findByFlagquitarconta", query = "SELECT b FROM Bancoocorrencia b WHERE b.flagquitarconta = :flagquitarconta")
    , @NamedQuery(name = "Bancoocorrencia.findByFlagatualizanossonumero", query = "SELECT b FROM Bancoocorrencia b WHERE b.flagatualizanossonumero = :flagatualizanossonumero")
    , @NamedQuery(name = "Bancoocorrencia.findByFlagatualizadataconfirmacao", query = "SELECT b FROM Bancoocorrencia b WHERE b.flagatualizadataconfirmacao = :flagatualizadataconfirmacao")})
public class Bancoocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBANCOOCORRENCIA")
    private String codbancoocorrencia;
    @Column(name = "CODIGOOCORRENCIA")
    private String codigoocorrencia;
    @Column(name = "CODBANCO")
    private String codbanco;
    @Column(name = "DESCRICAOOCORRENCIA")
    private String descricaoocorrencia;
    @Column(name = "FLAGQUITARCONTA")
    private Character flagquitarconta;
    @Column(name = "FLAGATUALIZANOSSONUMERO")
    private Character flagatualizanossonumero;
    @Column(name = "FLAGATUALIZADATACONFIRMACAO")
    private Character flagatualizadataconfirmacao;
    @OneToMany(mappedBy = "codbancoocorrencia")
    private Collection<Contareceberrec> contareceberrecCollection;
    @OneToMany(mappedBy = "codbancoocorrencia")
    private Collection<Bancoocorrenciamotivo> bancoocorrenciamotivoCollection;

    public Bancoocorrencia() {
    }

    public Bancoocorrencia(String codbancoocorrencia) {
        this.codbancoocorrencia = codbancoocorrencia;
    }

    public String getCodbancoocorrencia() {
        return codbancoocorrencia;
    }

    public void setCodbancoocorrencia(String codbancoocorrencia) {
        this.codbancoocorrencia = codbancoocorrencia;
    }

    public String getCodigoocorrencia() {
        return codigoocorrencia;
    }

    public void setCodigoocorrencia(String codigoocorrencia) {
        this.codigoocorrencia = codigoocorrencia;
    }

    public String getCodbanco() {
        return codbanco;
    }

    public void setCodbanco(String codbanco) {
        this.codbanco = codbanco;
    }

    public String getDescricaoocorrencia() {
        return descricaoocorrencia;
    }

    public void setDescricaoocorrencia(String descricaoocorrencia) {
        this.descricaoocorrencia = descricaoocorrencia;
    }

    public Character getFlagquitarconta() {
        return flagquitarconta;
    }

    public void setFlagquitarconta(Character flagquitarconta) {
        this.flagquitarconta = flagquitarconta;
    }

    public Character getFlagatualizanossonumero() {
        return flagatualizanossonumero;
    }

    public void setFlagatualizanossonumero(Character flagatualizanossonumero) {
        this.flagatualizanossonumero = flagatualizanossonumero;
    }

    public Character getFlagatualizadataconfirmacao() {
        return flagatualizadataconfirmacao;
    }

    public void setFlagatualizadataconfirmacao(Character flagatualizadataconfirmacao) {
        this.flagatualizadataconfirmacao = flagatualizadataconfirmacao;
    }

    @XmlTransient
    public Collection<Contareceberrec> getContareceberrecCollection() {
        return contareceberrecCollection;
    }

    public void setContareceberrecCollection(Collection<Contareceberrec> contareceberrecCollection) {
        this.contareceberrecCollection = contareceberrecCollection;
    }

    @XmlTransient
    public Collection<Bancoocorrenciamotivo> getBancoocorrenciamotivoCollection() {
        return bancoocorrenciamotivoCollection;
    }

    public void setBancoocorrenciamotivoCollection(Collection<Bancoocorrenciamotivo> bancoocorrenciamotivoCollection) {
        this.bancoocorrenciamotivoCollection = bancoocorrenciamotivoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbancoocorrencia != null ? codbancoocorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancoocorrencia)) {
            return false;
        }
        Bancoocorrencia other = (Bancoocorrencia) object;
        if ((this.codbancoocorrencia == null && other.codbancoocorrencia != null) || (this.codbancoocorrencia != null && !this.codbancoocorrencia.equals(other.codbancoocorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Bancoocorrencia[ codbancoocorrencia=" + codbancoocorrencia + " ]";
    }
    
}
