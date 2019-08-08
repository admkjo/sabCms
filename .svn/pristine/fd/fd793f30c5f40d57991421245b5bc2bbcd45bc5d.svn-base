/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.ejb.sessionbean;

import com.sabonay.ejb.entities.generated.AdminUser;
import com.sabonay.ejb.entities.generated.Category;
import com.sabonay.ejb.entities.generated.Content;
import com.sabonay.ejb.entities.generated.ContentResource;
import com.sabonay.ejb.entities.generated.Resources;
import com.sabonay.ejb.entities.generated.Settings;
import com.sabonay.ejb.entities.generated.UserComment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

/**
 *
 * @author emma
 */
@Stateless
public class CMSSessionBean {

    public static Connection conn = null;
    public static ResultSet rs;
    public static Statement st = null;
    @PersistenceContext(unitName = "tmaPU")
    private EntityManager em;

    // <editor-fold defaultstate="collapsed" desc=" AdminUser Persistence Functionalities">
    public Integer adminUserCreate(AdminUser adminUser) {
        try {
            em.persist(adminUser);
            em.flush();
            return adminUser.getAdminUserId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean adminUserDelete(AdminUser adminUser) {
        try {
            em.remove(em.merge(adminUser));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean adminUserUpdate(AdminUser adminUser) {
        try {
            em.merge(adminUser);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public AdminUser adminUserFind(String adminUserId) {
        try {

            AdminUser adminUser = em.find(AdminUser.class, adminUserId);
            return adminUser;
        } catch (Exception e) {
            return null;
        }
    }

    public List<AdminUser> adminUserFindByAttribute(String adminUserAttribute, Object attributeValue, String fieldType) {
        List<AdminUser> listOfAdminUser = null;

        String qryString = "";

        qryString = "SELECT e FROM AdminUser e ";
        qryString += "WHERE e." + adminUserAttribute + " =:adminUserAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfAdminUser = (List<AdminUser>) em.createQuery(qryString).setParameter("adminUserAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfAdminUser = (List<AdminUser>) em.createQuery(qryString).setParameter("adminUserAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfAdminUser = (List<AdminUser>) em.createQuery(qryString).setParameter("adminUserAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfAdminUser;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AdminUser> adminUserGetAll() {
        List<AdminUser> listOfAdminUser = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM AdminUser e WHERE e.systemView='1'";

            listOfAdminUser = (List<AdminUser>) em.createQuery(qryString).getResultList();

            return listOfAdminUser;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Category Persistence Functionalities">
    public Integer categoryCreate(Category category) {
        try {
            em.persist(category);
            em.flush();
            return category.getCategoryId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean categoryDelete(Category category) {
        try {
            em.remove(em.merge(category));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean categoryUpdate(Category category) {
        try {
            em.merge(category);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Category categoryFind(Integer categoryId) {
        try {

            Category category = em.find(Category.class, categoryId);
            return category;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Category> categoryFindByAttribute(String categoryAttribute, Object attributeValue, String fieldType) {
        List<Category> listOfCategory = null;

        String qryString = "";

        qryString = "SELECT e FROM Category e ";
        qryString += "WHERE e." + categoryAttribute + " =:categoryAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfCategory = (List<Category>) em.createQuery(qryString).setParameter("categoryAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfCategory = (List<Category>) em.createQuery(qryString).setParameter("categoryAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfCategory = (List<Category>) em.createQuery(qryString).setParameter("categoryAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfCategory;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Category> categoryGetAll() {
        List<Category> listOfCategory = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Category e ORDER BY e.categoryId DESC";

            listOfCategory = (List<Category>) em.createQuery(qryString).getResultList();

            return listOfCategory;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object categoryParentId(String firstAttribute, String contentid, int content_id) {
        try {

            String qryString = "";

            qryString = "SELECT e." + firstAttribute + " FROM Category e ";
            qryString += "WHERE e." + contentid + " ='" + content_id + "'";
            Object parentId = "";
            try {
                parentId = em.createQuery(qryString).getSingleResult();
                return parentId;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Content Persistence Functionalities">
    public Integer contentCreate(Content content) {
        try {
            em.persist(content);
            em.flush();
            return content.getContentId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean contentDelete(Content content) {
        try {
            em.remove(em.merge(content));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean contentUpdate(Content content) {
        try {
            em.merge(content);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Content contentFind(Integer contentId) {
        try {

            Content content = em.find(Content.class, contentId);
            return content;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Content> contentFindByAttribute(String contentAttribute, Object attributeValue, String fieldType) {
        List<Content> listOfContent = null;

        String qryString = "";

        qryString = "SELECT e FROM Content e ";
        qryString += "WHERE e." + contentAttribute + " =:contentAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfContent = (List<Content>) em.createQuery(qryString).setParameter("contentAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfContent = (List<Content>) em.createQuery(qryString).setParameter("contentAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfContent = (List<Content>) em.createQuery(qryString).setParameter("contentAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfContent;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Content> contentGetNews() {
        List<Content> listOfContent = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Content e where e.categoryid = '5328' ORDER BY e.contentId DESC";

            listOfContent = (List<Content>) em.createQuery(qryString).getResultList();

            return listOfContent;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Content> contentGetGallery() {
        List<Content> listOfContent = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Content e where e.categoryid = '5004' ORDER BY e.contentId DESC";

            listOfContent = (List<Content>) em.createQuery(qryString).getResultList();

            return listOfContent;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Resources> contentGetPics() {
        List<Content> listOfAlbums = new ArrayList<>();
        List<ContentResource> listOfPics = new ArrayList<>();
        List<Resources> listOfVariousPics = new ArrayList<>();

        String qryString1 = "";
        String qryString2 = "";
        String qryString3 = "";

        try {
            qryString1 = "SELECT e FROM Content e where e.categoryid = '5004' ";
            listOfAlbums = em.createQuery(qryString1).getResultList();
            System.out.println("listalbums: " + listOfAlbums);

            if (listOfAlbums != null) {
                for (Content contenti : listOfAlbums) {
                    qryString2 = "SELECT e  from ContentResource e where e.contentid = " + contenti.getContentId() + "";
                    listOfPics.addAll((List<ContentResource>) em.createQuery(qryString2).getResultList());
                }
                System.out.println("listpics " + listOfPics);

                for (ContentResource contente : listOfPics) {
                    qryString3 = "SELECT e  from Resources e where e.resourceid = " + contente.getResourceid() + "";
                    listOfVariousPics.add((Resources) em.createQuery(qryString3).getSingleResult());
                }
                System.out.println("listvariouspics " + listOfVariousPics);
                return listOfVariousPics;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Content> contentGetPressRelease() {
        List<Content> listOfPress = new ArrayList<>();

        String qryString = "";

        try {
            qryString = "SELECT e  from Content e INNER JOIN Category c on c.parentId = '272' and e.categoryid = c.categoryId ORDER BY e.contentId DESC";
            listOfPress = (List<Content>) em.createQuery(qryString).getResultList();

            return listOfPress;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Content> contentGetPages() {
        List<Content> listOfContent = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Content e where e.categoryid NOT IN (SELECT e.contentId FROM Content e where e.categoryid != '5328'  )"
                    + "and e.categoryid NOT IN (SELECT e.contentId FROM Content e where e.categoryid != '5004' ) ORDER BY e.contentId DESC";

            listOfContent = (List<Content>) em.createQuery(qryString).getResultList();

            return listOfContent;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object contentNameByID(String firstAttribute, String contentid, int content_id) {
        String qryString = "";

        qryString = "SELECT e." + firstAttribute + " FROM Content e ";
        qryString += "WHERE e." + contentid + " ='" + content_id + "'";
        Object contentName = "";
        try {
            contentName = em.createQuery(qryString).getSingleResult();
            return contentName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Resources Persistence Functionalities">
    public Integer resourcesCreate(Resources resources) {
        try {
            em.persist(resources);
            em.flush();
            return resources.getResourceid();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean resourcesDelete(Resources resources) {
        try {
            em.remove(em.merge(resources));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean resourcesUpdate(Resources resources) {
        try {
            em.merge(resources);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Resources resourcesFind(String resourcesId) {
        try {

            Resources resources = em.find(Resources.class, resourcesId);
            return resources;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean resourcesDeletebyid(int resourcesId) {
        try {
            String qryString = "";

            qryString = "Select e FROM Resources e ";
            qryString += "WHERE e.resourceid ='" + resourcesId + "'";

            Resources resource = (Resources) em.createQuery(qryString).getSingleResult();
            em.remove(resource);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Resources> resourcesFindByAttribute(String resourcesAttribute, Object attributeValue, String fieldType) {
        List<Resources> listOfResources = null;

        String qryString = "";

        qryString = "SELECT e FROM Resources e ";
        qryString += "WHERE e." + resourcesAttribute + " =:resourcesAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfResources = (List<Resources>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfResources = (List<Resources>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfResources = (List<Resources>) em.createQuery(qryString).setParameter("resourcesAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfResources;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Resources> resourcesGetAll() {
        List<Resources> listOfResources = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Resources e ORDER BY e.resourceid DESC";

            listOfResources = (List<Resources>) em.createQuery(qryString).getResultList();

            return listOfResources;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Settings Persistence Functionalities">
    public String settingsCreate(Settings settings) {
        try {
            em.persist(settings);
            em.flush();
            return settings.getSettingsId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean settingsDelete(Settings settings) {
        try {
            em.remove(em.merge(settings));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean settingsUpdate(Settings settings) {
        try {

            em.merge(settings);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Settings settingsFind(String settingsId) {
        try {

            Settings settings = em.find(Settings.class, settingsId);
            return settings;
        } catch (Exception e) {
            return null;
        }
    }

//    public Settings settingFindByKey(String name) {
//        List<Settings> listOfSettings = null;
//
//        String qryString = "";
//
//        qryString = "SELECT e FROM Settings e ";
//        qryString += "WHERE e.settingKey =:name";
//
//        try {
//            listOfSettings = (List<Settings>) em.createQuery(qryString).setParameter("name", name).getResultList();
//
//            return listOfSettings.get(0);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public List<Settings> settingsFindByAttribute(String settingsAttribute, Object attributeValue, String fieldType) {
        List<Settings> listOfSettings = null;

        String qryString = "";

        qryString = "SELECT e FROM Settings e ";
        qryString += "WHERE e." + settingsAttribute + " =:settingsAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfSettings = (List<Settings>) em.createQuery(qryString).setParameter("settingsAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfSettings = (List<Settings>) em.createQuery(qryString).setParameter("settingsAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfSettings = (List<Settings>) em.createQuery(qryString).setParameter("settingsAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfSettings;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Settings> settingGetAll() {
        List<Settings> listOfSettings = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Settings e WHERE e.settingView='1' ";

            listOfSettings = (List<Settings>) em.createQuery(qryString).getResultList();

            return listOfSettings;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" ContentResources Persistence Functionalities">
    public Integer contentResourcesCreate(ContentResource contentResource) {
        try {
            em.persist(contentResource);
            em.flush();
            return contentResource.getResourceid();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean contentResourceDelete(ContentResource contentResource) {
        try {
            em.remove(em.merge(contentResource));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean contentResourceUpdate(ContentResource contentResource) {
        try {
            em.merge(contentResource);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public ContentResource contentResourceFind(String resourcesId) {
        try {

            ContentResource contentResource = em.find(ContentResource.class, resourcesId);
            return contentResource;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean contentResourcesDeletebyid(int resourcesId) {
        try {
            String qryString = "";

            qryString = "Select e FROM ContentResource e ";
            qryString += "WHERE e.resourceid ='" + resourcesId + "'";

            ContentResource contentResource = (ContentResource) em.createQuery(qryString).getSingleResult();
            em.remove(contentResource);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<ContentResource> contentResourceFindByAttribute(String contentResourceAttribute, Object attributeValue, String fieldType) {
        List<ContentResource> listOfContentResource = null;

        String qryString = "";

        qryString = "SELECT e FROM Resources e ";
        qryString += "WHERE e." + contentResourceAttribute + " =:resourcesAttribute  ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfContentResource = (List<ContentResource>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfContentResource = (List<ContentResource>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfContentResource = (List<ContentResource>) em.createQuery(qryString).setParameter("resourcesAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfContentResource;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object contentResourceId(String firstAttribute, String contentid, int content_id) {
        try {

            String qryString = "";

            qryString = "SELECT e." + firstAttribute + " FROM ContentResource e ";
            qryString += "WHERE e." + contentid + " ='" + content_id + "'";
            Object resourceId = "";
            try {
                resourceId = em.createQuery(qryString).getSingleResult();
                return resourceId;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public List<ContentResource> contentResourceGetAll() {
        List<ContentResource> listOfContentResource = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM Resources e ORDER BY e.resourceid DESC";

            listOfContentResource = (List<ContentResource>) em.createQuery(qryString).getResultList();

            return listOfContentResource;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" UserComment Persistence Functionalities">
    public String userCommentCreate(UserComment userComment) {
        try {
            em.persist(userComment);
            em.flush();
            System.out.println("comment id" + userComment.getUserId());
            return userComment.getUserCommentId();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public boolean userCommentDelete(UserComment userComment) {
        try {
            em.remove(em.merge(userComment));
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean userCommentUpdate(UserComment userComment) {
        try {
            em.merge(userComment);
            em.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public UserComment userCommentFind(String userCommentId) {
        try {

            UserComment userComment = em.find(UserComment.class, userCommentId);
            return userComment;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean userCommentDeletebyid(int userCommentId) {
        try {
            String qryString = "";

            qryString = "Select e FROM UserComment e ";
            qryString += "WHERE e.userCommentId ='" + userCommentId + "'";

            UserComment userComment = (UserComment) em.createQuery(qryString).getSingleResult();
            em.remove(userComment);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<UserComment> userCommentFindByAttribute(String userCommentAttribute, Object attributeValue, String fieldType) {
        List<UserComment> listOfUserComment = null;

        String qryString = "";

        qryString = "SELECT e FROM UserComment e ";
        qryString += "WHERE e." + userCommentAttribute + " =:resourcesAttribute ";

        try {
            if (fieldType.equalsIgnoreCase("NUMBER")) {
                listOfUserComment = (List<UserComment>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("STRING")) {
                listOfUserComment = (List<UserComment>) em.createQuery(qryString).setParameter("resourcesAttribute", attributeValue).getResultList();
            } else if (fieldType.equalsIgnoreCase("DATE")) {
                listOfUserComment = (List<UserComment>) em.createQuery(qryString).setParameter("resourcesAttribute", (Date) attributeValue, TemporalType.DATE).getResultList();
            }

            return listOfUserComment;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object userCommentId(String firstAttribute, String contentid, int userCommentId) {
        try {

            String qryString = "";

            qryString = "SELECT e." + firstAttribute + " FROM UserComment e ";
            qryString += "WHERE e." + userCommentId + " ='" + userCommentId + "'";
            Object commentId = "";
            try {
                commentId = em.createQuery(qryString).getSingleResult();
                return commentId;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public List<UserComment> userCommentGetAll() {
        List<UserComment> listOfUserComment = null;

        String qryString = "";

        try {
            qryString = "SELECT e FROM UserComment e ORDER BY e.userCommentId DESC";

            listOfUserComment = (List<UserComment>) em.createQuery(qryString).getResultList();

            return listOfUserComment;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // </editor-fold>
    public EntityManager getEntityInstance() {
        return em;
    }

    public Content customerMaterialGroupFind(Integer customerMaterialGroupId) {
        try {
            String qryString = "select * from content where content_id =5010";
            return (Content) em.createNativeQuery(qryString, Content.class).getResultList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public Object settingFindByKey(String qryString) {
        try {
            return (Object) em.createNativeQuery(qryString, Settings.class).getSingleResult();
        } catch (Exception e) {
        }
        return null;
    }

    public ResultSet processQuery(String sqlQuery) throws SQLException {
        conn = (Connection) em.unwrap(java.sql.Connection.class);
        st = null;
        rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            conn.close();
            return rs;

        } catch (SQLException sqlEx) {
            return null;
        }
    }

    public ResultSet updateQuery(String sqlQuery) throws SQLException {
        Connection conn = (Connection) em.unwrap(java.sql.Connection.class);
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sqlQuery);

            conn.close();
        } catch (SQLException sqlEx) {
        }
        return rs;
    }

    public void processSQLStatement(String sqlQuery) throws SQLException {
        Connection conn = (Connection) em.unwrap(java.sql.Connection.class);
        Statement st = null;
        try {
            st = conn.createStatement();
            st.execute(sqlQuery);
            conn.close();
        } catch (SQLException sqlEx) {
        }

    }

    public ResultSet processSQLStatementReturnGeneratedKey(String sqlQuery) throws SQLException {
        Connection conn = (Connection) em.unwrap(java.sql.Connection.class);
        Statement st = null;
        try {
            st = conn.createStatement();

            conn.close();
            return st.getGeneratedKeys();

        } catch (SQLException sqlEx) {
        }
        return null;
    }

}
