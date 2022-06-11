/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "PLUPDV", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plupdv.findAll", query = "SELECT p FROM Plupdv p")
    , @NamedQuery(name = "Plupdv.findByCodplupdv", query = "SELECT p FROM Plupdv p WHERE p.codplupdv = :codplupdv")
    , @NamedQuery(name = "Plupdv.findByCaminhoarquivo", query = "SELECT p FROM Plupdv p WHERE p.caminhoarquivo = :caminhoarquivo")
    , @NamedQuery(name = "Plupdv.findByData", query = "SELECT p FROM Plupdv p WHERE p.data = :data")
    , @NamedQuery(name = "Plupdv.findByTamanho", query = "SELECT p FROM Plupdv p WHERE p.tamanho = :tamanho")
    , @NamedQuery(name = "Plupdv.findByFlagtipoplu", query = "SELECT p FROM Plupdv p WHERE p.flagtipoplu = :flagtipoplu")
    , @NamedQuery(name = "Plupdv.findByFlagenviada", query = "SELECT p FROM Plupdv p WHERE p.flagenviada = :flagenviada")
    , @NamedQuery(name = "Plupdv.findByCodempresa", query = "SELECT p FROM Plupdv p WHERE p.codempresa = :codempresa")})
public class Plupdv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODPLUPDV")
    private String codplupdv;
    @Basic(optional = false)
    @Column(name = "CAMINHOARQUIVO")
    private String caminhoarquivo;
    @Basic(optional = false)
    @Column(name = "DATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAMANHO")
    private BigDecimal tamanho;
    @Column(name = "FLAGTIPOPLU")
    private Character flagtipoplu;
    @Column(name = "FLAGENVIADA")
    private Character flagenviada;
    @Column(name = "CODEMPRESA")
    private Integer codempresa;

    public Plupdv() {
    }

    public Plupdv(String codplupdv) {
        this.codplupdv = codplupdv;
    }

    public Plupdv(String codplupdv, String caminhoarquivo, Date data) {
        this.codplupdv = codplupdv;
        this.caminhoarquivo = caminhoarquivo;
        this.data = data;
    }

    public String getCodplupdv() {
        return codplupdv;
    }

    public void setCodplupdv(String codplupdv) {
        this.codplupdv = codplupdv;
    }

    public String getCaminhoarquivo() {
        return caminhoarquivo;
    }

    public void setCaminhoarquivo(String caminhoarquivo) {
        this.caminhoarquivo = caminhoarquivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getTamanho() {
        return tamanho;
    }

    public void setTamanho(BigDecimal tamanho) {
        this.tamanho = tamanho;
    }

    public Character getFlagtipoplu() {
        return flagtipoplu;
    }

    public void setFlagtipoplu(Character flagtipoplu) {
        this.flagtipoplu = flagtipoplu;
    }

    public Character getFlagenviada() {
        return flagenviada;
    }

    public void setFlagenviada(Character flagenviada) {
        this.flagenviada = flagenviada;
    }

    public Integer getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Integer codempresa) {
        this.codempresa = codempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codplupdv != null ? codplupdv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plupdv)) {
            return false;
        }
        Plupdv other = (Plupdv) object;
        if ((this.codplupdv == null && other.codplupdv != null) || (this.codplupdv != null && !this.codplupdv.equals(other.codplupdv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Plupdv[ codplupdv=" + codplupdv + " ]";
    }
    
}
