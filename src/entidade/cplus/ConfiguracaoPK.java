/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class ConfiguracaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NOMESECAO")
    private String nomesecao;
    @Basic(optional = false)
    @Column(name = "NOMECONFIGURACAO")
    private String nomeconfiguracao;

    public ConfiguracaoPK() {
    }

    public ConfiguracaoPK(String nomesecao, String nomeconfiguracao) {
        this.nomesecao = nomesecao;
        this.nomeconfiguracao = nomeconfiguracao;
    }

    public String getNomesecao() {
        return nomesecao;
    }

    public void setNomesecao(String nomesecao) {
        this.nomesecao = nomesecao;
    }

    public String getNomeconfiguracao() {
        return nomeconfiguracao;
    }

    public void setNomeconfiguracao(String nomeconfiguracao) {
        this.nomeconfiguracao = nomeconfiguracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomesecao != null ? nomesecao.hashCode() : 0);
        hash += (nomeconfiguracao != null ? nomeconfiguracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracaoPK)) {
            return false;
        }
        ConfiguracaoPK other = (ConfiguracaoPK) object;
        if ((this.nomesecao == null && other.nomesecao != null) || (this.nomesecao != null && !this.nomesecao.equals(other.nomesecao))) {
            return false;
        }
        if ((this.nomeconfiguracao == null && other.nomeconfiguracao != null) || (this.nomeconfiguracao != null && !this.nomeconfiguracao.equals(other.nomeconfiguracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.ConfiguracaoPK[ nomesecao=" + nomesecao + ", nomeconfiguracao=" + nomeconfiguracao + " ]";
    }
    
}
