package com.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class MyConfiguration {
	
	@Bean
	public ModelAndView mdlView(){
		return new ModelAndView();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
