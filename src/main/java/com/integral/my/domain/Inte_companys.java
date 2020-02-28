package com.integral.my.domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Inte_companys.
 */
@Entity
@Table(name = "inte_companys")
@EntityListeners(AuditingEntityListener.class)
public class Inte_companys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_uuid")
    private String companyUUID;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "type")
    private Integer type;

    @Column(name = "integral_value")
    private Integer integralValue;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "create_time")
    @CreatedDate// 创建数据自动填入创建时间信息
    private LocalDate createTime;

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

    public Inte_companys companyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyUUID() {
        return companyUUID;
    }

    public Inte_companys companyUUID(String companyUUID) {
        this.companyUUID = companyUUID;
        return this;
    }

    public void setCompanyUUID(String companyUUID) {
        this.companyUUID = companyUUID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Inte_companys companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getType() {
        return type;
    }

    public Inte_companys type(Integer type) {
        this.type = type;
        return this;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIntegralValue() {
        return integralValue;
    }

    public Inte_companys integralValue(Integer integralValue) {
        this.integralValue = integralValue;
        return this;
    }

    public void setIntegralValue(Integer integralValue) {
        this.integralValue = integralValue;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Inte_companys ranking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public Inte_companys createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inte_companys)) {
            return false;
        }
        return id != null && id.equals(((Inte_companys) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Inte_companys{" +
            "id=" + getId() +
            ", companyId=" + getCompanyId() +
            ", companyUUID='" + getCompanyUUID() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", type=" + getType() +
            ", integralValue=" + getIntegralValue() +
            ", ranking=" + getRanking() +
            ", createTime='" + getCreateTime() + "'" +
            "}";
    }
}
