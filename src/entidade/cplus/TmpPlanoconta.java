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
@Table(name = "TMP_PLANOCONTA", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpPlanoconta.findAll", query = "SELECT t FROM TmpPlanoconta t")
    , @NamedQuery(name = "TmpPlanoconta.findByCodpc", query = "SELECT t FROM TmpPlanoconta t WHERE t.codpc = :codpc")
    , @NamedQuery(name = "TmpPlanoconta.findByCodigo", query = "SELECT t FROM TmpPlanoconta t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TmpPlanoconta.findByNomeplanoconta", query = "SELECT t FROM TmpPlanoconta t WHERE t.nomeplanoconta = :nomeplanoconta")
    , @NamedQuery(name = "TmpPlanoconta.findByTipo", query = "SELECT t FROM TmpPlanoconta t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TmpPlanoconta.findByClassificacao", query = "SELECT t FROM TmpPlanoconta t WHERE t.classificacao = :classificacao")
    , @NamedQuery(name = "TmpPlanoconta.findByStrnivel", query = "SELECT t FROM TmpPlanoconta t WHERE t.strnivel = :strnivel")
    , @NamedQuery(name = "TmpPlanoconta.findById", query = "SELECT t FROM TmpPlanoconta t WHERE t.id = :id")
    , @NamedQuery(name = "TmpPlanoconta.findByCodregistropai", query = "SELECT t FROM TmpPlanoconta t WHERE t.codregistropai = :codregistropai")})
public class TmpPlanoconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODPC")
    private String codpc;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "NOMEPLANOCONTA")
    private String nomeplanoconta;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "STRNIVEL")
    private String strnivel;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CODREGISTROPAI")
    private String codregistropai;

    public TmpPlanoconta() {
    }

    public TmpPlanoconta(Integer id) {
        this.id = id;
    }

    public String getCodpc() {
        return codpc;
    }

    public void setCodpc(String codpc) {
        this.codpc = codpc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeplanoconta() {
        return nomeplanoconta;
    }

    public void setNomeplanoconta(String nomeplanoconta) {
        this.nomeplanoconta = nomeplanoconta;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getStrnivel() {
        return strnivel;
    }

    public void setStrnivel(String strnivel) {
        this.strnivel = strnivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodregistropai() {
        return codregistropai;
    }

    public void setCodregistropai(String codregistropai) {
        this.codregistropai = codregistropai;
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
        if (!(object instanceof TmpPlanoconta)) {
            return false;
        }
        TmpPlanoconta other = (TmpPlanoconta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpPlanoconta[ id=" + id + " ]";
    }
    
}
