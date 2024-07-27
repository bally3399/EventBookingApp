package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.CreateAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ViewAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateAttendeeResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class AttendeeServicesImplTest {
    @Autowired
    private AttendeeService attendeeService;
    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void createAttendeeTest() {
        CreateAttendeeRequest createAttendeeRequest = new CreateAttendeeRequest();
        createAttendeeRequest.setFirstName("john");
        createAttendeeRequest.setLastName("doe");
        createAttendeeRequest.setEmail("john@doe.com");
        createAttendeeRequest.setOrganizerId(200L);
        createAttendeeRequest.setEventId(100L);
        createAttendeeRequest.setId(1L);
        CreateAttendeeResponse response = attendeeService.createAttendee(createAttendeeRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Successfully created attendee");
    }

    @Test
    @Sql(scripts = {"/db/data.sql"})
    public void viewAttendeeTest() {
        CreateAttendeeRequest createAttendeeRequest = new CreateAttendeeRequest();
        createAttendeeRequest.setFirstName("jane");
        createAttendeeRequest.setLastName("doe");
        createAttendeeRequest.setEmail("jane@doe.com");
        createAttendeeRequest.setOrganizerId(201L);
        createAttendeeRequest.setEventId(100L);
        createAttendeeRequest.setId(2L);
        attendeeService.createAttendee(createAttendeeRequest);

        ViewAttendeeRequest viewAttendeeRequest = new ViewAttendeeRequest();
        viewAttendeeRequest.setId(2L);
        viewAttendeeRequest.setEventId(100L);
        viewAttendeeRequest.setOrganizerId(201L);
        ViewAttendeeResponse viewAttendeeResponse = attendeeService.attendeesView(viewAttendeeRequest);
        assertThat(viewAttendeeResponse).isNotNull();
        assertThat(viewAttendeeResponse.getMessage()).isEqualTo("successful");

    }

}