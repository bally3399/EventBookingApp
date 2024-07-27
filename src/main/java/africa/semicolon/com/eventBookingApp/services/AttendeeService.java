package africa.semicolon.com.eventBookingApp.services;

import africa.semicolon.com.eventBookingApp.dtos.requests.CreateAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.requests.ViewAttendeeRequest;
import africa.semicolon.com.eventBookingApp.dtos.response.CreateAttendeeResponse;
import africa.semicolon.com.eventBookingApp.dtos.response.ViewAttendeeResponse;
import africa.semicolon.com.eventBookingApp.model.Attendee;

import java.util.List;

public interface AttendeeService {

    CreateAttendeeResponse createAttendee(CreateAttendeeRequest createAttendeeRequest);


    ViewAttendeeResponse attendeesView(ViewAttendeeRequest viewAttendeeRequest);
}
