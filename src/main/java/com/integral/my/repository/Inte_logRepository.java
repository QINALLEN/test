package com.integral.my.repository;

import com.integral.my.domain.Inte_log;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Inte_log entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Inte_logRepository extends JpaRepository<Inte_log, Long> {

}
