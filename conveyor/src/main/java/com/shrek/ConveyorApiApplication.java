package com.shrek;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude= {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class,
		AutoConfigureJdbc.class,
		FlywayAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class,
		LiquibaseAutoConfiguration.class,
		LiquibaseDataSource.class
})*/

public class ConveyorApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConveyorApiApplication.class, args);
	}

}
