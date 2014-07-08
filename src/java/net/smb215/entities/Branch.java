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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBraId", query = "SELECT b FROM Branch b WHERE b.braId = :braId"),
    @NamedQuery(name = "Branch.findByBraName", query = "SELECT b FROM Branch b WHERE b.braName = :braName"),
    @NamedQuery(name = "Branch.findByBraCntId", query = "SELECT b FROM Branch b WHERE b.braCntId = :braCntId"),
    @NamedQuery(name = "Branch.findByBraCity", query = "SELECT b FROM Branch b WHERE b.braCity = :braCity"),
    @NamedQuery(name = "Branch.findByBraAddSrt", query = "SELECT b FROM Branch b WHERE b.braAddSrt = :braAddSrt"),
    @NamedQuery(name = "Branch.findByBraTel1", query = "SELECT b FROM Branch b WHERE b.braTel1 = :braTel1"),
    @NamedQuery(name = "Branch.findByBraTel2", query = "SELECT b FROM Branch b WHERE b.braTel2 = :braTel2"),
    @NamedQuery(name = "Branch.findByBraFax", query = "SELECT b FROM Branch b WHERE b.braFax = :braFax"),
    @NamedQuery(name = "Branch.findByBraEmail", query = "SELECT b FROM Branch b WHERE b.braEmail = :braEmail"),
    @NamedQuery(name = "Branch.findByBraTimeStamp", query = "SELECT b FROM Branch b WHERE b.braTimeStamp = :braTimeStamp")})
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bra_id")
    private Integer braId;
    @Size(max = 45)
    @Column(name = "bra_name")
    private String braName;
    @Column(name = "bra_cnt_id")
    private Integer braCntId;
    @Size(max = 45)
    @Column(name = "bra_city")
    private String braCity;
    @Size(max = 45)
    @Column(name = "bra_add_srt")
    private String braAddSrt;
    @Lob
    @Size(max = 65535)
    @Column(name = "bra_add_1")
    private String braAdd1;
    @Size(max = 128)
    @Column(name = "bra_tel_1")
    private String braTel1;
    @Size(max = 128)
    @Column(name = "bra_tel_2")
    private String braTel2;
    @Size(max = 128)
    @Column(name = "bra_fax")
    private String braFax;
    @Size(max = 128)
    @Column(name = "bra_email")
    private String braEmail;
    @Column(name = "bra_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date braTimeStamp;

    public Branch() {
    }

    public Branch(Integer braId) {
        this.braId = braId;
    }

    public Integer getBraId() {
        return braId;
    }

    public void setBraId(Integer braId) {
        this.braId = braId;
    }

    public String getBraName() {
        return braName;
    }

    public void setBraName(String braName) {
        this.braName = braName;
    }

    public Integer getBraCntId() {
        return braCntId;
    }

    public void setBraCntId(Integer braCntId) {
        this.braCntId = braCntId;
    }

    public String getBraCity() {
        return braCity;
    }

    public void setBraCity(String braCity) {
        this.braCity = braCity;
    }

    public String getBraAddSrt() {
        return braAddSrt;
    }

    public void setBraAddSrt(String braAddSrt) {
        this.braAddSrt = braAddSrt;
    }

    public String getBraAdd1() {
        return braAdd1;
    }

    public void setBraAdd1(String braAdd1) {
        this.braAdd1 = braAdd1;
    }

    public String getBraTel1() {
        return braTel1;
    }

    public void setBraTel1(String braTel1) {
        this.braTel1 = braTel1;
    }

    public String getBraTel2() {
        return braTel2;
    }

    public void setBraTel2(String braTel2) {
        this.braTel2 = braTel2;
    }

    public String getBraFax() {
        return braFax;
    }

    public void setBraFax(String braFax) {
        this.braFax = braFax;
    }

    public String getBraEmail() {
        return braEmail;
    }

    public void setBraEmail(String braEmail) {
        this.braEmail = braEmail;
    }

    public Date getBraTimeStamp() {
        return braTimeStamp;
    }

    public void setBraTimeStamp(Date braTimeStamp) {
        this.braTimeStamp = braTimeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (braId != null ? braId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.braId == null && other.braId != null) || (this.braId != null && !this.braId.equals(other.braId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.smb215.entities.Branch[ braId=" + braId + " ]";
    }
    
}
