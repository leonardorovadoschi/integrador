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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CARTACORRECAORETIFICACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartacorrecaoretificacao.findAll", query = "SELECT c FROM Cartacorrecaoretificacao c")
    , @NamedQuery(name = "Cartacorrecaoretificacao.findByCodcartacorrecao", query = "SELECT c FROM Cartacorrecaoretificacao c WHERE c.cartacorrecaoretificacaoPK.codcartacorrecao = :codcartacorrecao")
    , @NamedQuery(name = "Cartacorrecaoretificacao.findByCodcartacorrecaoespecificacao", query = "SELECT c FROM Cartacorrecaoretificacao c WHERE c.cartacorrecaoretificacaoPK.codcartacorrecaoespecificacao = :codcartacorrecaoespecificacao")
    , @NamedQuery(name = "Cartacorrecaoretificacao.findByValor", query = "SELECT c FROM Cartacorrecaoretificacao c WHERE c.valor = :valor")})
public class Cartacorrecaoretificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartacorrecaoretificacaoPK cartacorrecaoretificacaoPK;
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "CODCARTACORRECAO", referencedColumnName = "CODCARTACORRECAO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cartacorrecao cartacorrecao;
    @JoinColumn(name = "CODCARTACORRECAOESPECIFICACAO", referencedColumnName = "CODCARTACORRECAOESPECIFICACAO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cartacorrecaoespecificacao cartacorrecaoespecificacao;

    public Cartacorrecaoretificacao() {
    }

    public Cartacorrecaoretificacao(CartacorrecaoretificacaoPK cartacorrecaoretificacaoPK) {
        this.cartacorrecaoretificacaoPK = cartacorrecaoretificacaoPK;
    }

    public Cartacorrecaoretificacao(String codcartacorrecao, String codcartacorrecaoespecificacao) {
        this.cartacorrecaoretificacaoPK = new CartacorrecaoretificacaoPK(codcartacorrecao, codcartacorrecaoespecificacao);
    }

    public CartacorrecaoretificacaoPK getCartacorrecaoretificacaoPK() {
        return cartacorrecaoretificacaoPK;
    }

    public void setCartacorrecaoretificacaoPK(CartacorrecaoretificacaoPK cartacorrecaoretificacaoPK) {
        this.cartacorrecaoretificacaoPK = cartacorrecaoretificacaoPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Cartacorrecao getCartacorrecao() {
        return cartacorrecao;
    }

    public void setCartacorrecao(Cartacorrecao cartacorrecao) {
        this.cartacorrecao = cartacorrecao;
    }

    public Cartacorrecaoespecificacao getCartacorrecaoespecificacao() {
        return cartacorrecaoespecificacao;
    }

    public void setCartacorrecaoespecificacao(Cartacorrecaoespecificacao cartacorrecaoespecificacao) {
        this.cartacorrecaoespecificacao = cartacorrecaoespecificacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartacorrecaoretificacaoPK != null ? cartacorrecaoretificacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartacorrecaoretificacao)) {
            return false;
        }
        Cartacorrecaoretificacao other = (Cartacorrecaoretificacao) object;
        if ((this.cartacorrecaoretificacaoPK == null && other.cartacorrecaoretificacaoPK != null) || (this.cartacorrecaoretificacaoPK != null && !this.cartacorrecaoretificacaoPK.equals(other.cartacorrecaoretificacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cartacorrecaoretificacao[ cartacorrecaoretificacaoPK=" + cartacorrecaoretificacaoPK + " ]";
    }
    
}
