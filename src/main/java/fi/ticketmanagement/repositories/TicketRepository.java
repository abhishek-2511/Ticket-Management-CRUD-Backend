package fi.ticketmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fi.ticketmanagement.dto.TicketDTO;
import fi.ticketmanagement.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query("Select entTicket from Ticket entTicket where entTicket.status='OPEN'")
	public List<Ticket> findAllOpenTickets();
}
