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
 * A IntegralCompays.
 */
@Entity
@Table(name = "integral_compays")
public class IntegralCompays implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "type")
    private Integer type;

    @Column(name = "company_uuid")
    private String companyUuid;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "integtal_value")
    private Integer integtalValue;

    @Column(name = "ranking")
    private Integer ranking=0;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "sort")
    private Date sort;

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

    public IntegralCompays companyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getType() {
        return type;
    }

    public IntegralCompays type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyUuid() {
        return companyUuid;
    }

    public IntegralCompays companyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
        return this;
    }

    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public IntegralCompays companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getIntegtalValue() {
        return integtalValue;
    }

    public IntegralCompays integtalValue(Integer integtalValue) {
        this.integtalValue = integtalValue;
        return this;
    }

    public void setIntegtalValue(Integer integtalValue) {
        this.integtalValue = integtalValue;
    }

    public Integer getRanking() {
        return ranking;
    }

    public IntegralCompays ranking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public IntegralCompays createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSort() {
        return sort;
    }

    public IntegralCompays sort(Date sort) {
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
        if (!(o instanceof IntegralCompays)) {
            return false;
        }
        return id != null && id.equals(((IntegralCompays) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "IntegralCompays{" +
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
