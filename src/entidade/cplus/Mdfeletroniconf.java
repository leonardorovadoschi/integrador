/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MDFELETRONICONF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletroniconf.findAll", query = "SELECT m FROM Mdfeletroniconf m")
    , @NamedQuery(name = "Mdfeletroniconf.findByCodmdfeletroniconf", query = "SELECT m FROM Mdfeletroniconf m WHERE m.codmdfeletroniconf = :codmdfeletroniconf")
    , @NamedQuery(name = "Mdfeletroniconf.findByTotalcarga", query = "SELECT m FROM Mdfeletroniconf m WHERE m.totalcarga = :totalcarga")
    , @NamedQuery(name = "Mdfeletroniconf.findByPesototalcarga", query = "SELECT m FROM Mdfeletroniconf m WHERE m.pesototalcarga = :pesototalcarga")
    , @NamedQuery(name = "Mdfeletroniconf.findByChaveacessonfeletronica", query = "SELECT m FROM Mdfeletroniconf m WHERE m.chaveacessonfeletronica = :chaveacessonfeletronica")
    , @NamedQuery(name = "Mdfeletroniconf.findBySegundocodigobarra", query = "SELECT m FROM Mdfeletroniconf m WHERE m.segundocodigobarra = :segundocodigobarra")})
public class Mdfeletroniconf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICONF")
    private String codmdfeletroniconf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALCARGA")
    private BigDecimal totalcarga;
    @Column(name = "PESOTOTALCARGA")
    private BigDecimal pesototalcarga;
    @Column(name = "CHAVEACESSONFELETRONICA")
    private String chaveacessonfeletronica;
    @Column(name = "SEGUNDOCODIGOBARRA")
    private String segundocodigobarra;
    @JoinColumn(name = "CODDOCUMENTO", referencedColumnName = "CODDOCUMENTO")
    @ManyToOne
    private Documento coddocumento;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;
    @JoinColumn(name = "CODMDFELETRONICOLOCAL", referencedColumnName = "CODMDFELETRONICOLOCAL")
    @ManyToOne(optional = false)
    private Mdfeletronicolocal codmdfeletronicolocal;

    public Mdfeletroniconf() {
    }

    public Mdfeletroniconf(String codmdfeletroniconf) {
        this.codmdfeletroniconf = codmdfeletroniconf;
    }

    public String getCodmdfeletroniconf() {
        return codmdfeletroniconf;
    }

    public void setCodmdfeletroniconf(String codmdfeletroniconf) {
        this.codmdfeletroniconf = codmdfeletroniconf;
    }

    public BigDecimal getTotalcarga() {
        return totalcarga;
    }

    public void setTotalcarga(BigDecimal totalcarga) {
        this.totalcarga = totalcarga;
    }

    public BigDecimal getPesototalcarga() {
        return pesototalcarga;
    }

    public void setPesototalcarga(BigDecimal pesototalcarga) {
        this.pesototalcarga = pesototalcarga;
    }

    public String getChaveacessonfeletronica() {
        return chaveacessonfeletronica;
    }

    public void setChaveacessonfeletronica(String chaveacessonfeletronica) {
        this.chaveacessonfeletronica = chaveacessonfeletronica;
    }

    public String getSegundocodigobarra() {
        return segundocodigobarra;
    }

    public void setSegundocodigobarra(String segundocodigobarra) {
        this.segundocodigobarra = segundocodigobarra;
    }

    public Documento getCoddocumento() {
        return coddocumento;
    }

    public void setCoddocumento(Documento coddocumento) {
        this.coddocumento = coddocumento;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    public Mdfeletronicolocal getCodmdfeletronicolocal() {
        return codmdfeletronicolocal;
    }

    public void setCodmdfeletronicolocal(Mdfeletronicolocal codmdfeletronicolocal) {
        this.codmdfeletronicolocal = codmdfeletronicolocal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletroniconf != null ? codmdfeletroniconf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletroniconf)) {
            return false;
        }
        Mdfeletroniconf other = (Mdfeletroniconf) object;
        if ((this.codmdfeletroniconf == null && other.codmdfeletroniconf != null) || (this.codmdfeletroniconf != null && !this.codmdfeletroniconf.equals(other.codmdfeletroniconf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletroniconf[ codmdfeletroniconf=" + codmdfeletroniconf + " ]";
    }
    
}
