package africa.semicolon.com.eventBookingApp.repository;

import africa.semicolon.com.eventBookingApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
         @Query("SELECT t From Ticket t where t.ticket_id =:ticketId")
         Ticket findTicketById(Long ticketId);
}
