/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_PESQUISA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsPesquisa.findAll", query = "SELECT o FROM OsPesquisa o")
    , @NamedQuery(name = "OsPesquisa.findByObs", query = "SELECT o FROM OsPesquisa o WHERE o.obs = :obs")
    , @NamedQuery(name = "OsPesquisa.findByCodospesquisa", query = "SELECT o FROM OsPesquisa o WHERE o.codospesquisa = :codospesquisa")
    , @NamedQuery(name = "OsPesquisa.findByPergunta", query = "SELECT o FROM OsPesquisa o WHERE o.pergunta = :pergunta")
    , @NamedQuery(name = "OsPesquisa.findByResposta", query = "SELECT o FROM OsPesquisa o WHERE o.resposta = :resposta")
    , @NamedQuery(name = "OsPesquisa.findByData", query = "SELECT o FROM OsPesquisa o WHERE o.data = :data")})
public class OsPesquisa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "OBS")
    private String obs;
    @Id
    @Basic(optional = false)
    @Column(name = "CODOSPESQUISA")
    private String codospesquisa;
    @Column(name = "PERGUNTA")
    private String pergunta;
    @Column(name = "RESPOSTA")
    private String resposta;
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne(optional = false)
    private OsOrdemservico codos;
    @JoinColumn(name = "CODPESQUISAPERGUNTA", referencedColumnName = "CODPESQUISAPERGUNTA")
    @ManyToOne(optional = false)
    private OsPesquisapergunta codpesquisapergunta;
    @JoinColumn(name = "CODPESQUISARESPOSTA", referencedColumnName = "CODPESQUISARESPOSTA")
    @ManyToOne
    private OsPesquisaresposta codpesquisaresposta;

    public OsPesquisa() {
    }

    public OsPesquisa(String codospesquisa) {
        this.codospesquisa = codospesquisa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getCodospesquisa() {
        return codospesquisa;
    }

    public void setCodospesquisa(String codospesquisa) {
        this.codospesquisa = codospesquisa;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    public OsPesquisapergunta getCodpesquisapergunta() {
        return codpesquisapergunta;
    }

    public void setCodpesquisapergunta(OsPesquisapergunta codpesquisapergunta) {
        this.codpesquisapergunta = codpesquisapergunta;
    }

    public OsPesquisaresposta getCodpesquisaresposta() {
        return codpesquisaresposta;
    }

    public void setCodpesquisaresposta(OsPesquisaresposta codpesquisaresposta) {
        this.codpesquisaresposta = codpesquisaresposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codospesquisa != null ? codospesquisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsPesquisa)) {
            return false;
        }
        OsPesquisa other = (OsPesquisa) object;
        if ((this.codospesquisa == null && other.codospesquisa != null) || (this.codospesquisa != null && !this.codospesquisa.equals(other.codospesquisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsPesquisa[ codospesquisa=" + codospesquisa + " ]";
    }
    
}
