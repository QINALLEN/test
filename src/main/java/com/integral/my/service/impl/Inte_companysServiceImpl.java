package com.integral.my.service.impl;

import com.integral.my.service.Inte_companysService;
import com.integral.my.domain.Inte_companys;
import com.integral.my.repository.Inte_companysRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Service Implementation for managing {@link Inte_companys}.
 */
@Service
@Transactional
public class Inte_companysServiceImpl implements Inte_companysService {

    private final Logger log = LoggerFactory.getLogger(Inte_companysServiceImpl.class);

    private final Inte_companysRepository inte_companysRepository;

    public Inte_companysServiceImpl(Inte_companysRepository inte_companysRepository) {
        this.inte_companysRepository = inte_companysRepository;
    }

    /**
     * Save a inte_companys.
     *
     * @param inte_companys the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Inte_companys save(Inte_companys inte_companys) {
        log.debug("Request to save Inte_companys : {}", inte_companys);
        if (inte_companys.getCompanyUUID()==null||"".equals(inte_companys.getCompanyUUID())){
            inte_companys.setCompanyUUID(UUID.randomUUID().toString().replaceAll("-",""));
        }
        if (inte_companys.getCreateTime()==null){
        }
        return inte_companysRepository.save(inte_companys);
    }

    /**
     * Get all the inte_companys.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Inte_companys> findAll(Pageable pageable) {
        log.debug("Request to get all Inte_companys");
        return inte_companysRepository.findAll(pageable);
    }

    /**
     * Get one inte_companys by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Inte_companys> findOne(Long id) {
        log.debug("Request to get Inte_companys : {}", id);
        return inte_companysRepository.findById(id);
    }

    /**
     * Delete the inte_companys by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Inte_companys : {}", id);
        inte_companysRepository.deleteById(id);
    }

    @Override
    public Inte_companys findByCompanyIdAndType(Integer companyId, Integer type) {
        return inte_companysRepository.findByCompanyIdAndType(companyId,type);
    }
}
