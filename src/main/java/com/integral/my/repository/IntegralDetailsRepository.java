package com.integral.my.repository;

import com.integral.my.domain.IntegralDetails;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

/**
 * Spring Data  repository for the IntegralDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntegralDetailsRepository extends JpaRepository<IntegralDetails, Long> {

    Page<IntegralDetails> findAllByCompanyUuidOrderBySortDesc(String companyUuid, Pageable pageable);

    IntegralDetails findByCompanyIdAndTypeAndTenderCodeAndSource(Integer companyId, Integer type, String tenderCode, String source);
}
