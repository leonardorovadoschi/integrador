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
@Table(name = "MDFELETRONICOAUTORIZADOXML", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicoautorizadoxml.findAll", query = "SELECT m FROM Mdfeletronicoautorizadoxml m")
    , @NamedQuery(name = "Mdfeletronicoautorizadoxml.findByCodmdfeletronicoautorizadoxml", query = "SELECT m FROM Mdfeletronicoautorizadoxml m WHERE m.codmdfeletronicoautorizadoxml = :codmdfeletronicoautorizadoxml")
    , @NamedQuery(name = "Mdfeletronicoautorizadoxml.findByCnpjcpf", query = "SELECT m FROM Mdfeletronicoautorizadoxml m WHERE m.cnpjcpf = :cnpjcpf")
    , @NamedQuery(name = "Mdfeletronicoautorizadoxml.findByFlagfisica", query = "SELECT m FROM Mdfeletronicoautorizadoxml m WHERE m.flagfisica = :flagfisica")})
public class Mdfeletronicoautorizadoxml implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOAUTORIZADOXML")
    private String codmdfeletronicoautorizadoxml;
    @Basic(optional = false)
    @Column(name = "CNPJCPF")
    private String cnpjcpf;
    @Basic(optional = false)
    @Column(name = "FLAGFISICA")
    private Character flagfisica;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;

    public Mdfeletronicoautorizadoxml() {
    }

    public Mdfeletronicoautorizadoxml(String codmdfeletronicoautorizadoxml) {
        this.codmdfeletronicoautorizadoxml = codmdfeletronicoautorizadoxml;
    }

    public Mdfeletronicoautorizadoxml(String codmdfeletronicoautorizadoxml, String cnpjcpf, Character flagfisica) {
        this.codmdfeletronicoautorizadoxml = codmdfeletronicoautorizadoxml;
        this.cnpjcpf = cnpjcpf;
        this.flagfisica = flagfisica;
    }

    public String getCodmdfeletronicoautorizadoxml() {
        return codmdfeletronicoautorizadoxml;
    }

    public void setCodmdfeletronicoautorizadoxml(String codmdfeletronicoautorizadoxml) {
        this.codmdfeletronicoautorizadoxml = codmdfeletronicoautorizadoxml;
    }

    public String getCnpjcpf() {
        return cnpjcpf;
    }

    public void setCnpjcpf(String cnpjcpf) {
        this.cnpjcpf = cnpjcpf;
    }

    public Character getFlagfisica() {
        return flagfisica;
    }

    public void setFlagfisica(Character flagfisica) {
        this.flagfisica = flagfisica;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicoautorizadoxml != null ? codmdfeletronicoautorizadoxml.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicoautorizadoxml)) {
            return false;
        }
        Mdfeletronicoautorizadoxml other = (Mdfeletronicoautorizadoxml) object;
        if ((this.codmdfeletronicoautorizadoxml == null && other.codmdfeletronicoautorizadoxml != null) || (this.codmdfeletronicoautorizadoxml != null && !this.codmdfeletronicoautorizadoxml.equals(other.codmdfeletronicoautorizadoxml))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicoautorizadoxml[ codmdfeletronicoautorizadoxml=" + codmdfeletronicoautorizadoxml + " ]";
    }
    
}
