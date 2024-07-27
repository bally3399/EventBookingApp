package africa.semicolon.com.eventBookingApp.dtos.requests;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAttendeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long id;
    private Long organizerId;
    private Long eventId;
}
