package africa.semicolon.com.eventBookingApp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long ticket_id;
    private BigDecimal price;
    private BigDecimal discount;
    @Enumerated(value = EnumType.STRING)
    private Type ticketType;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
}
