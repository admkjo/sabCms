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
public class Resources implements Serializable{
    private int resourceId;
    private String resourceUrl;
    private String resourceDesc;
    private String xtraInfo;

    /**
     * @return the resourceId
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * @return the resourceUrl
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * @param resourceUrl the resourceUrl to set
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * @return the resourceDesc
     */
    public String getResourceDesc() {
        return resourceDesc;
    }

    /**
     * @param resourceDesc the resourceDesc to set
     */
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    /**
     * @return the xtraInfo
     */
    public String getXtraInfo() {
        return xtraInfo;
    }

    /**
     * @param xtraInfo the xtraInfo to set
     */
    public void setXtraInfo(String xtraInfo) {
        this.xtraInfo = xtraInfo;
    }

    @Override
    public String toString(){
        return "Resource "+getResourceId()+" - "+getResourceUrl();
    }
}
