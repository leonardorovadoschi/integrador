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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ENQUADRAMENTOIPI", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enquadramentoipi.findAll", query = "SELECT e FROM Enquadramentoipi e")
    , @NamedQuery(name = "Enquadramentoipi.findByCodenquadramentoipi", query = "SELECT e FROM Enquadramentoipi e WHERE e.codenquadramentoipi = :codenquadramentoipi")
    , @NamedQuery(name = "Enquadramentoipi.findByCstipientrada", query = "SELECT e FROM Enquadramentoipi e WHERE e.cstipientrada = :cstipientrada")
    , @NamedQuery(name = "Enquadramentoipi.findByCstipisaida", query = "SELECT e FROM Enquadramentoipi e WHERE e.cstipisaida = :cstipisaida")
    , @NamedQuery(name = "Enquadramentoipi.findBySistema", query = "SELECT e FROM Enquadramentoipi e WHERE e.sistema = :sistema")})
public class Enquadramentoipi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODENQUADRAMENTOIPI")
    private String codenquadramentoipi;
    @Column(name = "CSTIPIENTRADA")
    private String cstipientrada;
    @Column(name = "CSTIPISAIDA")
    private String cstipisaida;
    @Basic(optional = false)
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "SISTEMA")
    private Character sistema;

    public Enquadramentoipi() {
    }

    public Enquadramentoipi(String codenquadramentoipi) {
        this.codenquadramentoipi = codenquadramentoipi;
    }

    public Enquadramentoipi(String codenquadramentoipi, String descricao, Character sistema) {
        this.codenquadramentoipi = codenquadramentoipi;
        this.descricao = descricao;
        this.sistema = sistema;
    }

    public String getCodenquadramentoipi() {
        return codenquadramentoipi;
    }

    public void setCodenquadramentoipi(String codenquadramentoipi) {
        this.codenquadramentoipi = codenquadramentoipi;
    }

    public String getCstipientrada() {
        return cstipientrada;
    }

    public void setCstipientrada(String cstipientrada) {
        this.cstipientrada = cstipientrada;
    }

    public String getCstipisaida() {
        return cstipisaida;
    }

    public void setCstipisaida(String cstipisaida) {
        this.cstipisaida = cstipisaida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getSistema() {
        return sistema;
    }

    public void setSistema(Character sistema) {
        this.sistema = sistema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codenquadramentoipi != null ? codenquadramentoipi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquadramentoipi)) {
            return false;
        }
        Enquadramentoipi other = (Enquadramentoipi) object;
        if ((this.codenquadramentoipi == null && other.codenquadramentoipi != null) || (this.codenquadramentoipi != null && !this.codenquadramentoipi.equals(other.codenquadramentoipi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Enquadramentoipi[ codenquadramentoipi=" + codenquadramentoipi + " ]";
    }
    
}
