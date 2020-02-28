package com.integral.my.service;

import com.integral.my.domain.Inte_log;

import java.util.List;
import java.util.Optional;

public interface Inte_logService {
    Inte_log save(Inte_log inte_log);
    List<Inte_log> findAll();
    Optional<Inte_log> findOne(Long id);
    void delete(Long id);
}
