/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sabonay.cms.web.controller;

import com.sabonay.ejb.common.CMSDataSource;
import com.sabonay.ejb.entities.Page;
import com.sabonay.ejb.entities.generated.UserComment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author thony
 */
@Named
@ViewScoped
public class CommentController implements Serializable{
Page p = new Page();
 private List<UserComment> userCommentList = new ArrayList<>();
    UserComment userComment = new UserComment();
private boolean inEditMode = true;
  private boolean formShow = false;
    /**
     * Creates a new instance of CommentController
     */
    public CommentController() {
    }

    public void saveComment() {
       
        userComment.setUserCommentId(UUID.randomUUID().toString().substring(0, 9));
        userComment.setContentId(p.getPageid());
        System.out.println("did it come here");
               userComment.setIsPublish("YES");
 userComment.setCommentDate(Calendar.getInstance().getTime());
        CMSDataSource.dataSource().userCommentCreate(userComment);
        refresh();
    }
    
    
     
    
    public void editing(){
    inEditMode = true;
//        formShow = true;
    }
     public void editComment(){System.out.println("edit mode?" + inEditMode);
         
         if (inEditMode) {
             System.out.println("about to edit");
        CMSDataSource.dataSource().userCommentUpdate(userComment);
        refresh();
         }
     
    }
     
     
     
    
     
    public void deleteComment(){
        CMSDataSource.dataSource().userCommentDelete(userComment);
    }
    
    
      
    public void refresh(){
        userComment = new UserComment();
    }

    public Page getP() {
        return p;
    }

    public void setP(Page p) {
        this.p = p;
    }

    public UserComment getUserComment() {
        return userComment;
    }

    public void setUserComment(UserComment userComment) {
        this.userComment = userComment;
    }

    public List<UserComment> getUserCommentList() {
        userCommentList = CMSDataSource.dataSource().userCommentGetAll();
        return userCommentList;
    }

    public void setUserCommentList(List<UserComment> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public boolean isFormShow() {
        return formShow;
    }

    public void setFormShow(boolean formShow) {
        this.formShow = formShow;
    }

}
