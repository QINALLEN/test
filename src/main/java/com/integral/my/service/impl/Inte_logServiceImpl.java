package com.integral.my.service.impl;

import com.integral.my.domain.Inte_log;
import com.integral.my.repository.Inte_logRepository;
import com.integral.my.service.Inte_logService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Inte_log}.
 */
@Service
@Transactional
public class Inte_logServiceImpl implements Inte_logService {

    private final Logger log = LoggerFactory.getLogger(Inte_logServiceImpl.class);

    private final Inte_logRepository inte_logRepository;

    public Inte_logServiceImpl(Inte_logRepository inte_logRepository) {
        this.inte_logRepository = inte_logRepository;
    }

    /**
     * Save a inte_log.
     *
     * @param inte_log the entity to save.
     * @return the persisted entity.
     */
    public Inte_log save(Inte_log inte_log) {
        log.debug("Request to save Inte_log : {}", inte_log);
        return inte_logRepository.save(inte_log);
    }

    /**
     * Get all the inte_logs.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Inte_log> findAll() {
        log.debug("Request to get all Inte_logs");
        return inte_logRepository.findAll();
    }

    /**
     * Get one inte_log by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Inte_log> findOne(Long id) {
        log.debug("Request to get Inte_log : {}", id);
        return inte_logRepository.findById(id);
    }

    /**
     * Delete the inte_log by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Inte_log : {}", id);
        inte_logRepository.deleteById(id);
    }
}
