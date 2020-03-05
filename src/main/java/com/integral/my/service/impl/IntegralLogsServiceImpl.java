package com.integral.my.service.impl;

import com.integral.my.service.IntegralLogsService;
import com.integral.my.domain.IntegralLogs;
import com.integral.my.repository.IntegralLogsRepository;
import com.integral.my.service.dto.IntegralLogsDTO;
import com.integral.my.service.mapper.IntegralLogsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link IntegralLogs}.
 */
@Service
@Transactional
public class IntegralLogsServiceImpl implements IntegralLogsService {

    private final Logger log = LoggerFactory.getLogger(IntegralLogsServiceImpl.class);

    private final IntegralLogsRepository integralLogsRepository;

    private final IntegralLogsMapper integralLogsMapper;

    public IntegralLogsServiceImpl(IntegralLogsRepository integralLogsRepository, IntegralLogsMapper integralLogsMapper) {
        this.integralLogsRepository = integralLogsRepository;
        this.integralLogsMapper = integralLogsMapper;
    }

    /**
     * Save a integralLogs.
     *
     * @param integralLogsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public IntegralLogsDTO save(IntegralLogsDTO integralLogsDTO) {
        log.debug("Request to save IntegralLogs : {}", integralLogsDTO);
        IntegralLogs integralLogs = integralLogsMapper.toEntity(integralLogsDTO);
        integralLogs.setCreateTime(new Date());
        integralLogs = integralLogsRepository.save(integralLogs);
        return integralLogsMapper.toDto(integralLogs);
    }

    /**
     * Get all the integralLogs.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<IntegralLogsDTO> findAll() {
        log.debug("Request to get all IntegralLogs");
        return integralLogsRepository.findAll().stream()
            .map(integralLogsMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one integralLogs by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IntegralLogsDTO> findOne(Long id) {
        log.debug("Request to get IntegralLogs : {}", id);
        return integralLogsRepository.findById(id)
            .map(integralLogsMapper::toDto);
    }

    /**
     * Delete the integralLogs by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IntegralLogs : {}", id);
        integralLogsRepository.deleteById(id);
    }
}
