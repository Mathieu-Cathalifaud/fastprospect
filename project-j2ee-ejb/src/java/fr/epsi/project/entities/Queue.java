/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mathieu
 */
@Entity
@Table(name = "Queue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Queue.findAll", query = "SELECT q FROM Queue q"),
    @NamedQuery(name = "Queue.findById", query = "SELECT q FROM Queue q WHERE q.id = :id"),
    @NamedQuery(name = "Queue.findByDCreate", query = "SELECT q FROM Queue q WHERE q.dCreate = :dCreate")})
public class Queue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "d_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dCreate;

    public Queue() {
    }

    public Queue(Integer id) {
        this.id = id;
    }

    public Queue(Integer id, Date dCreate) {
        this.id = id;
        this.dCreate = dCreate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDCreate() {
        return dCreate;
    }

    public void setDCreate(Date dCreate) {
        this.dCreate = dCreate;
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
        if (!(object instanceof Queue)) {
            return false;
        }
        Queue other = (Queue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.Queue[ id=" + id + " ]";
    }
    
}
