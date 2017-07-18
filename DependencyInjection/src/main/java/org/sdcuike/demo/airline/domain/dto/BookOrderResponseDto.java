package org.sdcuike.demo.airline.domain.dto;

import lombok.Data;
import org.sdcuike.demo.airline.domain.AirlineCompanyEnum;

/**
 * Created by beaver on 2017/7/18.
 */
@Data
public class BookOrderResponseDto {
    /**
     * 航司
     */
    private AirlineCompanyEnum airlineCompany = AirlineCompanyEnum.SPRINGAIRLINE;
    
    
}
