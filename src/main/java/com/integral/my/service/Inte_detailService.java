package com.integral.my.service;

import com.integral.my.domain.Inte_detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Inte_detail}.
 */
public interface Inte_detailService {

    /**
     * Save a inte_detail.
     *
     * @param inte_detail the entity to save.
     * @return the persisted entity.
     */
    Inte_detail save(Inte_detail inte_detail);

    /**
     * Get all the inte_details.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Inte_detail> findAll(Pageable pageable);

    /**
     * Get the "id" inte_detail.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Inte_detail> findOne(Long id);

    /**
     * Delete the "id" inte_detail.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
