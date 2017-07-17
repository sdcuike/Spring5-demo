package org.sdcuike.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sdcuike.demo.manager.DemoManager;
import org.sdcuike.demo.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by beaver on 2017/7/17.
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {
    
    @Autowired
    private DemoManager demoManager;
    
    //@Autowired
    //@Qualifier("integer1")
    @Resource(name = "integer1")
    private Integer integer;
    
    @PostConstruct
    public void init() {
        log.info("set注入的类{},{}", demoManager, integer);
        
    }
    
}
