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
public class WhereWeAre implements Serializable{
    private int contentId;
    private String pageTitle;
    private String whereUrl;

    public WhereWeAre() {
    }

    
    /**
     * @return the contentId
     */
    public int getContentId() {
        return contentId;
    }

    /**
     * @param contentId the contentId to set
     */
    public void setContentId(int contentId) {
        this.contentId = contentId;
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
     * @return the whereUrl
     */
    public String getWhereUrl() {
        return whereUrl;
    }

    /**
     * @param whereUrl the whereUrl to set
     */
    public void setWhereUrl(String whereUrl) {
        this.whereUrl = whereUrl;
    }
}
