/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_modulo_cpf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsModuloCpf.findAll", query = "SELECT p FROM PsModuloCpf p")
    , @NamedQuery(name = "PsModuloCpf.findById", query = "SELECT p FROM PsModuloCpf p WHERE p.id = :id")
    , @NamedQuery(name = "PsModuloCpf.findByDocumento", query = "SELECT p FROM PsModuloCpf p WHERE p.documento = :documento")
    , @NamedQuery(name = "PsModuloCpf.findByRgIe", query = "SELECT p FROM PsModuloCpf p WHERE p.rgIe = :rgIe")
    , @NamedQuery(name = "PsModuloCpf.findByTpDocumento", query = "SELECT p FROM PsModuloCpf p WHERE p.tpDocumento = :tpDocumento")
    , @NamedQuery(name = "PsModuloCpf.findByDateAdd", query = "SELECT p FROM PsModuloCpf p WHERE p.dateAdd = :dateAdd")
    , @NamedQuery(name = "PsModuloCpf.findByDateUpd", query = "SELECT p FROM PsModuloCpf p WHERE p.dateUpd = :dateUpd")})
public class PsModuloCpf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "documento")
    private String documento;
    @Column(name = "rg_ie")
    private String rgIe;
    @Column(name = "tp_documento")
    private Short tpDocumento;
    @Basic(optional = false)
    @Column(name = "date_add")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    @Basic(optional = false)
    @Column(name = "date_upd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpd;
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer")
    @ManyToOne(optional = false)
    private PsCustomer idCustomer;

    public PsModuloCpf() {
    }

    public PsModuloCpf(Integer id) {
        this.id = id;
    }

    public PsModuloCpf(Integer id, Date dateAdd, Date dateUpd) {
        this.id = id;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public Short getTpDocumento() {
        return tpDocumento;
    }

    public void setTpDocumento(Short tpDocumento) {
        this.tpDocumento = tpDocumento;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public PsCustomer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(PsCustomer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsModuloCpf)) {
            return false;
        }
        PsModuloCpf other = (PsModuloCpf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsModuloCpf[ id=" + id + " ]";
    }
    
}
