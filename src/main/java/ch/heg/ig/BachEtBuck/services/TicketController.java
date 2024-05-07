package ch.heg.ig.BachEtBuck.services;

import ch.heg.ig.BachEtBuck.business.Ticket;
import ch.heg.ig.BachEtBuck.persistance.TicketRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("ticket/{ticketId}")
	public ResponseEntity<?> findTicket(@PathVariable(name = "ticketId", required = false) Integer ticketId) {
		try {
			Ticket ticket = this.ticketRepository.findById(ticketId);
			if (ticket == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Aucun ticket trouvé pour l'id : " + ticketId);
			}
			return ResponseEntity.ok(ticket);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erreur lors de la récupération du ticket : " + e.getMessage());
		}
	}

	@GetMapping("ticket")
	public ResponseEntity<?> findByPurchaseDate(@RequestParam String purchaseDate) {
		try {
			List<Ticket> tickets= this.ticketRepository.findByPurchaseDate(purchaseDate);
			if (tickets.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Aucun ticket trouvé pour la date donnée : " + purchaseDate);
			}
			return ResponseEntity.ok(tickets);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erreur lors de la récupération des tickets : " + e.getMessage());
		}
	}

	@GetMapping("/tickets/all")
	public ResponseEntity<?>showTickets() {
		try {
			List<Ticket> tickets = this.ticketRepository.findAll();
			if (tickets.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Aucun ticket trouvé");
			}
			return ResponseEntity.ok(tickets);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Erreur lors de la récupération des tickets : " + e.getMessage());
		}
	}

}
