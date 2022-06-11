/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "PESQUISA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pesquisa.findAll", query = "SELECT p FROM Pesquisa p")
    , @NamedQuery(name = "Pesquisa.findByCodpesquisa", query = "SELECT p FROM Pesquisa p WHERE p.codpesquisa = :codpesquisa")
    , @NamedQuery(name = "Pesquisa.findByDatainicio", query = "SELECT p FROM Pesquisa p WHERE p.datainicio = :datainicio")
    , @NamedQuery(name = "Pesquisa.findByDatafin", query = "SELECT p FROM Pesquisa p WHERE p.datafin = :datafin")
    , @NamedQuery(name = "Pesquisa.findByGenerica", query = "SELECT p FROM Pesquisa p WHERE p.generica = :generica")
    , @NamedQuery(name = "Pesquisa.findBySequencial", query = "SELECT p FROM Pesquisa p WHERE p.sequencial = :sequencial")
    , @NamedQuery(name = "Pesquisa.findByNomepesquisa", query = "SELECT p FROM Pesquisa p WHERE p.nomepesquisa = :nomepesquisa")})
public class Pesquisa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPESQUISA")
    private String codpesquisa;
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.DATE)
    private Date datainicio;
    @Column(name = "DATAFIN")
    @Temporal(TemporalType.DATE)
    private Date datafin;
    @Column(name = "GENERICA")
    private String generica;
    @Column(name = "SEQUENCIAL")
    private String sequencial;
    @Column(name = "NOMEPESQUISA")
    private String nomepesquisa;
    @OneToMany(mappedBy = "codpesquisa")
    private Collection<Pesquisapergunta> pesquisaperguntaCollection;
    @OneToMany(mappedBy = "codpesquisa")
    private Collection<Perguntaresposta> perguntarespostaCollection;

    public Pesquisa() {
    }

    public Pesquisa(String codpesquisa) {
        this.codpesquisa = codpesquisa;
    }

    public String getCodpesquisa() {
        return codpesquisa;
    }

    public void setCodpesquisa(String codpesquisa) {
        this.codpesquisa = codpesquisa;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafin() {
        return datafin;
    }

    public void setDatafin(Date datafin) {
        this.datafin = datafin;
    }

    public String getGenerica() {
        return generica;
    }

    public void setGenerica(String generica) {
        this.generica = generica;
    }

    public String getSequencial() {
        return sequencial;
    }

    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    public String getNomepesquisa() {
        return nomepesquisa;
    }

    public void setNomepesquisa(String nomepesquisa) {
        this.nomepesquisa = nomepesquisa;
    }

    @XmlTransient
    public Collection<Pesquisapergunta> getPesquisaperguntaCollection() {
        return pesquisaperguntaCollection;
    }

    public void setPesquisaperguntaCollection(Collection<Pesquisapergunta> pesquisaperguntaCollection) {
        this.pesquisaperguntaCollection = pesquisaperguntaCollection;
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
        hash += (codpesquisa != null ? codpesquisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pesquisa)) {
            return false;
        }
        Pesquisa other = (Pesquisa) object;
        if ((this.codpesquisa == null && other.codpesquisa != null) || (this.codpesquisa != null && !this.codpesquisa.equals(other.codpesquisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Pesquisa[ codpesquisa=" + codpesquisa + " ]";
    }
    
}
