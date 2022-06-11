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
@Table(name = "COTACAOFORNECEDOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotacaofornecedor.findAll", query = "SELECT c FROM Cotacaofornecedor c")
    , @NamedQuery(name = "Cotacaofornecedor.findByCodcotacaofornecedor", query = "SELECT c FROM Cotacaofornecedor c WHERE c.codcotacaofornecedor = :codcotacaofornecedor")
    , @NamedQuery(name = "Cotacaofornecedor.findByFlagenviado", query = "SELECT c FROM Cotacaofornecedor c WHERE c.flagenviado = :flagenviado")
    , @NamedQuery(name = "Cotacaofornecedor.findByLastChange", query = "SELECT c FROM Cotacaofornecedor c WHERE c.lastChange = :lastChange")})
public class Cotacaofornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCOTACAOFORNECEDOR")
    private String codcotacaofornecedor;
    @Lob
    @Column(name = "OBSCOTACAOFORNECEDOR")
    private String obscotacaofornecedor;
    @Column(name = "FLAGENVIADO")
    private Character flagenviado;
    @Column(name = "LAST_CHANGE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChange;
    @JoinColumn(name = "CODCOTACAO", referencedColumnName = "CODCOTACAO")
    @ManyToOne
    private Cotacao codcotacao;
    @JoinColumn(name = "CODFORN", referencedColumnName = "CODFORN")
    @ManyToOne
    private Fornecedor codforn;

    public Cotacaofornecedor() {
    }

    public Cotacaofornecedor(String codcotacaofornecedor) {
        this.codcotacaofornecedor = codcotacaofornecedor;
    }

    public String getCodcotacaofornecedor() {
        return codcotacaofornecedor;
    }

    public void setCodcotacaofornecedor(String codcotacaofornecedor) {
        this.codcotacaofornecedor = codcotacaofornecedor;
    }

    public String getObscotacaofornecedor() {
        return obscotacaofornecedor;
    }

    public void setObscotacaofornecedor(String obscotacaofornecedor) {
        this.obscotacaofornecedor = obscotacaofornecedor;
    }

    public Character getFlagenviado() {
        return flagenviado;
    }

    public void setFlagenviado(Character flagenviado) {
        this.flagenviado = flagenviado;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Cotacao getCodcotacao() {
        return codcotacao;
    }

    public void setCodcotacao(Cotacao codcotacao) {
        this.codcotacao = codcotacao;
    }

    public Fornecedor getCodforn() {
        return codforn;
    }

    public void setCodforn(Fornecedor codforn) {
        this.codforn = codforn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcotacaofornecedor != null ? codcotacaofornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotacaofornecedor)) {
            return false;
        }
        Cotacaofornecedor other = (Cotacaofornecedor) object;
        if ((this.codcotacaofornecedor == null && other.codcotacaofornecedor != null) || (this.codcotacaofornecedor != null && !this.codcotacaofornecedor.equals(other.codcotacaofornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cotacaofornecedor[ codcotacaofornecedor=" + codcotacaofornecedor + " ]";
    }
    
}
