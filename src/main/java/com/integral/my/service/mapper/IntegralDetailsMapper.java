package com.integral.my.service.mapper;


import com.integral.my.domain.*;
import com.integral.my.service.dto.IntegralDetailsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link IntegralDetails} and its DTO {@link IntegralDetailsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface IntegralDetailsMapper extends EntityMapper<IntegralDetailsDTO, IntegralDetails> {



    default IntegralDetails fromId(Long id) {
        if (id == null) {
            return null;
        }
        IntegralDetails integralDetails = new IntegralDetails();
        integralDetails.setId(id);
        return integralDetails;
    }
}
