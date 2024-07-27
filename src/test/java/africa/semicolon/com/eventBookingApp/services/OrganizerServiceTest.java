package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.*;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateEventResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.RegisterOrganizerResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import africa.semicolon.com.eventBookingApp.model.Organizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static africa.semicolon.com.eventBookingApp.model.Type.VIP;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrganizerServiceTest {
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private EventService eventService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AttendeeService attendeeService;
    @Test
    public void registerOrganizerTest() {
        RegisterOrganizerRequest registerOrganizerRequest = new RegisterOrganizerRequest();
        registerOrganizerRequest.setFirstName("Baliqis");
        registerOrganizerRequest.setLastName("Bimbim");
        registerOrganizerRequest.setEmail("bimbim@gmail.com");
        registerOrganizerRequest.setPassword("1254");
        RegisterOrganizerResponse response = organizerService.registerOrganizer(registerOrganizerRequest);
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getMessage()).isEqualTo("Organizer registered successfully");
    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void organizerCanCreateEventTest(){
        Organizer organizer = organizerService.getById(200L);
        assertThat(organizer).isNotNull();
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
    public void organizerCanAddTicketTest(){
        Organizer organizer = organizerService.getById(201L);
        assertThat(organizer).isNotNull();

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
    public void viewAttendeeList(){
        Organizer organizer = organizerService.getById(202L);
        assertThat(organizer).isNotNull();

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
        viewAttendeeRequest.setOrganizerId(201L);
        viewAttendeeRequest.setEventId(101L);

        ViewAttendeeResponse response = attendeeService.attendeesView(viewAttendeeRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("successful");
    }
    @Test
    public void viewAllEventForOrganizerTest(){
        Organizer organizer = organizerService.getById(202L);
        assertThat(organizer).isNotNull();


    }
}