package org.sdcuike.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by beaver on 2017/7/17.
 */
@Configuration
public class DemoConfig {
    
    @Bean("integer1")
    public Integer integer1() {
        return 1;
    }
    
    @Bean("integer2")
    public Integer integer2() {
        return 2;
    }
}
