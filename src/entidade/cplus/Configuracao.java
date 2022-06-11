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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CONFIGURACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracao.findAll", query = "SELECT c FROM Configuracao c")
    , @NamedQuery(name = "Configuracao.findByNomesecao", query = "SELECT c FROM Configuracao c WHERE c.configuracaoPK.nomesecao = :nomesecao")
    , @NamedQuery(name = "Configuracao.findByNomeconfiguracao", query = "SELECT c FROM Configuracao c WHERE c.configuracaoPK.nomeconfiguracao = :nomeconfiguracao")
    , @NamedQuery(name = "Configuracao.findByValorconfiguracao", query = "SELECT c FROM Configuracao c WHERE c.valorconfiguracao = :valorconfiguracao")
    , @NamedQuery(name = "Configuracao.findByFlagaltpaf", query = "SELECT c FROM Configuracao c WHERE c.flagaltpaf = :flagaltpaf")})
public class Configuracao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConfiguracaoPK configuracaoPK;
    @Column(name = "VALORCONFIGURACAO")
    private String valorconfiguracao;
    @Column(name = "FLAGALTPAF")
    private Character flagaltpaf;
    @Lob
    @Column(name = "VALORCONFIGURACAOBLOB")
    private byte[] valorconfiguracaoblob;

    public Configuracao() {
    }

    public Configuracao(ConfiguracaoPK configuracaoPK) {
        this.configuracaoPK = configuracaoPK;
    }

    public Configuracao(String nomesecao, String nomeconfiguracao) {
        this.configuracaoPK = new ConfiguracaoPK(nomesecao, nomeconfiguracao);
    }

    public ConfiguracaoPK getConfiguracaoPK() {
        return configuracaoPK;
    }

    public void setConfiguracaoPK(ConfiguracaoPK configuracaoPK) {
        this.configuracaoPK = configuracaoPK;
    }

    public String getValorconfiguracao() {
        return valorconfiguracao;
    }

    public void setValorconfiguracao(String valorconfiguracao) {
        this.valorconfiguracao = valorconfiguracao;
    }

    public Character getFlagaltpaf() {
        return flagaltpaf;
    }

    public void setFlagaltpaf(Character flagaltpaf) {
        this.flagaltpaf = flagaltpaf;
    }

    public byte[] getValorconfiguracaoblob() {
        return valorconfiguracaoblob;
    }

    public void setValorconfiguracaoblob(byte[] valorconfiguracaoblob) {
        this.valorconfiguracaoblob = valorconfiguracaoblob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracaoPK != null ? configuracaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracao)) {
            return false;
        }
        Configuracao other = (Configuracao) object;
        if ((this.configuracaoPK == null && other.configuracaoPK != null) || (this.configuracaoPK != null && !this.configuracaoPK.equals(other.configuracaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Configuracao[ configuracaoPK=" + configuracaoPK + " ]";
    }
    
}
