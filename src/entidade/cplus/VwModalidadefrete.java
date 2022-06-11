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
@Table(name = "VW_MODALIDADEFRETE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwModalidadefrete.findAll", query = "SELECT v FROM VwModalidadefrete v")
    , @NamedQuery(name = "VwModalidadefrete.findByCodmodalidadefrete", query = "SELECT v FROM VwModalidadefrete v WHERE v.codmodalidadefrete = :codmodalidadefrete")
    , @NamedQuery(name = "VwModalidadefrete.findByDescricao", query = "SELECT v FROM VwModalidadefrete v WHERE v.descricao = :descricao")})
public class VwModalidadefrete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODMODALIDADEFRETE")
    private Character codmodalidadefrete;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwModalidadefrete() {
    }

    public Character getCodmodalidadefrete() {
        return codmodalidadefrete;
    }

    public void setCodmodalidadefrete(Character codmodalidadefrete) {
        this.codmodalidadefrete = codmodalidadefrete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
