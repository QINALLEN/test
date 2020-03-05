package com.integral.my.service.impl;

import com.integral.my.service.IntegralCompaysService;
import com.integral.my.domain.IntegralCompays;
import com.integral.my.repository.IntegralCompaysRepository;
import com.integral.my.service.dto.IntegralCompaysDTO;
import com.integral.my.service.mapper.IntegralCompaysMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link IntegralCompays}.
 */
@Service
@Transactional
public class IntegralCompaysServiceImpl implements IntegralCompaysService {

    private final Logger log = LoggerFactory.getLogger(IntegralCompaysServiceImpl.class);

    private final IntegralCompaysRepository integralCompaysRepository;

    private final IntegralCompaysMapper integralCompaysMapper;

    public IntegralCompaysServiceImpl(IntegralCompaysRepository integralCompaysRepository, IntegralCompaysMapper integralCompaysMapper) {
        this.integralCompaysRepository = integralCompaysRepository;
        this.integralCompaysMapper = integralCompaysMapper;
    }

    /**
     * Save a integralCompays.
     *
     * @param integralCompaysDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public synchronized IntegralCompaysDTO save(IntegralCompaysDTO integralCompaysDTO) {
        log.debug("Request to save IntegralCompays : {}", integralCompaysDTO);
        IntegralCompays integralCompays = integralCompaysMapper.toEntity(integralCompaysDTO);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        integralCompays.setCompanyUuid(uuid);
        integralCompays.setCreateTime(new Date());

        integralCompays = integralCompaysRepository.save(integralCompays);
        return integralCompaysMapper.toDto(integralCompays);
    }

    @Override
    public IntegralCompaysDTO update(IntegralCompaysDTO integralCompaysDTO) {
        log.debug("Request to update IntegralCompays : {}", integralCompaysDTO);
        IntegralCompays integralCompays = integralCompaysMapper.toEntity(integralCompaysDTO);
        integralCompays = integralCompaysRepository.save(integralCompays);
        return integralCompaysMapper.toDto(integralCompays);
    }

    /**
     * Get all the integralCompays.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<IntegralCompaysDTO> findAll(String key,Pageable pageable) {
        log.debug("Request to get all IntegralCompays");
        if (key==null){
            key="";
        }
        Page<IntegralCompays> page = integralCompaysRepository.findAllByCompanyNameLikeOrderByIntegtalValueDesc("%"+key+"%", pageable);
        if (page.getContent().size()==0){
            return Page.empty();
        }
        return page.map(integralCompaysMapper::toDto).map((m) -> {
            IntegralCompays integralCompays = integralCompaysRepository.findById(m.getId()).get();
            Integer l = integralCompaysRepository.countAllByIntegtalValueGreaterThanOrIntegtalValueEqualsAndIdLessThan(integralCompays.getIntegtalValue(), integralCompays.getIntegtalValue(), integralCompays.getId());
            m.setRanking(l + 1);
            return m;
        });
    }

    /**
     * Get one integralCompays by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IntegralCompaysDTO> findOne(Long id) {
        log.debug("Request to get IntegralCompays : {}", id);
        return integralCompaysRepository.findById(id)
            .map(integralCompaysMapper::toDto);
    }

    /**
     * Delete the integralCompays by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IntegralCompays : {}", id);
        integralCompaysRepository.deleteById(id);
    }

    @Override
    public IntegralCompays findByCompanyIdAndType(Integer companyId, Integer type) {
        return integralCompaysRepository.findByCompanyIdAndType(companyId,type);
    }
}
