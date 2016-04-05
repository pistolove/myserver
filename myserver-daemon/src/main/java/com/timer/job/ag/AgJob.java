package com.timer.job.ag;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.timer.modules.ag.service.AgService;

@Component("AgJob")
public class AgJob {
    private static final Logger logger = LoggerFactory.getLogger(AgJob.class);
    
    @Resource
    private AgService agService;
    
    public void getAg(){
        this.logger.info("start get ag info");
        agService.getAG();
        this.logger.info("end get ag info");
    }
}
