/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.ejb.entities;

import java.io.Serializable;

/**
 *
 * @author seth
 */
public class Settings implements Serializable{
    private String sitename;
    private String siteInitials;
    private String sitelogo;
    private String currentBanner;
    private String currentTheme;
    private String useUrlParam;
    private String allowSharing;
    private String allowPrinting;
    private String allowEmail;
    private String showLocation;
    private String siteDescription;
    private String siteKeyword;
    private String showPageClick;
    private String googleApikey;
    private String googleMapLocation;

    public Settings() {
    }


    public Settings(String sitename, String siteInitials, String sitelogo, String currentBanner, String currentTheme, String useUrlParam, String allowSharing, String allowPrinting, String allowEmail, String showLocation, String siteDescription, String siteKeyword, String showPageClick, String googleApikey, String googleMapLocation) {
        this.sitename = sitename;
        this.siteInitials = siteInitials;
        this.sitelogo = sitelogo;
        this.currentBanner = currentBanner;
        this.currentTheme = currentTheme;
        this.useUrlParam = useUrlParam;
        this.allowSharing = allowSharing;
        this.allowPrinting = allowPrinting;
        this.allowEmail = allowEmail;
        this.showLocation = showLocation;
        this.siteDescription = siteDescription;
        this.siteKeyword = siteKeyword;
        this.showPageClick = showPageClick;
        this.googleApikey = googleApikey;
        this.googleMapLocation = googleMapLocation;
    }



    /**
     * @return the sitename
     */
    public String getSitename() {
        return sitename;
    }

    /**
     * @param sitename the sitename to set
     */
    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    /**
     * @return the siteInitials
     */
    public String getSiteInitials() {
        return siteInitials;
    }

    /**
     * @param siteInitials the siteInitials to set
     */
    public void setSiteInitials(String siteInitials) {
        this.siteInitials = siteInitials;
    }

    /**
     * @return the sitelogo
     */
    public String getSitelogo() {
        return sitelogo;
    }

    /**
     * @param sitelogo the sitelogo to set
     */
    public void setSitelogo(String sitelogo) {
        this.sitelogo = sitelogo;
    }

    /**
     * @return the currentBanner
     */
    public String getCurrentBanner() {
        return currentBanner;
    }

    /**
     * @param currentBanner the currentBanner to set
     */
    public void setCurrentBanner(String currentBanner) {
        this.currentBanner = currentBanner;
    }

    /**
     * @return the currentTheme
     */
    public String getCurrentTheme() {
        return currentTheme;
    }

    /**
     * @param currentTheme the currentTheme to set
     */
    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
    }

    /**
     * @return the useUrlParam
     */
    public String getUseUrlParam() {
        return useUrlParam;
    }

    /**
     * @param useUrlParam the useUrlParam to set
     */
    public void setUseUrlParam(String useUrlParam) {
        this.useUrlParam = useUrlParam;
    }

    /**
     * @return the allowSharing
     */
    public String getAllowSharing() {
        return allowSharing;
    }

    /**
     * @param allowSharing the allowSharing to set
     */
    public void setAllowSharing(String allowSharing) {
        this.allowSharing = allowSharing;
    }

    /**
     * @return the allowPrinting
     */
    public String getAllowPrinting() {
        return allowPrinting;
    }

    /**
     * @param allowPrinting the allowPrinting to set
     */
    public void setAllowPrinting(String allowPrinting) {
        this.allowPrinting = allowPrinting;
    }

    /**
     * @return the allowEmail
     */
    public String getAllowEmail() {
        return allowEmail;
    }

    /**
     * @param allowEmail the allowEmail to set
     */
    public void setAllowEmail(String allowEmail) {
        this.allowEmail = allowEmail;
    }

    /**
     * @return the showLocation
     */
    public String getShowLocation() {
        return showLocation;
    }

    /**
     * @param showLocation the showLocation to set
     */
    public void setShowLocation(String showLocation) {
        this.showLocation = showLocation;
    }

    /**
     * @return the siteDescription
     */
    public String getSiteDescription() {
        return siteDescription;
    }

    /**
     * @param siteDescription the siteDescription to set
     */
    public void setSiteDescription(String siteDescription) {
        this.siteDescription = siteDescription;
    }

    /**
     * @return the siteKeyword
     */
    public String getSiteKeyword() {
        return siteKeyword;
    }

    /**
     * @param siteKeyword the siteKeyword to set
     */
    public void setSiteKeyword(String siteKeyword) {
        this.siteKeyword = siteKeyword;
    }

    /**
     * @return the showPageClick
     */
    public String getShowPageClick() {
        return showPageClick;
    }

    /**
     * @param showPageClick the showPageClick to set
     */
    public void setShowPageClick(String showPageClick) {
        this.showPageClick = showPageClick;
    }

    /**
     * @return the googleApikey
     */
    public String getGoogleApikey() {
        return googleApikey;
    }

    /**
     * @param googleApikey the googleApikey to set
     */
    public void setGoogleApikey(String googleApikey) {
        this.googleApikey = googleApikey;
    }

    /**
     * @return the googleMapLocation
     */
    public String getGoogleMapLocation() {
        return googleMapLocation;
    }

    /**
     * @param googleMapLocation the googleMapLocation to set
     */
    public void setGoogleMapLocation(String googleMapLocation) {
        this.googleMapLocation = googleMapLocation;
    }
    

}
