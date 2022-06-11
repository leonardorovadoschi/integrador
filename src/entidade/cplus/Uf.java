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
@Table(name = "UF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u")
    , @NamedQuery(name = "Uf.findByCoduf", query = "SELECT u FROM Uf u WHERE u.coduf = :coduf")
    , @NamedQuery(name = "Uf.findByNomeuf", query = "SELECT u FROM Uf u WHERE u.nomeuf = :nomeuf")
    , @NamedQuery(name = "Uf.findByAliquotainterna1", query = "SELECT u FROM Uf u WHERE u.aliquotainterna1 = :aliquotainterna1")
    , @NamedQuery(name = "Uf.findByAliquotainterna2", query = "SELECT u FROM Uf u WHERE u.aliquotainterna2 = :aliquotainterna2")
    , @NamedQuery(name = "Uf.findByAliquotainterna3", query = "SELECT u FROM Uf u WHERE u.aliquotainterna3 = :aliquotainterna3")
    , @NamedQuery(name = "Uf.findByAliquotainterna4", query = "SELECT u FROM Uf u WHERE u.aliquotainterna4 = :aliquotainterna4")
    , @NamedQuery(name = "Uf.findByAliquotainterna5", query = "SELECT u FROM Uf u WHERE u.aliquotainterna5 = :aliquotainterna5")
    , @NamedQuery(name = "Uf.findByAliquotainterna6", query = "SELECT u FROM Uf u WHERE u.aliquotainterna6 = :aliquotainterna6")
    , @NamedQuery(name = "Uf.findByAliquotainterna7", query = "SELECT u FROM Uf u WHERE u.aliquotainterna7 = :aliquotainterna7")
    , @NamedQuery(name = "Uf.findByAliquotainterna8", query = "SELECT u FROM Uf u WHERE u.aliquotainterna8 = :aliquotainterna8")
    , @NamedQuery(name = "Uf.findByAliquotainterna9", query = "SELECT u FROM Uf u WHERE u.aliquotainterna9 = :aliquotainterna9")
    , @NamedQuery(name = "Uf.findByFlagusapafecf", query = "SELECT u FROM Uf u WHERE u.flagusapafecf = :flagusapafecf")
    , @NamedQuery(name = "Uf.findByCodigoibge", query = "SELECT u FROM Uf u WHERE u.codigoibge = :codigoibge")
    , @NamedQuery(name = "Uf.findByAliqinternafcp1", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp1 = :aliqinternafcp1")
    , @NamedQuery(name = "Uf.findByAliqinternafcp2", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp2 = :aliqinternafcp2")
    , @NamedQuery(name = "Uf.findByAliqinternafcp3", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp3 = :aliqinternafcp3")
    , @NamedQuery(name = "Uf.findByAliqinternafcp4", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp4 = :aliqinternafcp4")
    , @NamedQuery(name = "Uf.findByAliqinternafcp5", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp5 = :aliqinternafcp5")
    , @NamedQuery(name = "Uf.findByAliqinternafcp6", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp6 = :aliqinternafcp6")
    , @NamedQuery(name = "Uf.findByAliqinternafcp7", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp7 = :aliqinternafcp7")
    , @NamedQuery(name = "Uf.findByAliqinternafcp8", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp8 = :aliqinternafcp8")
    , @NamedQuery(name = "Uf.findByAliqinternafcp9", query = "SELECT u FROM Uf u WHERE u.aliqinternafcp9 = :aliqinternafcp9")})
public class Uf implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODUF")
    private String coduf;
    @Basic(optional = false)
    @Column(name = "NOMEUF")
    private String nomeuf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ALIQUOTAINTERNA1")
    private BigDecimal aliquotainterna1;
    @Column(name = "ALIQUOTAINTERNA2")
    private BigDecimal aliquotainterna2;
    @Column(name = "ALIQUOTAINTERNA3")
    private BigDecimal aliquotainterna3;
    @Column(name = "ALIQUOTAINTERNA4")
    private BigDecimal aliquotainterna4;
    @Column(name = "ALIQUOTAINTERNA5")
    private BigDecimal aliquotainterna5;
    @Column(name = "ALIQUOTAINTERNA6")
    private BigDecimal aliquotainterna6;
    @Column(name = "ALIQUOTAINTERNA7")
    private BigDecimal aliquotainterna7;
    @Column(name = "ALIQUOTAINTERNA8")
    private BigDecimal aliquotainterna8;
    @Column(name = "ALIQUOTAINTERNA9")
    private BigDecimal aliquotainterna9;
    @Column(name = "FLAGUSAPAFECF")
    private Character flagusapafecf;
    @Column(name = "CODIGOIBGE")
    private String codigoibge;
    @Column(name = "ALIQINTERNAFCP1")
    private BigDecimal aliqinternafcp1;
    @Column(name = "ALIQINTERNAFCP2")
    private BigDecimal aliqinternafcp2;
    @Column(name = "ALIQINTERNAFCP3")
    private BigDecimal aliqinternafcp3;
    @Column(name = "ALIQINTERNAFCP4")
    private BigDecimal aliqinternafcp4;
    @Column(name = "ALIQINTERNAFCP5")
    private BigDecimal aliqinternafcp5;
    @Column(name = "ALIQINTERNAFCP6")
    private BigDecimal aliqinternafcp6;
    @Column(name = "ALIQINTERNAFCP7")
    private BigDecimal aliqinternafcp7;
    @Column(name = "ALIQINTERNAFCP8")
    private BigDecimal aliqinternafcp8;
    @Column(name = "ALIQINTERNAFCP9")
    private BigDecimal aliqinternafcp9;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codufdestino")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduforigem")
    private Collection<Calculoicmsestado> calculoicmsestadoCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduf")
    private Collection<Empresauf> empresaufCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduf")
    private Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollection;
    @OneToMany(mappedBy = "coduf")
    private Collection<Cidade> cidadeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduf")
    private Collection<Regracfopitem> regracfopitemCollection;
    @OneToMany(mappedBy = "coduf")
    private Collection<Veiculos> veiculosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uf")
    private Collection<Icmsestado> icmsestadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uf1")
    private Collection<Icmsestado> icmsestadoCollection1;
    @OneToMany(mappedBy = "coduf")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coduffim")
    private Collection<Mdfeletronico> mdfeletronicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codufinicio")
    private Collection<Mdfeletronico> mdfeletronicoCollection1;

    public Uf() {
    }

    public Uf(String coduf) {
        this.coduf = coduf;
    }

    public Uf(String coduf, String nomeuf) {
        this.coduf = coduf;
        this.nomeuf = nomeuf;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public String getNomeuf() {
        return nomeuf;
    }

    public void setNomeuf(String nomeuf) {
        this.nomeuf = nomeuf;
    }

    public BigDecimal getAliquotainterna1() {
        return aliquotainterna1;
    }

    public void setAliquotainterna1(BigDecimal aliquotainterna1) {
        this.aliquotainterna1 = aliquotainterna1;
    }

    public BigDecimal getAliquotainterna2() {
        return aliquotainterna2;
    }

    public void setAliquotainterna2(BigDecimal aliquotainterna2) {
        this.aliquotainterna2 = aliquotainterna2;
    }

    public BigDecimal getAliquotainterna3() {
        return aliquotainterna3;
    }

    public void setAliquotainterna3(BigDecimal aliquotainterna3) {
        this.aliquotainterna3 = aliquotainterna3;
    }

    public BigDecimal getAliquotainterna4() {
        return aliquotainterna4;
    }

    public void setAliquotainterna4(BigDecimal aliquotainterna4) {
        this.aliquotainterna4 = aliquotainterna4;
    }

    public BigDecimal getAliquotainterna5() {
        return aliquotainterna5;
    }

    public void setAliquotainterna5(BigDecimal aliquotainterna5) {
        this.aliquotainterna5 = aliquotainterna5;
    }

    public BigDecimal getAliquotainterna6() {
        return aliquotainterna6;
    }

    public void setAliquotainterna6(BigDecimal aliquotainterna6) {
        this.aliquotainterna6 = aliquotainterna6;
    }

    public BigDecimal getAliquotainterna7() {
        return aliquotainterna7;
    }

    public void setAliquotainterna7(BigDecimal aliquotainterna7) {
        this.aliquotainterna7 = aliquotainterna7;
    }

    public BigDecimal getAliquotainterna8() {
        return aliquotainterna8;
    }

    public void setAliquotainterna8(BigDecimal aliquotainterna8) {
        this.aliquotainterna8 = aliquotainterna8;
    }

    public BigDecimal getAliquotainterna9() {
        return aliquotainterna9;
    }

    public void setAliquotainterna9(BigDecimal aliquotainterna9) {
        this.aliquotainterna9 = aliquotainterna9;
    }

    public Character getFlagusapafecf() {
        return flagusapafecf;
    }

    public void setFlagusapafecf(Character flagusapafecf) {
        this.flagusapafecf = flagusapafecf;
    }

    public String getCodigoibge() {
        return codigoibge;
    }

    public void setCodigoibge(String codigoibge) {
        this.codigoibge = codigoibge;
    }

    public BigDecimal getAliqinternafcp1() {
        return aliqinternafcp1;
    }

    public void setAliqinternafcp1(BigDecimal aliqinternafcp1) {
        this.aliqinternafcp1 = aliqinternafcp1;
    }

    public BigDecimal getAliqinternafcp2() {
        return aliqinternafcp2;
    }

    public void setAliqinternafcp2(BigDecimal aliqinternafcp2) {
        this.aliqinternafcp2 = aliqinternafcp2;
    }

    public BigDecimal getAliqinternafcp3() {
        return aliqinternafcp3;
    }

    public void setAliqinternafcp3(BigDecimal aliqinternafcp3) {
        this.aliqinternafcp3 = aliqinternafcp3;
    }

    public BigDecimal getAliqinternafcp4() {
        return aliqinternafcp4;
    }

    public void setAliqinternafcp4(BigDecimal aliqinternafcp4) {
        this.aliqinternafcp4 = aliqinternafcp4;
    }

    public BigDecimal getAliqinternafcp5() {
        return aliqinternafcp5;
    }

    public void setAliqinternafcp5(BigDecimal aliqinternafcp5) {
        this.aliqinternafcp5 = aliqinternafcp5;
    }

    public BigDecimal getAliqinternafcp6() {
        return aliqinternafcp6;
    }

    public void setAliqinternafcp6(BigDecimal aliqinternafcp6) {
        this.aliqinternafcp6 = aliqinternafcp6;
    }

    public BigDecimal getAliqinternafcp7() {
        return aliqinternafcp7;
    }

    public void setAliqinternafcp7(BigDecimal aliqinternafcp7) {
        this.aliqinternafcp7 = aliqinternafcp7;
    }

    public BigDecimal getAliqinternafcp8() {
        return aliqinternafcp8;
    }

    public void setAliqinternafcp8(BigDecimal aliqinternafcp8) {
        this.aliqinternafcp8 = aliqinternafcp8;
    }

    public BigDecimal getAliqinternafcp9() {
        return aliqinternafcp9;
    }

    public void setAliqinternafcp9(BigDecimal aliqinternafcp9) {
        this.aliqinternafcp9 = aliqinternafcp9;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection() {
        return calculoicmsestadoCollection;
    }

    public void setCalculoicmsestadoCollection(Collection<Calculoicmsestado> calculoicmsestadoCollection) {
        this.calculoicmsestadoCollection = calculoicmsestadoCollection;
    }

    @XmlTransient
    public Collection<Calculoicmsestado> getCalculoicmsestadoCollection1() {
        return calculoicmsestadoCollection1;
    }

    public void setCalculoicmsestadoCollection1(Collection<Calculoicmsestado> calculoicmsestadoCollection1) {
        this.calculoicmsestadoCollection1 = calculoicmsestadoCollection1;
    }

    @XmlTransient
    public Collection<Empresauf> getEmpresaufCollection() {
        return empresaufCollection;
    }

    public void setEmpresaufCollection(Collection<Empresauf> empresaufCollection) {
        this.empresaufCollection = empresaufCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronicopercurso> getMdfeletronicopercursoCollection() {
        return mdfeletronicopercursoCollection;
    }

    public void setMdfeletronicopercursoCollection(Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollection) {
        this.mdfeletronicopercursoCollection = mdfeletronicopercursoCollection;
    }

    @XmlTransient
    public Collection<Cidade> getCidadeCollection() {
        return cidadeCollection;
    }

    public void setCidadeCollection(Collection<Cidade> cidadeCollection) {
        this.cidadeCollection = cidadeCollection;
    }

    @XmlTransient
    public Collection<Regracfopitem> getRegracfopitemCollection() {
        return regracfopitemCollection;
    }

    public void setRegracfopitemCollection(Collection<Regracfopitem> regracfopitemCollection) {
        this.regracfopitemCollection = regracfopitemCollection;
    }

    @XmlTransient
    public Collection<Veiculos> getVeiculosCollection() {
        return veiculosCollection;
    }

    public void setVeiculosCollection(Collection<Veiculos> veiculosCollection) {
        this.veiculosCollection = veiculosCollection;
    }

    @XmlTransient
    public Collection<Icmsestado> getIcmsestadoCollection() {
        return icmsestadoCollection;
    }

    public void setIcmsestadoCollection(Collection<Icmsestado> icmsestadoCollection) {
        this.icmsestadoCollection = icmsestadoCollection;
    }

    @XmlTransient
    public Collection<Icmsestado> getIcmsestadoCollection1() {
        return icmsestadoCollection1;
    }

    public void setIcmsestadoCollection1(Collection<Icmsestado> icmsestadoCollection1) {
        this.icmsestadoCollection1 = icmsestadoCollection1;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronico> getMdfeletronicoCollection() {
        return mdfeletronicoCollection;
    }

    public void setMdfeletronicoCollection(Collection<Mdfeletronico> mdfeletronicoCollection) {
        this.mdfeletronicoCollection = mdfeletronicoCollection;
    }

    @XmlTransient
    public Collection<Mdfeletronico> getMdfeletronicoCollection1() {
        return mdfeletronicoCollection1;
    }

    public void setMdfeletronicoCollection1(Collection<Mdfeletronico> mdfeletronicoCollection1) {
        this.mdfeletronicoCollection1 = mdfeletronicoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coduf != null ? coduf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uf)) {
            return false;
        }
        Uf other = (Uf) object;
        if ((this.coduf == null && other.coduf != null) || (this.coduf != null && !this.coduf.equals(other.coduf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.Uf[ coduf=" + coduf + " ]";
    }
    
}
