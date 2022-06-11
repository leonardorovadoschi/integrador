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
@Table(name = "TMP_SPED_UNIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedUnidade.findAll", query = "SELECT t FROM TmpSpedUnidade t")
    , @NamedQuery(name = "TmpSpedUnidade.findByUnidade", query = "SELECT t FROM TmpSpedUnidade t WHERE t.unidade = :unidade")
    , @NamedQuery(name = "TmpSpedUnidade.findByDescricao", query = "SELECT t FROM TmpSpedUnidade t WHERE t.descricao = :descricao")})
public class TmpSpedUnidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UNIDADE")
    private String unidade;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public TmpSpedUnidade() {
    }

    public TmpSpedUnidade(String unidade) {
        this.unidade = unidade;
    }

    public TmpSpedUnidade(String unidade, String descricao) {
        this.unidade = unidade;
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidade != null ? unidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedUnidade)) {
            return false;
        }
        TmpSpedUnidade other = (TmpSpedUnidade) object;
        if ((this.unidade == null && other.unidade != null) || (this.unidade != null && !this.unidade.equals(other.unidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedUnidade[ unidade=" + unidade + " ]";
    }
    
}
