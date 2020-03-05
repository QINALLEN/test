package com.integral.my.service.dto;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public class ReturnDetails implements Serializable {
    private Integer totalIntegtalValue;
    private List<IntegralDetailsDTO> data;
    private Integer totalPages;
    private Integer totalElements;

    public Integer getTotalIntegtalValue() {
        return totalIntegtalValue;
    }

    public void setTotalIntegtalValue(Integer totalIntegtalValue) {
        this.totalIntegtalValue = totalIntegtalValue;
    }

    public List<IntegralDetailsDTO> getData() {
        return data;
    }

    public void setData(List<IntegralDetailsDTO> data) {
        this.data = data;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public ReturnDetails(Integer totalIntegtalValue, List<IntegralDetailsDTO> data, Integer totalPages, Integer totalElements) {
        this.totalIntegtalValue = totalIntegtalValue;
        this.data = data;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public ReturnDetails() {
    }

    @Override
    public String toString() {
        return "ReturnDetails{" +
            "totalIntegtalValue=" + totalIntegtalValue +
            ", data=" + data +
            ", totalPages=" + totalPages +
            ", totalElements=" + totalElements +
            '}';
    }
}
