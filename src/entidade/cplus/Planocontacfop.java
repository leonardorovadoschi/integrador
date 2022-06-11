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
@Table(name = "PLANOCONTACFOP", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planocontacfop.findAll", query = "SELECT p FROM Planocontacfop p")
    , @NamedQuery(name = "Planocontacfop.findByCodplanocontacfop", query = "SELECT p FROM Planocontacfop p WHERE p.codplanocontacfop = :codplanocontacfop")
    , @NamedQuery(name = "Planocontacfop.findByCodpc", query = "SELECT p FROM Planocontacfop p WHERE p.codpc = :codpc")
    , @NamedQuery(name = "Planocontacfop.findByCodigonaturezaconta", query = "SELECT p FROM Planocontacfop p WHERE p.codigonaturezaconta = :codigonaturezaconta")})
public class Planocontacfop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPLANOCONTACFOP")
    private String codplanocontacfop;
    @Basic(optional = false)
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODIGONATUREZACONTA")
    private String codigonaturezaconta;
    @JoinColumn(name = "CODCFOP", referencedColumnName = "CODCFOP")
    @ManyToOne(optional = false)
    private Cfop codcfop;
    @JoinColumn(name = "CODTIPOMOVIMENTO", referencedColumnName = "CODTIPOMOVIMENTO")
    @ManyToOne(optional = false)
    private Tipomovimento codtipomovimento;

    public Planocontacfop() {
    }

    public Planocontacfop(String codplanocontacfop) {
        this.codplanocontacfop = codplanocontacfop;
    }

    public Planocontacfop(String codplanocontacfop, String codpc) {
        this.codplanocontacfop = codplanocontacfop;
        this.codpc = codpc;
    }

    public String getCodplanocontacfop() {
        return codplanocontacfop;
    }

    public void setCodplanocontacfop(String codplanocontacfop) {
        this.codplanocontacfop = codplanocontacfop;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodigonaturezaconta() {
        return codigonaturezaconta;
    }

    public void setCodigonaturezaconta(String codigonaturezaconta) {
        this.codigonaturezaconta = codigonaturezaconta;
    }

    public Cfop getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(Cfop codcfop) {
        this.codcfop = codcfop;
    }

    public Tipomovimento getCodtipomovimento() {
        return codtipomovimento;
    }

    public void setCodtipomovimento(Tipomovimento codtipomovimento) {
        this.codtipomovimento = codtipomovimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codplanocontacfop != null ? codplanocontacfop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planocontacfop)) {
            return false;
        }
        Planocontacfop other = (Planocontacfop) object;
        if ((this.codplanocontacfop == null && other.codplanocontacfop != null) || (this.codplanocontacfop != null && !this.codplanocontacfop.equals(other.codplanocontacfop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Planocontacfop[ codplanocontacfop=" + codplanocontacfop + " ]";
    }
    
}
