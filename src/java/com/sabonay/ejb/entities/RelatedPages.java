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
public class RelatedPages implements Serializable{
    private String pageTitle;
    private String directUrl;

    public RelatedPages(String pageTitle, String directUrl) {
        this.pageTitle = pageTitle;
        this.directUrl = directUrl;
    }

    /**
     * @return the pageTitle
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * @param pageTitle the pageTitle to set
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * @return the directUrl
     */
    public String getDirectUrl() {
        return directUrl;
    }

    /**
     * @param directUrl the directUrl to set
     */
    public void setDirectUrl(String directUrl) {
        this.directUrl = directUrl;
    }


}
