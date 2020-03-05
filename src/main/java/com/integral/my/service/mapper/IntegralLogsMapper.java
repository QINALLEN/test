package com.integral.my.service.mapper;


import com.integral.my.domain.*;
import com.integral.my.service.dto.IntegralLogsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IntegralLogs} and its DTO {@link IntegralLogsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IntegralLogsMapper extends EntityMapper<IntegralLogsDTO, IntegralLogs> {



    default IntegralLogs fromId(Long id) {
        if (id == null) {
            return null;
        }
        IntegralLogs integralLogs = new IntegralLogs();
        integralLogs.setId(id);
        return integralLogs;
    }
}
