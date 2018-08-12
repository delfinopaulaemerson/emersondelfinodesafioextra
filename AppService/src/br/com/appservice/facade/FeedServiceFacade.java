package br.com.appservice.facade;

import org.springframework.stereotype.Component;

@Component("feedServiceFacade")
public interface FeedServiceFacade {
	
	
	public String contentFeed()throws Exception;

}
