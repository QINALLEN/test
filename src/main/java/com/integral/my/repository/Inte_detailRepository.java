package com.integral.my.repository;

import com.integral.my.domain.Inte_detail;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Inte_detail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Inte_detailRepository extends JpaRepository<Inte_detail, Long> {

}
