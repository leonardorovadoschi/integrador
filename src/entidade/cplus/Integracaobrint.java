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
@Table(name = "INTEGRACAOBRINT", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Integracaobrint.findAll", query = "SELECT i FROM Integracaobrint i")
    , @NamedQuery(name = "Integracaobrint.findByCodintegracao", query = "SELECT i FROM Integracaobrint i WHERE i.codintegracao = :codintegracao")
    , @NamedQuery(name = "Integracaobrint.findByNumped", query = "SELECT i FROM Integracaobrint i WHERE i.numped = :numped")
    , @NamedQuery(name = "Integracaobrint.findByNumcaixa", query = "SELECT i FROM Integracaobrint i WHERE i.numcaixa = :numcaixa")
    , @NamedQuery(name = "Integracaobrint.findByZona", query = "SELECT i FROM Integracaobrint i WHERE i.zona = :zona")
    , @NamedQuery(name = "Integracaobrint.findByCodigoimpressao", query = "SELECT i FROM Integracaobrint i WHERE i.codigoimpressao = :codigoimpressao")
    , @NamedQuery(name = "Integracaobrint.findByDataintegracao", query = "SELECT i FROM Integracaobrint i WHERE i.dataintegracao = :dataintegracao")})
public class Integracaobrint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODINTEGRACAO")
    private String codintegracao;
    @Basic(optional = false)
    @Column(name = "NUMPED")
    private int numped;
    @Basic(optional = false)
    @Column(name = "NUMCAIXA")
    private String numcaixa;
    @Basic(optional = false)
    @Column(name = "ZONA")
    private String zona;
    @Basic(optional = false)
    @Column(name = "CODIGOIMPRESSAO")
    private String codigoimpressao;
    @Basic(optional = false)
    @Column(name = "DATAINTEGRACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataintegracao;

    public Integracaobrint() {
    }

    public Integracaobrint(String codintegracao) {
        this.codintegracao = codintegracao;
    }

    public Integracaobrint(String codintegracao, int numped, String numcaixa, String zona, String codigoimpressao, Date dataintegracao) {
        this.codintegracao = codintegracao;
        this.numped = numped;
        this.numcaixa = numcaixa;
        this.zona = zona;
        this.codigoimpressao = codigoimpressao;
        this.dataintegracao = dataintegracao;
    }

    public String getCodintegracao() {
        return codintegracao;
    }

    public void setCodintegracao(String codintegracao) {
        this.codintegracao = codintegracao;
    }

    public int getNumped() {
        return numped;
    }

    public void setNumped(int numped) {
        this.numped = numped;
    }

    public String getNumcaixa() {
        return numcaixa;
    }

    public void setNumcaixa(String numcaixa) {
        this.numcaixa = numcaixa;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getCodigoimpressao() {
        return codigoimpressao;
    }

    public void setCodigoimpressao(String codigoimpressao) {
        this.codigoimpressao = codigoimpressao;
    }

    public Date getDataintegracao() {
        return dataintegracao;
    }

    public void setDataintegracao(Date dataintegracao) {
        this.dataintegracao = dataintegracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codintegracao != null ? codintegracao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Integracaobrint)) {
            return false;
        }
        Integracaobrint other = (Integracaobrint) object;
        if ((this.codintegracao == null && other.codintegracao != null) || (this.codintegracao != null && !this.codintegracao.equals(other.codintegracao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Integracaobrint[ codintegracao=" + codintegracao + " ]";
    }
    
}
