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
@Table(name = "DIAINUTIL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diainutil.findAll", query = "SELECT d FROM Diainutil d")
    , @NamedQuery(name = "Diainutil.findByCoddiainutil", query = "SELECT d FROM Diainutil d WHERE d.coddiainutil = :coddiainutil")
    , @NamedQuery(name = "Diainutil.findByDatainutil", query = "SELECT d FROM Diainutil d WHERE d.datainutil = :datainutil")
    , @NamedQuery(name = "Diainutil.findByMesano", query = "SELECT d FROM Diainutil d WHERE d.mesano = :mesano")
    , @NamedQuery(name = "Diainutil.findByFlagtipo", query = "SELECT d FROM Diainutil d WHERE d.flagtipo = :flagtipo")
    , @NamedQuery(name = "Diainutil.findByNomediainutil", query = "SELECT d FROM Diainutil d WHERE d.nomediainutil = :nomediainutil")
    , @NamedQuery(name = "Diainutil.findByDiames", query = "SELECT d FROM Diainutil d WHERE d.diames = :diames")})
public class Diainutil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODDIAINUTIL")
    private String coddiainutil;
    @Column(name = "DATAINUTIL")
    @Temporal(TemporalType.DATE)
    private Date datainutil;
    @Column(name = "MESANO")
    private String mesano;
    @Column(name = "FLAGTIPO")
    private String flagtipo;
    @Column(name = "NOMEDIAINUTIL")
    private String nomediainutil;
    @Column(name = "DIAMES")
    private String diames;

    public Diainutil() {
    }

    public Diainutil(String coddiainutil) {
        this.coddiainutil = coddiainutil;
    }

    public String getCoddiainutil() {
        return coddiainutil;
    }

    public void setCoddiainutil(String coddiainutil) {
        this.coddiainutil = coddiainutil;
    }

    public Date getDatainutil() {
        return datainutil;
    }

    public void setDatainutil(Date datainutil) {
        this.datainutil = datainutil;
    }

    public String getMesano() {
        return mesano;
    }

    public void setMesano(String mesano) {
        this.mesano = mesano;
    }

    public String getFlagtipo() {
        return flagtipo;
    }

    public void setFlagtipo(String flagtipo) {
        this.flagtipo = flagtipo;
    }

    public String getNomediainutil() {
        return nomediainutil;
    }

    public void setNomediainutil(String nomediainutil) {
        this.nomediainutil = nomediainutil;
    }

    public String getDiames() {
        return diames;
    }

    public void setDiames(String diames) {
        this.diames = diames;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddiainutil != null ? coddiainutil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diainutil)) {
            return false;
        }
        Diainutil other = (Diainutil) object;
        if ((this.coddiainutil == null && other.coddiainutil != null) || (this.coddiainutil != null && !this.coddiainutil.equals(other.coddiainutil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Diainutil[ coddiainutil=" + coddiainutil + " ]";
    }
    
}
