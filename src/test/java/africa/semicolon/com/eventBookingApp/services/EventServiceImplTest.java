package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.*;
import africa.semicolon.com.eventBookingApp.dtos.response.*;
import africa.semicolon.com.eventBookingApp.model.Event;
import africa.semicolon.com.eventBookingApp.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static africa.semicolon.com.eventBookingApp.model.TicketStatus.*;
import static africa.semicolon.com.eventBookingApp.model.Type.VIP;
import static africa.semicolon.com.eventBookingApp.model.Type.VVIP;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class EventServiceImplTest {
    @Autowired
    private EventService eventService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AttendeeService attendeeService;

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void createEventTest(){
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setEventName("Wedding");
        createEventRequest.setLocation("New York");
        createEventRequest.setDescription("Celebrating wedding event on saturday");
        createEventRequest.setOrganizerId(200L);
        createEventRequest.setEventDate(LocalDateTime.now());
        CreateEventResponse response = eventService.createEvent(createEventRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Event created successfully");
 }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void addTicketToEventTest(){
        Event event = eventService.getEventWith(100L);
        assertThat(event).isNotNull();
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

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void viewEventAttendee(){
        Event event = eventService.getEventWith(101L);
        assertThat(event).isNotNull();

        CreateAttendeeRequest createAttendeeRequest = new CreateAttendeeRequest();
        createAttendeeRequest.setFirstName("jane");
        createAttendeeRequest.setLastName("doe");
        createAttendeeRequest.setEmail("jane@doe.com");
        createAttendeeRequest.setOrganizerId(201L);
        createAttendeeRequest.setEventId(101L);
        createAttendeeRequest.setId(2L);
        attendeeService.createAttendee(createAttendeeRequest);

        ViewAttendeeRequest viewAttendeeRequest = new ViewAttendeeRequest();
        viewAttendeeRequest.setId(2L);
        viewAttendeeRequest.setEventId(101L);
        viewAttendeeRequest.setOrganizerId(201L);
        ViewAttendeeResponse viewAttendeeResponse = attendeeService.attendeesView(viewAttendeeRequest);
        assertThat(viewAttendeeResponse).isNotNull();
        assertThat(viewAttendeeResponse.getMessage()).isEqualTo("successful");
    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void reserveTicketForEvent(){
        ReserveTicketForEventRequest reserveTicket = new ReserveTicketForEventRequest();
        reserveTicket.setEventId(100L);
        reserveTicket.setTicketId(303L);
        reserveTicket.setTicketType(VVIP);
        reserveTicket.setStatus(RESERVED);
        ReserveTicketForEventResponse response = eventService.reserveTicket(reserveTicket);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Ticket reserved successfully");
    }
    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void purchaseTicketForEvent(){
        PurchaseTicketForEventRequest purchaseTicket = new PurchaseTicketForEventRequest();
        purchaseTicket.setEventId(100L);
        purchaseTicket.setTicketType(VVIP);
        purchaseTicket.setStatus(PURCHASED);
        purchaseTicket.setTicketId(303L);
        PurchaseTicketForEventResponse response = eventService.purchaseTicket(purchaseTicket);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Ticket purchased successfully");

    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void viewAllEventForAnOrganizerTest(){
        List<Event> events  = eventService.viewAllEvent(200L);
        assertThat(events).isNotNull();
        assertThat(events.size()).isEqualTo(3);
    }

}