package com.integral.my.service.dto;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.Instant;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.integral.my.domain.IntegralCompays} entity.
 */
public class IntegralCompaysDTO implements Serializable {

    private Long id;

    private Integer companyId;

    private Integer type;

    private String companyUuid;

    private String companyName;

    private Integer integtalValue;

    private Integer ranking=0;

    private Date createTime;

    private Date sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIntegtalValue() {
        return integtalValue;
    }

    public void setIntegtalValue(Integer integtalValue) {
        this.integtalValue = integtalValue;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSort() {
        return sort;
    }

    public void setSort(Date sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegralCompaysDTO integralCompaysDTO = (IntegralCompaysDTO) o;
        if (integralCompaysDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), integralCompaysDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IntegralCompaysDTO{" +
            "id=" + getId() +
            ", companyId=" + getCompanyId() +
            ", type=" + getType() +
            ", companyUuid='" + getCompanyUuid() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", integtalValue=" + getIntegtalValue() +
            ", ranking=" + getRanking() +
            ", createTime='" + getCreateTime() + "'" +
            ", sort='" + getSort() + "'" +
            "}";
    }
}
