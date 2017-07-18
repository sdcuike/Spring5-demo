package org.sdcuike.demo.airline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sdcuike.demo.airline.domain.AirlineCompanyEnum;
import org.sdcuike.demo.airline.domain.dto.BookOrder2RequestDto;
import org.sdcuike.demo.airline.domain.dto.BookOrderResponseDto;
import org.sdcuike.demo.airline.domain.dto.FlightInfo2Dto;
import org.sdcuike.demo.airline.domain.dto.SearchFlightRequestDto;
import org.sdcuike.demo.airline.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by beaver on 2017/7/18.
 * 票台接口实现，委托给具体航空公司处理
 * <p>
 * <p>
 * spring set方法注入示例
 */
@Service("airlineService")
@Slf4j
public class AirlineServiceImpl implements AirlineService {
    private Map<AirlineCompanyEnum, AirlineCompanyService> airlineCompanyServiceMap;
    
    @Autowired
    public void setAirlineCompanyService(final List<AirlineCompanyService> airlineCompanyServices) {
        airlineCompanyServiceMap = airlineCompanyServices
                .stream()
                .collect(toMap(t -> t.getCompany(), t -> t));
        
    }
    
    @Override
    public List<FlightInfo2Dto> searchFlights(SearchFlightRequestDto requestDto) {
        //http://fahdshariff.blogspot.com/2016/06/java-8-completablefuture-vs-parallel.html?spref=tw
        final List<CompletableFuture<List<FlightInfo2Dto>>> futureList = airlineCompanyServiceMap
                .values().stream()
                .map(t -> CompletableFuture.<List<FlightInfo2Dto>>supplyAsync(() -> {
                            {
                                try {
                                    return t.searchFlights(requestDto);
                                } catch (Exception e) {
                                    log.error("searchFlights error", e);
                                }
                                
                                return new ArrayList<>();
                            }
                        })
                
                ).collect(toList());
        
        List<List<FlightInfo2Dto>> result = futureList.stream()
                                                      .map(CompletableFuture::join)
                                                      .collect(toList());
        
        
        return result.stream().flatMap(t -> t.stream()).collect(toList());
    }
    
    @Override
    public BookOrderResponseDto bookOrder(BookOrder2RequestDto bookOrderRequestDto) {
        final AirlineCompanyService airlineCompanyService = airlineCompanyServiceMap.get(bookOrderRequestDto.getAirlineCompany());
        return airlineCompanyService.bookOrder(bookOrderRequestDto);
    }
}
