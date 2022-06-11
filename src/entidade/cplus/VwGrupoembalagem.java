/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.cplus;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "VW_GRUPOEMBALAGEM", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwGrupoembalagem.findAll", query = "SELECT v FROM VwGrupoembalagem v")
    , @NamedQuery(name = "VwGrupoembalagem.findByCodgrupoembalagem", query = "SELECT v FROM VwGrupoembalagem v WHERE v.codgrupoembalagem = :codgrupoembalagem")
    , @NamedQuery(name = "VwGrupoembalagem.findByCodigo", query = "SELECT v FROM VwGrupoembalagem v WHERE v.codigo = :codigo")
    , @NamedQuery(name = "VwGrupoembalagem.findByDescricao", query = "SELECT v FROM VwGrupoembalagem v WHERE v.descricao = :descricao")})
public class VwGrupoembalagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODGRUPOEMBALAGEM")
    private String codgrupoembalagem;
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwGrupoembalagem() {
    }

    public String getCodgrupoembalagem() {
        return codgrupoembalagem;
    }

    public void setCodgrupoembalagem(String codgrupoembalagem) {
        this.codgrupoembalagem = codgrupoembalagem;
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
    
}
