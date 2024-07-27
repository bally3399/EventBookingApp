package africa.semicolon.com.eventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateEventRequest {
    private String eventName;
    private String description;
    private String location;
    private LocalDateTime eventDate;
    private Long organizerId;

}
