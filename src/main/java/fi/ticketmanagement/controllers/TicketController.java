package fi.ticketmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.ticketmanagement.dto.TicketDTO;
import fi.ticketmanagement.repositories.TicketRepository;
import fi.ticketmanagement.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService service;
	
	@Autowired
	TicketRepository repository;
	
	
	@PostMapping("/createTicket")
	public String createTicket(@RequestBody TicketDTO dto) {
		
		return service.createTicket(dto);
	}
	
	@PutMapping("/updateTicket/{id}")
	public String update(@PathVariable("id") int ticketId) {
		
		return service.updateTicket(ticketId);
	}
	
	
	@GetMapping("/allOpenTickets")
	public List<TicketDTO> openTickets(){
		return service.getAllOpenTickets();
	}
	
	@GetMapping("/getById/{id}")
	public TicketDTO getTicketByID(@PathVariable("id") int ticketId) {
		
		return service.getTicketById(ticketId);
	}
	
	@DeleteMapping("/deleteTicketById/{id}")
	public String deleteTicket(@PathVariable("id") int ticketId) {
		
		return service.deleteTicket(ticketId);
	}
	
	@GetMapping("/getAllTickets")
	public List<TicketDTO> allTickets(){
		
		return service.getAllTickets();
	}
}
