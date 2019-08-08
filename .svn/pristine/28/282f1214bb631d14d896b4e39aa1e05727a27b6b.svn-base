/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.cms.web.controller;

import com.sabonay.cms.web.common.ApplicationConstant;
import com.sabonay.cms.web.common.CommonUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author thony
 */
@ManagedBean
@RequestScoped
public class FileUploadController implements Serializable{
//private static final long serialVersionUID = 9040359120893077422L;
           public static int f = 8;
           public static String resourceurl = "";
private ContentController contentController;
	private Part part;
	private String statusMessage;
        private String basePath = ApplicationConstant.SERVER_ROOT_PATH + File.separator + ApplicationConstant.RESOURCE_DIRECTORY + File.separator;
 
	public String uploadFile(Part part) throws IOException, SQLException {
            try {
                
          
		// Extract file name from content-disposition header of file part
		String fileName = CommonUtils.getLastResource()+getFileName(part);
             String filetype = "";
                if ("image/gif".equals(part.getContentType()) || "image/png".equals(part.getContentType()) || "image/jpeg".equals(part.getContentType()) || "image/pjpeg".equals(part.getContentType())|| "image/jpeg 2000".equals(part.getContentType())|| "image/exif".equals(part.getContentType())|| "image/tiff".equals(part.getContentType())|| "image/rif".equals(part.getContentType())|| "image/PNG".equals(part.getContentType())) {
                            filetype = "images";
                            f = 7;
                        } else if ("application/pdf".equals(part.getContentType()) ||"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(part.getContentType()) ||"application/vnd.openxmlformats-officedocument.presentationml.presentation".equals(part.getContentType())  ||"application/txt".equals(part.getContentType()) || "application/msword".equals(part.getContentType()) || (part.getContentType().startsWith("vnd.openxmlformats") && CommonUtils.strripos(part.getContentType(), "vnd.openxmlformats-officedocument") > 0)) {
                            filetype = "docs";
                            f = 10;
                        } else if ("application/zip".equals(part.getContentType()) || "application/x-gzip".equals(part.getContentType())|| "application/bzip2".equals(part.getContentType())|| "application/x-bzip2".equals(part.getContentType())) {
                            filetype = "zip";
                            f = 14;
                        } else if ("application/x-shockwave-flash".equals(part.getContentType())) {
                            filetype = "video";
                            f = 9;
                        } else if ("audio/mpeg".equals(part.getContentType())) {
                            filetype = "audio";
                            f = 8;
                        } else if ("text/plain".equals(part.getContentType())) {
                            filetype = "text";
                            f = 15;
                        } else if ("text/html".equals(part.getContentType()) || "application/xhtml+xml".equals(part.getContentType())) {
                            filetype = "forms";
                            f = 21;
                        } else {
                            filetype = "others";
                            f = 17;
                        }
		System.out.println("***** fileName: " + fileName + "ext = "+part.getContentType());
 
		 
		File outputFilePath = new File(basePath+filetype+File.separator+ fileName);
                resourceurl =filetype+"/"+ fileName;
                System.out.println("resource url" + resourceurl);
 
		// Copy uploaded file to destination path
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = part.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);
 
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
 
			statusMessage = "File upload successfull !!";
                        
		} catch (IOException e) {
			e.printStackTrace();
			statusMessage = "File upload failed !!";
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	  } catch (Exception e) {
            }
		return null;    // return to same page
        }
            
 
	public Part getPart() {
		return part;
	}
 
	public void setPart(Part part) {
		this.part = part;
	}

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
 
        
	public String getStatusMessage() {
		return statusMessage;
	}
 
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
 
	// Extract file name from content-disposition header of file part
	public static String getFileName(Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("***** partHeader: " + partHeader);
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}

