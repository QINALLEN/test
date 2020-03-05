package com.integral.my.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * A IntegralLogs.
 */
@Entity
@Table(name = "integral_logs")
public class IntegralLogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action")
    private String action;

    @Column(name = "company_uuid")
    private String companyUuid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "request")
    private String request;

    @Column(name = "is_success")
    private Integer isSuccess;

    @Column(name = "remark")
    private String remark;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public IntegralLogs action(String action) {
        this.action = action;
        return this;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public IntegralLogs companyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
        return this;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public IntegralLogs createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRequest() {
        return request;
    }

    public IntegralLogs request(String request) {
        this.request = request;
        return this;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public IntegralLogs isSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
        return this;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getRemark() {
        return remark;
    }

    public IntegralLogs remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntegralLogs)) {
            return false;
        }
        return id != null && id.equals(((IntegralLogs) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "IntegralLogs{" +
            "id=" + getId() +
            ", action='" + getAction() + "'" +
            ", companyUuid='" + getCompanyUuid() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", request='" + getRequest() + "'" +
            ", isSuccess=" + getIsSuccess() +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
