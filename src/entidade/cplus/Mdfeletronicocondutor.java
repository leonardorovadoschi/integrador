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
@Table(name = "MDFELETRONICOCONDUTOR", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mdfeletronicocondutor.findAll", query = "SELECT m FROM Mdfeletronicocondutor m")
    , @NamedQuery(name = "Mdfeletronicocondutor.findByCodmdfeletronicocondutor", query = "SELECT m FROM Mdfeletronicocondutor m WHERE m.codmdfeletronicocondutor = :codmdfeletronicocondutor")
    , @NamedQuery(name = "Mdfeletronicocondutor.findByNumseqevento", query = "SELECT m FROM Mdfeletronicocondutor m WHERE m.numseqevento = :numseqevento")})
public class Mdfeletronicocondutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMDFELETRONICOCONDUTOR")
    private String codmdfeletronicocondutor;
    @Column(name = "NUMSEQEVENTO")
    private Short numseqevento;
    @JoinColumn(name = "CODENTREGAPESSOA", referencedColumnName = "CODENTREGAPESSOA")
    @ManyToOne(optional = false)
    private Entregapessoa codentregapessoa;
    @JoinColumn(name = "CODMDFELETRONICO", referencedColumnName = "CODMDFELETRONICO")
    @ManyToOne(optional = false)
    private Mdfeletronico codmdfeletronico;

    public Mdfeletronicocondutor() {
    }

    public Mdfeletronicocondutor(String codmdfeletronicocondutor) {
        this.codmdfeletronicocondutor = codmdfeletronicocondutor;
    }

    public String getCodmdfeletronicocondutor() {
        return codmdfeletronicocondutor;
    }

    public void setCodmdfeletronicocondutor(String codmdfeletronicocondutor) {
        this.codmdfeletronicocondutor = codmdfeletronicocondutor;
    }

    public Short getNumseqevento() {
        return numseqevento;
    }

    public void setNumseqevento(Short numseqevento) {
        this.numseqevento = numseqevento;
    }

    public Entregapessoa getCodentregapessoa() {
        return codentregapessoa;
    }

    public void setCodentregapessoa(Entregapessoa codentregapessoa) {
        this.codentregapessoa = codentregapessoa;
    }

    public Mdfeletronico getCodmdfeletronico() {
        return codmdfeletronico;
    }

    public void setCodmdfeletronico(Mdfeletronico codmdfeletronico) {
        this.codmdfeletronico = codmdfeletronico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmdfeletronicocondutor != null ? codmdfeletronicocondutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mdfeletronicocondutor)) {
            return false;
        }
        Mdfeletronicocondutor other = (Mdfeletronicocondutor) object;
        if ((this.codmdfeletronicocondutor == null && other.codmdfeletronicocondutor != null) || (this.codmdfeletronicocondutor != null && !this.codmdfeletronicocondutor.equals(other.codmdfeletronicocondutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Mdfeletronicocondutor[ codmdfeletronicocondutor=" + codmdfeletronicocondutor + " ]";
    }
    
}
