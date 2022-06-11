/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "RELACIONADO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacionado.findAll", query = "SELECT r FROM Relacionado r")
    , @NamedQuery(name = "Relacionado.findByRefercodprod", query = "SELECT r FROM Relacionado r WHERE r.refercodprod = :refercodprod")
    , @NamedQuery(name = "Relacionado.findByCodrelacionado", query = "SELECT r FROM Relacionado r WHERE r.codrelacionado = :codrelacionado")
    , @NamedQuery(name = "Relacionado.findByFlagtributavel", query = "SELECT r FROM Relacionado r WHERE r.flagtributavel = :flagtributavel")
    , @NamedQuery(name = "Relacionado.findByFatorconversao", query = "SELECT r FROM Relacionado r WHERE r.fatorconversao = :fatorconversao")
    , @NamedQuery(name = "Relacionado.findByGuid", query = "SELECT r FROM Relacionado r WHERE r.guid = :guid")})
public class Relacionado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "REFERCODPROD")
    private String refercodprod;
    @Id
    @Basic(optional = false)
    @Column(name = "CODRELACIONADO")
    private String codrelacionado;
    @Column(name = "FLAGTRIBUTAVEL")
    private Character flagtributavel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FATORCONVERSAO")
    private BigDecimal fatorconversao;
    @Column(name = "GUID")
    private String guid;
    @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    @ManyToOne(optional = false)
    private Produto codprod;

    public Relacionado() {
    }

    public Relacionado(String codrelacionado) {
        this.codrelacionado = codrelacionado;
    }

    public Relacionado(String codrelacionado, String refercodprod) {
        this.codrelacionado = codrelacionado;
        this.refercodprod = refercodprod;
    }

    public String getRefercodprod() {
        return refercodprod;
    }

    public void setRefercodprod(String refercodprod) {
        this.refercodprod = refercodprod;
    }

    public String getCodrelacionado() {
        return codrelacionado;
    }

    public void setCodrelacionado(String codrelacionado) {
        this.codrelacionado = codrelacionado;
    }

    public Character getFlagtributavel() {
        return flagtributavel;
    }

    public void setFlagtributavel(Character flagtributavel) {
        this.flagtributavel = flagtributavel;
    }

    public BigDecimal getFatorconversao() {
        return fatorconversao;
    }

    public void setFatorconversao(BigDecimal fatorconversao) {
        this.fatorconversao = fatorconversao;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Produto getCodprod() {
        return codprod;
    }

    public void setCodprod(Produto codprod) {
        this.codprod = codprod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codrelacionado != null ? codrelacionado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relacionado)) {
            return false;
        }
        Relacionado other = (Relacionado) object;
        if ((this.codrelacionado == null && other.codrelacionado != null) || (this.codrelacionado != null && !this.codrelacionado.equals(other.codrelacionado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relacionado[ codrelacionado=" + codrelacionado + " ]";
    }
    
}
