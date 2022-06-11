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
@Table(name = "VW_CSTCOFINS", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCstcofins.findAll", query = "SELECT v FROM VwCstcofins v")
    , @NamedQuery(name = "VwCstcofins.findByCstcofins", query = "SELECT v FROM VwCstcofins v WHERE v.cstcofins = :cstcofins")
    , @NamedQuery(name = "VwCstcofins.findByDescricao", query = "SELECT v FROM VwCstcofins v WHERE v.descricao = :descricao")})
public class VwCstcofins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CSTCOFINS")
    private String cstcofins;
    @Column(name = "DESCRICAO")
    private String descricao;

    public VwCstcofins() {
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
