/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seth
 */
public class Page implements Serializable{
    private String pageTitle;
    private String pageContent;
    private String keyword;
    private String source;
    private String datePublished;
    private int categoryId;
    private String isPublished;
    private String directUrl;
    private int pageid;
    private String cattype;
    private String pageHit;
    private String xtraInfo;
    private Resources[] pageResources;
    private String[] firstImage;
    private ArrayList<Category> pageCategory;
    private RelatedPages[] relatedPages;
    private ArrayList<SubPages> subPages;
    private List<IncludedPage> includedPages;

    public List<IncludedPage> getIncludedPages() {
        return includedPages;
    }

    public void setIncludedPages(List<IncludedPage> includedPages) {
        this.includedPages = includedPages;
    }

    public Page(){}
    public Page(String pageTitle, String pageContent, String keyword, String source, String datePublished, String pageHit, Resources[] pageResources, ArrayList<Category> pageCategory, RelatedPages[] relatedPages, ArrayList<SubPages> subPages) {
        this.pageTitle = pageTitle;
        this.pageContent = pageContent;
        this.keyword = keyword;
        this.pageHit = pageHit;
        this.pageResources = pageResources;
        this.pageCategory = pageCategory;
        this.relatedPages = relatedPages;
        this.subPages = subPages;
        this.source = source;
        this.datePublished = datePublished;
    }
     public Page(int pageid,String pageTitle, String pageContent, String keyword,int categoryid ,String directUrl) {
        this.pageid = pageid;
         this.pageTitle = pageTitle;
        this.pageContent = pageContent;
        this.keyword = keyword;
        this.categoryId =categoryid;
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
     * @return the pageContent
     */
    public String getPageContent() {
        return pageContent;
    }

    /**
     * @param pageContent the pageContent to set
     */
    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the pageHit
     */
    public String getPageHit() {
        return pageHit;
    }

    /**
     * @param pageHit the pageHit to set
     */
    public void setPageHit(String pageHit) {
        this.pageHit = pageHit;
    }

    /**
     * @return the pageResources
     */
    public Resources[] getPageResources() {
        return pageResources;
    }

    /**
     * @param pageResources the pageResources to set
     */
    public void setPageResources(Resources[] pageResources) {
        this.pageResources = pageResources;
    }

    /**
     * @return the pageCategory
     */
    public ArrayList<Category> getPageCategory() {
        return pageCategory;
    }

    /**
     * @param pageCategory the pageCategory to set
     */
    public void setPageCategory(ArrayList<Category> pageCategory) {
        this.pageCategory = pageCategory;
    }

    /**
     * @return the relatedPages
     */
    public RelatedPages[] getRelatedPages() {
        return relatedPages;
    }

    /**
     * @param relatedPages the relatedPages to set
     */
    public void setRelatedPages(RelatedPages[] relatedPages) {
        this.relatedPages = relatedPages;
    }

    /**
     * @return the subPages
     */
    public ArrayList<SubPages> getSubPages() {
        return subPages;
    }

    /**
     * @param subPages the subPages to set
     */
    public void setSubPages(ArrayList<SubPages> subPages) {
        this.subPages = subPages;
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
     * @return the pageid
     */
    public int getPageid() {
        return pageid;
    }

    /**
     * @param pageid the pageid to set
     */
    public void setPageid(int pageid) {
        this.pageid = pageid;
    }

    /**
     * @return the cattype
     */
    public String getCattype() {
        return cattype;
    }

    /**
     * @param cattype the cattype to set
     */
    public void setCattype(String cattype) {
        this.cattype = cattype;
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

    /**
     * @return the firstImage
     */
    public String[] getFirstImage() {
        return firstImage;
    }

    /**
     * @param firstImage the firstImage to set
     */
    public void setFirstImage(String[] firstImage) {
        this.firstImage = firstImage;
    }

    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the datePublished
     */
    public String getDatePublished() {
        return datePublished;
    }

    /**
     * @param datePublished the datePublished to set
     */
    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

}
