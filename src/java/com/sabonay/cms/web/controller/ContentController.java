/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.ApplicationConstant;
import com.sabonay.cms.web.common.CommonUtils;
import com.sabonay.cms.web.common.utilities.JSFUtility;
import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.generated.Category;
import com.sabonay.ejb.entities.generated.Content;
import com.sabonay.ejb.entities.generated.ContentResource;
import com.sabonay.ejb.entities.generated.Resources; 
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author emma
 */
@Named
@ViewScoped
public class ContentController implements Serializable {

    private List<Content> news = new ArrayList<>();
    private List<Content> pages = new ArrayList<>();
    private List<Content> press = new ArrayList<>();
    private List<Resources> pics = new ArrayList<>();
    private List<Content> gallery = new ArrayList<>();
    List<SelectItem> listOfAlbums;
    private List<ContentResource> contentResources = new ArrayList<>();
    private Content content = new Content();
    private FileUploadController fileUploadController = new FileUploadController();
    private ResourcesController resourcesController = new ResourcesController();
    private Category category = new Category();
    private ContentResource contentResource = new ContentResource();
    private Resources resources = new Resources();
    private String userPassword = null;
    private boolean inEditMode = false;
    private boolean inSubPageMode = false;
    private boolean formShow = false;
    private String contentBody = "";
    private String directLink = "";
    private int categoryid = 5328;
    private String ptitle = "General News";
    private int resourceId = 0;
    private Part part1 = null;
    private Part part2 = null;
    private Part part3 = null;
    private Part part4 = null;
    private Part part5 = null;
    private Part part6 = null;
    private int galleryid = 0;
    int pageChecker = 0;
    private String statusMessage;
    String link = "";
    String d = "";

//    private String basePath = System.getProperty("com.sun.aas.instanceRoot") + File.separator + "docroot" + File.separator + "stma_metro" + File.separator;
    public ContentController() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        link = request.getRequestURI();
        if (link.endsWith("press.xhtml")) {
            d = "272";
        }
        if (link.endsWith("gallery.xhtml")) {
            d = "5004";

        }
        if (link.endsWith("news.xhtml")) {
            d = "5328";

        }
        if (link.endsWith("pictures.xhtml")) {
            d = "5000";

        }
        listOfAlbums = new ArrayList<SelectItem>();
        List<Content> listOfContent = CMSDataSource.dataSource().contentGetGallery();
        listOfAlbums.add(new SelectItem("", "--Select Album--"));
        for (Content contenti : listOfContent) {
            listOfAlbums.add(new SelectItem(contenti.getContentId(), contenti.getPtitle()));
        }

    }

    public void editContent() {
        resourceId = 0;
        inEditMode = true;
        contentBody = content.getPcontent();
        formShow = true;
        subPage();
        contentResourceId();
    }

    public void addSubPage() {
        resourceId = 0;
        inSubPageMode = true;
//        contentBody = content.getPcontent();
        formShow = true;
        subPage();
        content = new Content();

    }

    public void addNewContent() {
        resourceId = 0;
        categoryid = 5328;
        ptitle = "General News";
        inSubPageMode = false;
        inEditMode = false;
        content = new Content();
        formShow = true;
    }

    public void saveContent() throws IOException, SQLException {
        //adding new page
        if (!inEditMode) {
            //Adding  News Content
            if ("5328".equalsIgnoreCase(d)) {
                autoUnpublishLastNews();
                content.setCattype("page");
                content.setCategoryid(5328);
                content.setDatecreated(Calendar.getInstance().getTime());
                content.setLastmodified(Calendar.getInstance().getTime());
                if (directLink.length() > 4) {
                    content.setUrl("New Tab/Window");
                }
                content.setDirectlink(getDirectLink());
                CMSDataSource.dataSource().contentCreate(content);
                System.out.println("direct Link" + getDirectLink());
                uploadDoc();

                JSFUtility.infoMessage("Content has been added.");
            } //creating Galery
            else if ("5004".equalsIgnoreCase(d)) {
//                category.setCategoryName(content.getPtitle());
//                category.setIsPublished("yes");
//                category.setParentId(5004);
//                category.setCategoryOrder(1);
//                CMSDataSource.dataSource().categoryCreate(category);

                content.setCattype("cat");
                content.setCategoryid(5004);
                content.setDatecreated(Calendar.getInstance().getTime());
                content.setLastmodified(Calendar.getInstance().getTime());
                CMSDataSource.dataSource().contentCreate(content);
                uploadDoc();

                JSFUtility.infoMessage("Content has been added.");
            }//creating press release
            else if ("272".equalsIgnoreCase(d)) {
                category.setCategoryName(content.getPtitle());
                category.setIsPublished("yes");
                category.setParentId(272);
                category.setCategoryOrder(1);
                CMSDataSource.dataSource().categoryCreate(category);

                content.setCattype("cat");
                content.setCategoryid(category.getCategoryId());
                content.setDatecreated(Calendar.getInstance().getTime());
                content.setLastmodified(Calendar.getInstance().getTime());
                CMSDataSource.dataSource().contentCreate(content);
                uploadDoc();

                JSFUtility.infoMessage("Content has been added.");
            } else if ("5000".equalsIgnoreCase(d)) {

                content.setCattype("cat");
                content.setCategoryid(galleryid);
                content.setDatecreated(Calendar.getInstance().getTime());
                content.setLastmodified(Calendar.getInstance().getTime());
                content.setPtitle("Gallery Image");
                CMSDataSource.dataSource().contentCreate(content);
                uploadDoc();

                JSFUtility.infoMessage("Content has been added.");
            } else {
                category.setCategoryName(content.getPtitle());
                category.setIsPublished("yes");
                category.setParentId(categoryid);
                category.setCategoryOrder(1);
                CMSDataSource.dataSource().categoryCreate(category);

                content.setCattype("cat");
                content.setCategoryid(category.getCategoryId());
                content.setDatecreated(Calendar.getInstance().getTime());
                content.setLastmodified(Calendar.getInstance().getTime());
                CMSDataSource.dataSource().contentCreate(content);
                uploadDoc();

                JSFUtility.infoMessage("Content has been added.");
            }

        } //editing a page
        else {

            CMSDataSource.dataSource().contentUpdate(content);
            uploadDoc();
            JSFUtility.infoMessage("Content has been updated.");

        }
        reset();
    }

    public void deleteContent() {
        CMSDataSource.dataSource().contentDelete(content);
        deleteResource();
        JSFUtility.infoMessage("Content has been deleted.");
        reset();

    }

    public void deleteResource() {
        try {

            int resid = (int) CMSDataSource.dataSource().contentResourceId("resourceid", "contentid", content.getContentId());
            CMSDataSource.dataSource().resourcesDeletebyid(resid);
            CMSDataSource.dataSource().contentResourcesDeletebyid(resid);
            System.out.println("cresid" + resid);
        } catch (Exception e) {
        }

    }

    public void contentResourceId() {
        try {

            int cResourceID = content.getContentId();
            resourceId = (int) CMSDataSource.dataSource().contentResourceId("resourceid", "contentid", cResourceID);
        } catch (Exception e) {
        }
    }

    public void uploadDoc() throws IOException, SQLException {
        //uploading about to start
        try {

            if (part1.getSize() > 0 && null != part1) {
                System.out.println("file size is " + part1.getSize());
                fileUploadController.uploadFile(part1);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }
            if (part2.getSize() > 0 && null != part2) {
                System.out.println("file size is " + part2.getSize());
                fileUploadController.uploadFile(part2);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }
            if (part3.getSize() > 0 && null != part3) {
                System.out.println("file size is " + part3.getSize());
                fileUploadController.uploadFile(part3);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }
            if (part4.getSize() > 0 && null != part4) {
                System.out.println("file size is " + part4.getSize());
                fileUploadController.uploadFile(part4);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }
            if (part5.getSize() > 0 && null != part5) {
                System.out.println("file size is " + part5.getSize());
                fileUploadController.uploadFile(part5);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }
            if (part6.getSize() > 0 && null != part6) {
                System.out.println("file size is " + part6.getSize());
                fileUploadController.uploadFile(part6);
                saveContentResource();
                saveResources();
                System.out.println("File Uploading Finished, Content Resource saved and Resources Saved");
            }

        } catch (Exception e) {
            System.out.println("No file Uploaded. Either No file was chosen or error occured in file upload.");
        }
        reset();
    }

    public void subPage() {
        formShow = true;
        int parentCat = content.getContentId();
        if (inSubPageMode || inEditMode) {
            categoryid = (int) CMSDataSource.dataSource().contentNameByID("categoryid", "contentId", parentCat);

            ptitle = (String) CMSDataSource.dataSource().contentNameByID("ptitle", "contentId", parentCat);

        } else {

            categoryid = 5328;
            ptitle = "General News";
        }

    }

    public void saveContentResource() {
        if (d.equalsIgnoreCase("5000")) {
            contentResource.setContentid(galleryid);
        } else {
            contentResource.setContentid(content.getContentId());

        }
        contentResource.setResourceorder(2);
        contentResource.setDatecreated((Calendar.getInstance().getTime()));
        CMSDataSource.dataSource().contentResourcesCreate(contentResource);
        System.out.println("enter contentresource save and get content id " + content.getContentId() + "id " + contentResource.getResourceid());
    }

    public void saveResources() {

        resources.setResourceid(contentResource.getResourceid());
        resources.setCategory(FileUploadController.f);
        resources.setResourceurl(FileUploadController.resourceurl);
        resources.setIspublished(1);
        resources.setOtherattri("style=\"width: 450px; height: 250px\"");
        resources.setResourcedesc(content.getPtitle());
        CMSDataSource.dataSource().resourcesCreate(resources);
    }

    public static void autoUnpublishLastNews() throws SQLException {
        String catid = CommonUtils.getSettingValue(ApplicationConstant.NEWS_CATEGORY);
        System.out.println("catid..." + catid);
        String sql = "select count(*) from content where ispublished='yes' and categoryid=" + catid;

        ResultSet rs = CMSDataSource.dataSource().processQuery(sql);
        if (rs.next() && rs.getInt(1) > 19) {

            sql = "select content_id from content where ispublished='yes' and categoryid=" + catid + " order by content_id limit 1";
            rs = CMSDataSource.dataSource().processQuery(sql);
            System.out.println("first pass");
            if (rs.next()) {
                sql = "update content set ispublished='no' where content_id=" + rs.getInt(1);
                CMSDataSource.dataSource().updateQuery(sql);

                System.out.println("Unpublished Item");
            }
        }
    }

    public void reset() {
        content = new Content();
        inEditMode = false;
        categoryid = 5328;
        ptitle = "General News";
        userPassword = null;
        resourceId = 0;
        formShow = false;
    }

    public boolean isInEditMode() {
        return inEditMode;
    }

    public String parent(String cattype, Integer catid) {
        if ("cat".equals(cattype)) {
            Category c = CMSDataSource.dataSource().categoryFind(catid);
            return c != null ? c.getCategoryName() : "";
        } else {
            Content c = CMSDataSource.dataSource().contentFind(catid);
            return c != null ? c.getPtitle() : "";
        }
    }

    public void setInEditMode(boolean inEditMode) {
        this.inEditMode = inEditMode;
    }

    public boolean isFormShow() {
        return formShow;
    }

    public void setFormShow(boolean formShow) {
        this.formShow = formShow;
    }

    public List<Content> getNews() {
        news = CMSDataSource.dataSource().contentGetNews();
        return news;
    }

    public void setNews(List<Content> news) {
        this.news = news;
    }

    public List<Content> getPages() {
        pages = CMSDataSource.dataSource().contentGetPages();
        return pages;
    }

    public void setPages(List<Content> pages) {
        this.pages = pages;
    }

    public List<Resources> getPics() {
        pics = CMSDataSource.dataSource().contentGetPics();
        return pics;
    }

    public void setPics(List<Resources> pics) {
        this.pics = pics;
    }

    public List<Content> getGallery() {
        gallery = CMSDataSource.dataSource().contentGetGallery();

        return gallery;
    }

    public void setGallery(List<Content> gallery) {
        this.gallery = gallery;
    }

    public List<Content> getPress() {
        press = CMSDataSource.dataSource().contentGetPressRelease();
        return press;
    }

    public void setPress(List<Content> press) {
        this.press = press;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public int getSubPageid() {
        return categoryid;
    }

    public void setSubPageid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getSubPageName() {
        return ptitle;
    }

    public void setSubPageName(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public boolean isInSubPageMode() {
        return inSubPageMode;
    }

    public void setInSubPageMode(boolean inSubPageMode) {
        this.inSubPageMode = inSubPageMode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public List<ContentResource> getContentResources() {
        try {
            if (resourceId != 0) {
                contentResources = CMSDataSource.dataSource().contentResourceFindByAttribute("resourceid", resourceId, "number");
                return contentResources;
            } else {
                return null;
            }
        } catch (Exception e) {;
            return null;
        }
    }

    public void setContentResources(List<ContentResource> contentResources) {
        this.contentResources = contentResources;
    }

    public ResourcesController getResourcesController() {
        return resourcesController;
    }

    public void setResourcesController(ResourcesController resourcesController) {
        this.resourcesController = resourcesController;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Part getPart1() {
        return part1;
    }

    public void setPart1(Part part1) {
        this.part1 = part1;
    }

    public Part getPart2() {
        return part2;
    }

    public void setPart2(Part part2) {
        this.part2 = part2;
    }

    public Part getPart3() {
        return part3;
    }

    public void setPart3(Part part3) {
        this.part3 = part3;
    }

    public Part getPart4() {
        return part4;
    }

    public void setPart4(Part part4) {
        this.part4 = part4;
    }

    public Part getPart5() {
        return part5;
    }

    public void setPart5(Part part5) {
        this.part5 = part5;
    }

    public Part getPart6() {
        return part6;
    }

    public void setPart6(Part part6) {
        this.part6 = part6;
    }

    public FileUploadController getFileUploadController() {
        return fileUploadController;
    }

    public void setFileUploadController(FileUploadController fileUploadController) {
        this.fileUploadController = fileUploadController;
    }

    public ContentResource getContentResource() {
        return contentResource;
    }

    public void setContentResource(ContentResource contentResource) {
        this.contentResource = contentResource;
    }

    public int getGalleryid() {
        return galleryid;
    }

    public void setGalleryid(int galleryid) {
        this.galleryid = galleryid;
    }

    public String getDirectLink() {
        return directLink;
    }

    public void setDirectLink(String directLink) {
        this.directLink = directLink;
    }

    public List<SelectItem> getListOfAlbums() {
        return listOfAlbums;
    }

    public void setListOfAlbums(List<SelectItem> listOfAlbums) {
        this.listOfAlbums = listOfAlbums;
    }

}
