package org.sdcuike.demo.airline.service.impl;

import org.sdcuike.demo.airline.domain.AirlineCompanyEnum;
import org.sdcuike.demo.airline.service.AirlineService;

/**
 * Created by beaver on 2017/7/18.
 * <p>
 * 各家航空公司票台接口
 */
interface AirlineCompanyService extends AirlineService {
    
    /**
     * 获取航空公司
     *
     * @return
     */
    AirlineCompanyEnum getCompany();
}
