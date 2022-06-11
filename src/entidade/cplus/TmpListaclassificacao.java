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
@Table(name = "TMP_LISTACLASSIFICACAO", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TmpListaclassificacao.findAll", query = "SELECT t FROM TmpListaclassificacao t")
    , @NamedQuery(name = "TmpListaclassificacao.findByCodtmpListaclassificacao", query = "SELECT t FROM TmpListaclassificacao t WHERE t.codtmpListaclassificacao = :codtmpListaclassificacao")
    , @NamedQuery(name = "TmpListaclassificacao.findByCodigo", query = "SELECT t FROM TmpListaclassificacao t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TmpListaclassificacao.findByCodregistro", query = "SELECT t FROM TmpListaclassificacao t WHERE t.codregistro = :codregistro")
    , @NamedQuery(name = "TmpListaclassificacao.findByNomeclassificacao", query = "SELECT t FROM TmpListaclassificacao t WHERE t.nomeclassificacao = :nomeclassificacao")
    , @NamedQuery(name = "TmpListaclassificacao.findByTipo", query = "SELECT t FROM TmpListaclassificacao t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TmpListaclassificacao.findByClassificacao", query = "SELECT t FROM TmpListaclassificacao t WHERE t.classificacao = :classificacao")
    , @NamedQuery(name = "TmpListaclassificacao.findByStrnivel", query = "SELECT t FROM TmpListaclassificacao t WHERE t.strnivel = :strnivel")
    , @NamedQuery(name = "TmpListaclassificacao.findByCodregistropai", query = "SELECT t FROM TmpListaclassificacao t WHERE t.codregistropai = :codregistropai")
    , @NamedQuery(name = "TmpListaclassificacao.findBySeleciona", query = "SELECT t FROM TmpListaclassificacao t WHERE t.seleciona = :seleciona")
    , @NamedQuery(name = "TmpListaclassificacao.findByExplicito", query = "SELECT t FROM TmpListaclassificacao t WHERE t.explicito = :explicito")
    , @NamedQuery(name = "TmpListaclassificacao.findByFlagativo", query = "SELECT t FROM TmpListaclassificacao t WHERE t.flagativo = :flagativo")})
public class TmpListaclassificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTMP_LISTACLASSIFICACAO")
    private Integer codtmpListaclassificacao;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "CODREGISTRO")
    private String codregistro;
    @Column(name = "NOMECLASSIFICACAO")
    private String nomeclassificacao;
    @Column(name = "TIPO")
    private Character tipo;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "STRNIVEL")
    private String strnivel;
    @Column(name = "CODREGISTROPAI")
    private String codregistropai;
    @Column(name = "SELECIONA")
    private Character seleciona;
    @Column(name = "EXPLICITO")
    private Character explicito;
    @Column(name = "FLAGATIVO")
    private Character flagativo;

    public TmpListaclassificacao() {
    }

    public TmpListaclassificacao(Integer codtmpListaclassificacao) {
        this.codtmpListaclassificacao = codtmpListaclassificacao;
    }

    public Integer getCodtmpListaclassificacao() {
        return codtmpListaclassificacao;
    }

    public void setCodtmpListaclassificacao(Integer codtmpListaclassificacao) {
        this.codtmpListaclassificacao = codtmpListaclassificacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodregistro() {
        return codregistro;
    }

    public void setCodregistro(String codregistro) {
        this.codregistro = codregistro;
    }

    public String getNomeclassificacao() {
        return nomeclassificacao;
    }

    public void setNomeclassificacao(String nomeclassificacao) {
        this.nomeclassificacao = nomeclassificacao;
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

    public String getCodregistropai() {
        return codregistropai;
    }

    public void setCodregistropai(String codregistropai) {
        this.codregistropai = codregistropai;
    }

    public Character getSeleciona() {
        return seleciona;
    }

    public void setSeleciona(Character seleciona) {
        this.seleciona = seleciona;
    }

    public Character getExplicito() {
        return explicito;
    }

    public void setExplicito(Character explicito) {
        this.explicito = explicito;
    }

    public Character getFlagativo() {
        return flagativo;
    }

    public void setFlagativo(Character flagativo) {
        this.flagativo = flagativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codtmpListaclassificacao != null ? codtmpListaclassificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TmpListaclassificacao)) {
            return false;
        }
        TmpListaclassificacao other = (TmpListaclassificacao) object;
        if ((this.codtmpListaclassificacao == null && other.codtmpListaclassificacao != null) || (this.codtmpListaclassificacao != null && !this.codtmpListaclassificacao.equals(other.codtmpListaclassificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.cplus.TmpListaclassificacao[ codtmpListaclassificacao=" + codtmpListaclassificacao + " ]";
    }
    
}
