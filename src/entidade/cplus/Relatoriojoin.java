/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "RELATORIOJOIN", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatoriojoin.findAll", query = "SELECT r FROM Relatoriojoin r")
    , @NamedQuery(name = "Relatoriojoin.findByNometabela1", query = "SELECT r FROM Relatoriojoin r WHERE r.relatoriojoinPK.nometabela1 = :nometabela1")
    , @NamedQuery(name = "Relatoriojoin.findByNometabela2", query = "SELECT r FROM Relatoriojoin r WHERE r.relatoriojoinPK.nometabela2 = :nometabela2")
    , @NamedQuery(name = "Relatoriojoin.findByTipojoin", query = "SELECT r FROM Relatoriojoin r WHERE r.tipojoin = :tipojoin")
    , @NamedQuery(name = "Relatoriojoin.findByNomecampos1", query = "SELECT r FROM Relatoriojoin r WHERE r.nomecampos1 = :nomecampos1")
    , @NamedQuery(name = "Relatoriojoin.findByOperadores", query = "SELECT r FROM Relatoriojoin r WHERE r.operadores = :operadores")
    , @NamedQuery(name = "Relatoriojoin.findByNomecampos2", query = "SELECT r FROM Relatoriojoin r WHERE r.nomecampos2 = :nomecampos2")})
public class Relatoriojoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelatoriojoinPK relatoriojoinPK;
    @Column(name = "TIPOJOIN")
    private String tipojoin;
    @Column(name = "NOMECAMPOS1")
    private String nomecampos1;
    @Column(name = "OPERADORES")
    private String operadores;
    @Column(name = "NOMECAMPOS2")
    private String nomecampos2;

    public Relatoriojoin() {
    }

    public Relatoriojoin(RelatoriojoinPK relatoriojoinPK) {
        this.relatoriojoinPK = relatoriojoinPK;
    }

    public Relatoriojoin(String nometabela1, String nometabela2) {
        this.relatoriojoinPK = new RelatoriojoinPK(nometabela1, nometabela2);
    }

    public RelatoriojoinPK getRelatoriojoinPK() {
        return relatoriojoinPK;
    }

    public void setRelatoriojoinPK(RelatoriojoinPK relatoriojoinPK) {
        this.relatoriojoinPK = relatoriojoinPK;
    }

    public String getTipojoin() {
        return tipojoin;
    }

    public void setTipojoin(String tipojoin) {
        this.tipojoin = tipojoin;
    }

    public String getNomecampos1() {
        return nomecampos1;
    }

    public void setNomecampos1(String nomecampos1) {
        this.nomecampos1 = nomecampos1;
    }

    public String getOperadores() {
        return operadores;
    }

    public void setOperadores(String operadores) {
        this.operadores = operadores;
    }

    public String getNomecampos2() {
        return nomecampos2;
    }

    public void setNomecampos2(String nomecampos2) {
        this.nomecampos2 = nomecampos2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relatoriojoinPK != null ? relatoriojoinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relatoriojoin)) {
            return false;
        }
        Relatoriojoin other = (Relatoriojoin) object;
        if ((this.relatoriojoinPK == null && other.relatoriojoinPK != null) || (this.relatoriojoinPK != null && !this.relatoriojoinPK.equals(other.relatoriojoinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Relatoriojoin[ relatoriojoinPK=" + relatoriojoinPK + " ]";
    }
    
}
