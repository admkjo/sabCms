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
public class IncludedPage implements Serializable{
    private String pageUrl;
    private String pageId;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
    private String pageDesc;

    public IncludedPage(String pageUrl, String pageDesc,String page) {
        this.pageUrl = pageUrl;
        this.pageDesc = pageDesc;
        this.pageId =page;
    }

    /**
     * @return the pageUrl
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * @param pageUrl the pageUrl to set
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * @return the pageDesc
     */
    public String getPageDesc() {
        return pageDesc;
    }

    /**
     * @param pageDesc the pageDesc to set
     */
    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }

}
