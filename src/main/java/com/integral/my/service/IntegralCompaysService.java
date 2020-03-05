package com.integral.my.service;

import com.integral.my.domain.IntegralCompays;
import com.integral.my.service.dto.IntegralCompaysDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.integral.my.domain.IntegralCompays}.
 */
public interface IntegralCompaysService {

    /**
     * Save a integralCompays.
     *
     * @param integralCompaysDTO the entity to save.
     * @return the persisted entity.
     */
    IntegralCompaysDTO save(IntegralCompaysDTO integralCompaysDTO);


    IntegralCompaysDTO update(IntegralCompaysDTO integralCompaysDTO);

    /**
     * Get all the integralCompays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<IntegralCompaysDTO> findAll(String key,Pageable pageable);

    /**
     * Get the "id" integralCompays.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IntegralCompaysDTO> findOne(Long id);

    /**
     * Delete the "id" integralCompays.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    IntegralCompays findByCompanyIdAndType(Integer companyId, Integer type);
}
