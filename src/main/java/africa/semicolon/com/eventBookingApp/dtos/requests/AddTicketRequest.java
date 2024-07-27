package africa.semicolon.com.eventBookingApp.dtos.requests;

import africa.semicolon.com.eventBookingApp.model.Type;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddTicketRequest {
    private Long id;
    private Type ticketType;
    private Long eventId;
    private BigDecimal price;
    private BigDecimal discount;
    private Long organizerId;
}
