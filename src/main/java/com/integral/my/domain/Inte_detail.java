package com.integral.my.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A Inte_detail.
 */
@Entity
@Table(name = "inte_detail")
public class Inte_detail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_uu_id")
    private String companyUUId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "type")
    private Integer type;

    @Column(name = "source")
    private String source;

    @Column(name = "tender_code")
    private String tenderCode;

    @Column(name = "pro_name")
    private String proName;

    @Column(name = "reward_value")
    private Integer rewardValue;

    @Column(name = "reward_date")
    private LocalDate rewardDate;

    @Column(name = "create_time")
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Inte_detail companyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyUUId() {
        return companyUUId;
    }

    public Inte_detail companyUUId(String companyUUId) {
        this.companyUUId = companyUUId;
        return this;
    }

    public void setCompanyUUId(String companyUUId) {
        this.companyUUId = companyUUId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Inte_detail companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getType() {
        return type;
    }

    public Inte_detail type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public Inte_detail source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTenderCode() {
        return tenderCode;
    }

    public Inte_detail tenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
        return this;
    }

    public void setTenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
    }

    public String getProName() {
        return proName;
    }

    public Inte_detail proName(String proName) {
        this.proName = proName;
        return this;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getRewardValue() {
        return rewardValue;
    }

    public Inte_detail rewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
        return this;
    }

    public void setRewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
    }

    public LocalDate getRewardDate() {
        return rewardDate;
    }

    public Inte_detail rewardDate(LocalDate rewardDate) {
        this.rewardDate = rewardDate;
        return this;
    }

    public void setRewardDate(LocalDate rewardDate) {
        this.rewardDate = rewardDate;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inte_detail)) {
            return false;
        }
        return id != null && id.equals(((Inte_detail) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Inte_detail{" +
            "id=" + getId() +
            ", companyId=" + getCompanyId() +
            ", companyUUId='" + getCompanyUUId() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", type=" + getType() +
            ", source='" + getSource() + "'" +
            ", tenderCode='" + getTenderCode() + "'" +
            ", proName='" + getProName() + "'" +
            ", rewardValue=" + getRewardValue() +
            ", rewardDate='" + getRewardDate() + "'" +
            "}";
    }
}
