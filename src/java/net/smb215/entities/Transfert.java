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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "transfert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfert.findAll", query = "SELECT t FROM Transfert t"),
    @NamedQuery(name = "Transfert.findByTransId", query = "SELECT t FROM Transfert t WHERE t.transId = :transId"),
    @NamedQuery(name = "Transfert.findByTransSrcBraId", query = "SELECT t FROM Transfert t WHERE t.transSrcBraId = :transSrcBraId"),
    @NamedQuery(name = "Transfert.findByTransDestBraId", query = "SELECT t FROM Transfert t WHERE t.transDestBraId = :transDestBraId"),
    @NamedQuery(name = "Transfert.findByTransSendDate", query = "SELECT t FROM Transfert t WHERE t.transSendDate = :transSendDate"),
    @NamedQuery(name = "Transfert.findByTransDelDate", query = "SELECT t FROM Transfert t WHERE t.transDelDate = :transDelDate"),
    @NamedQuery(name = "Transfert.findByTransStatus", query = "SELECT t FROM Transfert t WHERE t.transStatus = :transStatus"),
    @NamedQuery(name = "Transfert.findByTransTimeStamp", query = "SELECT t FROM Transfert t WHERE t.transTimeStamp = :transTimeStamp")})
public class Transfert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trans_id")
    private Integer transId;
    @Column(name = "trans_src_bra_id")
    private Integer transSrcBraId;
    @Column(name = "trans_dest_bra_id")
    private Integer transDestBraId;
    @Column(name = "trans_send_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transSendDate;
    @Column(name = "trans_del_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDelDate;
    @Column(name = "trans_status")
    private Integer transStatus;
    @Column(name = "trans_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transTimeStamp;

    public Transfert() {
    }

    public Transfert(Integer transId) {
        this.transId = transId;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Integer getTransSrcBraId() {
        return transSrcBraId;
    }

    public void setTransSrcBraId(Integer transSrcBraId) {
        this.transSrcBraId = transSrcBraId;
    }

    public Integer getTransDestBraId() {
        return transDestBraId;
    }

    public void setTransDestBraId(Integer transDestBraId) {
        this.transDestBraId = transDestBraId;
    }

    public Date getTransSendDate() {
        return transSendDate;
    }

    public void setTransSendDate(Date transSendDate) {
        this.transSendDate = transSendDate;
    }

    public Date getTransDelDate() {
        return transDelDate;
    }

    public void setTransDelDate(Date transDelDate) {
        this.transDelDate = transDelDate;
    }

    public Integer getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Integer transStatus) {
        this.transStatus = transStatus;
    }

    public Date getTransTimeStamp() {
        return transTimeStamp;
    }

    public void setTransTimeStamp(Date transTimeStamp) {
        this.transTimeStamp = transTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfert)) {
            return false;
        }
        Transfert other = (Transfert) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Transfert[ transId=" + transId + " ]";
    }
    
}
