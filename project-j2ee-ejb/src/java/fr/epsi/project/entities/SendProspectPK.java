/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.project.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mathieu
 */
@Embeddable
public class SendProspectPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmail")
    private int idEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProspect")
    private int idProspect;

    public SendProspectPK() {
    }

    public SendProspectPK(int idEmail, int idProspect) {
        this.idEmail = idEmail;
        this.idProspect = idProspect;
    }

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public int getIdProspect() {
        return idProspect;
    }

    public void setIdProspect(int idProspect) {
        this.idProspect = idProspect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmail;
        hash += (int) idProspect;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SendProspectPK)) {
            return false;
        }
        SendProspectPK other = (SendProspectPK) object;
        if (this.idEmail != other.idEmail) {
            return false;
        }
        if (this.idProspect != other.idProspect) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.epsi.project.entities.SendProspectPK[ idEmail=" + idEmail + ", idProspect=" + idProspect + " ]";
    }
    
}
