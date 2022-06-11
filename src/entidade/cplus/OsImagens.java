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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_IMAGENS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsImagens.findAll", query = "SELECT o FROM OsImagens o")
    , @NamedQuery(name = "OsImagens.findByCodimgos", query = "SELECT o FROM OsImagens o WHERE o.codimgos = :codimgos")})
public class OsImagens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIMGOS")
    private String codimgos;
    @Lob
    @Column(name = "FOTO")
    private byte[] foto;
    @JoinColumn(name = "CODOS", referencedColumnName = "CODOS")
    @ManyToOne
    private OsOrdemservico codos;

    public OsImagens() {
    }

    public OsImagens(String codimgos) {
        this.codimgos = codimgos;
    }

    public String getCodimgos() {
        return codimgos;
    }

    public void setCodimgos(String codimgos) {
        this.codimgos = codimgos;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public OsOrdemservico getCodos() {
        return codos;
    }

    public void setCodos(OsOrdemservico codos) {
        this.codos = codos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codimgos != null ? codimgos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsImagens)) {
            return false;
        }
        OsImagens other = (OsImagens) object;
        if ((this.codimgos == null && other.codimgos != null) || (this.codimgos != null && !this.codimgos.equals(other.codimgos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsImagens[ codimgos=" + codimgos + " ]";
    }
    
}
