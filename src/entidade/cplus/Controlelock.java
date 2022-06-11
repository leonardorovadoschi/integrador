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
@Table(name = "CONTROLELOCK", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controlelock.findAll", query = "SELECT c FROM Controlelock c")
    , @NamedQuery(name = "Controlelock.findByNomeentidade", query = "SELECT c FROM Controlelock c WHERE c.controlelockPK.nomeentidade = :nomeentidade")
    , @NamedQuery(name = "Controlelock.findByIdentidade", query = "SELECT c FROM Controlelock c WHERE c.controlelockPK.identidade = :identidade")
    , @NamedQuery(name = "Controlelock.findByIdconexao", query = "SELECT c FROM Controlelock c WHERE c.idconexao = :idconexao")})
public class Controlelock implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ControlelockPK controlelockPK;
    @Column(name = "IDCONEXAO")
    private Integer idconexao;

    public Controlelock() {
    }

    public Controlelock(ControlelockPK controlelockPK) {
        this.controlelockPK = controlelockPK;
    }

    public Controlelock(String nomeentidade, String identidade) {
        this.controlelockPK = new ControlelockPK(nomeentidade, identidade);
    }

    public ControlelockPK getControlelockPK() {
        return controlelockPK;
    }

    public void setControlelockPK(ControlelockPK controlelockPK) {
        this.controlelockPK = controlelockPK;
    }

    public Integer getIdconexao() {
        return idconexao;
    }

    public void setIdconexao(Integer idconexao) {
        this.idconexao = idconexao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlelockPK != null ? controlelockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controlelock)) {
            return false;
        }
        Controlelock other = (Controlelock) object;
        if ((this.controlelockPK == null && other.controlelockPK != null) || (this.controlelockPK != null && !this.controlelockPK.equals(other.controlelockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Controlelock[ controlelockPK=" + controlelockPK + " ]";
    }
    
}
