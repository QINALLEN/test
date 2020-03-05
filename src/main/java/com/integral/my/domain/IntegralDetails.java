package com.integral.my.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * A IntegralDetails.
 */
@Entity
@Table(name = "integral_details")
public class IntegralDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_uuid")
    private String companyUuid;

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
    private Date rewardDate;

    @Column(name = "sort")
    private Date sort;

    @Column(name = "have_inte")
    private Integer haveInte;

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

    public IntegralDetails companyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public IntegralDetails companyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
        return this;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public IntegralDetails companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getType() {
        return type;
    }

    public IntegralDetails type(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getHaveInte() {
        return haveInte;
    }

    public void setHaveInte(Integer haveInte) {
        this.haveInte = haveInte;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public IntegralDetails source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTenderCode() {
        return tenderCode;
    }

    public IntegralDetails tenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
        return this;
    }

    public void setTenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
    }

    public String getProName() {
        return proName;
    }

    public IntegralDetails proName(String proName) {
        this.proName = proName;
        return this;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getRewardValue() {
        return rewardValue;
    }

    public IntegralDetails rewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
        return this;
    }

    public void setRewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Date getRewardDate() {
        return rewardDate;
    }

    public IntegralDetails rewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
        return this;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
    }

    public Date getSort() {
        return sort;
    }

    public IntegralDetails sort(Date sort) {
        this.sort = sort;
        return this;
    }

    public void setSort(Date sort) {
        this.sort = sort;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntegralDetails)) {
            return false;
        }
        return id != null && id.equals(((IntegralDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "IntegralDetails{" +
            "id=" + id +
            ", companyId=" + companyId +
            ", companyUuid='" + companyUuid + '\'' +
            ", companyName='" + companyName + '\'' +
            ", type=" + type +
            ", source='" + source + '\'' +
            ", tenderCode='" + tenderCode + '\'' +
            ", proName='" + proName + '\'' +
            ", rewardValue=" + rewardValue +
            ", rewardDate=" + rewardDate +
            ", sort=" + sort +
            ", haveInte=" + haveInte +
            '}';
    }
}
