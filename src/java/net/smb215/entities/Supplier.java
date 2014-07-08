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
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findBySupId", query = "SELECT s FROM Supplier s WHERE s.supId = :supId"),
    @NamedQuery(name = "Supplier.findBySupComp", query = "SELECT s FROM Supplier s WHERE s.supComp = :supComp"),
    @NamedQuery(name = "Supplier.findBySupName", query = "SELECT s FROM Supplier s WHERE s.supName = :supName"),
    @NamedQuery(name = "Supplier.findBySupTitle", query = "SELECT s FROM Supplier s WHERE s.supTitle = :supTitle"),
    @NamedQuery(name = "Supplier.findBySupCity", query = "SELECT s FROM Supplier s WHERE s.supCity = :supCity"),
    @NamedQuery(name = "Supplier.findBySupCntId", query = "SELECT s FROM Supplier s WHERE s.supCntId = :supCntId"),
    @NamedQuery(name = "Supplier.findBySupTel1", query = "SELECT s FROM Supplier s WHERE s.supTel1 = :supTel1"),
    @NamedQuery(name = "Supplier.findBySupTel2", query = "SELECT s FROM Supplier s WHERE s.supTel2 = :supTel2"),
    @NamedQuery(name = "Supplier.findBySupFax", query = "SELECT s FROM Supplier s WHERE s.supFax = :supFax"),
    @NamedQuery(name = "Supplier.findBySupEmail", query = "SELECT s FROM Supplier s WHERE s.supEmail = :supEmail"),
    @NamedQuery(name = "Supplier.findBySupSite", query = "SELECT s FROM Supplier s WHERE s.supSite = :supSite"),
    @NamedQuery(name = "Supplier.findBySupLogo", query = "SELECT s FROM Supplier s WHERE s.supLogo = :supLogo"),
    @NamedQuery(name = "Supplier.findBySupTimeStamp", query = "SELECT s FROM Supplier s WHERE s.supTimeStamp = :supTimeStamp")})
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sup_id")
    private Integer supId;
    @Size(max = 128)
    @Column(name = "sup_comp")
    private String supComp;
    @Size(max = 128)
    @Column(name = "sup_name")
    private String supName;
    @Size(max = 4)
    @Column(name = "sup_title")
    private String supTitle;
    @Lob
    @Size(max = 65535)
    @Column(name = "sup_add_1")
    private String supAdd1;
    @Lob
    @Size(max = 65535)
    @Column(name = "sup_add_2")
    private String supAdd2;
    @Size(max = 128)
    @Column(name = "sup_city")
    private String supCity;
    @Column(name = "sup_cnt_id")
    private Integer supCntId;
    @Size(max = 128)
    @Column(name = "sup_tel_1")
    private String supTel1;
    @Size(max = 128)
    @Column(name = "sup_tel_2")
    private String supTel2;
    @Size(max = 128)
    @Column(name = "sup_fax")
    private String supFax;
    @Size(max = 256)
    @Column(name = "sup_email")
    private String supEmail;
    @Size(max = 256)
    @Column(name = "sup_site")
    private String supSite;
    @Size(max = 256)
    @Column(name = "sup_logo")
    private String supLogo;
    @Column(name = "sup_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date supTimeStamp;

    public Supplier() {
    }

    public Supplier(Integer supId) {
        this.supId = supId;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getSupComp() {
        return supComp;
    }

    public void setSupComp(String supComp) {
        this.supComp = supComp;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupTitle() {
        return supTitle;
    }

    public void setSupTitle(String supTitle) {
        this.supTitle = supTitle;
    }

    public String getSupAdd1() {
        return supAdd1;
    }

    public void setSupAdd1(String supAdd1) {
        this.supAdd1 = supAdd1;
    }

    public String getSupAdd2() {
        return supAdd2;
    }

    public void setSupAdd2(String supAdd2) {
        this.supAdd2 = supAdd2;
    }

    public String getSupCity() {
        return supCity;
    }

    public void setSupCity(String supCity) {
        this.supCity = supCity;
    }

    public Integer getSupCntId() {
        return supCntId;
    }

    public void setSupCntId(Integer supCntId) {
        this.supCntId = supCntId;
    }

    public String getSupTel1() {
        return supTel1;
    }

    public void setSupTel1(String supTel1) {
        this.supTel1 = supTel1;
    }

    public String getSupTel2() {
        return supTel2;
    }

    public void setSupTel2(String supTel2) {
        this.supTel2 = supTel2;
    }

    public String getSupFax() {
        return supFax;
    }

    public void setSupFax(String supFax) {
        this.supFax = supFax;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    public String getSupSite() {
        return supSite;
    }

    public void setSupSite(String supSite) {
        this.supSite = supSite;
    }

    public String getSupLogo() {
        return supLogo;
    }

    public void setSupLogo(String supLogo) {
        this.supLogo = supLogo;
    }

    public Date getSupTimeStamp() {
        return supTimeStamp;
    }

    public void setSupTimeStamp(Date supTimeStamp) {
        this.supTimeStamp = supTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supId != null ? supId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supId == null && other.supId != null) || (this.supId != null && !this.supId.equals(other.supId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Supplier[ supId=" + supId + " ]";
    }
    
}
