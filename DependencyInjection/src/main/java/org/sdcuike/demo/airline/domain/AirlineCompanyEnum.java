package org.sdcuike.demo.airline.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by beaver on 2017/7/18.
 * <p>
 * 航空公司列表
 * </p>
 */
@Getter
@AllArgsConstructor
@ToString
public enum AirlineCompanyEnum {
    /**
     * 春秋，id=1
     */
    SPRINGAIRLINE(1, "春秋航空", true);
    
    /**
     * 航空ID标识
     */
    private Integer airlineCompanyId;
    
    /**
     * 航司名称
     */
    private String name;
    
    /**
     * 启用（目前没用途)
     */
    private boolean enable = true;
    
    
    public static AirlineCompanyEnum of(Integer airlineCompanyId) {
        return airlineCompanyID2Enum.get(airlineCompanyId);
    }
    
    private static Map<Integer, AirlineCompanyEnum> airlineCompanyID2Enum = new HashMap<>();
    
    static {
        for (AirlineCompanyEnum e : AirlineCompanyEnum.values()) {
            airlineCompanyID2Enum.put(e.getAirlineCompanyId(), e);
        }
    }
}
