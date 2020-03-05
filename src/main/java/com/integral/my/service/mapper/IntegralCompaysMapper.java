package com.integral.my.service.mapper;


import com.integral.my.domain.*;
import com.integral.my.service.dto.IntegralCompaysDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IntegralCompays} and its DTO {@link IntegralCompaysDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IntegralCompaysMapper extends EntityMapper<IntegralCompaysDTO, IntegralCompays> {



    default IntegralCompays fromId(Long id) {
        if (id == null) {
            return null;
        }
        IntegralCompays integralCompays = new IntegralCompays();
        integralCompays.setId(id);
        return integralCompays;
    }
}
