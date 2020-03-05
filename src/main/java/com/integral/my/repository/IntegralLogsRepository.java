package com.integral.my.repository;

import com.integral.my.domain.IntegralLogs;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the IntegralLogs entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntegralLogsRepository extends JpaRepository<IntegralLogs, Long> {

}
