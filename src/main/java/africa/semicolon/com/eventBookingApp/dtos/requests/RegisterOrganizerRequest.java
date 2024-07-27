package africa.semicolon.com.eventBookingApp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterOrganizerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
}
