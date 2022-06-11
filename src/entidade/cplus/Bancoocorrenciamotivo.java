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
@Table(name = "BANCOOCORRENCIAMOTIVO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancoocorrenciamotivo.findAll", query = "SELECT b FROM Bancoocorrenciamotivo b")
    , @NamedQuery(name = "Bancoocorrenciamotivo.findByCodbancoocorrenciamotivo", query = "SELECT b FROM Bancoocorrenciamotivo b WHERE b.codbancoocorrenciamotivo = :codbancoocorrenciamotivo")
    , @NamedQuery(name = "Bancoocorrenciamotivo.findByCodigomotivo", query = "SELECT b FROM Bancoocorrenciamotivo b WHERE b.codigomotivo = :codigomotivo")
    , @NamedQuery(name = "Bancoocorrenciamotivo.findByDescricaomotivo", query = "SELECT b FROM Bancoocorrenciamotivo b WHERE b.descricaomotivo = :descricaomotivo")})
public class Bancoocorrenciamotivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODBANCOOCORRENCIAMOTIVO")
    private String codbancoocorrenciamotivo;
    @Column(name = "CODIGOMOTIVO")
    private String codigomotivo;
    @Column(name = "DESCRICAOMOTIVO")
    private String descricaomotivo;
    @JoinColumn(name = "CODBANCOOCORRENCIA", referencedColumnName = "CODBANCOOCORRENCIA")
    @ManyToOne
    private Bancoocorrencia codbancoocorrencia;

    public Bancoocorrenciamotivo() {
    }

    public Bancoocorrenciamotivo(String codbancoocorrenciamotivo) {
        this.codbancoocorrenciamotivo = codbancoocorrenciamotivo;
    }

    public String getCodbancoocorrenciamotivo() {
        return codbancoocorrenciamotivo;
    }

    public void setCodbancoocorrenciamotivo(String codbancoocorrenciamotivo) {
        this.codbancoocorrenciamotivo = codbancoocorrenciamotivo;
    }

    public String getCodigomotivo() {
        return codigomotivo;
    }

    public void setCodigomotivo(String codigomotivo) {
        this.codigomotivo = codigomotivo;
    }

    public String getDescricaomotivo() {
        return descricaomotivo;
    }

    public void setDescricaomotivo(String descricaomotivo) {
        this.descricaomotivo = descricaomotivo;
    }

    public Bancoocorrencia getCodbancoocorrencia() {
        return codbancoocorrencia;
    }

    public void setCodbancoocorrencia(Bancoocorrencia codbancoocorrencia) {
        this.codbancoocorrencia = codbancoocorrencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codbancoocorrenciamotivo != null ? codbancoocorrenciamotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancoocorrenciamotivo)) {
            return false;
        }
        Bancoocorrenciamotivo other = (Bancoocorrenciamotivo) object;
        if ((this.codbancoocorrenciamotivo == null && other.codbancoocorrenciamotivo != null) || (this.codbancoocorrenciamotivo != null && !this.codbancoocorrenciamotivo.equals(other.codbancoocorrenciamotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Bancoocorrenciamotivo[ codbancoocorrenciamotivo=" + codbancoocorrenciamotivo + " ]";
    }
    
}
