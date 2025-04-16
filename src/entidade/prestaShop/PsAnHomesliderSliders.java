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
 * @author leo-note
 */
@Entity
@Table(name = "ps_an_homeslider_sliders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PsAnHomesliderSliders.findAll", query = "SELECT p FROM PsAnHomesliderSliders p")})
public class PsAnHomesliderSliders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_slider")
    private Integer idSlider;
    @Basic(optional = false)
    @Column(name = "active")
    private short active;
    @Basic(optional = false)
    @Column(name = "hook")
    private String hook;
    @Basic(optional = false)
    @Column(name = "preloader")
    private short preloader;
    @Basic(optional = false)
    @Column(name = "preloader_height_1920")
    private int preloaderHeight1920;
    @Basic(optional = false)
    @Column(name = "preloader_height_1600")
    private int preloaderHeight1600;
    @Basic(optional = false)
    @Column(name = "preloader_height_1366")
    private int preloaderHeight1366;
    @Basic(optional = false)
    @Column(name = "preloader_height_991")
    private int preloaderHeight991;
    @Basic(optional = false)
    @Column(name = "preloader_height_767")
    private int preloaderHeight767;
    @Basic(optional = false)
    @Column(name = "preloader_mobile_height_580")
    private int preloaderMobileHeight580;
    @Basic(optional = false)
    @Column(name = "preloader_mobile_height_440")
    private int preloaderMobileHeight440;
    @Basic(optional = false)
    @Column(name = "preloader_mobile_height_320")
    private int preloaderMobileHeight320;
    @Basic(optional = false)
    @Column(name = "lazy_load")
    private short lazyLoad;
    @Basic(optional = false)
    @Column(name = "loop")
    private short loop;
    @Basic(optional = false)
    @Column(name = "nav")
    private short nav;
    @Basic(optional = false)
    @Column(name = "dots")
    private short dots;
    @Basic(optional = false)
    @Column(name = "autoplay")
    private short autoplay;
    @Basic(optional = false)
    @Column(name = "smartspeed")
    private int smartspeed;
    @Basic(optional = false)
    @Column(name = "autoplay_timeout")
    private int autoplayTimeout;
    @Basic(optional = false)
    @Column(name = "responsive_image")
    private short responsiveImage;
    @Basic(optional = false)
    @Column(name = "show_on")
    private int showOn;
    @Basic(optional = false)
    @Column(name = "show_content_on")
    private int showContentOn;

    public PsAnHomesliderSliders() {
    }

    public PsAnHomesliderSliders(Integer idSlider) {
        this.idSlider = idSlider;
    }

    public PsAnHomesliderSliders(Integer idSlider, short active, String hook, short preloader, int preloaderHeight1920, int preloaderHeight1600, int preloaderHeight1366, int preloaderHeight991, int preloaderHeight767, int preloaderMobileHeight580, int preloaderMobileHeight440, int preloaderMobileHeight320, short lazyLoad, short loop, short nav, short dots, short autoplay, int smartspeed, int autoplayTimeout, short responsiveImage, int showOn, int showContentOn) {
        this.idSlider = idSlider;
        this.active = active;
        this.hook = hook;
        this.preloader = preloader;
        this.preloaderHeight1920 = preloaderHeight1920;
        this.preloaderHeight1600 = preloaderHeight1600;
        this.preloaderHeight1366 = preloaderHeight1366;
        this.preloaderHeight991 = preloaderHeight991;
        this.preloaderHeight767 = preloaderHeight767;
        this.preloaderMobileHeight580 = preloaderMobileHeight580;
        this.preloaderMobileHeight440 = preloaderMobileHeight440;
        this.preloaderMobileHeight320 = preloaderMobileHeight320;
        this.lazyLoad = lazyLoad;
        this.loop = loop;
        this.nav = nav;
        this.dots = dots;
        this.autoplay = autoplay;
        this.smartspeed = smartspeed;
        this.autoplayTimeout = autoplayTimeout;
        this.responsiveImage = responsiveImage;
        this.showOn = showOn;
        this.showContentOn = showContentOn;
    }

    public Integer getIdSlider() {
        return idSlider;
    }

    public void setIdSlider(Integer idSlider) {
        this.idSlider = idSlider;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getHook() {
        return hook;
    }

    public void setHook(String hook) {
        this.hook = hook;
    }

    public short getPreloader() {
        return preloader;
    }

    public void setPreloader(short preloader) {
        this.preloader = preloader;
    }

    public int getPreloaderHeight1920() {
        return preloaderHeight1920;
    }

    public void setPreloaderHeight1920(int preloaderHeight1920) {
        this.preloaderHeight1920 = preloaderHeight1920;
    }

    public int getPreloaderHeight1600() {
        return preloaderHeight1600;
    }

    public void setPreloaderHeight1600(int preloaderHeight1600) {
        this.preloaderHeight1600 = preloaderHeight1600;
    }

    public int getPreloaderHeight1366() {
        return preloaderHeight1366;
    }

    public void setPreloaderHeight1366(int preloaderHeight1366) {
        this.preloaderHeight1366 = preloaderHeight1366;
    }

    public int getPreloaderHeight991() {
        return preloaderHeight991;
    }

    public void setPreloaderHeight991(int preloaderHeight991) {
        this.preloaderHeight991 = preloaderHeight991;
    }

    public int getPreloaderHeight767() {
        return preloaderHeight767;
    }

    public void setPreloaderHeight767(int preloaderHeight767) {
        this.preloaderHeight767 = preloaderHeight767;
    }

    public int getPreloaderMobileHeight580() {
        return preloaderMobileHeight580;
    }

    public void setPreloaderMobileHeight580(int preloaderMobileHeight580) {
        this.preloaderMobileHeight580 = preloaderMobileHeight580;
    }

    public int getPreloaderMobileHeight440() {
        return preloaderMobileHeight440;
    }

    public void setPreloaderMobileHeight440(int preloaderMobileHeight440) {
        this.preloaderMobileHeight440 = preloaderMobileHeight440;
    }

    public int getPreloaderMobileHeight320() {
        return preloaderMobileHeight320;
    }

    public void setPreloaderMobileHeight320(int preloaderMobileHeight320) {
        this.preloaderMobileHeight320 = preloaderMobileHeight320;
    }

    public short getLazyLoad() {
        return lazyLoad;
    }

    public void setLazyLoad(short lazyLoad) {
        this.lazyLoad = lazyLoad;
    }

    public short getLoop() {
        return loop;
    }

    public void setLoop(short loop) {
        this.loop = loop;
    }

    public short getNav() {
        return nav;
    }

    public void setNav(short nav) {
        this.nav = nav;
    }

    public short getDots() {
        return dots;
    }

    public void setDots(short dots) {
        this.dots = dots;
    }

    public short getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(short autoplay) {
        this.autoplay = autoplay;
    }

    public int getSmartspeed() {
        return smartspeed;
    }

    public void setSmartspeed(int smartspeed) {
        this.smartspeed = smartspeed;
    }

    public int getAutoplayTimeout() {
        return autoplayTimeout;
    }

    public void setAutoplayTimeout(int autoplayTimeout) {
        this.autoplayTimeout = autoplayTimeout;
    }

    public short getResponsiveImage() {
        return responsiveImage;
    }

    public void setResponsiveImage(short responsiveImage) {
        this.responsiveImage = responsiveImage;
    }

    public int getShowOn() {
        return showOn;
    }

    public void setShowOn(int showOn) {
        this.showOn = showOn;
    }

    public int getShowContentOn() {
        return showContentOn;
    }

    public void setShowContentOn(int showContentOn) {
        this.showContentOn = showContentOn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSlider != null ? idSlider.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PsAnHomesliderSliders)) {
            return false;
        }
        PsAnHomesliderSliders other = (PsAnHomesliderSliders) object;
        if ((this.idSlider == null && other.idSlider != null) || (this.idSlider != null && !this.idSlider.equals(other.idSlider))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidade.prestaShop.PsAnHomesliderSliders[ idSlider=" + idSlider + " ]";
    }
    
}
