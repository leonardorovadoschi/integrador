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
@Table(name = "RECEITA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findByCodreceita", query = "SELECT r FROM Receita r WHERE r.codreceita = :codreceita")
    , @NamedQuery(name = "Receita.findByCodigo", query = "SELECT r FROM Receita r WHERE r.codigo = :codigo")
    , @NamedQuery(name = "Receita.findByNomereceita", query = "SELECT r FROM Receita r WHERE r.nomereceita = :nomereceita")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRECEITA")
    private String codreceita;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMERECEITA")
    private String nomereceita;
    @Lob
    @Column(name = "DESCRICAORECEITA")
    private String descricaoreceita;

    public Receita() {
    }

    public Receita(String codreceita) {
        this.codreceita = codreceita;
    }

    public String getCodreceita() {
        return codreceita;
    }

    public void setCodreceita(String codreceita) {
        this.codreceita = codreceita;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomereceita() {
        return nomereceita;
    }

    public void setNomereceita(String nomereceita) {
        this.nomereceita = nomereceita;
    }

    public String getDescricaoreceita() {
        return descricaoreceita;
    }

    public void setDescricaoreceita(String descricaoreceita) {
        this.descricaoreceita = descricaoreceita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codreceita != null ? codreceita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.codreceita == null && other.codreceita != null) || (this.codreceita != null && !this.codreceita.equals(other.codreceita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Receita[ codreceita=" + codreceita + " ]";
    }
    
}
