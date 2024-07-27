package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.AddTicketRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ReserveTicketForEventRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ReserveTicketForEventResponse;
import africa.semicolon.com.eventBookingApp.model.Ticket;
import africa.semicolon.com.eventBookingApp.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;

    @Override
    public AddTicketResponse addTicket(AddTicketRequest addTicketRequest) {
        Ticket ticket = modelMapper.map(addTicketRequest, Ticket.class);
        ticket = ticketRepository.save(ticket);
        var response = modelMapper.map(ticket, AddTicketResponse.class);
        response.setMessage("Ticket added successfully");
        return response;
    }

}
