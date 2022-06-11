/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "VEICULOS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculos.findAll", query = "SELECT v FROM Veiculos v")
    , @NamedQuery(name = "Veiculos.findByCodveiculo", query = "SELECT v FROM Veiculos v WHERE v.codveiculo = :codveiculo")
    , @NamedQuery(name = "Veiculos.findByCodigo", query = "SELECT v FROM Veiculos v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "Veiculos.findByModelo", query = "SELECT v FROM Veiculos v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Veiculos.findByPlaca", query = "SELECT v FROM Veiculos v WHERE v.placa = :placa")
    , @NamedQuery(name = "Veiculos.findByTara", query = "SELECT v FROM Veiculos v WHERE v.tara = :tara")
    , @NamedQuery(name = "Veiculos.findByTipoCarroceria", query = "SELECT v FROM Veiculos v WHERE v.tipoCarroceria = :tipoCarroceria")
    , @NamedQuery(name = "Veiculos.findByTipoRodado", query = "SELECT v FROM Veiculos v WHERE v.tipoRodado = :tipoRodado")
    , @NamedQuery(name = "Veiculos.findByRenavan", query = "SELECT v FROM Veiculos v WHERE v.renavan = :renavan")
    , @NamedQuery(name = "Veiculos.findByCapacidadeKg", query = "SELECT v FROM Veiculos v WHERE v.capacidadeKg = :capacidadeKg")
    , @NamedQuery(name = "Veiculos.findByCapacidadeM3", query = "SELECT v FROM Veiculos v WHERE v.capacidadeM3 = :capacidadeM3")
    , @NamedQuery(name = "Veiculos.findByTipoVeiculo", query = "SELECT v FROM Veiculos v WHERE v.tipoVeiculo = :tipoVeiculo")
    , @NamedQuery(name = "Veiculos.findByCiot", query = "SELECT v FROM Veiculos v WHERE v.ciot = :ciot")})
public class Veiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODVEICULO")
    private Integer codveiculo;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "PLACA")
    private String placa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TARA")
    private BigDecimal tara;
    @Column(name = "TIPO_CARROCERIA")
    private String tipoCarroceria;
    @Column(name = "TIPO_RODADO")
    private String tipoRodado;
    @Column(name = "RENAVAN")
    private String renavan;
    @Column(name = "CAPACIDADE_KG")
    private Integer capacidadeKg;
    @Column(name = "CAPACIDADE_M3")
    private Integer capacidadeM3;
    @Column(name = "TIPO_VEICULO")
    private Character tipoVeiculo;
    @Column(name = "CIOT")
    private Integer ciot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codveiculo")
    private Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollection;
    @JoinColumn(name = "CODEMPRESA", referencedColumnName = "CODEMPRESA")
    @ManyToOne
    private Empresa codempresa;
    @JoinColumn(name = "CODTRANS", referencedColumnName = "CODTRANS")
    @ManyToOne
    private Transportadora codtrans;
    @JoinColumn(name = "CODUF", referencedColumnName = "CODUF")
    @ManyToOne
    private Uf coduf;
    @OneToMany(mappedBy = "codveiculo")
    private Collection<Orcamento> orcamentoCollection;
    @OneToMany(mappedBy = "codveiculo")
    private Collection<Movenda> movendaCollection;
    @OneToMany(mappedBy = "codveiculo")
    private Collection<Loteentrega> loteentregaCollection;

    public Veiculos() {
    }

    public Veiculos(Integer codveiculo) {
        this.codveiculo = codveiculo;
    }

    public Veiculos(Integer codveiculo, String codigo) {
        this.codveiculo = codveiculo;
        this.codigo = codigo;
    }

    public Integer getCodveiculo() {
        return codveiculo;
    }

    public void setCodveiculo(Integer codveiculo) {
        this.codveiculo = codveiculo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getTara() {
        return tara;
    }

    public void setTara(BigDecimal tara) {
        this.tara = tara;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public String getTipoRodado() {
        return tipoRodado;
    }

    public void setTipoRodado(String tipoRodado) {
        this.tipoRodado = tipoRodado;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public Integer getCapacidadeKg() {
        return capacidadeKg;
    }

    public void setCapacidadeKg(Integer capacidadeKg) {
        this.capacidadeKg = capacidadeKg;
    }

    public Integer getCapacidadeM3() {
        return capacidadeM3;
    }

    public void setCapacidadeM3(Integer capacidadeM3) {
        this.capacidadeM3 = capacidadeM3;
    }

    public Character getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Character tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Integer getCiot() {
        return ciot;
    }

    public void setCiot(Integer ciot) {
        this.ciot = ciot;
    }

    @XmlTransient
    public Collection<Mdfeletronicoveiculo> getMdfeletronicoveiculoCollection() {
        return mdfeletronicoveiculoCollection;
    }

    public void setMdfeletronicoveiculoCollection(Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollection) {
        this.mdfeletronicoveiculoCollection = mdfeletronicoveiculoCollection;
    }

    public Empresa getCodempresa() {
        return codempresa;
    }

    public void setCodempresa(Empresa codempresa) {
        this.codempresa = codempresa;
    }

    public Transportadora getCodtrans() {
        return codtrans;
    }

    public void setCodtrans(Transportadora codtrans) {
        this.codtrans = codtrans;
    }

    public Uf getCoduf() {
        return coduf;
    }

    public void setCoduf(Uf coduf) {
        this.coduf = coduf;
    }

    @XmlTransient
    public Collection<Orcamento> getOrcamentoCollection() {
        return orcamentoCollection;
    }

    public void setOrcamentoCollection(Collection<Orcamento> orcamentoCollection) {
        this.orcamentoCollection = orcamentoCollection;
    }

    @XmlTransient
    public Collection<Movenda> getMovendaCollection() {
        return movendaCollection;
    }

    public void setMovendaCollection(Collection<Movenda> movendaCollection) {
        this.movendaCollection = movendaCollection;
    }

    @XmlTransient
    public Collection<Loteentrega> getLoteentregaCollection() {
        return loteentregaCollection;
    }

    public void setLoteentregaCollection(Collection<Loteentrega> loteentregaCollection) {
        this.loteentregaCollection = loteentregaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codveiculo != null ? codveiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculos)) {
            return false;
        }
        Veiculos other = (Veiculos) object;
        if ((this.codveiculo == null && other.codveiculo != null) || (this.codveiculo != null && !this.codveiculo.equals(other.codveiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Veiculos[ codveiculo=" + codveiculo + " ]";
    }
    
}
