/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sabonay.ejb.entities.generated;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryId", query = "SELECT c FROM Category c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Category.findByCategoryName", query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName"),
    @NamedQuery(name = "Category.findByIsPublished", query = "SELECT c FROM Category c WHERE c.isPublished = :isPublished"),
    @NamedQuery(name = "Category.findByCategoryIcon", query = "SELECT c FROM Category c WHERE c.categoryIcon = :categoryIcon"),
    @NamedQuery(name = "Category.findByParentId", query = "SELECT c FROM Category c WHERE c.parentId = :parentId"),
    @NamedQuery(name = "Category.findByListType", query = "SELECT c FROM Category c WHERE c.listType = :listType"),
    @NamedQuery(name = "Category.findByIsRss", query = "SELECT c FROM Category c WHERE c.isRss = :isRss"),
    @NamedQuery(name = "Category.findByAllowComment", query = "SELECT c FROM Category c WHERE c.allowComment = :allowComment"),
    @NamedQuery(name = "Category.findByCreatedBy", query = "SELECT c FROM Category c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "Category.findByCategoryOrder", query = "SELECT c FROM Category c WHERE c.categoryOrder = :categoryOrder")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "category_name")
    private String categoryName;
    @Size(max = 15)
    @Column(name = "is_published")
    private String isPublished;
    @Column(name = "category_icon")
    private Integer categoryIcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parent_id")
    private int parentId;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "list_type")
    private Integer listType;
    @Size(max = 4)
    @Column(name = "is_rss")
    private String isRss;
    @Size(max = 15)
    @Column(name = "allow_comment")
    private String allowComment;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "category_order")
    private Integer categoryOrder;

    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String categoryName, int parentId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished;
    }

    public Integer getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(Integer categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getIsRss() {
        return isRss;
    }

    public void setIsRss(String isRss) {
        this.isRss = isRss;
    }

    public String getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(String allowComment) {
        this.allowComment = allowComment;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.Category[ categoryId=" + categoryId + " ]";
    }
    
}
