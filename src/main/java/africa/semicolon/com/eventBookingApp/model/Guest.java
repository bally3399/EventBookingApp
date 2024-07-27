package africa.semicolon.com.eventBookingApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Setter
@Getter
@Table(name = "guests")
public class Guest {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;
    @ManyToOne
    private Organizer organizer;
}
