/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "CIDADE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByCodcidade", query = "SELECT c FROM Cidade c WHERE c.codcidade = :codcidade")
    , @NamedQuery(name = "Cidade.findByCodigo", query = "SELECT c FROM Cidade c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cidade.findByNomecidade", query = "SELECT c FROM Cidade c WHERE c.nomecidade = :nomecidade")
    , @NamedQuery(name = "Cidade.findByCodigoibge", query = "SELECT c FROM Cidade c WHERE c.codigoibge = :codigoibge")
    , @NamedQuery(name = "Cidade.findByFlagcapital", query = "SELECT c FROM Cidade c WHERE c.flagcapital = :flagcapital")
    , @NamedQuery(name = "Cidade.findByDnecodloc", query = "SELECT c FROM Cidade c WHERE c.dnecodloc = :dnecodloc")
    , @NamedQuery(name = "Cidade.findByCep", query = "SELECT c FROM Cidade c WHERE c.cep = :cep")
    , @NamedQuery(name = "Cidade.findByLocInSit", query = "SELECT c FROM Cidade c WHERE c.locInSit = :locInSit")
    , @NamedQuery(name = "Cidade.findByLocInTipoLoc", query = "SELECT c FROM Cidade c WHERE c.locInTipoLoc = :locInTipoLoc")
    , @NamedQuery(name = "Cidade.findByLocNoAbrev", query = "SELECT c FROM Cidade c WHERE c.locNoAbrev = :locNoAbrev")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCIDADE")
    private String codcidade;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMECIDADE")
    private String nomecidade;
    @Column(name = "CODIGOIBGE")
    private String codigoibge;
    @Column(name = "FLAGCAPITAL")
    private Character flagcapital;
    @Column(name = "DNECODLOC")
    private Integer dnecodloc;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "LOC_IN_SIT")
    private Character locInSit;
    @Column(name = "LOC_IN_TIPO_LOC")
    private Character locInTipoLoc;
    @Column(name = "LOC_NO_ABREV")
    private String locNoAbrev;
    @OneToMany(mappedBy = "codcidade")
    private Collection<Cep> cepCollection;
    @OneToMany(mappedBy = "codcidade")
    private Collection<Regiaocidade> regiaocidadeCollection;
    @JoinColumn(name = "CODPAIS", referencedColumnName = "CODPAIS")
    @ManyToOne
    private Pais codpais;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne
    private Uf coduf;

    public Cidade() {
    }

    public Cidade(String codcidade) {
        this.codcidade = codcidade;
    }

    public Cidade(String codcidade, String codigo) {
        this.codcidade = codcidade;
        this.codigo = codigo;
    }

    public String getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(String codcidade) {
        this.codcidade = codcidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(String codigoibge) {
        this.codigoibge = codigoibge;
    }

    public Character getFlagcapital() {
        return flagcapital;
    }

    public void setFlagcapital(Character flagcapital) {
        this.flagcapital = flagcapital;
    }

    public Integer getDnecodloc() {
        return dnecodloc;
    }

    public void setDnecodloc(Integer dnecodloc) {
        this.dnecodloc = dnecodloc;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Character getLocInSit() {
        return locInSit;
    }

    public void setLocInSit(Character locInSit) {
        this.locInSit = locInSit;
    }

    public Character getLocInTipoLoc() {
        return locInTipoLoc;
    }

    public void setLocInTipoLoc(Character locInTipoLoc) {
        this.locInTipoLoc = locInTipoLoc;
    }

    public String getLocNoAbrev() {
        return locNoAbrev;
    }

    public void setLocNoAbrev(String locNoAbrev) {
        this.locNoAbrev = locNoAbrev;
    }

    @XmlTransient
    public Collection<Cep> getCepCollection() {
        return cepCollection;
    }

    public void setCepCollection(Collection<Cep> cepCollection) {
        this.cepCollection = cepCollection;
    }

    @XmlTransient
    public Collection<Regiaocidade> getRegiaocidadeCollection() {
        return regiaocidadeCollection;
    }

    public void setRegiaocidadeCollection(Collection<Regiaocidade> regiaocidadeCollection) {
        this.regiaocidadeCollection = regiaocidadeCollection;
    }

    public Pais getCodpais() {
        return codpais;
    }

    public void setCodpais(Pais codpais) {
        this.codpais = codpais;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcidade != null ? codcidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.codcidade == null && other.codcidade != null) || (this.codcidade != null && !this.codcidade.equals(other.codcidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Cidade[ codcidade=" + codcidade + " ]";
    }
    
}
