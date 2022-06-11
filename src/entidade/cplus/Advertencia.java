/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ADVERTENCIA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertencia.findAll", query = "SELECT a FROM Advertencia a")
    , @NamedQuery(name = "Advertencia.findByCodadvertencia", query = "SELECT a FROM Advertencia a WHERE a.codadvertencia = :codadvertencia")
    , @NamedQuery(name = "Advertencia.findByCodigo", query = "SELECT a FROM Advertencia a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Advertencia.findByDescadvertencia", query = "SELECT a FROM Advertencia a WHERE a.descadvertencia = :descadvertencia")
    , @NamedQuery(name = "Advertencia.findByDataregistro", query = "SELECT a FROM Advertencia a WHERE a.dataregistro = :dataregistro")})
public class Advertencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODADVERTENCIA")
    private String codadvertencia;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCADVERTENCIA")
    private String descadvertencia;
    @Column(name = "DATAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date dataregistro;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfunc;
    @JoinColumn(name = "CODFUNCADVERTENCIA", referencedColumnName = "CODFUNCIONARIO")
    @ManyToOne
    private Funcionario codfuncadvertencia;
    @JoinColumn(name = "CODTIPOADVERTENCIA", referencedColumnName = "CODTIPOADVERTENCIA")
    @ManyToOne
    private Tipoadvertencia codtipoadvertencia;

    public Advertencia() {
    }

    public Advertencia(String codadvertencia) {
        this.codadvertencia = codadvertencia;
    }

    public String getCodadvertencia() {
        return codadvertencia;
    }

    public void setCodadvertencia(String codadvertencia) {
        this.codadvertencia = codadvertencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescadvertencia() {
        return descadvertencia;
    }

    public void setDescadvertencia(String descadvertencia) {
        this.descadvertencia = descadvertencia;
    }

    public Date getDataregistro() {
        return dataregistro;
    }

    public void setDataregistro(Date dataregistro) {
        this.dataregistro = dataregistro;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Funcionario getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Funcionario codfunc) {
        this.codfunc = codfunc;
    }

    public Funcionario getCodfuncadvertencia() {
        return codfuncadvertencia;
    }

    public void setCodfuncadvertencia(Funcionario codfuncadvertencia) {
        this.codfuncadvertencia = codfuncadvertencia;
    }

    public Tipoadvertencia getCodtipoadvertencia() {
        return codtipoadvertencia;
    }

    public void setCodtipoadvertencia(Tipoadvertencia codtipoadvertencia) {
        this.codtipoadvertencia = codtipoadvertencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codadvertencia != null ? codadvertencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertencia)) {
            return false;
        }
        Advertencia other = (Advertencia) object;
        if ((this.codadvertencia == null && other.codadvertencia != null) || (this.codadvertencia != null && !this.codadvertencia.equals(other.codadvertencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Advertencia[ codadvertencia=" + codadvertencia + " ]";
    }
    
}
