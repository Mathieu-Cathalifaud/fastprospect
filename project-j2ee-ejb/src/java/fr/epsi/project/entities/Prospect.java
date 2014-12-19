/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mathieu
 */
@Entity
@Table(name = "Prospect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prospect.findAll", query = "SELECT p FROM Prospect p"),
    @NamedQuery(name = "Prospect.findById", query = "SELECT p FROM Prospect p WHERE p.id = :id"),
    @NamedQuery(name = "Prospect.findByEmail", query = "SELECT p FROM Prospect p WHERE p.email = :email")})
public class Prospect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "WebsiteProspect", joinColumns = {
        @JoinColumn(name = "idProspect", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idWebsite", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Website> websiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prospect")
    private Collection<SendProspect> sendProspectCollection;

    public Prospect() {
    }

    public Prospect(Integer id) {
        this.id = id;
    }

    public Prospect(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Website> getWebsiteCollection() {
        return websiteCollection;
    }

    public void setWebsiteCollection(Collection<Website> websiteCollection) {
        this.websiteCollection = websiteCollection;
    }

    @XmlTransient
    public Collection<SendProspect> getSendProspectCollection() {
        return sendProspectCollection;
    }

    public void setSendProspectCollection(Collection<SendProspect> sendProspectCollection) {
        this.sendProspectCollection = sendProspectCollection;
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
        if (!(object instanceof Prospect)) {
            return false;
        }
        Prospect other = (Prospect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.Prospect[ id=" + id + " ]";
    }
    
}
