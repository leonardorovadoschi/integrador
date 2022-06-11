/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PRODUTOFAIXACOMISSAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtofaixacomissao.findAll", query = "SELECT p FROM Produtofaixacomissao p")
    , @NamedQuery(name = "Produtofaixacomissao.findByCodprodutofaixacomissao", query = "SELECT p FROM Produtofaixacomissao p WHERE p.codprodutofaixacomissao = :codprodutofaixacomissao")
    , @NamedQuery(name = "Produtofaixacomissao.findByValorinicial", query = "SELECT p FROM Produtofaixacomissao p WHERE p.valorinicial = :valorinicial")
    , @NamedQuery(name = "Produtofaixacomissao.findByValorfinal", query = "SELECT p FROM Produtofaixacomissao p WHERE p.valorfinal = :valorfinal")
    , @NamedQuery(name = "Produtofaixacomissao.findByComissao", query = "SELECT p FROM Produtofaixacomissao p WHERE p.comissao = :comissao")})
public class Produtofaixacomissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOFAIXACOMISSAO")
    private String codprodutofaixacomissao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORINICIAL")
    private BigDecimal valorinicial;
    @Column(name = "VALORFINAL")
    private BigDecimal valorfinal;
    @Column(name = "COMISSAO")
    private BigDecimal comissao;

    public Produtofaixacomissao() {
    }

    public Produtofaixacomissao(String codprodutofaixacomissao) {
        this.codprodutofaixacomissao = codprodutofaixacomissao;
    }

    public String getCodprodutofaixacomissao() {
        return codprodutofaixacomissao;
    }

    public void setCodprodutofaixacomissao(String codprodutofaixacomissao) {
        this.codprodutofaixacomissao = codprodutofaixacomissao;
    }

    public BigDecimal getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(BigDecimal valorinicial) {
        this.valorinicial = valorinicial;
    }

    public BigDecimal getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(BigDecimal valorfinal) {
        this.valorfinal = valorfinal;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutofaixacomissao != null ? codprodutofaixacomissao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtofaixacomissao)) {
            return false;
        }
        Produtofaixacomissao other = (Produtofaixacomissao) object;
        if ((this.codprodutofaixacomissao == null && other.codprodutofaixacomissao != null) || (this.codprodutofaixacomissao != null && !this.codprodutofaixacomissao.equals(other.codprodutofaixacomissao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtofaixacomissao[ codprodutofaixacomissao=" + codprodutofaixacomissao + " ]";
    }
    
}
