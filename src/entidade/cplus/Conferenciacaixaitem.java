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
@Table(name = "CONFERENCIACAIXAITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conferenciacaixaitem.findAll", query = "SELECT c FROM Conferenciacaixaitem c")
    , @NamedQuery(name = "Conferenciacaixaitem.findByCodconferenciacaixaitem", query = "SELECT c FROM Conferenciacaixaitem c WHERE c.codconferenciacaixaitem = :codconferenciacaixaitem")
    , @NamedQuery(name = "Conferenciacaixaitem.findByValorinformado", query = "SELECT c FROM Conferenciacaixaitem c WHERE c.valorinformado = :valorinformado")})
public class Conferenciacaixaitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCONFERENCIACAIXAITEM")
    private String codconferenciacaixaitem;
    @Column(name = "VALORINFORMADO")
    private String valorinformado;
    @JoinColumn(name = "CODCONFERENCIACAIXA", referencedColumnName = "CODCONFERENCIACAIXA")
    @ManyToOne
    private Conferenciacaixa codconferenciacaixa;
    @JoinColumn(name = "CODREC", referencedColumnName = "CODREC")
    @ManyToOne
    private Recebimento codrec;

    public Conferenciacaixaitem() {
    }

    public Conferenciacaixaitem(String codconferenciacaixaitem) {
        this.codconferenciacaixaitem = codconferenciacaixaitem;
    }

    public String getCodconferenciacaixaitem() {
        return codconferenciacaixaitem;
    }

    public void setCodconferenciacaixaitem(String codconferenciacaixaitem) {
        this.codconferenciacaixaitem = codconferenciacaixaitem;
    }

    public String getValorinformado() {
        return valorinformado;
    }

    public void setValorinformado(String valorinformado) {
        this.valorinformado = valorinformado;
    }

    public Conferenciacaixa getCodconferenciacaixa() {
        return codconferenciacaixa;
    }

    public void setCodconferenciacaixa(Conferenciacaixa codconferenciacaixa) {
        this.codconferenciacaixa = codconferenciacaixa;
    }

    public Recebimento getCodrec() {
        return codrec;
    }

    public void setCodrec(Recebimento codrec) {
        this.codrec = codrec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codconferenciacaixaitem != null ? codconferenciacaixaitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conferenciacaixaitem)) {
            return false;
        }
        Conferenciacaixaitem other = (Conferenciacaixaitem) object;
        if ((this.codconferenciacaixaitem == null && other.codconferenciacaixaitem != null) || (this.codconferenciacaixaitem != null && !this.codconferenciacaixaitem.equals(other.codconferenciacaixaitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Conferenciacaixaitem[ codconferenciacaixaitem=" + codconferenciacaixaitem + " ]";
    }
    
}
