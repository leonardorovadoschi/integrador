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
@Table(name = "ps_guest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsGuest.findAll", query = "SELECT p FROM PsGuest p")
    , @NamedQuery(name = "PsGuest.findByIdGuest", query = "SELECT p FROM PsGuest p WHERE p.idGuest = :idGuest")
    , @NamedQuery(name = "PsGuest.findByIdOperatingSystem", query = "SELECT p FROM PsGuest p WHERE p.idOperatingSystem = :idOperatingSystem")
    , @NamedQuery(name = "PsGuest.findByIdWebBrowser", query = "SELECT p FROM PsGuest p WHERE p.idWebBrowser = :idWebBrowser")
    , @NamedQuery(name = "PsGuest.findByIdCustomer", query = "SELECT p FROM PsGuest p WHERE p.idCustomer = :idCustomer")
    , @NamedQuery(name = "PsGuest.findByJavascript", query = "SELECT p FROM PsGuest p WHERE p.javascript = :javascript")
    , @NamedQuery(name = "PsGuest.findByScreenResolutionX", query = "SELECT p FROM PsGuest p WHERE p.screenResolutionX = :screenResolutionX")
    , @NamedQuery(name = "PsGuest.findByScreenResolutionY", query = "SELECT p FROM PsGuest p WHERE p.screenResolutionY = :screenResolutionY")
    , @NamedQuery(name = "PsGuest.findByScreenColor", query = "SELECT p FROM PsGuest p WHERE p.screenColor = :screenColor")
    , @NamedQuery(name = "PsGuest.findBySunJava", query = "SELECT p FROM PsGuest p WHERE p.sunJava = :sunJava")
    , @NamedQuery(name = "PsGuest.findByAdobeFlash", query = "SELECT p FROM PsGuest p WHERE p.adobeFlash = :adobeFlash")
    , @NamedQuery(name = "PsGuest.findByAdobeDirector", query = "SELECT p FROM PsGuest p WHERE p.adobeDirector = :adobeDirector")
    , @NamedQuery(name = "PsGuest.findByAppleQuicktime", query = "SELECT p FROM PsGuest p WHERE p.appleQuicktime = :appleQuicktime")
    , @NamedQuery(name = "PsGuest.findByRealPlayer", query = "SELECT p FROM PsGuest p WHERE p.realPlayer = :realPlayer")
    , @NamedQuery(name = "PsGuest.findByWindowsMedia", query = "SELECT p FROM PsGuest p WHERE p.windowsMedia = :windowsMedia")
    , @NamedQuery(name = "PsGuest.findByAcceptLanguage", query = "SELECT p FROM PsGuest p WHERE p.acceptLanguage = :acceptLanguage")
    , @NamedQuery(name = "PsGuest.findByMobileTheme", query = "SELECT p FROM PsGuest p WHERE p.mobileTheme = :mobileTheme")})
public class PsGuest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_guest")
    private Integer idGuest;
    @Column(name = "id_operating_system")
    private Integer idOperatingSystem;
    @Column(name = "id_web_browser")
    private Integer idWebBrowser;
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "javascript")
    private Boolean javascript;
    @Column(name = "screen_resolution_x")
    private Short screenResolutionX;
    @Column(name = "screen_resolution_y")
    private Short screenResolutionY;
    @Column(name = "screen_color")
    private Short screenColor;
    @Column(name = "sun_java")
    private Boolean sunJava;
    @Column(name = "adobe_flash")
    private Boolean adobeFlash;
    @Column(name = "adobe_director")
    private Boolean adobeDirector;
    @Column(name = "apple_quicktime")
    private Boolean appleQuicktime;
    @Column(name = "real_player")
    private Boolean realPlayer;
    @Column(name = "windows_media")
    private Boolean windowsMedia;
    @Column(name = "accept_language")
    private String acceptLanguage;
    @Basic(optional = false)
    @Column(name = "mobile_theme")
    private boolean mobileTheme;

    public PsGuest() {
    }

    public PsGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public PsGuest(Integer idGuest, boolean mobileTheme) {
        this.idGuest = idGuest;
        this.mobileTheme = mobileTheme;
    }

    public Integer getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(Integer idGuest) {
        this.idGuest = idGuest;
    }

    public Integer getIdOperatingSystem() {
        return idOperatingSystem;
    }

    public void setIdOperatingSystem(Integer idOperatingSystem) {
        this.idOperatingSystem = idOperatingSystem;
    }

    public Integer getIdWebBrowser() {
        return idWebBrowser;
    }

    public void setIdWebBrowser(Integer idWebBrowser) {
        this.idWebBrowser = idWebBrowser;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Boolean getJavascript() {
        return javascript;
    }

    public void setJavascript(Boolean javascript) {
        this.javascript = javascript;
    }

    public Short getScreenResolutionX() {
        return screenResolutionX;
    }

    public void setScreenResolutionX(Short screenResolutionX) {
        this.screenResolutionX = screenResolutionX;
    }

    public Short getScreenResolutionY() {
        return screenResolutionY;
    }

    public void setScreenResolutionY(Short screenResolutionY) {
        this.screenResolutionY = screenResolutionY;
    }

    public Short getScreenColor() {
        return screenColor;
    }

    public void setScreenColor(Short screenColor) {
        this.screenColor = screenColor;
    }

    public Boolean getSunJava() {
        return sunJava;
    }

    public void setSunJava(Boolean sunJava) {
        this.sunJava = sunJava;
    }

    public Boolean getAdobeFlash() {
        return adobeFlash;
    }

    public void setAdobeFlash(Boolean adobeFlash) {
        this.adobeFlash = adobeFlash;
    }

    public Boolean getAdobeDirector() {
        return adobeDirector;
    }

    public void setAdobeDirector(Boolean adobeDirector) {
        this.adobeDirector = adobeDirector;
    }

    public Boolean getAppleQuicktime() {
        return appleQuicktime;
    }

    public void setAppleQuicktime(Boolean appleQuicktime) {
        this.appleQuicktime = appleQuicktime;
    }

    public Boolean getRealPlayer() {
        return realPlayer;
    }

    public void setRealPlayer(Boolean realPlayer) {
        this.realPlayer = realPlayer;
    }

    public Boolean getWindowsMedia() {
        return windowsMedia;
    }

    public void setWindowsMedia(Boolean windowsMedia) {
        this.windowsMedia = windowsMedia;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public boolean getMobileTheme() {
        return mobileTheme;
    }

    public void setMobileTheme(boolean mobileTheme) {
        this.mobileTheme = mobileTheme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGuest != null ? idGuest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsGuest)) {
            return false;
        }
        PsGuest other = (PsGuest) object;
        if ((this.idGuest == null && other.idGuest != null) || (this.idGuest != null && !this.idGuest.equals(other.idGuest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsGuest[ idGuest=" + idGuest + " ]";
    }
    
}
