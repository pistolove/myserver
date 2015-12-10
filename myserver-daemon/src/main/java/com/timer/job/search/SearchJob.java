package com.timer.job.search;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.timer.modules.search.service.SearchService;

@Component("searchJob")
public class SearchJob {
	private final static Logger log = LoggerFactory.getLogger(SearchJob.class);
	
	@Resource
	private SearchService searchService;
	
	public void search(){
		log.info("start search");
		searchService.getSearhData();
		log.info("end search");
	}
}
