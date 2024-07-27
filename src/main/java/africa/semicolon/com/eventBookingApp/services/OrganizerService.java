package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.AddTicketRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.CreateEventRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.RegisterOrganizerRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ViewAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateEventResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.RegisterOrganizerResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import africa.semicolon.com.eventBookingApp.model.Organizer;

public interface OrganizerService {
    RegisterOrganizerResponse registerOrganizer(RegisterOrganizerRequest registerOrganizerRequest);
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    Organizer getById(Long organizerId);
    AddTicketResponse addTicket(AddTicketRequest addTicketRequest);
    ViewAttendeeResponse viewAll(ViewAttendeeRequest viewAttendeeRequest);


}
