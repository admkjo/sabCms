<%-- 
    Document   : contact
    Created on : Jun 7, 2015, 8:23:44 AM
    Author     : Tony
--%>

<%@page import="com.sabonay.cms.web.controller.CommonQuery"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.sabonay.ejb.common.CMSDataSource"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.UUID"%>
<%@page import="com.sabonay.ejb.entities.Page"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CommonQuery commonQuery = new CommonQuery();
            Connection con = null;
            Page p = new Page();
            String name = request.getParameter("name");
            String content_id = request.getParameter("content_id");
            int ans = Integer.parseInt(request.getParameter("ans"));
            String coment_id = request.getParameter("coment_id");
            String commenttitle = request.getParameter("commenttitle");
            String commentmessage = request.getParameter("commentmessage");
            String url = "jdbc:mysql://localhost:3306/" + commonQuery.getApplicationSettings(21,1);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            String queryText = "insert into user_comment "
                    + "(user_comment_id,user_id, comment_title,"
                    + " user_comment_message,comment_date, "
                    + " content_id,  user_comment_response, "
                    + " is_publish)"
                    + "values('" + UUID.randomUUID().toString().substring(0, 9) + "','" + name + "'  ,'" + commenttitle + "'  ,'" + commentmessage + "' "
                    + " ,'" + sdf.format(date) + "','" + content_id + "', '', 'YES' )";

            try {
                if (ans == commonQuery.getPube()) {

//              ResultSet rs = CMSDataSource.dataSource().processQuery(queryText);
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    con = DriverManager.getConnection(url, "sabonay", "qdeerq$2012");

                    Statement stat = con.createStatement();
//
                    stat.executeUpdate(queryText);
                      response.sendRedirect(coment_id);
                } else {

                    System.out.println("Not Sent");

                    response.sendRedirect(coment_id);

                }

            } catch (Exception e) {

                e.printStackTrace();
            }
 
        %>

    </body>
</html>
