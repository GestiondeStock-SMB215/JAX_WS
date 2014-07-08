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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "invoice_out")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceOut.findAll", query = "SELECT i FROM InvoiceOut i"),
    @NamedQuery(name = "InvoiceOut.findByInvOutId", query = "SELECT i FROM InvoiceOut i WHERE i.invOutId = :invOutId"),
    @NamedQuery(name = "InvoiceOut.findByInvOutOrdOutId", query = "SELECT i FROM InvoiceOut i WHERE i.invOutOrdOutId = :invOutOrdOutId"),
    @NamedQuery(name = "InvoiceOut.findByInvOutSupId", query = "SELECT i FROM InvoiceOut i WHERE i.invOutSupId = :invOutSupId"),
    @NamedQuery(name = "InvoiceOut.findByInvOutDate", query = "SELECT i FROM InvoiceOut i WHERE i.invOutDate = :invOutDate"),
    @NamedQuery(name = "InvoiceOut.findByInvOutNum", query = "SELECT i FROM InvoiceOut i WHERE i.invOutNum = :invOutNum"),
    @NamedQuery(name = "InvoiceOut.findByInvOutTotal", query = "SELECT i FROM InvoiceOut i WHERE i.invOutTotal = :invOutTotal"),
    @NamedQuery(name = "InvoiceOut.findByInvOutTax", query = "SELECT i FROM InvoiceOut i WHERE i.invOutTax = :invOutTax"),
    @NamedQuery(name = "InvoiceOut.findByInvOutDisc", query = "SELECT i FROM InvoiceOut i WHERE i.invOutDisc = :invOutDisc"),
    @NamedQuery(name = "InvoiceOut.findByInvOutTotalDue", query = "SELECT i FROM InvoiceOut i WHERE i.invOutTotalDue = :invOutTotalDue"),
    @NamedQuery(name = "InvoiceOut.findByInvOutStatus", query = "SELECT i FROM InvoiceOut i WHERE i.invOutStatus = :invOutStatus"),
    @NamedQuery(name = "InvoiceOut.findByInvOutAtt", query = "SELECT i FROM InvoiceOut i WHERE i.invOutAtt = :invOutAtt"),
    @NamedQuery(name = "InvoiceOut.findByInvOutTimeStamp", query = "SELECT i FROM InvoiceOut i WHERE i.invOutTimeStamp = :invOutTimeStamp")})
public class InvoiceOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_out_id")
    private Integer invOutId;
    @Column(name = "inv_out_ord_out_id")
    private Integer invOutOrdOutId;
    @Column(name = "inv_out_sup_id")
    private Integer invOutSupId;
    @Column(name = "inv_out_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invOutDate;
    @Size(max = 45)
    @Column(name = "inv_out_num")
    private String invOutNum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_out_total")
    private Double invOutTotal;
    @Column(name = "inv_out_tax")
    private Double invOutTax;
    @Column(name = "inv_out_disc")
    private Double invOutDisc;
    @Column(name = "inv_out_total_due")
    private Double invOutTotalDue;
    @Column(name = "inv_out_status")
    private Integer invOutStatus;
    @Size(max = 256)
    @Column(name = "inv_out_att")
    private String invOutAtt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_out_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invOutTimeStamp;

    public InvoiceOut() {
    }

    public InvoiceOut(Integer invOutId) {
        this.invOutId = invOutId;
    }

    public InvoiceOut(Integer invOutId, Date invOutTimeStamp) {
        this.invOutId = invOutId;
        this.invOutTimeStamp = invOutTimeStamp;
    }

    public Integer getInvOutId() {
        return invOutId;
    }

    public void setInvOutId(Integer invOutId) {
        this.invOutId = invOutId;
    }

    public Integer getInvOutOrdOutId() {
        return invOutOrdOutId;
    }

    public void setInvOutOrdOutId(Integer invOutOrdOutId) {
        this.invOutOrdOutId = invOutOrdOutId;
    }

    public Integer getInvOutSupId() {
        return invOutSupId;
    }

    public void setInvOutSupId(Integer invOutSupId) {
        this.invOutSupId = invOutSupId;
    }

    public Date getInvOutDate() {
        return invOutDate;
    }

    public void setInvOutDate(Date invOutDate) {
        this.invOutDate = invOutDate;
    }

    public String getInvOutNum() {
        return invOutNum;
    }

    public void setInvOutNum(String invOutNum) {
        this.invOutNum = invOutNum;
    }

    public Double getInvOutTotal() {
        return invOutTotal;
    }

    public void setInvOutTotal(Double invOutTotal) {
        this.invOutTotal = invOutTotal;
    }

    public Double getInvOutTax() {
        return invOutTax;
    }

    public void setInvOutTax(Double invOutTax) {
        this.invOutTax = invOutTax;
    }

    public Double getInvOutDisc() {
        return invOutDisc;
    }

    public void setInvOutDisc(Double invOutDisc) {
        this.invOutDisc = invOutDisc;
    }

    public Double getInvOutTotalDue() {
        return invOutTotalDue;
    }

    public void setInvOutTotalDue(Double invOutTotalDue) {
        this.invOutTotalDue = invOutTotalDue;
    }

    public Integer getInvOutStatus() {
        return invOutStatus;
    }

    public void setInvOutStatus(Integer invOutStatus) {
        this.invOutStatus = invOutStatus;
    }

    public String getInvOutAtt() {
        return invOutAtt;
    }

    public void setInvOutAtt(String invOutAtt) {
        this.invOutAtt = invOutAtt;
    }

    public Date getInvOutTimeStamp() {
        return invOutTimeStamp;
    }

    public void setInvOutTimeStamp(Date invOutTimeStamp) {
        this.invOutTimeStamp = invOutTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invOutId != null ? invOutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceOut)) {
            return false;
        }
        InvoiceOut other = (InvoiceOut) object;
        if ((this.invOutId == null && other.invOutId != null) || (this.invOutId != null && !this.invOutId.equals(other.invOutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.InvoiceOut[ invOutId=" + invOutId + " ]";
    }
    
}
