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
@Table(name = "TMP_SPED_INCONSISTENCIAITEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpSpedInconsistenciaitem.findAll", query = "SELECT t FROM TmpSpedInconsistenciaitem t")
    , @NamedQuery(name = "TmpSpedInconsistenciaitem.findByIditem", query = "SELECT t FROM TmpSpedInconsistenciaitem t WHERE t.iditem = :iditem")
    , @NamedQuery(name = "TmpSpedInconsistenciaitem.findByErro", query = "SELECT t FROM TmpSpedInconsistenciaitem t WHERE t.erro = :erro")
    , @NamedQuery(name = "TmpSpedInconsistenciaitem.findByValorcorreto", query = "SELECT t FROM TmpSpedInconsistenciaitem t WHERE t.valorcorreto = :valorcorreto")
    , @NamedQuery(name = "TmpSpedInconsistenciaitem.findByValoratual", query = "SELECT t FROM TmpSpedInconsistenciaitem t WHERE t.valoratual = :valoratual")})
public class TmpSpedInconsistenciaitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDITEM")
    private Integer iditem;
    @Column(name = "ERRO")
    private String erro;
    @Column(name = "VALORCORRETO")
    private String valorcorreto;
    @Column(name = "VALORATUAL")
    private String valoratual;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne
    private TmpSpedInconsistencia id;

    public TmpSpedInconsistenciaitem() {
    }

    public TmpSpedInconsistenciaitem(Integer iditem) {
        this.iditem = iditem;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getValorcorreto() {
        return valorcorreto;
    }

    public void setValorcorreto(String valorcorreto) {
        this.valorcorreto = valorcorreto;
    }

    public String getValoratual() {
        return valoratual;
    }

    public void setValoratual(String valoratual) {
        this.valoratual = valoratual;
    }

    public TmpSpedInconsistencia getId() {
        return id;
    }

    public void setId(TmpSpedInconsistencia id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditem != null ? iditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpSpedInconsistenciaitem)) {
            return false;
        }
        TmpSpedInconsistenciaitem other = (TmpSpedInconsistenciaitem) object;
        if ((this.iditem == null && other.iditem != null) || (this.iditem != null && !this.iditem.equals(other.iditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpSpedInconsistenciaitem[ iditem=" + iditem + " ]";
    }
    
}
