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
@Table(name = "ITEMGRADEDETALHE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemgradedetalhe.findAll", query = "SELECT i FROM Itemgradedetalhe i")
    , @NamedQuery(name = "Itemgradedetalhe.findByCoditemgradedetalhe", query = "SELECT i FROM Itemgradedetalhe i WHERE i.coditemgradedetalhe = :coditemgradedetalhe")
    , @NamedQuery(name = "Itemgradedetalhe.findByDescricao", query = "SELECT i FROM Itemgradedetalhe i WHERE i.descricao = :descricao")
    , @NamedQuery(name = "Itemgradedetalhe.findBySigla", query = "SELECT i FROM Itemgradedetalhe i WHERE i.sigla = :sigla")
    , @NamedQuery(name = "Itemgradedetalhe.findByPosicao", query = "SELECT i FROM Itemgradedetalhe i WHERE i.posicao = :posicao")})
public class Itemgradedetalhe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODITEMGRADEDETALHE")
    private String coditemgradedetalhe;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "POSICAO")
    private Integer posicao;
    @JoinColumn(name = "CODITEMGRADE", referencedColumnName = "CODITEMGRADE")
    @ManyToOne(optional = false)
    private Itemgrade coditemgrade;

    public Itemgradedetalhe() {
    }

    public Itemgradedetalhe(String coditemgradedetalhe) {
        this.coditemgradedetalhe = coditemgradedetalhe;
    }

    public String getCoditemgradedetalhe() {
        return coditemgradedetalhe;
    }

    public void setCoditemgradedetalhe(String coditemgradedetalhe) {
        this.coditemgradedetalhe = coditemgradedetalhe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    public Itemgrade getCoditemgrade() {
        return coditemgrade;
    }

    public void setCoditemgrade(Itemgrade coditemgrade) {
        this.coditemgrade = coditemgrade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coditemgradedetalhe != null ? coditemgradedetalhe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemgradedetalhe)) {
            return false;
        }
        Itemgradedetalhe other = (Itemgradedetalhe) object;
        if ((this.coditemgradedetalhe == null && other.coditemgradedetalhe != null) || (this.coditemgradedetalhe != null && !this.coditemgradedetalhe.equals(other.coditemgradedetalhe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Itemgradedetalhe[ coditemgradedetalhe=" + coditemgradedetalhe + " ]";
    }
    
}
