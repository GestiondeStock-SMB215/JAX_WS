/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.smb215.entities;

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
 * @author henry_kozhaya
 */
@Entity
@Table(name = "tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracking.findAll", query = "SELECT t FROM Tracking t"),
    @NamedQuery(name = "Tracking.findByTrackId", query = "SELECT t FROM Tracking t WHERE t.trackId = :trackId"),
    @NamedQuery(name = "Tracking.findByTrackTransId", query = "SELECT t FROM Tracking t WHERE t.trackTransId = :trackTransId"),
    @NamedQuery(name = "Tracking.findByTrackShipId", query = "SELECT t FROM Tracking t WHERE t.trackShipId = :trackShipId"),
    @NamedQuery(name = "Tracking.findByTrackTimeStamp", query = "SELECT t FROM Tracking t WHERE t.trackTimeStamp = :trackTimeStamp")})
public class Tracking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "track_id")
    private Integer trackId;
    @Column(name = "track_trans_id")
    private Integer trackTransId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "track_ship_id")
    private int trackShipId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "track_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackTimeStamp;

    public Tracking() {
    }

    public Tracking(Integer trackId) {
        this.trackId = trackId;
    }

    public Tracking(Integer trackId, int trackShipId, Date trackTimeStamp) {
        this.trackId = trackId;
        this.trackShipId = trackShipId;
        this.trackTimeStamp = trackTimeStamp;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getTrackTransId() {
        return trackTransId;
    }

    public void setTrackTransId(Integer trackTransId) {
        this.trackTransId = trackTransId;
    }

    public int getTrackShipId() {
        return trackShipId;
    }

    public void setTrackShipId(int trackShipId) {
        this.trackShipId = trackShipId;
    }

    public Date getTrackTimeStamp() {
        return trackTimeStamp;
    }

    public void setTrackTimeStamp(Date trackTimeStamp) {
        this.trackTimeStamp = trackTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracking)) {
            return false;
        }
        Tracking other = (Tracking) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Tracking[ trackId=" + trackId + " ]";
    }
    
}
