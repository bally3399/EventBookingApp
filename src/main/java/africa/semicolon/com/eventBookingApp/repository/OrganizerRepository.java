package africa.semicolon.com.eventBookingApp.repository;

import africa.semicolon.com.eventBookingApp.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
