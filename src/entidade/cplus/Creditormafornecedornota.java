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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CREDITORMAFORNECEDORNOTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditormafornecedornota.findAll", query = "SELECT c FROM Creditormafornecedornota c")
    , @NamedQuery(name = "Creditormafornecedornota.findByCodcredifornnota", query = "SELECT c FROM Creditormafornecedornota c WHERE c.codcredifornnota = :codcredifornnota")
    , @NamedQuery(name = "Creditormafornecedornota.findByCodcrediforn", query = "SELECT c FROM Creditormafornecedornota c WHERE c.codcrediforn = :codcrediforn")
    , @NamedQuery(name = "Creditormafornecedornota.findByNumnota", query = "SELECT c FROM Creditormafornecedornota c WHERE c.numnota = :numnota")
    , @NamedQuery(name = "Creditormafornecedornota.findByValornota", query = "SELECT c FROM Creditormafornecedornota c WHERE c.valornota = :valornota")
    , @NamedQuery(name = "Creditormafornecedornota.findByFlagconcedido", query = "SELECT c FROM Creditormafornecedornota c WHERE c.flagconcedido = :flagconcedido")
    , @NamedQuery(name = "Creditormafornecedornota.findByFlagutilizado", query = "SELECT c FROM Creditormafornecedornota c WHERE c.flagutilizado = :flagutilizado")
    , @NamedQuery(name = "Creditormafornecedornota.findByCodcr", query = "SELECT c FROM Creditormafornecedornota c WHERE c.codcr = :codcr")})
public class Creditormafornecedornota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCREDIFORNNOTA")
    private String codcredifornnota;
    @Column(name = "CODCREDIFORN")
    private String codcrediforn;
    @Column(name = "NUMNOTA")
    private String numnota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORNOTA")
    private BigDecimal valornota;
    @Column(name = "FLAGCONCEDIDO")
    private Character flagconcedido;
    @Column(name = "FLAGUTILIZADO")
    private Character flagutilizado;
    @Column(name = "CODCR")
    private String codcr;

    public Creditormafornecedornota() {
    }

    public Creditormafornecedornota(String codcredifornnota) {
        this.codcredifornnota = codcredifornnota;
    }

    public String getCodcredifornnota() {
        return codcredifornnota;
    }

    public void setCodcredifornnota(String codcredifornnota) {
        this.codcredifornnota = codcredifornnota;
    }

    public String getCodcrediforn() {
        return codcrediforn;
    }

    public void setCodcrediforn(String codcrediforn) {
        this.codcrediforn = codcrediforn;
    }

    public String getNumnota() {
        return numnota;
    }

    public void setNumnota(String numnota) {
        this.numnota = numnota;
    }

    public BigDecimal getValornota() {
        return valornota;
    }

    public void setValornota(BigDecimal valornota) {
        this.valornota = valornota;
    }

    public Character getFlagconcedido() {
        return flagconcedido;
    }

    public void setFlagconcedido(Character flagconcedido) {
        this.flagconcedido = flagconcedido;
    }

    public Character getFlagutilizado() {
        return flagutilizado;
    }

    public void setFlagutilizado(Character flagutilizado) {
        this.flagutilizado = flagutilizado;
    }

    public String getCodcr() {
        return codcr;
    }

    public void setCodcr(String codcr) {
        this.codcr = codcr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcredifornnota != null ? codcredifornnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditormafornecedornota)) {
            return false;
        }
        Creditormafornecedornota other = (Creditormafornecedornota) object;
        if ((this.codcredifornnota == null && other.codcredifornnota != null) || (this.codcredifornnota != null && !this.codcredifornnota.equals(other.codcredifornnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Creditormafornecedornota[ codcredifornnota=" + codcredifornnota + " ]";
    }
    
}
