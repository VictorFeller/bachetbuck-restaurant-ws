package ch.heg.ig.BachEtBuck.services;

import ch.heg.ig.BachEtBuck.business.Ticket;
import ch.heg.ig.BachEtBuck.business.Tickets;
import ch.heg.ig.BachEtBuck.owner.Owner;
import ch.heg.ig.BachEtBuck.persistance.TicketRepository;
import ch.heg.ig.BachEtBuck.vet.Vets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Feller
 */
@RestController
public class TicketController {

	private final TicketRepository ticketRepository;

	public TicketController(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@GetMapping("ticket")
	public Ticket findTicket(@PathVariable(name = "ticketId", required = true) @RequestParam Integer ticketId) {
		return ticketId == null ? new Ticket() : this.ticketRepository.findById(ticketId);
	}

	@GetMapping("/tickets/all")
	public List<Ticket> showTickets() {
		Tickets tickets = new Tickets();
		tickets.getTicketList().addAll(this.ticketRepository.findAll());
		return tickets.getTicketList();
	}

}
