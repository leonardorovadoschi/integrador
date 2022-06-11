/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "RELATORIOCAMPO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriocampo.findAll", query = "SELECT r FROM Relatoriocampo r")
    , @NamedQuery(name = "Relatoriocampo.findByNometabela", query = "SELECT r FROM Relatoriocampo r WHERE r.relatoriocampoPK.nometabela = :nometabela")
    , @NamedQuery(name = "Relatoriocampo.findByNomecampo", query = "SELECT r FROM Relatoriocampo r WHERE r.relatoriocampoPK.nomecampo = :nomecampo")
    , @NamedQuery(name = "Relatoriocampo.findByApelidocampo", query = "SELECT r FROM Relatoriocampo r WHERE r.apelidocampo = :apelidocampo")
    , @NamedQuery(name = "Relatoriocampo.findByTipo", query = "SELECT r FROM Relatoriocampo r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "Relatoriocampo.findByFlagpodeselecionar", query = "SELECT r FROM Relatoriocampo r WHERE r.flagpodeselecionar = :flagpodeselecionar")
    , @NamedQuery(name = "Relatoriocampo.findByFlagpodepesquisar", query = "SELECT r FROM Relatoriocampo r WHERE r.flagpodepesquisar = :flagpodepesquisar")
    , @NamedQuery(name = "Relatoriocampo.findByFlagpodeordenar", query = "SELECT r FROM Relatoriocampo r WHERE r.flagpodeordenar = :flagpodeordenar")
    , @NamedQuery(name = "Relatoriocampo.findByFlagautopesquisa", query = "SELECT r FROM Relatoriocampo r WHERE r.flagautopesquisa = :flagautopesquisa")
    , @NamedQuery(name = "Relatoriocampo.findByFlagobrigatorio", query = "SELECT r FROM Relatoriocampo r WHERE r.flagobrigatorio = :flagobrigatorio")})
public class Relatoriocampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelatoriocampoPK relatoriocampoPK;
    @Column(name = "APELIDOCAMPO")
    private String apelidocampo;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "FLAGPODESELECIONAR")
    private Character flagpodeselecionar;
    @Column(name = "FLAGPODEPESQUISAR")
    private Character flagpodepesquisar;
    @Column(name = "FLAGPODEORDENAR")
    private Character flagpodeordenar;
    @Column(name = "FLAGAUTOPESQUISA")
    private Character flagautopesquisa;
    @Column(name = "FLAGOBRIGATORIO")
    private Character flagobrigatorio;

    public Relatoriocampo() {
    }

    public Relatoriocampo(RelatoriocampoPK relatoriocampoPK) {
        this.relatoriocampoPK = relatoriocampoPK;
    }

    public Relatoriocampo(String nometabela, String nomecampo) {
        this.relatoriocampoPK = new RelatoriocampoPK(nometabela, nomecampo);
    }

    public RelatoriocampoPK getRelatoriocampoPK() {
        return relatoriocampoPK;
    }

    public void setRelatoriocampoPK(RelatoriocampoPK relatoriocampoPK) {
        this.relatoriocampoPK = relatoriocampoPK;
    }

    public String getApelidocampo() {
        return apelidocampo;
    }

    public void setApelidocampo(String apelidocampo) {
        this.apelidocampo = apelidocampo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Character getFlagpodeselecionar() {
        return flagpodeselecionar;
    }

    public void setFlagpodeselecionar(Character flagpodeselecionar) {
        this.flagpodeselecionar = flagpodeselecionar;
    }

    public Character getFlagpodepesquisar() {
        return flagpodepesquisar;
    }

    public void setFlagpodepesquisar(Character flagpodepesquisar) {
        this.flagpodepesquisar = flagpodepesquisar;
    }

    public Character getFlagpodeordenar() {
        return flagpodeordenar;
    }

    public void setFlagpodeordenar(Character flagpodeordenar) {
        this.flagpodeordenar = flagpodeordenar;
    }

    public Character getFlagautopesquisa() {
        return flagautopesquisa;
    }

    public void setFlagautopesquisa(Character flagautopesquisa) {
        this.flagautopesquisa = flagautopesquisa;
    }

    public Character getFlagobrigatorio() {
        return flagobrigatorio;
    }

    public void setFlagobrigatorio(Character flagobrigatorio) {
        this.flagobrigatorio = flagobrigatorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatoriocampoPK != null ? relatoriocampoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriocampo)) {
            return false;
        }
        Relatoriocampo other = (Relatoriocampo) object;
        if ((this.relatoriocampoPK == null && other.relatoriocampoPK != null) || (this.relatoriocampoPK != null && !this.relatoriocampoPK.equals(other.relatoriocampoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatoriocampo[ relatoriocampoPK=" + relatoriocampoPK + " ]";
    }
    
}
