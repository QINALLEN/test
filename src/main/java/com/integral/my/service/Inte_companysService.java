package com.integral.my.service;

import com.integral.my.domain.Inte_companys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Inte_companys}.
 */
public interface Inte_companysService {

    /**
     * Save a inte_companys.
     *
     * @param inte_companys the entity to save.
     * @return the persisted entity.
     */
    Inte_companys save(Inte_companys inte_companys);

    /**
     * Get all the inte_companys.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Inte_companys> findAll(Pageable pageable);

    /**
     * Get the "id" inte_companys.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Inte_companys> findOne(Long id);

    /**
     * Delete the "id" inte_companys.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    Inte_companys findByCompanyIdAndType(Integer companyId, Integer type);
}
