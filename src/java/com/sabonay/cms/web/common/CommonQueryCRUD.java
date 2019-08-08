/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.common;

import com.sabonay.ejb.common.CMSDataSource;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author emma
 */
public class CommonQueryCRUD {

    //ELContext elContext = FacesContext.getCurrentInstance().getELContext();
    //private final CommonQuery commonquery;

    //@Inject CommonQuery commonQuery;
    
    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2; // 2MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024; // 1MB
    String sqlStatement = ""; 
    static Integer contentWithResourceId = null; //Will be set if the content we are adding has image to be added
    static Map<String, String> ppRequest = new HashMap<>();
    static String[] filenames = {"", "images", "audio", "video", "text", "zip", "docs", "forms", "others"};
    private static final String serverRootResourcePath = ApplicationConstant.SERVER_ROOT_PATH + File.separator + ApplicationConstant.RESOURCE_DIRECTORY;
 
    public static void processPageCRUD(HttpServletRequest request) throws SQLException {
        System.out.println("About processing CRUD..." + request.getAuthType());
        try { 
            ppRequest = new HashMap<>(); 
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            System.out.println("items..." + items);
            for(FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldname = item.getFieldName();
                    String fieldvalue = item.getString();
                    
                    System.out.println("fieldname=" + fieldname + "  ::  fieldvalue=" + fieldvalue);
                    ppRequest.put(fieldname, fieldvalue);
                } else {
                    System.out.println("Picture form....");
                    try {
                        // Process form file field (input type="file").
//                        String fieldname = item.getFieldName();
                        String contenttype = item.getContentType();
                        String filename = FilenameUtils.getName(item.getName());
                        
                        String plusloc = ""; 
                        int filetype = 0;
                        int f = 0;
                        int lastResource = CommonUtils.getLastResource();
                        lastResource += 1;
                        String dirname = ppRequest.get("dirname");
                        
                        if (dirname.length() > 0) {
                            if (new File(serverRootResourcePath + "/images/" + dirname).isDirectory()) {
                                plusloc = dirname + "/";
                            } else {
                                new File(serverRootResourcePath + "/images/" + dirname).mkdir();
                                plusloc = dirname + "/";
                            }
                        }
                        
                        if ("image/gif".equals(contenttype) || "image/png".equals(contenttype) || "image/jpeg".equals(contenttype) || "image/pjpeg".equals(contenttype)) {
                            filetype = IMAGES;
                            f = 1;
                        } else if ("application/pdf".equals(contenttype) || "application/msword".equals(contenttype) || (contenttype.startsWith("vnd.openxmlformats") && CommonUtils.strripos(contenttype, "vnd.openxmlformats-officedocument") > 0)) {
                            filetype = DOC;
                            f = 6;
                        } else if ("application/zip".equals(contenttype)) {
                            filetype = ZIP;
                            f = 5;
                        } else if ("application/x-shockwave-flash".equals(contenttype)) {
                            filetype = VIDEO;
                            f = 3;
                        } else if ("audio/mpeg".equals(contenttype)) {
                            filetype = AUDIO;
                            f = 2;
                        } else if ("text/plain".equals(contenttype)) {
                            filetype = PLAIN_TEXT;
                            f = 6;
                        } else if ("text/html".equals(contenttype) || "application/xhtml+xml".equals(contenttype)) {
                            filetype = INCLUDED_PAGE;
                            f = 7;
                        } else {
                            filetype = INCLUDED_PAGE;
                            f = 8;
                        }
                        
                        String destination = "";
                        
                        String fileNameOnly = CommonUtils.urlFriendly(filename.substring(0, filename.indexOf('.')), "_");
                        String fileExtension = filename.substring(filename.indexOf('.'));
                        String filenm = fileNameOnly + fileExtension;
                        
                        String img = filenames[f] + "/" + plusloc + lastResource + "_" + filenm;
                        
                        if ("images".equals(filenames[f])) {
//                            destination = "resources/" + filenames[f] + "/" + plusloc + lastResource + "_" + filenm;
                            destination = filenames[f] + File.separator + plusloc + File.separator + lastResource + "_" + filenm;
                        } else {
//                            destination = "resources/" + filenames[f] + "/" + lastResource + "_" + filenm;
                            destination = filenames[f] + File.separator + lastResource + "_" + filenm;
                        }
                        
                        // Create a factory for disk-based file items
                        DiskFileItemFactory factory = new DiskFileItemFactory();
                        
                        // Sets the size threshold beyond which files are written directly to disk.
                        factory.setSizeThreshold(MAX_MEMORY_SIZE);
                        
                        // Sets the directory used to temporarily store files that are larger
                        // than the configured size threshold. We use temporary directory for java
                        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
                        
                        // constructs the folder where uploaded file will be stored
                        String uploadFolder = serverRootResourcePath + File.separator + destination;
                        
                        // Create a new file upload handler
                        ServletFileUpload upload = new ServletFileUpload(factory);
                        
                        // Set overall request size constraint
                        upload.setSizeMax(MAX_REQUEST_SIZE);
                        
                        //Upload Files
                        String filePath = uploadFolder;
                        File uploadedFile = new File(filePath);
                        item.write(uploadedFile);
                        
                        //Add Entry to Database (Resources and ContentResources)
                        contentWithResourceId = resourcesAdd(String.valueOf(filetype), img, "");
                        
                    } catch (Exception ex) {
                        System.out.println("This error is nothing to think about: " + ex);
                    }
                }
            }
        } catch (FileUploadException e) {
            //return;
            System.out.println("Cannot parse multipart request...." + e);
            return;
        }

        //Update Category
        if (allowSQLProcess(ppRequest.get("MM_update"), ApplicationConstant.FORM_CATEGORY_UPDATE)) {
            categoryUpdate(ppRequest.get("categoryname"),
                    ppRequest.get("ispublished"),
                    ppRequest.get("categoryicon"),
                    ppRequest.get("description"),
                    ppRequest.get("listtype"),
                    ppRequest.get("parentid"),
                    ppRequest.get("allowcomment"),
                    ppRequest.get("rss"),
                    ppRequest.get("categoryid"));

            return;
        }

        //Add Category
        if (allowSQLProcess(ppRequest.get("MM_insert"), ApplicationConstant.FORM_CATEGORY_ADD)) {
            categoryAdd(ppRequest.get("categoryname"),
                    ppRequest.get("ispublished"),
                    ppRequest.get("categoryicon"),
                    ppRequest.get("description"),
                    ppRequest.get("listtype"),
                    ppRequest.get("parentid"),
                    ppRequest.get("allowcomment"));

            return;
        }

        //Update Content
        if (allowSQLProcess(ppRequest.get("MM_update"), ApplicationConstant.FORM_CONTENT_UPDATE)) {
            String dir = "";
            if (CommonUtils.isset(ppRequest.get("isDirect")) && ppRequest.get("directlink").length() > 10) {
                dir = ppRequest.get("directlink");
            }
            contentUpdate(ppRequest.get("listtype"),
                    ppRequest.get("keywords"),
                    ppRequest.get("ptitle"),
                    ppRequest.get("pcontent"),
                    ppRequest.get("pbanner"),
                    ppRequest.get("ispublished"),
                    ppRequest.get("categoryid"),
                    dir,
                    ppRequest.get("lastmodified") + " " + ppRequest.get("tendH") + ":" + ppRequest.get("tendM") + ":00",
                    ppRequest.get("datecreated") + " " + ppRequest.get("tstartH") + ":" + ppRequest.get("tstartM") + ":00",
                    ppRequest.get("source"),
                    ppRequest.get("contentid"));

            return;
        }

        //Add Page to Content
        //keywords=435345&ptitle=yuyouiouiou&source=ds&pcontent=sdfsdfsd+fsd+fsd+f<br>&ispublished=yes&listtype=0&categoryid=05231&dirname=&file1=DSCF0287.JPG&pdesc1=How&file2=DSCF0307+-+Copy+-+Copy.JPG&pdesc2=Are&file3=&pdesc3=&file4=&pdesc4=&uploadnum=4&imge=&addimgs=&MM_insert=frmContentAdd
        if (allowSQLProcess(ppRequest.get("MM_insert"), ApplicationConstant.FORM_CONTENT_ADD)) {
            //enctype="multipart/form-data"
            contentAdd(ppRequest.get("listtype"),
                    ppRequest.get("keywords"),
                    ppRequest.get("ptitle"),
                    ppRequest.get("pcontent"),
                    ppRequest.get("pbanner"),
                    ppRequest.get("ispublished"),
                    ppRequest.get("categoryid"),
                    ppRequest.get("lastmodified") + " " + ppRequest.get("tendH") + ":" + ppRequest.get("tendM") + ":00",
                    ppRequest.get("datecreated") + " " + ppRequest.get("tstartH") + ":" + ppRequest.get("tstartM") + ":00",
                    ppRequest.get("source"),
                    ppRequest.get("contentid"));

            return;
        }

        //Update Resource
        if (allowSQLProcess(ppRequest.get("MM_update"), ApplicationConstant.FORM_RESOURCE_UPDATE)) {
            resourcesUpdate(ppRequest.get("resourcedesc"),
                    ppRequest.get("ispublished"),
                    ppRequest.get("source"),
                    ppRequest.get("otherattri"),
                    ppRequest.get("resourceid"));

            return;
        }

        //Approve and Delete Buttons
        if (CommonUtils.isset(ppRequest.get("frmCont"))) {
            String deltab = ppRequest.get("frmCont");
            String prefix = ppRequest.get("chkprefix");
            String action = ppRequest.get("frmaction");

            String query = "";

            if (null != deltab)//            System.out.println("deltab..." + deltab);
//            System.out.println("deltab..." + deltab);
//            System.out.println("prefix..." + prefix);
//            System.out.println("action..." + action);
            switch (deltab) {
                case "category":
                    for (Map.Entry<String, String> entry : ppRequest.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        
                        if (prefix.equals(key.substring(0, prefix.length()))) {
                            if (null != action) switch (action) {
                                case "delete":
                                    query = "DELETE FROM category WHERE category_id='" + value + "' or parent_id='" + value + "'";
                                    CMSDataSource.dataSource().processSQLStatement(query);
                                    query = "DELETE FROM content WHERE categoryid='" + value + "'";
                                    CMSDataSource.dataSource().processSQLStatement(query);
                                    break;
                                case "approve":
                                    query = "UPDATE category SET is_published='yes' WHERE category_id='" + value + "'";
                                    CMSDataSource.dataSource().processSQLStatement(query);
                                    break;
                            }
                        }
                        
//                    System.out.println("key..." + key);
//                    System.out.println("value..." + value);
                    }   break;
                case "content":
                    for (Map.Entry<String, String> entry : ppRequest.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        
                        if (prefix.equals(key.substring(0, prefix.length()))) {
                            if ("delete".equals(action)) {
                                query = "DELETE FROM content WHERE content_id='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                                
                                query = "DELETE FROM category WHERE category_id='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                                
                                query = "DELETE FROM content WHERE categoryid='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                                
                                query = "DELETE FROM content_resource WHERE contentid='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                            } else if ("approve".equals(action)) {
                                query = "UPDATE content SET is_published='yes' WHERE content_id='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                            }
                        }
                    }   break;
                case "resource":
                    for (Map.Entry<String, String> entry : ppRequest.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        
                        if (prefix.equals(key.substring(0, prefix.length()))) {
                            if ("delete".equals(action)) {
                                //String resourceurl = (new CommonQueryCRUD()).commonQuery.getResourceUrl(value);
                                
                                query = "DELETE FROM resources WHERE resourceid='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                                
                                query = "DELETE FROM content_resource WHERE resourceid='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                                
                                //Unlink - PHP (Meaning Delete File from Disk)
                                //File file = new File(serverRootResourcePath + File.separator + resourceurl);
                                //file.delete();
                            } else if ("approve".equals(action)) {
                                query = "UPDATE resources SET ispublished='yes' WHERE resourceid='" + value + "'";
                                CMSDataSource.dataSource().processSQLStatement(query);
                            }
                        }
                    }   break;
            }
        }
    }

    private static String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("file")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }

    private static boolean allowSQLProcess(String param, String form) {
        if (CommonUtils.isset(param) && form.equals(param)) {
            return true;
        }

        return false;
    }

    private static void categoryAdd(String categoryName, String ispublished, String categoryIcon, String description, String listType, String parentId, String allowComment) throws SQLException {
        System.out.println("CATEGORY ADD...");
        String sql = String.format("INSERT INTO category (category_name, is_published, category_icon,description,list_type, allow_comment,parent_id) VALUES (%s, %s, %s,%s, %s,%s,%s)",
                CommonUtils.GetSQLValueString(categoryName, TEXT),
                CommonUtils.GetSQLValueString(ispublished, TEXT),
                CommonUtils.GetSQLValueString(categoryIcon, INT),
                CommonUtils.GetSQLValueString(description, TEXT),
                CommonUtils.GetSQLValueString(listType, INT),
                CommonUtils.GetSQLValueString(allowComment, TEXT),
                CommonUtils.GetSQLValueString(parentId, INT));

        ResultSet rs = CMSDataSource.dataSource().processSQLStatementReturnGeneratedKey(sql);

        int lastInsert = -1;

        if (rs.next()) {
            lastInsert = rs.getInt(1);
        }

        String ctype = "cat";
        String dir = "";

        if (ppRequest.get("directlink").length() > 10) {
            dir = ppRequest.get("directlink");
        }

        //categoryname=Effect+of+Internet+on+Modern+Education&ispublished=yes&listtype=19&directlink=http%3A%2F%2F&description=Effect+of+Internet+on+Modern+Education&pcontent=Effect+of+Internet+on+Modern+Education&parentid=222&allowcomment=yes&MM_insert=frmcatadd
        sql = String.format("INSERT INTO content (ptitle, pcontent, ispublished,categoryid, datecreated,source,directlink,cattype) VALUES (%s, %s,%s, %s, %s,%s,%s,%s)",
                CommonUtils.GetSQLValueString(categoryName, TEXT),
                CommonUtils.GetSQLValueString(CommonUtils.stripUslessCharacters(ppRequest.get("pcontent")), TEXT),
                CommonUtils.GetSQLValueString(ispublished, TEXT),
                CommonUtils.GetSQLValueString(lastInsert, INT),
                CommonUtils.GetSQLValueString((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()), TEXT),
                CommonUtils.GetSQLValueString(ppRequest.get("source"), TEXT),
                CommonUtils.GetSQLValueString(dir, TEXT),
                CommonUtils.GetSQLValueString(ctype, TEXT));

        CMSDataSource.dataSource().processSQLStatement(sql);
    }

    private static void categoryUpdate(String categoryName, String ispublished, String categoryIcon, String description, String listType, String parentId, String allowComment, String rss, String categoryId) throws SQLException {
        String sql = String.format("UPDATE category SET category_name=%s, is_published=%s, category_icon=%s,description=%s, list_type=%s, parent_id=%s , allow_comment =%s ,is_rss=%s  WHERE category_id=%s",
                CommonUtils.GetSQLValueString(categoryName, TEXT),
                CommonUtils.GetSQLValueString(ispublished, TEXT),
                CommonUtils.GetSQLValueString(categoryIcon, INT),
                CommonUtils.GetSQLValueString(description, TEXT),
                CommonUtils.GetSQLValueString(listType, INT),
                CommonUtils.GetSQLValueString(parentId, INT),
                CommonUtils.GetSQLValueString(allowComment, TEXT),
                CommonUtils.GetSQLValueString(rss, TEXT),
                CommonUtils.GetSQLValueString(categoryId, INT)); 

        CMSDataSource.dataSource().processSQLStatement(sql);
    }

    private static void contentUpdate(String listtype, String keywords, String ptitle, String pcontent, String pbanner, String ispublished, String categoryid, String dir, String lastmodified, String datecreated, String source, String contentid) throws SQLException {
        if (CommonUtils.isset(listtype) && (2 == Integer.parseInt(listtype) || 3 == Integer.parseInt(listtype))) {

            String sql = String.format("UPDATE content SET keywords=%s, ptitle=%s, pcontent=%s, pbanner=%s, ispublished=%s, categoryid=%s, directlink=%s, lastmodified=%s, datecreated=%s, source=%s WHERE content_id=%s",
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(keywords), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(ptitle), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(CommonUtils.stripUslessCharacters(pcontent)), TEXT),
                    CommonUtils.GetSQLValueString(pbanner, INT),
                    CommonUtils.GetSQLValueString(ispublished, TEXT),
                    CommonUtils.GetSQLValueString(categoryid, INT),
                    CommonUtils.GetSQLValueString(dir, TEXT),
                    CommonUtils.GetSQLValueString(lastmodified, TEXT),
                    CommonUtils.GetSQLValueString(datecreated, TEXT),
                    CommonUtils.GetSQLValueString(source, TEXT),
                    CommonUtils.GetSQLValueString(contentid, INT));
            CMSDataSource.dataSource().processSQLStatement(sql);
        } else {
            String sql = String.format("UPDATE content SET keywords=%s, ptitle=%s, pcontent=%s, pbanner=%s, ispublished=%s, categoryid=%s, directlink=%s, lastmodified=%s, source=%s WHERE content_id=%s",
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(keywords), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(ptitle), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(CommonUtils.stripUslessCharacters(pcontent)), TEXT),
                    CommonUtils.GetSQLValueString(pbanner, INT),
                    CommonUtils.GetSQLValueString(ispublished, TEXT),
                    CommonUtils.GetSQLValueString(categoryid, INT),
                    CommonUtils.GetSQLValueString(dir, TEXT),
                    CommonUtils.GetSQLValueString((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()), TEXT),
                    CommonUtils.GetSQLValueString(source, TEXT),
                    CommonUtils.GetSQLValueString(contentid, INT));
            CMSDataSource.dataSource().processSQLStatement(sql);
        }
        
        if (null != contentWithResourceId) {
            //Add Entry to Content Resource 
            
            ResultSet r = CMSDataSource.dataSource().processQuery("Select * from content_resource WHERE contentid = " + ppRequest.get("contentid") + " AND resourceid=" + contentWithResourceId);
            if (r.next()) {}
            else{
                String sql = String.format("INSERT INTO content_resource (contentid,resourceid,resourceorder) values (%s ,%s,%s)",
                        ppRequest.get("contentid") , contentWithResourceId, 2);
                CMSDataSource.dataSource().processSQLStatement(sql);
            }
        }

    }

    private static void contentAdd(String listtype, String keywords, String ptitle, String pcontent, String pbanner, String ispublished, String categoryid, String lastmodified, String datecreated, String source, String contentid) throws SQLException {
        System.out.println("CONTENT ADD...");
        int contentId = 0;
        if (CommonUtils.isset(listtype) && (2 == Integer.parseInt(listtype) || 3 == Integer.parseInt(listtype))) {
            System.out.println("About adding content...");
            //autoUnpublishLastNews();
            String sql = String.format("INSERT INTO content (keywords, ptitle, pcontent, pbanner, ispublished, categoryid, lastmodified, datecreated, cattype, source) VALUES (%s, %s, %s, %s, %s,  %s,%s,%s,'page',%s);",
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(keywords), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(ptitle), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(CommonUtils.stripUslessCharacters(pcontent)), TEXT),
                    CommonUtils.GetSQLValueString(pbanner, INT),
                    CommonUtils.GetSQLValueString(ispublished, TEXT),
                    CommonUtils.GetSQLValueString(categoryid, INT),
                    CommonUtils.GetSQLValueString(lastmodified, TEXT),
                    CommonUtils.GetSQLValueString(datecreated, TEXT),
                    CommonUtils.GetSQLValueString(source, TEXT),
                    CommonUtils.GetSQLValueString(contentid, INT));
            ResultSet r = CMSDataSource.dataSource().processSQLStatementReturnGeneratedKey(sql);
            if (r.next()){contentId = r.getInt(1);}
            
        } else {
            String sql = String.format("INSERT INTO content (keywords, ptitle, pcontent, pbanner, ispublished, categoryid, lastmodified, datecreated, cattype, source) VALUES (%s, %s, %s, %s, %s,  %s,now(),now(),'page',%s);",
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(keywords), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(ptitle), TEXT),
                    CommonUtils.GetSQLValueString(StringEscapeUtils.escapeSql(CommonUtils.stripUslessCharacters(pcontent)), TEXT),
                    CommonUtils.GetSQLValueString(pbanner, INT),
                    CommonUtils.GetSQLValueString(ispublished, TEXT),
                    CommonUtils.GetSQLValueString(categoryid, INT),
                    CommonUtils.GetSQLValueString(lastmodified, TEXT),
                    CommonUtils.GetSQLValueString(datecreated, TEXT),
                    CommonUtils.GetSQLValueString(source, TEXT),
                    CommonUtils.GetSQLValueString(contentid, INT));
            ResultSet r = CMSDataSource.dataSource().processSQLStatementReturnGeneratedKey(sql);
            if (r.next()){contentId = r.getInt(1);}
        }

        if (null != contentWithResourceId) {
            //Add Entry to Content Resource 
            String sql = String.format("INSERT INTO content_resource (contentid,resourceid,resourceorder) values (%s ,%s,%s)",
                    contentId, contentWithResourceId, 2);

            CMSDataSource.dataSource().processSQLStatement(sql);
        }
    }
    
    private static void autoUnpublishLastNews() throws SQLException{
        String catid = CommonUtils.getSettingValue(ApplicationConstant.NEWS_CATEGORY);
        System.out.println("catid..." + catid);
        String sql = "select count(*) from content where ispublished='yes' and categoryid=" + catid;
        
        ResultSet rs = CMSDataSource.dataSource().processQuery(sql);
        if (rs.next() && 20 >= rs.getInt(1)){
            
            sql = "select content_id from content where ispublished='yes' and categoryid=" + catid + " order by content_id limit 1";
            rs = CMSDataSource.dataSource().processQuery(sql);
            System.out.println("first pass");
            if (rs.next()){
                sql = "update content set ispublished='no' where content_id=" + rs.getInt(1);
                CMSDataSource.dataSource().processQuery(sql);
                
                System.out.println("Unpublished Item");
            }
        }
        
        
    }

    private static int resourcesAdd(String categoryId, String resourceURL, String resourceDesc) throws SQLException {
        String sql = String.format("INSERT INTO resources (category,resourceurl,resourcedesc) VALUES (%s, %s, %s)",
                CommonUtils.GetSQLValueString(categoryId, INT),
                CommonUtils.GetSQLValueString(resourceURL, TEXT),
                CommonUtils.GetSQLValueString(CommonUtils.stripUslessCharacters(resourceDesc), TEXT));

        ResultSet rs = CMSDataSource.dataSource().processSQLStatementReturnGeneratedKey(sql);

        int lastInsert = -1;

        if (rs.next()) {
            lastInsert = rs.getInt(1);
        }

        return lastInsert; 

    }

    private static void resourcesUpdate(String resourceDesc, String isPublished, String source, String otherattri, String resourceid) throws SQLException {
        String sql = String.format("UPDATE resources SET  resourcedesc=%s, ispublished=%s, source=%s, otherattri=%s WHERE resourceid=%s",
                CommonUtils.GetSQLValueString(resourceDesc, TEXT),
                CommonUtils.GetSQLValueString(isPublished, INT),
                CommonUtils.GetSQLValueString(source, TEXT),
                CommonUtils.GetSQLValueString(otherattri, TEXT),
                CommonUtils.GetSQLValueString(resourceid, INT));

        CMSDataSource.dataSource().processSQLStatement(sql);
    }

    private static void contentResourcesAdd() {
    }
    private static String TEXT = "text";
    private static String INT = "int";
    private static String DATE = "date";
    private static int IMAGES = 7;
    private static int AUDIO = 8;
    private static int VIDEO = 9;
    private static int DOC = 10;
    private static int ZIP = 14;
    private static int PLAIN_TEXT = 15;
    private static int EXE = 16;
    private static int OTHERS = 17;
    private static int INCLUDED_PAGE = 21;

    public static void main(String[] args) {
        new File("../resources/images/kk/").mkdir();
        System.out.println("dirname..." + new File("../resources/images/").getAbsolutePath());

        if (new File("../resources/images/").getAbsoluteFile().isDirectory()) {
            System.out.println("true");
        }
    }
}
