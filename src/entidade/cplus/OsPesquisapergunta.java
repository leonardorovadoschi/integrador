/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "OS_PESQUISAPERGUNTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsPesquisapergunta.findAll", query = "SELECT o FROM OsPesquisapergunta o")
    , @NamedQuery(name = "OsPesquisapergunta.findByPergunta", query = "SELECT o FROM OsPesquisapergunta o WHERE o.pergunta = :pergunta")
    , @NamedQuery(name = "OsPesquisapergunta.findByCodigo", query = "SELECT o FROM OsPesquisapergunta o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsPesquisapergunta.findByCodpesquisapergunta", query = "SELECT o FROM OsPesquisapergunta o WHERE o.codpesquisapergunta = :codpesquisapergunta")
    , @NamedQuery(name = "OsPesquisapergunta.findByFlaginativa", query = "SELECT o FROM OsPesquisapergunta o WHERE o.flaginativa = :flaginativa")})
public class OsPesquisapergunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PERGUNTA")
    private String pergunta;
    @Column(name = "CODIGO")
    private String codigo;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESQUISAPERGUNTA")
    private String codpesquisapergunta;
    @Column(name = "FLAGINATIVA")
    private Character flaginativa;
    @OneToMany(mappedBy = "codpesquisapergunta")
    private Collection<OsPesquisaresposta> osPesquisarespostaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpesquisapergunta")
    private Collection<OsPesquisa> osPesquisaCollection;

    public OsPesquisapergunta() {
    }

    public OsPesquisapergunta(String codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodpesquisapergunta() {
        return codpesquisapergunta;
    }

    public void setCodpesquisapergunta(String codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    public Character getFlaginativa() {
        return flaginativa;
    }

    public void setFlaginativa(Character flaginativa) {
        this.flaginativa = flaginativa;
    }

    @XmlTransient
    public Collection<OsPesquisaresposta> getOsPesquisarespostaCollection() {
        return osPesquisarespostaCollection;
    }

    public void setOsPesquisarespostaCollection(Collection<OsPesquisaresposta> osPesquisarespostaCollection) {
        this.osPesquisarespostaCollection = osPesquisarespostaCollection;
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
        hash += (codpesquisapergunta != null ? codpesquisapergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsPesquisapergunta)) {
            return false;
        }
        OsPesquisapergunta other = (OsPesquisapergunta) object;
        if ((this.codpesquisapergunta == null && other.codpesquisapergunta != null) || (this.codpesquisapergunta != null && !this.codpesquisapergunta.equals(other.codpesquisapergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsPesquisapergunta[ codpesquisapergunta=" + codpesquisapergunta + " ]";
    }
    
}
