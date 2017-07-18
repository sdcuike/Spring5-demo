package org.sdcuike.demo.airline.service;

import org.sdcuike.demo.airline.domain.dto.BookOrder2RequestDto;
import org.sdcuike.demo.airline.domain.dto.BookOrderResponseDto;
import org.sdcuike.demo.airline.domain.dto.FlightInfo2Dto;
import org.sdcuike.demo.airline.domain.dto.SearchFlightRequestDto;

import java.util.List;

/**
 * Created by beaver on 2017/7/18.
 * <p>
 * 票台接口
 */
public interface AirlineService {
    
    /**
     * 查询航班：查询所有航空公司的航班信息
     *
     * @param requestDto
     * @return
     */
    List<FlightInfo2Dto> searchFlights(SearchFlightRequestDto requestDto);
    
    /**
     * 预定订单
     *
     * @param bookOrderRequestDto
     * @return
     */
    BookOrderResponseDto bookOrder(BookOrder2RequestDto bookOrderRequestDto);
    
}
