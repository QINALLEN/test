package com.integral.my.repository;

import com.integral.my.domain.IntegralCompays;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IntegralCompays entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntegralCompaysRepository extends JpaRepository<IntegralCompays, Long> {

    IntegralCompays findByCompanyIdAndType(Integer companyId, Integer type);

    Page<IntegralCompays> findAllByCompanyNameLikeOrderByIntegtalValueDesc(String key, Pageable pageable);

    Integer countAllByIntegtalValueGreaterThanOrIntegtalValueEqualsAndIdLessThan(Integer value,Integer val,Long id);
}
