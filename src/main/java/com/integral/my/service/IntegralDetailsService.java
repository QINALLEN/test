package com.integral.my.service;

import com.integral.my.service.dto.IntegralDetailsDTO;

import com.integral.my.service.dto.ResultView;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.integral.my.domain.IntegralDetails}.
 */
public interface IntegralDetailsService {

    /**
     * Save a integralDetails.
     *
     * @param integralDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    ResultView save(IntegralDetailsDTO integralDetailsDTO);

    /**
     * Get all the integralDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    ResultView findAll(String viewerId, Integer type, Pageable pageable);

    /**
     * Get the "id" integralDetails.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IntegralDetailsDTO> findOne(Long id);

    /**
     * Delete the "id" integralDetails.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
