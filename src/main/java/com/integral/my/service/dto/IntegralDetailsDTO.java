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
 * A DTO for the {@link com.integral.my.domain.IntegralDetails} entity.
 */
public class IntegralDetailsDTO implements Serializable {

    private Long id;

    private Integer companyId;

    private String companyUuid;

    private String companyName;

    private Integer type;

    private String source;

    private String tenderCode;

    private String proName;

    private Integer rewardValue;

    private Date rewardDate;

    private Date sort;

    private Integer haveInte;

    public Integer getHaveInte() {
        return haveInte;
    }

    public void setHaveInte(Integer haveInte) {
        this.haveInte = haveInte;
    }

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTenderCode() {
        return tenderCode;
    }

    public void setTenderCode(String tenderCode) {
        this.tenderCode = tenderCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(Integer rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Date getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(Date rewardDate) {
        this.rewardDate = rewardDate;
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

        IntegralDetailsDTO integralDetailsDTO = (IntegralDetailsDTO) o;
        if (integralDetailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), integralDetailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "IntegralDetailsDTO{" +
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
