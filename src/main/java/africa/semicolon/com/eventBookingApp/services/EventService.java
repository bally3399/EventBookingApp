package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.*;
import africa.semicolon.com.eventBookingApp.dtos.response.*;
import africa.semicolon.com.eventBookingApp.model.Event;
import africa.semicolon.com.eventBookingApp.model.Ticket;

import java.util.List;

public interface EventService {
    CreateEventResponse createEvent(CreateEventRequest createEventRequest);
    AddTicketResponse addTicket(AddTicketRequest addTicketRequest);

    Event getEventWith(Long eventId);
    ViewAttendeeResponse attendeesView(ViewAttendeeRequest viewAttendeeRequest);

    ReserveTicketForEventResponse reserveTicket(ReserveTicketForEventRequest reserveTicket);

    PurchaseTicketForEventResponse purchaseTicket(PurchaseTicketForEventRequest purchaseTicket);

    List<Event> viewAllEvent(long organizerId);

}
