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
@Table(name = "MDFELETRONICOVEICULO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicoveiculo.findAll", query = "SELECT m FROM Mdfeletronicoveiculo m")
    , @NamedQuery(name = "Mdfeletronicoveiculo.findByCodmdfeletronicoveiculo", query = "SELECT m FROM Mdfeletronicoveiculo m WHERE m.codmdfeletronicoveiculo = :codmdfeletronicoveiculo")})
public class Mdfeletronicoveiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOVEICULO")
    private String codmdfeletronicoveiculo;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @JoinColumn(name = "CODVEICULO", referencedColumnName = "CODVEICULO")
    @ManyToOne(optional = false)
    private Veiculos codveiculo;

    public Mdfeletronicoveiculo() {
    }

    public Mdfeletronicoveiculo(String codmdfeletronicoveiculo) {
        this.codmdfeletronicoveiculo = codmdfeletronicoveiculo;
    }

    public String getCodmdfeletronicoveiculo() {
        return codmdfeletronicoveiculo;
    }

    public void setCodmdfeletronicoveiculo(String codmdfeletronicoveiculo) {
        this.codmdfeletronicoveiculo = codmdfeletronicoveiculo;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Veiculos getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Veiculos codveiculo) {
        this.codveiculo = codveiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicoveiculo != null ? codmdfeletronicoveiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicoveiculo)) {
            return false;
        }
        Mdfeletronicoveiculo other = (Mdfeletronicoveiculo) object;
        if ((this.codmdfeletronicoveiculo == null && other.codmdfeletronicoveiculo != null) || (this.codmdfeletronicoveiculo != null && !this.codmdfeletronicoveiculo.equals(other.codmdfeletronicoveiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicoveiculo[ codmdfeletronicoveiculo=" + codmdfeletronicoveiculo + " ]";
    }
    
}
