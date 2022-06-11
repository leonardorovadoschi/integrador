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
@Table(name = "MEDICO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByCodmedico", query = "SELECT m FROM Medico m WHERE m.codmedico = :codmedico")
    , @NamedQuery(name = "Medico.findByCodigo", query = "SELECT m FROM Medico m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Medico.findByNumerocrm", query = "SELECT m FROM Medico m WHERE m.numerocrm = :numerocrm")
    , @NamedQuery(name = "Medico.findByNomemedico", query = "SELECT m FROM Medico m WHERE m.nomemedico = :nomemedico")
    , @NamedQuery(name = "Medico.findByNomeconselho", query = "SELECT m FROM Medico m WHERE m.nomeconselho = :nomeconselho")
    , @NamedQuery(name = "Medico.findByCodufconselho", query = "SELECT m FROM Medico m WHERE m.codufconselho = :codufconselho")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMEDICO")
    private String codmedico;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NUMEROCRM")
    private String numerocrm;
    @Column(name = "NOMEMEDICO")
    private String nomemedico;
    @Column(name = "NOMECONSELHO")
    private String nomeconselho;
    @Column(name = "CODUFCONSELHO")
    private String codufconselho;

    public Medico() {
    }

    public Medico(String codmedico) {
        this.codmedico = codmedico;
    }

    public String getCodmedico() {
        return codmedico;
    }

    public void setCodmedico(String codmedico) {
        this.codmedico = codmedico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumerocrm() {
        return numerocrm;
    }

    public void setNumerocrm(String numerocrm) {
        this.numerocrm = numerocrm;
    }

    public String getNomemedico() {
        return nomemedico;
    }

    public void setNomemedico(String nomemedico) {
        this.nomemedico = nomemedico;
    }

    public String getNomeconselho() {
        return nomeconselho;
    }

    public void setNomeconselho(String nomeconselho) {
        this.nomeconselho = nomeconselho;
    }

    public String getCodufconselho() {
        return codufconselho;
    }

    public void setCodufconselho(String codufconselho) {
        this.codufconselho = codufconselho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmedico != null ? codmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.codmedico == null && other.codmedico != null) || (this.codmedico != null && !this.codmedico.equals(other.codmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Medico[ codmedico=" + codmedico + " ]";
    }
    
}
