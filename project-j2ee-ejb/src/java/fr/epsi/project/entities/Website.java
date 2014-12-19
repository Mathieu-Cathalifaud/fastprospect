/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mathieu
 */
@Entity
@Table(name = "Website")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Website.findAll", query = "SELECT w FROM Website w"),
    @NamedQuery(name = "Website.findById", query = "SELECT w FROM Website w WHERE w.id = :id"),
    @NamedQuery(name = "Website.findByUrl", query = "SELECT w FROM Website w WHERE w.url = :url"),
    @NamedQuery(name = "Website.findByIp", query = "SELECT w FROM Website w WHERE w.ip = :ip"),
    @NamedQuery(name = "Website.findByDCreate", query = "SELECT w FROM Website w WHERE w.dCreate = :dCreate"),
    @NamedQuery(name = "Website.findByDUpdate", query = "SELECT w FROM Website w WHERE w.dUpdate = :dUpdate")})
public class Website implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ip")
    private String ip;
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
    @ManyToMany(mappedBy = "websiteCollection")
    private Collection<Prospect> prospectCollection;
    @ManyToMany(mappedBy = "websiteCollection")
    private Collection<Search> searchCollection;

    public Website() {
    }

    public Website(Integer id) {
        this.id = id;
    }

    public Website(Integer id, String url, String ip, Date dCreate, Date dUpdate) {
        this.id = id;
        this.url = url;
        this.ip = ip;
        this.dCreate = dCreate;
        this.dUpdate = dUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
    public Collection<Prospect> getProspectCollection() {
        return prospectCollection;
    }

    public void setProspectCollection(Collection<Prospect> prospectCollection) {
        this.prospectCollection = prospectCollection;
    }

    @XmlTransient
    public Collection<Search> getSearchCollection() {
        return searchCollection;
    }

    public void setSearchCollection(Collection<Search> searchCollection) {
        this.searchCollection = searchCollection;
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
        if (!(object instanceof Website)) {
            return false;
        }
        Website other = (Website) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.Website[ id=" + id + " ]";
    }
    
}
