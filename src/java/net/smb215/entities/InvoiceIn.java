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
@Table(name = "invoice_in")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceIn.findAll", query = "SELECT i FROM InvoiceIn i"),
    @NamedQuery(name = "InvoiceIn.findByInvInId", query = "SELECT i FROM InvoiceIn i WHERE i.invInId = :invInId"),
    @NamedQuery(name = "InvoiceIn.findByInvInOrdInId", query = "SELECT i FROM InvoiceIn i WHERE i.invInOrdInId = :invInOrdInId"),
    @NamedQuery(name = "InvoiceIn.findByInvInCustId", query = "SELECT i FROM InvoiceIn i WHERE i.invInCustId = :invInCustId"),
    @NamedQuery(name = "InvoiceIn.findByInvInDate", query = "SELECT i FROM InvoiceIn i WHERE i.invInDate = :invInDate"),
    @NamedQuery(name = "InvoiceIn.findByInvInNum", query = "SELECT i FROM InvoiceIn i WHERE i.invInNum = :invInNum"),
    @NamedQuery(name = "InvoiceIn.findByInvInTotal", query = "SELECT i FROM InvoiceIn i WHERE i.invInTotal = :invInTotal"),
    @NamedQuery(name = "InvoiceIn.findByInvInTax", query = "SELECT i FROM InvoiceIn i WHERE i.invInTax = :invInTax"),
    @NamedQuery(name = "InvoiceIn.findByInvInDisc", query = "SELECT i FROM InvoiceIn i WHERE i.invInDisc = :invInDisc"),
    @NamedQuery(name = "InvoiceIn.findByInvInTotalDue", query = "SELECT i FROM InvoiceIn i WHERE i.invInTotalDue = :invInTotalDue"),
    @NamedQuery(name = "InvoiceIn.findByInvInStatus", query = "SELECT i FROM InvoiceIn i WHERE i.invInStatus = :invInStatus"),
    @NamedQuery(name = "InvoiceIn.findByInvInAtt", query = "SELECT i FROM InvoiceIn i WHERE i.invInAtt = :invInAtt"),
    @NamedQuery(name = "InvoiceIn.findByInvInTimeStamp", query = "SELECT i FROM InvoiceIn i WHERE i.invInTimeStamp = :invInTimeStamp")})
public class InvoiceIn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inv_in_id")
    private Integer invInId;
    @Column(name = "inv_in_ord_in_id")
    private Integer invInOrdInId;
    @Column(name = "inv_in_cust_id")
    private Integer invInCustId;
    @Column(name = "inv_in_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invInDate;
    @Size(max = 45)
    @Column(name = "inv_in_num")
    private String invInNum;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inv_in_total")
    private Double invInTotal;
    @Column(name = "inv_in_tax")
    private Double invInTax;
    @Column(name = "inv_in_disc")
    private Double invInDisc;
    @Column(name = "inv_in_total_due")
    private Double invInTotalDue;
    @Column(name = "inv_in_status")
    private Integer invInStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "inv_in_att")
    private String invInAtt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_in_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invInTimeStamp;

    public InvoiceIn() {
    }

    public InvoiceIn(Integer invInId) {
        this.invInId = invInId;
    }

    public InvoiceIn(Integer invInId, String invInAtt, Date invInTimeStamp) {
        this.invInId = invInId;
        this.invInAtt = invInAtt;
        this.invInTimeStamp = invInTimeStamp;
    }

    public Integer getInvInId() {
        return invInId;
    }

    public void setInvInId(Integer invInId) {
        this.invInId = invInId;
    }

    public Integer getInvInOrdInId() {
        return invInOrdInId;
    }

    public void setInvInOrdInId(Integer invInOrdInId) {
        this.invInOrdInId = invInOrdInId;
    }

    public Integer getInvInCustId() {
        return invInCustId;
    }

    public void setInvInCustId(Integer invInCustId) {
        this.invInCustId = invInCustId;
    }

    public Date getInvInDate() {
        return invInDate;
    }

    public void setInvInDate(Date invInDate) {
        this.invInDate = invInDate;
    }

    public String getInvInNum() {
        return invInNum;
    }

    public void setInvInNum(String invInNum) {
        this.invInNum = invInNum;
    }

    public Double getInvInTotal() {
        return invInTotal;
    }

    public void setInvInTotal(Double invInTotal) {
        this.invInTotal = invInTotal;
    }

    public Double getInvInTax() {
        return invInTax;
    }

    public void setInvInTax(Double invInTax) {
        this.invInTax = invInTax;
    }

    public Double getInvInDisc() {
        return invInDisc;
    }

    public void setInvInDisc(Double invInDisc) {
        this.invInDisc = invInDisc;
    }

    public Double getInvInTotalDue() {
        return invInTotalDue;
    }

    public void setInvInTotalDue(Double invInTotalDue) {
        this.invInTotalDue = invInTotalDue;
    }

    public Integer getInvInStatus() {
        return invInStatus;
    }

    public void setInvInStatus(Integer invInStatus) {
        this.invInStatus = invInStatus;
    }

    public String getInvInAtt() {
        return invInAtt;
    }

    public void setInvInAtt(String invInAtt) {
        this.invInAtt = invInAtt;
    }

    public Date getInvInTimeStamp() {
        return invInTimeStamp;
    }

    public void setInvInTimeStamp(Date invInTimeStamp) {
        this.invInTimeStamp = invInTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invInId != null ? invInId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceIn)) {
            return false;
        }
        InvoiceIn other = (InvoiceIn) object;
        if ((this.invInId == null && other.invInId != null) || (this.invInId != null && !this.invInId.equals(other.invInId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.InvoiceIn[ invInId=" + invInId + " ]";
    }
    
}
