package ch.heg.ig.BachEtBuck.services;

import ch.heg.ig.BachEtBuck.business.Ticket;
import ch.heg.ig.BachEtBuck.owner.Owner;
import ch.heg.ig.BachEtBuck.owner.OwnerRepository;
import ch.heg.ig.BachEtBuck.persistance.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Victor Feller
 */
@Controller
public class TicketController {

	public TicketController(TicketRepository ticket) {
		this.ticket = ticket;
	}

	private final TicketRepository ticket;

	@GetMapping("/tickets/{ticketId}")
	public ModelAndView showTicket(@PathVariable("ticketId") int ticketId) {
		ModelAndView mav = new ModelAndView("tickets/ticketsDetails");
		Ticket ticket = this.ticket.findById(ticketId);
		mav.addObject(ticket);
		// Owner owner = this.owners.findById(ownerId);
		// mav.addObject(owner);
		return mav;
	}

}
