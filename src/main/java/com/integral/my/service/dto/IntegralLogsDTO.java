package com.integral.my.service.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.integral.my.domain.IntegralLogs} entity.
 */
public class IntegralLogsDTO implements Serializable {

    private Long id;

    private String action;

    private String companyUuid;

    private Date createTime;

    private String request;

    private Integer isSuccess;

    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegralLogsDTO integralLogsDTO = (IntegralLogsDTO) o;
        if (integralLogsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), integralLogsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IntegralLogsDTO{" +
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
