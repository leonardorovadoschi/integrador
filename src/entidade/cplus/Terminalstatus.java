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
@Table(name = "TERMINALSTATUS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminalstatus.findAll", query = "SELECT t FROM Terminalstatus t")
    , @NamedQuery(name = "Terminalstatus.findByCodterminal", query = "SELECT t FROM Terminalstatus t WHERE t.codterminal = :codterminal")
    , @NamedQuery(name = "Terminalstatus.findByCoddocumentocaixaabertura", query = "SELECT t FROM Terminalstatus t WHERE t.coddocumentocaixaabertura = :coddocumentocaixaabertura")
    , @NamedQuery(name = "Terminalstatus.findByStatusterminal", query = "SELECT t FROM Terminalstatus t WHERE t.statusterminal = :statusterminal")
    , @NamedQuery(name = "Terminalstatus.findByCoduser", query = "SELECT t FROM Terminalstatus t WHERE t.coduser = :coduser")
    , @NamedQuery(name = "Terminalstatus.findByGuidabertura", query = "SELECT t FROM Terminalstatus t WHERE t.guidabertura = :guidabertura")})
public class Terminalstatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTERMINAL")
    private String codterminal;
    @Column(name = "CODDOCUMENTOCAIXAABERTURA")
    private String coddocumentocaixaabertura;
    @Column(name = "STATUSTERMINAL")
    private Character statusterminal;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "GUIDABERTURA")
    private String guidabertura;

    public Terminalstatus() {
    }

    public Terminalstatus(String codterminal) {
        this.codterminal = codterminal;
    }

    public String getCodterminal() {
        return codterminal;
    }

    public void setCodterminal(String codterminal) {
        this.codterminal = codterminal;
    }

    public String getCoddocumentocaixaabertura() {
        return coddocumentocaixaabertura;
    }

    public void setCoddocumentocaixaabertura(String coddocumentocaixaabertura) {
        this.coddocumentocaixaabertura = coddocumentocaixaabertura;
    }

    public Character getStatusterminal() {
        return statusterminal;
    }

    public void setStatusterminal(Character statusterminal) {
        this.statusterminal = statusterminal;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
    }

    public String getGuidabertura() {
        return guidabertura;
    }

    public void setGuidabertura(String guidabertura) {
        this.guidabertura = guidabertura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codterminal != null ? codterminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminalstatus)) {
            return false;
        }
        Terminalstatus other = (Terminalstatus) object;
        if ((this.codterminal == null && other.codterminal != null) || (this.codterminal != null && !this.codterminal.equals(other.codterminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Terminalstatus[ codterminal=" + codterminal + " ]";
    }
    
}
