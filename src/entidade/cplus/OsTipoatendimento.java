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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "OS_TIPOATENDIMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsTipoatendimento.findAll", query = "SELECT o FROM OsTipoatendimento o")
    , @NamedQuery(name = "OsTipoatendimento.findByCodta", query = "SELECT o FROM OsTipoatendimento o WHERE o.codta = :codta")
    , @NamedQuery(name = "OsTipoatendimento.findByCodigo", query = "SELECT o FROM OsTipoatendimento o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsTipoatendimento.findByTipoatendimento", query = "SELECT o FROM OsTipoatendimento o WHERE o.tipoatendimento = :tipoatendimento")
    , @NamedQuery(name = "OsTipoatendimento.findByPrazogarantia", query = "SELECT o FROM OsTipoatendimento o WHERE o.prazogarantia = :prazogarantia")})
public class OsTipoatendimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTA")
    private String codta;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "TIPOATENDIMENTO")
    private String tipoatendimento;
    @Column(name = "PRAZOGARANTIA")
    private Integer prazogarantia;

    public OsTipoatendimento() {
    }

    public OsTipoatendimento(String codta) {
        this.codta = codta;
    }

    public OsTipoatendimento(String codta, String codigo) {
        this.codta = codta;
        this.codigo = codigo;
    }

    public String getCodta() {
        return codta;
    }

    public void setCodta(String codta) {
        this.codta = codta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoatendimento() {
        return tipoatendimento;
    }

    public void setTipoatendimento(String tipoatendimento) {
        this.tipoatendimento = tipoatendimento;
    }

    public Integer getPrazogarantia() {
        return prazogarantia;
    }

    public void setPrazogarantia(Integer prazogarantia) {
        this.prazogarantia = prazogarantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codta != null ? codta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsTipoatendimento)) {
            return false;
        }
        OsTipoatendimento other = (OsTipoatendimento) object;
        if ((this.codta == null && other.codta != null) || (this.codta != null && !this.codta.equals(other.codta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsTipoatendimento[ codta=" + codta + " ]";
    }
    
}
