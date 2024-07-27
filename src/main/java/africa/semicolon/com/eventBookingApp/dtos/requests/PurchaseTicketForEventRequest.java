package africa.semicolon.com.eventBookingApp.dtos.requests;

import africa.semicolon.com.eventBookingApp.model.TicketStatus;
import africa.semicolon.com.eventBookingApp.model.Type;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseTicketForEventRequest {
    private Long eventId;
    private Long ticketId;
    private TicketStatus status;
    private Type ticketType;
}
