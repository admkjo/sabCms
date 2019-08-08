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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adm-Kjo
 */
@Entity
@Table(name = "related_pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelatedPages.findAll", query = "SELECT r FROM RelatedPages r"),
    @NamedQuery(name = "RelatedPages.findByPrimaryPage", query = "SELECT r FROM RelatedPages r WHERE r.primaryPage = :primaryPage"),
    @NamedQuery(name = "RelatedPages.findBySecondaryPage", query = "SELECT r FROM RelatedPages r WHERE r.secondaryPage = :secondaryPage")})
public class RelatedPages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "primary_page")
    private Integer primaryPage;
    @Column(name = "secondary_page")
    private Integer secondaryPage;

    public RelatedPages() {
    }

    public RelatedPages(Integer primaryPage) {
        this.primaryPage = primaryPage;
    }

    public Integer getPrimaryPage() {
        return primaryPage;
    }

    public void setPrimaryPage(Integer primaryPage) {
        this.primaryPage = primaryPage;
    }

    public Integer getSecondaryPage() {
        return secondaryPage;
    }

    public void setSecondaryPage(Integer secondaryPage) {
        this.secondaryPage = secondaryPage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (primaryPage != null ? primaryPage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatedPages)) {
            return false;
        }
        RelatedPages other = (RelatedPages) object;
        if ((this.primaryPage == null && other.primaryPage != null) || (this.primaryPage != null && !this.primaryPage.equals(other.primaryPage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sabonay.ejb.entities.generated.RelatedPages[ primaryPage=" + primaryPage + " ]";
    }
    
}
