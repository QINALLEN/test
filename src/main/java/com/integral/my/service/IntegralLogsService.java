package com.integral.my.service;

import com.integral.my.service.dto.IntegralLogsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.integral.my.domain.IntegralLogs}.
 */
public interface IntegralLogsService {

    /**
     * Save a integralLogs.
     *
     * @param integralLogsDTO the entity to save.
     * @return the persisted entity.
     */
    IntegralLogsDTO save(IntegralLogsDTO integralLogsDTO);

    /**
     * Get all the integralLogs.
     *
     * @return the list of entities.
     */
    List<IntegralLogsDTO> findAll();

    /**
     * Get the "id" integralLogs.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<IntegralLogsDTO> findOne(Long id);

    /**
     * Delete the "id" integralLogs.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
