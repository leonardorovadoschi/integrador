/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author leo
 */
@Embeddable
public class RelatorioitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODRELATORIOPASTA")
    private int codrelatoriopasta;
    @Basic(optional = false)
    @Column(name = "NOMEITEM")
    private String nomeitem;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private int tipo;
    @Basic(optional = false)
    @Column(name = "FLAGMODIFICADO")
    private double flagmodificado;

    public RelatorioitemPK() {
    }

    public RelatorioitemPK(int codrelatoriopasta, String nomeitem, int tipo, double flagmodificado) {
        this.codrelatoriopasta = codrelatoriopasta;
        this.nomeitem = nomeitem;
        this.tipo = tipo;
        this.flagmodificado = flagmodificado;
    }

    public int getCodrelatoriopasta() {
        return codrelatoriopasta;
    }

    public void setCodrelatoriopasta(int codrelatoriopasta) {
        this.codrelatoriopasta = codrelatoriopasta;
    }

    public String getNomeitem() {
        return nomeitem;
    }

    public void setNomeitem(String nomeitem) {
        this.nomeitem = nomeitem;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getFlagmodificado() {
        return flagmodificado;
    }

    public void setFlagmodificado(double flagmodificado) {
        this.flagmodificado = flagmodificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codrelatoriopasta;
        hash += (nomeitem != null ? nomeitem.hashCode() : 0);
        hash += (int) tipo;
        hash += (int) flagmodificado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatorioitemPK)) {
            return false;
        }
        RelatorioitemPK other = (RelatorioitemPK) object;
        if (this.codrelatoriopasta != other.codrelatoriopasta) {
            return false;
        }
        if ((this.nomeitem == null && other.nomeitem != null) || (this.nomeitem != null && !this.nomeitem.equals(other.nomeitem))) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.flagmodificado != other.flagmodificado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.RelatorioitemPK[ codrelatoriopasta=" + codrelatoriopasta + ", nomeitem=" + nomeitem + ", tipo=" + tipo + ", flagmodificado=" + flagmodificado + " ]";
    }
    
}
