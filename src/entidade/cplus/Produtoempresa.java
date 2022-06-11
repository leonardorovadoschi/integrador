/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
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
@Table(name = "PRODUTOEMPRESA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtoempresa.findAll", query = "SELECT p FROM Produtoempresa p")
    , @NamedQuery(name = "Produtoempresa.findByCodprodutoempresa", query = "SELECT p FROM Produtoempresa p WHERE p.codprodutoempresa = :codprodutoempresa")
    , @NamedQuery(name = "Produtoempresa.findByClassificacaoabc", query = "SELECT p FROM Produtoempresa p WHERE p.classificacaoabc = :classificacaoabc")
    , @NamedQuery(name = "Produtoempresa.findByRankingabc", query = "SELECT p FROM Produtoempresa p WHERE p.rankingabc = :rankingabc")})
public class Produtoempresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPRODUTOEMPRESA")
    private String codprodutoempresa;
    @Column(name = "CLASSIFICACAOABC")
    private Character classificacaoabc;
    @Column(name = "RANKINGABC")
    private Integer rankingabc;

    public Produtoempresa() {
    }

    public Produtoempresa(String codprodutoempresa) {
        this.codprodutoempresa = codprodutoempresa;
    }

    public String getCodprodutoempresa() {
        return codprodutoempresa;
    }

    public void setCodprodutoempresa(String codprodutoempresa) {
        this.codprodutoempresa = codprodutoempresa;
    }

    public Character getClassificacaoabc() {
        return classificacaoabc;
    }

    public void setClassificacaoabc(Character classificacaoabc) {
        this.classificacaoabc = classificacaoabc;
    }

    public Integer getRankingabc() {
        return rankingabc;
    }

    public void setRankingabc(Integer rankingabc) {
        this.rankingabc = rankingabc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprodutoempresa != null ? codprodutoempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtoempresa)) {
            return false;
        }
        Produtoempresa other = (Produtoempresa) object;
        if ((this.codprodutoempresa == null && other.codprodutoempresa != null) || (this.codprodutoempresa != null && !this.codprodutoempresa.equals(other.codprodutoempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Produtoempresa[ codprodutoempresa=" + codprodutoempresa + " ]";
    }
    
}
