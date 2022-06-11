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
@Table(name = "MODELOCARTACOBRANCA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelocartacobranca.findAll", query = "SELECT m FROM Modelocartacobranca m")
    , @NamedQuery(name = "Modelocartacobranca.findByCodmodelocartacobranca", query = "SELECT m FROM Modelocartacobranca m WHERE m.codmodelocartacobranca = :codmodelocartacobranca")
    , @NamedQuery(name = "Modelocartacobranca.findByCodigo", query = "SELECT m FROM Modelocartacobranca m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Modelocartacobranca.findByNomemodelocartacobranca", query = "SELECT m FROM Modelocartacobranca m WHERE m.nomemodelocartacobranca = :nomemodelocartacobranca")
    , @NamedQuery(name = "Modelocartacobranca.findByAtrasoinicial", query = "SELECT m FROM Modelocartacobranca m WHERE m.atrasoinicial = :atrasoinicial")
    , @NamedQuery(name = "Modelocartacobranca.findByAtrasofinal", query = "SELECT m FROM Modelocartacobranca m WHERE m.atrasofinal = :atrasofinal")
    , @NamedQuery(name = "Modelocartacobranca.findByCodcaracteristicapessoa", query = "SELECT m FROM Modelocartacobranca m WHERE m.codcaracteristicapessoa = :codcaracteristicapessoa")
    , @NamedQuery(name = "Modelocartacobranca.findByIdrtm", query = "SELECT m FROM Modelocartacobranca m WHERE m.idrtm = :idrtm")})
public class Modelocartacobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODMODELOCARTACOBRANCA")
    private String codmodelocartacobranca;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEMODELOCARTACOBRANCA")
    private String nomemodelocartacobranca;
    @Column(name = "ATRASOINICIAL")
    private Integer atrasoinicial;
    @Column(name = "ATRASOFINAL")
    private Integer atrasofinal;
    @Column(name = "CODCARACTERISTICAPESSOA")
    private String codcaracteristicapessoa;
    @Column(name = "IDRTM")
    private Integer idrtm;

    public Modelocartacobranca() {
    }

    public Modelocartacobranca(String codmodelocartacobranca) {
        this.codmodelocartacobranca = codmodelocartacobranca;
    }

    public String getCodmodelocartacobranca() {
        return codmodelocartacobranca;
    }

    public void setCodmodelocartacobranca(String codmodelocartacobranca) {
        this.codmodelocartacobranca = codmodelocartacobranca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomemodelocartacobranca() {
        return nomemodelocartacobranca;
    }

    public void setNomemodelocartacobranca(String nomemodelocartacobranca) {
        this.nomemodelocartacobranca = nomemodelocartacobranca;
    }

    public Integer getAtrasoinicial() {
        return atrasoinicial;
    }

    public void setAtrasoinicial(Integer atrasoinicial) {
        this.atrasoinicial = atrasoinicial;
    }

    public Integer getAtrasofinal() {
        return atrasofinal;
    }

    public void setAtrasofinal(Integer atrasofinal) {
        this.atrasofinal = atrasofinal;
    }

    public String getCodcaracteristicapessoa() {
        return codcaracteristicapessoa;
    }

    public void setCodcaracteristicapessoa(String codcaracteristicapessoa) {
        this.codcaracteristicapessoa = codcaracteristicapessoa;
    }

    public Integer getIdrtm() {
        return idrtm;
    }

    public void setIdrtm(Integer idrtm) {
        this.idrtm = idrtm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmodelocartacobranca != null ? codmodelocartacobranca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelocartacobranca)) {
            return false;
        }
        Modelocartacobranca other = (Modelocartacobranca) object;
        if ((this.codmodelocartacobranca == null && other.codmodelocartacobranca != null) || (this.codmodelocartacobranca != null && !this.codmodelocartacobranca.equals(other.codmodelocartacobranca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Modelocartacobranca[ codmodelocartacobranca=" + codmodelocartacobranca + " ]";
    }
    
}
