/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_PESQUISARESPOSTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsPesquisaresposta.findAll", query = "SELECT o FROM OsPesquisaresposta o")
    , @NamedQuery(name = "OsPesquisaresposta.findByCodpesquisaresposta", query = "SELECT o FROM OsPesquisaresposta o WHERE o.codpesquisaresposta = :codpesquisaresposta")
    , @NamedQuery(name = "OsPesquisaresposta.findByResposta", query = "SELECT o FROM OsPesquisaresposta o WHERE o.resposta = :resposta")})
public class OsPesquisaresposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESQUISARESPOSTA")
    private String codpesquisaresposta;
    @Column(name = "RESPOSTA")
    private String resposta;
    @JoinColumn(name = "CODPESQUISAPERGUNTA", referencedColumnName = "CODPESQUISAPERGUNTA")
    @ManyToOne
    private OsPesquisapergunta codpesquisapergunta;
    @OneToMany(mappedBy = "codpesquisaresposta")
    private Collection<OsPesquisa> osPesquisaCollection;

    public OsPesquisaresposta() {
    }

    public OsPesquisaresposta(String codpesquisaresposta) {
        this.codpesquisaresposta = codpesquisaresposta;
    }

    public String getCodpesquisaresposta() {
        return codpesquisaresposta;
    }

    public void setCodpesquisaresposta(String codpesquisaresposta) {
        this.codpesquisaresposta = codpesquisaresposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public OsPesquisapergunta getCodpesquisapergunta() {
        return codpesquisapergunta;
    }

    public void setCodpesquisapergunta(OsPesquisapergunta codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    @XmlTransient
    public Collection<OsPesquisa> getOsPesquisaCollection() {
        return osPesquisaCollection;
    }

    public void setOsPesquisaCollection(Collection<OsPesquisa> osPesquisaCollection) {
        this.osPesquisaCollection = osPesquisaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpesquisaresposta != null ? codpesquisaresposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsPesquisaresposta)) {
            return false;
        }
        OsPesquisaresposta other = (OsPesquisaresposta) object;
        if ((this.codpesquisaresposta == null && other.codpesquisaresposta != null) || (this.codpesquisaresposta != null && !this.codpesquisaresposta.equals(other.codpesquisaresposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsPesquisaresposta[ codpesquisaresposta=" + codpesquisaresposta + " ]";
    }
    
}
