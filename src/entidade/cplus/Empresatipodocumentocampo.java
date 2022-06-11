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
@Table(name = "EMPRESATIPODOCUMENTOCAMPO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresatipodocumentocampo.findAll", query = "SELECT e FROM Empresatipodocumentocampo e")
    , @NamedQuery(name = "Empresatipodocumentocampo.findByCodempresatipodocumentocampo", query = "SELECT e FROM Empresatipodocumentocampo e WHERE e.codempresatipodocumentocampo = :codempresatipodocumentocampo")
    , @NamedQuery(name = "Empresatipodocumentocampo.findByCampocustom", query = "SELECT e FROM Empresatipodocumentocampo e WHERE e.campocustom = :campocustom")
    , @NamedQuery(name = "Empresatipodocumentocampo.findByCampo", query = "SELECT e FROM Empresatipodocumentocampo e WHERE e.campo = :campo")
    , @NamedQuery(name = "Empresatipodocumentocampo.findByFlagtipo", query = "SELECT e FROM Empresatipodocumentocampo e WHERE e.flagtipo = :flagtipo")
    , @NamedQuery(name = "Empresatipodocumentocampo.findByFlagfixo", query = "SELECT e FROM Empresatipodocumentocampo e WHERE e.flagfixo = :flagfixo")})
public class Empresatipodocumentocampo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEMPRESATIPODOCUMENTOCAMPO")
    private String codempresatipodocumentocampo;
    @Column(name = "CAMPOCUSTOM")
    private String campocustom;
    @Column(name = "CAMPO")
    private String campo;
    @Column(name = "FLAGTIPO")
    private Character flagtipo;
    @Column(name = "FLAGFIXO")
    private Character flagfixo;
    @JoinColumn(name = "CODEMPRESATIPODOCUMENTO", referencedColumnName = "CODEMPRESATIPODOCUMENTO")
    @ManyToOne(optional = false)
    private Empresatipodocumento codempresatipodocumento;

    public Empresatipodocumentocampo() {
    }

    public Empresatipodocumentocampo(String codempresatipodocumentocampo) {
        this.codempresatipodocumentocampo = codempresatipodocumentocampo;
    }

    public String getCodempresatipodocumentocampo() {
        return codempresatipodocumentocampo;
    }

    public void setCodempresatipodocumentocampo(String codempresatipodocumentocampo) {
        this.codempresatipodocumentocampo = codempresatipodocumentocampo;
    }

    public String getCampocustom() {
        return campocustom;
    }

    public void setCampocustom(String campocustom) {
        this.campocustom = campocustom;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Character getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(Character flagtipo) {
        this.flagtipo = flagtipo;
    }

    public Character getFlagfixo() {
        return flagfixo;
    }

    public void setFlagfixo(Character flagfixo) {
        this.flagfixo = flagfixo;
    }

    public Empresatipodocumento getCodempresatipodocumento() {
        return codempresatipodocumento;
    }

    public void setCodempresatipodocumento(Empresatipodocumento codempresatipodocumento) {
        this.codempresatipodocumento = codempresatipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codempresatipodocumentocampo != null ? codempresatipodocumentocampo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresatipodocumentocampo)) {
            return false;
        }
        Empresatipodocumentocampo other = (Empresatipodocumentocampo) object;
        if ((this.codempresatipodocumentocampo == null && other.codempresatipodocumentocampo != null) || (this.codempresatipodocumentocampo != null && !this.codempresatipodocumentocampo.equals(other.codempresatipodocumentocampo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Empresatipodocumentocampo[ codempresatipodocumentocampo=" + codempresatipodocumentocampo + " ]";
    }
    
}
