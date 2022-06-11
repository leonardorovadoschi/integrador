/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.prestaShop;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_link_block")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsLinkBlock.findAll", query = "SELECT p FROM PsLinkBlock p")
    , @NamedQuery(name = "PsLinkBlock.findByIdLinkBlock", query = "SELECT p FROM PsLinkBlock p WHERE p.idLinkBlock = :idLinkBlock")
    , @NamedQuery(name = "PsLinkBlock.findByIdHook", query = "SELECT p FROM PsLinkBlock p WHERE p.idHook = :idHook")
    , @NamedQuery(name = "PsLinkBlock.findByPosition", query = "SELECT p FROM PsLinkBlock p WHERE p.position = :position")})
public class PsLinkBlock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_link_block")
    private Integer idLinkBlock;
    @Column(name = "id_hook")
    private Integer idHook;
    @Basic(optional = false)
    @Column(name = "position")
    private int position;
    @Lob
    @Column(name = "content")
    private String content;

    public PsLinkBlock() {
    }

    public PsLinkBlock(Integer idLinkBlock) {
        this.idLinkBlock = idLinkBlock;
    }

    public PsLinkBlock(Integer idLinkBlock, int position) {
        this.idLinkBlock = idLinkBlock;
        this.position = position;
    }

    public Integer getIdLinkBlock() {
        return idLinkBlock;
    }

    public void setIdLinkBlock(Integer idLinkBlock) {
        this.idLinkBlock = idLinkBlock;
    }

    public Integer getIdHook() {
        return idHook;
    }

    public void setIdHook(Integer idHook) {
        this.idHook = idHook;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLinkBlock != null ? idLinkBlock.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsLinkBlock)) {
            return false;
        }
        PsLinkBlock other = (PsLinkBlock) object;
        if ((this.idLinkBlock == null && other.idLinkBlock != null) || (this.idLinkBlock != null && !this.idLinkBlock.equals(other.idLinkBlock))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsLinkBlock[ idLinkBlock=" + idLinkBlock + " ]";
    }
    
}
