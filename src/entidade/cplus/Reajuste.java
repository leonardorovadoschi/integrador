/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "REAJUSTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reajuste.findAll", query = "SELECT r FROM Reajuste r")
    , @NamedQuery(name = "Reajuste.findByCodreajuste", query = "SELECT r FROM Reajuste r WHERE r.codreajuste = :codreajuste")
    , @NamedQuery(name = "Reajuste.findByNomereajuste", query = "SELECT r FROM Reajuste r WHERE r.nomereajuste = :nomereajuste")
    , @NamedQuery(name = "Reajuste.findByData", query = "SELECT r FROM Reajuste r WHERE r.data = :data")
    , @NamedQuery(name = "Reajuste.findByHora", query = "SELECT r FROM Reajuste r WHERE r.hora = :hora")
    , @NamedQuery(name = "Reajuste.findByNomeentidadeorigem", query = "SELECT r FROM Reajuste r WHERE r.nomeentidadeorigem = :nomeentidadeorigem")
    , @NamedQuery(name = "Reajuste.findByIdentidadeorigem", query = "SELECT r FROM Reajuste r WHERE r.identidadeorigem = :identidadeorigem")
    , @NamedQuery(name = "Reajuste.findByCodpreco", query = "SELECT r FROM Reajuste r WHERE r.codpreco = :codpreco")
    , @NamedQuery(name = "Reajuste.findByBloqueado", query = "SELECT r FROM Reajuste r WHERE r.bloqueado = :bloqueado")
    , @NamedQuery(name = "Reajuste.findByCoduserprocesso", query = "SELECT r FROM Reajuste r WHERE r.coduserprocesso = :coduserprocesso")})
public class Reajuste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODREAJUSTE")
    private Integer codreajuste;
    @Column(name = "NOMEREAJUSTE")
    private String nomereajuste;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "NOMEENTIDADEORIGEM")
    private String nomeentidadeorigem;
    @Column(name = "IDENTIDADEORIGEM")
    private String identidadeorigem;
    @Column(name = "CODPRECO")
    private String codpreco;
    @Column(name = "BLOQUEADO")
    private Character bloqueado;
    @Column(name = "CODUSERPROCESSO")
    private String coduserprocesso;
    @OneToMany(mappedBy = "codreajuste")
    private Collection<Reajusteproduto> reajusteprodutoCollection;

    public Reajuste() {
    }

    public Reajuste(Integer codreajuste) {
        this.codreajuste = codreajuste;
    }

    public Integer getCodreajuste() {
        return codreajuste;
    }

    public void setCodreajuste(Integer codreajuste) {
        this.codreajuste = codreajuste;
    }

    public String getNomereajuste() {
        return nomereajuste;
    }

    public void setNomereajuste(String nomereajuste) {
        this.nomereajuste = nomereajuste;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getNomeentidadeorigem() {
        return nomeentidadeorigem;
    }

    public void setNomeentidadeorigem(String nomeentidadeorigem) {
        this.nomeentidadeorigem = nomeentidadeorigem;
    }

    public String getIdentidadeorigem() {
        return identidadeorigem;
    }

    public void setIdentidadeorigem(String identidadeorigem) {
        this.identidadeorigem = identidadeorigem;
    }

    public String getCodpreco() {
        return codpreco;
    }

    public void setCodpreco(String codpreco) {
        this.codpreco = codpreco;
    }

    public Character getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Character bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getCoduserprocesso() {
        return coduserprocesso;
    }

    public void setCoduserprocesso(String coduserprocesso) {
        this.coduserprocesso = coduserprocesso;
    }

    @XmlTransient
    public Collection<Reajusteproduto> getReajusteprodutoCollection() {
        return reajusteprodutoCollection;
    }

    public void setReajusteprodutoCollection(Collection<Reajusteproduto> reajusteprodutoCollection) {
        this.reajusteprodutoCollection = reajusteprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codreajuste != null ? codreajuste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reajuste)) {
            return false;
        }
        Reajuste other = (Reajuste) object;
        if ((this.codreajuste == null && other.codreajuste != null) || (this.codreajuste != null && !this.codreajuste.equals(other.codreajuste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Reajuste[ codreajuste=" + codreajuste + " ]";
    }
    
}
