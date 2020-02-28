package com.integral.my.service.impl;

import com.integral.my.domain.Inte_companys;
import com.integral.my.domain.Inte_log;
import com.integral.my.service.Inte_companysService;
import com.integral.my.service.Inte_detailService;
import com.integral.my.domain.Inte_detail;
import com.integral.my.repository.Inte_detailRepository;
import com.integral.my.service.Inte_logService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Inte_detail}.
 */
@Service
@Transactional
public class Inte_detailServiceImpl implements Inte_detailService {

    private final Logger log = LoggerFactory.getLogger(Inte_detailServiceImpl.class);

    private final Inte_detailRepository inte_detailRepository;

    @Autowired
    private Inte_logService inte_logService;

    @Autowired
    private Inte_companysService inte_companysService;

    public Inte_detailServiceImpl(Inte_detailRepository inte_detailRepository) {
        this.inte_detailRepository = inte_detailRepository;
    }

    /**
     * Save a inte_detail.
     *
     * @param inte_detail the entity to save.
     * @return the persisted entity.
     */
    @Override
    public synchronized Inte_detail save(Inte_detail inte_detail) {
        log.debug("Request to save Inte_detail : {}", inte_detail);

        Inte_companys inte_companys=inte_companysService.findByCompanyIdAndType(inte_detail.getCompanyId(),inte_detail.getType());
        if (inte_companys==null){
            inte_companys=new Inte_companys();
            inte_companys.setCompanyId(inte_detail.getCompanyId());
            inte_companys.setCompanyName(inte_detail.getCompanyName());
            inte_companys.setIntegralValue(inte_detail.getRewardValue());
            inte_companys.setType(inte_detail.getType());
        }else {
            inte_companys.setIntegralValue(inte_companys.getIntegralValue()+inte_detail.getRewardValue());
        }
        Inte_companys save = inte_companysService.save(inte_companys);

        Inte_log inte_log = new Inte_log();
        inte_log.setAction("存入交易明细");
        inte_log.setCompany(inte_detail.getCompanyId());
        inte_log.setRequest(inte_detail.toString());

        return inte_detailRepository.save(inte_detail);
    }

    /**
     * Get all the inte_details.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Inte_detail> findAll(Pageable pageable) {
        log.debug("Request to get all Inte_details");
        return inte_detailRepository.findAll(pageable);
    }

    /**
     * Get one inte_detail by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Inte_detail> findOne(Long id) {
        log.debug("Request to get Inte_detail : {}", id);
        return inte_detailRepository.findById(id);
    }

    /**
     * Delete the inte_detail by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Inte_detail : {}", id);
        inte_detailRepository.deleteById(id);
    }
}
