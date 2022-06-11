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
@Table(name = "PESQUISAPERGUNTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pesquisapergunta.findAll", query = "SELECT p FROM Pesquisapergunta p")
    , @NamedQuery(name = "Pesquisapergunta.findByCodpesquisapergunta", query = "SELECT p FROM Pesquisapergunta p WHERE p.codpesquisapergunta = :codpesquisapergunta")
    , @NamedQuery(name = "Pesquisapergunta.findByPergunta", query = "SELECT p FROM Pesquisapergunta p WHERE p.pergunta = :pergunta")
    , @NamedQuery(name = "Pesquisapergunta.findByTipo", query = "SELECT p FROM Pesquisapergunta p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pesquisapergunta.findBySequencia", query = "SELECT p FROM Pesquisapergunta p WHERE p.sequencia = :sequencia")})
public class Pesquisapergunta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESQUISAPERGUNTA")
    private String codpesquisapergunta;
    @Column(name = "PERGUNTA")
    private String pergunta;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "SEQUENCIA")
    private Character sequencia;
    @JoinColumn(name = "CODPESQUISA", referencedColumnName = "CODPESQUISA")
    @ManyToOne
    private Pesquisa codpesquisa;
    @OneToMany(mappedBy = "codproximapergunta")
    private Collection<Pesquisapergunta> pesquisaperguntaCollection;
    @JoinColumn(name = "CODPROXIMAPERGUNTA", referencedColumnName = "CODPESQUISAPERGUNTA")
    @ManyToOne
    private Pesquisapergunta codproximapergunta;
    @OneToMany(mappedBy = "codpesquisapergunta")
    private Collection<Perguntaresposta> perguntarespostaCollection;

    public Pesquisapergunta() {
    }

    public Pesquisapergunta(String codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    public String getCodpesquisapergunta() {
        return codpesquisapergunta;
    }

    public void setCodpesquisapergunta(String codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Character getSequencia() {
        return sequencia;
    }

    public void setSequencia(Character sequencia) {
        this.sequencia = sequencia;
    }

    public Pesquisa getCodpesquisa() {
        return codpesquisa;
    }

    public void setCodpesquisa(Pesquisa codpesquisa) {
        this.codpesquisa = codpesquisa;
    }

    @XmlTransient
    public Collection<Pesquisapergunta> getPesquisaperguntaCollection() {
        return pesquisaperguntaCollection;
    }

    public void setPesquisaperguntaCollection(Collection<Pesquisapergunta> pesquisaperguntaCollection) {
        this.pesquisaperguntaCollection = pesquisaperguntaCollection;
    }

    public Pesquisapergunta getCodproximapergunta() {
        return codproximapergunta;
    }

    public void setCodproximapergunta(Pesquisapergunta codproximapergunta) {
        this.codproximapergunta = codproximapergunta;
    }

    @XmlTransient
    public Collection<Perguntaresposta> getPerguntarespostaCollection() {
        return perguntarespostaCollection;
    }

    public void setPerguntarespostaCollection(Collection<Perguntaresposta> perguntarespostaCollection) {
        this.perguntarespostaCollection = perguntarespostaCollection;
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
        if (!(object instanceof Pesquisapergunta)) {
            return false;
        }
        Pesquisapergunta other = (Pesquisapergunta) object;
        if ((this.codpesquisapergunta == null && other.codpesquisapergunta != null) || (this.codpesquisapergunta != null && !this.codpesquisapergunta.equals(other.codpesquisapergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pesquisapergunta[ codpesquisapergunta=" + codpesquisapergunta + " ]";
    }
    
}
