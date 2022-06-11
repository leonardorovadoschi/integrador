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
import javax.persistence.Lob;
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
@Table(name = "OS_EQUIPAMENTO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsEquipamento.findAll", query = "SELECT o FROM OsEquipamento o")
    , @NamedQuery(name = "OsEquipamento.findByCodequip", query = "SELECT o FROM OsEquipamento o WHERE o.codequip = :codequip")
    , @NamedQuery(name = "OsEquipamento.findByCodigo", query = "SELECT o FROM OsEquipamento o WHERE o.codigo = :codigo")
    , @NamedQuery(name = "OsEquipamento.findByDescricao", query = "SELECT o FROM OsEquipamento o WHERE o.descricao = :descricao")
    , @NamedQuery(name = "OsEquipamento.findByTipo", query = "SELECT o FROM OsEquipamento o WHERE o.tipo = :tipo")
    , @NamedQuery(name = "OsEquipamento.findByMarcamodelo", query = "SELECT o FROM OsEquipamento o WHERE o.marcamodelo = :marcamodelo")})
public class OsEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODEQUIP")
    private String codequip;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TIPO")
    private String tipo;
    @Lob
    @Column(name = "OBS")
    private String obs;
    @Column(name = "MARCAMODELO")
    private String marcamodelo;
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    @ManyToOne
    private Cliente codcli;

    public OsEquipamento() {
    }

    public OsEquipamento(String codequip) {
        this.codequip = codequip;
    }

    public OsEquipamento(String codequip, String codigo) {
        this.codequip = codequip;
        this.codigo = codigo;
    }

    public String getCodequip() {
        return codequip;
    }

    public void setCodequip(String codequip) {
        this.codequip = codequip;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public Cliente getCodcli() {
        return codcli;
    }

    public void setCodcli(Cliente codcli) {
        this.codcli = codcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codequip != null ? codequip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsEquipamento)) {
            return false;
        }
        OsEquipamento other = (OsEquipamento) object;
        if ((this.codequip == null && other.codequip != null) || (this.codequip != null && !this.codequip.equals(other.codequip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.OsEquipamento[ codequip=" + codequip + " ]";
    }
    
}
