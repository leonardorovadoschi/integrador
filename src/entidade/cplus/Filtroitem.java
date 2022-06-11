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
@Table(name = "FILTROITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filtroitem.findAll", query = "SELECT f FROM Filtroitem f")
    , @NamedQuery(name = "Filtroitem.findByCodfiltroitem", query = "SELECT f FROM Filtroitem f WHERE f.codfiltroitem = :codfiltroitem")
    , @NamedQuery(name = "Filtroitem.findByCodfiltro", query = "SELECT f FROM Filtroitem f WHERE f.codfiltro = :codfiltro")
    , @NamedQuery(name = "Filtroitem.findByParametroinicio", query = "SELECT f FROM Filtroitem f WHERE f.parametroinicio = :parametroinicio")
    , @NamedQuery(name = "Filtroitem.findByNomecampo", query = "SELECT f FROM Filtroitem f WHERE f.nomecampo = :nomecampo")
    , @NamedQuery(name = "Filtroitem.findByOperador", query = "SELECT f FROM Filtroitem f WHERE f.operador = :operador")
    , @NamedQuery(name = "Filtroitem.findByValor", query = "SELECT f FROM Filtroitem f WHERE f.valor = :valor")
    , @NamedQuery(name = "Filtroitem.findByParametrofim", query = "SELECT f FROM Filtroitem f WHERE f.parametrofim = :parametrofim")
    , @NamedQuery(name = "Filtroitem.findByFlagAndOr", query = "SELECT f FROM Filtroitem f WHERE f.flagAndOr = :flagAndOr")})
public class Filtroitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFILTROITEM")
    private String codfiltroitem;
    @Basic(optional = false)
    @Column(name = "CODFILTRO")
    private String codfiltro;
    @Column(name = "PARAMETROINICIO")
    private String parametroinicio;
    @Basic(optional = false)
    @Column(name = "NOMECAMPO")
    private String nomecampo;
    @Basic(optional = false)
    @Column(name = "OPERADOR")
    private String operador;
    @Basic(optional = false)
    @Column(name = "VALOR")
    private String valor;
    @Column(name = "PARAMETROFIM")
    private String parametrofim;
    @Column(name = "FLAG_AND_OR")
    private String flagAndOr;

    public Filtroitem() {
    }

    public Filtroitem(String codfiltroitem) {
        this.codfiltroitem = codfiltroitem;
    }

    public Filtroitem(String codfiltroitem, String codfiltro, String nomecampo, String operador, String valor) {
        this.codfiltroitem = codfiltroitem;
        this.codfiltro = codfiltro;
        this.nomecampo = nomecampo;
        this.operador = operador;
        this.valor = valor;
    }

    public String getCodfiltroitem() {
        return codfiltroitem;
    }

    public void setCodfiltroitem(String codfiltroitem) {
        this.codfiltroitem = codfiltroitem;
    }

    public String getCodfiltro() {
        return codfiltro;
    }

    public void setCodfiltro(String codfiltro) {
        this.codfiltro = codfiltro;
    }

    public String getParametroinicio() {
        return parametroinicio;
    }

    public void setParametroinicio(String parametroinicio) {
        this.parametroinicio = parametroinicio;
    }

    public String getNomecampo() {
        return nomecampo;
    }

    public void setNomecampo(String nomecampo) {
        this.nomecampo = nomecampo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getParametrofim() {
        return parametrofim;
    }

    public void setParametrofim(String parametrofim) {
        this.parametrofim = parametrofim;
    }

    public String getFlagAndOr() {
        return flagAndOr;
    }

    public void setFlagAndOr(String flagAndOr) {
        this.flagAndOr = flagAndOr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfiltroitem != null ? codfiltroitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filtroitem)) {
            return false;
        }
        Filtroitem other = (Filtroitem) object;
        if ((this.codfiltroitem == null && other.codfiltroitem != null) || (this.codfiltroitem != null && !this.codfiltroitem.equals(other.codfiltroitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Filtroitem[ codfiltroitem=" + codfiltroitem + " ]";
    }
    
}
