/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "MOVFISCOESTOQUEMENSAL", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movfiscoestoquemensal.findAll", query = "SELECT m FROM Movfiscoestoquemensal m")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByCodempresa", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.movfiscoestoquemensalPK.codempresa = :codempresa")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByMes", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.movfiscoestoquemensalPK.mes = :mes")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByAno", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.movfiscoestoquemensalPK.ano = :ano")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByFlagassinado", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.flagassinado = :flagassinado")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByFlagtransmitido", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.flagtransmitido = :flagtransmitido")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByRecibo", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.recibo = :recibo")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByNomearquivo", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.nomearquivo = :nomearquivo")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByDhgerado", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.dhgerado = :dhgerado")
    , @NamedQuery(name = "Movfiscoestoquemensal.findByDhrecebido", query = "SELECT m FROM Movfiscoestoquemensal m WHERE m.dhrecebido = :dhrecebido")})
public class Movfiscoestoquemensal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovfiscoestoquemensalPK movfiscoestoquemensalPK;
    @Column(name = "FLAGASSINADO")
    private Character flagassinado;
    @Column(name = "FLAGTRANSMITIDO")
    private Character flagtransmitido;
    @Column(name = "RECIBO")
    private String recibo;
    @Column(name = "NOMEARQUIVO")
    private String nomearquivo;
    @Column(name = "DHGERADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhgerado;
    @Column(name = "DHRECEBIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dhrecebido;
    @Lob
    @Column(name = "ARQUIVOXML")
    private String arquivoxml;

    public Movfiscoestoquemensal() {
    }

    public Movfiscoestoquemensal(MovfiscoestoquemensalPK movfiscoestoquemensalPK) {
        this.movfiscoestoquemensalPK = movfiscoestoquemensalPK;
    }

    public Movfiscoestoquemensal(int codempresa, short mes, short ano) {
        this.movfiscoestoquemensalPK = new MovfiscoestoquemensalPK(codempresa, mes, ano);
    }

    public MovfiscoestoquemensalPK getMovfiscoestoquemensalPK() {
        return movfiscoestoquemensalPK;
    }

    public void setMovfiscoestoquemensalPK(MovfiscoestoquemensalPK movfiscoestoquemensalPK) {
        this.movfiscoestoquemensalPK = movfiscoestoquemensalPK;
    }

    public Character getFlagassinado() {
        return flagassinado;
    }

    public void setFlagassinado(Character flagassinado) {
        this.flagassinado = flagassinado;
    }

    public Character getFlagtransmitido() {
        return flagtransmitido;
    }

    public void setFlagtransmitido(Character flagtransmitido) {
        this.flagtransmitido = flagtransmitido;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Date getDhgerado() {
        return dhgerado;
    }

    public void setDhgerado(Date dhgerado) {
        this.dhgerado = dhgerado;
    }

    public Date getDhrecebido() {
        return dhrecebido;
    }

    public void setDhrecebido(Date dhrecebido) {
        this.dhrecebido = dhrecebido;
    }

    public String getArquivoxml() {
        return arquivoxml;
    }

    public void setArquivoxml(String arquivoxml) {
        this.arquivoxml = arquivoxml;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movfiscoestoquemensalPK != null ? movfiscoestoquemensalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movfiscoestoquemensal)) {
            return false;
        }
        Movfiscoestoquemensal other = (Movfiscoestoquemensal) object;
        if ((this.movfiscoestoquemensalPK == null && other.movfiscoestoquemensalPK != null) || (this.movfiscoestoquemensalPK != null && !this.movfiscoestoquemensalPK.equals(other.movfiscoestoquemensalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Movfiscoestoquemensal[ movfiscoestoquemensalPK=" + movfiscoestoquemensalPK + " ]";
    }
    
}
