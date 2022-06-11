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
@Table(name = "TIPOGRADEDETALHE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipogradedetalhe.findAll", query = "SELECT t FROM Tipogradedetalhe t")
    , @NamedQuery(name = "Tipogradedetalhe.findByCodgradedetalhe", query = "SELECT t FROM Tipogradedetalhe t WHERE t.codgradedetalhe = :codgradedetalhe")
    , @NamedQuery(name = "Tipogradedetalhe.findByCodgrade", query = "SELECT t FROM Tipogradedetalhe t WHERE t.codgrade = :codgrade")
    , @NamedQuery(name = "Tipogradedetalhe.findByDescricao", query = "SELECT t FROM Tipogradedetalhe t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "Tipogradedetalhe.findBySigla", query = "SELECT t FROM Tipogradedetalhe t WHERE t.sigla = :sigla")
    , @NamedQuery(name = "Tipogradedetalhe.findByPosicao", query = "SELECT t FROM Tipogradedetalhe t WHERE t.posicao = :posicao")})
public class Tipogradedetalhe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODGRADEDETALHE")
    private String codgradedetalhe;
    @Column(name = "CODGRADE")
    private String codgrade;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "SIGLA")
    private String sigla;
    @Column(name = "POSICAO")
    private Integer posicao;

    public Tipogradedetalhe() {
    }

    public Tipogradedetalhe(String codgradedetalhe) {
        this.codgradedetalhe = codgradedetalhe;
    }

    public String getCodgradedetalhe() {
        return codgradedetalhe;
    }

    public void setCodgradedetalhe(String codgradedetalhe) {
        this.codgradedetalhe = codgradedetalhe;
    }

    public String getCodgrade() {
        return codgrade;
    }

    public void setCodgrade(String codgrade) {
        this.codgrade = codgrade;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codgradedetalhe != null ? codgradedetalhe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipogradedetalhe)) {
            return false;
        }
        Tipogradedetalhe other = (Tipogradedetalhe) object;
        if ((this.codgradedetalhe == null && other.codgradedetalhe != null) || (this.codgradedetalhe != null && !this.codgradedetalhe.equals(other.codgradedetalhe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Tipogradedetalhe[ codgradedetalhe=" + codgradedetalhe + " ]";
    }
    
}
