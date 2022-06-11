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
@Table(name = "PERGUNTARESPOSTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perguntaresposta.findAll", query = "SELECT p FROM Perguntaresposta p")
    , @NamedQuery(name = "Perguntaresposta.findByCodperguntaresposta", query = "SELECT p FROM Perguntaresposta p WHERE p.codperguntaresposta = :codperguntaresposta")
    , @NamedQuery(name = "Perguntaresposta.findByCodresposta", query = "SELECT p FROM Perguntaresposta p WHERE p.codresposta = :codresposta")
    , @NamedQuery(name = "Perguntaresposta.findByResposta", query = "SELECT p FROM Perguntaresposta p WHERE p.resposta = :resposta")})
public class Perguntaresposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPERGUNTARESPOSTA")
    private String codperguntaresposta;
    @Column(name = "CODRESPOSTA")
    private String codresposta;
    @Column(name = "RESPOSTA")
    private String resposta;
    @OneToMany(mappedBy = "codproximapergunta")
    private Collection<Perguntaresposta> perguntarespostaCollection;
    @JoinColumn(name = "CODPROXIMAPERGUNTA", referencedColumnName = "CODPERGUNTARESPOSTA")
    @ManyToOne
    private Perguntaresposta codproximapergunta;
    @JoinColumn(name = "CODPESQUISA", referencedColumnName = "CODPESQUISA")
    @ManyToOne
    private Pesquisa codpesquisa;
    @JoinColumn(name = "CODPESQUISAPERGUNTA", referencedColumnName = "CODPESQUISAPERGUNTA")
    @ManyToOne
    private Pesquisapergunta codpesquisapergunta;

    public Perguntaresposta() {
    }

    public Perguntaresposta(String codperguntaresposta) {
        this.codperguntaresposta = codperguntaresposta;
    }

    public String getCodperguntaresposta() {
        return codperguntaresposta;
    }

    public void setCodperguntaresposta(String codperguntaresposta) {
        this.codperguntaresposta = codperguntaresposta;
    }

    public String getCodresposta() {
        return codresposta;
    }

    public void setCodresposta(String codresposta) {
        this.codresposta = codresposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @XmlTransient
    public Collection<Perguntaresposta> getPerguntarespostaCollection() {
        return perguntarespostaCollection;
    }

    public void setPerguntarespostaCollection(Collection<Perguntaresposta> perguntarespostaCollection) {
        this.perguntarespostaCollection = perguntarespostaCollection;
    }

    public Perguntaresposta getCodproximapergunta() {
        return codproximapergunta;
    }

    public void setCodproximapergunta(Perguntaresposta codproximapergunta) {
        this.codproximapergunta = codproximapergunta;
    }

    public Pesquisa getCodpesquisa() {
        return codpesquisa;
    }

    public void setCodpesquisa(Pesquisa codpesquisa) {
        this.codpesquisa = codpesquisa;
    }

    public Pesquisapergunta getCodpesquisapergunta() {
        return codpesquisapergunta;
    }

    public void setCodpesquisapergunta(Pesquisapergunta codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codperguntaresposta != null ? codperguntaresposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perguntaresposta)) {
            return false;
        }
        Perguntaresposta other = (Perguntaresposta) object;
        if ((this.codperguntaresposta == null && other.codperguntaresposta != null) || (this.codperguntaresposta != null && !this.codperguntaresposta.equals(other.codperguntaresposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Perguntaresposta[ codperguntaresposta=" + codperguntaresposta + " ]";
    }
    
}
