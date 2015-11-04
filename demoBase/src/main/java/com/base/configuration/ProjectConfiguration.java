package com.base.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.base.dao.AbstractDao;
import com.base.dao.city.CityDao;
import com.base.dao.city.CityDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.base")
public class ProjectConfiguration {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/world");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	
	
	@Bean
	public AbstractDao getAbstractDao() {
		return new AbstractDao(getDataSource());
	}
	@Bean
	public CityDao fooService() {
        return new CityDaoImpl(getAbstractDao());
    }
}
