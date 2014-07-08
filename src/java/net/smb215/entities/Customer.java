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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry_kozhaya
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustId", query = "SELECT c FROM Customer c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customer.findByCustComp", query = "SELECT c FROM Customer c WHERE c.custComp = :custComp"),
    @NamedQuery(name = "Customer.findByCustName", query = "SELECT c FROM Customer c WHERE c.custName = :custName"),
    @NamedQuery(name = "Customer.findByCustTitle", query = "SELECT c FROM Customer c WHERE c.custTitle = :custTitle"),
    @NamedQuery(name = "Customer.findByCustCity", query = "SELECT c FROM Customer c WHERE c.custCity = :custCity"),
    @NamedQuery(name = "Customer.findByCustCntId", query = "SELECT c FROM Customer c WHERE c.custCntId = :custCntId"),
    @NamedQuery(name = "Customer.findByCustTel1", query = "SELECT c FROM Customer c WHERE c.custTel1 = :custTel1"),
    @NamedQuery(name = "Customer.findByCustTel2", query = "SELECT c FROM Customer c WHERE c.custTel2 = :custTel2"),
    @NamedQuery(name = "Customer.findByCustFax", query = "SELECT c FROM Customer c WHERE c.custFax = :custFax"),
    @NamedQuery(name = "Customer.findByCustEmail", query = "SELECT c FROM Customer c WHERE c.custEmail = :custEmail"),
    @NamedQuery(name = "Customer.findByCustSite", query = "SELECT c FROM Customer c WHERE c.custSite = :custSite"),
    @NamedQuery(name = "Customer.findByCustLogo", query = "SELECT c FROM Customer c WHERE c.custLogo = :custLogo"),
    @NamedQuery(name = "Customer.findByCustTimeStamp", query = "SELECT c FROM Customer c WHERE c.custTimeStamp = :custTimeStamp")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cust_id")
    private Integer custId;
    @Size(max = 128)
    @Column(name = "cust_comp")
    private String custComp;
    @Size(max = 128)
    @Column(name = "cust_name")
    private String custName;
    @Size(max = 4)
    @Column(name = "cust_title")
    private String custTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "cust_add_1")
    private String custAdd1;
    @Lob
    @Size(max = 65535)
    @Column(name = "cust_add_2")
    private String custAdd2;
    @Size(max = 128)
    @Column(name = "cust_city")
    private String custCity;
    @Column(name = "cust_cnt_id")
    private Integer custCntId;
    @Size(max = 128)
    @Column(name = "cust_tel_1")
    private String custTel1;
    @Size(max = 128)
    @Column(name = "cust_tel_2")
    private String custTel2;
    @Size(max = 128)
    @Column(name = "cust_fax")
    private String custFax;
    @Size(max = 256)
    @Column(name = "cust_email")
    private String custEmail;
    @Size(max = 256)
    @Column(name = "cust_site")
    private String custSite;
    @Size(max = 256)
    @Column(name = "cust_logo")
    private String custLogo;
    @Column(name = "cust_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date custTimeStamp;

    public Customer() {
    }

    public Customer(Integer custId) {
        this.custId = custId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustComp() {
        return custComp;
    }

    public void setCustComp(String custComp) {
        this.custComp = custComp;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustTitle() {
        return custTitle;
    }

    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
    }

    public String getCustAdd1() {
        return custAdd1;
    }

    public void setCustAdd1(String custAdd1) {
        this.custAdd1 = custAdd1;
    }

    public String getCustAdd2() {
        return custAdd2;
    }

    public void setCustAdd2(String custAdd2) {
        this.custAdd2 = custAdd2;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public Integer getCustCntId() {
        return custCntId;
    }

    public void setCustCntId(Integer custCntId) {
        this.custCntId = custCntId;
    }

    public String getCustTel1() {
        return custTel1;
    }

    public void setCustTel1(String custTel1) {
        this.custTel1 = custTel1;
    }

    public String getCustTel2() {
        return custTel2;
    }

    public void setCustTel2(String custTel2) {
        this.custTel2 = custTel2;
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustSite() {
        return custSite;
    }

    public void setCustSite(String custSite) {
        this.custSite = custSite;
    }

    public String getCustLogo() {
        return custLogo;
    }

    public void setCustLogo(String custLogo) {
        this.custLogo = custLogo;
    }

    public Date getCustTimeStamp() {
        return custTimeStamp;
    }

    public void setCustTimeStamp(Date custTimeStamp) {
        this.custTimeStamp = custTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Customer[ custId=" + custId + " ]";
    }
    
}
