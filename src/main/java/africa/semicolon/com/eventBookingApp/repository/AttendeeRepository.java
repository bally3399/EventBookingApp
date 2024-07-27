package africa.semicolon.com.eventBookingApp.repository;

import africa.semicolon.com.eventBookingApp.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
