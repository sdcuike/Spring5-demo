package org.sdcuike.demo.airline.service.impl;

import org.sdcuike.demo.airline.domain.AirlineCompanyEnum;
import org.sdcuike.demo.airline.domain.dto.BookOrder2RequestDto;
import org.sdcuike.demo.airline.domain.dto.BookOrderResponseDto;
import org.sdcuike.demo.airline.domain.dto.FlightInfo2Dto;
import org.sdcuike.demo.airline.domain.dto.SearchFlightRequestDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beaver on 2017/7/18.
 */
@Service
class SpringairlineServiceImpl implements AirlineCompanyService {
    
    private final AirlineCompanyEnum SpringairlineCompany = AirlineCompanyEnum.SPRINGAIRLINE;
    
    @Override
    public AirlineCompanyEnum getCompany() {
        return SpringairlineCompany;
    }
    
    @Override
    public List<FlightInfo2Dto> searchFlights(SearchFlightRequestDto requestDto) {
        //TODO:
        return new ArrayList<>();
    }
    
    @Override
    public BookOrderResponseDto bookOrder(BookOrder2RequestDto bookOrderRequestDto) {
        
        //demo
        return new BookOrderResponseDto();
    }
}
