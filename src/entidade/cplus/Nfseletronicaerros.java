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
@Table(name = "NFSELETRONICAERROS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nfseletronicaerros.findAll", query = "SELECT n FROM Nfseletronicaerros n")
    , @NamedQuery(name = "Nfseletronicaerros.findByCodnfseletronicaerros", query = "SELECT n FROM Nfseletronicaerros n WHERE n.codnfseletronicaerros = :codnfseletronicaerros")
    , @NamedQuery(name = "Nfseletronicaerros.findByCodigoretorno", query = "SELECT n FROM Nfseletronicaerros n WHERE n.codigoretorno = :codigoretorno")
    , @NamedQuery(name = "Nfseletronicaerros.findByMensagemretorno", query = "SELECT n FROM Nfseletronicaerros n WHERE n.mensagemretorno = :mensagemretorno")
    , @NamedQuery(name = "Nfseletronicaerros.findByCorrecaoretorno", query = "SELECT n FROM Nfseletronicaerros n WHERE n.correcaoretorno = :correcaoretorno")})
public class Nfseletronicaerros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODNFSELETRONICAERROS")
    private Integer codnfseletronicaerros;
    @Column(name = "CODIGORETORNO")
    private String codigoretorno;
    @Column(name = "MENSAGEMRETORNO")
    private String mensagemretorno;
    @Column(name = "CORRECAORETORNO")
    private String correcaoretorno;
    @JoinColumn(name = "CODNFSELETRONICA", referencedColumnName = "CODNFSELETRONICA")
    @ManyToOne(optional = false)
    private Nfseletronica codnfseletronica;

    public Nfseletronicaerros() {
    }

    public Nfseletronicaerros(Integer codnfseletronicaerros) {
        this.codnfseletronicaerros = codnfseletronicaerros;
    }

    public Integer getCodnfseletronicaerros() {
        return codnfseletronicaerros;
    }

    public void setCodnfseletronicaerros(Integer codnfseletronicaerros) {
        this.codnfseletronicaerros = codnfseletronicaerros;
    }

    public String getCodigoretorno() {
        return codigoretorno;
    }

    public void setCodigoretorno(String codigoretorno) {
        this.codigoretorno = codigoretorno;
    }

    public String getMensagemretorno() {
        return mensagemretorno;
    }

    public void setMensagemretorno(String mensagemretorno) {
        this.mensagemretorno = mensagemretorno;
    }

    public String getCorrecaoretorno() {
        return correcaoretorno;
    }

    public void setCorrecaoretorno(String correcaoretorno) {
        this.correcaoretorno = correcaoretorno;
    }

    public Nfseletronica getCodnfseletronica() {
        return codnfseletronica;
    }

    public void setCodnfseletronica(Nfseletronica codnfseletronica) {
        this.codnfseletronica = codnfseletronica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codnfseletronicaerros != null ? codnfseletronicaerros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nfseletronicaerros)) {
            return false;
        }
        Nfseletronicaerros other = (Nfseletronicaerros) object;
        if ((this.codnfseletronicaerros == null && other.codnfseletronicaerros != null) || (this.codnfseletronicaerros != null && !this.codnfseletronicaerros.equals(other.codnfseletronicaerros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Nfseletronicaerros[ codnfseletronicaerros=" + codnfseletronicaerros + " ]";
    }
    
}
