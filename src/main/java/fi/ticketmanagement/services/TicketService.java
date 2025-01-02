package fi.ticketmanagement.services;

import java.util.List;

import fi.ticketmanagement.dto.TicketDTO;

public interface TicketService {
	
	public String createTicket(TicketDTO dto);
	public TicketDTO getTicketById(int id);
	public String updateTicket(int id);
	public List<TicketDTO> getAllOpenTickets();
	public String deleteTicket(int id);
	public List<TicketDTO> getAllTickets();
}
