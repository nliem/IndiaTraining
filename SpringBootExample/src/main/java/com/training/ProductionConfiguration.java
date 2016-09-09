package com.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProductionConfiguration {
	
	@Bean
	public MyDataSource productionDb(){
		
		return new MyDataSource("OracleDriver", "jdbc:oracle:@localhost:thing:1521");
		
	}

}
