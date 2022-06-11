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
@Table(name = "FABRICANTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f")
    , @NamedQuery(name = "Fabricante.findByCodfabricante", query = "SELECT f FROM Fabricante f WHERE f.codfabricante = :codfabricante")
    , @NamedQuery(name = "Fabricante.findByCodigo", query = "SELECT f FROM Fabricante f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Fabricante.findByNomefabricante", query = "SELECT f FROM Fabricante f WHERE f.nomefabricante = :nomefabricante")})
public class Fabricante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFABRICANTE")
    private String codfabricante;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEFABRICANTE")
    private String nomefabricante;
    @Lob
    @Column(name = "LOGO")
    private byte[] logo;

    public Fabricante() {
    }

    public Fabricante(String codfabricante) {
        this.codfabricante = codfabricante;
    }

    public Fabricante(String codfabricante, String codigo) {
        this.codfabricante = codfabricante;
        this.codigo = codigo;
    }

    public String getCodfabricante() {
        return codfabricante;
    }

    public void setCodfabricante(String codfabricante) {
        this.codfabricante = codfabricante;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomefabricante() {
        return nomefabricante;
    }

    public void setNomefabricante(String nomefabricante) {
        this.nomefabricante = nomefabricante;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfabricante != null ? codfabricante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.codfabricante == null && other.codfabricante != null) || (this.codfabricante != null && !this.codfabricante.equals(other.codfabricante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Fabricante[ codfabricante=" + codfabricante + " ]";
    }
    
}
