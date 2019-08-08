/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities.generated;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;   
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tony
 */
@Entity
@Table(name = "user_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserComment.findAll", query = "SELECT u FROM UserComment u"),
    @NamedQuery(name = "UserComment.findByUserCommentId", query = "SELECT u FROM UserComment u WHERE u.userCommentId = :userCommentId"),
    @NamedQuery(name = "UserComment.findByUserId", query = "SELECT u FROM UserComment u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserComment.findByCommentDate", query = "SELECT u FROM UserComment u WHERE u.commentDate = :commentDate"),
    @NamedQuery(name = "UserComment.findByContentId", query = "SELECT u FROM UserComment u WHERE u.contentId = :contentId"),
    @NamedQuery(name = "UserComment.findByUserCommentResponse", query = "SELECT u FROM UserComment u WHERE u.userCommentResponse = :userCommentResponse"),
    @NamedQuery(name = "UserComment.findByIsPublish", query = "SELECT u FROM UserComment u WHERE u.isPublish = :isPublish"),
    @NamedQuery(name = "UserComment.findBySiteId", query = "SELECT u FROM UserComment u WHERE u.siteId = :siteId")})
public class UserComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "user_comment_id")
    private String userCommentId;
    @Size(max = 255)
    @Column(name = "user_id")
    private String userId;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment_title")
    private String commentTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_comment_message")
    private String userCommentMessage;
    @Column(name = "comment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    @Column(name = "content_id")
    private Integer contentId;
    @Size(max = 255)
    @Column(name = "user_comment_response")
    private String userCommentResponse;
    @Size(max = 4)
    @Column(name = "is_publish")
    private String isPublish;
    @Size(max = 10)
    @Column(name = "site_id")
    private String siteId;

    public UserComment() {
    }

    public UserComment(String userCommentId) {
        this.userCommentId = userCommentId;
    }

    public String getUserCommentId() {
        return userCommentId;
    }

    public void setUserCommentId(String userCommentId) {
        this.userCommentId = userCommentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getUserCommentMessage() {
        return userCommentMessage;
    }

    public void setUserCommentMessage(String userCommentMessage) {
        this.userCommentMessage = userCommentMessage;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getUserCommentResponse() {
        return userCommentResponse;
    }

    public void setUserCommentResponse(String userCommentResponse) {
        this.userCommentResponse = userCommentResponse;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userCommentId != null ? userCommentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserComment)) {
            return false;
        }
        UserComment other = (UserComment) object;
        if ((this.userCommentId == null && other.userCommentId != null) || (this.userCommentId != null && !this.userCommentId.equals(other.userCommentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.UserComment[ userCommentId=" + userCommentId + " ]";
    }
    
}
