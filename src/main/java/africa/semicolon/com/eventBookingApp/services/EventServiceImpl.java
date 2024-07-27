package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.*;
import africa.semicolon.com.eventBookingApp.dtos.response.*;
import africa.semicolon.com.eventBookingApp.exceptions.EventIdIsInvalidException;
import africa.semicolon.com.eventBookingApp.exceptions.IdNotFoundException;
import africa.semicolon.com.eventBookingApp.exceptions.TicketNotAvailableException;
import africa.semicolon.com.eventBookingApp.model.Event;
import africa.semicolon.com.eventBookingApp.model.Ticket;
import africa.semicolon.com.eventBookingApp.repository.EventRepository;
import africa.semicolon.com.eventBookingApp.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static africa.semicolon.com.eventBookingApp.model.TicketStatus.PURCHASED;
import static africa.semicolon.com.eventBookingApp.model.TicketStatus.RESERVED;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final ModelMapper modelMapper;
    private final EventRepository eventRepository;
    private final TicketService ticketService;
    private final AttendeeService attendeeService;
    private final TicketRepository ticketRepository;

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        Event event = modelMapper.map(createEventRequest, Event.class);
        if (!event.getOrganizer().getId().equals(createEventRequest.getOrganizerId()))
            throw new EventIdIsInvalidException("Event id is invalid");
        event = eventRepository.save(event);
        var response = modelMapper.map(event, CreateEventResponse.class);
        response.setMessage("Event created successfully");
        return response;
    }

    @Override
    public AddTicketResponse addTicket(AddTicketRequest addTicketRequest) {
        getEventWith(addTicketRequest.getEventId());
        return ticketService.addTicket(addTicketRequest);
    }

    @Override
    public Event getEventWith(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventIdIsInvalidException("Event id is invalid"));
    }

    @Override
    public ViewAttendeeResponse attendeesView(ViewAttendeeRequest viewAttendeeRequest) {
        getEventWith(viewAttendeeRequest.getEventId());
        return attendeeService.attendeesView(viewAttendeeRequest);
    }

    private boolean isAvailable(Ticket ticket) {
        return ticket.getStatus() == PURCHASED || ticket.getStatus() == RESERVED;
    }

    @Override
    public ReserveTicketForEventResponse reserveTicket(ReserveTicketForEventRequest reserveTicket) {
        getEventWith(reserveTicket.getEventId());
        Event event = modelMapper.map(reserveTicket, Event.class);
        Ticket ticket = ticketRepository.findTicketById(reserveTicket.getTicketId());
        if (ticket == null) throw new IdNotFoundException("Ticket id not found");
        if (isAvailable(ticket)) throw new TicketNotAvailableException("Ticket is not available");
        ticket.setStatus(RESERVED);
        ticketRepository.save(ticket);
        event = eventRepository.save(event);
        var response = modelMapper.map(event, ReserveTicketForEventResponse.class);
        response.setMessage("Ticket reserved successfully");
        return response;
    }

    @Override
    public PurchaseTicketForEventResponse purchaseTicket(PurchaseTicketForEventRequest purchaseTicket) {
        getEventWith(purchaseTicket.getEventId());
        Event event = modelMapper.map(purchaseTicket, Event.class);
        Ticket ticket = ticketRepository.findTicketById(purchaseTicket.getTicketId());
        if (ticket == null) throw new IdNotFoundException("Ticket id not found");
        if (isAvailable(ticket)) throw new TicketNotAvailableException("Ticket is not available");
        ticket.setStatus(PURCHASED);
        ticketRepository.save(ticket);
        event = eventRepository.save(event);
        var response = modelMapper.map(event, PurchaseTicketForEventResponse.class);
        response.setMessage("Ticket purchased successfully");
        return response;
    }

    @Override
    public List<Event> viewAllEvent(long organizerId) {
        List<Event> eventList = eventRepository.findAll();
        List<Event> eventForOrganizer = new ArrayList<>();
        for (Event event : eventList){
            if (event.getOrganizer().getId().equals(organizerId)){
                eventForOrganizer.add(event);
            }
        }
        return eventForOrganizer;
    }
}