/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CARGO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c")
    , @NamedQuery(name = "Cargo.findByCodcargo", query = "SELECT c FROM Cargo c WHERE c.codcargo = :codcargo")
    , @NamedQuery(name = "Cargo.findByCodigo", query = "SELECT c FROM Cargo c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cargo.findByNomecargo", query = "SELECT c FROM Cargo c WHERE c.nomecargo = :nomecargo")
    , @NamedQuery(name = "Cargo.findBySalariocargo", query = "SELECT c FROM Cargo c WHERE c.salariocargo = :salariocargo")
    , @NamedQuery(name = "Cargo.findByFlagativo", query = "SELECT c FROM Cargo c WHERE c.flagativo = :flagativo")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARGO")
    private String codcargo;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECARGO")
    private String nomecargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARIOCARGO")
    private BigDecimal salariocargo;
    @Column(name = "FLAGATIVO")
    private Character flagativo;
    @JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfunc;
    @OneToMany(mappedBy = "codcargo")
    private Collection<Funcionario> funcionarioCollection;

    public Cargo() {
    }

    public Cargo(String codcargo) {
        this.codcargo = codcargo;
    }

    public String getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(String codcargo) {
        this.codcargo = codcargo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecargo() {
        return nomecargo;
    }

    public void setNomecargo(String nomecargo) {
        this.nomecargo = nomecargo;
    }

    public BigDecimal getSalariocargo() {
        return salariocargo;
    }

    public void setSalariocargo(BigDecimal salariocargo) {
        this.salariocargo = salariocargo;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    public Funcionario getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Funcionario codfunc) {
        this.codfunc = codfunc;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcargo != null ? codcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codcargo == null && other.codcargo != null) || (this.codcargo != null && !this.codcargo.equals(other.codcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cargo[ codcargo=" + codcargo + " ]";
    }
    
}
