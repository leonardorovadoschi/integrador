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
@Table(name = "CONHECIMENTOSTATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conhecimentostatus.findAll", query = "SELECT c FROM Conhecimentostatus c")
    , @NamedQuery(name = "Conhecimentostatus.findByCodconhecimentostatus", query = "SELECT c FROM Conhecimentostatus c WHERE c.codconhecimentostatus = :codconhecimentostatus")
    , @NamedQuery(name = "Conhecimentostatus.findByCodigo", query = "SELECT c FROM Conhecimentostatus c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Conhecimentostatus.findByNomeconhecimentostatus", query = "SELECT c FROM Conhecimentostatus c WHERE c.nomeconhecimentostatus = :nomeconhecimentostatus")
    , @NamedQuery(name = "Conhecimentostatus.findByFlaglancacontareceber", query = "SELECT c FROM Conhecimentostatus c WHERE c.flaglancacontareceber = :flaglancacontareceber")})
public class Conhecimentostatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONHECIMENTOSTATUS")
    private String codconhecimentostatus;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECONHECIMENTOSTATUS")
    private String nomeconhecimentostatus;
    @Column(name = "FLAGLANCACONTARECEBER")
    private Character flaglancacontareceber;

    public Conhecimentostatus() {
    }

    public Conhecimentostatus(String codconhecimentostatus) {
        this.codconhecimentostatus = codconhecimentostatus;
    }

    public Conhecimentostatus(String codconhecimentostatus, String codigo) {
        this.codconhecimentostatus = codconhecimentostatus;
        this.codigo = codigo;
    }

    public String getCodconhecimentostatus() {
        return codconhecimentostatus;
    }

    public void setCodconhecimentostatus(String codconhecimentostatus) {
        this.codconhecimentostatus = codconhecimentostatus;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeconhecimentostatus() {
        return nomeconhecimentostatus;
    }

    public void setNomeconhecimentostatus(String nomeconhecimentostatus) {
        this.nomeconhecimentostatus = nomeconhecimentostatus;
    }

    public Character getFlaglancacontareceber() {
        return flaglancacontareceber;
    }

    public void setFlaglancacontareceber(Character flaglancacontareceber) {
        this.flaglancacontareceber = flaglancacontareceber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconhecimentostatus != null ? codconhecimentostatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conhecimentostatus)) {
            return false;
        }
        Conhecimentostatus other = (Conhecimentostatus) object;
        if ((this.codconhecimentostatus == null && other.codconhecimentostatus != null) || (this.codconhecimentostatus != null && !this.codconhecimentostatus.equals(other.codconhecimentostatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conhecimentostatus[ codconhecimentostatus=" + codconhecimentostatus + " ]";
    }
    
}
