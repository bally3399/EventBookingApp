package africa.semicolon.com.eventBookingApp.dtos.requests;

import africa.semicolon.com.eventBookingApp.model.TicketStatus;
import africa.semicolon.com.eventBookingApp.model.Type;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReserveTicketForEventRequest {
    private Long ticketId;
    private Long eventId;
    private Type ticketType;
    private TicketStatus status;

}
