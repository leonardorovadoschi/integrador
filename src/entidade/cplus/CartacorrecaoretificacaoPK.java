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
public class CartacorrecaoretificacaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODCARTACORRECAO")
    private String codcartacorrecao;
    @Basic(optional = false)
    @Column(name = "CODCARTACORRECAOESPECIFICACAO")
    private String codcartacorrecaoespecificacao;

    public CartacorrecaoretificacaoPK() {
    }

    public CartacorrecaoretificacaoPK(String codcartacorrecao, String codcartacorrecaoespecificacao) {
        this.codcartacorrecao = codcartacorrecao;
        this.codcartacorrecaoespecificacao = codcartacorrecaoespecificacao;
    }

    public String getCodcartacorrecao() {
        return codcartacorrecao;
    }

    public void setCodcartacorrecao(String codcartacorrecao) {
        this.codcartacorrecao = codcartacorrecao;
    }

    public String getCodcartacorrecaoespecificacao() {
        return codcartacorrecaoespecificacao;
    }

    public void setCodcartacorrecaoespecificacao(String codcartacorrecaoespecificacao) {
        this.codcartacorrecaoespecificacao = codcartacorrecaoespecificacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcartacorrecao != null ? codcartacorrecao.hashCode() : 0);
        hash += (codcartacorrecaoespecificacao != null ? codcartacorrecaoespecificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartacorrecaoretificacaoPK)) {
            return false;
        }
        CartacorrecaoretificacaoPK other = (CartacorrecaoretificacaoPK) object;
        if ((this.codcartacorrecao == null && other.codcartacorrecao != null) || (this.codcartacorrecao != null && !this.codcartacorrecao.equals(other.codcartacorrecao))) {
            return false;
        }
        if ((this.codcartacorrecaoespecificacao == null && other.codcartacorrecaoespecificacao != null) || (this.codcartacorrecaoespecificacao != null && !this.codcartacorrecaoespecificacao.equals(other.codcartacorrecaoespecificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.CartacorrecaoretificacaoPK[ codcartacorrecao=" + codcartacorrecao + ", codcartacorrecaoespecificacao=" + codcartacorrecaoespecificacao + " ]";
    }
    
}
