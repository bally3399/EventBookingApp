package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.AddTicketRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ReserveTicketForEventRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ReserveTicketForEventResponse;

public interface TicketService {
    AddTicketResponse addTicket(AddTicketRequest addTicketRequest);

}
