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
@Table(name = "VW_MODALIDADETRANSPORTE", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwModalidadetransporte.findAll", query = "SELECT v FROM VwModalidadetransporte v")
    , @NamedQuery(name = "VwModalidadetransporte.findByCodmodal", query = "SELECT v FROM VwModalidadetransporte v WHERE v.codmodal = :codmodal")
    , @NamedQuery(name = "VwModalidadetransporte.findByNomemodal", query = "SELECT v FROM VwModalidadetransporte v WHERE v.nomemodal = :nomemodal")})
public class VwModalidadetransporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODMODAL")
    private Character codmodal;
    @Column(name = "NOMEMODAL")
    private String nomemodal;

    public VwModalidadetransporte() {
    }

    public Character getCodmodal() {
        return codmodal;
    }

    public void setCodmodal(Character codmodal) {
        this.codmodal = codmodal;
    }

    public String getNomemodal() {
        return nomemodal;
    }

    public void setNomemodal(String nomemodal) {
        this.nomemodal = nomemodal;
    }
    
}
