package com.integral.my.service.impl;

import com.integral.my.domain.IntegralCompays;
import com.integral.my.service.IntegralCompaysService;
import com.integral.my.service.IntegralDetailsService;
import com.integral.my.domain.IntegralDetails;
import com.integral.my.repository.IntegralDetailsRepository;
import com.integral.my.service.IntegralLogsService;
import com.integral.my.service.dto.*;
import com.integral.my.service.mapper.IntegralCompaysMapper;
import com.integral.my.service.mapper.IntegralDetailsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * Service Implementation for managing {@link IntegralDetails}.
 */
@Service
@Transactional
public class IntegralDetailsServiceImpl implements IntegralDetailsService {

    private final Logger log = LoggerFactory.getLogger(IntegralDetailsServiceImpl.class);

    private final IntegralDetailsRepository integralDetailsRepository;

    private final IntegralDetailsMapper integralDetailsMapper;

    @Autowired
    private IntegralCompaysService integralCompaysService;

    @Autowired
    private IntegralCompaysMapper integralCompaysMapper;

    @Autowired
    private IntegralLogsService integralLogsService;

    public IntegralDetailsServiceImpl(IntegralDetailsRepository integralDetailsRepository, IntegralDetailsMapper integralDetailsMapper) {
        this.integralDetailsRepository = integralDetailsRepository;
        this.integralDetailsMapper = integralDetailsMapper;
    }

    /**
     * Save a integralDetails.
     *
     * @param integralDetailsDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ResultView save(IntegralDetailsDTO integralDetailsDTO) {
        log.debug("Request to save IntegralDetails : {}", integralDetailsDTO);
        IntegralDetails have = integralDetailsRepository.findByCompanyIdAndTypeAndTenderCodeAndSource(integralDetailsDTO.getCompanyId(),integralDetailsDTO.getType(),integralDetailsDTO.getTenderCode(),integralDetailsDTO.getSource());
        if (have!=null){
            return new ResultView<String>("提交成功");
        }

        IntegralDetails integralDetails = integralDetailsMapper.toEntity(integralDetailsDTO);

        IntegralCompays integralCompays = integralCompaysService.findByCompanyIdAndType(integralDetails.getCompanyId(),integralDetails.getType());
        IntegralCompaysDTO save=null;
        if (integralCompays==null){
            integralCompays = new IntegralCompays();
            integralCompays.setCompanyId(integralDetails.getCompanyId());
            integralCompays.setCompanyName(integralDetails.getCompanyName());
            integralCompays.setSort(integralDetails.getSort());
            integralCompays.setType(integralDetails.getType());
            integralCompays.setIntegtalValue(integralDetails.getRewardValue());
            IntegralCompaysDTO integralCompaysDTO = integralCompaysMapper.toDto(integralCompays);
            save = integralCompaysService.save(integralCompaysDTO);
        }else {
            integralCompays.setIntegtalValue(integralCompays.getIntegtalValue()+integralDetails.getRewardValue());
            IntegralCompaysDTO integralCompaysDTO = integralCompaysMapper.toDto(integralCompays);
            save = integralCompaysService.update(integralCompaysDTO);
        }

        IntegralLogsDTO integralLogsDTO = new IntegralLogsDTO();
        integralLogsDTO.setAction("提交善建值");
        integralLogsDTO.setCompanyUuid(save.getCompanyUuid());
        integralLogsDTO.setRequest(integralDetailsDTO.toString());
        integralLogsDTO.setIsSuccess(0);

        integralLogsService.save(integralLogsDTO);

        integralDetails.setHaveInte(integralCompays.getIntegtalValue());
        integralDetails.setCompanyUuid(save.getCompanyUuid());
        integralDetails.setRewardDate(new Date());
        integralDetails = integralDetailsRepository.save(integralDetails);
        return new ResultView("提交成功");
    }

    /**
     * Get all the integralDetails.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public ResultView findAll(String viewerId, Integer type, Pageable pageable) {
        log.debug("Request to get all IntegralDetails");
        IntegralCompays integralCompays = integralCompaysService.findByCompanyIdAndType(Integer.parseInt(viewerId), type);
        Page<IntegralDetailsDTO> map = integralDetailsRepository.findAllByCompanyUuidOrderBySortDesc(integralCompays.getCompanyUuid(), pageable).map(integralDetailsMapper::toDto);
        return new ResultView<ReturnDetails>(new ReturnDetails(integralCompays.getIntegtalValue(),map.getContent(),map.getTotalPages(),(int)map.getTotalElements()));
    }

    /**
     * Get one integralDetails by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<IntegralDetailsDTO> findOne(Long id) {
        log.debug("Request to get IntegralDetails : {}", id);
        return integralDetailsRepository.findById(id)
            .map(integralDetailsMapper::toDto);
    }

    /**
     * Delete the integralDetails by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete IntegralDetails : {}", id);
        integralDetailsRepository.deleteById(id);
    }
}
