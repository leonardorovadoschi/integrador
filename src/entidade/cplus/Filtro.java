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
@Table(name = "FILTRO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filtro.findAll", query = "SELECT f FROM Filtro f")
    , @NamedQuery(name = "Filtro.findByCodfiltro", query = "SELECT f FROM Filtro f WHERE f.codfiltro = :codfiltro")
    , @NamedQuery(name = "Filtro.findByCodigo", query = "SELECT f FROM Filtro f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Filtro.findByNomefiltro", query = "SELECT f FROM Filtro f WHERE f.nomefiltro = :nomefiltro")
    , @NamedQuery(name = "Filtro.findByNomeentidade", query = "SELECT f FROM Filtro f WHERE f.nomeentidade = :nomeentidade")})
public class Filtro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFILTRO")
    private String codfiltro;
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "NOMEFILTRO")
    private String nomefiltro;
    @Column(name = "NOMEENTIDADE")
    private String nomeentidade;

    public Filtro() {
    }

    public Filtro(String codfiltro) {
        this.codfiltro = codfiltro;
    }

    public String getCodfiltro() {
        return codfiltro;
    }

    public void setCodfiltro(String codfiltro) {
        this.codfiltro = codfiltro;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomefiltro() {
        return nomefiltro;
    }

    public void setNomefiltro(String nomefiltro) {
        this.nomefiltro = nomefiltro;
    }

    public String getNomeentidade() {
        return nomeentidade;
    }

    public void setNomeentidade(String nomeentidade) {
        this.nomeentidade = nomeentidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfiltro != null ? codfiltro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filtro)) {
            return false;
        }
        Filtro other = (Filtro) object;
        if ((this.codfiltro == null && other.codfiltro != null) || (this.codfiltro != null && !this.codfiltro.equals(other.codfiltro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Filtro[ codfiltro=" + codfiltro + " ]";
    }
    
}
