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
@Table(name = "MENUEXTRA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menuextra.findAll", query = "SELECT m FROM Menuextra m")
    , @NamedQuery(name = "Menuextra.findByCodmenuextra", query = "SELECT m FROM Menuextra m WHERE m.codmenuextra = :codmenuextra")
    , @NamedQuery(name = "Menuextra.findByNomemenuextra", query = "SELECT m FROM Menuextra m WHERE m.nomemenuextra = :nomemenuextra")
    , @NamedQuery(name = "Menuextra.findByPrograma", query = "SELECT m FROM Menuextra m WHERE m.programa = :programa")
    , @NamedQuery(name = "Menuextra.findByParametros", query = "SELECT m FROM Menuextra m WHERE m.parametros = :parametros")
    , @NamedQuery(name = "Menuextra.findByFlagloginautomatico", query = "SELECT m FROM Menuextra m WHERE m.flagloginautomatico = :flagloginautomatico")})
public class Menuextra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMENUEXTRA")
    private String codmenuextra;
    @Column(name = "NOMEMENUEXTRA")
    private String nomemenuextra;
    @Column(name = "PROGRAMA")
    private String programa;
    @Column(name = "PARAMETROS")
    private String parametros;
    @Column(name = "FLAGLOGINAUTOMATICO")
    private Character flagloginautomatico;

    public Menuextra() {
    }

    public Menuextra(String codmenuextra) {
        this.codmenuextra = codmenuextra;
    }

    public String getCodmenuextra() {
        return codmenuextra;
    }

    public void setCodmenuextra(String codmenuextra) {
        this.codmenuextra = codmenuextra;
    }

    public String getNomemenuextra() {
        return nomemenuextra;
    }

    public void setNomemenuextra(String nomemenuextra) {
        this.nomemenuextra = nomemenuextra;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public Character getFlagloginautomatico() {
        return flagloginautomatico;
    }

    public void setFlagloginautomatico(Character flagloginautomatico) {
        this.flagloginautomatico = flagloginautomatico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmenuextra != null ? codmenuextra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menuextra)) {
            return false;
        }
        Menuextra other = (Menuextra) object;
        if ((this.codmenuextra == null && other.codmenuextra != null) || (this.codmenuextra != null && !this.codmenuextra.equals(other.codmenuextra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Menuextra[ codmenuextra=" + codmenuextra + " ]";
    }
    
}
