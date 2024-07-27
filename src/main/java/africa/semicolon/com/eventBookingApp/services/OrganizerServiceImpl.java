package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.AddTicketRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.CreateEventRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.RegisterOrganizerRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ViewAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.AddTicketResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateEventResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.RegisterOrganizerResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import africa.semicolon.com.eventBookingApp.exceptions.IdNotFoundException;
import africa.semicolon.com.eventBookingApp.model.Attendee;
import africa.semicolon.com.eventBookingApp.model.Organizer;
import africa.semicolon.com.eventBookingApp.repository.OrganizerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    private ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;
    private final EventService eventService;
    private final AttendeeService attendeeService;
    @Override
    public RegisterOrganizerResponse registerOrganizer(RegisterOrganizerRequest registerOrganizerRequest) {
        Organizer organizer = modelMapper.map(registerOrganizerRequest, Organizer.class);
        organizer =organizerRepository.save(organizer);
        var response = modelMapper.map(organizer, RegisterOrganizerResponse.class);
        response.setMessage("Organizer registered successfully");
        return response;
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        getById(createEventRequest.getOrganizerId());
        return eventService.createEvent(createEventRequest);
    }

    @Override
    public Organizer getById(Long organizerId) {
        return organizerRepository.findById(organizerId)
                .orElseThrow(() ->
                        new IdNotFoundException("id not found"));
    }

    @Override
    public AddTicketResponse addTicket(AddTicketRequest addTicketRequest) {
        getById(addTicketRequest.getOrganizerId());
        return eventService.addTicket(addTicketRequest);
    }

    @Override
    public ViewAttendeeResponse viewAll(ViewAttendeeRequest viewAttendeeRequest) {
        getById(viewAttendeeRequest.getOrganizerId());
        return eventService.attendeesView(viewAttendeeRequest);
    }


}
