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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "ps_hook_module_exceptions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsHookModuleExceptions.findAll", query = "SELECT p FROM PsHookModuleExceptions p")
    , @NamedQuery(name = "PsHookModuleExceptions.findByIdHookModuleExceptions", query = "SELECT p FROM PsHookModuleExceptions p WHERE p.idHookModuleExceptions = :idHookModuleExceptions")
    , @NamedQuery(name = "PsHookModuleExceptions.findByIdShop", query = "SELECT p FROM PsHookModuleExceptions p WHERE p.idShop = :idShop")
    , @NamedQuery(name = "PsHookModuleExceptions.findByIdModule", query = "SELECT p FROM PsHookModuleExceptions p WHERE p.idModule = :idModule")
    , @NamedQuery(name = "PsHookModuleExceptions.findByIdHook", query = "SELECT p FROM PsHookModuleExceptions p WHERE p.idHook = :idHook")
    , @NamedQuery(name = "PsHookModuleExceptions.findByFileName", query = "SELECT p FROM PsHookModuleExceptions p WHERE p.fileName = :fileName")})
public class PsHookModuleExceptions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_hook_module_exceptions")
    private Integer idHookModuleExceptions;
    @Basic(optional = false)
    @Column(name = "id_shop")
    private int idShop;
    @Basic(optional = false)
    @Column(name = "id_module")
    private int idModule;
    @Basic(optional = false)
    @Column(name = "id_hook")
    private int idHook;
    @Column(name = "file_name")
    private String fileName;

    public PsHookModuleExceptions() {
    }

    public PsHookModuleExceptions(Integer idHookModuleExceptions) {
        this.idHookModuleExceptions = idHookModuleExceptions;
    }

    public PsHookModuleExceptions(Integer idHookModuleExceptions, int idShop, int idModule, int idHook) {
        this.idHookModuleExceptions = idHookModuleExceptions;
        this.idShop = idShop;
        this.idModule = idModule;
        this.idHook = idHook;
    }

    public Integer getIdHookModuleExceptions() {
        return idHookModuleExceptions;
    }

    public void setIdHookModuleExceptions(Integer idHookModuleExceptions) {
        this.idHookModuleExceptions = idHookModuleExceptions;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public int getIdHook() {
        return idHook;
    }

    public void setIdHook(int idHook) {
        this.idHook = idHook;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHookModuleExceptions != null ? idHookModuleExceptions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsHookModuleExceptions)) {
            return false;
        }
        PsHookModuleExceptions other = (PsHookModuleExceptions) object;
        if ((this.idHookModuleExceptions == null && other.idHookModuleExceptions != null) || (this.idHookModuleExceptions != null && !this.idHookModuleExceptions.equals(other.idHookModuleExceptions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsHookModuleExceptions[ idHookModuleExceptions=" + idHookModuleExceptions + " ]";
    }
    
}
