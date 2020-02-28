package com.integral.my.repository;

import com.integral.my.domain.Inte_companys;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Inte_companys entity.
 */
@SuppressWarnings("unused")
@Repository
public interface Inte_companysRepository extends JpaRepository<Inte_companys, Long> {

    Inte_companys findByCompanyIdAndType(Integer companyId, Integer type);
}
