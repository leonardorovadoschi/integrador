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
public class MovfiscoestoquemensalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODEMPRESA")
    private int codempresa;
    @Basic(optional = false)
    @Column(name = "MES")
    private short mes;
    @Basic(optional = false)
    @Column(name = "ANO")
    private short ano;

    public MovfiscoestoquemensalPK() {
    }

    public MovfiscoestoquemensalPK(int codempresa, short mes, short ano) {
        this.codempresa = codempresa;
        this.mes = mes;
        this.ano = ano;
    }

    public int getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(int codempresa) {
        this.codempresa = codempresa;
    }

    public short getMes() {
        return mes;
    }

    public void setMes(short mes) {
        this.mes = mes;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codempresa;
        hash += (int) mes;
        hash += (int) ano;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovfiscoestoquemensalPK)) {
            return false;
        }
        MovfiscoestoquemensalPK other = (MovfiscoestoquemensalPK) object;
        if (this.codempresa != other.codempresa) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.MovfiscoestoquemensalPK[ codempresa=" + codempresa + ", mes=" + mes + ", ano=" + ano + " ]";
    }
    
}
