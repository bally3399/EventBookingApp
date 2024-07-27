package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.AddTicketRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ReserveTicketForEventRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ReserveTicketForEventResponse;
import africa.semicolon.com.eventBookingApp.model.TicketStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static africa.semicolon.com.eventBookingApp.model.Type.*;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class TicketServiceImplTest {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private EventService eventService;
    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void addTicketTest() {
        AddTicketRequest addTicketRequest = new AddTicketRequest();
        addTicketRequest.setTicketType(VIP);
        addTicketRequest.setId(300L);
        addTicketRequest.setEventId(100L);
        addTicketRequest.setOrganizerId(201L);
        addTicketRequest.setPrice(BigDecimal.valueOf(2000.00));
        addTicketRequest.setDiscount(BigDecimal.valueOf(200.00));
        AddTicketResponse addTicketResponse = ticketService.addTicket(addTicketRequest);
        assertThat(addTicketResponse).isNotNull();
        assertThat(addTicketResponse.getMessage()).isEqualTo("Ticket added successfully");
    }

}