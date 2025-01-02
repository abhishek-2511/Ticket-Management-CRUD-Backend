package fi.ticketmanagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fi.ticketmanagement.dto.TicketDTO;
import fi.ticketmanagement.entity.Ticket;
import fi.ticketmanagement.exceptions.TicketNotFoundException;
import fi.ticketmanagement.repositories.TicketRepository;

@Service
public class TicketServiceImplementation implements TicketService {
	
	@Autowired
	TicketRepository repository;
	
	@Override
	public String createTicket(TicketDTO dto) {
		// TODO Auto-generated method stub
		
		try {
			Ticket entityTicket = new Ticket();
			
			BeanUtils.copyProperties(dto, entityTicket);
			
			repository.save(entityTicket);
			
			return "New Ticket Created SuccessFully.....";
		} 
		catch (BeansException e) {
			// TODO Auto-generated catch block
			
			throw new RuntimeException("Error creating ticket : " + e.getMessage());
		}
	}

	@Override
	public TicketDTO getTicketById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Ticket> optTicket =  repository.findById(id);
		
		if(optTicket.isPresent()) {
			
			Ticket entTicket = optTicket.get();
			
			TicketDTO dto = new TicketDTO();
			
			BeanUtils.copyProperties(entTicket, dto);
			
			return dto;
		}
		else {
			throw new TicketNotFoundException("Ticket not Found with ID : " + id);
		}
	}

	@Override
	public String updateTicket(int id) {
		// TODO Auto-generated method stub
		
	    // Find the ticket in the repository
	    Optional<Ticket> optTicket = repository.findById(id);
	    
	    // Check if the ticket exists
	    if (optTicket.isPresent()) {
	        // Get the existing ticket entity
	        Ticket existingTicket = optTicket.get();
	        
	        TicketDTO dto = new TicketDTO();

	        // Copy properties from DTO to the entity
	        BeanUtils.copyProperties(existingTicket, dto);

	        // Save the updated ticket back to the database
	        repository.save(existingTicket);

	        // Return a success message
	        return "Ticket updated successfully";
	    } else {
	        // If ticket is not found, return a failure message
	        throw new TicketNotFoundException("Ticket not found with ID : " + id);
	    }
	}

	public List<TicketDTO> getAllOpenTickets() {
		// TODO Auto-generated method stub
		
		try {
			List<Ticket> ticketList = repository.findAllOpenTickets();
			
			List<TicketDTO> result = new ArrayList<>();
			
			for(Ticket entTicket : ticketList) {
				
				TicketDTO dto = new TicketDTO();
				
				BeanUtils.copyProperties(entTicket, dto);
				
				result.add(dto);
			}
			
			return result;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Error Fetching Open Tickets : " + e.getMessage());
		}
	}

	@Override
	public String deleteTicket(int id) {
		// TODO Auto-generated method stub
		
		if(repository.existsById(id)) {
			
			repository.deleteById(id);
			
			return "Delete successfull Ticket id :" + id;
		}
		else {
			
			throw new TicketNotFoundException("Ticket not Found with ID : " + id);
		}
	}

	@Override
	public List<TicketDTO> getAllTickets() {
		// TODO Auto-generated method stub
		
		try {
			List<Ticket> list = repository.findAll();
			
			List<TicketDTO> result = new ArrayList<>();
			
			for(Ticket entTicket : list) {
				
				TicketDTO dto = new TicketDTO();
				
				BeanUtils.copyProperties(entTicket, dto);
				
				result.add(dto);
			}
			return result;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("No Tickets Found : " + e.getMessage());
		}
	}
	
}
