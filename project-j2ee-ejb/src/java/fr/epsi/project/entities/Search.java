/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mathieu
 */
@Entity
@Table(name = "Search")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Search.findAll", query = "SELECT s FROM Search s"),
    @NamedQuery(name = "Search.findById", query = "SELECT s FROM Search s WHERE s.id = :id"),
    @NamedQuery(name = "Search.findByDeep", query = "SELECT s FROM Search s WHERE s.deep = :deep"),
    @NamedQuery(name = "Search.findByDCreate", query = "SELECT s FROM Search s WHERE s.dCreate = :dCreate"),
    @NamedQuery(name = "Search.findByDUpdate", query = "SELECT s FROM Search s WHERE s.dUpdate = :dUpdate")})
public class Search implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deep")
    private int deep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dUpdate;
    @JoinTable(name = "UserSearch", joinColumns = {
        @JoinColumn(name = "idSearch", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idUser", referencedColumnName = "id")})
    @ManyToMany
    private List<User> userList;
    @JoinTable(name = "SearchWebsite", joinColumns = {
        @JoinColumn(name = "idSearch", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idWebsite", referencedColumnName = "id")})
    @ManyToMany
    private List<Website> websiteList;
    @ManyToMany(mappedBy = "searchList")
    private List<Keyword> keywordList;

    public Search() {
    }

    public Search(Integer id) {
        this.id = id;
    }

    public Search(Integer id, int deep, Date dCreate, Date dUpdate) {
        this.id = id;
        this.deep = deep;
        this.dCreate = dCreate;
        this.dUpdate = dUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public Date getDCreate() {
        return dCreate;
    }

    public void setDCreate(Date dCreate) {
        this.dCreate = dCreate;
    }

    public Date getDUpdate() {
        return dUpdate;
    }

    public void setDUpdate(Date dUpdate) {
        this.dUpdate = dUpdate;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Website> getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(List<Website> websiteList) {
        this.websiteList = websiteList;
    }

    @XmlTransient
    public List<Keyword> getKeywordList() {
        return keywordList;
    }

    public void setKeywordList(List<Keyword> keywordList) {
        this.keywordList = keywordList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Search)) {
            return false;
        }
        Search other = (Search) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.Search[ id=" + id + " ]";
    }
    
}
