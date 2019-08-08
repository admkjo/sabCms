<%-- 
    Document   : contact
    Created on : Jun 7, 2015, 8:23:44 AM
    Author     : Tony
--%>
 
<%@page import="com.sabonay.cms.web.controller.CommonQuery"%>
<%@page import="com.sabonay.cms.web.controller.ContactBean"%>
<%@page import="com.sabonay.cms.web.common.SendEmail"%> 





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//";
            CommonQuery commonQuery = new CommonQuery();
            String cname = request.getParameter("cname");
            String content_id = request.getParameter("content_id");
            String cemail = request.getParameter("cemail");
            String tel = request.getParameter("tel");
            String topic = request.getParameter("topic");
            int ans = Integer.parseInt(request.getParameter("ans"));
            String comment = request.getParameter("comment");
            String emailaddr = commonQuery.getApplicationSettings(26, 1);
            try { 
                    if (ans == commonQuery.getPube()) {
                        SendEmail sending = new SendEmail();
                        sending.send(cemail, emailaddr, topic,
                                "Name of Sender : " + cname + "\n\n Telephone Number : " + tel + "\n\n Message :\n " + comment + "", null);
                        System.out.println("sent");
                        response.sendRedirect(content_id);

                    } else {

                        System.out.println("Not Sent");

                        response.sendRedirect(content_id);

                    }
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body> 
</html>
