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
public class SubPages implements Serializable{
 private int categoryId;
    private int contentId;
    private int keyword;
    private String pageTitle;
    private String directUrl;
    private String defaultPicture;
    private String defaultPictureAttr;
    private String defaultDesc;
    private String summary;

    public SubPages(int categoryId, int contentId, int keyword, String pageTitle, String directUrl, String defaultPicture, String defaultPictureAttr, String summary) {
        this.categoryId = categoryId;
        this.contentId = contentId;
        this.keyword = keyword;
        this.pageTitle = pageTitle;
        this.directUrl = directUrl;
        this.defaultPicture = defaultPicture;
        this.defaultPictureAttr = defaultPictureAttr;
        this.summary = summary;
    }

    public SubPages() {
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
     * @return the keyword
     */
    public int getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(int keyword) {
        this.keyword = keyword;
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

    /**
     * @return the defaultPicture
     */
    public String getDefaultPicture() {
        return defaultPicture;
    }

    /**
     * @param defaultPicture the defaultPicture to set
     */
    public void setDefaultPicture(String defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

 @Override
    public String toString(){
        return "Content "+getCategoryId()+" - "+getPageTitle();
    }

    /**
     * @return the defaultDesc
     */
    public String getDefaultDesc() {
        return defaultDesc;
    }

    /**
     * @param defaultDesc the defaultDesc to set
     */
    public void setDefaultDesc(String defaultDesc) {
        this.defaultDesc = defaultDesc;
    }

    public String getDefaultPictureAttr() {
        return defaultPictureAttr;
    }

    public void setDefaultPictureAttr(String defaultPictureAttr) {
        this.defaultPictureAttr = defaultPictureAttr;
    }
}
