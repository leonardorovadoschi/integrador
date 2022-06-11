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
@Table(name = "MONTAGEMARQUIVOITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Montagemarquivoitem.findAll", query = "SELECT m FROM Montagemarquivoitem m")
    , @NamedQuery(name = "Montagemarquivoitem.findByCodmontagemarquivoitem", query = "SELECT m FROM Montagemarquivoitem m WHERE m.codmontagemarquivoitem = :codmontagemarquivoitem")
    , @NamedQuery(name = "Montagemarquivoitem.findByOrdem", query = "SELECT m FROM Montagemarquivoitem m WHERE m.ordem = :ordem")})
public class Montagemarquivoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMONTAGEMARQUIVOITEM")
    private String codmontagemarquivoitem;
    @Column(name = "ORDEM")
    private Integer ordem;
    @JoinColumn(name = "CODARQUIVOREGISTRO", referencedColumnName = "CODARQUIVOREGISTRO")
    @ManyToOne
    private Arquivoregistro codarquivoregistro;
    @JoinColumn(name = "CODLOTEMONTAGEMARQUIVO", referencedColumnName = "CODLOTEMONTAGEMARQUIVO")
    @ManyToOne
    private Lotemontagemarquivo codlotemontagemarquivo;
    @JoinColumn(name = "CODMONTAGEMARQUIVO", referencedColumnName = "CODMONTAGEMARQUIVO")
    @ManyToOne
    private Montagemarquivo codmontagemarquivo;

    public Montagemarquivoitem() {
    }

    public Montagemarquivoitem(String codmontagemarquivoitem) {
        this.codmontagemarquivoitem = codmontagemarquivoitem;
    }

    public String getCodmontagemarquivoitem() {
        return codmontagemarquivoitem;
    }

    public void setCodmontagemarquivoitem(String codmontagemarquivoitem) {
        this.codmontagemarquivoitem = codmontagemarquivoitem;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Arquivoregistro getCodarquivoregistro() {
        return codarquivoregistro;
    }

    public void setCodarquivoregistro(Arquivoregistro codarquivoregistro) {
        this.codarquivoregistro = codarquivoregistro;
    }

    public Lotemontagemarquivo getCodlotemontagemarquivo() {
        return codlotemontagemarquivo;
    }

    public void setCodlotemontagemarquivo(Lotemontagemarquivo codlotemontagemarquivo) {
        this.codlotemontagemarquivo = codlotemontagemarquivo;
    }

    public Montagemarquivo getCodmontagemarquivo() {
        return codmontagemarquivo;
    }

    public void setCodmontagemarquivo(Montagemarquivo codmontagemarquivo) {
        this.codmontagemarquivo = codmontagemarquivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmontagemarquivoitem != null ? codmontagemarquivoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Montagemarquivoitem)) {
            return false;
        }
        Montagemarquivoitem other = (Montagemarquivoitem) object;
        if ((this.codmontagemarquivoitem == null && other.codmontagemarquivoitem != null) || (this.codmontagemarquivoitem != null && !this.codmontagemarquivoitem.equals(other.codmontagemarquivoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Montagemarquivoitem[ codmontagemarquivoitem=" + codmontagemarquivoitem + " ]";
    }
    
}
