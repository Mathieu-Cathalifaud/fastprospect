/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mathieu
 */
@Entity
@Table(name = "SendProspect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SendProspect.findAll", query = "SELECT s FROM SendProspect s"),
    @NamedQuery(name = "SendProspect.findByIdEmail", query = "SELECT s FROM SendProspect s WHERE s.sendProspectPK.idEmail = :idEmail"),
    @NamedQuery(name = "SendProspect.findByIdProspect", query = "SELECT s FROM SendProspect s WHERE s.sendProspectPK.idProspect = :idProspect"),
    @NamedQuery(name = "SendProspect.findByStatus", query = "SELECT s FROM SendProspect s WHERE s.status = :status")})
public class SendProspect implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SendProspectPK sendProspectPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "idProspect", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prospect prospect;
    @JoinColumn(name = "idEmail", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Email email;

    public SendProspect() {
    }

    public SendProspect(SendProspectPK sendProspectPK) {
        this.sendProspectPK = sendProspectPK;
    }

    public SendProspect(SendProspectPK sendProspectPK, boolean status) {
        this.sendProspectPK = sendProspectPK;
        this.status = status;
    }

    public SendProspect(int idEmail, int idProspect) {
        this.sendProspectPK = new SendProspectPK(idEmail, idProspect);
    }

    public SendProspectPK getSendProspectPK() {
        return sendProspectPK;
    }

    public void setSendProspectPK(SendProspectPK sendProspectPK) {
        this.sendProspectPK = sendProspectPK;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Prospect getProspect() {
        return prospect;
    }

    public void setProspect(Prospect prospect) {
        this.prospect = prospect;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sendProspectPK != null ? sendProspectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SendProspect)) {
            return false;
        }
        SendProspect other = (SendProspect) object;
        if ((this.sendProspectPK == null && other.sendProspectPK != null) || (this.sendProspectPK != null && !this.sendProspectPK.equals(other.sendProspectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.SendProspect[ sendProspectPK=" + sendProspectPK + " ]";
    }
    
}
