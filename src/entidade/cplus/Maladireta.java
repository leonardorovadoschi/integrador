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
import javax.persistence.Lob;
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
@Table(name = "MALADIRETA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maladireta.findAll", query = "SELECT m FROM Maladireta m")
    , @NamedQuery(name = "Maladireta.findByCodmaladireta", query = "SELECT m FROM Maladireta m WHERE m.codmaladireta = :codmaladireta")
    , @NamedQuery(name = "Maladireta.findByDatamaladireta", query = "SELECT m FROM Maladireta m WHERE m.datamaladireta = :datamaladireta")
    , @NamedQuery(name = "Maladireta.findByNomemaladireta", query = "SELECT m FROM Maladireta m WHERE m.nomemaladireta = :nomemaladireta")
    , @NamedQuery(name = "Maladireta.findByAssuntoemail", query = "SELECT m FROM Maladireta m WHERE m.assuntoemail = :assuntoemail")
    , @NamedQuery(name = "Maladireta.findByFlaghtml", query = "SELECT m FROM Maladireta m WHERE m.flaghtml = :flaghtml")
    , @NamedQuery(name = "Maladireta.findByNomeemitente", query = "SELECT m FROM Maladireta m WHERE m.nomeemitente = :nomeemitente")
    , @NamedQuery(name = "Maladireta.findByEmailemitente", query = "SELECT m FROM Maladireta m WHERE m.emailemitente = :emailemitente")})
public class Maladireta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMALADIRETA")
    private Integer codmaladireta;
    @Column(name = "DATAMALADIRETA")
    @Temporal(TemporalType.DATE)
    private Date datamaladireta;
    @Column(name = "NOMEMALADIRETA")
    private String nomemaladireta;
    @Column(name = "ASSUNTOEMAIL")
    private String assuntoemail;
    @Lob
    @Column(name = "CORPOEMAIL")
    private String corpoemail;
    @Column(name = "FLAGHTML")
    private Character flaghtml;
    @Column(name = "NOMEEMITENTE")
    private String nomeemitente;
    @Column(name = "EMAILEMITENTE")
    private String emailemitente;

    public Maladireta() {
    }

    public Maladireta(Integer codmaladireta) {
        this.codmaladireta = codmaladireta;
    }

    public Integer getCodmaladireta() {
        return codmaladireta;
    }

    public void setCodmaladireta(Integer codmaladireta) {
        this.codmaladireta = codmaladireta;
    }

    public Date getDatamaladireta() {
        return datamaladireta;
    }

    public void setDatamaladireta(Date datamaladireta) {
        this.datamaladireta = datamaladireta;
    }

    public String getNomemaladireta() {
        return nomemaladireta;
    }

    public void setNomemaladireta(String nomemaladireta) {
        this.nomemaladireta = nomemaladireta;
    }

    public String getAssuntoemail() {
        return assuntoemail;
    }

    public void setAssuntoemail(String assuntoemail) {
        this.assuntoemail = assuntoemail;
    }

    public String getCorpoemail() {
        return corpoemail;
    }

    public void setCorpoemail(String corpoemail) {
        this.corpoemail = corpoemail;
    }

    public Character getFlaghtml() {
        return flaghtml;
    }

    public void setFlaghtml(Character flaghtml) {
        this.flaghtml = flaghtml;
    }

    public String getNomeemitente() {
        return nomeemitente;
    }

    public void setNomeemitente(String nomeemitente) {
        this.nomeemitente = nomeemitente;
    }

    public String getEmailemitente() {
        return emailemitente;
    }

    public void setEmailemitente(String emailemitente) {
        this.emailemitente = emailemitente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmaladireta != null ? codmaladireta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maladireta)) {
            return false;
        }
        Maladireta other = (Maladireta) object;
        if ((this.codmaladireta == null && other.codmaladireta != null) || (this.codmaladireta != null && !this.codmaladireta.equals(other.codmaladireta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Maladireta[ codmaladireta=" + codmaladireta + " ]";
    }
    
}
