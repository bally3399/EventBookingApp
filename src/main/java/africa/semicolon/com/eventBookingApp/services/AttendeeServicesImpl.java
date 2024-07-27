package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.CreateAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ViewAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateAttendeeResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import africa.semicolon.com.eventBookingApp.exceptions.IdNotFoundException;
import africa.semicolon.com.eventBookingApp.model.Attendee;
import africa.semicolon.com.eventBookingApp.repository.AttendeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendeeServicesImpl implements AttendeeService {
    private final ModelMapper modelMapper;
    private final AttendeeRepository attendeeRepository;

    @Override
    public CreateAttendeeResponse createAttendee(CreateAttendeeRequest createAttendeeRequest) {
        Attendee attendee = modelMapper.map(createAttendeeRequest, Attendee.class);
        attendee = attendeeRepository.save(attendee);
        var response = modelMapper.map(attendee, CreateAttendeeResponse.class);
        response.setMessage("Successfully created attendee");
        return response;
    }

    @Override
    public ViewAttendeeResponse attendeesView(ViewAttendeeRequest viewAttendeeRequest) {
        ViewAttendeeResponse response = new ViewAttendeeResponse();
        for (Attendee attendee : attendeeRepository.findAll()) {
            if (attendee.getId().equals(viewAttendeeRequest.getId())) throw new IdNotFoundException("id not found");
        }
        response.setMessage("successful");
        return response;
    }

}

