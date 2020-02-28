package com.integral.my.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Inte_log.
 */
@Entity
@Table(name = "inte_log")
public class Inte_log implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action")
    private String action;

    @Column(name = "company")
    private Integer company;

    @Column(name = "create_time")
    private LocalDate createTime;

    @Column(name = "request")
    private String request;

    @Column(name = "is_success")
    private Integer is_success;

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

    public Inte_log action(String action) {
        this.action = action;
        return this;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getCompany() {
        return company;
    }

    public Inte_log company(Integer company) {
        this.company = company;
        return this;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public Inte_log createTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getRequest() {
        return request;
    }

    public Inte_log request(String request) {
        this.request = request;
        return this;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Integer getIs_success() {
        return is_success;
    }

    public Inte_log is_success(Integer is_success) {
        this.is_success = is_success;
        return this;
    }

    public void setIs_success(Integer is_success) {
        this.is_success = is_success;
    }

    public String getRemark() {
        return remark;
    }

    public Inte_log remark(String remark) {
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
        if (!(o instanceof Inte_log)) {
            return false;
        }
        return id != null && id.equals(((Inte_log) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Inte_log{" +
            "id=" + getId() +
            ", action='" + getAction() + "'" +
            ", company=" + getCompany() +
            ", createTime='" + getCreateTime() + "'" +
            ", request='" + getRequest() + "'" +
            ", is_success=" + getIs_success() +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}
