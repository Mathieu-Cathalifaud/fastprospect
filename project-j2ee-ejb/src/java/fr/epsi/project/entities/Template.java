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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "Template")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Template.findAll", query = "SELECT t FROM Template t"),
    @NamedQuery(name = "Template.findById", query = "SELECT t FROM Template t WHERE t.id = :id"),
    @NamedQuery(name = "Template.findByTitle", query = "SELECT t FROM Template t WHERE t.title = :title"),
    @NamedQuery(name = "Template.findByDCreate", query = "SELECT t FROM Template t WHERE t.dCreate = :dCreate"),
    @NamedQuery(name = "Template.findByDUpdate", query = "SELECT t FROM Template t WHERE t.dUpdate = :dUpdate")})
public class Template implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
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
    @ManyToMany(mappedBy = "templateList")
    private List<Email> emailList;
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Template() {
    }

    public Template(Integer id) {
        this.id = id;
    }

    public Template(Integer id, Date dCreate, Date dUpdate) {
        this.id = id;
        this.dCreate = dCreate;
        this.dUpdate = dUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Template)) {
            return false;
        }
        Template other = (Template) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.Template[ id=" + id + " ]";
    }
    
}
