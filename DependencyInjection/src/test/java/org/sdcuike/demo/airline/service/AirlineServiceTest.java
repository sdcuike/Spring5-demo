package org.sdcuike.demo.airline.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sdcuike.demo.Boot;
import org.sdcuike.demo.airline.domain.dto.FlightInfo2Dto;
import org.sdcuike.demo.airline.domain.dto.SearchFlightRequestDto;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by beaver on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Boot.class)
public class AirlineServiceTest {
    
    @Resource(name = "airlineService")
    private AirlineService airlineService;
    
    @Test
    public void test_searchFlights() {
        SearchFlightRequestDto requestDto = new SearchFlightRequestDto();
        final List<FlightInfo2Dto> flightInfo2Dtos = airlineService.searchFlights(requestDto);
        System.out.println(flightInfo2Dtos);
    }
}
