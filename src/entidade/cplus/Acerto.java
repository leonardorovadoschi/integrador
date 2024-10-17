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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ACERTO", catalog = "", schema = "")

public class Acerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODACERTO")
    private String codacerto;
    @Column(name = "CODUSER")
    private String coduser;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "STATUS")
    private Character status;
    @Column(name = "DATAACERTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataacerto;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne(optional = false)
    private Empresa codempresa;
    @JoinColumn(name = "CODSETORESTOQUE", referencedColumnName = "CODSETORESTOQUE")
    @ManyToOne(optional = false)
    private Setorestoque codsetorestoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codacerto")
    private Collection<Acertoproduto> acertoprodutoCollection;

    public Acerto() {
    }

    public Acerto(String codacerto) {
        this.codacerto = codacerto;
    }

    public String getCodacerto() {
        return codacerto;
    }

    public void setCodacerto(String codacerto) {
        this.codacerto = codacerto;
    }

    public String getCoduser() {
        return coduser;
    }

    public void setCoduser(String coduser) {
        this.coduser = coduser;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getDataacerto() {
        return dataacerto;
    }

    public void setDataacerto(Date dataacerto) {
        this.dataacerto = dataacerto;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Setorestoque getCodsetorestoque() {
        return codsetorestoque;
    }

    public void setCodsetorestoque(Setorestoque codsetorestoque) {
        this.codsetorestoque = codsetorestoque;
    }

    @XmlTransient
    public Collection<Acertoproduto> getAcertoprodutoCollection() {
        return acertoprodutoCollection;
    }

    public void setAcertoprodutoCollection(Collection<Acertoproduto> acertoprodutoCollection) {
        this.acertoprodutoCollection = acertoprodutoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codacerto != null ? codacerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acerto)) {
            return false;
        }
        Acerto other = (Acerto) object;
        if ((this.codacerto == null && other.codacerto != null) || (this.codacerto != null && !this.codacerto.equals(other.codacerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Acerto[ codacerto=" + codacerto + " ]";
    }
    
}
