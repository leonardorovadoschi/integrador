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
@Table(name = "TMP_CRMATENDIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpCrmatendimento.findAll", query = "SELECT t FROM TmpCrmatendimento t")
    , @NamedQuery(name = "TmpCrmatendimento.findByCodatend", query = "SELECT t FROM TmpCrmatendimento t WHERE t.codatend = :codatend")
    , @NamedQuery(name = "TmpCrmatendimento.findByCodcli", query = "SELECT t FROM TmpCrmatendimento t WHERE t.codcli = :codcli")})
public class TmpCrmatendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODATEND")
    private String codatend;
    @Column(name = "CODCLI")
    private String codcli;

    public TmpCrmatendimento() {
    }

    public TmpCrmatendimento(String codatend) {
        this.codatend = codatend;
    }

    public String getCodatend() {
        return codatend;
    }

    public void setCodatend(String codatend) {
        this.codatend = codatend;
    }

    public String getCodcli() {
        return codcli;
    }

    public void setCodcli(String codcli) {
        this.codcli = codcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codatend != null ? codatend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpCrmatendimento)) {
            return false;
        }
        TmpCrmatendimento other = (TmpCrmatendimento) object;
        if ((this.codatend == null && other.codatend != null) || (this.codatend != null && !this.codatend.equals(other.codatend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpCrmatendimento[ codatend=" + codatend + " ]";
    }
    
}
