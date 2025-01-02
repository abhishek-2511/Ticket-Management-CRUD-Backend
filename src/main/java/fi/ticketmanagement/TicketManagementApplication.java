package fi.ticketmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"fi.ticketmanagement.controllers", "fi.ticketmanagement.services", "fi.ticketmanagement.exceptions"})
@EntityScan(basePackages = {"fi.ticketmanagement.entity"})
@EnableJpaRepositories(basePackages = {"fi.ticketmanagement.repositories"})
public class TicketManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketManagementApplication.class, args);
	}
}
