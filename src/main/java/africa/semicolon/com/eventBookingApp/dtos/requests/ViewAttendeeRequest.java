package africa.semicolon.com.eventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewAttendeeRequest {
    private Long id;
    private Long organizerId;
    private Long eventId;

}
